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
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;
import com.google.android.gms.games.quest.QuestUpdateListener;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.quest.Quests.AcceptQuestResult;
import com.google.android.gms.games.quest.Quests.ClaimMilestoneResult;
import com.google.android.gms.games.quest.Quests.LoadQuestsResult;
import com.google.android.gms.internal.zzzv.zzb;

public final class QuestsImpl implements Quests {

    private static abstract class AcceptImpl extends BaseGamesApiMethodImpl<AcceptQuestResult> {
        private AcceptImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public AcceptQuestResult zzaL(final Status status) {
            return new AcceptQuestResult(this) {
                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaL(status);
        }
    }

    private static abstract class ClaimImpl extends BaseGamesApiMethodImpl<ClaimMilestoneResult> {
        private ClaimImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public ClaimMilestoneResult zzaM(final Status status) {
            return new ClaimMilestoneResult(this) {
                public Milestone getMilestone() {
                    return null;
                }

                public Quest getQuest() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaM(status);
        }
    }

    private static abstract class LoadsImpl extends BaseGamesApiMethodImpl<LoadQuestsResult> {
        private LoadsImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadQuestsResult zzaN(final Status status) {
            return new LoadQuestsResult(this) {
                public QuestBuffer getQuests() {
                    return new QuestBuffer(DataHolder.zzcD(status.getStatusCode()));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaN(status);
        }
    }

    class AnonymousClass5 extends LoadsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, null, 0, false);
        }
    }

    class AnonymousClass6 extends LoadsImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza((zzb) this, null, null, false, null);
        }
    }

    public PendingResult<AcceptQuestResult> accept(GoogleApiClient googleApiClient, final String str) {
        return googleApiClient.zzb(new AcceptImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzh((zzb) this, str);
            }
        });
    }

    public PendingResult<ClaimMilestoneResult> claim(GoogleApiClient googleApiClient, final String str, final String str2) {
        return googleApiClient.zzb(new ClaimImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, str, str2);
            }
        });
    }

    public Intent getQuestIntent(GoogleApiClient googleApiClient, String str) {
        return Games.zzi(googleApiClient).zzer(str);
    }

    public Intent getQuestsIntent(GoogleApiClient googleApiClient, int[] iArr) {
        return Games.zzi(googleApiClient).zzc(iArr);
    }

    public PendingResult<LoadQuestsResult> load(GoogleApiClient googleApiClient, int[] iArr, int i, boolean z) {
        final int[] iArr2 = iArr;
        final int i2 = i;
        final boolean z2 = z;
        return googleApiClient.zza(new LoadsImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, iArr2, i2, z2);
            }
        });
    }

    public PendingResult<LoadQuestsResult> loadByIds(GoogleApiClient googleApiClient, final boolean z, final String... strArr) {
        return googleApiClient.zza(new LoadsImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzb((zzb) this, z, strArr);
            }
        });
    }

    public void registerQuestUpdateListener(GoogleApiClient googleApiClient, QuestUpdateListener questUpdateListener) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzc(googleApiClient.zzr(questUpdateListener));
        }
    }

    public void showStateChangedPopup(GoogleApiClient googleApiClient, String str) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzes(str);
        }
    }

    public void unregisterQuestUpdateListener(GoogleApiClient googleApiClient) {
        GamesClientImpl zzb = Games.zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzEk();
        }
    }
}
