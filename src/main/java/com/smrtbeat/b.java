package com.smrtbeat;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

class b extends ObjectInputStream {
    private final /* synthetic */ ClassLoader a;

    b(InputStream inputStream, ClassLoader classLoader) {
        this.a = classLoader;
        super(inputStream);
    }

    public Class resolveClass(ObjectStreamClass objectStreamClass) {
        Class cls = Class.forName(objectStreamClass.getName(), false, this.a);
        return cls == null ? super.resolveClass(objectStreamClass) : cls;
    }
}
