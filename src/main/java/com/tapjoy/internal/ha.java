package com.tapjoy.internal;

import com.tapjoy.internal.gl.c;
import com.tapjoy.internal.gl.d;
import com.tapjoy.internal.gl.d.a;
import com.tapjoy.internal.gl.i;
import java.util.Map;

public final class ha extends gy {
    public final a c = d.e();
    private i d = null;

    public final String c() {
        return this.d == i.USAGES ? "api/v1/usages" : "api/v1/cevs";
    }

    public final boolean a(c cVar) {
        if (this.d == null) {
            this.d = cVar.c;
        } else if (cVar.c != this.d) {
            return false;
        }
        a aVar = this.c;
        if (cVar == null) {
            throw new NullPointerException();
        }
        aVar.e();
        aVar.b.add(cVar);
        return true;
    }

    public final Map e() {
        Map e = super.e();
        e.put("events", new bq(gk.a(this.c.d())));
        return e;
    }
}
