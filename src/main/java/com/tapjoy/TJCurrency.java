package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tapjoy.TapjoyErrorMessage.ErrorType;
import com.tapjoy.internal.en;
import java.util.Map;
import java.util.UUID;
import org.w3c.dom.Document;

public class TJCurrency {
    private static TJGetCurrencyBalanceListener d;
    private static TJSpendCurrencyListener e;
    private static TJAwardCurrencyListener f;
    private static TJEarnedCurrencyListener g;
    String a = null;
    int b = 0;
    Context c;

    public TJCurrency(Context applicationContext) {
        this.c = applicationContext;
    }

    public void saveCurrencyBalance(int balance) {
        Editor edit = this.c.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).edit();
        edit.putInt(TapjoyConstants.PREF_LAST_CURRENCY_BALANCE, balance);
        edit.commit();
    }

    public int getLocalCurrencyBalance() {
        return this.c.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0).getInt(TapjoyConstants.PREF_LAST_CURRENCY_BALANCE, -9999);
    }

    public void getCurrencyBalance(TJGetCurrencyBalanceListener listener) {
        d = listener;
        new Thread(new Runnable(this) {
            final /* synthetic */ TJCurrency a;

            {
                this.a = r1;
            }

            public final void run() {
                this.a.a(new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_GET_CURRENCY_BALANCE_URL_PATH, TapjoyConnectCore.getURLParams()));
            }
        }).start();
    }

    public void spendCurrency(int amount, TJSpendCurrencyListener listener) {
        if (amount < 0) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the spendCurrency API"));
            return;
        }
        this.a = String.valueOf(amount);
        e = listener;
        new Thread(new Runnable(this) {
            final /* synthetic */ TJCurrency a;

            {
                this.a = r1;
            }

            public final void run() {
                Map uRLParams = TapjoyConnectCore.getURLParams();
                TapjoyUtil.safePut(uRLParams, TapjoyConstants.TJC_CURRENCY, this.a.a, true);
                this.a.b(new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_SPEND_CURRENCY_URL_PATH, uRLParams));
            }
        }).start();
    }

    public void awardCurrency(int amount, TJAwardCurrencyListener listener) {
        if (amount < 0) {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.INTEGRATION_ERROR, "Amount must be a positive number for the awardCurrency API"));
            return;
        }
        this.b = amount;
        f = listener;
        new Thread(new Runnable(this) {
            final /* synthetic */ TJCurrency a;

            {
                this.a = r1;
            }

            public final void run() {
                String uuid = UUID.randomUUID().toString();
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                Map genericURLParams = TapjoyConnectCore.getGenericURLParams();
                TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_CURRENCY, String.valueOf(this.a.b), true);
                TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_GUID, uuid, true);
                TapjoyUtil.safePut(genericURLParams, "timestamp", String.valueOf(currentTimeMillis), true);
                TapjoyUtil.safePut(genericURLParams, TapjoyConstants.TJC_VERIFIER, TapjoyConnectCore.getAwardCurrencyVerifier(currentTimeMillis, this.a.b, uuid), true);
                this.a.c(new TapjoyURLConnection().getResponseFromURL(TapjoyConnectCore.getHostURL() + TapjoyConstants.TJC_AWARD_CURRENCY_URL_PATH, genericURLParams));
            }
        }).start();
    }

    public void setEarnedCurrencyListener(TJEarnedCurrencyListener listener) {
        g = listener;
    }

    private synchronized void a(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        if (tapjoyHttpURLResponse.response != null) {
            Document buildDocument = TapjoyUtil.buildDocument(tapjoyHttpURLResponse.response);
            if (buildDocument != null) {
                String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
                if (nodeTrimValue == null || !nodeTrimValue.equals("true")) {
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing <Success> tag."));
                } else {
                    nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("TapPoints"));
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("CurrencyName"));
                    if (nodeTrimValue == null || nodeTrimValue2 == null) {
                        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "getCurrencyBalance response is invalid -- missing tags."));
                    } else {
                        try {
                            int parseInt = Integer.parseInt(nodeTrimValue);
                            int localCurrencyBalance = getLocalCurrencyBalance();
                            if (!(g == null || localCurrencyBalance == -9999 || parseInt <= localCurrencyBalance)) {
                                TapjoyLog.i("TJCurrency", "earned: " + (parseInt - localCurrencyBalance));
                                g.onEarnedCurrency(nodeTrimValue2, parseInt - localCurrencyBalance);
                            }
                            saveCurrencyBalance(parseInt);
                            if (d != null) {
                                d.onGetCurrencyBalanceResponse(nodeTrimValue2, parseInt);
                            }
                        } catch (Exception e) {
                            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "Error parsing XML and calling listener: " + e.toString()));
                        }
                    }
                }
            }
            if (d != null) {
                d.onGetCurrencyBalanceResponseFailure("Failed to get currency balance");
            }
        } else {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "getCurrencyBalance response is NULL"));
            if (d != null) {
                d.onGetCurrencyBalanceResponseFailure("Failed to get currency balance");
            }
        }
    }

    private synchronized void b(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        String str = "Failed to spend currency";
        if (tapjoyHttpURLResponse.response != null) {
            Document buildDocument = TapjoyUtil.buildDocument(tapjoyHttpURLResponse.response);
            if (buildDocument != null) {
                String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
                if (nodeTrimValue == null || !nodeTrimValue.equals("true")) {
                    if (nodeTrimValue != null) {
                        if (nodeTrimValue.endsWith("false")) {
                            str = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Message"));
                            TapjoyLog.i("TJCurrency", str);
                            if ("BalanceTooLowError".equals(TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("MessageCode")))) {
                                en.a();
                            }
                        }
                    }
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "spendCurrency response is invalid -- missing <Success> tag."));
                } else {
                    nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("TapPoints"));
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("CurrencyName"));
                    if (nodeTrimValue == null || nodeTrimValue2 == null) {
                        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "spendCurrency response is invalid -- missing tags."));
                    } else {
                        int parseInt = Integer.parseInt(nodeTrimValue);
                        saveCurrencyBalance(parseInt);
                        if (e != null) {
                            e.onSpendCurrencyResponse(nodeTrimValue2, parseInt);
                        }
                    }
                }
            }
            if (e != null) {
                e.onSpendCurrencyResponseFailure(str);
            }
        } else {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "spendCurrency response is NULL"));
            if (e != null) {
                e.onSpendCurrencyResponseFailure(str);
            }
        }
    }

    private synchronized void c(TapjoyHttpURLResponse tapjoyHttpURLResponse) {
        String str = "Failed to award currency";
        if (tapjoyHttpURLResponse.response != null) {
            Document buildDocument = TapjoyUtil.buildDocument(tapjoyHttpURLResponse.response);
            if (buildDocument != null) {
                String nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Success"));
                if (nodeTrimValue == null || !nodeTrimValue.equals("true")) {
                    if (nodeTrimValue != null) {
                        if (nodeTrimValue.endsWith("false")) {
                            str = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("Message"));
                            TapjoyLog.i("TJCurrency", str);
                        }
                    }
                    TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing <Success> tag."));
                } else {
                    nodeTrimValue = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("TapPoints"));
                    String nodeTrimValue2 = TapjoyUtil.getNodeTrimValue(buildDocument.getElementsByTagName("CurrencyName"));
                    if (nodeTrimValue == null || nodeTrimValue2 == null) {
                        TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "awardCurrency response is invalid -- missing tags."));
                    } else {
                        int parseInt = Integer.parseInt(nodeTrimValue);
                        saveCurrencyBalance(parseInt);
                        if (f != null) {
                            f.onAwardCurrencyResponse(nodeTrimValue2, parseInt);
                        }
                    }
                }
            }
            if (f != null) {
                f.onAwardCurrencyResponseFailure(str);
            }
        } else {
            TapjoyLog.e("TJCurrency", new TapjoyErrorMessage(ErrorType.SERVER_ERROR, "awardCurrency response is NULL"));
            if (f != null) {
                f.onAwardCurrencyResponseFailure(str);
            }
        }
    }
}
