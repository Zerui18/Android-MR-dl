package com.smrtbeat;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.Build.VERSION;

class ao {
    ao() {
    }

    static int a() {
        return VERSION.PREVIEW_SDK_INT;
    }

    static String a(Context context) {
        return a(context, 0);
    }

    private static String a(Context context, int i) {
        if (context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", g.n) != 0) {
            return "no permission";
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        Network[] allNetworks = connectivityManager.getAllNetworks();
        if (allNetworks != null) {
            for (Network networkInfo : allNetworks) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(networkInfo);
                if (networkInfo2 != null && networkInfo2.getType() == i) {
                    return String.valueOf(networkInfo2.isConnected());
                }
            }
        }
        return String.valueOf(false);
    }

    static String b(Context context) {
        return a(context, 1);
    }
}
