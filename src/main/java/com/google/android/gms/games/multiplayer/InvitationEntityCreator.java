package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class InvitationEntityCreator implements Creator<InvitationEntity> {
    static void zza(InvitationEntity invitationEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, invitationEntity.getGame(), i, false);
        zzc.zza(parcel, 2, invitationEntity.getInvitationId(), false);
        zzc.zza(parcel, 3, invitationEntity.getCreationTimestamp());
        zzc.zzc(parcel, 4, invitationEntity.getInvitationType());
        zzc.zza(parcel, 5, invitationEntity.getInviter(), i, false);
        zzc.zzc(parcel, 6, invitationEntity.getParticipants(), false);
        zzc.zzc(parcel, 7, invitationEntity.getVariant());
        zzc.zzc(parcel, 1000, invitationEntity.getVersionCode());
        zzc.zzc(parcel, 8, invitationEntity.getAvailableAutoMatchSlots());
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfN(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziS(i);
    }

    public InvitationEntity zzfN(Parcel parcel) {
        ArrayList arrayList = null;
        int i = 0;
        int zzaU = zzb.zzaU(parcel);
        long j = 0;
        int i2 = 0;
        ParticipantEntity participantEntity = null;
        int i3 = 0;
        String str = null;
        GameEntity gameEntity = null;
        int i4 = 0;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    gameEntity = (GameEntity) zzb.zza(parcel, zzaT, GameEntity.CREATOR);
                    break;
                case 2:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 3:
                    j = zzb.zzi(parcel, zzaT);
                    break;
                case 4:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 5:
                    participantEntity = (ParticipantEntity) zzb.zza(parcel, zzaT, ParticipantEntity.CREATOR);
                    break;
                case 6:
                    arrayList = zzb.zzc(parcel, zzaT, ParticipantEntity.CREATOR);
                    break;
                case 7:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 8:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 1000:
                    i4 = zzb.zzg(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new InvitationEntity(i4, gameEntity, str, j, i3, participantEntity, arrayList, i2, i);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public InvitationEntity[] zziS(int i) {
        return new InvitationEntity[i];
    }
}
