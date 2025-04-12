package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Fieyate_All extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_END = 110;
    public static final int U_CARINFO_TRIPA_AVG_OIL = 102;
    public static final int U_CARINFO_TRIPA_AVG_SPEEDL = 103;
    public static final int U_CARINFO_TRIPA_DRIVED_TIME = 105;
    public static final int U_CARINFO_TRIPA_TOTAL_MILE = 104;
    public static final int U_CARINFO_TRIPB_AVG_OIL = 106;
    public static final int U_CARINFO_TRIPB_AVG_SPEEDL = 107;
    public static final int U_CARINFO_TRIPB_DRIVED_TIME = 109;
    public static final int U_CARINFO_TRIPB_TOTAL_MILE = 108;
    public static final int U_CARINFO_TRIP_CUR_OIL = 99;
    public static final int U_CARINFO_TRIP_DRIVENABLE_OIL = 100;
    public static final int U_CARINFO_TRIP_TOTAL_MILE = 101;
    public static final int U_CARSET_BEGIN = 111;
    public static final int U_CARSET_CORERING_LIGHTS = 122;
    public static final int U_CARSET_COURTESYLIGHT_DELAY = 127;
    public static final int U_CARSET_COURTESY_LIGHTS = 123;
    public static final int U_CARSET_D76_D0_B20 = 153;
    public static final int U_CARSET_D76_D0_B3 = 156;
    public static final int U_CARSET_D76_D0_B4 = 155;
    public static final int U_CARSET_D76_D0_B65 = 154;
    public static final int U_CARSET_D76_D0_B7 = 152;
    public static final int U_CARSET_D76_D1_B10 = 161;
    public static final int U_CARSET_D76_D1_B3 = 160;
    public static final int U_CARSET_D76_D1_B4 = 159;
    public static final int U_CARSET_D76_D1_B6 = 158;
    public static final int U_CARSET_D76_D1_B7 = 157;
    public static final int U_CARSET_D76_D3_B5 = 130;
    public static final int U_CARSET_D76_D3_B76 = 129;
    public static final int U_CARSET_D79_D2_B10 = 166;
    public static final int U_CARSET_D79_D2_B32 = 165;
    public static final int U_CARSET_D79_D2_B54 = 164;
    public static final int U_CARSET_D79_D2_B6 = 163;
    public static final int U_CARSET_D79_D2_B7 = 162;
    public static final int U_CARSET_D79_D3_B10 = 138;
    public static final int U_CARSET_D79_D3_B32 = 137;
    public static final int U_CARSET_D79_D3_B54 = 136;
    public static final int U_CARSET_D79_D3_B76 = 135;
    public static final int U_CARSET_D79_D4_B0 = 143;
    public static final int U_CARSET_D79_D4_B1 = 142;
    public static final int U_CARSET_D79_D4_B32 = 141;
    public static final int U_CARSET_D79_D4_B54 = 140;
    public static final int U_CARSET_D79_D4_B76 = 139;
    public static final int U_CARSET_D79_D5_B0 = 146;
    public static final int U_CARSET_D79_D5_B1 = 145;
    public static final int U_CARSET_D79_D5_B32 = 144;
    public static final int U_CARSET_D79_D5_B4 = 168;
    public static final int U_CARSET_D79_D5_B5 = 167;
    public static final int U_CARSET_D79_D6_B0 = 149;
    public static final int U_CARSET_D79_D6_B31 = 148;
    public static final int U_CARSET_D79_D6_B74 = 147;
    public static final int U_CARSET_D79_D7_B70 = 150;
    public static final int U_CARSET_D94_D0_B70 = 128;
    public static final int U_CARSET_DAY_LIGHT = 116;
    public static final int U_CARSET_DOOR_AUTOLOCK = 115;
    public static final int U_CARSET_FLAHLIGHT_LOCK = 121;
    public static final int U_CARSET_HEADLIGHT_DELAY = 126;
    public static final int U_CARSET_MEASURE_UNIT = 118;
    public static final int U_CARSET_MILE_UNIT = 112;
    public static final int U_CARSET_OIL_UNIT = 113;
    public static final int U_CARSET_PARKSENSE = 124;
    public static final int U_CARSET_PRESSURE_UNIT = 151;
    public static final int U_CARSET_REARPARK_VOL = 120;
    public static final int U_CARSET_REARVIEW_DELAY = 125;
    public static final int U_CARSET_REARV_GUID = 119;
    public static final int U_CARSET_TEMP_UNIT = 114;
    public static final int U_CARSET_TRIB_ONOFF = 117;
    public static final int U_CNT_MAX = 169;
    public static final int U_PRESSURE_FL = 131;
    public static final int U_PRESSURE_FR = 132;
    public static final int U_PRESSURE_RL = 133;
    public static final int U_PRESSURE_RR = 134;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 169; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_Feiyate_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
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
        if (updateCode >= 0 && updateCode < 169) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
