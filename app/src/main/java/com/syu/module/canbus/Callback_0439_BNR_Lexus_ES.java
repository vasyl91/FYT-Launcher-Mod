package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_BNR_Toyota;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_BNR_Lexus_ES extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int U_CAR_AUDIO_ASL = 158;
    public static final int U_CAR_AUDIO_BAL = 154;
    public static final int U_CAR_AUDIO_BASS = 155;
    public static final int U_CAR_AUDIO_FAD = 153;
    public static final int U_CAR_AUDIO_MID = 157;
    public static final int U_CAR_AUDIO_SPEED = 160;
    public static final int U_CAR_AUDIO_STATE = 152;
    public static final int U_CAR_AUDIO_TREB = 156;
    public static final int U_CAR_AUDIO_VOL = 159;
    public static final int U_CAR_CD1_STATE = 100;
    public static final int U_CAR_CD1_TYPE = 108;
    public static final int U_CAR_CD2_STATE = 101;
    public static final int U_CAR_CD2_TYPE = 109;
    public static final int U_CAR_CD3_STATE = 102;
    public static final int U_CAR_CD3_TYPE = 110;
    public static final int U_CAR_CD4_STATE = 103;
    public static final int U_CAR_CD4_TYPE = 111;
    public static final int U_CAR_CD5_STATE = 104;
    public static final int U_CAR_CD5_TYPE = 112;
    public static final int U_CAR_CD6_STATE = 105;
    public static final int U_CAR_CD6_TYPE = 113;
    public static final int U_CAR_CD_BEGIN = 99;
    public static final int U_CAR_CD_END = 124;
    public static final int U_CAR_CD_HOUR_CUR = 121;
    public static final int U_CAR_CD_HOUR_TOTAL = 118;
    public static final int U_CAR_CD_MIN_CUR = 122;
    public static final int U_CAR_CD_MIN_TOTAL = 119;
    public static final int U_CAR_CD_NUM = 107;
    public static final int U_CAR_CD_RANDOM = 115;
    public static final int U_CAR_CD_REPEAT = 114;
    public static final int U_CAR_CD_SEC_CUR = 123;
    public static final int U_CAR_CD_SEC_TOTAL = 120;
    public static final int U_CAR_CD_TOTALTRACK = 116;
    public static final int U_CAR_CD_TRACK = 117;
    public static final int U_CAR_CD_WORKSTATE = 106;
    public static final int U_CAR_RADIO_BAND = 126;
    public static final int U_CAR_RADIO_BEGIN = 125;
    public static final int U_CAR_RADIO_END = 137;
    public static final int U_CAR_RADIO_FREQ = 130;
    public static final int U_CAR_RADIO_FREQ1 = 131;
    public static final int U_CAR_RADIO_FREQ2 = 132;
    public static final int U_CAR_RADIO_FREQ3 = 133;
    public static final int U_CAR_RADIO_FREQ4 = 134;
    public static final int U_CAR_RADIO_FREQ5 = 135;
    public static final int U_CAR_RADIO_FREQ6 = 136;
    public static final int U_CAR_RADIO_NUM = 129;
    public static final int U_CAR_RADIO_SCAN_STATE = 128;
    public static final int U_CAR_RADIO_ST_STATE = 127;
    public static final int U_CAR_REARCD_BEGIN = 138;
    public static final int U_CAR_REARCD_HOUR_CUR = 149;
    public static final int U_CAR_REARCD_HOUR_TOTAL = 146;
    public static final int U_CAR_REARCD_MIN_CUR = 150;
    public static final int U_CAR_REARCD_MIN_TOTAL = 147;
    public static final int U_CAR_REARCD_RANDOM = 143;
    public static final int U_CAR_REARCD_REPEAT = 142;
    public static final int U_CAR_REARCD_SEC_CUR = 151;
    public static final int U_CAR_REARCD_SEC_TOTAL = 148;
    public static final int U_CAR_REARCD_STATE = 139;
    public static final int U_CAR_REARCD_TOTALTRACK = 144;
    public static final int U_CAR_REARCD_TRACK = 145;
    public static final int U_CAR_REARCD_TYPE = 140;
    public static final int U_CAR_REARCD_WORKSTATE = 141;
    public static final int U_CNT_MAX = 161;
    public static final int U_RADAR_VOL = 98;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 161; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_BNR_Toyota(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 161) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
