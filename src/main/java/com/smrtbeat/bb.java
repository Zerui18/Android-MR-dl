package com.smrtbeat;

import java.io.File;
import java.io.FilenameFilter;

class bb implements FilenameFilter {
    private final /* synthetic */ String a;

    bb(String str) {
        this.a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.a);
    }
}
