package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.internal.zzavp;

public class zza implements Creator<Message> {
    static void zza(Message message, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, message.getContent(), false);
        zzc.zza(parcel, 2, message.getType(), false);
        zzc.zza(parcel, 3, message.getNamespace(), false);
        zzc.zza(parcel, 4, message.zzbxp, i, false);
        zzc.zza(parcel, 5, message.zzMY());
        zzc.zzc(parcel, 1000, message.versionCode);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzhZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzlJ(i);
    }

    public Message zzhZ(Parcel parcel) {
        zzavp[] com_google_android_gms_internal_zzavpArr = null;
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        long j = 0;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case 2:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    com_google_android_gms_internal_zzavpArr = (zzavp[]) zzb.zzb(parcel, zzaT, zzavp.CREATOR);
                    break;
                case 5:
                    j = zzb.zzi(parcel, zzaT);
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
            return new Message(i, bArr, str2, str, com_google_android_gms_internal_zzavpArr, j);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zzb.zza("Overread allowed size end=" + zzaU, parcel);
    }

    public Message[] zzlJ(int i) {
        return new Message[i];
    }
}
