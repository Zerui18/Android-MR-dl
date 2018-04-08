package com.smrtbeat;

import org.json.JSONObject;

class x implements Runnable {
    JSONObject a;

    x() {
    }

    Runnable a(JSONObject jSONObject) {
        this.a = jSONObject;
        return this;
    }

    public void run() {
        i.a(this.a);
    }
}
