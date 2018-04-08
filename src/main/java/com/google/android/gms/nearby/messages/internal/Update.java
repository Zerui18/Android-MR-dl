package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzavp;
import com.google.android.gms.nearby.messages.Message;
import java.util.Set;

public class Update extends zza implements ReflectedParcelable {
    public static final Creator<Update> CREATOR = new zzak();
    final int mVersionCode;
    public final Message zzbyC;
    final int zzbzi;
    @Nullable
    public final zze zzbzj;
    @Nullable
    public final zza zzbzk;
    @Nullable
    public final zzavp zzbzl;

    Update(int i, int i2, Message message, @Nullable zze com_google_android_gms_nearby_messages_internal_zze, @Nullable zza com_google_android_gms_nearby_messages_internal_zza, @Nullable zzavp com_google_android_gms_internal_zzavp) {
        boolean z = true;
        this.mVersionCode = i;
        this.zzbzi = i2;
        if (zzmj(1) && zzmj(2)) {
            z = false;
        }
        zzac.zza(z, (Object) "Update cannot represent both FOUND and LOST.");
        this.zzbyC = message;
        this.zzbzj = com_google_android_gms_nearby_messages_internal_zze;
        this.zzbzk = com_google_android_gms_nearby_messages_internal_zza;
        this.zzbzl = com_google_android_gms_internal_zzavp;
    }

    private Set<String> zzNq() {
        Set<String> com_google_android_gms_common_util_zza = new com.google.android.gms.common.util.zza();
        if (zzmj(1)) {
            com_google_android_gms_common_util_zza.add("FOUND");
        }
        if (zzmj(2)) {
            com_google_android_gms_common_util_zza.add("LOST");
        }
        if (zzmj(4)) {
            com_google_android_gms_common_util_zza.add("DISTANCE");
        }
        if (zzmj(8)) {
            com_google_android_gms_common_util_zza.add("BLE_SIGNAL");
        }
        if (zzmj(16)) {
            com_google_android_gms_common_util_zza.add("DEVICE");
        }
        return com_google_android_gms_common_util_zza;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        return this.zzbzi == update.zzbzi && zzaa.equal(this.zzbyC, update.zzbyC) && zzaa.equal(this.zzbzj, update.zzbzj) && zzaa.equal(this.zzbzk, update.zzbzk) && zzaa.equal(this.zzbzl, update.zzbzl);
    }

    public int hashCode() {
        return zzaa.hashCode(Integer.valueOf(this.zzbzi), this.zzbyC, this.zzbzj, this.zzbzk, this.zzbzl);
    }

    public String toString() {
        String valueOf = String.valueOf(zzNq());
        String valueOf2 = String.valueOf(this.zzbyC);
        String valueOf3 = String.valueOf(this.zzbzj);
        String valueOf4 = String.valueOf(this.zzbzk);
        String valueOf5 = String.valueOf(this.zzbzl);
        return new StringBuilder(((((String.valueOf(valueOf).length() + 56) + String.valueOf(valueOf2).length()) + String.valueOf(valueOf3).length()) + String.valueOf(valueOf4).length()) + String.valueOf(valueOf5).length()).append("Update{types=").append(valueOf).append(", message=").append(valueOf2).append(", distance=").append(valueOf3).append(", bleSignal=").append(valueOf4).append(", device=").append(valueOf5).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzak.zza(this, parcel, i);
    }

    public boolean zzmj(int i) {
        return (this.zzbzi & i) != 0;
    }
}
