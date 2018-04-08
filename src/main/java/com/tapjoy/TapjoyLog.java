package com.tapjoy;

import android.annotation.TargetApi;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.webkit.WebView;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.fi;

public class TapjoyLog {
    private static final String a = TapjoyLog.class.getSimpleName();
    private static int b = 6;
    private static int c = 4;
    private static int d = 2;
    private static boolean e = false;
    private static int f = b;

    public static void setDebugEnabled(boolean enable) {
        e = enable;
        fi.a(enable);
        if (e) {
            a(TapjoyConstants.LOG_LEVEL_DEBUG_ON, false);
        } else {
            a(TapjoyConstants.LOG_LEVEL_DEBUG_OFF, false);
        }
    }

    public static void setInternalLogging(boolean isInternalLogging) {
        if (isInternalLogging) {
            a(TapjoyConstants.LOG_LEVEL_INTERNAL, true);
        }
    }

    @TargetApi(19)
    static void a(String str, boolean z) {
        if (z || TapjoyAppSettings.getInstance() == null || TapjoyAppSettings.getInstance().a == null) {
            if (str.equals(TapjoyConstants.LOG_LEVEL_INTERNAL)) {
                f = d;
                if (VERSION.SDK_INT >= 19) {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            TapjoyLog.d(TapjoyLog.a, "Enabling WebView debugging");
                            WebView.setWebContentsDebuggingEnabled(true);
                        }
                    });
                }
            } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_ON)) {
                f = c;
            } else if (str.equals(TapjoyConstants.LOG_LEVEL_DEBUG_OFF)) {
                f = b;
            } else {
                d(a, "unrecognized loggingLevel: " + str);
                f = b;
            }
            d(a, "logThreshold=" + f);
            return;
        }
        d(a, "setLoggingLevel -- log setting already persisted");
    }

    public static boolean isLoggingEnabled() {
        return e;
    }

    public static void i(String tag, String msg) {
        a(4, tag, msg);
    }

    public static void e(String tag, String msg) {
        e(tag, new TapjoyErrorMessage(ErrorType.INTERNAL_ERROR, msg));
    }

    public static void e(String tag, TapjoyErrorMessage error) {
        if (error == null) {
            return;
        }
        if (f == d || error.getType() != ErrorType.INTERNAL_ERROR) {
            a(6, tag, error.toString());
        }
    }

    public static void w(String tag, String msg) {
        a(5, tag, msg);
    }

    public static void d(String tag, String msg) {
        a(3, tag, msg);
    }

    public static void v(String tag, String msg) {
        a(2, tag, msg);
    }

    private static void a(int i, String str, String str2) {
        String str3 = a + ":" + str;
        if (f > i) {
            return;
        }
        if (str2.length() > 4096) {
            for (int i2 = 0; i2 <= str2.length() / 4096; i2++) {
                int i3 = i2 * 4096;
                int i4 = (i2 + 1) * 4096;
                if (i4 > str2.length()) {
                    i4 = str2.length();
                }
                Log.println(i, str3, str2.substring(i3, i4));
            }
            return;
        }
        Log.println(i, str3, str2);
    }
}
