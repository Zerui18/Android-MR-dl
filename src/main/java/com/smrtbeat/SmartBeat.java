package com.smrtbeat;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

public class SmartBeat {
    public static void addExtraData(String str, String str2) {
        if (isSupported()) {
            bd.a(str, str2);
        }
    }

    public static void addExtraData(HashMap hashMap) {
        if (isSupported() && hashMap != null) {
            for (Entry entry : hashMap.entrySet()) {
                addExtraData((String) entry.getKey(), (String) entry.getValue());
            }
        }
    }

    public static boolean beginOnDrawFrame() {
        return ag.a();
    }

    public static void disable() {
        if (isSupported()) {
            bd.a(true);
        }
    }

    public static void disableAutoScreenCapture() {
        if (isSupported()) {
            g.O = false;
        }
    }

    public static void enable() {
        if (isSupported()) {
            bd.a(false);
        }
    }

    public static void enableAutoScreenCapture() {
        if (isSupported()) {
            g.O = true;
        }
    }

    public static void enableDebugLog(String str) {
        if (isSupported()) {
            g.H = str;
        }
    }

    public static void enableLogCat() {
        if (isSupported()) {
            g.I = true;
            g.J = "";
        }
    }

    public static void enableLogCat(String str) {
        if (isSupported()) {
            g.I = true;
            g.J = str;
        }
    }

    public static void endOnDrawFrame() {
        ag.b();
    }

    public static void flush() {
        if (isSupported() && bd.m()) {
            i.c();
        }
    }

    public static void initAndStartSession(Application application, String str) {
        if (isSupported()) {
            Context applicationContext = application.getApplicationContext();
            if (applicationContext == null) {
                throw new IllegalArgumentException("context must not be null");
            } else if (str == null || str.length() <= 0) {
                throw new IllegalArgumentException("apiKey must not be empty");
            } else if (str.length() != 36) {
                Log.e("SmartBeat", "Invalid api key:" + str);
                return;
            } else {
                bd.a(bd.e(applicationContext));
                g.m = str;
                bd.a(applicationContext);
                g.a(applicationContext);
                g.C = SmartBeatJni.a((Context) application);
                g.D = SmartBeatJni.b(application);
                Thread.setDefaultUncaughtExceptionHandler(new ExceptionHander(Thread.getDefaultUncaughtExceptionHandler()));
                if (VERSION.SDK_INT >= 14) {
                    ak.a(application);
                }
                i.c();
                i.b();
                return;
            }
        }
        bd.a(bg.INFO, String.format("This Android version(%d) is not supported", new Object[]{Integer.valueOf(VERSION.SDK_INT)}));
    }

    public static void initAndStartSession(Application application, String str, boolean z) {
        bd.a(!z);
        initAndStartSession(application, str);
    }

    public static boolean isEnabled() {
        return !g.ac;
    }

    private static boolean isSupported() {
        return VERSION.SDK_INT >= 8;
    }

    public static boolean isWhiteListed() {
        return ag.b(Build.MODEL);
    }

    public static void leaveBreadcrumbs(String str) {
        if (!isSupported() || str == null || str.length() <= 0) {
            return;
        }
        if (str.length() > 32) {
            bd.a(bg.INFO, String.format("Breadcrumb length should be up to %d", new Object[]{Integer.valueOf(32)}));
            bd.a(str.substring(0, 32));
            return;
        }
        bd.a(str);
    }

    public static void log(String str) {
        ae.a().a(str);
    }

    public static void logHandleExceptionForCocos2dJs(String str, String str2, String str3, String str4) {
        if (isSupported() && bd.m()) {
            ExceptionHander.logCocos2dJsException(str, str2, str3, str4, UUID.randomUUID().toString());
        }
    }

    public static void logHandleExceptionForUnity(Context context, String str, String str2) {
        if (isSupported() && bd.m()) {
            ExceptionHander.logUnityLog(context, str, str2, UUID.randomUUID().toString());
        }
    }

    public static void logHandleExceptionForUnity(Context context, String str, String str2, String str3) {
        if (isSupported() && bd.m()) {
            String uuid = UUID.randomUUID().toString();
            ExceptionHander.logUnityLog(context, str, str2, uuid);
            if (str3 != null && str3.length() > 0) {
                Thread thread = new Thread(new aw().a(new File(str3), uuid));
                thread.setPriority(2);
                thread.start();
            }
        }
    }

    public static void logHandledException(Context context, Throwable th) {
        if (isSupported() && bd.m()) {
            ExceptionHander.logHandledException(context, th);
        }
    }

    public static void notifyDump(String str) {
        SmartBeatJni.a(str);
    }

    public static void notifyOnPause(Activity activity) {
        if (isSupported() && VERSION.SDK_INT < 14) {
            bd.c(activity);
        }
    }

    public static void notifyOnResume(Activity activity) {
        if (!isSupported()) {
            return;
        }
        if (VERSION.SDK_INT < 14) {
            bd.b(activity);
        } else {
            bd.a(activity);
        }
    }

    public static void onSurfaceCreated(int i) {
        onSurfaceCreated(i, false);
    }

    public static void onSurfaceCreated(int i, boolean z) {
        g.E = i;
        ag.a(z);
    }

    public static void setActivityAsSensitive(String str) {
        if (isSupported() && str != null && str.length() != 0) {
            g.Q.add(str);
        }
    }

    public static void setActivityAsSensitive(List list) {
        if (isSupported() && list != null && list.size() != 0) {
            g.Q.addAll(list);
        }
    }

    public static void setOpenGLESVersion(int i) {
        Log.w("SmartBeat", "deprecated API (SmartBeat.setOpenGLESVersion) is used.");
    }

    public static void setUserId(String str) {
        if (isSupported()) {
            g.K = str;
        }
    }

    public static void whiteListBoardForOpenGLES(String str) {
        Log.w("SmartBeat", "deprecated API (SmartBeat.whiteListBoardForOpenGLES) is used.");
    }

    public static void whiteListModelForOpenGLES(String str) {
        ag.a(str);
    }
}
