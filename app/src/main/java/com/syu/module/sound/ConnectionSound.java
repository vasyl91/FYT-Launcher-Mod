package com.syu.module.sound;

import android.os.RemoteException;
import com.syu.ipc.IRemoteToolkit;
import com.syu.module.ConnectionObserver;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ConnectionSound implements ConnectionObserver {
    private static final ConnectionSound INSTANCE = new ConnectionSound();

    public static ConnectionSound getInstance() {
        return INSTANCE;
    }

    @Override // com.syu.module.ConnectionObserver
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            DataSound.PROXY.setRemoteModule(toolkit.getRemoteModule(4));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        ModuleCallbackSound callback = ModuleCallbackSound.getInstance();
        DataSound.PROXY.register(callback, 2, 1);
        DataSound.PROXY.register(callback, 3, 1);
    }

    @Override // com.syu.module.ConnectionObserver
    public void onDisconnected() {
        DataSound.PROXY.setRemoteModule(null);
    }
}
