package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Subaru;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_LZ_Subaru_TRIBECA extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_MODE = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 11;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 12;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_WIND_LEVEL_LEFT = 17;
    public static final int U_CARINFO_CD_NUM = 54;
    public static final int U_CARINFO_CD_RANDOM = 56;
    public static final int U_CARINFO_CD_REAPEAT = 55;
    public static final int U_CARINFO_CD_TIME_M = 58;
    public static final int U_CARINFO_CD_TIME_S = 59;
    public static final int U_CARINFO_CD_TRACK = 57;
    public static final int U_CARINFO_RADIO_BAND = 43;
    public static final int U_CARINFO_RADIO_CHANNEL_ID = 51;
    public static final int U_CARINFO_RADIO_FREQ = 44;
    public static final int U_CARINFO_RADIO_FREQ1 = 45;
    public static final int U_CARINFO_RADIO_FREQ2 = 46;
    public static final int U_CARINFO_RADIO_FREQ3 = 47;
    public static final int U_CARINFO_RADIO_FREQ4 = 48;
    public static final int U_CARINFO_RADIO_FREQ5 = 49;
    public static final int U_CARINFO_RADIO_FREQ6 = 50;
    public static final int U_CARINFO_RADIO_SCAN = 53;
    public static final int U_CARINFO_RADIO_ST = 52;
    public static final int U_CARINF_D31_D0_B70 = 22;
    public static final int U_CARINF_D31_D1_B70 = 23;
    public static final int U_CARINF_D31_D2_B70 = 24;
    public static final int U_CARINF_D31_D3_B70 = 25;
    public static final int U_CARINF_D31_D4_B70 = 26;
    public static final int U_CARINF_D31_D5_B70 = 27;
    public static final int U_CARINF_D31_D6_B70 = 60;
    public static final int U_CARINF_D35_D0_D1 = 28;
    public static final int U_CARINF_D35_D10_D11 = 33;
    public static final int U_CARINF_D35_D13_B70 = 34;
    public static final int U_CARINF_D35_D2_D3 = 29;
    public static final int U_CARINF_D35_D4_D5 = 30;
    public static final int U_CARINF_D35_D6_D7 = 31;
    public static final int U_CARINF_D35_D8_D9 = 32;
    public static final int U_CARINF_D38_D0_B10 = 39;
    public static final int U_CARINF_D38_D0_B2 = 38;
    public static final int U_CARINF_D38_D0_B3 = 37;
    public static final int U_CARINF_D38_D0_B64 = 36;
    public static final int U_CARINF_D38_D0_B7 = 35;
    public static final int U_CARINF_D38_D1_B6 = 41;
    public static final int U_CARINF_D38_D1_B7 = 40;
    public static final int U_CARINF_LEFT_TEMP_ADD = 63;
    public static final int U_CARINF_RIGHT_TEMP_ADD = 64;
    public static final int U_CARINF_UNIT_MILE = 61;
    public static final int U_CARINF_UNIT_OIL = 62;
    public static final int U_CAR_SOURCE_ID = 42;
    public static final int U_CNT_MAX = 65;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 65; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Subaru(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 21; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 21; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 65) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
