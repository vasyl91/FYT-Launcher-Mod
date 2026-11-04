package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Callback_0454_TD_Lexus_All extends CallbackCanbusBase {
    public static final int U_AVERAGE_SPEED = 104;
    public static final int U_CARCD_ASL = 178;
    public static final int U_CARCD_BAL = 177;
    public static final int U_CARCD_BASS = 179;
    public static final int U_CARCD_CURTIME_HOUR = 173;
    public static final int U_CARCD_CURTIME_MIN = 172;
    public static final int U_CARCD_CURTIME_SEC = 171;
    public static final int U_CARCD_CURTRACK = 167;
    public static final int U_CARCD_DISC1 = 138;
    public static final int U_CARCD_DISC1_TYPE = 146;
    public static final int U_CARCD_DISC2 = 139;
    public static final int U_CARCD_DISC2_TYPE = 147;
    public static final int U_CARCD_DISC3 = 140;
    public static final int U_CARCD_DISC3_TYPE = 148;
    public static final int U_CARCD_DISC4 = 141;
    public static final int U_CARCD_DISC4_TYPE = 149;
    public static final int U_CARCD_DISC5 = 142;
    public static final int U_CARCD_DISC5_TYPE = 150;
    public static final int U_CARCD_DISC6 = 143;
    public static final int U_CARCD_DISC6_TYPE = 151;
    public static final int U_CARCD_MID = 181;
    public static final int U_CARCD_NUM = 145;
    public static final int U_CARCD_RANDOM = 165;
    public static final int U_CARCD_REPEAT = 164;
    public static final int U_CARCD_STATE = 144;
    public static final int U_CARCD_TOTALTIME_HOUR = 170;
    public static final int U_CARCD_TOTALTIME_MIN = 169;
    public static final int U_CARCD_TOTALTIME_SEC = 168;
    public static final int U_CARCD_TOTALTRACK = 166;
    public static final int U_CARCD_TRE = 180;
    public static final int U_CARCD_VOL = 182;
    public static final int U_CARCD_WORKSTATE = 152;
    public static final int U_CAREQ_FAD = 176;
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARRADIO_BAND = 153;
    public static final int U_CARRADIO_CHNEL = 154;
    public static final int U_CARRADIO_FRQ = 157;
    public static final int U_CARRADIO_FRQ1 = 158;
    public static final int U_CARRADIO_FRQ2 = 159;
    public static final int U_CARRADIO_FRQ3 = 160;
    public static final int U_CARRADIO_FRQ4 = 161;
    public static final int U_CARRADIO_FRQ5 = 162;
    public static final int U_CARRADIO_FRQ6 = 163;
    public static final int U_CARRADIO_SCAN = 155;
    public static final int U_CARRADIO_ST = 156;
    public static final int U_CARSET_D26_D5_B20 = 137;
    public static final int U_CARSET_OIL_UNIT = 110;
    public static final int U_CARUSB_CURTIME_HOUR = 183;
    public static final int U_CARUSB_CURTIME_MIN = 182;
    public static final int U_CARUSB_CURTIME_SEC = 181;
    public static final int U_CARUSB_RANDOM = 175;
    public static final int U_CARUSB_REPEAT = 174;
    public static final int U_CARUSB_TOTALTIME_HOUR = 180;
    public static final int U_CARUSB_TOTALTIME_MIN = 179;
    public static final int U_CARUSB_TOTALTIME_SEC = 178;
    public static final int U_CARUSB_TOTALTRACK = 177;
    public static final int U_CARUSB_TRACK = 176;
    public static final int U_CAR_D66_D2_B6 = 184;
    public static final int U_CAR_D66_D2_B7 = 183;
    public static final int U_CAR_D68_D0_B0 = 185;
    public static final int U_CAR_D68_D0_B1 = 186;
    public static final int U_CAR_D68_D0_B2 = 187;
    public static final int U_CAR_D68_D0_B3 = 188;
    public static final int U_CAR_D68_D0_B4 = 189;
    public static final int U_CAR_D68_D0_B5 = 190;
    public static final int U_CAR_D70_D0_D1 = 191;
    public static final int U_CAR_D70_D2_D3 = 192;
    public static final int U_CAR_D70_D4_D5 = 193;
    public static final int U_CAR_D70_D6_D7 = 194;
    public static final int U_CAR_D70_D8_B70 = 195;
    public static final int U_CAR_ECO_MODE = 102;
    public static final int U_CAR_EC_LEV = 99;
    public static final int U_CAR_EV_MODE = 103;
    public static final int U_CAR_PE_ENABLE = 100;
    public static final int U_CAR_PE_STATE = 101;
    public static final int U_CAR_SCREEN_H = 200;
    public static final int U_CAR_SCREEN_W = 199;
    public static final int U_CNT_MAX = 201;
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
    public static final int U_SHOW_AIRMODE = 196;
    public static final int U_SHOW_CARCD_STATE = 197;
    public static final int U_SHOW_REARAIR_STATE = 198;
    public static final int U_SHOW_TIRE_BACKUP = 113;
    public static final int U_TIRE_SHOW_STATE = 114;
    public static final int U_TPMS_STATE = 112;
    public static final int U_TRIP_OIL_EXPEND = 109;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 201; i++) {
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
        if (updateCode >= 0 && updateCode < 201) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
