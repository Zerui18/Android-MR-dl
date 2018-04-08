package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzi implements Creator<zzh> {
    static void zza(zzh com_google_android_gms_nearby_messages_internal_zzh, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_nearby_messages_internal_zzh.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_nearby_messages_internal_zzh.zzNi(), false);
        zzc.zza(parcel, 3, com_google_android_gms_nearby_messages_internal_zzh.zzbxx, false);
        zzc.zza(parcel, 4, com_google_android_gms_nearby_messages_internal_zzh.zzbyA, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzij(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlZ(i);
    }

    public zzh zzij(Parcel parcel) {
        ClientAppContext clientAppContext = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case 3:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    clientAppContext = (ClientAppContext) zzb.zza(parcel, zzaT, ClientAppContext.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzh(i, iBinder, str, clientAppContext);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzh[] zzlZ(int i) {
        return new zzh[i];
    }
}
