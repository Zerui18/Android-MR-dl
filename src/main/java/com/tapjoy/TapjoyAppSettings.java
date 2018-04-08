package com.tapjoy;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tapjoy.internal.cr;

public class TapjoyAppSettings {
    public static final String TAG = TapjoyAppSettings.class.getSimpleName();
    private static TapjoyAppSettings b;
    String a = this.d.getString(TapjoyConstants.PREF_LOG_LEVEL, null);
    private Context c;
    private SharedPreferences d = this.c.getSharedPreferences(TapjoyConstants.TJC_PREFERENCE, 0);

    private TapjoyAppSettings(Context applicationContext) {
        this.c = applicationContext;
        if (!cr.c(this.a)) {
            TapjoyLog.d(TAG, "restoreLoggingLevel from sharedPref -- loggingLevel=" + this.a);
            TapjoyLog.a(this.a, true);
        }
    }

    public static TapjoyAppSettings getInstance() {
        return b;
    }

    public static void init(Context applicationContext) {
        TapjoyLog.d(TAG, "initializing app settings");
        b = new TapjoyAppSettings(applicationContext);
    }

    public void saveLoggingLevel(String level) {
        if (cr.c(level)) {
            TapjoyLog.d(TAG, "saveLoggingLevel -- server logging level is NULL or Empty string");
            return;
        }
        TapjoyLog.d(TAG, "saveLoggingLevel -- currentLevel=" + this.a + ";newLevel=" + level);
        if (cr.c(this.a) || !this.a.equals(level)) {
            Editor edit = this.d.edit();
            edit.putString(TapjoyConstants.PREF_LOG_LEVEL, level);
            edit.commit();
            this.a = level;
            TapjoyLog.a(this.a, true);
        }
        TapjoyLog.i(TAG, "Tapjoy remote device debugging set to '" + level + "'. The SDK Debug-setting is: " + (TapjoyLog.isLoggingEnabled() ? "'Enabled'" : "'Disabled'"));
    }

    public void clearLoggingLevel() {
        Editor edit = this.d.edit();
        edit.remove(TapjoyConstants.PREF_LOG_LEVEL);
        edit.commit();
        this.a = null;
        boolean isLoggingEnabled = TapjoyLog.isLoggingEnabled();
        TapjoyLog.i(TAG, "Tapjoy remote device debugging 'Disabled'. The SDK Debug-setting is: " + (isLoggingEnabled ? "'Enabled'" : "'Disabled'"));
        TapjoyLog.setDebugEnabled(isLoggingEnabled);
    }

    public void saveConnectResultAndParams(String result, String paramsHash, long expires) {
        if (!cr.c(result) && !cr.c(paramsHash)) {
            Editor edit = this.d.edit();
            edit.putString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, result);
            edit.putString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, paramsHash);
            if (expires >= 0) {
                edit.putLong(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES, expires);
            } else {
                edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES);
            }
            TapjoyLog.i(TAG, "Stored connect result");
            edit.commit();
        }
    }

    public void removeConnectResult() {
        if (this.d.getString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, null) != null) {
            Editor edit = this.d.edit();
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT);
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH);
            edit.remove(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES);
            TapjoyLog.i(TAG, "Removed connect result");
            edit.commit();
        }
    }

    public String getConnectResult(String paramsHash, long currentTimeMillis) {
        String string = this.d.getString(TapjoyConstants.PREF_LAST_CONNECT_RESULT, null);
        if (cr.c(string) || cr.c(paramsHash) || !paramsHash.equals(this.d.getString(TapjoyConstants.PREF_LAST_CONNECT_PARAMS_HASH, null))) {
            return null;
        }
        long j = this.d.getLong(TapjoyConstants.PREF_LAST_CONNECT_RESULT_EXPIRES, -1);
        if (j < 0 || j >= currentTimeMillis) {
            return string;
        }
        return null;
    }
}
