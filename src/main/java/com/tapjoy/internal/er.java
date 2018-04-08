package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TJPlacementManager;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.internal.gf.a;
import java.util.Observer;

public final class er extends gf {
    private final et b = new et(this) {
        final /* synthetic */ er a;

        {
            this.a = r1;
        }

        protected final /* synthetic */ TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj) {
            a aVar = (a) obj;
            TJPlacement createPlacement = TJPlacementManager.createPlacement(TapjoyConnectCore.getContext(), aVar.b, false, tJPlacementListener);
            createPlacement.pushId = aVar.a;
            return createPlacement;
        }

        protected final /* synthetic */ a b(Object obj) {
            a aVar = (a) obj;
            return new a(this, aVar, aVar.d);
        }

        protected final boolean a() {
            return true;
        }

        protected final boolean a(Observer observer) {
            if (TapjoyConnectCore.isViewOpen()) {
                TJPlacementManager.dismissContentShowing(true);
            }
            return super.a(observer);
        }
    };

    static {
        gf.a(new er());
    }

    public static void a() {
    }

    private er() {
    }

    protected final boolean b() {
        return this.b.b != null;
    }

    protected final void a(a aVar) {
        this.b.c(aVar);
    }
}
