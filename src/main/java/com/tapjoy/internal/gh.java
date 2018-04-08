package com.tapjoy.internal;

import android.content.SharedPreferences.Editor;
import android.os.SystemClock;
import com.tapjoy.internal.gl.c.a;
import com.tapjoy.internal.gl.i;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class gh {
    final ft a;
    final AtomicBoolean b = new AtomicBoolean();
    ScheduledFuture c;
    private final Runnable d = new Runnable(this) {
        final /* synthetic */ gh a;

        {
            this.a = r1;
        }

        public final void run() {
            if (this.a.b.compareAndSet(true, false)) {
                fr.a("The session ended");
                ft ftVar = this.a.a;
                long elapsedRealtime = SystemClock.elapsedRealtime() - ftVar.c;
                fx fxVar = ftVar.a;
                synchronized (fxVar) {
                    long a = fxVar.c.i.a() + elapsedRealtime;
                    fxVar.c.i.a(a);
                    fxVar.b.b(a);
                }
                a d = ftVar.a(i.APP, "session").d(elapsedRealtime);
                ftVar.a(d);
                ftVar.c = 0;
                fx fxVar2 = ftVar.a;
                long j = d.e;
                synchronized (fxVar2) {
                    Editor a2 = fxVar2.c.a();
                    fxVar2.c.j.a(a2, j);
                    fxVar2.c.k.a(a2, elapsedRealtime);
                    a2.commit();
                    fxVar2.b.c(j);
                    fxVar2.b.d(elapsedRealtime);
                }
                fs fsVar = ftVar.b;
                if (fsVar.b != null) {
                    fsVar.a();
                    new hc(fsVar) {
                        final /* synthetic */ fs a;

                        {
                            this.a = r1;
                        }

                        protected final boolean a() {
                            return !this.a.a.c();
                        }
                    }.run();
                }
                fsVar.a.flush();
                eo.d.notifyObservers();
            }
        }
    };
    private final Runnable e = new Runnable(this) {
        final /* synthetic */ gh a;

        {
            this.a = r1;
        }

        public final void run() {
        }
    };

    gh(ft ftVar) {
        this.a = ftVar;
    }

    public final void a() {
        if (!this.b.get()) {
            return;
        }
        if (!Boolean.FALSE.booleanValue()) {
            this.d.run();
        } else if (this.c == null || this.c.cancel(false)) {
            this.c = gi.a.schedule(this.d, 3000, TimeUnit.MILLISECONDS);
        }
    }
}
