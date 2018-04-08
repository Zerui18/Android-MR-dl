package com.google.android.gms.games.internal.data;

import android.net.Uri;
import com.google.android.gms.games.Games;

public final class GamesDataChangeUris {
    private static final Uri zzbbF = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
    public static final Uri zzbbG = zzbbF.buildUpon().appendPath("invitations").build();
    public static final Uri zzbbH = zzbbF.buildUpon().appendEncodedPath(Games.EXTRA_PLAYER_IDS).build();
}
