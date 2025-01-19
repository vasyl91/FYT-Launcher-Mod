package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0444_WC2_DAIHATSU_All extends CallbackCanbusBase {
    public static final int U_CARINF_DE8_D0_B0 = 2;
    public static final int U_CARINF_DE8_D0_B1 = 1;
    public static final int U_CARINF_DE8_D1_B70 = 3;
    public static final int U_CARINF_UBACK_STATE = 4;
    public static final int U_CNT_MAX = 5;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 5; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 5) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
