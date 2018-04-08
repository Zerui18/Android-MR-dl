package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class ProfileSettingsEntityCreator implements Creator<ProfileSettingsEntity> {
    static void zza(ProfileSettingsEntity profileSettingsEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, profileSettingsEntity.getStatus(), i, false);
        zzc.zza(parcel, 2, profileSettingsEntity.zzDc(), false);
        zzc.zza(parcel, 3, profileSettingsEntity.zzDm());
        zzc.zza(parcel, 4, profileSettingsEntity.zzDf());
        zzc.zza(parcel, 5, profileSettingsEntity.zzDk());
        zzc.zza(parcel, 6, profileSettingsEntity.zzDl(), i, false);
        zzc.zza(parcel, 7, profileSettingsEntity.zzDn());
        zzc.zzc(parcel, 1000, profileSettingsEntity.getVersionCode());
        zzc.zza(parcel, 8, profileSettingsEntity.zzDo());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfK(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziN(i);
    }

    public ProfileSettingsEntity zzfK(Parcel parcel) {
        StockProfileImageEntity stockProfileImageEntity = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        String str = null;
        Status status = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    status = (Status) zzb.zza(parcel, zzaT, Status.CREATOR);
                    break;
                case 2:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    z5 = zzb.zzc(parcel, zzaT);
                    break;
                case 4:
                    z4 = zzb.zzc(parcel, zzaT);
                    break;
                case 5:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case 6:
                    stockProfileImageEntity = (StockProfileImageEntity) zzb.zza(parcel, zzaT, StockProfileImageEntity.CREATOR);
                    break;
                case 7:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 8:
                    z = zzb.zzc(parcel, zzaT);
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
            return new ProfileSettingsEntity(i, status, str, z5, z4, z3, stockProfileImageEntity, z2, z);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ProfileSettingsEntity[] zziN(int i) {
        return new ProfileSettingsEntity[i];
    }
}
