package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GameEntity;

public class ExperienceEventEntityCreator implements Creator<ExperienceEventEntity> {
    static void zza(ExperienceEventEntity experienceEventEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, experienceEventEntity.zzES(), false);
        zzc.zza(parcel, 2, experienceEventEntity.getGame(), i, false);
        zzc.zza(parcel, 3, experienceEventEntity.zzET(), false);
        zzc.zza(parcel, 4, experienceEventEntity.zzEU(), false);
        zzc.zza(parcel, 5, experienceEventEntity.getIconImageUrl(), false);
        zzc.zza(parcel, 6, experienceEventEntity.getIconImageUri(), i, false);
        zzc.zza(parcel, 7, experienceEventEntity.zzEV());
        zzc.zzc(parcel, 1000, experienceEventEntity.getVersionCode());
        zzc.zza(parcel, 8, experienceEventEntity.zzEW());
        zzc.zza(parcel, 9, experienceEventEntity.zzEX());
        zzc.zzc(parcel, 10, experienceEventEntity.getType());
        zzc.zzc(parcel, 11, experienceEventEntity.zzEY());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfF(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziE(i);
    }

    public ExperienceEventEntity zzfF(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        GameEntity gameEntity = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 2:
                    gameEntity = (GameEntity) zzb.zza(parcel, zzaT, GameEntity.CREATOR);
                    break;
                case 3:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 5:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case 6:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 7:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case 8:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case 9:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case 10:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 11:
                    i3 = zzb.zzg(parcel, zzaT);
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
            return new ExperienceEventEntity(i, str, gameEntity, str2, str3, str4, uri, j, j2, j3, i2, i3);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ExperienceEventEntity[] zziE(int i) {
        return new ExperienceEventEntity[i];
    }
}
