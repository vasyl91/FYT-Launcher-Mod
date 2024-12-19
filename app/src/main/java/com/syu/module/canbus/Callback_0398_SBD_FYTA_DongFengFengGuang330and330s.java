package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0398_SBD_FYTA_DongFengFengGuang330and330s extends CallbackCanbusBase {
    private static final int U_CNT_MAX = 45;
    public static final int U_SET_POWER_ANIMATE = 44;
    public static final int U_SET_TRIGGER_FORWARD = 43;
    public static final int U_SET_TRIGGER_LEFT = 40;
    public static final int U_SET_TRIGGER_RIGHT = 41;
    public static final int U_SET_TRIGGER_STEER = 42;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 45; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 45) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
