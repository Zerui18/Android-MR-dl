package co.cyberz.fox;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import co.cyberz.common.ids.FingerPrint;
import co.cyberz.fox.b.b;
import co.cyberz.fox.service.c;
import co.cyberz.fox.service.e;
import co.cyberz.fox.service.h;
import co.cyberz.fox.service.i;
import co.cyberz.util.string.StringUtil;

public final class a implements co.cyberz.fox.service.e.a {
    private static a f;
    c a;
    FoxTrackOption b;
    public FoxConfig c;
    public Context d;
    FingerPrint e;

    public static a a() {
        if (f == null) {
            f = new a();
        }
        return f;
    }

    private void f() {
        this.b.setTrackingStateListener(null);
        this.b.setTrackingStateListener(null);
    }

    protected final void a(FoxTrackOption foxTrackOption) {
        if (foxTrackOption == null) {
            co.cyberz.util.f.a.c("FoxTrackOption must be not null");
        } else if (this.c == null) {
            co.cyberz.util.f.a.c("FoxConfig isn't get activation yet");
        } else {
            this.b = foxTrackOption;
            if (!e()) {
                co.cyberz.common.a.a.a(new Runnable(this) {
                    final /* synthetic */ a a;

                    {
                        this.a = r1;
                    }

                    public final void run() {
                        this.a.e = new FingerPrint(this.a.d);
                        try {
                            new Handler(Looper.getMainLooper()).post(new Runnable(this.a.e) {
                                final /* synthetic */ FingerPrint a;

                                {
                                    this.a = r1;
                                }

                                public final void run() {
                                    FingerPrint.a(this.a);
                                }
                            });
                        } catch (Throwable th) {
                        }
                        b a = h.a();
                        if (a != null) {
                            if (this.a.b.deeplinkHandler != null) {
                                new co.cyberz.fox.service.b(this.a.d, a, this.a.b.getDeeplinkHandler()).a((Object[]) new Void[0]);
                            }
                            e eVar = new e(this.a.d, this.a.b, a, this.a);
                            new b(eVar.a.b, new co.cyberz.fox.service.e.b.a(eVar) {
                                final /* synthetic */ e a;

                                {
                                    this.a = r1;
                                }

                                public final void a() {
                                    this.a.a((Object[]) new Void[0]);
                                    try {
                                        if (!co.cyberz.common.b.a.a().l && this.a.a.a) {
                                            this.a.a(this.a.b);
                                        }
                                    } catch (Exception e) {
                                    }
                                }
                            }).a((Object[]) new Void[0]);
                        }
                    }
                });
            }
        }
    }

    protected final void a(String str) {
        if (this.c == null) {
            co.cyberz.util.f.a.c("FoxConfig is not activation yet.");
        } else if (StringUtil.isEmpty(str)) {
            co.cyberz.util.f.a.c("URL must be not null.");
        } else {
            e();
            c.a(str);
        }
    }

    public final void b() {
        this.e = null;
        if (this.b.trackingStateListener != null) {
            this.b.trackingStateListener.onComplete();
            f();
        }
    }

    protected final void c() {
        if (i.b(this.d) && this.b != null && this.b.trackingStateListener != null) {
            this.e = null;
            this.b.trackingStateListener.onComplete();
            f();
        }
    }

    protected final void d() {
        e();
        c.a();
    }

    protected final boolean e() {
        boolean z = false;
        if (this.c == null) {
            co.cyberz.util.f.a.c("FoxConfig is not activation yet.");
        } else {
            Context context = this.c.getContext();
            if (context != null && (context.getSharedPreferences("co.cyberz.fox", 0).getBoolean("fox_sent_cv", false) || i.c(context))) {
                z = true;
            }
            if (!z) {
                co.cyberz.util.f.a.c("Install Tracking has not been completed yet.");
            }
        }
        return z;
    }
}
