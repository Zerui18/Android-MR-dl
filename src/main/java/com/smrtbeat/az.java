package com.smrtbeat;

import java.util.concurrent.Callable;

class az implements Callable {
    az() {
    }

    public Integer a() {
        return Integer.valueOf(SmartBeatJni.getVersion());
    }

    public /* synthetic */ Object call() {
        return a();
    }
}
