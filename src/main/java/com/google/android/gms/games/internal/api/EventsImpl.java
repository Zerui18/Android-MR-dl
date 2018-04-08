package com.google.android.gms.games.internal.api;

import android.annotation.SuppressLint;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.event.EventBuffer;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.event.Events.LoadEventsResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzzv.zzb;

public final class EventsImpl implements Events {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadEventsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadEventsResult zzas(final Status status) {
            return new LoadEventsResult(this) {
                public EventBuffer getEvents() {
                    return new EventBuffer(DataHolder.zzcD(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzas(status);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<Result> {
        private UpdateImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Result zzc(final Status status) {
            return new Result(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }
    }

    @SuppressLint({"MissingRemoteException"})
    public void increment(GoogleApiClient googleApiClient, final String str, final int i) {
        GamesClientImpl zzc = Games.zzc(googleApiClient, false);
        if (zzc != null) {
            if (zzc.isConnected()) {
                zzc.zzo(str, i);
            } else {
                googleApiClient.zzb(new UpdateImpl(this, googleApiClient) {
                    public void zza(GamesClientImpl gamesClientImpl) {
                        gamesClientImpl.zzo(str, i);
                    }
                });
            }
        }
    }

    public PendingResult<LoadEventsResult> load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadImpl(this, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd((zzb) this, z);
            }
        });
    }

    public PendingResult<LoadEventsResult> loadByIds(GoogleApiClient googleApiClient, final boolean z, final String... strArr) {
        return googleApiClient.zza(new LoadImpl(this, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, z, strArr);
            }
        });
    }
}
