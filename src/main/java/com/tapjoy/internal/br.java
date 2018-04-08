package com.tapjoy.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class br implements bo, bt {
    private HashMap a;

    public static abstract class a {
        private static a a;

        public static a a() {
            a aVar = a;
            if (aVar != null) {
                return aVar;
            }
            aVar = bs.a;
            a = aVar;
            return aVar;
        }

        public final br a(InputStream inputStream) {
            return a(new InputStreamReader(inputStream, co.c));
        }

        public br a(Reader reader) {
            return a(cz.a(reader));
        }

        public br a(String str) {
            return a(new ByteArrayInputStream(str.getBytes(co.c.name())));
        }
    }

    public static br a(InputStream inputStream) {
        return a.a().a(inputStream);
    }

    public static br b(String str) {
        return a.a().a(str);
    }

    public final Object a(String str) {
        return this.a != null ? this.a.get(str) : null;
    }

    public final void a(String str, Object obj) {
        if (this.a == null) {
            this.a = new HashMap();
        }
        this.a.put(str, obj);
    }

    public final boolean a() {
        return k() == bw.BEGIN_OBJECT;
    }

    private boolean t() {
        if (k() != bw.NULL) {
            return false;
        }
        o();
        return true;
    }

    public final String b() {
        if (t()) {
            return null;
        }
        return m();
    }

    public final String c(String str) {
        return t() ? str : m();
    }

    private Object u() {
        bw k = k();
        switch (k) {
            case BEGIN_ARRAY:
                return c();
            case BEGIN_OBJECT:
                return d();
            case NULL:
                o();
                return null;
            case BOOLEAN:
                return Boolean.valueOf(n());
            case NUMBER:
                return new cm(m());
            case STRING:
                return m();
            default:
                throw new IllegalStateException("Expected a value but was " + k);
        }
    }

    public final List c() {
        List linkedList = new LinkedList();
        a(linkedList);
        return linkedList;
    }

    private void a(List list) {
        f();
        while (j()) {
            list.add(u());
        }
        g();
    }

    public final Map d() {
        Map linkedHashMap = new LinkedHashMap();
        a(linkedHashMap);
        return linkedHashMap;
    }

    public final void a(Map map) {
        h();
        while (j()) {
            map.put(l(), u());
        }
        i();
    }

    public final Object a(bm bmVar) {
        if (t()) {
            return null;
        }
        return bmVar.a(this);
    }

    public final void a(List list, bm bmVar) {
        f();
        while (j()) {
            list.add(bmVar.a(this));
        }
        g();
    }

    private static URI d(String str) {
        try {
            return new URI(str);
        } catch (Throwable e) {
            throw new bz(e);
        }
    }

    public final URL e() {
        URI uri = (URI) a("BASE_URI");
        if (uri != null) {
            return uri.resolve(d(m())).toURL();
        }
        return new URL(m());
    }
}
