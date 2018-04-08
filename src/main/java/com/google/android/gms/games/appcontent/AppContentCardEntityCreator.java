package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.ArrayList;

public class AppContentCardEntityCreator implements Creator<AppContentCardEntity> {
    static void zza(AppContentCardEntity appContentCardEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, appContentCardEntity.getActions(), false);
        zzc.zzc(parcel, 2, appContentCardEntity.zzDF(), false);
        zzc.zzc(parcel, 3, appContentCardEntity.zzDu(), false);
        zzc.zza(parcel, 4, appContentCardEntity.zzDv(), false);
        zzc.zzc(parcel, 5, appContentCardEntity.zzDG());
        zzc.zza(parcel, 6, appContentCardEntity.getDescription(), false);
        zzc.zza(parcel, 7, appContentCardEntity.getExtras(), false);
        zzc.zzc(parcel, 1000, appContentCardEntity.getVersionCode());
        zzc.zza(parcel, 10, appContentCardEntity.zzDH(), false);
        zzc.zza(parcel, 11, appContentCardEntity.getTitle(), false);
        zzc.zzc(parcel, 12, appContentCardEntity.zzDI());
        zzc.zza(parcel, 13, appContentCardEntity.getType(), false);
        zzc.zza(parcel, 14, appContentCardEntity.getId(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfy(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzii(i);
    }

    public AppContentCardEntity zzfy(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        ArrayList arrayList3 = null;
        String str = null;
        int i2 = 0;
        String str2 = null;
        Bundle bundle = null;
        String str3 = null;
        String str4 = null;
        int i3 = 0;
        String str5 = null;
        String str6 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    arrayList = zzb.zzc(parcel, zzaT, AppContentActionEntity.CREATOR);
                    break;
                case 2:
                    arrayList2 = zzb.zzc(parcel, zzaT, AppContentAnnotationEntity.CREATOR);
                    break;
                case 3:
                    arrayList3 = zzb.zzc(parcel, zzaT, AppContentConditionEntity.CREATOR);
                    break;
                case 4:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 5:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 6:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case 10:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 11:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_RX /*12*/:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 13:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case 14:
                    str6 = zzb.zzq(parcel, zzaT);
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
            return new AppContentCardEntity(i, arrayList, arrayList2, arrayList3, str, i2, str2, bundle, str3, str4, i3, str5, str6);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppContentCardEntity[] zzii(int i) {
        return new AppContentCardEntity[i];
    }
}
