package co.cyberz.fox.b;

import co.cyberz.util.string.StringUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public final class b {
    public boolean a;
    public int b;
    public int c = 10;

    public b(String str) {
        try {
            Map a = a(str);
            this.a = "1".equals(a(a, "bre"));
            String a2 = a(a, "delay");
            this.b = StringUtil.isEmpty(a2) ? 0 : Integer.parseInt(a2);
            a2 = a(a, "deferred_timeout");
            this.c = StringUtil.isEmpty(a2) ? this.c : Integer.parseInt(a2);
        } catch (Exception e) {
        }
    }

    private static String a(Map<String, String> map, String str) {
        try {
            if (map.containsKey(str)) {
                return (String) map.get(str);
            }
        } catch (Exception e) {
        }
        return null;
    }

    private static Map<String, String> a(String str) {
        Map hashMap = new HashMap();
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
            while (stringTokenizer.hasMoreTokens()) {
                StringTokenizer stringTokenizer2 = new StringTokenizer(stringTokenizer.nextToken(), "=");
                if (stringTokenizer2.countTokens() == 2) {
                    hashMap.put(stringTokenizer2.nextToken(), stringTokenizer2.nextToken());
                }
            }
        } catch (Exception e) {
        }
        return hashMap;
    }
}
