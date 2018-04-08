package android.support.v4.view.animation;

import android.view.animation.Interpolator;
import com.tapjoy.TapjoyConnectCore;

abstract class LookupTableInterpolator implements Interpolator {
    private final float mStepSize = (TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER / ((float) (this.mValues.length - 1)));
    private final float[] mValues;

    public LookupTableInterpolator(float[] values) {
        this.mValues = values;
    }

    public float getInterpolation(float input) {
        if (input >= TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER) {
            return TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER;
        }
        if (input <= 0.0f) {
            return 0.0f;
        }
        int position = Math.min((int) (((float) (this.mValues.length - 1)) * input), this.mValues.length - 2);
        return this.mValues[position] + ((this.mValues[position + 1] - this.mValues[position]) * ((input - (((float) position) * this.mStepSize)) / this.mStepSize));
    }
}
