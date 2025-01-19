package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0347_YINGLONG_Ruijie;

public class Callback_0347_YingLong_Ruijie extends CallbackCanbusBase {
    public static final int CHANNEL_AM_INDEX_BEGIN = 33137;
    public static final int CHANNEL_FM_INDEX_BEGIN = 32998;
    public static final int U_CARINFO_BACKLIGHT_STATE = 113;
    public static final int U_CARINFO_BEGIN = 97;
    public static final int U_CARINFO_CARBRAKE_STATE = 110;
    public static final int U_CARINFO_CD_CUR_FOLDERID = 99;
    public static final int U_CARINFO_CD_CUR_LIST_INFO = 101;
    public static final int U_CARINFO_CD_ID3_ARTIST = 106;
    public static final int U_CARINFO_CD_ID3_TITLE = 105;
    public static final int U_CARINFO_CD_PLAYTIME = 100;
    public static final int U_CARINFO_CD_TRACK = 98;
    public static final int U_CARINFO_CUR_SPEED = 114;
    public static final int U_CARINFO_END = 123;
    public static final int U_CARINFO_ENGINER_STATE = 109;
    public static final int U_CARINFO_MEDIA_STATE = 112;
    public static final int U_CARINFO_RADIO_CHANNEL_PRESET = 108;
    public static final int U_CARINFO_RADIO_CUR_CHANNEL = 102;
    public static final int U_CARINFO_RADIO_CUR_CHANNEL_PRESET = 107;
    public static final int U_CARINFO_RADIO_CUR_FRAEQ = 103;
    public static final int U_CARINFO_TURNLIGHTS_STATE = 111;
    public static final int U_CARINFO_VOL = 104;
    public static final int U_CNT_MAX = 124;
    public static final int U_CUR_WORK_MODE = 117;
    public static final int U_LINE_GROUP = 121;
    public static final int U_LIST_INFO = 115;
    public static final int U_MODE_STATE = 118;
    public static final int U_PHONE_STATE = 119;
    public static final int U_PHONE_TIME = 116;
    public static final int U_PLAY_TIME = 122;
    public static final int U_SCREEN_ICON = 120;
    public static int[] freq = new int[10];

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 124; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0347_YINGLONG_Ruijie(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
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
        if (updateCode >= 0 && updateCode < 124 && updateCode != 100) {
            Log.d("LG", updateCode + "ints:" + (ints != null) + " flts:" + (flts != null) + " strs:" + (strs != null));
        }
        if (updateCode == 108) {
            freq = ints;
        }
        if (strs == null) {
            HandlerCanbus.update(updateCode, ints);
        } else {
            HandlerCanbus.update(updateCode, ints, flts, strs);
        }
    }
}
