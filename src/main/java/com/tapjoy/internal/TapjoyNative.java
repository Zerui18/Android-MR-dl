package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacementListener;

@ep
public class TapjoyNative {
    @ep
    public static Object createPlacement(Context context, String placementName, TJPlacementListener listener) {
        return ew.a().a(context, placementName, listener);
    }
}
