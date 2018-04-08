package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.List;

public final class AppMetadata extends zza {
    public static final Creator<AppMetadata> CREATOR = new zzb();
    private final int mVersionCode;
    private final List<AppIdentifier> zzbwT;

    AppMetadata(int i, List<AppIdentifier> list) {
        this.mVersionCode = i;
        this.zzbwT = (List) zzac.zzb((Object) list, (Object) "Must specify application identifiers");
        zzac.zza(list.size(), (Object) "Application identifiers cannot be empty");
    }

    public AppMetadata(List<AppIdentifier> list) {
        this(1, list);
    }

    public List<AppIdentifier> getAppIdentifiers() {
        return this.zzbwT;
    }

    public int getVersionCode() {
        return this.mVersionCode;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
