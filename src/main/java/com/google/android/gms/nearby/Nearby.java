package com.google.android.gms.nearby;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.zzaui;
import com.google.android.gms.internal.zzaum;
import com.google.android.gms.internal.zzavk;
import com.google.android.gms.nearby.connection.Connections;
import com.google.android.gms.nearby.messages.Messages;
import com.google.android.gms.nearby.messages.MessagesOptions;
import com.google.android.gms.nearby.messages.internal.zzy;
import com.google.android.gms.nearby.messages.internal.zzz;
import com.google.android.gms.nearby.messages.zzc;

public final class Nearby {
    public static final Api<NoOptions> CONNECTIONS_API = new Api("Nearby.CONNECTIONS_API", zzavk.zzahd, zzavk.zzahc);
    public static final Connections Connections = new zzavk();
    public static final Api<MessagesOptions> MESSAGES_API = new Api("Nearby.MESSAGES_API", zzy.zzahd, zzy.zzahc);
    public static final Messages Messages = zzy.zzbyO;
    public static final zzc zzbwG = new zzz();
    public static final Api<NoOptions> zzbwH = new Api("Nearby.BOOTSTRAP_API", zzaum.zzahd, zzaum.zzahc);
    public static final zzaui zzbwI = new zzaum();

    private Nearby() {
    }
}
