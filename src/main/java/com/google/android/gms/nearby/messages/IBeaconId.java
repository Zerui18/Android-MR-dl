package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.nearby.messages.internal.zzl;
import java.util.UUID;

public class IBeaconId {
    public static final int LENGTH = 20;
    private final zzl zzbxn;

    public IBeaconId(UUID uuid, short s, short s2) {
        this.zzbxn = new zzl(uuid, Short.valueOf(s), Short.valueOf(s2));
    }

    public IBeaconId(byte[] bArr) {
        this.zzbxn = new zzl(zzB(bArr));
    }

    public static IBeaconId from(Message message) {
        boolean zzgp = message.zzgp(Message.MESSAGE_TYPE_I_BEACON_ID);
        String valueOf = String.valueOf(message.getType());
        zzac.zzb(zzgp, new StringBuilder(String.valueOf(valueOf).length() + 55).append("Message type '").append(valueOf).append("' is not Message.MESSAGE_TYPE_I_BEACON_ID").toString());
        return new IBeaconId(message.getContent());
    }

    private static byte[] zzB(byte[] bArr) {
        zzac.zzb(bArr.length == 20, (Object) "iBeacon ID must be a UUID, a major, and a minor (20 total bytes).");
        return bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IBeaconId)) {
            return false;
        }
        return zzaa.equal(this.zzbxn, ((IBeaconId) obj).zzbxn);
    }

    public short getMajor() {
        return this.zzbxn.zzNj().shortValue();
    }

    public short getMinor() {
        return this.zzbxn.zzNk().shortValue();
    }

    public UUID getProximityUuid() {
        return this.zzbxn.getProximityUuid();
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbxn);
    }

    public String toString() {
        String valueOf = String.valueOf(getProximityUuid());
        short major = getMajor();
        return new StringBuilder(String.valueOf(valueOf).length() + 53).append("IBeaconId{proximityUuid=").append(valueOf).append(", major=").append(major).append(", minor=").append(getMinor()).append("}").toString();
    }
}
