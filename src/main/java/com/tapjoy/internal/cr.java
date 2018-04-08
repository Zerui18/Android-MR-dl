package com.tapjoy.internal;

public final class cr {
    public static String a(String str) {
        return str == null ? "" : str;
    }

    public static String b(String str) {
        return c(str) ? null : str;
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0;
    }
}
