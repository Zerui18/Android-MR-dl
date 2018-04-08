package co.cyberz.util.e;

import android.content.Context;
import android.support.annotation.Nullable;
import co.cyberz.util.string.StringUtil;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public final class a {
    private static a b;
    public a a;
    private a c;
    private FutureTask<a> d;

    public static class a {
        public final String a;
        public final boolean b;
        public final String c;

        public a(String str, boolean z) {
            this.a = str;
            this.b = z;
            String str2 = StringUtil.isEmpty(str) ? "" : z ? "0" : "1";
            this.c = str2;
        }

        public final String toString() {
            return this.a;
        }
    }

    private a(final Context context) {
        try {
            this.d = new FutureTask(new Callable(this) {
                final /* synthetic */ a b;

                public final /* synthetic */ Object call() {
                    return this.b.b(context);
                }
            });
            co.cyberz.common.a.a.a(this.d);
        } catch (Exception e) {
        }
    }

    private a a(a aVar) {
        if (aVar == null) {
            return new a("", true);
        }
        if (this.c != null) {
            return this.c;
        }
        try {
            return new a(co.cyberz.util.h.a.a(aVar.a, co.cyberz.util.h.a.a.XUNIQ), aVar.b);
        } catch (Exception e) {
            return new a("", true);
        }
    }

    public static a a(Context context) {
        if (b == null) {
            b = new a(context.getApplicationContext());
        }
        return b;
    }

    public final synchronized a a() {
        a aVar;
        if (this.c != null) {
            aVar = this.c;
        } else {
            aVar = a(3);
            aVar = StringUtil.isEmpty(aVar.a) ? new a("", true) : a(aVar);
        }
        return aVar;
    }

    public final synchronized a a(int i) {
        a aVar;
        if (this.a != null) {
            aVar = this.a;
        } else {
            try {
                aVar = (a) this.d.get((long) i, TimeUnit.SECONDS);
            } catch (Exception e) {
                aVar = null;
            }
            if (this.c == null) {
                this.c = a(this.a);
            }
            if (aVar == null) {
                aVar = new a("", true);
            }
        }
        return aVar;
    }

    @Nullable
    final a b(Context context) {
        if (this.a != null) {
            return this.a;
        }
        try {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Class cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            Object invoke = cls.getMethod("getAdvertisingIdInfo", new Class[]{Context.class}).invoke(cls, new Object[]{context});
            if (invoke != null) {
                String str = (String) invoke.getClass().getMethod("getId", null).invoke(invoke, null);
                if (str != null) {
                    this.a = new a(str, ((Boolean) invoke.getClass().getMethod("isLimitAdTrackingEnabled", null).invoke(invoke, null)).booleanValue());
                }
            }
        } catch (ClassNotFoundException e) {
            co.cyberz.util.f.a.c("Not found google play services in this application");
        } catch (Throwable e2) {
            String simpleName = e2.getCause().getClass().getSimpleName();
            if ("GooglePlayServicesRepairableException".equals(simpleName) || "GooglePlayServicesNotAvailableException".equals(simpleName)) {
                co.cyberz.util.f.a.a(e2.getCause().getMessage(), e2.getTargetException());
            } else if ("IOException".equals(simpleName)) {
                co.cyberz.util.f.a.a("Unrecoverable error connecting to Google Play services", e2);
            } else if ("GooglePlayServicesAvailabilityException".equals(simpleName)) {
                co.cyberz.util.f.a.c("Encountered a recoverable error connecting to Google Play services");
            } else {
                co.cyberz.util.f.a.a("Not found Google Play Services", e2);
            }
        } catch (Exception e3) {
            co.cyberz.util.f.a.c("Cannot get AdvertisingId");
        }
        return this.a;
    }
}
