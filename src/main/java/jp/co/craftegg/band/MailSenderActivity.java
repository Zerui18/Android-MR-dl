package jp.co.craftegg.band;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import java.io.File;

public class MailSenderActivity extends Activity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        intent.setAction("android.intent.action.SEND");
        String bundleIdentifier = intent.getStringExtra("BUNDLE_IDENTIFIER");
        String address = intent.getStringExtra("ADDRESS");
        String subject = intent.getStringExtra("SUBJECT");
        String body = intent.getStringExtra("BODY");
        File sendFile = new File(intent.getStringExtra("ATTACH_FILE_PATH"));
        Intent mailActivityIntent = new Intent();
        mailActivityIntent.setAction("android.intent.action.SEND");
        mailActivityIntent.putExtra("android.intent.extra.EMAIL", new String[]{address});
        mailActivityIntent.putExtra("android.intent.extra.SUBJECT", subject);
        mailActivityIntent.putExtra("android.intent.extra.TEXT", body);
        mailActivityIntent.setType("text/plain");
        mailActivityIntent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(this, bundleIdentifier + ".provider", sendFile));
        startActivity(mailActivityIntent);
        finish();
    }
}
