package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_Luz_LexusIS;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_LUZ_Lexus_IS extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AQS = 15;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_AUTO_WIN = 13;
    public static final int U_AIR_BACK_AUTO = 79;
    public static final int U_AIR_BACK_BLOW = 81;
    public static final int U_AIR_BACK_COOL = 83;
    public static final int U_AIR_BACK_HEAT = 84;
    public static final int U_AIR_BACK_MANUAL = 78;
    public static final int U_AIR_BACK_POWER = 82;
    public static final int U_AIR_BACK_TEMP_LEFT = 76;
    public static final int U_AIR_BACK_TEMP_RIGHT = 77;
    public static final int U_AIR_BACK_WIN_LEV = 80;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_BODY_RIGHT = 70;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 71;
    public static final int U_AIR_BLOW_UP_LEFT = 7;
    public static final int U_AIR_BLOW_UP_RIGHT = 69;
    public static final int U_AIR_CLEAR = 72;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_FRONT_HOT = 73;
    public static final int U_AIR_FRONT_MAX = 6;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR = 75;
    public static final int U_AIR_REARVIEW_HOT = 74;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_TEMP_LEFT = 11;
    public static final int U_AIR_TEMP_RIGHT = 12;
    public static final int U_AIR_TEMP_UNIT = 16;
    public static final int U_AIR_WIND_LEVEL = 10;
    public static final int U_CARCD_ASL = 65;
    public static final int U_CARCD_BAL = 64;
    public static final int U_CARCD_BASS = 66;
    public static final int U_CARCD_CURTIME_HOUR = 62;
    public static final int U_CARCD_CURTIME_MIN = 61;
    public static final int U_CARCD_CURTIME_SEC = 60;
    public static final int U_CARCD_CURTRACK = 56;
    public static final int U_CARCD_DISC1 = 33;
    public static final int U_CARCD_DISC2 = 34;
    public static final int U_CARCD_DISC3 = 35;
    public static final int U_CARCD_DISC4 = 36;
    public static final int U_CARCD_DISC5 = 37;
    public static final int U_CARCD_DISC6 = 38;
    public static final int U_CARCD_MID = 68;
    public static final int U_CARCD_NUM = 40;
    public static final int U_CARCD_RANDOM = 54;
    public static final int U_CARCD_REPEAT = 53;
    public static final int U_CARCD_STATE = 39;
    public static final int U_CARCD_TOTALTIME_HOUR = 59;
    public static final int U_CARCD_TOTALTIME_MIN = 58;
    public static final int U_CARCD_TOTALTIME_SEC = 57;
    public static final int U_CARCD_TOTALTRACK = 55;
    public static final int U_CARCD_TRE = 67;
    public static final int U_CARCD_VOL = 85;
    public static final int U_CARCD_WORKSTATE = 41;
    public static final int U_CAREQ_FAD = 63;
    public static final int U_CARINFO_D35_D0_D1 = 86;
    public static final int U_CARINFO_D35_D2_D3 = 87;
    public static final int U_CARINFO_D35_D4_D5 = 88;
    public static final int U_CARINFO_D35_D6_D7 = 89;
    public static final int U_CARINFO_D35_D8_D9 = 90;
    public static final int U_CARRADIO_BAND = 42;
    public static final int U_CARRADIO_CHNEL = 43;
    public static final int U_CARRADIO_FRQ = 46;
    public static final int U_CARRADIO_FRQ1 = 47;
    public static final int U_CARRADIO_FRQ2 = 48;
    public static final int U_CARRADIO_FRQ3 = 49;
    public static final int U_CARRADIO_FRQ4 = 50;
    public static final int U_CARRADIO_FRQ5 = 51;
    public static final int U_CARRADIO_FRQ6 = 52;
    public static final int U_CARRADIO_SCAN = 44;
    public static final int U_CARRADIO_ST = 45;
    public static final int U_CARUSB_FOLDERNUM = 32;
    public static final int U_CARUSB_PLAYTIME_MIN = 28;
    public static final int U_CARUSB_PLAYTIME_SEC = 29;
    public static final int U_CARUSB_STATE = 27;
    public static final int U_CARUSB_TOTALTRACK = 31;
    public static final int U_CARUSB_TRACK = 30;
    public static final int U_CNT_MAX = 91;
    public static final int U_CUR_SPEED = 25;
    public static final int U_DOOR_BACK = 23;
    public static final int U_DOOR_BEGIN = 18;
    public static final int U_DOOR_END = 24;
    public static final int U_DOOR_ENGINE = 18;
    public static final int U_DOOR_FL = 19;
    public static final int U_DOOR_FR = 20;
    public static final int U_DOOR_RL = 21;
    public static final int U_DOOR_RR = 22;
    public static final int U_ENGINE_SPEED = 26;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 91; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 18;
        DoorHelper.sUcDoorFl = 19;
        DoorHelper.sUcDoorFr = 20;
        DoorHelper.sUcDoorRl = 21;
        DoorHelper.sUcDoorRr = 22;
        DoorHelper.sUcDoorBack = 23;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 18; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_Luz_LexusIS(LauncherApplication.getInstance()));
        for (int i3 = 0; i3 < 17; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 18; i < 24; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 91) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
