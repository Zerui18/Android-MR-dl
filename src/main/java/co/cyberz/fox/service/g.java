package co.cyberz.fox.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import co.cyberz.common.b.c;
import co.cyberz.common.ids.b;
import co.cyberz.util.string.StringUtil;

public final class g extends co.cyberz.common.a.a<Void, Void> {
    public final Intent a;
    public Context b;
    public String c;
    public String d;
    private final String e;
    private boolean f;
    private int g;
    private int h;

    static class a extends c {
        private static String a = "RE_SEND";

        protected static void a(Context context) {
            context.getSharedPreferences("co.cyberz.fox", 0).edit().putBoolean(a, true).commit();
        }

        protected static boolean b(Context context) {
            return context.getSharedPreferences("co.cyberz.fox", 0).getBoolean(a, false);
        }

        protected static void c(Context context) {
            context.getSharedPreferences("co.cyberz.fox", 0).edit().remove(a).commit();
        }
    }

    public g() {
        this((byte) 0);
    }

    private g(byte b) {
        this(null, null);
    }

    public g(Intent intent, String str) {
        this.c = null;
        this.d = null;
        this.f = false;
        this.g = 0;
        this.h = 1;
        this.a = intent;
        this.e = str;
        try {
            this.b = co.cyberz.fox.a.a().d;
            String[] a = a(this.a);
            if (a != null && a.length == 2) {
                this.c = a[0];
                this.d = a[1];
            }
        } catch (Exception e) {
        }
    }

    private void a(Uri uri, String str, String str2, String str3) {
        try {
            if (((Integer) new co.cyberz.fox.a.g(uri, str, str2, str3).i()).intValue() == 200) {
                Context context = this.b;
                b.d(context);
                b.e(context);
                a.c(context);
            }
        } catch (Exception e) {
            new StringBuilder("Could not send the reengage post --- ").append(e.getMessage());
        }
    }

    private String[] a(Intent intent) {
        if (intent == null) {
            return null;
        }
        try {
            String[] a;
            Uri data = this.a.getData();
            if (data == null) {
                a = a(this.a.getExtras());
            } else if (!data.isHierarchical()) {
                return null;
            } else {
                a = a(data);
            }
            if (a != null) {
                try {
                    if (a.length == 2 && !StringUtil.isEmpty(a[this.g]) && "2".equals(a[this.h])) {
                        new StringBuilder("_xuid : ").append(a[this.g]);
                        new StringBuilder("_xroute : ").append(a[this.h]);
                        return a;
                    }
                } catch (IndexOutOfBoundsException e) {
                    return a;
                } catch (NullPointerException e2) {
                    return a;
                } catch (Exception e3) {
                    return a;
                }
            }
            return null;
        } catch (IndexOutOfBoundsException e4) {
            return null;
        } catch (NullPointerException e5) {
            return null;
        } catch (Exception e6) {
            return null;
        }
    }

    private String[] a(Uri uri) {
        String[] strArr = new String[2];
        try {
            strArr[this.g] = uri.getQueryParameter("_xuid");
            strArr[this.h] = uri.getQueryParameter("_xroute");
        } catch (Exception e) {
        }
        return strArr;
    }

    private String[] a(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        String[] strArr = new String[2];
        try {
            strArr[this.g] = bundle.getString("_xuid");
            strArr[this.h] = bundle.getString("_xroute");
            return strArr;
        } catch (Exception e) {
            return strArr;
        }
    }

    private Void c() {
        Object obj = null;
        if (this.a == null) {
            try {
                if (this.b != null && a.b(this.b)) {
                    String b = b.b(this.b);
                    String c = b.c(this.b);
                    b a = b.a(this.b);
                    if (!StringUtil.isEmpty(b)) {
                        Uri parse = Uri.parse(b);
                        String[] a2 = a(parse);
                        if (!(StringUtil.isEmpty(a2[0]) || StringUtil.isEmpty(a2[1]))) {
                            new StringBuilder("ReengagementService --- Xuid : ").append(a2[0]);
                            a(parse, a2[0], a2[1], c);
                        }
                    } else if (!(StringUtil.isEmpty(a.a) || StringUtil.isEmpty(a.b))) {
                        new StringBuilder("ReengagementService --- Xuid : ").append(a.a);
                        a(null, a.a, a.b, c);
                    }
                }
            } catch (Exception e) {
            }
        } else if (!(this.a == null || this.b == null || this.c == null || this.d == null)) {
            try {
                Uri data = this.a.getData();
                Context context = this.b;
                String str = this.c;
                String str2 = this.d;
                if (!(StringUtil.isEmpty(str) || StringUtil.isEmpty(str2) || !"2".equals(str2) || str.equals(b.a(context).a))) {
                    b.a(context, str, str2);
                    if (data != null) {
                        b.a(context, data, this.e);
                    }
                    int i = 1;
                }
                if (!(obj == null || this.f)) {
                    a(data, this.c, this.d, this.e);
                }
            } catch (Exception e2) {
            }
        }
        return null;
    }

    protected final /* synthetic */ Object b(Object[] objArr) {
        return c();
    }

    public final void b() {
        this.f = true;
        a.a(this.b);
    }
}
