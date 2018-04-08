package co.cyberz.fox.service;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import co.cyberz.common.a.a;
import co.cyberz.fox.FoxTrackOption.DeeplinkHandler;
import co.cyberz.fox.a.d;
import co.cyberz.util.string.StringUtil;
import com.google.android.gms.nearby.messages.Strategy;
import org.json.JSONObject;

public final class b extends a<Void, JSONObject> {
    private static boolean d = false;
    private static DeeplinkHandler e;
    private Context a;
    private co.cyberz.fox.b.b b;
    private final int c = Strategy.TTL_SECONDS_DEFAULT;

    public b(Context context, co.cyberz.fox.b.b bVar, DeeplinkHandler deeplinkHandler) {
        this.a = context;
        this.b = bVar;
        e = deeplinkHandler;
    }

    private static JSONObject a(int i) {
        if (e == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis() + ((long) (i * 1000));
        d dVar = new d(e.getDuration());
        JSONObject jSONObject = null;
        while (System.currentTimeMillis() < currentTimeMillis) {
            try {
                JSONObject jSONObject2 = (JSONObject) dVar.i();
                if (jSONObject2 != null && !StringUtil.isEmpty(jSONObject2.optString("deeplink", null))) {
                    return jSONObject2;
                }
                try {
                    Thread.sleep(300);
                    jSONObject = jSONObject2;
                } catch (InterruptedException e) {
                    jSONObject = jSONObject2;
                }
            } catch (Exception e2) {
                if (jSONObject != null && !StringUtil.isEmpty(jSONObject.optString("deeplink", null))) {
                    return jSONObject;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e3) {
                }
            } catch (Throwable th) {
                if (jSONObject != null && !StringUtil.isEmpty(jSONObject.optString("deeplink", null))) {
                    return jSONObject;
                }
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e4) {
                }
            }
        }
        new StringBuilder("doInBackground Received DLL : ").append(jSONObject);
        return jSONObject;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Context r4) {
        /*
        r1 = 0;
        r0 = "co.cyberz.fox";
        r2 = 0;
        r0 = r4.getSharedPreferences(r0, r2);
        r2 = "deeplink";
        r3 = "";
        r2 = r0.getString(r2, r3);
        r0 = co.cyberz.util.string.StringUtil.isEmpty(r2);	 Catch:{ JSONException -> 0x001f, all -> 0x0024 }
        if (r0 != 0) goto L_0x0029;
    L_0x0016:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x001f, all -> 0x0024 }
        r0.<init>(r2);	 Catch:{ JSONException -> 0x001f, all -> 0x0024 }
    L_0x001b:
        b(r4, r0);
    L_0x001e:
        return;
    L_0x001f:
        r0 = move-exception;
        b(r4, r1);
        goto L_0x001e;
    L_0x0024:
        r0 = move-exception;
        b(r4, r1);
        throw r0;
    L_0x0029:
        r0 = r1;
        goto L_0x001b;
        */
        throw new UnsupportedOperationException("Method not decompiled: co.cyberz.fox.service.b.a(android.content.Context):void");
    }

    public static void b(Context context) {
        context.getSharedPreferences("co.cyberz.fox", 0).edit().putBoolean("receive_dl_delay", true).commit();
    }

    private static void b(Context context, JSONObject jSONObject) {
        if (!d) {
            context.getSharedPreferences("co.cyberz.fox", 0).edit().putBoolean("receive_dl_delay", false).commit();
            if (e != null) {
                e.onReceived(context, jSONObject);
            }
            context.getSharedPreferences("co.cyberz.fox", 0).edit().remove("deeplink").commit();
            e = null;
        }
    }

    private static boolean c(Context context) {
        return context.getSharedPreferences("co.cyberz.fox", 0).getBoolean("receive_dl_delay", false);
    }

    protected final /* synthetic */ void a(@Nullable Object obj) {
        final JSONObject jSONObject = (JSONObject) obj;
        d = false;
        new StringBuilder("Received DLL : ").append(jSONObject == null ? "" : jSONObject.toString()).append(" returned app : ").append(c(this.a));
        if (!this.b.a || c(this.a)) {
            new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                final /* synthetic */ b b;

                public final void run() {
                    b.b(this.b.a, jSONObject);
                }
            });
        } else if (jSONObject != null) {
            this.a.getSharedPreferences("co.cyberz.fox", 0).edit().putString("deeplink", jSONObject.toString()).commit();
        }
    }

    protected final /* synthetic */ Object b(Object[] objArr) {
        d = true;
        return a(this.b.c > 0 ? this.b.c : 10);
    }
}
