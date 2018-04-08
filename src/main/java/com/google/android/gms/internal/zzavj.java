package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.nearby.connection.AppMetadata;
import com.google.android.gms.nearby.connection.Connections.ConnectionRequestListener;
import com.google.android.gms.nearby.connection.Connections.ConnectionResponseCallback;
import com.google.android.gms.nearby.connection.Connections.EndpointDiscoveryListener;
import com.google.android.gms.nearby.connection.Connections.MessageListener;
import com.google.android.gms.nearby.connection.Connections.StartAdvertisingResult;

public final class zzavj extends zzl<zzavm> {
    private final long zzaYW = ((long) hashCode());

    private static class zzb extends zzavi {
        private final zzaaz<MessageListener> zzbwV;

        zzb(zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            this.zzbwV = com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener;
        }

        public void onDisconnected(final String str) throws RemoteException {
            this.zzbwV.zza(new com.google.android.gms.internal.zzaaz.zzc<MessageListener>(this) {
                public void zza(MessageListener messageListener) {
                    messageListener.onDisconnected(str);
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((MessageListener) obj);
                }

                public void zzvy() {
                }
            });
        }

        public void onMessageReceived(final String str, final byte[] bArr, final boolean z) throws RemoteException {
            this.zzbwV.zza(new com.google.android.gms.internal.zzaaz.zzc<MessageListener>(this) {
                public void zza(MessageListener messageListener) {
                    messageListener.onMessageReceived(str, bArr, z);
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((MessageListener) obj);
                }

                public void zzvy() {
                }
            });
        }
    }

    private static final class zza extends zzb {
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaFq;

        public zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzaFq = (com.google.android.gms.internal.zzzv.zzb) zzac.zzw(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status);
        }

