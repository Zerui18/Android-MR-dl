package com.tapjoy.internal;

import com.tapjoy.internal.gz.a;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class gc implements cj {
    public final fu a;
    Set b = null;
    private final Map c = Collections.synchronizedMap(new HashMap());
    private final Map d = cv.a();

    public gc(fu fuVar) {
        this.a = fuVar;
    }

    private void a(ce ceVar, a aVar) {
        if (ceVar instanceof gz) {
            if (aVar.b != null) {
                Iterable iterable = aVar.b;
                synchronized (this) {
                    Set hashSet;
                    if (iterable instanceof Collection) {
                        hashSet = new HashSet(ct.a(iterable));
                    } else {
                        hashSet = cw.a(iterable.iterator());
                    }
                    this.b = hashSet;
                }
            }
            gz gzVar = (gz) ceVar;
            String str = gzVar.c;
            boolean z = gzVar.d;
            this.d.remove(str);
            if (!z) {
                this.c.put(str, aVar.a);
            }
            gb gbVar = aVar.a;
            fv fvVar = this.a.p;
            if (gbVar instanceof ga) {
                fr.a("No content for \"{}\"", str);
                fvVar.a(str);
                return;
            }
            fr.a("New content for \"{}\" is ready", str);
            if (z) {
                gbVar.a(fvVar, new eq());
                return;
            } else {
                fvVar.b(str);
                return;
            }
        }
        throw new IllegalStateException(ceVar.getClass().getName());
    }

    public final void a(ce ceVar) {
        a(ceVar, new a(new ga(), null));
    }
}
