package com.pekall.fmradio;

import android.content.Context;
import android.media.AudioSystem;
import android.provider.Settings;
import android.support.v4.view.accessibility.AccessibilityEventCompat;
import com.lsec.core.util.data.FinalChip;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FmAudioDeviceInterface extends FmAudioDefaultImpl {
    private int mDialToneSetting;
    private boolean mToneDisabled;
    private int mTouchToneSetting;

    public FmAudioDeviceInterface(FMRadioService service, Context context) {
        super(service, context);
        this.mDialToneSetting = 1;
        this.mTouchToneSetting = 1;
        this.mToneDisabled = false;
    }

    @Override // com.pekall.fmradio.FmAudioDefaultImpl
    public void powerOnAudio() {
        disableTouchTones();
        super.powerOnAudio();
    }

    @Override // com.pekall.fmradio.FmAudioDefaultImpl
    public void powerOffAudio() {
        super.powerOffAudio();
    }

    @Override // com.pekall.fmradio.FmAudioDefaultImpl
    public void disableTouchSound() {
        disableTouchTones();
    }

    @Override // com.pekall.fmradio.FmAudioDefaultImpl
    public void enableTouchSound() {
        enableTouchTones();
    }

    private void disableTouchTones() {
        if (!this.mToneDisabled) {
            this.mToneDisabled = true;
            this.mDialToneSetting = Settings.System.getInt(this.mFMService.getContentResolver(), "dtmf_tone", 1);
            this.mTouchToneSetting = Settings.System.getInt(this.mFMService.getContentResolver(), "sound_effects_enabled", 1);
            Settings.System.putInt(this.mFMService.getContentResolver(), "dtmf_tone", 0);
            Settings.System.putInt(this.mFMService.getContentResolver(), "sound_effects_enabled", 0);
            if (this.mDialToneSetting == 1 || this.mTouchToneSetting == 1) {
                this.mAudioMgr.unloadSoundEffects();
            }
        }
    }

    private void enableTouchTones() {
        if (this.mToneDisabled) {
            this.mToneDisabled = false;
            if (this.mDialToneSetting == 1 || this.mTouchToneSetting == 1) {
                this.mAudioMgr.loadSoundEffects();
            }
            int currentSetting = Settings.System.getInt(this.mFMService.getContentResolver(), "dtmf_tone", 1);
            if (currentSetting != this.mDialToneSetting) {
                Settings.System.putInt(this.mFMService.getContentResolver(), "dtmf_tone", this.mDialToneSetting);
            }
            int currentSetting2 = Settings.System.getInt(this.mFMService.getContentResolver(), "sound_effects_enabled", 1);
            if (currentSetting2 != this.mTouchToneSetting) {
                Settings.System.putInt(this.mFMService.getContentResolver(), "sound_effects_enabled", this.mTouchToneSetting);
            }
        }
    }

    @Override // com.pekall.fmradio.FmAudioDefaultImpl
    protected void enableAudio() {
        if (AudioSystem.getDeviceConnectionState(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, FinalChip.BSP_PLATFORM_Null) == 0) {
            AudioSystem.setDeviceConnectionState(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, 1, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null);
        }
    }

    @Override // com.pekall.fmradio.FmAudioDefaultImpl
    protected void disableAudio() {
        if (1 == AudioSystem.getDeviceConnectionState(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, FinalChip.BSP_PLATFORM_Null)) {
            AudioSystem.setDeviceConnectionState(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, 0, FinalChip.BSP_PLATFORM_Null, FinalChip.BSP_PLATFORM_Null);
        }
    }

    public boolean isAudioOn() {
        return 1 == AudioSystem.getDeviceConnectionState(AccessibilityEventCompat.TYPE_TOUCH_INTERACTION_START, FinalChip.BSP_PLATFORM_Null);
    }
}
