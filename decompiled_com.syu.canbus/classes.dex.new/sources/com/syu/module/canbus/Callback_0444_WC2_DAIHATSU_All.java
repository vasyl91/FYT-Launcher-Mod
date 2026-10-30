package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0444_WC2_DAIHATSU_All extends CallbackCanbusBase {
    public static final int U_CARINF_DE8_D0_B0 = 2;
    public static final int U_CARINF_DE8_D0_B1 = 1;
    public static final int U_CARINF_DE8_D1_B70 = 3;
    public static final int U_CARINF_UBACK_STATE = 4;
    public static final int U_CNT_MAX = 5;

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
