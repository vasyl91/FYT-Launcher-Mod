package com.syu.module.sound;

import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.UiNotifyEvent;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DataSound {
    public static final RemoteModuleProxy PROXY = new RemoteModuleProxy();
    public static final int[] DATA = new int[50];
    public static final UiNotifyEvent[] NOTIFY_EVENTS = new UiNotifyEvent[50];

    static {
        for (int i = 0; i < 50; i++) {
            NOTIFY_EVENTS[i] = new UiNotifyEvent(i);
        }
    }
}
