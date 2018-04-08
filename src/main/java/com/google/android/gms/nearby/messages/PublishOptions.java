package com.google.android.gms.nearby.messages;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;

public final class PublishOptions {
    public static final PublishOptions DEFAULT = new Builder().build();
    private final Strategy zzbxC;
    @Nullable
    private final PublishCallback zzbxD;

    public static class Builder {
        private Strategy zzbxC = Strategy.DEFAULT;
        @Nullable
        private PublishCallback zzbxD;

        public PublishOptions build() {
            return new PublishOptions(this.zzbxC, this.zzbxD);
        }

        public Builder setCallback(PublishCallback publishCallback) {
            this.zzbxD = (PublishCallback) zzac.zzw(publishCallback);
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zzbxC = (Strategy) zzac.zzw(strategy);
            return this;
        }
    }

    private PublishOptions(Strategy strategy, @Nullable PublishCallback publishCallback) {
        this.zzbxC = strategy;
        this.zzbxD = publishCallback;
    }

    @Nullable
    public PublishCallback getCallback() {
        return this.zzbxD;
    }

    public Strategy getStrategy() {
        return this.zzbxC;
    }
}
