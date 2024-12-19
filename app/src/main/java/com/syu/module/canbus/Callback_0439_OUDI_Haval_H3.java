package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_OUDI_Haval_H3 extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int U_AIR_AC = 1;
    public static final int U_AIR_AUTO = 2;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY = 7;
    public static final int U_AIR_BLOW_FOOT = 8;
    public static final int U_AIR_BLOW_MODE = 12;
    public static final int U_AIR_BLOW_UP = 6;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_END = 13;
    public static final int U_AIR_FRONT_DEFROST = 4;
    public static final int U_AIR_POWER = 0;
    public static final int U_AIR_REAR_DEFROST = 5;
    public static final int U_AIR_TEMP_LEFT = 10;
    public static final int U_AIR_TEMP_RIGHT = 11;
    public static final int U_AIR_WIND_LEVEL = 9;
    public static final int U_CNT_MAX = 14;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 14; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 14) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
