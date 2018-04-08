package co.cyberz.util.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import co.cyberz.util.string.StringUtil;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public abstract class a<R> {
    private final String a = "FOX";
    private final String b = "FOX-USERAGENT";
    private String c;
    private String d;

    protected enum a {
        GET("GET"),
        POST("POST");
        
        public final String c;

        private a(String str) {
            this.c = str;
        }
    }

    private HttpURLConnection b(String str) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            if (httpURLConnection != null) {
                a(httpURLConnection);
            }
            return httpURLConnection;
        } catch (Exception e) {
            throw new co.cyberz.util.b.a("http");
        }
    }

    public abstract String a();

    public String a(String str) {
        return str;
    }

    protected void a(@NonNull HttpURLConnection httpURLConnection) {
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(30000);
        httpURLConnection.setDoInput(true);
        this.d = a("FOX-USERAGENT");
        httpURLConnection.setRequestProperty("User-Agent", this.d);
    }

    public a b() {
        return a.GET;
    }

    public abstract R b(int i, @Nullable InputStream inputStream);

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    public final R i() {
        OutputStreamWriter outputStreamWriter;
        Throwable th;
        HttpURLConnection httpURLConnection;
        InputStream inputStream = null;
        if (StringUtil.isEmpty(this.c)) {
            this.c = a();
        }
        String d = d();
        if (!StringUtil.isEmpty(d)) {
            this.c += "?" + d;
        }
        HttpURLConnection b = b(this.c);
        new StringBuilder("send http : ").append(this.c);
        if (b != null) {
            try {
                d = c();
                if (d != null) {
                    b.setDoInput(true);
                    b.setDoOutput(true);
                    b.setUseCaches(false);
                    b.setRequestMethod(b().c);
                    try {
                        outputStreamWriter = new OutputStreamWriter(b.getOutputStream());
                        try {
                            outputStreamWriter.write(d);
                            try {
                                outputStreamWriter.close();
                            } catch (IOException e) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (outputStreamWriter != null) {
                                try {
                                    outputStreamWriter.close();
                                } catch (IOException e2) {
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        outputStreamWriter = inputStream;
                        if (outputStreamWriter != null) {
                            outputStreamWriter.close();
                        }
                        throw th;
                    }
                }
                b.connect();
                int responseCode = b.getResponseCode();
                httpURLConnection = b;
                while (true) {
                    if ((responseCode == 302 ? 1 : null) != null) {
                        try {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            httpURLConnection.disconnect();
                            httpURLConnection = b(headerField);
                            if (httpURLConnection != null) {
                                httpURLConnection.connect();
                                responseCode = httpURLConnection.getResponseCode();
                            }
                        } catch (Throwable th4) {
                            th = th4;
                        }
                    } else {
                        try {
                            break;
                        } catch (Exception e3) {
                            inputStream = httpURLConnection.getErrorStream();
                        } catch (Throwable th5) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e4) {
                                }
                            }
                        }
                    }
                }
                inputStream = httpURLConnection.getInputStream();
                R b2 = b(responseCode, inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
                httpURLConnection.disconnect();
                return b2;
            } catch (Throwable th6) {
                th = th6;
                httpURLConnection = b;
            }
        } else {
            throw new co.cyberz.util.b.a("http");
        }
        httpURLConnection.disconnect();
        throw th;
    }
}
