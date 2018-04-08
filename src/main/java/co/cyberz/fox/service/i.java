package co.cyberz.fox.service;

import android.content.Context;
import java.util.Arrays;
import java.util.List;

public final class i {
    protected static void a(Context context) {
        if (context != null) {
            context.getSharedPreferences("co.cyberz.fox", 0).edit().putBoolean("fox_sent_web", true).commit();
        }
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences("co.cyberz.fox", 0).getBoolean("fox_sent_web", false) || Arrays.asList(context.fileList()).contains("__ADMAGE_WEB_CONVERSION_COMPLETED__");
    }

    public static boolean c(Context context) {
        try {
            List asList = Arrays.asList(context.fileList());
            return asList.contains("__ADMAGE_WEB_CONVERSION_COMPLETED__") || asList.contains("__ADMAGE_APP_CONVERSION_COMPLETED__");
        } catch (Exception e) {
            return true;
        }
    }
}
