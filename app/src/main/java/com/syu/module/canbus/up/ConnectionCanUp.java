package com.syu.module.canbus.up;

import android.os.RemoteException;
import com.syu.ipc.IRemoteToolkit;
import com.syu.module.ConnectionObserver;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ConnectionCanUp implements ConnectionObserver {
    private static final ConnectionCanUp INSTANCE = new ConnectionCanUp();

    public static ConnectionCanUp getInstance() {
        return INSTANCE;
    }

    private ConnectionCanUp() {
    }

    @Override // com.syu.module.ConnectionObserver
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            DataCanUp.PROXY.setRemoteModule(toolkit.getRemoteModule(14));
            ModuleCallbackCanUpProxy callback = ModuleCallbackCanUpProxy.getInstance();
            DataCanUp.PROXY.register(callback, 100, 1);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.syu.module.ConnectionObserver
    public void onDisconnected() {
        DataCanUp.PROXY.setRemoteModule(null);
        DataCanUp.DATA[100] = 0;
        ModuleCallbackCanbusProxy.getInstance().setCallbackCanbus(null);
    }
}
