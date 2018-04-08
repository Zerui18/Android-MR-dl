package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.nearby.Nearby;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;
import java.util.List;

public final class zzavk implements Connections {
    public static final zzf<zzavj> zzahc = new zzf();
    public static final com.google.android.gms.common.api.Api.zza<zzavj, NoOptions> zzahd = new com.google.android.gms.common.api.Api.zza<zzavj, NoOptions>() {
        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzs(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzavj zzs(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzavj(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        }
    };

    private static abstract class zza<R extends Result> extends com.google.android.gms.internal.zzzv.zza<R, zzavj> {
        public zza(GoogleApiClient googleApiClient) {
            super(Nearby.CONNECTIONS_API, googleApiClient);
        }
    }

    private static abstract class zzb extends zza<StartAdvertisingResult> {
        private zzb(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public StartAdvertisingResult zzbx(final Status status) {
            return new StartAdvertisingResult(this) {
                public String getLocalEndpointName() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbx(status);
        }
    }

    private static abstract class zzc extends zza<Status> {
        private zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public static zzavj zzd(GoogleApiClient googleApiClient, boolean z) {
        zzac.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzac.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zze(googleApiClient, z);
    }

    public static zzavj zze(GoogleApiClient googleApiClient, boolean z) {
        zzac.zza(googleApiClient.zza(Nearby.CONNECTIONS_API), (Object) "GoogleApiClient is not configured to use the Nearby Connections Api. Pass Nearby.CONNECTIONS_API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (zzavj) googleApiClient.zza(zzahc) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Nearby.CONNECTIONS_API and is not connected to Nearby Connections. Use GoogleApiClient.hasConnectedApi(Nearby.CONNECTIONS_API) to guard this call.");
        }
    }

    public PendingResult<Status> acceptConnectionRequest(GoogleApiClient googleApiClient, String str, byte[] bArr, MessageListener messageListener) {
        final zzaaz zzr = googleApiClient.zzr(messageListener);
        final String str2 = str;
        final byte[] bArr2 = bArr;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
                com_google_android_gms_internal_zzavj.zza((com.google.android.gms.internal.zzzv.zzb) this, str2, bArr2, zzr);
            }
        });
    }

    public void disconnectFromEndpoint(GoogleApiClient googleApiClient, String str) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzgo(str);
        }
    }

    public String getLocalDeviceId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzMU();
    }

    public String getLocalEndpointId(GoogleApiClient googleApiClient) {
        return zzd(googleApiClient, true).zzMT();
    }

    public PendingResult<Status> rejectConnectionRequest(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
                com_google_android_gms_internal_zzavj.zzt(this, str);
            }
        });
    }

    public PendingResult<Status> sendConnectionRequest(GoogleApiClient googleApiClient, String str, String str2, byte[] bArr, ConnectionResponseCallback connectionResponseCallback, MessageListener messageListener) {
        final zzaaz zzr = googleApiClient.zzr(connectionResponseCallback);
        final zzaaz zzr2 = googleApiClient.zzr(messageListener);
        final String str3 = str;
        final String str4 = str2;
        final byte[] bArr2 = bArr;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
                com_google_android_gms_internal_zzavj.zza(this, str3, str4, bArr2, zzr, zzr2);
            }
        });
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zza(new String[]{str}, bArr);
        }
    }

    public void sendReliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zza((String[]) list.toArray(new String[0]), bArr);
        }
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, String str, byte[] bArr) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzb(new String[]{str}, bArr);
        }
    }

    public void sendUnreliableMessage(GoogleApiClient googleApiClient, List<String> list, byte[] bArr) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzb((String[]) list.toArray(new String[0]), bArr);
        }
    }

    public PendingResult<StartAdvertisingResult> startAdvertising(GoogleApiClient googleApiClient, String str, AppMetadata appMetadata, long j, ConnectionRequestListener connectionRequestListener) {
        final zzaaz zzr = googleApiClient.zzr(connectionRequestListener);
        final String str2 = str;
        final AppMetadata appMetadata2 = appMetadata;
        final long j2 = j;
        return googleApiClient.zzb(new zzb(this, googleApiClient) {
            protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
                com_google_android_gms_internal_zzavj.zza(this, str2, appMetadata2, j2, zzr);
            }
        });
    }

    public PendingResult<Status> startDiscovery(GoogleApiClient googleApiClient, String str, long j, EndpointDiscoveryListener endpointDiscoveryListener) {
        final zzaaz zzr = googleApiClient.zzr(endpointDiscoveryListener);
        final String str2 = str;
        final long j2 = j;
        return googleApiClient.zzb(new zzc(this, googleApiClient) {
            protected void zza(zzavj com_google_android_gms_internal_zzavj) throws RemoteException {
                com_google_android_gms_internal_zzavj.zza((com.google.android.gms.internal.zzzv.zzb) this, str2, j2, zzr);
            }
        });
    }

    public void stopAdvertising(GoogleApiClient googleApiClient) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzMV();
        }
    }

    public void stopAllEndpoints(GoogleApiClient googleApiClient) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzMW();
        }
    }

    public void stopDiscovery(GoogleApiClient googleApiClient, String str) {
        zzavj zzd = zzd(googleApiClient, false);
        if (zzd != null) {
            zzd.zzgn(str);
        }
    }
}
