package co.cyberz.fox;

import android.content.Context;
import co.cyberz.fox.service.c;
import co.cyberz.fox.service.g;
import co.cyberz.util.string.StringUtil;
import co.cyberz.util.string.a;

public class FoxConfig {
    private String aServerUrl;
    private final int appId;
    private final String appKey;
    private final String appSalt;
    private final Context context;
    private boolean isDebug = false;
    private String serverUrl;

    public FoxConfig(Context context, int i, String str, String str2) {
        if (context == null) {
            throw new IllegalArgumentException("Activate Fox SDK | Context must be not null!");
        }
        this.context = context.getApplicationContext();
        this.appId = i;
        this.appKey = str;
        this.appSalt = str2;
    }

    public void activate() {
        if (this.context == null) {
            throw new IllegalArgumentException("Activate Fox SDK | Context must be not null!");
        } else if (this.appId <= 0) {
            throw new IllegalArgumentException("Activate Fox SDK | AppId must be larger than zero!");
        } else if (StringUtil.isEmpty(this.appKey) || !a.a(this.appKey)) {
            throw new IllegalArgumentException("Activate Fox SDK | AppKey must be not null!");
        } else if (StringUtil.isEmpty(this.appSalt) || !a.a(this.appSalt)) {
            throw new IllegalArgumentException("Activate Fox SDK | AppSalt must be not null!");
        } else {
            a a = a.a();
            a.c = this;
            a.d = getContext();
            try {
                co.cyberz.common.b.a.a();
            } catch (co.cyberz.util.b.a e) {
            }
            try {
                a.a = new c();
                new g().a((Object[]) new Void[0]);
            } catch (Exception e2) {
            }
            co.cyberz.util.f.a.a("APP_ID : " + getAppId());
            co.cyberz.util.f.a.a("APP_KEY : " + getAppKey());
            co.cyberz.util.f.a.a("APP_SALT : " + getAppSalt());
            if (!StringUtil.isEmpty(getServerUrl())) {
                co.cyberz.util.f.a.a("APP_SERVER_URL : " + getServerUrl());
            }
        }
    }

    public FoxConfig addAnalyticsServerUrlOption(String str) {
        this.aServerUrl = str;
        return this;
    }

    public FoxConfig addDebugOption(boolean z) {
        this.isDebug = z;
        return this;
    }

    public FoxConfig addFoxServerUrlOption(String str) {
        this.serverUrl = str;
        return this;
    }

    public String getAServerUrl() {
        return this.aServerUrl;
    }

    public int getAppId() {
        return this.appId;
    }

    public String getAppKey() {
        return this.appKey;
    }

    public String getAppSalt() {
        return this.appSalt;
    }

    public Context getContext() {
        return this.context;
    }

    public String getServerUrl() {
        return this.serverUrl;
    }

    public boolean isDebug() {
        return this.isDebug;
    }
}
