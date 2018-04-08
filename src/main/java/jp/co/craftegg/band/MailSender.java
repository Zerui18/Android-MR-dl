package jp.co.craftegg.band;

import android.app.Activity;
import android.content.Intent;

public class MailSender {
    public static void SendMail(Activity currentActivity, String bundleIdentifier, String address, String subject, String body, String attachFilePath) {
        Intent intent = new Intent();
        intent.setClassName(bundleIdentifier, "jp.co.craftegg.band.MailSenderActivity");
        intent.putExtra("BUNDLE_IDENTIFIER", bundleIdentifier);
        intent.putExtra("ADDRESS", address);
        intent.putExtra("SUBJECT", subject);
        intent.putExtra("BODY", body);
        intent.putExtra("ATTACH_FILE_PATH", attachFilePath);
        currentActivity.startActivity(intent);
    }
}
