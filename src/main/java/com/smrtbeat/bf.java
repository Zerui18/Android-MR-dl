package com.smrtbeat;

import android.content.SharedPreferences.Editor;

class bf implements Runnable {
    Editor a;

    bf() {
    }

    Runnable a(Editor editor) {
        this.a = editor;
        return this;
    }

    public void run() {
        this.a.commit();
    }
}
