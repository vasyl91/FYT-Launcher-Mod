package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0454_TD_Lexus_All extends CallbackCanbusBase {
    public static final int U_AVERAGE_SPEED = 104;
    public static final int U_CARCD_ASL = 160;
    public static final int U_CARCD_BAL = 159;
    public static final int U_CARCD_BASS = 161;
    public static final int U_CARCD_CURTIME_HOUR = 155;
    public static final int U_CARCD_CURTIME_MIN = 154;
    public static final int U_CARCD_CURTIME_SEC = 153;
    public static final int U_CARCD_CURTRACK = 149;
    public static final int U_CARCD_DISC1 = 120;
    public static final int U_CARCD_DISC1_TYPE = 128;
    public static final int U_CARCD_DISC2 = 121;
    public static final int U_CARCD_DISC2_TYPE = 129;
    public static final int U_CARCD_DISC3 = 122;
    public static final int U_CARCD_DISC3_TYPE = 130;
    public static final int U_CARCD_DISC4 = 123;
    public static final int U_CARCD_DISC4_TYPE = 131;
    public static final int U_CARCD_DISC5 = 124;
    public static final int U_CARCD_DISC5_TYPE = 132;
    public static final int U_CARCD_DISC6 = 125;
    public static final int U_CARCD_DISC6_TYPE = 133;
    public static final int U_CARCD_MID = 163;
    public static final int U_CARCD_NUM = 127;
    public static final int U_CARCD_RANDOM = 147;
    public static final int U_CARCD_REPEAT = 146;
    public static final int U_CARCD_STATE = 126;
    public static final int U_CARCD_TOTALTIME_HOUR = 152;
    public static final int U_CARCD_TOTALTIME_MIN = 151;
    public static final int U_CARCD_TOTALTIME_SEC = 150;
    public static final int U_CARCD_TOTALTRACK = 148;
    public static final int U_CARCD_TRE = 162;
    public static final int U_CARCD_VOL = 164;
    public static final int U_CARCD_WORKSTATE = 134;
    public static final int U_CAREQ_FAD = 158;
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARRADIO_BAND = 135;
    public static final int U_CARRADIO_CHNEL = 136;
    public static final int U_CARRADIO_FRQ = 139;
    public static final int U_CARRADIO_FRQ1 = 140;
    public static final int U_CARRADIO_FRQ2 = 141;
    public static final int U_CARRADIO_FRQ3 = 142;
    public static final int U_CARRADIO_FRQ4 = 143;
    public static final int U_CARRADIO_FRQ5 = 144;
    public static final int U_CARRADIO_FRQ6 = 145;
    public static final int U_CARRADIO_SCAN = 137;
    public static final int U_CARRADIO_ST = 138;
    public static final int U_CARSET_OIL_UNIT = 110;
    public static final int U_CARUSB_CURTIME_HOUR = 165;
    public static final int U_CARUSB_CURTIME_MIN = 164;
    public static final int U_CARUSB_CURTIME_SEC = 163;
    public static final int U_CARUSB_RANDOM = 157;
    public static final int U_CARUSB_REPEAT = 156;
    public static final int U_CARUSB_TOTALTIME_HOUR = 162;
    public static final int U_CARUSB_TOTALTIME_MIN = 161;
    public static final int U_CARUSB_TOTALTIME_SEC = 160;
    public static final int U_CARUSB_TOTALTRACK = 159;
    public static final int U_CARUSB_TRACK = 158;
    public static final int U_CAR_D66_D2_B6 = 166;
    public static final int U_CAR_D66_D2_B7 = 165;
    public static final int U_CAR_D68_D0_B0 = 167;
    public static final int U_CAR_D68_D0_B1 = 168;
    public static final int U_CAR_D68_D0_B2 = 169;
    public static final int U_CAR_D68_D0_B3 = 170;
    public static final int U_CAR_D68_D0_B4 = 171;
    public static final int U_CAR_D68_D0_B5 = 172;
    public static final int U_CAR_D70_D0_D1 = 173;
    public static final int U_CAR_D70_D2_D3 = 174;
    public static final int U_CAR_D70_D4_D5 = 175;
    public static final int U_CAR_D70_D6_D7 = 176;
    public static final int U_CAR_D70_D8_B70 = 177;
    public static final int U_CAR_ECO_MODE = 102;
    public static final int U_CAR_EC_LEV = 99;
    public static final int U_CAR_EV_MODE = 103;
    public static final int U_CAR_PE_ENABLE = 100;
    public static final int U_CAR_PE_STATE = 101;
    public static final int U_CNT_MAX = 181;
    public static final int U_CUR_OIL_EXPEND = 107;
    public static final int U_CUR_TRIP_OIL_EXPEND = 108;
    public static final int U_DRIVING_MILEAGE = 106;
    public static final int U_DRIVING_TIME = 105;
    public static final int U_EXIST_TPMS = 111;
    public static final int U_PRESSURE_BACKUP = 119;
    public static final int U_PRESSURE_FL = 115;
    public static final int U_PRESSURE_FR = 116;
    public static final int U_PRESSURE_RL = 117;
    public static final int U_PRESSURE_RR = 118;
    public static final int U_SHOW_AIRMODE = 178;
    public static final int U_SHOW_CARCD_STATE = 179;
    public static final int U_SHOW_REARAIR_STATE = 180;
    public static final int U_SHOW_TIRE_BACKUP = 113;
    public static final int U_TIRE_SHOW_STATE = 114;
    public static final int U_TPMS_STATE = 112;
    public static final int U_TRIP_OIL_EXPEND = 109;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 181; i++) {
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 181) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
