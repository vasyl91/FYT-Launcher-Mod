package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0121_WC2_14Prado extends CallbackCanbusBase {
    public static final int MINUTEOILEXPENDMAX = 15;
    public static final int U_2TIMES_KEY_UNLOCK = 7;
    public static final int U_AIR_AC_ON = 59;
    public static final int U_AIR_AUTO_ON = 63;
    public static final int U_AIR_BACK_POWER_ON = 58;
    public static final int U_AIR_BEGIN = 40;
    public static final int U_AIR_BEGIN1 = 58;
    public static final int U_AIR_BLOW_AUTO_LEFT = 68;
    public static final int U_AIR_BLOW_BODY_LEFT = 66;
    public static final int U_AIR_BLOW_BODY_REAR = 73;
    public static final int U_AIR_BLOW_FOOT_LEFT = 67;
    public static final int U_AIR_BLOW_FOOT_REAR = 74;
    public static final int U_AIR_BLOW_UP_LEFT = 65;
    public static final int U_AIR_BY_AUTO_KEY = 18;
    public static final int U_AIR_CYCLE_TYPE = 62;
    public static final int U_AIR_DUAL_ON = 61;
    public static final int U_AIR_END = 51;
    public static final int U_AIR_END1 = 82;
    public static final int U_AIR_FACE_BLOW = 77;
    public static final int U_AIR_FRONT_DEFROST = 64;
    public static final int U_AIR_FRONT_POWER_ON = 60;
    public static final int U_AIR_REAR_DEFROST = 72;
    public static final int U_AIR_REAR_SHOW = 78;
    public static final int U_AIR_TEMP_LEFT = 70;
    public static final int U_AIR_TEMP_LEFT_REAR = 75;
    public static final int U_AIR_TEMP_REAR = 81;
    public static final int U_AIR_TEMP_RIGHT = 71;
    public static final int U_AIR_WIND_LEVEL_LEFT = 69;
    public static final int U_AIR_WIND_LEVEL_REAR = 76;
    public static final int U_AIR_WIND_MODE = 79;
    public static final int U_AIR_WIND_MODE_REAR = 80;
    public static final int U_AVERAGE_SPEED = 2;
    public static final int U_CLOSE_BIGLAMP_TIME = 19;
    public static final int U_CLOSE_INSIDELAMP_TIME = 4;
    public static final int U_CNT_MAX = 85;
    public static final int U_CURRENT_SPEED = 20;
    public static final int U_CUR_OIL_EXPEND = 0;
    public static final int U_CUR_SPEED = 83;
    public static final int U_DOOR_BACK = 57;
    public static final int U_DOOR_BEGIN = 52;
    public static final int U_DOOR_END = 58;
    public static final int U_DOOR_ENGINE = 52;
    public static final int U_DOOR_FL = 53;
    public static final int U_DOOR_FR = 54;
    public static final int U_DOOR_RL = 55;
    public static final int U_DOOR_RR = 56;
    public static final int U_DRIVING_MILEAGE = 1;
    public static final int U_DRIVING_TIME = 3;
    public static final int U_DSP_SURROUND = 22;
    public static final int U_DSP_VOL_LINK_SPEED = 21;
    public static final int U_ENGINE_SPEED = 84;
    public static final int U_FRONT_RADAR_DISTANCE = 15;
    public static final int U_IN_OUT_AIR_BY_AUTO_KEY = 17;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 11;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 8;
    public static final int U_OPTIMAL_OIL_EXPEND = 12;
    public static final int U_RADAR_VOL = 14;
    public static final int U_REAR_RADAR_DISTANCE = 16;
    public static final int U_REMOTE_2PRESS_UNLOCK = 5;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 6;
    public static final int U_SHOW_RADAR = 13;
    public static final int U_SMARTLOCK_AND_ONE_KEY_BOOT = 10;
    public static final int U_UNLOCK_BY_SMART_DOOR = 9;
    public static int[][] mMinuteoilexpend = new int[15][];

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 85; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 52;
        DoorHelper.sUcDoorFl = 53;
        DoorHelper.sUcDoorFr = 54;
        DoorHelper.sUcDoorRl = 55;
        DoorHelper.sUcDoorRr = 56;
        DoorHelper.sUcDoorBack = 57;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 52; i2 < 58; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 40; i3 < 51; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 52; i < 58; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 40; i2 < 51; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 11:
                    lastMinoldexpend(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 85) {
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
