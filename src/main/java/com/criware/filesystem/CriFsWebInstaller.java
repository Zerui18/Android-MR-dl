package com.criware.filesystem;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.criware.filesystem.CriFsWebInstallerManager.LooseTrustManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.util.Date;
import java.util.Locale;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.X509TrustManager;

public class CriFsWebInstaller {
    private static CriFsWebInstallerManager manager;
    private boolean can_access_asynctask;
    public boolean is_stop_required = false;
    private boolean is_timeouted;
    private boolean is_waiting_to_start;
    private long start_time;
    private StatusInfo synced_statusinfo = new StatusInfo();
    private WebInstallerTask task;
    private AsyncTaskParam task_params;
    private long timeout_start_time;

    public class AsyncTaskParam {
        long param_contents_size;
        String param_dst_path;
        long param_received_size;
        String param_src_path;

        AsyncTaskParam(String src_path, String dst_path, long contents_size, long received_size) {
            this.param_src_path = src_path;
            this.param_dst_path = dst_path;
            this.param_contents_size = contents_size;
            this.param_received_size = received_size;
        }
    }

    public static class Config {
        boolean allow_insecure_ssl;
        int inactive_timeout_sec;
        int num_installers;
        String proxy_host;
        short proxy_port;
        String user_agent;
    }

    public enum Error {
        CRIFSWEBINSTALLER_ERROR_NONE(0),
        CRIFSWEBINSTALLER_ERROR_TIMEOUT(1),
        CRIFSWEBINSTALLER_ERROR_MEMORY(2),
        CRIFSWEBINSTALLER_ERROR_LOCALFS(3),
        CRIFSWEBINSTALLER_ERROR_DNS(4),
        CRIFSWEBINSTALLER_ERROR_CONNECTION(5),
        CRIFSWEBINSTALLER_ERROR_SSL(6),
        CRIFSWEBINSTALLER_ERROR_HTTP(7),
        CRIFSWEBINSTALLER_ERROR_INTERNAL(8);
        
        private int value;

