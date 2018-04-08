package com.tapjoy.internal;

import android.content.Context;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.gl.c;
import com.tapjoy.internal.gl.i;
import com.tapjoy.internal.gl.n;
import com.tapjoy.internal.gl.p;
import com.tapjoy.internal.gl.x;
import com.tapjoy.internal.gl.x.a;
import java.io.File;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executors;

public final class fu {
    private static final fu q;
    private static fu r;
    private static Handler w;
    private static File x;
    public final gc a = new gc(this);
    public gd b;
    public boolean c = false;
    public String d = null;
    public Context e;
    public fx f;
    public ft g;
    public gh h;
    public fs i;
    public String j;
    public boolean k;
    public String l;
    public String m;
    public boolean n = false;
    public String o;
    public fv p = fv.a(null);
    private boolean s = false;
    private boolean t = false;
    private String u;
    private String v;

    static {
        fu fuVar = new fu();
        q = fuVar;
        r = fuVar;
    }

    public static fu a() {
        return r;
    }

    private fu() {
    }

    final synchronized void b(Context context) {
        if (this.e == null) {
            Context applicationContext = context.getApplicationContext();
            this.e = applicationContext;
            eu.a().a(applicationContext);
            this.f = fx.a(applicationContext);
            File file = new File(c(applicationContext), "events2");
            if (this.i == null) {
                this.i = new fs(file);
            }
            this.g = new ft(this.f, this.i);
            this.h = new gh(this.g);
            this.b = new gd(applicationContext);
            fa.a(new fc(new File(c(applicationContext), "usages"), this.g));
            gp gpVar = gp.a;
            gpVar.b = applicationContext.getApplicationContext();
            gpVar.c = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2E", 0);
            gpVar.d = applicationContext.getSharedPreferences("tapjoyCacheDataMMF2U", 0);
            gpVar.a();
        }
    }

    public final n a(boolean z) {
        if (z) {
            this.f.a();
        }
        return this.f.b();
    }

    public final synchronized void b() {
        if (this.k) {
            fw.b(this.e).e(this.d);
            a(null);
        }
    }

    public final synchronized void a(String str) {
        if (this.k) {
            if (str == null && this.o != null) {
                str = this.o;
            }
            this.o = null;
            if (str != null) {
                fr.a("GCM registration id of device {} updated for sender {}: {}", this.f.b().c.h(), this.d, str);
                new hb(r0, str).a(new cj(this) {
                    final /* synthetic */ fu b;

                    public final /* synthetic */ void a(ce ceVar, Object obj) {
                        r b = fw.b(this.b.e);
                        String str = str;
                        long currentTimeMillis = 0 != 0 ? System.currentTimeMillis() + 0 : 0;
                        if (str.equals(b.b.b(b.a))) {
                            b.b.b(b.a, true);
                            if (currentTimeMillis != 0) {
                                new Object[1][0] = new Timestamp(currentTimeMillis);
                            }
                            b.b.a(b.a, currentTimeMillis);
                            return;
                        }
                        new Object[1][0] = str;
                    }

                    public final void a(ce ceVar) {
                    }
                }, ce.a);
            }
        } else if (str != null) {
            this.o = str;
        }
    }

    public static void a(GLSurfaceView gLSurfaceView) {
        if (fr.a((Object) gLSurfaceView, "setGLSurfaceView: The given GLSurfaceView was null")) {
            fm.a(gLSurfaceView);
        }
    }

    public final Set c() {
        if (c("getUserTags")) {
            return this.f.e();
        }
        return new HashSet();
    }

    public final void a(Set set) {
        if (c("setUserTags")) {
            Iterable iterable;
            if (!(set == null || set.isEmpty())) {
                Set hashSet = new HashSet();
                for (String str : set) {
                    String str2;
                    if (str2 != null) {
                        str2 = str2.trim();
                        if (!str2.isEmpty() && str2.length() <= 200) {
                            hashSet.add(str2);
                            if (hashSet.size() >= 200) {
                                break;
                            }
                        }
                    }
                }
                iterable = hashSet;
            }
            fx fxVar = this.f;
            synchronized (fxVar) {
                if (iterable != null) {
                    if (!iterable.isEmpty()) {
                        a e = x.e();
                        e.e();
                        dh.a.a(iterable, e.b);
                        x d = e.d();
                        if (d.c()) {
                            fxVar.c.z.a(Base64.encodeToString(d.a(), 2));
                            fxVar.b.y();
                            fxVar.b.a(iterable);
                        } else {
                            throw new dz();
                        }
                    }
                }
                fxVar.c.z.c();
                fxVar.b.y();
            }
        }
    }

