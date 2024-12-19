package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IRemoteToolkit;
import com.syu.module.ConnectionObserver;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class ConnectionCanbus implements ConnectionObserver {
    private static final ConnectionCanbus INSTANCE = new ConnectionCanbus();

    public static ConnectionCanbus getInstance() {
        return INSTANCE;
    }

    private ConnectionCanbus() {
    }

    @Override // com.syu.module.ConnectionObserver
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            DataCanbus.PROXY.setRemoteModule(toolkit.getRemoteModule(7));
            ModuleCallbackCanbusProxy callback = ModuleCallbackCanbusProxy.getInstance();
            DataCanbus.PROXY.register(callback, 1000, 1);
            DataCanbus.PROXY.register(callback, FinalCanbus.U_AIR_WINDOW_ENABLE, 1);
            DataCanbus.PROXY.register(callback, FinalCanbus.U_DOOR_WINDOW_ENABLE, 1);
            DataCanbus.PROXY.register(callback, FinalCanbus.U_CAR_BT_ON, 1);
            DataCanbus.PROXY.register(callback, FinalCanbus.U_SHOW_AIR_WINDOW, 1);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.syu.module.ConnectionObserver
    public void onDisconnected() {
        DataCanbus.PROXY.setRemoteModule(null);
        DataCanbus.DATA[1000] = 0;
        ModuleCallbackCanbusProxy.getInstance().setCallbackCanbus(null);
    }
}
