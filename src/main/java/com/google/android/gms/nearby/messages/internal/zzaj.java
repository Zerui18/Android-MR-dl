package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class zzaj implements Creator<zzai> {
    static void zza(zzai com_google_android_gms_nearby_messages_internal_zzai, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_nearby_messages_internal_zzai.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_nearby_messages_internal_zzai.zzNo(), false);
        zzc.zza(parcel, 3, com_google_android_gms_nearby_messages_internal_zzai.zzNi(), false);
        zzc.zza(parcel, 4, com_google_android_gms_nearby_messages_internal_zzai.zzaIj, i, false);
        zzc.zzc(parcel, 5, com_google_android_gms_nearby_messages_internal_zzai.zzbzf);
        zzc.zza(parcel, 6, com_google_android_gms_nearby_messages_internal_zzai.zzbxx, false);
        zzc.zza(parcel, 7, com_google_android_gms_nearby_messages_internal_zzai.zzbyv, false);
        zzc.zza(parcel, 8, com_google_android_gms_nearby_messages_internal_zzai.zzbxy);
        zzc.zza(parcel, 9, com_google_android_gms_nearby_messages_internal_zzai.zzbyA, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzir(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmi(i);
    }

    public zzai zzir(Parcel parcel) {
        boolean z = false;
        ClientAppContext clientAppContext = null;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        String str2 = null;
        int i = 0;
        PendingIntent pendingIntent = null;
        IBinder iBinder = null;
        IBinder iBinder2 = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case 3:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case 4:
                    pendingIntent = (PendingIntent) zzb.zza(parcel, zzaT, PendingIntent.CREATOR);
                    break;
                case 5:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 6:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 8:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 9:
                    clientAppContext = (ClientAppContext) zzb.zza(parcel, zzaT, ClientAppContext.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzai(i2, iBinder2, iBinder, pendingIntent, i, str2, str, z, clientAppContext);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzai[] zzmi(int i) {
        return new zzai[i];
    }
}
