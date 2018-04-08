package com.smrtbeat;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.Thread.State;
import java.net.HttpURLConnection;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

class bd {
    static final String a = "no permission";
    private static final String b = "unknown";
    private static final String c = "com.smrtbeat.pref1";
    private static final String d = "com.smrtbeat.pref3";
    private static final String e = "com.smrtbeat.pref4";
    private static final String f = "com.smrtbeat.pref5";
    private static final String g = "com.smrtbeat.pref6";
    private static final long h = 86400000;
    private static /* synthetic */ int[] i;
    private static /* synthetic */ int[] j;

    bd() {
    }

    private static long a(SharedPreferences sharedPreferences, String str, long j) {
        try {
            j = sharedPreferences.getLong(str, j);
        } catch (Exception e) {
            d(sharedPreferences.edit().remove(str));
        }
        return j;
    }

    static String a() {
        return UUID.randomUUID().toString();
    }

    static String a(int i) {
        if (VERSION.SDK_INT >= 21) {
            String[] a = an.a();
            return a.length <= i ? null : a[i];
        } else {
            switch (i) {
                case 0:
                    return aq.a();
                case 1:
                    return aq.b();
                default:
                    return null;
            }
        }
    }

    static String a(Context context, String str) {
        String str2 = "unknown";
        try {
            Class loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", new Class[]{String.class}).invoke(loadClass, new Object[]{new String(str)});
        } catch (Exception e) {
            return str2;
        }
    }

