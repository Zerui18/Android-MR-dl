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
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.GamesLog;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.leaderboard.Leaderboards.LeaderboardMetadataResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadPlayerScoreResult;
import com.google.android.gms.games.leaderboard.Leaderboards.LoadScoresResult;
import com.google.android.gms.games.leaderboard.Leaderboards.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.internal.zzzv.zzb;

public final class LeaderboardsImpl implements Leaderboards {

    private static abstract class LoadScoresImpl extends BaseGamesApiMethodImpl<LoadScoresResult> {
        private LoadScoresImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadScoresResult zzaz(final Status status) {
            return new LoadScoresResult(this) {
                public Leaderboard getLeaderboard() {
                    return null;
                }

                public LeaderboardScoreBuffer getScores() {
                    return new LeaderboardScoreBuffer(DataHolder.zzcD(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaz(status);
        }
    }

    class AnonymousClass10 extends LoadScoresImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(this, null, null, 0, 0, 0, false);
        }
    }

    class AnonymousClass11 extends LoadScoresImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this, null, null, 0, 0, 0, false);
        }
    }

    private static abstract class LoadMetadataImpl extends BaseGamesApiMethodImpl<LeaderboardMetadataResult> {
        private LoadMetadataImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LeaderboardMetadataResult zzax(final Status status) {
            return new LeaderboardMetadataResult(this) {
                public LeaderboardBuffer getLeaderboards() {
                    return new LeaderboardBuffer(DataHolder.zzcD(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzax(status);
        }
    }

    private static abstract class LoadPlayerScoreImpl extends BaseGamesApiMethodImpl<LoadPlayerScoreResult> {
        private LoadPlayerScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadPlayerScoreResult zzay(final Status status) {
            return new LoadPlayerScoreResult(this) {
                public LeaderboardScore getScore() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzay(status);
        }
    }

    protected static abstract class SubmitScoreImpl extends BaseGamesApiMethodImpl<SubmitScoreResult> {
        protected SubmitScoreImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public SubmitScoreResult zzaA(final Status status) {
            return new SubmitScoreResult(this) {
                public ScoreSubmissionData getScoreData() {
                    return new ScoreSubmissionData(DataHolder.zzcD(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaA(status);
        }
    }

    class AnonymousClass8 extends LoadMetadataImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzd((zzb) this, null, false);
        }
    }

    class AnonymousClass9 extends LoadMetadataImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, false);
        }
    }

    public Intent getAllLeaderboardsIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEe();
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str) {
        return getLeaderboardIntent(googleApiClient, str, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i) {
        return getLeaderboardIntent(googleApiClient, str, i, -1);
    }

    public Intent getLeaderboardIntent(GoogleApiClient googleApiClient, String str, int i, int i2) {
        return Games.zzi(googleApiClient).zzl(str, i, i2);
    }

    public PendingResult<LoadPlayerScoreResult> loadCurrentPlayerLeaderboardScore(GoogleApiClient googleApiClient, String str, int i, int i2) {
        final String str2 = str;
        final int i3 = i;
        final int i4 = i2;
        return googleApiClient.zza(new LoadPlayerScoreImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, null, str2, i3, i4);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, final String str, final boolean z) {
        return googleApiClient.zza(new LoadMetadataImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, str, z);
            }
        });
    }

    public PendingResult<LeaderboardMetadataResult> loadLeaderboardMetadata(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadMetadataImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, z);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadMoreScores(GoogleApiClient googleApiClient, LeaderboardScoreBuffer leaderboardScoreBuffer, int i, int i2) {
        final LeaderboardScoreBuffer leaderboardScoreBuffer2 = leaderboardScoreBuffer;
        final int i3 = i;
        final int i4 = i2;
        return googleApiClient.zza(new LoadScoresImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, leaderboardScoreBuffer2, i3, i4);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadPlayerCenteredScores(googleApiClient, str, i, i2, i3, false);
    }

    public PendingResult<LoadScoresResult> loadPlayerCenteredScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        final String str2 = str;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        return googleApiClient.zza(new LoadScoresImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, str2, i4, i5, i6, z2);
            }
        });
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3) {
        return loadTopScores(googleApiClient, str, i, i2, i3, false);
    }

    public PendingResult<LoadScoresResult> loadTopScores(GoogleApiClient googleApiClient, String str, int i, int i2, int i3, boolean z) {
        final String str2 = str;
        final int i4 = i;
        final int i5 = i2;
        final int i6 = i3;
        final boolean z2 = z;
        return googleApiClient.zza(new LoadScoresImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str2, i4, i5, i6, z2);
            }
        });
    }

    public void submitScore(GoogleApiClient googleApiClient, String str, long j) {
        submitScore(googleApiClient, str, j, null);
    }

    public void submitScore(GoogleApiClient googleApiClient, String str, long j, String str2) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            try {
                zzb.zza(null, str, j, str2);
            } catch (RemoteException e) {
                GamesLog.zzE("LeaderboardsImpl", "service died");
            }
        }
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j) {
        return submitScoreImmediate(googleApiClient, str, j, null);
    }

    public PendingResult<SubmitScoreResult> submitScoreImmediate(GoogleApiClient googleApiClient, String str, long j, String str2) {
        final String str3 = str;
        final long j2 = j;
        final String str4 = str2;
        return googleApiClient.zzb(new SubmitScoreImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str3, j2, str4);
            }
        });
    }
}
