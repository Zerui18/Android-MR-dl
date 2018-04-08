package com.tapjoy.internal;

import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tapjoy.internal.gl.c;
import com.tapjoy.internal.gl.f;
import com.tapjoy.internal.gl.f.a;
import com.tapjoy.internal.gl.i;
import com.tapjoy.internal.gl.j;
import com.tapjoy.internal.gl.l;
import com.tapjoy.internal.gl.n;
import com.tapjoy.internal.gl.r;
import com.tapjoy.internal.gl.z;
import java.util.Map;
import java.util.Map.Entry;

public final class ft {
    final fx a;
    final fs b;
    long c;
    private int d = 1;
    private final a e = f.j();

    ft(fx fxVar, fs fsVar) {
        this.a = fxVar;
        this.b = fsVar;
    }

    public final void a(String str, String str2, double d, String str3, String str4, String str5) {
        fx fxVar = this.a;
        synchronized (fxVar) {
            int b;
            double a;
            Editor a2 = fxVar.c.a();
            if (str2.equals(fxVar.c.l.a())) {
                b = fxVar.c.m.b() + 1;
                fxVar.c.m.a(a2, b);
                a = fxVar.c.n.a() + d;
                fxVar.c.n.a(a2, a);
                a2.commit();
            } else {
                fxVar.c.l.a(a2, str2);
                fxVar.c.m.a(a2, 1);
                fxVar.c.n.a(a2, d);
                fxVar.c.o.a(a2);
                fxVar.c.p.a(a2);
                a2.commit();
                fxVar.b.b(str2);
                z.a aVar = fxVar.b;
                aVar.b &= -4097;
                aVar.d = 0;
                aVar = fxVar.b;
                aVar.b &= -8193;
                aVar.e = 0.0d;
                b = 1;
                a = d;
            }
            fxVar.b.e(b);
            fxVar.b.a(a);
        }
        c.a a3 = a(i.APP, "purchase");
        r.a C = r.C();
        if (str == null) {
            throw new NullPointerException();
        }
        C.b |= 1;
        C.c = str;
        if (str2 != null) {
            if (str2 == null) {
                throw new NullPointerException();
            }
            C.b |= 8;
            C.d = str2;
        }
        C.a(d);
        if (str5 != null) {
            if (str5 == null) {
                throw new NullPointerException();
            }
            C.b |= 1024;
            C.e = str5;
        }
        if (str3 != null) {
            if (str3 == null) {
                throw new NullPointerException();
            }
            C.b |= 4096;
            C.f = str3;
        }
        if (str4 != null) {
            if (str4 == null) {
                throw new NullPointerException();
            }
            C.b |= 8192;
            C.g = str4;
        }
        r d2 = C.d();
        if (d2.c()) {
            a3.k = d2;
            a3.b |= 8192;
            a(a3);
            fx fxVar2 = this.a;
            long j = a3.e;
            synchronized (fxVar2) {
                Editor a4 = fxVar2.c.a();
                fxVar2.c.o.a(a4, j);
                fxVar2.c.p.a(a4, d);
                a4.commit();
                fxVar2.b.e(j);
                fxVar2.b.b(d);
            }
            return;
        }
        throw new dz();
    }

    public final void a(String str, String str2, String str3, String str4, Map map) {
        c.a a = a(i.CUSTOM, str2);
        if (str != null) {
            if (str == null) {
                throw new NullPointerException();
            }
            a.b |= 131072;
            a.m = str;
        }
        if (str3 != null) {
            if (str3 == null) {
                throw new NullPointerException();
            }
            a.b |= 262144;
            a.n = str3;
        }
        if (str4 != null) {
            if (str4 == null) {
                throw new NullPointerException();
            }
            a.b |= 524288;
            a.o = str4;
        }
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a.a(j.h().a((String) entry.getKey()).a(((Long) entry.getValue()).longValue()));
            }
        }
        a(a);
    }

    public final void a(String str, String str2, int i, long j, long j2, Map map) {
        c.a a = a(i.USAGES, str);
        if (str2 == null) {
            throw new NullPointerException();
        }
        a.b |= 2097152;
        a.p = str2;
        a.b(i);
        a.e(j);
        a.f(j2);
        if (map != null) {
            for (Entry entry : map.entrySet()) {
                a.a(j.h().a((String) entry.getKey()).a(((Long) entry.getValue()).longValue()));
            }
        }
        a(a);
    }

    public final c.a a(i iVar, String str) {
        n b = this.a.b();
        c.a L = c.L();
        String str2 = fx.a;
        if (str2 == null) {
            throw new NullPointerException();
        }
        L.b |= 16;
        L.f = str2;
        L = L.a(iVar);
        if (str == null) {
            throw new NullPointerException();
        }
        L.b |= 2;
        L.d = str;
        if (y.c()) {
            L.a(y.b()).b(System.currentTimeMillis());
        } else {
            L.a(System.currentTimeMillis()).c(SystemClock.elapsedRealtime());
        }
        l lVar = b.c;
        if (lVar == null) {
            throw new NullPointerException();
        }
        L.g = lVar;
        L.b |= 128;
        gl.a aVar = b.d;
        if (aVar == null) {
            throw new NullPointerException();
        }
        L.h = aVar;
        L.b |= 256;
        z zVar = b.e;
        if (zVar == null) {
            throw new NullPointerException();
        }
        L.i = zVar;
        L.b |= 512;
        return L;
    }

    public final synchronized void a(c.a aVar) {
        if (aVar.c != i.USAGES) {
            String str;
            dk dkVar;
            int i = this.d;
            this.d = i + 1;
            aVar.a(i);
            if (this.e.c()) {
                f d = this.e.d();
                if (d.c()) {
                    aVar.j = d;
                    aVar.b |= 4096;
                } else {
                    throw new dz();
                }
            }
            this.e.a(aVar.c);
            a aVar2 = this.e;
            Object obj = aVar.d;
            if (obj instanceof String) {
                str = (String) obj;
            } else {
                dkVar = (dk) obj;
                String e = dkVar.e();
                if (dkVar.f()) {
                    aVar.d = e;
                }
                obj = e;
            }
            if (obj == null) {
                throw new NullPointerException();
            }
            aVar2.b |= 2;
            aVar2.c = obj;
            if ((aVar.b & 131072) == 131072) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                a aVar3 = this.e;
                obj = aVar.m;
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    dkVar = (dk) obj;
                    String e2 = dkVar.e();
                    if (dkVar.f()) {
                        aVar.m = e2;
                    }
                    obj = e2;
                }
                if (obj == null) {
                    throw new NullPointerException();
                }
                aVar3.b |= 4;
                aVar3.d = obj;
            } else {
                a aVar4 = this.e;
                aVar4.b &= -5;
                aVar4.d = f.d().i();
            }
        }
        fs fsVar = this.b;
        c d2 = aVar.d();
        if (d2.c()) {
            try {
                gg ggVar = fsVar.a;
                synchronized (ggVar.a) {
                    try {
                        ggVar.b.add(d2);
                    } catch (Exception e3) {
                        ggVar.a();
                        try {
                            ggVar.b.add(d2);
                        } catch (Exception e4) {
                        }
                    }
                }
                if (fsVar.b == null) {
                    fsVar.a.flush();
                } else if (fr.a || d2.c != i.CUSTOM) {
                    fsVar.a(true);
                } else {
                    fsVar.a(false);
                }
            } catch (Exception e5) {
            }
        } else {
            throw new dz();
        }
    }
}
