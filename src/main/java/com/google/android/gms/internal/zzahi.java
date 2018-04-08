package com.google.android.gms.internal;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import com.google.android.gms.common.api.BooleanResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class zzahi implements DriveApi {

    static abstract class zzh extends zzahj<MetadataBufferResult> {
        zzh(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public MetadataBufferResult zzO(Status status) {
            return new zzg(status, null, false);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzO(status);
        }
    }

    static abstract class zzc extends zzahj<DriveContentsResult> {
        zzc(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveContentsResult zzM(Status status) {
            return new zzb(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzM(status);
        }
    }

    static abstract class zzf extends zzahj<DriveIdResult> {
        zzf(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DriveIdResult zzN(Status status) {
            return new zze(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzN(status);
        }
    }

    private static class zza extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<DriveContentsResult> zzaFq;

        public zza(com.google.android.gms.internal.zzzv.zzb<DriveContentsResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_DriveContentsResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zzb(status, null));
        }

        public void zza(zzaiu com_google_android_gms_internal_zzaiu) throws RemoteException {
            this.zzaFq.setResult(new zzb(Status.zzayh, new zzahl(com_google_android_gms_internal_zzaiu.zzAo())));
        }
    }

    static class zzb implements Releasable, DriveContentsResult {
        private final DriveContents zzaJm;
        private final Status zzahq;

        public zzb(Status status, DriveContents driveContents) {
            this.zzahq = status;
            this.zzaJm = driveContents;
        }

        public DriveContents getDriveContents() {
            return this.zzaJm;
        }

        public Status getStatus() {
            return this.zzahq;
        }

        public void release() {
            if (this.zzaJm != null) {
                this.zzaJm.zzzC();
            }
        }
    }

    static class zzd extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<DriveIdResult> zzaFq;

        public zzd(com.google.android.gms.internal.zzzv.zzb<DriveIdResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_DriveIdResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zze(status, null));
        }

        public void zza(zzaja com_google_android_gms_internal_zzaja) throws RemoteException {
            this.zzaFq.setResult(new zze(Status.zzayh, com_google_android_gms_internal_zzaja.getDriveId()));
        }

        public void zza(zzajl com_google_android_gms_internal_zzajl) throws RemoteException {
            this.zzaFq.setResult(new zze(Status.zzayh, new zzahd(com_google_android_gms_internal_zzajl.zzAx()).getDriveId()));
        }
    }

    private static class zze implements DriveIdResult {
        private final DriveId zzaJj;
        private final Status zzahq;

        public zze(Status status, DriveId driveId) {
            this.zzahq = status;
            this.zzaJj = driveId;
        }

        public DriveId getDriveId() {
            return this.zzaJj;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    static class zzg implements MetadataBufferResult {
        private final MetadataBuffer zzaLp;
        private final boolean zzaLq;
        private final Status zzahq;

        public zzg(Status status, MetadataBuffer metadataBuffer, boolean z) {
            this.zzahq = status;
            this.zzaLp = metadataBuffer;
            this.zzaLq = z;
        }

        public MetadataBuffer getMetadataBuffer() {
            return this.zzaLp;
        }

        public Status getStatus() {
            return this.zzahq;
        }

        public void release() {
            if (this.zzaLp != null) {
                this.zzaLp.release();
            }
        }
    }

    private static class zzi extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<MetadataBufferResult> zzaFq;

        public zzi(com.google.android.gms.internal.zzzv.zzb<MetadataBufferResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zzg(status, null, false));
        }

        public void zza(zzajg com_google_android_gms_internal_zzajg) throws RemoteException {
            this.zzaFq.setResult(new zzg(Status.zzayh, new MetadataBuffer(com_google_android_gms_internal_zzajg.zzAu()), com_google_android_gms_internal_zzajg.zzAv()));
        }
    }

    @SuppressLint({"MissingRemoteException"})
    static class zzj extends com.google.android.gms.internal.zzahj.zza {
        zzj(GoogleApiClient googleApiClient, Status status) {
            super(googleApiClient);
            zzb(status);
        }

        protected /* bridge */ /* synthetic */ void zza(com.google.android.gms.common.api.Api.zzb com_google_android_gms_common_api_Api_zzb) throws RemoteException {
        }
    }

    public PendingResult<Status> cancelPendingActions(GoogleApiClient googleApiClient, List<String> list) {
        return ((zzahk) googleApiClient.zza(Drive.zzahc)).cancelPendingActions(googleApiClient, list);
    }

    public PendingResult<DriveIdResult> fetchDriveId(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new zzf(this, googleApiClient) {
            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzaie(DriveId.zzdH(str), false), new zzd(this));
            }
        });
    }

    public DriveFolder getAppFolder(GoogleApiClient googleApiClient) {
        zzahk com_google_android_gms_internal_zzahk = (zzahk) googleApiClient.zza(Drive.zzahc);
        if (com_google_android_gms_internal_zzahk.zzAl()) {
            DriveId zzAk = com_google_android_gms_internal_zzahk.zzAk();
            return zzAk != null ? new zzaho(zzAk) : null;
        } else {
            throw new IllegalStateException("Client is not yet connected");
        }
    }

    public DriveFile getFile(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (googleApiClient.isConnected()) {
            return new zzahm(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getFolder(GoogleApiClient googleApiClient, DriveId driveId) {
        if (driveId == null) {
            throw new IllegalArgumentException("Id must be provided.");
        } else if (googleApiClient.isConnected()) {
            return new zzaho(driveId);
        } else {
            throw new IllegalStateException("Client must be connected");
        }
    }

    public DriveFolder getRootFolder(GoogleApiClient googleApiClient) {
        zzahk com_google_android_gms_internal_zzahk = (zzahk) googleApiClient.zza(Drive.zzahc);
        if (com_google_android_gms_internal_zzahk.zzAl()) {
            DriveId zzAj = com_google_android_gms_internal_zzahk.zzAj();
            return zzAj != null ? new zzaho(zzAj) : null;
        } else {
            throw new IllegalStateException("Client is not yet connected");
        }
    }

    public PendingResult<BooleanResult> isAutobackupEnabled(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzahj<BooleanResult>(this, googleApiClient) {
            protected BooleanResult zzL(Status status) {
                return new BooleanResult(status, false);
            }

            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zze(new zzagh(this) {
                    public void zzav(boolean z) {
                        this.zzb(new BooleanResult(Status.zzayh, z));
                    }
                });
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzL(status);
            }
        });
    }

    public CreateFileActivityBuilder newCreateFileActivityBuilder() {
        return new CreateFileActivityBuilder();
    }

    public PendingResult<DriveContentsResult> newDriveContents(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, DriveFile.MODE_WRITE_ONLY);
    }

    public OpenFileActivityBuilder newOpenFileActivityBuilder() {
        return new OpenFileActivityBuilder();
    }

    public PendingResult<MetadataBufferResult> query(GoogleApiClient googleApiClient, final Query query) {
        if (query != null) {
            return googleApiClient.zza(new zzh(this, googleApiClient) {
                protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                    com_google_android_gms_internal_zzahk.zzAi().zza(new zzakd(query), new zzi(this));
                }
            });
        }
        throw new IllegalArgumentException("Query must be provided.");
    }

    public PendingResult<Status> requestSync(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new com.google.android.gms.internal.zzahj.zza(this, googleApiClient) {
            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzakp(this));
            }
        });
    }

    public PendingResult<DriveContentsResult> zzb(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzagu(i), new zza(this));
            }
        });
    }
}
