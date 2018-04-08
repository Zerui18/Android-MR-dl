package com.smrtbeat;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Handler;
import android.view.Window;

class e implements Runnable {
    private static final int g = 3;
    private static final long h = 1000;
    Canvas a;
    Bitmap b;
    Handler c;
    private Window d = null;
    private Context e = null;
    private int f = 0;
    private Object i = new Object();

    e() {
    }

    private boolean a() {
        synchronized (this.i) {
            if (this.d == null || this.e == null || this.c == null) {
                this.f++;
                return false;
            }
            Window window = this.d;
            Context context = this.e;
            au.a(window, context, this, this.c);
            return true;
        }
    }

    void a(Activity activity) {
        synchronized (this.i) {
            this.f = 0;
            if (g.X) {
                this.d = null;
                this.e = null;
            } else {
                this.d = activity.getWindow();
                this.e = activity.getApplicationContext();
                this.c = new Handler(activity.getMainLooper());
            }
        }
    }

    void b(Activity activity) {
        synchronized (this.i) {
            if (this.d == activity.getWindow()) {
                this.d = null;
                this.e = null;
            }
        }
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(h);
            } catch (InterruptedException e) {
            }
            if (bd.i()) {
                synchronized (this.i) {
                    if (this.f > 3) {
                        return;
                    }
                }
            } else {
                return;
            }
            a();
        }
    }
}
