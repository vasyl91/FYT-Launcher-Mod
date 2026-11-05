package com.syu.jni;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class FuncJni {
    private static int sFD = -1;

    public static int readSpectGram() {
        if (sFD == -1) {
            sFD = ControlNative.getInstance().fyt_sound_spectrogram_open();
        }
        if (sFD != -1) {
            return ControlNative.getInstance().fyt_sound_spectrogram_read(sFD);
        }
        return 1;
    }
}
