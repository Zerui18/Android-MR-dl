package co.cyberz.util.c;

import android.content.Context;
import co.cyberz.common.b.b;
import co.cyberz.util.string.StringUtil;
import java.io.File;
import java.io.IOException;

public final class a {
    public final boolean a;
    public final String b;
    public final String c;
    private final String d;

    public a(Context context) {
        b bVar = new b(context);
        String str = bVar.a;
        this.d = context.getPackageName();
        if (StringUtil.isEmpty(str)) {
            str = this.d;
        }
        this.b = str;
        str = bVar.b;
        if (StringUtil.isEmpty(str)) {
            str = "__FOX_XUNIQ__";
        }
        this.c = str;
        this.a = !"0".equals(bVar.c);
    }

    public static boolean a(String str, String str2, String str3) {
        try {
            b.a(new File(str, str2), str3);
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
