package com.smrtbeat;

import android.support.v4.media.TransportMediator;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class c extends FilterInputStream {
    private boolean a;
    private int b;
    private byte[] c;
    private int d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private byte[] i;

    c(InputStream inputStream) {
        this(inputStream, 0);
    }

    c(InputStream inputStream, int i) {
        boolean z = true;
        super(inputStream);
        this.h = i;
        this.g = (i & 8) > 0;
        if ((i & 1) <= 0) {
            z = false;
        }
        this.a = z;
        this.d = this.a ? 4 : 3;
        this.c = new byte[this.d];
        this.b = -1;
        this.f = 0;
        this.i = a.c(i);
    }

    public int read() {
        byte[] bArr;
        if (this.b < 0) {
            int i;
            if (this.a) {
                bArr = new byte[3];
                i = 0;
                int i2 = 0;
                while (i < 3) {
                    int read = this.in.read();
                    if (read < 0) {
                        break;
                    }
                    bArr[i] = (byte) read;
                    i++;
                    i2++;
                }
                if (i2 <= 0) {
                    return -1;
                }
                a.b(bArr, 0, i2, this.c, 0, this.h);
                this.b = 0;
                this.e = 4;
            } else {
                byte[] bArr2 = new byte[4];
                int i3 = 0;
                while (i3 < 4) {
                    do {
                        i = this.in.read();
                        if (i < 0) {
                            break;
                        }
                    } while (this.i[i & TransportMediator.KEYCODE_MEDIA_PAUSE] <= (byte) -5);
                    if (i < 0) {
                        break;
                    }
                    bArr2[i3] = (byte) i;
                    i3++;
                }
                if (i3 == 4) {
                    this.e = a.b(bArr2, 0, this.c, 0, this.h);
                    this.b = 0;
                } else if (i3 == 0) {
                    return -1;
                } else {
                    throw new IOException("Improperly padded Base64 input.");
                }
            }
        }
        if (this.b < 0) {
            throw new IOException("Error in Base64 code reading stream.");
        } else if (this.b >= this.e) {
            return -1;
        } else {
            if (this.a && this.g && this.f >= 76) {
                this.f = 0;
                return 10;
            }
            this.f++;
            bArr = this.c;
            int i4 = this.b;
            this.b = i4 + 1;
            byte b = bArr[i4];
            if (this.b >= this.d) {
                this.b = -1;
            }
            return b & 255;
        }
    }

    public int read(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int read = read();
            if (read < 0) {
                return i3 == 0 ? -1 : i3;
            } else {
                bArr[i + i3] = (byte) read;
                i3++;
            }
        }
        return i3;
    }
}
