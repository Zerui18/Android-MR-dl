package criware.filesystem;

import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.net.HttpURLConnection;
import java.util.Date;

public class CriFsWebInstaller {
    private static CriFsWebInstallerManager manager = null;
    private HttpURLConnection con = null;
    public StatusInfo info = new StatusInfo();
    public StatusInfo info_out = new StatusInfo();
    public boolean is_retrying;
    private String savePath = "";
    public WebInstallerTask task;
    public long timeout_start_time;
    private String urlString = "";

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

    public enum TaskResult {
        COMPLETE,
        STOP,
        ERROR,
        RETRY
    }

    private class WebInstallerTask extends AsyncTask<Void, Void, TaskResult> {
        private WebInstallerTask() {
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        protected criware.filesystem.CriFsWebInstaller.TaskResult doInBackground(java.lang.Void... r21) {
            /*
            r20 = this;
            r14 = r20.isCancelled();
            if (r14 == 0) goto L_0x0011;
        L_0x0006:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r15 = 1;
            r14.ClearMember(r15);
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.STOP;
        L_0x0010:
            return r14;
        L_0x0011:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.is_retrying;
            if (r14 == 0) goto L_0x002a;
        L_0x0019:
            r14 = 5000; // 0x1388 float:7.006E-42 double:2.4703E-320;
            java.lang.Thread.sleep(r14);	 Catch:{ InterruptedException -> 0x0029 }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ InterruptedException -> 0x0029 }
            r14 = r14.is_retrying;	 Catch:{ InterruptedException -> 0x0029 }
            if (r14 != 0) goto L_0x002a;
        L_0x0026:
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.ERROR;	 Catch:{ InterruptedException -> 0x0029 }
            goto L_0x0010;
        L_0x0029:
            r14 = move-exception;
        L_0x002a:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.urlString;
            r14 = r14.toLowerCase();
            r15 = "https://";
            r14 = r14.startsWith(r15);
            if (r14 == 0) goto L_0x01e1;
        L_0x003e:
            r12 = 0;
            r13 = new java.net.URL;	 Catch:{ FileNotFoundException -> 0x041e, MalformedURLException -> 0x041b, SSLException -> 0x0418, SocketTimeoutException -> 0x03c3, InterruptedIOException -> 0x03da, IOException -> 0x03f1 }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x041e, MalformedURLException -> 0x041b, SSLException -> 0x0418, SocketTimeoutException -> 0x03c3, InterruptedIOException -> 0x03da, IOException -> 0x03f1 }
            r14 = r14.urlString;	 Catch:{ FileNotFoundException -> 0x041e, MalformedURLException -> 0x041b, SSLException -> 0x0418, SocketTimeoutException -> 0x03c3, InterruptedIOException -> 0x03da, IOException -> 0x03f1 }
            r13.<init>(r14);	 Catch:{ FileNotFoundException -> 0x041e, MalformedURLException -> 0x041b, SSLException -> 0x0418, SocketTimeoutException -> 0x03c3, InterruptedIOException -> 0x03da, IOException -> 0x03f1 }
            r14 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.proxy_host;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            if (r14 == 0) goto L_0x020d;
        L_0x0054:
            r14 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.proxy_port;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            if (r14 == 0) goto L_0x020d;
        L_0x005c:
            r10 = new java.net.Proxy;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = java.net.Proxy.Type.HTTP;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = new java.net.InetSocketAddress;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r16 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r16;
            r0 = r0.proxy_host;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r16 = r0;
            r17 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r17;
            r0 = r0.proxy_port;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r17 = r0;
            r15.<init>(r16, r17);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r10.<init>(r14, r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r15 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r13.openConnection(r10);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = (java.net.HttpURLConnection) r14;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15.con = r14;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
        L_0x0089:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = "GET";
            r14.setRequestMethod(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = 0;
            r14.setInstanceFollowRedirects(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = 1;
            r14.setDoInput(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = 300000; // 0x493e0 float:4.2039E-40 double:1.482197E-318;
            r14.setConnectTimeout(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = "User-Agent";
            r16 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r16;
            r0 = r0.user_agent;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r16 = r0;
            r14.setRequestProperty(r15, r16);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = r15.inactive_timeout_sec;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = r15 * 1000;
            r14.setReadTimeout(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.allow_insecure_ssl;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            if (r14 == 0) goto L_0x011c;
        L_0x00ee:
            r14 = "SSL";
            r11 = javax.net.ssl.SSLContext.getInstance(r14);	 Catch:{ Exception -> 0x029f }
            r14 = 0;
            r15 = 1;
            r15 = new javax.net.ssl.X509TrustManager[r15];	 Catch:{ Exception -> 0x029f }
            r16 = 0;
            r17 = new criware.filesystem.CriFsWebInstallerManager$LooseTrustManager;	 Catch:{ Exception -> 0x029f }
            r17.<init>();	 Catch:{ Exception -> 0x029f }
            r15[r16] = r17;	 Catch:{ Exception -> 0x029f }
            r16 = new java.security.SecureRandom;	 Catch:{ Exception -> 0x029f }
            r16.<init>();	 Catch:{ Exception -> 0x029f }
            r0 = r16;
            r11.init(r14, r15, r0);	 Catch:{ Exception -> 0x029f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ Exception -> 0x029f }
            r14 = r14.con;	 Catch:{ Exception -> 0x029f }
            r14 = (javax.net.ssl.HttpsURLConnection) r14;	 Catch:{ Exception -> 0x029f }
            r15 = r11.getSocketFactory();	 Catch:{ Exception -> 0x029f }
            r14.setSSLSocketFactory(r15);	 Catch:{ Exception -> 0x029f }
        L_0x011c:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ SocketException -> 0x02b8, FileNotFoundException -> 0x02d1, IOException -> 0x02ea, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r14 = r14.con;	 Catch:{ SocketException -> 0x02b8, FileNotFoundException -> 0x02d1, IOException -> 0x02ea, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r14.connect();	 Catch:{ SocketException -> 0x02b8, FileNotFoundException -> 0x02d1, IOException -> 0x02ea, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r15 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = r15.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = r15.getResponseCode();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.http_status_code = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.http_status_code;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
            if (r14 != r15) goto L_0x02f2;
        L_0x0147:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r15 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = r15.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = r15.getContentLength();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = (long) r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r16 = r0;
            r0 = r16;
            r14.contents_size = r0;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r6 = r14.getInputStream();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r8 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = new java.lang.StringBuilder;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.<init>();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r15 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = r15.savePath;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.append(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = ".tmp";
            r14 = r14.append(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.toString();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r8.<init>(r14);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r8.deleteOnExit();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r7 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r7.<init>(r8);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r3 = -1;
            r14 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
            r2 = new byte[r14];	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
        L_0x0199:
            r14 = r20.isCancelled();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            if (r14 == 0) goto L_0x0315;
        L_0x019f:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = 1;
            r14.ClearMember(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
        L_0x01a7:
            r7.close();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r6.close();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r20.isCancelled();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            if (r14 != 0) goto L_0x03bc;
        L_0x01b3:
            r5 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.savePath;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r5.<init>(r14);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r5.exists();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            if (r14 == 0) goto L_0x0381;
        L_0x01c6:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.status = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_LOCALFS;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.error = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r8.delete();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0010;
        L_0x01e1:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.urlString;
            r14 = r14.toLowerCase();
            r15 = "http://";
            r14 = r14.startsWith(r15);
            if (r14 != 0) goto L_0x003e;
        L_0x01f5:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_HTTP;
            r14.error = r15;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            r14.status = r15;
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.ERROR;
            goto L_0x0010;
        L_0x020d:
            r14 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = "http.proxyHost";
            r15 = java.lang.System.getProperty(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.proxy_host = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            if (r15 == 0) goto L_0x0279;
        L_0x021b:
            r14 = "http.proxyPort";
            r9 = java.lang.System.getProperty(r14);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            if (r9 == 0) goto L_0x0276;
        L_0x0227:
            r15 = java.lang.Short.parseShort(r9);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.proxy_port = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r10 = new java.net.Proxy;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = java.net.Proxy.Type.HTTP;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = new java.net.InetSocketAddress;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r16 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r16;
            r0 = r0.proxy_host;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r16 = r0;
            r17 = criware.filesystem.CriFsWebInstaller.manager;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r17;
            r0 = r0.proxy_port;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r17 = r0;
            r15.<init>(r16, r17);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r10.<init>(r14, r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r15 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r13.openConnection(r10);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = (java.net.HttpURLConnection) r14;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15.con = r14;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0089;
        L_0x025c:
            r4 = move-exception;
            r12 = r13;
        L_0x025e:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            r14.status = r15;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_LOCALFS;
            r14.error = r15;
        L_0x0272:
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.COMPLETE;
            goto L_0x0010;
        L_0x0276:
            r9 = "-1";
            goto L_0x0227;
        L_0x0279:
            r0 = r20;
            r15 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r13.openConnection();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = (java.net.HttpURLConnection) r14;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15.con = r14;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0089;
        L_0x0288:
            r4 = move-exception;
            r12 = r13;
        L_0x028a:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            r14.status = r15;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_DNS;
            r14.error = r15;
            goto L_0x0272;
        L_0x029f:
            r4 = move-exception;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_SSL;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.error = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.status = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0010;
        L_0x02b8:
            r4 = move-exception;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.status = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_CONNECTION;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.error = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0010;
        L_0x02d1:
            r4 = move-exception;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_HTTP;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.error = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.status = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0010;
        L_0x02ea:
            r4 = move-exception;
            r4.printStackTrace();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.RETRY;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0010;
        L_0x02f2:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_HTTP;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.error = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.status = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.con;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.disconnect();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.ERROR;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0010;
        L_0x0315:
            r3 = r6.read(r2);	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r14 = -1;
            if (r3 == r14) goto L_0x01a7;
        L_0x031c:
            if (r3 != 0) goto L_0x0345;
        L_0x031e:
            r14 = 0;
            r7.write(r2, r14, r3);	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r14 = r14.info;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r0 = r14.received_size;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r16 = r0;
            r0 = (long) r3;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r18 = r0;
            r16 = r16 + r18;
            r0 = r16;
            r14.received_size = r0;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            goto L_0x0199;
        L_0x0337:
            r4 = move-exception;
            r14 = r20.isCancelled();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            if (r14 != 0) goto L_0x0199;
        L_0x033e:
            r4.printStackTrace();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.RETRY;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0010;
        L_0x0345:
            r14 = r2.length;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r14 = r14 - r3;
            r14 = r6.read(r2, r3, r14);	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r3 = r3 + r14;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r15 = new java.util.Date;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r15.<init>();	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r16 = r15.getTime();	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r18 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
            r16 = r16 / r18;
            r0 = r16;
            r14.timeout_start_time = r0;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            r15 = 0;
            r14.is_retrying = r15;	 Catch:{ IOException -> 0x0337, FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412 }
            goto L_0x031e;
        L_0x0369:
            r4 = move-exception;
            r12 = r13;
        L_0x036b:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            r14.status = r15;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_SSL;
            r14.error = r15;
            goto L_0x0272;
        L_0x0381:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r15 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = r15.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r15.contents_size;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r16 = r0;
            r0 = r16;
            r14.received_size = r0;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_COMPLETE;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.status = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = r14.info;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_NONE;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.error = r15;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = new java.io.File;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r0 = r20;
            r15 = criware.filesystem.CriFsWebInstaller.this;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r15 = r15.savePath;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14.<init>(r15);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r8.renameTo(r14);	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r12 = r13;
            goto L_0x0272;
        L_0x03bc:
            r8.delete();	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            r14 = criware.filesystem.CriFsWebInstaller.TaskResult.STOP;	 Catch:{ FileNotFoundException -> 0x025c, MalformedURLException -> 0x0288, SSLException -> 0x0369, SocketTimeoutException -> 0x0415, InterruptedIOException -> 0x0412, IOException -> 0x040f }
            goto L_0x0010;
        L_0x03c3:
            r4 = move-exception;
        L_0x03c4:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            r14.status = r15;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_TIMEOUT;
            r14.error = r15;
            goto L_0x0272;
        L_0x03da:
            r4 = move-exception;
        L_0x03db:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            r14.status = r15;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_TIMEOUT;
            r14.error = r15;
            goto L_0x0272;
        L_0x03f1:
            r4 = move-exception;
        L_0x03f2:
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Status.CRIFSWEBINSTALLER_STATUS_ERROR;
            r14.status = r15;
            r0 = r20;
            r14 = criware.filesystem.CriFsWebInstaller.this;
            r14 = r14.info;
            r15 = criware.filesystem.CriFsWebInstaller.Error.CRIFSWEBINSTALLER_ERROR_INTERNAL;
            r14.error = r15;
            r14 = 0;
            criware.filesystem.CriFsWebInstaller.ErrorEntry(r14);
            r4.printStackTrace();
            goto L_0x0272;
        L_0x040f:
            r4 = move-exception;
            r12 = r13;
            goto L_0x03f2;
        L_0x0412:
            r4 = move-exception;
            r12 = r13;
            goto L_0x03db;
        L_0x0415:
            r4 = move-exception;
            r12 = r13;
            goto L_0x03c4;
        L_0x0418:
            r4 = move-exception;
            goto L_0x036b;
        L_0x041b:
            r4 = move-exception;
            goto L_0x028a;
        L_0x041e:
            r4 = move-exception;
            goto L_0x025e;
            */
            throw new UnsupportedOperationException("Method not decompiled: criware.filesystem.CriFsWebInstaller.WebInstallerTask.doInBackground(java.lang.Void[]):criware.filesystem.CriFsWebInstaller$TaskResult");
        }

        protected void onPreExecute() {
            if (!CriFsWebInstaller.this.is_retrying) {
                CriFsWebInstaller.this.timeout_start_time = new Date().getTime() / 1000;
            }
            CriFsWebInstaller.this.con = null;
            CriFsWebInstaller.this.ClearMember(false);
        }

        protected void onPostExecute(TaskResult result) {
            switch (result) {
                case RETRY:
                    CriFsWebInstaller.this.is_retrying = true;
                    CriFsWebInstaller.this.StartTask();
                    return;
                default:
                    return;
            }
        }

        protected void onCancelled() {
            super.onCancelled();
        }
    }

