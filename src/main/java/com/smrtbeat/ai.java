package com.smrtbeat;

import android.opengl.GLES20;
import android.support.v4.view.InputDeviceCompat;

class ai {
    final /* synthetic */ ag a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private boolean h;
    private boolean i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int[] p = new int[4];

    ai(ag agVar) {
        this.a = agVar;
    }

    void a(int i, boolean z) {
        int[] iArr = new int[1];
        GLES20.glGetIntegerv(34016, iArr, 0);
        this.b = iArr[0];
        GLES20.glActiveTexture(33984);
        GLES20.glGetIntegerv(32873, iArr, 0);
        this.c = iArr[0];
        GLES20.glGetIntegerv(35725, iArr, 0);
        this.d = iArr[0];
        GLES20.glGetIntegerv(34965, iArr, 0);
        this.e = iArr[0];
        GLES20.glGetIntegerv(34964, iArr, 0);
        this.f = iArr[0];
        this.g = GLES20.glIsEnabled(3042);
        if (this.g) {
            GLES20.glDisable(3042);
        }
        this.h = GLES20.glIsEnabled(2884);
        if (this.h) {
            GLES20.glDisable(2884);
        }
        this.i = GLES20.glIsEnabled(2929);
        if (this.i) {
            GLES20.glDisable(2929);
        }
        GLES20.glGetIntegerv(2932, iArr, 0);
        this.j = iArr[0];
        if (this.j != InputDeviceCompat.SOURCE_DPAD) {
            GLES20.glDepthFunc(InputDeviceCompat.SOURCE_DPAD);
        }
        if (i > 0) {
            GLES20.glBindTexture(3553, i);
        }
        if (z) {
            GLES20.glGetTexParameteriv(3553, 10240, iArr, 0);
            this.k = iArr[0];
            if (this.k != 9728) {
                GLES20.glTexParameteri(3553, 10240, 9728);
            }
            GLES20.glGetTexParameteriv(3553, 10241, iArr, 0);
            this.l = iArr[0];
            if (this.l != 9728) {
                GLES20.glTexParameteri(3553, 10241, 9728);
            }
            GLES20.glGetTexParameteriv(3553, 10242, iArr, 0);
            this.m = iArr[0];
            if (this.m != 33071) {
                GLES20.glTexParameteri(3553, 10242, 33071);
            }
            GLES20.glGetTexParameteriv(3553, 10243, iArr, 0);
            this.n = iArr[0];
            if (this.n != 33071) {
                GLES20.glTexParameteri(3553, 10243, 33071);
            }
        }
        GLES20.glGetIntegerv(36006, iArr, 0);
        this.o = iArr[0];
        GLES20.glGetIntegerv(2978, this.p, 0);
    }

    void a(boolean z, boolean z2) {
        if (z2) {
            GLES20.glBindFramebuffer(36160, this.o);
            GLES20.glClear(16640);
        }
        GLES20.glViewport(this.p[0], this.p[1], this.p[2], this.p[3]);
        if (z) {
            if (this.k != 9728) {
                GLES20.glTexParameteri(3553, 10240, this.k);
            }
            if (this.l != 9728) {
                GLES20.glTexParameteri(3553, 10241, this.l);
            }
            if (this.m != 33071) {
                GLES20.glTexParameteri(3553, 10242, this.m);
            }
            if (this.n != 33071) {
                GLES20.glTexParameteri(3553, 10243, this.n);
            }
        }
        if (this.j != InputDeviceCompat.SOURCE_DPAD) {
            GLES20.glDepthFunc(this.j);
        }
        if (this.i) {
            GLES20.glEnable(2929);
        }
        if (this.h) {
            GLES20.glEnable(2884);
        }
        if (this.g) {
            GLES20.glEnable(3042);
        }
        GLES20.glUseProgram(this.d);
        GLES20.glBindBuffer(34963, this.e);
        GLES20.glBindBuffer(34962, this.f);
        GLES20.glBindTexture(3553, this.c);
        if (this.b != 33984) {
            GLES20.glActiveTexture(this.b);
        }
        ag.e("restoreParams");
    }
}
