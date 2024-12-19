package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0067_WC3_SiYu extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 9;
    public static final int U_AIR_END = 10;
    public static final int U_CNT_MAX = 10;
    public static final int U_COMPASS_STATUS = 8;
    public static final int U_CUR_SPEED = 0;
    public static final int U_MISC_BEGIN = 0;
    public static final int U_MISC_END = 9;
    public static final int U_PLAYER_MDI = 5;
    public static final int U_PLAYER_PROGRESS = 6;
    public static final int U_PLAYER_STATES = 7;
    public static final int U_PLAYER_TIME = 2;
    public static final int U_PLAYER_TOTAL_TRACK = 4;
    public static final int U_PLAYER_TRACK = 3;
    public static final int U_USB_TYPE = 1;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 10; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 10) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
