package com.google.android.gms.nearby.messages.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzzv.zzb;
import com.google.android.gms.nearby.messages.internal.zzn.zza;

final class zzaa extends zza {
    private final zzb<Status> zzbyV;
    private boolean zzbyW;

    private zzaa(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
        this.zzbyV = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
    }

    static zzaa zzu(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
        return new zzaa(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status);
    }

    public void zzbw(Status status) throws RemoteException {
        if (!this.zzbyW) {
            this.zzbyV.setResult(status);
            this.zzbyW = true;
        }
    }
}
