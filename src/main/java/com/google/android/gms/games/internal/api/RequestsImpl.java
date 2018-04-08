package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;
import com.google.android.gms.games.request.OnRequestReceivedListener;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.request.Requests.LoadRequestSummariesResult;
import com.google.android.gms.games.request.Requests.LoadRequestsResult;
import com.google.android.gms.games.request.Requests.SendRequestResult;
import com.google.android.gms.games.request.Requests.UpdateRequestsResult;
import com.google.android.gms.internal.zzzv.zzb;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public final class RequestsImpl implements Requests {

    private static abstract class UpdateRequestsImpl extends BaseGamesApiMethodImpl<UpdateRequestsResult> {
        private UpdateRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateRequestsResult zzaR(final Status status) {
            return new UpdateRequestsResult(this) {
                public Set<String> getRequestIds() {
                    return null;
                }

                public int getRequestOutcome(String str) {
                    String str2 = "Unknown request ID ";
                    String valueOf = String.valueOf(str);
                    throw new IllegalArgumentException(valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaR(status);
        }
    }

    private static abstract class LoadRequestsImpl extends BaseGamesApiMethodImpl<LoadRequestsResult> {
        private LoadRequestsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadRequestsResult zzaP(final Status status) {
            return new LoadRequestsResult(this) {
                public GameRequestBuffer getRequests(int i) {
                    return new GameRequestBuffer(DataHolder.zzcD(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaP(status);
        }
    }

    private static abstract class SendRequestImpl extends BaseGamesApiMethodImpl<SendRequestResult> {
        public SendRequestResult zzaQ(final Status status) {
            return new SendRequestResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaQ(status);
        }
    }

    class AnonymousClass4 extends SendRequestImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, 0, null, 0);
        }
    }

    class AnonymousClass5 extends SendRequestImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, 0, null, 0);
        }
    }

    class AnonymousClass6 extends UpdateRequestsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, null);
        }
    }

    class AnonymousClass7 extends LoadRequestsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, 0, 0, 0);
        }
    }

    private static abstract class LoadRequestSummariesImpl extends BaseGamesApiMethodImpl<LoadRequestSummariesResult> {
        public LoadRequestSummariesResult zzaO(final Status status) {
            return new LoadRequestSummariesResult(this) {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaO(status);
        }
    }

    class AnonymousClass8 extends LoadRequestSummariesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzg(this, null, 0);
        }
    }

    public PendingResult<UpdateRequestsResult> acceptRequest(GoogleApiClient googleApiClient, String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return acceptRequests(googleApiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> acceptRequests(GoogleApiClient googleApiClient, List<String> list) {
        final String[] strArr = list == null ? null : (String[]) list.toArray(new String[list.size()]);
        return googleApiClient.zzb(new UpdateRequestsImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, strArr);
            }
        });
    }

    public PendingResult<UpdateRequestsResult> dismissRequest(GoogleApiClient googleApiClient, String str) {
        List arrayList = new ArrayList();
        arrayList.add(str);
        return dismissRequests(googleApiClient, arrayList);
    }

    public PendingResult<UpdateRequestsResult> dismissRequests(GoogleApiClient googleApiClient, List<String> list) {
        final String[] strArr = list == null ? null : (String[]) list.toArray(new String[list.size()]);
        return googleApiClient.zzb(new UpdateRequestsImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb) this, strArr);
            }
        });
    }

    public ArrayList<GameRequest> getGameRequestsFromBundle(Bundle bundle) {
        if (bundle == null || !bundle.containsKey(Requests.EXTRA_REQUESTS)) {
            return new ArrayList();
        }
        ArrayList arrayList = (ArrayList) bundle.get(Requests.EXTRA_REQUESTS);
        ArrayList<GameRequest> arrayList2 = new ArrayList();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add((GameRequest) arrayList.get(i));
        }
        return arrayList2;
    }

    public ArrayList<GameRequest> getGameRequestsFromInboxResponse(Intent intent) {
        return intent == null ? new ArrayList() : getGameRequestsFromBundle(intent.getExtras());
    }

    public Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEq();
    }

    public int getMaxLifetimeDays(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEs();
    }

    public int getMaxPayloadSize(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEr();
    }

    public Intent getSendIntent(GoogleApiClient googleApiClient, int i, byte[] bArr, int i2, Bitmap bitmap, String str) {
        return Games.zzi(googleApiClient).zza(i, bArr, i2, bitmap, str);
    }

    public PendingResult<LoadRequestsResult> loadRequests(GoogleApiClient googleApiClient, int i, int i2, int i3) {
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        return googleApiClient.zza(new LoadRequestsImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, i4, i5, i6);
            }
        });
    }

    public void registerRequestListener(GoogleApiClient googleApiClient, OnRequestReceivedListener onRequestReceivedListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzd(googleApiClient.zzr(onRequestReceivedListener));
        }
    }

    public void unregisterRequestListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzEl();
        }
    }
}
