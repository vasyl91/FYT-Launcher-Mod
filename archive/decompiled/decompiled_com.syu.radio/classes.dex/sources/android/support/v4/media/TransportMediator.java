package android.support.v4.media;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.support.v4.view.KeyEventCompat;
import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class TransportMediator extends TransportController {
    public static final int FLAG_KEY_MEDIA_FAST_FORWARD = 64;
    public static final int FLAG_KEY_MEDIA_NEXT = 128;
    public static final int FLAG_KEY_MEDIA_PAUSE = 16;
    public static final int FLAG_KEY_MEDIA_PLAY = 4;
    public static final int FLAG_KEY_MEDIA_PLAY_PAUSE = 8;
    public static final int FLAG_KEY_MEDIA_PREVIOUS = 1;
    public static final int FLAG_KEY_MEDIA_REWIND = 2;
    public static final int FLAG_KEY_MEDIA_STOP = 32;
    public static final int KEYCODE_MEDIA_PAUSE = 127;
    public static final int KEYCODE_MEDIA_PLAY = 126;
    public static final int KEYCODE_MEDIA_RECORD = 130;
    final AudioManager mAudioManager;
    final TransportPerformer mCallbacks;
    final Context mContext;
    final TransportMediatorJellybeanMR2 mController;
    final Object mDispatcherState;
    final KeyEvent.Callback mKeyEventCallback;
    final ArrayList<TransportStateListener> mListeners;
    final TransportMediatorCallback mTransportKeyCallback;
    final View mView;

    static boolean isMediaKey(int keyCode) {
        switch (keyCode) {
            case 79:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 126:
            case 127:
            case 130:
                return true;
            default:
                return false;
        }
    }

    public TransportMediator(Activity activity, TransportPerformer callbacks) {
        this(activity, null, callbacks);
    }

    public TransportMediator(View view, TransportPerformer callbacks) {
        this(null, view, callbacks);
    }

    private TransportMediator(Activity activity, View view, TransportPerformer callbacks) {
        this.mListeners = new ArrayList<>();
        this.mTransportKeyCallback = new TransportMediatorCallback() { // from class: android.support.v4.media.TransportMediator.1
            @Override // android.support.v4.media.TransportMediatorCallback
            public void handleKey(KeyEvent key) {
                key.dispatch(TransportMediator.this.mKeyEventCallback);
            }

            @Override // android.support.v4.media.TransportMediatorCallback
            public void handleAudioFocusChange(int focusChange) {
                TransportMediator.this.mCallbacks.onAudioFocusChange(focusChange);
            }

            @Override // android.support.v4.media.TransportMediatorCallback
            public long getPlaybackPosition() {
                return TransportMediator.this.mCallbacks.onGetCurrentPosition();
            }

            @Override // android.support.v4.media.TransportMediatorCallback
            public void playbackPositionUpdate(long newPositionMs) {
                TransportMediator.this.mCallbacks.onSeekTo(newPositionMs);
            }
        };
        this.mKeyEventCallback = new KeyEvent.Callback() { // from class: android.support.v4.media.TransportMediator.2
            @Override // android.view.KeyEvent.Callback
            public boolean onKeyDown(int keyCode, KeyEvent event) {
                if (TransportMediator.isMediaKey(keyCode)) {
                    return TransportMediator.this.mCallbacks.onMediaButtonDown(keyCode, event);
                }
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyLongPress(int keyCode, KeyEvent event) {
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyUp(int keyCode, KeyEvent event) {
                if (TransportMediator.isMediaKey(keyCode)) {
                    return TransportMediator.this.mCallbacks.onMediaButtonUp(keyCode, event);
                }
                return false;
            }

            @Override // android.view.KeyEvent.Callback
            public boolean onKeyMultiple(int keyCode, int count, KeyEvent event) {
                return false;
            }
        };
        this.mContext = activity != null ? activity : view.getContext();
        this.mCallbacks = callbacks;
        this.mAudioManager = (AudioManager) this.mContext.getSystemService("audio");
        this.mView = activity != null ? activity.getWindow().getDecorView() : view;
        this.mDispatcherState = KeyEventCompat.getKeyDispatcherState(this.mView);
        if (Build.VERSION.SDK_INT >= 18) {
            this.mController = new TransportMediatorJellybeanMR2(this.mContext, this.mAudioManager, this.mView, this.mTransportKeyCallback);
        } else {
            this.mController = null;
        }
    }

    public Object getRemoteControlClient() {
        if (this.mController != null) {
            return this.mController.getRemoteControlClient();
        }
        return null;
    }

    public boolean dispatchKeyEvent(KeyEvent event) {
        return KeyEventCompat.dispatch(event, this.mKeyEventCallback, this.mDispatcherState, this);
    }

    @Override // android.support.v4.media.TransportController
    public void registerStateListener(TransportStateListener listener) {
        this.mListeners.add(listener);
    }

    @Override // android.support.v4.media.TransportController
    public void unregisterStateListener(TransportStateListener listener) {
        this.mListeners.remove(listener);
    }

    private TransportStateListener[] getListeners() {
        if (this.mListeners.size() <= 0) {
            return null;
        }
        TransportStateListener[] listeners = new TransportStateListener[this.mListeners.size()];
        this.mListeners.toArray(listeners);
        return listeners;
    }

    private void reportPlayingChanged() {
        TransportStateListener[] listeners = getListeners();
        if (listeners != null) {
            for (TransportStateListener listener : listeners) {
                listener.onPlayingChanged(this);
            }
        }
    }

    private void reportTransportControlsChanged() {
        TransportStateListener[] listeners = getListeners();
        if (listeners != null) {
            for (TransportStateListener listener : listeners) {
                listener.onTransportControlsChanged(this);
            }
        }
    }

    private void pushControllerState() {
        if (this.mController != null) {
            this.mController.refreshState(this.mCallbacks.onIsPlaying(), this.mCallbacks.onGetCurrentPosition(), this.mCallbacks.onGetTransportControlFlags());
        }
    }

    public void refreshState() {
        pushControllerState();
        reportPlayingChanged();
        reportTransportControlsChanged();
    }

    @Override // android.support.v4.media.TransportController
    public void startPlaying() {
        if (this.mController != null) {
            this.mController.startPlaying();
        }
        this.mCallbacks.onStart();
        pushControllerState();
        reportPlayingChanged();
    }

    @Override // android.support.v4.media.TransportController
    public void pausePlaying() {
        if (this.mController != null) {
            this.mController.pausePlaying();
        }
        this.mCallbacks.onPause();
        pushControllerState();
        reportPlayingChanged();
    }

    @Override // android.support.v4.media.TransportController
    public void stopPlaying() {
        if (this.mController != null) {
            this.mController.stopPlaying();
        }
        this.mCallbacks.onStop();
        pushControllerState();
        reportPlayingChanged();
    }

    @Override // android.support.v4.media.TransportController
    public long getDuration() {
        return this.mCallbacks.onGetDuration();
    }

    @Override // android.support.v4.media.TransportController
    public long getCurrentPosition() {
        return this.mCallbacks.onGetCurrentPosition();
    }

    @Override // android.support.v4.media.TransportController
    public void seekTo(long pos) {
        this.mCallbacks.onSeekTo(pos);
    }

    @Override // android.support.v4.media.TransportController
    public boolean isPlaying() {
        return this.mCallbacks.onIsPlaying();
    }

    @Override // android.support.v4.media.TransportController
    public int getBufferPercentage() {
        return this.mCallbacks.onGetBufferPercentage();
    }

    @Override // android.support.v4.media.TransportController
    public int getTransportControlFlags() {
        return this.mCallbacks.onGetTransportControlFlags();
    }

    public void destroy() {
        this.mController.destroy();
    }
}
