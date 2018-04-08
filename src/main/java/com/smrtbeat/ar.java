package com.smrtbeat;

import com.tapjoy.TJAdUnitConstants;
import org.json.JSONArray;
import org.json.JSONObject;

class ar {
    int a = 0;
    String b = "";

    ar() {
    }

    private boolean a(String str, String str2) {
        boolean z = false;
        try {
            JSONArray jSONArray = new JSONObject(str).getJSONArray("filesSaved");
            for (int i = 0; i < jSONArray.length(); i++) {
                if (str2.equals(jSONArray.get(i))) {
                    z = true;
                }
            }
        } catch (Exception e) {
        }
        return z;
    }

    private static boolean b(String str) {
        try {
            return "OK".equals(new JSONObject(str).get("status"));
        } catch (Exception e) {
            return false;
        }
    }

    as a() {
        return b(this.b) ? as.OK : (this.a == 400 || this.a == TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL) ? as.FAILED_BY_DATA : as.FAILED_BY_OTHER;
    }

    as a(String str) {
        return (this.a == 200 && a(this.b, str)) ? as.OK : (this.a == 400 || this.a == TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL) ? as.FAILED_BY_DATA : as.FAILED_BY_OTHER;
    }

    public String toString() {
        return "\"code\":" + this.a + ", \"data\":\"" + this.b + "\"";
    }
}
