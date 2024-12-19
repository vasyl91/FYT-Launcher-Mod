package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0070_RZC_XP1_17CHANGANCS75;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RZC_Changan_CX70 extends CallbackCanbusBase {
    public static final int U_360ALLVIEW_FRONT_RADAR = 76;
    public static final int U_360ALLVIEW_LOW_SPEED_TURN_LIGHT = 75;
    public static final int U_AIRSET_AIRAUTO_DRY = 47;
    public static final int U_AIRSET_BT_BLOW = 61;
    public static final int U_AIRSET_RAINVOLUME_AUTOAIR = 45;
    public static final int U_AIRSET_UNLOCK_OPENWINDOWTOWIND = 46;
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_ACMAX = 15;
    public static final int U_AIR_AUTO = 5;
    public static final int U_AIR_AUTO_CLEAR = 55;
    public static final int U_AIR_BEGIN = 4;
    public static final int U_AIR_BLOW_BODY_LEFT = 11;
    public static final int U_AIR_BLOW_FOOT_LEFT = 12;
    public static final int U_AIR_BLOW_MODE = 17;
    public static final int U_AIR_BLOW_UP_LEFT = 13;
    public static final int U_AIR_CYCLE = 6;
    public static final int U_AIR_END = 18;
    public static final int U_AIR_FRONT_DEFROST = 7;
    public static final int U_AIR_REAR = 16;
    public static final int U_AIR_REAR_DEFROST = 8;
    public static final int U_AIR_TEMP_LEFT = 10;
    public static final int U_AIR_WIND_LEVEL_LEFT = 14;
    public static final int U_BACK_RAINASSIST = 40;
    public static final int U_BOXVOL_BAOJING = 53;
    public static final int U_BOXVOL_TISHI = 52;
    public static final int U_BOXVOL_YINGBING = 51;
    public static final int U_CARINF_D53_D0_D1_D2_D3 = 118;
    public static final int U_CARINF_D53_D10_B70 = 123;
    public static final int U_CARINF_D53_D11_B12 = 124;
    public static final int U_CARINF_D53_D4_D5_D6_D7 = 119;
    public static final int U_CARINF_D53_D8_B0 = 121;
    public static final int U_CARINF_D53_D8_B1 = 120;
    public static final int U_CARINF_D53_D9_B70 = 122;
    public static final int U_CAR_AIR_TYPE = 111;
    public static final int U_CNT_MAX = 127;
    public static final int U_COLLISION_AUTO_STOP = 69;
    public static final int U_COLLISION_WARNING = 67;
    public static final int U_COLLISION_WARNING_SENSOR = 68;
    public static final int U_CRUISE_AIMS_BEEP = 66;
    public static final int U_CRUISE_AUTO_INTEGADTED = 65;
    public static final int U_CUR_OIL_EXPEND = 1;
    public static final int U_CUR_TRIP_OIL_EXPEND = 3;
    public static final int U_D52_D3B_B70 = 96;
    public static final int U_D52_D3C_B70 = 97;
    public static final int U_D52_D3D_B70 = 98;
    public static final int U_D52_D3E_B70 = 99;
    public static final int U_D52_D3F_B70 = 100;
    public static final int U_D52_D40_B70 = 101;
    public static final int U_D52_D41_B70 = 102;
    public static final int U_D52_D42_B70 = 103;
    public static final int U_D52_D43_B70 = 104;
    public static final int U_D52_D44_B70 = 105;
    public static final int U_D52_D45_B70 = 106;
    public static final int U_D52_D46_B70 = 107;
    public static final int U_D52_D47_B70 = 108;
    public static final int U_D52_D48_B70 = 109;
    public static final int U_D52_D49_B70 = 110;
    public static final int U_D52_D4A_B70 = 112;
    public static final int U_D52_D4B_B70 = 113;
    public static final int U_D52_D4C_B70 = 114;
    public static final int U_D52_D4D_B70 = 115;
    public static final int U_D52_D4E_B70 = 116;
    public static final int U_D52_D4F_B70 = 117;
    public static final int U_D52_D50_B70 = 125;
    public static final int U_D52_D51_B70 = 126;
    public static final int U_DIANLABA_VOLSET = 59;
    public static final int U_DOORWINDOW_ACCOFF_LOCK = 43;
    public static final int U_DOORWINDOW_DRIVE_LOCK = 42;
    public static final int U_DOORWINDOW_RAINVOLUME_CLOSETOPWINDOW = 44;
    public static final int U_DOORWINDOW_REMOE_UNLOCK = 41;
    public static final int U_DOOR_BACK = 23;
    public static final int U_DOOR_BEGIN = 18;
    public static final int U_DOOR_END = 24;
    public static final int U_DOOR_ENGINE = 18;
    public static final int U_DOOR_FL = 19;
    public static final int U_DOOR_FR = 20;
    public static final int U_DOOR_RL = 21;
    public static final int U_DOOR_RR = 22;
    public static final int U_DRIVEMODE_REMEBER = 91;
    public static final int U_DRIVING_MILEAGE = 2;
    public static final int U_LANE_ASSIST_FUNCTION_SEL = 71;
    public static final int U_LANE_ASSIST_SENSOR = 70;
    public static final int U_LANE_ASSIST_SPEEDING_WARN = 74;
    public static final int U_LANE_ASSIST_SPEEDING_WARN_DEVIATION = 79;
    public static final int U_LANE_ASSIST_SPEED_LIMIT = 73;
    public static final int U_LANE_ASSIST_VIBRATION = 78;
    public static final int U_LANE_ASSIST_WARN_TYPEL = 72;
    public static final int U_LIGHT_ATMOSPHERE = 63;
    public static final int U_LIGHT_ATMOSPHERE_AUTO = 92;
    public static final int U_LIGHT_ATMOSPHERE_AUTOTYPE = 93;
    public static final int U_LIGHT_ATMOSPHERE_LEV = 77;
    public static final int U_LIGHT_ATMOSPHERE_VALUE = 88;
    public static final int U_LIGHT_AUTO_HIGH_BEAM = 64;
    public static final int U_LIGHT_DAY_DRIVING = 62;
    public static final int U_LIGHT_FORNTDELAY = 48;
    public static final int U_LIGHT_ONEKEYTURN = 49;
    public static final int U_METER_BEEP_VOICE = 94;
    public static final int U_METER_THEME = 95;
    public static final int U_OPTIMAL_OIL_EXPEND = 0;
    public static final int U_PART_AUTO_UNLOCK = 54;
    public static final int U_REAR_ASSIST_SPEEDING_WARN_BEEP = 80;
    public static final int U_REAR_WARN_PARALLEL = 81;
    public static final int U_REAR_WARN_REAR_CAR = 83;
    public static final int U_REAR_WARN_REAR_CAR_BEEP = 84;
    public static final int U_REAR_WARN_REVERSE_LANDSCAPE = 82;
    public static final int U_RESORE_CARSET = 39;
    public static final int U_RIGHTVIEW_FRONT_RADAR = 90;
    public static final int U_RIGHTVIEW_TURNRIGHT_LIGHT = 89;
    public static final int U_SET_FOLD_REARMIRROR = 38;
    public static final int U_SKYLIGHT_RAIN_SENSING = 87;
    public static final int U_SKYLIGHT_REMOTE_CTRL = 86;
    public static final int U_SKYLIGHT_VOICE_CTRL = 85;
    public static final int U_TIRE_ALARM_FL = 33;
    public static final int U_TIRE_ALARM_FR = 34;
    public static final int U_TIRE_ALARM_RL = 35;
    public static final int U_TIRE_ALARM_RR = 36;
    public static final int U_TIRE_PRESSURE_FL = 25;
    public static final int U_TIRE_PRESSURE_FR = 26;
    public static final int U_TIRE_PRESSURE_RL = 27;
    public static final int U_TIRE_PRESSURE_RR = 28;
    public static final int U_TIRE_RESET = 50;
    public static final int U_TIRE_TEMP_FL = 29;
    public static final int U_TIRE_TEMP_FR = 30;
    public static final int U_TIRE_TEMP_RL = 31;
    public static final int U_TIRE_TEMP_RR = 32;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 37;
    public static final int U_UNLOCK_REC_SET = 60;
    public static final int U_WINDOW_DELAY_TIME = 56;
    public static final int U_WINDOW_LIGHT = 57;
    public static final int U_WINDOW_YAOKONG = 58;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 127; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 18;
        DoorHelper.sUcDoorFl = 19;
        DoorHelper.sUcDoorFr = 20;
        DoorHelper.sUcDoorRl = 21;
        DoorHelper.sUcDoorRr = 22;
        DoorHelper.sUcDoorBack = 23;
        for (int i2 = 18; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0070_RZC_XP1_17CHANGANCS75(LauncherApplication.getInstance()));
        for (int i3 = 4; i3 < 18; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 18; i < 24; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 4; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 127) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
