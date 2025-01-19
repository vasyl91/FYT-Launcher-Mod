package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0121_WC2_14Prado extends CallbackCanbusBase {
    public static final int MINUTEOILEXPENDMAX = 15;
    public static final int U_2TIMES_KEY_UNLOCK = 105;
    public static final int U_AIR_BY_AUTO_KEY = 116;
    public static final int U_AVERAGE_SPEED = 100;
    public static final int U_CLOSE_BIGLAMP_TIME = 117;
    public static final int U_CLOSE_INSIDELAMP_TIME = 102;
    public static final int U_CNT_MAX = 123;
    public static final int U_CURRENT_SPEED = 118;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_SPEED = 121;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_DRIVING_TIME = 101;
    public static final int U_DSP_SURROUND = 120;
    public static final int U_DSP_VOL_LINK_SPEED = 119;
    public static final int U_ENGINE_SPEED = 122;
    public static final int U_FRONT_RADAR_DISTANCE = 113;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 115;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 109;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 106;
    public static final int U_OPTIMAL_OIL_EXPEND = 110;
    public static final int U_RADAR_VOL = 112;
    public static final int U_REAR_RADAR_DISTANCE = 114;
    public static final int U_REMOTE_2PRESS_UNLOCK = 103;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 104;
    public static final int U_SHOW_RADAR = 111;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 108;
    public static final int U_UNLOCK_BY_SMART_DOOR = 107;
    public static int[][] mMinuteoilexpend = new int[15][];

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 123; i++) {
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
                case 109:
                    lastMinoldexpend(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 123) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void lastMinoldexpend(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 15) {
            mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
