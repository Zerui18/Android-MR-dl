package com.tapjoy;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import java.util.ArrayList;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class TJWebViewJSInterface {
    WebView a;
    TJWebViewJSInterfaceListener b;
    PriorityQueue c = new PriorityQueue();

    @TargetApi(19)
    class a extends AsyncTask {
        WebView a;
        final /* synthetic */ TJWebViewJSInterface b;

        protected final /* bridge */ /* synthetic */ Object doInBackground(Object[] x0) {
            return ((String[]) x0)[0];
        }

        protected final /* synthetic */ void onPostExecute(Object x0) {
            String str = (String) x0;
            if (this.a == null) {
                return;
            }
            if (!str.startsWith("javascript:") || VERSION.SDK_INT < 19) {
                try {
                    this.a.loadUrl(str);
                    return;
                } catch (Exception e) {
                    TapjoyLog.e("TJWebViewJSInterface", new TapjoyErrorMessage(ErrorType.INTERNAL_ERROR, "Exception in loadUrl. Device not supported. " + e.toString()));
                    return;
                }
            }
            try {
                this.a.evaluateJavascript(str.replaceFirst("javascript:", ""), null);
            } catch (Exception e2) {
                TapjoyLog.e("TJWebViewJSInterface", new TapjoyErrorMessage(ErrorType.INTERNAL_ERROR, "Exception in evaluateJavascript. Device not supported. " + e2.toString()));
            }
        }

        public a(TJWebViewJSInterface tJWebViewJSInterface, WebView webView) {
            this.b = tJWebViewJSInterface;
            this.a = webView;
        }
    }

    public TJWebViewJSInterface(WebView w, TJWebViewJSInterfaceListener l) {
        this.a = w;
        this.b = l;
    }

    @JavascriptInterface
    public void dispatchMethod(String params) {
        TapjoyLog.d("TJWebViewJSInterface", "dispatchMethod params: " + params);
        try {
            JSONObject jSONObject = new JSONObject(params);
            String string = jSONObject.getJSONObject(String.DATA).getString(String.METHOD);
            TapjoyLog.d("TJWebViewJSInterface", "method: " + string);
            if (this.b != null) {
                this.b.onDispatchMethod(string, jSONObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callback(ArrayList result, String methodName, String callbackID) {
        try {
            callbackToJavaScript(new JSONArray(result), methodName, callbackID);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void callback(Map result, String methodName, String callbackID) {
        try {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(new JSONObject(result));
            callbackToJavaScript(jSONArray, methodName, callbackID);
        } catch (Exception e) {
            TapjoyLog.e("TJWebViewJSInterface", "Exception in callback to JS: " + e.toString());
            e.printStackTrace();
        }
    }

    public void callbackToJavaScript(Object arguments, String methodName, String callbackID) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(String.ARGUMENTS, arguments);
            if (methodName != null && methodName.length() > 0) {
                jSONObject.put(String.METHOD, methodName);
            }
            JSONObject jSONObject2 = new JSONObject();
            if (callbackID != null && callbackID.length() > 0) {
                jSONObject2.put(String.CALLBACK_ID, callbackID);
            }
            jSONObject2.put(String.DATA, jSONObject);
            String str = "javascript:if(window.AndroidWebViewJavascriptBridge) AndroidWebViewJavascriptBridge._handleMessageFromAndroid('" + jSONObject2 + "');";
            if (this.c != null) {
                this.c.add(str);
                return;
            }
            new a(this, this.a).execute(new String[]{str});
        } catch (Exception e) {
            TapjoyLog.e("TJWebViewJSInterface", "Exception in callback to JS: " + e.toString());
            e.printStackTrace();
        }
    }

    public void flushMessageQueue() {
        if (this.c != null) {
            while (this.c.size() != 0) {
                String str = (String) this.c.poll();
                new a(this, this.a).execute(new String[]{str});
            }
            this.c = null;
        }
    }
}
