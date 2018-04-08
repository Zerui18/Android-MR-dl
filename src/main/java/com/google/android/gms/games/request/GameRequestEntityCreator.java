package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.PlayerEntity;
import java.util.ArrayList;

public class GameRequestEntityCreator implements Creator<GameRequestEntity> {
    static void zza(GameRequestEntity gameRequestEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, gameRequestEntity.getGame(), i, false);
        zzc.zza(parcel, 2, gameRequestEntity.getSender(), i, false);
        zzc.zza(parcel, 3, gameRequestEntity.getData(), false);
        zzc.zza(parcel, 4, gameRequestEntity.getRequestId(), false);
        zzc.zzc(parcel, 5, gameRequestEntity.getRecipients(), false);
        zzc.zzc(parcel, 7, gameRequestEntity.getType());
        zzc.zzc(parcel, 1000, gameRequestEntity.getVersionCode());
        zzc.zza(parcel, 9, gameRequestEntity.getCreationTimestamp());
        zzc.zza(parcel, 10, gameRequestEntity.getExpirationTimestamp());
        zzc.zza(parcel, 11, gameRequestEntity.zzFK(), false);
        zzc.zzc(parcel, 12, gameRequestEntity.getStatus());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfV(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzja(i);
    }

    public GameRequestEntity zzfV(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        PlayerEntity playerEntity = null;
        byte[] bArr = null;
        String str = null;
        ArrayList arrayList = null;
        int i2 = 0;
        long j = 0;
        long j2 = 0;
        Bundle bundle = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    gameEntity = (GameEntity) zzb.zza(parcel, zzaT, GameEntity.CREATOR);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) zzb.zza(parcel, zzaT, PlayerEntity.CREATOR);
                    break;
                case 3:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case 4:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 5:
                    arrayList = zzb.zzc(parcel, zzaT, PlayerEntity.CREATOR);
                    break;
                case 7:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 9:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case 10:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case 11:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_RX /*12*/:
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
            return new GameRequestEntity(i, gameEntity, playerEntity, bArr, str, arrayList, i2, j, j2, bundle, i3);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public GameRequestEntity[] zzja(int i) {
        return new GameRequestEntity[i];
    }
}
