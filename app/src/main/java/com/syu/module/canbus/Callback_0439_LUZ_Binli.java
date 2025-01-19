package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.luz.binli.BinliCarSet;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_LZ_Binli;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_LUZ_Binli extends CallbackCanbusBase {
    public static final int U_CAREQ_D0_B70 = 153;
    public static final int U_CAREQ_D1_B70 = 154;
    public static final int U_CAREQ_D2_B70 = 155;
    public static final int U_CAREQ_D3_B70 = 156;
    public static final int U_CAREQ_D4_B70 = 157;
    public static final int U_CAREQ_D5_B70 = 158;
    public static final int U_CAREQ_D6_B30 = 160;
    public static final int U_CAREQ_D6_B74 = 159;
    public static final int U_CAREQ_D7_B6 = 162;
    public static final int U_CAREQ_D7_B7 = 161;
    public static final int U_CARINFO_INTERIOR_ALARM = 150;
    public static final int U_CARINFO_LIGHT_DELAY = 149;
    public static final int U_CARINFO_MOVE_ALARM = 151;
    public static final int U_CARINFO_SEAT_SET = 152;
    public static final int U_CARSET_BEGIN = 98;
    public static final int U_CARSET_CAR_LEV = 115;
    public static final int U_CARSET_CUR_SPEED = 117;
    public static final int U_CARSET_DRIVENABLE_MILE = 118;
    public static final int U_CARSET_END = 134;
    public static final int U_CARSET_ENGINE_SPEED = 119;
    public static final int U_CARSET_HANG_LEV = 114;
    public static final int U_CARSET_HANG_ON = 113;
    public static final int U_CARSET_LIGHT_STATE = 116;
    public static final int U_CARSET_MILE_UNIT = 123;
    public static final int U_CARSET_PARK_MODE = 100;
    public static final int U_CARSET_RADAR_BEEP = 99;
    public static final int U_CARSET_TEMP_UNIT = 122;
    public static final int U_CARSET_TIRE_CALI = 111;
    public static final int U_CARSET_TIRE_ERROR = 112;
    public static final int U_CARSET_TIRE_FL = 106;
    public static final int U_CARSET_TIRE_FR = 107;
    public static final int U_CARSET_TIRE_MONITOR_TYPE = 110;
    public static final int U_CARSET_TIRE_ONOFF = 105;
    public static final int U_CARSET_TIRE_RL = 108;
    public static final int U_CARSET_TIRE_RR = 109;
    public static final int U_CARSET_TIRE_SPEED = 103;
    public static final int U_CARSET_TIRE_TYPE = 104;
    public static final int U_CARSET_TIRE_UNIT = 102;
    public static final int U_CARSET_TOTAL_MILE = 120;
    public static final int U_CARSET_TRIPA_AVG_SPEED = 126;
    public static final int U_CARSET_TRIPA_MILE = 124;
    public static final int U_CARSET_TRIPA_OIL = 125;
    public static final int U_CARSET_TRIPA_UNIT = 127;
    public static final int U_CARSET_TRIPB_AVG_OIL = 130;
    public static final int U_CARSET_TRIPB_AVG_SPEED = 131;
    public static final int U_CARSET_TRIPB_MILE = 128;
    public static final int U_CARSET_TRIPB_OIL = 129;
    public static final int U_CARSET_TRIPB_TIME = 133;
    public static final int U_CARSET_TRIPB_UNIT = 132;
    public static final int U_CARSET_VOLTAGE = 121;
    public static final int U_CARSET_WIPER_STATE = 101;
    public static final int U_CAR_CD1_STATE = 135;
    public static final int U_CAR_CD2_STATE = 136;
    public static final int U_CAR_CD3_STATE = 137;
    public static final int U_CAR_CD4_STATE = 138;
    public static final int U_CAR_CD5_STATE = 139;
    public static final int U_CAR_CD6_STATE = 140;
    public static final int U_CAR_CD_MIN = 147;
    public static final int U_CAR_CD_NUM = 145;
    public static final int U_CAR_CD_PLAYSTATE = 141;
    public static final int U_CAR_CD_PREVIEW = 144;
    public static final int U_CAR_CD_RANDOM = 143;
    public static final int U_CAR_CD_REPEAT = 142;
    public static final int U_CAR_CD_SEC = 148;
    public static final int U_CAR_CD_TRACK = 146;
    public static final int U_CNT_MAX = 163;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 163; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_LZ_Binli(LauncherApplication.getInstance()));
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

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 113) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            switch (value) {
                case 0:
                    if (BinliCarSet.mIsFront && BinliCarSet.mInstance != null) {
                        BinliCarSet.mInstance.finish();
                        break;
                    }
                case 1:
                    if (!BinliCarSet.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.luz.binli.BinliCarSet");
                        break;
                    }
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 163) {
            switch (updateCode) {
                case 113:
                    ShowCarState(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 163) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
