package com.google.android.gms.games.internal.api;

import android.os.RemoteException;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.social.Social;
import com.google.android.gms.games.social.Social.InviteUpdateResult;
import com.google.android.gms.games.social.Social.LoadInvitesResult;
import com.google.android.gms.internal.zzzv.zzb;

public class SocialImpl implements Social {

    private static abstract class SocialInviteUpdateImpl extends BaseGamesApiMethodImpl<InviteUpdateResult> {
        public InviteUpdateResult zzaX(final Status status) {
            return new InviteUpdateResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaX(status);
        }
    }

    class AnonymousClass1 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzo((zzb) this, null);
        }
    }

    class AnonymousClass2 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzp((zzb) this, null);
        }
    }

    class AnonymousClass3 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzr(this, null);
        }
    }

    class AnonymousClass4 extends SocialInviteUpdateImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzq((zzb) this, null);
        }
    }

    private static abstract class LoadSocialInvitesImpl extends BaseGamesApiMethodImpl<LoadInvitesResult> {
        public LoadInvitesResult zzaW(final Status status) {
            return new LoadInvitesResult(this) {
                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaW(status);
        }
    }

    class AnonymousClass5 extends LoadSocialInvitesImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, 0);
        }
    }

    class AnonymousClass6 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, 0, false, false);
        }
    }

    class AnonymousClass7 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zze(this, 0, true, false);
        }
    }

    class AnonymousClass8 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzs(this, null);
        }
    }

    class AnonymousClass9 extends LoadPlayersImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this, null, false);
        }
    }
}
