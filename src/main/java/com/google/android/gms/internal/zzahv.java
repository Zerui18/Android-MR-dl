package com.google.android.gms.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.zzb;
import com.google.android.gms.drive.events.zzd;
import com.google.android.gms.drive.events.zzh;
import com.google.android.gms.drive.events.zzk;
import com.google.android.gms.drive.events.zzm;
import com.google.android.gms.drive.events.zzn;
import java.util.ArrayList;
import java.util.List;

public class zzahv extends com.google.android.gms.internal.zzaim.zza {
    private final int zzaGv;
    private final zzh zzaMi;
    private final zza zzaMj;
    private final List<Integer> zzaMk = new ArrayList();

    private static class zza extends Handler {
        private final Context mContext;

        class AnonymousClass1 {
            final /* synthetic */ MetadataBuffer zzaMl;

            AnonymousClass1(MetadataBuffer metadataBuffer) {
                this.zzaMl = metadataBuffer;
            }
        }

        private zza(Looper looper, Context context) {
            super(looper);
            this.mContext = context;
        }

        private static void zza(zzm com_google_android_gms_drive_events_zzm, zzk com_google_android_gms_drive_events_zzk) {
            DataHolder zzAb = com_google_android_gms_drive_events_zzk.zzAb();
            if (zzAb != null) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(new MetadataBuffer(zzAb));
            }
            if (com_google_android_gms_drive_events_zzk.zzAc()) {
                com_google_android_gms_drive_events_zzk.zzAd();
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    zzh com_google_android_gms_drive_events_zzh = (zzh) pair.first;
                    DriveEvent driveEvent = (DriveEvent) pair.second;
                    switch (driveEvent.getType()) {
                        case 1:
                            ((ChangeListener) com_google_android_gms_drive_events_zzh).onChange((ChangeEvent) driveEvent);
                            return;
                        case 2:
                            ((CompletionListener) com_google_android_gms_drive_events_zzh).onCompletion((CompletionEvent) driveEvent);
                            return;
                        case 3:
                            zza((zzm) com_google_android_gms_drive_events_zzh, (zzk) driveEvent);
                            return;
                        case 4:
                            ((zzd) com_google_android_gms_drive_events_zzh).zza((zzb) driveEvent);
                            return;
                        case 8:
                            zzafx com_google_android_gms_internal_zzafx = new zzafx(((zzn) driveEvent).zzAe());
                            return;
                        default:
                            String valueOf = String.valueOf(driveEvent);
                            zzahp.zzE("EventCallback", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unexpected event: ").append(valueOf).toString());
                            return;
                    }
                default:
                    zzahp.zzh(this.mContext, "EventCallback", "Don't know how to handle this event");
                    return;
            }
        }

        public void zza(zzh com_google_android_gms_drive_events_zzh, DriveEvent driveEvent) {
            sendMessage(obtainMessage(1, new Pair(com_google_android_gms_drive_events_zzh, driveEvent)));
        }
    }

    public zzahv(Looper looper, Context context, int i, zzh com_google_android_gms_drive_events_zzh) {
        this.zzaGv = i;
        this.zzaMi = com_google_android_gms_drive_events_zzh;
        this.zzaMj = new zza(looper, context);
    }

    public void zzc(zzajc com_google_android_gms_internal_zzajc) throws RemoteException {
        DriveEvent zzAt = com_google_android_gms_internal_zzajc.zzAt();
        zzac.zzar(this.zzaGv == zzAt.getType());
        zzac.zzar(this.zzaMk.contains(Integer.valueOf(zzAt.getType())));
        this.zzaMj.zza(this.zzaMi, zzAt);
    }

    public void zzeH(int i) {
        this.zzaMk.add(Integer.valueOf(i));
    }

    public boolean zzeI(int i) {
        return this.zzaMk.contains(Integer.valueOf(i));
    }
}
