package co.cyberz.fox.service;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.Nullable;
import android.util.Log;
import co.cyberz.common.ids.c;
import co.cyberz.fox.FoxTrackOption;
import co.cyberz.util.string.StringUtil;
import com.google.android.gms.drive.DriveFile;
import com.tapjoy.TJAdUnitConstants;
import java.net.UnknownHostException;
import java.util.HashMap;

public final class e extends co.cyberz.common.a.a<Void, Integer> {
    public final co.cyberz.fox.b.b a;
    private Context b;
    private a c;
    private co.cyberz.fox.a.e d;

    public interface a {
        void b();
    }

    static class b extends co.cyberz.common.a.a<Void, String> {
        private a a;
        private int b = 0;

        public interface a {
            void a();
        }

        public b(int i, a aVar) {
            this.a = aVar;
            this.b = i;
        }

        private String b() {
            String str = "";
            try {
                co.cyberz.common.b.a a = co.cyberz.common.b.a.a();
                Log.i("F.O.X SDK", "Xuniq : " + c.a(a.a).a().a);
                int round = Math.round((float) ((this.b > 0 ? this.b * 1000 : 0) / TJAdUnitConstants.DEFAULT_VOLUME_CHECK_INTERVAL));
                int i = 0;
                Object obj = null;
                Object obj2 = null;
                while (true) {
                    if ((obj2 != null && r0 != null) || i >= round) {
                        break;
                    }
                    if (a.r == null) {
                        a.r = co.cyberz.common.ids.b.f(a.a);
                    }
                    obj2 = !StringUtil.isEmpty(a.r) ? 1 : null;
                    obj = a.s != null ? 1 : null;
                    if (obj2 == null || obj == null) {
                        Thread.sleep(500);
                    }
                    i++;
                }
            } catch (Exception e) {
            }
            return str;
        }

        protected final /* bridge */ /* synthetic */ void a(@Nullable Object obj) {
            if (this.a != null) {
                this.a.a();
            }
        }

        protected final /* bridge */ /* synthetic */ Object b(Object[] objArr) {
            return b();
        }
    }

    public e(Context context, FoxTrackOption foxTrackOption, co.cyberz.fox.b.b bVar, a aVar) {
        this.b = context;
        this.a = bVar;
        this.d = new co.cyberz.fox.a.e(foxTrackOption, bVar);
        this.c = aVar;
    }

    private Integer b() {
        try {
            return (Integer) this.d.i();
        } catch (UnknownHostException e) {
            co.cyberz.util.f.a.c("Could not connect to the network. Please check the network state of this device.");
        } catch (Exception e2) {
        }
        return null;
    }

    public final void a(final Context context) {
        if (this.d != null) {
            try {
                final String str = this.d.a() + "?" + StringUtil.mapToUrlString((HashMap) this.d.g());
                new Handler(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ e c;

                    public final void run() {
                        Intent intent = new Intent("android.intent.action.VIEW");
                        intent.setFlags((intent.getFlags() | DriveFile.MODE_READ_ONLY) | DriveFile.MODE_READ_ONLY);
                        intent.setData(Uri.parse(str));
                        context.startActivity(intent);
                    }
                });
            } catch (Exception e) {
            } finally {
                i.a(context);
            }
        }
    }

    protected final /* synthetic */ void a(@android.support.annotation.Nullable java.lang.Object r4) {
        /* JADX: method processing error */
/*
Error: java.util.NoSuchElementException
	at java.util.HashMap$HashIterator.nextNode(HashMap.java:1444)
	at java.util.HashMap$KeyIterator.next(HashMap.java:1466)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.applyRemove(BlockFinallyExtract.java:535)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.extractFinally(BlockFinallyExtract.java:175)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.processExceptionHandler(BlockFinallyExtract.java:79)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:51)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r4 = (java.lang.Integer) r4;
        r0 = r4.intValue();	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        if (r0 != r1) goto L_0x0023;	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
    L_0x000a:
        r0 = r3.b;	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        if (r0 == 0) goto L_0x0023;	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
    L_0x000e:
        r1 = "co.cyberz.fox";	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        r2 = 0;	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        r0 = r0.getSharedPreferences(r1, r2);	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        r0 = r0.edit();	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        r1 = "fox_sent_cv";	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        r2 = 1;	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        r0 = r0.putBoolean(r1, r2);	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
        r0.commit();	 Catch:{ Exception -> 0x0033, all -> 0x0044 }
    L_0x0023:
        r0 = r3.a;
        r0 = r0.a;
        if (r0 != 0) goto L_0x0032;
    L_0x0029:
        r0 = r3.c;
        if (r0 == 0) goto L_0x0032;
    L_0x002d:
        r0 = r3.c;
        r0.b();
    L_0x0032:
        return;
    L_0x0033:
        r0 = move-exception;
        r0 = r3.a;
        r0 = r0.a;
        if (r0 != 0) goto L_0x0032;
    L_0x003a:
        r0 = r3.c;
        if (r0 == 0) goto L_0x0032;
    L_0x003e:
        r0 = r3.c;
        r0.b();
        goto L_0x0032;
    L_0x0044:
        r0 = move-exception;
        r1 = r3.a;
        r1 = r1.a;
        if (r1 != 0) goto L_0x0054;
    L_0x004b:
        r1 = r3.c;
        if (r1 == 0) goto L_0x0054;
    L_0x004f:
        r1 = r3.c;
        r1.b();
    L_0x0054:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: co.cyberz.fox.service.e.a(java.lang.Object):void");
    }
}
