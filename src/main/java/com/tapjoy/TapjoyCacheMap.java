package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import java.io.File;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class TapjoyCacheMap extends ConcurrentHashMap {
    private Context a;
    private int b = -1;

    public TapjoyCacheMap(Context applicationContext, int cacheLimit) {
        this.a = applicationContext;
        this.b = cacheLimit;
    }

    private String a() {
        long j = -1;
        String str = "";
        for (Entry entry : entrySet()) {
            String str2;
            long j2;
            long timestampInSeconds = ((TapjoyCachedAssetData) entry.getValue()).getTimestampInSeconds();
            if (j == 0 || timestampInSeconds < j) {
                str2 = (String) entry.getKey();
                j2 = timestampInSeconds;
            } else {
                str2 = str;
                j2 = j;
            }
            j = j2;
            str = str2;
        }
        return str;
    }

    public TapjoyCachedAssetData put(String key, TapjoyCachedAssetData assetData) {
        TapjoyLog.d("TapjoyCacheMap", "TapjoyCacheMap::put() -- key: " + key + " assetURL: " + assetData.getAssetURL());
        if (assetData == null || assetData.getTimeOfDeathInSeconds() <= System.currentTimeMillis() / 1000) {
            return null;
        }
        if (size() == this.b) {
            remove(a());
        }
        Editor edit = this.a.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0).edit();
        edit.putString(assetData.getLocalFilePath(), assetData.toRawJSONString());
        edit.commit();
        return (TapjoyCachedAssetData) super.put(key, assetData);
    }

    public TapjoyCachedAssetData remove(Object key) {
        if (!containsKey(key)) {
            return null;
        }
        Editor edit = this.a.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0).edit();
        edit.remove(((TapjoyCachedAssetData) get(key)).getLocalFilePath());
        edit.commit();
        String localFilePath = ((TapjoyCachedAssetData) get(key)).getLocalFilePath();
        if (localFilePath != null && localFilePath.length() > 0) {
            TapjoyUtil.deleteFileOrDirectory(new File(localFilePath));
        }
        TapjoyLog.d("TapjoyCacheMap", "TapjoyCacheMap::remove() -- key: " + key);
        return (TapjoyCachedAssetData) super.remove(key);
    }

    public boolean replace(String key, TapjoyCachedAssetData oldValue, TapjoyCachedAssetData newValue) {
        throw new UnsupportedOperationException();
    }

    public TapjoyCachedAssetData replace(String key, TapjoyCachedAssetData value) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }
}
