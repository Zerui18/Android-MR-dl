package com.smrtbeat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class r implements at {
    ar a = null;
    File b = null;

    r() {
    }

    public ar a() {
        return this.a;
    }

    at a(File file) {
        this.b = file;
        return this;
    }

    public void run() {
        List arrayList = new ArrayList(1);
        arrayList.add(new ab("screenshot", this.b.getName(), this.b));
        this.a = new aa("https://images.smbeat.jp/api/upload", arrayList).a(10000, false);
    }
}
