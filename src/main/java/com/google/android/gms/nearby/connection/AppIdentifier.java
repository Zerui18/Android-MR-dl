package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;

public final class AppIdentifier extends zza {
    public static final Creator<AppIdentifier> CREATOR = new zza();
    private final int mVersionCode;
    private final String zzaTJ;

    AppIdentifier(int i, String str) {
        this.mVersionCode = i;
        this.zzaTJ = zzac.zzh(str, "Missing application identifier value");
    }

    public AppIdentifier(String str) {
        this(1, str);
    }

    public String getIdentifier() {
        return this.zzaTJ;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.zza(this, parcel, i);
    }
}
