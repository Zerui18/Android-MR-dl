package com.tapjoy.internal;

import android.os.SystemClock;

public final class eg {
    public static final eg a = new eg(-1);
    public final long b;
    public long c;

    public eg(long j) {
        this.b = j;
        this.c = SystemClock.elapsedRealtime();
    }

    public eg() {
        this.b = 3600000;
        try {
            this.c = SystemClock.elapsedRealtime() - 3600000;
        } catch (NullPointerException e) {
            this.c = -1;
        }
    }

    public final boolean a() {
        try {
            return SystemClock.elapsedRealtime() - this.c > this.b;
        } catch (NullPointerException e) {
            return true;
        }
    }

    public final boolean a(long j) {
        try {
            return (SystemClock.elapsedRealtime() - this.c) + j > this.b;
        } catch (NullPointerException e) {
            return true;
        }
    }
}
