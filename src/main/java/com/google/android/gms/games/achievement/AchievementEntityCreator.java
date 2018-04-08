package com.google.android.gms.games.achievement;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.PlayerEntity;

public class AchievementEntityCreator implements Creator<AchievementEntity> {
    static void zza(AchievementEntity achievementEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, achievementEntity.getAchievementId(), false);
        zzc.zzc(parcel, 2, achievementEntity.getType());
        zzc.zza(parcel, 3, achievementEntity.getName(), false);
        zzc.zza(parcel, 4, achievementEntity.getDescription(), false);
        zzc.zza(parcel, 5, achievementEntity.getUnlockedImageUri(), i, false);
        zzc.zza(parcel, 6, achievementEntity.getUnlockedImageUrl(), false);
        zzc.zza(parcel, 7, achievementEntity.getRevealedImageUri(), i, false);
        zzc.zzc(parcel, 1000, achievementEntity.getVersionCode());
        zzc.zza(parcel, 8, achievementEntity.getRevealedImageUrl(), false);
        zzc.zzc(parcel, 9, achievementEntity.zzDp());
        zzc.zza(parcel, 10, achievementEntity.zzDq(), false);
        zzc.zza(parcel, 11, achievementEntity.getPlayer(), i, false);
        zzc.zzc(parcel, 12, achievementEntity.getState());
        zzc.zzc(parcel, 13, achievementEntity.zzDr());
        zzc.zza(parcel, 14, achievementEntity.zzDs(), false);
        zzc.zza(parcel, 15, achievementEntity.getLastUpdatedTimestamp());
        zzc.zza(parcel, 16, achievementEntity.getXpValue());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzif(i);
    }

    public AchievementEntity zzfv(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        int i2 = 0;
        String str2 = null;
        String str3 = null;
        Uri uri = null;
        String str4 = null;
        Uri uri2 = null;
        String str5 = null;
        int i3 = 0;
        String str6 = null;
        PlayerEntity playerEntity = null;
        int i4 = 0;
        int i5 = 0;
        String str7 = null;
        long j = 0;
        long j2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 2:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 3:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 5:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 6:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    uri2 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 8:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case 9:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 10:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case 11:
                    playerEntity = (PlayerEntity) zzb.zza(parcel, zzaT, PlayerEntity.CREATOR);
                    break;
                case MotionEventCompat.AXIS_RX /*12*/:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case 13:
                    i5 = zzb.zzg(parcel, zzaT);
                    break;
                case 14:
                    str7 = zzb.zzq(parcel, zzaT);
                    break;
                case 15:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case 16:
                    j2 = zzb.zzi(parcel, zzaT);
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
            return new AchievementEntity(i, str, i2, str2, str3, uri, str4, uri2, str5, i3, str6, playerEntity, i4, i5, str7, j, j2);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AchievementEntity[] zzif(int i) {
        return new AchievementEntity[i];
    }
}
