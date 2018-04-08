package co.cyberz.util.g;

import co.cyberz.util.string.StringUtil;
import java.util.HashMap;

public final class a<K> extends HashMap<K, String> {
    public final String a(K k, String str) {
        return a(k, str, StringUtil.isEmpty(str));
    }

    public final String a(K k, String str, boolean z) {
        return !z ? (String) super.put(k, str) : "";
    }

    public final /* synthetic */ Object put(Object obj, Object obj2) {
        return a(obj, (String) obj2);
    }
}
