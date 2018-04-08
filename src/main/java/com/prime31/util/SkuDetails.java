package com.prime31.util;

import com.moat.analytics.mobile.tjy.MoatAdEvent;
import com.tapjoy.TJAdUnitConstants.String;
import org.json.JSONException;
import org.json.JSONObject;

public class SkuDetails {
    String _description;
    String _itemType;
    String _json;
    String _price;
    String _price_amount_micros;
    String _price_currency_code;
    String _sku;
    String _title;
    String _type;

    public SkuDetails(String jsonSkuDetails) throws JSONException {
        this(IabHelperImpl.ITEM_TYPE_INAPP, jsonSkuDetails);
    }

    public SkuDetails(String itemType, String jsonSkuDetails) throws JSONException {
        this._itemType = itemType;
        JSONObject o = new JSONObject(jsonSkuDetails);
        this._sku = o.optString("productId");
        this._type = o.optString(MoatAdEvent.EVENT_TYPE);
        this._price = o.optString("price");
        this._title = o.optString(String.TITLE);
        this._description = o.optString("description");
        this._price_currency_code = o.optString("price_currency_code");
        this._price_amount_micros = o.optString("price_amount_micros");
        o.put("itemType", itemType);
        this._json = o.toString();
    }

    public String getSku() {
        return this._sku;
    }

    public String getType() {
        return this._type;
    }

    public String getItemType() {
        return this._itemType;
    }

    public String getPrice() {
        return this._price;
    }

    public String getPriceMicros() {
        return this._price_amount_micros;
    }

    public String getCurrencyCode() {
        return this._price_currency_code;
    }

    public String getTitle() {
        return this._title;
    }

    public String getDescription() {
        return this._description;
    }

    public String toString() {
        return "SkuDetails:" + this._json;
    }

    public String toJson() {
        return this._json;
    }
}
