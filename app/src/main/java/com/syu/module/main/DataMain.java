package com.syu.module.main;

import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.UiNotifyEvent;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DataMain {
    public static int sAppIdRequest;
    public static final RemoteModuleProxy PROXY = new RemoteModuleProxy();
    public static final int[] DATA = new int[200];
    public static final UiNotifyEvent[] NOTIFY_EVENTS = new UiNotifyEvent[200];

    static {
        for (int i = 0; i < 200; i++) {
            NOTIFY_EVENTS[i] = new UiNotifyEvent(i);
        }
    }
}
