package com.tapjoy.internal;

import android.graphics.Point;
import com.tapjoy.TJAdUnitConstants.String;
import java.net.URL;

public final class gr {
    public static final bm d = new bm() {
        public final /* synthetic */ Object a(br brVar) {
            gt gtVar = null;
            brVar.h();
            Point point = null;
            Point point2 = null;
            while (brVar.j()) {
                String l = brVar.l();
                if ("image".equals(l)) {
                    l = brVar.m();
                    if (!cr.c(l)) {
                        gtVar = new gt(new URL(l));
                    }
                } else if (String.LANDSCAPE.equals(l)) {
                    point2 = AnonymousClass1.b(brVar);
                } else if ("portrait".equals(l)) {
                    point = AnonymousClass1.b(brVar);
                } else {
                    brVar.s();
                }
            }
            brVar.i();
            return new gr(gtVar, point2, point);
        }

        private static Point b(br brVar) {
            Point point = null;
            brVar.h();
            while (brVar.j()) {
                if ("offset".equals(brVar.l())) {
                    brVar.h();
                    int i = 0;
                    int i2 = 0;
                    while (brVar.j()) {
                        String l = brVar.l();
                        if ("x".equals(l)) {
                            i2 = brVar.r();
                        } else if ("y".equals(l)) {
                            i = brVar.r();
                        } else {
                            brVar.s();
                        }
                    }
                    brVar.i();
                    point = new Point(i2, i);
                } else {
                    brVar.s();
                }
            }
            brVar.i();
            return point;
        }
    };
    public final gt a;
    public final Point b;
    public final Point c;

    public gr(gt gtVar, Point point, Point point2) {
        this.a = gtVar;
        this.b = point;
        this.c = point2;
    }
}
