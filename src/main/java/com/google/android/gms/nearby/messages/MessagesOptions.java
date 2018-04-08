package com.google.android.gms.nearby.messages;

import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;

public class MessagesOptions implements Optional {
    public final String zzbxA;
    @Nullable
    public final String zzbxx;
    public final boolean zzbxy;
    public final int zzbxz;

    public static class Builder {
        private int zzbxB = -1;

        public MessagesOptions build() {
            return new MessagesOptions();
        }

        public Builder setPermissions(int i) {
            this.zzbxB = i;
            return this;
        }
    }

    private MessagesOptions(Builder builder) {
        this.zzbxx = null;
        this.zzbxy = false;
        this.zzbxz = builder.zzbxB;
        this.zzbxA = null;
    }
}
