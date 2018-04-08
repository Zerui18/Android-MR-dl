package com.google.android.gms.games.multiplayer.realtime;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.multiplayer.ParticipantEntity;
import java.util.ArrayList;

public class RoomEntityCreator implements Creator<RoomEntity> {
    static void zza(RoomEntity roomEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, roomEntity.getRoomId(), false);
        zzc.zza(parcel, 2, roomEntity.getCreatorId(), false);
        zzc.zza(parcel, 3, roomEntity.getCreationTimestamp());
        zzc.zzc(parcel, 4, roomEntity.getStatus());
        zzc.zza(parcel, 5, roomEntity.getDescription(), false);
        zzc.zzc(parcel, 6, roomEntity.getVariant());
        zzc.zza(parcel, 7, roomEntity.getAutoMatchCriteria(), false);
        zzc.zzc(parcel, 1000, roomEntity.getVersionCode());
        zzc.zzc(parcel, 8, roomEntity.getParticipants(), false);
        zzc.zzc(parcel, 9, roomEntity.getAutoMatchWaitEstimateSeconds());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfR(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziW(i);
    }

    public RoomEntity zzfR(Parcel parcel) {
        int i = 0;
        ArrayList arrayList = null;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        Bundle bundle = null;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        String str2 = null;
        String str3 = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 2:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case 4:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 5:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 6:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 7:
                    bundle = zzb.zzs(parcel, zzaT);
                    break;
                case 8:
                    arrayList = zzb.zzc(parcel, zzaT, ParticipantEntity.CREATOR);
                    break;
                case 9:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 1000:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new RoomEntity(i4, str3, str2, j, i3, str, i2, bundle, arrayList, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public RoomEntity[] zziW(int i) {
        return new RoomEntity[i];
    }
}
