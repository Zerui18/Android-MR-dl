package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.nearby.messages.Message;

public class zzv extends zza {
    public static final Creator<zzv> CREATOR = new zzw();
    final int mVersionCode;
    public final Message zzbyC;

    zzv(int i, Message message) {
        this.mVersionCode = i;
        this.zzbyC = (Message) zzac.zzw(message);
    }

    public static final zzv zza(Message message) {
        return new zzv(1, message);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzv)) {
            return false;
        }
        return zzaa.equal(this.zzbyC, ((zzv) obj).zzbyC);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbyC);
    }

    public String toString() {
        String valueOf = String.valueOf(this.zzbyC.toString());
        return new StringBuilder(String.valueOf(valueOf).length() + 24).append("MessageWrapper{message=").append(valueOf).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzw.zza(this, parcel, i);
    }
}
