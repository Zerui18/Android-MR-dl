package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.DriveResource.MetadataResult;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class zzahr implements DriveResource {
    protected final DriveId zzaJj;

    private abstract class zzd extends zzahj<MetadataResult> {
        private zzd(zzahr com_google_android_gms_internal_zzahr, GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public MetadataResult zzS(Status status) {
            return new zzc(status, null);
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzS(status);
        }
    }

    private static class zza extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<MetadataBufferResult> zzaFq;

        public zza(com.google.android.gms.internal.zzzv.zzb<MetadataBufferResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveApi_MetadataBufferResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zzg(status, null, false));
        }

        public void zza(zzaji com_google_android_gms_internal_zzaji) throws RemoteException {
            this.zzaFq.setResult(new zzg(Status.zzayh, new MetadataBuffer(com_google_android_gms_internal_zzaji.zzAw()), false));
        }
    }

    private static class zzb extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<MetadataResult> zzaFq;

        public zzb(com.google.android.gms.internal.zzzv.zzb<MetadataResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveResource_MetadataResult) {
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DriveResource_MetadataResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zzc(status, null));
        }

        public void zza(zzajl com_google_android_gms_internal_zzajl) throws RemoteException {
            this.zzaFq.setResult(new zzc(Status.zzayh, new zzahd(com_google_android_gms_internal_zzajl.zzAx())));
        }
    }

    private static class zzc implements MetadataResult {
        private final Metadata zzaMg;
        private final Status zzahq;

        public zzc(Status status, Metadata metadata) {
            this.zzahq = status;
            this.zzaMg = metadata;
        }

        public Metadata getMetadata() {
            return this.zzaMg;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    public zzahr(DriveId driveId) {
        this.zzaJj = driveId;
    }

    private PendingResult<MetadataResult> zza(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new zzd(this, googleApiClient) {
            final /* synthetic */ zzahr zzaMe;

            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzaie(this.zzaMe.zzaJj, z), new zzb(this));
            }
        });
    }

    public PendingResult<Status> addChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzahk) googleApiClient.zza(Drive.zzahc)).zza(googleApiClient, this.zzaJj, changeListener);
    }

    public PendingResult<Status> addChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzahk) googleApiClient.zza(Drive.zzahc)).zza(googleApiClient, this.zzaJj);
    }

    public PendingResult<Status> delete(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new com.google.android.gms.internal.zzahj.zza(this, googleApiClient) {
            final /* synthetic */ zzahr zzaMe;

            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzahe(this.zzaMe.zzaJj), new zzakp(this));
            }
        });
    }

    public DriveId getDriveId() {
        return this.zzaJj;
    }

    public PendingResult<MetadataResult> getMetadata(GoogleApiClient googleApiClient) {
        return zza(googleApiClient, false);
    }

    public PendingResult<MetadataBufferResult> listParents(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzh(this, googleApiClient) {
            final /* synthetic */ zzahr zzaMe;

            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzaio(this.zzaMe.zzaJj), new zza(this));
            }
        });
    }

    public PendingResult<Status> removeChangeListener(GoogleApiClient googleApiClient, ChangeListener changeListener) {
        return ((zzahk) googleApiClient.zza(Drive.zzahc)).zzb(googleApiClient, this.zzaJj, changeListener);
    }

    public PendingResult<Status> removeChangeSubscription(GoogleApiClient googleApiClient) {
        return ((zzahk) googleApiClient.zza(Drive.zzahc)).zzb(googleApiClient, this.zzaJj);
    }

    public PendingResult<Status> setParents(GoogleApiClient googleApiClient, Set<DriveId> set) {
        if (set == null) {
            throw new IllegalArgumentException("ParentIds must be provided.");
        }
        final List arrayList = new ArrayList(set);
        return googleApiClient.zzb(new com.google.android.gms.internal.zzahj.zza(this, googleApiClient) {
            final /* synthetic */ zzahr zzaMe;

            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzakn(this.zzaMe.zzaJj, arrayList), new zzakp(this));
            }
        });
    }

    public PendingResult<Status> trash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new com.google.android.gms.internal.zzahj.zza(this, googleApiClient) {
            final /* synthetic */ zzahr zzaMe;

            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzaku(this.zzaMe.zzaJj), new zzakp(this));
            }
        });
    }

    public PendingResult<Status> untrash(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new com.google.android.gms.internal.zzahj.zza(this, googleApiClient) {
            final /* synthetic */ zzahr zzaMe;

            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zza(new zzaky(this.zzaMe.zzaJj), new zzakp(this));
            }
        });
    }

    public PendingResult<MetadataResult> updateMetadata(GoogleApiClient googleApiClient, final MetadataChangeSet metadataChangeSet) {
        if (metadataChangeSet != null) {
            return googleApiClient.zzb(new zzd(this, googleApiClient) {
                final /* synthetic */ zzahr zzaMe;

                protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                    metadataChangeSet.zzzP().setContext(com_google_android_gms_internal_zzahk.getContext());
                    com_google_android_gms_internal_zzahk.zzAi().zza(new zzala(this.zzaMe.zzaJj, metadataChangeSet.zzzP()), new zzb(this));
                }
            });
        }
        throw new IllegalArgumentException("ChangeSet must be provided.");
    }
}
