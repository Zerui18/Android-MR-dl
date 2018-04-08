package com.tapjoy;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.moat.analytics.mobile.tjy.MoatAdEvent;
import com.moat.analytics.mobile.tjy.MoatAdEventType;
import com.moat.analytics.mobile.tjy.MoatFactory;
import com.moat.analytics.mobile.tjy.ReactiveVideoTracker;
import com.moat.analytics.mobile.tjy.ReactiveVideoTrackerPlugin;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.cr;
import com.tapjoy.mraid.view.MraidView;
import com.tapjoy.mraid.view.MraidView.PLACEMENT_TYPE;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

@SuppressLint({"SetJavaScriptEnabled"})
public class TJAdUnitJSBridge {
    private TJWebViewJSInterface a;
    public boolean allowRedirect;
    private TJAdUnitJSBridge b;
    private Context c;
    public boolean closeRequested;
    public boolean customClose;
    private TJAdUnit d;
    public boolean didLaunchOtherActivity;
    private WebView e;
    private ProgressDialog f;
    private LocationManager g;
    private LocationListener h;
    private View i;
    private boolean j;
    private ReactiveVideoTracker k;
    private HashMap l;
    private Handler m;
    public String otherActivityCallbackID;

    public interface AdUnitAsyncTaskListner {
        void onComplete(boolean z);
    }

    @TargetApi(11)
    class a extends AsyncTask {
        WebView a;
        final /* synthetic */ TJAdUnitJSBridge b;

        protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] x0) {
            return (Boolean[]) x0;
        }

        protected final /* synthetic */ void onPostExecute(Object x0) {
            Boolean[] boolArr = (Boolean[]) x0;
            final boolean booleanValue = boolArr[0].booleanValue();
            final boolean booleanValue2 = boolArr[1].booleanValue();
            if (this.b.c instanceof Activity) {
                ((Activity) this.b.c).runOnUiThread(new Runnable(this) {
                    final /* synthetic */ a c;

                    public final void run() {
                        if (booleanValue) {
                            this.c.a.setVisibility(0);
                            if (booleanValue2) {
                                if (this.c.a.getParent() instanceof RelativeLayout) {
                                    ((RelativeLayout) this.c.a.getParent()).getBackground().setAlpha(0);
                                    ((RelativeLayout) this.c.a.getParent()).setBackgroundColor(0);
                                }
                                if (VERSION.SDK_INT >= 11) {
                                    this.c.a.setLayerType(1, null);
                                    return;
                                }
                                return;
                            }
                            if (this.c.a.getParent() instanceof RelativeLayout) {
                                ((RelativeLayout) this.c.a.getParent()).getBackground().setAlpha(255);
                                ((RelativeLayout) this.c.a.getParent()).setBackgroundColor(-1);
                            }
                            if (VERSION.SDK_INT >= 11) {
                                this.c.a.setLayerType(0, null);
                                return;
                            }
                            return;
                        }
                        this.c.a.setVisibility(4);
                        if (this.c.a.getParent() instanceof RelativeLayout) {
                            ((RelativeLayout) this.c.a.getParent()).getBackground().setAlpha(0);
                            ((RelativeLayout) this.c.a.getParent()).setBackgroundColor(0);
                        }
                    }
                });
            } else {
                TapjoyLog.e("TJAdUnitJSBridge", "Unable to present offerwall. No Activity context provided.");
            }
        }

        public a(TJAdUnitJSBridge tJAdUnitJSBridge, WebView webView) {
            this.b = tJAdUnitJSBridge;
            this.a = webView;
        }
    }

    public TJAdUnitJSBridge(Context c, TJAdUnit tjAdUnit) {
        this(c, tjAdUnit.getWebView());
        this.d = tjAdUnit;
    }

    public TJAdUnitJSBridge(Context c, WebView w) {
        this.i = null;
        this.didLaunchOtherActivity = false;
        this.allowRedirect = true;
        this.otherActivityCallbackID = null;
        this.customClose = false;
        this.closeRequested = false;
        TapjoyLog.i("TJAdUnitJSBridge", "creating AdUnit/JS Bridge");
        this.c = c;
        this.e = w;
        this.b = this;
        if (this.e == null) {
            TapjoyLog.e("TJAdUnitJSBridge", new TapjoyErrorMessage(ErrorType.SDK_ERROR, "Cannot create AdUnitJSBridge -- webview is NULL"));
            return;
        }
        this.a = new TJWebViewJSInterface(this.e, new TJWebViewJSInterfaceListener(this) {
            final /* synthetic */ TJAdUnitJSBridge a;

            {
                this.a = r1;
            }

            public final void onDispatchMethod(String methodName, JSONObject json) {
                if (this.a.j) {
                    String string;
                    String str = null;
                    try {
                        string = json.getString(String.CALLBACK_ID);
                    } catch (Exception e) {
                        string = str;
                    }
                    try {
                        JSONObject jSONObject = json.getJSONObject(String.DATA);
                        Method method = TJAdUnitJSBridge.class.getMethod(methodName, new Class[]{JSONObject.class, String.class});
                        TapjoyLog.d("TJAdUnitJSBridge", "Dispatching method with method name=" + method + ";data=" + jSONObject + ";callbackID=" + string);
                        method.invoke(this.a.b, new Object[]{jSONObject, string});
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        this.a.invokeJSCallback(string, Boolean.FALSE);
                    }
                }
            }
        });
        this.e.addJavascriptInterface(this.a, TJAdUnitConstants.JAVASCRIPT_INTERFACE_ID);
        this.j = true;
    }

    public void alert(JSONObject json, final String callbackID) {
        CharSequence charSequence;
        JSONArray jSONArray;
        Exception e;
        JSONArray jSONArray2;
        Object obj;
        AlertDialog create;
        TapjoyLog.d("TJAdUnitJSBridge", "alert_method: " + json);
        CharSequence charSequence2 = "";
        String str = "";
        JSONArray jSONArray3 = null;
        String string;
        try {
            charSequence2 = json.getString(String.TITLE);
            string = json.getString(String.MESSAGE);
            try {
                charSequence = string;
                jSONArray = json.getJSONArray(String.BUTTONS);
            } catch (Exception e2) {
                e = e2;
                invokeJSCallback(callbackID, Boolean.FALSE);
                e.printStackTrace();
                jSONArray2 = jSONArray3;
                obj = string;
                jSONArray = jSONArray2;
                create = new Builder(this.c).setTitle(charSequence2).setMessage(charSequence).create();
                if (jSONArray != null) {
                }
                invokeJSCallback(callbackID, Boolean.FALSE);
                return;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            string = str;
            e = exception;
            invokeJSCallback(callbackID, Boolean.FALSE);
            e.printStackTrace();
            jSONArray2 = jSONArray3;
            obj = string;
            jSONArray = jSONArray2;
            create = new Builder(this.c).setTitle(charSequence2).setMessage(charSequence).create();
            if (jSONArray != null) {
            }
            invokeJSCallback(callbackID, Boolean.FALSE);
            return;
        }
        create = new Builder(this.c).setTitle(charSequence2).setMessage(charSequence).create();
        if (jSONArray != null || jSONArray.length() == 0) {
            invokeJSCallback(callbackID, Boolean.FALSE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            int i2;
            switch (i) {
                case 0:
                    i2 = -2;
                    break;
                case 1:
                    i2 = -3;
                    break;
                default:
                    i2 = -1;
                    break;
            }
            try {
                arrayList.add(jSONArray.getString(i));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            create.setButton(i2, (CharSequence) arrayList.get(i), new OnClickListener(this) {
                final /* synthetic */ TJAdUnitJSBridge b;

                public final void onClick(DialogInterface dialog, int which) {
                    int i = 0;
                    switch (which) {
                        case -3:
                            i = 1;
                            break;
                        case -1:
                            i = 2;
                            break;
                    }
                    try {
                        this.b.invokeJSCallback(callbackID, Integer.valueOf(i));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        create.setCancelable(false);
        create.setCanceledOnTouchOutside(false);
        create.show();
    }

    public void checkAppInstalled(JSONObject json, String callbackID) {
        String str = "";
        try {
            str = json.getString(String.BUNDLE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str != null && str.length() > 0) {
            for (ApplicationInfo applicationInfo : this.c.getPackageManager().getInstalledApplications(0)) {
                if (applicationInfo.packageName.equals(str)) {
                    invokeJSCallback(callbackID, Boolean.TRUE);
                    return;
                }
            }
        }
        invokeJSCallback(callbackID, Boolean.FALSE);
    }

    public void getInstalledAppData(JSONObject json, String callbackID) {
        PackageManager packageManager = this.c.getPackageManager();
        List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(0);
        JSONArray jSONArray = new JSONArray();
        for (ApplicationInfo applicationInfo : installedApplications) {
            if ((applicationInfo.flags & 1) != 1) {
                Map hashMap = new HashMap();
                String str = applicationInfo.packageName;
                hashMap.put("packageName", str);
                hashMap.put("targetSdk", Integer.valueOf(applicationInfo.targetSdkVersion));
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo(str, 4096);
                    hashMap.put("installTime", new Date(packageInfo.firstInstallTime));
                    hashMap.put("updateTime", new Date(packageInfo.lastUpdateTime));
                    hashMap.put("versionName", packageInfo.versionName);
                    hashMap.put("versionCode", Integer.valueOf(packageInfo.versionCode));
                    jSONArray.put(new JSONObject(hashMap));
                } catch (Exception e) {
                }
            }
        }
        invokeJSCallback(callbackID, jSONArray);
    }

    public void closeRequested(Boolean shouldForceClose) {
        this.closeRequested = true;
        Map hashMap = new HashMap();
        hashMap.put(String.FORCE_CLOSE, shouldForceClose);
        invokeJSAdunitMethod(String.CLOSE_REQUESTED, hashMap);
    }

    public void getVolume(JSONObject json, String callbackID) {
        Map volumeArgs = getVolumeArgs();
        if (volumeArgs != null) {
            invokeJSCallback(callbackID, volumeArgs);
            return;
        }
        invokeJSCallback(callbackID, Boolean.valueOf(false));
    }

    public void onVolumeChanged() {
        invokeJSAdunitMethod(String.VOLUME_CHANGED, getVolumeArgs());
    }

    public HashMap getVolumeArgs() {
        if (this.d == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            return null;
        }
        String volume = this.d.getVolume();
        boolean isMuted = this.d.isMuted();
        TapjoyLog.d("TJAdUnitJSBridge", "getVolumeArgs: volume=" + volume + "; isMuted=" + isMuted);
        HashMap hashMap = new HashMap();
        hashMap.put(String.CURRENT_VOLUME, volume);
        hashMap.put(String.IS_MUTED, Boolean.valueOf(isMuted));
        return hashMap;
    }

    public void destroy() {
        if (this.h != null && this.g != null) {
            this.g.removeUpdates(this.h);
            this.g = null;
            this.h = null;
        }
    }

    public void dismiss(JSONObject json, String callbackID) {
        if (this.c instanceof TJAdUnitActivity) {
            invokeJSCallback(callbackID, Boolean.valueOf(true));
            ((Activity) this.c).finish();
            return;
        }
        invokeJSCallback(callbackID, Boolean.valueOf(false));
    }

    public void display() {
        invokeJSAdunitMethod(String.DISPLAY, new Object[0]);
    }

    public void displayRichMedia(final JSONObject json, String callbackID) {
        boolean z;
        String string;
        try {
            z = json.getBoolean(String.INLINE);
        } catch (Exception e) {
            z = false;
        }
        try {
            string = json.getString(String.HTML);
        } catch (Exception e2) {
            e2.printStackTrace();
            string = null;
        }
        if (string == null) {
            invokeJSCallback(callbackID, Boolean.FALSE);
        } else if (z) {
            ((Activity) this.c).runOnUiThread(new Runnable(this) {
                final /* synthetic */ TJAdUnitJSBridge b;

                public final void run() {
                    String string;
                    try {
                        string = json.getString(String.HTML);
                    } catch (Exception e) {
                        e.printStackTrace();
                        string = null;
                    }
                    if (!(this.b.i == null || this.b.i.getParent() == null)) {
                        ((ViewGroup) this.b.i.getParent()).removeView(this.b.i);
                    }
                    View mraidView = new MraidView(this.b.c);
                    this.b.e.getSettings().setJavaScriptEnabled(true);
                    mraidView.setPlacementType(PLACEMENT_TYPE.INLINE);
                    mraidView.setLayoutParams(new LayoutParams(640, 100));
                    mraidView.setInitialScale(100);
                    mraidView.setBackgroundColor(0);
                    mraidView.loadDataWithBaseURL(null, string, "text/html", "utf-8", null);
                    int width = ((WindowManager) ((Activity) this.b.c).getSystemService("window")).getDefaultDisplay().getWidth();
                    this.b.i = TapjoyUtil.scaleDisplayAd(mraidView, width);
                    ((Activity) this.b.c).addContentView(this.b.i, new LayoutParams(width, (int) (100.0d * (((double) width) / 640.0d))));
                }
            });
        } else {
            Serializable tJPlacementData = new TJPlacementData(TapjoyConnectCore.getHostURL(), string, callbackID);
            Intent intent = new Intent(this.c, TJAdUnitActivity.class);
            intent.putExtra(TJAdUnitConstants.EXTRA_TJ_PLACEMENT_DATA, tJPlacementData);
            ((Activity) this.c).startActivityForResult(intent, TJAdUnitConstants.MRAID_REQUEST_CODE);
        }
    }

    public void displayStoreURL(JSONObject json, String callbackID) {
        displayURL(json, callbackID);
    }

    public void displayURL(JSONObject json, String callbackID) {
        try {
            String string = json.getString(String.URL);
            this.didLaunchOtherActivity = true;
            this.otherActivityCallbackID = callbackID;
            ((Activity) this.c).startActivity(new Intent("android.intent.action.VIEW", Uri.parse(string)));
        } catch (Exception e) {
            invokeJSCallback(callbackID, Boolean.TRUE);
            e.printStackTrace();
        }
    }

    public void clearCache(JSONObject json, String callbackID) {
        if (TapjoyCache.getInstance() != null) {
            TapjoyCache.getInstance().clearTapjoyCache();
            invokeJSCallback(callbackID, Boolean.TRUE);
            return;
        }
        invokeJSCallback(callbackID, Boolean.FALSE);
    }

    public void setPrerenderLimit(JSONObject json, String callbackID) {
        try {
            TJPlacementManager.setPreRenderedPlacementLimit(json.getInt(String.TJC_PLACEMENT_PRE_RENDERED_LIMIT));
            invokeJSCallback(callbackID, Boolean.TRUE);
        } catch (Exception e) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy placement pre-render limit. Invalid parameters.");
            invokeJSCallback(callbackID, Boolean.FALSE);
        }
    }

    public void setEventPreloadLimit(JSONObject json, String callbackID) {
        if (TapjoyCache.getInstance() != null) {
            try {
                TJPlacementManager.setCachedPlacementLimit(json.getInt(String.TJC_PLACEMENT_CACHE_LIMIT));
                invokeJSCallback(callbackID, Boolean.TRUE);
                return;
            } catch (Exception e) {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to set Tapjoy cache's event preload limit. Invalid parameters.");
                invokeJSCallback(callbackID, Boolean.FALSE);
                return;
            }
        }
        invokeJSCallback(callbackID, Boolean.FALSE);
    }

    public void removeAssetFromCache(JSONObject json, String callbackID) {
        try {
            String assetURL = json.getString(String.URL);
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(callbackID, Boolean.valueOf(TapjoyCache.getInstance().removeAssetFromCache(assetURL)));
                return;
            }
            invokeJSCallback(callbackID, Boolean.FALSE);
        } catch (Exception e) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(callbackID, Boolean.FALSE);
        }
    }

    public void cacheAsset(JSONObject json, String callbackID) {
        String str = "";
        Long valueOf = Long.valueOf(0);
        try {
            String assetURL = json.getString(String.URL);
            try {
                str = json.getString(TapjoyConstants.TJC_PLACEMENT_OFFER_ID);
            } catch (Exception e) {
            }
            try {
                valueOf = Long.valueOf(json.getLong(TapjoyConstants.TJC_TIME_TO_LIVE));
            } catch (Exception e2) {
            }
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(callbackID, TapjoyCache.getInstance().cacheAssetFromURL(assetURL, str, valueOf.longValue()));
                return;
            }
            invokeJSCallback(callbackID, Boolean.FALSE);
        } catch (Exception e3) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to cache video. Invalid parameters.");
            invokeJSCallback(callbackID, Boolean.FALSE);
        }
    }

    public void cachePathForURL(JSONObject json, String callbackID) {
        try {
            String url = json.getString(String.URL);
            if (TapjoyCache.getInstance() != null) {
                invokeJSCallback(callbackID, TapjoyCache.getInstance().getPathOfCachedURL(url));
                return;
            }
            invokeJSCallback(callbackID, "");
        } catch (Exception e) {
            invokeJSCallback(callbackID, "");
        }
    }

    public void getCachedAssets(JSONObject json, String callbackID) {
        if (TapjoyCache.getInstance() != null) {
            invokeJSCallback(callbackID, TapjoyCache.getInstance().cachedAssetsToJSON());
            return;
        }
        invokeJSCallback(callbackID, "");
    }

    public void contentReady(JSONObject json, String callbackID) {
        if (this.d != null) {
            this.d.fireContentReady();
            invokeJSCallback(callbackID, Boolean.valueOf(true));
            return;
        }
        invokeJSCallback(callbackID, Boolean.valueOf(false));
    }

    public void setOrientation(JSONObject json, String callbackID) {
        if (this.d == null) {
            TapjoyLog.d("TJAdUnitJSBridge", "No ad unit provided");
            invokeJSCallback(callbackID, Boolean.valueOf(false));
            return;
        }
        try {
            String string = json.getString(String.ORIENTATION);
            int i = (string.equals(String.LANDSCAPE) || string.equals(String.LANDSCAPE_LEFT)) ? 0 : string.equals(String.LANDSCAPE_RIGHT) ? 8 : 1;
            this.d.setOrientation(i);
            invokeJSCallback(callbackID, Boolean.valueOf(true));
        } catch (Exception e) {
            invokeJSCallback(callbackID, Boolean.valueOf(false));
        }
    }

    public void setBackgroundColor(JSONObject json, final String callbackID) {
        try {
            String backgroundHexColor = json.getString(String.BACKGROUND_COLOR);
            if (this.d != null) {
                this.d.setBackgroundColor(backgroundHexColor, new AdUnitAsyncTaskListner(this) {
                    final /* synthetic */ TJAdUnitJSBridge b;

                    public final void onComplete(boolean result) {
                        this.b.invokeJSCallback(callbackID, Boolean.valueOf(result));
                    }
                });
                return;
            }
            invokeJSCallback(callbackID, Boolean.valueOf(false));
        } catch (Exception e) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background color. Invalid parameters.");
            invokeJSCallback(callbackID, Boolean.valueOf(false));
        }
    }

    public void setBackgroundWebViewContent(JSONObject json, final String callbackID) {
        TapjoyLog.d("TJAdUnitJSBridge", "setBackgroundWebViewContent");
        try {
            String string = json.getString(String.BACKGROUND_CONTENT);
            if (this.d != null) {
                this.d.setBackgroundContent(string, new AdUnitAsyncTaskListner(this) {
                    final /* synthetic */ TJAdUnitJSBridge b;

                    public final void onComplete(boolean result) {
                        this.b.invokeJSCallback(callbackID, Boolean.valueOf(result));
                    }
                });
                return;
            }
            invokeJSCallback(callbackID, Boolean.valueOf(false));
        } catch (Exception e) {
            TapjoyLog.w("TJAdUnitJSBridge", "Unable to set background content. Invalid parameters.");
            invokeJSCallback(callbackID, Boolean.valueOf(false));
        }
    }

    public void displayVideo(JSONObject json, final String callbackID) {
        try {
            String url = json.getString(String.URL);
            if (url.length() <= 0 || url == "") {
                invokeJSCallback(callbackID, Boolean.FALSE);
                return;
            }
            this.d.loadVideoUrl(url, new AdUnitAsyncTaskListner(this) {
                final /* synthetic */ TJAdUnitJSBridge b;

                public final void onComplete(boolean result) {
                    this.b.invokeJSCallback(callbackID, Boolean.valueOf(result));
                }
            });
        } catch (Exception e) {
            invokeJSCallback(callbackID, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void playVideo(JSONObject json, String callbackID) {
        if (this.d != null) {
            invokeJSCallback(callbackID, Boolean.valueOf(this.d.playVideo()));
        }
    }

    public void pauseVideo(JSONObject json, String callbackID) {
        if (this.d != null) {
            invokeJSCallback(callbackID, Boolean.valueOf(this.d.pauseVideo()));
        }
    }

    public void clearVideo(JSONObject json, final String callbackID) {
        if (this.d != null) {
            this.d.clearVideo(new AdUnitAsyncTaskListner(this) {
                final /* synthetic */ TJAdUnitJSBridge b;

                public final void onComplete(boolean result) {
                    this.b.invokeJSCallback(callbackID, Boolean.valueOf(result));
                }
            });
        }
    }

    public void getLocation(JSONObject json, String callbackID) {
        boolean booleanValue;
        float f = 100.0f;
        try {
            f = Float.valueOf(json.getString(String.GPS_ACCURACY)).floatValue();
        } catch (Exception e) {
        }
        try {
            booleanValue = Boolean.valueOf(json.getString(String.ENABLED)).booleanValue();
        } catch (Exception e2) {
            e2.printStackTrace();
            booleanValue = false;
        }
        this.g = (LocationManager) this.c.getSystemService("location");
        String bestProvider = this.g.getBestProvider(new Criteria(), false);
        if (this.h == null) {
            this.h = new LocationListener(this) {
                final /* synthetic */ TJAdUnitJSBridge a;

                {
                    this.a = r1;
                }

                public final void onLocationChanged(Location location) {
                    if (this.a.c == null || this.a.e == null) {
                        if (this.a.g != null && this.a.h != null) {
                            TapjoyLog.d("TJAdUnitJSBridge", "stopping updates");
                            this.a.g.removeUpdates(this.a.h);
                        }
                    } else if (location != null) {
                        Map hashMap = new HashMap();
                        hashMap.put(String.LAT, Double.valueOf(location.getLatitude()));
                        hashMap.put(String.LONG, Double.valueOf(location.getLongitude()));
                        hashMap.put(String.ALTITUDE, Double.valueOf(location.getAltitude()));
                        hashMap.put("timestamp", Long.valueOf(location.getTime()));
                        hashMap.put(String.SPEED, Float.valueOf(location.getSpeed()));
                        hashMap.put(String.COURSE, Float.valueOf(location.getBearing()));
                        this.a.invokeJSAdunitMethod(String.LOCATION_UPDATED, hashMap);
                    }
                }

                public final void onProviderEnabled(String p) {
                }

                public final void onProviderDisabled(String p) {
                }

                public final void onStatusChanged(String p, int status, Bundle extras) {
                }
            };
        }
        if (booleanValue) {
            if (bestProvider != null) {
                this.g.requestLocationUpdates(bestProvider, 0, f, this.h);
            } else {
                invokeJSCallback(callbackID, Boolean.FALSE);
                return;
            }
        } else if (!(this.g == null || this.h == null)) {
            this.g.removeUpdates(this.h);
        }
        invokeJSCallback(callbackID, Boolean.TRUE);
    }

    public void log(JSONObject json, String callbackID) {
        try {
            TapjoyLog.d("TJAdUnitJSBridge", "Logging message=" + json.getString(String.MESSAGE));
            invokeJSCallback(callbackID, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(callbackID, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    public void openApp(JSONObject json, String callbackID) {
        try {
            this.c.startActivity(this.c.getPackageManager().getLaunchIntentForPackage(json.getString(String.BUNDLE)));
            invokeJSCallback(callbackID, Boolean.TRUE);
        } catch (Exception e) {
            invokeJSCallback(callbackID, Boolean.FALSE);
            e.printStackTrace();
        }
    }

    @TargetApi(19)
    public void nativeEval(final JSONObject json, final String callbackID) {
        ((Activity) this.c).runOnUiThread(new Runnable(this) {
            final /* synthetic */ TJAdUnitJSBridge c;

            public final void run() {
                try {
                    if (VERSION.SDK_INT >= 19) {
                        this.c.e.evaluateJavascript(json.getString(String.COMMAND), null);
                    } else {
                        this.c.e.loadUrl("javascript:" + json.getString(String.COMMAND));
                    }
                    this.c.invokeJSCallback(callbackID, Boolean.TRUE);
                } catch (Exception e) {
                    this.c.invokeJSCallback(callbackID, Boolean.FALSE);
                }
            }
        });
    }

    public void present(JSONObject json, String callbackID) {
        try {
            Boolean.valueOf(false);
            Boolean valueOf = Boolean.valueOf(false);
            Boolean valueOf2 = Boolean.valueOf(json.getString(String.VISIBLE));
            try {
                valueOf = Boolean.valueOf(json.getString(String.TRANSPARENT));
            } catch (Exception e) {
            }
            try {
                this.customClose = Boolean.valueOf(json.getString(String.CUSTOM_CLOSE)).booleanValue();
            } catch (Exception e2) {
            }
            new a(this, this.e).execute(new Boolean[]{valueOf2, valueOf});
            invokeJSCallback(callbackID, Boolean.TRUE);
        } catch (Exception e3) {
            invokeJSCallback(callbackID, Boolean.FALSE);
            e3.printStackTrace();
        }
    }

    public void triggerEvent(JSONObject json, String callbackID) {
        if (this.d != null) {
            try {
                String string = json.getString("eventName");
                if (string.equals(String.VIDEO_START)) {
                    this.d.fireOnVideoStart();
                } else if (string.equals(String.VIDEO_COMPLETE)) {
                    this.d.fireOnVideoComplete();
                } else if (string.equals(String.VIDEO_ERROR)) {
                    this.d.fireOnVideoError("Error while trying to play video.");
                }
            } catch (Exception e) {
                TapjoyLog.w("TJAdUnitJSBridge", "Unable to triggerEvent. No event name.");
            }
        }
    }

    public void invokeJSAdunitMethod(String methodName, Object... args) {
        this.a.callback(new ArrayList(Arrays.asList(args)), methodName, null);
    }

    public void invokeJSAdunitMethod(String methodName, Map arguments) {
        this.a.callback(arguments, methodName, null);
    }

    public void invokeJSCallback(String callbackID, Object... argArray) {
        if (cr.c(callbackID)) {
            TapjoyLog.d("TJAdUnitJSBridge", "invokeJSCallback -- no callbackID provided");
            return;
        }
        this.a.callback(new ArrayList(Arrays.asList(argArray)), "", callbackID);
    }

    public void invokeJSCallback(String callbackID, Map arguments) {
        this.a.callback(arguments, "", callbackID);
    }

    public void flushMessageQueue() {
        this.a.flushMessageQueue();
    }

    public void setAllowRedirect(JSONObject json, String callbackID) {
        boolean z;
        try {
            z = json.getBoolean(String.ENABLED);
        } catch (Exception e) {
            z = true;
        }
        this.allowRedirect = z;
        invokeJSCallback(callbackID, Boolean.TRUE);
    }

    public void setContext(Context c) {
        this.c = c;
    }

    public void setSpinnerVisible(JSONObject json, String callbackID) {
        String str = TJAdUnitConstants.SPINNER_TITLE;
        CharSequence charSequence = "";
        try {
            CharSequence string;
            boolean visible = json.getBoolean(String.VISIBLE);
            try {
                str = json.getString(String.TITLE);
                charSequence = str;
                string = json.getString(String.MESSAGE);
            } catch (Exception e) {
                CharSequence charSequence2 = charSequence;
                Object obj = str;
                string = charSequence2;
            }
            if (visible) {
                this.f = ProgressDialog.show(this.c, charSequence, string);
            } else if (this.f != null) {
                this.f.dismiss();
            }
            invokeJSCallback(callbackID, Boolean.TRUE);
        } catch (Exception e2) {
            invokeJSCallback(callbackID, Boolean.FALSE);
            e2.printStackTrace();
        }
    }

    public void setCloseButtonVisible(JSONObject json, String callbackID) {
        if (this.c instanceof TJAdUnitActivity) {
            try {
                final boolean z = json.getBoolean(String.VISIBLE);
                ((Activity) this.c).runOnUiThread(new Runnable(this) {
                    final /* synthetic */ TJAdUnitJSBridge b;

                    public final void run() {
                        ((TJAdUnitActivity) this.b.c).setCloseButtonVisibility(z);
                    }
                });
                invokeJSCallback(callbackID, Boolean.valueOf(true));
                return;
            } catch (Exception e) {
                invokeJSCallback(callbackID, Boolean.valueOf(false));
                e.printStackTrace();
                return;
            }
        }
        TapjoyLog.d("TJAdUnitJSBridge", "Not a TJAdUnitActivity");
        invokeJSCallback(callbackID, Boolean.valueOf(false));
    }

    public void shouldClose(JSONObject json, String callbackID) {
        try {
            Boolean.valueOf(false);
            if (Boolean.valueOf(json.getString(String.CLOSE)).booleanValue() && (this.c instanceof Activity)) {
                ((Activity) this.c).finish();
            }
            invokeJSCallback(callbackID, Boolean.TRUE);
        } catch (Exception e) {
            Exception exception = e;
            invokeJSCallback(callbackID, Boolean.FALSE);
            ((Activity) this.c).finish();
            exception.printStackTrace();
        }
        this.closeRequested = false;
    }

    public void setLoggingLevel(JSONObject json, String callbackID) {
        try {
            TapjoyAppSettings.getInstance().saveLoggingLevel(String.valueOf(json.getString(String.LOGGING_LEVEL)));
        } catch (Exception e) {
            TapjoyLog.d("TJAdUnitJSBridge", "setLoggingLevel exception " + e.getLocalizedMessage());
            invokeJSCallback(callbackID, Boolean.valueOf(false));
            e.printStackTrace();
        }
    }

    public void clearLoggingLevel(JSONObject json, String callbackID) {
        TapjoyAppSettings.getInstance().clearLoggingLevel();
    }

    public void attachVolumeListener(JSONObject json, String callbackID) {
        try {
            boolean z = json.getBoolean(String.ATTACH);
            int optInt = json.optInt(String.INTERVAL, TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL);
            if (optInt > 0) {
                this.d.attachVolumeListener(z, optInt);
                invokeJSCallback(callbackID, Boolean.valueOf(true));
                return;
            }
            TapjoyLog.d("TJAdUnitJSBridge", "Invalid `interval` value passed to attachVolumeListener(): interval=" + optInt);
            invokeJSCallback(callbackID, Boolean.valueOf(false));
        } catch (Exception e) {
            TapjoyLog.d("TJAdUnitJSBridge", "attachVolumeListener exception " + e.toString());
            invokeJSCallback(callbackID, Boolean.valueOf(false));
            e.printStackTrace();
        }
    }

    public void initMoatVideoTracker(JSONObject json, String callbackID) {
        if (this.c instanceof TJAdUnitActivity) {
            try {
                this.k = (ReactiveVideoTracker) MoatFactory.create((TJAdUnitActivity) this.c).createCustomTracker(new ReactiveVideoTrackerPlugin(json.getString(String.PARTNER_CODE)));
                if (this.l == null) {
                    TapjoyLog.d("TJAdUnitJSBridge", "Initializing MOAT tracking events map");
                    this.l = new HashMap();
                    this.l.put(String.VIDEO_FIRST_QUARTILE, MoatAdEventType.AD_EVT_FIRST_QUARTILE);
                    this.l.put(String.VIDEO_MIDPOINT, MoatAdEventType.AD_EVT_MID_POINT);
                    this.l.put(String.VIDEO_THIRD_QUARTILE, MoatAdEventType.AD_EVT_THIRD_QUARTILE);
                    this.l.put(String.VIDEO_COMPLETE, MoatAdEventType.AD_EVT_COMPLETE);
                    this.l.put(String.VIDEO_PAUSED, MoatAdEventType.AD_EVT_PAUSED);
                    this.l.put(String.VIDEO_PLAYING, MoatAdEventType.AD_EVT_PLAYING);
                    this.l.put(String.VIDEO_START, MoatAdEventType.AD_EVT_START);
                    this.l.put(String.VIDEO_STOPPED, MoatAdEventType.AD_EVT_STOPPED);
                    this.l.put(String.VIDEO_SKIPPED, MoatAdEventType.AD_EVT_SKIPPED);
                    this.l.put(String.VOLUME_CHANGED, MoatAdEventType.AD_EVT_VOLUME_CHANGE);
                    this.l.put(String.ENTER_FULL_SCREEN, MoatAdEventType.AD_EVT_ENTER_FULLSCREEN);
                    this.l.put(String.EXIT_FULL_SCREEN, MoatAdEventType.AD_EVT_EXIT_FULLSCREEN);
                }
                this.m = new Handler(Looper.getMainLooper());
                invokeJSCallback(callbackID, Boolean.valueOf(true));
                return;
            } catch (Exception e) {
                TapjoyLog.d("TJAdUnitJSBridge", "initMoatVideoTracker exception " + e.toString());
                invokeJSCallback(callbackID, Boolean.valueOf(false));
                return;
            }
        }
        TapjoyLog.d("TJAdUnitJSBridge", "Error from initMoatVideoTracker -- not a TJAdUnitActivity");
        invokeJSCallback(callbackID, Boolean.valueOf(false));
    }

    public void startMoatVideoTracker(JSONObject json, final String callbackID) {
        try {
            final Integer valueOf = Integer.valueOf(json.getInt(String.VIDEO_LENGTH));
            final Map hashMap = new HashMap();
            JSONObject jSONObject = json.getJSONObject(String.AD_IDS);
            if (jSONObject != null) {
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String str = (String) keys.next();
                    hashMap.put(str, jSONObject.getString(str));
                }
            }
            this.m.post(new Runnable(this) {
                final /* synthetic */ TJAdUnitJSBridge d;

                public final void run() {
                    boolean trackVideoAd;
                    if (this.d.k != null) {
                        trackVideoAd = this.d.k.trackVideoAd(hashMap, valueOf, this.d.e);
                    } else {
                        trackVideoAd = false;
                    }
                    this.d.invokeJSCallback(callbackID, Boolean.valueOf(trackVideoAd));
                }
            });
        } catch (Exception e) {
            TapjoyLog.d("TJAdUnitJSBridge", "startMoatVideoTracker exception " + e.toString());
            invokeJSCallback(callbackID, Boolean.valueOf(false));
        }
    }

    public void triggerMoatVideoEvent(JSONObject json, String callbackID) {
        try {
            Integer valueOf = Integer.valueOf(json.getInt(String.CURRENT_VIDEO_TIME));
            String string = json.getString("eventName");
            MoatAdEventType moatAdEventType = null;
            if (this.l != null) {
                moatAdEventType = (MoatAdEventType) this.l.get(string);
            }
            if (moatAdEventType == null) {
                TapjoyLog.d("TJAdUnitJSBridge", "eventName:" + string + " has no matching MOAT event");
                invokeJSCallback(callbackID, Boolean.valueOf(false));
                return;
            }
            TapjoyLog.d("TJAdUnitJSBridge", "Sending MOAT event: " + moatAdEventType);
            final MoatAdEvent moatAdEvent = new MoatAdEvent(moatAdEventType, valueOf);
            this.m.post(new Runnable(this) {
                final /* synthetic */ TJAdUnitJSBridge b;

                public final void run() {
                    if (this.b.k != null) {
                        this.b.k.dispatchEvent(moatAdEvent);
                    }
                }
            });
            invokeJSCallback(callbackID, Boolean.valueOf(true));
        } catch (Exception e) {
            TapjoyLog.d("TJAdUnitJSBridge", "triggerMoatVideoEvent exception " + e.toString());
            invokeJSCallback(callbackID, Boolean.valueOf(false));
        }
    }

    public void disable() {
        this.j = false;
    }

    public void onVideoReady(int videoDuration, int videoWidth, int videoHeight) {
        Map hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_READY_EVENT);
        hashMap.put(String.VIDEO_DURATION, Integer.valueOf(videoDuration));
        hashMap.put(String.VIDEO_WIDTH, Integer.valueOf(videoWidth));
        hashMap.put(String.VIDEO_HEIGHT, Integer.valueOf(videoHeight));
        invokeJSAdunitMethod(String.VIDEO_EVENT, hashMap);
    }

    public void onVideoStarted(int currentTime) {
        Map hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_START_EVENT);
        hashMap.put(String.VIDEO_CURRENT_TIME, Integer.valueOf(currentTime));
        invokeJSAdunitMethod(String.VIDEO_EVENT, hashMap);
    }

    public void onVideoProgress(int currentTime) {
        Map hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_PROGRESS_EVENT);
        hashMap.put(String.VIDEO_CURRENT_TIME, Integer.valueOf(currentTime));
        invokeJSAdunitMethod(String.VIDEO_EVENT, hashMap);
    }

    public void onVideoPaused(int currentTime) {
        Map hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_PAUSE_EVENT);
        hashMap.put(String.VIDEO_CURRENT_TIME, Integer.valueOf(currentTime));
        invokeJSAdunitMethod(String.VIDEO_EVENT, hashMap);
    }

    public void onVideoCompletion() {
        Map hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_COMPLETE_EVENT);
        invokeJSAdunitMethod(String.VIDEO_EVENT, hashMap);
    }

    public void onVideoInfo(String infoMessage) {
        Map hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_INFO_EVENT);
        hashMap.put(String.VIDEO_INFO, infoMessage);
        invokeJSAdunitMethod(String.VIDEO_EVENT, hashMap);
    }

    public void onVideoError(String errorMessage) {
        Map hashMap = new HashMap();
        hashMap.put(String.VIDEO_EVENT_NAME, String.VIDEO_ERROR_EVENT);
        invokeJSAdunitMethod(String.VIDEO_EVENT, hashMap);
    }
}
