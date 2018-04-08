package com.tapjoy.internal;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public final class ak extends Animation {
    private final boolean a;
    private final float b;
    private final float c;
    private final int d;
    private final float e;
    private final int f;
    private final float g;
    private float h;
    private float i;
    private Camera j;

    public ak(boolean z, float f, float f2, int i, float f3, int i2, float f4) {
        this.a = z;
        this.b = f;
        this.c = f2;
        this.d = i;
        this.e = f3;
        this.f = i2;
        this.g = f4;
    }

    public final void initialize(int width, int height, int parentWidth, int parentHeight) {
        super.initialize(width, height, parentWidth, parentHeight);
        this.h = resolveSize(this.d, this.e, width, parentWidth);
        this.i = resolveSize(this.f, this.g, height, parentHeight);
        this.j = new Camera();
    }

    protected final void applyTransformation(float interpolatedTime, Transformation t) {
        float f = this.b;
        f += (this.c - f) * interpolatedTime;
        Matrix matrix = t.getMatrix();
        Camera camera = this.j;
        camera.save();
        if (this.a) {
            camera.rotateX(f);
        } else {
            camera.rotateY(f);
        }
        camera.getMatrix(matrix);
        camera.restore();
        f = this.h;
        float f2 = this.i;
        matrix.preTranslate(-f, -f2);
        matrix.postTranslate(f, f2);
    }
}
