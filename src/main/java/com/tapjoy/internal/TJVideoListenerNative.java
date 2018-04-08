package com.tapjoy.internal;

import com.tapjoy.TJVideoListener;

public class TJVideoListenerNative implements TJVideoListener {
    private final long a;

    private static native void onVideoCompleteNative(long j);

    private static native void onVideoErrorNative(long j, int i);

    private static native void onVideoStartNative(long j);

    private TJVideoListenerNative(long nativeHandle) {
        if (nativeHandle == 0) {
            throw new IllegalArgumentException();
        }
        this.a = nativeHandle;
    }

    public void onVideoStart() {
        onVideoStartNative(this.a);
    }

    public void onVideoError(int statusCode) {
        onVideoErrorNative(this.a, statusCode);
    }

    public void onVideoComplete() {
        onVideoCompleteNative(this.a);
    }

    @ep
    static Object create(long nativeHandle) {
        return new TJVideoListenerNative(nativeHandle);
    }
}
