package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0151_DAOJUN_XP1_BYDG6 extends CallbackCanbusBase {
    public static final int U_AIR_DATA1 = 100;
    public static final int U_AIR_DATA2 = 101;
    public static final int U_AIR_DATA3 = 102;
    public static final int U_AIR_DATA4 = 103;
    public static final int U_AIR_DATA5 = 104;
    public static final int U_AIR_DATA6 = 105;
    public static final int U_AIR_DATA7 = 106;
    public static final int U_AMP_SWITCH = 108;
    public static final int U_CNT_MAX = 109;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_RADAR_SWITCH = 107;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 109; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0151_DAOJUN_XP1_BYDG6(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 109) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
