package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_XC_Xiandai_Suolantuo;

public class Callback_0439_XC_Xiandai_Suolantuo extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 99;
    public static final int U_CAREQ_BASS = 101;
    public static final int U_CAREQ_FAD = 100;
    public static final int U_CAREQ_MID = 102;
    public static final int U_CAREQ_TREB = 103;
    public static final int U_CAREQ_VOL = 98;
    public static final int U_CNT_MAX = 104;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 104; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0439_XC_Xiandai_Suolantuo(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 104) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
