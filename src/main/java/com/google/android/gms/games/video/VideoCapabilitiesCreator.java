package com.google.android.gms.games.video;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class VideoCapabilitiesCreator implements Creator<VideoCapabilities> {
    static void zza(VideoCapabilities videoCapabilities, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, videoCapabilities.isCameraSupported());
        zzc.zza(parcel, 2, videoCapabilities.isMicSupported());
        zzc.zza(parcel, 3, videoCapabilities.isWriteStorageSupported());
        zzc.zza(parcel, 4, videoCapabilities.getSupportedCaptureModes(), false);
        zzc.zza(parcel, 5, videoCapabilities.getSupportedQualityLevels(), false);
        zzc.zzc(parcel, 1000, videoCapabilities.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzgc(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzjl(i);
    }

    public VideoCapabilities zzgc(Parcel parcel) {
        boolean[] zArr = null;
        boolean z = false;
        int zzaU = zzb.zzaU(parcel);
        boolean[] zArr2 = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case 2:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 3:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 4:
                    zArr2 = zzb.zzv(parcel, zzaT);
                    break;
                case 5:
                    zArr = zzb.zzv(parcel, zzaT);
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
            return new VideoCapabilities(i, z3, z2, z, zArr2, zArr);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public VideoCapabilities[] zzjl(int i) {
        return new VideoCapabilities[i];
    }
}
