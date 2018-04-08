package com.tapjoy.internal;

import com.tapjoy.TJEarnedCurrencyListener;

public class TJEarnedCurrencyListenerNative implements TJEarnedCurrencyListener {
    private final long a;

    private static native void onEarnedCurrencyNative(long j, String str, int i);

    private TJEarnedCurrencyListenerNative(long nativeHandle) {
        if (nativeHandle == 0) {
            throw new IllegalArgumentException();
        }
        this.a = nativeHandle;
    }

    public void onEarnedCurrency(String currencyName, int amount) {
        onEarnedCurrencyNative(this.a, currencyName, amount);
    }

    @ep
    static Object create(long nativeHandle) {
        return new TJEarnedCurrencyListenerNative(nativeHandle);
    }
}
