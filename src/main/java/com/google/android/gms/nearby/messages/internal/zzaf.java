package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.internal.safeparcel.zzb.zza;
import com.google.android.gms.common.internal.safeparcel.zzc;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

public class zzaf implements Creator<SubscribeRequest> {
    static void zza(SubscribeRequest subscribeRequest, Parcel parcel, int i) {
        int zzaV = zzc.zzaV(parcel);
        zzc.zzc(parcel, 1, subscribeRequest.mVersionCode);
        zzc.zza(parcel, 2, subscribeRequest.zzNo(), false);
        zzc.zza(parcel, 3, subscribeRequest.zzbyY, i, false);
        zzc.zza(parcel, 4, subscribeRequest.zzNi(), false);
        zzc.zza(parcel, 5, subscribeRequest.zzbze, i, false);
        zzc.zza(parcel, 6, subscribeRequest.zzaIj, i, false);
        zzc.zzc(parcel, 7, subscribeRequest.zzbzf);
        zzc.zza(parcel, 8, subscribeRequest.zzbxx, false);
        zzc.zza(parcel, 9, subscribeRequest.zzbyv, false);
        zzc.zza(parcel, 10, subscribeRequest.zzbzg, false);
        zzc.zza(parcel, 11, subscribeRequest.zzbyZ);
        zzc.zza(parcel, 12, subscribeRequest.zzNp(), false);
        zzc.zza(parcel, 13, subscribeRequest.zzbxy);
        zzc.zza(parcel, 14, subscribeRequest.zzbyA, i, false);
        zzc.zza(parcel, 15, subscribeRequest.zzbxT);
        zzc.zzJ(parcel, zzaV);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzip(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzmg(i);
    }

    public SubscribeRequest zzip(Parcel parcel) {
        int zzaU = zzb.zzaU(parcel);
        int i = 0;
        IBinder iBinder = null;
        Strategy strategy = null;
        IBinder iBinder2 = null;
        MessageFilter messageFilter = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        String str = null;
        String str2 = null;
        byte[] bArr = null;
        boolean z = false;
        IBinder iBinder3 = null;
        boolean z2 = false;
        ClientAppContext clientAppContext = null;
        boolean z3 = false;
        while (parcel.dataPosition() < zzaU) {
            int zzaT = zzb.zzaT(parcel);
            switch (zzb.zzcW(zzaT)) {
                case 1:
                    i = zzb.zzg(parcel, zzaT);
                    break;
                case 2:
                    iBinder = zzb.zzr(parcel, zzaT);
                    break;
                case 3:
                    strategy = (Strategy) zzb.zza(parcel, zzaT, Strategy.CREATOR);
                    break;
                case 4:
                    iBinder2 = zzb.zzr(parcel, zzaT);
                    break;
                case 5:
                    messageFilter = (MessageFilter) zzb.zza(parcel, zzaT, MessageFilter.CREATOR);
                    break;
                case 6:
                    pendingIntent = (PendingIntent) zzb.zza(parcel, zzaT, PendingIntent.CREATOR);
                    break;
                case 7:
                    i2 = zzb.zzg(parcel, zzaT);
                    break;
                case 8:
                    str = zzb.zzq(parcel, zzaT);
                    break;
                case 9:
                    str2 = zzb.zzq(parcel, zzaT);
                    break;
                case 10:
                    bArr = zzb.zzt(parcel, zzaT);
                    break;
                case 11:
                    z = zzb.zzc(parcel, zzaT);
                    break;
                case MotionEventCompat.AXIS_RX /*12*/:
                    iBinder3 = zzb.zzr(parcel, zzaT);
                    break;
                case 13:
                    z2 = zzb.zzc(parcel, zzaT);
                    break;
                case 14:
                    clientAppContext = (ClientAppContext) zzb.zza(parcel, zzaT, ClientAppContext.CREATOR);
                    break;
                case 15:
                    z3 = zzb.zzc(parcel, zzaT);
                    break;
                default:
                    zzb.zzb(parcel, zzaT);
                    break;
            }
        }
        if (parcel.dataPosition() == zzaU) {
            return new SubscribeRequest(i, iBinder, strategy, iBinder2, messageFilter, pendingIntent, i2, str, str2, bArr, z, iBinder3, z2, clientAppContext, z3);
        }
        throw new zza("Overread allowed size end=" + zzaU, parcel);
    }

    public SubscribeRequest[] zzmg(int i) {
        return new SubscribeRequest[i];
    }
}
