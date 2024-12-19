package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0139_RZC_BoRui_YuanjSUV;
import com.syu.ui.air.Air_0139_RZC_DIHAOYUANJING;
import com.syu.ui.air.Air_0139_RZC_DihaoGS_GL;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0139_RZC_XP1_JiLiEC7 extends CallbackCanbusBase {
    public static final int U_AIR_PM25_INTER = 97;
    public static final int U_AIR_PM25_OUT = 98;
    public static final int U_CAR_ACCOFF_AUTO_UNLOCK = 119;
    public static final int U_CAR_AIR_OPEN_MODE = 125;
    public static final int U_CAR_ALLDOOR_LOCK_WARN = 150;
    public static final int U_CAR_ASSIST_TURN_BY_MOVING = 138;
    public static final int U_CAR_AUTO_PARK = 126;
    public static final int U_CAR_AWAY_LOAD_WARN_AUTO = 129;
    public static final int U_CAR_AWAY_LOCK = 152;
    public static final int U_CAR_CLOSEDOOR_AUTO_WIND = 144;
    public static final int U_CAR_DAY_LIGHT = 104;
    public static final int U_CAR_DAY_LIGHT_19DHGL = 155;
    public static final int U_CAR_DRIVE_MODE = 174;
    public static final int U_CAR_DYNAMIC_RAILLINE = 134;
    public static final int U_CAR_ELECTRONIC_MODE = 100;
    public static final int U_CAR_ESC_MODE = 124;
    public static final int U_CAR_FISHEYE_CALIC = 135;
    public static final int U_CAR_FORTIFICATION_TYPE = 105;
    public static final int U_CAR_FRONT_LIGHT_AUTO = 128;
    public static final int U_CAR_FRONT_WARN = 127;
    public static final int U_CAR_LOCK_AUTOCLOSE_LIGHT = 143;
    public static final int U_CAR_LOCK_AUTOOFF_LIGNT = 122;
    public static final int U_CAR_LOCK_AUTO_CLOSE_WINDOW = 102;
    public static final int U_CAR_LOCK_AUTO_LIGHTOFF = 132;
    public static final int U_CAR_LOCK_CLOSE_SKYLIGHT = 103;
    public static final int U_CAR_LOCK_LIGHTOFF = 90;
    public static final int U_CAR_LOCK_SPEED = 123;
    public static final int U_CAR_LOWSPEED_WARN_BEEP = 148;
    public static final int U_CAR_MAINTENANCE = 168;
    public static final int U_CAR_NEAR_UNLOCK = 151;
    public static final int U_CAR_NOTIME_CHARGE_MODE = 149;
    public static final int U_CAR_OPENDOOR_LIGHT = 88;
    public static final int U_CAR_OPEND_TURN_LIGNT = 121;
    public static final int U_CAR_OPEN_TURNLIGHT_TWICE = 141;
    public static final int U_CAR_PARK_REARVIEW_AUTO = 153;
    public static final int U_CAR_REARVIEW_AUTO = 145;
    public static final int U_CAR_REARVIEW_AUTO_FOLD = 118;
    public static final int U_CAR_REMOTELOCK_RECALL = 89;
    public static final int U_CAR_REMOTE_AUTO_LOCK_BEEP = 120;
    public static final int U_CAR_REMOTE_LOCK_BEEP = 142;
    public static final int U_CAR_REMOTE_LOCK_CYCLE = 101;
    public static final int U_CAR_RMODE_5S_DELAY = 136;
    public static final int U_CAR_SET_D4E_D1B = 176;
    public static final int U_CAR_SET_D4E_D27 = 169;
    public static final int U_CAR_SET_D4E_D29 = 170;
    public static final int U_CAR_SET_D4E_D2A = 171;
    public static final int U_CAR_SET_D4E_D2B = 172;
    public static final int U_CAR_SET_D4E_D2C = 177;
    public static final int U_CAR_SET_D4E_D2D = 178;
    public static final int U_CAR_SET_D4E_D2E = 179;
    public static final int U_CAR_SET_D4E_D2F = 180;
    public static final int U_CAR_SET_D4E_D30 = 181;
    public static final int U_CAR_SET_D4E_D31 = 185;
    public static final int U_CAR_SET_D4E_D32 = 186;
    public static final int U_CAR_SET_D4E_D33 = 187;
    public static final int U_CAR_SET_D4E_D34 = 188;
    public static final int U_CAR_SET_D4E_D35 = 189;
    public static final int U_CAR_SET_D4E_D36 = 190;
    public static final int U_CAR_SET_D4E_D37 = 191;
    public static final int U_CAR_SET_D4E_D38 = 192;
    public static final int U_CAR_SET_D4E_D39 = 193;
    public static final int U_CAR_SET_D4E_D3A = 194;
    public static final int U_CAR_SET_D4E_D3B = 195;
    public static final int U_CAR_SET_D4E_D3C = 196;
    public static final int U_CAR_SET_D4E_D3D = 197;
    public static final int U_CAR_SET_D4E_D3E = 198;
    public static final int U_CAR_SET_D4E_D3F = 199;
    public static final int U_CAR_SET_D4E_D40 = 200;
    public static final int U_CAR_SET_D4E_D41 = 201;
    public static final int U_CAR_SET_D4E_D80 = 175;
    public static final int U_CAR_SET_D50_D3_B0 = 165;
    public static final int U_CAR_SET_D50_D3_B1 = 164;
    public static final int U_CAR_SET_D50_D3_B2 = 163;
    public static final int U_CAR_SET_D50_D3_B3 = 162;
    public static final int U_CAR_SET_D50_D3_B4 = 161;
    public static final int U_CAR_SET_D50_D3_B5 = 160;
    public static final int U_CAR_SET_D50_D4_B1 = 166;
    public static final int U_CAR_SET_FATIGUE = 183;
    public static final int U_CAR_SET_FATIGUE_WARN = 184;
    public static final int U_CAR_SET_PM25_ONOFF = 167;
    public static final int U_CAR_SET_SHOW_MAS = 182;
    public static final int U_CAR_SHEFANG_TISHI = 147;
    public static final int U_CAR_SINGLEROAD_BACKCAR_VIDEO = 137;
    public static final int U_CAR_SMART_CORNER_LIGHT = 99;
    public static final int U_CAR_SOC = 159;
    public static final int U_CAR_SPEED_LOCK = 86;
    public static final int U_CAR_SPEED_LOCK_19DH = 139;
    public static final int U_CAR_STATIC_RAILLINE = 133;
    public static final int U_CAR_STOP_UNLOCK = 140;
    public static final int U_CAR_THEME_COLOR = 146;
    public static final int U_CAR_TRUNK_AUTO_DISTANCE = 157;
    public static final int U_CAR_TRUNK_AUTO_NOKEY = 158;
    public static final int U_CAR_TRUNK_AUTO_OPEN = 156;
    public static final int U_CAR_TURNOFF_UNLOCKCAR = 87;
    public static final int U_CAR_UNLOCK_OFF = 131;
    public static final int U_CAR_WARN_DISTANCE = 130;
    public static final int U_CAR_WINDOW_ANTI_PINCK = 154;
    public static final int U_CNT_MAX = 202;
    public static final int U_COME_HOME_WITH_ME = 91;
    public static final int U_DRIVING_AUTO_LOCK = 94;
    public static final int U_KEEP_LIGHTON_TIME = 93;
    public static final int U_LOCK_FEEDBACK = 96;
    public static final int U_SEEK_CAR_FEEDBACK = 92;
    public static final int U_TIRE_STATE_FL = 106;
    public static final int U_TIRE_STATE_FR = 107;
    public static final int U_TIRE_STATE_RL = 108;
    public static final int U_TIRE_STATE_RR = 109;
    public static final int U_TIRE_TEMP_FL = 114;
    public static final int U_TIRE_TEMP_FR = 115;
    public static final int U_TIRE_TEMP_RL = 116;
    public static final int U_TIRE_TEMP_RR = 117;
    public static final int U_TIRE_VALUE_FL = 110;
    public static final int U_TIRE_VALUE_FR = 111;
    public static final int U_TIRE_VALUE_RL = 112;
    public static final int U_TIRE_VALUE_RR = 113;
    public static final int U_TURNOFF_AUTO_UNLOCK = 95;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 173;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 202; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i4 = 10; i4 < 85; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        int carid = (DataCanbus.DATA[1000] >> 16) & 65535;
        if (carid == 11 || carid == 12 || carid == 13 || carid == 14 || carid == 15 || carid == 17 || carid == 18 || carid == 19 || carid == 20 || carid == 21 || carid == 22 || carid == 23 || carid == 26 || carid == 28 || carid == 29 || carid == 31 || carid == 32 || carid == 33 || carid == 34 || carid == 35 || carid == 36 || carid == 37 || carid == 38 || carid == 39 || carid == 40 || carid == 41 || carid == 42 || carid == 44) {
            AirHelper.getInstance().buildUi(new Air_0139_RZC_BoRui_YuanjSUV(LauncherApplication.getInstance()));
            return;
        }
        if (carid == 9 || carid == 10 || carid == 24 || carid == 25 || carid == 27 || carid == 30) {
            AirHelper.getInstance().buildUi(new Air_0139_RZC_DihaoGS_GL(LauncherApplication.getInstance()));
        } else if (carid != 0) {
            AirHelper.getInstance().buildUi(new Air_0139_RZC_DIHAOYUANJING(LauncherApplication.getInstance()));
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 202) {
            Log.v("zed", "updateCode = " + updateCode + "____________ value  = " + ints[0]);
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    if (strs != null && strs.length > 0) {
                        ConstRzcAddData.CarFrameNum = strs[0];
                    } else {
                        ConstRzcAddData.CarFrameNum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
