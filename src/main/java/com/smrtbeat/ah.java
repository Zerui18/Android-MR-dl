package com.smrtbeat;

import java.nio.ByteBuffer;

class ah implements Runnable {
    ByteBuffer a;
    final /* synthetic */ ag b;

    ah(ag agVar) {
        this.b = agVar;
    }

    Runnable a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        return this;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
        r6 = this;
        r5 = 0;
        r0 = com.smrtbeat.g.S;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0 = r0.length();	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        if (r0 <= 0) goto L_0x0052;
    L_0x0009:
        r0 = r6.a;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r1 = java.nio.ByteOrder.nativeOrder();	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0 = r0.order(r1);	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r1 = 0;
        r0.position(r1);	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0 = r6.a;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0 = com.smrtbeat.SmartBeatJni.copyTextureBuffer(r0);	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        if (r0 == 0) goto L_0x0052;
    L_0x001f:
        r0 = r6.b;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0 = r0.p;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r1 = r6.a;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0.copyPixelsFromBuffer(r1);	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0 = 0;
        r6.a = r0;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0 = r6.b;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0 = r0.r;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r1 = r6.b;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r1 = r1.p;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r2 = 0;
        r3 = 0;
        r4 = new android.graphics.Paint;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r4.<init>();	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0.drawBitmap(r1, r2, r3, r4);	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r0 = com.smrtbeat.h.EGles;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r1 = r6.b;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r1 = r1.q;	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0058, all -> 0x005f }
        com.smrtbeat.bd.a(r0, r1, r2);	 Catch:{ Exception -> 0x0058, all -> 0x005f }
    L_0x0052:
        r0 = r6.b;
        r0.s = r5;
    L_0x0057:
        return;
    L_0x0058:
        r0 = move-exception;
        r0 = r6.b;
        r0.s = r5;
        goto L_0x0057;
    L_0x005f:
        r0 = move-exception;
        r1 = r6.b;
        r1.s = r5;
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smrtbeat.ah.run():void");
    }
}
