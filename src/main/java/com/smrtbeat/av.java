package com.smrtbeat;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

class av implements Runnable {
    View a;
    Canvas b;
    long c;
    Bitmap d;

    av() {
    }

    Runnable a(View view, Canvas canvas, long j, Bitmap bitmap) {
        this.a = view;
        this.b = canvas;
        this.c = j;
        this.d = bitmap;
        return this;
    }

    public void run() {
        try {
            this.a.draw(this.b);
            bd.a(h.ENative, this.d, this.c);
        } catch (Throwable th) {
        }
        this.a = null;
        this.b = null;
        this.d = null;
    }
}
