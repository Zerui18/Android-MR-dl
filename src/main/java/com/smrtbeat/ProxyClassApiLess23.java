package com.smrtbeat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ProxyClassApiLess23 {
    static String getMobileNetworkStatus(Context context) {
        return getNetworkStatus(context, 0);
    }

    private static String getNetworkStatus(Context context, int i) {
        String str = "no permission";
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", g.n) != 0) {
            return str;
        }
        NetworkInfo networkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getNetworkInfo(i);
        boolean z = networkInfo != null && networkInfo.isConnected();
        return String.valueOf(z);
    }

    static String getWifiStatus(Context context) {
        return getNetworkStatus(context, 1);
    }
}
