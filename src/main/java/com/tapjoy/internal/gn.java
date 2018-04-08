package com.tapjoy.internal;

import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class gn extends gm {
    public static final bm d = new bm() {
        public final /* synthetic */ Object a(br brVar) {
            return new gn(brVar);
        }
    };
    public ArrayList a = new ArrayList();
    public Map b;
    public float c;

    public gn(br brVar) {
        brVar.h();
        String str = null;
        String str2 = null;
        while (brVar.j()) {
            String l = brVar.l();
            if ("layouts".equals(l)) {
                brVar.a(this.a, gw.d);
            } else if ("meta".equals(l)) {
                this.b = brVar.d();
            } else if ("max_show_time".equals(l)) {
                this.c = (float) brVar.p();
            } else if ("ad_content".equals(l)) {
                str2 = brVar.b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                str = brVar.b();
            } else {
                brVar.s();
            }
        }
        brVar.i();
        if (this.a != null) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                gw gwVar = (gw) it.next();
                if (gwVar.c != null) {
                    Iterator it2 = gwVar.c.iterator();
                    while (it2.hasNext()) {
                        gv gvVar = (gv) it2.next();
                        if (gvVar.i == null) {
                            gvVar.i = str2;
                        }
                        if (gvVar.h == null) {
                            gvVar.h = str;
                        }
                    }
                }
            }
        }
    }
}
