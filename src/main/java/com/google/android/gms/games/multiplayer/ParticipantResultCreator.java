package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;

public class ParticipantResultCreator implements Creator<ParticipantResult> {
    static void zza(ParticipantResult participantResult, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, participantResult.getParticipantId(), false);
        zzc.zzc(parcel, 2, participantResult.getResult());
        zzc.zzc(parcel, 3, participantResult.getPlacing());
        zzc.zzc(parcel, 1000, participantResult.getVersionCode());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfP(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziU(i);
    }

    public ParticipantResult zzfP(Parcel parcel) {
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 2:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 3:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 1000:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new ParticipantResult(i3, str, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public ParticipantResult[] zziU(int i) {
        return new ParticipantResult[i];
    }
}
