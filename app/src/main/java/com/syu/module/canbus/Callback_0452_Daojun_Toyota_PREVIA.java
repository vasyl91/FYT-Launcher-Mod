package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0452_Daojun_Toyota_PREVIA extends CallbackCanbusBase {
    public static final int U_CARSET_D6A_D0_B0 = 1;
    public static final int U_CARSET_D6A_D0_B1 = 2;
    public static final int U_CNT_MAX = 3;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 3; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 3) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
