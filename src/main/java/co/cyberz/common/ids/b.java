package co.cyberz.common.ids;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.net.Uri;
import co.cyberz.util.string.StringUtil;

public final class b {
    private static String c = "fox_xuid";
    private static String d = "fox_xroute";
    private static String e = "fox_referrer";
    private static String f = "fox_reengagement_uri";
    private static String g = "fox_reengagement_buid";
    private static String h = "";
    public final String a;
    public final String b;

    private b(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static b a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("co.cyberz.fox", 0);
        return new b(sharedPreferences.getString(c, h), sharedPreferences.getString(d, h));
    }

    public static b a(Context context, String str, String str2) {
        if (StringUtil.isEmpty(str) || StringUtil.isEmpty(str2)) {
            return null;
        }
        context.getSharedPreferences("co.cyberz.fox", 0).edit().putString(c, str).putString(d, str2).commit();
        return new b(str, str2);
    }

    public static void a(Context context, String str) {
        if (!StringUtil.isEmpty(str) && context != null) {
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("co.cyberz.fox", 0);
                if (sharedPreferences.contains(e)) {
                    sharedPreferences.edit().remove(e).commit();
                }
            }
            context.getSharedPreferences("co.cyberz.fox", 0).edit().putString(e, str).commit();
        }
    }

    public static boolean a(Context context, Uri uri, String str) {
        Editor edit = context.getSharedPreferences("co.cyberz.fox", 0).edit();
        edit.putString(f, uri.toString());
        if (!StringUtil.isEmpty(str)) {
            edit.putString(g, str);
        }
        return edit.commit();
    }

    public static String b(Context context) {
        return context.getSharedPreferences("co.cyberz.fox", 0).getString(f, null);
    }

    public static String c(Context context) {
        return context.getSharedPreferences("co.cyberz.fox", 0).getString(g, null);
    }

    public static boolean d(Context context) {
        return context.getSharedPreferences("co.cyberz.fox", 0).edit().remove(f).commit();
    }

    public static boolean e(Context context) {
        return context.getSharedPreferences("co.cyberz.fox", 0).edit().remove(g).commit();
    }

    public static String f(Context context) {
        return context == null ? h : context.getSharedPreferences("co.cyberz.fox", 0).getString(e, h);
    }
}
