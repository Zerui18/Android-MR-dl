package com.smrtbeat;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Point;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.games.stats.PlayerStats;
import com.tapjoy.TapjoyConnectCore;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;

class ag {
    private static ag A = null;
    private static final int a = 4;
    private static final int b = 8;
    private final String B = "attribute vec2 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = vec4(aPosition, 0.0, 1.0);\n  vTextureCoord = aTextureCoord;\n}\n";
    private final String C = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    private int c;
    private int d;
    private int e;
    private int f = 0;
    private boolean g = false;
    private int h = -1;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private ByteBuffer o = null;
    private Bitmap p = null;
    private Bitmap q = null;
    private Canvas r = null;
    private Thread s = null;
    private boolean t = true;
    private boolean u = false;
    private long v = 0;
    private boolean w = false;
    private FloatBuffer x = null;
    private FloatBuffer y = null;
    private List z = new ArrayList();

    ag() {
    }

    private int a(int i, String str) {
        int glCreateShader = GLES20.glCreateShader(i);
        if (glCreateShader != 0) {
            GLES20.glShaderSource(glCreateShader, str);
            GLES20.glCompileShader(glCreateShader);
            int[] iArr = new int[1];
            GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
            if (iArr[0] == 0) {
                GLES20.glDeleteShader(glCreateShader);
                return 0;
            }
        }
        return glCreateShader;
    }

    private int a(String str, String str2) {
        int a = a(35633, str);
        if (a == 0) {
            return 0;
        }
        int a2 = a(35632, str2);
        if (a2 == 0) {
            return 0;
        }
        int glCreateProgram = GLES20.glCreateProgram();
        if (glCreateProgram != 0) {
            GLES20.glAttachShader(glCreateProgram, a);
            e("glAttachShader");
            GLES20.glAttachShader(glCreateProgram, a2);
            e("glAttachShader");
            GLES20.glLinkProgram(glCreateProgram);
            int[] iArr = new int[1];
            GLES20.glGetProgramiv(glCreateProgram, 35714, iArr, 0);
            if (iArr[0] != 1) {
                GLES20.glDeleteShader(a);
                GLES20.glDeleteShader(a2);
                GLES20.glDeleteProgram(glCreateProgram);
                return 0;
            }
        }
        return glCreateProgram;
    }

    private void a(int i, int i2, int i3, int i4, int i5, boolean z, float f, boolean z2) {
        float[] fArr = new float[]{PlayerStats.UNSET_VALUE, PlayerStats.UNSET_VALUE, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, PlayerStats.UNSET_VALUE, PlayerStats.UNSET_VALUE, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER};
        int i6 = this.c;
        int i7 = this.d;
        int i8 = this.e;
        float f2 = (((float) i4) / ((float) i3)) / f;
        float f3 = (((float) i5) / ((float) i3)) / f;
        float[] fArr2 = new float[8];
        if (z2) {
            fArr2[0] = 0.0f;
            fArr2[1] = f3;
            fArr2[2] = TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER;
            fArr2[3] = f3;
            fArr2[4] = 0.0f;
            fArr2[5] = f3 - TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER;
            fArr2[6] = TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER;
            fArr2[7] = f3 - TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER;
        } else {
            fArr2[0] = 0.0f;
            fArr2[1] = 0.0f;
            fArr2[2] = f2;
            fArr2[3] = 0.0f;
            fArr2[4] = 0.0f;
            fArr2[5] = f3;
            fArr2[6] = f2;
            fArr2[7] = f3;
        }
        GLES20.glUseProgram(i2);
        this.x.position(0);
        this.x.put(fArr).position(0);
        GLES20.glEnableVertexAttribArray(i6);
        GLES20.glVertexAttribPointer(i6, 2, 5126, false, 0, this.x);
        this.y.position(0);
        this.y.put(fArr2).position(0);
        GLES20.glEnableVertexAttribArray(i7);
        GLES20.glVertexAttribPointer(i7, 2, 5126, false, 0, this.y);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glUniform1i(i8, 0);
        GLES20.glDrawArrays(5, 0, 4);
        GLES20.glBindTexture(3553, 0);
    }

    static void a(String str) {
        e().z.add(str);
    }

    static void a(boolean z) {
        e().g();
        e().w = z;
    }

    static boolean a() {
        e().h();
        e("beginOnDrawFrame");
        return e().t && !e().u;
    }

