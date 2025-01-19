package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0392_CYT_SHUPING_CAMARY extends CallbackCanbusBase {
    public static final int C_2TIMES_KEY_UNLOCK = 12;
    public static final int C_AIR_BY_AUTO_KEY = 17;
    public static final int C_AIR_CONTIRE_CMD = 22;
    public static final int C_AUTOLOCK_BY_SHIFT_FROM_P = 2;
    public static final int C_AUTOLOCK_BY_SHIFT_TO_P = 3;
    public static final int C_AUTOLOCK_BY_SPEED = 1;
    public static final int C_CAR_CAMERA_LOUCS = 21;
    public static final int C_CLEAR_LAST_N_MINUTE_OIL_EXPEND = 10;
    public static final int C_CLEAR_TRIP_OIL_EXPEND = 9;
    public static final int C_CLOSE_BIGLAMP_TIME = 7;
    public static final int C_CLOSE_INSIDELAMP_TIME = 11;
    public static final int C_DAYTIME_RUNNING_LIGHTS = 5;
    public static final int C_IN_OUT_AIR_BY_AUTO_KEY = 18;
    public static final int C_LOCK_UNLOCK_FEEDBACK_TONE = 6;
    public static final int C_LOCK_UNLOCK_LAMP_FLASH = 16;
    public static final int C_RADAR_VOL = 19;
    public static final int C_REMOTE_2PRESS_UNLOCK = 4;
    public static final int C_SENSITIVITY_OPEN_BIGLAMP = 0;
    public static final int C_SMARTLOCK_AND_ONE_KEY_BOOT = 15;
    public static final int C_UNLOCK_BY_DRIVERS_DOOR_OPEN = 13;
    public static final int C_UNLOCK_BY_SMART_DOOR = 14;
    public static final int C_UPDATE_TRIP_OIL_EXPEND = 8;
    public static final int DOOR_ALL = 0;
    public static final int DOOR_DRIVER = 1;
    public static final int U_CNT_MAX = 152;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 152; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 105:
                    TripOilExpand(updateCode, ints);
                    break;
                case 134:
                    LastMinuteOldExpand(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 152) {
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
