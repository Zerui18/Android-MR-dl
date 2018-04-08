package co.cyberz.fox.b;

import android.content.Context;
import android.os.Build.VERSION;
import co.cyberz.common.ids.b;
import co.cyberz.common.ids.c;
import co.cyberz.util.string.StringUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.json.JSONObject;

public final class a {
    public int a = 0;
    public a b = null;
    public String c = "";
    public String d = null;
    public String e = null;
    public String f = null;
    public String g = null;
    public String h = null;
    public int i = 0;
    public String j = null;
    public String k = null;
    public String l = null;
    public double m;
    public int n;
    public String o = null;
    public int p = 0;
    public String q = null;
    public String r;
    public String s;
    public JSONObject t = null;
    public JSONObject u = null;
    public String v;

    public enum a {
        AnalyticsEventStartSession("1"),
        AnalyticsEventEndSession("2"),
        AnalyticsEventPageView("3"),
        AnalyticsEventTrackEvent("4"),
        AnalyticsEventTrackTransaction("5");
        
        final String f;

        private a(String str) {
            this.f = str;
        }
    }

    private String b() {
        String str = "";
        if (this.u != null) {
            try {
                str = co.cyberz.util.h.a.a(this.u.toString(), co.cyberz.util.h.a.a.XUNIQ);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public final String a() {
        try {
            co.cyberz.common.b.a a = co.cyberz.common.b.a.a();
            Context context = co.cyberz.fox.a.a().d;
            co.cyberz.common.ids.c.a a2 = c.a(context).a();
            co.cyberz.util.e.a.a a3 = co.cyberz.util.e.a.a(context).a(3);
            String format = new SimpleDateFormat("Z").format(new Date());
            StringBuffer stringBuffer = new StringBuffer();
            StringBuffer append = stringBuffer.append(StringUtil.nvl(Integer.valueOf(this.a))).append(",").append(StringUtil.nvl(this.b.f)).append(",").append(StringUtil.urlEncode(StringUtil.nvl(this.c))).append(",").append(StringUtil.nvl(this.d)).append(",").append(StringUtil.nvl(Integer.valueOf(a.b.getAppId()))).append(",").append(StringUtil.nvl(a.b.getAppKey())).append(",").append(StringUtil.nvl(this.e)).append(",").append(StringUtil.nvl(this.f)).append(",").append(StringUtil.nvl(a2.a)).append(",").append(StringUtil.nvl(this.g)).append(",").append(StringUtil.nvl(b.a(context).a)).append(",,,").append(StringUtil.nvl(Integer.valueOf(this.i))).append(",").append(StringUtil.urlEncode(StringUtil.nvl(this.j))).append(",").append(StringUtil.urlEncode(StringUtil.nvl(this.k))).append(",").append(StringUtil.urlEncode(StringUtil.nvl(this.l))).append(",").append(StringUtil.nvl(Double.valueOf(this.m))).append(",").append(StringUtil.nvl(Integer.valueOf(this.n))).append(",").append(StringUtil.nvl(this.o)).append(",").append(StringUtil.urlEncode(a.j)).append(",").append(StringUtil.nvl("4.2.1")).append(",").append(StringUtil.nvl(Integer.valueOf(this.p))).append(",").append(StringUtil.urlEncode(StringUtil.nvl(co.cyberz.util.a.a.a()))).append(",").append(StringUtil.urlEncode(StringUtil.nvl(VERSION.RELEASE))).append(",").append(StringUtil.nvl(format)).append(",,,2,").append(StringUtil.urlEncode(StringUtil.nvl(this.r))).append(",").append(StringUtil.urlEncode(StringUtil.nvl(this.s))).append(",").append(StringUtil.nvl(a3.a)).append(",").append(StringUtil.nvl(a3.c)).append(",,");
            String str = "";
            if (this.t != null) {
                str = StringUtil.urlEncode(this.t.toString());
            }
            append.append(str).append(",").append(b()).append(",").append(StringUtil.nvl(co.cyberz.util.a.b.a())).append(",").append(StringUtil.nvl(co.cyberz.util.a.b.b())).append(",").append(StringUtil.nvl(a.k)).append(",").append(StringUtil.nvl(a.n)).append(",").append(StringUtil.nvl(co.cyberz.util.a.a.b())).append(",").append(StringUtil.nvl(a.g));
            this.v = stringBuffer.toString();
        } catch (Exception e) {
        }
        return this.v;
    }

    public final String toString() {
        return StringUtil.isEmpty(this.v) ? a() : this.v;
    }
}
