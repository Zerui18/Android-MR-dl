package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzah implements Creator<zzag> {
    static void zza(zzag com_google_android_gms_nearby_messages_internal_zzag, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_nearby_messages_internal_zzag.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_nearby_messages_internal_zzag.zzbyX, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_nearby_messages_internal_zzag.zzNi(), false);
        zzc.zza(parcel, 4, com_google_android_gms_nearby_messages_internal_zzag.zzbxx, false);
        zzc.zza(parcel, 5, com_google_android_gms_nearby_messages_internal_zzag.zzbyv, false);
        zzc.zza(parcel, 6, com_google_android_gms_nearby_messages_internal_zzag.zzbxy);
        zzc.zza(parcel, 7, com_google_android_gms_nearby_messages_internal_zzag.zzbyA, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zziq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmh(i);
    }

    public zzag zziq(Parcel parcel) {
        boolean z = false;
        ClientAppContext clientAppContext = null;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        String str2 = null;
        IBinder iBinder = null;
        zzv com_google_android_gms_nearby_messages_internal_zzv = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    com_google_android_gms_nearby_messages_internal_zzv = (zzv) zzb.zza(parcel, zzaT, zzv.CREATOR);
                    break;
                case 3:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case 4:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 5:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 6:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 7:
                    clientAppContext = (ClientAppContext) zzb.zza(parcel, zzaT, ClientAppContext.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzag(i, com_google_android_gms_nearby_messages_internal_zzv, iBinder, str2, str, z, clientAppContext);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzag[] zzmh(int i) {
        return new zzag[i];
    }
}
