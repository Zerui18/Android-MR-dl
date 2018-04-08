package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzu implements Creator<zzt> {
    static void zza(zzt com_google_android_gms_nearby_messages_internal_zzt, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_nearby_messages_internal_zzt.zzaFs, false);
        zzc.zza(parcel, 2, com_google_android_gms_nearby_messages_internal_zzt.type, false);
        zzc.zzc(parcel, 1000, com_google_android_gms_nearby_messages_internal_zzt.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzil(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmb(i);
    }

    public zzt zzil(Parcel parcel) {
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str2 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 2:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 1000:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzt(i, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzt[] zzmb(int i) {
        return new zzt[i];
    }
}
