package com.google.android.gms.games.internal.api;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.CancelMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.InitiateMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LeaveMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.LoadMatchesResult;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer.UpdateMatchResult;
import com.google.android.gms.internal.zzzv.zzb;
import java.util.List;

public final class TurnBasedMultiplayerImpl implements TurnBasedMultiplayer {

    private static abstract class LoadMatchImpl extends BaseGamesApiMethodImpl<LoadMatchResult> {
        private LoadMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchResult zzbc(final Status status) {
            return new LoadMatchResult(this) {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbc(status);
        }
    }

    private static abstract class InitiateMatchImpl extends BaseGamesApiMethodImpl<InitiateMatchResult> {
        private InitiateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public InitiateMatchResult zzba(final Status status) {
            return new InitiateMatchResult(this) {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzba(status);
        }
    }

    class AnonymousClass11 extends InitiateMatchImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, null, null);
        }
    }

    class AnonymousClass12 extends InitiateMatchImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, null, null);
        }
    }

    private static abstract class LoadMatchesImpl extends BaseGamesApiMethodImpl<LoadMatchesResult> {
        private LoadMatchesImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadMatchesResult zzbd(final Status status) {
            return new LoadMatchesResult(this) {
                public LoadMatchesResponse getMatches() {
                    return new LoadMatchesResponse(new Bundle());
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbd(status);
        }
    }

    class AnonymousClass13 extends LoadMatchesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, 0, null);
        }
    }

    private static abstract class UpdateMatchImpl extends BaseGamesApiMethodImpl<UpdateMatchResult> {
        private UpdateMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public UpdateMatchResult zzbe(final Status status) {
            return new UpdateMatchResult(this) {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbe(status);
        }
    }

    private static abstract class LeaveMatchImpl extends BaseGamesApiMethodImpl<LeaveMatchResult> {
        private LeaveMatchImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaveMatchResult zzbb(final Status status) {
            return new LeaveMatchResult(this) {
                public TurnBasedMatch getMatch() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzbb(status);
        }
    }

    private static abstract class CancelMatchImpl extends BaseGamesApiMethodImpl<CancelMatchResult> {
        private final String zzGu;

        public CancelMatchImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzGu = str;
        }

        public CancelMatchResult zzaZ(final Status status) {
            return new CancelMatchResult(this) {
                final /* synthetic */ CancelMatchImpl zzbbC;

                public String getMatchId() {
                    return this.zzbbC.zzGu;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaZ(status);
        }
    }

    public PendingResult<InitiateMatchResult> acceptInvitation(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new InitiateMatchImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzd((zzb) this, str);
            }
        });
    }

    public PendingResult<CancelMatchResult> cancelMatch(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new CancelMatchImpl(this, googleApiClient, str) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf((zzb) this, str);
            }
        });
    }

    public PendingResult<InitiateMatchResult> createMatch(GoogleApiClient googleApiClient, final TurnBasedMatchConfig turnBasedMatchConfig) {
        return googleApiClient.zzb(new InitiateMatchImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, turnBasedMatchConfig);
            }
        });
    }

    public void declineInvitation(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzq(str, 1);
        }
    }

    public void dismissInvitation(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzp(str, 1);
        }
    }

    public void dismissMatch(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzeq(str);
        }
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str) {
        return finishMatch(googleApiClient, str, null, null);
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, List<ParticipantResult> list) {
        return finishMatch(googleApiClient, str, bArr, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    public PendingResult<UpdateMatchResult> finishMatch(GoogleApiClient googleApiClient, String str, byte[] bArr, ParticipantResult... participantResultArr) {
        final String str2 = str;
        final byte[] bArr2 = bArr;
        final ParticipantResult[] participantResultArr2 = participantResultArr;
        return googleApiClient.zzb(new UpdateMatchImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str2, bArr2, participantResultArr2);
            }
        });
    }

    public Intent getInboxIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEg();
    }

    public int getMaxMatchDataSize(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEp();
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2) {
        return Games.zzi(googleApiClient).zzb(i, i2, true);
    }

    public Intent getSelectOpponentsIntent(GoogleApiClient googleApiClient, int i, int i2, boolean z) {
        return Games.zzi(googleApiClient).zzb(i, i2, z);
    }

    public PendingResult<LeaveMatchResult> leaveMatch(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new LeaveMatchImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zze((zzb) this, str);
            }
        });
    }

    public PendingResult<LeaveMatchResult> leaveMatchDuringTurn(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new LeaveMatchImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str, str2);
            }
        });
    }

    public PendingResult<LoadMatchResult> loadMatch(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zza(new LoadMatchImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzg((zzb) this, str);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, final int i, final int[] iArr) {
        return googleApiClient.zza(new LoadMatchesImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, i, iArr);
            }
        });
    }

    public PendingResult<LoadMatchesResult> loadMatchesByStatus(GoogleApiClient googleApiClient, int[] iArr) {
        return loadMatchesByStatus(googleApiClient, 0, iArr);
    }

    public void registerMatchUpdateListener(GoogleApiClient googleApiClient, OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzb(googleApiClient.zzr(onTurnBasedMatchUpdateReceivedListener));
        }
    }

    public PendingResult<InitiateMatchResult> rematch(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new InitiateMatchImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb) this, str);
            }
        });
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2) {
        return takeTurn(googleApiClient, str, bArr, str2, null);
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, List<ParticipantResult> list) {
        return takeTurn(googleApiClient, str, bArr, str2, list == null ? null : (ParticipantResult[]) list.toArray(new ParticipantResult[list.size()]));
    }

    public PendingResult<UpdateMatchResult> takeTurn(GoogleApiClient googleApiClient, String str, byte[] bArr, String str2, ParticipantResult... participantResultArr) {
        final String str3 = str;
        final byte[] bArr2 = bArr;
        final String str4 = str2;
        final ParticipantResult[] participantResultArr2 = participantResultArr;
        return googleApiClient.zzb(new UpdateMatchImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str3, bArr2, str4, participantResultArr2);
            }
        });
    }

    public void unregisterMatchUpdateListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzEj();
        }
    }
}
