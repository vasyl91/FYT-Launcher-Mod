package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_HC_QiyaKaizunK7;

public class Callback_0439_HC_Qiya_KaiZunK7 extends CallbackCanbusBase {
    public static final int CMD_CAREQ_CTRL = 0;
    public static final int U_CAREQ_BAL = 102;
    public static final int U_CAREQ_BASS = 100;
    public static final int U_CAREQ_BEGIN = 98;
    public static final int U_CAREQ_FAD = 103;
    public static final int U_CAREQ_MID = 104;
    public static final int U_CAREQ_TREBLE = 101;
    public static final int U_CAREQ_VOL = 99;
    public static final int U_CNT_MAX = 105;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 105; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0439_HC_QiyaKaizunK7(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 105) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
