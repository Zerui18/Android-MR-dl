package co.cyberz.fox.g;

import android.content.Context;

public class a {
    public static String a(Context context, String str) {
        if (co.cyberz.common.ids.a.a == null) {
            co.cyberz.common.ids.a.a = new co.cyberz.common.ids.a(context);
        }
        co.cyberz.common.ids.a aVar = co.cyberz.common.ids.a.a;
        return aVar.b.containsKey(str) ? (String) aVar.b.get(str) : null;
    }
}
