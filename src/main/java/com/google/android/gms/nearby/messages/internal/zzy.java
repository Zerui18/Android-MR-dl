package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzaaz;
import com.google.android.gms.internal.zzavp;
import com.google.android.gms.internal.zzzv.zzb;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.messages.Message;
import com.google.android.gms.nearby.messages.MessageListener;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.PublishOptions;
import com.google.android.gms.nearby.messages.StatusCallback;
import com.google.android.gms.nearby.messages.Strategy;
import com.google.android.gms.nearby.messages.SubscribeOptions;
import java.util.List;

public class zzy implements Messages {
    public static final zzf<zzx> zzahc = new zzf();
    public static final com.google.android.gms.common.api.Api.zza<zzx, MessagesOptions> zzahd = new com.google.android.gms.common.api.Api.zza<zzx, MessagesOptions>() {
        public int getPriority() {
            return Strategy.TTL_SECONDS_INFINITE;
        }

        public zzx zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, MessagesOptions messagesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzx(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzg, messagesOptions);
        }
    };
    public static final zzy zzbyO = new zzy();

    static abstract class zza extends com.google.android.gms.internal.zzzv.zza<Status, zzx> {
        public zza(GoogleApiClient googleApiClient) {
            super(Nearby.MESSAGES_API, googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private zzy() {
    }

    private static List<Update> zzE(Intent intent) {
        return zzs.zzc(intent, "com.google.android.gms.nearby.messages.UPDATES");
    }

    static void zza(Iterable<Update> iterable, MessageListener messageListener) {
        for (Update update : iterable) {
            if (update.zzmj(1)) {
                messageListener.onFound(update.zzbyC);
            }
            if (update.zzmj(2)) {
                messageListener.onLost(update.zzbyC);
            }
            if (update.zzmj(4)) {
                messageListener.onDistanceChanged(update.zzbyC, update.zzbzj);
            }
            if (update.zzmj(8)) {
                messageListener.onBleSignalChanged(update.zzbyC, update.zzbzk);
            }
            if (update.zzmj(16)) {
                Message message = update.zzbyC;
                zzavp com_google_android_gms_internal_zzavp = update.zzbzl;
            }
        }
    }

    public PendingResult<Status> getPermissionStatus(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzx com_google_android_gms_nearby_messages_internal_zzx) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzx.zzt(this);
            }
        });
    }

    public void handleIntent(Intent intent, MessageListener messageListener) {
        zza(zzE(intent), messageListener);
    }

    public PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message) {
        return publish(googleApiClient, message, PublishOptions.DEFAULT);
    }

    public PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message, PublishOptions publishOptions) {
        zzac.zzw(message);
        zzac.zzw(publishOptions);
        final zzaaz zza = ((zzx) googleApiClient.zza(zzahc)).zza(googleApiClient, publishOptions.getCallback());
        final Message message2 = message;
        final PublishOptions publishOptions2 = publishOptions;
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzx com_google_android_gms_nearby_messages_internal_zzx) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzx.zza((zzb) this, zzv.zza(message2), zza, publishOptions2);
            }
        });
    }

    public PendingResult<Status> registerStatusCallback(GoogleApiClient googleApiClient, final StatusCallback statusCallback) {
        zzac.zzw(statusCallback);
        final zzaaz zza = ((zzx) googleApiClient.zza(zzahc)).zza(googleApiClient, statusCallback);
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzx com_google_android_gms_nearby_messages_internal_zzx) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzx.zza((zzb) this, zza, statusCallback);
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return subscribe(googleApiClient, pendingIntent, SubscribeOptions.DEFAULT);
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, PendingIntent pendingIntent, SubscribeOptions subscribeOptions) {
        zzac.zzw(pendingIntent);
        zzac.zzw(subscribeOptions);
        final zzaaz zza = ((zzx) googleApiClient.zza(zzahc)).zza(googleApiClient, subscribeOptions.getCallback());
        final PendingIntent pendingIntent2 = pendingIntent;
        final SubscribeOptions subscribeOptions2 = subscribeOptions;
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzx com_google_android_gms_nearby_messages_internal_zzx) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzx.zza((zzb) this, pendingIntent2, zza, subscribeOptions2);
            }
        });
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener) {
        return subscribe(googleApiClient, messageListener, SubscribeOptions.DEFAULT);
    }

    public PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, SubscribeOptions subscribeOptions) {
        zzac.zzw(messageListener);
        zzac.zzw(subscribeOptions);
        zzac.zzb(subscribeOptions.getStrategy().zzNf() == 0, (Object) "Strategy.setBackgroundScanMode() is only supported by background subscribe (the version which takes a PendingIntent).");
        final zzaaz zza = ((zzx) googleApiClient.zza(zzahc)).zza(googleApiClient, messageListener);
        final zzaaz zza2 = ((zzx) googleApiClient.zza(zzahc)).zza(googleApiClient, subscribeOptions.getCallback());
        final MessageListener messageListener2 = messageListener;
        final SubscribeOptions subscribeOptions2 = subscribeOptions;
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzx com_google_android_gms_nearby_messages_internal_zzx) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzx.zza(this, zza, messageListener2, zza2, subscribeOptions2, null);
            }
        });
    }

    public PendingResult<Status> unpublish(GoogleApiClient googleApiClient, final Message message) {
        zzac.zzw(message);
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzx com_google_android_gms_nearby_messages_internal_zzx) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzx.zza((zzb) this, zzv.zza(message));
            }
        });
    }

    public PendingResult<Status> unregisterStatusCallback(GoogleApiClient googleApiClient, final StatusCallback statusCallback) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzx com_google_android_gms_nearby_messages_internal_zzx) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzx.zza((zzb) this, statusCallback);
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final PendingIntent pendingIntent) {
        zzac.zzw(pendingIntent);
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzx com_google_android_gms_nearby_messages_internal_zzx) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzx.zza((zzb) this, pendingIntent);
            }
        });
    }

    public PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, final MessageListener messageListener) {
        zzac.zzw(messageListener);
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzx com_google_android_gms_nearby_messages_internal_zzx) throws RemoteException {
                com_google_android_gms_nearby_messages_internal_zzx.zza((zzb) this, messageListener);
            }
        });
    }
}
