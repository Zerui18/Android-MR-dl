package com.google.android.gms.nearby.messages.internal;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;
import java.nio.ByteBuffer;
import java.util.UUID;

public class zzl extends zzc {
    public zzl(UUID uuid, @Nullable Short sh, @Nullable Short sh2) {
        this(zzb(uuid, sh, sh2));
    }

    public zzl(byte[] bArr) {
        super(zzB(bArr));
    }

    private static byte[] zzB(byte[] bArr) {
        boolean z = bArr.length == 16 || bArr.length == 18 || bArr.length == 20;
        zzac.zzb(z, (Object) "Prefix must be a UUID, a UUID and a major, or a UUID, a major, and a minor.");
        return bArr;
    }

    private static byte[] zzb(UUID uuid, Short sh, Short sh2) {
        int i = 0;
        int i2 = (sh == null ? 0 : 2) + 16;
        if (sh2 != null) {
            i = 2;
        }
        ByteBuffer allocate = ByteBuffer.allocate(i + i2);
        allocate.putLong(uuid.getMostSignificantBits()).putLong(uuid.getLeastSignificantBits());
        if (sh != null) {
            allocate.putShort(sh.shortValue());
        }
        if (sh2 != null) {
            allocate.putShort(sh2.shortValue());
        }
        return allocate.array();
    }

    public UUID getProximityUuid() {
        ByteBuffer wrap = ByteBuffer.wrap(getBytes());
        return new UUID(wrap.getLong(), wrap.getLong());
    }

    public String toString() {
        String valueOf = String.valueOf(getProximityUuid());
        String valueOf2 = String.valueOf(zzNj());
        String valueOf3 = String.valueOf(zzNk());
        return new StringBuilder(((String.valueOf(valueOf).length() + 47) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()).append("IBeaconIdPrefix{proximityUuid=").append(valueOf).append(", major=").append(valueOf2).append(", minor=").append(valueOf3).append("}").toString();
    }

    public Short zzNj() {
        byte[] bytes = getBytes();
        return bytes.length >= 18 ? Short.valueOf(ByteBuffer.wrap(bytes).getShort(16)) : null;
    }

    public Short zzNk() {
        byte[] bytes = getBytes();
        return bytes.length == 20 ? Short.valueOf(ByteBuffer.wrap(bytes).getShort(18)) : null;
    }
}
