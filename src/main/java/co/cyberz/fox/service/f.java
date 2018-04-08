package co.cyberz.fox.service;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import co.cyberz.common.ids.c;
import co.cyberz.util.string.StringUtil;
import com.google.android.gms.drive.DriveFile;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class f {
    public final FoxEvent a;
    private final Context b;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ String a;
        final /* synthetic */ f b;

        AnonymousClass2(f fVar, String str) {
            this.b = fVar;
            this.a = str;
        }

        public final void run() {
            f.a(this.a);
        }
    }

    private class a extends co.cyberz.common.a.a<String, String> {
        final /* synthetic */ f a;
        private final Context b;
        private final FoxEvent c;

        public a(f fVar, Context context, FoxEvent foxEvent) {
            this.a = fVar;
            this.b = context;
            this.c = foxEvent;
        }

        private String a(String... strArr) {
            StringBuilder stringBuilder = new StringBuilder("");
            try {
                if (StringUtil.isEmpty(strArr[0])) {
                    return null;
                }
                co.cyberz.fox.a.f fVar = new co.cyberz.fox.a.f(this.c, this.c.xtid);
                StringBuilder stringBuilder2 = new StringBuilder(fVar.g());
                try {
                    stringBuilder2.append("?").append(StringUtil.mapToUrlString((HashMap) fVar.h()));
                    stringBuilder2.append("&_rurl=").append(StringUtil.urlEncode(strArr[0]));
                    stringBuilder = stringBuilder2;
                } catch (Exception e) {
                    stringBuilder = stringBuilder2;
                }
                return stringBuilder.toString();
            } catch (Exception e2) {
            }
        }

        protected final /* synthetic */ void a(Object obj) {
            String str = (String) obj;
            if (!StringUtil.isEmpty(str)) {
                Intent intent = new Intent("android.intent.action.VIEW");
                try {
                    intent.setFlags((intent.getFlags() | DriveFile.MODE_READ_ONLY) | DriveFile.MODE_READ_ONLY);
                    intent.setData(Uri.parse(str));
                    this.b.startActivity(intent);
                } catch (ActivityNotFoundException e) {
                }
            }
        }

        protected final /* synthetic */ Object b(Object[] objArr) {
            return a((String[]) objArr);
        }
    }

    private static class b {
        static b e;
        Context a = co.cyberz.fox.a.a().d;
        co.cyberz.common.b.a b;
        String c = "";
        String d = "1";

        b() {
            try {
                this.b = co.cyberz.common.b.a.a();
                this.c = StringUtil.getDomain(this.b.c);
            } catch (co.cyberz.util.b.a e) {
            }
        }

        public final void a(String str, String str2) {
            CookieManager.getInstance().setCookie(this.c, str + "=" + str2);
        }
    }

    public f() {
        this(null);
    }

    public f(FoxEvent foxEvent) {
        this.b = co.cyberz.fox.a.a().d;
        this.a = foxEvent;
    }

    public static void a(String str) {
        if (b.e == null) {
            b.e = new b();
        }
        try {
            if (VERSION.SDK_INT < 21) {
                CookieSyncManager.createInstance(co.cyberz.fox.a.a().d);
                CookieSyncManager.getInstance().sync();
            } else {
                CookieManager.getInstance().flush();
            }
            b bVar = b.e;
            if (bVar.b != null && !StringUtil.isEmpty(bVar.c)) {
                co.cyberz.common.ids.c.a a = c.a(bVar.b.a).a();
                co.cyberz.common.ids.b a2 = co.cyberz.common.ids.b.a(bVar.a);
                bVar.a("_app_xuid", a2.a);
                bVar.a("_xroute", a2.b);
                bVar.a("_app", String.valueOf(bVar.b.b.getAppId()));
                bVar.a("_xuniq", a.a);
                bVar.a("_app_inner", bVar.d);
                if (!StringUtil.isEmpty(str)) {
                    bVar.a("_xtid", str);
                }
                bVar.a("_sdk", bVar.b.j);
                bVar.a("_model", bVar.b.e);
            }
        } catch (co.cyberz.util.b.a e) {
        } catch (Exception e2) {
        }
    }

    public final void a(String str, String str2) {
        try {
            if (StringUtil.isEmpty(str)) {
                co.cyberz.util.f.a.c("RedirectUrl must be not null.");
            } else if (Pattern.compile("(http://|https://){1}[\\w\\.\\-/:\\#\\?\\=\\&\\;\\%\\~\\+]+", 2).matcher(str).find()) {
                new a(this, this.b, new FoxEvent().setXtid(str2)).a((Object[]) new String[]{str});
            } else {
                co.cyberz.util.f.a.c("Couldn't open an external browser. RedirectUrl is incorrect, must be url format.");
            }
        } catch (Exception e) {
        }
    }
}
