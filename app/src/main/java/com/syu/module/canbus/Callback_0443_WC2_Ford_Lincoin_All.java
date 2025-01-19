package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0443_WC2_Ford_Lincoin_All;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Ford_Lincoin_All extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String RadioText = null;
    public static String Title = null;
    public static final int U_CARCD_ARTIST = 157;
    public static final int U_CARCD_BEGIN = 149;
    public static final int U_CARCD_END = 158;
    public static final int U_CARCD_PLAYTIME = 152;
    public static final int U_CARCD_PLAYTRACK = 154;
    public static final int U_CARCD_RANDOM = 151;
    public static final int U_CARCD_REPEAT = 150;
    public static final int U_CARCD_STATE = 149;
    public static final int U_CARCD_TITLE = 156;
    public static final int U_CARCD_TOTALTIME = 153;
    public static final int U_CARCD_TOTALTRACK = 155;
    public static final int U_CAREQ_BAL = 112;
    public static final int U_CAREQ_BASS = 114;
    public static final int U_CAREQ_BEGIN = 111;
    public static final int U_CAREQ_END = 119;
    public static final int U_CAREQ_FAD = 113;
    public static final int U_CAREQ_MID = 115;
    public static final int U_CAREQ_SURROUND = 118;
    public static final int U_CAREQ_TREB = 116;
    public static final int U_CAREQ_VOL = 111;
    public static final int U_CAREQ_VOL_LINK_SPEED = 117;
    public static final int U_CARINFO_AMBIENT_LIGHT = 106;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_DAY = 100;
    public static final int U_CARINFO_DRIVING_TIME = 107;
    public static final int U_CARINFO_END = 110;
    public static final int U_CARINFO_HOUR = 101;
    public static final int U_CARINFO_LANGUAGE = 104;
    public static final int U_CARINFO_MEASURE = 105;
    public static final int U_CARINFO_MINUTE = 102;
    public static final int U_CARINFO_MONTH = 99;
    public static final int U_CARINFO_PASSWORD_PROMPT = 109;
    public static final int U_CARINFO_RADAR_DISPLAY = 108;
    public static final int U_CARINFO_SECOND = 102;
    public static final int U_CARINFO_TOTAL_DISTANCE = 103;
    public static final int U_CARINFO_YEAR = 98;
    public static final int U_CARRADIO_AUTOP = 144;
    public static final int U_CARRADIO_BAND = 121;
    public static final int U_CARRADIO_BAND_TYPE = 147;
    public static final int U_CARRADIO_BEGIN = 120;
    public static final int U_CARRADIO_END = 148;
    public static final int U_CARRADIO_FRQ = 122;
    public static final int U_CARRADIO_FRQ1 = 123;
    public static final int U_CARRADIO_FRQ10 = 132;
    public static final int U_CARRADIO_FRQ11 = 133;
    public static final int U_CARRADIO_FRQ12 = 134;
    public static final int U_CARRADIO_FRQ13 = 135;
    public static final int U_CARRADIO_FRQ14 = 136;
    public static final int U_CARRADIO_FRQ15 = 137;
    public static final int U_CARRADIO_FRQ16 = 138;
    public static final int U_CARRADIO_FRQ17 = 139;
    public static final int U_CARRADIO_FRQ18 = 140;
    public static final int U_CARRADIO_FRQ2 = 124;
    public static final int U_CARRADIO_FRQ3 = 125;
    public static final int U_CARRADIO_FRQ4 = 126;
    public static final int U_CARRADIO_FRQ5 = 127;
    public static final int U_CARRADIO_FRQ6 = 128;
    public static final int U_CARRADIO_FRQ7 = 129;
    public static final int U_CARRADIO_FRQ8 = 130;
    public static final int U_CARRADIO_FRQ9 = 131;
    public static final int U_CARRADIO_RDS = 141;
    public static final int U_CARRADIO_SCAN = 142;
    public static final int U_CARRADIO_ST = 143;
    public static final int U_CARRADIO_TXT_INFO = 146;
    public static final int U_CARRADIO_TXT_SHOW = 145;
    public static final int U_CARSET_D61_D0_B0 = 165;
    public static final int U_CARSET_D61_D0_B1 = 164;
    public static final int U_CARSET_D61_D0_B4 = 163;
    public static final int U_CARSET_D61_D0_B5 = 162;
    public static final int U_CARSET_D61_D5_B30 = 167;
    public static final int U_CARSET_D61_D5_B74 = 166;
    public static final int U_CARSET_D61_D6_B10 = 170;
    public static final int U_CARSET_D61_D6_B32 = 169;
    public static final int U_CARSET_D61_D6_B74 = 168;
    public static final int U_CARSET_D61_D7_B30 = 172;
    public static final int U_CARSET_D61_D7_B74 = 171;
    public static final int U_CARSET_D61_D8_B10 = 175;
    public static final int U_CARSET_D61_D8_B32 = 174;
    public static final int U_CARSET_D61_D8_B74 = 173;
    public static final int U_CARSET_D61_D9_B70 = 161;
    public static final int U_CARSET_DE8_D0_B2 = 160;
    public static final int U_CARSET_DE8_D0_B3 = 159;
    public static final int U_CNT_MAX = 176;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 176; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_Ford_Lincoin_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
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
        if (updateCode >= 0 && updateCode < 176) {
            switch (updateCode) {
                case 156:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 157:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 176) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
