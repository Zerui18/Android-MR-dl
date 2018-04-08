package com.tapjoy.mraid.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.tapjoy.mraid.controller.Abstract;
import com.tapjoy.mraid.controller.Abstract.Dimensions;
import com.tapjoy.mraid.controller.Abstract.PlayerProperties;
import com.tapjoy.mraid.listener.Player;
import com.tapjoy.mraid.util.MraidPlayer;
import com.tapjoy.mraid.util.Utils;
import com.tapjoy.mraid.view.MraidView.Action;
import java.util.HashMap;
import java.util.Map.Entry;

public class ActionHandler extends Activity {
    private HashMap a = new HashMap();
    private RelativeLayout b;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(1);
        Bundle extras = getIntent().getExtras();
        this.b = new RelativeLayout(this);
        this.b.setLayoutParams(new LayoutParams(-1, -1));
        this.b.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        setContentView(this.b);
        String string = extras.getString(MraidView.ACTION_KEY);
        if (string != null) {
            Action valueOf = Action.valueOf(string);
            switch (valueOf) {
                case PLAY_AUDIO:
                    a(extras, valueOf).playAudio();
                    return;
                case PLAY_VIDEO:
                    a(extras, valueOf).playVideo();
                    return;
                default:
                    return;
            }
        }
    }

    private MraidPlayer a(Bundle bundle, Action action) {
        LayoutParams layoutParams;
        PlayerProperties playerProperties = (PlayerProperties) bundle.getParcelable(MraidView.PLAYER_PROPERTIES);
        Dimensions dimensions = (Dimensions) bundle.getParcelable(MraidView.DIMENSIONS);
        View mraidPlayer = new MraidPlayer(this);
        mraidPlayer.setPlayData(playerProperties, Utils.getData(MraidView.EXPAND_URL, bundle));
        if (playerProperties.inline || !playerProperties.startStyle.equals(Abstract.FULL_SCREEN)) {
            layoutParams = new RelativeLayout.LayoutParams(dimensions.width, dimensions.height);
            layoutParams.topMargin = dimensions.y;
            layoutParams.leftMargin = dimensions.x;
        } else {
            getWindow().setFlags(1024, 1024);
            getWindow().setFlags(ViewCompat.MEASURED_STATE_TOO_SMALL, ViewCompat.MEASURED_STATE_TOO_SMALL);
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(13);
        }
        mraidPlayer.setLayoutParams(layoutParams);
        this.b.addView(mraidPlayer);
        this.a.put(action, mraidPlayer);
        mraidPlayer.setListener(new Player(this) {
            final /* synthetic */ ActionHandler a;

            {
                this.a = r1;
            }

            public final void onPrepared() {
            }

            public final void onError() {
                this.a.finish();
            }

            public final void onComplete() {
                this.a.finish();
            }
        });
        return mraidPlayer;
    }

    protected void onStop() {
        for (Entry entry : this.a.entrySet()) {
            switch ((Action) entry.getKey()) {
                case PLAY_AUDIO:
                case PLAY_VIDEO:
                    ((MraidPlayer) entry.getValue()).releasePlayer();
                    break;
                default:
                    break;
            }
        }
        super.onStop();
    }
}
