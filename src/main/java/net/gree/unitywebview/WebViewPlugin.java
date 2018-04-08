package net.gree.unitywebview;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebSettings.RenderPriority;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.unity3d.player.UnityPlayer;

public class WebViewPlugin {
    private static FrameLayout layout = null;
    private long mDownTime;
    private WebView mWebView;

    public void Init(final String gameObject) {
        final Activity a = UnityPlayer.currentActivity;
        a.runOnUiThread(new Runnable() {
            public void run() {
                WebViewPlugin.this.mWebView = new WebView(a);
                WebViewPlugin.this.mWebView.setVisibility(8);
                WebViewPlugin.this.mWebView.setFocusable(true);
                WebViewPlugin.this.mWebView.setFocusableInTouchMode(true);
                if (WebViewPlugin.layout == null) {
                    WebViewPlugin.layout = new FrameLayout(a);
                    a.addContentView(WebViewPlugin.layout, new LayoutParams(-1, -1));
                    WebViewPlugin.layout.setFocusable(true);
                    WebViewPlugin.layout.setFocusableInTouchMode(true);
                }
                WebViewPlugin.layout.addView(WebViewPlugin.this.mWebView, new FrameLayout.LayoutParams(-1, -1, 0));
                WebViewPlugin.this.mWebView.setWebChromeClient(new WebChromeClient() {
                    public boolean onConsoleMessage(ConsoleMessage cm) {
                        Log.d("Webview", cm.message());
                        return true;
                    }
                });
                WebViewPlugin.this.mWebView.setWebViewClient(new WebViewClient() {
                    public boolean shouldOverrideUrlLoading(WebView view, String url) {
                        if (url.startsWith("http://") || url.startsWith("https://") || url.startsWith("file://") || url.startsWith("javascript:")) {
                            return false;
                        }
                        if (url.substring(0, 7).equals("mailto:")) {
                            view.getContext().startActivity(new Intent("android.intent.action.SENDTO", Uri.parse(url)));
                            return true;
                        }
                        view.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(url)));
                        return true;
                    }
                });
                WebViewPlugin.this.mWebView.addJavascriptInterface(new WebViewPluginInterface(gameObject), "Unity");
                WebSettings webSettings = WebViewPlugin.this.mWebView.getSettings();
                webSettings.setSupportZoom(false);
                webSettings.setJavaScriptEnabled(true);
                if (VERSION.SDK_INT >= 16) {
                    Log.i("WebViewPlugin", "Build.VERSION.SDK_INT = " + VERSION.SDK_INT);
                    webSettings.setAllowUniversalAccessFromFileURLs(true);
                }
                webSettings.setRenderPriority(RenderPriority.HIGH);
                webSettings.setCacheMode(2);
                String databasePath = WebViewPlugin.this.mWebView.getContext().getDir("databases", 0).getPath();
                webSettings.setDatabaseEnabled(true);
                webSettings.setDomStorageEnabled(true);
                webSettings.setDatabasePath(databasePath);
            }
        });
        final View activityRootView = a.getWindow().getDecorView().getRootView();
        activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                Rect r = new Rect();
                activityRootView.getWindowVisibleDisplayFrame(r);
                if (activityRootView.getRootView().getHeight() - (r.bottom - r.top) > a.getWindowManager().getDefaultDisplay().getHeight() / 3) {
                    UnityPlayer.UnitySendMessage(gameObject, "SetKeyboardVisible", "true");
                } else {
                    UnityPlayer.UnitySendMessage(gameObject, "SetKeyboardVisible", "false");
                }
            }
        });
    }

    public void Destroy() {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {
                if (WebViewPlugin.this.mWebView != null) {
                    WebViewPlugin.layout.removeView(WebViewPlugin.this.mWebView);
                    WebViewPlugin.this.mWebView = null;
                }
            }
        });
    }

    public void LoadURL(final String url) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {
                WebViewPlugin.this.mWebView.loadUrl(url);
            }
        });
    }

    public void EvaluateJS(final String js) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {
                WebViewPlugin.this.mWebView.loadUrl("javascript:" + js);
            }
        });
    }

    public void SetMargins(int left, int top, int right, int bottom) {
        final FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -1, 0);
        params.setMargins(left, top, right, bottom);
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {
                WebViewPlugin.this.mWebView.setLayoutParams(params);
            }
        });
    }

    public void SetVisibility(final boolean visibility) {
        UnityPlayer.currentActivity.runOnUiThread(new Runnable() {
            public void run() {
                if (visibility) {
                    WebViewPlugin.this.mWebView.setVisibility(0);
                    WebViewPlugin.layout.requestFocus();
                    WebViewPlugin.this.mWebView.requestFocus();
                    return;
                }
                WebViewPlugin.this.mWebView.setVisibility(8);
            }
        });
    }
}
