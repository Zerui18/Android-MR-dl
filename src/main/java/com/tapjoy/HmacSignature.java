package com.tapjoy;

import android.net.Uri;
import java.security.Key;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HmacSignature {
    private String a;
    private String b;

    public HmacSignature(String method, String secret) {
        this.a = method;
        this.b = secret;
    }

    public String sign(String url, Map params) {
        int i = 0;
        try {
            Key secretKeySpec = new SecretKeySpec(this.b.getBytes(), this.a);
            Mac instance = Mac.getInstance(this.a);
            instance.init(secretKeySpec);
            Uri parse = Uri.parse(url);
            String str = parse.getScheme() + "://" + parse.getHost();
            int i2 = ((parse.getScheme().equals("http") && parse.getPort() == 80) || (parse.getScheme().equals("https") && parse.getPort() == 443)) ? 1 : 0;
            if (i2 == 0 && -1 != parse.getPort()) {
                str = str + ":" + parse.getPort();
            }
            str = "POST&" + Uri.encode(str.toLowerCase() + parse.getPath()) + "&" + Uri.encode(a(params));
            TapjoyLog.v("HmacSignature", "Base Url: " + str);
            byte[] doFinal = instance.doFinal(str.getBytes());
            StringBuilder stringBuilder = new StringBuilder();
            int length = doFinal.length;
            while (i < length) {
                String toHexString = Integer.toHexString(doFinal[i] & 255);
                if (toHexString.length() == 1) {
                    stringBuilder.append('0');
                }
                stringBuilder.append(toHexString);
                i++;
            }
            return stringBuilder.toString();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean matches(String url, Map params, String signature) {
        return sign(url, params).equals(signature);
    }

    private static String a(Map map) {
        TreeSet treeSet = new TreeSet(map.keySet());
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            stringBuilder.append(str + "=" + ((String) map.get(str)) + "&");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("&"));
        TapjoyLog.v("HmacSignature", "Unhashed String: " + stringBuilder.toString());
        return stringBuilder.toString();
    }
}
