package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0314_RZC_XP1_FengGuang360 extends CallbackCanbusBase {
    public static final int C_AIR_CMD = 0;
    public static final int U_CARINFO_BATTERY_STATE = 114;
    public static final int U_CARINFO_BEGIN = 102;
    public static final int U_CARINFO_BMS_STATE = 115;
    public static final int U_CARINFO_END = 116;
    public static final int U_CARINFO_REMAIN_ELEC = 113;
    public static final int U_CARINFO_TEMP_HIGH = 110;
    public static final int U_CARINFO_TEMP_HIGH_NUM = 112;
    public static final int U_CARINFO_TEMP_LOW = 109;
    public static final int U_CARINFO_TEMP_LOW_NUM = 111;
    public static final int U_CARINFO_TEMP_MOTOR = 103;
    public static final int U_CARINFO_TEMP_MOTOR_CTRL = 104;
    public static final int U_CARINFO_VOLTAGE_HIGH = 106;
    public static final int U_CARINFO_VOLTAGE_HIGH_NUM = 108;
    public static final int U_CARINFO_VOLTAGE_LOW = 105;
    public static final int U_CARINFO_VOLTAGE_LOW_NUM = 107;
    public static final int U_CARSET_BEGIN = 98;
    public static final int U_CARSET_CHARGE_LEV = 118;
    public static final int U_CARSET_CHARGE_LEV_LOCK = 119;
    public static final int U_CARSET_CHARGE_START_H = 135;
    public static final int U_CARSET_CHARGE_START_M = 136;
    public static final int U_CARSET_CHARGE_STOP_H = 137;
    public static final int U_CARSET_CHARGE_STOP_M = 138;
    public static final int U_CARSET_CYCLE_LEV = 99;
    public static final int U_CARSET_D29_D0B_B70 = 139;
    public static final int U_CARSET_D29_D0C_B70 = 140;
    public static final int U_CARSET_D29_D0D_B70 = 141;
    public static final int U_CARSET_D29_D0E_B70 = 142;
    public static final int U_CARSET_D29_D0F_B70 = 143;
    public static final int U_CARSET_D29_D10_B70 = 144;
    public static final int U_CARSET_D29_D11_B70 = 145;
    public static final int U_CARSET_D29_D12_B70 = 146;
    public static final int U_CARSET_D29_D13_B70 = 147;
    public static final int U_CARSET_D29_D14_B70 = 148;
    public static final int U_CARSET_D29_D7_B70 = 120;
    public static final int U_CARSET_D29_D8_B70 = 121;
    public static final int U_CARSET_D29_D9_B70 = 122;
    public static final int U_CARSET_D29_DA_B70 = 123;
    public static final int U_CARSET_D31_D0_B70 = 124;
    public static final int U_CARSET_D42_D0_B10 = 128;
    public static final int U_CARSET_D42_D0_B32 = 127;
    public static final int U_CARSET_D42_D0_B54 = 126;
    public static final int U_CARSET_D42_D0_B76 = 125;
    public static final int U_CARSET_D42_D1_B10 = 132;
    public static final int U_CARSET_D42_D1_B32 = 131;
    public static final int U_CARSET_D42_D1_B54 = 130;
    public static final int U_CARSET_D42_D1_B76 = 129;
    public static final int U_CARSET_D42_D2_B54 = 134;
    public static final int U_CARSET_D42_D2_B76 = 133;
    public static final int U_CARSET_END = 101;
    public static final int U_CARSET_HEADUP_SHOW = 100;
    public static final int U_CARSET_VSP_ONOFF = 117;
    public static final int U_CNT_MAX = 149;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 149; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0314_RZC_XP1_FengGuang580(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (DataCanbus.DATA[1000] == 2031930) {
            DataCanbus.NOTIFY_EVENTS[53].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 149) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
