package co.cyberz.common.ids;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import co.cyberz.util.string.StringUtil;

public final class FingerPrint {
    private Context a;
    private WebView b;
    private a c;

    public static class a {
        public final String a;
        public final String b;

        private a(String str, String str2) {
            this.a = str;
            this.b = str2;
        }
    }

    public FingerPrint(Context context) {
        this.a = context;
    }

    static /* synthetic */ void a(FingerPrint fingerPrint) {
        try {
            co.cyberz.util.f.a.a("Fingerprint init");
            fingerPrint.b = new WebView(fingerPrint.a);
            WebSettings settings = fingerPrint.b.getSettings();
            settings.setJavaScriptEnabled(true);
            fingerPrint.b.addJavascriptInterface(fingerPrint, "droid");
            String userAgentString = settings.getUserAgentString();
            if (!StringUtil.isEmpty(userAgentString)) {
                fingerPrint.a.getSharedPreferences("co.cyberz.fox", 0).edit().putString("ua", userAgentString).commit();
            }
            fingerPrint.b.loadUrl(co.cyberz.common.b.a.a().c() + "/view/collect.html");
            co.cyberz.util.f.a.a("Fingerprint after load");
        } catch (Exception e) {
            fingerPrint.b = null;
            fingerPrint.a = null;
        }
    }

    @JavascriptInterface
    public final void setFingerprintId(String str, long j) {
        try {
            co.cyberz.util.f.a.a("Fingerprint received");
            this.c = new a(StringUtil.urlDecode(str), j > 0 ? String.valueOf(j) : "");
            co.cyberz.common.b.a.a().s = this.c;
        } catch (Throwable e) {
            co.cyberz.util.f.a.a("setFingerprint", e);
        } finally {
            this.b = null;
            this.a = null;
        }
    }
}
