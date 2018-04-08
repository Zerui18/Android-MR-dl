package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public class zzt extends zza {
    public static final Creator<zzt> CREATOR = new zzu();
    final int mVersionCode;
    public final String type;
    public final String zzaFs;

    zzt(int i, String str, String str2) {
        this.mVersionCode = i;
        this.zzaFs = str;
        this.type = str2;
    }

    public zzt(String str, String str2) {
        this(1, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzt)) {
            return false;
        }
        zzt com_google_android_gms_nearby_messages_internal_zzt = (zzt) obj;
        return zzaa.equal(this.zzaFs, com_google_android_gms_nearby_messages_internal_zzt.zzaFs) && zzaa.equal(this.type, com_google_android_gms_nearby_messages_internal_zzt.type);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaFs, this.type);
    }

    public String toString() {
        String str = this.zzaFs;
        String str2 = this.type;
        return new StringBuilder((String.valueOf(str).length() + 17) + String.valueOf(str2).length()).append("namespace=").append(str).append(", type=").append(str2).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }
}
