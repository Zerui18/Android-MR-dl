package com.smrtbeat;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

class aa {
    private static final String a = "----------V2ymHFg03ehbqgZCaKO6jy";
    private String b;
    private List c;

    public aa(String str, List list) {
        this.b = str;
        this.c = list;
    }

    private String a(ab abVar) {
        StringBuffer append = new StringBuffer("--").append(a).append("\r\n");
        append.append("Content-Disposition: form-data; name=\"").append(abVar.a()).append("\"; filename=\"").append(abVar.b()).append("\"\r\n").append("Content-Type: ").append("application/octet-stream").append("\r\n\r\n");
        return append.toString();
    }

    private byte[] a(File file) {
        FileInputStream fileInputStream;
        FileNotFoundException e;
        IOException e2;
        Throwable th;
        byte[] bArr = new byte[10];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            fileInputStream = new FileInputStream(file);
            while (fileInputStream.read(bArr) > 0) {
                try {
                    byteArrayOutputStream.write(bArr);
                } catch (FileNotFoundException e3) {
                    e = e3;
                } catch (IOException e4) {
                    e2 = e4;
                }
            }
            try {
                byteArrayOutputStream.close();
            } catch (IOException e5) {
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e6) {
                }
            }
        } catch (FileNotFoundException e7) {
            e = e7;
            fileInputStream = null;
            try {
                bd.a(bg.ERROR, String.format("HttpMultipartRequest:%s", new Object[]{e.getMessage()}));
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e8) {
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e9) {
                    }
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Throwable th2) {
                th = th2;
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e10) {
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e11) {
                    }
                }
                throw th;
            }
        } catch (IOException e12) {
            e2 = e12;
            fileInputStream = null;
            bd.a(bg.ERROR, String.format("HttpMultipartRequest:%s", new Object[]{e2.getMessage()}));
            try {
                byteArrayOutputStream.close();
            } catch (IOException e13) {
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e14) {
                }
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            byteArrayOutputStream.close();
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.smrtbeat.ar a(int r9, boolean r10) {
        /*
        r8 = this;
        r3 = 0;
        r2 = new com.smrtbeat.ar;
        r2.<init>();
        r0 = com.smrtbeat.g.m;
        r0 = r0.length();
        if (r0 > 0) goto L_0x0017;
    L_0x000e:
        r0 = com.smrtbeat.bg.ERROR;
        r1 = "Data cannot send due to invalide api key.";
        com.smrtbeat.bd.a(r0, r1);
        r0 = r2;
    L_0x0016:
        return r0;
    L_0x0017:
        r0 = new java.net.URL;	 Catch:{ Exception -> 0x0102, all -> 0x00e7 }
        r1 = r8.b;	 Catch:{ Exception -> 0x0102, all -> 0x00e7 }
        r0.<init>(r1);	 Catch:{ Exception -> 0x0102, all -> 0x00e7 }
        r0 = r0.openConnection();	 Catch:{ Exception -> 0x0102, all -> 0x00e7 }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ Exception -> 0x0102, all -> 0x00e7 }
        r0.setReadTimeout(r9);	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
        r0.setConnectTimeout(r9);	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
        r1 = "X-SmartBeat-Api-Key";
        r4 = com.smrtbeat.g.m;	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
        r0.addRequestProperty(r1, r4);	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
        r1 = "Content-Type";
        r4 = "multipart/form-data; boundary=----------V2ymHFg03ehbqgZCaKO6jy";
        r0.setRequestProperty(r1, r4);	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
        if (r10 == 0) goto L_0x0041;
    L_0x003a:
        r1 = "Content-Encoding";
        r4 = "gzip";
        r0.setRequestProperty(r1, r4);	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
    L_0x0041:
        r1 = 1;
        r0.setDoOutput(r1);	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
        r1 = 0;
        r0.setChunkedStreamingMode(r1);	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
        r0.connect();	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
        r3 = r0.getOutputStream();	 Catch:{ Exception -> 0x0105, all -> 0x00f8 }
        if (r10 == 0) goto L_0x0058;
    L_0x0052:
        r1 = new java.util.zip.GZIPOutputStream;	 Catch:{ Exception -> 0x010b, all -> 0x00f8 }
        r1.<init>(r3);	 Catch:{ Exception -> 0x010b, all -> 0x00f8 }
        r3 = r1;
    L_0x0058:
        r1 = r8.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        if (r1 == 0) goto L_0x0068;
    L_0x005c:
        r1 = r8.c;	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r4 = r1.iterator();	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
    L_0x0062:
        r1 = r4.hasNext();	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        if (r1 != 0) goto L_0x0095;
    L_0x0068:
        r1 = "------------V2ymHFg03ehbqgZCaKO6jy--\r\n";
        r1 = r1.getBytes();	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r3.write(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r3.flush();	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r3.close();	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r1 = r0.getResponseCode();	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r2.a = r1;	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r1 = r2.a;	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r1 != r4) goto L_0x0089;
    L_0x0083:
        r1 = com.smrtbeat.bd.a(r0);	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r2.b = r1;	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
    L_0x0089:
        if (r0 == 0) goto L_0x008e;
    L_0x008b:
        r0.disconnect();
    L_0x008e:
        if (r3 == 0) goto L_0x0093;
    L_0x0090:
        r3.close();	 Catch:{ IOException -> 0x00f6 }
    L_0x0093:
        r0 = r2;
        goto L_0x0016;
    L_0x0095:
        r1 = r4.next();	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r1 = (com.smrtbeat.ab) r1;	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r5 = r8.a(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r6 = "UTF-8";
        r5 = r5.getBytes(r6);	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r3.write(r5);	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r1 = r1.c();	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r1 = r8.a(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r3.write(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r1 = "\r\n";
        r1 = r1.getBytes();	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        r3.write(r1);	 Catch:{ Exception -> 0x00bd, all -> 0x00f8 }
        goto L_0x0062;
    L_0x00bd:
        r1 = move-exception;
        r7 = r1;
        r1 = r3;
        r3 = r0;
        r0 = r7;
    L_0x00c2:
        r4 = com.smrtbeat.bg.DEBUG;	 Catch:{ all -> 0x00fd }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00fd }
        r6 = "failed to send data";
        r5.<init>(r6);	 Catch:{ all -> 0x00fd }
        r0 = r0.toString();	 Catch:{ all -> 0x00fd }
        r0 = r5.append(r0);	 Catch:{ all -> 0x00fd }
        r0 = r0.toString();	 Catch:{ all -> 0x00fd }
        com.smrtbeat.bd.a(r4, r0);	 Catch:{ all -> 0x00fd }
        if (r3 == 0) goto L_0x00df;
    L_0x00dc:
        r3.disconnect();
    L_0x00df:
        if (r1 == 0) goto L_0x0093;
    L_0x00e1:
        r1.close();	 Catch:{ IOException -> 0x00e5 }
        goto L_0x0093;
    L_0x00e5:
        r0 = move-exception;
        goto L_0x0093;
    L_0x00e7:
        r0 = move-exception;
        r1 = r3;
    L_0x00e9:
        if (r1 == 0) goto L_0x00ee;
    L_0x00eb:
        r1.disconnect();
    L_0x00ee:
        if (r3 == 0) goto L_0x00f3;
    L_0x00f0:
        r3.close();	 Catch:{ IOException -> 0x00f4 }
    L_0x00f3:
        throw r0;
    L_0x00f4:
        r1 = move-exception;
        goto L_0x00f3;
    L_0x00f6:
        r0 = move-exception;
        goto L_0x0093;
    L_0x00f8:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
        goto L_0x00e9;
    L_0x00fd:
        r0 = move-exception;
        r7 = r1;
        r1 = r3;
        r3 = r7;
        goto L_0x00e9;
    L_0x0102:
        r0 = move-exception;
        r1 = r3;
        goto L_0x00c2;
    L_0x0105:
        r1 = move-exception;
        r7 = r1;
        r1 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x00c2;
    L_0x010b:
        r1 = move-exception;
        r7 = r1;
        r1 = r3;
        r3 = r0;
        r0 = r7;
        goto L_0x00c2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.smrtbeat.aa.a(int, boolean):com.smrtbeat.ar");
    }
}
