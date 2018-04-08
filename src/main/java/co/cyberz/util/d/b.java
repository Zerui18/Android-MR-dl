package co.cyberz.util.d;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b<R> extends co.cyberz.fox.a.b<R> {
    public abstract R a(@Nullable JSONObject jSONObject);

    protected final void a(@NonNull HttpURLConnection httpURLConnection) {
        super.a(httpURLConnection);
        httpURLConnection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
        httpURLConnection.setRequestProperty("Accept", "application/json");
    }

    @Nullable
    protected final R b(int i, @Nullable InputStream inputStream) {
        R r = null;
        if (inputStream != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                char[] cArr = new char[1024];
                StringBuffer stringBuffer = new StringBuffer();
                while (true) {
                    int read = bufferedReader.read(cArr);
                    if (read == -1) {
                        break;
                    }
                    stringBuffer.append(cArr, 0, read);
                }
                if (stringBuffer.length() > 0) {
                    r = a(new JSONObject(stringBuffer.toString()));
                }
            } catch (IOException e) {
            } catch (JSONException e2) {
            } catch (Exception e3) {
            }
        }
        return r;
    }

    protected final String c() {
        return null;
    }
}
