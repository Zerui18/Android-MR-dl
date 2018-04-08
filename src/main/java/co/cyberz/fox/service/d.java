package co.cyberz.fox.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.cyberz.common.b.b;
import co.cyberz.util.f.a;
import co.cyberz.util.string.StringUtil;
import com.tapjoy.TapjoyConstants;
import java.lang.reflect.Method;

public class d extends BroadcastReceiver {
    private final String a = "com.android.vending.INSTALL_REFERRER";

    private void a(Context context, Intent intent) {
        try {
            b bVar = new b(context);
            if (!StringUtil.isEmpty(bVar.d)) {
                for (String str : bVar.d.indexOf("|") != -1 ? StringUtil.split(bVar.d, "|") : new String[]{bVar.d}) {
                    Class loadClass = getClass().getClassLoader().loadClass(str);
                    Object newInstance = loadClass.newInstance();
                    Method method = loadClass.getMethod("onReceive", new Class[]{Context.class, Intent.class});
                    a.a("FORWARD INSTALL RECEIVER : " + str);
                    method.invoke(newInstance, new Object[]{context, intent});
                }
            }
        } catch (co.cyberz.util.b.a e) {
        } catch (Exception e2) {
            a.b("Not found class to forward");
        }
    }

    public void onReceive(Context context, Intent intent) {
        if ("com.android.vending.INSTALL_REFERRER".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra(TapjoyConstants.TJC_REFERRER);
            if (!StringUtil.isEmpty(stringExtra)) {
                try {
                    co.cyberz.common.ids.b.a(context.getApplicationContext(), stringExtra);
                    new StringBuilder("Saved InstallReferrer : ").append(co.cyberz.common.ids.b.f(context.getApplicationContext()));
                    String str = "";
                    String str2 = "";
                    for (Object split : StringUtil.split(stringExtra, "&")) {
                        String[] split2 = StringUtil.split(split, "=");
                        if (split2.length == 2) {
                            if ("_xuid".equals(split2[0])) {
                                str2 = split2[1];
                            }
                            if ("_xroute".equals(split2[0])) {
                                str = split2[1];
                            }
                        }
                    }
                    if (!(StringUtil.isEmpty(str2) || StringUtil.isEmpty(str))) {
                        co.cyberz.common.ids.b.a(context, str2, str);
                    }
                } catch (Exception e) {
                }
            }
            a(context, intent);
        }
    }
}
