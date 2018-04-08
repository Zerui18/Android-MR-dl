package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Games.StatusImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.video.CaptureState;
import com.google.android.gms.games.video.VideoCapabilities;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.games.video.Videos.CaptureAvailableResult;
import com.google.android.gms.games.video.Videos.CaptureCapabilitiesResult;
import com.google.android.gms.games.video.Videos.CaptureOverlayStateListener;
import com.google.android.gms.games.video.Videos.CaptureStateResult;
import com.google.android.gms.games.video.Videos.CaptureStoppedResult;
import com.google.android.gms.games.video.Videos.CaptureStreamingAvailabilityResult;
import com.google.android.gms.games.video.Videos.CaptureStreamingMetadataResult;
import com.google.android.gms.games.video.Videos.CaptureStreamingUrlResult;
import com.google.android.gms.games.video.Videos.ListVideosResult;
import com.google.android.gms.internal.zzzv.zzb;

public final class VideosImpl implements Videos {

    private static abstract class CaptureStopImpl extends BaseGamesApiMethodImpl<CaptureStoppedResult> {
        public CaptureStoppedResult zzbi(final Status status) {
            return new CaptureStoppedResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbi(status);
        }
    }

    class AnonymousClass10 extends CaptureStopImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzq(this);
        }
    }

    private static abstract class CaptureStreamingMetadataImpl extends BaseGamesApiMethodImpl<CaptureStreamingMetadataResult> {
        public CaptureStreamingMetadataResult zzbk(final Status status) {
            return new CaptureStreamingMetadataResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbk(status);
        }
    }

    class AnonymousClass11 extends CaptureStreamingMetadataImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl(this);
        }
    }

    private static abstract class CaptureStreamingUrlImpl extends BaseGamesApiMethodImpl<CaptureStreamingUrlResult> {
        public CaptureStreamingUrlResult zzbl(final Status status) {
            return new CaptureStreamingUrlResult(this) {
                public Status getStatus() {
                    return status;
                }

                public String getUrl() {
                    return null;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbl(status);
        }
    }

    class AnonymousClass12 extends CaptureStreamingUrlImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzm(this);
        }
    }

    class AnonymousClass13 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((BaseGamesApiMethodImpl) this, null, null);
        }
    }

    private static abstract class ListVideosImpl extends BaseGamesApiMethodImpl<ListVideosResult> {
        public ListVideosResult zzbm(final Status status) {
            return new ListVideosResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbm(status);
        }
    }

    class AnonymousClass14 extends ListVideosImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, null, 0);
        }
    }

    class AnonymousClass15 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, null, false);
        }
    }

    private static abstract class CaptureCapabilitiesImpl extends BaseGamesApiMethodImpl<CaptureCapabilitiesResult> {
        private CaptureCapabilitiesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CaptureCapabilitiesResult zzbg(final Status status) {
            return new CaptureCapabilitiesResult(this) {
                public VideoCapabilities getCapabilities() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbg(status);
        }
    }

    private static abstract class CaptureStateImpl extends BaseGamesApiMethodImpl<CaptureStateResult> {
        private CaptureStateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CaptureStateResult zzbh(final Status status) {
            return new CaptureStateResult(this) {
                public CaptureState getCaptureState() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbh(status);
        }
    }

    private static abstract class CaptureStreamingAvailabilityImpl extends BaseGamesApiMethodImpl<CaptureStreamingAvailabilityResult> {
        public CaptureStreamingAvailabilityResult zzbj(final Status status) {
            return new CaptureStreamingAvailabilityResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbj(status);
        }
    }

    class AnonymousClass3 extends CaptureStreamingAvailabilityImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk(this);
        }
    }

    class AnonymousClass4 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this);
        }
    }

    private static abstract class CaptureAvailableImpl extends BaseGamesApiMethodImpl<CaptureAvailableResult> {
        private CaptureAvailableImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CaptureAvailableResult zzbf(final Status status) {
            return new CaptureAvailableResult(this) {
                public Status getStatus() {
                    return status;
                }

                public boolean isAvailable() {
                    return false;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbf(status);
        }
    }

    class AnonymousClass6 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo(this);
        }
    }

    class AnonymousClass7 extends ListVideosImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzp(this);
        }
    }

    class AnonymousClass8 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg((zzb) this, false);
        }
    }

    class AnonymousClass9 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null);
        }
    }

    public PendingResult<CaptureCapabilitiesResult> getCaptureCapabilities(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new CaptureCapabilitiesImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzi(this);
            }
        });
    }

    public Intent getCaptureOverlayIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEv();
    }

    public PendingResult<CaptureStateResult> getCaptureState(GoogleApiClient googleApiClient) {
        return googleApiClient.zza(new CaptureStateImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzj(this);
            }
        });
    }

    public PendingResult<CaptureAvailableResult> isCaptureAvailable(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new CaptureAvailableImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, i);
            }
        });
    }

    public boolean isCaptureSupported(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEw();
    }

    public void registerCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient, CaptureOverlayStateListener captureOverlayStateListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zze(googleApiClient.zzr(captureOverlayStateListener));
        }
    }

    public void unregisterCaptureOverlayStateChangedListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzEx();
        }
    }
}
