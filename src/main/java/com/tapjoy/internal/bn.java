package com.tapjoy.internal;

import android.graphics.Point;
import android.graphics.Rect;

public final class bn {
    public static final bm a = new bm() {
        public final /* synthetic */ Object a(br brVar) {
            Point point = new Point();
            brVar.h();
            while (brVar.j()) {
                String l = brVar.l();
                if ("x".equals(l)) {
                    point.x = brVar.r();
                } else if ("y".equals(l)) {
                    point.y = brVar.r();
                } else {
                    brVar.s();
                }
            }
            brVar.i();
            return point;
        }
    };
    public static final bm b = new bm() {
        public final /* synthetic */ Object a(br brVar) {
            Rect rect = new Rect();
            switch (brVar.k()) {
                case BEGIN_ARRAY:
                    brVar.f();
                    rect.left = brVar.r();
                    rect.top = brVar.r();
                    rect.right = brVar.r();
                    rect.bottom = brVar.r();
                    while (brVar.j()) {
                        brVar.s();
                    }
                    brVar.g();
                    break;
                case BEGIN_OBJECT:
                    brVar.h();
                    while (brVar.j()) {
                        String l = brVar.l();
                        if ("left".equals(l)) {
                            rect.left = brVar.r();
                        } else if ("top".equals(l)) {
                            rect.top = brVar.r();
                        } else if ("right".equals(l)) {
                            rect.right = brVar.r();
                        } else if ("bottom".equals(l)) {
                            rect.bottom = brVar.r();
                        } else {
                            brVar.s();
                        }
                    }
                    brVar.i();
                    break;
                default:
                    throw new IllegalStateException("Unexpected token: " + brVar.k());
            }
            return rect;
        }
    };
}
