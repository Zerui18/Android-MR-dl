package com.smrtbeat;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.ads.identifier.AdvertisingIdClient.Info;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import java.io.IOException;

class aj {
    aj() {
    }

    static String a(Context context) {
        try {
            Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
            if (advertisingIdInfo != null) {
                return advertisingIdInfo.getId();
            }
        } catch (IllegalStateException e) {
        } catch (GooglePlayServicesRepairableException e2) {
        } catch (IOException e3) {
        } catch (GooglePlayServicesNotAvailableException e4) {
        } catch (NoClassDefFoundError e5) {
        } catch (NoSuchMethodError e6) {
        } catch (Throwable th) {
            bd.a(bg.ERROR, "error to access google play service", th);
        }
        return null;
    }
}