    public final synchronized void a(Context context, String str, String str2, String str3, String str4, String str5) {
        Object obj = 1;
        synchronized (this) {
            if (!this.k) {
                boolean z;
                b(context);
                if (this.e != null) {
                    z = true;
                } else {
                    z = false;
                }
                if (fr.a(z, "The given context was null")) {
                    Object obj2;
                    if (str4 != null && str4.length() == 24 && str4.matches("[0-9a-f]{24}")) {
                        obj2 = 1;
                    } else {
                        fr.b("Invalid App ID: {}", str4);
                        obj2 = null;
                    }
                    if (obj2 != null) {
                        if (str5 != null && str5.length() == 20 && str5.matches("[0-9A-Za-z\\-_]{20}")) {
                            obj2 = 1;
                        } else {
                            fr.b("Invalid App Key: {}", str5);
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            this.l = str;
                            this.m = str2;
                            this.u = str4;
                            this.v = str5;
                            try {
                                URL url = new URL(str3);
                                ch ciVar = new ci("TapjoySDK" + " " + str2 + " (" + Build.MODEL + "; Android " + VERSION.RELEASE + "; " + Locale.getDefault() + ")", url);
                                ce.b = ciVar;
                                ce.a = Executors.newCachedThreadPool();
                                fs fsVar = this.i;
                                fsVar.b = ciVar;
                                fsVar.a();
                                new Object[1][0] = str3;
                                this.k = true;
                                fy fyVar = new fy(d(this.e));
                                if (fyVar.b() == null) {
                                    obj = null;
                                }
                                if (obj == null && fyVar.a()) {
                                    ft ftVar = this.g;
                                    ftVar.a(ftVar.a(i.APP, "install"));
                                }
                                fx fxVar = this.f;
                                if (!(cr.c(str4) || str4.equals(fxVar.c.D.a()))) {
                                    fxVar.c.D.a(str4);
                                    fxVar.c.a(false);
                                }
                                b();
                            } catch (Throwable e) {
                                throw new IllegalArgumentException(e);
                            }
                        }
                    }
                }
            }
        }
    }

    public final boolean b(String str) {
        if ((this.k || this.j != null) && this.e != null) {
            return true;
        }
        if (fr.a) {
            fr.b(str + ": Should be called after initializing the SDK");
        }
        return false;
    }

    public final boolean c(String str) {
        if (this.e != null) {
            return true;
        }
        if (fr.a) {
            fr.b(str + ": Should be called after initializing the SDK");
        }
        return false;
    }

    public final boolean d() {
        return this.h != null && this.h.b.get();
    }

    public final boolean e() {
        boolean z;
        gh ghVar = this.h;
        if (ghVar.c != null) {
            ghVar.c.cancel(false);
            ghVar.c = null;
        }
        if (ghVar.b.compareAndSet(false, true)) {
            fr.a("New session started");
            ft ftVar = ghVar.a;
            p d = ftVar.a.d();
            fx fxVar = ftVar.a;
            synchronized (fxVar) {
                int b = fxVar.c.h.b() + 1;
                fxVar.c.h.a(b);
                fxVar.b.d(b);
            }
            c.a a = ftVar.a(i.APP, "bootup");
            ftVar.c = SystemClock.elapsedRealtime();
            if (d != null) {
                if (d == null) {
                    throw new NullPointerException();
                }
                a.l = d;
                a.b |= 65536;
            }
            ftVar.a(a);
            eo.c.notifyObservers();
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            return false;
        }
        gc gcVar = this.a;
        synchronized (gcVar) {
            gcVar.b = null;
        }
        gp.a.a();
        return true;
    }

    final void a(Map map) {
        ft ftVar = this.g;
        c.a a = ftVar.a(i.CAMPAIGN, "impression");
        if (map != null) {
            a.a(bl.a((Object) map));
        }
        ftVar.a(a);
    }

    final void a(Map map, long j) {
        ft ftVar = this.g;
        c.a d = ftVar.a(i.CAMPAIGN, "view").d(j);
        if (map != null) {
            d.a(bl.a((Object) map));
        }
        ftVar.a(d);
    }

    final void a(Map map, String str) {
        ft ftVar = this.g;
        c.a a = ftVar.a(i.CAMPAIGN, "click");
        Object linkedHashMap = new LinkedHashMap(map);
        linkedHashMap.put("region", str);
        a.a(bl.a(linkedHashMap));
        ftVar.a(a);
    }

    public static synchronized void a(Runnable runnable) {
        synchronized (fu.class) {
            if (w == null) {
                w = new Handler(Looper.getMainLooper());
            }
            w.post(runnable);
        }
    }

    static synchronized File c(Context context) {
        File file;
        synchronized (fu.class) {
            if (x == null) {
                x = context.getDir("fiverocks", 0);
            }
            file = x;
        }
        return file;
    }

    static File d(Context context) {
        return new File(c(context), "install");
    }

    public static String a(Context context, Intent intent) {
        String a = f.a(intent);
        if (a != null) {
            fu fuVar = r;
            fuVar.b(context);
            if (cr.c(fuVar.f.c()) || intent.getBooleanExtra("fiverocks:force", false)) {
                fx fxVar = fuVar.f;
                synchronized (fxVar) {
                    fxVar.c.d.a(a);
                    fxVar.b.a(a);
                }
                if (a.length() > 0) {
                    ft ftVar = fuVar.g;
                    ftVar.a(ftVar.a(i.APP, TapjoyConstants.TJC_REFERRER));
                }
            }
        }
        return a;
    }

    public static fu a(Context context) {
        fu fuVar = r;
        fuVar.b(context);
        return fuVar;
    }
}
