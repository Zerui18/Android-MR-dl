package com.moat.analytics.mobile.tjy;

import android.view.ViewGroup;
import java.util.Iterator;

class bo implements Iterable {
    private final ViewGroup a;

    private bo(ViewGroup viewGroup) {
        this.a = viewGroup;
    }

    public Iterator iterator() {
        return new bp();
    }
}