package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.drive.DriveId;

public class zzaku extends zza {
    public static final Creator<zzaku> CREATOR = new zzakv();
    final int mVersionCode;
    final DriveId zzaKS;

    zzaku(int i, DriveId driveId) {
        this.mVersionCode = i;
        this.zzaKS = driveId;
    }

    public zzaku(DriveId driveId) {
        this(1, driveId);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzakv.zza(this, parcel, i);
    }
}
