package com.tapjoy.internal;

import android.os.SystemClock;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class fa {
    static Set a = null;
    private static final ThreadLocal b = new ThreadLocal() {
        protected final /* synthetic */ Object initialValue() {
            return new HashMap();
        }
    };
    private static fa c;
    private static volatile boolean d = false;

    public static final class a {
        final String a;
        private final TreeMap b = new TreeMap();
        private final Map c = new HashMap();
        private volatile long d;

        a(String str) {
            this.a = str;
        }

        public final a a() {
            try {
                this.d = SystemClock.elapsedRealtime();
            } catch (NullPointerException e) {
                this.d = -1;
            }
            return this;
        }

        public final a b() {
            long j = this.d;
            if (j != -1) {
                try {
                    a("spent_time", SystemClock.elapsedRealtime() - j);
                } catch (NullPointerException e) {
                }
            }
            return this;
        }

        public final a a(String str, Object obj) {
            this.b.put(str, obj);
            return this;
        }

        public final a a(String str) {
            this.b.put("failure", str);
            return this;
        }

        public final a b(String str) {
            this.b.put("misuse", str);
            return this;
        }

        public final a a(String str, long j) {
            this.c.put(str, Long.valueOf(j));
            return this;
        }

        public final void c() {
            String a;
            Map map = null;
            String str = this.a;
            if (this.b.size() > 0) {
                a = bl.a(this.b);
            } else {
                a = null;
            }
            if (this.c.size() > 0) {
                map = this.c;
            }
            fa.a(str, a, map);
        }
    }

    protected abstract void a();

    protected abstract void a(long j);

    protected abstract void a(long j, String str, String str2, Map map);

    public static void a(fc fcVar) {
        if (c == null) {
            c = fcVar;
            if (d) {
                fcVar.a(y.b());
            }
        }
    }

    public static void a(boolean z) {
        if (d != z) {
            d = z;
            if (c == null) {
                return;
            }
            if (z) {
                c.a(y.b());
            } else {
                c.a();
            }
        }
    }

    public static void a(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            a = null;
        } else {
            a = new HashSet(collection);
        }
    }

    public static a a(String str) {
        a a = new a(str).a();
        ((Map) b.get()).put(str, a);
        return a;
    }

    public static a b(String str) {
        a aVar = (a) ((Map) b.get()).remove(str);
        return aVar != null ? aVar.b() : new a(str);
    }

    public static a c(String str) {
        return (a) ((Map) b.get()).get(str);
    }

    public static a d(String str) {
        return (a) ((Map) b.get()).remove(str);
    }

    public static void a(String str, a aVar) {
        if (aVar == null) {
            new Object[1][0] = str;
        } else if (str.equals(aVar.a)) {
            ((Map) b.get()).put(str, aVar);
        } else {
            Object[] objArr = new Object[]{str, aVar.a};
        }
    }

    public static a e(String str) {
        return new a(str);
    }

    static /* synthetic */ void a(String str, String str2, Map map) {
        Set set = a;
        if ((set == null || !set.contains(str)) && d && c != null) {
            c.a(y.b(), str, str2, map);
        }
    }
}
