package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0238_RZC4_C5 extends CallbackCanbusBase {
    public static final int C_2TIMES_KEY_UNLOCK = 17;
    public static final int C_AC = 30;
    public static final int C_AC_MAX = 31;
    public static final int C_AIR_BY_AUTO_KEY = 22;
    public static final int C_AUTO = 32;
    public static final int C_AUTOLOCK_BY_SHIFT_FROM_P = 10;
    public static final int C_AUTOLOCK_BY_SHIFT_TO_P = 11;
    public static final int C_AUTOLOCK_BY_SPEED = 9;
    public static final int C_BLOW_BODY = 37;
    public static final int C_BLOW_FOOT = 38;
    public static final int C_BLOW_WIN = 36;
    public static final int C_CLOSE_BIGLAMP_TIME = 16;
    public static final int C_CLOSE_INSIDELAMP_TIME = 15;
    public static final int C_CRUISE_SPEED_FIVE_VALUE = 55;
    public static final int C_CRUISE_SPEED_RESET = 50;
    public static final int C_IN_OUT_AIR_BY_AUTO_KEY = 23;
    public static final int C_LOCK_UNLOCK_FEEDBACK_TONE = 14;
    public static final int C_LOCK_UNLOCK_LAMP_FLASH = 21;
    public static final int C_MONO = 43;
    public static final int C_RADAR_DISTANCE = 26;
    public static final int C_RADAR_VOL = 25;
    public static final int C_REMOTE_2PRESS_UNLOCK = 12;
    public static final int C_REQUEST_OIL_INFO_1 = 70;
    public static final int C_REQUEST_OIL_INFO_2 = 71;
    public static final int C_REQUEST_OIL_INFO_3 = 72;
    public static final int C_SHOW_RADAR = 24;
    public static final int C_SMARTLOCK_AND_ONE_KEY_BOOT = 20;
    public static final int C_SPEED_LIMIT_FIVE_VALUE = 64;
    public static final int C_SPEED_LIMIT_FOUR_VALUE = 63;
    public static final int C_SPEED_LIMIT_ONE_VALUE = 60;
    public static final int C_SPEED_LIMIT_SIX_VALUE = 65;
    public static final int C_SPEED_LIMIT_THREE_VALUE = 62;
    public static final int C_SPEED_LIMIT_TWO_VALUE = 61;
    public static final int C_TEMPERATURE_LEFT = 40;
    public static final int C_TEMPERATURE_RIGHT = 41;
    public static final int C_UNLOCK_BY_DRIVERS_DOOR_OPEN = 18;
    public static final int C_UNLOCK_BY_SMART_DOOR = 19;
    public static final int C_WIND_LEVEL = 42;
    public static final int C_WIND_RATE = 39;
    public static final int U_AIR_AC = 87;
    public static final int U_AIR_ACMAX = 100;
    public static final int U_AIR_AMB = 103;
    public static final int U_AIR_AUTO = 83;
    public static final int U_AIR_BEGIN = 82;
    public static final int U_AIR_BLOW_AUTO_LEFT = 98;
    public static final int U_AIR_BLOW_BODY_LEFT = 89;
    public static final int U_AIR_BLOW_FOOT_LEFT = 90;
    public static final int U_AIR_BLOW_UP_LEFT = 91;
    public static final int U_AIR_CYCLE = 84;
    public static final int U_AIR_DUAL = 93;
    public static final int U_AIR_ECO = 96;
    public static final int U_AIR_END = 104;
    public static final int U_AIR_FRONT_DEFROST = 85;
    public static final int U_AIR_HYAC = 102;
    public static final int U_AIR_MONO = 101;
    public static final int U_AIR_POWER = 95;
    public static final int U_AIR_REAR_DEFROST = 86;
    public static final int U_AIR_SYNC = 99;
    public static final int U_AIR_TEMP_LEFT = 88;
    public static final int U_AIR_TEMP_RIGHT = 94;
    public static final int U_AIR_TEMP_UNIT = 97;
    public static final int U_AIR_WIND_LEVEL_LEFT = 92;
    public static final int U_CNT_MAX = 110;
    public static final int U_DOOR_BACK = 109;
    public static final int U_DOOR_BEGIN = 104;
    public static final int U_DOOR_END = 110;
    public static final int U_DOOR_ENGINE = 104;
    public static final int U_DOOR_FL = 105;
    public static final int U_DOOR_FR = 106;
    public static final int U_DOOR_RL = 107;
    public static final int U_DOOR_RR = 108;
    public static final int U_EXIST_EDOOR_BACK = 27;
    public static int mSum = -1;
    public static int mCurrPage = -1;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 110; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 104;
        DoorHelper.sUcDoorFl = 105;
        DoorHelper.sUcDoorFr = 106;
        DoorHelper.sUcDoorRl = 107;
        DoorHelper.sUcDoorRr = 108;
        DoorHelper.sUcDoorBack = 109;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 104; i2 < 110; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 104; i < 110; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 110) {
            if (updateCode == 18) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[18];
                if (value == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMileIndexActi");
                    return;
                } else {
                    if (value == 0 && PSAOilMileIndexActi.mIsFront && PSAOilMileIndexActi.mInstance != null) {
                        PSAOilMileIndexActi.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
