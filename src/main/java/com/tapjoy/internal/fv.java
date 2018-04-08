package com.tapjoy.internal;

import android.os.Handler;
import android.os.Looper;

public class fv implements fj {
    private static final fv a = new fv() {
        public final void a(String str) {
        }

        public final void b(String str) {
        }

        public final void c(String str) {
        }

        public final void d(String str) {
        }

        public final void a(String str, fg fgVar) {
        }

        public final void a(String str, String str2, fg fgVar) {
        }
    };
    private final fj b;
    private final be c;

    public static fv a(fj fjVar) {
        Object obj;
        if (fjVar instanceof fv) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            throw new IllegalArgumentException();
        } else if (fjVar != null) {
            return new fv(fjVar);
        } else {
            return a;
        }
    }

    private fv() {
        this.b = null;
        this.c = null;
    }

    private fv(fj fjVar) {
        Handler a;
        this.b = fjVar;
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            cq.a((Object) myLooper);
            a = myLooper == Looper.getMainLooper() ? x.a() : new Handler(myLooper);
        } else {
            a = null;
        }
        if (a != null) {
            this.c = x.a(a);
            new Object[1][0] = a.getLooper();
        } else if (Thread.currentThread() == fm.b()) {
            this.c = fm.a;
        } else {
            this.c = x.a(x.a());
        }
    }

    public void a(final String str) {
        this.c.a(new Runnable(this) {
            final /* synthetic */ fv b;

            public final void run() {
                this.b.b.a(str);
            }
        });
    }

    public void b(final String str) {
        this.c.a(new Runnable(this) {
            final /* synthetic */ fv b;

            public final void run() {
                this.b.b.b(str);
            }
        });
    }

    public void c(final String str) {
        this.c.a(new Runnable(this) {
            final /* synthetic */ fv b;

            public final void run() {
                this.b.b.c(str);
            }
        });
    }

    public void d(final String str) {
        this.c.a(new Runnable(this) {
            final /* synthetic */ fv b;

            public final void run() {
                this.b.b.d(str);
            }
        });
    }

    public void a(final String str, final fg fgVar) {
        this.c.a(new Runnable(this) {
            final /* synthetic */ fv c;

            public final void run() {
                this.c.b.a(str, fgVar);
            }
        });
    }

    public void a(final String str, final String str2, final fg fgVar) {
        this.c.a(new Runnable(this) {
            final /* synthetic */ fv d;

            public final void run() {
                this.d.b.a(str, str2, fgVar);
            }
        });
    }
}
