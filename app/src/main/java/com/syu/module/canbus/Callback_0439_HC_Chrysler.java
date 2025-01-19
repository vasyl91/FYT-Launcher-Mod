package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;

public class Callback_0439_HC_Chrysler extends CallbackCanbusBase {
    public static final int CMD_CARSET_CTRL = 0;
    public static final int U_CAR_CD_BAN = 4;
    public static final int U_CAR_CD_BASS = 0;
    public static final int U_CAR_CD_FAD = 3;
    public static final int U_CAR_CD_MID = 1;
    public static final int U_CAR_CD_TREB = 2;
    public static final int U_CAR_CD_VOL = 5;
    public static final int U_CNT_MAX = 6;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 6; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override
    public void out() {
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 6) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
