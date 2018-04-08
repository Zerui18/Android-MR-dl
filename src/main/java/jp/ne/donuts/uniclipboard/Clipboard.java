package jp.ne.donuts.uniclipboard;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import com.unity3d.player.UnityPlayer;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Clipboard {
    public static void setText(final String text) {
        final Activity activity = UnityPlayer.currentActivity;
        activity.runOnUiThread(new Runnable() {
            public void run() {
                ((ClipboardManager) activity.getSystemService("clipboard")).setPrimaryClip(new ClipData(new ClipDescription("text_data", new String[]{"text/uri-list"}), new Item(text)));
            }
        });
    }

    public static String getText() {
        final Activity activity = UnityPlayer.currentActivity;
        FutureTask<String> futureResult = new FutureTask(new Callable<String>() {
            public String call() throws Exception {
                ClipData cd = ((ClipboardManager) activity.getSystemService("clipboard")).getPrimaryClip();
                if (cd != null) {
                    return cd.getItemAt(0).getText().toString();
                }
                return "";
            }
        });
        activity.runOnUiThread(futureResult);
        try {
            return (String) futureResult.get();
        } catch (Exception e) {
            return "";
        }
    }
}
