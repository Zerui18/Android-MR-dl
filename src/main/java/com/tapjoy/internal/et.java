package com.tapjoy.internal;

import android.content.Context;
import com.tapjoy.TJActionRequest;
import com.tapjoy.TJError;
import com.tapjoy.TJPlacement;
import com.tapjoy.TJPlacementListener;
import com.tapjoy.TapjoyConnectCore;
import com.tapjoy.TapjoyConstants;
import com.tapjoy.TapjoyLog;
import java.util.Observable;
import java.util.Observer;

abstract class et {
    volatile a b;

    class a implements TJPlacementListener, Observer {
        final /* synthetic */ et a;
        private final Object b;
        private final eg c;
        private volatile boolean d;
        private TJPlacement e;

        a(et etVar, Object obj) {
            this(etVar, obj, new eg(TapjoyConstants.TIMER_INCREMENT));
        }

        a(et etVar, Object obj, eg egVar) {
            this.a = etVar;
            this.b = obj;
            this.c = egVar;
        }

        final void a() {
            synchronized (this) {
                if (this.d) {
                } else if (this.c.a()) {
                    a("Timed out");
                } else {
                    if (!TapjoyConnectCore.isConnected()) {
                        eo.a.addObserver(this);
                        if (TapjoyConnectCore.isConnected()) {
                            eo.a.deleteObserver(this);
                        } else {
                            return;
                        }
                    }
                    if (this.e == null) {
                        if (this.a.a()) {
                            this.e = this.a.a(TapjoyConnectCore.getContext(), this, this.b);
                            this.e.requestContent();
                            return;
                        }
                        a("Cannot request");
                    } else if (!this.e.isContentReady()) {
                    } else if (this.a.a((Observer) this)) {
                        this.e.showContent();
                        a(null);
                    }
                }
            }
        }

        private void a(String str) {
            synchronized (this) {
                String a = this.a.a(this.b);
                if (str == null) {
                    TapjoyLog.i("SystemPlacement", "Placement " + a + " is presented now");
                } else {
                    TapjoyLog.i("SystemPlacement", "Cannot show placement " + a + " now (" + str + ")");
                }
                this.d = true;
                this.e = null;
                eo.a.deleteObserver(this);
                eo.e.deleteObserver(this);
                eo.c.deleteObserver(this);
            }
            et etVar = this.a;
            synchronized (etVar) {
                if (etVar.b == this) {
                    etVar.b = null;
                }
            }
        }

        public final void update(Observable observable, Object data) {
            a();
        }

        public final void onRequestSuccess(TJPlacement placement) {
        }

        public final void onRequestFailure(TJPlacement placement, TJError error) {
            a(error.message);
        }

        public final void onContentReady(TJPlacement placement) {
            a();
        }

        public final void onContentShow(TJPlacement placement) {
        }

        public final void onContentDismiss(TJPlacement placement) {
        }

        public final void onPurchaseRequest(TJPlacement placement, TJActionRequest request, String productId) {
        }

        public final void onRewardRequest(TJPlacement placement, TJActionRequest request, String itemId, int quantity) {
        }
    }

    protected abstract TJPlacement a(Context context, TJPlacementListener tJPlacementListener, Object obj);

    protected abstract String a(Object obj);

    et() {
    }

    public final boolean c(Object obj) {
        if (!a()) {
            return false;
        }
        a aVar = null;
        synchronized (this) {
            if (this.b == null) {
                aVar = b(obj);
                this.b = aVar;
            }
        }
        if (aVar == null) {
            return false;
        }
        aVar.a();
        return true;
    }

    protected a b(Object obj) {
        return new a(this, obj);
    }

    protected boolean a() {
        return !TapjoyConnectCore.isFullScreenViewOpen();
    }

    protected boolean a(Observer observer) {
        if (TapjoyConnectCore.isFullScreenViewOpen()) {
            eo.e.addObserver(observer);
            if (TapjoyConnectCore.isFullScreenViewOpen()) {
                return false;
            }
            eo.e.deleteObserver(observer);
        }
        if (!fu.a().d()) {
            eo.c.addObserver(observer);
            if (!fu.a().d()) {
                return false;
            }
            eo.c.deleteObserver(observer);
        }
        return true;
    }
}
