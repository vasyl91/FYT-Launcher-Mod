package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0167_XBS_MZD;

public class Callback_0167_XBS_XP1_OLD_MZD6 extends CallbackCanbusBase {
    public static final int U_CARCD_BEGIN = 98;
    public static final int U_CARCD_CURRENT_TIME = 107;
    public static final int U_CARCD_CURRENT_TRACK = 105;
    public static final int U_CARCD_DEVICE = 99;
    public static final int U_CARCD_ERROR_STATE = 100;
    public static final int U_CARCD_PLAY_RANDOMMODE = 104;
    public static final int U_CARCD_PLAY_REPEATMODE = 103;
    public static final int U_CARCD_PLAY_STATE = 102;
    public static final int U_CARCD_TEXT = 110;
    public static final int U_CARCD_TEXT_CHARSET = 109;
    public static final int U_CARCD_TEXT_TYPE = 108;
    public static final int U_CARCD_TOTAL_TIME = 106;
    public static final int U_CARCD_TOTAL_TRACK = 101;
    public static final int U_CAR_BRIGHT_LEVEL = 114;
    public static final int U_CD_END = 115;
    public static final int U_CNT_MAX = 116;
    public static final int U_CUR_BAND = 111;
    public static final int U_CUR_FREQ = 113;
    public static final int U_PRESET_CHANNEL = 112;
    public static String cdId3Album;
    public static String cdId3Artist;
    public static String cdId3Track;
    public static int cdid3charset;
    public static int cdid3type;
    public static int id3infoflag;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0167_XBS_MZD(LauncherApplication.getInstance()));
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 110:
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
                if (updateCode >= 0 && updateCode < 116) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
