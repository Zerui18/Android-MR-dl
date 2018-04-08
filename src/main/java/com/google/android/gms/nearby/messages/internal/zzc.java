package com.google.android.gms.nearby.messages.internal;

import java.util.Arrays;

public abstract class zzc {
    private static final char[] zzbyu = "0123456789abcdef".toCharArray();
    private final byte[] zzbyp;

    protected zzc(byte[] bArr) {
        this.zzbyp = bArr;
    }

    public static String zzC(byte[] bArr) {
        StringBuilder stringBuilder = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            stringBuilder.append(zzbyu[(b >> 4) & 15]).append(zzbyu[b & 15]);
        }
        return stringBuilder.toString();
    }

    public static byte[] zzgq(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = (byte) ((Character.digit(str.charAt(i * 2), 16) << 4) + Character.digit(str.charAt((i * 2) + 1), 16));
        }
        return bArr;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!obj.getClass().isAssignableFrom(getClass())) {
            return false;
        }
        return Arrays.equals(this.zzbyp, ((zzc) obj).zzbyp);
    }

    public byte[] getBytes() {
        return this.zzbyp;
    }

    public String getHex() {
        return zzC(this.zzbyp);
    }

    public int hashCode() {
        return Arrays.hashCode(this.zzbyp);
    }

    public String toString() {
        return zzC(this.zzbyp);
    }
}
