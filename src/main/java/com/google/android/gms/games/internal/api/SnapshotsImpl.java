package com.google.android.gms.games.internal.api;

import android.content.Intent;
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
import com.google.android.gms.games.snapshot.Snapshot;
import com.google.android.gms.games.snapshot.SnapshotContents;
import com.google.android.gms.games.snapshot.SnapshotMetadata;
import com.google.android.gms.games.snapshot.SnapshotMetadataBuffer;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange;
import com.google.android.gms.games.snapshot.SnapshotMetadataChange.Builder;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.snapshot.Snapshots.CommitSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.DeleteSnapshotResult;
import com.google.android.gms.games.snapshot.Snapshots.LoadSnapshotsResult;
import com.google.android.gms.games.snapshot.Snapshots.OpenSnapshotResult;
import com.google.android.gms.internal.zzzv.zzb;

public final class SnapshotsImpl implements Snapshots {

    private static abstract class LoadImpl extends BaseGamesApiMethodImpl<LoadSnapshotsResult> {
        private LoadImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public LoadSnapshotsResult zzaU(final Status status) {
            return new LoadSnapshotsResult(this) {
                public SnapshotMetadataBuffer getSnapshots() {
                    return new SnapshotMetadataBuffer(DataHolder.zzcD(14));
                }

                public Status getStatus() {
                    return status;
                }

                public void release() {
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaU(status);
        }
    }

    private static abstract class OpenImpl extends BaseGamesApiMethodImpl<OpenSnapshotResult> {
        private OpenImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public OpenSnapshotResult zzaV(final Status status) {
            return new OpenSnapshotResult(this) {
                public String getConflictId() {
                    return null;
                }

                public Snapshot getConflictingSnapshot() {
                    return null;
                }

                public SnapshotContents getResolutionSnapshotContents() {
                    return null;
                }

                public Snapshot getSnapshot() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaV(status);
        }
    }

    private static abstract class CommitImpl extends BaseGamesApiMethodImpl<CommitSnapshotResult> {
        private CommitImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public CommitSnapshotResult zzaS(final Status status) {
            return new CommitSnapshotResult(this) {
                public SnapshotMetadata getSnapshotMetadata() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaS(status);
        }
    }

    private static abstract class DeleteImpl extends BaseGamesApiMethodImpl<DeleteSnapshotResult> {
        private DeleteImpl(GoogleApiClient googleApiClient) {
            super(googleApiClient);
        }

        public DeleteSnapshotResult zzaT(final Status status) {
            return new DeleteSnapshotResult(this) {
                public String getSnapshotId() {
                    return null;
                }

                public Status getStatus() {
                    return status;
                }
            };
        }

        public /* synthetic */ Result zzc(Status status) {
            return zzaT(status);
        }
    }

    class AnonymousClass6 extends LoadImpl {
        protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
            gamesClientImpl.zzc((zzb) this, null, null, false);
        }
    }

    public PendingResult<CommitSnapshotResult> commitAndClose(GoogleApiClient googleApiClient, final Snapshot snapshot, final SnapshotMetadataChange snapshotMetadataChange) {
        return googleApiClient.zzb(new CommitImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, snapshot, snapshotMetadataChange);
            }
        });
    }

    public PendingResult<DeleteSnapshotResult> delete(GoogleApiClient googleApiClient, final SnapshotMetadata snapshotMetadata) {
        return googleApiClient.zzb(new DeleteImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzi((zzb) this, snapshotMetadata.getSnapshotId());
            }
        });
    }

    public void discardAndClose(GoogleApiClient googleApiClient, Snapshot snapshot) {
        Games.zzi(googleApiClient).zza(snapshot);
    }

    public int getMaxCoverImageSize(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEu();
    }

    public int getMaxDataSize(GoogleApiClient googleApiClient) {
        return Games.zzi(googleApiClient).zzEt();
    }

    public Intent getSelectSnapshotIntent(GoogleApiClient googleApiClient, String str, boolean z, boolean z2, int i) {
        return Games.zzi(googleApiClient).zza(str, z, z2, i);
    }

    public SnapshotMetadata getSnapshotFromBundle(Bundle bundle) {
        return (bundle == null || !bundle.containsKey(Snapshots.EXTRA_SNAPSHOT_METADATA)) ? null : (SnapshotMetadata) bundle.getParcelable(Snapshots.EXTRA_SNAPSHOT_METADATA);
    }

    public PendingResult<LoadSnapshotsResult> load(GoogleApiClient googleApiClient, final boolean z) {
        return googleApiClient.zza(new LoadImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zzf((zzb) this, z);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, SnapshotMetadata snapshotMetadata, int i) {
        return open(googleApiClient, snapshotMetadata.getUniqueName(), false, i);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z) {
        return open(googleApiClient, str, z, -1);
    }

    public PendingResult<OpenSnapshotResult> open(GoogleApiClient googleApiClient, String str, boolean z, int i) {
        final String str2 = str;
        final boolean z2 = z;
        final int i2 = i;
        return googleApiClient.zzb(new OpenImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str2, z2, i2);
            }
        });
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, Snapshot snapshot) {
        SnapshotMetadata metadata = snapshot.getMetadata();
        SnapshotMetadataChange build = new Builder().fromMetadata(metadata).build();
        return resolveConflict(googleApiClient, str, metadata.getSnapshotId(), build, snapshot.getSnapshotContents());
    }

    public PendingResult<OpenSnapshotResult> resolveConflict(GoogleApiClient googleApiClient, String str, String str2, SnapshotMetadataChange snapshotMetadataChange, SnapshotContents snapshotContents) {
        final String str3 = str;
        final String str4 = str2;
        final SnapshotMetadataChange snapshotMetadataChange2 = snapshotMetadataChange;
        final SnapshotContents snapshotContents2 = snapshotContents;
        return googleApiClient.zzb(new OpenImpl(this, googleApiClient) {
            protected void zza(GamesClientImpl gamesClientImpl) throws RemoteException {
                gamesClientImpl.zza((zzb) this, str3, str4, snapshotMetadataChange2, snapshotContents2);
            }
        });
    }
}
