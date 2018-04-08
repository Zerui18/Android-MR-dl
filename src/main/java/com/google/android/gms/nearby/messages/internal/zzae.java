package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzae implements Creator<zzad> {
    static void zza(zzad com_google_android_gms_nearby_messages_internal_zzad, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_nearby_messages_internal_zzad.versionCode);
        zzc.zza(parcel, 2, com_google_android_gms_nearby_messages_internal_zzad.zzNi(), false);
        zzc.zza(parcel, 3, com_google_android_gms_nearby_messages_internal_zzad.zzNn(), false);
        zzc.zza(parcel, 4, com_google_android_gms_nearby_messages_internal_zzad.zzbzc);
        zzc.zza(parcel, 5, com_google_android_gms_nearby_messages_internal_zzad.zzbxx, false);
        zzc.zza(parcel, 6, com_google_android_gms_nearby_messages_internal_zzad.zzbyA, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzio(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmf(i);
    }

    public zzad zzio(Parcel parcel) {
        boolean z = false;
        ClientAppContext clientAppContext = null;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case 3:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case 4:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 5:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 6:
                    clientAppContext = (ClientAppContext) zzb.zza(parcel, zzaT, ClientAppContext.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzad(i, iBinder2, iBinder, z, str, clientAppContext);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzad[] zzmf(int i) {
        return new zzad[i];
    }
}
