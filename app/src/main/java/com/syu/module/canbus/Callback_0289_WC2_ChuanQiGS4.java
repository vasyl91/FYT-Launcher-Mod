package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wc.gs4.GS4SOSAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0289_WC2_ChuanQiGs3;
import com.syu.ui.air.Air_0289_WC2_ChuanQiGs4;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0289_WC2_ChuanQiGS4 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 30;
    public static final int U_AIR_AUTO = 26;
    public static final int U_AIR_BEGIN = 25;
    public static final int U_AIR_BLOW_AUTO_LEFT = 40;
    public static final int U_AIR_BLOW_BODY_LEFT = 32;
    public static final int U_AIR_BLOW_FOOT_LEFT = 33;
    public static final int U_AIR_BLOW_UP_LEFT = 34;
    public static final int U_AIR_CYCLE = 27;
    public static final int U_AIR_DUAL = 41;
    public static final int U_AIR_END = 44;
    public static final int U_AIR_FRONT_DEFROST = 28;
    public static final int U_AIR_ION = 43;
    public static final int U_AIR_MAX = 42;
    public static final int U_AIR_POWER = 39;
    public static final int U_AIR_REAR_DEFROST = 29;
    public static final int U_AIR_SEAT_HEAT_LEFT = 36;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 37;
    public static final int U_AIR_TEMP_LEFT = 31;
    public static final int U_AIR_TEMP_RIGHT = 38;
    public static final int U_AIR_WIND_LEVEL_LEFT = 35;
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 20;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 21;
    public static final int U_AUTOLOCK_BY_SPEED = 18;
    public static final int U_AUTO_AC_ENABLED = 11;
    public static final int U_AVERAGE_SPEED = 5;
    public static final int U_CARINFO_LIGHT_ATMOSPHERE = 54;
    public static final int U_CARINFO_SOS = 53;
    public static final int U_CLOSE_BIGLAMP_TIME = 17;
    public static final int U_CLOSE_INSIDELAMP_TIME = 16;
    public static final int U_CNT_MAX = 71;
    public static final int U_CUR_OIL_EXPEND = 0;
    public static final int U_CUR_TRIP_OIL_EXPEND = 8;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 15;
    public static final int U_DISPLAY_ENABLE_0 = 3;
    public static final int U_DISPLAY_ENABLE_1 = 6;
    public static final int U_DISPLAY_ENABLE_2 = 7;
    public static final int U_DISPLAY_ENABLE_3 = 19;
    public static final int U_DOOR_BACK = 49;
    public static final int U_DOOR_BEGIN = 44;
    public static final int U_DOOR_END = 50;
    public static final int U_DOOR_ENGINE = 44;
    public static final int U_DOOR_FL = 45;
    public static final int U_DOOR_FR = 46;
    public static final int U_DOOR_RL = 47;
    public static final int U_DOOR_RR = 48;
    public static final int U_DRIVING_MILEAGE = 1;
    public static final int U_DRIVING_TIME = 4;
    public static final int U_ENERGY_BEGIN = 55;
    public static final int U_ENERGY_CHARGING_CYCLE_N1 = 63;
    public static final int U_ENERGY_CHARGING_CYCLE_N2 = 64;
    public static final int U_ENERGY_CHARGING_CYCLE_N3 = 65;
    public static final int U_ENERGY_CHARGING_CYCLE_N4 = 66;
    public static final int U_ENERGY_CHARGING_CYCLE_N5 = 67;
    public static final int U_ENERGY_CHARGING_CYCLE_N6 = 68;
    public static final int U_ENERGY_CHARGING_CYCLE_N7 = 69;
    public static final int U_ENERGY_CHARGING_CYCLE_ONOFF = 62;
    public static final int U_ENERGY_CHARGING_ENDTIME_H = 60;
    public static final int U_ENERGY_CHARGING_ENDTIME_M = 61;
    public static final int U_ENERGY_CHARGING_MODE = 57;
    public static final int U_ENERGY_CHARGING_STARTTIME_H = 58;
    public static final int U_ENERGY_CHARGING_STARTTIME_M = 59;
    public static final int U_ENERGY_CYCLE_MODE = 70;
    public static final int U_ENERGY_FLOW_MODE = 56;
    public static final int U_ENGINESPEED = 50;
    public static final int U_ENGINE_BEGIN = 50;
    public static final int U_ENGINE_END = 52;
    public static final int U_FEEDBACK_LAMP_ENABLED = 10;
    public static final int U_INSTANTANEOUSSPEED = 51;
    public static final int U_LOCK_UNLOCK_BLOW_TONE = 24;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 23;
    public static final int U_MISC_END = 25;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 14;
    public static final int U_OPTIMAL_OIL_EXPEND = 2;
    public static final int U_REMOTE_2PRESS_UNLOCK = 22;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 13;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 9;
    public static final int U_VALID_VENTILATION_ENABLED = 12;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 71; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 44;
        DoorHelper.sUcDoorFl = 45;
        DoorHelper.sUcDoorFr = 46;
        DoorHelper.sUcDoorRl = 47;
        DoorHelper.sUcDoorRr = 48;
        DoorHelper.sUcDoorBack = 49;
        if (DataCanbus.DATA[1000] == 262433) {
            AirHelper.getInstance().buildUi(new Air_0289_WC2_ChuanQiGs3(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0289_WC2_ChuanQiGs4(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 44; i2 < 50; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 25; i3 < 44; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    private void showSoS(int updateCode, int[] ints) {
        HandlerCanbus.update(updateCode, ints);
        int value = ints[0];
        if ((value == 1 || value == 2) && !GS4SOSAct.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.gs4.GS4SOSAct");
        } else if (GS4SOSAct.mIsFront && value == 0 && GS4SOSAct.mIsFront && GS4SOSAct.mInstance != null) {
            GS4SOSAct.mInstance.finish();
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 44; i < 50; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 25; i2 < 44; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 71) {
            switch (updateCode) {
                case 53:
                    showSoS(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
