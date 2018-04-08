package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class TurnBasedMatchEntityCreator implements Creator<TurnBasedMatchEntity> {
    static void zza(TurnBasedMatchEntity turnBasedMatchEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, turnBasedMatchEntity.getGame(), i, false);
        zzc.zza(parcel, 2, turnBasedMatchEntity.getMatchId(), false);
        zzc.zza(parcel, 3, turnBasedMatchEntity.getCreatorId(), false);
        zzc.zza(parcel, 4, turnBasedMatchEntity.getCreationTimestamp());
        zzc.zza(parcel, 5, turnBasedMatchEntity.getLastUpdaterId(), false);
        zzc.zza(parcel, 6, turnBasedMatchEntity.getLastUpdatedTimestamp());
        zzc.zza(parcel, 7, turnBasedMatchEntity.getPendingParticipantId(), false);
        zzc.zzc(parcel, 1000, turnBasedMatchEntity.getVersionCode());
        zzc.zzc(parcel, 8, turnBasedMatchEntity.getStatus());
        zzc.zzc(parcel, 10, turnBasedMatchEntity.getVariant());
        zzc.zzc(parcel, 11, turnBasedMatchEntity.getVersion());
        zzc.zza(parcel, 12, turnBasedMatchEntity.getData(), false);
        zzc.zzc(parcel, 13, turnBasedMatchEntity.getParticipants(), false);
        zzc.zza(parcel, 14, turnBasedMatchEntity.getRematchId(), false);
        zzc.zza(parcel, 15, turnBasedMatchEntity.getPreviousMatchData(), false);
        zzc.zzc(parcel, 16, turnBasedMatchEntity.getMatchNumber());
        zzc.zza(parcel, 17, turnBasedMatchEntity.getAutoMatchCriteria(), false);
        zzc.zzc(parcel, 18, turnBasedMatchEntity.getTurnStatus());
        zzc.zza(parcel, 19, turnBasedMatchEntity.isLocallyModified());
        zzc.zza(parcel, 20, turnBasedMatchEntity.getDescription(), false);
        zzc.zza(parcel, 21, turnBasedMatchEntity.getDescriptionParticipantId(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfS(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziX(i);
    }

    public TurnBasedMatchEntity zzfS(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        String str2 = null;
        long j = 0;
        String str3 = null;
        long j2 = 0;
        String str4 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        byte[] bArr = null;
        ArrayList arrayList = null;
        String str5 = null;
        byte[] bArr2 = null;
        int i5 = 0;
        Bundle bundle = null;
        int i6 = 0;
        boolean z = false;
        String str6 = null;
        String str7 = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    gameEntity = (GameEntity) zzb.zza(parcel, zzaT, GameEntity.CREATOR);
                    break;
                case 2:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case 5:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 6:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case 7:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case 8:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 10:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 11:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_RX /*12*/:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case 13:
                    arrayList = zzb.zzc(parcel, zzaT, ParticipantEntity.CREATOR);
                    break;
                case 14:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case 15:
                    bArr2 = zzb.zzt(parcel, zzaT);
                    break;
                case 16:
                    i5 = zzb.zzg(parcel, zzaT);
                    break;
                case 17:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case 18:
                    i6 = zzb.zzg(parcel, zzaT);
                    break;
                case 19:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 20:
                    str6 = zzb.zzq(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_WHEEL /*21*/:
                    str7 = zzb.zzq(parcel, zzaT);
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
            return new TurnBasedMatchEntity(i, gameEntity, str, str2, j, str3, j2, str4, i2, i3, i4, bArr, arrayList, str5, bArr2, i5, bundle, i6, z, str6, str7);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public TurnBasedMatchEntity[] zziX(int i) {
        return new TurnBasedMatchEntity[i];
    }
}
