package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Notifications;
import com.google.android.gms.games.Notifications.ContactSettingLoadResult;
import com.google.android.gms.games.Notifications.GameMuteStatusChangeResult;
import com.google.android.gms.games.Notifications.GameMuteStatusLoadResult;
import com.google.android.gms.games.Notifications.InboxCountResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzzv.zzb;

public final class NotificationsImpl implements Notifications {

    class AnonymousClass1 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, null, true);
        }

        public GameMuteStatusChangeResult zzaB(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ AnonymousClass1 zzbba;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaB(status);
        }
    }

    class AnonymousClass2 extends BaseGamesApiMethodImpl<GameMuteStatusChangeResult> {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, null, false);
        }

        public GameMuteStatusChangeResult zzaB(final Status status) {
            return new GameMuteStatusChangeResult(this) {
                final /* synthetic */ AnonymousClass2 zzbbb;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaB(status);
        }
    }

    class AnonymousClass3 extends BaseGamesApiMethodImpl<GameMuteStatusLoadResult> {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzn(this, null);
        }

        public GameMuteStatusLoadResult zzaC(final Status status) {
            return new GameMuteStatusLoadResult(this) {
                final /* synthetic */ AnonymousClass3 zzbbc;

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaC(status);
        }
    }

    private static abstract class ContactSettingLoadImpl extends BaseGamesApiMethodImpl<ContactSettingLoadResult> {
        public ContactSettingLoadResult zzaD(final Status status) {
            return new ContactSettingLoadResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaD(status);
        }
    }

    class AnonymousClass4 extends ContactSettingLoadImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl((zzb) this, false);
        }
    }

    private static abstract class ContactSettingUpdateImpl extends BaseGamesApiMethodImpl<Status> {
        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    class AnonymousClass5 extends ContactSettingUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, false, false, null);
        }
    }

    private static abstract class InboxCountImpl extends BaseGamesApiMethodImpl<InboxCountResult> {
        public InboxCountResult zzaE(final Status status) {
            return new InboxCountResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaE(status);
        }
    }

    class AnonymousClass6 extends InboxCountImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzs(this);
        }
    }

    public void clear(GoogleApiClient googleApiClient, int i) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zziz(i);
        }
    }

    public void clearAll(GoogleApiClient googleApiClient) {
        clear(googleApiClient, 63);
    }
}
