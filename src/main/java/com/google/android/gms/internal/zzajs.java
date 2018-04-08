package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzajs extends zza {
    public static final Creator<zzajs> CREATOR = new zzajt();
    final int mVersionCode;
    final ParcelFileDescriptor zzaMV;
    final IBinder zzaMW;
    final String zzxq;

    zzajs(int i, ParcelFileDescriptor parcelFileDescriptor, IBinder iBinder, String str) {
        this.mVersionCode = i;
        this.zzaMV = parcelFileDescriptor;
        this.zzaMW = iBinder;
        this.zzxq = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzajt.zza(this, parcel, i | 1);
    }
}
