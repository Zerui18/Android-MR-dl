package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.nearby.messages.Strategy;

public class zzac implements Creator<zzab> {
    static void zza(zzab com_google_android_gms_nearby_messages_internal_zzab, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_nearby_messages_internal_zzab.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_nearby_messages_internal_zzab.zzbyX, i, false);
        zzc.zza(parcel, 3, com_google_android_gms_nearby_messages_internal_zzab.zzbyY, i, false);
        zzc.zza(parcel, 4, com_google_android_gms_nearby_messages_internal_zzab.zzNi(), false);
        zzc.zza(parcel, 5, com_google_android_gms_nearby_messages_internal_zzab.zzbxx, false);
        zzc.zza(parcel, 6, com_google_android_gms_nearby_messages_internal_zzab.zzbyv, false);
        zzc.zza(parcel, 7, com_google_android_gms_nearby_messages_internal_zzab.zzbyZ);
        zzc.zza(parcel, 8, com_google_android_gms_nearby_messages_internal_zzab.zzNm(), false);
        zzc.zza(parcel, 9, com_google_android_gms_nearby_messages_internal_zzab.zzbxy);
        zzc.zza(parcel, 10, com_google_android_gms_nearby_messages_internal_zzab.zzbyA, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzin(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzme(i);
    }

    public zzab zzin(Parcel parcel) {
        boolean z = false;
        ClientAppContext clientAppContext = null;
        int zzaU = zzb.zzaU(parcel);
        IBinder iBinder = null;
        boolean z2 = false;
        String str = null;
        String str2 = null;
        IBinder iBinder2 = null;
        Strategy strategy = null;
        zzv com_google_android_gms_nearby_messages_internal_zzv = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    com_google_android_gms_nearby_messages_internal_zzv = (zzv) zzb.zza(parcel, zzaT, zzv.CREATOR);
                    break;
                case 3:
                    strategy = (Strategy) zzb.zza(parcel, zzaT, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case 5:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 6:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 8:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case 9:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 10:
                    clientAppContext = (ClientAppContext) zzb.zza(parcel, zzaT, ClientAppContext.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzab(i, com_google_android_gms_nearby_messages_internal_zzv, strategy, iBinder2, str2, str, z2, iBinder, z, clientAppContext);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzab[] zzme(int i) {
        return new zzab[i];
    }
}
