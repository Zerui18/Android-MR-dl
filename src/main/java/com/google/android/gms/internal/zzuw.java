package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.Auth.AuthCredentialsOptions;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialRequest;
import com.google.android.gms.auth.api.credentials.CredentialRequestResult;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzzv.zzb;

public final class zzuw implements CredentialsApi {

    private static class zza extends zzus {
        private zzb<Status> zzaiL;

        zza(zzb<Status> com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status) {
            this.zzaiL = com_google_android_gms_internal_zzzv_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzh(Status status) {
            this.zzaiL.setResult(status);
        }
    }

    private AuthCredentialsOptions zza(GoogleApiClient googleApiClient) {
        return ((zzuz) googleApiClient.zza(Auth.zzahR)).zzqC();
    }

    public PendingResult<Status> delete(GoogleApiClient googleApiClient, final Credential credential) {
        return googleApiClient.zzb(new zzux<Status>(this, googleApiClient) {
            protected void zza(Context context, zzvf com_google_android_gms_internal_zzvf) throws RemoteException {
                com_google_android_gms_internal_zzvf.zza(new zza(this), new zzva(credential));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingResult<Status> disableAutoSignIn(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new zzux<Status>(this, googleApiClient) {
            protected void zza(Context context, zzvf com_google_android_gms_internal_zzvf) throws RemoteException {
                com_google_android_gms_internal_zzvf.zza(new zza(this));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }

    public PendingIntent getHintPickerIntent(GoogleApiClient googleApiClient, HintRequest hintRequest) {
        zzac.zzb(googleApiClient.zza(Auth.CREDENTIALS_API), (Object) "Auth.CREDENTIALS_API must be added to GoogleApiClient to use this API");
        return zzuy.zza(googleApiClient.getContext(), zza(googleApiClient), hintRequest);
    }

    public PendingResult<CredentialRequestResult> request(GoogleApiClient googleApiClient, final CredentialRequest credentialRequest) {
        return googleApiClient.zza(new zzux<CredentialRequestResult>(this, googleApiClient) {
            protected void zza(Context context, zzvf com_google_android_gms_internal_zzvf) throws RemoteException {
                com_google_android_gms_internal_zzvf.zza(new zzus(this) {
                    final /* synthetic */ AnonymousClass1 zzaiJ;

                    {
                        this.zzaiJ = r1;
                    }

                    public void zza(Status status, Credential credential) {
                        this.zzaiJ.zzb(new zzuv(status, credential));
                    }

                    public void zzh(Status status) {
                        this.zzaiJ.zzb(zzuv.zzi(status));
                    }
                }, credentialRequest);
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzj(status);
            }

            protected CredentialRequestResult zzj(Status status) {
                return zzuv.zzi(status);
            }
        });
    }

    public PendingResult<Status> save(GoogleApiClient googleApiClient, final Credential credential) {
        return googleApiClient.zzb(new zzux<Status>(this, googleApiClient) {
            protected void zza(Context context, zzvf com_google_android_gms_internal_zzvf) throws RemoteException {
                com_google_android_gms_internal_zzvf.zza(new zza(this), new zzvg(credential));
            }

            protected Status zzb(Status status) {
                return status;
            }

            protected /* synthetic */ Result zzc(Status status) {
                return zzb(status);
            }
        });
    }
}
