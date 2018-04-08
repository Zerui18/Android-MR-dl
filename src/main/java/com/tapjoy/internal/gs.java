package com.tapjoy.internal;

final class gs extends gj implements fk {
    public static final bm a = new bm() {
        public final /* synthetic */ Object a(br brVar) {
            String str = "";
            String str2 = "";
            brVar.h();
            while (brVar.j()) {
                String l = brVar.l();
                if ("campaign_id".equals(l)) {
                    str = brVar.c("");
                } else if ("product_id".equals(l)) {
                    str2 = brVar.c("");
                } else {
                    brVar.s();
                }
            }
            brVar.i();
            return new gs(str, str2);
        }
    };
    private final String b;
    private final String c;

    gs(String str, String str2) {
        this.b = str;
        this.c = str2;
    }

    public final String a() {
        return this.b;
    }

    public final String b() {
        return this.c;
    }
}
