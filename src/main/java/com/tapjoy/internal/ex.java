package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;

final class ex extends ew {
    ex() {
    }

    public final Object a(Context context, String str, TJPlacementListener tJPlacementListener) {
        return new TJPlacement(context, str, tJPlacementListener);
    }
}
