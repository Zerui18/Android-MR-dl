package com.google.android.gms.nearby.messages.internal;

import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.common.util.zzb;
import java.util.Arrays;

public class zzg extends zzc {
    public zzg(String str) {
        this(zzc.zzgq(str));
    }

    public zzg(String str, String str2) {
        this(zzc.zzgq(str), zzc.zzgq(str2));
    }

    public zzg(byte[] bArr) {
        super(zzB(bArr));
    }

    public zzg(byte[] bArr, byte[] bArr2) {
        this(zzb.zza(zzD(bArr), zzE(bArr2)));
    }

    private static byte[] zzB(byte[] bArr) {
        boolean z = bArr.length == 10 || bArr.length == 16;
        zzac.zzb(z, (Object) "Bytes must be a namespace (10 bytes), or a namespace plus instance (16 bytes).");
        return bArr;
    }

    private static byte[] zzD(byte[] bArr) {
        zzac.zzb(bArr.length == 10, "Namespace length(" + bArr.length + " bytes) must be " + 10 + " bytes.");
        return bArr;
    }

    private static byte[] zzE(byte[] bArr) {
        zzac.zzb(bArr.length == 6, "Instance length(" + bArr.length + " bytes) must be " + 6 + " bytes.");
        return bArr;
    }

    public String getInstance() {
        byte[] bytes = getBytes();
        return bytes.length < 16 ? null : zzc.zzC(Arrays.copyOfRange(bytes, 10, 16));
    }

    public String getNamespace() {
        return zzc.zzC(Arrays.copyOfRange(getBytes(), 0, 10));
    }

    public String toString() {
        String valueOf = String.valueOf(getHex());
        return new StringBuilder(String.valueOf(valueOf).length() + 26).append("EddystoneUidPrefix{bytes=").append(valueOf).append("}").toString();
    }
}
