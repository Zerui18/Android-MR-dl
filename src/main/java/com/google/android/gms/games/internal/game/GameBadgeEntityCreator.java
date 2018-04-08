package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class GameBadgeEntityCreator implements Creator<GameBadgeEntity> {
    static void zza(GameBadgeEntity gameBadgeEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, gameBadgeEntity.getType());
        zzc.zza(parcel, 2, gameBadgeEntity.getTitle(), false);
        zzc.zza(parcel, 3, gameBadgeEntity.getDescription(), false);
        zzc.zza(parcel, 4, gameBadgeEntity.getIconImageUri(), i, false);
        zzc.zzc(parcel, 1000, gameBadgeEntity.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfG(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziG(i);
    }

    public GameBadgeEntity zzfG(Parcel parcel) {
        int i = 0;
        Uri uri = null;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        String str2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 1000:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new GameBadgeEntity(i2, i, str2, str, uri);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public GameBadgeEntity[] zziG(int i) {
        return new GameBadgeEntity[i];
    }
}
