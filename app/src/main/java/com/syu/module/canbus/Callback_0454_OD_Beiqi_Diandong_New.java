package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0454_Oudi_Beiqi_diandong_new;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_OD_Beiqi_Diandong_New extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 97;
    public static final int U_CARINFO_CAR_BATTERY = 103;
    public static final int U_CARINFO_CAR_STATE1 = 101;
    public static final int U_CARINFO_CAR_STATE2 = 102;
    public static final int U_CARINFO_CREEP = 99;
    public static final int U_CARINFO_D39_D0_D2 = 105;
    public static final int U_CARINFO_D39_D10_B70 = 113;
    public static final int U_CARINFO_D39_D3_B70 = 106;
    public static final int U_CARINFO_D39_D4_D5 = 107;
    public static final int U_CARINFO_D39_D6_D7 = 108;
    public static final int U_CARINFO_D39_D8_B30 = 110;
    public static final int U_CARINFO_D39_D8_B74 = 109;
    public static final int U_CARINFO_D39_D9_B60 = 112;
    public static final int U_CARINFO_D39_D9_B7 = 111;
    public static final int U_CARINFO_D42_D0_D1 = 114;
    public static final int U_CARINFO_D43_D0_D1 = 115;
    public static final int U_CARINFO_DRIVEN_MILES = 100;
    public static final int U_CARINFO_ENERGEY_CONSUME = 104;
    public static final int U_CARINFO_SIDE_PEDAL = 98;
    public static final int U_CNT_MAX = 131;
    public static final int U_D37_D1_D1_B70 = 116;
    public static final int U_D37_D1_D2_B70 = 117;
    public static final int U_D37_D1_D3_B70 = 118;
    public static final int U_D37_D2_D1_B70 = 119;
    public static final int U_D37_D2_D2_B70 = 120;
    public static final int U_D37_D2_D3_B70 = 121;
    public static final int U_D37_D2_D4_B70 = 122;
    public static final int U_D37_D3_D1_B70 = 123;
    public static final int U_D37_D3_D2_B70 = 124;
    public static final int U_D37_D4_D1_B70 = 125;
    public static final int U_D37_D4_D2_B70 = 126;
    public static final int U_D37_D4_D3_B70 = 127;
    public static final int U_D37_D4_D4_B70 = 128;
    public static final int U_D37_D5_D1_B70 = 129;
    public static final int U_D37_D5_D2_B70 = 130;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 131; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0454_Oudi_Beiqi_diandong_new(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 131) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
