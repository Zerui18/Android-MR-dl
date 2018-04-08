package jp.co.rforce.alto;

import android.media.SoundPool;
import com.tapjoy.TapjoyConnectCore;

public class SoundData {
    private int soundId;
    private SoundPool soundPool = new SoundPool(10, 3, 0);

    public SoundData(String path) {
        this.soundId = this.soundPool.load(path, 1);
    }

    public void play(float volume) {
        if (this.soundPool != null) {
            this.soundPool.play(this.soundId, volume, volume, 1, 0, TapjoyConnectCore.DEFAULT_CURRENCY_MULTIPLIER);
        }
    }

    public void release() {
        if (this.soundPool != null) {
            this.soundPool.unload(this.soundId);
            this.soundPool.release();
            this.soundPool = null;
        }
    }
}
