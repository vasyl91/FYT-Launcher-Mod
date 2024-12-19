package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_BMW_X1 extends CallbackCanbusBase {
    public static final int U_CARCDC_BEGIN = 19;
    public static final int U_CARCDC_CUR_TRACK = 22;
    public static final int U_CARCDC_DISC1 = 28;
    public static final int U_CARCDC_DISC2 = 29;
    public static final int U_CARCDC_DISC3 = 30;
    public static final int U_CARCDC_DISC4 = 31;
    public static final int U_CARCDC_DISC5 = 32;
    public static final int U_CARCDC_DISC6 = 33;
    public static final int U_CARCDC_NUM = 20;
    public static final int U_CARCDC_PLAY_STATE = 24;
    public static final int U_CARCDC_PLAY_TIME = 23;
    public static final int U_CARCDC_RANDOM_STATE = 26;
    public static final int U_CARCDC_REPEAT_STATE = 25;
    public static final int U_CARCDC_SCAN_STATE = 27;
    public static final int U_CARCDC_TOTAL_TRACK = 21;
    public static final int U_CARINFO_BEGIN = 7;
    public static final int U_CARINFO_D03_D2_D3 = 8;
    public static final int U_CARINFO_D03_D4_D5 = 9;
    public static final int U_CARINFO_D03_D6_D7 = 10;
    public static final int U_CARINFO_D04_D0_B70 = 11;
    public static final int U_CARINFO_D04_D1_B70 = 12;
    public static final int U_CARINFO_D04_D2_B70 = 13;
    public static final int U_CARINFO_D04_D3_B70 = 14;
    public static final int U_CARINFO_D04_D4_B70 = 15;
    public static final int U_CARINFO_D07_D0_B30 = 17;
    public static final int U_CARINFO_D07_D0_B74 = 16;
    public static final int U_CARINFO_D07_D1_B0 = 18;
    public static final int U_CNT_MAX = 34;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 34; i++) {
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
        if (updateCode >= 0 && updateCode < 34) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
