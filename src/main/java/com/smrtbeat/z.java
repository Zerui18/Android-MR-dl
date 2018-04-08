package com.smrtbeat;

import java.io.File;
import org.json.JSONObject;

class z implements Runnable {
    private final /* synthetic */ JSONObject a;
    private final /* synthetic */ File b;

    z(JSONObject jSONObject, File file) {
        this.a = jSONObject;
        this.b = file;
    }

    public void run() {
        i.a(this.a);
        if (this.b != null && i.a(this.b, 0).a(this.b.getName()) == as.OK) {
            this.b.delete();
        }
    }
}
