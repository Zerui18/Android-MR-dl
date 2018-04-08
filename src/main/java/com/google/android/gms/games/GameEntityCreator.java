package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class GameEntityCreator implements Creator<GameEntity> {
    static void zza(GameEntity gameEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, gameEntity.getApplicationId(), false);
        zzc.zza(parcel, 2, gameEntity.getDisplayName(), false);
        zzc.zza(parcel, 3, gameEntity.getPrimaryCategory(), false);
        zzc.zza(parcel, 4, gameEntity.getSecondaryCategory(), false);
        zzc.zza(parcel, 5, gameEntity.getDescription(), false);
        zzc.zza(parcel, 6, gameEntity.getDeveloperName(), false);
        zzc.zza(parcel, 7, gameEntity.getIconImageUri(), i, false);
        zzc.zza(parcel, 8, gameEntity.getHiResImageUri(), i, false);
        zzc.zza(parcel, 9, gameEntity.getFeaturedImageUri(), i, false);
        zzc.zza(parcel, 10, gameEntity.zzCV());
        zzc.zza(parcel, 11, gameEntity.zzCX());
        zzc.zza(parcel, 12, gameEntity.zzCY(), false);
        zzc.zzc(parcel, 13, gameEntity.zzCZ());
        zzc.zzc(parcel, 14, gameEntity.getAchievementTotalCount());
        zzc.zzc(parcel, 15, gameEntity.getLeaderboardCount());
        zzc.zza(parcel, 16, gameEntity.isRealTimeMultiplayerEnabled());
        zzc.zza(parcel, 17, gameEntity.isTurnBasedMultiplayerEnabled());
        zzc.zza(parcel, 18, gameEntity.getIconImageUrl(), false);
        zzc.zza(parcel, 19, gameEntity.getHiResImageUrl(), false);
        zzc.zza(parcel, 20, gameEntity.getFeaturedImageUrl(), false);
        zzc.zza(parcel, 21, gameEntity.isMuted());
        zzc.zza(parcel, 22, gameEntity.zzCW());
        zzc.zza(parcel, 23, gameEntity.areSnapshotsEnabled());
        zzc.zza(parcel, 24, gameEntity.getThemeColor(), false);
        zzc.zza(parcel, 25, gameEntity.hasGamepadSupport());
        zzc.zzc(parcel, 1000, gameEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzia(i);
    }

    public GameEntity zzfr(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        Uri uri = null;
        Uri uri2 = null;
        Uri uri3 = null;
        boolean z = false;
        boolean z2 = false;
        String str7 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z3 = false;
        boolean z4 = false;
        String str8 = null;
        String str9 = null;
        String str10 = null;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        String str11 = null;
        boolean z8 = false;
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
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case 5:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case 6:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 8:
                    uri2 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 9:
                    uri3 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 10:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 11:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_RX /*12*/:
                    str7 = zzb.zzq(parcel, zzaT);
                    break;
                case 13:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 14:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 15:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case 16:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case 17:
                    z4 = zzb.zzc(parcel, zzaT);
                    break;
                case 18:
                    str8 = zzb.zzq(parcel, zzaT);
                    break;
                case 19:
                    str9 = zzb.zzq(parcel, zzaT);
                    break;
                case 20:
                    str10 = zzb.zzq(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_WHEEL /*21*/:
                    z5 = zzb.zzc(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_GAS /*22*/:
                    z6 = zzb.zzc(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_BRAKE /*23*/:
                    z7 = zzb.zzc(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_DISTANCE /*24*/:
                    str11 = zzb.zzq(parcel, zzaT);
                    break;
                case 25:
                    z8 = zzb.zzc(parcel, zzaT);
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
            return new GameEntity(i, str, str2, str3, str4, str5, str6, uri, uri2, uri3, z, z2, str7, i2, i3, i4, z3, z4, str8, str9, str10, z5, z6, z7, str11, z8);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public GameEntity[] zzia(int i) {
        return new GameEntity[i];
    }
}
