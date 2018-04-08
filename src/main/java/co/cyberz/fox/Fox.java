package co.cyberz.fox;

import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebView;
import co.cyberz.fox.service.FoxEvent;
import co.cyberz.fox.service.b;
import co.cyberz.fox.service.c;
import co.cyberz.fox.service.c.AnonymousClass2;
import co.cyberz.fox.service.f;
import co.cyberz.fox.service.g;
import co.cyberz.fox.service.i;
import co.cyberz.util.f.a;
import co.cyberz.util.string.StringUtil;
import java.io.IOException;
import java.net.UnknownHostException;
import org.json.JSONObject;

public class Fox {
    public static JSONObject getUserInfo() {
        try {
            return a.a().a.b;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean isConversionCompleted() {
        try {
            return a.a().e();
        } catch (Throwable th) {
            return false;
        }
    }

    public static void setUserInfo(JSONObject jSONObject) {
        try {
            a.a().a.b = jSONObject;
        } catch (Throwable th) {
        }
    }

    public static void trackDeeplinkLaunch(Activity activity) {
        trackDeeplinkLaunch(activity, null);
    }

    public static void trackDeeplinkLaunch(Activity activity, String str) {
        if (activity != null) {
            try {
                a.a().d = activity.getApplicationContext();
                trackDeeplinkLaunch(activity.getIntent(), str);
            } catch (Throwable th) {
            }
        }
    }

    public static void trackDeeplinkLaunch(Intent intent) {
        trackDeeplinkLaunch(intent, null);
    }

    public static void trackDeeplinkLaunch(Intent intent, String str) {
        Object obj = null;
        try {
            a.a().c();
            a a = a.a();
            g gVar = new g(intent, str);
            if (gVar.b == null) {
                a.c("Context must be not null");
            } else if (gVar.a == null) {
                a.c("Intent must be not null");
            } else if (!(gVar.c == null || gVar.d == null)) {
                obj = 1;
            }
            if (obj != null) {
                if (a.c == null) {
                    a.c("FoxConfig is not activation yet");
                    gVar.b();
                }
                gVar.a((Object[]) new Void[0]);
            }
            a a2 = a.a();
            if (i.b(a2.d)) {
                b.b(a2.d);
                b.a(a2.d);
            }
        } catch (Throwable th) {
        }
    }

    public static void trackEvent(FoxEvent foxEvent) {
        try {
            a a = a.a();
            if (foxEvent == null) {
                a.c("FoxEvent must be not null.");
            } else if (a.c == null) {
                a.c("FoxConfig is not activation yet.");
            } else {
                c cVar = a.a;
                if (foxEvent.ltvPointId > 0) {
                    f fVar = new f(foxEvent);
                    if (0.0d >= fVar.a.price || fVar.a.quantity > 0) {
                        co.cyberz.common.a.a.a(new Runnable(fVar) {
                            final /* synthetic */ f a;

                            {
                                this.a = r1;
                            }

                            public final void run() {
                                try {
                                    new co.cyberz.fox.a.f(this.a.a, this.a.a.xtid).i();
                                } catch (UnknownHostException e) {
                                    co.cyberz.util.f.a.c("Could not connect to the network. Please check the network state of this device.");
                                } catch (co.cyberz.util.b.a e2) {
                                } catch (IOException e3) {
                                }
                            }
                        });
                    } else {
                        throw new co.cyberz.util.b.a("Quantity is incorrect.");
                    }
                }
                if (!StringUtil.isEmpty(foxEvent.eventName)) {
                    co.cyberz.common.a.a.a(new AnonymousClass2(cVar, foxEvent));
                }
            }
        } catch (co.cyberz.util.b.a e) {
            a.c("Parameter is incorrect");
        } catch (Exception e2) {
        } catch (Throwable th) {
        }
    }

    public static void trackEventByBrowser(String str) {
        try {
            a.a().a(str);
        } catch (Throwable th) {
        }
    }

    public static void trackEventByWebView(WebView webView) {
        try {
            CookieManager instance = CookieManager.getInstance();
            instance.setAcceptCookie(true);
            if (VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(a.a().d);
                CookieSyncManager.getInstance().startSync();
                instance.removeExpiredCookie();
            } else {
                instance.setAcceptThirdPartyCookies(webView, true);
            }
            a.a().d();
        } catch (Throwable th) {
        }
    }

    public static void trackInstall() {
        try {
            trackInstall(new FoxTrackOption());
        } catch (Throwable th) {
        }
    }

    public static void trackInstall(FoxTrackOption foxTrackOption) {
        try {
            a.a().a(foxTrackOption);
        } catch (Throwable th) {
        }
    }

    public static void trackSession() {
        try {
            a a = a.a();
            if (a.c == null) {
                a.c("FoxConfig is not activation yet");
            } else {
                co.cyberz.common.a.a.a(new Runnable(a.a) {
                    final /* synthetic */ c a;

                    {
                        this.a = r1;
                    }

                    public final void run() {
                        co.cyberz.fox.b.a aVar = new co.cyberz.fox.b.a();
                        aVar.r = this.a.d;
                        aVar.s = this.a.e;
                        aVar.b = co.cyberz.fox.b.a.a.a;
                        aVar.u = this.a.b;
                        this.a.a(aVar);
                    }
                });
            }
        } catch (Exception e) {
        } catch (Throwable th) {
        }
    }
}
