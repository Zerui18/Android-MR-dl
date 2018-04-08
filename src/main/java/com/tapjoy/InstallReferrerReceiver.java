package com.tapjoy;

import android.content.Context;
import android.content.Intent;
import com.tapjoy.internal.fu;
import com.tapjoy.internal.l;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class InstallReferrerReceiver extends l {
    public void onReceive(Context context, Intent intent) {
        String a = fu.a(context, intent);
        int forward = forward(context, intent);
        if (intent.getBooleanExtra("fiverocks:verify", false) && isOrderedBroadcast()) {
            setResultCode(forward + 1);
            if (a != null) {
                try {
                    setResultData("http://play.google.com/store/apps/details?id=" + context.getPackageName() + "&referrer=" + URLEncoder.encode(a, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                }
            }
        }
    }
}
