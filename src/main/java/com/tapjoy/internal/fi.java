package com.tapjoy.internal;

import android.app.Activity;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

public final class fi {
    public static void a(boolean z) {
        Object obj;
        fu a = fu.a();
        if (fr.a != z) {
            fr.a = z;
            if (z) {
                fr.a("The debug mode has been enabled");
            } else {
                fr.a("The debug mode has been disabled");
            }
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null && z && a.k) {
            a.i.a();
        }
    }

    public static void a(Activity activity) {
        fu a = fu.a();
        if (fr.a((Object) activity, "onActivityStart: The given activity was null")) {
            fr.c("onActivityStart");
            d.a(activity.getApplication());
            d.b(activity);
            if (a.b("onActivityStart") && a.e()) {
                fo.b(activity);
            }
        }
    }

    public static void b(Activity activity) {
        fu a = fu.a();
        if (fr.a((Object) activity, "onActivityStop: The given activity was null")) {
            fr.c("onActivityStop");
            d.c(activity);
            if (a.b("onActivityStop") && !d.b()) {
                a.h.a();
            }
        }
    }

    public static void a() {
        fu a = fu.a();
        if (a.b("startSession") && a.e()) {
            fo.b(null);
        }
    }

    public static void b() {
        fu a = fu.a();
        if (a.b("endSession")) {
            a.h.a();
        }
    }

    public static void a(String str, String str2, String str3, String str4, long j) {
        fu a = fu.a();
        if (a.c("trackEvent") && fr.a((Object) str2, "trackEvent: name was null")) {
            Map map = null;
            if (j != 0) {
                map = cv.b();
                map.put("value", Long.valueOf(j));
            }
            a.g.a(str, str2, str3, str4, map);
            fr.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, map);
        }
    }

    public static void a(String str, String str2, String str3, String str4, String str5, long j, String str6, long j2, String str7, long j3) {
        fu a = fu.a();
        if (a.c("trackEvent") && fr.a((Object) str2, "trackEvent: name was null")) {
            Map b = cv.b();
            if (!(str5 == null || j == 0)) {
                b.put(str5, Long.valueOf(j));
            }
            if (!(str6 == null || j2 == 0)) {
                b.put(str6, Long.valueOf(j2));
            }
            if (!(str7 == null || j3 == 0)) {
                b.put(str7, Long.valueOf(j3));
            }
            if (b.isEmpty()) {
                b = null;
            }
            a.g.a(str, str2, str3, str4, b);
            fr.a("trackEvent category:{}, name:{}, p1:{}, p2:{}, values:{} called", str, str2, str3, str4, b);
        }
    }

    public static void a(String str, String str2, String str3, String str4) {
        fu a = fu.a();
        if (a.b("trackPurchase")) {
            try {
                g gVar = new g(str);
                String b = fp.b(gVar.a);
                String b2 = fp.b(gVar.f);
                if (b == null || b2 == null) {
                    fr.a("trackPurchase", "skuDetails", "insufficient fields");
                } else if (b2.length() != 3) {
                    fr.a("trackPurchase", "skuDetails", "invalid currency code");
                } else {
                    String b3 = fp.b(str2);
                    String b4 = fp.b(str3);
                    if (b3 != null) {
                        if (b4 != null) {
                            try {
                                h hVar = new h(b3);
                                if (cr.c(hVar.a) || cr.c(hVar.b) || cr.c(hVar.c) || hVar.d == 0) {
                                    fr.a("trackPurchase", "purchaseData", "insufficient fields");
                                }
                            } catch (IOException e) {
                                fr.a("trackPurchase", "purchaseData", "invalid PurchaseData JSON");
                            }
                        } else {
                            fr.a("trackPurchase", "dataSignature", "is null, skipping purchase validation");
                        }
                    } else if (b4 != null) {
                        fr.a("trackPurchase", "purchaseData", "is null. skipping purchase validation");
                    }
                    a.g.a(b, b2.toUpperCase(Locale.US), ((double) gVar.g) / 1000000.0d, b3, b4, fp.b(str4));
                    if (b3 == null || b4 == null) {
                        fr.a("trackPurchase without purchaseData called");
                    } else {
                        fr.a("trackPurchase with purchaseData called");
                    }
                }
            } catch (IOException e2) {
                fr.a("trackPurchase", "skuDetails", "invalid SkuDetails JSON");
            }
        }
    }
}
