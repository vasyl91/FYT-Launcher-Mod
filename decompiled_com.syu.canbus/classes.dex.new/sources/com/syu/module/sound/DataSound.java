package com.syu.module.sound;

import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.UiNotifyEvent;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
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
