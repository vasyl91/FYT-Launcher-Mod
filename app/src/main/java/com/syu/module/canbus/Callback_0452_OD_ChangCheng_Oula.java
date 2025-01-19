package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_OUDI_Changchang_Oula;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_OD_ChangCheng_Oula extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARSET_D31_D0_B30 = 100;
    public static final int U_CARSET_D31_D0_B74 = 99;
    public static final int U_CARSET_D31_D1_B74 = 101;
    public static final int U_CARSET_D42_D0_B70 = 102;
    public static final int U_CARSET_D42_D1_B70 = 103;
    public static final int U_CARSET_D42_D2_D3 = 104;
    public static final int U_CARSET_D42_D4_B70 = 105;
    public static final int U_CARSET_D42_D5_B70 = 106;
    public static final int U_CARSET_D42_D6_B70 = 107;
    public static final int U_CARSET_D42_D7_B70 = 108;
    public static final int U_CARSET_D42_D8_B70 = 109;
    public static final int U_CNT_MAX = 110;

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
        //AirHelper.getInstance().buildUi(new Air_0452_OUDI_Changchang_Oula(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
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
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
