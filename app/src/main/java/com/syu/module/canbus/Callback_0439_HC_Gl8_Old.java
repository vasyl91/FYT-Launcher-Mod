package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0439_HC_Gl8_Old extends CallbackCanbusBase {
    public static final int U_CAR_WARN = 1;
    public static final int U_CNT_MAX = 2;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 2; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 2) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
