package com.tapjoy.mraid.controller;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.JavascriptInterface;
import com.tapjoy.TapjoyLog;
import com.tapjoy.mraid.controller.Defines.Events;
import com.tapjoy.mraid.view.MraidView;

@TargetApi(14)
public class Utility extends Abstract {
    private Assets c;
    private Display d;
    private MraidLocation e;
    private Network f;
    private MraidSensor g;

    public Utility(MraidView adView, Context context) {
        super(adView, context);
        this.c = new Assets(adView, context);
        this.d = new Display(adView, context);
        this.e = new MraidLocation(adView, context);
        this.f = new Network(adView, context);
        this.g = new MraidSensor(adView, context);
        adView.addJavascriptInterface(this.c, "MRAIDAssetsControllerBridge");
        adView.addJavascriptInterface(this.d, "MRAIDDisplayControllerBridge");
        adView.addJavascriptInterface(this.e, "MRAIDLocationControllerBridge");
        adView.addJavascriptInterface(this.f, "MRAIDNetworkControllerBridge");
        adView.addJavascriptInterface(this.g, "MRAIDSensorControllerBridge");
    }

    public void init(float density) {
        StringBuilder append = new StringBuilder("window.mraidview.fireChangeEvent({ state: 'default', network: '").append(this.f.getNetwork()).append("', size: ").append(this.d.getSize()).append(", placement: '").append(this.a.getPlacementType()).append("', maxSize: ").append(this.d.getMaxSize()).append(",expandProperties: ").append(this.d.getMaxSize()).append(", screenSize: ").append(this.d.getScreenSize()).append(", defaultPosition: { x:").append((int) (((float) this.a.getLeft()) / density)).append(", y: ").append((int) (((float) this.a.getTop()) / density)).append(", width: ").append((int) (((float) this.a.getWidth()) / density)).append(", height: ").append((int) (((float) this.a.getHeight()) / density)).append(" }, orientation:").append(this.d.getOrientation()).append(",");
        String str = "supports: [ 'level-1', 'level-2', 'screen', 'orientation', 'network'";
        boolean z = this.e.allowLocationServices() && (this.b.checkCallingOrSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 || this.b.checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0);
        if (z) {
            str = str + ", 'location'";
        }
        str = ((str + ", 'video'") + ", 'audio'") + ", 'map' ]";
        TapjoyLog.d("MRAID Utility", "getSupports: " + str);
        str = append.append(str).append(",viewable:true });").toString();
        TapjoyLog.d("MRAID Utility", "init: injection: " + str);
        this.a.injectMraidJavaScript(str);
        fireReadyEvent();
        fireViewableChange(true);
    }

    public void fireReadyEvent() {
        this.a.injectMraidJavaScript("mraid.signalReady();");
    }

    public void fireViewableChange(boolean visible) {
        this.a.injectMraidJavaScript("window.mraidview.fireChangeEvent({viewable:" + visible + "});");
    }

    public String copyTextFromJarIntoAssetDir(String alias, String source) {
        return this.c.copyTextFromJarIntoAssetDir(alias, source);
    }

    public void setMaxSize(int w, int h) {
        this.d.setMaxSize(w, h);
    }

    @JavascriptInterface
    public void activate(String event) {
        TapjoyLog.d("MRAID Utility", "activate: " + event);
        if (event.equalsIgnoreCase(Events.NETWORK_CHANGE)) {
            this.f.startNetworkListener();
        } else if (this.e.allowLocationServices() && event.equalsIgnoreCase(Events.LOCATION_CHANGE)) {
            this.e.startLocationListener();
        } else if (event.equalsIgnoreCase(Events.SHAKE)) {
            this.g.startShakeListener();
        } else if (event.equalsIgnoreCase(Events.TILT_CHANGE)) {
            this.g.startTiltListener();
        } else if (event.equalsIgnoreCase(Events.HEADING_CHANGE)) {
            this.g.startHeadingListener();
        } else if (event.equalsIgnoreCase(Events.ORIENTATION_CHANGE)) {
            this.d.startConfigurationListener();
        }
    }

    @JavascriptInterface
    public void deactivate(String event) {
        TapjoyLog.d("MRAID Utility", "deactivate: " + event);
        if (event.equalsIgnoreCase(Events.NETWORK_CHANGE)) {
            this.f.stopNetworkListener();
        } else if (event.equalsIgnoreCase(Events.LOCATION_CHANGE)) {
            this.e.stopAllListeners();
        } else if (event.equalsIgnoreCase(Events.SHAKE)) {
            this.g.stopShakeListener();
        } else if (event.equalsIgnoreCase(Events.TILT_CHANGE)) {
            this.g.stopTiltListener();
        } else if (event.equalsIgnoreCase(Events.HEADING_CHANGE)) {
            this.g.stopHeadingListener();
        } else if (event.equalsIgnoreCase(Events.ORIENTATION_CHANGE)) {
            this.d.stopConfigurationListener();
        }
    }

    public void deleteOldAds() {
        this.c.deleteOldAds();
    }

    public void stopAllListeners() {
        try {
            this.c.stopAllListeners();
            this.d.stopAllListeners();
            this.e.stopAllListeners();
            this.f.stopAllListeners();
            this.g.stopAllListeners();
        } catch (Exception e) {
        }
    }

    @JavascriptInterface
    public void showAlert(String message) {
        TapjoyLog.e("MRAID Utility", message);
    }
}
