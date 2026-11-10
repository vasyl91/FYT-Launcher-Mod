package com.pekall.fmradio;

import android.content.Context;
import android.media.AudioManager;
import android.os.SystemProperties;
import com.syu.radio.App_Radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public abstract class FmAudioDefaultImpl {
    public static final int FMRADIO_MUTE_AUDIO = 0;
    public static final int FMRADIO_UNMUTE_AUDIO = 1;
    public static final String FM_ROUTE_HEADSET = "com.pekall.fmradio.route.headset";
    public static final String FM_ROUTE_LOUDSPEAKER = "com.pekall.fmradio.route.loudspeaker";
    public static final int ROUTE_FM_HEADSET = 0;
    public static final int ROUTE_FM_SPEAKER = 1;
    protected final AudioManager mAudioMgr;
    protected final FMRadioService mFMService;
    protected boolean mLostFocus;
    private int mVolumeStep;
    protected int mFMAudioRouting = 0;
    protected int mSpeakerOn = 0;
    protected boolean mFMOn = false;
    private boolean mIsMuted = false;
    private double[] dbHeadsetArray = {0.0d, 0.007079458d, 0.008912509d, 0.010592537d, 0.014962357d, 0.022387211d, 0.033496544d, 0.047315126d, 0.070794578d, 0.1d, 0.149623566d, 0.223872114d, 0.316227766d, 0.473151259d, 0.668343918d, 1.0d};

    protected abstract void disableAudio();

    protected abstract void enableAudio();

    public void disableTouchSound() {
    }

    public void enableTouchSound() {
    }

    public FmAudioDefaultImpl(FMRadioService service, Context context) {
        this.mVolumeStep = 0;
        this.mFMService = service;
        this.mAudioMgr = (AudioManager) context.getSystemService("audio");
        this.mVolumeStep = this.mAudioMgr.getStreamVolume(3);
    }

    public void powerOnAudio() {
        this.mLostFocus = false;
        this.mVolumeStep = this.mAudioMgr.getStreamVolume(3);
        if (!App_Radio.bIsRadioArmExt) {
            this.mAudioMgr.setParameters("route-fm=headset");
        }
        this.mSpeakerOn = 0;
        this.mFMOn = true;
        SystemProperties.set("fm.on", "true");
    }

    public void powerOnAudioOnFocusLoss() {
        if (this.mFMOn && !App_Radio.bIsRadioArmExt) {
            if (this.mSpeakerOn != 0) {
                this.mAudioMgr.setParameters("route-fm=speaker");
            } else {
                this.mAudioMgr.setParameters("route-fm=headset");
            }
        }
    }

    public void powerOffAudio() {
        if (!App_Radio.bIsRadioArmExt) {
            this.mAudioMgr.setParameters("route-fm=disabled");
        }
        this.mSpeakerOn = 0;
        setMute(false);
        this.mLostFocus = false;
        this.mFMOn = false;
        SystemProperties.set("fm.on", "false");
    }

    public void setFMStreamVol(int volume) {
        if (this.mAudioMgr != null && volume != this.mVolumeStep) {
            this.mAudioMgr.setParameters("fm-volume=" + this.dbHeadsetArray[volume]);
            this.mVolumeStep = volume;
        }
    }

    public int getFMStreamVolCurr() {
        return this.mAudioMgr.getStreamVolume(3);
    }

    public void setMute(boolean mute) {
        this.mIsMuted = mute;
        if (mute) {
            this.mAudioMgr.setParameters("fm-volume=" + this.dbHeadsetArray[0]);
        } else {
            this.mAudioMgr.setParameters("fm-volume=" + this.dbHeadsetArray[this.mVolumeStep]);
        }
    }

    public boolean getMute() {
        return this.mIsMuted;
    }

    public void setAudioOnSpeaker(boolean speaker) {
        if (!App_Radio.bIsRadioArmExt) {
            if (speaker) {
                if (this.mFMOn) {
                    this.mAudioMgr.setParameters("route-fm=speaker");
                    this.mSpeakerOn = 1;
                    return;
                }
                return;
            }
            if (this.mFMOn) {
                this.mAudioMgr.setParameters("route-fm=headset");
                this.mSpeakerOn = 0;
            }
        }
    }

    public int getAudioPath() {
        return this.mSpeakerOn;
    }

    public void onAudioFocusChange(int focusChange) {
        if (2 == this.mFMService.getState() || this.mFMService.getState() == 0 || 1 == this.mFMService.getState()) {
            switch (focusChange) {
                case -3:
                case -2:
                    this.mAudioMgr.setParameters("fmr_notify=audiofocus_loss_transient");
                    if (!App_Radio.bIsRadioArmExt) {
                        this.mAudioMgr.setParameters("route-fm=disabled");
                    }
                    this.mLostFocus = true;
                    break;
                case -1:
                    App_Radio.getInstance().RadioSophia_PowerOff();
                    break;
                case 1:
                    if (this.mLostFocus) {
                        this.mAudioMgr.setParameters("fmr_notify=audiofocus_gain");
                        powerOnAudioOnFocusLoss();
                        this.mLostFocus = false;
                    }
                    break;
            }
        }
    }
}
