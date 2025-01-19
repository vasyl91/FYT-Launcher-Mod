package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0139_RZC_BoRui_YuanjSUV;
//import com.syu.ui.air.Air_0139_RZC_DIHAOYUANJING;
//import com.syu.ui.air.Air_0139_RZC_DihaoGS_GL;
import com.syu.ui.door.DoorHelper;

public class Callback_0139_RZC_XP1_JiLiEC7 extends CallbackCanbusBase {
    public static final int U_AIR_PM25_INTER = 109;
    public static final int U_AIR_PM25_OUT = 110;
    public static final int U_CAR_ACCOFF_AUTO_UNLOCK = 131;
    public static final int U_CAR_AIR_OPEN_MODE = 137;
    public static final int U_CAR_ALLDOOR_LOCK_WARN = 162;
    public static final int U_CAR_ASSIST_TURN_BY_MOVING = 150;
    public static final int U_CAR_AUTO_PARK = 138;
    public static final int U_CAR_AWAY_LOAD_WARN_AUTO = 141;
    public static final int U_CAR_AWAY_LOCK = 164;
    public static final int U_CAR_CLOSEDOOR_AUTO_WIND = 156;
    public static final int U_CAR_DAY_LIGHT = 116;
    public static final int U_CAR_DAY_LIGHT_19DHGL = 167;
    public static final int U_CAR_DRIVE_MODE = 186;
    public static final int U_CAR_DYNAMIC_RAILLINE = 146;
    public static final int U_CAR_ELECTRONIC_MODE = 112;
    public static final int U_CAR_ESC_MODE = 136;
    public static final int U_CAR_FISHEYE_CALIC = 147;
    public static final int U_CAR_FORTIFICATION_TYPE = 117;
    public static final int U_CAR_FRONT_LIGHT_AUTO = 140;
    public static final int U_CAR_FRONT_WARN = 139;
    public static final int U_CAR_LOCK_AUTOCLOSE_LIGHT = 155;
    public static final int U_CAR_LOCK_AUTOOFF_LIGNT = 134;
    public static final int U_CAR_LOCK_AUTO_CLOSE_WINDOW = 114;
    public static final int U_CAR_LOCK_AUTO_LIGHTOFF = 144;
    public static final int U_CAR_LOCK_CLOSE_SKYLIGHT = 115;
    public static final int U_CAR_LOCK_LIGHTOFF = 102;
    public static final int U_CAR_LOCK_SPEED = 135;
    public static final int U_CAR_LOWSPEED_WARN_BEEP = 160;
    public static final int U_CAR_MAINTENANCE = 180;
    public static final int U_CAR_NEAR_UNLOCK = 163;
    public static final int U_CAR_NOTIME_CHARGE_MODE = 161;
    public static final int U_CAR_OPENDOOR_LIGHT = 100;
    public static final int U_CAR_OPEND_TURN_LIGNT = 133;
    public static final int U_CAR_OPEN_TURNLIGHT_TWICE = 153;
    public static final int U_CAR_PARK_REARVIEW_AUTO = 165;
    public static final int U_CAR_REARVIEW_AUTO = 157;
    public static final int U_CAR_REARVIEW_AUTO_FOLD = 130;
    public static final int U_CAR_REMOTELOCK_RECALL = 101;
    public static final int U_CAR_REMOTE_AUTO_LOCK_BEEP = 132;
    public static final int U_CAR_REMOTE_LOCK_BEEP = 154;
    public static final int U_CAR_REMOTE_LOCK_CYCLE = 113;
    public static final int U_CAR_RMODE_5S_DELAY = 148;
    public static final int U_CAR_SET_D4E_D12 = 214;
    public static final int U_CAR_SET_D4E_D1B = 188;
    public static final int U_CAR_SET_D4E_D27 = 181;
    public static final int U_CAR_SET_D4E_D29 = 182;
    public static final int U_CAR_SET_D4E_D2A = 183;
    public static final int U_CAR_SET_D4E_D2B = 184;
    public static final int U_CAR_SET_D4E_D2C = 189;
    public static final int U_CAR_SET_D4E_D2D = 190;
    public static final int U_CAR_SET_D4E_D2E = 191;
    public static final int U_CAR_SET_D4E_D2F = 192;
    public static final int U_CAR_SET_D4E_D30 = 193;
    public static final int U_CAR_SET_D4E_D31 = 197;
    public static final int U_CAR_SET_D4E_D32 = 198;
    public static final int U_CAR_SET_D4E_D33 = 199;
    public static final int U_CAR_SET_D4E_D34 = 200;
    public static final int U_CAR_SET_D4E_D35 = 201;
    public static final int U_CAR_SET_D4E_D36 = 202;
    public static final int U_CAR_SET_D4E_D37 = 203;
    public static final int U_CAR_SET_D4E_D38 = 204;
    public static final int U_CAR_SET_D4E_D39 = 205;
    public static final int U_CAR_SET_D4E_D3A = 206;
    public static final int U_CAR_SET_D4E_D3B = 207;
    public static final int U_CAR_SET_D4E_D3C = 208;
    public static final int U_CAR_SET_D4E_D3D = 209;
    public static final int U_CAR_SET_D4E_D3E = 210;
    public static final int U_CAR_SET_D4E_D3F = 211;
    public static final int U_CAR_SET_D4E_D40 = 212;
    public static final int U_CAR_SET_D4E_D41 = 213;
    public static final int U_CAR_SET_D4E_D80 = 187;
    public static final int U_CAR_SET_D4F_D3 = 215;
    public static final int U_CAR_SET_D50_D3_B0 = 177;
    public static final int U_CAR_SET_D50_D3_B1 = 176;
    public static final int U_CAR_SET_D50_D3_B2 = 175;
    public static final int U_CAR_SET_D50_D3_B3 = 174;
    public static final int U_CAR_SET_D50_D3_B4 = 173;
    public static final int U_CAR_SET_D50_D3_B5 = 172;
    public static final int U_CAR_SET_D50_D4_B1 = 178;
    public static final int U_CAR_SET_FATIGUE = 195;
    public static final int U_CAR_SET_FATIGUE_WARN = 196;
    public static final int U_CAR_SET_PM25_ONOFF = 179;
    public static final int U_CAR_SET_SHOW_MAS = 194;
    public static final int U_CAR_SET_SOC_BUTTON = 216;
    public static final int U_CAR_SHEFANG_TISHI = 159;
    public static final int U_CAR_SINGLEROAD_BACKCAR_VIDEO = 149;
    public static final int U_CAR_SMART_CORNER_LIGHT = 111;
    public static final int U_CAR_SOC = 171;
    public static final int U_CAR_SPEED_LOCK = 98;
    public static final int U_CAR_SPEED_LOCK_19DH = 151;
    public static final int U_CAR_STATIC_RAILLINE = 145;
    public static final int U_CAR_STOP_UNLOCK = 152;
    public static final int U_CAR_THEME_COLOR = 158;
    public static final int U_CAR_TRUNK_AUTO_DISTANCE = 169;
    public static final int U_CAR_TRUNK_AUTO_NOKEY = 170;
    public static final int U_CAR_TRUNK_AUTO_OPEN = 168;
    public static final int U_CAR_TURNOFF_UNLOCKCAR = 99;
    public static final int U_CAR_UNLOCK_OFF = 143;
    public static final int U_CAR_WARN_DISTANCE = 142;
    public static final int U_CAR_WINDOW_ANTI_PINCK = 166;
    public static final int U_CNT_MAX = 217;
    public static final int U_COME_HOME_WITH_ME = 103;
    public static final int U_DRIVING_AUTO_LOCK = 106;
    public static final int U_KEEP_LIGHTON_TIME = 105;
    public static final int U_LOCK_FEEDBACK = 108;
    public static final int U_SEEK_CAR_FEEDBACK = 104;
    public static final int U_TIRE_STATE_FL = 118;
    public static final int U_TIRE_STATE_FR = 119;
    public static final int U_TIRE_STATE_RL = 120;
    public static final int U_TIRE_STATE_RR = 121;
    public static final int U_TIRE_TEMP_FL = 126;
    public static final int U_TIRE_TEMP_FR = 127;
    public static final int U_TIRE_TEMP_RL = 128;
    public static final int U_TIRE_TEMP_RR = 129;
    public static final int U_TIRE_VALUE_FL = 122;
    public static final int U_TIRE_VALUE_FR = 123;
    public static final int U_TIRE_VALUE_RL = 124;
    public static final int U_TIRE_VALUE_RR = 125;
    public static final int U_TURNOFF_AUTO_UNLOCK = 107;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 185;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 217; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        int carid = (DataCanbus.DATA[1000] >> 16) & 65535;
        if (carid == 11 || carid == 12 || carid == 13 || carid == 14 || carid == 15 || carid == 17 || carid == 18 || carid == 19 || carid == 20 || carid == 21 || carid == 22 || carid == 23 || carid == 26 || carid == 28 || carid == 29 || carid == 31 || carid == 32 || carid == 33 || carid == 34 || carid == 35 || carid == 36 || carid == 37 || carid == 38 || carid == 39 || carid == 40 || carid == 41 || carid == 42 || carid == 44 || carid == 47 || carid == 48 || carid == 49 || carid == 50 || carid == 51) {
            //AirHelper.getInstance().buildUi(new Air_0139_RZC_BoRui_YuanjSUV(LauncherApplication.getInstance()));
            return;
        }
        if (carid == 9 || carid == 10 || carid == 24 || carid == 25 || carid == 27 || carid == 30) {
            //AirHelper.getInstance().buildUi(new Air_0139_RZC_DihaoGS_GL(LauncherApplication.getInstance()));
        } else if (carid != 0) {
            //AirHelper.getInstance().buildUi(new Air_0139_RZC_DIHAOYUANJING(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 217) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
