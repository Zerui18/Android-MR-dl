package com.google.android.gms.nearby.messages.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.util.zzs;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishCallback;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.SubscribeCallback;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import java.util.List;

class zzx extends zzl<zzo> {
    private final int zzbxB;
    private final ClientAppContext zzbyD;
    private final zzh<StatusCallback, zzf> zzbyE = new zzh<StatusCallback, zzf>(this) {
        protected zzf zzh(zzaaz<StatusCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_StatusCallback) {
            return new zzf(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_StatusCallback);
        }

        protected /* synthetic */ zza zzi(zzaaz com_google_android_gms_internal_zzaaz) {
            return zzh(com_google_android_gms_internal_zzaaz);
        }
    };
    private final zzh<MessageListener, zzc> zzbyF = new zzh<MessageListener, zzc>(this) {
        protected /* synthetic */ zza zzi(zzaaz com_google_android_gms_internal_zzaaz) {
            return zzj(com_google_android_gms_internal_zzaaz);
        }

        protected zzc zzj(zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_MessageListener) {
            return new zzc(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_MessageListener);
        }
    };
    private final zzh<SubscribeCallback, zzg> zzbyG = new zzh<SubscribeCallback, zzg>(this) {
        protected /* synthetic */ zza zzi(zzaaz com_google_android_gms_internal_zzaaz) {
            return zzk(com_google_android_gms_internal_zzaaz);
        }

        protected zzg zzk(zzaaz<SubscribeCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback) {
            return new zzg(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback);
        }
    };
    private final zzh<PublishCallback, zze> zzbyH = new zzh<PublishCallback, zze>(this) {
        protected /* synthetic */ zza zzi(zzaaz com_google_android_gms_internal_zzaaz) {
            return zzl(com_google_android_gms_internal_zzaaz);
        }

        protected zze zzl(zzaaz<PublishCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_PublishCallback) {
            return new zze(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_PublishCallback);
        }
    };

    private static abstract class zzh<C, W extends zza<C>> {
        private final SimpleArrayMap<C, W> zzaGt;

        private zzh() {
            this.zzaGt = new SimpleArrayMap(1);
        }

        @Nullable
        W zzH(C c) {
            return (zza) this.zzaGt.get(c);
        }

        @Nullable
        W zzI(C c) {
            zza com_google_android_gms_nearby_messages_internal_zzx_zza = (zza) this.zzaGt.remove(c);
            if (com_google_android_gms_nearby_messages_internal_zzx_zza != null) {
                com_google_android_gms_nearby_messages_internal_zzx_zza.zzNl().clear();
            }
            return com_google_android_gms_nearby_messages_internal_zzx_zza;
        }

        W zza(zzaaz<C> com_google_android_gms_internal_zzaaz_C, C c) {
            zza com_google_android_gms_nearby_messages_internal_zzx_zza = (zza) this.zzaGt.get(c);
            if (com_google_android_gms_nearby_messages_internal_zzx_zza != null) {
                com_google_android_gms_internal_zzaaz_C.clear();
                return com_google_android_gms_nearby_messages_internal_zzx_zza;
            }
            W zzi = zzi(com_google_android_gms_internal_zzaaz_C);
            this.zzaGt.put(c, zzi);
            return zzi;
        }

        protected abstract W zzi(zzaaz<C> com_google_android_gms_internal_zzaaz_C);
    }

    private interface zza<C> {
        zzaaz<C> zzNl();
    }

    @TargetApi(14)
    private static class zzb implements ActivityLifecycleCallbacks {
        private final Activity zzbyI;
        private final zzx zzbyJ;

        private zzb(Activity activity, zzx com_google_android_gms_nearby_messages_internal_zzx) {
            this.zzbyI = activity;
            this.zzbyJ = com_google_android_gms_nearby_messages_internal_zzx;
        }

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
            if (activity == this.zzbyI) {
                Log.v("NearbyMessagesClient", String.format("Unregistering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", new Object[]{activity.getPackageName()}));
                activity.getApplication().unregisterActivityLifecycleCallbacks(this);
            }
        }

