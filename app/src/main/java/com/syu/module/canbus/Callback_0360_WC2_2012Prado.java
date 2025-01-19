package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0360_WC2_2012Prado extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 1;
    public static final int U_SETTING_A6D70 = 0;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 1; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 1) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
