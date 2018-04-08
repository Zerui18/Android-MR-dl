package com.tapjoy.internal;

import com.tapjoy.TJAwardCurrencyListener;

public class TJAwardCurrencyListenerNative implements TJAwardCurrencyListener {
    private final long a;

    private static native void onAwardCurrencyResponseFailureNative(long j, String str);

    private static native void onAwardCurrencyResponseNative(long j, String str, int i);

    private TJAwardCurrencyListenerNative(long nativeHandle) {
        if (nativeHandle == 0) {
            throw new IllegalArgumentException();
        }
        this.a = nativeHandle;
    }

    public void onAwardCurrencyResponse(String currencyName, int balance) {
        onAwardCurrencyResponseNative(this.a, currencyName, balance);
    }

    public void onAwardCurrencyResponseFailure(String error) {
        onAwardCurrencyResponseFailureNative(this.a, error);
    }

    @ep
    static Object create(long nativeHandle) {
        return new TJAwardCurrencyListenerNative(nativeHandle);
    }
}
