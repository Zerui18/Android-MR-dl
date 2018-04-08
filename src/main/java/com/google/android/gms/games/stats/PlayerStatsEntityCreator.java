package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class PlayerStatsEntityCreator implements Creator<PlayerStatsEntity> {
    static void zza(PlayerStatsEntity playerStatsEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, playerStatsEntity.getAverageSessionLength());
        zzc.zza(parcel, 2, playerStatsEntity.getChurnProbability());
        zzc.zzc(parcel, 3, playerStatsEntity.getDaysSinceLastPlayed());
        zzc.zzc(parcel, 4, playerStatsEntity.getNumberOfPurchases());
        zzc.zzc(parcel, 5, playerStatsEntity.getNumberOfSessions());
        zzc.zza(parcel, 6, playerStatsEntity.getSessionPercentile());
        zzc.zza(parcel, 7, playerStatsEntity.getSpendPercentile());
        zzc.zzc(parcel, 1000, playerStatsEntity.getVersionCode());
        zzc.zza(parcel, 8, playerStatsEntity.zzFO(), false);
        zzc.zza(parcel, 9, playerStatsEntity.getSpendProbability());
        zzc.zza(parcel, 10, playerStatsEntity.getHighSpenderProbability());
        zzc.zza(parcel, 11, playerStatsEntity.getTotalSpendNext28Days());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjj(i);
    }

    public PlayerStatsEntity zzgb(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        float f = 0.0f;
        float f2 = 0.0f;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        float f3 = 0.0f;
        float f4 = 0.0f;
        Bundle bundle = null;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    f = zzb.zzl(parcel, zzaT);
                    break;
                case 2:
                    f2 = zzb.zzl(parcel, zzaT);
                    break;
                case 3:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 4:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 5:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case 6:
                    f3 = zzb.zzl(parcel, zzaT);
                    break;
                case 7:
                    f4 = zzb.zzl(parcel, zzaT);
                    break;
                case 8:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case 9:
                    f5 = zzb.zzl(parcel, zzaT);
                    break;
                case 10:
                    f6 = zzb.zzl(parcel, zzaT);
                    break;
                case 11:
                    f7 = zzb.zzl(parcel, zzaT);
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
            return new PlayerStatsEntity(i, f, f2, i2, i3, i4, f3, f4, bundle, f5, f6, f7);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public PlayerStatsEntity[] zzjj(int i) {
        return new PlayerStatsEntity[i];
    }
}
