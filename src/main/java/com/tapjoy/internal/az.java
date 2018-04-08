package com.tapjoy.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public final class az implements bb {
    private final List a;

    public az(List list) {
        this.a = list;
    }

    public final boolean add(Object object) {
        return this.a.add(object);
    }

    public final boolean addAll(Collection collection) {
        return this.a.addAll(collection);
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean contains(Object object) {
        return this.a.contains(object);
    }

    public final boolean containsAll(Collection collection) {
        return this.a.containsAll(collection);
    }

    public final boolean equals(Object object) {
        return this.a.equals(object);
    }

    public final Object a(int i) {
        return this.a.get(i);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    public final Iterator iterator() {
        return this.a.iterator();
    }

    public final boolean remove(Object object) {
        return this.a.remove(object);
    }

    public final boolean removeAll(Collection collection) {
        return this.a.removeAll(collection);
    }

    public final boolean retainAll(Collection collection) {
        return this.a.retainAll(collection);
    }

    public final int size() {
        return this.a.size();
    }

    public final Object[] toArray() {
        return this.a.toArray();
    }

    public final Object[] toArray(Object[] array) {
        return this.a.toArray(array);
    }

    public final boolean offer(Object e) {
        return this.a.add(e);
    }

    public final Object remove() {
        Object poll = poll();
        if (poll != null) {
            return poll;
        }
        throw new NoSuchElementException();
    }

    public final Object poll() {
        return this.a.isEmpty() ? null : this.a.remove(0);
    }

    public final Object element() {
        Object peek = peek();
        if (peek != null) {
            return peek;
        }
        throw new NoSuchElementException();
    }

    public final Object peek() {
        return this.a.isEmpty() ? null : this.a.get(0);
    }

    public final void b(int i) {
        ba.a(this.a, i);
    }
}
