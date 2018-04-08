package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.nearby.messages.BleSignal;

public class zza extends com.google.android.gms.common.internal.safeparcel.zza implements BleSignal {
    public static final Creator<zza> CREATOR = new zzb();
    final int mVersionCode;
    public final int zzbys;
    public final int zzbyt;

    zza(int i, int i2, int i3) {
        this.mVersionCode = i;
        this.zzbys = i2;
        if (-128 >= i3 || i3 >= 128) {
            i3 = Integer.MIN_VALUE;
        }
        this.zzbyt = i3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BleSignal)) {
            return false;
        }
        BleSignal bleSignal = (BleSignal) obj;
        return this.zzbys == bleSignal.getRssi() && this.zzbyt == bleSignal.getTxPower();
    }

    public int getRssi() {
        return this.zzbys;
    }

    public int getTxPower() {
        return this.zzbyt;
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzbys), Integer.valueOf(this.zzbyt));
    }

    public String toString() {
        int i = this.zzbys;
        return "BleSignal{rssi=" + i + ", txPower=" + this.zzbyt + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }
}
