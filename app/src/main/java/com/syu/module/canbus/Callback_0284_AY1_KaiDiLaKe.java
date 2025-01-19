package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0284_AY1_KaiDiLaKe extends CallbackCanbusBase {
    public static final int U_AVERAGE_SPEED = 99;
    public static final int U_CNT_MAX = 103;
    public static final int U_CURRENT_SPEED = 98;
    public static final int U_CUR_OIL_EXPEND = 100;
    public static final int U_DRIVING_MILEAGE = 101;
    public static final int U_OPTIMAL_OIL_EXPEND = 102;

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
