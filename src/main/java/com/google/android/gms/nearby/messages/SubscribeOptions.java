package com.google.android.gms.nearby.messages;

import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzac;

public final class SubscribeOptions {
    public static final SubscribeOptions DEFAULT = new Builder().build();
    private final Strategy zzbxC;
    private final MessageFilter zzbxR;
    @Nullable
    private final SubscribeCallback zzbxS;
    public final boolean zzbxT;

    public static class Builder {
        private Strategy zzbxC = Strategy.DEFAULT;
        private MessageFilter zzbxR = MessageFilter.INCLUDE_ALL_MY_TYPES;
        @Nullable
        private SubscribeCallback zzbxS;

        public SubscribeOptions build() {
            return new SubscribeOptions(this.zzbxC, this.zzbxR, this.zzbxS, false);
        }

        public Builder setCallback(SubscribeCallback subscribeCallback) {
            this.zzbxS = (SubscribeCallback) zzac.zzw(subscribeCallback);
            return this;
        }

        public Builder setFilter(MessageFilter messageFilter) {
            this.zzbxR = messageFilter;
            return this;
        }

        public Builder setStrategy(Strategy strategy) {
            this.zzbxC = strategy;
            return this;
        }
    }

    private SubscribeOptions(Strategy strategy, MessageFilter messageFilter, @Nullable SubscribeCallback subscribeCallback, boolean z) {
        this.zzbxC = strategy;
        this.zzbxR = messageFilter;
        this.zzbxS = subscribeCallback;
        this.zzbxT = z;
    }

    @Nullable
    public SubscribeCallback getCallback() {
        return this.zzbxS;
    }

    public MessageFilter getFilter() {
        return this.zzbxR;
    }

    public Strategy getStrategy() {
        return this.zzbxC;
    }
}
