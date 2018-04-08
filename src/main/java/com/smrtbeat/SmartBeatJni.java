package com.smrtbeat;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build.VERSION;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.Callable;

class SmartBeatJni {
    private static final String a = "SmartBeatNdk";
    private static final String b = "SmartBeatOpenGLNdk";
    private static final String c = "libSmartBeatNdk.so.bin";
    private static final String d = "libSmartBeatOpenGLNdk.so.bin";
    private static final String e = "com.smrtbeat";
    private static final int f = 8192;

    SmartBeatJni() {
    }

    public static void a(String str) {
        File file = new File(str);
        if (bd.g()) {
            Thread thread = new Thread(new ay().a(file));
            thread.start();
            try {
                thread.join(5000);
                return;
            } catch (InterruptedException e) {
                return;
            }
        }
        file.delete();
    }

    private static void a(String str, String str2) {
        File file = new File(str);
        if (file != null && file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles(new bb(str2));
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
        }
    }

    static boolean a(Context context) {
        boolean a = a(context, a, c, 8, new az());
        if (a) {
            File file = new File(g.A + "/dump_tmp");
            file.mkdirs();
            initNdk(file.getAbsolutePath());
            bd.a(bg.DEBUG, "NDK is initialized");
        }
        return a;
    }

    private static boolean a(Context context, String str, String str2, int i) {
        a(str, str2);
        bd.a(bg.DEBUG, "Install NDK Library from assets");
        AssetManager assets = context.getAssets();
        int i2 = 0;
        boolean z = false;
        while (true) {
            String a = bd.a(i2);
            if (a == null) {
                break;
            }
            a(new StringBuilder(String.valueOf(str)).append("/").append(a).toString(), str2);
            try {
                if (a(assets.open("com.smrtbeat/" + a + "/" + str2), new File(new StringBuilder(String.valueOf(str)).append("/").append(a).append("/").append(str2).append(".").append(String.valueOf(i)).toString()))) {
                    z = true;
                }
            } catch (IOException e) {
            }
            i2++;
        }
        if (!z) {
            bd.a(bg.WARN, String.format("Failed to install NDK Library SUPPORTED_ABIS:%s", new Object[]{bd.f()}));
        }
        return z;
    }

    private static boolean a(Context context, String str, String str2, int i, Callable callable) {
        boolean a = a(str, i, callable);
        if (a) {
            return a;
        }
        String str3 = context.getFilesDir() + "/" + e;
        a = a(str3, str2, i, callable);
        if (a) {
            return a;
        }
        a(context, str3, str2, i);
        return a(str3, str2, i, callable);
    }

    private static boolean a(File file, int i, Callable callable) {
        if (file == null || !file.exists()) {
            return false;
        }
        try {
            int intValue;
            System.load(file.getAbsolutePath());
            try {
                intValue = ((Integer) callable.call()).intValue();
            } catch (Exception e) {
                intValue = -1;
            }
            if (intValue != i) {
                bd.a(bg.WARN, String.format("Library might be old. The file shall be updated. Installed:%d, Current:%d", new Object[]{Integer.valueOf(intValue), Integer.valueOf(i)}));
                return false;
            }
            bd.a(bg.DEBUG, "Success to load NDK Lib (file) ver = " + String.valueOf(i));
            return true;
        } catch (UnsatisfiedLinkError e2) {
            bd.a(bg.WARN, "NDK Libarry(file) Link Error");
            return false;
        }
    }

    private static boolean a(InputStream inputStream, File file) {
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        boolean z = true;
        if (inputStream == null) {
            return false;
        }
        OutputStream outputStream = null;
        OutputStream fileOutputStream;
        try {
            file.getParentFile().mkdirs();
            file.createNewFile();
            fileOutputStream = new FileOutputStream(file);
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (-1 == read) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (FileNotFoundException e5) {
                e = e5;
            } catch (IOException e6) {
                e2 = e6;
                outputStream = fileOutputStream;
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileOutputStream = null;
            try {
                bd.a(bg.WARN, String.format("Failed to install NDK Library err:%s", new Object[]{e.toString()}));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e8) {
                    }
                }
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                        z = false;
                    } catch (IOException e9) {
                        z = false;
                    }
                    return z;
                }
                z = false;
                return z;
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e10) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e11) {
                    }
                }
                throw th;
            }
        } catch (IOException e12) {
            e2 = e12;
            try {
                bd.a(bg.WARN, String.format("Failed to install NDK Library err:%s", new Object[]{e2.toString()}));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e13) {
                    }
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                        z = false;
                    } catch (IOException e14) {
                        z = false;
                    }
                    return z;
                }
                z = false;
                return z;
            } catch (Throwable th3) {
                th = th3;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                throw th;
            }
        }
        return z;
    }

    private static boolean a(String str, int i, Callable callable) {
        try {
            int intValue;
            System.loadLibrary(str);
            try {
                intValue = ((Integer) callable.call()).intValue();
            } catch (Exception e) {
                intValue = -1;
            }
            if (intValue != i) {
                bd.a(bg.WARN, "Loaded ndk from libs folder but incompatible version. version must be " + i);
                return false;
            }
            bd.a(bg.DEBUG, "Success to load NDK Lib (" + str + ")");
            return true;
        } catch (UnsatisfiedLinkError e2) {
            return false;
        }
    }

    private static boolean a(String str, String str2, int i, Callable callable) {
        int i2 = 0;
        while (true) {
            String a = bd.a(i2);
            if (a == null) {
                return false;
            }
            if (a(new File(new StringBuilder(String.valueOf(str)).append("/").append(a).append("/").append(str2).append(".").append(String.valueOf(i)).toString()), i, callable)) {
                return true;
            }
            i2++;
        }
    }

    static boolean b(Context context) {
        return (VERSION.SDK_INT > 23 || bd.n()) ? false : a(context, b, d, 2, new ba());
    }

    static native boolean copyTextureBuffer(ByteBuffer byteBuffer);

    private static native int getGlLibVersion();

    static native int getTextureLongerSideLength();

    private static native int getVersion();

    private static native void initNdk(String str);

    static native int newImageTargetTexture(int i, int i2, int i3, int i4);
}
