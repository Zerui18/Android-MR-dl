package com.smrtbeat;

import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.moat.analytics.mobile.tjy.MoatAdEvent;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Map.Entry;
import org.json.JSONException;
import org.json.JSONObject;

class ac {
    ac() {
    }

    static JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, MoatAdEvent.EVENT_TYPE, "ping");
        a(jSONObject2, "userId", g.K);
        a(jSONObject2, "occuredAt", String.valueOf(System.currentTimeMillis()));
        a(jSONObject, "request", jSONObject2);
        a(jSONObject, "environment", c());
        a(jSONObject, "sdk", d());
        return jSONObject;
    }

    private static JSONObject a(long j) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, MoatAdEvent.EVENT_TYPE, "breakpad-exception-report");
        a(jSONObject, "userId", g.K);
        a(jSONObject, "requestId", g.B);
        a(jSONObject, "occuredAt", String.valueOf(j));
        return jSONObject;
    }

    private static JSONObject a(long j, boolean z) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "userId", g.K);
        if (z) {
            a(jSONObject, "requestId", bd.a());
        } else {
            a(jSONObject, "requestId", g.B);
        }
        a(jSONObject, "occuredAt", String.valueOf(j));
        return jSONObject;
    }

    static JSONObject a(Context context) {
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        a(jSONObject, "request", a(currentTimeMillis));
        a(jSONObject, "exception", a(null, false));
        a(jSONObject, "performance", b(context));
        a(jSONObject, "environment", a(context, currentTimeMillis));
        a(jSONObject, "sdk", d());
        return jSONObject;
    }

    private static JSONObject a(Context context, long j) {
        return a(context, j, true);
    }

    private static JSONObject a(Context context, long j, boolean z) {
        JSONObject c = c();
        if (context != null) {
            a(c, "mobileNet", bd.b(context));
            a(c, TapjoyConstants.TJC_CONNECTION_TYPE_WIFI, bd.c(context));
            a(c, "screenRotation", bd.d(context));
        }
        a(c, "screenDpi", String.valueOf(g.w));
        a(c, "screenWidth", String.valueOf(g.x));
        a(c, "screenHeight", String.valueOf(g.y));
        a(c, "board", bd.e());
        a(c, "boardPlatform", bd.d());
        a(c, "cpuAbi", bd.f());
        a(c, "manufacturer", Build.MANUFACTURER);
        a(c, "buildType", Build.TYPE);
        a(c, j, z);
        a(c);
        return c;
    }

    static JSONObject a(Context context, String str, String str2, String str3) {
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject a = a(currentTimeMillis, false);
        a(a, MoatAdEvent.EVENT_TYPE, "unity-exception-report");
        a(a, "requestId", str3);
        a(a, "occuredAt", String.valueOf(System.currentTimeMillis()));
        a(jSONObject, "request", a);
        a(jSONObject, "exception", a(str, str2));
        a(jSONObject, "performance", b(context));
        a(jSONObject, "environment", a(context, currentTimeMillis));
        a(jSONObject, "sdk", d());
        return jSONObject;
    }

    static JSONObject a(Context context, String str, String str2, String str3, String str4, String str5) {
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject a = a(currentTimeMillis, false);
        a(a, MoatAdEvent.EVENT_TYPE, "cocos2djs-exception-report");
        a(a, "requestId", str5);
        a(a, "occuredAt", String.valueOf(System.currentTimeMillis()));
        a(jSONObject, "request", a);
        a(jSONObject, "exception", a(str, str2, str3, str4));
        a(jSONObject, "performance", b(context));
        a(jSONObject, "environment", a(context, currentTimeMillis, false));
        a(jSONObject, "sdk", d());
        return jSONObject;
    }

    static JSONObject a(Context context, Throwable th, boolean z) {
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        JSONObject a = a(currentTimeMillis, z);
        a(a, MoatAdEvent.EVENT_TYPE, "exception-report");
        a(jSONObject, "request", a);
        a(jSONObject, "exception", a(th, z));
        a(jSONObject, "performance", b(context));
        a(jSONObject, "environment", a(context, currentTimeMillis));
        a(jSONObject, "sdk", d());
        return jSONObject;
    }

    private static JSONObject a(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, String.MESSAGE, str);
        a(jSONObject, "stackTrace", str2);
        b(jSONObject);
        a(jSONObject, "handled", String.valueOf(false));
        return jSONObject;
    }

    private static JSONObject a(String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "cause", str);
        a(jSONObject, String.MESSAGE, str2);
        a(jSONObject, "stackTrace", str3);
        a(jSONObject, str4);
        b(jSONObject);
        a(jSONObject, "handled", String.valueOf(true));
        return jSONObject;
    }

    private static JSONObject a(Throwable th, boolean z) {
        JSONObject jSONObject = new JSONObject();
        if (th != null) {
            a(jSONObject, th);
            b(jSONObject, th);
            c(jSONObject, th);
            d(jSONObject, th);
        }
        b(jSONObject);
        a(jSONObject, "handled", String.valueOf(z));
        return jSONObject;
    }

    private static void a(JSONObject jSONObject) {
        if (g.G != null && g.G.size() > 0) {
            JSONObject jSONObject2 = new JSONObject();
            for (Entry entry : g.G.entrySet()) {
                a(jSONObject2, (String) entry.getKey(), (String) entry.getValue());
            }
            a(jSONObject, "customMeta", jSONObject2);
        }
    }

    private static void a(JSONObject jSONObject, long j, boolean z) {
        JSONObject jSONObject2 = new JSONObject();
        if (g.I && z) {
            a(jSONObject2, "log", bd.c());
        } else {
            String aeVar = ae.a().toString();
            if (aeVar.length() > 0) {
                a(jSONObject2, "log", aeVar);
            }
        }
        a(jSONObject2, "hacked", String.valueOf(g.v));
        a(jSONObject2, "msFromStart", String.valueOf(j - g.z));
        a(jSONObject, "log", jSONObject2);
    }

    private static void a(JSONObject jSONObject, Context context) {
        JSONObject jSONObject2 = new JSONObject();
        if (context != null) {
            MemoryInfo memoryInfo = new MemoryInfo();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            activityManager.getMemoryInfo(memoryInfo);
            a(jSONObject2, "sysAvail", String.valueOf(memoryInfo.availMem));
            a(jSONObject2, "sysLow", String.valueOf(memoryInfo.lowMemory));
            a(jSONObject2, "sysThreshold", String.valueOf(memoryInfo.threshold));
            a(jSONObject2, "appPss", String.valueOf(activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() * 1024));
        } else {
            a(jSONObject2, "sysAvail", "");
            a(jSONObject2, "sysLow", "");
            a(jSONObject2, "sysThreshold", "");
            a(jSONObject2, "appPss", "");
        }
        Runtime runtime = Runtime.getRuntime();
        a(jSONObject2, "appAvail", String.valueOf(runtime.freeMemory()));
        a(jSONObject2, "appMax", String.valueOf(runtime.maxMemory()));
        a(jSONObject2, "appTotal", String.valueOf(runtime.totalMemory()));
        a(jSONObject, "memory", jSONObject2);
    }

    private static void a(JSONObject jSONObject, String str) {
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, "engineVersion", str);
        a(jSONObject2, "scriptDirPath", "assets");
        a(jSONObject, "auxData", jSONObject2);
    }

    private static void a(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e) {
        }
    }

    private static void a(JSONObject jSONObject, String str, JSONObject jSONObject2) {
        try {
            jSONObject.put(str, jSONObject2);
        } catch (JSONException e) {
        }
    }

    private static void a(JSONObject jSONObject, Throwable th) {
        String message = th.getMessage();
        if (message == null) {
            message = "";
        }
        a(jSONObject, String.MESSAGE, message);
    }

    static JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        a(jSONObject2, MoatAdEvent.EVENT_TYPE, "remote");
        a(jSONObject2, "userId", g.K);
        a(jSONObject2, "occuredAt", String.valueOf(System.currentTimeMillis()));
        a(jSONObject, "request", jSONObject2);
        a(jSONObject, "environment", c());
        a(jSONObject, "sdk", d());
        return jSONObject;
    }

    private static JSONObject b(Context context) {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, context);
        return jSONObject;
    }

    private static void b(JSONObject jSONObject) {
        String str = "";
        if (g.F != null && g.F.size() > 0) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String str2 : g.F) {
                stringBuilder.append(str2.replaceAll("\\|", "_"));
                stringBuilder.append("|");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            str2 = stringBuilder.toString();
        }
        a(jSONObject, "breadcrumbs", str2);
    }

    private static void b(JSONObject jSONObject, Throwable th) {
        a(jSONObject, "cause", th.getClass().getName());
    }

    private static JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "uid", g.r);
        if (g.s != null) {
            a(jSONObject, "idv2", g.s);
        }
        a(jSONObject, "model", g.q);
        a(jSONObject, "brand", g.p);
        a(jSONObject, "appVer", g.o);
        a(jSONObject, "appVerCode", g.t);
        a(jSONObject, "appName", g.n);
        a(jSONObject, "appIdentifier", g.n);
        a(jSONObject, "osVer", g.u);
        a(jSONObject, "locale", bd.b());
        a(jSONObject, "optOutCrashLog", String.valueOf(g.ac));
        return jSONObject;
    }

    private static void c(JSONObject jSONObject, Throwable th) {
        JSONObject jSONObject2 = new JSONObject();
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (!(stackTrace == null || stackTrace.length <= 1 || stackTrace[0] == null)) {
            a(jSONObject2, "file", stackTrace[0].getFileName());
            a(jSONObject2, "line", String.valueOf(stackTrace[0].getLineNumber()));
            a(jSONObject2, "class", stackTrace[0].getClassName());
            a(jSONObject2, String.METHOD, stackTrace[0].getMethodName());
        }
        a(jSONObject, "location", jSONObject2);
    }

    private static JSONObject d() {
        JSONObject jSONObject = new JSONObject();
        a(jSONObject, "name", "SmartBeat-Android");
        a(jSONObject, "version", "1.17");
        return jSONObject;
    }

    private static void d(JSONObject jSONObject, Throwable th) {
        Writer stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        a(jSONObject, "stackTrace", stringWriter.toString());
    }
}
