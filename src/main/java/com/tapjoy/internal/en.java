package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;

public final class en {
    private static final et a = new et() {
        protected final /* bridge */ /* synthetic */ String a(Object obj) {
            return "InsufficientCurrency";
        }

        protected final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            return TJPlacementManager.createPlacement(context, "InsufficientCurrency", true, tJPlacementListener);
        }
    };

    public static void a() {
        a.c(null);
    }
}
