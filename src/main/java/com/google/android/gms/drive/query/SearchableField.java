package com.google.android.gms.drive.query;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.zzalh;
import com.google.android.gms.internal.zzalj;
import java.util.Date;

public class SearchableField {
    public static final SearchableMetadataField<Boolean> IS_PINNED = zzalh.zzaNP;
    public static final SearchableOrderedMetadataField<Date> LAST_VIEWED_BY_ME = zzalj.zzaOt;
    public static final SearchableMetadataField<String> MIME_TYPE = zzalh.zzaNX;
    public static final SearchableOrderedMetadataField<Date> MODIFIED_DATE = zzalj.zzaOu;
    public static final SearchableCollectionMetadataField<DriveId> PARENTS = zzalh.zzaOc;
    public static final SearchableMetadataField<Boolean> STARRED = zzalh.zzaOe;
    public static final SearchableMetadataField<String> TITLE = zzalh.zzaOg;
    public static final SearchableMetadataField<Boolean> TRASHED = zzalh.zzaOh;
    public static final SearchableOrderedMetadataField<Date> zzaOH = zzalj.zzaOw;
    public static final SearchableMetadataField<AppVisibleCustomProperties> zzaOI = zzalh.zzaNC;
}
