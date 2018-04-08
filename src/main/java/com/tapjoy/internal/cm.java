package com.tapjoy.internal;

import java.math.BigInteger;

public final class cm extends Number {
    private final String a;

    public cm(String str) {
        this.a = str;
    }

    public final boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Number)) {
            return false;
        }
        Number number = (Number) o;
        if (number instanceof Integer) {
            if (intValue() != number.intValue()) {
                return false;
            }
            return true;
        } else if (number instanceof Long) {
            if (longValue() != number.longValue()) {
                return false;
            }
            return true;
        } else if (number instanceof Float) {
            if (floatValue() != number.floatValue()) {
                return false;
            }
            return true;
        } else if (!(number instanceof Double)) {
            return this.a.equals(number.toString());
        } else {
            if (doubleValue() != number.doubleValue()) {
                return false;
            }
            return true;
        }
    }

    public final int intValue() {
        try {
            return Integer.parseInt(this.a);
        } catch (NumberFormatException e) {
            try {
                return (int) Long.parseLong(this.a);
            } catch (NumberFormatException e2) {
                return new BigInteger(this.a).intValue();
            }
        }
    }

    public final long longValue() {
        try {
            return Long.parseLong(this.a);
        } catch (NumberFormatException e) {
            return new BigInteger(this.a).longValue();
        }
    }

    public final float floatValue() {
        return Float.parseFloat(this.a);
    }

    public final double doubleValue() {
        return Double.parseDouble(this.a);
    }

    public final String toString() {
        return this.a;
    }
}
