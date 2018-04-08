package co.cyberz.fox.extra;

import android.content.Context;
import co.cyberz.util.string.StringUtil;

public class Ids {
    public static String get(Context context, String str) {
        if (context != null) {
            try {
                if (!StringUtil.isEmpty(str)) {
                    Class cls = Class.forName("co.cyberz.fox.g.a");
                    return (String) cls.getMethod("a", new Class[]{Context.class, String.class}).invoke(cls, new Object[]{context.getApplicationContext(), str.toLowerCase()});
                }
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
