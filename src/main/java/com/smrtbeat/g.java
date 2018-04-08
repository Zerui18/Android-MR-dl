package com.smrtbeat;

import android.content.Context;
import android.graphics.Bitmap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class g {
    static String A = "";
    static String B = "";
    static boolean C = false;
    static boolean D = false;
    static int E = 0;
    static List F = new ArrayList(16);
    static HashMap G = null;
    static String H = "";
    static boolean I = false;
    static String J = "";
    static String K = "";
    static boolean L = false;
    static e M = null;
    static Thread N = null;
    static boolean O = false;
    static boolean P = true;
    static List Q = new ArrayList();
    static int R = 5;
    static String S = "";
    static Bitmap T = null;
    static Bitmap U = null;
    static long V = 0;
    static h W = h.ENone;
    static boolean X = false;
    static String Y = null;
    static String Z = null;
    static final String a = "https://api.smbeat.jp/api/errors";
    static String aa = null;
    static boolean ab = false;
    static boolean ac = false;
    static boolean ad = false;
    static boolean ae = false;
    static Thread af = null;
    private static WeakReference ag = null;
    static final String b = "https://images.smbeat.jp/api/upload";
    static final String c = "https://minidumps.smbeat.jp/api/errors/multi";
    static final String d = "https://control.smbeat.jp/api/remote";
    static final long e = 21600000;
    static final int f = 32;
    static final int g = 16;
    static final long h = 5000;
    static final int i = 3;
    static final int j = 65536;
    static final int k = 500;
    static final String l = "1.17";
    static String m = "";
    static String n = "";
    static String o = "";
    static String p = "";
    static String q = "";
    static String r = "";
    static String s = null;
    static String t = "";
    static String u = "";
    static boolean v = false;
    static int w = 0;
    static int x = 0;
    static int y = 0;
    static long z = System.currentTimeMillis();

    g() {
    }

    static Context a() {
        return ag == null ? null : (Context) ag.get();
    }

    static void a(Context context) {
        ag = new WeakReference(context);
    }
}
