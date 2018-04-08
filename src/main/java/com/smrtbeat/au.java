package com.smrtbeat;

import android.app.ActivityManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.Handler;
import android.os.Process;
import android.view.View;
import android.view.Window;
import java.io.File;

class au {
    private static final long a = 10240;

    au() {
    }

    static String a(String str, long j, String str2) {
        return new StringBuilder(String.valueOf(str)).append("_").append(String.valueOf(j)).append(str2).toString();
    }

    static void a(Window window, Context context, e eVar, Handler handler) {
        if (a((ActivityManager) context.getSystemService("activity"))) {
            bd.a(bg.INFO, "Skip Capturing ScreenShot due to low memory");
        } else {
            a(window, eVar, handler);
        }
    }

    private static void a(Window window, e eVar, Handler handler) {
        if (!g.ab && g.B.length() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            if (window != null) {
                View decorView = window.getDecorView();
                if (decorView != null && decorView.getHeight() > 0 && decorView.getWidth() > 0) {
                    if (!(eVar.a != null && eVar.a.getWidth() == decorView.getWidth() && eVar.a.getHeight() == decorView.getHeight())) {
                        if (eVar.b != null) {
                            bd.a(h.ENative, eVar.b);
                        }
                        eVar.b = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Config.RGB_565);
                        eVar.a = new Canvas();
                        eVar.a.setBitmap(eVar.b);
                        eVar.a.setDensity(eVar.a.getDensity());
                    }
                    handler.post(new av().a(decorView, eVar.a, currentTimeMillis, eVar.b));
                }
            }
        }
    }

    private static boolean a(ActivityManager activityManager) {
        return Runtime.getRuntime().maxMemory() - ((long) (activityManager.getProcessMemoryInfo(new int[]{Process.myPid()})[0].getTotalPss() * 1024)) < a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(java.io.File r5, android.graphics.Bitmap r6) {
        /*
        r2 = 0;
        r0 = 0;
        r1 = r5.getParentFile();	 Catch:{ FileNotFoundException -> 0x0026, IOException -> 0x0031, Throwable -> 0x003c, all -> 0x0047 }
        r1.mkdirs();	 Catch:{ FileNotFoundException -> 0x0026, IOException -> 0x0031, Throwable -> 0x003c, all -> 0x0047 }
        r5.createNewFile();	 Catch:{ FileNotFoundException -> 0x0026, IOException -> 0x0031, Throwable -> 0x003c, all -> 0x0047 }
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x0026, IOException -> 0x0031, Throwable -> 0x003c, all -> 0x0047 }
        r1.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0026, IOException -> 0x0031, Throwable -> 0x003c, all -> 0x0047 }
        r0 = android.graphics.Bitmap.CompressFormat.JPEG;	 Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005c, Throwable -> 0x0057, all -> 0x0055 }
        r3 = 80;
        r6.compress(r0, r3, r1);	 Catch:{ FileNotFoundException -> 0x0061, IOException -> 0x005c, Throwable -> 0x0057, all -> 0x0055 }
        r0 = 1;
        r2 = com.smrtbeat.bg.VERBOSE;	 Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x005f, Throwable -> 0x005a, all -> 0x0055 }
        r3 = "saved Screenshot to file";
        com.smrtbeat.bd.a(r2, r3);	 Catch:{ FileNotFoundException -> 0x0064, IOException -> 0x005f, Throwable -> 0x005a, all -> 0x0055 }
        if (r1 == 0) goto L_0x0025;
    L_0x0022:
        r1.close();	 Catch:{ IOException -> 0x0053 }
    L_0x0025:
        return r0;
    L_0x0026:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0029:
        if (r1 == 0) goto L_0x0025;
    L_0x002b:
        r1.close();	 Catch:{ IOException -> 0x002f }
        goto L_0x0025;
    L_0x002f:
        r1 = move-exception;
        goto L_0x0025;
    L_0x0031:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0034:
        if (r1 == 0) goto L_0x0025;
    L_0x0036:
        r1.close();	 Catch:{ IOException -> 0x003a }
        goto L_0x0025;
    L_0x003a:
        r1 = move-exception;
        goto L_0x0025;
    L_0x003c:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x003f:
        if (r1 == 0) goto L_0x0025;
    L_0x0041:
        r1.close();	 Catch:{ IOException -> 0x0045 }
        goto L_0x0025;
    L_0x0045:
        r1 = move-exception;
        goto L_0x0025;
    L_0x0047:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x004b:
        if (r1 == 0) goto L_0x0050;
    L_0x004d:
        r1.close();	 Catch:{ IOException -> 0x0051 }
    L_0x0050:
        throw r0;
    L_0x0051:
        r1 = move-exception;
        goto L_0x0050;
    L_0x0053:
        r1 = move-exception;
        goto L_0x0025;
    L_0x0055:
        r0 = move-exception;
        goto L_0x004b;
    L_0x0057:
        r0 = move-exception;
        r0 = r2;
        goto L_0x003f;
    L_0x005a:
        r2 = move-exception;
        goto L_0x003f;
    L_0x005c:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0034;
    L_0x005f:
        r2 = move-exception;
        goto L_0x0034;
    L_0x0061:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0029;
    L_0x0064:
        r2 = move-exception;
        goto L_0x0029;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smrtbeat.au.a(java.io.File, android.graphics.Bitmap):boolean");
    }

    static File b(String str, long j, String str2) {
        return new File(g.A + "/capture/" + str + "/" + a(str, j, str2));
    }
}
