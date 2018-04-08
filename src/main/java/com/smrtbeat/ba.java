package com.smrtbeat;

import java.util.concurrent.Callable;

class ba implements Callable {
    ba() {
    }

    public Integer a() {
        return Integer.valueOf(SmartBeatJni.getGlLibVersion());
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
