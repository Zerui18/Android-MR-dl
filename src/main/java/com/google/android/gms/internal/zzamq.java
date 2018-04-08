package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.List;

public class zzamq implements Creator<zzamp> {
    static void zza(zzamp com_google_android_gms_internal_zzamp, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamp.mVersionCode);
        zzc.zzc(parcel, 2, com_google_android_gms_internal_zzamp.zztf, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzamp.zzaPL, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_internal_zzamp.zzaPM);
        zzc.zzb(parcel, 5, com_google_android_gms_internal_zzamp.zzaPN, false);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzamp.zzaPO, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgc(i);
    }

    public zzamp zzdF(Parcel parcel) {
        boolean z = false;
        zzamd com_google_android_gms_internal_zzamd = null;
        int zzaU = zzb.zzaU(parcel);
        List list = null;
        DataHolder dataHolder = null;
        List list2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    list2 = zzb.zzc(parcel, zzaT, zzamn.CREATOR);
                    break;
                case 3:
                    dataHolder = (DataHolder) zzb.zza(parcel, zzaT, DataHolder.CREATOR);
                    break;
                case 4:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 5:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                case 6:
                    com_google_android_gms_internal_zzamd = (zzamd) zzb.zza(parcel, zzaT, zzamd.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzamp(i, list2, dataHolder, z, list, com_google_android_gms_internal_zzamd);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamp[] zzgc(int i) {
        return new zzamp[i];
    }
}
