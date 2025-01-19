package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0020_XP1_Camry2013;
import com.syu.ui.door.DoorHelper;

public class Callback_0020_XP1_Camry2013 extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 125;
    public static final int U_AIR_BY_AUTO_KEY = 131;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 121;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 122;
    public static final int U_AUTOLOCK_BY_SPEED = 120;
    public static final int U_AVERAGE_SPEED = 101;
    public static final int U_BATTERY_VOLTAGE = 98;
    public static final int U_BELT_LEFT = 159;
    public static final int U_BELT_RIGHT = 160;
    public static final int U_CARINFO_D1E_D4_B20 = 195;
    public static final int U_CARINFO_D1E_D4_B4 = 194;
    public static final int U_CARINFO_D1E_D4_B5 = 193;
    public static final int U_CARINFO_D1E_D4_B6 = 192;
    public static final int U_CARINFO_D1E_D4_B7 = 191;
    public static final int U_CARINF_EQ_ASL = 188;
    public static final int U_CARINF_EQ_BAL = 184;
    public static final int U_CARINF_EQ_BASS = 185;
    public static final int U_CARINF_EQ_FAD = 183;
    public static final int U_CARINF_EQ_MID = 187;
    public static final int U_CARINF_EQ_SUROUND = 190;
    public static final int U_CARINF_EQ_TREB = 186;
    public static final int U_CARINF_EQ_VOL = 189;
    public static final int U_CARSET_D26_D1_B3 = 198;
    public static final int U_CARSET_D26_D3_B10 = 200;
    public static final int U_CARSET_D26_D3_B54 = 199;
    public static final int U_CARSET_D26_D4_B10 = 204;
    public static final int U_CARSET_D26_D4_B32 = 203;
    public static final int U_CARSET_D26_D4_B4 = 202;
    public static final int U_CARSET_D26_D4_B65 = 201;
    public static final int U_CARSET_D26_D5_B30 = 206;
    public static final int U_CARSET_D26_D5_B54 = 205;
    public static final int U_CAR_CAMERA_LOUCS = 133;
    public static final int U_CAR_CAMERA_LOUCS_ENABLE = 134;
    public static final int U_CAR_EC_LEV = 197;
    public static final int U_CAR_PE_ENABLE = 99;
    public static final int U_CAR_PE_STATE = 100;
    public static final int U_CD_CURRENT_INDEX = 163;
    public static final int U_CD_CUR_DISC = 166;
    public static final int U_CD_CUR_INDEX = 169;
    public static final int U_CD_CUR_PLAYMODE = 167;
    public static final int U_CD_CUR_TIME = 171;
    public static final int U_CD_EXIST = 161;
    public static final int U_CD_MEDIA_STATE = 165;
    public static final int U_CD_STATE = 162;
    public static final int U_CD_TOTAL_INDEX = 168;
    public static final int U_CD_TOTAL_TIME = 170;
    public static final int U_CD_TYPE = 164;
    public static final int U_CLOSE_BIGLAMP_TIME = 119;
    public static final int U_CLOSE_INSIDELAMP_TIME = 118;
    public static final int U_CNT_MAX = 198;
    public static final int U_CUR_ENGINE_SPEED = 157;
    public static final int U_CUR_OIL_EXPEND = 104;
    public static final int U_CUR_SPEED = 158;
    public static final int U_CUR_TRIP_OIL_EXPEND = 105;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 116;
    public static final int U_DISPLAY_ENABLE_0 = 136;
    public static final int U_DISPLAY_ENABLE_1 = 137;
    public static final int U_DISPLAY_ENABLE_10 = 146;
    public static final int U_DISPLAY_ENABLE_11 = 147;
    public static final int U_DISPLAY_ENABLE_12 = 148;
    public static final int U_DISPLAY_ENABLE_13 = 149;
    public static final int U_DISPLAY_ENABLE_2 = 138;
    public static final int U_DISPLAY_ENABLE_3 = 139;
    public static final int U_DISPLAY_ENABLE_4 = 140;
    public static final int U_DISPLAY_ENABLE_5 = 141;
    public static final int U_DISPLAY_ENABLE_6 = 142;
    public static final int U_DISPLAY_ENABLE_7 = 143;
    public static final int U_DISPLAY_ENABLE_8 = 144;
    public static final int U_DISPLAY_ENABLE_9 = 145;
    public static final int U_DRIVING_MILEAGE = 103;
    public static final int U_DRIVING_TIME = 102;
    public static final int U_ENGINE_SPEED = 155;
    public static final int U_EXIST_TPMS = 107;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 132;
    public static final int U_JUMP_SOS_PAGE = 196;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 135;
    public static final int U_LAST_OIL = 154;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 124;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 129;
    public static final int U_PARK_BESIDE_ROAD = 156;
    public static final int U_PRESSURE_BACKUP = 115;
    public static final int U_PRESSURE_FL = 111;
    public static final int U_PRESSURE_FR = 112;
    public static final int U_PRESSURE_RL = 113;
    public static final int U_PRESSURE_RR = 114;
    public static final int U_REMOTE_2PRESS_UNLOCK = 123;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 117;
    public static final int U_SHOW_TIRE_BACKUP = 109;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 128;
    public static final int U_TIRE_SHOW_STATE = 110;
    public static final int U_TPMS_STATE = 108;
    public static final int U_TRIP_OIL_EXPEND = 106;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 126;
    public static final int U_UNLOCK_BY_SMART_DOOR = 127;
    public static final int U_WARNNING_CLEANNING_FLUID = 152;
    public static final int U_WARNNING_HANDLE_BRAKE = 153;
    public static final int U_WARNNING_LIFE_BELT = 151;
    public static final int U_WARNNING_LOW_BATTERY = 150;
    public static final int U_WARNNING_LOW_OIL = 130;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 198; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0020_XP1_Camry2013(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
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
        if (updateCode >= 0) {
            switch (updateCode) {
                case 106:
                    TripOilExpand(updateCode, ints);
                    break;
                case 135:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                case 196:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 198) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 196) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    private void TripOilExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 5) {
            ConstWcToyota.mTripoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void LastMinuteOldExpand(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            ConstWcToyota.mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
