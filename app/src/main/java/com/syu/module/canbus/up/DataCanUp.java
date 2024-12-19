package com.syu.module.canbus.up;

import com.syu.ipc.RemoteModuleProxy;
import com.syu.module.UiNotifyEvent;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class DataCanUp {
    public static final UiNotifyEvent NOTIFY_EVENTS_FILEPATH;
    public static String mFileUpdatePath;
    public static final RemoteModuleProxy PROXY = new RemoteModuleProxy();
    public static final int[] DATA = new int[120];
    public static final UiNotifyEvent[] NOTIFY_EVENTS = new UiNotifyEvent[120];

    static {
        for (int i = 0; i < 120; i++) {
            NOTIFY_EVENTS[i] = new UiNotifyEvent(i);
        }
        mFileUpdatePath = "";
        NOTIFY_EVENTS_FILEPATH = new UiNotifyEvent();
    }
}
