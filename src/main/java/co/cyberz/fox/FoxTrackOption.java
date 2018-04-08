package co.cyberz.fox;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import co.cyberz.util.f.a;
import com.google.android.gms.drive.DriveFile;
import org.json.JSONObject;

public class FoxTrackOption {
    private String buid;
    protected DeeplinkHandler deeplinkHandler;
    private boolean optOut = false;
    private String redirectTo = "default";
    protected TrackingStateListener trackingStateListener;

    public interface TrackingStateListener {
        void onComplete();
    }

    public static abstract class DeeplinkHandler {
        public static DeeplinkHandler getDefault() {
            return new DeeplinkHandler() {
                public final void onReceived(Context context, @Nullable JSONObject jSONObject) {
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("deeplink", "blank");
                        if (!"blank".equals(optString)) {
                            try {
                                a.a("Received deeplink : " + optString);
                                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(optString));
                                intent.addFlags(DriveFile.MODE_READ_ONLY);
                                context.startActivity(intent);
                                return;
                            } catch (Throwable e) {
                                a.a("Perhaps a received deeplink is illegal.", e);
                                return;
                            }
                        }
                        return;
                    }
                    a.a("Could'nt receive a deeplink.");
                }
            };
        }

        public long getDuration() {
            return 86400;
        }

        public abstract void onReceived(Context context, @Nullable JSONObject jSONObject);
    }

    @Deprecated
    public interface TrackingStateListerner {
        void onComplete();
    }

    public FoxTrackOption addBuid(String str) {
        this.buid = str;
        return this;
    }

    public FoxTrackOption addOptOut(boolean z) {
        this.optOut = z;
        return this;
    }

    public FoxTrackOption addRedirectUrl(String str) {
        this.redirectTo = str;
        return this;
    }

    public String getBuid() {
        return this.buid;
    }

    public DeeplinkHandler getDeeplinkHandler() {
        return this.deeplinkHandler;
    }

    public String getRedirectUrl() {
        return this.redirectTo;
    }

    public boolean isOptOut() {
        return this.optOut;
    }

    public FoxTrackOption registerDeeplinkHandler(DeeplinkHandler deeplinkHandler) {
        this.deeplinkHandler = deeplinkHandler;
        return this;
    }

    public FoxTrackOption setTrackingStateListener(TrackingStateListener trackingStateListener) {
        this.trackingStateListener = trackingStateListener;
        return this;
    }

    @Deprecated
    public void setTrackingStateListener(final TrackingStateListerner trackingStateListerner) {
        this.trackingStateListener = new TrackingStateListener(this) {
            final /* synthetic */ FoxTrackOption b;

            public final void onComplete() {
                if (trackingStateListerner != null) {
                    trackingStateListerner.onComplete();
                }
            }
        };
    }
}
