package com.tapjoy.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager.BadTokenException;
import android.widget.FrameLayout;
import com.tapjoy.TJContentActivity;
import com.tapjoy.internal.hf.a;
import java.util.Iterator;

public final class fq extends gb {
    public static fq a;
    final fu b;
    final String c;
    final gn d;
    private boolean e;
    private boolean f;
    private long g;
    private Context l;
    private hf m;
    private Activity n;
    private fv o;
    private Handler p;
    private Runnable q;

    public static class AnonymousClass1 implements Runnable {
        final /* synthetic */ fq a;

        public AnonymousClass1(fq fqVar) {
            this.a = fqVar;
        }

        public final void run() {
            fq.a(this.a);
        }
    }

    static /* synthetic */ void a(fq fqVar) {
        if (fqVar.f) {
            fqVar.f = false;
            if (fqVar.p != null) {
                fqVar.p.removeCallbacks(fqVar.q);
                fqVar.q = null;
                fqVar.p = null;
            }
            if (a == fqVar) {
                a = null;
            }
            fqVar.b.a(fqVar.d.b, SystemClock.elapsedRealtime() - fqVar.g);
            if (!(fqVar.i || fqVar.o == null)) {
                fqVar.o.a(fqVar.c, fqVar.k, null);
                fqVar.o = null;
            }
            ViewGroup viewGroup = (ViewGroup) fqVar.m.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(fqVar.m);
            }
            fqVar.m = null;
            if (fqVar.n instanceof TJContentActivity) {
                fqVar.n.finish();
            }
            fqVar.n = null;
        }
    }

    public fq(fu fuVar, String str, gn gnVar, Context context) {
        this.b = fuVar;
        this.c = str;
        this.d = gnVar;
        this.l = context;
    }

    public final void a() {
        Iterator it = this.d.a.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((gw) it.next()).c.iterator();
            while (it2.hasNext()) {
                gv gvVar = (gv) it2.next();
                if (gvVar.l != null) {
                    gvVar.l.a();
                }
                if (gvVar.m != null) {
                    gvVar.m.a();
                }
            }
        }
    }

    public final boolean b() {
        Iterator it = this.d.a.iterator();
        boolean z = true;
        while (it.hasNext()) {
            Iterator it2 = ((gw) it.next()).c.iterator();
            while (it2.hasNext()) {
                gv gvVar = (gv) it2.next();
                if ((gvVar.l != null && gvVar.l.b == null) || (gvVar.m != null && gvVar.m.b == null)) {
                    z = false;
                    continue;
                    break;
                }
            }
            z = true;
            continue;
            if (!z) {
                return false;
            }
        }
        return z;
    }

    public final void a(fv fvVar, eq eqVar) {
        this.o = fvVar;
        this.n = c.a(this.l);
        if (!(this.n == null || this.n.isFinishing())) {
            try {
                a(this.n, fvVar, eqVar);
                new Object[1][0] = this.c;
                return;
            } catch (BadTokenException e) {
            }
        }
        this.n = fm.a();
        if (!(this.n == null || this.n.isFinishing())) {
            try {
                a(this.n, fvVar, eqVar);
                new Object[1][0] = this.c;
                return;
            } catch (BadTokenException e2) {
            }
        }
        fr.b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.c);
        fvVar.a(this.c, this.k, null);
    }

    private void a(final Activity activity, final fv fvVar, eq eqVar) {
        cq.a(!this.e);
        this.e = true;
        this.f = true;
        a = this;
        this.m = new hf(activity, this.d, new a(this) {
            final /* synthetic */ fq c;

            public final void a(gv gvVar) {
                this.c.b.a(this.c.d.b, gvVar.k);
                if (!cr.c(gvVar.h)) {
                    this.c.j.a(activity, gvVar.h, cr.b(gvVar.i));
                    this.c.i = true;
                } else if (!cr.c(gvVar.g)) {
                    gb.a(activity, gvVar.g);
                }
                fvVar.a(this.c.c, null);
                if (gvVar.j) {
                    fq.a(this.c);
                }
            }

            public final void a() {
                fq.a(this.c);
            }
        });
        Window window = activity.getWindow();
        View view = this.m;
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1, 17);
        Callback callback = window.getCallback();
        window.setCallback(null);
        window.addContentView(view, layoutParams);
        window.setCallback(callback);
        this.g = SystemClock.elapsedRealtime();
        this.b.a(this.d.b);
        eqVar.a();
        fvVar.c(this.c);
        if (this.d.c > 0.0f) {
            this.p = new Handler(Looper.getMainLooper());
            this.q = new Runnable(this) {
                final /* synthetic */ fq a;

                {
                    this.a = r1;
                }

                public final void run() {
                    fq.a(this.a);
                }
            };
            this.p.postDelayed(this.q, (long) (this.d.c * 1000.0f));
        }
    }
}
