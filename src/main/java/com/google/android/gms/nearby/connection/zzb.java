package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.List;

public class zzb implements Creator<AppMetadata> {
    static void zza(AppMetadata appMetadata, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, appMetadata.getAppIdentifiers(), false);
        zzc.zzc(parcel, 1000, appMetadata.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhY(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlE(i);
    }

    public AppMetadata zzhY(Parcel parcel) {
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        int i = 0;
        List list = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case 1:
                    list = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT, AppIdentifier.CREATOR);
                    break;
                case 1000:
                    i = com.google.android.gms.common.internal.safeparcel.zzb.zzg(parcel, zzaT);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new AppMetadata(i, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public AppMetadata[] zzlE(int i) {
        return new AppMetadata[i];
    }
}
