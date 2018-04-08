package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.util.zzb;
import java.util.ArrayList;

public final class AppContentUtils {

    private interface AppContentRunner {
        void zzb(ArrayList<DataHolder> arrayList, int i);
    }

    class AnonymousClass1 implements AppContentRunner {
        final /* synthetic */ ArrayList zzaYH;

        AnonymousClass1(ArrayList arrayList) {
            this.zzaYH = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzaYH.add(new AppContentActionRef(arrayList, i));
        }
    }

    class AnonymousClass2 implements AppContentRunner {
        final /* synthetic */ ArrayList zzaYH;

        AnonymousClass2(ArrayList arrayList) {
            this.zzaYH = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzaYH.add(new AppContentAnnotationRef(arrayList, i));
        }
    }

    class AnonymousClass3 implements AppContentRunner {
        final /* synthetic */ ArrayList zzaYH;

        AnonymousClass3(ArrayList arrayList) {
            this.zzaYH = arrayList;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            this.zzaYH.add(new AppContentConditionRef(arrayList, i));
        }
    }

    class AnonymousClass4 implements AppContentRunner {
        final /* synthetic */ DataHolder zzaYI;
        final /* synthetic */ Bundle zzaYJ;

        AnonymousClass4(DataHolder dataHolder, Bundle bundle) {
            this.zzaYI = dataHolder;
            this.zzaYJ = bundle;
        }

        public void zzb(ArrayList<DataHolder> arrayList, int i) {
            AppContentTuple appContentTupleRef = new AppContentTupleRef(this.zzaYI, i);
            this.zzaYJ.putString(appContentTupleRef.getName(), appContentTupleRef.getValue());
        }
    }

    public static ArrayList<AppContentAction> zza(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAction> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 1, str2, "action_id", i, new AnonymousClass1(arrayList2), arrayList);
        return arrayList2;
    }

    private static void zza(DataHolder dataHolder, int i, String str, String str2, int i2, AppContentRunner appContentRunner, ArrayList<DataHolder> arrayList) {
        DataHolder dataHolder2 = (DataHolder) arrayList.get(i);
        Object zzd = dataHolder.zzd(str, i2, dataHolder.zzcC(i2));
        if (!TextUtils.isEmpty(zzd)) {
            int count = dataHolder2.getCount();
            String[] split = zzd.split(",");
            for (int i3 = 0; i3 < count; i3++) {
                CharSequence zzd2 = dataHolder2.zzd(str2, i3, dataHolder2.zzcC(i3));
                if (!TextUtils.isEmpty(zzd2) && zzb.zzb(split, zzd2)) {
                    appContentRunner.zzb(arrayList, i3);
                }
            }
        }
    }

    public static ArrayList<AppContentAnnotation> zzb(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentAnnotation> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 2, str2, "annotation_id", i, new AnonymousClass2(arrayList2), arrayList);
        return arrayList2;
    }

    public static ArrayList<AppContentCondition> zzc(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        ArrayList<AppContentCondition> arrayList2 = new ArrayList();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 4, str2, "condition_id", i, new AnonymousClass3(arrayList2), arrayList);
        return arrayList2;
    }

    public static Bundle zzd(DataHolder dataHolder, ArrayList<DataHolder> arrayList, String str, int i) {
        Bundle bundle = new Bundle();
        DataHolder dataHolder2 = dataHolder;
        String str2 = str;
        zza(dataHolder2, 3, str2, "tuple_id", i, new AnonymousClass4((DataHolder) arrayList.get(3), bundle), arrayList);
        return bundle;
    }
}
