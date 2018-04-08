package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

public class PlayerEntityCreator implements Creator<PlayerEntity> {
    static void zza(PlayerEntity playerEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, playerEntity.getPlayerId(), false);
        zzc.zza(parcel, 2, playerEntity.getDisplayName(), false);
        zzc.zza(parcel, 3, playerEntity.getIconImageUri(), i, false);
        zzc.zza(parcel, 4, playerEntity.getHiResImageUri(), i, false);
        zzc.zza(parcel, 5, playerEntity.getRetrievedTimestamp());
        zzc.zzc(parcel, 6, playerEntity.zzDe());
        zzc.zza(parcel, 7, playerEntity.getLastPlayedWithTimestamp());
        zzc.zzc(parcel, 1000, playerEntity.getVersionCode());
        zzc.zza(parcel, 8, playerEntity.getIconImageUrl(), false);
        zzc.zza(parcel, 9, playerEntity.getHiResImageUrl(), false);
        zzc.zza(parcel, 14, playerEntity.getTitle(), false);
        zzc.zza(parcel, 15, playerEntity.zzDg(), i, false);
        zzc.zza(parcel, 16, playerEntity.getLevelInfo(), i, false);
        zzc.zza(parcel, 18, playerEntity.zzDf());
        zzc.zza(parcel, 19, playerEntity.zzDd());
        zzc.zza(parcel, 20, playerEntity.zzDc(), false);
        zzc.zza(parcel, 21, playerEntity.getName(), false);
        zzc.zza(parcel, 22, playerEntity.getBannerImageLandscapeUri(), i, false);
        zzc.zza(parcel, 23, playerEntity.getBannerImageLandscapeUrl(), false);
        zzc.zza(parcel, 24, playerEntity.getBannerImagePortraitUri(), i, false);
        zzc.zza(parcel, 25, playerEntity.getBannerImagePortraitUrl(), false);
        zzc.zzc(parcel, 26, playerEntity.zzDh());
        zzc.zza(parcel, 27, playerEntity.zzDi());
        zzc.zza(parcel, 28, playerEntity.isMuted());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzic(i);
    }

    public PlayerEntity zzfs(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        Uri uri = null;
        Uri uri2 = null;
        long j = 0;
        int i2 = 0;
        long j2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        MostRecentGameInfoEntity mostRecentGameInfoEntity = null;
        PlayerLevelInfo playerLevelInfo = null;
        boolean z = false;
        boolean z2 = false;
        String str6 = null;
        String str7 = null;
        Uri uri3 = null;
        String str8 = null;
        Uri uri4 = null;
        String str9 = null;
        int i3 = 0;
        long j3 = 0;
        boolean z3 = false;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 2:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 4:
                    uri2 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 5:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case 6:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 7:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case 8:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 9:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case 14:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case 15:
                    mostRecentGameInfoEntity = (MostRecentGameInfoEntity) zzb.zza(parcel, zzaT, MostRecentGameInfoEntity.CREATOR);
                    break;
                case 16:
                    playerLevelInfo = (PlayerLevelInfo) zzb.zza(parcel, zzaT, PlayerLevelInfo.CREATOR);
                    break;
                case 18:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 19:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 20:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_WHEEL /*21*/:
                    str7 = zzb.zzq(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_GAS /*22*/:
                    uri3 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case MotionEventCompat.AXIS_BRAKE /*23*/:
                    str8 = zzb.zzq(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_DISTANCE /*24*/:
                    uri4 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 25:
                    str9 = zzb.zzq(parcel, zzaT);
                    break;
                case 26:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_RELATIVE_X /*27*/:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_RELATIVE_Y /*28*/:
                    z3 = zzb.zzc(parcel, zzaT);
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
            return new PlayerEntity(i, str, str2, uri, uri2, j, i2, j2, str3, str4, str5, mostRecentGameInfoEntity, playerLevelInfo, z, z2, str6, str7, uri3, str8, uri4, str9, i3, j3, z3);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public PlayerEntity[] zzic(int i) {
        return new PlayerEntity[i];
    }
}
