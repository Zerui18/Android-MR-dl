package com.tapjoy.internal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tapjoy.TapjoyConnectCore;
import java.util.ArrayList;
import java.util.Iterator;

public final class hf extends RelativeLayout {
    private gn a;
    private a b;
    private af c = af.UNSPECIFIED;
    private int d = 0;
    private int e = 0;
    private ArrayList f = new ArrayList();
    private gw g = null;

    public interface a {
        void a();

        void a(gv gvVar);
    }

    public hf(Context context, gn gnVar, a aVar) {
        super(context);
        this.a = gnVar;
        this.b = aVar;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.b.a();
    }

    protected final void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int size2 = MeasureSpec.getSize(heightMeasureSpec);
        if (size >= size2) {
            if (this.c != af.LANDSCAPE) {
                this.c = af.LANDSCAPE;
                a();
            }
        } else if (this.c != af.PORTRAIT) {
            this.c = af.PORTRAIT;
            a();
        }
        if (!(this.d == size && this.e == size2)) {
            float f;
            float f2;
            float f3;
            LayoutParams layoutParams;
            gv gvVar;
            float a;
            float a2;
            float a3;
            float a4;
            int i;
            this.d = size;
            this.e = size2;
            float f4 = (float) size;
            float f5 = (float) size2;
            if (!(this.g == null || this.g.b == null)) {
                float f6 = ((this.g.b.y * f4) / this.g.b.x) / f5;
                if (f6 < TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER) {
                    f6 = (this.g.b.y * f4) / this.g.b.x;
                    f = f4;
                    f2 = 0.0f;
                    f3 = (f5 - f6) / 2.0f;
                    f4 = f6;
                } else if (f6 > TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER) {
                    f6 = (this.g.b.x * f5) / this.g.b.y;
                    f3 = 0.0f;
                    f2 = (f4 - f6) / 2.0f;
                    f4 = f5;
                    f = f6;
                }
                for (View view : ah.a(this)) {
                    layoutParams = (LayoutParams) view.getLayoutParams();
                    gvVar = (gv) view.getTag();
                    a = gvVar.a.a(f, f4);
                    a2 = gvVar.b.a(f, f4);
                    a3 = gvVar.c.a(f, f4);
                    a4 = gvVar.d.a(f, f4);
                    i = gvVar.e;
                    size = gvVar.f;
                    if (i == 14) {
                        i = 9;
                        a += (f - a3) / 2.0f;
                    }
                    if (size == 15) {
                        size = 10;
                        a2 += (f4 - a4) / 2.0f;
                    }
                    layoutParams.addRule(i, -1);
                    layoutParams.addRule(size, -1);
                    layoutParams.width = Math.round(a3);
                    layoutParams.height = Math.round(a4);
                    if (i == 9) {
                        layoutParams.leftMargin = Math.round(f2 + a);
                    } else if (i == 11) {
                        layoutParams.rightMargin = Math.round(f2 + a);
                    }
                    if (size == 10) {
                        layoutParams.topMargin = Math.round(f3 + a2);
                    } else if (size == 12) {
                        layoutParams.bottomMargin = Math.round(f3 + a2);
                    }
                }
            }
            f2 = 0.0f;
            f3 = 0.0f;
            f = f4;
            f4 = f5;
            for (View view2 : ah.a(this)) {
                layoutParams = (LayoutParams) view2.getLayoutParams();
                gvVar = (gv) view2.getTag();
                a = gvVar.a.a(f, f4);
                a2 = gvVar.b.a(f, f4);
                a3 = gvVar.c.a(f, f4);
                a4 = gvVar.d.a(f, f4);
                i = gvVar.e;
                size = gvVar.f;
                if (i == 14) {
                    i = 9;
                    a += (f - a3) / 2.0f;
                }
                if (size == 15) {
                    size = 10;
                    a2 += (f4 - a4) / 2.0f;
                }
                layoutParams.addRule(i, -1);
                layoutParams.addRule(size, -1);
                layoutParams.width = Math.round(a3);
                layoutParams.height = Math.round(a4);
                if (i == 9) {
                    layoutParams.leftMargin = Math.round(f2 + a);
                } else if (i == 11) {
                    layoutParams.rightMargin = Math.round(f2 + a);
                }
                if (size == 10) {
                    layoutParams.topMargin = Math.round(f3 + a2);
                } else if (size == 12) {
                    layoutParams.bottomMargin = Math.round(f3 + a2);
                }
            }
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    private void a() {
        Object obj;
        Iterator it = this.a.a.iterator();
        Resources resources = null;
        while (it.hasNext()) {
            gw gwVar = (gw) it.next();
            if (gwVar.a == this.c) {
                break;
            }
            if (gwVar.a != af.UNSPECIFIED) {
                obj = resources;
            }
            Object obj2 = gwVar;
        }
        obj = resources;
        removeAllViews();
        if (gwVar != null) {
            this.g = gwVar;
            Context context = getContext();
            Iterator it2 = gwVar.c.iterator();
            while (it2.hasNext()) {
                Bitmap bitmap;
                BitmapDrawable bitmapDrawable;
                final gv gvVar = (gv) it2.next();
                View view = new View(context);
                ViewGroup.LayoutParams layoutParams = new LayoutParams(0, 0);
                Bitmap bitmap2 = gvVar.l.b;
                if (gvVar.m != null) {
                    bitmap = gvVar.m.b;
                } else {
                    bitmap = null;
                }
                final Drawable bitmapDrawable2 = new BitmapDrawable(null, bitmap2);
                if (bitmap != null) {
                    bitmapDrawable = new BitmapDrawable(null, bitmap);
                } else {
                    bitmapDrawable = null;
                }
                ag.a(view, bitmapDrawable2);
                view.setOnTouchListener(new OnTouchListener(this) {
                    final /* synthetic */ hf c;

                    public final boolean onTouch(View v, MotionEvent event) {
                        if (event.getAction() == 0) {
                            if (bitmapDrawable != null) {
                                ag.a(v, bitmapDrawable);
                            }
                        } else if (event.getAction() == 1) {
                            ag.a(v, bitmapDrawable2);
                        }
                        return false;
                    }
                });
                view.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ hf b;

                    public final void onClick(View v) {
                        this.b.b.a(gvVar);
                    }
                });
                view.setTag(gvVar);
                addView(view, layoutParams);
            }
        }
    }
}
