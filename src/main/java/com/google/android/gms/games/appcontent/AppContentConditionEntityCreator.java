package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class AppContentConditionEntityCreator implements Creator<AppContentConditionEntity> {
    static void zza(AppContentConditionEntity appContentConditionEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, appContentConditionEntity.zzDK(), false);
        zzc.zza(parcel, 2, appContentConditionEntity.zzDL(), false);
        zzc.zza(parcel, 3, appContentConditionEntity.zzDM(), false);
        zzc.zza(parcel, 4, appContentConditionEntity.zzDN(), false);
        zzc.zzc(parcel, 1000, appContentConditionEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfz(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzij(i);
    }

    public AppContentConditionEntity zzfz(Parcel parcel) {
        Bundle bundle = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
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
                    bundle = zzb.zzs(parcel, zzaT);
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
            return new AppContentConditionEntity(i, str3, str2, str, bundle);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppContentConditionEntity[] zzij(int i) {
        return new AppContentConditionEntity[i];
    }
}
