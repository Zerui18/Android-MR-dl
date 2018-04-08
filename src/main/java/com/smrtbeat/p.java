package com.smrtbeat;

import org.json.JSONObject;

class p implements Runnable {
    String a;
    JSONObject b;

    p() {
    }

    Runnable a(String str, JSONObject jSONObject) {
        this.a = str;
        this.b = jSONObject;
        return this;
    }

    public void run() {
        i.c(this.b, this.a);
    }
}
