package jp.co.rforce.alto;

import android.annotation.SuppressLint;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class AltoSoundPool implements Runnable {
    private final long WaitMilliSec = 1;
    private ArrayList<Integer> hashList;
    private boolean isGamePlaying;
    private Map<Integer, SoundData> map;
    private Thread thread;
    private boolean threadLock;
    private float volumeCache;

    @SuppressLint({"UseSparseArrays"})
    public void initialize(float volume) {
        this.volumeCache = volume;
        this.isGamePlaying = true;
        this.threadLock = false;
        this.hashList = new ArrayList();
        this.map = new HashMap();
        this.thread = new Thread(this);
        this.thread.start();
    }

    public void run() {
        while (this.isGamePlaying) {
            PlayQueueRecursive();
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
            }
        }
    }

    private void PlayQueueRecursive() {
        if (this.map != null && this.hashList != null && this.hashList.size() > 0) {
            this.threadLock = true;
            for (int i = 0; i < this.hashList.size(); i++) {
                ((SoundData) this.map.get(this.hashList.get(i))).play(this.volumeCache);
            }
            this.hashList.clear();
            this.threadLock = false;
        }
    }

    public int loadWavFile(String path) {
        if (this.map == null || !isExistFileName(path) || !isWavFile(path)) {
            return -1;
        }
        int hashCode = path.hashCode();
        this.map.put(Integer.valueOf(hashCode), new SoundData(path));
        return hashCode;
    }

    boolean isExistFileName(String path) {
        return new File(path).exists();
    }

    boolean isWavFile(String path) {
        int point = path.lastIndexOf(".");
        if (point == -1) {
            return false;
        }
        if ("wav".equals(path.substring(point + 1))) {
            return true;
        }
        return false;
    }

    public void play(int hashCode) {
        if (this.map != null && this.hashList != null && this.thread != null && !this.threadLock && this.map.containsKey(Integer.valueOf(hashCode)) && !this.hashList.contains(Integer.valueOf(hashCode))) {
            this.hashList.add(Integer.valueOf(hashCode));
        }
    }

    public void release() {
        this.isGamePlaying = false;
        if (this.map != null) {
            for (Entry<Integer, SoundData> e : this.map.entrySet()) {
                ((SoundData) e.getValue()).release();
            }
            this.map.clear();
            this.map = null;
        }
        if (this.hashList != null) {
            this.hashList.clear();
            this.hashList = null;
        }
        System.gc();
    }
}
