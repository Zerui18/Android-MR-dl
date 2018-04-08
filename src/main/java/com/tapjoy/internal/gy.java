package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import java.util.Map;

public abstract class gy extends cd {
    public final String b() {
        return "POST";
    }

    public final String d() {
        return "application/json";
    }

    public Map e() {
        Map e = super.e();
        fu a = fu.a();
        e.put("sdk_ver", a.m + "/Android");
        e.put(TapjoyConstants.TJC_API_KEY, a.l);
        if (fr.a) {
            e.put("debug", Boolean.valueOf(true));
        }
        return e;
    }

    protected Object f() {
        try {
            return super.f();
        } catch (Exception e) {
            new Object[1][0] = this;
            throw e;
        }
    }

    protected Object a(br brVar) {
        brVar.s();
        return null;
    }
}
