package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_TZY_UAZ_Patriot extends CallbackCanbusBase {
    public static int[] CHANNEL_ERROR_CODES = new int[101];
    public static final int U_CARINFO_D24_D0_B70 = 0;
    public static final int U_CARINFO_D24_D1_B70 = 1;
    public static final int U_CNT_MAX = 4;
    public static final int U_ERROR_CODE = 2;
    public static final int U_ERROR_CODES = 3;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 4; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 4) {
            if (updateCode == 3) {
                CHANNEL_ERROR_CODES = ints;
                HandlerCanbus.update(updateCode, ints, flts, strs);
            } else {
                HandlerCanbus.update(updateCode, ints);
            }
        }
    }
}
