package com.tapjoy.internal;

import java.io.Closeable;
import java.io.Flushable;
import java.util.LinkedList;

public final class ay extends ax implements bb, Closeable, Flushable {
    private final bb a;
    private final LinkedList b = new LinkedList();
    private final LinkedList c = new LinkedList();
    private int d;
    private boolean e;

    public static ay a(bb bbVar) {
        return new ay(bbVar);
    }

    private ay(bb bbVar) {
        this.a = bbVar;
        this.d = bbVar.size();
        this.e = this.d == 0;
    }

    protected final void finalize() {
        close();
        super.finalize();
    }

    public final void close() {
        try {
            flush();
        } finally {
            if (this.a instanceof Closeable) {
                ((Closeable) this.a).close();
            }
        }
    }

    public final void flush() {
        if (!this.c.isEmpty()) {
            this.a.addAll(this.c);
            if (this.e) {
                this.b.addAll(this.c);
            }
            this.c.clear();
        }
    }

    public final int size() {
        return this.d;
    }

    public final boolean offer(Object e) {
        this.c.add(e);
        this.d++;
        return true;
    }

    public final Object poll() {
        if (this.d <= 0) {
            return null;
        }
        Object remove;
        if (!this.b.isEmpty()) {
            remove = this.b.remove();
            this.a.b(1);
        } else if (this.e) {
            remove = this.c.remove();
        } else {
            remove = this.a.remove();
            if (this.d == this.c.size() + 1) {
                this.e = true;
            }
        }
        this.d--;
        return remove;
    }

    public final Object peek() {
        if (this.d <= 0) {
            return null;
        }
        if (!this.b.isEmpty()) {
            return this.b.element();
        }
        if (this.e) {
            return this.c.element();
        }
        Object peek = this.a.peek();
        this.b.add(peek);
        if (this.d != this.b.size() + this.c.size()) {
            return peek;
        }
        this.e = true;
        return peek;
    }

    public final Object a(int i) {
        if (i < 0 || i >= this.d) {
            throw new IndexOutOfBoundsException();
        }
        int size = this.b.size();
        if (i < size) {
            return this.b.get(i);
        }
        if (this.e) {
            return this.c.get(i - size);
        }
        if (i >= this.a.size()) {
            return this.c.get(i - this.a.size());
        }
        int i2 = size;
        Object obj = null;
        int i3 = i2;
        while (i3 <= i) {
            Object a = this.a.a(i3);
            this.b.add(a);
            i3++;
            obj = a;
        }
        if ((i + 1) + this.c.size() != this.d) {
            return obj;
        }
        this.e = true;
        return obj;
    }

    public final void b(int i) {
        if (i <= 0 || i > this.d) {
            throw new IndexOutOfBoundsException();
        }
        if (i <= this.b.size()) {
            ba.a(this.b, i);
            this.a.b(i);
        } else {
            this.b.clear();
            int size = (this.c.size() + i) - this.d;
            if (size < 0) {
                this.a.b(i);
            } else {
                this.a.clear();
                this.e = true;
                if (size > 0) {
                    ba.a(this.c, size);
                }
            }
        }
        this.d -= i;
    }
}
