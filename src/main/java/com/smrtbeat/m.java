package com.smrtbeat;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import org.json.JSONObject;

class m implements Runnable {
    m() {
    }

    public void run() {
        boolean z = false;
        boolean z2 = g.ad;
        Context a = g.a();
        if (a != null) {
            SharedPreferences e = bd.e(a);
            Editor edit = e.edit();
            try {
                boolean z3;
                ar a2 = i.b("https://control.smbeat.jp/api/remote", ac.b(), false);
                if (!i.b(a2.b) || a == null) {
                    z3 = false;
                } else {
                    JSONObject jSONObject = new JSONObject(a2.b);
                    if (jSONObject.has("suppressSdk")) {
                        z = i.b(jSONObject, "suppressSdk", false);
                        bd.a(edit, z);
                    }
                    if (jSONObject.has("suppressCap")) {
                        bd.b(edit, i.b(jSONObject, "suppressCap", false));
                    }
                    z3 = true;
                }
                bd.a(edit);
                if (z3) {
                    if (z != z2) {
                        bd.c(edit);
                    } else if (z) {
                        bd.e(e);
                    }
                }
                bd.d(edit);
                g.af = null;
            } catch (Exception e2) {
                bd.a(edit);
                bd.d(edit);
                g.af = null;
            } catch (Throwable th) {
                bd.a(edit);
                bd.d(edit);
                g.af = null;
            }
        } else {
            g.af = null;
        }
    }
}
