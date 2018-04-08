package co.cyberz.util.string;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

public class StringUtil {
    public static String formatUrl(String str, String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = urlEncode(strArr[i]);
        }
        return new MessageFormat(str).format(strArr);
    }

    public static String getDomain(String str) {
        if (isEmpty(str)) {
            return null;
        }
        int indexOf = str.indexOf("://");
        if (indexOf < 0) {
            return str;
        }
        indexOf += 3;
        int indexOf2 = str.indexOf("/", indexOf);
        return indexOf2 > 0 ? str.substring(indexOf, indexOf2) : str.substring(indexOf, str.length());
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isUUIDString(String str) {
        if (isEmpty(str)) {
            return false;
        }
        try {
            UUID fromString = UUID.fromString(str);
            return fromString != null ? str.equals(fromString.toString()) : false;
        } catch (Exception e) {
            return false;
        }
    }

    public static <T> String join(List<T> list, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (T obj : list) {
            stringBuffer.append(obj.toString());
            stringBuffer.append(str);
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        return stringBuffer.toString();
    }

    public static <T> String join(T[] tArr, String str) {
        return join(Arrays.asList(tArr), str);
    }

    public static String mapToUrlString(Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Entry entry : map.entrySet()) {
            String urlEncode = urlEncode((String) entry.getKey());
            String urlEncode2 = urlEncode((String) entry.getValue());
            if (i > 0) {
                stringBuilder.append("&");
            }
            stringBuilder.append(urlEncode).append("=").append(urlEncode2);
            i++;
        }
        return stringBuilder.toString();
    }

    public static String nvl(Double d) {
        return nvl(d, "");
    }

    public static String nvl(Double d, String str) {
        return d == null ? str : d.toString();
    }

    public static String nvl(Integer num) {
        return nvl(num, "");
    }

    public static String nvl(Integer num, String str) {
        return num == null ? str : num.toString();
    }

    public static String nvl(String str) {
        return nvl(str, "");
    }

    public static String nvl(String str, String str2) {
        return isEmpty(str) ? str2 : str;
    }

    public static String[] split(Object obj, String str) {
        return split(obj, str, 0);
    }

    public static String[] split(Object obj, String str, int i) {
        int i2 = 0;
        if (obj == null) {
            return new String[0];
        }
        String obj2 = obj.toString();
        if (obj2.length() == 0) {
            return new String[0];
        }
        ArrayList arrayList = new ArrayList();
        if (str.startsWith("\\") && str.length() >= 2) {
            str = str.substring(1);
        }
        int length = obj2.length();
        int i3 = 0;
        while (i3 < length) {
            int indexOf = obj2.indexOf(str, i3);
            if (indexOf < 0) {
                break;
            }
            arrayList.add(obj2.substring(i3, indexOf));
            i3 = str.length() + indexOf;
            if (i > 0 && arrayList.size() >= i) {
                break;
            }
        }
        arrayList.add(obj2.substring(i3));
        String[] strArr = new String[arrayList.size()];
        length = strArr.length;
        while (i2 < length) {
            strArr[i2] = (String) arrayList.get(i2);
            i2++;
        }
        return strArr;
    }

    public static String urlDecode(String str) {
        if (!isEmpty(str)) {
            try {
                str = URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        return str;
    }

    public static String urlEncode(String str) {
        if (!isEmpty(str)) {
            try {
                str = URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
            }
        }
        return str;
    }
}
