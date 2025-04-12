package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.xp.yinglang.GmConstData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0348_DAOJUN_XP1_ATS extends CallbackCanbusBase {
    public static final int U_2TIMES_KEY_UNLOCK = 112;
    public static final int U_ACTIVATE_AUTOMATICLLY = 106;
    public static final int U_AIR = 100;
    public static final int U_ANJIXING_PHONE_STATE = 116;
    public static final int U_ANJIXING_STATE = 117;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 110;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 111;
    public static final int U_AUTOLOCK_BY_SPEED = 109;
    public static final int U_CAR_SCREEN_BRIGHTNESS_MODE = 122;
    public static final int U_CNT_MAX = 137;
    public static final int U_CURRENT_SPEED = 133;
    public static final int U_CUR_OIL_EXPEND = 113;
    public static final int U_CUR_TRIP_OIL_EXPEND = 119;
    public static final int U_DISPLAY_ENABLE_0 = 136;
    public static final int U_DRIVER_ACC = 103;
    public static final int U_DRIVER_ALERT_SYSTEM = 105;
    public static final int U_DRIVER_LAST_DISTANCE_SELECTED = 104;
    public static final int U_DRIVING_MILEAGE = 114;
    public static final int U_DRIVING_TIME = 118;
    public static final int U_FRONT_VOL = 102;
    public static final int U_LIGHT_COMING_HOME = 126;
    public static final int U_LIGHT_LEAVING_HOME = 121;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 108;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 120;
    public static final int U_MIRROR_WIPERS_AUTO_WIPING_IN_RAIN = 134;
    public static final int U_MIRROR_WIPERS_SYN_ADJUST = 135;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 99;
    public static final int U_OPTIMAL_OIL_EXPEND = 115;
    public static final int U_RADAR_VOL = 127;
    public static final int U_REMOTE_2PRESS_UNLOCK = 107;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 98;
    public static final int U_SHOW_RADAR = 124;
    public static final int U_TPMS = 101;
    public static final int U_UNIT_TEMPERATURE = 128;
    public static final int U_UNLOCK_BY_DRIVERS_DOOR_OPEN = 123;
    public static final int U_WARNNING_CLEANNING_FLUID = 131;
    public static final int U_WARNNING_HANDLE_BRAKE = 132;
    public static final int U_WARNNING_LIFE_BELT = 130;
    public static final int U_WARNNING_LOW_BATTERY = 129;
    public static final int U_WARNNING_LOW_OIL = 125;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 137; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0348_XP1_GM_H(LauncherApplication.getInstance()));
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 116:
                if (strs != null && strs.length > 0) {
                    GmConstData.anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 137) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
