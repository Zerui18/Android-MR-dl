package com.moat.analytics.mobile.tjy;

import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.Map;

class bb {
    final /* synthetic */ ay a;
    private final WeakReference[] b;
    private final LinkedList c;
    private final Method d;

    private bb(ay ayVar, Method method, Object... objArr) {
        int i = 0;
        this.a = ayVar;
        this.c = new LinkedList();
        if (objArr == null) {
            objArr = ay.a;
        }
        WeakReference[] weakReferenceArr = new WeakReference[objArr.length];
        int length = objArr.length;
        int i2 = 0;
        while (i < length) {
            Object obj = objArr[i];
            if ((obj instanceof Map) || (obj instanceof Integer)) {
                this.c.add(obj);
            }
            int i3 = i2 + 1;
            weakReferenceArr[i2] = new WeakReference(obj);
            i++;
            i2 = i3;
        }
        this.b = weakReferenceArr;
        this.d = method;
    }
}
