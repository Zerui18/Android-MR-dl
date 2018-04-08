package com.smrtbeat;

import android.os.SystemClock;
import java.io.File;

class ay implements Runnable {
    File a;

    ay() {
    }

    Runnable a(File file) {
        this.a = file;
        return this;
    }

    public void run() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        i.a(ac.a(g.a()), this.a, 5000);
        File l = bd.l();
        elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (l != null && 5000 > elapsedRealtime && i.a(l, 5000 - elapsedRealtime).a(l.getName()) == as.OK) {
            i.a(l);
        }
    }
}