        private Error(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public enum Status {
        CRIFSWEBINSTALLER_STATUS_STOP(0),
        CRIFSWEBINSTALLER_STATUS_BUSY(1),
        CRIFSWEBINSTALLER_STATUS_COMPLETE(2),
        CRIFSWEBINSTALLER_STATUS_ERROR(3);
        
        private int value;

        private Status(int value) {
            this.value = value;
        }

        public int getValue() {
            return this.value;
        }
    }

    public class StatusInfo {
        long contents_size;
        Error error;
        int http_status_code;
        long received_size;
        Status status;
    }

    public enum TaskStatus {
        BUSY,
        STOP,
        STOPPING
    }

    public class TaskStatusInfo {
        long contents_size = -1;
        Error error = Error.CRIFSWEBINSTALLER_ERROR_NONE;
        int http_status_code = -1;
        long received_size = 0;
        TaskStatus status = TaskStatus.BUSY;

        TaskStatusInfo() {
        }
    }

    private class WebInstallerTask extends AsyncTask<AsyncTaskParam, Void, Boolean> {
        private HttpURLConnection http_connection = null;
        private boolean is_ssl;
        private String task_dst_path;
        private TaskStatusInfo task_internal_info;
        private String task_src_path;
        private File tmp_file;

        WebInstallerTask() {
            this.task_internal_info = new TaskStatusInfo();
        }

        protected Boolean doInBackground(AsyncTaskParam... params) {
            this.task_src_path = params[0].param_src_path;
            this.task_dst_path = params[0].param_dst_path;
            synchronized (this) {
                this.task_internal_info.contents_size = params[0].param_contents_size;
                this.task_internal_info.received_size = params[0].param_received_size;
            }
            if (!task_setup()) {
                if (this.http_connection != null) {
                    this.http_connection.disconnect();
                }
                return Boolean.valueOf(false);
            } else if (isCancelled()) {
                this.tmp_file.delete();
                this.http_connection.disconnect();
                return Boolean.valueOf(false);
            } else if (!task_connect()) {
                this.http_connection.disconnect();
                return Boolean.valueOf(false);
            } else if (!task_copyfile()) {
                return Boolean.valueOf(false);
            } else {
                synchronized (this) {
                    this.task_internal_info.status = TaskStatus.STOP;
                }
                return Boolean.valueOf(true);
            }
        }

        protected void onPostExecute(Boolean is_completed) {
            synchronized (this) {
                this.task_internal_info.status = TaskStatus.STOP;
            }
        }

        protected void onCancelled() {
            synchronized (this) {
                this.task_internal_info.status = TaskStatus.STOP;
            }
        }

        public void Cancel() {
            cancel(true);
            synchronized (this) {
                this.task_internal_info.status = TaskStatus.STOPPING;
            }
        }

        public synchronized TaskStatusInfo GetTaskStatusInfo() {
            return this.task_internal_info;
        }

        private synchronized void SetError(Error error, int http_status_code) {
            boolean is_error_retryable = error == Error.CRIFSWEBINSTALLER_ERROR_CONNECTION || error == Error.CRIFSWEBINSTALLER_ERROR_DNS;
            if (!is_error_retryable) {
                this.tmp_file.delete();
            }
            this.task_internal_info.status = TaskStatus.STOP;
            this.task_internal_info.error = error;
            this.task_internal_info.http_status_code = http_status_code;
        }

        private boolean task_setup() {
            try {
                if (this.task_src_path.toLowerCase(Locale.ENGLISH).startsWith("https://")) {
                    this.is_ssl = true;
                } else if (this.task_src_path.toLowerCase(Locale.ENGLISH).startsWith("http://")) {
                    this.is_ssl = false;
                } else {
                    SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                    CriFsWebInstaller.ErrorEntry(7);
                    return false;
                }
                URL url = new URL(this.task_src_path);
                this.tmp_file = new File(this.task_dst_path + ".tmp");
                if (CriFsWebInstaller.manager.proxy_host == null || CriFsWebInstaller.manager.proxy_port == (short) 0) {
                    CriFsWebInstallerManager access$000 = CriFsWebInstaller.manager;
                    String property = System.getProperty("http.proxyHost");
                    access$000.proxy_host = property;
                    if (property != null) {
                        String portStr = System.getProperty("http.proxyPort");
                        access$000 = CriFsWebInstaller.manager;
                        if (portStr == null) {
                            portStr = "-1";
                        }
                        access$000.proxy_port = Short.parseShort(portStr);
                        this.http_connection = (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(CriFsWebInstaller.manager.proxy_host, CriFsWebInstaller.manager.proxy_port)));
                    } else {
                        this.http_connection = (HttpURLConnection) url.openConnection();
                    }
                } else {
                    this.http_connection = (HttpURLConnection) url.openConnection(new Proxy(Type.HTTP, new InetSocketAddress(CriFsWebInstaller.manager.proxy_host, CriFsWebInstaller.manager.proxy_port)));
                }
                this.http_connection.setRequestMethod("GET");
                this.http_connection.setInstanceFollowRedirects(false);
                this.http_connection.setDoInput(true);
                this.http_connection.setConnectTimeout(5000);
                this.http_connection.setReadTimeout(5000);
                this.http_connection.setRequestProperty("User-Agent", CriFsWebInstaller.manager.user_agent);
                this.http_connection.setRequestProperty("Accept-Encoding", "identity");
                if (CriFsWebInstaller.manager.allow_insecure_ssl && this.is_ssl) {
                    SSLContext sslContext = SSLContext.getInstance("SSL");
                    sslContext.init(null, new X509TrustManager[]{new LooseTrustManager()}, new SecureRandom());
                    ((HttpsURLConnection) this.http_connection).setSSLSocketFactory(sslContext.getSocketFactory());
                }
                if (this.task_internal_info.contents_size != -1) {
                    if (!this.tmp_file.exists()) {
                        CriFsWebInstaller.ErrorEntry(8);
                        SetError(Error.CRIFSWEBINSTALLER_ERROR_LOCALFS, this.task_internal_info.http_status_code);
                        return false;
                    } else if (this.tmp_file.length() != this.task_internal_info.received_size) {
                        CriFsWebInstaller.ErrorEntry(9);
                        SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                        return false;
                    } else {
                        this.http_connection.setRequestProperty("Range", "Bytes=" + this.tmp_file.length() + "-");
                    }
                } else if (this.tmp_file.exists()) {
                    this.tmp_file.delete();
                }
                return true;
            } catch (NullPointerException e) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_MEMORY, this.task_internal_info.http_status_code);
                return false;
            } catch (MalformedURLException e2) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_DNS, this.task_internal_info.http_status_code);
                return false;
            } catch (ProtocolException e3) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, this.task_internal_info.http_status_code);
                return false;
            } catch (GeneralSecurityException e4) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_SSL, this.task_internal_info.http_status_code);
                return false;
            } catch (IOException e5) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_INTERNAL, this.task_internal_info.http_status_code);
                CriFsWebInstaller.ErrorEntry(4);
                e5.printStackTrace();
                return false;
            }
        }

        private boolean task_connect() {
            try {
                long contents_size;
                this.http_connection.connect();
                int status_code = this.http_connection.getResponseCode();
                if (status_code == 200) {
                    contents_size = (long) this.http_connection.getContentLength();
                } else if (status_code == 206) {
                    contents_size = ((long) this.http_connection.getContentLength()) + this.task_internal_info.received_size;
                } else if (status_code >= 0) {
                    SetError(Error.CRIFSWEBINSTALLER_ERROR_HTTP, status_code);
                    return false;
                } else {
                    SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                    return false;
                }
                synchronized (this) {
                    this.task_internal_info.http_status_code = status_code;
                    this.task_internal_info.contents_size = contents_size;
                }
                return true;
            } catch (UnknownHostException e) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                return false;
            } catch (SocketException e2) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                return false;
            } catch (SocketTimeoutException e3) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                return false;
            } catch (FileNotFoundException e4) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_HTTP, -1);
                return false;
            } catch (SSLException e5) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_SSL, -1);
                return false;
            } catch (IOException e6) {
                SetError(Error.CRIFSWEBINSTALLER_ERROR_CONNECTION, -1);
                CriFsWebInstaller.ErrorEntry(5);
                e6.printStackTrace();
                return false;
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private boolean task_copyfile() {
            /*
            r15 = this;
            r7 = 1;
            r6 = 0;
            r14 = -1;
            r8 = r15.http_connection;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r4 = r8.getInputStream();	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r5 = new java.io.FileOutputStream;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = r15.tmp_file;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r9 = 1;
            r5.<init>(r8, r9);	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r1 = -1;
            r8 = 65536; // 0x10000 float:9.18355E-41 double:3.2379E-319;
            r0 = new byte[r8];	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
        L_0x0016:
            r8 = r15.isCancelled();	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            if (r8 != 0) goto L_0x0022;
        L_0x001c:
            r1 = r4.read(r0);	 Catch:{ IOException -> 0x0048, NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e }
            if (r1 != r14) goto L_0x005d;
        L_0x0022:
            r4.close();	 Catch:{ IOException -> 0x0112, NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e }
        L_0x0025:
            r5.close();	 Catch:{ IOException -> 0x0115, NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e }
        L_0x0028:
            r8 = r15.http_connection;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8.disconnect();	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = r15.task_internal_info;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = r8.error;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r9 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_NONE;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            if (r8 == r9) goto L_0x009b;
        L_0x0035:
            r7 = r15.task_internal_info;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7 = r7.error;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_LOCALFS;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            if (r7 != r8) goto L_0x0042;
        L_0x003d:
            r7 = r15.tmp_file;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7.delete();	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
        L_0x0042:
            r7 = r15.http_connection;
            r7.disconnect();
        L_0x0047:
            return r6;
        L_0x0048:
            r3 = move-exception;
            r8 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_CONNECTION;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r9 = -1;
            r15.SetError(r8, r9);	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            goto L_0x0022;
        L_0x0050:
            r3 = move-exception;
            r7 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_MEMORY;	 Catch:{ all -> 0x010b }
            r8 = -1;
            r15.SetError(r7, r8);	 Catch:{ all -> 0x010b }
            r7 = r15.http_connection;
            r7.disconnect();
            goto L_0x0047;
        L_0x005d:
            if (r1 != 0) goto L_0x0067;
        L_0x005f:
            r8 = 10;
            java.lang.Thread.sleep(r8);	 Catch:{ InterruptedException -> 0x0065 }
            goto L_0x0016;
        L_0x0065:
            r8 = move-exception;
            goto L_0x0016;
        L_0x0067:
            r8 = 0;
            r5.write(r0, r8, r1);	 Catch:{ IOException -> 0x0086, NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e }
            monitor-enter(r15);	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = r15.task_internal_info;	 Catch:{ all -> 0x0076 }
            r10 = r8.received_size;	 Catch:{ all -> 0x0076 }
            r12 = (long) r1;	 Catch:{ all -> 0x0076 }
            r10 = r10 + r12;
            r8.received_size = r10;	 Catch:{ all -> 0x0076 }
            monitor-exit(r15);	 Catch:{ all -> 0x0076 }
            goto L_0x0016;
        L_0x0076:
            r7 = move-exception;
            monitor-exit(r15);	 Catch:{ all -> 0x0076 }
            throw r7;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
        L_0x0079:
            r3 = move-exception;
            r7 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_CONNECTION;	 Catch:{ all -> 0x010b }
            r8 = -1;
            r15.SetError(r7, r8);	 Catch:{ all -> 0x010b }
            r7 = r15.http_connection;
            r7.disconnect();
            goto L_0x0047;
        L_0x0086:
            r3 = move-exception;
            r8 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_LOCALFS;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r9 = -1;
            r15.SetError(r8, r9);	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            goto L_0x0022;
        L_0x008e:
            r3 = move-exception;
            r7 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_LOCALFS;	 Catch:{ all -> 0x010b }
            r8 = -1;
            r15.SetError(r7, r8);	 Catch:{ all -> 0x010b }
            r7 = r15.http_connection;
            r7.disconnect();
            goto L_0x0047;
        L_0x009b:
            r8 = r15.isCancelled();	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            if (r8 == 0) goto L_0x00ac;
        L_0x00a1:
            r7 = r15.tmp_file;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7.delete();	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7 = r15.http_connection;
            r7.disconnect();
            goto L_0x0047;
        L_0x00ac:
            r8 = r15.task_internal_info;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = r8.received_size;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r10 = r15.task_internal_info;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r10 = r10.contents_size;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1));
            if (r8 == 0) goto L_0x00ca;
        L_0x00b8:
            r7 = r15.tmp_file;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7.delete();	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_INTERNAL;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = -1;
            r15.SetError(r7, r8);	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7 = r15.http_connection;
            r7.disconnect();
            goto L_0x0047;
        L_0x00ca:
            r2 = new java.io.File;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = r15.task_dst_path;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r2.<init>(r8);	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = r2.exists();	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            if (r8 == 0) goto L_0x00e9;
        L_0x00d7:
            r7 = r15.tmp_file;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7.delete();	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_LOCALFS;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8 = -1;
            r15.SetError(r7, r8);	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r7 = r15.http_connection;
            r7.disconnect();
            goto L_0x0047;
        L_0x00e9:
            r8 = r15.tmp_file;	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r8.renameTo(r2);	 Catch:{ NullPointerException -> 0x0050, SocketTimeoutException -> 0x0079, FileNotFoundException -> 0x008e, IOException -> 0x00f6 }
            r6 = r15.http_connection;
            r6.disconnect();
            r6 = r7;
            goto L_0x0047;
        L_0x00f6:
            r3 = move-exception;
            r7 = com.criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_INTERNAL;	 Catch:{ all -> 0x010b }
            r8 = -1;
            r15.SetError(r7, r8);	 Catch:{ all -> 0x010b }
            r7 = 6;
            com.criware.filesystem.CriFsWebInstaller.ErrorEntry(r7);	 Catch:{ all -> 0x010b }
            r3.printStackTrace();	 Catch:{ all -> 0x010b }
            r7 = r15.http_connection;
            r7.disconnect();
            goto L_0x0047;
        L_0x010b:
            r6 = move-exception;
            r7 = r15.http_connection;
            r7.disconnect();
            throw r6;
        L_0x0112:
            r8 = move-exception;
            goto L_0x0025;
        L_0x0115:
            r8 = move-exception;
            goto L_0x0028;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.criware.filesystem.CriFsWebInstaller.WebInstallerTask.task_copyfile():boolean");
        }
    }

    private static native boolean ErrorCallback(int i);

    CriFsWebInstaller() {
        ClearMember();
    }

    public void Update() {
        boolean is_progressing = false;
        if (this.synced_statusinfo.status == Status.CRIFSWEBINSTALLER_STATUS_BUSY && this.can_access_asynctask) {
            TaskStatusInfo task_statusinfo = this.task.GetTaskStatusInfo();
            if (task_statusinfo != null) {
                switch (task_statusinfo.status) {
                    case BUSY:
                        if (this.is_stop_required) {
                            this.task.Cancel();
                            return;
                        }
                        this.synced_statusinfo.contents_size = task_statusinfo.contents_size;
                        if (task_statusinfo.received_size > this.synced_statusinfo.received_size) {
                            is_progressing = true;
                        }
                        if (is_progressing) {
                            this.synced_statusinfo.received_size = task_statusinfo.received_size;
                            this.timeout_start_time = GetNow() / 1000;
                            return;
                        }
                        if (this.timeout_start_time + ((long) manager.inactive_timeout_sec) < GetNow() / 1000) {
                            this.is_timeouted = true;
                            this.task.cancel(true);
                            return;
                        }
                        return;
                    case STOP:
                        if (this.is_stop_required) {
                            new File(this.task_params.param_dst_path + ".tmp").delete();
                            ClearMember();
                            return;
                        } else if (this.is_timeouted) {
                            this.synced_statusinfo.contents_size = task_statusinfo.contents_size;
                            this.synced_statusinfo.received_size = task_statusinfo.received_size;
                            this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
                            this.synced_statusinfo.error = Error.CRIFSWEBINSTALLER_ERROR_TIMEOUT;
                            return;
                        } else {
                            this.synced_statusinfo.contents_size = task_statusinfo.contents_size;
                            this.synced_statusinfo.received_size = task_statusinfo.received_size;
                            if (task_statusinfo.error == Error.CRIFSWEBINSTALLER_ERROR_NONE) {
                                this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_COMPLETE;
                                this.synced_statusinfo.http_status_code = task_statusinfo.http_status_code;
                                return;
                            } else if (!IsRetryable(task_statusinfo.error, this.synced_statusinfo.contents_size)) {
                                this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
                                this.synced_statusinfo.error = task_statusinfo.error;
                                this.synced_statusinfo.http_status_code = task_statusinfo.http_status_code;
                                return;
                            } else if (!this.is_waiting_to_start) {
                                this.is_waiting_to_start = true;
                                this.start_time = GetNow();
                                return;
                            } else if (GetNow() - this.start_time >= 5000) {
                                this.is_waiting_to_start = false;
                                this.task_params.param_contents_size = this.synced_statusinfo.contents_size;
                                this.task_params.param_received_size = this.synced_statusinfo.received_size;
                                this.can_access_asynctask = false;
                                StartTask(this.task_params);
                                return;
                            } else {
                                return;
                            }
                        }
                    case STOPPING:
                        this.synced_statusinfo.contents_size = task_statusinfo.contents_size;
                        this.synced_statusinfo.received_size = task_statusinfo.received_size;
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private long GetNow() {
        return new Date().getTime();
    }

    private static boolean IsRetryable(Error error, long contents_size) {
        boolean is_error_retryable;
        if (error == Error.CRIFSWEBINSTALLER_ERROR_CONNECTION || error == Error.CRIFSWEBINSTALLER_ERROR_DNS) {
            is_error_retryable = true;
        } else {
            is_error_retryable = false;
        }
        boolean is_contents_size_retryable;
        if (contents_size != -1) {
            is_contents_size_retryable = true;
        } else {
            is_contents_size_retryable = false;
        }
        if (is_error_retryable && is_contents_size_retryable) {
            return true;
        }
        return false;
    }

    private void ClearMember() {
        this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_STOP;
        this.synced_statusinfo.error = Error.CRIFSWEBINSTALLER_ERROR_NONE;
        this.synced_statusinfo.http_status_code = -1;
        this.synced_statusinfo.contents_size = -1;
        this.synced_statusinfo.received_size = 0;
        this.start_time = 0;
        this.timeout_start_time = 0;
        this.is_waiting_to_start = false;
        this.is_timeouted = false;
        this.can_access_asynctask = false;
    }

    private void StartTask(final AsyncTaskParam params) {
        try {
            if (VERSION.SDK_INT < 11) {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        CriFsWebInstaller.this.task = new WebInstallerTask();
                        CriFsWebInstaller.this.task.execute(new AsyncTaskParam[]{params});
                        CriFsWebInstaller.this.can_access_asynctask = true;
                    }
                });
            } else if (VERSION.SDK_INT < 11 || VERSION.SDK_INT >= 16) {
                this.task = new WebInstallerTask();
                this.task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new AsyncTaskParam[]{params});
                this.can_access_asynctask = true;
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    public void run() {
                        CriFsWebInstaller.this.task = new WebInstallerTask();
                        CriFsWebInstaller.this.task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new AsyncTaskParam[]{params});
                        CriFsWebInstaller.this.can_access_asynctask = true;
                    }
                });
            }
        } catch (NullPointerException e) {
            ErrorEntry(10);
            this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            this.synced_statusinfo.error = Error.CRIFSWEBINSTALLER_ERROR_MEMORY;
        }
    }

    public static void Initialize(Config wiconfig) {
        if (manager == null) {
            manager = new CriFsWebInstallerManager();
            manager.Manager_Initialize(wiconfig);
            return;
        }
        ErrorEntry(1);
    }

    public static void Finalize() {
        if (manager != null) {
            manager.Manager_Finalize();
            manager = null;
            return;
        }
        ErrorEntry(1);
    }

    public static void ExecuteMain() {
        if (manager != null) {
            manager.ExecuteMain();
        }
    }

    public static CriFsWebInstaller Create() {
        if (manager != null) {
            return manager.CreateInstaller();
        }
        ErrorEntry(1);
        return null;
    }

    public void Destroy() {
        if (this.synced_statusinfo.status != Status.CRIFSWEBINSTALLER_STATUS_STOP) {
            ErrorEntry(2);
        } else if (manager.installer_list.remove(this)) {
            CriFsWebInstallerManager criFsWebInstallerManager = manager;
            criFsWebInstallerManager.num_installers--;
        }
    }

    public void Copy(String src_path, String dst_path) {
        if (this.synced_statusinfo.status != Status.CRIFSWEBINSTALLER_STATUS_STOP) {
            ErrorEntry(2);
            return;
        }
        ClearMember();
        this.is_stop_required = false;
        this.synced_statusinfo.status = Status.CRIFSWEBINSTALLER_STATUS_BUSY;
        this.task_params = new AsyncTaskParam(src_path, dst_path, this.synced_statusinfo.contents_size, this.synced_statusinfo.received_size);
        this.timeout_start_time = GetNow() / 1000;
        StartTask(this.task_params);
    }

    public void Stop() {
        switch (this.synced_statusinfo.status) {
            case CRIFSWEBINSTALLER_STATUS_BUSY:
                this.is_stop_required = true;
                return;
            case CRIFSWEBINSTALLER_STATUS_COMPLETE:
            case CRIFSWEBINSTALLER_STATUS_ERROR:
                ClearMember();
                return;
            default:
                return;
        }
    }

    public int GetStatusInfo_status() {
        return this.synced_statusinfo.status.getValue();
    }

    public int GetStatusInfo_error() {
        return this.synced_statusinfo.error.getValue();
    }

    public int GetStatusInfo_http_status_code() {
        return this.synced_statusinfo.http_status_code;
    }

    public long GetStatusInfo_contents_size() {
        return this.synced_statusinfo.contents_size;
    }

    public long GetStatusInfo_received_size() {
        return this.synced_statusinfo.received_size;
    }

    public static boolean ErrorEntry(int entrynum) {
        return ErrorCallback(entrynum);
    }
}
