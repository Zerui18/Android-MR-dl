package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public final class ClientAppContext extends zza implements ReflectedParcelable {
    public static final Creator<ClientAppContext> CREATOR = new zzd();
    final int versionCode;
    public final String zzbxA;
    public final boolean zzbxy;
    @Nullable
    public final String zzbyv;
    @Nullable
    public final String zzbyw;
    public final int zzbyx;

    ClientAppContext(int i, @Nullable String str, @Nullable String str2, boolean z, int i2, @Nullable String str3) {
        this.versionCode = i;
        this.zzbyv = str;
        if (!(str2 == null || str2.isEmpty() || str2.startsWith("0p:"))) {
            Log.w("NearbyMessages", String.format("ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", new Object[]{str2, "0p:"}));
            String valueOf = String.valueOf("0p:");
            String valueOf2 = String.valueOf(str2);
            str2 = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
        }
        this.zzbyw = str2;
        this.zzbxy = z;
        this.zzbyx = i2;
        this.zzbxA = str3;
    }

    public ClientAppContext(@Nullable String str, @Nullable String str2, boolean z) {
        this(str, str2, z, null, 0);
    }

    public ClientAppContext(@Nullable String str, @Nullable String str2, boolean z, @Nullable String str3, int i) {
        this(1, str, str2, z, i, str3);
    }

    @Nullable
    static final ClientAppContext zza(@Nullable ClientAppContext clientAppContext, @Nullable String str, @Nullable String str2, boolean z) {
        return clientAppContext != null ? clientAppContext : (str == null && str2 == null) ? null : new ClientAppContext(str, str2, z);
    }

    private static boolean zzaf(String str, String str2) {
        return TextUtils.isEmpty(str) ? TextUtils.isEmpty(str2) : str.equals(str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) obj;
        return zzaf(this.zzbyv, clientAppContext.zzbyv) && zzaf(this.zzbyw, clientAppContext.zzbyw) && this.zzbxy == clientAppContext.zzbxy && zzaf(this.zzbxA, clientAppContext.zzbxA) && this.zzbyx == clientAppContext.zzbyx;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbyv, this.zzbyw, Boolean.valueOf(this.zzbxy), this.zzbxA, Integer.valueOf(this.zzbyx));
    }

    public String toString() {
        return String.format("{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", new Object[]{this.zzbyv, this.zzbyw, Boolean.valueOf(this.zzbxy), this.zzbxA, Integer.valueOf(this.zzbyx)});
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }
}
