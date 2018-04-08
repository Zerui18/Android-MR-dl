package com.smrtbeat;

import java.io.File;
import java.io.FileFilter;

class s implements FileFilter {
    s() {
    }

    public boolean accept(File file) {
        return file.getName().endsWith(".id");
    }
}
