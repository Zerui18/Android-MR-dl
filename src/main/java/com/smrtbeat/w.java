package com.smrtbeat;

import android.os.SystemClock;
import java.io.File;
import org.json.JSONObject;

class w implements Runnable {
    final /* synthetic */ ExceptionHander a;
    private final /* synthetic */ JSONObject b;
    private final /* synthetic */ File c;

    w(ExceptionHander exceptionHander, JSONObject jSONObject, File file) {
        this.a = exceptionHander;
        this.b = jSONObject;
        this.c = file;
    }

    public void run() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        i.a(this.b, 5000);
        elapsedRealtime = SystemClock.elapsedRealtime() - elapsedRealtime;
        if (this.c != null && 5000 > elapsedRealtime && i.a(this.c, 5000 - elapsedRealtime).a(this.c.getName()) == as.OK) {
            this.c.delete();
        }
    }
}
