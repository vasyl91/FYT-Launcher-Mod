package com.syu.module.canbus.up;

import android.os.RemoteException;

import com.syu.ipc.IRemoteToolkit;
import com.syu.module.ConnectionObserver;
import com.syu.module.canbus.ModuleCallbackCanbusProxy;

public class ConnectionCanUp implements ConnectionObserver {
    private static final ConnectionCanUp INSTANCE = new ConnectionCanUp();

    public static ConnectionCanUp getInstance() {
        return INSTANCE;
    }

    private ConnectionCanUp() {
    }

    @Override
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            DataCanUp.PROXY.setRemoteModule(toolkit.getRemoteModule(14));
            ModuleCallbackCanUpProxy callback = ModuleCallbackCanUpProxy.getInstance();
            DataCanUp.PROXY.register(callback, 100, 1);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisconnected() {
        DataCanUp.PROXY.setRemoteModule(null);
        DataCanUp.DATA[100] = 0;
        ModuleCallbackCanbusProxy.getInstance().setCallbackCanbus(null);
    }
}
