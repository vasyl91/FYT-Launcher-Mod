package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

import java.lang.reflect.Array;

public class Callback_0255_RZC_XP1_FengShenAX7 extends CallbackCanbusBase {
    public static int[][] LIST_EX1_EN = (int[][]) Array.newInstance(Integer.TYPE, 31, 10);
    public static final int U_CARSET_BEGIN = 106;
    public static final int U_CARSET_BLIND_PORT = 104;
    public static final int U_CARSET_D29_D0_B0 = 113;
    public static final int U_CARSET_D29_D0_B1 = 112;
    public static final int U_CARSET_D29_D0_B2 = 111;
    public static final int U_CARSET_D29_D0_B3 = 110;
    public static final int U_CARSET_D29_D0_B4 = 109;
    public static final int U_CARSET_D29_D0_B5 = 108;
    public static final int U_CARSET_D29_D0_B76 = 107;
    public static final int U_CARSET_D29_D1_B3 = 118;
    public static final int U_CARSET_D29_D1_B4 = 117;
    public static final int U_CARSET_D29_D1_B5 = 116;
    public static final int U_CARSET_D29_D1_B6 = 115;
    public static final int U_CARSET_D29_D1_B7 = 114;
    public static final int U_CARSET_D29_D2_B1 = 125;
    public static final int U_CARSET_D29_D2_B2 = 124;
    public static final int U_CARSET_D29_D2_B3 = 123;
    public static final int U_CARSET_D29_D2_B4 = 122;
    public static final int U_CARSET_D29_D2_B5 = 121;
    public static final int U_CARSET_D29_D2_B6 = 120;
    public static final int U_CARSET_D29_D2_B7 = 119;
    public static final int U_CARSET_D29_D3_B30 = 127;
    public static final int U_CARSET_D29_D3_B74 = 126;
    public static final int U_CARSET_D29_D4_B30 = 130;
    public static final int U_CARSET_D29_D4_B4 = 129;
    public static final int U_CARSET_D29_D4_B75 = 128;
    public static final int U_CARSET_D29_D5_B74 = 131;
    public static final int U_CARSET_D29_D6_B1 = 146;
    public static final int U_CARSET_D29_D6_B42 = 135;
    public static final int U_CARSET_D29_D6_B5 = 134;
    public static final int U_CARSET_D29_D6_B6 = 133;
    public static final int U_CARSET_D29_D6_B7 = 132;
    public static final int U_CARSET_D29_D7_B3 = 139;
    public static final int U_CARSET_D29_D7_B4 = 138;
    public static final int U_CARSET_D29_D7_B5 = 137;
    public static final int U_CARSET_D29_D7_B76 = 136;
    public static final int U_CARSET_D29_D8_B10 = 142;
    public static final int U_CARSET_D29_D8_B42 = 141;
    public static final int U_CARSET_D29_D8_B75 = 140;
    public static final int U_CARSET_D29_D9_B5 = 145;
    public static final int U_CARSET_D29_D9_B6 = 144;
    public static final int U_CARSET_D29_D9_B7 = 143;
    public static final int U_CARSET_D40_D0_B70 = 147;
    public static final int U_CARSET_D40_D1_B70 = 148;
    public static final int U_CARSET_D40_D2_D3 = 149;
    public static final int U_CARSET_D40_D4_D5 = 150;
    public static final int U_CARSET_D40_D6_B70 = 151;
    public static final int U_CARSET_D40_D7_B70 = 152;
    public static final int U_CARSET_D40_D8_D9 = 153;
    public static final int U_CARSET_D41_N0_ALL = 154;
    public static final int U_CARSET_MODE = 105;
    public static final int U_CARSET_TRUNAUTO_RCAM = 103;
    public static final int U_CNT_MAX = 155;
    public static final int U_CUR_SPEED = 98;
    public static final int U_CUR_SPEED_NOTIFFTIME = 100;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_ENGINE_SPEED_NOTIFFTIME = 101;
    public static final int U_TURN_CAM_STATUS = 102;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 155; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0255_rzc_xp1_fengshenax7(LauncherApplication.getInstance()));
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
        if (updateCode == 154) {
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            System.arraycopy(ints, 1, LIST_EX1_EN[ints[0]], 0, 10);
            return;
        }
        if (updateCode >= 0 && updateCode < 155) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
