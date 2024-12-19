package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0349_BAGOO_XP1_PorscheCayenne extends CallbackCanbusBase {
    public static final int U_AVERAGE_SPEED = 4;
    public static final int U_CARINFO_BEGIN = 0;
    public static final int U_CNT_MAX = 5;
    public static final int U_CUR_OIL_EXPEND = 1;
    public static final int U_DRIVING_TIME = 3;
    public static final int U_OPTIMAL_OIL_EXPEND = 2;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 5; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 5) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
