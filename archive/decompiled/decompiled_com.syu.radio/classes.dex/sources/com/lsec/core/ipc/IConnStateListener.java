package com.lsec.core.ipc;

import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public interface IConnStateListener {
    void onConnected(IRemoteToolkit iRemoteToolkit);

    void onDisconnected();

    void setRegisterModuleCallBack(IRegisterModuleCallBack iRegisterModuleCallBack);
}
