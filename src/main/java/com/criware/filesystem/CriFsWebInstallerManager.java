package com.criware.filesystem;

import com.criware.filesystem.CriFsWebInstaller.Config;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
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
                hnd.is_stop_required = true;
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
        if (!this.installer_list.add(hnd)) {
            return hnd;
        }
        this.num_installers++;
        return hnd;
    }

    public void ExecuteMain() {
        Iterator i = this.installer_list.iterator();
        while (i.hasNext()) {
            ((CriFsWebInstaller) i.next()).Update();
        }
    }
}
