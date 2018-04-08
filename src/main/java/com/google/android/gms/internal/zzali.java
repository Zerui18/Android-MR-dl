package com.google.android.gms.internal;

import android.os.Bundle;
import android.support.v4.util.LongSparseArray;
import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzc;
import com.google.android.gms.drive.metadata.internal.zzf.zza;
import com.google.android.gms.drive.metadata.internal.zzl;
import java.util.Arrays;

public class zzali extends zzl<AppVisibleCustomProperties> {
    public static final zza zzaOr = new zza() {
        public String zzAH() {
            return "customPropertiesExtraHolder";
        }

        public void zzb(DataHolder dataHolder) {
            zzali.zzd(dataHolder);
        }
    };

    public zzali(int i) {
        super("customProperties", Arrays.asList(new String[]{"hasCustomProperties", "sqlId"}), Arrays.asList(new String[]{"customPropertiesExtra", "customPropertiesExtraHolder"}), i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zzc(com.google.android.gms.common.data.DataHolder r8) {
        /*
        monitor-enter(r8);
        r0 = r8.zzwy();	 Catch:{ all -> 0x0056 }
        r1 = "customPropertiesExtraHolder";
        r0 = r0.getParcelable(r1);	 Catch:{ all -> 0x0056 }
        r0 = (com.google.android.gms.common.data.DataHolder) r0;	 Catch:{ all -> 0x0056 }
        if (r0 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r8);	 Catch:{ all -> 0x0056 }
    L_0x0010:
        return;
    L_0x0011:
        r3 = zzf(r0);	 Catch:{ all -> 0x0059 }
        r4 = new android.util.SparseArray;	 Catch:{ all -> 0x0059 }
        r4.<init>();	 Catch:{ all -> 0x0059 }
        r1 = 0;
        r2 = r1;
    L_0x001c:
        r1 = r8.getCount();	 Catch:{ all -> 0x0059 }
        if (r2 >= r1) goto L_0x003f;
    L_0x0022:
        r1 = "sqlId";
        r5 = r8.zzcC(r2);	 Catch:{ all -> 0x0059 }
        r6 = r8.zzb(r1, r2, r5);	 Catch:{ all -> 0x0059 }
        r1 = r3.get(r6);	 Catch:{ all -> 0x0059 }
        r1 = (com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.zza) r1;	 Catch:{ all -> 0x0059 }
        if (r1 == 0) goto L_0x003b;
    L_0x0034:
        r1 = r1.zzAE();	 Catch:{ all -> 0x0059 }
        r4.append(r2, r1);	 Catch:{ all -> 0x0059 }
    L_0x003b:
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x001c;
    L_0x003f:
        r1 = r8.zzwy();	 Catch:{ all -> 0x0059 }
        r2 = "customPropertiesExtra";
        r1.putSparseParcelableArray(r2, r4);	 Catch:{ all -> 0x0059 }
        r0.close();	 Catch:{ all -> 0x0056 }
        r0 = r8.zzwy();	 Catch:{ all -> 0x0056 }
        r1 = "customPropertiesExtraHolder";
        r0.remove(r1);	 Catch:{ all -> 0x0056 }
        monitor-exit(r8);	 Catch:{ all -> 0x0056 }
        goto L_0x0010;
    L_0x0056:
        r0 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x0056 }
        throw r0;
    L_0x0059:
        r1 = move-exception;
        r0.close();	 Catch:{ all -> 0x0056 }
        r0 = r8.zzwy();	 Catch:{ all -> 0x0056 }
        r2 = "customPropertiesExtraHolder";
        r0.remove(r2);	 Catch:{ all -> 0x0056 }
        throw r1;	 Catch:{ all -> 0x0056 }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzali.zzc(com.google.android.gms.common.data.DataHolder):void");
    }

    private static void zzd(DataHolder dataHolder) {
        Bundle zzwy = dataHolder.zzwy();
        if (zzwy != null) {
            synchronized (dataHolder) {
                DataHolder dataHolder2 = (DataHolder) zzwy.getParcelable("customPropertiesExtraHolder");
                if (dataHolder2 != null) {
                    dataHolder2.close();
                    zzwy.remove("customPropertiesExtraHolder");
                }
            }
        }
    }

    private static LongSparseArray<AppVisibleCustomProperties.zza> zzf(DataHolder dataHolder) {
        Bundle zzwy = dataHolder.zzwy();
        String string = zzwy.getString("entryIdColumn");
        String string2 = zzwy.getString("keyColumn");
        String string3 = zzwy.getString("visibilityColumn");
        String string4 = zzwy.getString("valueColumn");
        LongSparseArray<AppVisibleCustomProperties.zza> longSparseArray = new LongSparseArray();
        for (int i = 0; i < dataHolder.getCount(); i++) {
            int zzcC = dataHolder.zzcC(i);
            long zzb = dataHolder.zzb(string, i, zzcC);
            String zzd = dataHolder.zzd(string2, i, zzcC);
            int zzc = dataHolder.zzc(string3, i, zzcC);
            zzc com_google_android_gms_drive_metadata_internal_zzc = new zzc(new CustomPropertyKey(zzd, zzc), dataHolder.zzd(string4, i, zzcC));
            AppVisibleCustomProperties.zza com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza = (AppVisibleCustomProperties.zza) longSparseArray.get(zzb);
            if (com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza == null) {
                com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza = new AppVisibleCustomProperties.zza();
                longSparseArray.put(zzb, com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza);
            }
            com_google_android_gms_drive_metadata_internal_AppVisibleCustomProperties_zza.zza(com_google_android_gms_drive_metadata_internal_zzc);
        }
        return longSparseArray;
    }

    protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
        return zzl(dataHolder, i, i2);
    }

    protected AppVisibleCustomProperties zzl(DataHolder dataHolder, int i, int i2) {
        Bundle zzwy = dataHolder.zzwy();
        SparseArray sparseParcelableArray = zzwy.getSparseParcelableArray("customPropertiesExtra");
        if (sparseParcelableArray == null) {
            if (zzwy.getParcelable("customPropertiesExtraHolder") != null) {
                zzc(dataHolder);
                sparseParcelableArray = zzwy.getSparseParcelableArray("customPropertiesExtra");
            }
            if (sparseParcelableArray == null) {
                return AppVisibleCustomProperties.zzaNq;
            }
        }
        return (AppVisibleCustomProperties) sparseParcelableArray.get(i, AppVisibleCustomProperties.zzaNq);
    }
}
