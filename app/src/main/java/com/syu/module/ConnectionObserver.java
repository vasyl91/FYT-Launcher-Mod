package com.syu.module;

import com.syu.ipc.IRemoteToolkit;

public interface ConnectionObserver {
    void onConnected(IRemoteToolkit iRemoteToolkit);

    void onDisconnected();
}
