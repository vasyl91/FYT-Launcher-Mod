package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wc.gs4.GS4SOSAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0260_WC2_ChuangQiGa6;
//import com.syu.ui.air.Air_0289_WC2_ChuanQiGs3;
//import com.syu.ui.air.Air_0289_WC2_ChuanQiGs4;
import com.syu.ui.door.DoorHelper;

public class Callback_0289_WC2_ChuanQiGS4 extends CallbackCanbusBase {
    public static final int U_AUTOLOCK_BY_SHIFT_FROM_P = 118;
    public static final int U_AUTOLOCK_BY_SHIFT_TO_P = 119;
    public static final int U_AUTOLOCK_BY_SPEED = 116;
    public static final int U_AUTO_AC_ENABLED = 109;
    public static final int U_AVERAGE_SPEED = 103;
    public static final int U_CARINFO_LIGHT_ATMOSPHERE = 127;
    public static final int U_CARINFO_SOS = 126;
    public static final int U_CLOSE_BIGLAMP_TIME = 115;
    public static final int U_CLOSE_INSIDELAMP_TIME = 114;
    public static final int U_CNT_MAX = 144;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_TRIP_OIL_EXPEND = 106;
    public static final int U_DAYTIME_RUNING_LIGHTS_ON = 113;
    public static final int U_DISPLAY_ENABLE_0 = 101;
    public static final int U_DISPLAY_ENABLE_1 = 104;
    public static final int U_DISPLAY_ENABLE_2 = 105;
    public static final int U_DISPLAY_ENABLE_3 = 117;
    public static final int U_DRIVING_MILEAGE = 99;
    public static final int U_DRIVING_TIME = 102;
    public static final int U_ENERGY_BEGIN = 128;
    public static final int U_ENERGY_CHARGING_CYCLE_N1 = 136;
    public static final int U_ENERGY_CHARGING_CYCLE_N2 = 137;
    public static final int U_ENERGY_CHARGING_CYCLE_N3 = 138;
    public static final int U_ENERGY_CHARGING_CYCLE_N4 = 139;
    public static final int U_ENERGY_CHARGING_CYCLE_N5 = 140;
    public static final int U_ENERGY_CHARGING_CYCLE_N6 = 141;
    public static final int U_ENERGY_CHARGING_CYCLE_N7 = 142;
    public static final int U_ENERGY_CHARGING_CYCLE_ONOFF = 135;
    public static final int U_ENERGY_CHARGING_ENDTIME_H = 133;
    public static final int U_ENERGY_CHARGING_ENDTIME_M = 134;
    public static final int U_ENERGY_CHARGING_MODE = 130;
    public static final int U_ENERGY_CHARGING_STARTTIME_H = 131;
    public static final int U_ENERGY_CHARGING_STARTTIME_M = 132;
    public static final int U_ENERGY_CYCLE_MODE = 143;
    public static final int U_ENERGY_FLOW_MODE = 129;
    public static final int U_ENGINESPEED = 123;
    public static final int U_ENGINE_BEGIN = 123;
    public static final int U_ENGINE_END = 125;
    public static final int U_FEEDBACK_LAMP_ENABLED = 108;
    public static final int U_INSTANTANEOUSSPEED = 124;
    public static final int U_LOCK_UNLOCK_BLOW_TONE = 122;
    public static final int U_LOCK_UNLOCK_FEEDBACK_TONE = 121;
    public static final int U_MISC_END = 123;
    public static final int U_OPEN_BIGLAMP_BY_WIPER = 112;
    public static final int U_OPTIMAL_OIL_EXPEND = 100;
    public static final int U_REMOTE_2PRESS_UNLOCK = 120;
    public static final int U_SENSITIVITY_OPEN_BIGLAMP = 111;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 107;
    public static final int U_VALID_VENTILATION_ENABLED = 110;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 144; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 262433) {
            //AirHelper.getInstance().buildUi(new Air_0289_WC2_ChuanQiGs3(LauncherApplication.getInstance()));
        } else if (DataCanbus.DATA[1000] == 260 || DataCanbus.DATA[1000] == 65796 || DataCanbus.DATA[1000] == 131332) {
            //AirHelper.getInstance().buildUi(new Air_0260_WC2_ChuangQiGa6(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0289_WC2_ChuanQiGs4(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
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
        if (updateCode >= 0 && updateCode < 144) {
            switch (updateCode) {
                case 126:
                    showSoS(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
