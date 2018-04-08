package co.cyberz.fox.a;

import co.cyberz.common.ids.b;
import co.cyberz.util.g.a;
import co.cyberz.util.string.StringUtil;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public abstract class c<R> extends b<R> {
    protected final a<String> a(a<String> aVar) {
        try {
            a<String> b = b(aVar);
            co.cyberz.common.ids.c.a a = co.cyberz.common.ids.c.a(this.b.a).a();
            b.a("_xuniq", a.a);
            b.a("_xuniq_type", a.b.c);
            b a2 = b.a(co.cyberz.fox.a.a().d);
            b.a("_xuid", a2.a, false);
            b.a("_xroute", a2.b, false);
            try {
                if (!StringUtil.isEmpty(this.b.b.getAppSalt())) {
                    b.a("_hash", co.cyberz.util.h.a.c(String.valueOf(this.b.b.getAppId()) + a2.a + a.a + this.b.b.getAppSalt()));
                }
            } catch (NoSuchAlgorithmException e) {
            }
            if (this.b.i) {
                b.a("_jb", "1");
            }
            return b;
        } catch (co.cyberz.util.b.a e2) {
            throw new co.cyberz.util.b.a("CvCommonRequest appendParams");
        }
    }

    protected abstract a<String> b(a<String> aVar);

    protected final Map<String, String> f() {
        return a(super.e());
    }
}
