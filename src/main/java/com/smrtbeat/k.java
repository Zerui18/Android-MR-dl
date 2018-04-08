package com.smrtbeat;

import java.io.File;
import java.io.FileFilter;

class k implements FileFilter {
    k() {
    }

    public boolean accept(File file) {
        return file.isDirectory();
    }
}