    private static native boolean ErrorCallback(int i);

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
        } else {
            ErrorEntry(1);
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
        if (this.info.status != Status.CRIFSWEBINSTALLER_STATUS_STOP) {
            ErrorEntry(2);
        } else if (manager.installer_list.remove(this)) {
            CriFsWebInstallerManager criFsWebInstallerManager = manager;
            criFsWebInstallerManager.num_installers--;
        }
    }

    public void Copy(String src_path, String dst_path) {
        if (this.info.status != Status.CRIFSWEBINSTALLER_STATUS_STOP) {
            ErrorEntry(2);
            return;
        }
        this.info.status = Status.CRIFSWEBINSTALLER_STATUS_BUSY;
        this.urlString = src_path;
        this.savePath = dst_path;
        StartTask();
    }

    public void Stop() {
        switch (this.info.status) {
            case CRIFSWEBINSTALLER_STATUS_BUSY:
                if (!this.is_retrying) {
                    StopTask();
                    break;
                }
                ClearMember(true);
                StopTask();
                break;
            case CRIFSWEBINSTALLER_STATUS_COMPLETE:
            case CRIFSWEBINSTALLER_STATUS_ERROR:
                break;
            default:
                return;
        }
        ClearMember(true);
    }

    public int GetStatusInfo_status() {
        return this.info_out.status.getValue();
    }

