package co.cyberz.fox.service;

import android.content.Context;
import co.cyberz.util.c.b;
import co.cyberz.util.string.StringUtil;
import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a {
    private Context a = co.cyberz.fox.a.a().d;
    private volatile ArrayList<co.cyberz.fox.b.a> b = new ArrayList();
    private final String c = (this.a.getFilesDir().getPath() + "/__e.fox");
    private final int d = 5;
    private final int e = 1000;
    private final long f = 1048576;
    private final String g = "__e.fox";
    private final String h = "\n";
    private a i = new a();

    private class a implements Runnable {
        final /* synthetic */ a a;

        private a(a aVar) {
            this.a = aVar;
        }

        public final void run() {
            this.a.c();
        }
    }

    public a() {
        byte b = (byte) 0;
        File file = new File(this.c);
        if (file.exists() && 1048576 <= file.length()) {
            b = (byte) 1;
        }
        if (b != (byte) 0) {
            File file2 = new File(this.c);
            if (file2.exists()) {
                file2.delete();
            }
        } else {
            this.b = b(e());
        }
        new StringBuilder("[Constructor] Load Csv queue size : ").append(this.b.size());
        b();
    }

    private synchronized void a(String str) {
        if (!StringUtil.isEmpty(str)) {
            try {
                b.a(this.c, str);
            } catch (IOException e) {
            }
        }
    }

    private void a(ArrayList<co.cyberz.fox.b.a> arrayList) {
        try {
            b((ArrayList) arrayList);
            d();
        } catch (Exception e) {
        }
    }

    private void a(List<co.cyberz.fox.b.a> list) {
        for (int i = 0; i < list.size(); i++) {
            this.b.set(i, list.get(i));
        }
    }

    private static ArrayList<co.cyberz.fox.b.a> b(String str) {
        if (StringUtil.isEmpty(str)) {
            return new ArrayList();
        }
        String[] split = StringUtil.split(str, "#");
        ArrayList<co.cyberz.fox.b.a> arrayList = new ArrayList();
        for (String str2 : split) {
            if (!StringUtil.isEmpty(str2)) {
                co.cyberz.fox.b.a aVar = new co.cyberz.fox.b.a();
                aVar.v = str2;
                arrayList.add(aVar);
            }
        }
        return arrayList;
    }

    private void b(ArrayList<co.cyberz.fox.b.a> arrayList) {
        List arrayList2 = new ArrayList();
        for (co.cyberz.fox.b.a aVar : arrayList) {
            Object[] split = StringUtil.split(aVar.v, ",");
            aVar.p = Integer.parseInt(split[22]);
            int i = aVar.p + 1;
            aVar.p = i;
            split[22] = Integer.toString(i);
            aVar.v = StringUtil.join(split, ",");
            arrayList2.add(aVar);
        }
        a(arrayList2);
    }

    private static ArrayList<co.cyberz.fox.b.a> c(ArrayList<co.cyberz.fox.b.a> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        int size = arrayList.size() < 5 ? arrayList.size() : 5;
        ArrayList<co.cyberz.fox.b.a> arrayList2 = new ArrayList();
        for (int i = 0; i < size; i++) {
            co.cyberz.fox.b.a aVar = (co.cyberz.fox.b.a) arrayList.get(i);
            if (StringUtil.isEmpty(aVar.v)) {
                aVar.a();
            }
            arrayList2.add(aVar);
        }
        return arrayList2;
    }

    private synchronized String e() {
        return b.a(this.c);
    }

    private void f() {
        int i = 5;
        if (this.b.size() < 5) {
            i = this.b.size();
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (this.b.size() > 0) {
                this.b.remove(0);
            }
        }
    }

    private synchronized boolean g() {
        boolean z;
        z = false;
        try {
            z = b.a(this.c, "");
        } catch (IOException e) {
        }
        return z;
    }

    public final synchronized void a() {
        co.cyberz.common.a.a.b(new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public final void run() {
                this.a.d();
            }
        });
    }

    public final synchronized void a(co.cyberz.fox.b.a aVar) {
        if (this.b.size() == 1000) {
            this.b.remove(0);
        }
        this.b.add(aVar);
    }

    public final synchronized void b() {
        co.cyberz.common.a.a.b(this.i);
    }

    final synchronized void c() {
        new StringBuilder("[sendEvent] eventQueue size : ").append(this.b.size());
        Object obj = 1;
        while (this.b.size() > 0 && r2 != null) {
            ArrayList c = c(this.b);
            if (c == null) {
                break;
            }
            new StringBuilder("[sendEvent] sendList : ").append(c.size());
            try {
                Object obj2;
                String join = StringUtil.join((List) c, "#");
                co.cyberz.util.f.a.a("[F.O.X] Event Info : " + join);
                String a = co.cyberz.util.h.a.a(join, co.cyberz.util.h.a.a.XUNIQ);
                co.cyberz.fox.a.a aVar = new co.cyberz.fox.a.a(a);
                Object obj3 = null;
                int i = 0;
                while (!StringUtil.isEmpty(a) && r3 == null) {
                    int i2 = i + 1;
                    try {
                        Integer num = (Integer) aVar.i();
                        if (num == null || num.intValue() != 200) {
                            Thread.sleep(3000);
                            b(c);
                        } else {
                            f();
                            obj3 = 1;
                        }
                        if (this.b.size() > 0) {
                            d();
                            i = i2;
                        } else {
                            g();
                            i = i2;
                        }
                    } catch (UnknownHostException e) {
                        obj = obj3;
                        try {
                            new StringBuilder("[sendEvent] UnknownHostException : ").append(e.getMessage());
                            a(c);
                            if (i2 == 10) {
                                obj2 = null;
                                break;
                            }
                            try {
                                Thread.sleep(3000);
                                obj3 = obj;
                                i = i2;
                                obj = null;
                            } catch (InterruptedException e2) {
                                obj3 = obj;
                                i = i2;
                                obj = null;
                            }
                        } catch (Exception e3) {
                            obj = null;
                        }
                    }
                }
                obj2 = obj;
                obj = obj2;
            } catch (Exception e4) {
            }
        }
        if (obj == null) {
            co.cyberz.util.f.a.c("Could not connect to the network. Please check the network state of this device.");
        }
        a(c);
        if (obj == null) {
            co.cyberz.util.f.a.c("Could not connect to the network. Please check the network state of this device.");
        }
    }

    final synchronized void d() {
        if (this.b.size() != 0) {
            List arrayList = new ArrayList(this.b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                co.cyberz.fox.b.a aVar = (co.cyberz.fox.b.a) it.next();
                if (StringUtil.isEmpty(aVar.v)) {
                    aVar.a();
                }
            }
            a(StringUtil.join(arrayList, "\n"));
        }
    }
}
