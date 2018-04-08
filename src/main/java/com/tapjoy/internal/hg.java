package com.tapjoy.internal;

import android.content.Context;
import android.view.ViewGroup.LayoutParams;

public final class hg extends an {
    private final gq a;
    private final hh b;
    private af c = null;

    public hg(Context context, gq gqVar, hh hhVar) {
        super(context);
        this.a = gqVar;
        this.b = hhVar;
        addView(hhVar, new LayoutParams(-1, -1));
    }

    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        af afVar;
        af a = af.a(getContext());
        if (!this.a.a()) {
            afVar = af.LANDSCAPE;
            if (!a.a()) {
                setRotationCount(0);
            } else if (a.c() == 3) {
                setRotationCount(1);
            } else {
                setRotationCount(1);
            }
        } else if (this.a.b()) {
            if (a.a()) {
                afVar = af.PORTRAIT;
            } else if (a.b() || !af.b(getContext()).a()) {
                afVar = af.LANDSCAPE;
            } else {
                afVar = af.PORTRAIT;
            }
            setRotationCount(0);
        } else {
            afVar = af.PORTRAIT;
            if (!a.b()) {
                setRotationCount(0);
            } else if (a.c() == 3) {
                setRotationCount(1);
            } else {
                setRotationCount(3);
            }
        }
        if (this.c != afVar) {
            this.c = afVar;
            this.b.setLandscape(this.c.b());
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
