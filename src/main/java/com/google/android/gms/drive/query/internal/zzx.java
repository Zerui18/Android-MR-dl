package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzx extends zza {
    public static final Creator<zzx> CREATOR = new zzy();
    public static final zzx zzaPd = new zzx("=");
    public static final zzx zzaPe = new zzx("<");
    public static final zzx zzaPf = new zzx("<=");
    public static final zzx zzaPg = new zzx(">");
    public static final zzx zzaPh = new zzx(">=");
    public static final zzx zzaPi = new zzx("and");
    public static final zzx zzaPj = new zzx("or");
    public static final zzx zzaPk = new zzx("not");
    public static final zzx zzaPl = new zzx("contains");
    final String mTag;
    final int mVersionCode;

    zzx(int i, String str) {
        this.mVersionCode = i;
        this.mTag = str;
    }

    private zzx(String str) {
        this(1, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        zzx com_google_android_gms_drive_query_internal_zzx = (zzx) obj;
        return this.mTag == null ? com_google_android_gms_drive_query_internal_zzx.mTag == null : this.mTag.equals(com_google_android_gms_drive_query_internal_zzx.mTag);
    }

    public String getTag() {
        return this.mTag;
    }

    public int hashCode() {
        return (this.mTag == null ? 0 : this.mTag.hashCode()) + 31;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzy.zza(this, parcel, i);
    }
}
