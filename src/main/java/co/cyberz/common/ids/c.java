package co.cyberz.common.ids;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.annotation.NonNull;
import co.cyberz.util.string.StringUtil;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import java.util.UUID;

public final class c {
    private static c a;
    private a b;
    private Context c;
    private int d = 3;

    public static class a {
        public final String a;
        public final b b;
        public final boolean c = false;

        public a(@NonNull String str, @NonNull b bVar) {
            this.a = str;
            this.b = bVar;
        }

        public a(@NonNull String str, @NonNull b bVar, byte b) {
            this.a = str;
            this.b = bVar;
        }

        public final String toString() {
            return this.a;
        }
    }

    public enum b {
        UUID("2"),
        ADID("4");
        
        public final String c;

        private b(String str) {
            this.c = str;
        }
    }

    private c(Context context) {
        this.c = context.getApplicationContext();
    }

    private a a(co.cyberz.util.e.a.a aVar) {
        a aVar2 = null;
        try {
            aVar2 = b();
        } catch (Exception e) {
        }
        if (aVar2 == null || StringUtil.isEmpty(aVar2.a)) {
            aVar2 = b(aVar);
        }
        if (StringUtil.isUUIDString(aVar2.a)) {
            return aVar2;
        }
        try {
            return new a(co.cyberz.util.h.a.a(aVar2.a, co.cyberz.util.h.a.a.XUNIQ), aVar2.b);
        } catch (Exception e2) {
            throw new co.cyberz.util.b.a("Could not generate the Xuniq");
        }
    }

    private static b a(String str) {
        if (str != null) {
            for (b bVar : b.values()) {
                if (bVar.c.equals(str)) {
                    break;
                }
            }
        }
        b bVar2 = null;
        if (bVar2 != null) {
            return bVar2;
        }
        throw new IllegalArgumentException("unrecognized xuniq index :" + str);
    }

    public static synchronized c a(Context context) {
        c cVar;
        synchronized (c.class) {
            if (a == null) {
                a = new c(context);
                co.cyberz.util.e.a.a(context);
            }
            cVar = a;
        }
        return cVar;
    }

    private void a(String str, String str2) {
        String str3 = str2 + "," + str;
        try {
            this.c.getSharedPreferences("co.cyberz.fox", 0).edit().putString("xuniq_id", str).putString("xuniq_type", str2).commit();
            co.cyberz.util.c.a aVar = new co.cyberz.util.c.a(this.c);
            if (aVar.a) {
                co.cyberz.util.c.a.a(Environment.getExternalStorageDirectory().getPath() + "/" + aVar.b, aVar.c, str3);
            }
        } catch (IOException e) {
        } catch (co.cyberz.util.b.a e2) {
        }
    }

