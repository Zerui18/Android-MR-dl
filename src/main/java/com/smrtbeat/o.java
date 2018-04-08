package com.smrtbeat;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

class o implements at {
    ar a = null;
    File b = null;
    File c = null;
    File d = null;

    o() {
    }

    public ar a() {
        return this.a;
    }

    at a(File file, File file2, File file3) {
        this.b = file;
        this.c = file2;
        this.d = file3;
        return this;
    }

    public void run() {
        try {
            List arrayList = new ArrayList(2);
            arrayList.add(new ab("errors", "json.txt", this.b));
            arrayList.add(new ab("minidump", this.d.getName(), this.c));
            this.a = new aa("https://minidumps.smbeat.jp/api/errors/multi", arrayList).a(2000, true);
        } catch (Exception e) {
        }
    }
}
