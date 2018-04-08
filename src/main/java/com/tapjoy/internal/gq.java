package com.tapjoy.internal;

import android.graphics.Point;
import android.os.SystemClock;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class gq extends gm {
    public static final bm n = new bm() {
        public final /* synthetic */ Object a(br brVar) {
            return new gq(brVar);
        }
    };
    public gt a;
    public gt b;
    public gt c;
    public Point d;
    public gt e;
    public gt f;
    public String g;
    public fg h;
    public ArrayList i = new ArrayList();
    public ArrayList j = new ArrayList();
    public Map k;
    public long l;
    public gr m;

    gq(br brVar) {
        Iterator it;
        go goVar;
        brVar.h();
        String str = null;
        String str2 = null;
        while (brVar.j()) {
            String l = brVar.l();
            if ("frame".equals(l)) {
                brVar.h();
                while (brVar.j()) {
                    l = brVar.l();
                    if ("portrait".equals(l)) {
                        this.a = (gt) gt.c.a(brVar);
                    } else if (String.LANDSCAPE.equals(l)) {
                        this.b = (gt) gt.c.a(brVar);
                    } else if ("close_button".equals(l)) {
                        this.c = (gt) gt.c.a(brVar);
                    } else if ("close_button_offset".equals(l)) {
                        this.d = (Point) bn.a.a(brVar);
                    } else {
                        brVar.s();
                    }
                }
                brVar.i();
            } else if ("creative".equals(l)) {
                brVar.h();
                while (brVar.j()) {
                    l = brVar.l();
                    if ("portrait".equals(l)) {
                        this.e = (gt) gt.c.a(brVar);
                    } else if (String.LANDSCAPE.equals(l)) {
                        this.f = (gt) gt.c.a(brVar);
                    } else {
                        brVar.s();
                    }
                }
                brVar.i();
            } else if (String.URL.equals(l)) {
                this.g = brVar.b();
            } else if (gj.a(l)) {
                this.h = gj.a(l, brVar);
            } else if ("mappings".equals(l)) {
                brVar.h();
                while (brVar.j()) {
                    l = brVar.l();
                    if ("portrait".equals(l)) {
                        brVar.a(this.i, go.h);
                    } else if (String.LANDSCAPE.equals(l)) {
                        brVar.a(this.j, go.h);
                    } else {
                        brVar.s();
                    }
                }
                brVar.i();
            } else if ("meta".equals(l)) {
                this.k = brVar.d();
            } else if ("ttl".equals(l)) {
                this.l = ((long) (brVar.p() * 1000.0d)) + SystemClock.elapsedRealtime();
            } else if ("no_more_today".equals(l)) {
                this.m = (gr) gr.d.a(brVar);
            } else if ("ad_content".equals(l)) {
                str = brVar.b();
            } else if (TapjoyConstants.TJC_REDIRECT_URL.equals(l)) {
                str2 = brVar.b();
            } else {
                brVar.s();
            }
        }
        brVar.i();
        if (this.g == null) {
            this.g = "";
        }
        if (this.i != null) {
            it = this.i.iterator();
            while (it.hasNext()) {
                goVar = (go) it.next();
                if (goVar.f == null) {
                    goVar.f = str;
                }
                if (goVar.e == null) {
                    goVar.e = str2;
                }
            }
        }
        if (this.j != null) {
            it = this.j.iterator();
            while (it.hasNext()) {
                goVar = (go) it.next();
                if (goVar.f == null) {
                    goVar.f = str;
                }
                if (goVar.e == null) {
                    goVar.e = str2;
                }
            }
        }
    }

    public final boolean a() {
        return (this.c == null || this.a == null || this.e == null) ? false : true;
    }

    public final boolean b() {
        return (this.c == null || this.b == null || this.f == null) ? false : true;
    }
}
