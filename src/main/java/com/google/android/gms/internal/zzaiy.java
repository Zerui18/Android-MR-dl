package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.zze;
import java.util.Collections;
import java.util.List;

public class zzaiy extends zza {
    public static final Creator<zzaiy> CREATOR = new zzaiz();
    private static final List<zze> zzaMH = Collections.emptyList();
    final int mVersionCode;
    final int zzJh;
    final long zzaMI;
    final long zzaMJ;
    final List<zze> zzaMK;

    zzaiy(int i, long j, long j2, int i2, List<zze> list) {
        this.mVersionCode = i;
        this.zzaMI = j;
        this.zzaMJ = j2;
        this.zzJh = i2;
        this.zzaMK = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaiz.zza(this, parcel, i);
    }

    public long zzAr() {
        return this.zzaMI;
    }

    public long zzAs() {
        return this.zzaMJ;
    }
}
