package co.cyberz.util.f;

import android.util.Log;
import co.cyberz.fox.FoxConfig;

public final class a {
    private static String a = "FOX-DEBUG";
    private static String b = "FOX-LOG";

    public static void a(String str) {
        if (a()) {
            Log.i(a, str);
        }
    }

    public static void a(String str, Throwable th) {
        if (a()) {
            Log.e(a, str, th);
        }
    }

    private static boolean a() {
        co.cyberz.fox.a.a();
        FoxConfig foxConfig = co.cyberz.fox.a.a().c;
        return foxConfig == null ? false : foxConfig.isDebug();
    }

    public static void b(String str) {
        if (a()) {
            Log.w(a, str);
        }
    }

    public static void c(String str) {
        if (a()) {
            Log.e(a, str);
        }
    }
}
