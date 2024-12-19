package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.dj.huangguan.rzc_439_Huangguan_AirControlAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RZC_Toyato;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_TOYOTA_HuangGuan extends CallbackCanbusBase {
    public static final int CHANNEL_CNT_MAX = 6;
    public static int[] CHANNEL_FREQ_PRESET = new int[7];
    public static final int C_CMD_BUTTON = 0;
    public static final int C_CMD_KEY = 2;
    public static final int C_CMD_REQUEST = 1;
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AC_MAX = 18;
    public static final int U_AIR_AQS = 16;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BIG_WIND_LIGHT = 4;
    public static final int U_AIR_BLOW_BODY_LEFT = 9;
    public static final int U_AIR_BLOW_FOOT_LEFT = 10;
    public static final int U_AIR_BLOW_MODE = 70;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_CLEAN = 66;
    public static final int U_AIR_CLEAN_FLOWER = 67;
    public static final int U_AIR_CLEAN_ICE = 68;
    public static final int U_AIR_CLIMATE = 71;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 6;
    public static final int U_AIR_ECO = 17;
    public static final int U_AIR_END = 20;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_LITTLE_WIND_LIGHT = 5;
    public static final int U_AIR_MAX = 7;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_CTRL = 19;
    public static final int U_AIR_REAR_DEFROST = 15;
    public static final int U_AIR_SWING = 69;
    public static final int U_AIR_TEMP_LEFT = 12;
    public static final int U_AIR_TEMP_RIGHT = 13;
    public static final int U_AIR_WIND_LEVEL_LEFT = 11;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_DVD_CURRENT_TRACK = 58;
    public static final int U_CARINFO_DVD_DISC_MODE_RAND = 63;
    public static final int U_CARINFO_DVD_DISC_MODE_RPT = 62;
    public static final int U_CARINFO_DVD_ID = 57;
    public static final int U_CARINFO_DVD_PLAYTIME = 64;
    public static final int U_CARINFO_DVD_PLAY_MODE_RAND = 61;
    public static final int U_CARINFO_DVD_PLAY_MODE_RPT = 60;
    public static final int U_CARINFO_DVD_TOTAL_TRACK = 59;
    public static final int U_CARINFO_END = 65;
    public static final int U_CARINFO_RADIO_BAND = 51;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 53;
    public static final int U_CARINFO_RADIO_CHANNEL_PRESET = 55;
    public static final int U_CARINFO_RADIO_FREQ = 52;
    public static final int U_CARINFO_RADIO_SEARCH_STATE = 54;
    public static final int U_CARINFO_SOURCE = 50;
    public static final int U_CNT_MAX = 72;
    public static final int U_DOOR_BACK = 25;
    public static final int U_DOOR_BEGIN = 20;
    public static final int U_DOOR_END = 26;
    public static final int U_DOOR_ENGINE = 20;
    public static final int U_DOOR_FL = 21;
    public static final int U_DOOR_FR = 22;
    public static final int U_DOOR_RL = 23;
    public static final int U_DOOR_RR = 24;
    boolean jump = false;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 72; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 20;
        DoorHelper.sUcDoorFl = 21;
        DoorHelper.sUcDoorFr = 22;
        DoorHelper.sUcDoorRl = 23;
        DoorHelper.sUcDoorRr = 24;
        DoorHelper.sUcDoorBack = 25;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 20; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_RZC_Toyato(LauncherApplication.getInstance()));
        for (int i3 = 0; i3 < 20; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void showCotrolAir(int updateCode, int[] ints) {
        if (updateCode == 71) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !rzc_439_Huangguan_AirControlAct.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dj.huangguan.rzc_439_Huangguan_AirControlAct");
                this.jump = true;
                return;
            }
            this.jump = false;
            if (rzc_439_Huangguan_AirControlAct.mIsFront && this.jump && rzc_439_Huangguan_AirControlAct.mInstance != null) {
                rzc_439_Huangguan_AirControlAct.mInstance.finish();
            }
        }
    }

    private void showCotrolCD(int updateCode, int[] ints) {
        if (updateCode == 50) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 20; i < 26; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 20; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            if (updateCode == 55) {
                CHANNEL_FREQ_PRESET = ints;
                HandlerCanbus.update(updateCode, ints, flts, strs);
            } else if (updateCode == 71) {
                showCotrolAir(updateCode, ints);
            } else if (updateCode == 50) {
                showCotrolCD(updateCode, ints);
            } else {
                HandlerCanbus.update(updateCode, ints);
            }
        }
    }
}
