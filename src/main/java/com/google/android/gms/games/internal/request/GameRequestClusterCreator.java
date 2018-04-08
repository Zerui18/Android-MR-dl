package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.request.GameRequestEntity;
import java.util.ArrayList;

public class GameRequestClusterCreator implements Creator<GameRequestCluster> {
    static void zza(GameRequestCluster gameRequestCluster, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, gameRequestCluster.zzFw(), false);
        zzc.zzc(parcel, 1000, gameRequestCluster.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfM(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziQ(i);
    }

    public GameRequestCluster zzfM(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    arrayList = zzb.zzc(parcel, zzaT, GameRequestEntity.CREATOR);
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
            return new GameRequestCluster(i, arrayList);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public GameRequestCluster[] zziQ(int i) {
        return new GameRequestCluster[i];
    }
}
