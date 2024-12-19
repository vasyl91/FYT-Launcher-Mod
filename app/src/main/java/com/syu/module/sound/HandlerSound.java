package com.syu.module.sound;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class HandlerSound {
    public static void update(int updateCode, int value) {
        if (DataSound.DATA[updateCode] != value) {
            DataSound.DATA[updateCode] = value;
            DataSound.NOTIFY_EVENTS[updateCode].onNotify();
        }
    }
}
