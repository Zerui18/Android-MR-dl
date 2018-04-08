package com.smrtbeat;

import android.content.Context;
import java.lang.Thread.UncaughtExceptionHandler;

public class ExceptionHander implements UncaughtExceptionHandler {
    private UncaughtExceptionHandler mDefaultHander;

    ExceptionHander(UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.mDefaultHander = uncaughtExceptionHandler;
    }

    static void logCocos2dJsException(String str, String str2, String str3, String str4, String str5) {
        Context a = g.a();
        if (bd.g()) {
            try {
                new Thread(new z(ac.a(a, str, str2, str3, str4, str5), bd.b(str5))).start();
            } catch (Exception e) {
                bd.a(bg.ERROR, e.toString());
            }
        }
    }

    static void logHandledException(Context context, Throwable th) {
        if (th == null) {
            bd.a(bg.WARN, "Throwable should not be null when calling logHandledException()");
        } else if (bd.g()) {
            new Thread(new x().a(ac.a(context, th, true))).start();
        }
    }

    static void logUnityLog(Context context, String str, String str2, String str3) {
        if (bd.g()) {
            Thread thread = new Thread(new y().a(ac.a(context, str, str2, str3)));
            thread.setPriority(2);
            thread.start();
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Context a = g.a();
        g.ab = true;
        if (bd.g()) {
            try {
                new Thread(new w(this, ac.a(a, th, false), bd.l())).start();
            } catch (Exception e) {
                bd.a(bg.ERROR, e.toString());
            }
        }
        if (this.mDefaultHander != null) {
            this.mDefaultHander.uncaughtException(thread, th);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e2) {
        }
    }
}
