package co.cyberz.fox.a;

import co.cyberz.fox.service.FoxEvent;
import co.cyberz.util.g.a;
import co.cyberz.util.string.StringUtil;
import java.io.InputStream;
import java.util.Map;

public final class f extends c<Integer> {
    private final String a;
    private final FoxEvent c;

    public f(FoxEvent foxEvent, String str) {
        this.a = str;
        this.c = foxEvent;
    }

    private a<String> j() {
        a<String> aVar = new a();
        aVar.a("_cvpoint", StringUtil.nvl(Integer.valueOf(this.c.ltvPointId)));
        aVar.a("_buid", this.c.buid);
        aVar.a("_price", 0.0d < this.c.price ? StringUtil.nvl(Double.valueOf(this.c.price * ((double) this.c.quantity))) : "");
        aVar.a("_sku", this.c.sku);
        aVar.a("_currency", this.c.currency);
        aVar.a("_xtid", this.a);
        if (this.c.getExtraInfo() != null && this.c.getExtraInfo().size() > 0) {
            aVar.putAll(this.c.getExtraInfo());
        }
        return aVar;
    }

    protected final /* synthetic */ Object a(int i, InputStream inputStream) {
        return Integer.valueOf(i);
    }

    public final String a() {
        return this.b.c + "/p/cv";
    }

    protected final a<String> b(a<String> aVar) {
        aVar.putAll(j());
        return aVar;
    }

    public final String g() {
        return this.b.c + "/p/ls";
    }

    public final Map<String, String> h() {
        Map<String, String> f = super.f();
        f.putAll(j());
        return f;
    }
}
