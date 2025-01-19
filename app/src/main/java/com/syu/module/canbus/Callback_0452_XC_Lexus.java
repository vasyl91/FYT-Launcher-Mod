package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_Xincheng_Lexus;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_XC_Lexus extends CallbackCanbusBase {
    public static final int U_CARCD_CURFILE = 135;
    public static final int U_CARCD_CURTIME_HOUR = 146;
    public static final int U_CARCD_CURTIME_MIN = 145;
    public static final int U_CARCD_CURTIME_SEC = 144;
    public static final int U_CARCD_CURTRACK = 137;
    public static final int U_CARCD_D72_ASL = 105;
    public static final int U_CARCD_D72_BAL = 103;
    public static final int U_CARCD_D72_BASS = 100;
    public static final int U_CARCD_D72_FAD = 104;
    public static final int U_CARCD_D72_MID = 101;
    public static final int U_CARCD_D72_TRE = 102;
    public static final int U_CARCD_D73_ASL = 111;
    public static final int U_CARCD_D73_BAL = 107;
    public static final int U_CARCD_D73_BASS = 108;
    public static final int U_CARCD_D73_FAD = 106;
    public static final int U_CARCD_D73_MID = 110;
    public static final int U_CARCD_D73_TRE = 109;
    public static final int U_CARCD_DISC1 = 114;
    public static final int U_CARCD_DISC2 = 115;
    public static final int U_CARCD_DISC3 = 116;
    public static final int U_CARCD_DISC4 = 117;
    public static final int U_CARCD_DISC5 = 118;
    public static final int U_CARCD_DISC6 = 119;
    public static final int U_CARCD_NUM = 121;
    public static final int U_CARCD_RANDOM = 142;
    public static final int U_CARCD_REPEAT = 141;
    public static final int U_CARCD_SCAN = 143;
    public static final int U_CARCD_STATE = 120;
    public static final int U_CARCD_TOTALFILE = 134;
    public static final int U_CARCD_TOTALTIME_HOUR = 140;
    public static final int U_CARCD_TOTALTIME_MIN = 139;
    public static final int U_CARCD_TOTALTIME_SEC = 138;
    public static final int U_CARCD_TOTALTRACK = 136;
    public static final int U_CARCD_WORKSTATE = 122;
    public static final int U_CAREQ_D72_MUTE = 98;
    public static final int U_CAREQ_D72_VOL = 99;
    public static final int U_CAREQ_D73_MUTE = 112;
    public static final int U_CAREQ_D73_VOL = 113;
    public static final int U_CARRADIO_BAND = 123;
    public static final int U_CARRADIO_CHNEL = 126;
    public static final int U_CARRADIO_FRQ = 127;
    public static final int U_CARRADIO_FRQ1 = 128;
    public static final int U_CARRADIO_FRQ2 = 129;
    public static final int U_CARRADIO_FRQ3 = 130;
    public static final int U_CARRADIO_FRQ4 = 131;
    public static final int U_CARRADIO_FRQ5 = 132;
    public static final int U_CARRADIO_FRQ6 = 133;
    public static final int U_CARRADIO_SCAN = 125;
    public static final int U_CARRADIO_ST = 124;
    public static final int U_CNT_MAX = 147;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 147; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_Xincheng_Lexus(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
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
        if (updateCode >= 0 && updateCode < 147) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
