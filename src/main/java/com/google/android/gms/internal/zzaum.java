package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;

public class zzaum implements zzaui {
    public static final zzf<zzaul> zzahc = new zzf();
    public static final zza<zzaul, NoOptions> zzahd = new zza<zzaul, NoOptions>() {
        public /* synthetic */ zze zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, Object obj, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return zzr(context, looper, com_google_android_gms_common_internal_zzg, (NoOptions) obj, connectionCallbacks, onConnectionFailedListener);
        }

        public zzaul zzr(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, NoOptions noOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new zzaul(context, looper, connectionCallbacks, onConnectionFailedListener, com_google_android_gms_common_internal_zzg);
        }
    };
}