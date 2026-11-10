package android.support.v4.media;

import android.os.SystemClock;
import android.view.KeyEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class TransportPerformer {
    static final int AUDIOFOCUS_GAIN = 1;
    static final int AUDIOFOCUS_GAIN_TRANSIENT = 2;
    static final int AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK = 3;
    static final int AUDIOFOCUS_LOSS = -1;
    static final int AUDIOFOCUS_LOSS_TRANSIENT = -2;
    static final int AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK = -3;

    public abstract long onGetCurrentPosition();

    public abstract long onGetDuration();

    public abstract boolean onIsPlaying();

    public abstract void onPause();

    public abstract void onSeekTo(long j);

    public abstract void onStart();

    public abstract void onStop();

    public int onGetBufferPercentage() {
        return 100;
    }

    public int onGetTransportControlFlags() {
        return 60;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public boolean onMediaButtonDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case 79:
            case 85:
                if (onIsPlaying()) {
                    onPause();
                } else {
                    onStart();
                }
                return true;
            case 86:
                onStop();
                return true;
            case 126:
                onStart();
                return true;
            case 127:
                onPause();
                return true;
            default:
                return true;
        }
    }

    public boolean onMediaButtonUp(int keyCode, KeyEvent event) {
        return true;
    }

    public void onAudioFocusChange(int focusChange) {
        int keyCode = 0;
        switch (focusChange) {
            case -1:
                keyCode = 127;
                break;
        }
        if (keyCode != 0) {
            long now = SystemClock.uptimeMillis();
            onMediaButtonDown(keyCode, new KeyEvent(now, now, 0, keyCode, 0));
            onMediaButtonUp(keyCode, new KeyEvent(now, now, 1, keyCode, 0));
        }
    }
}
