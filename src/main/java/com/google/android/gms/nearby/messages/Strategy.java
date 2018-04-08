package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzac;
import java.util.ArrayList;
import java.util.List;

public class Strategy extends zza {
    public static final Strategy BLE_ONLY = new Builder().zzlP(2).setTtlSeconds(TTL_SECONDS_INFINITE).build();
    public static final Creator<Strategy> CREATOR = new zzd();
    public static final Strategy DEFAULT = new Builder().build();
    public static final int DISCOVERY_MODE_BROADCAST = 1;
    public static final int DISCOVERY_MODE_DEFAULT = 3;
    public static final int DISCOVERY_MODE_SCAN = 2;
    public static final int DISTANCE_TYPE_DEFAULT = 0;
    public static final int DISTANCE_TYPE_EARSHOT = 1;
    public static final int TTL_SECONDS_DEFAULT = 300;
    public static final int TTL_SECONDS_INFINITE = Integer.MAX_VALUE;
    public static final int TTL_SECONDS_MAX = 86400;
    @Deprecated
    public static final Strategy zzbxE = BLE_ONLY;
    final int mVersionCode;
    @Deprecated
    final int zzbxF;
    final int zzbxG;
    final int zzbxH;
    @Deprecated
    final boolean zzbxI;
    final int zzbxJ;
    final int zzbxK;
    private final int zzbxL;

    public static class Builder {
        private int zzbxM = 3;
        private int zzbxN = Strategy.TTL_SECONDS_DEFAULT;
        private int zzbxO = 0;
        private int zzbxP = -1;
        private int zzbxQ = 0;

        public Strategy build() {
            if (this.zzbxP == 2 && this.zzbxO == 1) {
                throw new IllegalStateException("Cannot set EARSHOT with BLE only mode.");
            }
            return new Strategy(2, 0, this.zzbxN, this.zzbxO, false, this.zzbxP, this.zzbxM, 0);
        }

        public Builder setDiscoveryMode(int i) {
            this.zzbxM = i;
            return this;
        }

        public Builder setDistanceType(int i) {
            this.zzbxO = i;
            return this;
        }

        public Builder setTtlSeconds(int i) {
            boolean z = i == Strategy.TTL_SECONDS_INFINITE || (i > 0 && i <= Strategy.TTL_SECONDS_MAX);
            zzac.zzb(z, "mTtlSeconds(%d) must either be TTL_SECONDS_INFINITE, or it must be between 1 and TTL_SECONDS_MAX(%d) inclusive", Integer.valueOf(i), Integer.valueOf(Strategy.TTL_SECONDS_MAX));
            this.zzbxN = i;
            return this;
        }

        public Builder zzlP(int i) {
            this.zzbxP = i;
            return this;
        }
    }

    Strategy(int i, int i2, int i3, int i4, boolean z, int i5, int i6, int i7) {
        this.mVersionCode = i;
        this.zzbxF = i2;
        if (i2 != 0) {
            switch (i2) {
                case 2:
                    this.zzbxK = 1;
                    break;
                case 3:
                    this.zzbxK = 2;
                    break;
                default:
                    this.zzbxK = 3;
                    break;
            }
        }
        this.zzbxK = i6;
        this.zzbxH = i4;
        this.zzbxI = z;
        if (!z) {
            this.zzbxG = i3;
            switch (i5) {
                case -1:
                case 0:
                case 1:
                case 6:
                    this.zzbxJ = -1;
                    break;
                default:
                    this.zzbxJ = i5;
                    break;
            }
        }
        this.zzbxJ = 2;
        this.zzbxG = TTL_SECONDS_INFINITE;
        this.zzbxL = i7;
    }

    private static String zzlL(int i) {
        switch (i) {
            case 0:
                return "DEFAULT";
            case 1:
                return "ALWAYS_ON";
            default:
                return "UNKNOWN: " + i;
        }
    }

    private static String zzlM(int i) {
        switch (i) {
            case 0:
                return "DEFAULT";
            case 1:
                return "EARSHOT";
            default:
                return "UNKNOWN:" + i;
        }
    }

    private static String zzlN(int i) {
        if (i == -1) {
            return "DEFAULT";
        }
        List arrayList = new ArrayList();
        if ((i & 4) > 0) {
            arrayList.add("ULTRASOUND");
        }
        if ((i & 2) > 0) {
            arrayList.add("BLE");
        }
        return arrayList.isEmpty() ? "UNKNOWN:" + i : arrayList.toString();
    }

    private static String zzlO(int i) {
        if (i == 3) {
            return "DEFAULT";
        }
        List arrayList = new ArrayList();
        if ((i & 1) > 0) {
            arrayList.add("BROADCAST");
        }
        if ((i & 2) > 0) {
            arrayList.add("SCAN");
        }
        return arrayList.isEmpty() ? "UNKNOWN:" + i : arrayList.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Strategy)) {
            return false;
        }
        Strategy strategy = (Strategy) obj;
        return this.mVersionCode == strategy.mVersionCode && this.zzbxK == strategy.zzbxK && this.zzbxG == strategy.zzbxG && this.zzbxH == strategy.zzbxH && this.zzbxJ == strategy.zzbxJ;
    }

    public int hashCode() {
        return (((((((this.mVersionCode * 31) + this.zzbxK) * 31) + this.zzbxG) * 31) + this.zzbxH) * 31) + this.zzbxJ;
    }

    public String toString() {
        int i = this.zzbxG;
        String valueOf = String.valueOf(zzlM(this.zzbxH));
        String valueOf2 = String.valueOf(zzlN(this.zzbxJ));
        String valueOf3 = String.valueOf(zzlO(this.zzbxK));
        String valueOf4 = String.valueOf(zzlL(this.zzbxL));
        return new StringBuilder((((String.valueOf(valueOf).length() + 102) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()).append("Strategy{ttlSeconds=").append(i).append(", distanceType=").append(valueOf).append(", discoveryMedium=").append(valueOf2).append(", discoveryMode=").append(valueOf3).append(", backgroundScanMode=").append(valueOf4).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.zza(this, parcel, i);
    }

    public int zzNd() {
        return this.zzbxJ;
    }

    public int zzNe() {
        return this.zzbxK;
    }

    public int zzNf() {
        return this.zzbxL;
    }
}
