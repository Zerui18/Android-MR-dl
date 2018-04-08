package com.smrtbeat;

import com.tapjoy.TJAdUnitConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

class ae {
    private static final String a = "yyyy-MM-dd HH:mm:ss.SSS Z";
    private static ae b = new ae();
    private List c = new ArrayList();
    private int d = 0;
    private SimpleDateFormat e = new SimpleDateFormat(a);

    private ae() {
        this.e.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    static ae a() {
        return b;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(int r7, int r8) {
        /*
        r6 = this;
        r1 = 0;
        r0 = r6.c;
        r0 = r0.size();
        r3 = r0;
        r0 = r1;
    L_0x0009:
        if (r3 > r7) goto L_0x0028;
    L_0x000b:
        r2 = r6.d;
        if (r2 > r8) goto L_0x0028;
    L_0x000f:
        r0 = r6.c;
        r0 = r0.size();
        if (r0 <= r3) goto L_0x0027;
    L_0x0017:
        r0 = r6.c;
        r2 = r6.c;
        r2 = r2.size();
        r2 = r2 - r3;
        r0 = r0.subList(r1, r2);
        r0.clear();
    L_0x0027:
        return;
    L_0x0028:
        if (r3 > 0) goto L_0x0032;
    L_0x002a:
        r0 = com.smrtbeat.bg.WARN;
        r2 = "Count or size of log data is strange.";
        com.smrtbeat.bd.a(r0, r2);
        goto L_0x000f;
    L_0x0032:
        r4 = r6.d;
        r5 = r6.c;
        r2 = r0 + 1;
        r0 = r5.get(r0);
        r0 = (com.smrtbeat.af) r0;
        r0 = r0.b;
        r0 = r4 - r0;
        r6.d = r0;
        r0 = r3 + -1;
        r3 = r0;
        r0 = r2;
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smrtbeat.ae.a(int, int):void");
    }

    void a(String str) {
        synchronized (this) {
            af afVar = new af(new StringBuilder(String.valueOf(this.e.format(new Date()))).append(": ").append(str).toString());
            this.c.add(afVar);
            this.d = afVar.b + this.d;
            a(TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL, 65536);
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        synchronized (this) {
            for (af afVar : this.c) {
                stringBuilder.append(afVar.a);
            }
        }
        return stringBuilder.toString();
    }
}
