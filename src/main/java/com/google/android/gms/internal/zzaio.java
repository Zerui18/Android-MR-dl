package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzaio extends zza {
    public static final Creator<zzaio> CREATOR = new zzaip();
    final int mVersionCode;
    final DriveId zzaMv;

    zzaio(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaMv = driveId;
    }

    public zzaio(DriveId driveId) {
        this(1, driveId);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaip.zza(this, parcel, i);
    }
}
