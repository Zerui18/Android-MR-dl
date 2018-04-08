package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TJAdUnit.TJAdUnitVideoListener;
import com.tapjoy.TJAdUnit.TJAdUnitWebViewListener;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.bd;
import com.tapjoy.internal.cf;
import com.tapjoy.internal.cr;
import com.tapjoy.internal.d;
import com.tapjoy.internal.eg;
import com.tapjoy.internal.eq;
import com.tapjoy.internal.eu;
import com.tapjoy.internal.fa;
import com.tapjoy.internal.fa.a;
import com.tapjoy.internal.fd;
import com.tapjoy.internal.fn;
import com.tapjoy.internal.fr;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.gb;
import com.tapjoy.internal.gc;
import com.tapjoy.internal.gd;
import com.tapjoy.internal.gl.n;
import com.tapjoy.internal.gz;
import com.tapjoy.internal.y;
import com.tapjoy.mediation.TJCustomPlacement;
import com.tapjoy.mediation.TJCustomPlacementListener;
import com.tapjoy.mediation.TJMediatedPlacementData;
import com.tapjoy.mediation.TJMediationSettings;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TJCorePlacement implements TJCustomPlacementListener {
    static final String a = TJCorePlacement.class.getSimpleName();
    private TJAdUnitVideoListener A = new TJAdUnitVideoListener(this) {
        final /* synthetic */ TJCorePlacement a;

        {
            this.a = r1;
        }

        public final void onVideoStart() {
            TJPlacement a = this.a.a("SHOW");
            if (a != null && a.getVideoListener() != null) {
                a.getVideoListener().onVideoStart(a);
            }
        }

        public final void onVideoCompleted() {
            TJPlacement a = this.a.a("SHOW");
            if (a != null && a.getVideoListener() != null) {
                a.getVideoListener().onVideoComplete(a);
            }
        }

        public final void onVideoError(String errorMessage) {
            TJPlacement a = this.a.a("SHOW");
            if (a != null && a.getVideoListener() != null) {
                a.getVideoListener().onVideoError(a, errorMessage);
            }
        }
    };
    Context b = d.c();
    TJPlacementData c;
    String d;
    long e;
    final eq f = new eq();
    boolean g = false;
    gb h = null;
    volatile boolean i = false;
    public boolean initiatedBySdk;
    volatile boolean j = false;
    volatile boolean k = false;
    TJCustomPlacement l;
    String m;
    String n;
    String o;
    String p;
    private bd q = bd.a();
    private Map r;
    private TJAdUnit s;
    private boolean t = false;
    private gz u = null;
    private volatile boolean v = false;
    private TJMediatedPlacementData w;
    private Handler x;
    private Runnable y;
    private TJAdUnitWebViewListener z = new TJAdUnitWebViewListener(this) {
        final /* synthetic */ TJCorePlacement a;

        {
            this.a = r1;
        }

        public final void onContentReady() {
            this.a.d();
        }

        public final void onClosed() {
            if (this.a.g) {
                TJPlacementManager.decrementPlacementCacheCount();
                this.a.g = false;
            }
            if (this.a.t) {
                TJPlacementManager.decrementPlacementPreRenderCount();
                this.a.t = false;
            }
        }
    };

    class AnonymousClass7 implements fn {
        final /* synthetic */ String a;
        final /* synthetic */ TJCorePlacement b;

        AnonymousClass7(TJCorePlacement tJCorePlacement, String str) {
            this.b = tJCorePlacement;
            this.a = str;
        }

        public final void a(Context context, String str, String str2) {
            if (str2 == null) {
                this.b.c.setRedirectURL(str);
            } else {
                this.b.c.setBaseURL(str);
                this.b.c.setHttpResponse(str2);
            }
            this.b.c.setHasProgressSpinner(true);
            this.b.c.setContentViewId(this.a);
            Intent intent = new Intent(this.b.b, TJAdUnitActivity.class);
            intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, this.b.c);
            intent.setFlags(DriveFile.MODE_READ_ONLY);
            context.startActivity(intent);
        }
    }

    class AnonymousClass9 implements TJCacheListener {
        final /* synthetic */ TJCacheListener a;
        final /* synthetic */ TJCorePlacement b;

        AnonymousClass9(TJCorePlacement tJCorePlacement, TJCacheListener tJCacheListener) {
            this.b = tJCorePlacement;
            this.a = tJCacheListener;
        }

        public final void onCachingComplete(int status) {
            this.a.onCachingComplete(status);
        }
    }

    TJCorePlacement(String placementName, String placementKey) {
        if (this.b == null) {
            TapjoyLog.d(a, "getVisibleActivity() is NULL. Activity can be explicitly set via `Tapjoy.setActivity(Activity)`");
        }
        this.c = new TJPlacementData(placementKey, getPlacementContentUrl());
        this.c.setPlacementName(placementName);
        this.d = UUID.randomUUID().toString();
        this.s = new TJAdUnit();
        this.s.setWebViewListener(this.z);
        this.s.setVideoListener(this.A);
        this.y = new Runnable(this) {
            final /* synthetic */ TJCorePlacement a;

            {
                this.a = r1;
            }

            public final void run() {
                try {
                    TapjoyLog.i(TJCorePlacement.a, "Custom placement adapter request timed out");
                    this.a.i();
                } catch (TapjoyException e) {
                    this.a.a(ErrorType.SERVER_ERROR, new TJError(TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL, e.getMessage() + " for placement " + this.a.c.getPlacementName()));
                }
            }
        };
    }

    final synchronized void a() {
        String url = this.c.getUrl();
        if (cr.c(url)) {
            url = getPlacementContentUrl();
            if (cr.c(url)) {
                url = "TJPlacement is missing APP_ID";
                fa.b("TJPlacement.requestContent").a(url).c();
                a(ErrorType.SDK_ERROR, new TJError(0, url));
            } else {
                this.c.updateUrl(url);
            }
        }
        TapjoyLog.d(a, "sendContentRequest -- URL: " + url + " name: " + this.c.getPlacementName());
        a(url, null, true);
    }

    final synchronized void a(String str, Map map, boolean z) {
        String str2 = null;
        synchronized (this) {
            if (this.v) {
                TapjoyLog.i(a, "Placement " + this.c.getPlacementName() + " is already requesting content");
                fa.b("TJPlacement.requestContent").b("already doing").c();
            } else {
                eg egVar;
                fd c;
                this.c.resetPlacementRequestData();
                eq eqVar = this.f;
                eqVar.a = null;
                eqVar.c = null;
                this.v = false;
                this.i = false;
                this.j = false;
                this.k = false;
                this.v = true;
                final TJPlacement a = a("REQUEST");
                this.r = TapjoyConnectCore.getGenericURLParams();
                this.r.putAll(TapjoyConnectCore.getTimeStampAndVerifierParams());
                TapjoyUtil.safePut(this.r, TJAdUnitConstants.PARAM_PLACEMENT_NAME, this.c.getPlacementName(), true);
                TapjoyUtil.safePut(this.r, TJAdUnitConstants.PARAM_PLACEMENT_PRELOAD, "true", true);
                TapjoyUtil.safePut(this.r, "debug", Boolean.toString(fr.a), true);
                fu a2 = fu.a();
                Map map2 = this.r;
                String str3 = TJAdUnitConstants.PARAM_ACTION_ID_EXCLUSION;
                if (a2.b != null) {
                    gd gdVar = a2.b;
                    gdVar.b();
                    str2 = gdVar.b.a();
                }
                TapjoyUtil.safePut(map2, str3, str2, true);
                TapjoyUtil.safePut(this.r, TJAdUnitConstants.PARAM_PLACEMENT_BY_SDK, String.valueOf(this.initiatedBySdk), true);
                TapjoyUtil.safePut(this.r, TJAdUnitConstants.PARAM_PUSH_ID, a.pushId, true);
                TapjoyUtil.safePut(this.r, TapjoyConstants.TJC_MEDIATION_SOURCE, this.m, true);
                TapjoyUtil.safePut(this.r, TapjoyConstants.TJC_ADAPTER_VERSION, this.n, true);
                if (map != null) {
                    this.r.putAll(map);
                }
                this.s.setContext(this.b);
                if (z) {
                    egVar = new eg(eu.b().b("placement_request_content_retry_timeout"));
                    c = eu.b().c("placement_request_content_retry_backoff");
                } else {
                    egVar = eg.a;
                    c = fd.a;
                }
                final a d = fa.d("TJPlacement.requestContent");
                final String str4 = str;
                new Thread(this) {
                    final /* synthetic */ TJCorePlacement f;

                    public final void run() {
                        fa.a("TJPlacement.requestContent", d);
                        int i = 0;
                        while (!a()) {
                            i++;
                            this.f.r.put(TapjoyConstants.TJC_RETRY, Integer.toString(i));
                            if (i == 1) {
                                d.a("retry_timeout", Long.valueOf(egVar.b));
                            }
                            d.a("retry_count", (long) i);
                        }
                    }

                    private boolean a() {
                        long b;
                        TapjoyLog.i(TJCorePlacement.a, "Sending content request for placement " + this.f.c.getPlacementName());
                        TJCorePlacement tJCorePlacement = this.f;
                        fu a = fu.a();
                        String f = this.f.c.getPlacementName();
                        Context h = this.f.b;
                        gc gcVar = a.a;
                        n a2 = gcVar.a.a(false);
                        tJCorePlacement.u = new gz(gcVar.a, a2.c, a2.d, a2.e, f, h);
                        TapjoyHttpURLResponse responseFromURL = new TapjoyURLConnection().getResponseFromURL(str4, null, null, this.f.r);
                        this.f.c.setHttpStatusCode(responseFromURL.statusCode);
                        this.f.c.setHttpResponse(responseFromURL.response);
                        if (!responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_PRERENDER_HEADER).equals("0")) {
                            this.f.c.setPrerenderingRequested(true);
                        }
                        String headerFieldAsString = responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_DEBUG_HEADER);
                        if (headerFieldAsString != null) {
                            TapjoyLog.v(TJCorePlacement.a, "Tapjoy-Server-Debug: " + headerFieldAsString);
                        }
                        if (responseFromURL.expires > 0) {
                            b = responseFromURL.expires - (responseFromURL.date > 0 ? responseFromURL.date : y.b());
                            if (b > 0) {
                                this.f.e = b + SystemClock.elapsedRealtime();
                            }
                        } else {
                            this.f.e = 0;
                        }
                        if (cr.c(responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_MEDIATION_HEADER))) {
                            if (!(responseFromURL == null || a.getListener() == null)) {
                                switch (responseFromURL.statusCode) {
                                    case 0:
                                        if (egVar.a(c.e)) {
                                            fa.b("TJPlacement.requestContent").a("network error").a("retry_timeout", Long.valueOf(egVar.b)).c();
                                            this.f.a(a, ErrorType.NETWORK_ERROR, new TJError(responseFromURL.statusCode, responseFromURL.response));
                                            break;
                                        }
                                        fd fdVar = c;
                                        long j = fdVar.e;
                                        b = (long) (((double) fdVar.e) * fdVar.d);
                                        if (b < fdVar.b) {
                                            b = fdVar.b;
                                        } else if (b > fdVar.c) {
                                            b = fdVar.c;
                                        }
                                        fdVar.e = b;
                                        if (j > 0) {
                                            synchronized (fdVar) {
                                                try {
                                                    fdVar.wait(j);
                                                } catch (InterruptedException e) {
                                                }
                                            }
                                        }
                                        return false;
                                    case 200:
                                        headerFieldAsString = responseFromURL.getHeaderFieldAsString("Content-Type");
                                        if (!cr.c(headerFieldAsString) && headerFieldAsString.contains("json")) {
                                            if (!responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_DISABLE_PRELOAD_HEADER).equals("1")) {
                                                if (!this.f.b(responseFromURL.response)) {
                                                    fa.b("TJPlacement.requestContent").a("asset error").c();
                                                    this.f.a(a, ErrorType.SERVER_ERROR, new TJError(responseFromURL.statusCode, responseFromURL.response));
                                                    break;
                                                }
                                                fa.b("TJPlacement.requestContent").a("content_type", (Object) "mm").c();
                                                this.f.j();
                                                this.f.d();
                                                break;
                                            }
                                            try {
                                                TJCorePlacement.a(this.f, responseFromURL.response);
                                                fa.b("TJPlacement.requestContent").a("content_type", (Object) "ad").c();
                                                this.f.j();
                                                this.f.d();
                                                break;
                                            } catch (TapjoyException e2) {
                                                headerFieldAsString = e2.getMessage() + " for placement " + this.f.c.getPlacementName();
                                                fa.b("TJPlacement.requestContent").a("server error").c();
                                                this.f.a(a, ErrorType.SERVER_ERROR, new TJError(responseFromURL.statusCode, headerFieldAsString));
                                                break;
                                            }
                                        }
                                        fa.b("TJPlacement.requestContent").a("content_type", (Object) "ad").c();
                                        this.f.j();
                                        TJCorePlacement tJCorePlacement2 = this.f;
                                        TJCacheListener anonymousClass1 = new TJCacheListener(this) {
                                            final /* synthetic */ AnonymousClass6 a;

                                            {
                                                this.a = r1;
                                            }

                                            public final void onCachingComplete(int status) {
                                                this.a.f.t = this.a.f.getAdUnit().preload(this.a.f.c);
                                            }
                                        };
                                        TapjoyLog.i(TJCorePlacement.a, "Checking if there is content to cache for placement " + tJCorePlacement2.c.getPlacementName());
                                        String headerFieldAsString2 = responseFromURL.getHeaderFieldAsString(TapjoyConstants.TAPJOY_CACHE_HEADER);
                                        try {
                                            if (!TJPlacementManager.canCachePlacement()) {
                                                TapjoyLog.i(TJCorePlacement.a, "Placement caching limit reached. No content will be cached for placement " + tJCorePlacement2.c.getPlacementName());
                                                anonymousClass1.onCachingComplete(2);
                                                break;
                                            }
                                            JSONArray jSONArray = new JSONArray(headerFieldAsString2);
                                            if (jSONArray.length() <= 0) {
                                                anonymousClass1.onCachingComplete(1);
                                                break;
                                            }
                                            TapjoyLog.i(TJCorePlacement.a, "Begin caching content for placement " + tJCorePlacement2.c.getPlacementName());
                                            TJPlacementManager.incrementPlacementCacheCount();
                                            tJCorePlacement2.g = true;
                                            TapjoyCache.getInstance().cacheAssetGroup(jSONArray, new AnonymousClass9(tJCorePlacement2, anonymousClass1));
                                            break;
                                        } catch (JSONException e3) {
                                            anonymousClass1.onCachingComplete(2);
                                            break;
                                        }
                                        break;
                                    default:
                                        fa.b("TJPlacement.requestContent").a("content_type", (Object) "none").a("code", Integer.valueOf(responseFromURL.statusCode)).c();
                                        this.f.a(a);
                                        break;
                                }
                            }
                        }
                        try {
                            this.f.w = new TJMediatedPlacementData(this.f.c.getHttpResponse());
                            TJCorePlacement.j(this.f);
                        } catch (TapjoyException e22) {
                            headerFieldAsString = e22.getMessage() + " for placement " + this.f.c.getPlacementName();
                            fa.b("TJPlacement.requestContent").a("mediation error").c();
                            this.f.a(a, ErrorType.SDK_ERROR, new TJError(this.f.c.getHttpStatusCode(), headerFieldAsString));
                        }
                        this.f.v = false;
                        return true;
                    }
                }.start();
            }
        }
    }

    final String b() {
        String str = this.o;
        if (str != null) {
            return str;
        }
        return this.initiatedBySdk ? "sdk" : "app";
    }

    private void h() {
        this.x.removeCallbacks(this.y);
    }

    private void i() {
        TapjoyLog.i(a, "Custom placement call failed, retrying Tapjoy request");
        if (this.w == null) {
            throw new TapjoyException("Mediation data is null");
        }
        JSONObject nextCall = this.w.getNextCall();
        this.l = null;
        this.w = null;
        try {
            a(this.c.getUrl(), TapjoyUtil.jsonToStringMap(nextCall), false);
        } catch (JSONException e) {
            TapjoyLog.i(a, "Failed to load next call parameters for mediated placement " + this.c.getPlacementName());
            throw new TapjoyException("TJPlacement request failed due to custom placement fallback failure");
        }
    }

    private boolean b(String str) {
        try {
            gz.a aVar = (gz.a) this.u.a(URI.create(this.c.getUrl()), new ByteArrayInputStream(str.getBytes()));
            this.h = aVar.a;
            aVar.a.a();
            if (aVar.a.b()) {
                return true;
            }
            TapjoyLog.e(a, "Failed to load fiverocks placement");
            return false;
        } catch (IOException e) {
            TapjoyLog.e(a, e.toString());
            e.printStackTrace();
            return false;
        } catch (cf e2) {
            TapjoyLog.e(a, e2.toString());
            e2.printStackTrace();
            return false;
        }
    }

    public Context getContext() {
        return this.b;
    }

    public void setContext(Context activityContext) {
        this.b = activityContext;
    }

    public TJAdUnit getAdUnit() {
        return this.s;
    }

    public TJPlacementData getPlacementData() {
        return this.c;
    }

    public boolean isContentReady() {
        return this.k;
    }

    public boolean isContentAvailable() {
        return this.j;
    }

    public String getPlacementContentUrl() {
        String appID = TapjoyConnectCore.getAppID();
        if (cr.c(appID)) {
            return "";
        }
        return TapjoyConnectCore.getPlacementURL() + "v1/apps/" + appID + "/content?";
    }

    final String c() {
        TJMediatedPlacementData tJMediatedPlacementData = this.w;
        if (this.l != null && tJMediatedPlacementData != null) {
            return tJMediatedPlacementData.getName();
        }
        if (this.h != null) {
            return "mm";
        }
        if (this.j) {
            return "ad";
        }
        return "none";
    }

    final void a(String str, TJPlacement tJPlacement) {
        synchronized (this.q) {
            this.q.put(str, tJPlacement);
            if (tJPlacement != null) {
                TapjoyLog.d(a, "Setting " + str + " placement: " + tJPlacement.getGUID());
            }
        }
    }

    final TJPlacement a(String str) {
        TJPlacement tJPlacement;
        synchronized (this.q) {
            tJPlacement = (TJPlacement) this.q.get(str);
            if (tJPlacement != null) {
                TapjoyLog.d(a, "Returning " + str + " placement: " + tJPlacement.getGUID());
            }
        }
        return tJPlacement;
    }

    private void j() {
        this.j = true;
        a(a("REQUEST"));
    }

    final void a(TJPlacement tJPlacement) {
        eq eqVar = this.f;
        Object placementName = this.c.getPlacementName();
        Object b = b();
        Object c = c();
        eqVar.b = 0;
        eqVar.a = fa.e("PlacementContent.funnel").a().a("placement", placementName).a("placement_type", b).a("content_type", c).a("state", Integer.valueOf(eqVar.b));
        eqVar.a.c();
        if (!"none".equals(c)) {
            eqVar.d = fa.e("PlacementContent.ready").a().a("placement", placementName).a("placement_type", b).a("content_type", c);
        }
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            TapjoyLog.i(a, "Content request delivered successfully for placement " + this.c.getPlacementName() + ", contentAvailable: " + isContentAvailable() + ", mediationAgent: " + this.o);
            tJPlacement.getListener().onRequestSuccess(tJPlacement);
        }
    }

    final void a(ErrorType errorType, TJError tJError) {
        a(a("REQUEST"), errorType, tJError);
    }

    final void a(TJPlacement tJPlacement, ErrorType errorType, TJError tJError) {
        TapjoyLog.e(a, new TapjoyErrorMessage(errorType, "Content request failed for placement " + this.c.getPlacementName() + "; Reason= " + tJError.message));
        if (tJPlacement != null && tJPlacement.getListener() != null) {
            tJPlacement.getListener().onRequestFailure(tJPlacement, tJError);
        }
    }

    final void d() {
        if (!this.i) {
            this.k = true;
            TapjoyLog.i(a, "Content is ready for placement " + this.c.getPlacementName());
            eq eqVar = this.f;
            a aVar = eqVar.d;
            if (aVar != null) {
                eqVar.d = null;
                aVar.b().c();
            }
            TJPlacement a = a("REQUEST");
            if (a != null && a.getListener() != null) {
                a.getListener().onContentReady(a);
                this.i = true;
            }
        }
    }

    final void e() {
        TJPlacement a = a("SHOW");
        if (a != null && a.getListener() != null) {
            TapjoyLog.i(a, "Content dismissed for placement " + this.c.getPlacementName());
            if (a != null && a.a != null) {
                a.a.onContentDismiss(a);
            }
        }
    }

    final void f() {
        TapjoyLog.i(a, "Content shown for placement " + this.c.getPlacementName());
        this.f.a();
        TJPlacement a = a("SHOW");
        if (a != null && a.getListener() != null) {
            a.getListener().onContentShow(a);
        }
    }

    public void onCustomPlacementLoad() {
        if (this.l != null) {
            h();
            this.j = true;
            if (!(this.w == null || this.w.getFillURL() == null)) {
                final String fillURL = this.w.getFillURL();
                new Thread(this) {
                    final /* synthetic */ TJCorePlacement b;

                    public final void run() {
                        TapjoyLog.d(TJCorePlacement.a, "onCustomPlacementLoad -- fillUrl=" + fillURL);
                        new TapjoyURLConnection().getResponseFromURL(fillURL);
                    }
                }.start();
            }
            fa.b("TJPlacement.requestContent").a("content_type", c()).c();
            j();
            d();
        }
    }

    public void onCustomPlacementFailure(Error error) {
        if (this.l != null) {
            h();
            try {
                if (!(this.w == null || this.w.getNoFillURL() == null)) {
                    final String noFillURL = this.w.getNoFillURL();
                    new Thread(this) {
                        final /* synthetic */ TJCorePlacement b;

                        public final void run() {
                            TapjoyLog.d(TJCorePlacement.a, "onCustomPlacementFailure -- noFillUrl=" + noFillURL);
                            new TapjoyURLConnection().getResponseFromURL(noFillURL);
                        }
                    }.start();
                }
                i();
            } catch (TapjoyException e) {
                a(ErrorType.SERVER_ERROR, new TJError(TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL, e.getMessage() + " for placement " + this.c.getPlacementName()));
            }
        }
    }

    public void onCustomPlacementContentShown() {
        f();
    }

    public void onCustomPlacementContentDismiss() {
        this.l = null;
        this.w = null;
        e();
    }

    public void onCustomPlacementReward(final String type, int amount) {
        TJPlacement a = a("SHOW");
        if (a != null && a.getListener() != null) {
            a.getListener().onRewardRequest(a, new TJActionRequest(this) {
                final /* synthetic */ TJCorePlacement b;

                public final String getRequestId() {
                    return type;
                }

                public final String getToken() {
                    return null;
                }

                public final void completed() {
                }

                public final void cancelled() {
                }
            }, type, amount);
        }
    }

    static /* synthetic */ void j(TJCorePlacement tJCorePlacement) {
        try {
            Class cls = Class.forName(tJCorePlacement.w.getClassname());
            if (TJCustomPlacement.class.isAssignableFrom(cls)) {
                tJCorePlacement.l = (TJCustomPlacement) cls.getConstructor(new Class[0]).newInstance(new Object[0]);
                if (tJCorePlacement.x == null) {
                    tJCorePlacement.x = new Handler(Looper.getMainLooper());
                }
                tJCorePlacement.x.postDelayed(tJCorePlacement.y, TJMediationSettings.getInstance().getTimeout());
                final a d = fa.d("TJPlacement.requestContent");
                tJCorePlacement.l.requestContentWithCustomPlacementParams(tJCorePlacement.b, new TJCustomPlacementListener(tJCorePlacement) {
                    final /* synthetic */ TJCorePlacement b;

                    public final void onCustomPlacementLoad() {
                        fa.a("TJPlacement.requestContent", d);
                        this.b.onCustomPlacementLoad();
                    }

                    public final void onCustomPlacementFailure(Error error) {
                        fa.a("TJPlacement.requestContent", d);
                        this.b.onCustomPlacementFailure(error);
                    }

                    public final void onCustomPlacementContentShown() {
                        this.b.onCustomPlacementContentShown();
                    }

                    public final void onCustomPlacementContentDismiss() {
                        this.b.onCustomPlacementContentDismiss();
                    }

                    public final void onCustomPlacementReward(String type, int amount) {
                        this.b.onCustomPlacementReward(type, amount);
                    }
                }, tJCorePlacement.w.getExtras());
                return;
            }
            TapjoyLog.e(a, tJCorePlacement.w.getClassname() + " does not implement TJCustomPlacement.");
            tJCorePlacement.i();
        } catch (Exception e) {
            TapjoyLog.e(a, new TapjoyErrorMessage(ErrorType.SDK_ERROR, "Failed to load custom class " + tJCorePlacement.w.getClassname() + " for placement " + tJCorePlacement.c.getPlacementName()));
            tJCorePlacement.i();
        }
    }

    static /* synthetic */ void a(TJCorePlacement tJCorePlacement, String str) {
        if (str != null) {
            try {
                TapjoyLog.d(a, "Disable preload flag is set for placement " + tJCorePlacement.c.getPlacementName());
                tJCorePlacement.c.setRedirectURL(new JSONObject(str).getString(TapjoyConstants.TJC_REDIRECT_URL));
                tJCorePlacement.c.setPreloadDisabled(true);
                tJCorePlacement.c.setHasProgressSpinner(true);
                TapjoyLog.d(a, "redirect_url:" + tJCorePlacement.c.getRedirectURL());
                return;
            } catch (JSONException e) {
                throw new TapjoyException("TJPlacement request failed, malformed server response");
            }
        }
        throw new TapjoyException("TJPlacement request failed due to null response");
    }
}
