package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_Xincheng_Lexus;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_XC_Lexus extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_ACMAX = 23;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_DUAL = 12;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_FRONT_MAX = 24;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_SEAT_HOT_LEFT = 21;
    public static final int U_AIR_SEAT_HOT_RIGHT = 22;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_TEMP_UNIT = 25;
    public static final int U_AIR_WIND_LEVEL = 18;
    public static final int U_CARCD_CURFILE = 64;
    public static final int U_CARCD_CURTIME_HOUR = 75;
    public static final int U_CARCD_CURTIME_MIN = 74;
    public static final int U_CARCD_CURTIME_SEC = 73;
    public static final int U_CARCD_CURTRACK = 66;
    public static final int U_CARCD_D72_ASL = 34;
    public static final int U_CARCD_D72_BAL = 32;
    public static final int U_CARCD_D72_BASS = 29;
    public static final int U_CARCD_D72_FAD = 33;
    public static final int U_CARCD_D72_MID = 30;
    public static final int U_CARCD_D72_TRE = 31;
    public static final int U_CARCD_D73_ASL = 40;
    public static final int U_CARCD_D73_BAL = 36;
    public static final int U_CARCD_D73_BASS = 37;
    public static final int U_CARCD_D73_FAD = 35;
    public static final int U_CARCD_D73_MID = 39;
    public static final int U_CARCD_D73_TRE = 38;
    public static final int U_CARCD_DISC1 = 43;
    public static final int U_CARCD_DISC2 = 44;
    public static final int U_CARCD_DISC3 = 45;
    public static final int U_CARCD_DISC4 = 46;
    public static final int U_CARCD_DISC5 = 47;
    public static final int U_CARCD_DISC6 = 48;
    public static final int U_CARCD_NUM = 50;
    public static final int U_CARCD_RANDOM = 71;
    public static final int U_CARCD_REPEAT = 70;
    public static final int U_CARCD_SCAN = 72;
    public static final int U_CARCD_STATE = 49;
    public static final int U_CARCD_TOTALFILE = 63;
    public static final int U_CARCD_TOTALTIME_HOUR = 69;
    public static final int U_CARCD_TOTALTIME_MIN = 68;
    public static final int U_CARCD_TOTALTIME_SEC = 67;
    public static final int U_CARCD_TOTALTRACK = 65;
    public static final int U_CARCD_WORKSTATE = 51;
    public static final int U_CAREQ_D72_MUTE = 27;
    public static final int U_CAREQ_D72_VOL = 28;
    public static final int U_CAREQ_D73_MUTE = 41;
    public static final int U_CAREQ_D73_VOL = 42;
    public static final int U_CARRADIO_BAND = 52;
    public static final int U_CARRADIO_CHNEL = 55;
    public static final int U_CARRADIO_FRQ = 56;
    public static final int U_CARRADIO_FRQ1 = 57;
    public static final int U_CARRADIO_FRQ2 = 58;
    public static final int U_CARRADIO_FRQ3 = 59;
    public static final int U_CARRADIO_FRQ4 = 60;
    public static final int U_CARRADIO_FRQ5 = 61;
    public static final int U_CARRADIO_FRQ6 = 62;
    public static final int U_CARRADIO_SCAN = 54;
    public static final int U_CARRADIO_ST = 53;
    public static final int U_CNT_MAX = 76;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 76; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_Xincheng_Lexus(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 26; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 76) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
