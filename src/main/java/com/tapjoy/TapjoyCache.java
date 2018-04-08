package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.tapjoy.TJAdUnitConstants.String;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.eh;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCache {
    public static final String CACHE_DIRECTORY_NAME = "Tapjoy/Cache/";
    public static final int CACHE_LIMIT = -1;
    private static TapjoyCache a = null;
    public static boolean unit_test_mode = false;
    private Context b;
    private TapjoyCacheMap c;
    private Vector d;
    private ExecutorService e;
    private File f;

    public class CacheAssetThread implements Callable {
        final /* synthetic */ TapjoyCache a;
        private URL b;
        private String c;
        private long d;

        public CacheAssetThread(TapjoyCache tapjoyCache, URL assetURL, String offerId, long timeToLive) {
            this.a = tapjoyCache;
            this.b = assetURL;
            this.c = offerId;
            this.d = timeToLive;
            if (this.d <= 0) {
                this.d = 86400;
            }
            tapjoyCache.d.add(TapjoyCache.b(this.b.toString()));
        }

        public Boolean call() {
            BufferedInputStream bufferedInputStream;
            SocketTimeoutException e;
            BufferedInputStream bufferedInputStream2;
            Boolean valueOf;
            Throwable th;
            Exception e2;
            BufferedOutputStream bufferedOutputStream = null;
            String a = TapjoyCache.b(this.b.toString());
            if (this.a.c.containsKey(a)) {
                if (new File(((TapjoyCachedAssetData) this.a.c.get(a)).getLocalFilePath()).exists()) {
                    if (this.d != 0) {
                        ((TapjoyCachedAssetData) this.a.c.get(a)).resetTimeToLive(this.d);
                    } else {
                        ((TapjoyCachedAssetData) this.a.c.get(a)).resetTimeToLive(86400);
                    }
                    TapjoyLog.d("TapjoyCache", "Reseting time to live for " + this.b.toString());
                    this.a.d.remove(a);
                    return Boolean.valueOf(true);
                }
                TapjoyCache.getInstance().removeAssetFromCache(a);
            }
            System.currentTimeMillis();
            try {
                File file = new File(this.a.f + "/" + TapjoyUtil.SHA256(a));
                TapjoyLog.d("TapjoyCache", "Downloading and caching asset from: " + this.b + " to " + file);
                BufferedOutputStream bufferedOutputStream2;
                try {
                    URLConnection a2 = eh.a(this.b);
                    a2.setConnectTimeout(15000);
                    a2.setReadTimeout(30000);
                    a2.connect();
                    bufferedInputStream = new BufferedInputStream(a2.getInputStream());
                    try {
                        bufferedOutputStream2 = new BufferedOutputStream(new FileOutputStream(file));
                        try {
                            TapjoyUtil.writeFileToDevice(bufferedInputStream, bufferedOutputStream2);
                            try {
                                bufferedInputStream.close();
                            } catch (IOException e3) {
                            }
                            try {
                                bufferedOutputStream2.close();
                            } catch (IOException e4) {
                            }
                            TapjoyCachedAssetData tapjoyCachedAssetData = new TapjoyCachedAssetData(this.b.toString(), file.getAbsolutePath(), this.d);
                            if (this.c != null) {
                                tapjoyCachedAssetData.setOfferID(this.c);
                            }
                            this.a.c.put(a, tapjoyCachedAssetData);
                            this.a.d.remove(a);
                            TapjoyLog.d("TapjoyCache", "----- Download complete -----" + tapjoyCachedAssetData.toString());
                            return Boolean.valueOf(true);
                        } catch (SocketTimeoutException e5) {
                            e = e5;
                            bufferedInputStream2 = bufferedInputStream;
                            try {
                                TapjoyLog.e("TapjoyCache", new TapjoyErrorMessage(ErrorType.NETWORK_ERROR, "Network timeout during caching: " + e.toString()));
                                this.a.d.remove(a);
                                TapjoyUtil.deleteFileOrDirectory(file);
                                valueOf = Boolean.valueOf(false);
                                if (bufferedInputStream2 != null) {
                                    try {
                                        bufferedInputStream2.close();
                                    } catch (IOException e6) {
                                    }
                                }
                                if (bufferedOutputStream2 != null) {
                                    return valueOf;
                                }
                                try {
                                    bufferedOutputStream2.close();
                                    return valueOf;
                                } catch (IOException e7) {
                                    return valueOf;
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                bufferedInputStream = bufferedInputStream2;
                                bufferedOutputStream = bufferedOutputStream2;
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e8) {
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    try {
                                        bufferedOutputStream.close();
                                    } catch (IOException e9) {
                                    }
                                }
                                throw th;
                            }
                        } catch (Exception e10) {
                            e2 = e10;
                            bufferedOutputStream = bufferedOutputStream2;
                            try {
                                TapjoyLog.e("TapjoyCache", "Error caching asset: " + e2.toString());
                                this.a.d.remove(a);
                                TapjoyUtil.deleteFileOrDirectory(file);
                                valueOf = Boolean.valueOf(false);
                                if (bufferedInputStream != null) {
                                    try {
                                        bufferedInputStream.close();
                                    } catch (IOException e11) {
                                    }
                                }
                                if (bufferedOutputStream != null) {
                                    return valueOf;
                                }
                                try {
                                    bufferedOutputStream.close();
                                    return valueOf;
                                } catch (IOException e12) {
                                    return valueOf;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                if (bufferedInputStream != null) {
                                    bufferedInputStream.close();
                                }
                                if (bufferedOutputStream != null) {
                                    bufferedOutputStream.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            bufferedOutputStream = bufferedOutputStream2;
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                            throw th;
                        }
                    } catch (SocketTimeoutException e13) {
                        e = e13;
                        bufferedOutputStream2 = null;
                        bufferedInputStream2 = bufferedInputStream;
                        TapjoyLog.e("TapjoyCache", new TapjoyErrorMessage(ErrorType.NETWORK_ERROR, "Network timeout during caching: " + e.toString()));
                        this.a.d.remove(a);
                        TapjoyUtil.deleteFileOrDirectory(file);
                        valueOf = Boolean.valueOf(false);
                        if (bufferedInputStream2 != null) {
                            bufferedInputStream2.close();
                        }
                        if (bufferedOutputStream2 != null) {
                            return valueOf;
                        }
                        bufferedOutputStream2.close();
                        return valueOf;
                    } catch (Exception e14) {
                        e2 = e14;
                        TapjoyLog.e("TapjoyCache", "Error caching asset: " + e2.toString());
                        this.a.d.remove(a);
                        TapjoyUtil.deleteFileOrDirectory(file);
                        valueOf = Boolean.valueOf(false);
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                        if (bufferedOutputStream != null) {
                            return valueOf;
                        }
                        bufferedOutputStream.close();
                        return valueOf;
                    }
                } catch (SocketTimeoutException e15) {
                    e = e15;
                    bufferedOutputStream2 = null;
                    TapjoyLog.e("TapjoyCache", new TapjoyErrorMessage(ErrorType.NETWORK_ERROR, "Network timeout during caching: " + e.toString()));
                    this.a.d.remove(a);
                    TapjoyUtil.deleteFileOrDirectory(file);
                    valueOf = Boolean.valueOf(false);
                    if (bufferedInputStream2 != null) {
                        bufferedInputStream2.close();
                    }
                    if (bufferedOutputStream2 != null) {
                        return valueOf;
                    }
                    bufferedOutputStream2.close();
                    return valueOf;
                } catch (Exception e16) {
                    e2 = e16;
                    bufferedInputStream = null;
                    TapjoyLog.e("TapjoyCache", "Error caching asset: " + e2.toString());
                    this.a.d.remove(a);
                    TapjoyUtil.deleteFileOrDirectory(file);
                    valueOf = Boolean.valueOf(false);
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        return valueOf;
                    }
                    bufferedOutputStream.close();
                    return valueOf;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedInputStream = null;
                    if (bufferedInputStream != null) {
                        bufferedInputStream.close();
                    }
                    if (bufferedOutputStream != null) {
                        bufferedOutputStream.close();
                    }
                    throw th;
                }
            } catch (Exception e17) {
                this.a.d.remove(a);
                return Boolean.valueOf(false);
            }
        }
    }

    public TapjoyCache(Context applicationContext) {
        if (a == null || unit_test_mode) {
            a = this;
            this.b = applicationContext;
            this.c = new TapjoyCacheMap(applicationContext, -1);
            this.d = new Vector();
            this.e = Executors.newFixedThreadPool(5);
            if (Environment.getExternalStorageDirectory() != null) {
                TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tapjoy"));
                TapjoyUtil.deleteFileOrDirectory(new File(Environment.getExternalStorageDirectory(), "tjcache/tmp/"));
            }
            this.f = new File(this.b.getFilesDir() + "/Tapjoy/Cache/");
            if (!this.f.exists()) {
                if (this.f.mkdirs()) {
                    TapjoyLog.d("TapjoyCache", "Created directory at: " + this.f.getPath());
                } else {
                    TapjoyLog.e("TapjoyCache", "Error initalizing cache");
                    a = null;
                }
            }
            a();
        }
    }

    private void a() {
        SharedPreferences sharedPreferences = this.b.getSharedPreferences(TapjoyConstants.PREF_TAPJOY_CACHE, 0);
        Editor edit = sharedPreferences.edit();
        for (Entry entry : sharedPreferences.getAll().entrySet()) {
            File file = new File((String) entry.getKey());
            if (file.exists() && file.isFile()) {
                TapjoyCachedAssetData fromRawJSONString = TapjoyCachedAssetData.fromRawJSONString(entry.getValue().toString());
                if (fromRawJSONString != null) {
                    TapjoyLog.d("TapjoyCache", "Loaded Asset: " + fromRawJSONString.getAssetURL());
                    String b = b(fromRawJSONString.getAssetURL());
                    if (b == null || "".equals(b) || b.length() <= 0) {
                        TapjoyLog.e("TapjoyCache", "Removing asset because deserialization failed.");
                        edit.remove((String) entry.getKey()).commit();
                    } else if (fromRawJSONString.getTimeOfDeathInSeconds() < System.currentTimeMillis() / 1000) {
                        TapjoyLog.d("TapjoyCache", "Asset expired, removing from cache: " + fromRawJSONString.getAssetURL());
                        if (fromRawJSONString.getLocalFilePath() != null && fromRawJSONString.getLocalFilePath().length() > 0) {
                            TapjoyUtil.deleteFileOrDirectory(new File(fromRawJSONString.getLocalFilePath()));
                        }
                    } else {
                        this.c.put(b, fromRawJSONString);
                    }
                } else {
                    TapjoyLog.e("TapjoyCache", "Removing asset because deserialization failed.");
                    edit.remove((String) entry.getKey()).commit();
                }
            } else {
                TapjoyLog.d("TapjoyCache", "Removing reference to missing asset: " + ((String) entry.getKey()));
                edit.remove((String) entry.getKey()).commit();
            }
        }
    }

    public void cacheAssetGroup(final JSONArray assetGroup, final TJCacheListener tapjoyCacheListener) {
        if (assetGroup != null && assetGroup.length() > 0) {
            new Thread(this) {
                final /* synthetic */ TapjoyCache c;

                public final void run() {
                    int i;
                    TapjoyLog.d("TapjoyCache", "Starting to cache asset group size of " + assetGroup.length());
                    List<Future> arrayList = new ArrayList();
                    int i2 = 1;
                    for (i = 0; i < assetGroup.length(); i++) {
                        try {
                            Future cacheAssetFromJSONObject = this.c.cacheAssetFromJSONObject(assetGroup.getJSONObject(i));
                            if (cacheAssetFromJSONObject != null) {
                                arrayList.add(cacheAssetFromJSONObject);
                            }
                        } catch (JSONException e) {
                            TapjoyLog.e("TapjoyCache", "Failed to load JSON object from JSONArray");
                        }
                    }
                    for (Future future : arrayList) {
                        try {
                            if (((Boolean) future.get()).booleanValue()) {
                                i = i2;
                            } else {
                                i = 2;
                            }
                            i2 = i;
                        } catch (InterruptedException e2) {
                            TapjoyLog.e("TapjoyCache", "Caching thread failed: " + e2.toString());
                            i2 = 2;
                        } catch (ExecutionException e3) {
                            TapjoyLog.e("TapjoyCache", "Caching thread failed: " + e3.toString());
                            i2 = 2;
                        }
                    }
                    TapjoyLog.d("TapjoyCache", "Finished caching group");
                    if (tapjoyCacheListener != null) {
                        tapjoyCacheListener.onCachingComplete(i2);
                    }
                }
            }.start();
        } else if (tapjoyCacheListener != null) {
            tapjoyCacheListener.onCachingComplete(1);
        }
    }

    public Future cacheAssetFromJSONObject(JSONObject assetData) {
        try {
            String string = assetData.getString(String.URL);
            Long.valueOf(86400);
            return cacheAssetFromURL(string, assetData.optString(TapjoyConstants.TJC_PLACEMENT_OFFER_ID), Long.valueOf(assetData.optLong(TapjoyConstants.TJC_TIME_TO_LIVE)).longValue());
        } catch (JSONException e) {
            TapjoyLog.e("TapjoyCache", "Required parameters to cache an asset from JSON is not present");
            return null;
        }
    }

    public Future cacheAssetFromURL(String assetURLString, String offerId, long timeToLive) {
        try {
            URL url = new URL(assetURLString);
            if (!this.d.contains(b(assetURLString))) {
                return startCachingThread(url, offerId, timeToLive);
            }
            TapjoyLog.d("TapjoyCache", "URL is already in the process of being cached: " + assetURLString);
            return null;
        } catch (MalformedURLException e) {
            TapjoyLog.d("TapjoyCache", "Invalid cache assetURL");
            return null;
        }
    }

    private static String b(String str) {
        if (str.startsWith("//")) {
            str = "http:" + str;
        }
        try {
            return new URL(str).getFile();
        } catch (MalformedURLException e) {
            TapjoyLog.e("TapjoyCache", "Invalid URL " + str);
            return "";
        }
    }

    public Future startCachingThread(URL assetURL, String offerId, long timeToLive) {
        if (assetURL != null) {
            return this.e.submit(new CacheAssetThread(this, assetURL, offerId, timeToLive));
        }
        return null;
    }

    public void clearTapjoyCache() {
        TapjoyLog.d("TapjoyCache", "Cleaning Tapjoy cache!");
        TapjoyUtil.deleteFileOrDirectory(this.f);
        if (this.f.mkdirs()) {
            TapjoyLog.d("TapjoyCache", "Created new cache directory at: " + this.f.getPath());
        }
        this.c = new TapjoyCacheMap(this.b, -1);
    }

    public boolean removeAssetFromCache(String url) {
        Object b = b(url);
        return (b == "" || this.c.remove(b) == null) ? false : true;
    }

    public boolean isURLDownloading(String url) {
        if (this.d == null) {
            return false;
        }
        String b = b(url);
        if (b == "" || !this.d.contains(b)) {
            return false;
        }
        return true;
    }

    public boolean isURLCached(String url) {
        return this.c.get(b(url)) != null;
    }

    public TapjoyCachedAssetData getCachedDataForURL(String url) {
        String b = b(url);
        if (b != "") {
            return (TapjoyCachedAssetData) this.c.get(b);
        }
        return null;
    }

    public TapjoyCacheMap getCachedData() {
        return this.c;
    }

    public String getPathOfCachedURL(String url) {
        String b = b(url);
        if (b == "" || !this.c.containsKey(b)) {
            return url;
        }
        TapjoyCachedAssetData tapjoyCachedAssetData = (TapjoyCachedAssetData) this.c.get(b);
        if (new File(tapjoyCachedAssetData.getLocalFilePath()).exists()) {
            return tapjoyCachedAssetData.getLocalURL();
        }
        getInstance().removeAssetFromCache(url);
        return url;
    }

    public String cachedAssetsToJSON() {
        JSONObject jSONObject = new JSONObject();
        for (Entry entry : this.c.entrySet()) {
            try {
                jSONObject.put(((String) entry.getKey()).toString(), ((TapjoyCachedAssetData) entry.getValue()).toRawJSONString());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    public String getCachedOfferIDs() {
        String str = "";
        Iterable arrayList = new ArrayList();
        if (this.c == null) {
            return str;
        }
        for (Entry value : this.c.entrySet()) {
            str = ((TapjoyCachedAssetData) value.getValue()).getOfferId();
            if (!(str == null || str.length() == 0 || arrayList.contains(str))) {
                arrayList.add(str);
            }
        }
        return TextUtils.join(",", arrayList);
    }

    public void printCacheInformation() {
        TapjoyLog.d("TapjoyCache", "------------- Cache Data -------------");
        TapjoyLog.d("TapjoyCache", "Number of files in cache: " + this.c.size());
        TapjoyLog.d("TapjoyCache", "Cache Size: " + TapjoyUtil.fileOrDirectorySize(this.f));
        TapjoyLog.d("TapjoyCache", "--------------------------------------");
    }

    public static TapjoyCache getInstance() {
        return a;
    }

    public static void setInstance(TapjoyCache cache) {
        a = cache;
    }
}
