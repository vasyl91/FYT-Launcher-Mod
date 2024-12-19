package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti;
import com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDrivingInfo1Acti;
import com.syu.carinfo.golf7_xp.XP_MQB_AllAirControl;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0040_XP_MQB_ALL;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitMisc;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0040_XP1_GaoErFu7 extends CallbackCanbusBase {
    public static final int U_0_BY_START = 0;
    public static final int U_10_BY_REFUELLING = 10;
    public static final int U_11_BY_REFUELLING = 11;
    public static final int U_12_BY_REFUELLING = 12;
    public static final int U_13_BY_REFUELLING = 13;
    public static final int U_14_BY_REFUELLING = 14;
    public static final int U_15 = 15;
    public static final int U_1_BY_START = 1;
    public static final int U_2_BY_START = 2;
    public static final int U_3_BY_START = 3;
    public static final int U_4_BY_START = 4;
    public static final int U_5_BY_LONG_TERM = 5;
    public static final int U_6_BY_LONG_TERM = 6;
    public static final int U_7_BY_LONG_TERM = 7;
    public static final int U_8_BY_LONG_TERM = 8;
    public static final int U_9_BY_LONG_TERM = 9;
    public static final int U_ACTIVATEAUTOMATICLLY = 19;
    public static final int U_ACTIVATEMATICLLY = 150;
    public static final int U_AIR_AC = 88;
    public static final int U_AIR_AC_MAX = 103;
    public static final int U_AIR_AQS = 102;
    public static final int U_AIR_AUTO = 90;
    public static final int U_AIR_AUTOCYCLE_SET = 146;
    public static final int U_AIR_BEGIN = 87;
    public static final int U_AIR_BLOW_BODY = 96;
    public static final int U_AIR_BLOW_FOOT = 97;
    public static final int U_AIR_BLOW_WIN = 95;
    public static final int U_AIR_CLEAR = 104;
    public static final int U_AIR_CLEAR_STATE = 122;
    public static final int U_AIR_CON_PROFILE = 121;
    public static final int U_AIR_CYCLE = 89;
    public static final int U_AIR_DUAL = 92;
    public static final int U_AIR_END = 119;
    public static final int U_AIR_FRONT_GLASS_HEAT = 108;
    public static final int U_AIR_JUMPCON = 120;
    public static final int U_AIR_MAX = 93;
    public static final int U_AIR_POWER = 87;
    public static final int U_AIR_REAR_AUTO = 118;
    public static final int U_AIR_REAR_BLOW_BODY = 115;
    public static final int U_AIR_REAR_BLOW_FOOT = 116;
    public static final int U_AIR_REAR_BLOW_WIN = 114;
    public static final int U_AIR_REAR_LOCK = 94;
    public static final int U_AIR_REAR_POWER = 111;
    public static final int U_AIR_REAR_SEAT_LEFT = 112;
    public static final int U_AIR_REAR_SEAT_RIGHT = 113;
    public static final int U_AIR_REAR_TEMP = 110;
    public static final int U_AIR_REAR_WIND_LEVEL = 117;
    public static final int U_AIR_REAR_WIN_HEAT = 101;
    public static final int U_AIR_SEAT_HEAT_LEFT = 107;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 109;
    public static final int U_AIR_STEER_HEAT = 106;
    public static final int U_AIR_SYNC = 91;
    public static final int U_AIR_TEMPUNIT = 105;
    public static final int U_AIR_TEMP_LEFT = 99;
    public static final int U_AIR_TEMP_RIGHT = 100;
    public static final int U_AIR_WIND_LEVEL = 98;
    public static final int U_AUTO_AC_ENABLED = 84;
    public static final int U_BACK_BRIGHT = 147;
    public static final int U_BACK_CONTRAST = 148;
    public static final int U_BACK_SATURATION = 149;
    public static final int U_CARDAY = 70;
    public static final int U_CARDISTANCE = 71;
    public static final int U_CARLOG_SET = 86;
    public static final int U_CAR_KEY_ACTIVATED = 151;
    public static final int U_CNT_MAX = 180;
    public static final int U_CUR_SPEED = 130;
    public static final int U_DAYTIME_RUNNING_LIGHTS = 78;
    public static final int U_DOOR_BACK = 128;
    public static final int U_DOOR_BEGIN = 123;
    public static final int U_DOOR_END = 129;
    public static final int U_DOOR_ENGINE = 123;
    public static final int U_DOOR_FL = 124;
    public static final int U_DOOR_FR = 125;
    public static final int U_DOOR_MIND_PAIR = 144;
    public static final int U_DOOR_RL = 126;
    public static final int U_DOOR_RR = 127;
    public static final int U_DOOR_SENSE_LAN = 145;
    public static final int U_DRIVERACC = 31;
    public static final int U_DRIVERACTIVE = 32;
    public static final int U_DRIVERADVANCEWARNNINGSETTING = 33;
    public static final int U_DRIVERALERTSYSTEM = 37;
    public static final int U_DRIVERDISPLAYDISTANCEWARNNING = 34;
    public static final int U_DRIVERLANEASSIST = 35;
    public static final int U_DRIVERLANEASSIST_JH = 152;
    public static final int U_DRIVERLASTDISTANCESELECTED = 30;
    public static final int U_DRIVERPROACTIVEOCCUPATION = 38;
    public static final int U_DRIVERPROGRAM = 29;
    public static final int U_DRIVERTRAFFICESIGNRECOGNITION = 36;
    public static final int U_ENGINE_SPEED = 131;
    public static final int U_ESC_SYSTEM = 65;
    public static final int U_FEEDBACK_LAMP_ENABLED = 83;
    public static final int U_FRONTTONE = 21;
    public static final int U_FRONTVOL = 20;
    public static final int U_IDCARNUM = 82;
    public static final int U_JUMP_CARINFO = 137;
    public static final int U_LIGHTAUTOMATICHEADLIGHTRAIN = 43;
    public static final int U_LIGHTCOMINGHOME = 49;
    public static final int U_LIGHTDOORBACKGROUND = 47;
    public static final int U_LIGHTFOOTWELL = 48;
    public static final int U_LIGHTINSTRUMENT = 46;
    public static final int U_LIGHTLANECHANGEFLASH = 44;
    public static final int U_LIGHTLEAVINGHOME = 50;
    public static final int U_LIGHTSWITCHONTIME = 42;
    public static final int U_LIGHTTRAVELMODE = 45;
    public static final int U_LIGHT_ALL = 143;
    public static final int U_LIGHT_ASSIST = 141;
    public static final int U_LIGHT_BEND = 142;
    public static final int U_LIGHT_COLOR = 138;
    public static final int U_LIGHT_FAN = 139;
    public static final int U_LIGHT_RIGHT = 140;
    public static final int U_MIRRORWIPERSLOWWHILEREVESING = 52;
    public static final int U_MIRRORWIPERSREARWINWIPINGINREV = 55;
    public static final int U_MIRRORWIPERSSYNADJUST = 51;
    public static final int U_MORRORWIPERSAUTOWIPINGINRAIN = 54;
    public static final int U_MORRORWIPERSFOLDINWHENPARKED = 53;
    public static final int U_MUTIILDIGITSPEEDDISPLAY = 63;
    public static final int U_MUTILAVERAGECONSUMPTION = 57;
    public static final int U_MUTILAVERAGESPEED = 62;
    public static final int U_MUTILCONVENIENCECONSUMER = 58;
    public static final int U_MUTILCURRENTCONSUMPTION = 56;
    public static final int U_MUTILDISTANCETRAVELLED = 61;
    public static final int U_MUTILECOTIPS = 59;
    public static final int U_MUTILOILTEMP = 79;
    public static final int U_MUTILSPEEDWARNNING = 64;
    public static final int U_MUTILTRAVERLLINGTIME = 60;
    public static final int U_OILDAY = 72;
    public static final int U_OILDISTANCE = 73;
    public static final int U_OIL_MARK_MAX = 16;
    public static final int U_OIL_PROGRESS = 17;
    public static final int U_OIL_UNIT = 18;
    public static final int U_OPENCLOSEAUTOLOCK = 41;
    public static final int U_OPENCLOSECONVENIENCE = 39;
    public static final int U_OPENCLOSEDOORUNLOCK = 40;
    public static final int U_PARK = 24;
    public static final int U_RADARMUTE = 25;
    public static final int U_REARTONE = 23;
    public static final int U_REARVOL = 22;
    public static final int U_SETTING_86D13 = 136;
    public static final int U_SETTING_86D14 = 135;
    public static final int U_SETTING_86D15 = 134;
    public static final int U_SETTING_86D16 = 133;
    public static final int U_SETTING_86D17 = 132;
    public static final int U_SETTING_D40_D30_D1_B2 = 176;
    public static final int U_SETTING_D40_D30_D1_B74 = 179;
    public static final int U_SETTING_D40_D51_D4_B75 = 177;
    public static final int U_SETTING_D40_D70_D2_B2 = 178;
    public static final int U_SETTING_D41_D20_D3_B70 = 171;
    public static final int U_SETTING_D41_D70_D3_B0 = 170;
    public static final int U_SETTING_D41_DA1_D1_B30 = 163;
    public static final int U_SETTING_D41_DA1_D1_B74 = 162;
    public static final int U_SETTING_D41_DA1_D2_B30 = 165;
    public static final int U_SETTING_D41_DA1_D2_B74 = 164;
    public static final int U_SETTING_D41_DA1_D3_B30 = 169;
    public static final int U_SETTING_D41_DA1_D3_B5 = 168;
    public static final int U_SETTING_D41_DA1_D3_B6 = 167;
    public static final int U_SETTING_D41_DA1_D3_B7 = 166;
    public static final int U_SETTING_D41_DC0_D1_B0 = 175;
    public static final int U_SETTING_D41_DC0_D1_B1 = 174;
    public static final int U_SETTING_D41_DC0_D1_B2 = 173;
    public static final int U_SETTING_D41_DC0_D1_B43 = 172;
    public static final int U_SPEEDWARNNING = 27;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 85;
    public static final int U_TEMPERATUREUNIT = 77;
    public static final int U_TIRE_ALARM = 153;
    public static final int U_TIRE_ALARM_FL = 154;
    public static final int U_TIRE_ALARM_FR = 155;
    public static final int U_TIRE_ALARM_RL = 156;
    public static final int U_TIRE_ALARM_RR = 157;
    public static final int U_TIRE_PRESSURE_FL = 158;
    public static final int U_TIRE_PRESSURE_FR = 159;
    public static final int U_TIRE_PRESSURE_RL = 160;
    public static final int U_TIRE_PRESSURE_RR = 161;
    public static final int U_TPMS = 26;
    public static final int U_UNITCONSUMPTION = 68;
    public static final int U_UNITMILEAGE = 80;
    public static final int U_UNITPRESSURE = 69;
    public static final int U_UNITSPEED = 81;
    public static final int U_UNITTEMPERATURE = 66;
    public static final int U_UNITVOLUME = 67;
    public static final int U_WARNNINGAT = 28;
    public static final int U_WARNNING_CONV_CONSUMER = 76;
    public static final int U_WARNNING_START_STOP = 75;
    public static final int U_WARNNING_VEHICLE = 74;
    Runnable mDismissFunctionalDrivingInfo1 = new Runnable() { // from class: com.syu.module.canbus.Callback_0040_XP1_GaoErFu7.1
        @Override // java.lang.Runnable
        public void run() {
            if (Golf7FunctionalDrivingInfo1Acti.mIsFront && Golf7FunctionalDrivingInfo1Acti.mInstance != null) {
                Golf7FunctionalDrivingInfo1Acti.mInstance.finish();
            }
        }
    };

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 180; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 123;
        DoorHelper.sUcDoorFl = 124;
        DoorHelper.sUcDoorFr = 125;
        DoorHelper.sUcDoorRl = 126;
        DoorHelper.sUcDoorRr = 127;
        DoorHelper.sUcDoorBack = 128;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 123; i2 < 129; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0040_XP_MQB_ALL(LauncherApplication.getInstance()));
        for (int i3 = 87; i3 < 119; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 123; i < 129; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 87; i2 < 119; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 74:
                    warningVehicle(updateCode, ints);
                    break;
                case 75:
                    warningStartStop(updateCode, ints);
                    break;
                case 76:
                    convConsumer(updateCode, ints);
                    break;
                case 82:
                    if (strs != null && strs.length >= 1 && !ToolkitMisc.strEqual(ConstGolf.mCarId, strs[0])) {
                        ConstGolf.mCarId = strs[0];
                        DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                        break;
                    }
                case 120:
                    if (updateCode >= 0 && updateCode < 180) {
                        HandlerCanbus.update(updateCode, ints);
                    }
                    int value = DataCanbus.DATA[120];
                    if (value == 1 && !XP_MQB_AllAirControl.mIsFront) {
                        AirHelper.disableAirWindowLocal(true);
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7_xp.XP_MQB_AllAirControl");
                        break;
                    } else if (value == 0 && XP_MQB_AllAirControl.mIsFront && XP_MQB_AllAirControl.mInstance != null) {
                        XP_MQB_AllAirControl.mInstance.finish();
                        break;
                    }
                case 137:
                    convDrivingMode(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 180) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void convDrivingMode(int updateCode, int[] ints) {
        if (updateCode == 137) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !Golf7_XP_FunctionalDrivingInfo1Acti.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDrivingInfo1Acti");
            }
            HandlerUI.getInstance().removeCallbacks(this.mDismissFunctionalDrivingInfo1);
            HandlerUI.getInstance().postDelayed(this.mDismissFunctionalDrivingInfo1, 100000L);
        }
    }

    private void convConsumer(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            ConstGolf.mConvConsumer[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void warningVehicle(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 16) {
            ConstGolf.mVehicleWarning[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void warningStartStop(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            ConstGolf.mSartStop[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
