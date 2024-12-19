package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_Ford_Lincoin_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_Ford_Lincoin_All extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String RadioText = null;
    public static String Title = null;
    public static final int U_AIR_AC = 3;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_AUTO_LEV = 7;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 13;
    public static final int U_AIR_BLOW_FOOT_LEFT = 14;
    public static final int U_AIR_BLOW_WIN_LEFT = 12;
    public static final int U_AIR_CYCLE = 15;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_END = 29;
    public static final int U_AIR_FRONT_DEFROST = 17;
    public static final int U_AIR_FRONT_HOT = 26;
    public static final int U_AIR_MAXAC = 4;
    public static final int U_AIR_POWER = 0;
    public static final int U_AIR_REAR_DEFROST = 16;
    public static final int U_AIR_REAR_LOCK = 28;
    public static final int U_AIR_REAR_POWER = 6;
    public static final int U_AIR_REAR_TEMP = 8;
    public static final int U_AIR_REAR_WIND_LEVEL = 10;
    public static final int U_AIR_SEAT_BLOW_LEFT = 20;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 21;
    public static final int U_AIR_SEAT_HEAT_LEFT = 18;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 19;
    public static final int U_AIR_STEER_HOT = 27;
    public static final int U_AIR_SYNC = 2;
    public static final int U_AIR_TEMP_LEFT = 24;
    public static final int U_AIR_TEMP_RIGHT = 25;
    public static final int U_AIR_TEMP_UNIT = 11;
    public static final int U_AIR_WIND_LEVEL = 23;
    public static final int U_AIR_WIND_LEVEL_LEFT = 9;
    public static final int U_AIR_WIND_MODE = 22;
    public static final int U_CARCD_ARTIST = 96;
    public static final int U_CARCD_BEGIN = 88;
    public static final int U_CARCD_END = 97;
    public static final int U_CARCD_PLAYTIME = 91;
    public static final int U_CARCD_PLAYTRACK = 93;
    public static final int U_CARCD_RANDOM = 90;
    public static final int U_CARCD_REPEAT = 89;
    public static final int U_CARCD_STATE = 88;
    public static final int U_CARCD_TITLE = 95;
    public static final int U_CARCD_TOTALTIME = 92;
    public static final int U_CARCD_TOTALTRACK = 94;
    public static final int U_CAREQ_BAL = 51;
    public static final int U_CAREQ_BASS = 53;
    public static final int U_CAREQ_BEGIN = 50;
    public static final int U_CAREQ_END = 58;
    public static final int U_CAREQ_FAD = 52;
    public static final int U_CAREQ_MID = 54;
    public static final int U_CAREQ_SURROUND = 57;
    public static final int U_CAREQ_TREB = 55;
    public static final int U_CAREQ_VOL = 50;
    public static final int U_CAREQ_VOL_LINK_SPEED = 56;
    public static final int U_CARINFO_AMBIENT_LIGHT = 45;
    public static final int U_CARINFO_BEGIN = 37;
    public static final int U_CARINFO_DAY = 39;
    public static final int U_CARINFO_DRIVING_TIME = 46;
    public static final int U_CARINFO_END = 49;
    public static final int U_CARINFO_HOUR = 40;
    public static final int U_CARINFO_LANGUAGE = 43;
    public static final int U_CARINFO_MEASURE = 44;
    public static final int U_CARINFO_MINUTE = 41;
    public static final int U_CARINFO_MONTH = 38;
    public static final int U_CARINFO_PASSWORD_PROMPT = 48;
    public static final int U_CARINFO_RADAR_DISPLAY = 47;
    public static final int U_CARINFO_SECOND = 41;
    public static final int U_CARINFO_TOTAL_DISTANCE = 42;
    public static final int U_CARINFO_YEAR = 37;
    public static final int U_CARRADIO_AUTOP = 83;
    public static final int U_CARRADIO_BAND = 60;
    public static final int U_CARRADIO_BAND_TYPE = 86;
    public static final int U_CARRADIO_BEGIN = 59;
    public static final int U_CARRADIO_END = 87;
    public static final int U_CARRADIO_FRQ = 61;
    public static final int U_CARRADIO_FRQ1 = 62;
    public static final int U_CARRADIO_FRQ10 = 71;
    public static final int U_CARRADIO_FRQ11 = 72;
    public static final int U_CARRADIO_FRQ12 = 73;
    public static final int U_CARRADIO_FRQ13 = 74;
    public static final int U_CARRADIO_FRQ14 = 75;
    public static final int U_CARRADIO_FRQ15 = 76;
    public static final int U_CARRADIO_FRQ16 = 77;
    public static final int U_CARRADIO_FRQ17 = 78;
    public static final int U_CARRADIO_FRQ18 = 79;
    public static final int U_CARRADIO_FRQ2 = 63;
    public static final int U_CARRADIO_FRQ3 = 64;
    public static final int U_CARRADIO_FRQ4 = 65;
    public static final int U_CARRADIO_FRQ5 = 66;
    public static final int U_CARRADIO_FRQ6 = 67;
    public static final int U_CARRADIO_FRQ7 = 68;
    public static final int U_CARRADIO_FRQ8 = 69;
    public static final int U_CARRADIO_FRQ9 = 70;
    public static final int U_CARRADIO_RDS = 80;
    public static final int U_CARRADIO_SCAN = 81;
    public static final int U_CARRADIO_ST = 82;
    public static final int U_CARRADIO_TXT_INFO = 85;
    public static final int U_CARRADIO_TXT_SHOW = 84;
    public static final int U_CARSET_D61_D9_B70 = 100;
    public static final int U_CARSET_DE8_D0_B2 = 99;
    public static final int U_CARSET_DE8_D0_B3 = 98;
    public static final int U_CNT_MAX = 101;
    public static final int U_DOOR_BACK = 35;
    public static final int U_DOOR_BEGIN = 30;
    public static final int U_DOOR_END = 36;
    public static final int U_DOOR_ENGINE = 30;
    public static final int U_DOOR_FL = 31;
    public static final int U_DOOR_FR = 32;
    public static final int U_DOOR_RL = 33;
    public static final int U_DOOR_RR = 34;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 101; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 30;
        DoorHelper.sUcDoorFl = 31;
        DoorHelper.sUcDoorFr = 32;
        DoorHelper.sUcDoorRl = 33;
        DoorHelper.sUcDoorRr = 34;
        DoorHelper.sUcDoorBack = 35;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 30; i2 < 36; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0443_WC2_Ford_Lincoin_All(LauncherApplication.getInstance()));
        for (int i3 = 0; i3 < 29; i3++) {
            if (i3 != 11) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 30; i < 36; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 29; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 101) {
            switch (updateCode) {
                case 95:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 96:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 101) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
