package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.internal.fe.a;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

public final class eu {
    private static final eu b;
    private static eu c;
    public final es a = new es();
    private Context d;

    static {
        eu euVar = new eu();
        b = euVar;
        c = euVar;
    }

    public static eu a() {
        return c;
    }

    public static es b() {
        return c.a;
    }

    eu() {
    }

    public final synchronized void a(Context context) {
        if (context != null) {
            if (this.d == null) {
                this.d = context;
                SharedPreferences c = c();
                String string = c().getString(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS, null);
                if (string != null) {
                    br b;
                    try {
                        b = br.b(string);
                        Map d = b.d();
                        b.close();
                        this.a.a(d);
                    } catch (Exception e) {
                        c.edit().remove(TapjoyConstants.PREF_SERVER_PROVIDED_CONFIGURATIONS).commit();
                    } catch (Throwable th) {
                        b.close();
                    }
                }
                Observer anonymousClass1 = new Observer(this) {
                    final /* synthetic */ eu a;

                    {
                        this.a = r1;
                    }

                    public final void update(Observable observable, Object data) {
                        Object a;
                        fa.a(this.a.a.a("usage_tracking_enabled", false));
                        String str = "usage_tracking_exclude";
                        Class cls = List.class;
                        for (a a2 : this.a.a.b) {
                            a = a2.a(str);
                            if (a != null && cls.isInstance(a)) {
                                a = cls.cast(a);
                                break;
                            }
                        }
                        a = null;
                        fa.a((Collection) a);
                    }
                };
                this.a.addObserver(anonymousClass1);
                anonymousClass1.update(this.a, null);
            }
        }
    }

    public final SharedPreferences c() {
        return this.d.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);
    }
}
