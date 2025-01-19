package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.daojun.b70.DaojunB70LowCarSettingInfoAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_DJ_14B70_H;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_DJ_14B70 extends CallbackCanbusBase {
    public static final int CAR_TYPE_CD = -2;
    public static final int CAR_TYPE_OTHER = -5;
    public static final int CAR_TYPE_RADIO = -1;
    public static final int CAR_TYPE_SET = -4;
    public static final int CAR_TYPE_VOL = -3;
    public static final int U_CAR_CAR_OTHER_TYPE = 122;
    public static final int U_CAR_CAR_SETINFO1 = 116;
    public static final int U_CAR_CAR_SETINFO2 = 117;
    public static final int U_CAR_CAR_SETINFO3 = 118;
    public static final int U_CAR_CAR_SETINFO4 = 119;
    public static final int U_CAR_CAR_SETINFO5 = 120;
    public static final int U_CAR_CAR_SETINF_VALUE = 121;
    public static final int U_CAR_CAR_VOL = 114;
    public static final int U_CAR_CAR_VOL_MUTE = 115;
    public static final int U_CAR_CD_CYCLE_MODE = 110;
    public static final int U_CAR_CD_PLAY_STATE = 111;
    public static final int U_CAR_CD_PLAY_TIME_MIN = 112;
    public static final int U_CAR_CD_PLAY_TIME_SEC = 113;
    public static final int U_CAR_CD_TOTAL_TRACK = 109;
    public static final int U_CAR_CD_TRACK = 108;
    public static final int U_CAR_RADIO_BADN = 99;
    public static final int U_CAR_RADIO_FREQ = 101;
    public static final int U_CAR_RADIO_FREQ1 = 102;
    public static final int U_CAR_RADIO_FREQ2 = 103;
    public static final int U_CAR_RADIO_FREQ3 = 104;
    public static final int U_CAR_RADIO_FREQ4 = 105;
    public static final int U_CAR_RADIO_FREQ5 = 106;
    public static final int U_CAR_RADIO_FREQ6 = 107;
    public static final int U_CAR_RADIO_NUM = 100;
    public static final int U_CAR_TYPE = 98;
    public static final int U_CNT_MAX = 124;
    public static final int U_JUMP_CARINFO = 123;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 124; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0439_DJ_14B70_H(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
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
        switch (updateCode) {
            case 123:
                convDrivingMode(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 124) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }

    private void convDrivingMode(int updateCode, int[] ints) {
        if (updateCode == 123) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !DaojunB70LowCarSettingInfoAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.b70.DaojunB70LowCarSettingInfoAct");
            }
        }
    }
}
