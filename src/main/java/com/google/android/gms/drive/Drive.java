package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.internal.zzahi;
import com.google.android.gms.internal.zzahk;
import com.google.android.gms.internal.zzahn;
import com.google.android.gms.internal.zzahq;
import com.google.android.gms.internal.zzahs;

public final class Drive {
    public static final Api<NoOptions> API = new Api("Drive.API", new zza<NoOptions>() {
        protected Bundle zza(NoOptions noOptions) {
            return new Bundle();
        }
    }, zzahc);
    public static final DriveApi DriveApi = new zzahi();
    public static final DrivePreferencesApi DrivePreferencesApi = new zzahq();
    public static final Scope SCOPE_APPFOLDER = new Scope(Scopes.DRIVE_APPFOLDER);
    public static final Scope SCOPE_FILE = new Scope(Scopes.DRIVE_FILE);
    public static final Scope zzaJo = new Scope("https://www.googleapis.com/auth/drive");
    public static final Scope zzaJp = new Scope("https://www.googleapis.com/auth/drive.apps");
    public static final Api<zzb> zzaJq = new Api("Drive.INTERNAL_API", new zza<zzb>() {
        protected Bundle zza(zzb com_google_android_gms_drive_Drive_zzb) {
            return com_google_android_gms_drive_Drive_zzb == null ? new Bundle() : com_google_android_gms_drive_Drive_zzb.zzzA();
        }
    }, zzahc);
    public static final zzg zzaJr = new zzahn();
    public static final zzi zzaJs = new zzahs();
    public static final zzf<zzahk> zzahc = new zzf();

    public static abstract class zza<O extends ApiOptions> extends com.google.android.gms.common.api.Api.zza<zzahk, O> {
        protected abstract Bundle zza(O o);

        public zzahk zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, O o, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzahk(context, looper, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener, zza(o));
        }
    }

    public static class zzb implements Optional {
        private final Bundle zzahb;

        public Bundle zzzA() {
            return this.zzahb;
        }
    }

    private Drive() {
    }
}
