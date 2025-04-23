package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.dj.huangguan.ActivityCarCD;
import com.syu.carinfo.dj.huangguan.ActivityCarRadio;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0429_DJ_XP1_TOYOTA_12Crown extends CallbackCanbusBase {
    public static int[] CHANNEL_FREQ_PRESET = new int[7];
    public static final int U_AVERAGE_SPEED = 125;
    public static final int U_CAREQ_ACOUSTIC = 121;
    public static final int U_CAREQ_BAL = 115;
    public static final int U_CAREQ_BASS = 116;
    public static final int U_CAREQ_FAD = 114;
    public static final int U_CAREQ_MID = 118;
    public static final int U_CAREQ_POSITION = 122;
    public static final int U_CAREQ_TRE = 117;
    public static final int U_CAREQ_VOL = 119;
    public static final int U_CAREQ_VOL_SPEED = 120;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_DVD_CURRENT_TRACK = 106;
    public static final int U_CARINFO_DVD_DISC_MODE_RAND = 111;
    public static final int U_CARINFO_DVD_DISC_MODE_RPT = 110;
    public static final int U_CARINFO_DVD_ID = 105;
    public static final int U_CARINFO_DVD_PLAYTIME = 112;
    public static final int U_CARINFO_DVD_PLAY_MODE_RAND = 109;
    public static final int U_CARINFO_DVD_PLAY_MODE_RPT = 108;
    public static final int U_CARINFO_DVD_TOTAL_TRACK = 107;
    public static final int U_CARINFO_END = 113;
    public static final int U_CARINFO_RADIO_BAND = 99;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 101;
    public static final int U_CARINFO_RADIO_CHANNEL_PRESET = 103;
    public static final int U_CARINFO_RADIO_FREQ = 100;
    public static final int U_CARINFO_RADIO_SEARCH_STATE = 102;
    public static final int U_CARINFO_SOURCE = 98;
    public static final int U_CARSET_D26_D0_B10 = 137;
    public static final int U_CARSET_D26_D0_B32 = 136;
    public static final int U_CARSET_D26_D0_B64 = 135;
    public static final int U_CARSET_D26_D0_B7 = 134;
    public static final int U_CARSET_D26_D1_B20 = 142;
    public static final int U_CARSET_D26_D1_B4 = 141;
    public static final int U_CARSET_D26_D1_B5 = 140;
    public static final int U_CARSET_D26_D1_B6 = 139;
    public static final int U_CARSET_D26_D1_B7 = 138;
    public static final int U_CARSET_D26_D2_B20 = 148;
    public static final int U_CARSET_D26_D2_B3 = 147;
    public static final int U_CARSET_D26_D2_B4 = 146;
    public static final int U_CARSET_D26_D2_B5 = 145;
    public static final int U_CARSET_D26_D2_B6 = 144;
    public static final int U_CARSET_D26_D2_B7 = 143;
    public static final int U_CARSET_D26_D3_B10 = 152;
    public static final int U_CARSET_D26_D3_B32 = 151;
    public static final int U_CARSET_D26_D3_B6 = 150;
    public static final int U_CARSET_D26_D3_B7 = 149;
    public static final int U_CARSET_D50_D0_B10 = 155;
    public static final int U_CARSET_D50_D0_B32 = 154;
    public static final int U_CARSET_D50_D0_B54 = 153;
    public static final int U_CARSET_D50_D1_B70 = 156;
    public static final int U_CARSET_D52_D0_B7 = 157;
    public static final int U_CARSET_D52_D1_B7 = 158;
    public static final int U_CARSET_D52_D2_B20 = 159;
    public static final int U_CARSET_D5A_D0_D1 = 160;
    public static final int U_CARSET_D5A_D10_B1 = 169;
    public static final int U_CARSET_D5A_D10_B2 = 168;
    public static final int U_CARSET_D5A_D10_B3 = 167;
    public static final int U_CARSET_D5A_D10_B54 = 166;
    public static final int U_CARSET_D5A_D10_B76 = 165;
    public static final int U_CARSET_D5A_D2_D3 = 161;
    public static final int U_CARSET_D5A_D4_D5 = 162;
    public static final int U_CARSET_D5A_D6_D7 = 163;
    public static final int U_CARSET_D5A_D8_D9 = 164;
    public static final int U_CARSET_OIL_UNIT = 132;
    public static final int U_CAR_JUMP_DISC = 124;
    public static final int U_CAR_JUMP_RADIO = 123;
    public static final int U_CNT_MAX = 170;
    public static final int U_CUR_OIL_EXPEND = 128;
    public static final int U_CUR_TRIP_OIL_EXPEND = 129;
    public static final int U_DRIVING_MILEAGE = 127;
    public static final int U_DRIVING_TIME = 126;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 133;
    public static final int U_TRIP_OIL_EXPEND = 130;
    public static final int U_WARNNING_LIFE_BELT = 131;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 170; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0429_DJ_XP1_TOYOTA_12Crown_Low(LauncherApplication.getInstance()));
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
        if (updateCode >= 0) {
            if (updateCode == 103) {
                CHANNEL_FREQ_PRESET = ints;
                HandlerCanbus.update(updateCode, ints, flts, strs);
                return;
            }
            if (updateCode == 123) {
                int value = ints[0];
                if (value == 1 && !ActivityCarRadio.mIsFront) {
                    //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.ActivityCarRadio");
                    return;
                }
                return;
            }
            if (updateCode == 124) {
                int value2 = ints[0];
                if (value2 == 1 && !ActivityCarCD.mIsFront) {
                    //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.ActivityCarCD");
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