    static String a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        int lastIndexOf2 = name.lastIndexOf(".", lastIndexOf - 1);
        return (lastIndexOf < 0 || lastIndexOf2 < 0) ? file.getName() : name.substring(0, lastIndexOf2) + name.substring(lastIndexOf);
    }

    static String a(HttpURLConnection httpURLConnection) {
        InputStream inputStream;
        BufferedReader bufferedReader;
        Exception e;
        Throwable th;
        InputStream inputStream2 = null;
        try {
            inputStream = httpURLConnection.getInputStream();
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 1024);
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuilder.append(readLine).append("\n");
                    }
                    String stringBuilder2 = stringBuilder.toString();
                    try {
                        inputStream.close();
                        if (bufferedReader == null) {
                            return stringBuilder2;
                        }
                        bufferedReader.close();
                        return stringBuilder2;
                    } catch (IOException e2) {
                        a(bg.ERROR, String.format("readResponse :%s", new Object[]{e2.getMessage()}));
                        return stringBuilder2;
                    }
                } catch (Exception e3) {
                    e = e3;
                    inputStream2 = inputStream;
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
                bufferedReader = null;
                inputStream2 = inputStream;
                try {
                    a(bg.ERROR, String.format("readResponse :%s", new Object[]{e.getMessage()}));
                    try {
                        inputStream2.close();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (IOException e5) {
                        a(bg.ERROR, String.format("readResponse :%s", new Object[]{e5.getMessage()}));
                    }
                    return "";
                } catch (Throwable th3) {
                    th = th3;
                    inputStream = inputStream2;
                    try {
                        inputStream.close();
                        if (bufferedReader != null) {
                            bufferedReader.close();
                        }
                    } catch (IOException e22) {
                        a(bg.ERROR, String.format("readResponse :%s", new Object[]{e22.getMessage()}));
                    }
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStream.close();
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            bufferedReader = null;
            a(bg.ERROR, String.format("readResponse :%s", new Object[]{e.getMessage()}));
            inputStream2.close();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            return "";
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStream = null;
            inputStream.close();
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw th;
        }
    }

    static void a(Activity activity) {
        if (g.S.length() <= 0) {
            b(activity);
        }
    }

    private static synchronized void a(Activity activity, boolean z) {
        synchronized (bd.class) {
            String name = activity.getClass().getName();
            if (z) {
                g.S = name;
                r();
            } else if (g.S.equals(name)) {
                g.S = "";
            }
            if (i()) {
                if (g.M == null || g.N == null || g.N.getState() == State.TERMINATED) {
                    g.M = new e();
                    g.N = new Thread(g.M);
                    g.N.start();
                }
                if (z) {
                    g.M.a(activity);
                } else {
                    g.M.b(activity);
                }
            }
        }
    }

    static void a(Context context) {
        g.n = context.getPackageName();
        g.q = Build.MODEL;
        g.p = Build.BRAND;
        g.B = a();
        g.o = "unknown";
        g.t = "unknown";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(g.n, 0);
            g.o = packageInfo.versionName;
            g.t = String.valueOf(packageInfo.versionCode);
        } catch (NameNotFoundException e) {
        }
        g.u = VERSION.RELEASE;
        g.v = q();
        g.r = f(context);
        g.s = g(context);
        h(context);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        g.w = displayMetrics.densityDpi;
        g.x = displayMetrics.widthPixels;
        g.y = displayMetrics.heightPixels;
        g.A = i(context);
    }

    static void a(Editor editor) {
        editor.putLong(d, System.currentTimeMillis());
    }

    static void a(Editor editor, boolean z) {
        editor.putBoolean(c, z);
        g.ad = z;
    }

    static void a(SharedPreferences sharedPreferences) {
        g.ad = a(sharedPreferences, c, false);
        g.ae = a(sharedPreferences, f, false);
    }

    static void a(bg bgVar, String str) {
        if (g.H != null && g.H.length() > 0) {
            switch (o()[bgVar.ordinal()]) {
                case 1:
                    Log.e(g.H, str);
                    ae.a().a("[E/" + g.H + "]" + str);
                    return;
                case 2:
                    Log.w(g.H, str);
                    ae.a().a("[W/" + g.H + "]" + str);
                    return;
                case 3:
                    Log.i(g.H, str);
                    ae.a().a("[I/" + g.H + "]" + str);
                    return;
                case 4:
                    Log.d(g.H, str);
                    ae.a().a("[D/" + g.H + "]" + str);
                    return;
                case 5:
                    Log.v(g.H, str);
                    ae.a().a("[V/" + g.H + "]" + str);
                    return;
                default:
                    return;
            }
        }
    }

    static void a(bg bgVar, String str, Throwable th) {
        if (g.H != null && g.H.length() > 0) {
            String stackTraceString = Log.getStackTraceString(th);
            switch (o()[bgVar.ordinal()]) {
                case 1:
                    Log.e(g.H, str, th);
                    ae.a().a("[E/" + g.H + "]" + str + "\n" + stackTraceString);
                    return;
                case 2:
                    Log.w(g.H, str, th);
                    ae.a().a("[W/" + g.H + "]" + str + "\n" + stackTraceString);
                    return;
                case 3:
                    Log.i(g.H, str, th);
                    ae.a().a("[I/" + g.H + "]" + str + "\n" + stackTraceString);
                    return;
                case 4:
                    Log.d(g.H, str, th);
                    ae.a().a("[D/" + g.H + "]" + str + "\n" + stackTraceString);
                    return;
                case 5:
                    Log.v(g.H, str, th);
                    ae.a().a("[V/" + g.H + "]" + str + "\n" + stackTraceString);
                    return;
                default:
                    return;
            }
        }
    }

    static void a(h hVar, Bitmap bitmap) {
        switch (p()[hVar.ordinal()]) {
            case 2:
                if (g.T != bitmap && bitmap != null) {
                    bitmap.recycle();
                    return;
                }
                return;
            case 3:
                if (g.U != bitmap && bitmap != null) {
                    bitmap.recycle();
                    return;
                }
                return;
            default:
                return;
        }
    }

    static synchronized void a(h hVar, Bitmap bitmap, long j) {
        synchronized (bd.class) {
            if (!(g.ab || bitmap == null)) {
                if (!bitmap.isRecycled()) {
                    switch (p()[hVar.ordinal()]) {
                        case 2:
                            if (g.T != bitmap) {
                                if (g.T != null) {
                                    g.T.recycle();
                                }
                                g.T = bitmap;
                            }
                            g.V = j;
                            a(bg.DEBUG, "save screen capture");
                            break;
                        case 3:
                            if (g.U != bitmap) {
                                if (g.U != null) {
                                    g.U.recycle();
                                }
                                g.U = bitmap;
                            }
                            g.V = j;
                            a(bg.DEBUG, "save screen capture (gl)");
                            break;
                    }
                    g.W = hVar;
                }
            }
        }
    }

    static synchronized void a(String str) {
        synchronized (bd.class) {
            if (g.F.size() >= 16) {
                g.F.remove(0);
            }
            g.F.add(str);
        }
    }

    static synchronized void a(String str, String str2) {
        synchronized (bd.class) {
            if (g.G == null) {
                g.G = new HashMap();
            }
            g.G.put(str, str2);
        }
    }

    static void a(boolean z) {
        g.ac = z;
    }

    private static boolean a(SharedPreferences sharedPreferences, String str, boolean z) {
        try {
            z = sharedPreferences.getBoolean(str, z);
        } catch (Exception e) {
            d(sharedPreferences.edit().remove(str));
        }
        return z;
    }

    static boolean a(File file, File file2) {
        FileInputStream fileInputStream;
        FileChannel channel;
        FileOutputStream fileOutputStream;
        FileChannel channel2;
        FileInputStream fileInputStream2;
        boolean exists;
        Throwable th;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                channel = fileInputStream.getChannel();
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        channel2 = fileOutputStream.getChannel();
                        try {
                            channel.transferTo(0, channel.size(), channel2);
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (IOException e) {
                                }
                            }
                            if (channel2 != null) {
                                try {
                                    channel2.close();
                                } catch (IOException e2) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e3) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                        } catch (FileNotFoundException e5) {
                            fileInputStream2 = fileInputStream;
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (IOException e6) {
                                }
                            }
                            if (channel2 != null) {
                                try {
                                    channel2.close();
                                } catch (IOException e7) {
                                }
                            }
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (IOException e8) {
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException e9) {
                                }
                            }
                            exists = file2.exists();
                            if (exists) {
                                file.delete();
                            }
                            return exists;
                        } catch (IOException e10) {
                            fileOutputStream2 = fileOutputStream;
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (IOException e11) {
                                }
                            }
                            if (channel2 != null) {
                                try {
                                    channel2.close();
                                } catch (IOException e12) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e13) {
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e14) {
                                }
                            }
                            exists = file2.exists();
                            if (exists) {
                                file.delete();
                            }
                            return exists;
                        } catch (Throwable th2) {
                            Throwable th3 = th2;
                            fileOutputStream2 = fileOutputStream;
                            th = th3;
                            if (channel != null) {
                                try {
                                    channel.close();
                                } catch (IOException e15) {
                                }
                            }
                            if (channel2 != null) {
                                try {
                                    channel2.close();
                                } catch (IOException e16) {
                                }
                            }
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (IOException e17) {
                                }
                            }
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException e18) {
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException e19) {
                        channel2 = null;
                        fileInputStream2 = fileInputStream;
                        if (channel != null) {
                            channel.close();
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        if (fileInputStream2 != null) {
                            fileInputStream2.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        exists = file2.exists();
                        if (exists) {
                            file.delete();
                        }
                        return exists;
                    } catch (IOException e20) {
                        channel2 = null;
                        fileOutputStream2 = fileOutputStream;
                        if (channel != null) {
                            channel.close();
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        exists = file2.exists();
                        if (exists) {
                            file.delete();
                        }
                        return exists;
                    } catch (Throwable th4) {
                        channel2 = null;
                        fileOutputStream2 = fileOutputStream;
                        th = th4;
                        if (channel != null) {
                            channel.close();
                        }
                        if (channel2 != null) {
                            channel2.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream2 != null) {
                            fileOutputStream2.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e21) {
                    fileOutputStream = null;
                    channel2 = null;
                    fileInputStream2 = fileInputStream;
                    if (channel != null) {
                        channel.close();
                    }
                    if (channel2 != null) {
                        channel2.close();
                    }
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    exists = file2.exists();
                    if (exists) {
                        file.delete();
                    }
                    return exists;
                } catch (IOException e22) {
                    channel2 = null;
                    if (channel != null) {
                        channel.close();
                    }
                    if (channel2 != null) {
                        channel2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    exists = file2.exists();
                    if (exists) {
                        file.delete();
                    }
                    return exists;
                } catch (Throwable th5) {
                    th = th5;
                    channel2 = null;
                    if (channel != null) {
                        channel.close();
                    }
                    if (channel2 != null) {
                        channel2.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream2 != null) {
                        fileOutputStream2.close();
                    }
                    throw th;
                }
            } catch (FileNotFoundException e23) {
                fileOutputStream = null;
                channel2 = null;
                channel = null;
                fileInputStream2 = fileInputStream;
                if (channel != null) {
                    channel.close();
                }
                if (channel2 != null) {
                    channel2.close();
                }
                if (fileInputStream2 != null) {
                    fileInputStream2.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                exists = file2.exists();
                if (exists) {
                    file.delete();
                }
                return exists;
            } catch (IOException e24) {
                channel2 = null;
                channel = null;
                if (channel != null) {
                    channel.close();
                }
                if (channel2 != null) {
                    channel2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                exists = file2.exists();
                if (exists) {
                    file.delete();
                }
                return exists;
            } catch (Throwable th6) {
                th = th6;
                channel2 = null;
                channel = null;
                if (channel != null) {
                    channel.close();
                }
                if (channel2 != null) {
                    channel2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream2 != null) {
                    fileOutputStream2.close();
                }
                throw th;
            }
        } catch (FileNotFoundException e25) {
            fileOutputStream = null;
            channel2 = null;
            channel = null;
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            exists = file2.exists();
            if (exists) {
                file.delete();
            }
            return exists;
        } catch (IOException e26) {
            fileInputStream = null;
            channel2 = null;
            channel = null;
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            exists = file2.exists();
            if (exists) {
                file.delete();
            }
            return exists;
        } catch (Throwable th7) {
            th = th7;
            fileInputStream = null;
            channel2 = null;
            channel = null;
            if (channel != null) {
                channel.close();
            }
            if (channel2 != null) {
                channel2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
        exists = file2.exists();
        if (exists) {
            file.delete();
        }
        return exists;
    }

    static long b(SharedPreferences sharedPreferences) {
        return a(sharedPreferences, d, 0);
    }

    static File b(String str) {
        File b;
        switch (p()[g.W.ordinal()]) {
            case 2:
                if (g.T == null) {
                    return null;
                }
                b = au.b(str, g.V, ".jpg");
                au.a(b, g.T);
                return b;
            case 3:
                if (g.U == null) {
                    return null;
                }
                b = au.b(str, g.V, ".jpg");
                au.a(b, g.U);
                return b;
            default:
                return null;
        }
    }

    static String b() {
        return Locale.getDefault().getDisplayLanguage(Locale.US);
    }

    static String b(Context context) {
        return VERSION.SDK_INT < 23 ? ProxyClassApiLess23.getMobileNetworkStatus(context) : ao.a(context);
    }

    static void b(Activity activity) {
        a(activity, true);
        i.a();
        i.c();
        i.b();
    }

    static void b(Editor editor) {
        editor.putLong(g, SystemClock.elapsedRealtime());
    }

    static void b(Editor editor, boolean z) {
        editor.putBoolean(f, z);
        g.ae = z;
    }

    static long c(SharedPreferences sharedPreferences) {
        return a(sharedPreferences, g, 0);
    }

    static String c() {
        String str = g.J;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("logcat -d " + str).getInputStream()), 8192);
            List arrayList = new ArrayList();
            while (true) {
                str = bufferedReader.readLine();
                if (str == null) {
                    break;
                }
                arrayList.add(str);
            }
            if (arrayList.size() == 0) {
                return "no permission (android.permission.READ_LOGS)";
            }
            int size = arrayList.size() - 500;
            int i = size < 0 ? 0 : size;
            int size2 = arrayList.size() - 1;
            int i2 = 0;
            while (size2 >= 0 && size2 >= i) {
                str = new StringBuilder(String.valueOf((String) arrayList.get(size2))).append("\n").toString();
                i2 += str.getBytes().length;
                if (i2 > 65536) {
                    break;
                }
                stringBuilder.insert(0, str);
                size2--;
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return String.format("error to read logcat(%s)", new Object[]{e.getMessage()});
        }
    }

    static String c(Context context) {
        return VERSION.SDK_INT < 23 ? ProxyClassApiLess23.getWifiStatus(context) : ao.b(context);
    }

    static void c(Activity activity) {
        a(activity, false);
    }

    static void c(Editor editor) {
        editor.putLong(e, h);
    }

    static long d(SharedPreferences sharedPreferences) {
        long j = h;
        long a = a(sharedPreferences, e, (long) h);
        if (a >= h) {
            j = a;
        }
        return j > 691200000 ? 691200000 : j;
    }

    static String d() {
        return a(g.a(), "ro.board.platform");
    }

    static String d(Context context) {
        String str = "";
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        switch (defaultDisplay.getRotation()) {
            case 0:
                return "ROTATION_0";
            case 1:
                return "ROTATION_90";
            case 2:
                return "ROTATION_180";
            case 3:
                return "ROTATION_270";
            default:
                return "unknown:" + String.valueOf(defaultDisplay.getRotation());
        }
    }

    static void d(Editor editor) {
        if (VERSION.SDK_INT >= 9) {
            ap.a(editor);
            return;
        }
        Thread thread = new Thread(new bf().a(editor));
        thread.start();
        try {
            thread.join(1000);
        } catch (InterruptedException e) {
        }
    }

    static SharedPreferences e(Context context) {
        return context.getSharedPreferences("com.smrtbeat", 0);
    }

    static String e() {
        return Build.BOARD;
    }

    static void e(SharedPreferences sharedPreferences) {
        long j = 691200000;
        long j2 = h;
        long d = d(sharedPreferences) * 2;
        if (d >= h) {
            j2 = d;
        }
        if (j2 <= 691200000) {
            j = j2;
        }
        Editor edit = sharedPreferences.edit();
        edit.putLong(e, j);
        d(edit);
    }

    static String f() {
        StringBuilder stringBuilder = new StringBuilder();
        if (VERSION.SDK_INT >= 21) {
            for (String str : an.a()) {
                if (str.length() > 0) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(" / ");
                    }
                    stringBuilder.append(str);
                }
            }
        } else {
            stringBuilder.append(aq.a());
            String b = aq.b();
            if (b != null && b.length() > 0) {
                stringBuilder.append(" / ").append(b);
            }
        }
        return stringBuilder.toString();
    }

    private static String f(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("SmartBeat", 0);
        String string = sharedPreferences.getString("uuid", "");
        if (string.length() <= 0) {
            string = UUID.randomUUID().toString();
            Editor edit = sharedPreferences.edit();
            edit.putString("uuid", string);
            d(edit);
        }
        return "android:" + string + ":" + g.q;
    }

    private static String g(Context context) {
        String string = context.getSharedPreferences("SmartBeat", 0).getString("idv2", "");
        return string.length() <= 0 ? null : string;
    }

    static boolean g() {
        return (g.ac || g.ad) ? false : true;
    }

    private static void h(Context context) {
        new Thread(new be(context)).start();
    }

    static boolean h() {
        return !g.ad;
    }

    private static String i(Context context) {
        return context.getDir("SmartBeat", 0).getAbsolutePath();
    }

    static boolean i() {
        return g() && !g.ae && g.O;
    }

    static boolean j() {
        return k();
    }

    static boolean k() {
        return g() && !g.ae;
    }

    static File l() {
        return b(g.B);
    }

    static boolean m() {
        return g.m.length() > 0;
    }

    static boolean n() {
        return (VERSION.SDK_INT >= 23 ? ao.a() : 0) > 0;
    }

    static /* synthetic */ int[] o() {
        int[] iArr = i;
        if (iArr == null) {
            iArr = new int[bg.values().length];
            try {
                iArr[bg.DEBUG.ordinal()] = 4;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[bg.ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[bg.INFO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[bg.VERBOSE.ordinal()] = 5;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[bg.WARN.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            i = iArr;
        }
        return iArr;
    }

    static /* synthetic */ int[] p() {
        int[] iArr = j;
        if (iArr == null) {
            iArr = new int[h.values().length];
            try {
                iArr[h.EGles.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[h.ENative.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[h.ENone.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            j = iArr;
        }
        return iArr;
    }

    private static boolean q() {
        String[] strArr = new String[]{"/sbin/", "/system/bin/", "/system/xbin/", "/data/local/xbin/", "/data/local/bin/", "/system/sd/xbin/", "/system/bin/failsafe/", "/data/local/"};
        for (String str : strArr) {
            if (new File(str + "su").exists()) {
                return true;
            }
        }
        return false;
    }

    private static void r() {
        String str = g.S;
        for (String equals : g.Q) {
            if (str.equals(equals)) {
                g.X = true;
                return;
            }
        }
        g.X = false;
    }
}
