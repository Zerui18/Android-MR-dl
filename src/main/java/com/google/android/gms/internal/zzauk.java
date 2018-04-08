package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzauk implements Creator<zzauj> {
    static void zza(zzauj com_google_android_gms_internal_zzauj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_internal_zzauj.getName(), false);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzauj.getDescription(), false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzauj.getDeviceId(), false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzauj.zzMK());
        zzc.zzc(parcel, 1000, com_google_android_gms_internal_zzauj.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhO(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlu(i);
    }

    public zzauj zzhO(Parcel parcel) {
        byte b = (byte) 0;
        String str = null;
        int zzaU = zzb.zzaU(parcel);
        String str2 = null;
        String str3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 2:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    b = zzb.zze(parcel, zzaT);
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
            return new zzauj(i, str3, str2, str, b);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzauj[] zzlu(int i) {
        return new zzauj[i];
    }
}