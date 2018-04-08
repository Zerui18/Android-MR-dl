package com.tapjoy.internal;

import android.graphics.Bitmap;
import java.io.InputStream;
import java.net.ContentHandler;
import java.net.URLConnection;

public final class u extends ContentHandler {
    public static final u a = new u();

    public final /* synthetic */ Object getContent(URLConnection x0) {
        return a(x0);
    }

    private u() {
    }

    private static Bitmap a(URLConnection uRLConnection) {
        InputStream inputStream = uRLConnection.getInputStream();
        try {
            Bitmap a = v.a.a(inputStream);
            return a;
        } finally {
            inputStream.close();
        }
    }

    public static Bitmap a(InputStream inputStream) {
        try {
            Bitmap a = v.a.a(inputStream);
            return a;
        } finally {
            inputStream.close();
        }
    }
}
