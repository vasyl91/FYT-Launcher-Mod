package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0347_YINGLONG_Ruijie;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0347_YingLong_Ruijie extends CallbackCanbusBase {
    public static final int CHANNEL_AM_INDEX_BEGIN = 33137;
    public static final int CHANNEL_FM_INDEX_BEGIN = 32998;
    public static final int U_AIR_AC = 4;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 6;
    public static final int U_AIR_BLOW_FOOT_LEFT = 7;
    public static final int U_AIR_BLOW_WIN_LEFT = 14;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_MAX = 8;
    public static final int U_AIR_MAX_AC = 15;
    public static final int U_AIR_POWER = 13;
    public static final int U_AIR_REAR_DEFROST = 3;
    public static final int U_AIR_SEAT_HEAT_LEFT = 10;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 11;
    public static final int U_AIR_TEMP_LEFT = 5;
    public static final int U_AIR_TEMP_RIGHT = 12;
    public static final int U_AIR_TEMP_UNIT = 16;
    public static final int U_AIR_WIND_LEVEL_LEFT = 9;
    public static final int U_CARINFO_BACKLIGHT_STATE = 33;
    public static final int U_CARINFO_BEGIN = 17;
    public static final int U_CARINFO_CARBRAKE_STATE = 30;
    public static final int U_CARINFO_CD_CUR_FOLDERID = 19;
    public static final int U_CARINFO_CD_CUR_LIST_INFO = 21;
    public static final int U_CARINFO_CD_ID3_ARTIST = 26;
    public static final int U_CARINFO_CD_ID3_TITLE = 25;
    public static final int U_CARINFO_CD_PLAYTIME = 20;
    public static final int U_CARINFO_CD_TRACK = 18;
    public static final int U_CARINFO_CUR_SPEED = 34;
    public static final int U_CARINFO_END = 43;
    public static final int U_CARINFO_ENGINER_STATE = 29;
    public static final int U_CARINFO_MEDIA_STATE = 32;
    public static final int U_CARINFO_RADIO_CHANNEL_PRESET = 28;
    public static final int U_CARINFO_RADIO_CUR_CHANNEL = 22;
    public static final int U_CARINFO_RADIO_CUR_CHANNEL_PRESET = 27;
    public static final int U_CARINFO_RADIO_CUR_FRAEQ = 23;
    public static final int U_CARINFO_TURNLIGHTS_STATE = 31;
    public static final int U_CARINFO_VOL = 24;
    public static final int U_CNT_MAX = 43;
    public static final int U_CUR_WORK_MODE = 37;
    public static final int U_LINE_GROUP = 41;
    public static final int U_LIST_INFO = 35;
    public static final int U_MODE_STATE = 38;
    public static final int U_PHONE_STATE = 39;
    public static final int U_PHONE_TIME = 36;
    public static final int U_PLAY_TIME = 42;
    public static final int U_SCREEN_ICON = 40;
    public static int[] freq = new int[10];

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 43; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0347_YINGLONG_Ruijie(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 17; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 43 && updateCode != 20) {
            Log.d("LG", String.valueOf(updateCode) + "ints:" + (ints != null) + " flts:" + (flts != null) + " strs:" + (strs != null));
        }
        if (updateCode == 28) {
            freq = ints;
        }
        if (strs == null) {
            HandlerCanbus.update(updateCode, ints);
        } else {
            HandlerCanbus.update(updateCode, ints, flts, strs);
        }
    }
}
