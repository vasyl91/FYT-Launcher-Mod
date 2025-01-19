package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_LUZ_Toyato_All extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 110;
    public static final int U_AIR_BY_AUTO_KEY = 116;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 106;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 107;
    public static final int U_AUTOLOCK_BY_SPEED = 105;
    public static final int U_AVERAGE_SPEED = 152;
    public static final int U_CARAIR_CTRL_TYPE = 144;
    public static final int U_CARAUX_CTRL_TYPE = 143;
    public static final int U_CARINFO_AUTO_RELOCK_TIME = 120;
    public static final int U_CARINF_EQ_ASL = 133;
    public static final int U_CARINF_EQ_BAL = 129;
    public static final int U_CARINF_EQ_BASS = 130;
    public static final int U_CARINF_EQ_FAD = 128;
    public static final int U_CARINF_EQ_MID = 132;
    public static final int U_CARINF_EQ_POS = 146;
    public static final int U_CARINF_EQ_SUROUND = 135;
    public static final int U_CARINF_EQ_TREB = 131;
    public static final int U_CARINF_EQ_VOL = 134;
    public static final int U_CARINF_SYSEQ_VOL = 136;
    public static final int U_CARSET_D26_D4_B65 = 159;
    public static final int U_CARSET_OIL_UNIT = 150;
    public static final int U_CAR_ALLSCREEN_ON = 160;
    public static final int U_CAR_ANDROID_UI_VOL = 145;
    public static final int U_CAR_BELT_STATE = 137;
    public static final int U_CAR_CAMERA_LOUCS = 118;
    public static final int U_CAR_HANDBRAKE_STATE = 138;
    public static final int U_CAR_LIGHT_D99_D0_B7 = 153;
    public static final int U_CAR_LIGHT_D99_D1_B70 = 154;
    public static final int U_CAR_LIGHT_D99_D2_B70 = 155;
    public static final int U_CAR_LIGHT_D99_D3_B70 = 156;
    public static final int U_CAR_LIGHT_D99_D4_B70 = 157;
    public static final int U_CAR_LIGHT_FAR = 139;
    public static final int U_CAR_REARSCREEN_LOCK = 148;
    public static final int U_CAR_SCREEN_H = 141;
    public static final int U_CAR_SCREEN_W = 140;
    public static final int U_CAR_SET_TYPE = 147;
    public static final int U_CAR_UI_VOL = 142;
    public static final int U_CLOSE_BIGLAMP_TIME = 104;
    public static final int U_CLOSE_INSIDELAMP_TIME = 103;
    public static final int U_CNT_MAX = 161;
    public static final int U_CUR_OIL_EXPEND = 149;
    public static final int U_CUR_TRIP_OIL_EXPEND = 99;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 101;
    public static final int U_DRIVING_MILEAGE = 98;
    public static final int U_DRIVING_TIME = 151;
    public static final int U_INFO_CAR_AIR_INOUT_SENSOR = 121;
    public static final int U_INFO_CAR_DRIVE_MILEAGE = 124;
    public static final int U_INFO_CAR_SEAT_AUTO = 122;
    public static final int U_INFO_CAR_TOTAL_MILEAGE = 123;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 117;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 119;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 109;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 114;
    public static final int U_RADARR_ONOFF = 126;
    public static final int U_RADARR_VOL_LEV = 127;
    public static final int U_RADAR_REAR_DISTANCE = 125;
    public static final int U_REMOTE_2PRESS_UNLOCK = 108;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 102;
    public static final int U_SHOW_AIRMODE = 158;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 113;
    public static final int U_TRIP_OIL_EXPEND = 100;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 111;
    public static final int U_UNLOCK_BY_SMART_DOOR = 112;
    public static final int U_WARNNING_LOW_OIL = 115;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 161; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] != 2621894 && DataCanbus.DATA[1000] != 15204806 && DataCanbus.DATA[1000] != 3211719 && DataCanbus.DATA[1000] != 1114567 && DataCanbus.DATA[1000] != 1180103 && DataCanbus.DATA[1000] != 16187846 && DataCanbus.DATA[1000] != 14942662 && DataCanbus.DATA[1000] != 16253382 && DataCanbus.DATA[1000] != 16318918 && DataCanbus.DATA[1000] != 16384454 && DataCanbus.DATA[1000] != 14877126 && DataCanbus.DATA[1000] != 15073734 && DataCanbus.DATA[1000] != 65991) {
            //AirHelper.getInstance().buildUi(new Air_0439_Luz_Toyota_All(LauncherApplication.getInstance()));
            for (int i2 = 10; i2 < 97; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
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
                case 100:
                    TripOilExpand(updateCode, ints);
                    break;
                case 119:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 161) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
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
