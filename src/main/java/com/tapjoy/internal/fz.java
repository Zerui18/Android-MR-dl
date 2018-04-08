package com.tapjoy.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.BadTokenException;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tapjoy.TJContentActivity;
import com.tapjoy.TJContentActivity.AbstractContentProducer;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.internal.hh.a;

public final class fz extends gb {
    public static fz a;
    final fu b;
    final String c;
    final gq d;
    e e;
    long f;
    boolean g = false;
    private boolean l;
    private Context m;

    public fz(fu fuVar, String str, gq gqVar, Context context) {
        this.b = fuVar;
        this.c = str;
        this.d = gqVar;
        this.m = context;
    }

    public final void a() {
        gq gqVar = this.d;
        if (gqVar.a != null) {
            gqVar.a.a();
        }
        if (gqVar.b != null) {
            gqVar.b.a();
        }
        gqVar.c.a();
        if (gqVar.e != null) {
            gqVar.e.a();
        }
        if (gqVar.f != null) {
            gqVar.f.a();
        }
        if (gqVar.m != null && gqVar.m.a != null) {
            gqVar.m.a.a();
        }
    }

    public final boolean b() {
        gq gqVar = this.d;
        return (gqVar.c == null || gqVar.c.b == null || ((gqVar.m != null && gqVar.m.a != null && gqVar.m.a.b == null) || ((gqVar.b == null || gqVar.f == null || gqVar.b.b == null || gqVar.f.b == null) && (gqVar.a == null || gqVar.e == null || gqVar.a.b == null || gqVar.e.b == null)))) ? false : true;
    }

