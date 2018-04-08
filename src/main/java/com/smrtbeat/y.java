package com.smrtbeat;

import org.json.JSONObject;

class y implements Runnable {
    JSONObject a;

    y() {
    }

    Runnable a(JSONObject jSONObject) {
        this.a = jSONObject;
        return this;
    }

    public void run() {
        i.a(this.a);
    }
}
