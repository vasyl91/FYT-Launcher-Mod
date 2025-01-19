package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0249_RZC3_SoNaTa9 extends CallbackCanbusBase {
    public static final int U_CARINFO_EQ_BAL = 102;
    public static final int U_CARINFO_EQ_BASS = 98;
    public static final int U_CARINFO_EQ_FAD = 101;
    public static final int U_CARINFO_EQ_MID = 99;
    public static final int U_CARINFO_EQ_TREB = 100;
    public static final int U_CNT_MAX = 103;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 103; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 103) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
