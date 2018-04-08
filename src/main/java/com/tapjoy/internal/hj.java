package com.tapjoy.internal;

public final class hj {
    public static hj a = new hj(null);
    public String b;
    public Throwable c;
    private Object[] d;

    public hj(String str) {
        this(str, null, null);
    }

    public hj(String str, Object[] objArr, Throwable th) {
        this.b = str;
        this.c = th;
        if (th == null) {
            this.d = objArr;
        } else if (objArr == null || objArr.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        } else {
            int length = objArr.length - 1;
            Object obj = new Object[length];
            System.arraycopy(objArr, 0, obj, 0, length);
            this.d = obj;
        }
    }
}
