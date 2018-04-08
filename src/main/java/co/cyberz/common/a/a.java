package co.cyberz.common.a;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public abstract class a<P, R> {
    private static final int a;
    private static final int b;
    private static Handler c = new Handler(Looper.getMainLooper());
    private static ExecutorService e = new ThreadPoolExecutor(0, b, 60, TimeUnit.SECONDS, new SynchronousQueue());
    private static ExecutorService f = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());
    private ExecutorService d;
    private FutureTask<R> g;
    private Runnable h;
    private P[] i;
    private Runnable j;
    private boolean k;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        b = (availableProcessors * 2) + 1;
    }

    public a() {
        this.d = new ThreadPoolExecutor(0, 2, 60, TimeUnit.SECONDS, new SynchronousQueue());
        this.k = false;
        this.k = true;
        this.j = new Runnable(this) {
            final /* synthetic */ a a;

            {
                this.a = r1;
            }

            public final void run() {
                final Object b = this.a.b(this.a.i);
                a.c.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 b;

                    public final void run() {
                        this.b.a.a(b);
                    }
                });
            }
        };
    }

    public static void a(Runnable runnable) {
        try {
            e.execute(runnable);
        } catch (Throwable th) {
            co.cyberz.util.f.a.a("Called over capacity tasks", th);
        }
    }

    public static void b(Runnable runnable) {
        try {
            f.execute(runnable);
        } catch (Throwable th) {
            co.cyberz.util.f.a.a("executeAnalysis - Called over capacity tasks", th);
        }
    }

    public void a(@Nullable R r) {
    }

    public final void a(P... pArr) {
        this.i = pArr;
        if (this.k) {
            e.execute(this.j);
            return;
        }
        this.d.execute(this.g);
        this.d.execute(this.h);
    }

    public abstract R b(P... pArr);
}
