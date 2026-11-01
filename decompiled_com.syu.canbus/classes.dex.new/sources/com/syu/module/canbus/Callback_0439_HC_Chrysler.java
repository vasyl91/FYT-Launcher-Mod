package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0439_HC_Chrysler extends CallbackCanbusBase {
    public static final int CMD_CARSET_CTRL = 0;
    public static final int U_CAR_CD_BAN = 4;
    public static final int U_CAR_CD_BASS = 0;
    public static final int U_CAR_CD_FAD = 3;
    public static final int U_CAR_CD_MID = 1;
    public static final int U_CAR_CD_TREB = 2;
    public static final int U_CAR_CD_VOL = 5;
    public static final int U_CNT_MAX = 6;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 6; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 6) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
