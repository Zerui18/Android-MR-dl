package jp.co.craftegg.band;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import java.io.IOException;

public class DeviceInfo {
    private static String advertisingId = "";

    public static void GetStartAdId(final Activity activity) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Info adInfo = AdvertisingIdClient.getAdvertisingIdInfo(activity);
                    boolean isLAT = adInfo.isLimitAdTrackingEnabled();
                    if (isLAT) {
                        DeviceInfo.advertisingId = "00000000-0000-0000-0000-000000000000";
                    } else {
                        DeviceInfo.advertisingId = adInfo.getId();
                    }
                    Log.d("DEBUG", "AndroidAdID : " + DeviceInfo.advertisingId);
                    Log.d("DEBUG", "OptoutFlag : " + String.valueOf(isLAT));
                } catch (IOException ex) {
                    Log.e("ERROR", "IOException:" + ex.getMessage());
                } catch (GooglePlayServicesNotAvailableException ex2) {
                    Log.e("ERROR", "GooglePlayServicesNotAvailableException:" + ex2.getMessage());
                } catch (Exception ex3) {
                    Log.e("ERROR", "Exception:" + ex3.getMessage());
                }
            }
        }).start();
    }

    public static String GetAdId() {
        return advertisingId;
    }
}
