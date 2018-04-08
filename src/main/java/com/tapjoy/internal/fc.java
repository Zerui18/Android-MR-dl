package com.tapjoy.internal;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class fc extends fb {
    private final ThreadPoolExecutor b = new ThreadPoolExecutor(0, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());

    class a implements Runnable {
        final /* synthetic */ fc a;
        private int b;
        private long c;
        private String d;
        private String e;
        private Map f;

        a(fc fcVar, int i, long j, String str, String str2, Map map) {
            this.a = fcVar;
            this.b = i;
            this.c = j;
            this.d = str;
            this.e = str2;
            this.f = map;
        }

        public final void run() {
            try {
                switch (this.b) {
                    case 1:
                        super.a(this.c);
                        return;
                    case 2:
                        super.a();
                        return;
                    case 3:
                        super.a(this.c, this.d, this.e, this.f);
                        return;
                    default:
                        return;
                }
            } catch (Throwable th) {
                super.a();
            }
            super.a();
        }
    }

    public fc(File file, ft ftVar) {
        super(file, ftVar);
    }

    protected final void finalize() {
        try {
            this.b.shutdown();
            this.b.awaitTermination(1, TimeUnit.SECONDS);
        } finally {
            super.finalize();
        }
    }

    protected final void a(long j) {
        try {
            this.b.execute(new a(this, 1, j, null, null, null));
        } catch (Throwable th) {
        }
    }

    protected final void a() {
        try {
            this.b.execute(new a(this, 2, 0, null, null, null));
        } catch (Throwable th) {
        }
    }

    protected final void a(long j, String str, String str2, Map map) {
        try {
            this.b.execute(new a(this, 3, j, str, str2, map != null ? new HashMap(map) : null));
        } catch (Throwable th) {
        }
    }
}