    public int GetStatusInfo_error() {
        return this.info_out.error.getValue();
    }

    public int GetStatusInfo_http_status_code() {
        return this.info_out.http_status_code;
    }

    public long GetStatusInfo_contents_size() {
        return this.info_out.contents_size;
    }

    public long GetStatusInfo_received_size() {
        return this.info_out.received_size;
    }

    public void ClearMember(boolean to_stop) {
        if (to_stop) {
            this.info.status = Status.CRIFSWEBINSTALLER_STATUS_STOP;
            this.info.error = Error.CRIFSWEBINSTALLER_ERROR_NONE;
            this.info_out.status = Status.CRIFSWEBINSTALLER_STATUS_STOP;
            this.info_out.error = Error.CRIFSWEBINSTALLER_ERROR_NONE;
            this.timeout_start_time = 0;
            this.is_retrying = false;
        }
        this.info.http_status_code = -1;
        this.info.contents_size = -1;
        this.info.received_size = 0;
        this.info_out.http_status_code = -1;
        this.info_out.contents_size = -1;
        this.info_out.received_size = 0;
    }

    public void StopTask() {
        this.task.cancel(true);
    }

    public void StartTask() {
        if (VERSION.SDK_INT < 11) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    CriFsWebInstaller.this.task = new WebInstallerTask();
                    CriFsWebInstaller.this.task.execute(new Void[0]);
                }
            });
        } else if (VERSION.SDK_INT < 11 || VERSION.SDK_INT >= 16) {
            this.task = new WebInstallerTask();
            this.task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        } else {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    CriFsWebInstaller.this.task = new WebInstallerTask();
                    CriFsWebInstaller.this.task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }
            });
        }
    }

    public static boolean ErrorEntry(int entrynum) {
        return ErrorCallback(entrynum);
    }
}