        public void zzlH(int i) throws RemoteException {
            this.zzaFq.setResult(new Status(i));
        }
    }

    private static class zzc extends zzavi {
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaUb;

        zzc(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaUb = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzlI(int i) throws RemoteException {
            this.zzaUb.setResult(new Status(i));
        }
    }

    private static final class zzd extends zzb {
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaFq;
        private final zzaaz<ConnectionResponseCallback> zzbwZ;

        public zzd(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzaaz<ConnectionResponseCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) {
            super(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener);
            this.zzaFq = (com.google.android.gms.internal.zzzv.zzb) zzac.zzw(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status);
            this.zzbwZ = (zzaaz) zzac.zzw(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback);
        }

        public void zza(final String str, final int i, final byte[] bArr) throws RemoteException {
            this.zzbwZ.zza(new com.google.android.gms.internal.zzaaz.zzc<ConnectionResponseCallback>(this) {
                public void zza(ConnectionResponseCallback connectionResponseCallback) {
                    connectionResponseCallback.onConnectionResponse(str, new Status(i), bArr);
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((ConnectionResponseCallback) obj);
                }

                public void zzvy() {
                }
            });
        }

        public void zzlG(int i) throws RemoteException {
            this.zzaFq.setResult(new Status(i));
        }
    }

    private static final class zze extends zzavi {
        private final zzaaz<ConnectionRequestListener> zzaBG;
        private final com.google.android.gms.internal.zzzv.zzb<StartAdvertisingResult> zzaFq;

        zze(com.google.android.gms.internal.zzzv.zzb<StartAdvertisingResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, zzaaz<ConnectionRequestListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) {
            this.zzaFq = (com.google.android.gms.internal.zzzv.zzb) zzac.zzw(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult);
            this.zzaBG = (zzaaz) zzac.zzw(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener);
        }

        public void onConnectionRequest(String str, String str2, String str3, byte[] bArr) throws RemoteException {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            final byte[] bArr2 = bArr;
            this.zzaBG.zza(new com.google.android.gms.internal.zzaaz.zzc<ConnectionRequestListener>(this) {
                public void zza(ConnectionRequestListener connectionRequestListener) {
                    connectionRequestListener.onConnectionRequest(str4, str5, str6, bArr2);
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((ConnectionRequestListener) obj);
                }

                public void zzvy() {
                }
            });
        }

        public void zzo(int i, String str) throws RemoteException {
            this.zzaFq.setResult(new zzf(new Status(i), str));
        }
    }

    private static final class zzf implements StartAdvertisingResult {
        private final Status zzahq;
        private final String zzbxc;

        zzf(Status status, String str) {
            this.zzahq = status;
            this.zzbxc = str;
        }

        public String getLocalEndpointName() {
            return this.zzbxc;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    private static final class zzg extends zzavi {
        private final zzaaz<EndpointDiscoveryListener> zzaBG;
        private final com.google.android.gms.internal.zzzv.zzb<Status> zzaFq;

        zzg(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, zzaaz<EndpointDiscoveryListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) {
            this.zzaFq = (com.google.android.gms.internal.zzzv.zzb) zzac.zzw(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status);
            this.zzaBG = (zzaaz) zzac.zzw(com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener);
        }

        public void onEndpointFound(String str, String str2, String str3, String str4) throws RemoteException {
            final String str5 = str;
            final String str6 = str2;
            final String str7 = str3;
            final String str8 = str4;
            this.zzaBG.zza(new com.google.android.gms.internal.zzaaz.zzc<EndpointDiscoveryListener>(this) {
                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointFound(str5, str6, str7, str8);
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }

                public void zzvy() {
                }
            });
        }

        public void onEndpointLost(final String str) throws RemoteException {
            this.zzaBG.zza(new com.google.android.gms.internal.zzaaz.zzc<EndpointDiscoveryListener>(this) {
                public void zza(EndpointDiscoveryListener endpointDiscoveryListener) {
                    endpointDiscoveryListener.onEndpointLost(str);
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((EndpointDiscoveryListener) obj);
                }

                public void zzvy() {
                }
            });
        }

        public void zzlF(int i) throws RemoteException {
            this.zzaFq.setResult(new Status(i));
        }
    }

    public zzavj(Context context, Looper looper, com.google.android.gms.common.internal.zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 54, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzavm) zzwW()).zzM(this.zzaYW);
            } catch (Throwable e) {
                Log.w("NearbyConnectionsClient", "Failed to notify client disconnect.", e);
            }
        }
        super.disconnect();
    }

    public String zzMT() {
        try {
            return ((zzavm) zzwW()).zzat(this.zzaYW);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public String zzMU() {
        try {
            return ((zzavm) zzwW()).zzMU();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public void zzMV() {
        try {
            ((zzavm) zzwW()).zzar(this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop advertising", e);
        }
    }

    public void zzMW() {
        try {
            ((zzavm) zzwW()).zzas(this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop all endpoints", e);
        }
    }

    public void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, String str, long j, zzaaz<EndpointDiscoveryListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener) throws RemoteException {
        ((zzavm) zzwW()).zza(new zzg(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_EndpointDiscoveryListener), str, j, this.zzaYW);
    }

    public void zza(com.google.android.gms.internal.zzzv.zzb<StartAdvertisingResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, String str, AppMetadata appMetadata, long j, zzaaz<ConnectionRequestListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener) throws RemoteException {
        ((zzavm) zzwW()).zza(new zze(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_nearby_connection_Connections_StartAdvertisingResult, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionRequestListener), str, appMetadata, j, this.zzaYW);
    }

    public void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, String str, String str2, byte[] bArr, zzaaz<ConnectionResponseCallback> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzavm) zzwW()).zza(new zzd(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_ConnectionResponseCallback, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener), str, str2, bArr, this.zzaYW);
    }

    public void zza(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, String str, byte[] bArr, zzaaz<MessageListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener) throws RemoteException {
        ((zzavm) zzwW()).zza(new zza(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, com_google_android_gms_internal_zzaaz_com_google_android_gms_nearby_connection_Connections_MessageListener), str, bArr, this.zzaYW);
    }

    public void zza(String[] strArr, byte[] bArr) {
        try {
            ((zzavm) zzwW()).zza(strArr, bArr, this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send reliable message", e);
        }
    }

    public void zzb(String[] strArr, byte[] bArr) {
        try {
            ((zzavm) zzwW()).zzb(strArr, bArr, this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't send unreliable message", e);
        }
    }

    protected String zzeu() {
        return "com.google.android.gms.nearby.connection.service.START";
    }

    protected String zzev() {
        return "com.google.android.gms.nearby.internal.connection.INearbyConnectionService";
    }

    protected zzavm zzez(IBinder iBinder) {
        return com.google.android.gms.internal.zzavm.zza.zzeB(iBinder);
    }

    public void zzgn(String str) {
        try {
            ((zzavm) zzwW()).zzk(str, this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't stop discovery", e);
        }
    }

    public void zzgo(String str) {
        try {
            ((zzavm) zzwW()).zzl(str, this.zzaYW);
        } catch (Throwable e) {
            Log.w("NearbyConnectionsClient", "Couldn't disconnect from endpoint", e);
        }
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzez(iBinder);
    }

    protected Bundle zzql() {
        Bundle bundle = new Bundle();
        bundle.putLong("clientId", this.zzaYW);
        return bundle;
    }

    public void zzt(com.google.android.gms.internal.zzzv.zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status, String str) throws RemoteException {
        ((zzavm) zzwW()).zza(new zzc(com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status), str, this.zzaYW);
    }
}
