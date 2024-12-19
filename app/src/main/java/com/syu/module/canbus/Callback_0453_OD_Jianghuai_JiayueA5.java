package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_OD_Jianghuai_JiayueA5 extends CallbackCanbusBase {
    public static final int U_CAR_D40_D00_B70 = 98;
    public static final int U_CAR_D40_D010_B70 = 108;
    public static final int U_CAR_D40_D011_B70 = 109;
    public static final int U_CAR_D40_D01_B70 = 99;
    public static final int U_CAR_D40_D02_B70 = 100;
    public static final int U_CAR_D40_D03_B70 = 101;
    public static final int U_CAR_D40_D04_B70 = 102;
    public static final int U_CAR_D40_D05_B70 = 103;
    public static final int U_CAR_D40_D06_B70 = 104;
    public static final int U_CAR_D40_D07_B70 = 105;
    public static final int U_CAR_D40_D08_B70 = 106;
    public static final int U_CAR_D40_D09_B70 = 107;
    public static final int U_CAR_D42_D0_B70 = 110;
    public static final int U_CAR_D42_D1_B70 = 111;
    public static final int U_CAR_D42_D2_B70 = 112;
    public static final int U_CAR_D42_D3_B70 = 113;
    public static final int U_CAR_D42_D4_B70 = 114;
    public static final int U_CAR_D42_D5_B70 = 115;
    public static final int U_CNT_MAX = 116;
    public static final int U_PRESSURE_FL = 86;
    public static final int U_PRESSURE_FR = 87;
    public static final int U_PRESSURE_RL = 88;
    public static final int U_PRESSURE_RR = 89;
    public static final int U_TEMP_FL = 90;
    public static final int U_TEMP_FR = 91;
    public static final int U_TEMP_RL = 92;
    public static final int U_TEMP_RR = 93;
    public static final int U_WARNING_FL = 94;
    public static final int U_WARNING_FR = 95;
    public static final int U_WARNING_RL = 96;
    public static final int U_WARNING_RR = 97;

    @Override // com.syu.module.canbus.CallbackCanbusBase
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
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
