package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzavn;
import com.google.android.gms.internal.zzavr;
import com.google.android.gms.nearby.messages.internal.zzt;
import java.util.List;

public class zzb implements Creator<MessageFilter> {
    static void zza(MessageFilter messageFilter, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, messageFilter.zzMZ(), false);
        zzc.zzc(parcel, 2, messageFilter.zzNb(), false);
        zzc.zza(parcel, 3, messageFilter.zzNa());
        zzc.zzc(parcel, 4, messageFilter.zzNc(), false);
        zzc.zzc(parcel, 1000, messageFilter.mVersionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzia(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlK(i);
    }

    public MessageFilter zzia(Parcel parcel) {
        boolean z = false;
        List list = null;
        int zzaU = com.google.android.gms.common.internal.safeparcel.zzb.zzaU(parcel);
        List list2 = null;
        List list3 = null;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = com.google.android.gms.common.internal.safeparcel.zzb.zzaT(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zzb.zzcW(zzaT)) {
                case 1:
                    list3 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT, zzt.CREATOR);
                    break;
                case 2:
                    list2 = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT, zzavr.CREATOR);
                    break;
                case 3:
                    z = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT);
                    break;
                case 4:
                    list = com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, zzaT, zzavn.CREATOR);
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
            return new MessageFilter(i, list3, list2, z, list);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public MessageFilter[] zzlK(int i) {
        return new MessageFilter[i];
    }
}
