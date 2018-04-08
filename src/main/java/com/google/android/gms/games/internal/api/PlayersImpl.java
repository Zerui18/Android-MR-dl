package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.Games.StatusImpl;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.Players;
import com.google.android.gms.games.Players.LoadPlayersResult;
import com.google.android.gms.games.Players.LoadProfileSettingsResult;
import com.google.android.gms.games.Players.LoadStockProfileImagesResult;
import com.google.android.gms.games.Players.LoadXpForGameCategoriesResult;
import com.google.android.gms.games.Players.LoadXpStreamResult;
import com.google.android.gms.games.Players.UpdateGamerProfileResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.player.ProfileSettingsEntity;
import com.google.android.gms.internal.zzzv.zzb;

public final class PlayersImpl implements Players {

    static abstract class LoadPlayersImpl extends BaseGamesApiMethodImpl<LoadPlayersResult> {
        LoadPlayersImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayersResult zzaF(final Status status) {
            return new LoadPlayersResult(this) {
                public PlayerBuffer getPlayers() {
                    return new PlayerBuffer(DataHolder.zzcD(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaF(status);
        }
    }

    class AnonymousClass10 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", null, 0, true, false);
        }
    }

    class AnonymousClass11 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", null, 0, false, false);
        }
    }

    class AnonymousClass12 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "played_with", null, 0, true, false);
        }
    }

    class AnonymousClass13 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, 0, false, false);
        }
    }

    class AnonymousClass14 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, 0, true, false);
        }
    }

    class AnonymousClass15 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, 0, false, false);
        }
    }

    class AnonymousClass16 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, 0, true, false);
        }
    }

    class AnonymousClass17 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, 0, false, false);
        }
    }

    class AnonymousClass18 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd(this, 0, true, false);
        }
    }

    class AnonymousClass19 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, 0, false, false);
        }
    }

    class AnonymousClass20 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, 0, true, false);
        }
    }

    class AnonymousClass21 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, null, null, 0, false, false);
        }
    }

    class AnonymousClass22 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, null, null, 0, true, false);
        }
    }

    private static abstract class LoadXpForGameCategoriesResultImpl extends BaseGamesApiMethodImpl<LoadXpForGameCategoriesResult> {
        public LoadXpForGameCategoriesResult zzaI(final Status status) {
            return new LoadXpForGameCategoriesResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaI(status);
        }
    }

    class AnonymousClass23 extends LoadXpForGameCategoriesResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzl((zzb) this, null);
        }
    }

    private static abstract class LoadXpStreamResultImpl extends BaseGamesApiMethodImpl<LoadXpStreamResult> {
        public LoadXpStreamResult zzaJ(final Status status) {
            return new LoadXpStreamResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaJ(status);
        }
    }

    class AnonymousClass24 extends LoadXpStreamResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, null, 0);
        }
    }

    class AnonymousClass25 extends LoadXpStreamResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze((zzb) this, null, 0);
        }
    }

    private static abstract class LoadProfileSettingsResultImpl extends BaseGamesApiMethodImpl<LoadProfileSettingsResult> {
        protected LoadProfileSettingsResult zzaG(Status status) {
            return new ProfileSettingsEntity(DataHolder.zzcD(status.getStatusCode()));
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaG(status);
        }
    }

    class AnonymousClass26 extends LoadProfileSettingsResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, false, false);
        }
    }

    class AnonymousClass27 extends LoadProfileSettingsResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, false, true);
        }
    }

    private static abstract class UpdateProfileSettingsResultImpl extends BaseGamesApiMethodImpl<Status> {
        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    class AnonymousClass28 extends UpdateProfileSettingsResultImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this, false);
        }
    }

    class AnonymousClass29 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null);
        }
    }

    private static abstract class LoadStockProfileImagesImpl extends BaseGamesApiMethodImpl<LoadStockProfileImagesResult> {
        protected LoadStockProfileImagesResult zzaH(final Status status) {
            return new LoadStockProfileImagesResult(this) {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaH(status);
        }
    }

    class AnonymousClass30 extends LoadStockProfileImagesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzr(this);
        }
    }

    private static abstract class UpdateGamerProfileImpl extends BaseGamesApiMethodImpl<UpdateGamerProfileResult> {
        protected UpdateGamerProfileResult zzaK(final Status status) {
            return new UpdateGamerProfileResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzaK(status);
        }
    }

    class AnonymousClass31 extends UpdateGamerProfileImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, false, null, false, false);
        }
    }

    class AnonymousClass32 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzi((zzb) this, false);
        }
    }

    class AnonymousClass33 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzj((zzb) this, false);
        }
    }

    class AnonymousClass34 extends StatusImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzk((zzb) this, false);
        }
    }

    class AnonymousClass3 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null);
        }
    }

    class AnonymousClass9 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, "nearby", null, 0, false, false);
        }
    }

    public Intent getCompareProfileIntent(GoogleApiClient googleApiClient, Player player) {
        return Games.zzi(googleApiClient).zza(new PlayerEntity(player));
    }

    public Player getCurrentPlayer(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEc();
    }

    public String getCurrentPlayerId(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzax(true);
    }

    public Intent getPlayerSearchIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEm();
    }

    public PendingResult<LoadPlayersResult> loadConnectedPlayers(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, z);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadInvitablePlayers(GoogleApiClient googleApiClient, final int i, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, i, false, z);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreInvitablePlayers(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, i, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadMoreRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, final int i) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, "played_with", i, true, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, false);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadPlayer(GoogleApiClient googleApiClient, final String str, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, z);
            }
        });
    }

    public PendingResult<LoadPlayersResult> loadRecentlyPlayedWithPlayers(GoogleApiClient googleApiClient, final int i, final boolean z) {
        return googleApiClient.zza(new LoadPlayersImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, "played_with", i, false, z);
            }
        });
    }
}
