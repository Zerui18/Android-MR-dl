package co.cyberz.fox.a;

import co.cyberz.common.ids.c;
import co.cyberz.fox.FoxTrackOption;
import co.cyberz.fox.b.b;
import co.cyberz.util.g.a;
import co.cyberz.util.string.StringUtil;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.Map;

public final class e extends c<Integer> {
    private final FoxTrackOption a;
    private final int c;
    private final b d;

    public e(FoxTrackOption foxTrackOption, b bVar) {
        this.a = foxTrackOption;
        this.c = bVar.b;
        this.d = bVar;
    }

    private a<String> a(boolean z, boolean z2) {
        a<String> aVar = new a();
        try {
            c.a a = c.a(this.b.a).a(this.c);
            String redirectUrl = this.a.getRedirectUrl();
            String str = "_rurl";
            if (StringUtil.isEmpty(redirectUrl)) {
                redirectUrl = "default";
            }
            aVar.a(str, redirectUrl);
            aVar.a("_buid", this.a.getBuid());
            aVar.a("_xevent", "1");
            if (a.c) {
                aVar.a("_dd", "1");
            }
            if (!(this.b.s == null || StringUtil.isEmpty(this.b.s.a) || StringUtil.isEmpty(this.b.s.b))) {
                aVar.a("_fpid", this.b.s.a);
                aVar.a("_fptdl", this.b.s.b);
            }
            if (this.a.isOptOut()) {
                aVar.a("_optout", "1");
            }
            String str2 = z2 ? "true" : "false";
            co.cyberz.common.ids.b a2 = co.cyberz.common.ids.b.a(co.cyberz.fox.a.a().d);
            new StringBuilder("xuid : ").append(a2.a);
            str = co.cyberz.common.ids.b.f(co.cyberz.fox.a.a().d);
            if (StringUtil.isEmpty(str)) {
                redirectUrl = b(z, z2);
            } else {
                aVar.a("_referrer", str);
                redirectUrl = ((str.length() <= 5 || !"LINE_".equals(str.substring(0, 5))) && StringUtil.isEmpty(a2.a)) ? b(z, z2) : z ? "true" : "false";
            }
            if (this.b.l) {
                str2 = "true";
                redirectUrl = "false";
            } else {
                String str3 = str2;
                str2 = redirectUrl;
                redirectUrl = str3;
            }
            aVar.a("_cv_target", str2);
            aVar.a("_use_bw", redirectUrl);
            redirectUrl = co.cyberz.fox.a.a().d.getSharedPreferences("co.cyberz.fox", 0).getString("ua", null);
            if (StringUtil.isEmpty(redirectUrl)) {
                redirectUrl = System.getProperty("http.agent", "");
            }
            if (!StringUtil.isEmpty(redirectUrl)) {
                redirectUrl = URLEncoder.encode(redirectUrl, "UTF-8");
            }
            aVar.a("_ua", redirectUrl);
            return aVar;
        } catch (Exception e) {
            throw new co.cyberz.util.b.a("Occured error at InstallRequest createInstallParams");
        }
    }

    private static String b(boolean z, boolean z2) {
        return z ? z2 ? "false" : "true" : "true";
    }

    protected final /* synthetic */ Object a(int i, InputStream inputStream) {
        return Integer.valueOf(i);
    }

    public final String a() {
        return this.b.c + "/p/cv";
    }

    protected final a<String> b(a<String> aVar) {
        aVar.putAll(a(true, this.d.a));
        return aVar;
    }

    public final Map<String, String> g() {
        Map<String, String> f = super.f();
        f.putAll(a(false, true));
        return f;
    }
}
