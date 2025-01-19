package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0322_WC1_NISSAN_LouLan extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 5;
    public static final int U_SETTING_A6D60 = 3;
    public static final int U_SETTING_A6D63 = 2;
    public static final int U_SETTING_A6D64 = 1;
    public static final int U_SETTING_A6D70 = 4;
    public static final int U_SETTING_BEGIN = 0;

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
