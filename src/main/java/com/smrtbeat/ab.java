package com.smrtbeat;

import java.io.File;

class ab {
    private String a;
    private String b;
    private File c;

    ab(String str, String str2, File file) {
        this.a = str;
        this.b = str2;
        this.c = file;
    }

    String a() {
        return this.a;
    }

    String b() {
        return this.b;
    }

    File c() {
        return this.c;
    }
}
