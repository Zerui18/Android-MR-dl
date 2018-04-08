package com.smrtbeat;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import org.json.JSONObject;

class i {
    private static final String a = ".id";
    private static boolean b = false;
    private static final ReentrantLock c = new ReentrantLock();
    private static final long d = 3600000;
    private static /* synthetic */ int[] e;

    i() {
    }

    static ar a(File file, long j) {
        return (file == null || !file.exists()) ? new ar() : !bd.k() ? new ar() : bc.a(new r().a(file), j);
    }

    static void a() {
        if (g.P) {
            Context a = g.a();
            if (a != null) {
                SharedPreferences e = bd.e(a);
                if (a(e)) {
                    new Thread(new j().a(e)).start();
                }
            }
        }
    }

    public static void a(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File a : listFiles) {
                a(a);
            }
        }
        file.delete();
    }

    static void a(JSONObject jSONObject) {
        if (b(jSONObject, true).a() != as.OK) {
            c(jSONObject);
        }
    }

    static void a(JSONObject jSONObject, long j) {
        k();
        bd.a(bg.INFO, "SendCrashEvent");
        if (bc.a(new n().a(jSONObject), j).a() != as.OK) {
            b(jSONObject);
        }
    }

    static void a(JSONObject jSONObject, File file, long j) {
        Object obj = 1;
        j();
        File file2 = new File(o());
        c(jSONObject, file2.getAbsolutePath());
        File file3 = new File(q());
        Object obj2 = bc.a(new o().a(file2, file, file3), j).a() == as.OK ? 1 : null;
        if (m() < g.R) {
            obj = null;
        }
        if (obj2 == null && r1 == null) {
            File file4 = new File(p());
            file4.getParentFile().mkdirs();
            file2.renameTo(file4);
            file.renameTo(file3);
            return;
        }
        file.delete();
        file2.delete();
    }

    private static boolean a(SharedPreferences sharedPreferences) {
        if (!bd.h()) {
            return false;
        }
        long c = bd.c(sharedPreferences);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        return (c == 0 || elapsedRealtime - c > 21600000 || c > elapsedRealtime) && !b;
    }

    private static boolean a(File file, File[] fileArr) {
        if (fileArr == null) {
            return false;
        }
        CharSequence charSequence = file.getName() + a;
        for (File name : fileArr) {
            if (name.getName().contentEquals(charSequence)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.smrtbeat.ar b(java.lang.String r8, org.json.JSONObject r9, boolean r10) {
        /*
        r3 = 0;
        r1 = new com.smrtbeat.ar;
        r1.<init>();
        r0 = com.smrtbeat.g.m;
        r0 = r0.length();
        if (r0 > 0) goto L_0x0017;
    L_0x000e:
        r0 = com.smrtbeat.bg.ERROR;
        r2 = "Data cannot send due to invalide api key.";
        com.smrtbeat.bd.a(r0, r2);
        r0 = r1;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x0088, all -> 0x00af }
        r0.<init>(r8);	 Catch:{ Exception -> 0x0088, all -> 0x00af }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x0088, all -> 0x00af }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0088, all -> 0x00af }
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0.setReadTimeout(r2);	 Catch:{ Exception -> 0x00c9, all -> 0x00c0 }
        r2 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r0.setConnectTimeout(r2);	 Catch:{ Exception -> 0x00c9, all -> 0x00c0 }
        r2 = "X-SmartBeat-Api-Key";
        r4 = com.smrtbeat.g.m;	 Catch:{ Exception -> 0x00c9, all -> 0x00c0 }
        r0.addRequestProperty(r2, r4);	 Catch:{ Exception -> 0x00c9, all -> 0x00c0 }
        r2 = "Content-Type";
        r4 = "application/json";
        r0.setRequestProperty(r2, r4);	 Catch:{ Exception -> 0x00c9, all -> 0x00c0 }
        if (r10 == 0) goto L_0x0043;
    L_0x003c:
        r2 = "Content-Encoding";
        r4 = "gzip";
        r0.setRequestProperty(r2, r4);	 Catch:{ Exception -> 0x00c9, all -> 0x00c0 }
    L_0x0043:
        r2 = 1;
        r0.setDoOutput(r2);	 Catch:{ Exception -> 0x00c9, all -> 0x00c0 }
        r2 = 0;
        r0.setChunkedStreamingMode(r2);	 Catch:{ Exception -> 0x00c9, all -> 0x00c0 }
        r3 = r0.getOutputStream();	 Catch:{ Exception -> 0x00c9, all -> 0x00c0 }
        if (r10 == 0) goto L_0x0057;
    L_0x0051:
        r2 = new java.util.zip.GZIPOutputStream;	 Catch:{ Exception -> 0x00cf, all -> 0x00c0 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00cf, all -> 0x00c0 }
        r3 = r2;
    L_0x0057:
        r2 = r9.toString();	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
        r4 = "UTF-8";
        r2 = r2.getBytes(r4);	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
        r3.write(r2);	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
        r3.flush();	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
        r3.close();	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
        r2 = r0.getResponseCode();	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
        r1.a = r2;	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
        r2 = r1.a;	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 != r4) goto L_0x007c;
    L_0x0076:
        r2 = com.smrtbeat.bd.a(r0);	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
        r1.b = r2;	 Catch:{ Exception -> 0x00d5, all -> 0x00c0 }
    L_0x007c:
        if (r0 == 0) goto L_0x0081;
    L_0x007e:
        r0.disconnect();
    L_0x0081:
        if (r3 == 0) goto L_0x0086;
    L_0x0083:
        r3.close();	 Catch:{ IOException -> 0x00be }
    L_0x0086:
        r0 = r1;
        goto L_0x0016;
    L_0x0088:
        r0 = move-exception;
        r2 = r3;
    L_0x008a:
        r4 = com.smrtbeat.bg.DEBUG;	 Catch:{ all -> 0x00c5 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00c5 }
        r6 = "failed to send data";
        r5.<init>(r6);	 Catch:{ all -> 0x00c5 }
        r0 = r0.toString();	 Catch:{ all -> 0x00c5 }
        r0 = r5.append(r0);	 Catch:{ all -> 0x00c5 }
        r0 = r0.toString();	 Catch:{ all -> 0x00c5 }
        com.smrtbeat.bd.a(r4, r0);	 Catch:{ all -> 0x00c5 }
        if (r3 == 0) goto L_0x00a7;
    L_0x00a4:
        r3.disconnect();
    L_0x00a7:
        if (r2 == 0) goto L_0x0086;
    L_0x00a9:
        r2.close();	 Catch:{ IOException -> 0x00ad }
        goto L_0x0086;
    L_0x00ad:
        r0 = move-exception;
        goto L_0x0086;
    L_0x00af:
        r0 = move-exception;
        r1 = r3;
    L_0x00b1:
        if (r1 == 0) goto L_0x00b6;
    L_0x00b3:
        r1.disconnect();
    L_0x00b6:
        if (r3 == 0) goto L_0x00bb;
    L_0x00b8:
        r3.close();	 Catch:{ IOException -> 0x00bc }
    L_0x00bb:
        throw r0;
    L_0x00bc:
        r1 = move-exception;
        goto L_0x00bb;
    L_0x00be:
        r0 = move-exception;
        goto L_0x0086;
    L_0x00c0:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00b1;
    L_0x00c5:
        r0 = move-exception;
        r1 = r3;
        r3 = r2;
        goto L_0x00b1;
    L_0x00c9:
        r2 = move-exception;
        r7 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x008a;
    L_0x00cf:
        r2 = move-exception;
        r7 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x008a;
    L_0x00d5:
        r2 = move-exception;
        r7 = r2;
        r2 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x008a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smrtbeat.i.b(java.lang.String, org.json.JSONObject, boolean):com.smrtbeat.ar");
    }

    private static ar b(JSONObject jSONObject, boolean z) {
        return b("https://api.smbeat.jp/api/errors", jSONObject, z);
    }

    static void b() {
        if (g.af == null && i()) {
            h();
        }
    }

    private static void b(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.isFile()) {
                    String d = d(file2);
                    if (d.length() > 0) {
                        try {
                            switch (e()[b(new JSONObject(d), true).a().ordinal()]) {
                                case 1:
                                    file2.delete();
                                    break;
                                case 2:
                                    c(file2);
                                    break;
                                default:
                                    break;
                            }
                        } catch (JSONException e) {
                        }
                    }
                }
            }
        }
    }

    private static void b(JSONObject jSONObject) {
        if (m() >= g.R) {
            bd.a(bg.INFO, "Dropped CrashData due to Event full");
        } else {
            b(jSONObject, n());
        }
    }

    private static void b(JSONObject jSONObject, String str) {
        new Thread(new p().a(str, jSONObject)).start();
    }

    private static boolean b(String str) {
        try {
            return "OK".equals(new JSONObject(str).get("status"));
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean b(JSONObject jSONObject, String str, boolean z) {
        try {
            return "true".equalsIgnoreCase(jSONObject.getString(str)) ? true : z;
        } catch (JSONException e) {
            return z;
        }
    }

    static void c() {
        new Thread(new t()).start();
    }

    private static void c(JSONObject jSONObject) {
        if (r() >= g.R) {
            bd.a(bg.INFO, "Dropped ExceptionData due to Event full");
        } else {
            b(jSONObject, s());
        }
    }

    private static void c(JSONObject jSONObject, String str) {
        File file = new File(str);
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file), 8192);
            bufferedWriter.write(jSONObject.toString());
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
        }
    }

    private static boolean c(File file) {
        int i;
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        int lastIndexOf2 = name.lastIndexOf(".", lastIndexOf - 1);
        if (lastIndexOf < 0 || lastIndexOf2 < 0) {
            i = 0;
        } else {
            try {
                i = Integer.valueOf(name.substring(lastIndexOf2 + 1, lastIndexOf)).intValue();
            } catch (NumberFormatException e) {
                i = 0;
            }
        }
        i++;
        if (i >= 3) {
            file.delete();
            return true;
        }
        if (lastIndexOf >= 0) {
            if (lastIndexOf2 < 0) {
                lastIndexOf2 = lastIndexOf;
            }
            file.renameTo(new File(new StringBuilder(String.valueOf(file.getParent() + File.separator)).append(name.substring(0, lastIndexOf2 + 1)).append(String.valueOf(i)).append(name.substring(lastIndexOf)).toString()));
        }
        return false;
    }

    private static String d(File file) {
        Throwable th;
        String str = "";
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 8192);
            try {
                StringBuffer stringBuffer = new StringBuffer();
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                }
                str = stringBuffer.toString();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e2) {
                }
            }
            throw th;
        }
        return str;
    }

    static /* synthetic */ int[] e() {
        int[] iArr = e;
        if (iArr == null) {
            iArr = new int[as.values().length];
            try {
                iArr[as.FAILED_BY_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[as.FAILED_BY_OTHER.ordinal()] = 3;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[as.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            e = iArr;
        }
        return iArr;
    }

    private static synchronized void h() {
        synchronized (i.class) {
            if (g.af == null) {
                g.af = new Thread(new m());
                g.af.start();
            }
        }
    }

    private static boolean i() {
        Context a = g.a();
        if (a == null) {
            bd.a(bg.ERROR, "failed to check remote controle due to context is null");
            return false;
        }
        SharedPreferences e = bd.e(a);
        long b = bd.b(e);
        long d = bd.d(e);
        long currentTimeMillis = System.currentTimeMillis();
        return (currentTimeMillis <= b || currentTimeMillis - d <= b) ? currentTimeMillis < b - d : true;
    }

    private static void j() {
        if (t() >= g.R) {
            bd.a(bg.INFO, "Dropped CaputredImages due to Event full");
            return;
        }
        File file = new File(u());
        file.getParentFile().mkdirs();
        try {
            file.createNewFile();
        } catch (IOException e) {
        }
    }

    private static void k() {
        new Thread(new q()).start();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void l() {
        /*
        r6 = 0;
        r3 = 1;
        r4 = 0;
        r8 = com.smrtbeat.i.class;
        monitor-enter(r8);
        r0 = new java.io.File;	 Catch:{ all -> 0x01c0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c0 }
        r2 = com.smrtbeat.g.A;	 Catch:{ all -> 0x01c0 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x01c0 }
        r1.<init>(r2);	 Catch:{ all -> 0x01c0 }
        r2 = "/start/";
        r1 = r1.append(r2);	 Catch:{ all -> 0x01c0 }
        r1 = r1.toString();	 Catch:{ all -> 0x01c0 }
        r0.<init>(r1);	 Catch:{ all -> 0x01c0 }
        a(r0);	 Catch:{ all -> 0x01c0 }
        r0 = com.smrtbeat.bd.g();	 Catch:{ all -> 0x01c0 }
        if (r0 != 0) goto L_0x002b;
    L_0x0029:
        monitor-exit(r8);
        return;
    L_0x002b:
        r0 = new java.io.File;	 Catch:{ all -> 0x01c0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c0 }
        r2 = com.smrtbeat.g.A;	 Catch:{ all -> 0x01c0 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x01c0 }
        r1.<init>(r2);	 Catch:{ all -> 0x01c0 }
        r2 = "/crash/";
        r1 = r1.append(r2);	 Catch:{ all -> 0x01c0 }
        r1 = r1.toString();	 Catch:{ all -> 0x01c0 }
        r0.<init>(r1);	 Catch:{ all -> 0x01c0 }
        b(r0);	 Catch:{ all -> 0x01c0 }
        r0 = new java.io.File;	 Catch:{ all -> 0x01c0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c0 }
        r2 = com.smrtbeat.g.A;	 Catch:{ all -> 0x01c0 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x01c0 }
        r1.<init>(r2);	 Catch:{ all -> 0x01c0 }
        r2 = "/exception/";
        r1 = r1.append(r2);	 Catch:{ all -> 0x01c0 }
        r1 = r1.toString();	 Catch:{ all -> 0x01c0 }
        r0.<init>(r1);	 Catch:{ all -> 0x01c0 }
        b(r0);	 Catch:{ all -> 0x01c0 }
        r0 = new java.io.File;	 Catch:{ all -> 0x01c0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c0 }
        r2 = com.smrtbeat.g.A;	 Catch:{ all -> 0x01c0 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x01c0 }
        r1.<init>(r2);	 Catch:{ all -> 0x01c0 }
        r2 = "/dump/";
        r1 = r1.append(r2);	 Catch:{ all -> 0x01c0 }
        r1 = r1.toString();	 Catch:{ all -> 0x01c0 }
        r0.<init>(r1);	 Catch:{ all -> 0x01c0 }
        r9 = r0.listFiles();	 Catch:{ all -> 0x01c0 }
        if (r9 == 0) goto L_0x0089;
    L_0x0085:
        r10 = r9.length;	 Catch:{ all -> 0x01c0 }
        r7 = r4;
    L_0x0087:
        if (r7 < r10) goto L_0x00cf;
    L_0x0089:
        r0 = new java.io.File;	 Catch:{ all -> 0x01c0 }
        r1 = com.smrtbeat.g.A;	 Catch:{ all -> 0x01c0 }
        r0.<init>(r1);	 Catch:{ all -> 0x01c0 }
        r1 = new com.smrtbeat.s;	 Catch:{ all -> 0x01c0 }
        r1.<init>();	 Catch:{ all -> 0x01c0 }
        r5 = r0.listFiles(r1);	 Catch:{ all -> 0x01c0 }
        r0 = new java.io.File;	 Catch:{ all -> 0x01c0 }
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c0 }
        r2 = com.smrtbeat.g.A;	 Catch:{ all -> 0x01c0 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ all -> 0x01c0 }
        r1.<init>(r2);	 Catch:{ all -> 0x01c0 }
        r2 = "/capture/";
        r1 = r1.append(r2);	 Catch:{ all -> 0x01c0 }
        r1 = r1.toString();	 Catch:{ all -> 0x01c0 }
        r0.<init>(r1);	 Catch:{ all -> 0x01c0 }
        r6 = r0.listFiles();	 Catch:{ all -> 0x01c0 }
        if (r6 == 0) goto L_0x0029;
    L_0x00b9:
        r7 = r6.length;	 Catch:{ all -> 0x01c0 }
        r1 = r4;
    L_0x00bb:
        if (r1 >= r7) goto L_0x0029;
    L_0x00bd:
        r9 = r6[r1];	 Catch:{ all -> 0x01c0 }
        r0 = r9.getName();	 Catch:{ all -> 0x01c0 }
        r2 = com.smrtbeat.g.B;	 Catch:{ all -> 0x01c0 }
        r0 = r0.equals(r2);	 Catch:{ all -> 0x01c0 }
        if (r0 == 0) goto L_0x017d;
    L_0x00cb:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x00bb;
    L_0x00cf:
        r11 = r9[r7];	 Catch:{ all -> 0x01c0 }
        r12 = r11.listFiles();	 Catch:{ all -> 0x01c0 }
        if (r12 != 0) goto L_0x00e1;
    L_0x00d7:
        r0 = r3;
    L_0x00d8:
        if (r0 == 0) goto L_0x00dd;
    L_0x00da:
        a(r11);	 Catch:{ all -> 0x01c0 }
    L_0x00dd:
        r0 = r7 + 1;
        r7 = r0;
        goto L_0x0087;
    L_0x00e1:
        r13 = r12.length;	 Catch:{ all -> 0x01c0 }
        r5 = r4;
        r0 = r6;
        r2 = r6;
    L_0x00e5:
        if (r5 < r13) goto L_0x012c;
    L_0x00e7:
        if (r2 == 0) goto L_0x016e;
    L_0x00e9:
        if (r0 == 0) goto L_0x016e;
    L_0x00eb:
        r1 = new java.util.ArrayList;	 Catch:{ Exception -> 0x0155 }
        r5 = 2;
        r1.<init>(r5);	 Catch:{ Exception -> 0x0155 }
        r5 = new com.smrtbeat.ab;	 Catch:{ Exception -> 0x0155 }
        r12 = "errors";
        r13 = "json.txt";
        r5.<init>(r12, r13, r0);	 Catch:{ Exception -> 0x0155 }
        r1.add(r5);	 Catch:{ Exception -> 0x0155 }
        r0 = new com.smrtbeat.ab;	 Catch:{ Exception -> 0x0155 }
        r5 = "minidump";
        r12 = com.smrtbeat.bd.a(r2);	 Catch:{ Exception -> 0x0155 }
        r0.<init>(r5, r12, r2);	 Catch:{ Exception -> 0x0155 }
        r1.add(r0);	 Catch:{ Exception -> 0x0155 }
        r0 = new com.smrtbeat.aa;	 Catch:{ Exception -> 0x0155 }
        r5 = "https://minidumps.smbeat.jp/api/errors/multi";
        r0.<init>(r5, r1);	 Catch:{ Exception -> 0x0155 }
        r1 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r5 = 1;
        r0 = r0.a(r1, r5);	 Catch:{ Exception -> 0x0155 }
        r1 = e();	 Catch:{ Exception -> 0x0155 }
        r0 = r0.a();	 Catch:{ Exception -> 0x0155 }
        r0 = r0.ordinal();	 Catch:{ Exception -> 0x0155 }
        r0 = r1[r0];	 Catch:{ Exception -> 0x0155 }
        switch(r0) {
            case 1: goto L_0x014e;
            case 2: goto L_0x0150;
            default: goto L_0x012a;
        };
    L_0x012a:
        r0 = r4;
        goto L_0x00d8;
    L_0x012c:
        r1 = r12[r5];	 Catch:{ all -> 0x01c0 }
        r14 = r1.getName();	 Catch:{ all -> 0x01c0 }
        r15 = ".dmp";
        r14 = r14.endsWith(r15);	 Catch:{ all -> 0x01c0 }
        if (r14 == 0) goto L_0x013f;
    L_0x013a:
        r2 = r5 + 1;
        r5 = r2;
        r2 = r1;
        goto L_0x00e5;
    L_0x013f:
        r14 = r1.getName();	 Catch:{ all -> 0x01c0 }
        r15 = ".dat";
        r14 = r14.endsWith(r15);	 Catch:{ all -> 0x01c0 }
        if (r14 == 0) goto L_0x01fa;
    L_0x014b:
        r0 = r1;
        r1 = r2;
        goto L_0x013a;
    L_0x014e:
        r0 = r3;
        goto L_0x00d8;
    L_0x0150:
        r0 = c(r2);	 Catch:{ Exception -> 0x0155 }
        goto L_0x00d8;
    L_0x0155:
        r0 = move-exception;
        r1 = com.smrtbeat.bg.INFO;	 Catch:{ all -> 0x01c0 }
        r2 = "failed to send dump: %s";
        r5 = 1;
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x01c0 }
        r12 = 0;
        r0 = r0.toString();	 Catch:{ all -> 0x01c0 }
        r5[r12] = r0;	 Catch:{ all -> 0x01c0 }
        r0 = java.lang.String.format(r2, r5);	 Catch:{ all -> 0x01c0 }
        com.smrtbeat.bd.a(r1, r0);	 Catch:{ all -> 0x01c0 }
        r0 = r4;
        goto L_0x00d8;
    L_0x016e:
        r0 = r11.getAbsolutePath();	 Catch:{ all -> 0x01c0 }
        r1 = com.smrtbeat.g.B;	 Catch:{ all -> 0x01c0 }
        r0 = r0.contains(r1);	 Catch:{ all -> 0x01c0 }
        if (r0 != 0) goto L_0x01f7;
    L_0x017a:
        r0 = r3;
        goto L_0x00d8;
    L_0x017d:
        r0 = a(r9, r5);	 Catch:{ all -> 0x01c0 }
        if (r0 == 0) goto L_0x01f0;
    L_0x0183:
        r10 = r9.listFiles();	 Catch:{ all -> 0x01c0 }
        if (r10 == 0) goto L_0x01f5;
    L_0x0189:
        r11 = r10.length;	 Catch:{ all -> 0x01c0 }
        r2 = r4;
        r0 = r4;
    L_0x018c:
        if (r2 < r11) goto L_0x01c3;
    L_0x018e:
        if (r0 != 0) goto L_0x00cb;
    L_0x0190:
        r0 = new java.io.File;	 Catch:{ all -> 0x01c0 }
        r2 = new java.lang.StringBuilder;	 Catch:{ all -> 0x01c0 }
        r10 = com.smrtbeat.g.A;	 Catch:{ all -> 0x01c0 }
        r10 = java.lang.String.valueOf(r10);	 Catch:{ all -> 0x01c0 }
        r2.<init>(r10);	 Catch:{ all -> 0x01c0 }
        r10 = "/";
        r2 = r2.append(r10);	 Catch:{ all -> 0x01c0 }
        r10 = r9.getName();	 Catch:{ all -> 0x01c0 }
        r2 = r2.append(r10);	 Catch:{ all -> 0x01c0 }
        r10 = ".id";
        r2 = r2.append(r10);	 Catch:{ all -> 0x01c0 }
        r2 = r2.toString();	 Catch:{ all -> 0x01c0 }
        r0.<init>(r2);	 Catch:{ all -> 0x01c0 }
        a(r0);	 Catch:{ all -> 0x01c0 }
        a(r9);	 Catch:{ all -> 0x01c0 }
        goto L_0x00cb;
    L_0x01c0:
        r0 = move-exception;
        monitor-exit(r8);
        throw r0;
    L_0x01c3:
        r12 = r10[r2];	 Catch:{ all -> 0x01c0 }
        r13 = e();	 Catch:{ all -> 0x01c0 }
        r14 = 0;
        r14 = a(r12, r14);	 Catch:{ all -> 0x01c0 }
        r15 = r12.getName();	 Catch:{ all -> 0x01c0 }
        r14 = r14.a(r15);	 Catch:{ all -> 0x01c0 }
        r14 = r14.ordinal();	 Catch:{ all -> 0x01c0 }
        r13 = r13[r14];	 Catch:{ all -> 0x01c0 }
        switch(r13) {
            case 1: goto L_0x01e4;
            case 2: goto L_0x01e8;
            default: goto L_0x01e0;
        };	 Catch:{ all -> 0x01c0 }
    L_0x01e0:
        r0 = r3;
    L_0x01e1:
        r2 = r2 + 1;
        goto L_0x018c;
    L_0x01e4:
        a(r12);	 Catch:{ all -> 0x01c0 }
        goto L_0x01e1;
    L_0x01e8:
        r12 = c(r12);	 Catch:{ all -> 0x01c0 }
        if (r12 != 0) goto L_0x01e1;
    L_0x01ee:
        r0 = r3;
        goto L_0x01e1;
    L_0x01f0:
        a(r9);	 Catch:{ all -> 0x01c0 }
        goto L_0x00cb;
    L_0x01f5:
        r0 = r4;
        goto L_0x018e;
    L_0x01f7:
        r0 = r4;
        goto L_0x00d8;
    L_0x01fa:
        r1 = r2;
        goto L_0x013a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smrtbeat.i.l():void");
    }

    private static int m() {
        String[] list = new File(g.A + "/crash/").list();
        int i = 0;
        if (list != null) {
            i = list.length;
        }
        File[] listFiles = new File(g.A + "/dump/").listFiles(new k());
        return listFiles != null ? i + listFiles.length : i;
    }

    private static String n() {
        return g.A + "/crash/" + String.valueOf(System.currentTimeMillis()) + "-" + String.valueOf(new Random(System.currentTimeMillis()).nextInt()) + ".dat";
    }

    private static String o() {
        return g.A + "/dump_tmp/" + String.valueOf(System.currentTimeMillis()) + "-" + String.valueOf(new Random(System.currentTimeMillis()).nextInt()) + ".dat";
    }

    private static String p() {
        return g.A + "/dump/" + g.B + "/" + String.valueOf(System.currentTimeMillis()) + "-" + String.valueOf(new Random(System.currentTimeMillis()).nextInt()) + ".dat";
    }

    private static String q() {
        return g.A + "/dump/" + g.B + "/" + g.B + ".dmp";
    }

    private static int r() {
        String[] list = new File(g.A + "/exception/").list();
        return list != null ? list.length : 0;
    }

    private static String s() {
        return g.A + "/exception/" + String.valueOf(System.currentTimeMillis()) + "-" + String.valueOf(new Random(System.currentTimeMillis()).nextInt()) + ".dat";
    }

    private static int t() {
        String[] list = new File(g.A + "/").list(new l());
        return list != null ? list.length : 0;
    }

    private static String u() {
        return g.A + "/" + g.B + a;
    }
}