    public final void a(final fv fvVar, final eq eqVar) {
        Activity a = c.a(this.m);
        if (!(a == null || a.isFinishing())) {
            try {
                a(a, fvVar, eqVar);
                new Object[1][0] = this.c;
                return;
            } catch (BadTokenException e) {
            }
        }
        Activity a2 = fm.a();
        boolean z = a2 != null ? (a2.getWindow().getAttributes().flags & 1024) != 0 : false;
        try {
            TJContentActivity.start(fu.a().e, new AbstractContentProducer(this) {
                final /* synthetic */ fz c;

                public final void show(Activity activity) {
                    try {
                        this.c.a(activity, fvVar, eqVar);
                    } catch (BadTokenException e) {
                        fr.b("Failed to show the content for \"{}\" caused by invalid activity", this.c.c);
                        fvVar.a(this.c.c, this.c.k, null);
                    }
                }

                public final void dismiss(Activity activity) {
                    this.c.c();
                }
            }, z);
            new Object[1][0] = this.c;
        } catch (ActivityNotFoundException e2) {
            if (!(a2 == null || a2.isFinishing())) {
                try {
                    a(a2, fvVar, eqVar);
                    new Object[1][0] = this.c;
                    return;
                } catch (BadTokenException e3) {
                    fr.b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.c);
                    fvVar.a(this.c, this.k, null);
                }
            }
            fr.b("Failed to show the content for \"{}\" caused by no registration of TJContentActivity", this.c);
            fvVar.a(this.c, this.k, null);
        }
    }

    final void a(final Activity activity, final fv fvVar, eq eqVar) {
        cq.a(!this.l);
        this.l = true;
        a = this;
        this.e = new e(activity);
        this.e.setOnCancelListener(new OnCancelListener(this) {
            final /* synthetic */ fz b;

            public final void onCancel(DialogInterface dialog) {
                fvVar.d(this.b.c);
            }
        });
        this.e.setOnDismissListener(new OnDismissListener(this) {
            final /* synthetic */ fz c;

            public final void onDismiss(DialogInterface dialog) {
                fz.a = null;
                gb.a(activity, this.c.d.g);
                this.c.b.a(this.c.d.k, SystemClock.elapsedRealtime() - this.c.f);
                if (!this.c.i) {
                    fvVar.a(this.c.c, this.c.k, this.c.d.h);
                }
                if (this.c.g && this.c.d.k != null && this.c.d.k.containsKey("action_id")) {
                    String obj = this.c.d.k.get("action_id").toString();
                    if (obj != null && obj.length() > 0) {
                        fu fuVar = this.c.b;
                        if (fuVar.b != null) {
                            Object obj2;
                            gd gdVar = fuVar.b;
                            String a = gd.a();
                            String a2 = gdVar.b.a();
                            String a3 = gdVar.a.a();
                            if (a3 == null || !a.equals(a3)) {
                                gdVar.a.a(a);
                                a2 = "";
                            }
                            if (a2.length() == 0) {
                                obj2 = 1;
                            } else {
                                obj2 = null;
                            }
                            if (obj2 != null) {
                                a2 = obj;
                            } else if (!a2.contains(obj)) {
                                a2 = a2.concat("," + obj);
                            }
                            gdVar.b.a(a2);
                        }
                    }
                }
                if (activity instanceof TJContentActivity) {
                    activity.finish();
                }
            }
        });
        this.e.setCanceledOnTouchOutside(false);
        View hgVar = new hg(activity, this.d, new hh(activity, this.d, new a(this) {
            final /* synthetic */ fz c;

            public final void a() {
                this.c.e.cancel();
            }

            public final void a(go goVar) {
                this.c.b.a(this.c.d.k, goVar.b);
                gb.a(activity, goVar.d);
                if (!cr.c(goVar.e)) {
                    this.c.j.a(activity, goVar.e, cr.b(goVar.f));
                    this.c.i = true;
                }
                fvVar.a(this.c.c, goVar.g);
                if (goVar.c) {
                    this.c.e.dismiss();
                }
            }

            public final void b() {
                boolean z;
                fz fzVar = this.c;
                if (this.c.g) {
                    z = false;
                } else {
                    z = true;
                }
                fzVar.g = z;
            }
        }));
        View frameLayout = new FrameLayout(activity);
        frameLayout.addView(hgVar, new LayoutParams(-2, -2, 17));
        this.e.setContentView(frameLayout);
        if (Boolean.FALSE.booleanValue()) {
            boolean z;
            int i;
            aj ajVar;
            al alVar;
            Window window = this.e.getWindow();
            if (VERSION.SDK_INT == 16 && "4.1.2".equals(VERSION.RELEASE)) {
                if (Boolean.FALSE.equals(a(window.getContext()))) {
                    z = false;
                    if (z) {
                        i = ai.a.b;
                        ajVar = new aj();
                        switch (com.tapjoy.internal.ai.AnonymousClass1.a[i - 1]) {
                            case 1:
                                alVar = new al();
                                alVar.a = false;
                                alVar.b = 60.0f;
                                ajVar.a(alVar.a()).a(new ScaleAnimation(0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, 0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER)).a(new am().a(TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER).b(0.3f).a());
                                break;
                            case 2:
                                alVar = new al();
                                alVar.a = false;
                                alVar.b = -60.0f;
                                ajVar.a(alVar.a()).a(new ScaleAnimation(0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, 0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER)).a(new am().a(-0.4f).b(0.3f).a());
                                break;
                            case 3:
                                alVar = new al();
                                alVar.a = true;
                                alVar.b = -60.0f;
                                ajVar.a(alVar.a()).a(new ScaleAnimation(0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, 0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER)).a(new am().a(0.3f).b(TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER).a());
                                break;
                            case 4:
                                alVar = new al();
                                alVar.a = true;
                                alVar.b = 60.0f;
                                ajVar.a(alVar.a()).a(new ScaleAnimation(0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, 0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER)).a(new am().a(0.3f).b(-0.4f).a());
                                break;
                        }
                        hgVar.startAnimation(ajVar.b().a());
                    }
                } else {
                    window.setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
                }
            }
            z = true;
            if (z) {
                i = ai.a.b;
                ajVar = new aj();
                switch (com.tapjoy.internal.ai.AnonymousClass1.a[i - 1]) {
                    case 1:
                        alVar = new al();
                        alVar.a = false;
                        alVar.b = 60.0f;
                        ajVar.a(alVar.a()).a(new ScaleAnimation(0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, 0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER)).a(new am().a(TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER).b(0.3f).a());
                        break;
                    case 2:
                        alVar = new al();
                        alVar.a = false;
                        alVar.b = -60.0f;
                        ajVar.a(alVar.a()).a(new ScaleAnimation(0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, 0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER)).a(new am().a(-0.4f).b(0.3f).a());
                        break;
                    case 3:
                        alVar = new al();
                        alVar.a = true;
                        alVar.b = -60.0f;
                        ajVar.a(alVar.a()).a(new ScaleAnimation(0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, 0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER)).a(new am().a(0.3f).b(TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER).a());
                        break;
                    case 4:
                        alVar = new al();
                        alVar.a = true;
                        alVar.b = 60.0f;
                        ajVar.a(alVar.a()).a(new ScaleAnimation(0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, 0.4f, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER)).a(new am().a(0.3f).b(-0.4f).a());
                        break;
                }
                hgVar.startAnimation(ajVar.b().a());
            }
        }
        try {
            this.e.show();
            this.e.getWindow().setLayout(-1, -1);
            if ((activity.getWindow().getAttributes().flags & 1024) != 0) {
                this.e.getWindow().setFlags(1024, 1024);
            }
            this.f = SystemClock.elapsedRealtime();
            this.b.a(this.d.k);
            eqVar.a();
            fvVar.c(this.c);
        } catch (BadTokenException e) {
            throw e;
        }
    }

    public final void c() {
        if (this.e != null) {
            this.e.dismiss();
        }
    }

    private static Boolean a(Context context) {
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                Object obj = bundle.get("tapjoy:hardwareAccelerated");
                if (obj instanceof Boolean) {
                    return (Boolean) obj;
                }
            }
        } catch (NameNotFoundException e) {
        }
        return null;
    }
}
