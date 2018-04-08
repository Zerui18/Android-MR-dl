package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.internal.zzavn;
import com.google.android.gms.internal.zzavr;
import com.google.android.gms.nearby.messages.internal.zzt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class MessageFilter extends zza {
    public static final Creator<MessageFilter> CREATOR = new zzb();
    public static final MessageFilter INCLUDE_ALL_MY_TYPES = new Builder().includeAllMyTypes().build();
    final int mVersionCode;
    private final List<zzt> zzbxr;
    private final List<zzavr> zzbxs;
    private final boolean zzbxt;
    private final List<zzavn> zzbxu;

    public static final class Builder {
        private final List<zzavr> zzbxs = new ArrayList();
        private boolean zzbxt;
        private final List<zzt> zzbxv = new ArrayList();
        private final Set<zzavn> zzbxw = new HashSet();

        private Builder zzad(String str, String str2) {
            this.zzbxv.add(new zzt(str, str2));
            return this;
        }

        public MessageFilter build() {
            boolean z = this.zzbxt || !this.zzbxv.isEmpty();
            zzac.zza(z, (Object) "At least one of the include methods must be called.");
            return new MessageFilter(this.zzbxv, this.zzbxs, this.zzbxt, new ArrayList(this.zzbxw));
        }

        public Builder includeAllMyTypes() {
            this.zzbxt = true;
            return this;
        }

        public Builder includeEddystoneUids(String str, @Nullable String str2) {
            zzad(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_EDDYSTONE_UID);
            this.zzbxs.add(zzavr.zzae(str, str2));
            return this;
        }

        public Builder includeFilter(MessageFilter messageFilter) {
            this.zzbxv.addAll(messageFilter.zzMZ());
            this.zzbxs.addAll(messageFilter.zzNb());
            this.zzbxt |= messageFilter.zzNa();
            return this;
        }

        public Builder includeIBeaconIds(UUID uuid, @Nullable Short sh, @Nullable Short sh2) {
            zzad(Message.MESSAGE_NAMESPACE_RESERVED, Message.MESSAGE_TYPE_I_BEACON_ID);
            this.zzbxs.add(zzavr.zza(uuid, sh, sh2));
            return this;
        }

        public Builder includeNamespacedType(String str, String str2) {
            boolean z = (str == null || str.isEmpty() || str.contains("*")) ? false : true;
            zzac.zzb(z, "namespace(%s) cannot be null, empty or contain (*).", str);
            z = (str2 == null || str2.contains("*")) ? false : true;
            zzac.zzb(z, "type(%s) cannot be null or contain (*).", str2);
            return zzad(str, str2);
        }
    }

    MessageFilter(int i, List<zzt> list, List<zzavr> list2, boolean z, List<zzavn> list3) {
        List emptyList;
        List emptyList2;
        this.mVersionCode = i;
        this.zzbxr = Collections.unmodifiableList((List) zzac.zzw(list));
        this.zzbxt = z;
        if (list2 == null) {
            emptyList = Collections.emptyList();
        }
        this.zzbxs = Collections.unmodifiableList(emptyList);
        if (list3 == null) {
            emptyList2 = Collections.emptyList();
        }
        this.zzbxu = Collections.unmodifiableList(emptyList2);
    }

    private MessageFilter(List<zzt> list, List<zzavr> list2, boolean z, List<zzavn> list3) {
        this(2, (List) list, (List) list2, z, (List) list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFilter)) {
            return false;
        }
        MessageFilter messageFilter = (MessageFilter) obj;
        return this.zzbxt == messageFilter.zzbxt && zzaa.equal(this.zzbxr, messageFilter.zzbxr) && zzaa.equal(this.zzbxs, messageFilter.zzbxs) && zzaa.equal(this.zzbxu, messageFilter.zzbxu);
    }

    public int hashCode() {
        return zzaa.hashCode(this.zzbxr, this.zzbxs, Boolean.valueOf(this.zzbxt), this.zzbxu);
    }

    public String toString() {
        boolean z = this.zzbxt;
        String valueOf = String.valueOf(this.zzbxr);
        return new StringBuilder(String.valueOf(valueOf).length() + 53).append("MessageFilter{includeAllMyTypes=").append(z).append(", messageTypes=").append(valueOf).append("}").toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    List<zzt> zzMZ() {
        return this.zzbxr;
    }

    boolean zzNa() {
        return this.zzbxt;
    }

    List<zzavr> zzNb() {
        return this.zzbxs;
    }

    List<zzavn> zzNc() {
        return this.zzbxu;
    }
}
