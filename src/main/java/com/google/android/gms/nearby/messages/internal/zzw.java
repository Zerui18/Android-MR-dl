package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.nearby.messages.Message;

public class zzw implements Creator<zzv> {
    static void zza(zzv com_google_android_gms_nearby_messages_internal_zzv, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, com_google_android_gms_nearby_messages_internal_zzv.zzbyC, i, false);
        zzc.zzc(parcel, 1000, com_google_android_gms_nearby_messages_internal_zzv.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzim(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmc(i);
    }

    public zzv zzim(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        Message message = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    message = (Message) zzb.zza(parcel, zzaT, Message.CREATOR);
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
            return new zzv(i, message);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzv[] zzmc(int i) {
        return new zzv[i];
    }
}
