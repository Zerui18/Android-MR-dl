package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzk implements Creator<zzj> {
    static void zza(zzj com_google_android_gms_nearby_messages_internal_zzj, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_nearby_messages_internal_zzj.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_nearby_messages_internal_zzj.zzbyA, i, false);
        zzc.zzc(parcel, 3, com_google_android_gms_nearby_messages_internal_zzj.zzbyB);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzik(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzma(i);
    }

    public zzj zzik(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        ClientAppContext clientAppContext = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            ClientAppContext clientAppContext2;
            int zzg;
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    int i3 = i;
                    clientAppContext2 = clientAppContext;
                    zzg = zzb.zzg(parcel, zzaT);
                    zzaT = i3;
                    break;
                case 2:
                    zzg = i2;
                    ClientAppContext clientAppContext3 = (ClientAppContext) zzb.zza(parcel, zzaT, ClientAppContext.CREATOR);
                    zzaT = i;
                    clientAppContext2 = clientAppContext3;
                    break;
                case 3:
                    zzaT = zzb.zzg(parcel, zzaT);
                    clientAppContext2 = clientAppContext;
                    zzg = i2;
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    zzaT = i;
                    clientAppContext2 = clientAppContext;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            clientAppContext = clientAppContext2;
            i = zzaT;
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzj(i2, clientAppContext, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzj[] zzma(int i) {
        return new zzj[i];
    }
}
