package com.unity3d.player;

import android.os.Build.VERSION;

public final class i {
    static final boolean a = (VERSION.SDK_INT >= 11);
    static final boolean b = (VERSION.SDK_INT >= 17);
    static final boolean c = (VERSION.SDK_INT >= 19);
    static final boolean d = (VERSION.SDK_INT >= 21);
    static final boolean e;
    static final c f = (a ? new b() : null);
    static final d g = (b ? new f() : null);
    static final e h;

    static {
        e eVar = null;
        boolean z = true;
        if (VERSION.SDK_INT < 23) {
            z = false;
        }
        e = z;
        if (e) {
            eVar = new h();
        }
        h = eVar;
    }
}
