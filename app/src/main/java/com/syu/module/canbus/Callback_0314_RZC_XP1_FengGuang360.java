package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0314_RZC_XP1_FengGuang580;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0314_RZC_XP1_FengGuang360 extends CallbackCanbusBase {
    public static final int C_AIR_CMD = 0;
    public static final int U_CARINFO_BATTERY_STATE = 102;
    public static final int U_CARINFO_BEGIN = 90;
    public static final int U_CARINFO_BMS_STATE = 103;
    public static final int U_CARINFO_END = 104;
    public static final int U_CARINFO_REMAIN_ELEC = 101;
    public static final int U_CARINFO_TEMP_HIGH = 98;
    public static final int U_CARINFO_TEMP_HIGH_NUM = 100;
    public static final int U_CARINFO_TEMP_LOW = 97;
    public static final int U_CARINFO_TEMP_LOW_NUM = 99;
    public static final int U_CARINFO_TEMP_MOTOR = 91;
    public static final int U_CARINFO_TEMP_MOTOR_CTRL = 92;
    public static final int U_CARINFO_VOLTAGE_HIGH = 94;
    public static final int U_CARINFO_VOLTAGE_HIGH_NUM = 96;
    public static final int U_CARINFO_VOLTAGE_LOW = 93;
    public static final int U_CARINFO_VOLTAGE_LOW_NUM = 95;
    public static final int U_CARSET_BEGIN = 86;
    public static final int U_CARSET_CHARGE_LEV = 106;
    public static final int U_CARSET_CHARGE_LEV_LOCK = 107;
    public static final int U_CARSET_CHARGE_START_H = 123;
    public static final int U_CARSET_CHARGE_START_M = 124;
    public static final int U_CARSET_CHARGE_STOP_H = 125;
    public static final int U_CARSET_CHARGE_STOP_M = 126;
    public static final int U_CARSET_CYCLE_LEV = 87;
    public static final int U_CARSET_D29_D0B_B70 = 127;
    public static final int U_CARSET_D29_D0C_B70 = 128;
    public static final int U_CARSET_D29_D0D_B70 = 129;
    public static final int U_CARSET_D29_D0E_B70 = 130;
    public static final int U_CARSET_D29_D0F_B70 = 131;
    public static final int U_CARSET_D29_D10_B70 = 132;
    public static final int U_CARSET_D29_D11_B70 = 133;
    public static final int U_CARSET_D29_D12_B70 = 134;
    public static final int U_CARSET_D29_D13_B70 = 135;
    public static final int U_CARSET_D29_D14_B70 = 136;
    public static final int U_CARSET_D29_D7_B70 = 108;
    public static final int U_CARSET_D29_D8_B70 = 109;
    public static final int U_CARSET_D29_D9_B70 = 110;
    public static final int U_CARSET_D29_DA_B70 = 111;
    public static final int U_CARSET_D31_D0_B70 = 112;
    public static final int U_CARSET_D42_D0_B10 = 116;
    public static final int U_CARSET_D42_D0_B32 = 115;
    public static final int U_CARSET_D42_D0_B54 = 114;
    public static final int U_CARSET_D42_D0_B76 = 113;
    public static final int U_CARSET_D42_D1_B10 = 120;
    public static final int U_CARSET_D42_D1_B32 = 119;
    public static final int U_CARSET_D42_D1_B54 = 118;
    public static final int U_CARSET_D42_D1_B76 = 117;
    public static final int U_CARSET_D42_D2_B54 = 122;
    public static final int U_CARSET_D42_D2_B76 = 121;
    public static final int U_CARSET_END = 89;
    public static final int U_CARSET_HEADUP_SHOW = 88;
    public static final int U_CARSET_VSP_ONOFF = 105;
    public static final int U_CNT_MAX = 137;

    @Override // com.syu.module.canbus.CallbackCanbusBase
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
        AirHelper.getInstance().buildUi(new Air_0314_RZC_XP1_FengGuang580(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (DataCanbus.DATA[1000] == 2031930) {
            DataCanbus.NOTIFY_EVENTS[53].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        DataCanbus.NOTIFY_EVENTS[53].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 137) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
