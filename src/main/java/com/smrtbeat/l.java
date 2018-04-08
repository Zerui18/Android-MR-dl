package com.smrtbeat;

import java.io.File;
import java.io.FilenameFilter;

class l implements FilenameFilter {
    l() {
    }

    public boolean accept(File file, String str) {
        return str.endsWith(".id");
    }
}
