package com.syu.module;

import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public interface ConnectionObserver {
    void onConnected(IRemoteToolkit iRemoteToolkit);

    void onDisconnected();
}
