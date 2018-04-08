package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzd implements Creator<Strategy> {
    static void zza(Strategy strategy, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, strategy.zzbxF);
        zzc.zzc(parcel, 2, strategy.zzbxG);
        zzc.zzc(parcel, 3, strategy.zzbxH);
        zzc.zza(parcel, 4, strategy.zzbxI);
        zzc.zzc(parcel, 5, strategy.zzNd());
        zzc.zzc(parcel, 6, strategy.zzNe());
        zzc.zzc(parcel, 7, strategy.zzNf());
        zzc.zzc(parcel, 1000, strategy.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzib(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlQ(i);
    }

    public Strategy zzib(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i6 = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    i5 = zzb.zzg(parcel, zzaT);
                    break;
                case 3:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                case 4:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 5:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 6:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 7:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 1000:
                    i7 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new Strategy(i7, i6, i5, i4, z, i3, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Strategy[] zzlQ(int i) {
        return new Strategy[i];
    }
}
