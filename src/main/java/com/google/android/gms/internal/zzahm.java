package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.internal.zzaaz.zzc;

public class zzahm extends zzahr implements DriveFile {

    private static class zza implements DownloadProgressListener {
        private final zzaaz<DownloadProgressListener> zzaLP;

        public zza(zzaaz<DownloadProgressListener> com_google_android_gms_internal_zzaaz_com_google_android_gms_drive_DriveFile_DownloadProgressListener) {
            this.zzaLP = com_google_android_gms_internal_zzaaz_com_google_android_gms_drive_DriveFile_DownloadProgressListener;
        }

        public void onProgress(long j, long j2) {
            final long j3 = j;
            final long j4 = j2;
            this.zzaLP.zza(new zzc<DownloadProgressListener>(this) {
                public void zza(DownloadProgressListener downloadProgressListener) {
                    downloadProgressListener.onProgress(j3, j4);
                }

                public /* synthetic */ void zzs(Object obj) {
                    zza((DownloadProgressListener) obj);
                }

                public void zzvy() {
                }
            });
        }
    }

    public zzahm(DriveId driveId) {
        super(driveId);
    }

    private static DownloadProgressListener zza(GoogleApiClient googleApiClient, DownloadProgressListener downloadProgressListener) {
        return downloadProgressListener == null ? null : new zza(googleApiClient.zzr(downloadProgressListener));
    }

    public PendingResult<DriveContentsResult> open(GoogleApiClient googleApiClient, final int i, DownloadProgressListener downloadProgressListener) {
        if (i == DriveFile.MODE_READ_ONLY || i == DriveFile.MODE_WRITE_ONLY || i == DriveFile.MODE_READ_WRITE) {
            final DownloadProgressListener zza = zza(googleApiClient, downloadProgressListener);
            return googleApiClient.zza(new zzc(this, googleApiClient) {
                final /* synthetic */ zzahm zzaLO;

                protected void zza(zzahk com_google_android_gms_internal_zzahk) throws RemoteException {
                    zza(com_google_android_gms_internal_zzahk.zzAi().zza(new zzajw(this.zzaLO.getDriveId(), i, 0), new zzajy(this, zza)).zzAn());
                }
            });
        }
        throw new IllegalArgumentException("Invalid mode provided.");
    }
}
