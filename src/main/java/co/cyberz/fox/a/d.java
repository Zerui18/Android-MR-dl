package co.cyberz.fox.a;

import android.net.Uri;
import co.cyberz.common.ids.c;
import co.cyberz.util.d.b;
import co.cyberz.util.g.a;
import co.cyberz.util.string.StringUtil;
import java.io.InputStream;
import org.json.JSONObject;

public final class d extends b<JSONObject> {
    private final long a;
    private final String c;

    public d(long j) {
        this.a = j;
        StringBuilder stringBuilder = new StringBuilder();
        String b = this.b.b();
        if (StringUtil.isEmpty(b)) {
            Uri parse = Uri.parse(this.b.c());
            stringBuilder.append(parse.getScheme()).append("://deferred.").append(parse.getHost()).append(parse.getPath());
            new StringBuilder("request DeferredDeeplink URL : ").append(stringBuilder.toString()).append("/v1/deferred");
        } else {
            stringBuilder.append(b);
        }
        this.c = stringBuilder.append("/v1/deferred").toString();
    }

    protected final a<String> a(a<String> aVar) {
        aVar.a("_xuniq", c.a(this.b.a).a().a);
        aVar.a("_expire", String.valueOf(this.a));
        return super.a((a) aVar);
    }

    protected final /* bridge */ /* synthetic */ Object a(int i, InputStream inputStream) {
        return null;
    }

    public final String a() {
        return this.c;
    }
}
