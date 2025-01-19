package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0324_BNR_TianLai;
//import com.syu.ui.air.Air_0327_HC_TianLai;
import com.syu.ui.door.DoorHelper;

public class Callback_0324_BNR_XP1_NISSAN_LouLan extends CallbackCanbusBase {
    public static final int C_AIRSET = 2;
    public static final int C_CARSET = 1;
    public static final int U_CARSET_D74_D1_B76 = 109;
    public static final int U_CNT_MAX = 110;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_SETTING_93D0 = 100;
    public static final int U_SETTING_93D1 = 101;
    public static final int U_SETTING_93D2 = 102;
    public static final int U_SETTING_93D3 = 103;
    public static final int U_SETTING_93D4 = 104;
    public static final int U_SETTING_93D5 = 105;
    public static final int U_SETTING_93D6 = 106;
    public static final int U_SETTING_93D7 = 107;
    public static final int U_SETTING_93D8 = 108;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 110; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 721220 || DataCanbus.DATA[1000] == 786756 || DataCanbus.DATA[1000] == 852292 || DataCanbus.DATA[1000] == 983364 || DataCanbus.DATA[1000] == 1048900 || DataCanbus.DATA[1000] == 917828) {
            //AirHelper.getInstance().buildUi(new Air_0324_BNR_TianLai(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0327_HC_TianLai(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 110) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
