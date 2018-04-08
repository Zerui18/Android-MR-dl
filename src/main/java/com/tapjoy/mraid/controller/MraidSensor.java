package com.tapjoy.mraid.controller;

import android.content.Context;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.listener.Accel;
import com.tapjoy.mraid.view.MraidView;

public class MraidSensor extends Abstract {
    final int c = 1000;
    private Accel d;
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;

    public MraidSensor(MraidView adView, Context context) {
        super(adView, context);
        this.d = new Accel(context, this);
    }

    public void startTiltListener() {
        this.d.startTrackingTilt();
    }

    public void startShakeListener() {
        this.d.startTrackingShake();
    }

    public void stopTiltListener() {
        this.d.stopTrackingTilt();
    }

    public void stopShakeListener() {
        this.d.stopTrackingShake();
    }

    public void startHeadingListener() {
        this.d.startTrackingHeading();
    }

    public void stopHeadingListener() {
        this.d.stopTrackingHeading();
    }

    public void onShake() {
        this.a.injectMraidJavaScript("mraid.gotShake()");
    }

    public void onTilt(float x, float y, float z) {
        this.e = x;
        this.f = y;
        this.g = z;
        String str = "window.mraidview.fireChangeEvent({ tilt: " + getTilt() + "})";
        TapjoyLog.d("MRAID Sensor", str);
        this.a.injectMraidJavaScript(str);
    }

    public String getTilt() {
        String str = "{ x : \"" + this.e + "\", y : \"" + this.f + "\", z : \"" + this.g + "\"}";
        TapjoyLog.d("MRAID Sensor", "getTilt: " + str);
        return str;
    }

    public void onHeadingChange(float f) {
        String str = "window.mraidview.fireChangeEvent({ heading: " + ((int) (((double) f) * 57.29577951308232d)) + "});";
        TapjoyLog.d("MRAID Sensor", str);
        this.a.injectMraidJavaScript(str);
    }

    public float getHeading() {
        TapjoyLog.d("MRAID Sensor", "getHeading: " + this.d.getHeading());
        return this.d.getHeading();
    }

    public void stopAllListeners() {
        this.d.stopAllListeners();
    }
}
