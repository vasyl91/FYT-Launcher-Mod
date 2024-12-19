package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0167_XBS_MZD;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0167_XBS_XP1_OLD_MZD6 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 26;
    public static final int U_AIR_AUTO = 28;
    public static final int U_AIR_BEGIN = 24;
    public static final int U_AIR_BLOW_BODY_LEFT = 34;
    public static final int U_AIR_BLOW_FOOT_LEFT = 35;
    public static final int U_AIR_BLOW_UP_LEFT = 33;
    public static final int U_AIR_CYCLE = 32;
    public static final int U_AIR_DUAL = 31;
    public static final int U_AIR_ECO = 27;
    public static final int U_AIR_END = 39;
    public static final int U_AIR_FRONT_DEFROST = 29;
    public static final int U_AIR_POWER = 25;
    public static final int U_AIR_REAR_DEFROST = 30;
    public static final int U_AIR_TEMP_LEFT = 37;
    public static final int U_AIR_TEMP_RIGHT = 38;
    public static final int U_AIR_WIND_LEVEL_LEFT = 36;
    public static final int U_CARCD_BEGIN = 6;
    public static final int U_CARCD_CURRENT_TIME = 15;
    public static final int U_CARCD_CURRENT_TRACK = 13;
    public static final int U_CARCD_DEVICE = 7;
    public static final int U_CARCD_ERROR_STATE = 8;
    public static final int U_CARCD_PLAY_RANDOMMODE = 12;
    public static final int U_CARCD_PLAY_REPEATMODE = 11;
    public static final int U_CARCD_PLAY_STATE = 10;
    public static final int U_CARCD_TEXT = 18;
    public static final int U_CARCD_TEXT_CHARSET = 17;
    public static final int U_CARCD_TEXT_TYPE = 16;
    public static final int U_CARCD_TOTAL_TIME = 14;
    public static final int U_CARCD_TOTAL_TRACK = 9;
    public static final int U_CAR_BRIGHT_LEVEL = 22;
    public static final int U_CD_END = 23;
    public static final int U_CNT_MAX = 40;
    public static final int U_CUR_BAND = 19;
    public static final int U_CUR_FREQ = 21;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_PRESET_CHANNEL = 20;
    public static String cdId3Album;
    public static String cdId3Artist;
    public static String cdId3Track;
    public static int cdid3charset;
    public static int cdid3type;
    public static int id3infoflag;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 40; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = 24; i2 < 39; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0167_XBS_MZD(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 24; i < 39; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 18:
                if (ints != null && ints.length >= 1) {
                    cdid3type = ints[0];
                    cdid3charset = ints[1];
                    id3infoflag = ints[2];
                }
                if (strs != null && strs.length > 0) {
                    if (cdid3type == 0) {
                        cdId3Track = strs[0];
                    } else if (cdid3type == 2) {
                        cdId3Album = strs[0];
                    } else if (cdid3type == 3) {
                        cdId3Artist = strs[0];
                    }
                } else {
                    cdId3Track = "";
                    cdId3Album = "";
                    cdId3Artist = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                break;
            default:
                if (updateCode >= 0 && updateCode < 40) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
