package co.cyberz.fox.service;

import co.cyberz.util.string.StringUtil;
import java.util.HashMap;
import org.json.JSONObject;

public class FoxEvent {
    public static final String DEFAULT_CURRENCY = "JPY";
    public String buid;
    public String currency;
    public JSONObject eventInfo;
    public final String eventName;
    protected HashMap<String, String> extraInfo;
    protected boolean isPurchase;
    public String itemName;
    public final int ltvPointId;
    public String orderId;
    public double price;
    public int quantity;
    public String sku;
    public int value;
    protected String xtid;

    protected FoxEvent() {
        this.quantity = 1;
        this.isPurchase = false;
        this.ltvPointId = 0;
        this.eventName = null;
    }

    public FoxEvent(String str) {
        this.quantity = 1;
        this.isPurchase = false;
        if (StringUtil.isEmpty(str)) {
            throw new IllegalArgumentException("EventName must be not null or empty");
        }
        this.ltvPointId = 0;
        this.eventName = str;
    }

    public FoxEvent(String str, int i) {
        this.quantity = 1;
        this.isPurchase = false;
        if (StringUtil.isEmpty(str)) {
            throw new IllegalArgumentException("EventName must be not null or empty");
        } else if (i == 0) {
            throw new IllegalArgumentException("ltvPointId must be greater than zero");
        } else {
            this.ltvPointId = i;
            this.eventName = str;
            this.extraInfo = new HashMap();
            this.eventInfo = new JSONObject();
        }
    }

    public FoxEvent addExtraInfo(String str, String str2) {
        if (!(StringUtil.isEmpty(str) || StringUtil.isEmpty(str2))) {
            try {
                if (this.extraInfo == null) {
                    this.extraInfo = new HashMap();
                }
                this.extraInfo.put(str, str2);
            } catch (Exception e) {
            }
        }
        return this;
    }

    public JSONObject getEventInfo() {
        return this.eventInfo;
    }

    public HashMap<String, String> getExtraInfo() {
        return this.extraInfo;
    }

    protected FoxEvent setXtid(String str) {
        this.xtid = str;
        return this;
    }
}
