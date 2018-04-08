package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Process;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.util.zzx;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.DriveEventService;
import com.google.android.gms.drive.events.zzd;
import com.google.android.gms.drive.events.zzi;
import com.google.android.gms.internal.zzahj.zza;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzahk extends zzl<zzaik> {
    final Map<DriveId, Map<Object, zzahv>> zzaLA = new HashMap();
    private final Bundle zzaLr;
    private final boolean zzaLs;
    private volatile DriveId zzaLt;
    private volatile DriveId zzaLu;
    private volatile boolean zzaLv = false;
    final ConnectionCallbacks zzaLw;
    final Map<DriveId, Map<ChangeListener, zzahv>> zzaLx = new HashMap();
    final Map<zzd, zzahv> zzaLy = new HashMap();
    final Map<DriveId, Map<Object, zzahv>> zzaLz = new HashMap();
    private final String zzahp;

    public zzahk(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, Bundle bundle) {
        super(context, looper, 11, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.zzahp = com_google_android_gms_common_internal_zzg.zzxh();
        this.zzaLw = connectionCallbacks;
        this.zzaLr = bundle;
        Intent intent = new Intent(DriveEventService.ACTION_HANDLE_EVENT);
        intent.setPackage(context.getPackageName());
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        String valueOf;
        switch (queryIntentServices.size()) {
            case 0:
                this.zzaLs = false;
                return;
            case 1:
                ServiceInfo serviceInfo = ((ResolveInfo) queryIntentServices.get(0)).serviceInfo;
                if (serviceInfo.exported) {
                    this.zzaLs = true;
                    return;
                } else {
                    valueOf = String.valueOf(serviceInfo.name);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 60).append("Drive event service ").append(valueOf).append(" must be exported in AndroidManifest.xml").toString());
                }
            default:
                valueOf = String.valueOf(intent.getAction());
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 72).append("AndroidManifest.xml can only define one service that handles the ").append(valueOf).append(" action").toString());
        }
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final int i, final DriveId driveId) {
        zzac.zzas(zzi.zza(i, driveId));
        zzac.zza(isConnected(), (Object) "Client must be connected");
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzakf(driveId, i), null, null, new zzakp(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final zzagb com_google_android_gms_internal_zzagb) {
        zzac.zzas(zzi.zza(com_google_android_gms_internal_zzagb.getEventType(), com_google_android_gms_internal_zzagb.getDriveId()));
        zzac.zza(isConnected(), (Object) "Client must be connected");
        if (this.zzaLs) {
            return googleApiClient.zzb(new zza(this, googleApiClient) {
                protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                    com_google_android_gms_internal_zzahk.zzAi().zza(com_google_android_gms_internal_zzagb, null, null, new zzakp(this));
                }
            });
        }
        throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final zzagb com_google_android_gms_internal_zzagb, final zzahv com_google_android_gms_internal_zzahv) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(com_google_android_gms_internal_zzagb, com_google_android_gms_internal_zzahv, null, new zzakp(this));
            }
        });
    }

    private PendingResult<Status> zza(GoogleApiClient googleApiClient, final zzakf com_google_android_gms_internal_zzakf, final zzahv com_google_android_gms_internal_zzahv) {
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(com_google_android_gms_internal_zzakf, com_google_android_gms_internal_zzahv, null, new zzakp(this));
            }
        });
    }

    PendingResult<Status> cancelPendingActions(GoogleApiClient googleApiClient, final List<String> list) {
        boolean z = true;
        zzac.zzas(list != null);
        if (list.isEmpty()) {
            z = false;
        }
        zzac.zzas(z);
        zzac.zza(isConnected(), (Object) "Client must be connected");
        return googleApiClient.zzb(new zza(this, googleApiClient) {
            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzagi(list), new zzakp(this));
            }
        });
    }

    public void disconnect() {
        if (isConnected()) {
            try {
                ((zzaik) zzwW()).zza(new zzahg());
            } catch (RemoteException e) {
            }
        }
        super.disconnect();
        synchronized (this.zzaLx) {
            this.zzaLx.clear();
        }
        synchronized (this.zzaLy) {
            this.zzaLy.clear();
        }
        synchronized (this.zzaLz) {
            this.zzaLz.clear();
        }
        synchronized (this.zzaLA) {
            this.zzaLA.clear();
        }
    }

    boolean zzAh() {
        return zzx.zzf(getContext(), Process.myUid());
    }

    public zzaik zzAi() throws DeadObjectException {
        return (zzaik) zzwW();
    }

    public DriveId zzAj() {
        return this.zzaLt;
    }

    public DriveId zzAk() {
        return this.zzaLu;
    }

    public boolean zzAl() {
        return this.zzaLv;
    }

    public boolean zzAm() {
        return this.zzaLs;
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, new zzagb(1, driveId));
    }

    PendingResult<Status> zza(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> com_google_android_gms_internal_zzahi_zzj;
        zzac.zzas(zzi.zza(1, driveId));
        zzac.zzb((Object) changeListener, (Object) "listener");
        zzac.zza(isConnected(), (Object) "Client must be connected");
        synchronized (this.zzaLx) {
            Map map;
            Map map2 = (Map) this.zzaLx.get(driveId);
            if (map2 == null) {
                HashMap hashMap = new HashMap();
                this.zzaLx.put(driveId, hashMap);
                map = hashMap;
            } else {
                map = map2;
            }
            zzahv com_google_android_gms_internal_zzahv = (zzahv) map.get(changeListener);
            if (com_google_android_gms_internal_zzahv == null) {
                com_google_android_gms_internal_zzahv = new zzahv(getLooper(), getContext(), 1, changeListener);
                map.put(changeListener, com_google_android_gms_internal_zzahv);
            } else if (com_google_android_gms_internal_zzahv.zzeI(1)) {
                com_google_android_gms_internal_zzahi_zzj = new zzj(googleApiClient, Status.zzayh);
            }
            com_google_android_gms_internal_zzahv.zzeH(1);
            com_google_android_gms_internal_zzahi_zzj = zza(googleApiClient, new zzagb(1, driveId), com_google_android_gms_internal_zzahv);
        }
        return com_google_android_gms_internal_zzahi_zzj;
    }

    protected void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        if (bundle != null) {
            bundle.setClassLoader(getClass().getClassLoader());
            this.zzaLt = (DriveId) bundle.getParcelable("com.google.android.gms.drive.root_id");
            this.zzaLu = (DriveId) bundle.getParcelable("com.google.android.gms.drive.appdata_id");
            this.zzaLv = true;
        }
        super.zza(i, iBinder, bundle, i2);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId) {
        return zza(googleApiClient, 1, driveId);
    }

    PendingResult<Status> zzb(GoogleApiClient googleApiClient, DriveId driveId, ChangeListener changeListener) {
        PendingResult<Status> com_google_android_gms_internal_zzahi_zzj;
        zzac.zzas(zzi.zza(1, driveId));
        zzac.zza(isConnected(), (Object) "Client must be connected");
        zzac.zzb((Object) changeListener, (Object) "listener");
        synchronized (this.zzaLx) {
            Map map = (Map) this.zzaLx.get(driveId);
            if (map == null) {
                com_google_android_gms_internal_zzahi_zzj = new zzj(googleApiClient, Status.zzayh);
            } else {
                zzahv com_google_android_gms_internal_zzahv = (zzahv) map.remove(changeListener);
                if (com_google_android_gms_internal_zzahv == null) {
                    com_google_android_gms_internal_zzahi_zzj = new zzj(googleApiClient, Status.zzayh);
                } else {
                    if (map.isEmpty()) {
                        this.zzaLx.remove(driveId);
                    }
                    com_google_android_gms_internal_zzahi_zzj = zza(googleApiClient, new zzakf(driveId, 1), com_google_android_gms_internal_zzahv);
                }
            }
        }
        return com_google_android_gms_internal_zzahi_zzj;
    }

    protected zzaik zzbK(IBinder iBinder) {
        return zzaik.zza.zzbL(iBinder);
    }

    protected String zzeu() {
        return "com.google.android.gms.drive.ApiService.START";
    }

    protected String zzev() {
        return "com.google.android.gms.drive.internal.IDriveService";
    }

    protected /* synthetic */ IInterface zzh(IBinder iBinder) {
        return zzbK(iBinder);
    }

    public boolean zzqD() {
        return (getContext().getPackageName().equals(this.zzahp) && zzAh()) ? false : true;
    }

    protected Bundle zzql() {
        String packageName = getContext().getPackageName();
        zzac.zzw(packageName);
        zzac.zzar(!zzxp().zzxf().isEmpty());
        Bundle bundle = new Bundle();
        if (!packageName.equals(this.zzahp)) {
            bundle.putString("proxy_package_name", this.zzahp);
        }
        bundle.putAll(this.zzaLr);
        return bundle;
    }

    public boolean zzwX() {
        return true;
    }
}
