package co.cyberz.fox.a;

import android.util.Log;
import co.cyberz.fox.b.b;
import co.cyberz.util.g.a;
import co.cyberz.util.string.StringUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public final class h extends b<b> {
    private static b a(InputStream inputStream) {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2;
        Throwable th;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            try {
                String readLine = bufferedReader.readLine();
                if (StringUtil.isEmpty(readLine)) {
                    Log.e("F.O.X", "CheckCvModeTask: Parameter is nothing.");
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e2) {
                        }
                    }
                    return null;
                }
                b bVar = new b(readLine);
                try {
                    bufferedReader.close();
                } catch (IOException e3) {
                }
                if (inputStream == null) {
                    return bVar;
                }
                try {
                    inputStream.close();
                    return bVar;
                } catch (Exception e4) {
                    return bVar;
                }
            } catch (Exception e5) {
                bufferedReader2 = bufferedReader;
                try {
                    Log.e("F.O.X", "CheckCvModeTask: Parameter is nothing.");
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                        } catch (IOException e6) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e7) {
                        }
                    }
                    return null;
                } catch (Throwable th2) {
                    bufferedReader = bufferedReader2;
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e8) {
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Exception e9) {
                        }
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                throw th;
            }
        } catch (Exception e10) {
            bufferedReader2 = null;
            Log.e("F.O.X", "CheckCvModeTask: Parameter is nothing.");
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return null;
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    protected final a<String> a(a<String> aVar) {
        aVar.a("_bv", this.b.h);
        return aVar;
    }

    protected final /* bridge */ /* synthetic */ Object a(int i, InputStream inputStream) {
        return a(inputStream);
    }

    public final String a() {
        return this.b.c + "/p/tmck";
    }
}
