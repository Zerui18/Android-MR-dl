package com.tapjoy.internal;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class dr extends AbstractList implements ds, RandomAccess {
    public static final ds a = new dr().b();
    private final List b;

    public final /* bridge */ /* synthetic */ void add(int x0, Object x1) {
        this.b.add(x0, (String) x1);
        this.modCount++;
    }

    public final /* synthetic */ Object set(int x0, Object x1) {
        return a(this.b.set(x0, (String) x1));
    }

    public dr() {
        this.b = new ArrayList();
    }

    public dr(ds dsVar) {
        this.b = new ArrayList(dsVar.size());
        addAll(dsVar);
    }

    public final int size() {
        return this.b.size();
    }

    public final boolean addAll(Collection c) {
        return addAll(size(), c);
    }

    public final boolean addAll(int index, Collection collection) {
        if (collection instanceof ds) {
            collection = ((ds) collection).a();
        }
        boolean addAll = this.b.addAll(index, collection);
        this.modCount++;
        return addAll;
    }

    public final void clear() {
        this.b.clear();
        this.modCount++;
    }

    public final void a(dk dkVar) {
        this.b.add(dkVar);
        this.modCount++;
    }

    public final dk a(int i) {
        dk dkVar;
        dk dkVar2 = this.b.get(i);
        if (dkVar2 instanceof dk) {
            dkVar = dkVar2;
        } else if (dkVar2 instanceof String) {
            dkVar = dk.a((String) dkVar2);
        } else {
            dkVar = dk.a((byte[]) dkVar2);
        }
        if (dkVar != dkVar2) {
            this.b.set(i, dkVar);
        }
        return dkVar;
    }

    private static String a(Object obj) {
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof dk) {
            return ((dk) obj).e();
        }
        return dp.b((byte[]) obj);
    }

    public final List a() {
        return Collections.unmodifiableList(this.b);
    }

    public final ds b() {
        return new ea(this);
    }

    public final /* synthetic */ Object remove(int x0) {
        Object remove = this.b.remove(x0);
        this.modCount++;
        return a(remove);
    }

    public final /* synthetic */ Object get(int x0) {
        Object obj = this.b.get(x0);
        if (obj instanceof String) {
            return (String) obj;
        }
        String e;
        if (obj instanceof dk) {
            dk dkVar = (dk) obj;
            e = dkVar.e();
            if (dkVar.f()) {
                this.b.set(x0, e);
            }
            return e;
        }
        byte[] bArr = (byte[]) obj;
        e = dp.b(bArr);
        if (dp.a(bArr)) {
            this.b.set(x0, e);
        }
        return e;
    }
}
