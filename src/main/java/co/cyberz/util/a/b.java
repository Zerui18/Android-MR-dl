package co.cyberz.util.a;

import java.util.Locale;

public final class b {
    public static String a() {
        try {
            return c().getCountry();
        } catch (Exception e) {
            return null;
        }
    }

    public static String b() {
        try {
            return c().getLanguage();
        } catch (Exception e) {
            return null;
        }
    }

    private static Locale c() {
        try {
            return Locale.getDefault();
        } catch (Exception e) {
            return null;
        }
    }
}
