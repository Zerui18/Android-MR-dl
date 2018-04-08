package co.cyberz.util.a;

import android.os.Build;

public final class a {
    public static String a() {
        try {
            return Build.MODEL;
        } catch (Exception e) {
            return null;
        }
    }

    public static String b() {
        try {
            return Build.ID;
        } catch (Exception e) {
            return null;
        }
    }
}
