package co.cyberz.common.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import co.cyberz.util.b.a;

public final class b {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    private final ApplicationInfo e;

    public b(Context context) {
        try {
            this.e = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            this.d = a("APPADFORCE_FORWARD_RECEIVER");
            this.a = a("APPADFORCE_ID_DIR");
            this.b = a("APPADFORCE_ID_FILE");
            this.c = a("APPADFORCE_USE_EXTERNAL_STORAGE");
        } catch (Exception e) {
            throw new a("meta data init error");
        }
    }

    private String a(@NonNull String str) {
        String str2 = null;
        try {
            Object obj = this.e.metaData.get(str);
            if (obj != null) {
                str2 = obj.toString();
            }
        } catch (Exception e) {
            new StringBuilder("init error : ").append(str).append(" is not found.");
        }
        return str2;
    }
}
