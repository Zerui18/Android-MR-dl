package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;

public class zzm extends zza {
    public static final Creator<zzm> CREATOR = new zzn();
    final int mVersionCode;
    private String zzaJT;
    private int zzaJU;
    private String zzaJV;
    private String zzaJW;
    private int zzaJX;
    private boolean zzaJY;

    zzm(int i, String str, int i2, String str2, String str3, int i3, boolean z) {
        this.mVersionCode = i;
        this.zzaJT = str;
        this.zzaJU = i2;
        this.zzaJV = str2;
        this.zzaJW = str3;
        this.zzaJX = i3;
        this.zzaJY = z;
    }

    public static boolean zzeb(int i) {
        switch (i) {
            case 256:
            case 257:
            case 258:
                return true;
            default:
                return false;
        }
    }

    public static boolean zzec(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
                return true;
            default:
                return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        zzm com_google_android_gms_drive_zzm = (zzm) obj;
        return zzaa.equal(this.zzaJT, com_google_android_gms_drive_zzm.zzaJT) && this.zzaJU == com_google_android_gms_drive_zzm.zzaJU && this.zzaJX == com_google_android_gms_drive_zzm.zzaJX && this.zzaJY == com_google_android_gms_drive_zzm.zzaJY;
    }

    public int getRole() {
        return !zzec(this.zzaJX) ? -1 : this.zzaJX;
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzaJT, Integer.valueOf(this.zzaJU), Integer.valueOf(this.zzaJX), Boolean.valueOf(this.zzaJY));
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.zza(this, parcel, i);
    }

    public String zzzS() {
        return !zzeb(this.zzaJU) ? null : this.zzaJT;
    }

    public int zzzT() {
        return !zzeb(this.zzaJU) ? -1 : this.zzaJU;
    }

    public String zzzU() {
        return this.zzaJV;
    }

    public String zzzV() {
        return this.zzaJW;
    }

    public boolean zzzW() {
        return this.zzaJY;
    }
}
