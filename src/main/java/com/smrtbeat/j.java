package com.smrtbeat;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

class j implements Runnable {
    private SharedPreferences a;

    j() {
    }

    Runnable a(SharedPreferences sharedPreferences) {
        this.a = sharedPreferences;
        return this;
    }

    public void run() {
        i.b = true;
        JSONObject a = ac.a();
        bd.a(bg.INFO, "SendPingData");
        if (i.b(a, false).a() == as.OK) {
            Editor edit = this.a.edit();
            bd.b(edit);
            bd.d(edit);
        }
        i.b = false;
    }
}
