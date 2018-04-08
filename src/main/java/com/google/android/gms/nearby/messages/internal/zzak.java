package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzavp;
import com.google.android.gms.nearby.messages.Message;

public class zzak implements Creator<Update> {
    static void zza(Update update, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, update.mVersionCode);
        zzc.zzc(parcel, 2, update.zzbzi);
        zzc.zza(parcel, 3, update.zzbyC, i, false);
        zzc.zza(parcel, 4, update.zzbzj, i, false);
        zzc.zza(parcel, 5, update.zzbzk, i, false);
        zzc.zza(parcel, 6, update.zzbzl, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzis(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmk(i);
    }

    public Update zzis(Parcel parcel) {
        int i = 0;
        zzavp com_google_android_gms_internal_zzavp = null;
        int zzaU = zzb.zzaU(parcel);
        zza com_google_android_gms_nearby_messages_internal_zza = null;
        zze com_google_android_gms_nearby_messages_internal_zze = null;
        Message message = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 3:
                    message = (Message) zzb.zza(parcel, zzaT, Message.CREATOR);
                    break;
                case 4:
                    com_google_android_gms_nearby_messages_internal_zze = (zze) zzb.zza(parcel, zzaT, zze.CREATOR);
                    break;
                case 5:
                    com_google_android_gms_nearby_messages_internal_zza = (zza) zzb.zza(parcel, zzaT, zza.CREATOR);
                    break;
                case 6:
                    com_google_android_gms_internal_zzavp = (zzavp) zzb.zza(parcel, zzaT, zzavp.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new Update(i2, i, message, com_google_android_gms_nearby_messages_internal_zze, com_google_android_gms_nearby_messages_internal_zza, com_google_android_gms_internal_zzavp);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Update[] zzmk(int i) {
        return new Update[i];
    }
}
