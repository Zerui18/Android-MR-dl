package co.cyberz.common.b;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import co.cyberz.fox.FoxConfig;
import co.cyberz.util.a.b;
import co.cyberz.util.string.StringUtil;
import java.io.File;
import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.UUID;

public final class a {
    private static a t;
    public final Context a = this.b.getContext();
    public final FoxConfig b = co.cyberz.fox.a.a().c;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final String h;
    public final boolean i;
    public final String j;
    public final String k;
    public final boolean l;
    public final int m;
    public final String n;
    public final String o;
    public final String p;
    public final String q;
    public String r;
    public co.cyberz.common.ids.FingerPrint.a s;

    private a() {
        String str = null;
        int i = 0;
        co.cyberz.fox.a.a();
        try {
            this.c = c();
            new StringBuilder("[Env] deliverServerUrl : ").append(this.c);
            String a = co.cyberz.util.h.a.a(this.b.getAServerUrl());
            if (!StringUtil.isEmpty(a)) {
                co.cyberz.util.f.a.a("access AnalyticsServer URL : " + a);
            }
            if (StringUtil.isEmpty(a)) {
                a = co.cyberz.util.h.a.a("01c5b701dfab1a1a5ec97707ed60f1aa33ea851b8a4fa3beac54434fc7d4c325bc3c9fdcfd5a652cdf5a36dbde769fd978");
            }
            this.d = a;
            new StringBuilder("[Env] analyticsServerUrl : ").append(this.d);
            Context context = this.a;
            if (context != null) {
                str = context.getSharedPreferences("co.cyberz.fox", 0).getString("fox_install_id", null);
                if (StringUtil.isEmpty(str)) {
                    str = UUID.randomUUID().toString();
                    if (!(context == null || StringUtil.isEmpty(str))) {
                        context.getSharedPreferences("co.cyberz.fox", 0).edit().putString("fox_install_id", str).commit();
                    }
                }
            }
            this.k = str;
            this.f = VERSION.RELEASE;
            this.g = this.a.getPackageName();
            this.e = co.cyberz.util.a.a.a();
            co.cyberz.util.e.a.a(this.a);
            this.i = new File("/system/bin/su").exists();
            Object obj = new String[]{VERSION.RELEASE, Build.MODEL, Build.DEVICE};
            MessageFormat messageFormat = new MessageFormat("ADMAGESMPHSDK/Android/4.2.1/CZ/{0}/{1}/{2}");
            boolean z = (this.a.getPackageManager().hasSystemFeature("android.hardware.touchscreen") || (VERSION.SDK_INT >= 21 ? 1 : 0) == 0) ? false : true;
            this.l = z;
            this.j = messageFormat.format(obj);
            this.o = b.b();
            this.p = b.a();
            this.q = co.cyberz.util.a.a.b();
            String str2 = "";
            try {
                Class cls = Class.forName(new StringBuilder(this.a.getPackageName()).append(".BuildConfig").toString());
                Field declaredField = cls.getDeclaredField("VERSION_NAME");
                Field declaredField2 = cls.getDeclaredField("VERSION_CODE");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                i = ((Integer) declaredField2.get(null)).intValue();
                str = (String) declaredField.get(null);
                try {
                    if (StringUtil.isEmpty(str) || i == 0) {
                        PackageInfo d = d();
                        i = d.versionCode;
                        str = d.versionName;
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                PackageInfo d2 = d();
                if (d2 != null) {
                    i = d2.versionCode;
                    str = d2.versionName;
                } else {
                    str = str2;
                }
            }
            this.m = i;
            this.h = str;
            this.n = this.h;
        } catch (Exception e3) {
            throw new co.cyberz.util.b.a();
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (t == null) {
                t = new a();
            }
            aVar = t;
        }
        return aVar;
    }

    private PackageInfo d() {
        try {
            return this.a.getPackageManager().getPackageInfo(this.a.getPackageName(), 0);
        } catch (NameNotFoundException e) {
            return null;
        }
    }

    public final String b() {
        String a = co.cyberz.util.h.a.a(this.b.getServerUrl());
        if (!StringUtil.isEmpty(a)) {
            co.cyberz.util.f.a.a("access Server URL : " + a);
        }
        return a;
    }

    public final String c() {
        String b = b();
        return StringUtil.isEmpty(b) ? co.cyberz.util.h.a.a("011a1b1ae48258bf64d51406997c78670af1f11837b0abd5ab0855cdb9a532de63") : b;
    }
}
