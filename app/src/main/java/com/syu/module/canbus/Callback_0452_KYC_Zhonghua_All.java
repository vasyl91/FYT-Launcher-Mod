package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_KYC_Zhonghua_All;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_KYC_Zhonghua_All extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D53_D0_B70 = 99;
    public static final int U_CARINF_D53_D10_B20 = 112;
    public static final int U_CARINF_D53_D10_B3 = 113;
    public static final int U_CARINF_D53_D10_B4 = 114;
    public static final int U_CARINF_D53_D10_B65 = 115;
    public static final int U_CARINF_D53_D1_B70 = 100;
    public static final int U_CARINF_D53_D2_B70 = 101;
    public static final int U_CARINF_D53_D3_B70 = 102;
    public static final int U_CARINF_D53_D4_B70 = 103;
    public static final int U_CARINF_D53_D5_B70 = 104;
    public static final int U_CARINF_D53_D6_B70 = 105;
    public static final int U_CARINF_D53_D7_B70 = 106;
    public static final int U_CARINF_D53_D8_B70 = 107;
    public static final int U_CARINF_D53_D9_B30 = 108;
    public static final int U_CARINF_D53_D9_B4 = 109;
    public static final int U_CARINF_D53_D9_B5 = 110;
    public static final int U_CARINF_D53_D9_B76 = 111;
    public static final int U_CNT_MAX = 116;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_KYC_Zhonghua_All(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