        public void onActivityPaused(Activity activity) {
        }

        public void onActivityResumed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
            if (activity == this.zzbyI) {
                try {
                    this.zzbyJ.zzmd(1);
                } catch (RemoteException e) {
                    Log.v("NearbyMessagesClient", String.format("Failed to emit ACTIVITY_STOPPED from ClientLifecycleSafetyNet for Activity %s: %s", new Object[]{activity.getPackageName(), e}));
                }
            }
        }
    }

    private static abstract class zzd<T> implements com.google.android.gms.internal.zzaaz.zzc<T> {
        private zzd() {
        }

        public void zzvy() {
        }
    }

    private static class zzc extends com.google.android.gms.nearby.messages.internal.zzm.zza implements zza<MessageListener> {
        private final zzaaz<MessageListener> zzaBG;

        private zzc(zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_MessageListener) {
            this.zzaBG = com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_MessageListener;
        }

        public void zzI(final List<Update> list) throws RemoteException {
            this.zzaBG.zza(new zzd<MessageListener>(this) {
                public void zza(MessageListener messageListener) {
                    zzy.zza(list, messageListener);
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((MessageListener) obj);
                }
            });
        }

        public zzaaz<MessageListener> zzNl() {
            return this.zzaBG;
        }

        public void zza(zzv com_google_android_gms_nearby_messages_internal_zzv) {
        }

        public void zzb(zzv com_google_android_gms_nearby_messages_internal_zzv) {
        }
    }

    private static class zze extends com.google.android.gms.nearby.messages.internal.zzp.zza implements zza<PublishCallback> {
        private static final zzd<PublishCallback> zzbyL = new zzd<PublishCallback>() {
            public void zza(PublishCallback publishCallback) {
                publishCallback.onExpired();
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((PublishCallback) obj);
            }
        };
        private final zzaaz<PublishCallback> zzbyM;

        private zze(zzaaz<PublishCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_PublishCallback) {
            this.zzbyM = com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_PublishCallback;
        }

        @Nullable
        private static zze zzm(@Nullable zzaaz<PublishCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_PublishCallback) {
            return com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_PublishCallback == null ? null : new zze(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_PublishCallback);
        }

        public void onExpired() {
            this.zzbyM.zza(zzbyL);
        }

        public zzaaz<PublishCallback> zzNl() {
            return this.zzbyM;
        }
    }

    private static class zzf extends com.google.android.gms.nearby.messages.internal.zzq.zza implements zza<StatusCallback> {
        private final zzaaz<StatusCallback> zzbyM;

        private zzf(zzaaz<StatusCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_StatusCallback) {
            this.zzbyM = com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_StatusCallback;
        }

        public void onPermissionChanged(final boolean z) {
            this.zzbyM.zza(new zzd<StatusCallback>(this) {
                public void zza(StatusCallback statusCallback) {
                    statusCallback.onPermissionChanged(z);
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((StatusCallback) obj);
                }
            });
        }

        public zzaaz<StatusCallback> zzNl() {
            return this.zzbyM;
        }
    }

    private static class zzg extends com.google.android.gms.nearby.messages.internal.zzr.zza implements zza<SubscribeCallback> {
        private static final zzd<SubscribeCallback> zzbyL = new zzd<SubscribeCallback>() {
            public void zza(SubscribeCallback subscribeCallback) {
                subscribeCallback.onExpired();
            }

            public /* synthetic */ void zzs(Object obj) {
                zza((SubscribeCallback) obj);
            }
        };
        private final zzaaz<SubscribeCallback> zzbyM;

        private zzg(zzaaz<SubscribeCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback) {
            this.zzbyM = com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback;
        }

        @Nullable
        private static zzg zzo(@Nullable zzaaz<SubscribeCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback) {
            return com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback == null ? null : new zzg(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback);
        }

        public void onExpired() {
            this.zzbyM.zza(zzbyL);
        }

        public zzaaz<SubscribeCallback> zzNl() {
            return this.zzbyM;
        }
    }

    @TargetApi(14)
    zzx(Context context, Looper looper, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, com.google.android.gms.common.internal.zzg com_google_android_gms_common_internal_zzg, MessagesOptions messagesOptions) {
        super(context, looper, 62, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        String zzxh = com_google_android_gms_common_internal_zzg.zzxh();
        int zzbv = zzbv(context);
        if (messagesOptions != null) {
            this.zzbyD = new ClientAppContext(zzxh, messagesOptions.zzbxx, messagesOptions.zzbxy, messagesOptions.zzbxA, zzbv);
            this.zzbxB = messagesOptions.zzbxz;
        } else {
            this.zzbyD = new ClientAppContext(zzxh, null, false, null, zzbv);
            this.zzbxB = -1;
        }
        if (zzbv == 1 && zzs.zzyA()) {
            Activity activity = (Activity) context;
            Log.v("NearbyMessagesClient", String.format("Registering ClientLifecycleSafetyNet's ActivityLifecycleCallbacks for %s", new Object[]{activity.getPackageName()}));
            activity.getApplication().registerActivityLifecycleCallbacks(new zzb(activity, this));
        }
    }

    @Nullable
    private static <C> zzaaz<C> zza(GoogleApiClient googleApiClient, C c, zzh<C, ? extends zza<C>> com_google_android_gms_nearby_messages_internal_zzx_zzh_C___extends_com_google_android_gms_nearby_messages_internal_zzx_zza_C) {
        if (c == null) {
            return null;
        }
        zza zzH = com_google_android_gms_nearby_messages_internal_zzx_zzh_C___extends_com_google_android_gms_nearby_messages_internal_zzx_zza_C.zzH(c);
        return zzH != null ? zzH.zzNl() : googleApiClient.zzr(c);
    }

    private static int zzbv(Context context) {
        return context instanceof Activity ? 1 : context instanceof Application ? 2 : context instanceof Service ? 3 : 0;
    }

    public void disconnect() {
        try {
            zzmd(2);
        } catch (RemoteException e) {
            Log.v("NearbyMessagesClient", String.format("Failed to emit CLIENT_DISCONNECTED from override of GmsClient#disconnect(): %s", new Object[]{e}));
        }
        super.disconnect();
    }

    @Nullable
    zzaaz<MessageListener> zza(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return zza(googleApiClient, (Object) messageListener, this.zzbyF);
    }

    @Nullable
    zzaaz<PublishCallback> zza(GoogleApiClient googleApiClient, PublishCallback publishCallback) {
        return zza(googleApiClient, (Object) publishCallback, this.zzbyH);
    }

    @Nullable
    zzaaz<StatusCallback> zza(GoogleApiClient googleApiClient, StatusCallback statusCallback) {
        return zza(googleApiClient, (Object) statusCallback, this.zzbyE);
    }

    @Nullable
    zzaaz<SubscribeCallback> zza(GoogleApiClient googleApiClient, SubscribeCallback subscribeCallback) {
        return zza(googleApiClient, (Object) subscribeCallback, this.zzbyG);
    }

    void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, PendingIntent pendingIntent) throws RemoteException {
        ((zzo) zzwW()).zza(new zzai(null, zzaa.zzu(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), pendingIntent, 0));
    }

    void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, PendingIntent pendingIntent, @Nullable zzaaz<SubscribeCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback, SubscribeOptions subscribeOptions) throws RemoteException {
        ((zzo) zzwW()).zza(new SubscribeRequest(null, subscribeOptions.getStrategy(), zzaa.zzu(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), subscribeOptions.getFilter(), pendingIntent, 0, null, zzg.zzo(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback), subscribeOptions.zzbxT));
    }

    void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_MessageListener, MessageListener messageListener, @Nullable zzaaz<SubscribeCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback, SubscribeOptions subscribeOptions, @Nullable byte[] bArr) throws RemoteException {
        ((zzo) zzwW()).zza(new SubscribeRequest((IBinder) this.zzbyF.zza(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_MessageListener, messageListener), subscribeOptions.getStrategy(), zzaa.zzu(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), subscribeOptions.getFilter(), null, 0, bArr, zzg.zzo(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_SubscribeCallback), subscribeOptions.zzbxT));
    }

    void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzaaz<StatusCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_StatusCallback, StatusCallback statusCallback) throws RemoteException {
        zzad com_google_android_gms_nearby_messages_internal_zzad = new zzad(zzaa.zzu(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), (IBinder) this.zzbyE.zza(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_StatusCallback, statusCallback));
        com_google_android_gms_nearby_messages_internal_zzad.zzbzc = true;
        ((zzo) zzwW()).zza(com_google_android_gms_nearby_messages_internal_zzad);
    }

    void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, MessageListener messageListener) throws RemoteException {
        if (this.zzbyF.zzH(messageListener) != null) {
            ((zzo) zzwW()).zza(new zzai((IBinder) this.zzbyF.zzH(messageListener), zzaa.zzu(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), null, 0));
            this.zzbyF.zzI(messageListener);
        }
    }

    void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, StatusCallback statusCallback) throws RemoteException {
        if (this.zzbyE.zzH(statusCallback) != null) {
            zzad com_google_android_gms_nearby_messages_internal_zzad = new zzad(zzaa.zzu(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), (IBinder) this.zzbyE.zzH(statusCallback));
            com_google_android_gms_nearby_messages_internal_zzad.zzbzc = false;
            ((zzo) zzwW()).zza(com_google_android_gms_nearby_messages_internal_zzad);
            this.zzbyE.zzI(statusCallback);
        }
    }

    void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzv com_google_android_gms_nearby_messages_internal_zzv) throws RemoteException {
        ((zzo) zzwW()).zza(new zzag(com_google_android_gms_nearby_messages_internal_zzv, zzaa.zzu(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), this.zzbyD));
    }

    void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzv com_google_android_gms_nearby_messages_internal_zzv, @Nullable zzaaz<PublishCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_PublishCallback, PublishOptions publishOptions) throws RemoteException {
        ((zzo) zzwW()).zza(new zzab(com_google_android_gms_nearby_messages_internal_zzv, publishOptions.getStrategy(), zzaa.zzu(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), zze.zzm(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_messages_PublishCallback)));
    }

    protected zzo zzeI(IBinder iBinder) {
        return com.google.android.gms.nearby.messages.internal.zzo.zza.zzeE(iBinder);
    }

    @NonNull
    protected String zzeu() {
        return "com.google.android.gms.nearby.messages.service.NearbyMessagesService.START";
    }

    @NonNull
    protected String zzev() {
        return "com.google.android.gms.nearby.messages.internal.INearbyMessagesService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzeI(iBinder);
    }

    void zzmd(int i) throws RemoteException {
        String str;
        switch (i) {
            case 1:
                str = "ACTIVITY_STOPPED";
                break;
            case 2:
                str = "CLIENT_DISCONNECTED";
                break;
            default:
                Log.w("NearbyMessagesClient", String.format("Received unknown/unforeseen client lifecycle event %d, can't do anything with it.", new Object[]{Integer.valueOf(i)}));
                return;
        }
        if (isConnected()) {
            zzj com_google_android_gms_nearby_messages_internal_zzj = new zzj(i);
            Log.d("NearbyMessagesClient", String.format("Emitting client lifecycle event %s", new Object[]{str}));
            ((zzo) zzwW()).zza(com_google_android_gms_nearby_messages_internal_zzj);
            return;
        }
        Log.d("NearbyMessagesClient", String.format("Failed to emit client lifecycle event %s due to GmsClient being disconnected", new Object[]{str}));
    }

    @NonNull
    protected Bundle zzql() {
        Bundle zzql = super.zzql();
        zzql.putInt("NearbyPermissions", this.zzbxB);
        zzql.putParcelable("ClientAppContext", this.zzbyD);
        return zzql;
    }

    void zzt(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) throws RemoteException {
        ((zzo) zzwW()).zza(new zzh(zzaa.zzu(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status)));
    }
}
