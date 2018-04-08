package com.google.android.gms.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzo;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.zzc;
import com.google.android.gms.drive.zzl;
import com.google.android.gms.internal.zzahj.zza;
import java.io.InputStream;
import java.io.OutputStream;

public class zzahl implements DriveContents {
    private boolean mClosed = false;
    private final zzc zzaLH;
    private boolean zzaLI = false;
    private boolean zzaLJ = false;

    public zzahl(zzc com_google_android_gms_drive_zzc) {
        this.zzaLH = (zzc) zzac.zzw(com_google_android_gms_drive_zzc);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        return zza(googleApiClient, metadataChangeSet, null);
    }

    public PendingResult<Status> commit(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, ExecutionOptions executionOptions) {
        return zza(googleApiClient, metadataChangeSet, executionOptions == null ? null : zzl.zzb(executionOptions));
    }

    public void discard(GoogleApiClient googleApiClient) {
        if (zzzD()) {
            throw new IllegalStateException("DriveContents already closed.");
        }
        zzzC();
        ((AnonymousClass4) googleApiClient.zzb(new zza(this, googleApiClient) {
            final /* synthetic */ zzahl zzaLK;

            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzagq(this.zzaLK.zzaLH.getRequestId(), false), new zzakp(this));
            }
        })).setResultCallback(new ResultCallback<Status>(this) {
            public /* synthetic */ void onResult(Result result) {
                zzp((Status) result);
            }

            public void zzp(Status status) {
                if (status.isSuccess()) {
                    zzahp.zzD("DriveContentsImpl", "Contents discarded");
                } else {
                    zzahp.zzF("DriveContentsImpl", "Error discarding contents");
                }
            }
        });
    }

    public DriveId getDriveId() {
        return this.zzaLH.getDriveId();
    }

    public InputStream getInputStream() {
        if (zzzD()) {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        } else if (this.zzaLH.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        } else if (this.zzaLI) {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else {
            this.zzaLI = true;
            return this.zzaLH.getInputStream();
        }
    }

    public int getMode() {
        return this.zzaLH.getMode();
    }

    public OutputStream getOutputStream() {
        if (zzzD()) {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else if (this.zzaLH.getMode() != DriveFile.MODE_WRITE_ONLY) {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        } else if (this.zzaLJ) {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else {
            this.zzaLJ = true;
            return this.zzaLH.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor() {
        if (!zzzD()) {
            return this.zzaLH.getParcelFileDescriptor();
        }
        throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
    }

    public PendingResult<DriveContentsResult> reopenForWrite(GoogleApiClient googleApiClient) {
        if (zzzD()) {
            throw new IllegalStateException("DriveContents already closed.");
        } else if (this.zzaLH.getMode() != DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else {
            zzzC();
            return googleApiClient.zza(new zzc(this, googleApiClient) {
                final /* synthetic */ zzahl zzaLK;

                protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                    com_google_android_gms_internal_zzahk.zzAi().zza(new zzajw(this.zzaLK.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzaLK.zzaLH.getRequestId()), new zzajy(this, null));
                }
            });
        }
    }

    public PendingResult<Status> zza(GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, zzl com_google_android_gms_drive_zzl) {
        final zzl com_google_android_gms_drive_zzl2 = com_google_android_gms_drive_zzl == null ? (zzl) new zzl.zza().build() : com_google_android_gms_drive_zzl;
        if (this.zzaLH.getMode() == DriveFile.MODE_READ_ONLY) {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        } else if (!ExecutionOptions.zzdX(com_google_android_gms_drive_zzl2.zzzH()) || this.zzaLH.zzzz()) {
            com_google_android_gms_drive_zzl2.zzh(googleApiClient);
            if (zzzD()) {
                throw new IllegalStateException("DriveContents already closed.");
            } else if (getDriveId() == null) {
                throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
            } else {
                if (metadataChangeSet == null) {
                    metadataChangeSet = MetadataChangeSet.zzaJN;
                }
                zzzC();
                return googleApiClient.zzb(new zza(this, googleApiClient) {
                    final /* synthetic */ zzahl zzaLK;

                    protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                        metadataChangeSet.zzzP().setContext(com_google_android_gms_internal_zzahk.getContext());
                        com_google_android_gms_internal_zzahk.zzAi().zza(new zzago(this.zzaLK.zzaLH.getDriveId(), metadataChangeSet.zzzP(), this.zzaLK.zzaLH.getRequestId(), this.zzaLK.zzaLH.zzzz(), com_google_android_gms_drive_zzl2), new zzakp(this));
                    }
                });
            }
        } else {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
    }

    public zzc zzzB() {
        return this.zzaLH;
    }

    public void zzzC() {
        zzo.zza(this.zzaLH.getParcelFileDescriptor());
        this.mClosed = true;
    }

    public boolean zzzD() {
        return this.mClosed;
    }
}