    private a b() {
        FileInputStream openFileInput;
        String property;
        co.cyberz.util.c.a aVar;
        String[] split;
        FileInputStream fileInputStream;
        Throwable th;
        SharedPreferences sharedPreferences = this.c.getSharedPreferences("co.cyberz.fox", 0);
        String string = sharedPreferences.getString("xuniq_id", null);
        String string2 = sharedPreferences.getString("xuniq_type", null);
        if (!(StringUtil.isEmpty(string) || StringUtil.isEmpty(string2))) {
            b a = a(string2);
            if (a != null) {
                return new a(string, a);
            }
        }
        b a2;
        try {
            Properties properties = new Properties();
            openFileInput = this.c.openFileInput("__ADMAGE_RANDOM_DEVICE_ID__");
            try {
                properties.load(openFileInput);
                property = properties.getProperty("random_device_id", "");
                string2 = properties.getProperty("random_device_id_type", "");
                if (StringUtil.isEmpty(property) || StringUtil.isEmpty(string2)) {
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e) {
                        }
                    }
                    try {
                        aVar = new co.cyberz.util.c.a(this.c);
                        if (aVar.a) {
                            string2 = co.cyberz.util.c.b.a(Environment.getExternalStorageDirectory().getPath() + "/" + aVar.b + "/" + aVar.c);
                        } else {
                            string2 = null;
                        }
                        if (!StringUtil.isEmpty(string2)) {
                            split = StringUtil.split(string2, ",");
                            if (split.length > 1) {
                                a2 = a(split[0]);
                                property = split[1];
                                a(property, a2.c);
                                return new a(property, a2, (byte) 0);
                            }
                        }
                    } catch (IOException e2) {
                    }
                    return null;
                }
                a aVar2 = new a(property, a(string2));
                if (openFileInput == null) {
                    return aVar2;
                }
                try {
                    openFileInput.close();
                    return aVar2;
                } catch (IOException e3) {
                    return aVar2;
                }
            } catch (FileNotFoundException e4) {
                fileInputStream = openFileInput;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e5) {
                    }
                }
                aVar = new co.cyberz.util.c.a(this.c);
                if (aVar.a) {
                    string2 = null;
                } else {
                    string2 = co.cyberz.util.c.b.a(Environment.getExternalStorageDirectory().getPath() + "/" + aVar.b + "/" + aVar.c);
                }
                if (StringUtil.isEmpty(string2)) {
                    split = StringUtil.split(string2, ",");
                    if (split.length > 1) {
                        a2 = a(split[0]);
                        property = split[1];
                        a(property, a2.c);
                        return new a(property, a2, (byte) 0);
                    }
                }
                return null;
            } catch (IOException e6) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e7) {
                    }
                }
                aVar = new co.cyberz.util.c.a(this.c);
                if (aVar.a) {
                    string2 = co.cyberz.util.c.b.a(Environment.getExternalStorageDirectory().getPath() + "/" + aVar.b + "/" + aVar.c);
                } else {
                    string2 = null;
                }
                if (StringUtil.isEmpty(string2)) {
                    split = StringUtil.split(string2, ",");
                    if (split.length > 1) {
                        a2 = a(split[0]);
                        property = split[1];
                        a(property, a2.c);
                        return new a(property, a2, (byte) 0);
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e8) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e9) {
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            aVar = new co.cyberz.util.c.a(this.c);
            if (aVar.a) {
                string2 = null;
            } else {
                string2 = co.cyberz.util.c.b.a(Environment.getExternalStorageDirectory().getPath() + "/" + aVar.b + "/" + aVar.c);
            }
            if (StringUtil.isEmpty(string2)) {
                split = StringUtil.split(string2, ",");
                if (split.length > 1) {
                    a2 = a(split[0]);
                    property = split[1];
                    a(property, a2.c);
                    return new a(property, a2, (byte) 0);
                }
            }
            return null;
        } catch (IOException e10) {
            openFileInput = null;
            if (openFileInput != null) {
                openFileInput.close();
            }
            aVar = new co.cyberz.util.c.a(this.c);
            if (aVar.a) {
                string2 = co.cyberz.util.c.b.a(Environment.getExternalStorageDirectory().getPath() + "/" + aVar.b + "/" + aVar.c);
            } else {
                string2 = null;
            }
            if (StringUtil.isEmpty(string2)) {
                split = StringUtil.split(string2, ",");
                if (split.length > 1) {
                    a2 = a(split[0]);
                    property = split[1];
                    a(property, a2.c);
                    return new a(property, a2, (byte) 0);
                }
            }
            return null;
        } catch (Throwable th3) {
            th = th3;
            openFileInput = null;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
    }

    private a b(co.cyberz.util.e.a.a aVar) {
        a c;
        if (aVar == null || StringUtil.isEmpty(aVar.a)) {
            c = c();
        } else {
            try {
                c = new a(co.cyberz.util.h.a.b(aVar.a), b.ADID);
            } catch (NoSuchAlgorithmException e) {
                c = c();
            }
        }
        a(c.a, c.b.c);
        return c;
    }

    private static a c() {
        return new a(UUID.randomUUID().toString(), b.UUID);
    }

    public final synchronized a a() {
        return a(this.d);
    }

    public final synchronized a a(int i) {
        a aVar;
        if (this.b != null) {
            aVar = this.b;
        } else {
            try {
                co.cyberz.util.e.a.a aVar2 = co.cyberz.util.e.a.a(this.c).a;
                if (aVar2 == null) {
                    Context context = this.c;
                    new StringBuilder("CurrentThreadName : ").append(Thread.currentThread().getName());
                    if (!Thread.currentThread().equals(context.getMainLooper().getThread())) {
                        aVar2 = co.cyberz.util.e.a.a(this.c).a(i);
                        new StringBuilder("[Xuniq] Adid : ").append(aVar2.toString());
                    }
                }
                this.b = a(aVar2);
                new StringBuilder("[Xuniq] Xuniq : ").append(this.b.toString());
            } catch (co.cyberz.util.b.a e) {
            }
            aVar = this.b;
        }
        return aVar;
    }

    public final String toString() {
        return this.b.a == null ? null : this.b.a;
    }
}
