package com.syu.audio;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class AndroidAudioFocusManger implements AudioManager.OnAudioFocusChangeListener {
    public static AndroidAudioFocusManger g;
    public int a;
    public final AudioManager d;
    public int b = -1;
    public boolean c = false;
    public AudioFocusRequest e = null;
    public OnFocusChangeListener f = null;

    public interface OnFocusChangeListener {
        void onAudioFocusChange(AndroidAudioFocusManger androidAudioFocusManger, int i, boolean z);
    }

    public AndroidAudioFocusManger(Context context) {
        this.a = -1;
        this.d = (AudioManager) context.getSystemService("audio");
        this.a = -1;
    }

    public static AndroidAudioFocusManger getInstance(Context context) {
        if (g == null) {
            g = new AndroidAudioFocusManger(context.getApplicationContext());
        }
        return g;
    }

    public int getAudioFocus() {
        return this.a;
    }

    public int getFocusGain() {
        return this.b;
    }

    public boolean isUiShowing() {
        return this.c;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public void onAudioFocusChange(int i) {
        OnFocusChangeListener onFocusChangeListener = this.f;
        if (onFocusChangeListener != null) {
            onFocusChangeListener.onAudioFocusChange(this, this.a, this.c);
        }
        this.a = i;
    }

    public void releaseAudioFocus() {
        if (this.a != -1) {
            AudioFocusRequest audioFocusRequest = this.e;
            if (audioFocusRequest != null) {
                this.d.abandonAudioFocusRequest(audioFocusRequest);
            } else {
                this.d.abandonAudioFocus(this);
            }
        }
        this.a = -1;
    }

    public boolean requestAudioFocus(int i, int i2) {
        this.b = i2;
        if (this.a == i2) {
            return true;
        }
        AudioFocusRequest audioFocusRequestBuild = new AudioFocusRequest.Builder(i2).setOnAudioFocusChangeListener(this).setAudioAttributes(new AudioAttributes.Builder().setContentType(2).setUsage(1).build()).build();
        this.e = audioFocusRequestBuild;
        boolean z = this.d.requestAudioFocus(audioFocusRequestBuild) == 1;
        if (z) {
            OnFocusChangeListener onFocusChangeListener = this.f;
            if (onFocusChangeListener != null) {
                onFocusChangeListener.onAudioFocusChange(this, this.a, this.c);
            }
            this.a = i2;
        }
        return z;
    }

    public void setOnFocusChangeListener(OnFocusChangeListener onFocusChangeListener) {
        this.f = onFocusChangeListener;
    }

    public void setUiShowing(boolean z) {
        this.c = z;
    }
}
