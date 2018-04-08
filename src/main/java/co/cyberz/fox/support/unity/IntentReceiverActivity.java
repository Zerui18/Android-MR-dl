package co.cyberz.fox.support.unity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import co.cyberz.fox.Fox;
import co.cyberz.util.string.StringUtil;

public class IntentReceiverActivity extends Activity {
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onResume() {
        super.onResume();
        Fox.trackDeeplinkLaunch((Activity) this);
        startLaunchActivity();
    }

    private void startLaunchActivity() {
        Intent i = getIntent();
        Uri uri = i.getData();
        Bundle bundle = i.getExtras();
        String packageName = getPackageName();
        try {
            Intent intent = getPackageManager().getLaunchIntentForPackage(packageName);
            if (uri != null) {
                intent.setData(uri);
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
            openMarketLaunchActivity(packageName);
        }
    }

    private void openMarketLaunchActivity() {
        try {
            startActivity(getPackageManager().getLaunchIntentForPackage("com.android.vending"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finish();
        }
    }

    private void openMarketLaunchActivity(String packageName) {
        if (StringUtil.isEmpty(packageName)) {
            openMarketLaunchActivity();
            return;
        }
        try {
            startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName)));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            finish();
        }
    }
}
