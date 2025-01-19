package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_TD_Lexus_All extends CallbackCanbusBase {
    public static final int U_CARCD_ASL = 138;
    public static final int U_CARCD_BAL = 137;
    public static final int U_CARCD_BASS = 139;
    public static final int U_CARCD_CURTIME_HOUR = 133;
    public static final int U_CARCD_CURTIME_MIN = 132;
    public static final int U_CARCD_CURTIME_SEC = 131;
    public static final int U_CARCD_CURTRACK = 127;
    public static final int U_CARCD_DISC1 = 98;
    public static final int U_CARCD_DISC1_TYPE = 106;
    public static final int U_CARCD_DISC2 = 99;
    public static final int U_CARCD_DISC2_TYPE = 107;
    public static final int U_CARCD_DISC3 = 100;
    public static final int U_CARCD_DISC3_TYPE = 108;
    public static final int U_CARCD_DISC4 = 101;
    public static final int U_CARCD_DISC4_TYPE = 109;
    public static final int U_CARCD_DISC5 = 102;
    public static final int U_CARCD_DISC5_TYPE = 110;
    public static final int U_CARCD_DISC6 = 103;
    public static final int U_CARCD_DISC6_TYPE = 111;
    public static final int U_CARCD_MID = 141;
    public static final int U_CARCD_NUM = 105;
    public static final int U_CARCD_RANDOM = 125;
    public static final int U_CARCD_REPEAT = 124;
    public static final int U_CARCD_STATE = 104;
    public static final int U_CARCD_TOTALTIME_HOUR = 130;
    public static final int U_CARCD_TOTALTIME_MIN = 129;
    public static final int U_CARCD_TOTALTIME_SEC = 128;
    public static final int U_CARCD_TOTALTRACK = 126;
    public static final int U_CARCD_TRE = 140;
    public static final int U_CARCD_VOL = 142;
    public static final int U_CARCD_WORKSTATE = 112;
    public static final int U_CAREQ_FAD = 136;
    public static final int U_CARRADIO_BAND = 113;
    public static final int U_CARRADIO_CHNEL = 114;
    public static final int U_CARRADIO_FRQ = 117;
    public static final int U_CARRADIO_FRQ1 = 118;
    public static final int U_CARRADIO_FRQ2 = 119;
    public static final int U_CARRADIO_FRQ3 = 120;
    public static final int U_CARRADIO_FRQ4 = 121;
    public static final int U_CARRADIO_FRQ5 = 122;
    public static final int U_CARRADIO_FRQ6 = 123;
    public static final int U_CARRADIO_SCAN = 115;
    public static final int U_CARRADIO_ST = 116;
    public static final int U_CARUSB_CURTIME_HOUR = 143;
    public static final int U_CARUSB_CURTIME_MIN = 142;
    public static final int U_CARUSB_CURTIME_SEC = 141;
    public static final int U_CARUSB_RANDOM = 135;
    public static final int U_CARUSB_REPEAT = 134;
    public static final int U_CARUSB_TOTALTIME_HOUR = 140;
    public static final int U_CARUSB_TOTALTIME_MIN = 139;
    public static final int U_CARUSB_TOTALTIME_SEC = 138;
    public static final int U_CARUSB_TOTALTRACK = 137;
    public static final int U_CARUSB_TRACK = 136;
    public static final int U_CAR_D66_D2_B6 = 144;
    public static final int U_CAR_D66_D2_B7 = 143;
    public static final int U_CAR_D68_D0_B0 = 145;
    public static final int U_CAR_D68_D0_B1 = 146;
    public static final int U_CAR_D68_D0_B2 = 147;
    public static final int U_CAR_D68_D0_B3 = 148;
    public static final int U_CAR_D68_D0_B4 = 149;
    public static final int U_CAR_D68_D0_B5 = 150;
    public static final int U_CAR_D70_D0_D1 = 151;
    public static final int U_CAR_D70_D2_D3 = 152;
    public static final int U_CAR_D70_D4_D5 = 153;
    public static final int U_CAR_D70_D6_D7 = 154;
    public static final int U_CAR_D70_D8_B70 = 155;
    public static final int U_CNT_MAX = 156;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 156; i++) {
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
        if (updateCode >= 0 && updateCode < 156) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
