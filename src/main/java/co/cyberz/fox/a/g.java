package co.cyberz.fox.a;

import android.net.Uri;
import co.cyberz.util.g.a;
import co.cyberz.util.string.StringUtil;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public final class g extends c<Integer> {
    private final Uri a;
    private final String c;
    private final String d;
    private final String e;

    public g(Uri uri, String str, String str2, String str3) {
        this.a = uri;
        this.c = str;
        this.d = str2;
        this.e = str3;
    }

    private static Map<String, String> a(Uri uri) {
        Map<String, String> hashMap = new HashMap();
        try {
            String encodedQuery = uri.getEncodedQuery();
            if (StringUtil.isEmpty(encodedQuery)) {
                return null;
            }
            for (Object split : StringUtil.split(encodedQuery, "&")) {
                Object split2;
                String[] split3 = StringUtil.split(split2, "=");
                if (1 < split3.length) {
                    Object obj = split3[0];
                    split2 = split3[1];
                    if (!("_xuid".equals(obj) || "_xroute".equals(obj))) {
                        hashMap.put(obj, split2);
                    }
                }
            }
            return hashMap;
        } catch (Exception e) {
            return hashMap;
        }
    }

    protected final /* synthetic */ Object a(int i, InputStream inputStream) {
        return Integer.valueOf(i);
    }

    public final String a() {
        return this.b.c + "/p/cv";
    }

    protected final a<String> b(a<String> aVar) {
        aVar.a("_xuid", this.c);
        aVar.a("_xroute", this.d);
        if (this.a != null) {
            aVar.putAll(a(this.a));
        }
        aVar.a("_buid", this.e);
        return aVar;
    }
}
