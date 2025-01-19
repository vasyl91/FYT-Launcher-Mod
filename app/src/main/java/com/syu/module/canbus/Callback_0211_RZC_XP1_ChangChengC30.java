package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0211_OuDi_ChangChengH3;
//import com.syu.ui.air.Air_0211_RZC_ChangChengC30;

public class Callback_0211_RZC_XP1_ChangChengC30 extends CallbackCanbusBase {
    public static final int U_CNT_MAX = 98;

    @Override
    public void in() {
        int mcarId = (DataCanbus.DATA[1000] >> 16) & 65535;
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 98; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        if (mcarId == 0) {
            //AirHelper.getInstance().buildUi(new Air_0211_RZC_ChangChengC30(LauncherApplication.getInstance()));
        } else if (mcarId == 1) {
            //AirHelper.getInstance().buildUi(new Air_0211_OuDi_ChangChengH3(LauncherApplication.getInstance()));
        }
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
        if (updateCode >= 0 && updateCode < 98) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
