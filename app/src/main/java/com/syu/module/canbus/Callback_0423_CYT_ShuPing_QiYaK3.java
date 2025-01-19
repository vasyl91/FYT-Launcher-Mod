package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0423_CYT_F3;
import com.syu.ui.door.DoorHelper;

public class Callback_0423_CYT_ShuPing_QiYaK3 extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 98;
    public static final int U_AIR_DATA0 = 98;
    public static final int U_AIR_DATA1 = 99;
    public static final int U_AIR_DATA2 = 100;
    public static final int U_AIR_DATA3 = 101;
    public static final int U_AIR_DATA4 = 102;
    public static final int U_AIR_DATA5 = 103;
    public static final int U_CNT_MAX = 104;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 104; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        if (DataCanbus.sCanbusId == 131495) {
            //AirHelper.getInstance().buildUi(new Air_0423_CYT_F3(LauncherApplication.getInstance()));
            for (int i2 = 10; i2 < 97; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
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
