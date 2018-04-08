package com.google.android.gms.games.quest;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.games.GameEntity;
import java.util.ArrayList;

public class QuestEntityCreator implements Creator<QuestEntity> {
    static void zza(QuestEntity questEntity, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zza(parcel, 1, questEntity.getGame(), i, false);
        zzc.zza(parcel, 2, questEntity.getQuestId(), false);
        zzc.zza(parcel, 3, questEntity.getAcceptedTimestamp());
        zzc.zza(parcel, 4, questEntity.getBannerImageUri(), i, false);
        zzc.zza(parcel, 5, questEntity.getBannerImageUrl(), false);
        zzc.zza(parcel, 6, questEntity.getDescription(), false);
        zzc.zza(parcel, 7, questEntity.getEndTimestamp());
        zzc.zzc(parcel, 1000, questEntity.getVersionCode());
        zzc.zza(parcel, 8, questEntity.getLastUpdatedTimestamp());
        zzc.zza(parcel, 9, questEntity.getIconImageUri(), i, false);
        zzc.zza(parcel, 10, questEntity.getIconImageUrl(), false);
        zzc.zza(parcel, 12, questEntity.getName(), false);
        zzc.zza(parcel, 13, questEntity.zzFJ());
        zzc.zza(parcel, 14, questEntity.getStartTimestamp());
        zzc.zzc(parcel, 15, questEntity.getState());
        zzc.zzc(parcel, 16, questEntity.getType());
        zzc.zzc(parcel, 17, questEntity.zzFI(), false);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzfU(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zziZ(i);
    }

    public QuestEntity zzfU(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        GameEntity gameEntity = null;
        String str = null;
        long j = 0;
        Uri uri = null;
        String str2 = null;
        String str3 = null;
        long j2 = 0;
        long j3 = 0;
        Uri uri2 = null;
        String str4 = null;
        String str5 = null;
        long j4 = 0;
        long j5 = 0;
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList = null;
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
                    uri = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 5:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 6:
                    str3 = zzb.zzq(parcel, zzaT);
                    break;
                case 7:
                    j2 = zzb.zzi(parcel, zzaT);
                    break;
                case 8:
                    j3 = zzb.zzi(parcel, zzaT);
                    break;
                case 9:
                    uri2 = (Uri) zzb.zza(parcel, zzaT, Uri.CREATOR);
                    break;
                case 10:
                    str4 = zzb.zzq(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_RX /*12*/:
                    str5 = zzb.zzq(parcel, zzaT);
                    break;
                case 13:
                    j4 = zzb.zzi(parcel, zzaT);
                    break;
                case 14:
                    j5 = zzb.zzi(parcel, zzaT);
                    break;
                case 15:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 16:
                    i3 = zzb.zzg(parcel, zzaT);
                    break;
                case 17:
                    arrayList = zzb.zzc(parcel, zzaT, MilestoneEntity.CREATOR);
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
            return new QuestEntity(i, gameEntity, str, j, uri, str2, str3, j2, j3, uri2, str4, str5, j4, j5, i2, i3, arrayList);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public QuestEntity[] zziZ(int i) {
        return new QuestEntity[i];
    }
}
