package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_LZ_Ford_SCREEN extends CallbackCanbusBase {
    public static final int U_CARINF_D29_T2_D1_B0 = 101;
    public static final int U_CARINF_D29_T2_D1_B1 = 100;
    public static final int U_CARINF_D29_T2_D2_D3 = 102;
    public static final int U_CARINF_D29_T2_D4_D5 = 103;
    public static final int U_CARINF_D29_T2_D6_D7 = 104;
    public static final int U_CARINF_D29_T2_D8_D10 = 105;
    public static final int U_CARINF_D29_T3_D1_B70 = 106;
    public static final int U_CARINF_D29_T3_D2_B70 = 107;
    public static final int U_CARINF_D29_T3_D3_B70 = 108;
    public static final int U_CARINF_D29_T3_D4_B70 = 109;
    public static final int U_CARINF_D29_T3_D5_B70 = 110;
    public static final int U_CARINF_D29_T3_D6_B70 = 111;
    public static final int U_CARINF_D29_T3_D7_B70 = 112;
    public static final int U_CARINF_D29_T3_D8_B70 = 113;
    public static final int U_CARINF_D29_T3_D9_B70 = 114;
    public static final int U_CAR_ANDROID_UI_VOL = 116;
    public static final int U_CAR_CUR_SPEED = 98;
    public static final int U_CAR_EN_SPEED = 99;
    public static final int U_CAR_LVDS_MODE = 118;
    public static final int U_CAR_SCREEN_H = 120;
    public static final int U_CAR_SCREEN_W = 119;
    public static final int U_CAR_UI_VOL = 115;
    public static final int U_CAR_VOICE_ANDROID = 117;
    public static final int U_CNT_MAX = 121;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 121; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0454_LZ_Ford_Screen(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 97; i++) {
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
        if (updateCode >= 0 && updateCode < 121) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
