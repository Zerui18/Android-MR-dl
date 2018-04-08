package com.smrtbeat;

import java.util.Arrays;

class u {
    private static final String[] a = new String[]{"HTL23", "LGL22", "Nexus 5", "SH-04F", "SH-06F", "SM-G900K", "SO-02F", "SOL23", "SOL25"};

    u() {
    }

    static boolean a(String str) {
        return Arrays.binarySearch(a, str) >= 0;
    }
}
