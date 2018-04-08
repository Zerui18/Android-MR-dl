package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.RemoteException;
import android.support.annotation.RequiresPermission;
import android.view.View;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.zza;
import com.google.android.gms.common.api.Api.zzf;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.api.AchievementsImpl;
import com.google.android.gms.games.internal.api.AppContentsImpl;
import com.google.android.gms.games.internal.api.EventsImpl;
import com.google.android.gms.games.internal.api.GamesMetadataImpl;
import com.google.android.gms.games.internal.api.InvitationsImpl;
import com.google.android.gms.games.internal.api.LeaderboardsImpl;
import com.google.android.gms.games.internal.api.MultiplayerImpl;
import com.google.android.gms.games.internal.api.NotificationsImpl;
import com.google.android.gms.games.internal.api.PlayersImpl;
import com.google.android.gms.games.internal.api.QuestsImpl;
import com.google.android.gms.games.internal.api.RealTimeMultiplayerImpl;
import com.google.android.gms.games.internal.api.RequestsImpl;
import com.google.android.gms.games.internal.api.SnapshotsImpl;
import com.google.android.gms.games.internal.api.SocialImpl;
import com.google.android.gms.games.internal.api.StatsImpl;
import com.google.android.gms.games.internal.api.TurnBasedMultiplayerImpl;
import com.google.android.gms.games.internal.api.VideosImpl;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.multiplayer.Invitations;
import com.google.android.gms.games.multiplayer.Multiplayer;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMultiplayer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMultiplayer;
import com.google.android.gms.games.quest.Quests;
import com.google.android.gms.games.request.Requests;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.social.Social;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;
import com.google.android.gms.internal.zzzv;
import com.google.android.gms.internal.zzzv.zzb;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Games {
    public static final Api<GamesOptions> API = new Api("Games.API", zzahd, zzahc);
    public static final Achievements Achievements = new AchievementsImpl();
    public static final String EXTRA_PLAYER_IDS = "players";
    public static final String EXTRA_STATUS = "status";
    public static final Events Events = new EventsImpl();
    public static final GamesMetadata GamesMetadata = new GamesMetadataImpl();
    public static final Invitations Invitations = new InvitationsImpl();
    public static final Leaderboards Leaderboards = new LeaderboardsImpl();
    public static final Notifications Notifications = new NotificationsImpl();
    public static final Players Players = new PlayersImpl();
    public static final Quests Quests = new QuestsImpl();
    public static final RealTimeMultiplayer RealTimeMultiplayer = new RealTimeMultiplayerImpl();
    public static final Requests Requests = new RequestsImpl();
    public static final Scope SCOPE_GAMES = new Scope(Scopes.GAMES);
    public static final Snapshots Snapshots = new SnapshotsImpl();
    public static final Stats Stats = new StatsImpl();
    public static final TurnBasedMultiplayer TurnBasedMultiplayer = new TurnBasedMultiplayerImpl();
    public static final Videos Videos = new VideosImpl();
    private static final zza<GamesClientImpl, GamesOptions> zzaXo = new GamesClientBuilder() {
        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.zzaXp);
        }

        public /* synthetic */ List zzp(Object obj) {
            return zza((GamesOptions) obj);
        }
    };
    public static final Scope zzaXp = new Scope("https://www.googleapis.com/auth/games.firstparty");
    public static final Api<GamesOptions> zzaXq = new Api("Games.API_1P", zzaXo, zzahc);
    public static final AppContents zzaXr = new AppContentsImpl();
    public static final Multiplayer zzaXs = new MultiplayerImpl();
    public static final Social zzaXt = new SocialImpl();
    static final zzf<GamesClientImpl> zzahc = new zzf();
    private static final zza<GamesClientImpl, GamesOptions> zzahd = new GamesClientBuilder() {
        public List<Scope> zza(GamesOptions gamesOptions) {
            return Collections.singletonList(Games.SCOPE_GAMES);
        }

        public /* synthetic */ List zzp(Object obj) {
            return zza((GamesOptions) obj);
        }
    };

    private static abstract class GamesClientBuilder extends zza<GamesClientImpl, GamesOptions> {
        private GamesClientBuilder() {
        }

        public int getPriority() {
            return 1;
        }

        public GamesClientImpl zza(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, GamesOptions gamesOptions, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
            return new GamesClientImpl(context, looper, com_google_android_gms_common_internal_zzg, gamesOptions == null ? new GamesOptions() : gamesOptions, connectionCallbacks, onConnectionFailedListener);
        }
    }

    public static abstract class BaseGamesApiMethodImpl<R extends Result> extends zzzv.zza<R, GamesClientImpl> {
        public BaseGamesApiMethodImpl(GoogleApiClient googleApiClient) {
            super(Games.zzahc, googleApiClient);
        }
    }

    private static abstract class GetTokenImpl extends BaseGamesApiMethodImpl<GetTokenResult> {
        public GetTokenResult zzak(final Status status) {
            return new GetTokenResult(this) {
                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzak(status);
        }
    }

    class AnonymousClass3 extends GetTokenImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf((zzb) this);
        }
    }

    private static abstract class GetServerAuthCodeImpl extends BaseGamesApiMethodImpl<GetServerAuthCodeResult> {
        private GetServerAuthCodeImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public GetServerAuthCodeResult zzaj(final Status status) {
            return new GetServerAuthCodeResult(this) {
                public String getCode() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaj(status);
        }
    }

    class AnonymousClass4 extends GetServerAuthCodeImpl {
        final /* synthetic */ String zzaXu;

        AnonymousClass4(GoogleApiClient googleApiClient, String str) {
            this.zzaXu = str;
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzb(this.zzaXu, (zzb) this);
        }
    }

    private static abstract class SignOutImpl extends BaseGamesApiMethodImpl<Status> {
        private SignOutImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    class AnonymousClass5 extends SignOutImpl {
        AnonymousClass5(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzh((zzb) this);
        }
    }

    class AnonymousClass6 extends BaseGamesApiMethodImpl<Status> {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zza(null, null);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    class AnonymousClass7 extends BaseGamesApiMethodImpl<Status> {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzf(null);
        }

        protected Status zzb(Status status) {
            return status;
        }

        protected /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    public static final class GamesOptions implements Optional {
        public final String zzaXA;
        public final ArrayList<String> zzaXB;
        public final boolean zzaXC;
        public final boolean zzaXD;
        public final boolean zzaXv;
        public final boolean zzaXw;
        public final int zzaXx;
        public final boolean zzaXy;
        public final int zzaXz;

        public static final class Builder {
            String zzaXA;
            ArrayList<String> zzaXB;
            boolean zzaXC;
            boolean zzaXD;
            boolean zzaXv;
            boolean zzaXw;
            int zzaXx;
            boolean zzaXy;
            int zzaXz;

            private Builder() {
                this.zzaXv = false;
                this.zzaXw = true;
                this.zzaXx = 17;
                this.zzaXy = false;
                this.zzaXz = 4368;
                this.zzaXA = null;
                this.zzaXB = new ArrayList();
                this.zzaXC = false;
                this.zzaXD = false;
            }

            public GamesOptions build() {
                return new GamesOptions();
            }

            @Deprecated
            public Builder setRequireGooglePlus(boolean z) {
                this.zzaXC = z;
                return this;
            }

            public Builder setSdkVariant(int i) {
                this.zzaXz = i;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z) {
                this.zzaXw = z;
                this.zzaXx = 17;
                return this;
            }

            public Builder setShowConnectingPopup(boolean z, int i) {
                this.zzaXw = z;
                this.zzaXx = i;
                return this;
            }
        }

        private GamesOptions() {
            this.zzaXv = false;
            this.zzaXw = true;
            this.zzaXx = 17;
            this.zzaXy = false;
            this.zzaXz = 4368;
            this.zzaXA = null;
            this.zzaXB = new ArrayList();
            this.zzaXC = false;
            this.zzaXD = false;
        }

        private GamesOptions(Builder builder) {
            this.zzaXv = false;
            this.zzaXw = builder.zzaXw;
            this.zzaXx = builder.zzaXx;
            this.zzaXy = false;
            this.zzaXz = builder.zzaXz;
            this.zzaXA = null;
            this.zzaXB = builder.zzaXB;
            this.zzaXC = builder.zzaXC;
            this.zzaXD = false;
        }

        public static Builder builder() {
            return new Builder();
        }

        public Bundle zzDb() {
            Bundle bundle = new Bundle();
            bundle.putBoolean("com.google.android.gms.games.key.isHeadless", false);
            bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.zzaXw);
            bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.zzaXx);
            bundle.putBoolean("com.google.android.gms.games.key.retryingSignIn", false);
            bundle.putInt("com.google.android.gms.games.key.sdkVariant", this.zzaXz);
            bundle.putString("com.google.android.gms.games.key.forceResolveAccountKey", null);
            bundle.putStringArrayList("com.google.android.gms.games.key.proxyApis", this.zzaXB);
            bundle.putBoolean("com.google.android.gms.games.key.requireGooglePlus", this.zzaXC);
            bundle.putBoolean("com.google.android.gms.games.key.unauthenticated", false);
            return bundle;
        }
    }

    @Deprecated
    public interface GetServerAuthCodeResult extends Result {
        String getCode();
    }

    public interface GetTokenResult extends Result {
    }

    public static abstract class StatusImpl extends BaseGamesApiMethodImpl<Status> {
        public Status zzb(Status status) {
            return status;
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzb(status);
        }
    }

    private Games() {
    }

    public static String getAppId(GoogleApiClient googleApiClient) {
        return zzi(googleApiClient).zzjI();
    }

    @RequiresPermission("android.permission.GET_ACCOUNTS")
    public static String getCurrentAccountName(GoogleApiClient googleApiClient) {
        return zzi(googleApiClient).zzEb();
    }

    @Deprecated
    public static PendingResult<GetServerAuthCodeResult> getGamesServerAuthCode(GoogleApiClient googleApiClient, String str) {
        zzac.zzh(str, "Please provide a valid serverClientId");
        return googleApiClient.zzb(new AnonymousClass4(googleApiClient, str));
    }

    public static int getSdkVariant(GoogleApiClient googleApiClient) {
        return zzi(googleApiClient).zzEo();
    }

    public static Intent getSettingsIntent(GoogleApiClient googleApiClient) {
        return zzi(googleApiClient).zzEn();
    }

    public static void setGravityForPopups(GoogleApiClient googleApiClient, int i) {
        GamesClientImpl zzb = zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zziy(i);
        }
    }

    public static void setViewForPopups(GoogleApiClient googleApiClient, View view) {
        zzac.zzw(view);
        GamesClientImpl zzb = zzb(googleApiClient, false);
        if (zzb != null) {
            zzb.zzv(view);
        }
    }

    public static PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return googleApiClient.zzb(new AnonymousClass5(googleApiClient));
    }

    public static GamesClientImpl zzb(GoogleApiClient googleApiClient, boolean z) {
        zzac.zzb(googleApiClient != null, (Object) "GoogleApiClient parameter is required.");
        zzac.zza(googleApiClient.isConnected(), (Object) "GoogleApiClient must be connected.");
        return zzc(googleApiClient, z);
    }

    public static GamesClientImpl zzc(GoogleApiClient googleApiClient, boolean z) {
        zzac.zza(googleApiClient.zza(API), (Object) "GoogleApiClient is not configured to use the Games Api. Pass Games.API into GoogleApiClient.Builder#addApi() to use this feature.");
        boolean hasConnectedApi = googleApiClient.hasConnectedApi(API);
        if (!z || hasConnectedApi) {
            return hasConnectedApi ? (GamesClientImpl) googleApiClient.zza(zzahc) : null;
        } else {
            throw new IllegalStateException("GoogleApiClient has an optional Games.API and is not connected to Games. Use GoogleApiClient.hasConnectedApi(Games.API) to guard this call.");
        }
    }

    public static GamesClientImpl zzi(GoogleApiClient googleApiClient) {
        return zzb(googleApiClient, true);
    }
}
