package com.google.android.gms.internal;

import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.DriveSpace;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.zzk;
import com.google.android.gms.drive.metadata.internal.zzl;
import com.google.android.gms.drive.metadata.internal.zzn;
import com.google.android.gms.drive.metadata.internal.zzq;
import com.google.android.gms.drive.metadata.internal.zzr;
import com.google.android.gms.drive.metadata.internal.zzs;
import com.tapjoy.TJAdUnitConstants.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class zzalh {
    public static final MetadataField<DriveId> zzaNA = zzalk.zzaOy;
    public static final MetadataField<String> zzaNB = new zzr("alternateLink", 4300000);
    public static final zza zzaNC = new zza(5000000);
    public static final MetadataField<String> zzaND = new zzr("description", 4300000);
    public static final MetadataField<String> zzaNE = new zzr("embedLink", 4300000);
    public static final MetadataField<String> zzaNF = new zzr("fileExtension", 4300000);
    public static final MetadataField<Long> zzaNG = new com.google.android.gms.drive.metadata.internal.zzh("fileSize", 4300000);
    public static final MetadataField<String> zzaNH = new zzr("folderColorRgb", 7500000);
    public static final MetadataField<Boolean> zzaNI = new com.google.android.gms.drive.metadata.internal.zzb("hasThumbnail", 4300000);
    public static final MetadataField<String> zzaNJ = new zzr("indexableText", 4300000);
    public static final MetadataField<Boolean> zzaNK = new com.google.android.gms.drive.metadata.internal.zzb("isAppData", 4300000);
    public static final MetadataField<Boolean> zzaNL = new com.google.android.gms.drive.metadata.internal.zzb("isCopyable", 4300000);
    public static final MetadataField<Boolean> zzaNM = new com.google.android.gms.drive.metadata.internal.zzb("isEditable", 4100000);
    public static final MetadataField<Boolean> zzaNN = new AnonymousClass1("isExplicitlyTrashed", Collections.singleton("trashed"), Collections.emptySet(), 7000000);
    public static final MetadataField<Boolean> zzaNO = new com.google.android.gms.drive.metadata.internal.zzb("isLocalContentUpToDate", 7800000);
    public static final zzb zzaNP = new zzb("isPinned", 4100000);
    public static final MetadataField<Boolean> zzaNQ = new com.google.android.gms.drive.metadata.internal.zzb("isOpenable", 7200000);
    public static final MetadataField<Boolean> zzaNR = new com.google.android.gms.drive.metadata.internal.zzb("isRestricted", 4300000);
    public static final MetadataField<Boolean> zzaNS = new com.google.android.gms.drive.metadata.internal.zzb("isShared", 4300000);
    public static final MetadataField<Boolean> zzaNT = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosFolder", 7000000);
    public static final MetadataField<Boolean> zzaNU = new com.google.android.gms.drive.metadata.internal.zzb("isGooglePhotosRootFolder", 7000000);
    public static final MetadataField<Boolean> zzaNV = new com.google.android.gms.drive.metadata.internal.zzb("isTrashable", 4400000);
    public static final MetadataField<Boolean> zzaNW = new com.google.android.gms.drive.metadata.internal.zzb("isViewed", 4300000);
    public static final zzc zzaNX = new zzc(4100000);
    public static final MetadataField<String> zzaNY = new zzr("originalFilename", 4300000);
    public static final com.google.android.gms.drive.metadata.zzb<String> zzaNZ = new zzq("ownerNames", 4300000);
    public static final zzs zzaOa = new zzs("lastModifyingUser", 6000000);
    public static final zzs zzaOb = new zzs("sharingUser", 6000000);
    public static final zzn zzaOc = new zzn(4100000);
    public static final zzd zzaOd = new zzd("quotaBytesUsed", 4300000);
    public static final zzf zzaOe = new zzf("starred", 4100000);
    public static final MetadataField<BitmapTeleporter> zzaOf = new AnonymousClass2("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000);
    public static final zzg zzaOg = new zzg(String.TITLE, 4100000);
    public static final zzh zzaOh = new zzh("trashed", 4100000);
    public static final MetadataField<String> zzaOi = new zzr("webContentLink", 4300000);
    public static final MetadataField<String> zzaOj = new zzr("webViewLink", 4300000);
    public static final MetadataField<String> zzaOk = new zzr("uniqueIdentifier", 5000000);
    public static final com.google.android.gms.drive.metadata.internal.zzb zzaOl = new com.google.android.gms.drive.metadata.internal.zzb("writersCanShare", 6000000);
    public static final MetadataField<String> zzaOm = new zzr("role", 6000000);
    public static final MetadataField<String> zzaOn = new zzr("md5Checksum", 7000000);
    public static final zze zzaOo = new zze(7000000);
    public static final MetadataField<String> zzaOp = new zzr("recencyReason", 8000000);
    public static final MetadataField<Boolean> zzaOq = new com.google.android.gms.drive.metadata.internal.zzb("subscribed", 8000000);

    class AnonymousClass1 extends com.google.android.gms.drive.metadata.internal.zzb {
        AnonymousClass1(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zze(dataHolder, i, i2);
        }

        protected Boolean zze(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc("trashed", i, i2) == 2);
        }
    }

    class AnonymousClass2 extends zzl<BitmapTeleporter> {
        AnonymousClass2(String str, Collection collection, Collection collection2, int i) {
            super(str, collection, collection2, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zzk(dataHolder, i, i2);
        }

        protected BitmapTeleporter zzk(DataHolder dataHolder, int i, int i2) {
            throw new IllegalStateException("Thumbnail field is write only");
        }
    }

    public static class zza extends zzali implements SearchableMetadataField<AppVisibleCustomProperties> {
        public zza(int i) {
            super(i);
        }
    }

    public static class zzb extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzb(String str, int i) {
            super(str, i);
        }
    }

    public static class zzc extends zzr implements SearchableMetadataField<String> {
        public zzc(int i) {
            super("mimeType", i);
        }
    }

    public static class zzd extends com.google.android.gms.drive.metadata.internal.zzh implements SortableMetadataField<Long> {
        public zzd(String str, int i) {
            super(str, i);
        }
    }

    public static class zze extends zzk<DriveSpace> {
        public zze(int i) {
            super("spaces", Arrays.asList(new String[]{"inDriveSpace", "isAppData", "inGooglePhotosSpace"}), Collections.emptySet(), i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zzd(dataHolder, i, i2);
        }

        protected Collection<DriveSpace> zzd(DataHolder dataHolder, int i, int i2) {
            Collection arrayList = new ArrayList();
            if (dataHolder.zze("inDriveSpace", i, i2)) {
                arrayList.add(DriveSpace.zzaJz);
            }
            if (dataHolder.zze("isAppData", i, i2)) {
                arrayList.add(DriveSpace.zzaJA);
            }
            if (dataHolder.zze("inGooglePhotosSpace", i, i2)) {
                arrayList.add(DriveSpace.zzaJB);
            }
            return arrayList;
        }
    }

    public static class zzf extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzf(String str, int i) {
            super(str, i);
        }
    }

    public static class zzg extends zzr implements SearchableMetadataField<String>, SortableMetadataField<String> {
        public zzg(String str, int i) {
            super(str, i);
        }
    }

    public static class zzh extends com.google.android.gms.drive.metadata.internal.zzb implements SearchableMetadataField<Boolean> {
        public zzh(String str, int i) {
            super(str, i);
        }

        protected /* synthetic */ Object zzc(DataHolder dataHolder, int i, int i2) {
            return zze(dataHolder, i, i2);
        }

        protected Boolean zze(DataHolder dataHolder, int i, int i2) {
            return Boolean.valueOf(dataHolder.zzc(getName(), i, i2) != 0);
        }
    }
}
