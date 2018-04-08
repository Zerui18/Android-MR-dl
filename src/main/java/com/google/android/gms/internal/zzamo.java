package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import java.util.List;

public class zzamo implements Creator<zzamn> {
    static void zza(zzamn com_google_android_gms_internal_zzamn, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, com_google_android_gms_internal_zzamn.mVersionCode);
        zzc.zza(parcel, 2, com_google_android_gms_internal_zzamn.zzVW, false);
        zzc.zza(parcel, 3, com_google_android_gms_internal_zzamn.zzach, false);
        zzc.zzb(parcel, 4, com_google_android_gms_internal_zzamn.zzaPx, false);
        zzc.zza(parcel, 5, com_google_android_gms_internal_zzamn.zzaPy);
        zzc.zza(parcel, 6, com_google_android_gms_internal_zzamn.zzaPr, false);
        zzc.zza(parcel, 7, com_google_android_gms_internal_zzamn.zzaPB, false);
        zzc.zza(parcel, 8, com_google_android_gms_internal_zzamn.zzaPC, i, false);
        zzc.zza(parcel, 9, com_google_android_gms_internal_zzamn.zzaPD, i, false);
        zzc.zza(parcel, 10, com_google_android_gms_internal_zzamn.zzaPE, i, false);
        zzc.zza(parcel, 11, com_google_android_gms_internal_zzamn.zzaPF, i, false);
        zzc.zza(parcel, 12, com_google_android_gms_internal_zzamn.zzaPG, i, false);
        zzc.zza(parcel, 13, com_google_android_gms_internal_zzamn.zzaPH, i, false);
        zzc.zza(parcel, 14, com_google_android_gms_internal_zzamn.zzaPI, i, false);
        zzc.zza(parcel, 15, com_google_android_gms_internal_zzamn.zzaPJ, i, false);
        zzc.zza(parcel, 16, com_google_android_gms_internal_zzamn.zzaPz);
        zzc.zza(parcel, 17, com_google_android_gms_internal_zzamn.zzaPA);
        zzc.zza(parcel, 18, com_google_android_gms_internal_zzamn.zzaPK, i, false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzdE(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgb(i);
    }

    public zzamn zzdE(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        List list = null;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        String str3 = null;
        String str4 = null;
        zzamv com_google_android_gms_internal_zzamv = null;
        zzamt com_google_android_gms_internal_zzamt = null;
        zzamz com_google_android_gms_internal_zzamz = null;
        zzanb com_google_android_gms_internal_zzanb = null;
        zzand com_google_android_gms_internal_zzand = null;
        zzamx com_google_android_gms_internal_zzamx = null;
        zzamr com_google_android_gms_internal_zzamr = null;
        zzaml com_google_android_gms_internal_zzaml = null;
        zzamj com_google_android_gms_internal_zzamj = null;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 4:
                    list = zzb.zzE(parcel, zzaT);
                    break;
                case 5:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case 6:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case 8:
                    com_google_android_gms_internal_zzamv = (zzamv) zzb.zza(parcel, zzaT, zzamv.CREATOR);
                    break;
                case 9:
                    com_google_android_gms_internal_zzamt = (zzamt) zzb.zza(parcel, zzaT, zzamt.CREATOR);
                    break;
                case 10:
                    com_google_android_gms_internal_zzamz = (zzamz) zzb.zza(parcel, zzaT, zzamz.CREATOR);
                    break;
                case 11:
                    com_google_android_gms_internal_zzanb = (zzanb) zzb.zza(parcel, zzaT, zzanb.CREATOR);
                    break;
                case MotionEventCompat.AXIS_RX /*12*/:
                    com_google_android_gms_internal_zzand = (zzand) zzb.zza(parcel, zzaT, zzand.CREATOR);
                    break;
                case 13:
                    com_google_android_gms_internal_zzamx = (zzamx) zzb.zza(parcel, zzaT, zzamx.CREATOR);
                    break;
                case 14:
                    com_google_android_gms_internal_zzamr = (zzamr) zzb.zza(parcel, zzaT, zzamr.CREATOR);
                    break;
                case 15:
                    com_google_android_gms_internal_zzaml = (zzaml) zzb.zza(parcel, zzaT, zzaml.CREATOR);
                    break;
                case 16:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 17:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                case 18:
                    com_google_android_gms_internal_zzamj = (zzamj) zzb.zza(parcel, zzaT, zzamj.CREATOR);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new zzamn(i, str, str2, list, z, z2, z3, str3, str4, com_google_android_gms_internal_zzamv, com_google_android_gms_internal_zzamt, com_google_android_gms_internal_zzamz, com_google_android_gms_internal_zzanb, com_google_android_gms_internal_zzand, com_google_android_gms_internal_zzamx, com_google_android_gms_internal_zzamr, com_google_android_gms_internal_zzaml, com_google_android_gms_internal_zzamj);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public zzamn[] zzgb(int i) {
        return new zzamn[i];
    }
}
