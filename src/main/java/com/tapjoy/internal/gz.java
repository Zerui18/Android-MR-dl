package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.internal.gl.l;
import com.tapjoy.internal.gl.z;
import java.util.List;
import java.util.Map;

public final class gz extends gy {
    public final String c;
    public boolean d = false;
    private final fu e;
    private final l f;
    private final com.tapjoy.internal.gl.a g;
    private final z h;
    private Context i;

    public static class a {
        public gb a;
        public final List b;

        public a(gb gbVar, List list) {
            this.a = gbVar;
            this.b = list;
        }
    }

    protected final /* synthetic */ Object a(br brVar) {
        brVar.h();
        List list = null;
        gn gnVar = null;
        gq gqVar = null;
        while (brVar.j()) {
            String l = brVar.l();
            if ("interstitial".equals(l)) {
                gqVar = (gq) brVar.a(gq.n);
            } else if ("contextual_button".equals(l)) {
                gnVar = (gn) brVar.a(gn.d);
            } else if ("enabled_placements".equals(l)) {
                list = brVar.c();
            } else {
                brVar.s();
            }
        }
        brVar.i();
        if (gqVar != null && (gqVar.a() || gqVar.b())) {
            return new a(new fz(this.e, this.c, gqVar, this.i), list);
        }
        if (gnVar != null) {
            return new a(new fq(this.e, this.c, gnVar, this.i), list);
        }
        return new a(new ga(), list);
    }

    public gz(fu fuVar, l lVar, com.tapjoy.internal.gl.a aVar, z zVar, String str, Context context) {
        this.e = fuVar;
        this.f = lVar;
        this.g = aVar;
        this.h = zVar;
        this.c = str;
        this.i = context;
    }

    public final String c() {
        return "placement";
    }

    public final Map e() {
        Map e = super.e();
        e.put(String.VIDEO_INFO, new bq(gk.a(this.f)));
        e.put("app", new bq(gk.a(this.g)));
        e.put("user", new bq(gk.a(this.h)));
        e.put("placement", this.c);
        return e;
    }

    protected final /* synthetic */ Object f() {
        a aVar = (a) super.f();
        if (!(aVar.a instanceof ga)) {
            aVar.a.a();
            if (!aVar.a.b()) {
                new Object[1][0] = this.c;
                aVar.a = new ga();
            }
        }
        return aVar;
    }
}
