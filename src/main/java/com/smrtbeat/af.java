package com.smrtbeat;

class af {
    final String a;
    final int b;

    af(String str) {
        this.a = new StringBuilder(String.valueOf(str)).append("\n").toString();
        this.b = str.getBytes().length;
    }
}
