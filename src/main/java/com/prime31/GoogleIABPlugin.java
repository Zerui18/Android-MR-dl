package com.prime31;

import android.content.Intent;
import android.util.Log;
import com.prime31.util.IabHelperImpl;
import com.prime31.util.IabHelperImpl.IabAsyncInProgressException;
import com.prime31.util.IabHelperImpl.OnConsumeFinishedListener;
import com.prime31.util.IabHelperImpl.OnConsumeMultiFinishedListener;
import com.prime31.util.IabHelperImpl.OnIabPurchaseFinishedListener;
import com.prime31.util.IabHelperImpl.OnIabSetupFinishedListener;
import com.prime31.util.IabHelperImpl.QueryInventoryFinishedListener;
import com.prime31.util.IabResult;
import com.prime31.util.Inventory;
import com.prime31.util.Purchase;
import com.prime31.util.SkuDetails;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class GoogleIABPlugin extends GoogleIABPluginBase implements QueryInventoryFinishedListener, OnIabPurchaseFinishedListener, OnConsumeFinishedListener, OnConsumeMultiFinishedListener {
    private static String BILLING_NOT_RUNNING_ERROR = "The billing service is not running or billing is not supported. Aborting.";
    static final int RC_REQUEST = 10001;
    private boolean _hasQueriedInventory = false;
    private List<Purchase> _purchases = new ArrayList();
    private List<SkuDetails> _skus;
    public IabHelperImpl helper;

    private Purchase getPurchasedProductForSku(String sku) {
        for (Purchase p : this._purchases) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                return p;
            }
        }
        return null;
    }

    public void enableLogging(boolean shouldEnable) {
        IABConstants.DEBUG = shouldEnable;
        if (this.helper != null) {
            this.helper.enableDebugLogging(shouldEnable);
        }
    }

    public void setAutoVerifySignatures(boolean shouldVerify) {
        IabHelperImpl.autoVerifySignatures = shouldVerify;
    }

    public void init(String publicKey) {
        IABConstants.logEntering(getClass().getSimpleName(), "init", (Object) publicKey);
        this._purchases = new ArrayList();
        this.helper = new IabHelperImpl(getActivity(), publicKey);
        this.helper.enableDebugLogging(IABConstants.DEBUG, "Prime31-IABH");
        this.helper.startSetup(new OnIabSetupFinishedListener() {
            public void onIabSetupFinished(IabResult result) {
                if (result.isSuccess()) {
                    GoogleIABPlugin.this.UnitySendMessage("billingSupported", "");
                    return;
                }
                Log.i("Prime31", "billing not supported: " + result.getMessage());
                GoogleIABPlugin.this.UnitySendMessage("billingNotSupported", result.getMessage());
                GoogleIABPlugin.this.helper = null;
            }
        });
    }

    public void unbindService() {
        IABConstants.logEntering(getClass().getSimpleName(), "unbindService");
        if (this.helper != null) {
            this.helper.disposeWhenFinished();
            this.helper = null;
        }
    }

    public boolean areSubscriptionsSupported() {
        IABConstants.logEntering(getClass().getSimpleName(), "areSubscriptionsSupported");
        if (this.helper == null) {
            return false;
        }
        return this.helper.subscriptionsSupported();
    }

    public void queryInventory(Object[] skus) {
        IABConstants.logEntering(getClass().getSimpleName(), "queryInventory", skus);
        IABConstants.logDebug("in queryInventory with Object[] parameter. Converting to String[] now.");
        queryInventory((String[]) Arrays.asList(skus).toArray(new String[skus.length]));
    }

    public void queryInventory(final String[] skus) {
        IABConstants.logEntering(getClass().getSimpleName(), "queryInventory", (Object[]) skus);
        if (this.helper == null) {
            Log.i("Prime31", "billing helper is null. Did you call init to setup the billing helper?");
            Log.i("Prime31", BILLING_NOT_RUNNING_ERROR);
        } else if (this.helper.mService == null) {
            Log.i("Prime31", "billing service is null. Did you call init to setup the billing helper?");
            Log.i("Prime31", BILLING_NOT_RUNNING_ERROR);
        } else {
            runSafelyOnUiThread(new Runnable() {
                public void run() {
                    try {
                        GoogleIABPlugin.this.helper.queryInventoryAsync(true, Arrays.asList(skus), null, GoogleIABPlugin.this);
                    } catch (IabAsyncInProgressException e) {
                        Log.i("Prime31", "queryInventoryAsync failed");
                        e.printStackTrace();
                    }
                }
            }, "queryInventoryFailed");
        }
    }

    public void purchaseProduct(final String sku, final String developerPayload) {
        IABConstants.logEntering(getClass().getSimpleName(), "purchaseProduct", new Object[]{sku, developerPayload});
        if (this.helper == null) {
            Log.i("Prime31", BILLING_NOT_RUNNING_ERROR);
            return;
        }
        if (!this._hasQueriedInventory) {
            Log.w("Prime31", "You have not queried your inventory yet so the plugin does not have the required information to protect you from coding errors.");
        }
        for (Purchase p : this._purchases) {
            if (p.getSku().equalsIgnoreCase(sku)) {
                Log.i("Prime31", "Attempting to purchase an item that has already been purchased. That is probably not a good idea: " + sku);
            }
        }
        String itemType = IabHelperImpl.ITEM_TYPE_INAPP;
        if (this._hasQueriedInventory && this._skus != null && this._skus.size() != 0) {
            for (SkuDetails s : this._skus) {
                if (s.getSku().equalsIgnoreCase(sku)) {
                    IABConstants.logDebug("found sku " + sku + " in retrieved skus. setting item type to " + s.getItemType());
                    itemType = s.getItemType();
                    break;
                }
            }
        }
        Log.w("Prime31", "CANNOT fetch sku type due to either inventory not being queried or it returned no valid skus.");
        if (sku.equalsIgnoreCase("android.test.purchased")) {
            Log.i("Prime31", "fixing Google bug where they think the sku " + sku + " is a subscription. resetting to type inapp");
            itemType = IabHelperImpl.ITEM_TYPE_INAPP;
        }
        if (itemType == null) {
            Log.i("Prime31", new StringBuilder(String.valueOf(sku)).append(": you have attempted to purchase a sku that was not returned when querying the inventory. We will still let the product go through but it will be defaulted to an inapp type and may not work.").toString());
            itemType = IabHelperImpl.ITEM_TYPE_INAPP;
        }
        final String f_itemType = itemType;
        runSafelyOnUiThread(new Runnable() {
            public void run() {
                Intent proxyStarter = new Intent(GoogleIABPlugin.this.getActivity(), GoogleIABProxyActivity.class);
                proxyStarter.putExtra("sku", sku);
                proxyStarter.putExtra("itemType", f_itemType);
                proxyStarter.putExtra("developerPayload", developerPayload);
                GoogleIABPlugin.this.getActivity().startActivity(proxyStarter);
            }
        }, "purchaseFailed");
    }

    public void consumeProduct(String sku) {
        IABConstants.logEntering(getClass().getSimpleName(), "consumeProduct", (Object) sku);
        if (this.helper == null) {
            Log.i("Prime31", BILLING_NOT_RUNNING_ERROR);
            return;
        }
        if (!this._hasQueriedInventory) {
            Log.w("Prime31", "You have not queried your inventory yet so the plugin does not have the required information to protect you from coding errors.");
        }
        final Purchase p = getPurchasedProductForSku(sku);
        if (p == null) {
            Log.i("Prime31", "Attempting to consume an item that has not been purchased. Aborting to avoid exception. sku: " + sku);
            UnitySendMessage("consumePurchaseFailed", new StringBuilder(String.valueOf(sku)).append(": you cannot consume a project that has not been purchased or if you have not first queried your inventory to retreive the purchases.").toString());
            return;
        }
        runSafelyOnUiThread(new Runnable() {
            public void run() {
                try {
                    GoogleIABPlugin.this.helper.consumeAsync(p, GoogleIABPlugin.this);
                } catch (IabAsyncInProgressException e) {
                    Log.i("Prime31", "consumeAsync failed");
                    e.printStackTrace();
                }
            }
        }, "consumePurchaseFailed");
    }

    public void consumeProducts(String[] skus) {
        IABConstants.logEntering(getClass().getSimpleName(), "consumeProducts", (Object[]) skus);
        if (this.helper == null) {
            Log.i("Prime31", BILLING_NOT_RUNNING_ERROR);
        } else if (this._purchases == null || this._purchases.size() == 0) {
            Log.e("Prime31", "there are no purchases available to consume");
        } else {
            final List<Purchase> confirmedPurchases = new ArrayList();
            for (String sku : skus) {
                Purchase p = getPurchasedProductForSku(sku);
                if (p != null) {
                    confirmedPurchases.add(p);
                }
            }
            if (confirmedPurchases.size() != skus.length) {
                Log.i("Prime31", "Attempting to consume " + skus.length + " item(s) but only " + confirmedPurchases.size() + " item(s) were found to be purchased. Aborting.");
            } else {
                runSafelyOnUiThread(new Runnable() {
                    public void run() {
                        try {
                            GoogleIABPlugin.this.helper.consumeAsync(confirmedPurchases, GoogleIABPlugin.this);
                        } catch (IabAsyncInProgressException e) {
                            Log.i("Prime31", "consumeAsync failed");
                            e.printStackTrace();
                        }
                    }
                }, "consumePurchaseFailed");
            }
        }
    }

    public void onQueryInventoryFinished(IabResult result, Inventory inv) {
        if (result.isSuccess()) {
            this._hasQueriedInventory = true;
            this._purchases = inv.getAllPurchases();
            if (this._skus == null) {
                this._skus = new ArrayList();
            }
            this._skus.addAll(inv.getAllSkuDetails());
            this._skus = inv.getAllSkuDetails();
            UnitySendMessage("queryInventorySucceeded", inv.getAllSkusAndPurchasesAsJson());
            return;
        }
        UnitySendMessage("queryInventoryFailed", result.getMessage());
    }

    public void onIabPurchaseCompleteAwaitingVerification(String purchaseData, String signature) {
        try {
            JSONObject json = new JSONObject();
            json.put("purchaseData", purchaseData);
            json.put("signature", signature);
            UnitySendMessage("purchaseCompleteAwaitingVerification", json.toString());
        } catch (JSONException e) {
            Log.i("Prime31", "failed to create JSON packet: " + e.getMessage());
        }
    }

    public void onIabPurchaseFinished(IabResult result, Purchase info) {
        IABConstants.logDebug("onIabPurchaseFinished. result: " + result.getResponse());
        if (result.isSuccess()) {
            if (!this._purchases.contains(info)) {
                this._purchases.add(info);
            }
            UnitySendMessage("purchaseSucceeded", info.toJson());
            return;
        }
        try {
            JSONObject json = new JSONObject();
            json.put("result", result.getMessage());
            json.put("response", result.getResponse());
            UnitySendMessage("purchaseFailed", json.toString());
        } catch (JSONException e) {
            Log.i("Prime31", "failed to create JSON packet: " + e.getMessage());
        }
    }

    public void onConsumeFinished(Purchase purchase, IabResult result) {
        if (result.isSuccess()) {
            if (this._purchases.contains(purchase)) {
                this._purchases.remove(purchase);
            }
            UnitySendMessage("consumePurchaseSucceeded", purchase.toJson());
            return;
        }
        UnitySendMessage("consumePurchaseFailed", purchase.getSku() + ": " + result.getMessage());
    }

    public void onConsumeMultiFinished(List<Purchase> purchases, List<IabResult> results) {
        for (int i = 0; i < results.size(); i++) {
            IabResult result = (IabResult) results.get(i);
            Purchase purchase = (Purchase) purchases.get(i);
            if (result.isSuccess()) {
                if (this._purchases.contains(purchase)) {
                    this._purchases.remove(purchase);
                }
                UnitySendMessage("consumePurchaseSucceeded", purchase.toJson());
            } else {
                UnitySendMessage("consumePurchaseFailed", purchase.getSku() + ": " + result.getMessage());
            }
        }
    }
}
