package com.tapjoy.internal;

import android.os.Looper;

public final class fr {
    public static boolean a;

    public static void a(String str) {
        if (a) {
            ac.a(4, "Tapjoy", str, null);
        }
    }

    public static void a(String str, Object... objArr) {
        if (a) {
            ac.a(4, "Tapjoy", str, objArr);
        }
    }

    public static void b(String str) {
        if (a) {
            ac.a(6, "Tapjoy", str, null);
        }
    }

    public static void b(String str, Object... objArr) {
        if (a) {
            ac.a("Tapjoy", str, objArr);
        }
    }

    public static void a(String str, String str2, String str3) {
        if (a) {
            ac.a("Tapjoy", "{}: {} {}", str, str2, str3);
        }
    }

    public static boolean a(Object obj, String str) {
        if (obj != null) {
            return true;
        }
        if (a) {
            b(str);
        }
        return false;
    }

    public static boolean a(boolean z, String str) {
        if (!a || z) {
            return z;
        }
        b(str);
        throw new IllegalStateException(str);
    }

    public static boolean c(String str) {
        return a(Looper.myLooper() == Looper.getMainLooper(), str + ": Must be called on the main/ui thread");
    }
}
