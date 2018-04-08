package com.tapjoy.internal;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class fb extends fa {
    private final File b;
    private final ft c;
    private volatile SQLiteDatabase d;
    private long e;
    private long f;
    private long g;

    protected void a(long r26, java.lang.String r28, java.lang.String r29, java.util.Map r30) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:64:0x0147 in {4, 6, 13, 16, 17, 21, 33, 34, 37, 39, 46, 51, 52, 55, 58, 61, 63, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r25 = this;
        r0 = r25;
        r4 = r0.d;
        if (r4 != 0) goto L_0x0007;
    L_0x0006:
        return;
    L_0x0007:
        r0 = r25;
        r4 = r0.e;
        r6 = 0;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 != 0) goto L_0x014c;
    L_0x0011:
        r0 = r26;
        r2 = r25;
        r2.g = r0;
        r0 = r26;
        r2 = r25;
        r2.e = r0;
    L_0x001d:
        if (r29 != 0) goto L_0x0021;
    L_0x001f:
        r29 = "";
    L_0x0021:
        r0 = r25;
        r4 = r0.d;
        r5 = "SELECT ROWID,count,first_time,last_time FROM UsageStats WHERE name = ? AND dimensions = ?";
        r6 = 2;
        r6 = new java.lang.String[r6];
        r7 = 0;
        r6[r7] = r28;
        r7 = 1;
        r6[r7] = r29;
        r8 = r4.rawQuery(r5, r6);
        r9 = new android.content.ContentValues;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.<init>();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r8.moveToNext();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        if (r4 == 0) goto L_0x019e;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x003f:
        r4 = 0;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r8.getLong(r4);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6 = 1;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6 = r8.getInt(r6);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r7 = 2;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r10 = r8.getLong(r7);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r7 = 3;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r12 = r8.getLong(r7);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r7 = "count";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6 = r6 + 1;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6 = java.lang.Integer.valueOf(r6);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r7, r6);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6 = (r26 > r10 ? 1 : (r26 == r10 ? 0 : -1));	 Catch:{ all -> 0x020f, all -> 0x0147 }
        if (r6 >= 0) goto L_0x006b;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x0062:
        r6 = "first_time";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r7 = java.lang.Long.valueOf(r26);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r6, r7);	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x006b:
        r6 = (r26 > r12 ? 1 : (r26 == r12 ? 0 : -1));	 Catch:{ all -> 0x020f, all -> 0x0147 }
        if (r6 <= 0) goto L_0x0078;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x006f:
        r6 = "last_time";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r7 = java.lang.Long.valueOf(r26);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r6, r7);	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x0078:
        r0 = r25;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6 = r0.d;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r7 = "UsageStats";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r10 = new java.lang.StringBuilder;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r11 = "ROWID = ";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r10.<init>(r11);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r10 = r10.append(r4);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r10 = r10.toString();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r11 = 0;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6.update(r7, r9, r10, r11);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6 = r4;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x0092:
        if (r30 == 0) goto L_0x0214;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x0094:
        r4 = r30.isEmpty();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        if (r4 != 0) goto L_0x0214;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x009a:
        r4 = r30.entrySet();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r10 = r4.iterator();	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x00a2:
        r4 = r10.hasNext();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        if (r4 == 0) goto L_0x0214;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x00a8:
        r4 = r10.next();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = (java.util.Map.Entry) r4;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = r4.getValue();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        if (r5 == 0) goto L_0x00a2;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x00b4:
        r5 = r4.getKey();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = (java.lang.String) r5;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r4.getValue();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = (java.lang.Long) r4;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r12 = r4.longValue();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = 2;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = new java.lang.String[r4];	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r11 = 0;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14 = java.lang.Long.toString(r6);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4[r11] = r14;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r11 = 1;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4[r11] = r5;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r0 = r25;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r11 = r0.d;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14 = "SELECT ROWID, * FROM UsageStatValues WHERE stat_id = ? AND name = ?";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r11 = r11.rawQuery(r14, r4);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r11.moveToNext();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        if (r4 == 0) goto L_0x01d6;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x00e1:
        r4 = 0;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r11.getLong(r4);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14 = 3;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14 = r11.getInt(r14);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r15 = 4;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r16 = r11.getDouble(r15);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r15 = 5;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r18 = r11.getLong(r15);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.clear();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r15 = "count";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r20 = r14 + 1;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r20 = java.lang.Integer.valueOf(r20);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r0 = r20;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r15, r0);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r15 = "avg";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r0 = (double) r12;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r20 = r0;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r20 = r20 - r16;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14 = r14 + 1;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r0 = (double) r14;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r22 = r0;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r20 = r20 / r22;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r16 = r16 + r20;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14 = java.lang.Double.valueOf(r16);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r15, r14);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1));	 Catch:{ all -> 0x020f, all -> 0x0147 }
        if (r14 <= 0) goto L_0x0129;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x0120:
        r14 = "max";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r12 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r14, r12);	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x0129:
        r0 = r25;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r12 = r0.d;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r13 = "UsageStatValues";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14 = new java.lang.StringBuilder;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r15 = "ROWID = ";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14.<init>(r15);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r14.append(r4);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r4.toString();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = 0;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r12.update(r13, r9, r4, r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x0142:
        r11.close();
        goto L_0x00a2;
    L_0x0147:
        r4 = move-exception;
        r8.close();
        throw r4;
    L_0x014c:
        r0 = r25;
        r4 = r0.e;
        r4 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1));
        if (r4 < 0) goto L_0x0170;
    L_0x0154:
        r0 = r25;
        r4 = r0.e;
        r6 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r4 = r4 + r6;
        r4 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1));
        if (r4 >= 0) goto L_0x0170;
    L_0x0160:
        r0 = r25;
        r4 = r0.g;
        r4 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1));
        if (r4 <= 0) goto L_0x001d;
    L_0x0168:
        r0 = r26;
        r2 = r25;
        r2.g = r0;
        goto L_0x001d;
    L_0x0170:
        r0 = r25;
        r4 = r0.e;
        r4 = (r26 > r4 ? 1 : (r26 == r4 ? 0 : -1));
        if (r4 >= 0) goto L_0x018d;
    L_0x0178:
        r0 = r25;
        r4 = r0.g;
        r4 = r4 - r26;
        r6 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r4 >= 0) goto L_0x018d;
    L_0x0185:
        r0 = r26;
        r2 = r25;
        r2.e = r0;
        goto L_0x001d;
    L_0x018d:
        r25.b();
        r0 = r26;
        r2 = r25;
        r2.g = r0;
        r0 = r26;
        r2 = r25;
        r2.e = r0;
        goto L_0x001d;
    L_0x019e:
        r4 = "name";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r0 = r28;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r0);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = "dimensions";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r0 = r29;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r0);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = "count";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = 1;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = "first_time";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = java.lang.Long.valueOf(r26);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = "last_time";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = java.lang.Long.valueOf(r26);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r0 = r25;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r0.d;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = "UsageStats";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6 = 0;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r4.insert(r5, r6, r9);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r6 = r4;
        goto L_0x0092;
    L_0x01d6:
        r9.clear();	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = "stat_id";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r14 = java.lang.Long.valueOf(r6);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r14);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = "name";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = "count";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = 1;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = "avg";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = "max";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = java.lang.Long.valueOf(r12);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r9.put(r4, r5);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r0 = r25;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4 = r0.d;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r5 = "UsageStatValues";	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r12 = 0;	 Catch:{ all -> 0x020f, all -> 0x0147 }
        r4.insert(r5, r12, r9);	 Catch:{ all -> 0x020f, all -> 0x0147 }
        goto L_0x0142;
    L_0x020f:
        r4 = move-exception;
        r11.close();
        throw r4;	 Catch:{ all -> 0x020f, all -> 0x0147 }
    L_0x0214:
        r8.close();
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tapjoy.internal.fb.a(long, java.lang.String, java.lang.String, java.util.Map):void");
    }

    public fb(File file, ft ftVar) {
        this.b = file;
        this.c = ftVar;
    }

    protected void finalize() {
        if (this.d != null) {
            da.a(this.d);
            this.d = null;
        }
        super.finalize();
    }

    protected void a(long j) {
        if (this.d == null) {
            this.d = SQLiteDatabase.openOrCreateDatabase(this.b, null);
            int version = this.d.getVersion();
            switch (version) {
                case 0:
                    this.d.beginTransaction();
                    try {
                        this.d.execSQL("CREATE TABLE IF NOT EXISTS UsageStats(name TEXT,dimensions TEXT,count INTEGER,first_time INTEGER,last_time INTEGER,PRIMARY KEY(name, dimensions))");
                        this.d.execSQL("CREATE TABLE IF NOT EXISTS UsageStatValues(stat_id LONG,name TEXT,count INTEGER,avg REAL,max INTEGER,PRIMARY KEY(stat_id, name))");
                        this.d.setVersion(1);
                        this.d.setTransactionSuccessful();
                        break;
                    } finally {
                        this.d.endTransaction();
                    }
                case 1:
                    break;
                default:
                    throw new SQLException("Unknown database version: " + version);
            }
            Cursor rawQuery = this.d.rawQuery("SELECT MIN(first_time), MAX(last_time) FROM UsageStats", null);
            try {
                if (rawQuery.moveToNext()) {
                    this.f = rawQuery.getLong(0);
                    this.g = rawQuery.getLong(1);
                }
                rawQuery.close();
                if (this.f > 0 && this.f + 86400000 <= j) {
                    b();
                }
            } catch (Throwable th) {
                rawQuery.close();
            }
        }
    }

    protected void a() {
        if (this.d != null) {
            da.a(this.d);
            this.d = null;
        }
        this.b.delete();
        this.g = 0;
        this.f = 0;
    }

    private void b() {
        Set set = fa.a;
        Cursor rawQuery = this.d.rawQuery("SELECT ROWID, * FROM UsageStats ORDER BY ROWID ASC", null);
        Cursor rawQuery2;
        try {
            rawQuery2 = this.d.rawQuery("SELECT * FROM UsageStatValues ORDER BY stat_id ASC", null);
            rawQuery2.moveToNext();
            while (rawQuery.moveToNext()) {
                long j = rawQuery.getLong(0);
                String string = rawQuery.getString(1);
                String string2 = rawQuery.getString(2);
                if (string2.isEmpty()) {
                    string2 = null;
                }
                int i = rawQuery.getInt(3);
                long j2 = rawQuery.getLong(4);
                long j3 = rawQuery.getLong(5);
                Map map = null;
                if (!rawQuery2.isAfterLast()) {
                    while (rawQuery2.getLong(0) == j) {
                        if (map == null) {
                            map = new HashMap();
                        }
                        String string3 = rawQuery2.getString(1);
                        long j4 = rawQuery2.getLong(3);
                        long j5 = rawQuery2.getLong(4);
                        map.put(string3, Long.valueOf(j4));
                        map.put(string3 + "_max", Long.valueOf(j5));
                        if (!rawQuery2.moveToNext()) {
                            break;
                        }
                    }
                }
                if (set == null || !set.contains(string)) {
                    this.c.a(string, string2, i, j2, j3, map);
                }
            }
        } catch (Throwable th) {
        } finally {
            
/*
Method generation error in method: com.tapjoy.internal.fb.b():void
jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b3: INVOKE  (wrap: android.database.Cursor
  ?: MERGE  (r13_2 android.database.Cursor) = (r13_1 'rawQuery2' android.database.Cursor), (r12_0 'rawQuery' android.database.Cursor)) android.database.Cursor.close():void type: INTERFACE in method: com.tapjoy.internal.fb.b():void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:203)
	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:100)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:50)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:297)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
Caused by: jadx.core.utils.exceptions.CodegenException: Error generate insn: ?: MERGE  (r13_2 android.database.Cursor) = (r13_1 'rawQuery2' android.database.Cursor), (r12_0 'rawQuery' android.database.Cursor) in method: com.tapjoy.internal.fb.b():void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:226)
	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:101)
	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:84)
	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:625)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:220)
	... 20 more
Caused by: jadx.core.utils.exceptions.CodegenException: MERGE can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:530)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:514)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:211)
	... 25 more

*/
        }
