package com.tapjoy.internal;

import android.support.v4.view.MotionEventCompat;
import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class bx implements Closeable {
    final Writer a;
    private final List b = new ArrayList();
    private String c;
    private String d;
    private boolean e;

    public bx(Writer writer) {
        this.b.add(bu.EMPTY_DOCUMENT);
        this.d = ":";
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.a = writer;
    }

    public final bx a() {
        return a(bu.EMPTY_ARRAY, "[");
    }

    public final bx b() {
        return a(bu.EMPTY_ARRAY, bu.NONEMPTY_ARRAY, "]");
    }

    public final bx c() {
        return a(bu.EMPTY_OBJECT, "{");
    }

    public final bx d() {
        return a(bu.EMPTY_OBJECT, bu.NONEMPTY_OBJECT, "}");
    }

    private bx a(bu buVar, String str) {
        a(true);
        this.b.add(buVar);
        this.a.write(str);
        return this;
    }

    private bx a(bu buVar, bu buVar2, String str) {
        bu e = e();
        if (e == buVar2 || e == buVar) {
            this.b.remove(this.b.size() - 1);
            if (e == buVar2) {
                g();
            }
            this.a.write(str);
            return this;
        }
        throw new IllegalStateException("Nesting problem: " + this.b);
    }

    private bu e() {
        return (bu) this.b.get(this.b.size() - 1);
    }

    private void a(bu buVar) {
        this.b.set(this.b.size() - 1, buVar);
    }

    public final bx a(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        bu e = e();
        if (e == bu.NONEMPTY_OBJECT) {
            this.a.write(44);
        } else if (e != bu.EMPTY_OBJECT) {
            throw new IllegalStateException("Nesting problem: " + this.b);
        }
        g();
        a(bu.DANGLING_NAME);
        c(str);
        return this;
    }

    public final bx b(String str) {
        if (str == null) {
            return f();
        }
        a(false);
        c(str);
        return this;
    }

    private bx f() {
        a(false);
        this.a.write("null");
        return this;
    }

    public final bx a(double d) {
        if (this.e || !(Double.isNaN(d) || Double.isInfinite(d))) {
            a(false);
            this.a.append(Double.toString(d));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d);
    }

    public final bx a(long j) {
        a(false);
        this.a.write(Long.toString(j));
        return this;
    }

    public final void close() {
        this.a.close();
        if (e() != bu.NONEMPTY_DOCUMENT) {
            throw new IOException("Incomplete document");
        }
    }

    private void c(String str) {
        this.a.write("\"");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    this.a.write("\\b");
                    continue;
                case '\t':
                    this.a.write("\\t");
                    continue;
                case '\n':
                    this.a.write("\\n");
                    continue;
                case MotionEventCompat.AXIS_RX /*12*/:
                    this.a.write("\\f");
                    continue;
                case '\r':
                    this.a.write("\\r");
                    continue;
                case MotionEventCompat.AXIS_GENERIC_3 /*34*/:
                case '\\':
                    this.a.write(92);
                    break;
                case ' ':
                case ' ':
                    this.a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                    continue;
                default:
                    if (charAt <= '\u001f') {
                        this.a.write(String.format("\\u%04x", new Object[]{Integer.valueOf(charAt)}));
                        continue;
                    }
                    break;
            }
            this.a.write(charAt);
        }
        this.a.write("\"");
    }

    private void g() {
        if (this.c != null) {
            this.a.write("\n");
            for (int i = 1; i < this.b.size(); i++) {
                this.a.write(this.c);
            }
        }
    }

    private void a(boolean z) {
        switch (e()) {
            case EMPTY_DOCUMENT:
                if (this.e || z) {
                    a(bu.NONEMPTY_DOCUMENT);
                    return;
                }
                throw new IllegalStateException("JSON must start with an array or an object.");
            case EMPTY_ARRAY:
                a(bu.NONEMPTY_ARRAY);
                g();
                return;
            case NONEMPTY_ARRAY:
                this.a.append(',');
                g();
                return;
            case DANGLING_NAME:
                this.a.append(this.d);
                a(bu.NONEMPTY_OBJECT);
                return;
            case NONEMPTY_DOCUMENT:
                throw new IllegalStateException("JSON must have only one top-level value.");
            default:
                throw new IllegalStateException("Nesting problem: " + this.b);
        }
    }

    public final bx a(Object obj) {
        if (obj == null) {
            return f();
        }
        if (obj instanceof bv) {
            if (this.b.size() == this.b.size()) {
                return this;
            }
            throw new IllegalStateException(obj.getClass().getName() + ".writeToJson(JsonWriter) wrote incomplete value");
        } else if (obj instanceof Boolean) {
            boolean booleanValue = ((Boolean) obj).booleanValue();
            a(false);
            this.a.write(booleanValue ? "true" : "false");
            return this;
        } else if (obj instanceof Number) {
            if (obj instanceof Long) {
                return a(((Number) obj).longValue());
            }
            if (obj instanceof Double) {
                return a(((Number) obj).doubleValue());
            }
            Number number = (Number) obj;
            if (number == null) {
                return f();
            }
            CharSequence obj2 = number.toString();
            if (this.e || !(obj2.equals("-Infinity") || obj2.equals("Infinity") || obj2.equals("NaN"))) {
                a(false);
                this.a.append(obj2);
                return this;
            }
            throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
        } else if (obj instanceof String) {
            return b((String) obj);
        } else {
            if (obj instanceof bp) {
                return a((bp) obj);
            }
            if (obj instanceof Collection) {
                return a((Collection) obj);
            }
            if (obj instanceof Map) {
                return a((Map) obj);
            }
            if (obj instanceof Date) {
                Date date = (Date) obj;
                if (date == null) {
                    return f();
                }
                return b(z.a(date));
            } else if (obj instanceof Object[]) {
                return a((Object[]) obj);
            } else {
                throw new IllegalArgumentException("Unknown type: " + obj.getClass().getName());
            }
        }
    }

    private bx a(Object[] objArr) {
        if (objArr == null) {
            return f();
        }
        a();
        for (Object a : objArr) {
            a(a);
        }
        b();
        return this;
    }

    public final bx a(bp bpVar) {
        a(false);
        bpVar.a(this.a);
        return this;
    }

    public final bx a(Collection collection) {
        if (collection == null) {
            return f();
        }
        a();
        for (Object a : collection) {
            a(a);
        }
        b();
        return this;
    }

    public final bx a(Map map) {
        if (map == null) {
            return f();
        }
        c();
        for (Entry entry : map.entrySet()) {
            a(String.valueOf(entry.getKey()));
            a(entry.getValue());
        }
        d();
        return this;
    }
}
