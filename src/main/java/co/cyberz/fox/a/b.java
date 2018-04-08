package co.cyberz.fox.a;

import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import co.cyberz.util.d.a;
import co.cyberz.util.string.StringUtil;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Map;

public abstract class b<R> extends a<R> {
    protected co.cyberz.common.b.a b;

    public b() {
        try {
            this.b = co.cyberz.common.b.a.a();
        } catch (co.cyberz.util.b.a e) {
        }
    }

    protected co.cyberz.util.g.a<String> a(co.cyberz.util.g.a<String> aVar) {
        return aVar;
    }

    protected abstract R a(int i, InputStream inputStream);

    protected final String a(String str) {
        int i = 0;
        Object obj = new String[]{VERSION.RELEASE, Build.MODEL, Build.DEVICE};
        String str2 = "ADMAGESMPHSDK/Android/4.2.1/CZ/{0}/{1}/{2}";
        while (i < 3) {
            obj[i] = StringUtil.urlEncode(obj[i]);
            i++;
        }
        return new MessageFormat(str2).format(obj);
    }

    public R b(int i, @Nullable InputStream inputStream) {
        switch (i) {
            case 200:
                return a(i, inputStream);
            default:
                return null;
        }
    }

    protected final String d() {
        Map a = a(e());
        return a == null ? null : StringUtil.mapToUrlString(a);
    }

    protected final co.cyberz.util.g.a<String> e() {
        co.cyberz.util.g.a<String> aVar = new co.cyberz.util.g.a();
        try {
            aVar.a("_app", String.valueOf(this.b.b.getAppId()));
            aVar.a("_model", this.b.e);
            aVar.a("_os_ver", this.b.f);
            aVar.a("_sdk_ver", "4.2.1");
            aVar.a("_bundle_id", this.b.g);
            try {
                co.cyberz.util.e.a.a a = co.cyberz.util.e.a.a(this.b.b.getContext()).a();
                aVar.a("_adid", a.a);
                aVar.a("_adte", a.c);
            } catch (Exception e) {
            }
            aVar.a("_install_id", this.b.k);
            aVar.a("_language", this.b.o);
            aVar.a("_country", this.b.p);
            aVar.a("_build", this.b.q);
        } catch (Exception e2) {
        }
        return aVar;
    }
}
