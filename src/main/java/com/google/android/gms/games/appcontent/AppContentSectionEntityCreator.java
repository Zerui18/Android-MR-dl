package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class AppContentSectionEntityCreator implements Creator<AppContentSectionEntity> {
    static void zza(AppContentSectionEntity appContentSectionEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, appContentSectionEntity.getActions(), false);
        zzc.zzc(parcel, 3, appContentSectionEntity.zzDP(), false);
        zzc.zza(parcel, 4, appContentSectionEntity.zzDv(), false);
        zzc.zza(parcel, 5, appContentSectionEntity.getExtras(), false);
        zzc.zza(parcel, 6, appContentSectionEntity.zzDH(), false);
        zzc.zza(parcel, 7, appContentSectionEntity.getTitle(), false);
        zzc.zzc(parcel, 1000, appContentSectionEntity.getVersionCode());
        zzc.zza(parcel, 8, appContentSectionEntity.getType(), false);
        zzc.zza(parcel, 9, appContentSectionEntity.getId(), false);
        zzc.zza(parcel, 10, appContentSectionEntity.zzDQ(), false);
        zzc.zzc(parcel, 14, appContentSectionEntity.zzDF(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfA(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzik(i);
    }

    public AppContentSectionEntity zzfA(Parcel parcel) {
        ArrayList arrayList = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Bundle bundle = null;
        String str6 = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    arrayList3 = zzb.zzc(parcel, zzaT, AppContentActionEntity.CREATOR);
                    break;
                case 3:
                    arrayList2 = zzb.zzc(parcel, zzaT, AppContentCardEntity.CREATOR);
                    break;
                case 4:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case 5:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case 6:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case 8:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 9:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 10:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 14:
                    arrayList = zzb.zzc(parcel, zzaT, AppContentAnnotationEntity.CREATOR);
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
            return new AppContentSectionEntity(i, arrayList3, arrayList2, str6, bundle, str5, str4, str3, str2, str, arrayList);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppContentSectionEntity[] zzik(int i) {
        return new AppContentSectionEntity[i];
    }
}
