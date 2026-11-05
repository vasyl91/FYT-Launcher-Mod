package android.support.v4.media;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.RemoteControlClient;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
class TransportMediatorJellybeanMR2 implements RemoteControlClient.OnGetPlaybackPositionListener, RemoteControlClient.OnPlaybackPositionUpdateListener {
    boolean mAudioFocused;
    final AudioManager mAudioManager;
    final Context mContext;
    boolean mFocused;
    final Intent mIntent;
    PendingIntent mPendingIntent;
    final String mReceiverAction;
    final IntentFilter mReceiverFilter;
    RemoteControlClient mRemoteControl;
    final View mTargetView;
    final TransportMediatorCallback mTransportCallback;
    final ViewTreeObserver.OnWindowAttachListener mWindowAttachListener = new ViewTreeObserver.OnWindowAttachListener() { // from class: android.support.v4.media.TransportMediatorJellybeanMR2.1
        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowAttached() {
            TransportMediatorJellybeanMR2.this.windowAttached();
        }

        @Override // android.view.ViewTreeObserver.OnWindowAttachListener
        public void onWindowDetached() {
            TransportMediatorJellybeanMR2.this.windowDetached();
        }
    };
    final ViewTreeObserver.OnWindowFocusChangeListener mWindowFocusListener = new ViewTreeObserver.OnWindowFocusChangeListener() { // from class: android.support.v4.media.TransportMediatorJellybeanMR2.2
        @Override // android.view.ViewTreeObserver.OnWindowFocusChangeListener
        public void onWindowFocusChanged(boolean hasFocus) {
            if (!hasFocus) {
                TransportMediatorJellybeanMR2.this.loseFocus();
            } else {
                TransportMediatorJellybeanMR2.this.gainFocus();
            }
        }
    };
    final BroadcastReceiver mMediaButtonReceiver = new BroadcastReceiver() { // from class: android.support.v4.media.TransportMediatorJellybeanMR2.3
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                KeyEvent event = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
                TransportMediatorJellybeanMR2.this.mTransportCallback.handleKey(event);
            } catch (ClassCastException e) {
                Log.w("TransportController", e);
            }
        }
    };
    AudioManager.OnAudioFocusChangeListener mAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() { // from class: android.support.v4.media.TransportMediatorJellybeanMR2.4
        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int focusChange) {
            TransportMediatorJellybeanMR2.this.mTransportCallback.handleAudioFocusChange(focusChange);
        }
    };
    int mPlayState = 0;

    public TransportMediatorJellybeanMR2(Context context, AudioManager audioManager, View view, TransportMediatorCallback transportCallback) {
        this.mContext = context;
        this.mAudioManager = audioManager;
        this.mTargetView = view;
        this.mTransportCallback = transportCallback;
        this.mReceiverAction = context.getPackageName() + ":transport:" + System.identityHashCode(this);
        this.mIntent = new Intent(this.mReceiverAction);
        this.mIntent.setPackage(context.getPackageName());
        this.mReceiverFilter = new IntentFilter();
        this.mReceiverFilter.addAction(this.mReceiverAction);
        this.mTargetView.getViewTreeObserver().addOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().addOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    public Object getRemoteControlClient() {
        return this.mRemoteControl;
    }

    public void destroy() {
        windowDetached();
        this.mTargetView.getViewTreeObserver().removeOnWindowAttachListener(this.mWindowAttachListener);
        this.mTargetView.getViewTreeObserver().removeOnWindowFocusChangeListener(this.mWindowFocusListener);
    }

    void windowAttached() {
        this.mContext.registerReceiver(this.mMediaButtonReceiver, this.mReceiverFilter);
        this.mPendingIntent = PendingIntent.getBroadcast(this.mContext, 0, this.mIntent, 268435456);
        this.mRemoteControl = new RemoteControlClient(this.mPendingIntent);
        this.mRemoteControl.setOnGetPlaybackPositionListener(this);
        this.mRemoteControl.setPlaybackPositionUpdateListener(this);
    }

    void gainFocus() {
        if (!this.mFocused) {
            this.mFocused = true;
            this.mAudioManager.registerMediaButtonEventReceiver(this.mPendingIntent);
            this.mAudioManager.registerRemoteControlClient(this.mRemoteControl);
            if (this.mPlayState == 3) {
                takeAudioFocus();
            }
        }
    }

    void takeAudioFocus() {
        if (!this.mAudioFocused) {
            this.mAudioFocused = true;
            this.mAudioManager.requestAudioFocus(this.mAudioFocusChangeListener, 3, 1);
        }
    }

    public void startPlaying() {
        if (this.mPlayState != 3) {
            this.mPlayState = 3;
            this.mRemoteControl.setPlaybackState(3);
        }
        if (this.mFocused) {
            takeAudioFocus();
        }
    }

    @Override // android.media.RemoteControlClient.OnGetPlaybackPositionListener
    public long onGetPlaybackPosition() {
        return this.mTransportCallback.getPlaybackPosition();
    }

    @Override // android.media.RemoteControlClient.OnPlaybackPositionUpdateListener
    public void onPlaybackPositionUpdate(long newPositionMs) {
        this.mTransportCallback.playbackPositionUpdate(newPositionMs);
    }

    public void refreshState(boolean playing, long position, int transportControls) {
        if (this.mRemoteControl != null) {
            this.mRemoteControl.setPlaybackState(playing ? 3 : 1, position, playing ? 1.0f : 0.0f);
            this.mRemoteControl.setTransportControlFlags(transportControls);
        }
    }

    public void pausePlaying() {
        if (this.mPlayState == 3) {
            this.mPlayState = 2;
            this.mRemoteControl.setPlaybackState(2);
        }
        dropAudioFocus();
    }

    public void stopPlaying() {
        if (this.mPlayState != 1) {
            this.mPlayState = 1;
            this.mRemoteControl.setPlaybackState(1);
        }
        dropAudioFocus();
    }

    void dropAudioFocus() {
        if (this.mAudioFocused) {
            this.mAudioFocused = false;
            this.mAudioManager.abandonAudioFocus(this.mAudioFocusChangeListener);
        }
    }

    void loseFocus() {
        dropAudioFocus();
        if (this.mFocused) {
            this.mFocused = false;
            this.mAudioManager.unregisterRemoteControlClient(this.mRemoteControl);
            this.mAudioManager.unregisterMediaButtonEventReceiver(this.mPendingIntent);
        }
    }

    void windowDetached() {
        loseFocus();
        if (this.mPendingIntent != null) {
            this.mContext.unregisterReceiver(this.mMediaButtonReceiver);
            this.mPendingIntent.cancel();
            this.mPendingIntent = null;
            this.mRemoteControl = null;
        }
    }
}
