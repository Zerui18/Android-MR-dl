package com.tapjoy;

import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class TapjoyCachedAssetData implements Serializable {
    private long a;
    private long b;
    private String c;
    private String d;
    private String e;
    private long f;
    private String g;
    private String h;

    public TapjoyCachedAssetData(String assetURL, String localFilePath, long timeToLiveInSeconds) {
        this(assetURL, localFilePath, timeToLiveInSeconds, System.currentTimeMillis() / 1000);
    }

    public TapjoyCachedAssetData(String assetURL, String localFilePath, long timeToLiveInSeconds, long timestampInSeconds) {
        setAssetURL(assetURL);
        setLocalFilePath(localFilePath);
        this.b = timeToLiveInSeconds;
        this.a = timestampInSeconds;
        this.f = timestampInSeconds + timeToLiveInSeconds;
    }

    public void setAssetURL(String assetURL) {
        this.c = assetURL;
        this.g = TapjoyUtil.determineMimeType(assetURL);
    }

    public void setLocalFilePath(String localFilePath) {
        this.d = localFilePath;
        this.e = "file://" + localFilePath;
    }

    public void resetTimeToLive(long timeToLiveInSeconds) {
        this.b = timeToLiveInSeconds;
        this.f = (System.currentTimeMillis() / 1000) + timeToLiveInSeconds;
    }

    public void setOfferID(String offerID) {
        this.h = offerID;
    }

    public long getTimestampInSeconds() {
        return this.a;
    }

    public long getTimeToLiveInSeconds() {
        return this.b;
    }

    public long getTimeOfDeathInSeconds() {
        return this.f;
    }

    public String getAssetURL() {
        return this.c;
    }

    public String getLocalFilePath() {
        return this.d;
    }

    public String getLocalURL() {
        return this.e;
    }

    public String getMimeType() {
        return this.g;
    }

    public String getOfferId() {
        return this.h;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", getTimestampInSeconds());
            jSONObject.put(TapjoyConstants.TJC_TIME_TO_LIVE, getTimeToLiveInSeconds());
            jSONObject.put("assetURL", getAssetURL());
            jSONObject.put("localFilePath", getLocalFilePath());
            jSONObject.put("offerID", getOfferId());
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public String toRawJSONString() {
        return toJSON().toString();
    }

    public static TapjoyCachedAssetData fromRawJSONString(String jsonRep) {
        try {
            return fromJSONObject(new JSONObject(jsonRep));
        } catch (JSONException e) {
            TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- error reading json string");
            return null;
        }
    }

    public static TapjoyCachedAssetData fromJSONObject(JSONObject data) {
        TapjoyCachedAssetData tapjoyCachedAssetData;
        try {
            tapjoyCachedAssetData = new TapjoyCachedAssetData(data.getString("assetURL"), data.getString("localFilePath"), data.getLong(TapjoyConstants.TJC_TIME_TO_LIVE), data.getLong("timestamp"));
            try {
                tapjoyCachedAssetData.setOfferID(data.optString("offerID"));
            } catch (JSONException e) {
                TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- not enough data.");
                return tapjoyCachedAssetData;
            }
        } catch (JSONException e2) {
            tapjoyCachedAssetData = null;
            TapjoyLog.i("TapjoyCachedAssetData", "Can not build TapjoyVideoObject -- not enough data.");
            return tapjoyCachedAssetData;
        }
        return tapjoyCachedAssetData;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\nURL=").append(this.e).append("\n");
        stringBuilder.append("AssetURL=").append(this.c).append("\n");
        stringBuilder.append("MimeType=").append(this.g).append("\n");
        stringBuilder.append("Timestamp=").append(getTimestampInSeconds()).append("\n");
        stringBuilder.append("TimeOfDeath=").append(this.f).append("\n");
        stringBuilder.append("TimeToLive=").append(this.b).append("\n");
        return stringBuilder.toString();
    }
}
