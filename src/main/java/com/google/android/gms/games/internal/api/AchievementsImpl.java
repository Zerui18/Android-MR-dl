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
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.achievement.Achievements.LoadAchievementsResult;
import com.google.android.gms.games.achievement.Achievements.UpdateAchievementResult;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.internal.zzzv.zzb;

public final class AchievementsImpl implements Achievements {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadAchievementsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadAchievementsResult zzap(final Status status) {
            return new LoadAchievementsResult(this) {
                public AchievementBuffer getAchievements() {
                    return new AchievementBuffer(DataHolder.zzcD(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzap(status);
        }
    }

    class AnonymousClass10 extends LoadImpl {
        public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb((zzb) this, null, null, false);
        }
    }

    private static abstract class UpdateImpl extends BaseGamesApiMethodImpl<UpdateAchievementResult> {
        private final String zzGu;

        public UpdateImpl(String str, GoogleApiClient googleApiClient) {
            super(googleApiClient);
            this.zzGu = str;
        }

        public UpdateAchievementResult zzaq(final Status status) {
            return new UpdateAchievementResult(this) {
                final /* synthetic */ UpdateImpl zzbaN;

                public String getAchievementId() {
                    return this.zzbaN.zzGu;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaq(status);
        }
    }

    public Intent getAchievementsIntent(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEf();
    }

    public void increment(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        googleApiClient.zzb(new UpdateImpl(this, str, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(null, str2, i2);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> incrementImmediate(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        return googleApiClient.zzb(new UpdateImpl(this, str, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str2, i2);
            }
        });
    }

    public PendingResult<LoadAchievementsResult> load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadImpl(this, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzc((zzb) this, z);
            }
        });
    }

    public void reveal(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(this, googleApiClient, str) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza(null, str);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> revealImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(this, googleApiClient, str) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str);
            }
        });
    }

    public void setSteps(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        googleApiClient.zzb(new UpdateImpl(this, str, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(null, str2, i2);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> setStepsImmediate(GoogleApiClient googleApiClient, String str, int i) {
        final String str2 = str;
        final int i2 = i;
        return googleApiClient.zzb(new UpdateImpl(this, str, googleApiClient) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, str2, i2);
            }
        });
    }

    public void unlock(GoogleApiClient googleApiClient, final String str) {
        googleApiClient.zzb(new UpdateImpl(this, googleApiClient, str) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb(null, str);
            }
        });
    }

    public PendingResult<UpdateAchievementResult> unlockImmediate(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new UpdateImpl(this, googleApiClient, str) {
            public void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, str);
            }
        });
    }
}
