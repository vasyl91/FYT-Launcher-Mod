package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_RZC_Subaru extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D25_D0_B0 = 118;
    public static final int U_CARINF_D25_D0_B1 = 117;
    public static final int U_CARINF_D25_D0_B2 = 116;
    public static final int U_CARINF_D25_D0_B3 = 115;
    public static final int U_CARINF_D31_D0_B0 = 108;
    public static final int U_CARINF_D31_D0_B1 = 107;
    public static final int U_CARINF_D31_D1_B70 = 109;
    public static final int U_CARINF_D31_D2_B70 = 110;
    public static final int U_CARINF_D31_D3_B70 = 111;
    public static final int U_CARINF_D31_D4_B70 = 112;
    public static final int U_CARINF_D31_D5_B70 = 113;
    public static final int U_CARINF_D31_D6_B70 = 114;
    public static final int U_CARINF_D40_D0_B20 = 103;
    public static final int U_CARINF_D40_D0_B3 = 102;
    public static final int U_CARINF_D40_D0_B4 = 101;
    public static final int U_CARINF_D40_D0_B5 = 100;
    public static final int U_CARINF_D40_D0_B76 = 99;
    public static final int U_CARINF_D40_D1_B0 = 106;
    public static final int U_CARINF_D40_D1_B54 = 105;
    public static final int U_CARINF_D40_D1_B76 = 104;
    public static final int U_CNT_MAX = 119;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 119; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 <= 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0454_RZ_Suburu_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 119) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
