package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TJCorePlacement.AnonymousClass7;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.cr;
import com.tapjoy.internal.ek;
import com.tapjoy.internal.eq;
import com.tapjoy.internal.fa;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.fz;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TJPlacement {
    TJPlacementListener a;
    private TJCorePlacement b;
    private TJPlacementListener c;
    private TJPlacementVideoListener d;
    private String e;
    public String pushId;

    @Deprecated
    public TJPlacement(Context activityContext, String placementName, TJPlacementListener listener) {
        TJCorePlacement a = TJPlacementManager.a(placementName);
        if (a == null) {
            a = TJPlacementManager.a(placementName, "", "", false);
        }
        a.setContext(activityContext);
        a(a, listener);
    }

    TJPlacement(TJCorePlacement corePlacement, TJPlacementListener listener) {
        a(corePlacement, listener);
    }

    private void a(TJCorePlacement tJCorePlacement, TJPlacementListener tJPlacementListener) {
        this.b = tJCorePlacement;
        this.e = UUID.randomUUID().toString();
        this.c = tJPlacementListener;
        this.a = tJPlacementListener != null ? (TJPlacementListener) ek.a(tJPlacementListener, TJPlacementListener.class) : null;
        FiveRocksIntegration.addPlacementCallback(getName(), this);
    }

    public TJPlacementListener getListener() {
        return this.c;
    }

    public void setVideoListener(TJPlacementVideoListener videoListener) {
        this.d = videoListener;
    }

    public TJPlacementVideoListener getVideoListener() {
        return this.d;
    }

    public String getName() {
        return this.b.getPlacementData() != null ? this.b.getPlacementData().getPlacementName() : "";
    }

    public boolean isContentReady() {
        boolean isContentReady = this.b.isContentReady();
        eq eqVar = this.b.f;
        if (isContentReady) {
            eqVar.a(4);
        } else {
            eqVar.a(2);
        }
        return isContentReady;
    }

    public boolean isContentAvailable() {
        this.b.f.a(1);
        return this.b.isContentAvailable();
    }

    public void setMediationId(String mediationId) {
        this.b.p = mediationId;
    }

    public void requestContent() {
        Object name = getName();
        TapjoyLog.i("TJPlacement", "requestContent() called for placement " + name);
        fa.a("TJPlacement.requestContent").a("placement", name).a("placement_type", this.b.b());
        if (!TapjoyConnectCore.isConnected()) {
            fa.b("TJPlacement.requestContent").b("not connected").c();
            a(new TJError(0, "SDK not connected -- connect must be called first with a successful callback"));
        } else if (this.b.getContext() == null) {
            fa.b("TJPlacement.requestContent").b("no context").c();
            a(new TJError(0, "Context is null -- TJPlacement requires a valid Context."));
        } else if (cr.c(name)) {
            fa.b("TJPlacement.requestContent").b("invalid name").c();
            a(new TJError(0, "Invalid placement name -- TJPlacement requires a valid placement name."));
        } else {
            try {
                TJCorePlacement tJCorePlacement = this.b;
                if (this == null) {
                    tJCorePlacement.a(ErrorType.SDK_ERROR, new TJError(0, "Cannot request content from a NULL placement"));
                } else {
                    tJCorePlacement.a("REQUEST", this);
                    if (tJCorePlacement.e - SystemClock.elapsedRealtime() > 0) {
                        TapjoyLog.d(TJCorePlacement.a, "Content has not expired yet for " + tJCorePlacement.c.getPlacementName());
                        if (tJCorePlacement.j) {
                            fa.b("TJPlacement.requestContent").a("content_type", tJCorePlacement.c()).a("from", (Object) "cache").c();
                            tJCorePlacement.i = false;
                            tJCorePlacement.a(this);
                            tJCorePlacement.d();
                        } else {
                            fa.b("TJPlacement.requestContent").a("content_type", (Object) "none").a("from", (Object) "cache").c();
                            tJCorePlacement.a(this);
                        }
                    } else {
                        if (tJCorePlacement.j) {
                            fa.c("TJPlacement.requestContent").a("was_available", Boolean.valueOf(true));
                        }
                        if (tJCorePlacement.k) {
                            fa.c("TJPlacement.requestContent").a("was_ready", Boolean.valueOf(true));
                        }
                        if (cr.c(tJCorePlacement.o)) {
                            tJCorePlacement.a();
                        } else {
                            Map hashMap = new HashMap();
                            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_AGENT, tJCorePlacement.o);
                            hashMap.put(TJAdUnitConstants.PARAM_PLACEMENT_MEDIATION_ID, tJCorePlacement.p);
                            tJCorePlacement.a(tJCorePlacement.c.getMediationURL(), hashMap, true);
                        }
                    }
                }
                fa.d("TJPlacement.requestContent");
            } catch (Throwable th) {
                fa.d("TJPlacement.requestContent");
            }
        }
    }

    public void showContent() {
        int i = 0;
        Object name = getName();
        TapjoyLog.i("TJPlacement", "showContent() called for placement " + name);
        this.b.f.a(8);
        fa.a("TJPlacement.showContent").a("placement", name).a("placement_type", this.b.b()).a("content_type", this.b.c());
        if (this.b.isContentAvailable()) {
            try {
                TJCorePlacement tJCorePlacement = this.b;
                if (this == null) {
                    tJCorePlacement.a(ErrorType.SDK_ERROR, new TJError(0, "Cannot show content from a NULL placement"));
                } else if (TapjoyConnectCore.isFullScreenViewOpen()) {
                    TapjoyLog.w(TJCorePlacement.a, "Only one view can be presented at a time.");
                    fa.b("TJPlacement.showContent").b("another content showing").c();
                } else {
                    if (TapjoyConnectCore.isViewOpen()) {
                        TapjoyLog.w(TJCorePlacement.a, "Will close N2E content.");
                        TJPlacementManager.dismissContentShowing(false);
                    }
                    tJCorePlacement.a("SHOW", this);
                    tJCorePlacement.f.c = fa.d("TJPlacement.showContent");
                    String uuid = UUID.randomUUID().toString();
                    if (tJCorePlacement.l != null) {
                        tJCorePlacement.l.showContent();
                    } else if (tJCorePlacement.h != null) {
                        tJCorePlacement.h.k = uuid;
                        if (tJCorePlacement.h == null) {
                            i = 1;
                        } else if (tJCorePlacement.h instanceof fq) {
                            i = 3;
                        } else if (tJCorePlacement.h instanceof fz) {
                            i = 2;
                        }
                        TapjoyConnectCore.viewWillOpen(uuid, i);
                        tJCorePlacement.h.j = new AnonymousClass7(tJCorePlacement, uuid);
                        fu.a(new Runnable(tJCorePlacement) {
                            final /* synthetic */ TJCorePlacement a;

                            {
                                this.a = r1;
                            }

                            public final void run() {
                                this.a.h.a(fu.a().p, this.a.f);
                            }
                        });
                    } else {
                        tJCorePlacement.c.setContentViewId(uuid);
                        Intent intent = new Intent(tJCorePlacement.b, TJAdUnitActivity.class);
                        intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, tJCorePlacement.c);
                        intent.setFlags(DriveFile.MODE_READ_ONLY);
                        tJCorePlacement.b.startActivity(intent);
                    }
                    tJCorePlacement.e = 0;
                    tJCorePlacement.j = false;
                    tJCorePlacement.k = false;
                }
                fa.d("TJPlacement.showContent");
            } catch (Throwable th) {
                fa.d("TJPlacement.showContent");
            }
        } else {
            TapjoyLog.e("TJPlacement", new TapjoyErrorMessage(ErrorType.INTEGRATION_ERROR, "No placement content available. Can not show content for non-200 placement."));
            fa.b("TJPlacement.showContent").b("no content").c();
        }
    }

    public void setMediationName(String mediationName) {
        TapjoyLog.d("TJPlacement", "setMediationName=" + mediationName);
        if (!cr.c(mediationName)) {
            Context context = this.b != null ? this.b.getContext() : null;
            this.b = TJPlacementManager.a(getName(), mediationName, "", false);
            TJCorePlacement tJCorePlacement = this.b;
            tJCorePlacement.o = mediationName;
            tJCorePlacement.m = mediationName;
            tJCorePlacement.c.setMediationURL(TapjoyConnectCore.getPlacementURL() + "v1/apps/" + TapjoyConnectCore.getAppID() + "/mediation_content?");
            if (context != null) {
                this.b.setContext(context);
            }
        }
    }

    public void setAdapterVersion(String adapterVersion) {
        this.b.n = adapterVersion;
    }

    public static void dismissContent() {
        boolean z = false;
        if ("true".equals(TapjoyConnectCore.getConnectFlagValue("TJC_OPTION_DISMISS_CONTENT_ALL"))) {
            z = true;
        }
        TJPlacementManager.dismissContentShowing(z);
    }

    public String getGUID() {
        return this.e;
    }

    private void a(TJError tJError) {
        this.b.a(this, ErrorType.INTEGRATION_ERROR, tJError);
    }
}
