package criware.filesystem;

import criware.filesystem.CriFsWebInstaller.Config;
import criware.filesystem.CriFsWebInstaller.Error;
import criware.filesystem.CriFsWebInstaller.Status;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import javax.net.ssl.X509TrustManager;

public class CriFsWebInstallerManager {
    public boolean allow_insecure_ssl;
    public int inactive_timeout_sec;
    public ConcurrentLinkedQueue<CriFsWebInstaller> installer_list;
    public boolean is_initialized;
    public int num_installers;
    private int num_installers_max;
    public String proxy_host = "";
    public short proxy_port = (short) -1;
    public String user_agent;

    public static class LooseTrustManager implements X509TrustManager {
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public void Manager_Initialize(Config wiconfig) {
        if (!this.is_initialized) {
            this.num_installers = wiconfig.num_installers;
            this.allow_insecure_ssl = wiconfig.allow_insecure_ssl;
            this.inactive_timeout_sec = wiconfig.inactive_timeout_sec;
            this.proxy_host = wiconfig.proxy_host;
            this.proxy_port = wiconfig.proxy_port;
            this.user_agent = wiconfig.user_agent;
            this.num_installers_max = this.num_installers;
            this.num_installers = 0;
            this.installer_list = new ConcurrentLinkedQueue();
            this.is_initialized = true;
        }
    }

    public void Manager_Finalize() {
        if (this.is_initialized) {
            Iterator i = this.installer_list.iterator();
            while (i.hasNext()) {
                CriFsWebInstaller hnd = (CriFsWebInstaller) i.next();
                if (hnd.info.status == Status.CRIFSWEBINSTALLER_STATUS_BUSY) {
                    hnd.StopTask();
                }
                this.installer_list.remove(hnd);
            }
            this.is_initialized = false;
        }
    }

    public CriFsWebInstaller CreateInstaller() {
        if (this.num_installers >= this.num_installers_max) {
            CriFsWebInstaller.ErrorEntry(3);
            return null;
        }
        CriFsWebInstaller hnd = new CriFsWebInstaller();
        hnd.ClearMember(true);
        if (!this.installer_list.add(hnd)) {
            return hnd;
        }
        this.num_installers++;
        return hnd;
    }

    public void ExecuteMain() {
        Iterator i = this.installer_list.iterator();
        while (i.hasNext()) {
            CriFsWebInstaller hnd = (CriFsWebInstaller) i.next();
            if (hnd.is_retrying) {
                if (hnd.timeout_start_time + ((long) this.inactive_timeout_sec) < new Date().getTime() / 1000) {
                    hnd.is_retrying = false;
                    hnd.info.status = Status.CRIFSWEBINSTALLER_STATUS_ERROR;
                    hnd.info.error = Error.CRIFSWEBINSTALLER_ERROR_TIMEOUT;
                }
            }
            hnd.info_out.status = hnd.info.status;
            hnd.info_out.error = hnd.info.error;
            hnd.info_out.http_status_code = hnd.info.http_status_code;
            hnd.info_out.contents_size = hnd.info.contents_size;
            hnd.info_out.received_size = hnd.info.received_size;
        }
    }
}
