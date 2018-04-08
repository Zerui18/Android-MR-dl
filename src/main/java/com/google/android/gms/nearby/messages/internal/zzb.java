package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzb implements Creator<zza> {
    static void zza(zza com_google_android_gms_nearby_messages_internal_zza, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_nearby_messages_internal_zza.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_nearby_messages_internal_zza.zzbys);
        zzc.zzc(parcel, 3, com_google_android_gms_nearby_messages_internal_zza.zzbyt);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzig(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlV(i);
    }

    public zza zzig(Parcel parcel) {
        int i = 0;
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case 1:
                    i3 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    i2 = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                case 3:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zza(i3, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zza[] zzlV(int i) {
        return new zza[i];
    }
}
