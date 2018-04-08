package com.google.android.gms.games.social;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.PlayerEntity;

public class SocialInviteEntityCreator implements Creator<SocialInviteEntity> {
    static void zza(SocialInviteEntity socialInviteEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, socialInviteEntity.zzFM(), false);
        zzc.zza(parcel, 2, socialInviteEntity.getPlayer(), i, false);
        zzc.zzc(parcel, 3, socialInviteEntity.getType());
        zzc.zzc(parcel, 4, socialInviteEntity.getDirection());
        zzc.zza(parcel, 5, socialInviteEntity.getLastModifiedTimestamp());
        zzc.zzc(parcel, 1000, socialInviteEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzga(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjh(i);
    }

    public SocialInviteEntity zzga(Parcel parcel) {
        PlayerEntity playerEntity = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 2:
                    playerEntity = (PlayerEntity) zzb.zza(parcel, zzaT, PlayerEntity.CREATOR);
                    break;
                case 3:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 4:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 5:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case 1000:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new SocialInviteEntity(i3, str, playerEntity, i2, i, j);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SocialInviteEntity[] zzjh(int i) {
        return new SocialInviteEntity[i];
    }
}
