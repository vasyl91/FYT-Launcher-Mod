package com.syu.module.main;

import android.os.RemoteException;
import com.syu.ipc.IRemoteToolkit;
import com.syu.module.ConnectionObserver;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ConnectionMain implements ConnectionObserver {
    private static final ConnectionMain INSTANCE = new ConnectionMain();

    public static ConnectionMain getInstance() {
        return INSTANCE;
    }

    private ConnectionMain() {
    }

    @Override // com.syu.module.ConnectionObserver
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            DataMain.PROXY.setRemoteModule(toolkit.getRemoteModule(0));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        ModuleCallbackMain callback = ModuleCallbackMain.getInstance();
        DataMain.PROXY.register(callback, 0, 1);
        DataMain.PROXY.register(callback, 12, 1);
        DataMain.PROXY.register(callback, 174, 1);
    }

    @Override // com.syu.module.ConnectionObserver
    public void onDisconnected() {
        DataMain.PROXY.setRemoteModule(null);
    }
}