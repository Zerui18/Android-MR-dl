package com.smrtbeat;

import android.graphics.Point;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;

class am {
    am() {
    }

    public static Point a() {
        int[] iArr = new int[2];
        EGLDisplay eglGetCurrentDisplay = EGL14.eglGetCurrentDisplay();
        EGLSurface eglGetCurrentSurface = EGL14.eglGetCurrentSurface(12377);
        EGL14.eglQuerySurface(eglGetCurrentDisplay, eglGetCurrentSurface, 12375, iArr, 0);
        EGL14.eglQuerySurface(eglGetCurrentDisplay, eglGetCurrentSurface, 12374, iArr, 1);
        return new Point(iArr[0], iArr[1]);
    }
}
