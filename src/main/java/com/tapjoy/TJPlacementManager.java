package com.tapjoy;

import android.content.Context;
import android.os.Looper;
import com.tapjoy.internal.bd;
import com.tapjoy.internal.cr;
import com.tapjoy.internal.fq;
import com.tapjoy.internal.fq.AnonymousClass1;
import com.tapjoy.internal.fz;
import com.tapjoy.internal.x;

public class TJPlacementManager {
    private static final bd a = bd.a();
    private static int b = 0;
    private static int c = 0;
    private static int d = 3;
    private static int e = 3;

    public static TJPlacement createPlacement(Context context, String placementName, boolean initiatedBySdk, TJPlacementListener listener) {
        TJCorePlacement a = a(placementName, null, null, initiatedBySdk);
        a.initiatedBySdk = initiatedBySdk;
        a.setContext(context);
        return new TJPlacement(a, listener);
    }

    public static TJPlacement a(String str, String str2, String str3, TJPlacementListener tJPlacementListener) {
        TJPlacement tJPlacement;
        synchronized (a) {
            tJPlacement = new TJPlacement(a(str, str2, str3, false), tJPlacementListener);
        }
        return tJPlacement;
    }

    static TJCorePlacement a(String str) {
        TJCorePlacement tJCorePlacement;
        synchronized (a) {
            tJCorePlacement = (TJCorePlacement) a.get(str);
        }
        return tJCorePlacement;
    }

    public static void setCachedPlacementLimit(int limit) {
        d = limit;
    }

    public static void setPreRenderedPlacementLimit(int limit) {
        e = limit;
    }

    public static int getCachedPlacementLimit() {
        return d;
    }

    public static int getPreRenderedPlacementLimit() {
        return e;
    }

    public static int getCachedPlacementCount() {
        return b;
    }

    public static int getPreRenderedPlacementCount() {
        return c;
    }

    public static boolean canCachePlacement() {
        return getCachedPlacementCount() < getCachedPlacementLimit();
    }

    public static boolean canPreRenderPlacement() {
        return getPreRenderedPlacementCount() < getPreRenderedPlacementLimit();
    }

    public static void incrementPlacementCacheCount() {
        int i = b + 1;
        b = i;
        if (i > d) {
            b = d;
        }
        printPlacementCacheInformation();
    }

    public static void decrementPlacementCacheCount() {
        int i = b - 1;
        b = i;
        if (i < 0) {
            b = 0;
        }
        printPlacementCacheInformation();
    }

    public static void incrementPlacementPreRenderCount() {
        int i = c + 1;
        c = i;
        if (i > e) {
            c = e;
        }
    }

    public static void decrementPlacementPreRenderCount() {
        int i = c - 1;
        c = i;
        if (i < 0) {
            c = 0;
        }
    }

    public static void printPlacementCacheInformation() {
        TapjoyLog.i("TJPlacementManager", "Space available in placement cache: " + b + " out of " + d);
    }

    public static void printPlacementPreRenderInformation() {
        TapjoyLog.i("TJPlacementManager", "Space available for placement pre-render: " + c + " out of " + e);
    }

    public static void dismissContentShowing(boolean dismissAd) {
        if (dismissAd) {
            TJAdUnitActivity.a();
        }
        fz fzVar = fz.a;
        if (fzVar != null) {
            fzVar.c();
        }
        fq fqVar = fq.a;
        if (fqVar != null) {
            Object obj;
            Runnable anonymousClass1 = new AnonymousClass1(fqVar);
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper == null || mainLooper.getThread() != Thread.currentThread()) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                anonymousClass1.run();
            } else {
                x.a().post(anonymousClass1);
            }
        }
    }

    static TJCorePlacement a(String str, String str2, String str3, boolean z) {
        TJCorePlacement a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(z ? "!SYSTEM!" : "");
        stringBuilder.append(!cr.c(str) ? str : "");
        if (cr.c(str2)) {
            str2 = "";
        }
        stringBuilder.append(str2);
        if (cr.c(str3)) {
            str3 = "";
        }
        stringBuilder.append(str3);
        String stringBuilder2 = stringBuilder.toString();
        TapjoyLog.d("TJPlacementManager", "TJCorePlacement key=" + stringBuilder2);
        synchronized (a) {
            a = a(stringBuilder2);
            if (a == null) {
                a = new TJCorePlacement(str, stringBuilder2);
                a.put(stringBuilder2, a);
                TapjoyLog.d("TJPlacementManager", "Created TJCorePlacement with GUID: " + a.d);
            }
        }
        return a;
    }
}
