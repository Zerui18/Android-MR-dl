package com.google.android.gms.internal;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzaje extends zza {
    public static final Creator<zzaje> CREATOR = new zzajf();
    final int mVersionCode;
    final ParcelFileDescriptor zzaMR;

    zzaje(int i, ParcelFileDescriptor parcelFileDescriptor) {
        this.mVersionCode = i;
        this.zzaMR = parcelFileDescriptor;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzajf.zza(this, parcel, i | 1);
    }
}
