package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_CXW_K50 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_FOOT_LEFT = 7;
    public static final int U_AIR_BLOW_MODE_LEFT = 5;
    public static final int U_AIR_BLOW_WIN_LEFT = 6;
    public static final int U_AIR_CYCLE = 1;
    public static final int U_AIR_END = 10;
    public static final int U_AIR_POWER = 3;
    public static final int U_AIR_REAR = 0;
    public static final int U_AIR_TEMP_LEFT = 9;
    public static final int U_AIR_WIND_LEVEL_LEFT = 4;
    public static final int U_CNT_MAX = 11;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 11; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 11) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
