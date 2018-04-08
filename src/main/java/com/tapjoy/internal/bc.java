package com.tapjoy.internal;

import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public final class bc extends AbstractSet implements Serializable, Set {
    transient WeakHashMap a;

    public bc() {
        this(new WeakHashMap());
    }

    private bc(WeakHashMap weakHashMap) {
        this.a = weakHashMap;
    }

    public final boolean add(Object object) {
        return this.a.put(object, this) == null;
    }

    public final void clear() {
        this.a.clear();
    }

    public final Object clone() {
        try {
            return (bc) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final boolean contains(Object object) {
        return this.a.containsKey(object);
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    public final Iterator iterator() {
        return this.a.keySet().iterator();
    }

    public final boolean remove(Object object) {
        return this.a.remove(object) != null;
    }

    public final int size() {
        return this.a.size();
    }
}
