package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_LUZ_Lexus_IS extends CallbackCanbusBase {
    public static final int U_CARCD_ASL = 138;
    public static final int U_CARCD_BAL = 137;
    public static final int U_CARCD_BASS = 139;
    public static final int U_CARCD_CURTIME_HOUR = 135;
    public static final int U_CARCD_CURTIME_MIN = 134;
    public static final int U_CARCD_CURTIME_SEC = 133;
    public static final int U_CARCD_CURTRACK = 129;
    public static final int U_CARCD_DISC1 = 106;
    public static final int U_CARCD_DISC2 = 107;
    public static final int U_CARCD_DISC3 = 108;
    public static final int U_CARCD_DISC4 = 109;
    public static final int U_CARCD_DISC5 = 110;
    public static final int U_CARCD_DISC6 = 111;
    public static final int U_CARCD_MID = 141;
    public static final int U_CARCD_NUM = 113;
    public static final int U_CARCD_RANDOM = 127;
    public static final int U_CARCD_REPEAT = 126;
    public static final int U_CARCD_STATE = 112;
    public static final int U_CARCD_TOTALTIME_HOUR = 132;
    public static final int U_CARCD_TOTALTIME_MIN = 131;
    public static final int U_CARCD_TOTALTIME_SEC = 130;
    public static final int U_CARCD_TOTALTRACK = 128;
    public static final int U_CARCD_TRE = 140;
    public static final int U_CARCD_VOL = 142;
    public static final int U_CARCD_WORKSTATE = 114;
    public static final int U_CAREQ_FAD = 136;
    public static final int U_CARINFO_D35_D0_D1 = 143;
    public static final int U_CARINFO_D35_D2_D3 = 144;
    public static final int U_CARINFO_D35_D4_D5 = 145;
    public static final int U_CARINFO_D35_D6_D7 = 146;
    public static final int U_CARINFO_D35_D8_D9 = 147;
    public static final int U_CARRADIO_BAND = 115;
    public static final int U_CARRADIO_CHNEL = 116;
    public static final int U_CARRADIO_FRQ = 119;
    public static final int U_CARRADIO_FRQ1 = 120;
    public static final int U_CARRADIO_FRQ2 = 121;
    public static final int U_CARRADIO_FRQ3 = 122;
    public static final int U_CARRADIO_FRQ4 = 123;
    public static final int U_CARRADIO_FRQ5 = 124;
    public static final int U_CARRADIO_FRQ6 = 125;
    public static final int U_CARRADIO_SCAN = 117;
    public static final int U_CARRADIO_ST = 118;
    public static final int U_CARUSB_FOLDERNUM = 105;
    public static final int U_CARUSB_PLAYTIME_MIN = 101;
    public static final int U_CARUSB_PLAYTIME_SEC = 102;
    public static final int U_CARUSB_STATE = 100;
    public static final int U_CARUSB_TOTALTRACK = 104;
    public static final int U_CARUSB_TRACK = 103;
    public static final int U_CAR_EC_LEV = 148;
    public static final int U_CAR_PE_ENABLE = 149;
    public static final int U_CAR_PE_STATE = 150;
    public static final int U_CNT_MAX = 159;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_SHOW_AIRMODE = 158;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 159; i++) {
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
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL /* 983495 */:
            case FinalCanbus.CAR_455_LZ_Toyota_LAND_CRUISER_11_CD_YL_H /* 1049031 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300 /* 15008198 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER /* 15139270 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_FJ_CRUISER_H /* 15532486 */:
            case FinalCanbus.CAR_454_LZ_CG_Toyota_LEUXS_RX300_H /* 15598022 */:
                break;
            default:
                //AirHelper.getInstance().buildUi(new Air_0439_Luz_LexusIS(LauncherApplication.getInstance()));
                for (int i3 = 10; i3 < 97; i3++) {
                    DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                break;
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
        if (updateCode >= 0 && updateCode < 159) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
