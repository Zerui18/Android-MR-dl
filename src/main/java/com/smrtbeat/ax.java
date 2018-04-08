package com.smrtbeat;

import java.io.File;

class ax implements Runnable {
    File a;
    final /* synthetic */ aw b;

    ax(aw awVar) {
        this.b = awVar;
    }

    Runnable a(File file) {
        this.a = file;
        return this;
    }

    public void run() {
        i.a(this.a, 0);
        this.a.delete();
    }
}
