package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0320_WC2_HavaH6;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0320_WC2_HavalH6 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 3;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_UP_LEFT = 10;
    public static final int U_AIR_BLOW_WIN_LEFT = 14;
    public static final int U_AIR_CYCLE = 5;
    public static final int U_AIR_DUAL = 12;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 6;
    public static final int U_AIR_POWER = 13;
    public static final int U_AIR_REAR_AUTO = 87;
    public static final int U_AIR_REAR_BODY = 88;
    public static final int U_AIR_REAR_DEFROST = 7;
    public static final int U_AIR_REAR_FOOT = 89;
    public static final int U_AIR_REAR_POWER = 86;
    public static final int U_AIR_REAR_TEMP = 91;
    public static final int U_AIR_REAR_WIND_LEVEL = 90;
    public static final int U_AIR_SEAT_BLOW_LEFT = 67;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 68;
    public static final int U_AIR_SEAT_HOT_LEFT = 65;
    public static final int U_AIR_SEAT_HOT_RIGHT = 66;
    public static final int U_AIR_TEMP_LEFT = 27;
    public static final int U_AIR_TEMP_RIGHT = 28;
    public static final int U_AIR_WIND_LEVEL_LEFT = 11;
    public static final int U_CARINFO2_ALTITUDE = 40;
    public static final int U_CARINFO2_BEGIN = 34;
    public static final int U_CARINFO2_FRONTWHEEL = 37;
    public static final int U_CARINFO2_INCLINATION = 38;
    public static final int U_CARINFO2_PRESSURE = 35;
    public static final int U_CARINFO2_SLOPE = 36;
    public static final int U_CARINFO2_STEER = 85;
    public static final int U_CARINFO2_TRAILER = 39;
    public static final int U_CARINFO_ALLTERRAIN = 53;
    public static final int U_CARINFO_ANTITHEFT_SET = 47;
    public static final int U_CARINFO_BATTERY_VOLGATE = 23;
    public static final int U_CARINFO_BEGIN = 22;
    public static final int U_CARINFO_BIAOZHI_INFO = 56;
    public static final int U_CARINFO_CARTOP_MODE = 52;
    public static final int U_CARINFO_CETA_SET = 51;
    public static final int U_CARINFO_COLLISION_SAFE = 58;
    public static final int U_CARINFO_COLOR_MONOR = 64;
    public static final int U_CARINFO_COOLANT_TEMP = 24;
    public static final int U_CARINFO_D62_D2_B31 = 94;
    public static final int U_CARINFO_D62_D2_B54 = 93;
    public static final int U_CARINFO_D62_D2_B76 = 92;
    public static final int U_CARINFO_D62_D3_B31 = 97;
    public static final int U_CARINFO_D62_D3_B54 = 96;
    public static final int U_CARINFO_D62_D3_B76 = 95;
    public static final int U_CARINFO_D62_D4_B0 = 102;
    public static final int U_CARINFO_D62_D4_B1 = 101;
    public static final int U_CARINFO_D62_D4_B32 = 100;
    public static final int U_CARINFO_D62_D4_B54 = 99;
    public static final int U_CARINFO_D62_D4_B76 = 98;
    public static final int U_CARINFO_D62_D5_B2 = 107;
    public static final int U_CARINFO_D62_D5_B3 = 106;
    public static final int U_CARINFO_D62_D5_B4 = 105;
    public static final int U_CARINFO_D62_D5_B65 = 104;
    public static final int U_CARINFO_D62_D5_B7 = 103;
    public static final int U_CARINFO_D62_D6_B5 = 110;
    public static final int U_CARINFO_D62_D6_B6 = 109;
    public static final int U_CARINFO_D62_D6_B7 = 108;
    public static final int U_CARINFO_D67_D0_B5 = 112;
    public static final int U_CARINFO_D67_D0_B76 = 111;
    public static final int U_CARINFO_D68_D0_B5 = 81;
    public static final int U_CARINFO_D68_D0_B6 = 80;
    public static final int U_CARINFO_D68_D0_B7 = 79;
    public static final int U_CARINFO_D68_D1_B0 = 82;
    public static final int U_CARINFO_D68_D3_B0 = 70;
    public static final int U_CARINFO_D68_D3_B1 = 69;
    public static final int U_CARINFO_D68_D3_B32 = 84;
    public static final int U_CARINFO_D68_D3_B4 = 83;
    public static final int U_CARINFO_D68_D4_B20 = 115;
    public static final int U_CARINFO_D68_D4_B3 = 114;
    public static final int U_CARINFO_D68_D4_B54 = 113;
    public static final int U_CARINFO_DA6_D0_B70 = 71;
    public static final int U_CARINFO_DA6_D1_B70 = 72;
    public static final int U_CARINFO_DA6_D2_B70 = 73;
    public static final int U_CARINFO_DA6_D3_B70 = 74;
    public static final int U_CARINFO_DA6_D4_B70 = 75;
    public static final int U_CARINFO_DA6_D5_B70 = 76;
    public static final int U_CARINFO_DA6_D6_B10 = 78;
    public static final int U_CARINFO_DA6_D6_B32 = 77;
    public static final int U_CARINFO_DOMEDELAY = 41;
    public static final int U_CARINFO_DOORLOCK_SET = 49;
    public static final int U_CARINFO_END = 26;
    public static final int U_CARINFO_FATIGUE_WARN = 57;
    public static final int U_CARINFO_FOLLOWHOME = 42;
    public static final int U_CARINFO_FRONTLIGHT_MODE = 45;
    public static final int U_CARINFO_OPENDOOR_WARN = 63;
    public static final int U_CARINFO_PARALLEL_SYS = 61;
    public static final int U_CARINFO_PARK_SET = 46;
    public static final int U_CARINFO_PEDESTRIAN_SAFE = 59;
    public static final int U_CARINFO_POWERSAVE = 43;
    public static final int U_CARINFO_RAINFALLSENSOR = 44;
    public static final int U_CARINFO_REARVIEW_AUTO = 48;
    public static final int U_CARINFO_REARVIEW_SIDE_SYS = 62;
    public static final int U_CARINFO_ROADAWAY_WARN = 55;
    public static final int U_CARINFO_SEAT_MEMORY = 50;
    public static final int U_CARINFO_TRANS_OIL_TEMP = 25;
    public static final int U_CARINFO_WARN_SNESOR = 60;
    public static final int U_CNT_MAX = 116;
    public static final int U_CUR_SPEED = 29;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 2;
    public static final int U_DOOR_BACK = 20;
    public static final int U_DOOR_BEGIN = 15;
    public static final int U_DOOR_END = 21;
    public static final int U_DOOR_ENGINE = 15;
    public static final int U_DOOR_FL = 16;
    public static final int U_DOOR_FR = 17;
    public static final int U_DOOR_RL = 18;
    public static final int U_DOOR_RR = 19;
    public static final int U_ENGINE_SPEED = 30;
    public static final int U_MY_END = 33;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 1;
    public static final int U_REAR_MIRROR = 31;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 0;
    public static final int U_SMART_STARTSOTP = 32;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 54;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 15;
        DoorHelper.sUcDoorFl = 16;
        DoorHelper.sUcDoorFr = 17;
        DoorHelper.sUcDoorRl = 18;
        DoorHelper.sUcDoorRr = 19;
        DoorHelper.sUcDoorBack = 20;
        AirHelper.getInstance().buildUi(new Air_0320_WC2_HavaH6(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 15; i2 < 21; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 3; i3 < 15; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[27].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[28].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[65].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[66].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[67].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[68].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 15; i < 21; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 3; i2 < 15; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[28].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[27].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[65].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[66].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
