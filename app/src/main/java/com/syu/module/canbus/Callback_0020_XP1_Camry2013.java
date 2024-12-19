package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0020_XP1_Camry2013;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0020_XP1_Camry2013 extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 113;
    public static final int U_AIR_BY_AUTO_KEY = 119;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 109;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 110;
    public static final int U_AUTOLOCK_BY_SPEED = 108;
    public static final int U_AVERAGE_SPEED = 89;
    public static final int U_BATTERY_VOLTAGE = 86;
    public static final int U_BELT_LEFT = 147;
    public static final int U_BELT_RIGHT = 148;
    public static final int U_CARINFO_D1E_D4_B20 = 183;
    public static final int U_CARINFO_D1E_D4_B4 = 182;
    public static final int U_CARINFO_D1E_D4_B5 = 181;
    public static final int U_CARINFO_D1E_D4_B6 = 180;
    public static final int U_CARINFO_D1E_D4_B7 = 179;
    public static final int U_CARINF_EQ_ASL = 176;
    public static final int U_CARINF_EQ_BAL = 172;
    public static final int U_CARINF_EQ_BASS = 173;
    public static final int U_CARINF_EQ_FAD = 171;
    public static final int U_CARINF_EQ_MID = 175;
    public static final int U_CARINF_EQ_SUROUND = 178;
    public static final int U_CARINF_EQ_TREB = 174;
    public static final int U_CARINF_EQ_VOL = 177;
    public static final int U_CARSET_D26_D1_B3 = 186;
    public static final int U_CARSET_D26_D3_B10 = 188;
    public static final int U_CARSET_D26_D3_B54 = 187;
    public static final int U_CARSET_D26_D4_B10 = 192;
    public static final int U_CARSET_D26_D4_B32 = 191;
    public static final int U_CARSET_D26_D4_B4 = 190;
    public static final int U_CARSET_D26_D4_B65 = 189;
    public static final int U_CARSET_D26_D5_B30 = 194;
    public static final int U_CARSET_D26_D5_B54 = 193;
    public static final int U_CAR_CAMERA_LOUCS = 121;
    public static final int U_CAR_CAMERA_LOUCS_ENABLE = 122;
    public static final int U_CAR_EC_LEV = 185;
    public static final int U_CAR_PE_ENABLE = 87;
    public static final int U_CAR_PE_STATE = 88;
    public static final int U_CD_CURRENT_INDEX = 151;
    public static final int U_CD_CUR_DISC = 154;
    public static final int U_CD_CUR_INDEX = 157;
    public static final int U_CD_CUR_PLAYMODE = 155;
    public static final int U_CD_CUR_TIME = 159;
    public static final int U_CD_EXIST = 149;
    public static final int U_CD_MEDIA_STATE = 153;
    public static final int U_CD_STATE = 150;
    public static final int U_CD_TOTAL_INDEX = 156;
    public static final int U_CD_TOTAL_TIME = 158;
    public static final int U_CD_TYPE = 152;
    public static final int U_CLOSE_BIGLAMP_TIME = 107;
    public static final int U_CLOSE_INSIDELAMP_TIME = 106;
    public static final int U_CNT_MAX = 186;
    public static final int U_CUR_ENGINE_SPEED = 145;
    public static final int U_CUR_OIL_EXPEND = 92;
    public static final int U_CUR_SPEED = 146;
    public static final int U_CUR_TRIP_OIL_EXPEND = 93;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 104;
    public static final int U_DISPLAY_ENABLE_0 = 124;
    public static final int U_DISPLAY_ENABLE_1 = 125;
    public static final int U_DISPLAY_ENABLE_10 = 134;
    public static final int U_DISPLAY_ENABLE_11 = 135;
    public static final int U_DISPLAY_ENABLE_12 = 136;
    public static final int U_DISPLAY_ENABLE_13 = 137;
    public static final int U_DISPLAY_ENABLE_2 = 126;
    public static final int U_DISPLAY_ENABLE_3 = 127;
    public static final int U_DISPLAY_ENABLE_4 = 128;
    public static final int U_DISPLAY_ENABLE_5 = 129;
    public static final int U_DISPLAY_ENABLE_6 = 130;
    public static final int U_DISPLAY_ENABLE_7 = 131;
    public static final int U_DISPLAY_ENABLE_8 = 132;
    public static final int U_DISPLAY_ENABLE_9 = 133;
    public static final int U_DRIVING_MILEAGE = 91;
    public static final int U_DRIVING_TIME = 90;
    public static final int U_ENGINE_SPEED = 143;
    public static final int U_EXIST_TPMS = 95;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 120;
    public static final int U_JUMP_SOS_PAGE = 184;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 123;
    public static final int U_LAST_OIL = 142;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 112;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 117;
    public static final int U_PARK_BESIDE_ROAD = 144;
    public static final int U_PRESSURE_BACKUP = 103;
    public static final int U_PRESSURE_FL = 99;
    public static final int U_PRESSURE_FR = 100;
    public static final int U_PRESSURE_RL = 101;
    public static final int U_PRESSURE_RR = 102;
    public static final int U_REMOTE_2PRESS_UNLOCK = 111;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 105;
    public static final int U_SHOW_TIRE_BACKUP = 97;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 116;
    public static final int U_TIRE_SHOW_STATE = 98;
    public static final int U_TPMS_STATE = 96;
    public static final int U_TRIP_OIL_EXPEND = 94;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 114;
    public static final int U_UNLOCK_BY_SMART_DOOR = 115;
    public static final int U_WARNNING_CLEANNING_FLUID = 140;
    public static final int U_WARNNING_HANDLE_BRAKE = 141;
    public static final int U_WARNNING_LIFE_BELT = 139;
    public static final int U_WARNNING_LOW_BATTERY = 138;
    public static final int U_WARNNING_LOW_OIL = 118;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 213; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0020_XP1_Camry2013(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0) {
            switch (updateCode) {
                case 94:
                    TripOilExpand(updateCode, ints);
                    break;
                case 123:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                case 184:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 213) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 184) {
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
