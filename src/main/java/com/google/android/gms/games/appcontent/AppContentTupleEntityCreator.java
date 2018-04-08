package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class AppContentTupleEntityCreator implements Creator<AppContentTupleEntity> {
    static void zza(AppContentTupleEntity appContentTupleEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, appContentTupleEntity.getName(), false);
        zzc.zza(parcel, 2, appContentTupleEntity.getValue(), false);
        zzc.zzc(parcel, 1000, appContentTupleEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfB(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzil(i);
    }

    public AppContentTupleEntity zzfB(Parcel parcel) {
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
            return new AppContentTupleEntity(i, str2, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppContentTupleEntity[] zzil(int i) {
        return new AppContentTupleEntity[i];
    }
}
