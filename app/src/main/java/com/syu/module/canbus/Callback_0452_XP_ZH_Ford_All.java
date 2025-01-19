package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_XP_ZH_Ford_All;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_XP_ZH_Ford_All extends CallbackCanbusBase {
    public static final int U_AUTO_REQUEST = 107;
    public static final int U_BT_STATE = 114;
    public static final int U_CARSET_D25_D0_B2 = 99;
    public static final int U_CARSET_D25_D0_B3 = 100;
    public static final int U_CARSET_D27_D0_B70 = 136;
    public static final int U_CARSET_D48_D0_B30 = 117;
    public static final int U_CARSET_D48_D1_B30 = 120;
    public static final int U_CARSET_D48_D1_B54 = 119;
    public static final int U_CARSET_D48_D1_B76 = 118;
    public static final int U_CARSET_D48_D2_B30 = 122;
    public static final int U_CARSET_D48_D2_B74 = 121;
    public static final int U_CARSET_D48_D3_B30 = 125;
    public static final int U_CARSET_D48_D3_B54 = 124;
    public static final int U_CARSET_D48_D3_B76 = 123;
    public static final int U_CARSET_D48_D4_B30 = 127;
    public static final int U_CARSET_D48_D4_B74 = 126;
    public static final int U_CARSET_D48_D5_B30 = 129;
    public static final int U_CARSET_D48_D5_B74 = 128;
    public static final int U_CARSET_D48_D6_B30 = 130;
    public static final int U_CARSET_D48_D7_B30 = 132;
    public static final int U_CARSET_D48_D7_B74 = 131;
    public static final int U_CARSET_D48_D8_B0 = 134;
    public static final int U_CARSET_D48_D8_B76 = 133;
    public static final int U_CARSET_D48_D9_B70 = 135;
    public static final int U_CARSET_MILE_UNIT = 98;
    public static final int U_CARSET_SEAT_SET_TYPE = 137;
    public static final int U_CAR_ENGINE_SPEED = 116;
    public static final int U_CAR_SPEED = 115;
    public static final int U_CAR_WARN = 108;
    public static final int U_CNT_MAX = 138;
    public static final int U_CUR_WORK_MODE = 104;
    public static final int U_DISPLAY_MODE = 113;
    public static final int U_LINE_GROUP = 111;
    public static final int U_LIST_INFO = 102;
    public static final int U_MODE_STATE = 105;
    public static final int U_PARM_WARM = 101;
    public static final int U_PHONE_STATE = 106;
    public static final int U_PHONE_TIME = 103;
    public static final int U_PLAY_TIME = 112;
    public static final int U_SCREEN_ICON = 110;
    public static final int U_SCREEN_ID = 109;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 138; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[37].removeNotify(AirHelper.SHOW_AND_REFRESH);
        //AirHelper.getInstance().buildUi(new Air_0452_XP_ZH_Ford_All(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 138) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
