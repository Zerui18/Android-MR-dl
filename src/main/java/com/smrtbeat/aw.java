package com.smrtbeat;

import android.webkit.MimeTypeMap;
import java.io.File;

class aw implements Runnable {
    File a;
    String b;

    aw() {
    }

    Runnable a(File file, String str) {
        this.a = file;
        this.b = str;
        return this;
    }

    public void run() {
        for (int i = 30; i > 0 && !this.a.exists(); i--) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        if (!this.a.exists()) {
            bd.a(bg.WARN, String.format("missing capture image file path=%s", new Object[]{this.a.getAbsolutePath()}));
        } else if (bd.g()) {
            File b = au.b(this.b, System.currentTimeMillis(), "." + MimeTypeMap.getFileExtensionFromUrl(this.a.getName()));
            b.getParentFile().mkdirs();
            if (!(this.a.renameTo(b) || bd.a(this.a, b))) {
                bd.a(bg.ERROR, String.format("failed to move file from %s to %s", new Object[]{this.a.getAbsolutePath(), b.getAbsolutePath()}));
            }
            Thread thread = new Thread(new ax(this).a(b));
            thread.setPriority(2);
            thread.start();
        } else {
            this.a.delete();
        }
    }
}
