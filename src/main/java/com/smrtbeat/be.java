package com.smrtbeat;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.util.UUID;

class be implements Runnable {
    private final /* synthetic */ Context a;

    be(Context context) {
        this.a = context;
    }

    public void run() {
        String str = null;
        try {
            Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient");
            str = aj.a(this.a);
        } catch (ClassNotFoundException e) {
        }
        if (str != null) {
            byte[] a = v.a(str.getBytes());
            if (a != null) {
                str = a.a(a);
                if (str != null) {
                    Editor edit = this.a.getSharedPreferences("SmartBeat", 0).edit();
                    if (g.s == null) {
                        g.s = str;
                        edit.putString("idv2", str);
                        bd.d(edit);
                    } else if (!g.s.equals(str)) {
                        String uuid = UUID.randomUUID().toString();
                        g.r = "android:" + uuid + ":" + g.q;
                        g.s = str;
                        edit.putString("uuid", uuid);
                        edit.putString("idv2", str);
                        bd.d(edit);
                    }
                }
            }
        }
    }
}
