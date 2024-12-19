package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_Daojun_Kayan extends CallbackCanbusBase {
    public static final int U_AIR_AUTO = 14;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 6;
    public static final int U_AIR_BLOW_FOOT_LEFT = 7;
    public static final int U_AIR_BLOW_MODE = 8;
    public static final int U_AIR_BLOW_UP_LEFT = 5;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_ECON = 9;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_POWER = 4;
    public static final int U_AIR_REAR_DEFROST = 2;
    public static final int U_AIR_REST = 10;
    public static final int U_AIR_TEMP_LEFT = 11;
    public static final int U_AIR_TEMP_RIGHT = 12;
    public static final int U_AIR_WIND_LEVEL = 1;
    public static final int U_CNT_MAX = 16;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 16; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 16) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
