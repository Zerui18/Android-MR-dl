package com.tapjoy.internal;

import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.internal.gl.a;
import com.tapjoy.internal.gl.l;
import com.tapjoy.internal.gl.n;
import com.tapjoy.internal.gl.z;
import java.util.Map;

public final class hb extends gy {
    private final l c;
    private final a d;
    private final z e;
    private final String f;

    private hb(l lVar, a aVar, z zVar, String str) {
        this.c = lVar;
        this.d = aVar;
        this.e = zVar;
        this.f = str;
    }

    public final String c() {
        return "api/v1/tokens";
    }

    public final Map e() {
        Object obj;
        Map e = super.e();
        e.put(String.VIDEO_INFO, new bq(gk.a(this.c)));
        e.put("app", new bq(gk.a(this.d)));
        e.put("user", new bq(gk.a(this.e)));
        CharSequence charSequence = this.f;
        if (charSequence == null || charSequence.length() == 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            e.put("push_token", this.f);
        }
        return e;
    }

    public hb(n nVar, String str) {
        this(nVar.c, nVar.d, nVar.e, str);
    }
}
