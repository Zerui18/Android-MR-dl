package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzd implements Creator<ClientAppContext> {
    static void zza(ClientAppContext clientAppContext, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, clientAppContext.versionCode);
        zzc.zza(parcel, 2, clientAppContext.zzbyv, false);
        zzc.zza(parcel, 3, clientAppContext.zzbyw, false);
        zzc.zza(parcel, 4, clientAppContext.zzbxy);
        zzc.zzc(parcel, 5, clientAppContext.zzbyx);
        zzc.zza(parcel, 6, clientAppContext.zzbxA, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzih(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlW(i);
    }

    public ClientAppContext zzih(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        boolean z = false;
        String str2 = null;
        String str3 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 5:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 6:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new ClientAppContext(i2, str3, str2, z, i, str);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ClientAppContext[] zzlW(int i) {
        return new ClientAppContext[i];
    }
}