    private boolean a(int i, int i2) {
        int[] iArr = new int[1];
        int c = c(i, i2);
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.i = iArr[0];
        GLES20.glBindFramebuffer(36160, this.i);
        this.k = SmartBeatJni.newImageTargetTexture(i, i2, this.n, VERSION.SDK_INT >= 18 ? 1 : 0);
        if (this.k <= 0) {
            GLES20.glDeleteFramebuffers(1, iArr, 0);
            this.i = 0;
            return false;
        }
        GLES20.glBindTexture(3553, this.k);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.k, 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            bd.a(bg.ERROR, String.format("failed to init fbo1 : %d", new Object[]{Integer.valueOf(GLES20.glCheckFramebufferStatus(36160))}));
            return false;
        }
        GLES20.glGenFramebuffers(1, iArr, 0);
        this.h = iArr[0];
        GLES20.glBindFramebuffer(36160, this.h);
        GLES20.glGenRenderbuffers(1, iArr, 0);
        GLES20.glBindRenderbuffer(36161, iArr[0]);
        if (VERSION.SDK_INT >= 18) {
            GLES20.glRenderbufferStorage(36161, k(), c, c);
            if (GLES20.glGetError() != 0) {
                GLES20.glBindRenderbuffer(36161, 0);
                GLES20.glDeleteRenderbuffers(1, iArr, 0);
            } else {
                GLES20.glFramebufferRenderbuffer(36160, 36128, 36161, iArr[0]);
            }
        }
        GLES20.glGenTextures(1, iArr, 0);
        this.j = iArr[0];
        GLES20.glBindTexture(3553, this.j);
        GLES20.glTexImage2D(3553, 0, 6408, c, c, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.j, 0);
        if (GLES20.glCheckFramebufferStatus(36160) != 36053) {
            bd.a(bg.ERROR, String.format("failed to init fbo2 : %d", new Object[]{Integer.valueOf(GLES20.glCheckFramebufferStatus(36160))}));
            return false;
        }
        this.x = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.y = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        return true;
    }

    private int b(int i, int i2) {
        int max = Math.max(i, i2);
        int i3 = 128;
        int i4 = i * i2;
        while (i3 < max && i3 > 0 && i3 * i3 <= i4) {
            i3 <<= 1;
        }
        i3 >>= 1;
        return i3 > 512 ? 512 : i3;
    }

    static void b() {
        e().i();
        e("endOnDrawFrame");
    }

    static boolean b(String str) {
        return (str == null || str.length() <= 0) ? false : u.a(str) ? true : e().d(str);
    }

    private int c(int i, int i2) {
        int max = Math.max(i, i2);
        int i3 = 256;
        while (i3 < max && i3 > 0) {
            i3 <<= 1;
        }
        return i3;
    }

    private void c() {
        if (this.t && this.h <= 0) {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            this.u = !bd.j();
            if (!this.u) {
                if (VERSION.SDK_INT < 14) {
                    bd.a(bg.DEBUG, "Not support ScreenCapture(GLES) (supports from Android 4.0)");
                    this.t = false;
                } else if (g.E < 2) {
                    if (g.E == 0) {
                        bd.a(bg.WARN, "OpenGLES version may not be set. Please set version!");
                    }
                    bd.a(bg.DEBUG, "Not support ScreenCapture(GLES) (supports from ES2.0)");
                    this.t = false;
                } else if (!d()) {
                    bd.a(bg.DEBUG, String.format("Not supported ScreenCapture(GLES) (NDK load failed arch=%s)", new Object[]{bd.a(0)}));
                    this.t = false;
                } else if (Build.MODEL == null || Build.MODEL.length() <= 0) {
                    bd.a(bg.DEBUG, "Not supported ScreenCapture(GLES) (model name is missing)");
                    this.t = false;
                } else if (!u.a(Build.MODEL) && !d(Build.MODEL)) {
                    this.t = false;
                    bd.a(bg.DEBUG, String.format("Not support ScreenCapture(GLES) (unsupport model:%s)", new Object[]{Build.MODEL}));
                } else if (!this.w || VERSION.SDK_INT >= 18) {
                    EGLDisplay eglGetCurrentDisplay = egl10.eglGetCurrentDisplay();
                    EGLSurface eglGetCurrentSurface = egl10.eglGetCurrentSurface(12377);
                    int[] iArr = new int[1];
                    egl10.eglQuerySurface(eglGetCurrentDisplay, eglGetCurrentSurface, 12375, iArr);
                    this.l = iArr[0];
                    egl10.eglQuerySurface(eglGetCurrentDisplay, eglGetCurrentSurface, 12374, iArr);
                    this.m = iArr[0];
                    if (this.l <= 0 || this.m <= 0) {
                        if (VERSION.SDK_INT >= 17) {
                            Point a = am.a();
                            this.l = a.x;
                            this.m = a.y;
                        }
                        if (this.l <= 0 || this.m <= 0) {
                            this.t = false;
                            return;
                        }
                    }
                    this.n = b(this.l, this.m);
                    g.Y = GLES20.glGetString(7936);
                    g.Z = GLES20.glGetString(7937);
                    g.aa = GLES20.glGetString(7938);
                    ai aiVar = new ai(this);
                    aiVar.a(0, true);
                    this.t = a(this.l, this.m);
                    aiVar.a(true, true);
                    if (!this.t) {
                        bd.a(bg.DEBUG, "Not support ScreenCapture(GLES) (failed to alloc memory)");
                        g();
                        this.t = false;
                    } else if (j()) {
                        int i = this.n;
                        i = SmartBeatJni.getTextureLongerSideLength();
                        this.o = ByteBuffer.allocateDirect((i * i) * 4);
                        this.p = Bitmap.createBitmap(i, i, Config.ARGB_8888);
                        i = c(this.l, this.m) / this.n;
                        this.q = Bitmap.createBitmap(this.l / i, this.m / i, Config.ARGB_8888);
                        this.r = new Canvas(this.q);
                    } else {
                        bd.a(bg.ERROR, "failed to init");
                        g();
                        this.t = false;
                    }
                } else {
                    bd.a(bg.INFO, "Android version must be JBMR2 or more for screen capture with Stencil Buffer.");
                    this.t = false;
                }
            }
        }
    }

    private boolean d() {
        return g.D;
    }

    private boolean d(String str) {
        if (str == null) {
            return false;
        }
        for (String equals : this.z) {
            if (equals.equals(str)) {
                bd.a(bg.DEBUG, String.format("this model(%s) is allowd by custmer whitelist", new Object[]{str}));
                return true;
            }
        }
        return false;
    }

    private static ag e() {
        if (A == null) {
            synchronized (ag.class) {
                if (A == null) {
                    A = new ag();
                }
            }
        }
        return A;
    }

    private static void e(String str) {
        while (GLES20.glGetError() != 0) {
            bd.a(bg.ERROR, String.format("%s:glErrro %d", new Object[]{str, Integer.valueOf(r0)}));
        }
    }

    private boolean f() {
        if (this.s != null || this.g) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.v < 1000 || g.X) {
            return false;
        }
        this.v = currentTimeMillis;
        return true;
    }

    private void g() {
        e("cleanup");
        this.f = 0;
        this.h = -1;
        this.i = 0;
        this.l = 0;
        this.m = 0;
        if (this.p != null) {
            this.p.recycle();
            this.p = null;
        }
        if (this.q != null) {
            bd.a(h.EGles, this.q);
            this.q = null;
        }
        if (this.r != null) {
            this.r = null;
        }
        this.v = System.currentTimeMillis();
        this.t = true;
    }

    private void h() {
        c();
        if (this.t && !this.u && this.h > 0 && f()) {
            GLES20.glBindFramebuffer(36160, this.h);
            GLES20.glClear(16640);
            this.g = true;
        }
    }

    private void i() {
        if (this.t && !this.u && this.g) {
            int[] iArr = new int[1];
            GLES20.glGetIntegerv(36006, iArr, 0);
            if (iArr[0] == this.h) {
                int c = c(this.l, this.m);
                ai aiVar = new ai(this);
                aiVar.a(this.j, true);
                GLES20.glBindFramebuffer(36160, this.i);
                GLES20.glClear(16640);
                GLES20.glViewport(0, 0, this.n, this.n);
                a(this.j, this.f, c, this.l, this.m, false, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, true);
                aiVar.a(true, false);
                this.s = new Thread(new ah(this).a(this.o));
                this.s.start();
                aiVar = new ai(this);
                aiVar.a(this.j, true);
                GLES20.glBindFramebuffer(36160, 0);
                GLES20.glClear(16640);
                GLES20.glViewport(0, 0, this.l, this.m);
                a(this.j, this.f, c, this.l, this.m, false, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER, false);
                aiVar.a(true, false);
            }
            this.g = false;
        }
    }

    private boolean j() {
        this.f = a("attribute vec2 aPosition;\nattribute vec2 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position = vec4(aPosition, 0.0, 1.0);\n  vTextureCoord = aTextureCoord;\n}\n", "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n");
        this.c = GLES20.glGetAttribLocation(this.f, "aPosition");
        e("glGetAttribLocation aPosition");
        if (this.c == -1) {
            bd.a(bg.ERROR, "Could not get attrib location for aPosition");
            return false;
        }
        this.d = GLES20.glGetAttribLocation(this.f, "aTextureCoord");
        e("glGetAttribLocation aTextureCoord");
        if (this.d == -1) {
            bd.a(bg.ERROR, "Could not get attrib location for aTextureCoord");
            return false;
        }
        this.e = GLES20.glGetUniformLocation(this.f, "sTexture");
        e("glGetAttribLocation sTexture");
        if (this.e != -1) {
            return true;
        }
        bd.a(bg.ERROR, "Could not get attrib location for sTexture");
        return false;
    }

    private static int k() {
        return 35056;
    }
}
