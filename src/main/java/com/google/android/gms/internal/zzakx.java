package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.drive.DriveId;

public class zzakx implements Creator<zzakw> {
    static void zza(zzakw com_google_android_gms_internal_zzakw, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzakw.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzakw.zzaKS, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcZ(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfv(i);
    }

    public zzakw zzcZ(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        DriveId driveId = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    driveId = (DriveId) zzb.zza(parcel, zzaT, DriveId.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzakw(i, driveId);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzakw[] zzfv(int i) {
        return new zzakw[i];
    }
}
