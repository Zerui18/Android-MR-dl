package com.tapjoy.internal;

import android.graphics.Bitmap;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.internal.at.a;
import com.tapjoy.internal.gp.AnonymousClass2;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

public final class gt {
    public static final bm c = new bm() {
        public final /* synthetic */ Object a(br brVar) {
            return new gt(brVar);
        }
    };
    private static final ar d;
    public URL a;
    public Bitmap b;

    static {
        ar avVar = new av();
        if (!(avVar instanceof aw)) {
            Object aVar = new a((au) avVar);
        }
        d = avVar;
    }

    public gt(URL url) {
        this.a = url;
    }

    public final void a() {
        boolean a = eu.b().a("mm_external_cache_enabled", true);
        boolean z = !a;
        if (z) {
            this.b = (Bitmap) d.a(this.a);
            if (this.b != null) {
                return;
            }
        }
        if (a) {
            File a2 = gp.a.a(this.a);
            if (a2 != null) {
                gp gpVar = gp.a;
                this.b = gp.a(a2);
                if (this.b == null) {
                    a2.delete();
                } else if (z) {
                    d.a(this.a, this.b);
                    return;
                } else {
                    return;
                }
            }
        }
        URLConnection a3 = eh.a(this.a);
        long j = 0;
        String headerField = a3.getHeaderField("Cache-Control");
        if (!cr.c(headerField)) {
            String[] split = headerField.split(",");
            int length = split.length;
            int i = 0;
            while (i < length) {
                String trim = split[i].trim();
                if (trim.startsWith("max-age=")) {
                    try {
                        j = Long.parseLong(trim.substring(8));
                        break;
                    } catch (NumberFormatException e) {
                    }
                } else {
                    i++;
                }
            }
        }
        gp gpVar2 = gp.a;
        if (gp.a(j) && a) {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            InputStream inputStream = a3.getInputStream();
            cy.a(inputStream, byteArrayOutputStream);
            byteArrayOutputStream.close();
            inputStream.close();
            InputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            u uVar = u.a;
            this.b = u.a(byteArrayInputStream);
            if (this.b != null) {
                byteArrayInputStream.reset();
                gp gpVar3 = gp.a;
                URL url = this.a;
                if (gpVar3.b != null) {
                    gpVar3.e.submit(new AnonymousClass2(gpVar3, url, byteArrayInputStream, j));
                }
            }
        } else {
            InputStream inputStream2 = a3.getInputStream();
            u uVar2 = u.a;
            this.b = u.a(inputStream2);
        }
        if (z && this.b != null) {
            d.a(this.a, this.b);
        }
    }

    gt(br brVar) {
        Object obj;
        if (brVar.k() == bw.STRING) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            this.a = brVar.e();
            return;
        }
        brVar.h();
        String l = brVar.l();
        while (brVar.j()) {
            if (String.URL.equals(l)) {
                this.a = brVar.e();
            } else {
                brVar.s();
            }
        }
        brVar.i();
    }
}
