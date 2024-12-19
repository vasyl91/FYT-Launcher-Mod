package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_Feiyate_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_Fieyate_All extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 86;
    public static final int U_CARINFO_END = 98;
    public static final int U_CARINFO_TRIPA_AVG_OIL = 90;
    public static final int U_CARINFO_TRIPA_AVG_SPEEDL = 91;
    public static final int U_CARINFO_TRIPA_DRIVED_TIME = 93;
    public static final int U_CARINFO_TRIPA_TOTAL_MILE = 92;
    public static final int U_CARINFO_TRIPB_AVG_OIL = 94;
    public static final int U_CARINFO_TRIPB_AVG_SPEEDL = 95;
    public static final int U_CARINFO_TRIPB_DRIVED_TIME = 97;
    public static final int U_CARINFO_TRIPB_TOTAL_MILE = 96;
    public static final int U_CARINFO_TRIP_CUR_OIL = 87;
    public static final int U_CARINFO_TRIP_DRIVENABLE_OIL = 88;
    public static final int U_CARINFO_TRIP_TOTAL_MILE = 89;
    public static final int U_CARSET_BEGIN = 99;
    public static final int U_CARSET_CORERING_LIGHTS = 110;
    public static final int U_CARSET_COURTESYLIGHT_DELAY = 115;
    public static final int U_CARSET_COURTESY_LIGHTS = 111;
    public static final int U_CARSET_D76_D0_B20 = 141;
    public static final int U_CARSET_D76_D0_B7 = 140;
    public static final int U_CARSET_D76_D3_B5 = 118;
    public static final int U_CARSET_D76_D3_B76 = 117;
    public static final int U_CARSET_D79_D3_B10 = 126;
    public static final int U_CARSET_D79_D3_B32 = 125;
    public static final int U_CARSET_D79_D3_B54 = 124;
    public static final int U_CARSET_D79_D3_B76 = 123;
    public static final int U_CARSET_D79_D4_B0 = 131;
    public static final int U_CARSET_D79_D4_B1 = 130;
    public static final int U_CARSET_D79_D4_B32 = 129;
    public static final int U_CARSET_D79_D4_B54 = 128;
    public static final int U_CARSET_D79_D4_B76 = 127;
    public static final int U_CARSET_D79_D5_B0 = 134;
    public static final int U_CARSET_D79_D5_B1 = 133;
    public static final int U_CARSET_D79_D5_B32 = 132;
    public static final int U_CARSET_D79_D6_B0 = 137;
    public static final int U_CARSET_D79_D6_B31 = 136;
    public static final int U_CARSET_D79_D6_B74 = 135;
    public static final int U_CARSET_D79_D7_B70 = 138;
    public static final int U_CARSET_D94_D0_B70 = 116;
    public static final int U_CARSET_DAY_LIGHT = 104;
    public static final int U_CARSET_DOOR_AUTOLOCK = 103;
    public static final int U_CARSET_FLAHLIGHT_LOCK = 109;
    public static final int U_CARSET_HEADLIGHT_DELAY = 114;
    public static final int U_CARSET_MEASURE_UNIT = 106;
    public static final int U_CARSET_MILE_UNIT = 100;
    public static final int U_CARSET_OIL_UNIT = 101;
    public static final int U_CARSET_PARKSENSE = 112;
    public static final int U_CARSET_PRESSURE_UNIT = 139;
    public static final int U_CARSET_REARPARK_VOL = 108;
    public static final int U_CARSET_REARVIEW_DELAY = 113;
    public static final int U_CARSET_REARV_GUID = 107;
    public static final int U_CARSET_TEMP_UNIT = 102;
    public static final int U_CARSET_TRIB_ONOFF = 105;
    public static final int U_CNT_MAX = 142;
    public static final int U_PRESSURE_FL = 119;
    public static final int U_PRESSURE_FR = 120;
    public static final int U_PRESSURE_RL = 121;
    public static final int U_PRESSURE_RR = 122;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 142; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0443_WC2_Feiyate_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 142) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
