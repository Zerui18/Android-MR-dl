package co.cyberz.fox.a;

import co.cyberz.util.string.StringUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class a extends b<Integer> {
    protected static String a = "1";
    private final String c;

    public a(String str) {
        this.c = str;
    }

    protected final /* synthetic */ Object a(int i, InputStream inputStream) {
        return Integer.valueOf(i);
    }

    public final String a() {
        return this.b.d;
    }

    protected final a b() {
        return a.POST;
    }

    protected final String c() {
        new StringBuilder("Send CSV : ").append(this.c);
        Map hashMap = new HashMap();
        co.cyberz.fox.a.a();
        Object obj = co.cyberz.fox.a.a().c.isDebug() ? "1" : "0";
        hashMap.put("v", "4.2.1");
        hashMap.put("p", this.c);
        hashMap.put("e", a);
        hashMap.put("d", obj);
        hashMap.put("o", "2");
        return StringUtil.mapToUrlString(hashMap);
    }
}
