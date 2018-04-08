package com.tapjoy;

import com.tapjoy.internal.bd;
import com.tapjoy.internal.fg;
import com.tapjoy.internal.fh;
import com.tapjoy.internal.fi;
import com.tapjoy.internal.fj;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.fv;
import java.util.Hashtable;

public class FiveRocksIntegration {
    private static bd a = new bd();

    public static void a(Hashtable hashtable) {
        if (hashtable != null) {
            String valueOf = String.valueOf(hashtable.get(TapjoyConnectFlag.ENABLE_LOGGING));
            if (valueOf != null && valueOf.equalsIgnoreCase("true")) {
                fi.a(true);
            }
        }
        fu a = fu.a();
        if (!a.c) {
            a.c = true;
        }
        fj anonymousClass1 = new fj() {
            public final void a(String str) {
            }

            public final void b(String str) {
                synchronized (FiveRocksIntegration.a) {
                    TJPlacement tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                }
                if (tJPlacement != null && tJPlacement.a != null) {
                    tJPlacement.a.onContentReady(tJPlacement);
                }
            }

            public final void c(String str) {
                synchronized (FiveRocksIntegration.a) {
                    TJPlacement tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                }
                if (tJPlacement != null && tJPlacement.a != null) {
                    tJPlacement.a.onContentShow(tJPlacement);
                }
            }

            public final void d(String str) {
            }

            public final void a(String str, fg fgVar) {
                if (fgVar != null) {
                    fgVar.a(e(str));
                }
            }

            public final void a(String str, String str2, fg fgVar) {
                if (fgVar != null) {
                    fgVar.a(e(str));
                }
                synchronized (FiveRocksIntegration.a) {
                    TJPlacement tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                }
                if (tJPlacement != null) {
                    TapjoyConnectCore.viewDidClose(str2);
                    if (tJPlacement.a != null) {
                        tJPlacement.a.onContentDismiss(tJPlacement);
                    }
                }
            }

            private fh e(final String str) {
                return new fh(this) {
                    final /* synthetic */ AnonymousClass1 b;

                    public final void a(final String str, String str2) {
                        synchronized (FiveRocksIntegration.a) {
                            TJPlacement tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                        }
                        if (tJPlacement != null && tJPlacement.a != null) {
                            tJPlacement.a.onPurchaseRequest(tJPlacement, new TJActionRequest(this) {
                                final /* synthetic */ AnonymousClass1 b;

                                public final String getRequestId() {
                                    return str;
                                }

                                public final String getToken() {
                                    return null;
                                }

                                public final void completed() {
                                }

                                public final void cancelled() {
                                }
                            }, str2);
                        }
                    }

                    public final void a(final String str, String str2, int i, final String str3) {
                        synchronized (FiveRocksIntegration.a) {
                            TJPlacement tJPlacement = (TJPlacement) FiveRocksIntegration.a.get(str);
                        }
                        if (tJPlacement != null && tJPlacement.a != null) {
                            tJPlacement.a.onRewardRequest(tJPlacement, new TJActionRequest(this) {
                                final /* synthetic */ AnonymousClass1 c;

                                public final String getRequestId() {
                                    return str;
                                }

                                public final String getToken() {
                                    return str3;
                                }

                                public final void completed() {
                                }

                                public final void cancelled() {
                                }
                            }, str2, i);
                        }
                    }
                };
            }
        };
        fu.a().p = fv.a(anonymousClass1);
    }

    public static void addPlacementCallback(String placement, TJPlacement p) {
        synchronized (a) {
            a.put(placement, p);
        }
    }
}
