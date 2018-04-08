package net.gree.unitywebview;

import android.webkit.JavascriptInterface;
import com.unity3d.player.UnityPlayer;

/* compiled from: WebViewPlugin */
class WebViewPluginInterface {
    private String mGameObject;

    public WebViewPluginInterface(String gameObject) {
        this.mGameObject = gameObject;
    }

    @JavascriptInterface
    public void call(String message) {
        UnityPlayer.UnitySendMessage(this.mGameObject, "CallFromJS", message);
    }
}
