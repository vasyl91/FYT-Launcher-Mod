package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0107_DJ_QiRuiAiRuiZe7 extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 3;
    public static final int U_AIR_BEGIN = 8;
    public static final int U_AIR_END = 9;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 5;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 4;
    public static final int U_AUTOLOCK_BY_SPEED = 2;
    public static final int U_CARINFO_END = 8;
    public static final int U_CLOSE_BIGLAMP_TIME = 7;
    public static final int U_CLOSE_INSIDELAMP_TIME = 6;
    public static final int U_CNT_MAX = 9;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 1;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 9; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 9) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
