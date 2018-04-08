package com.tapjoy;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.widget.ImageButton;
import android.widget.RelativeLayout.LayoutParams;

public class TJCloseButton extends ImageButton {
    private ClosePosition a;

    public enum ClosePosition {
        TOP_LEFT(new int[]{10, 9}),
        TOP_CENTER(new int[]{10, 14}),
        TOP_RIGHT(new int[]{10, 11}),
        CENTER(new int[]{13}),
        BOTTOM_LEFT(new int[]{12, 9}),
        BOTTOM_CENTER(new int[]{12, 14}),
        BOTTOM_RIGHT(new int[]{12, 11});
        
        final LayoutParams a;

        private ClosePosition(int[] layoutParams) {
            this.a = new LayoutParams(-2, -2);
            for (int addRule : layoutParams) {
                this.a.addRule(addRule);
            }
            int deviceScreenDensityScale = (int) (-10.0f * TapjoyConnectCore.getDeviceScreenDensityScale());
            this.a.setMargins(0, deviceScreenDensityScale, deviceScreenDensityScale, 0);
        }
    }

    public TJCloseButton(Context context) {
        this(context, ClosePosition.TOP_RIGHT);
    }

    public TJCloseButton(Context context, ClosePosition closePosition) {
        super(context);
        this.a = closePosition;
        setImageBitmap(TapjoyUtil.loadBitmapFromJar("tj_close_button.png", context));
        setBackgroundColor(ViewCompat.MEASURED_SIZE_MASK);
        setLayoutParams(this.a.a);
    }

    @TargetApi(11)
    protected void onAttachedToWindow() {
        if (VERSION.SDK_INT >= 12) {
            setAlpha(0.0f);
            setVisibility(0);
            setClickable(false);
            new Handler().postDelayed(new Runnable(this) {
                final /* synthetic */ TJCloseButton a;

                {
                    this.a = r1;
                }

                @SuppressLint({"NewApi"})
                public final void run() {
                    this.a.animate().alpha(TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER).setDuration(500).setListener(new AnimatorListener(this) {
                        final /* synthetic */ AnonymousClass1 a;

                        {
                            this.a = r1;
                        }

                        public final void onAnimationCancel(Animator arg0) {
                            this.a.a.setClickable(true);
                        }

                        public final void onAnimationRepeat(Animator arg0) {
                        }

                        public final void onAnimationStart(Animator arg0) {
                        }

                        public final void onAnimationEnd(Animator arg0) {
                            this.a.a.setClickable(true);
                        }
                    });
                }
            }, 2000);
        }
    }
}
