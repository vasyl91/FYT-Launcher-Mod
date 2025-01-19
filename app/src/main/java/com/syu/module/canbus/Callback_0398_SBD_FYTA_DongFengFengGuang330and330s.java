package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0398_SBD_FYTA_DongFengFengGuang330and330s extends CallbackCanbusBase {
    private static final int U_CNT_MAX = 45;
    public static final int U_SET_POWER_ANIMATE = 44;
    public static final int U_SET_TRIGGER_FORWARD = 43;
    public static final int U_SET_TRIGGER_LEFT = 40;
    public static final int U_SET_TRIGGER_RIGHT = 41;
    public static final int U_SET_TRIGGER_STEER = 42;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 45; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 45) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
