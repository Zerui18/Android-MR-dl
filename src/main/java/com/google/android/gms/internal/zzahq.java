package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult;
import com.google.android.gms.drive.FileUploadPreferences;

public class zzahq implements DrivePreferencesApi {

    private abstract class zzc extends zzahj<FileUploadPreferencesResult> {
        final /* synthetic */ zzahq zzaMa;

        public zzc(zzahq com_google_android_gms_internal_zzahq, GoogleApiClient googleApiClient) {
            this.zzaMa = com_google_android_gms_internal_zzahq;
            super(googleApiClient);
        }

        protected FileUploadPreferencesResult zzR(Status status) {
            return new zzb(status, null);
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzR(status);
        }
    }

    private class zza extends zzagh {
        private final com.google.android.gms.internal.zzzv.zzb<FileUploadPreferencesResult> zzaFq;
        final /* synthetic */ zzahq zzaMa;

        private zza(zzahq com_google_android_gms_internal_zzahq, com.google.android.gms.internal.zzzv.zzb<FileUploadPreferencesResult> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult) {
            this.zzaMa = com_google_android_gms_internal_zzahq;
            this.zzaFq = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_drive_DrivePreferencesApi_FileUploadPreferencesResult;
        }

        public void onError(Status status) throws RemoteException {
            this.zzaFq.setResult(new zzb(status, null));
        }

        public void zza(zzaiw com_google_android_gms_internal_zzaiw) throws RemoteException {
            this.zzaFq.setResult(new zzb(Status.zzayh, com_google_android_gms_internal_zzaiw.zzAq()));
        }
    }

    private class zzb implements FileUploadPreferencesResult {
        private final FileUploadPreferences zzaMc;
        private final Status zzahq;

        private zzb(zzahq com_google_android_gms_internal_zzahq, Status status, FileUploadPreferences fileUploadPreferences) {
            this.zzahq = status;
            this.zzaMc = fileUploadPreferences;
        }

        public FileUploadPreferences getFileUploadPreferences() {
            return this.zzaMc;
        }

        public Status getStatus() {
            return this.zzahq;
        }
    }

    public PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new zzc(this, googleApiClient) {
            final /* synthetic */ zzahq zzaMa;

            protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                com_google_android_gms_internal_zzahk.zzAi().zzd(new zza(this));
            }
        });
    }

    public PendingResult<Status> setFileUploadPreferences(GoogleApiClient googleApiClient, FileUploadPreferences fileUploadPreferences) {
        if (fileUploadPreferences instanceof zzahy) {
            final zzahy com_google_android_gms_internal_zzahy = (zzahy) fileUploadPreferences;
            return googleApiClient.zzb(new com.google.android.gms.internal.zzahj.zza(this, googleApiClient) {
                protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                    com_google_android_gms_internal_zzahk.zzAi().zza(new zzakj(com_google_android_gms_internal_zzahy), new zzakp(this));
                }
            });
        }
        throw new IllegalArgumentException("Invalid preference value");
    }
}
