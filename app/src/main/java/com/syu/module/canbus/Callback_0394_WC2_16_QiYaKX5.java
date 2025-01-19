package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0351_WC2_16_QiyaK5;
//import com.syu.ui.air.Air_0394_WC2_18_Zhipao;
import com.syu.ui.door.DoorHelper;

public class Callback_0394_WC2_16_QiYaKX5 extends CallbackCanbusBase {
    public static final int U_AIR_DATA0 = 106;
    public static final int U_AIR_DATA1 = 107;
    public static final int U_AIR_DATA2 = 108;
    public static final int U_AIR_DATA3 = 109;
    public static final int U_AIR_DATA4 = 110;
    public static final int U_AIR_DATA5 = 111;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_END = 105;
    public static final int U_CARINFO_FRONT_VIEW_INIT = 101;
    public static final int U_CARINFO_RADAR_DISPLAY = 100;
    public static final int U_CARINFO_REAR_VIEW_INIT = 102;
    public static final int U_CARINFO_TRACK_DISPLAY = 99;
    public static final int U_CARSEAT_BACK_STATE = 104;
    public static final int U_CARSEAT_STATE = 103;
    public static final int U_CNT_MAX = 107;
    public static final int U_CYTK3_AIR_BEGIN = 106;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 107; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 786826) {
            //AirHelper.getInstance().buildUi(new Air_0394_WC2_18_Zhipao(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0351_WC2_16_QiyaK5(LauncherApplication.getInstance()));
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
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 107) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
