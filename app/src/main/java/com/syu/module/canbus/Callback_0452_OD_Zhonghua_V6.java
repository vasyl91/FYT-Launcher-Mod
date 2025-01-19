package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_OD_ZhongHuaV6;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_Zhonghua_V6 extends CallbackCanbusBase {
    public static final int U_CARINFO_D4_D0_B70 = 98;
    public static final int U_CARINFO_D4_D1_B0 = 99;
    public static final int U_CARINFO_D4_D1_B1 = 100;
    public static final int U_CARINFO_D4_D1_B2 = 101;
    public static final int U_CARINFO_D4_D1_B5 = 108;
    public static final int U_CARINFO_D4_D1_B6 = 107;
    public static final int U_CARINFO_D4_D2_B0 = 111;
    public static final int U_CARINFO_D4_D2_B1 = 110;
    public static final int U_CARINFO_D4_D2_B32 = 109;
    public static final int U_CARINFO_D4_D3_B30 = 102;
    public static final int U_CARINFO_D4_D3_B54 = 113;
    public static final int U_CARINFO_D4_D3_B7 = 112;
    public static final int U_CARINFO_D4_D4_B70 = 103;
    public static final int U_CARINFO_D4_D5_B20 = 115;
    public static final int U_CARINFO_D4_D5_B3 = 114;
    public static final int U_CARINFO_D4_D5_B54 = 106;
    public static final int U_CARINFO_D4_D5_B6 = 105;
    public static final int U_CARINFO_D4_D5_B7 = 104;
    public static final int U_CARINFO_HUD_BRIGHT = 116;
    public static final int U_CNT_MAX = 117;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 117; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_OD_ZhongHuaV6(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 117) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
