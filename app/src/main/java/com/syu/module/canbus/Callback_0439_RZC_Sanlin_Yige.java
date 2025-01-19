package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_Sanlin_Yige extends CallbackCanbusBase {
    public static final int U_CAREQ_D17_D0_B70 = 133;
    public static final int U_CAREQ_D17_D10_B70 = 143;
    public static final int U_CAREQ_D17_D11_B70 = 144;
    public static final int U_CAREQ_D17_D12_B70 = 145;
    public static final int U_CAREQ_D17_D13_B70 = 146;
    public static final int U_CAREQ_D17_D1_B70 = 134;
    public static final int U_CAREQ_D17_D2_B70 = 135;
    public static final int U_CAREQ_D17_D3_B70 = 136;
    public static final int U_CAREQ_D17_D4_B70 = 137;
    public static final int U_CAREQ_D17_D5_B70 = 138;
    public static final int U_CAREQ_D17_D6_B70 = 139;
    public static final int U_CAREQ_D17_D7_B70 = 140;
    public static final int U_CAREQ_D17_D8_B70 = 141;
    public static final int U_CAREQ_D17_D9_B70 = 142;
    public static final int U_CARINFO_AVG_FUEL_AUTO = 102;
    public static final int U_CARINFO_AVG_FUEL_HAND = 103;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_CUR_FUEL = 101;
    public static final int U_CARINFO_MILE_DRIVENABLE = 100;
    public static final int U_CARINFO_UNIT = 99;
    public static final int U_CARINF_D41_D0_D3 = 147;
    public static final int U_CARINF_D41_D4_D5 = 148;
    public static final int U_CARINF_D41_D6_D7 = 149;
    public static final int U_CARSAT_AIR_CONDITIONER_1 = 124;
    public static final int U_CARSAT_AIR_CONDITIONER_2 = 125;
    public static final int U_CARSAT_AIR_CONDITIONER_3 = 126;
    public static final int U_CARSAT_AIR_CONDITIONER_4 = 127;
    public static final int U_CARSAT_AIR_CONDITIONER_5 = 128;
    public static final int U_CARSAT_AIR_CONDITIONER_6 = 129;
    public static final int U_CARSAT_DOOR_LOCK_1 = 121;
    public static final int U_CARSAT_DOOR_LOCK_2 = 122;
    public static final int U_CARSAT_DOOR_LOCK_3 = 123;
    public static final int U_CARSAT_KEYLESS_1 = 105;
    public static final int U_CARSAT_KEYLESS_2 = 106;
    public static final int U_CARSAT_KEYLESS_3 = 107;
    public static final int U_CARSAT_LIGHTS_1 = 113;
    public static final int U_CARSAT_LIGHTS_2 = 114;
    public static final int U_CARSAT_LIGHTS_3 = 115;
    public static final int U_CARSAT_LIGHTS_4 = 116;
    public static final int U_CARSAT_LIGHTS_5 = 117;
    public static final int U_CARSAT_OTHER_1 = 130;
    public static final int U_CARSAT_OTHER_2 = 131;
    public static final int U_CARSAT_OTHER_3 = 132;
    public static final int U_CARSAT_TOUCH_SENSE = 104;
    public static final int U_CARSAT_TUM_SIGNAL_1 = 118;
    public static final int U_CARSAT_TUM_SIGNAL_2 = 119;
    public static final int U_CARSAT_TUM_SIGNAL_3 = 120;
    public static final int U_CARSAT_WIPERS_1 = 108;
    public static final int U_CARSAT_WIPERS_2 = 109;
    public static final int U_CARSAT_WIPERS_3 = 110;
    public static final int U_CARSAT_WIPERS_4 = 111;
    public static final int U_CARSAT_WIPERS_5 = 112;
    public static final int U_CNT_MAX = 150;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 150; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 <= 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0439_RZC_Sanlin_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i <= 5; i++) {
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
        if (updateCode >= 0 && updateCode < 150) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
