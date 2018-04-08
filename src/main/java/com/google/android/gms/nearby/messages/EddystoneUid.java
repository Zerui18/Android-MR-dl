package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.nearby.messages.internal.zzc;
import com.google.android.gms.nearby.messages.internal.zzg;

public class EddystoneUid {
    public static final int INSTANCE_LENGTH = 6;
    public static final int LENGTH = 16;
    public static final int NAMESPACE_LENGTH = 10;
    private final zzg zzbxm;

    public EddystoneUid(String str) {
        this(zzc.zzgq(str));
    }

    public EddystoneUid(String str, String str2) {
        this.zzbxm = new zzg(str, str2);
    }

    public EddystoneUid(byte[] bArr) {
        this.zzbxm = new zzg(zzB(bArr));
    }

    public static EddystoneUid from(Message message) {
        boolean zzgp = message.zzgp(Message.MESSAGE_TYPE_EDDYSTONE_UID);
        String valueOf = String.valueOf(message.getType());
        zzac.zzb(zzgp, new StringBuilder(String.valueOf(valueOf).length() + 58).append("Message type '").append(valueOf).append("' is not Message.MESSAGE_TYPE_EDDYSTONE_UID.").toString());
        return new EddystoneUid(message.getContent());
    }

    private static byte[] zzB(byte[] bArr) {
        zzac.zzb(bArr.length == 16, (Object) "Bytes must be a namespace plus instance (16 bytes).");
        return bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EddystoneUid)) {
            return false;
        }
        return zzaa.equal(this.zzbxm, ((EddystoneUid) obj).zzbxm);
    }

    public String getHex() {
        return this.zzbxm.getHex();
    }

    public String getInstance() {
        return this.zzbxm.getInstance();
    }

    public String getNamespace() {
        return this.zzbxm.getNamespace();
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbxm);
    }

    public String toString() {
        String valueOf = String.valueOf(getHex());
        return new StringBuilder(String.valueOf(valueOf).length() + 17).append("EddystoneUid{id=").append(valueOf).append("}").toString();
    }
}
