package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0443_WC2_19focus;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_19Focus extends CallbackCanbusBase {
    public static final int U_AIR_RADAR_BEEP = 110;
    public static final int U_CARINF_D61_D0_B0 = 122;
    public static final int U_CARINF_D61_D0_B4 = 121;
    public static final int U_CARINF_D61_D0_B5 = 120;
    public static final int U_CARINF_D62_D0_B0 = 112;
    public static final int U_CARINF_D62_D0_B21 = 111;
    public static final int U_CARINF_D62_D1_B70 = 113;
    public static final int U_CARINF_D62_D3_B70 = 114;
    public static final int U_CARINF_D67_D1_B0 = 115;
    public static final int U_CARINF_D67_D1_B1 = 116;
    public static final int U_CARINF_D67_D1_B3 = 117;
    public static final int U_CARINF_D67_D1_B4 = 118;
    public static final int U_CARINF_D85_D1_B0 = 123;
    public static final int U_CARINF_D85_D1_B21 = 124;
    public static final int U_CARINF_D85_D1_B3 = 125;
    public static final int U_CARINF_D85_D1_B4 = 126;
    public static final int U_CARINF_D85_D1_B5 = 127;
    public static final int U_CARINF_D94_D0_B70 = 119;
    public static final int U_CAR_EQ_BAL = 103;
    public static final int U_CAR_EQ_BASS = 105;
    public static final int U_CAR_EQ_FAD = 104;
    public static final int U_CAR_EQ_MID = 106;
    public static final int U_CAR_EQ_SPEED_VOL = 108;
    public static final int U_CAR_EQ_SURROUND = 109;
    public static final int U_CAR_EQ_TREB = 107;
    public static final int U_CAR_EQ_VOL = 102;
    public static final int U_CAR_SET_AMBIENT_LIGHT = 101;
    public static final int U_CAR_SET_BEGIN = 99;
    public static final int U_CAR_SET_MILE_UNIT = 100;
    public static final int U_CNT_MAX = 128;
    public static final int U_DRIVING_TIME = 98;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 128; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_19focus(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 128) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
