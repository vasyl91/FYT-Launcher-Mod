package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_HC_Ford_Explorer;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_HC_Ford_Explorer extends CallbackCanbusBase {
    public static final int U_CARSET_BEGIN = 98;
    public static final int U_CARSET_D40_D0_B54 = 132;
    public static final int U_CARSET_D40_D0_B76 = 131;
    public static final int U_CARSET_D40_D1_B70 = 133;
    public static final int U_CARSET_D40_D2_B70 = 134;
    public static final int U_CARSET_D40_D3_B70 = 135;
    public static final int U_CARSET_D40_D4_B70 = 136;
    public static final int U_CARSET_D40_D5_B70 = 137;
    public static final int U_CARSET_D40_D6_B70 = 138;
    public static final int U_CARSET_D40_D7_B10 = 142;
    public static final int U_CARSET_D40_D7_B32 = 141;
    public static final int U_CARSET_D40_D7_B76 = 140;
    public static final int U_CARSET_D40_D8_B10 = 145;
    public static final int U_CARSET_D40_D8_B32 = 144;
    public static final int U_CARSET_D40_D8_B76 = 143;
    public static final int U_CARSET_D40_D9_B20 = 146;
    public static final int U_CARSET_END = 103;
    public static final int U_CARSET_LANGUAGE = 101;
    public static final int U_CARSET_LIGHT_COLOR = 102;
    public static final int U_CARSET_MILE_UNIT = 100;
    public static final int U_CARSET_TEMP_UNIT = 99;
    public static final int U_CAR_CD_PLAYTIME = 117;
    public static final int U_CAR_CD_RANDOM = 116;
    public static final int U_CAR_CD_REPEAT = 115;
    public static final int U_CAR_CD_TOTALTIME = 118;
    public static final int U_CAR_CD_TOTALTRACK = 120;
    public static final int U_CAR_CD_TRACK = 119;
    public static final int U_CAR_CD_WORKE_STATE = 114;
    public static final int U_CAR_EQ_BAL = 124;
    public static final int U_CAR_EQ_BASS = 126;
    public static final int U_CAR_EQ_FAD = 125;
    public static final int U_CAR_EQ_MID = 127;
    public static final int U_CAR_EQ_SPEED = 130;
    public static final int U_CAR_EQ_ST = 129;
    public static final int U_CAR_EQ_TREB = 128;
    public static final int U_CAR_EQ_VOL = 123;
    public static final int U_CAR_JUMP_CD = 121;
    public static final int U_CAR_JUMP_RADIO = 122;
    public static final int U_CAR_RADIO_BAND = 105;
    public static final int U_CAR_RADIO_CHANNEL = 107;
    public static final int U_CAR_RADIO_FREQ = 106;
    public static final int U_CAR_RADIO_FREQ1 = 108;
    public static final int U_CAR_RADIO_FREQ2 = 109;
    public static final int U_CAR_RADIO_FREQ3 = 110;
    public static final int U_CAR_RADIO_FREQ4 = 111;
    public static final int U_CAR_RADIO_FREQ5 = 112;
    public static final int U_CAR_RADIO_FREQ6 = 113;
    public static final int U_CAR_RADIO_SACN = 104;
    public static final int U_CNT_MAX = 147;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 147; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_HC_Ford_Explorer(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 147) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
