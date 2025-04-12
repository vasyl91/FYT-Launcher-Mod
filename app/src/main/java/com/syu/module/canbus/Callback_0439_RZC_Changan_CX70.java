package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_Changan_CX70 extends CallbackCanbusBase {
    public static final int U_360ALLVIEW_FRONT_RADAR = 153;
    public static final int U_360ALLVIEW_LOW_SPEED_TURN_LIGHT = 152;
    public static final int U_AIRSET_AIRAUTO_DRY = 124;
    public static final int U_AIRSET_BT_BLOW = 138;
    public static final int U_AIRSET_RAINVOLUME_AUTOAIR = 122;
    public static final int U_AIRSET_UNLOCK_OPENWINDOWTOWIND = 123;
    public static final int U_AIR_AUTO_CLEAR = 132;
    public static final int U_BACK_RAINASSIST = 117;
    public static final int U_BOXVOL_BAOJING = 130;
    public static final int U_BOXVOL_TISHI = 129;
    public static final int U_BOXVOL_YINGBING = 128;
    public static final int U_CARINF_D53_D0_D1_D2_D3 = 195;
    public static final int U_CARINF_D53_D10_B70 = 200;
    public static final int U_CARINF_D53_D11_B12 = 201;
    public static final int U_CARINF_D53_D4_D5_D6_D7 = 196;
    public static final int U_CARINF_D53_D8_B0 = 198;
    public static final int U_CARINF_D53_D8_B1 = 197;
    public static final int U_CARINF_D53_D9_B70 = 199;
    public static final int U_CAR_AIR_TYPE = 188;
    public static final int U_CNT_MAX = 205;
    public static final int U_COLLISION_AUTO_STOP = 146;
    public static final int U_COLLISION_WARNING = 144;
    public static final int U_COLLISION_WARNING_SENSOR = 145;
    public static final int U_CRUISE_AIMS_BEEP = 143;
    public static final int U_CRUISE_AUTO_INTEGADTED = 142;
    public static final int U_CUR_OIL_EXPEND = 99;
    public static final int U_CUR_TRIP_OIL_EXPEND = 101;
    public static final int U_D52_D3B_B70 = 173;
    public static final int U_D52_D3C_B70 = 174;
    public static final int U_D52_D3D_B70 = 175;
    public static final int U_D52_D3E_B70 = 176;
    public static final int U_D52_D3F_B70 = 177;
    public static final int U_D52_D40_B70 = 178;
    public static final int U_D52_D41_B70 = 179;
    public static final int U_D52_D42_B70 = 180;
    public static final int U_D52_D43_B70 = 181;
    public static final int U_D52_D44_B70 = 182;
    public static final int U_D52_D45_B70 = 183;
    public static final int U_D52_D46_B70 = 184;
    public static final int U_D52_D47_B70 = 185;
    public static final int U_D52_D48_B70 = 186;
    public static final int U_D52_D49_B70 = 187;
    public static final int U_D52_D4A_B70 = 189;
    public static final int U_D52_D4B_B70 = 190;
    public static final int U_D52_D4C_B70 = 191;
    public static final int U_D52_D4D_B70 = 192;
    public static final int U_D52_D4E_B70 = 193;
    public static final int U_D52_D4F_B70 = 194;
    public static final int U_D52_D50_B70 = 202;
    public static final int U_D52_D51_B70 = 203;
    public static final int U_DIANLABA_VOLSET = 136;
    public static final int U_DOORWINDOW_ACCOFF_LOCK = 120;
    public static final int U_DOORWINDOW_DRIVE_LOCK = 119;
    public static final int U_DOORWINDOW_RAINVOLUME_CLOSETOPWINDOW = 121;
    public static final int U_DOORWINDOW_REMOE_UNLOCK = 118;
    public static final int U_DRIVEMODE_REMEBER = 168;
    public static final int U_DRIVING_MILEAGE = 100;
    public static final int U_LANE_ASSIST_FUNCTION_SEL = 148;
    public static final int U_LANE_ASSIST_SENSOR = 147;
    public static final int U_LANE_ASSIST_SPEEDING_WARN = 151;
    public static final int U_LANE_ASSIST_SPEEDING_WARN_DEVIATION = 156;
    public static final int U_LANE_ASSIST_SPEED_LIMIT = 150;
    public static final int U_LANE_ASSIST_VIBRATION = 155;
    public static final int U_LANE_ASSIST_WARN_TYPEL = 149;
    public static final int U_LIGHT_ATMOSPHERE = 140;
    public static final int U_LIGHT_ATMOSPHERE_AUTO = 169;
    public static final int U_LIGHT_ATMOSPHERE_AUTOTYPE = 170;
    public static final int U_LIGHT_ATMOSPHERE_LEV = 154;
    public static final int U_LIGHT_ATMOSPHERE_VALUE = 165;
    public static final int U_LIGHT_AUTO_HIGH_BEAM = 141;
    public static final int U_LIGHT_DAY_DRIVING = 139;
    public static final int U_LIGHT_FORNTDELAY = 125;
    public static final int U_LIGHT_ONEKEYTURN = 126;
    public static final int U_METER_BEEP_VOICE = 171;
    public static final int U_METER_THEME = 172;
    public static final int U_OPTIMAL_OIL_EXPEND = 98;
    public static final int U_PART_AUTO_UNLOCK = 131;
    public static final int U_REAR_ASSIST_SPEEDING_WARN_BEEP = 157;
    public static final int U_REAR_WARN_PARALLEL = 158;
    public static final int U_REAR_WARN_REAR_CAR = 160;
    public static final int U_REAR_WARN_REAR_CAR_BEEP = 161;
    public static final int U_REAR_WARN_REVERSE_LANDSCAPE = 159;
    public static final int U_RESORE_CARSET = 116;
    public static final int U_RIGHTVIEW_FRONT_RADAR = 167;
    public static final int U_RIGHTVIEW_TURNRIGHT_LIGHT = 166;
    public static final int U_RIGHT_CAMERA_ONOFF = 204;
    public static final int U_SET_FOLD_REARMIRROR = 115;
    public static final int U_SKYLIGHT_RAIN_SENSING = 164;
    public static final int U_SKYLIGHT_REMOTE_CTRL = 163;
    public static final int U_SKYLIGHT_VOICE_CTRL = 162;
    public static final int U_TIRE_ALARM_FL = 110;
    public static final int U_TIRE_ALARM_FR = 111;
    public static final int U_TIRE_ALARM_RL = 112;
    public static final int U_TIRE_ALARM_RR = 113;
    public static final int U_TIRE_PRESSURE_FL = 102;
    public static final int U_TIRE_PRESSURE_FR = 103;
    public static final int U_TIRE_PRESSURE_RL = 104;
    public static final int U_TIRE_PRESSURE_RR = 105;
    public static final int U_TIRE_RESET = 127;
    public static final int U_TIRE_TEMP_FL = 106;
    public static final int U_TIRE_TEMP_FR = 107;
    public static final int U_TIRE_TEMP_RL = 108;
    public static final int U_TIRE_TEMP_RR = 109;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 114;
    public static final int U_UNLOCK_REC_SET = 137;
    public static final int U_WINDOW_DELAY_TIME = 133;
    public static final int U_WINDOW_LIGHT = 134;
    public static final int U_WINDOW_YAOKONG = 135;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 205; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        //AirHelper.getInstance().buildUi(new Air_0439_RZC_ChangAn_CX70(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 205) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
