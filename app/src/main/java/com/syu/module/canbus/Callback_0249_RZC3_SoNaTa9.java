package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0249_RZC3_SoNaTa9 extends CallbackCanbusBase {
    public static final int U_CARINFO_EQ_BAL = 40;
    public static final int U_CARINFO_EQ_BASS = 36;
    public static final int U_CARINFO_EQ_FAD = 39;
    public static final int U_CARINFO_EQ_MID = 37;
    public static final int U_CARINFO_EQ_TREB = 38;
    public static final int U_CNT_MAX = 41;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 41; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 41) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
