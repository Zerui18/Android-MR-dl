package co.cyberz.fox.service;

import co.cyberz.common.a.a;
import co.cyberz.fox.Fox;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import org.json.JSONObject;

public final class c {
    public static long a = 0;
    private static String c;
    private static String g = "";
    public JSONObject b = null;
    private String d;
    private String e = "";
    private int f = 0;
    private a h;

    class AnonymousClass2 implements Runnable {
        final /* synthetic */ FoxEvent a;
        final /* synthetic */ c b;

        public AnonymousClass2(c cVar, FoxEvent foxEvent) {
            this.b = cVar;
            this.a = foxEvent;
        }

        public final void run() {
            if (this.a.isPurchase || 0.0d < this.a.price) {
                c.a(this.b, this.a);
            } else {
                c.b(this.b, this.a);
            }
        }
    }

    public c() {
        if (this.h == null) {
            this.h = new a();
        }
        if (c == null) {
            c = UUID.randomUUID().toString();
        } else if (System.currentTimeMillis() - a > 30000) {
            c = UUID.randomUUID().toString();
        }
        this.d = UUID.randomUUID().toString();
        g = UUID.randomUUID().toString();
        if (Fox.isConversionCompleted()) {
            a.a(new co.cyberz.fox.service.f.AnonymousClass2(new f(), g));
        }
    }

    public static void a() {
        f fVar = new f();
        f.a(g);
    }

    private synchronized void a(co.cyberz.fox.b.a aVar) {
        int i = this.f;
        this.f = i + 1;
        aVar.a = i;
        aVar.f = UUID.randomUUID().toString();
        aVar.g = g;
        aVar.e = c;
        aVar.d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        this.h.a(aVar);
        this.h.a();
        this.h.b();
    }

    static /* synthetic */ void a(c cVar, FoxEvent foxEvent) {
        co.cyberz.fox.b.a aVar = new co.cyberz.fox.b.a();
        aVar.b = co.cyberz.fox.b.a.a.AnalyticsEventTrackTransaction;
        aVar.c = foxEvent.eventName;
        aVar.j = foxEvent.orderId;
        aVar.k = foxEvent.sku;
        aVar.l = foxEvent.itemName;
        aVar.m = foxEvent.price;
        aVar.n = foxEvent.quantity;
        aVar.o = foxEvent.currency;
        aVar.r = cVar.d;
        aVar.s = cVar.e;
        aVar.t = foxEvent.eventInfo;
        aVar.u = cVar.b;
        cVar.a(aVar);
    }

    public static void a(String str) {
        new f().a(str, g);
    }

    static /* synthetic */ void b(c cVar, FoxEvent foxEvent) {
        co.cyberz.fox.b.a aVar = new co.cyberz.fox.b.a();
        aVar.b = co.cyberz.fox.b.a.a.AnalyticsEventTrackEvent;
        aVar.c = foxEvent.eventName;
        aVar.i = foxEvent.value;
        aVar.r = cVar.d;
        aVar.s = cVar.e;
        aVar.t = foxEvent.eventInfo;
        aVar.u = cVar.b;
        cVar.a(aVar);
    }
}
