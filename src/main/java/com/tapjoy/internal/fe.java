package com.tapjoy.internal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.concurrent.ConcurrentHashMap;

public class fe extends Observable {
    public final List b = new ArrayList();

    public class a {
        public final String a;
        public volatile Map b = new ConcurrentHashMap();
        final /* synthetic */ fe c;

        a(fe feVar, String str) {
            this.c = feVar;
            this.a = str;
        }

        public final Object a(String str) {
            Map map = this.b;
            return map != null ? map.get(str) : null;
        }
    }

    public final a a(String str) {
        a aVar = new a(this, str);
        this.b.add(aVar);
        return aVar;
    }

    public void setChanged() {
        super.setChanged();
        notifyObservers();
    }

    public final boolean a(String str, boolean z) {
        for (a a : this.b) {
            Object a2 = a.a(str);
            if (a2 != null) {
                if (a2 instanceof Boolean) {
                    return ((Boolean) a2).booleanValue();
                }
                if (!(a2 instanceof String)) {
                    continue;
                } else if ("true".equals(a2)) {
                    return true;
                } else {
                    if ("false".equals(a2)) {
                        return false;
                    }
                }
            }
        }
        return z;
    }

    public final long b(String str) {
        for (a a : this.b) {
            Object a2 = a.a(str);
            if (a2 != null) {
                if (a2 instanceof Number) {
                    return ((Number) a2).longValue();
                }
                if (a2 instanceof String) {
                    try {
                        return Long.parseLong((String) a2);
                    } catch (IllegalArgumentException e) {
                    }
                } else {
                    continue;
                }
            }
        }
        return 0;
    }

    private static long a(Object obj) {
        if (obj instanceof Number) {
            return ((Number) obj).longValue();
        }
        if (obj instanceof String) {
            return Long.parseLong((String) obj);
        }
        throw new IllegalArgumentException();
    }

    public final fd c(String str) {
        for (a a : this.b) {
            Object a2 = a.a(str);
            if (a2 instanceof List) {
                List list = (List) a2;
                try {
                    double doubleValue;
                    long a3 = a(list.get(0));
                    long a4 = a(list.get(1));
                    long a5 = a(list.get(2));
                    a2 = list.get(3);
                    if (a2 instanceof Number) {
                        doubleValue = ((Number) a2).doubleValue();
                    } else if (a2 instanceof String) {
                        doubleValue = Double.parseDouble((String) a2);
                    } else {
                        throw new IllegalArgumentException();
                    }
                    return new fd(a3, a4, a5, doubleValue);
                } catch (RuntimeException e) {
                }
            }
        }
        return fd.a;
    }
}
