package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.od.mazdall.MazdAllMaintenanceWarnAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_OD_MZD_ALL extends CallbackCanbusBase {
    public static final int U_CARINF_D32_D6_D7_D8 = 94;
    public static final int U_CARINF_DAY_CUR = 107;
    public static final int U_CARINF_DAY_SET = 96;
    public static final int U_CARINF_DISTANCE_CUR = 106;
    public static final int U_CARINF_DISTANCE_CUR_OIL = 109;
    public static final int U_CARINF_DISTANCE_CUR_TIRE = 108;
    public static final int U_CARINF_DISTANCE_SET = 95;
    public static final int U_CARINF_DISTANCE_SET_OIL = 98;
    public static final int U_CARINF_DISTANCE_SET_TIRE = 97;
    public static final int U_CARINF_OIL_DIS_WARN = 105;
    public static final int U_CARINF_RESERVATION_DAY_WARN = 103;
    public static final int U_CARINF_RESERVATION_DIS_WARN = 102;
    public static final int U_CARINF_RESERVATION_OIL_ON = 101;
    public static final int U_CARINF_RESERVATION_ON = 99;
    public static final int U_CARINF_RESERVATION_TIRE_ON = 100;
    public static final int U_CARINF_TIRE_DIS_WARN = 104;
    public static final int U_CARSET_D09_D0_B10 = 68;
    public static final int U_CARSET_D09_D0_B32 = 67;
    public static final int U_CARSET_D09_D0_B64 = 66;
    public static final int U_CARSET_D09_D0_B7 = 65;
    public static final int U_CARSET_D09_D1_B10 = 74;
    public static final int U_CARSET_D09_D1_B32 = 73;
    public static final int U_CARSET_D09_D1_B4 = 72;
    public static final int U_CARSET_D09_D1_B5 = 71;
    public static final int U_CARSET_D09_D1_B6 = 70;
    public static final int U_CARSET_D09_D1_B7 = 69;
    public static final int U_CARSET_D09_D2_B10 = 81;
    public static final int U_CARSET_D09_D2_B2 = 80;
    public static final int U_CARSET_D09_D2_B3 = 79;
    public static final int U_CARSET_D09_D2_B4 = 78;
    public static final int U_CARSET_D09_D2_B5 = 77;
    public static final int U_CARSET_D09_D2_B6 = 76;
    public static final int U_CARSET_D09_D2_B7 = 75;
    public static final int U_CARSET_D09_D3_B20 = 84;
    public static final int U_CARSET_D09_D3_B53 = 83;
    public static final int U_CARSET_D09_D3_B76 = 82;
    public static final int U_CARSET_D09_D4_B70 = 85;
    public static final int U_CARSET_D09_D5_B70 = 86;
    public static final int U_CARSET_D09_D6_B70 = 87;
    public static final int U_CARSET_D09_D7_B21 = 92;
    public static final int U_CARSET_D09_D7_B3 = 91;
    public static final int U_CARSET_D09_D7_B54 = 90;
    public static final int U_CARSET_D09_D7_B6 = 89;
    public static final int U_CARSET_D09_D7_B7 = 88;
    public static final int U_CARSET_D0D_D0_B0 = 115;
    public static final int U_CARSET_D0D_D0_B1 = 114;
    public static final int U_CARSET_D0D_D0_B2 = 113;
    public static final int U_CARSET_D0D_D0_B53 = 112;
    public static final int U_CARSET_D0D_D0_B6 = 111;
    public static final int U_CARSET_D0D_D0_B7 = 110;
    public static final int U_CARSET_D0D_D1_B21 = 119;
    public static final int U_CARSET_D0D_D1_B43 = 118;
    public static final int U_CARSET_D0D_D1_B5 = 117;
    public static final int U_CARSET_D0D_D1_B76 = 116;
    public static final int U_CARSET_D0D_D2_B1 = 124;
    public static final int U_CARSET_D0D_D2_B2 = 123;
    public static final int U_CARSET_D0D_D2_B43 = 122;
    public static final int U_CARSET_D0D_D2_B65 = 121;
    public static final int U_CARSET_D0D_D2_B7 = 120;
    public static final int U_CARSET_D0E_D0_B3 = 127;
    public static final int U_CARSET_D0E_D0_B54 = 126;
    public static final int U_CARSET_D0E_D0_B76 = 125;
    public static final int U_CARSET_D0E_D1_B4 = 131;
    public static final int U_CARSET_D0E_D1_B5 = 130;
    public static final int U_CARSET_D0E_D1_B6 = 129;
    public static final int U_CARSET_D0E_D1_B7 = 128;
    public static final int U_CARSET_D0E_D2_B53 = 133;
    public static final int U_CARSET_D0E_D2_B76 = 132;
    public static final int U_CAR_JUMP_TIMEFLAG = 53;
    public static final int U_CAR_JUMP_WARNFLAG = 52;
    public static final int U_CAR_MOTOROIL_CHANGE = 50;
    public static final int U_CAR_RESERVATION_MILE = 48;
    public static final int U_CAR_RESERVATION_ONOFF = 46;
    public static final int U_CAR_RESERVATION_TIME = 47;
    public static final int U_CAR_TIRE_ADD = 62;
    public static final int U_CAR_TIRE_BEGIN = 54;
    public static final int U_CAR_TIRE_CHANGE = 49;
    public static final int U_CAR_TIRE_SYS = 60;
    public static final int U_CAR_TIRE_TYPE = 63;
    public static final int U_CAR_TIRE_UNIT = 64;
    public static final int U_CAR_TIRE_VALUE_ADD = 59;
    public static final int U_CAR_TIRE_VALUE_FL = 55;
    public static final int U_CAR_TIRE_VALUE_FR = 56;
    public static final int U_CAR_TIRE_VALUE_RL = 57;
    public static final int U_CAR_TIRE_VALUE_RR = 58;
    public static final int U_CAR_TIRE_WARN = 61;
    public static final int U_CAR_TOTAL_MIL = 51;
    public static final int U_CAR_WATER_TEMP = 45;
    public static final int U_CD_BEGIN = 30;
    public static final int U_CD_CUR_TIME = 38;
    public static final int U_CD_CUR_TRACK = 37;
    public static final int U_CD_END = 44;
    public static final int U_CD_RDM_STATE = 36;
    public static final int U_CD_RPT_STATE = 35;
    public static final int U_CD_STATE1 = 31;
    public static final int U_CD_STATE2 = 32;
    public static final int U_CD_TOTAL_TIME = 39;
    public static final int U_CD_TOTAL_TRACK = 33;
    public static final int U_CD_WORK_STATE = 34;
    public static final int U_CNT_MAX = 134;
    public static final int U_OIL_BEGIN = 6;
    public static final int U_OIL_INFO_AVG2 = 8;
    public static final int U_OIL_INFO_AVG3 = 9;
    public static final int U_OIL_INFO_AVG4 = 10;
    public static final int U_OIL_INFO_AVG5 = 11;
    public static final int U_OIL_INFO_AVG6 = 12;
    public static final int U_OIL_INFO_CURAVG = 7;
    public static final int U_OIL_INFO_DRIVING = 14;
    public static final int U_OIL_INFO_ELOOP = 13;
    public static final int U_OIL_INFO_END = 30;
    public static final int U_OIL_MINUTE_1 = 15;
    public static final int U_OIL_MINUTE_10 = 24;
    public static final int U_OIL_MINUTE_11_20 = 25;
    public static final int U_OIL_MINUTE_2 = 16;
    public static final int U_OIL_MINUTE_21_30 = 26;
    public static final int U_OIL_MINUTE_3 = 17;
    public static final int U_OIL_MINUTE_31_40 = 27;
    public static final int U_OIL_MINUTE_4 = 18;
    public static final int U_OIL_MINUTE_41_50 = 28;
    public static final int U_OIL_MINUTE_5 = 19;
    public static final int U_OIL_MINUTE_51_60 = 29;
    public static final int U_OIL_MINUTE_6 = 20;
    public static final int U_OIL_MINUTE_7 = 21;
    public static final int U_OIL_MINUTE_8 = 22;
    public static final int U_OIL_MINUTE_9 = 23;
    public static final int U_TEXT_ARTIST_NAME = 42;
    public static final int U_TEXT_DISC_NAME = 41;
    public static final int U_TEXT_MUSIC_NAME = 40;
    public static final int U_TEXT_TYPE = 43;
    public static String mId3DiscName;
    public static String mId3Name;
    public static String mIdArtist3Name;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 134; i++) {
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
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 134) {
            switch (updateCode) {
                case 40:
                    if (strs != null && strs.length > 0) {
                        mId3Name = strs[0];
                    } else {
                        mId3Name = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 41:
                    if (strs != null && strs.length > 0) {
                        mId3DiscName = strs[0];
                    } else {
                        mId3DiscName = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 42:
                    if (strs != null && strs.length > 0) {
                        mIdArtist3Name = strs[0];
                    } else {
                        mIdArtist3Name = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 52:
                    int value = ints[0];
                    if (value != 0 && !MazdAllMaintenanceWarnAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.od.mazdall.MazdAllMaintenanceWarnAct");
                        break;
                    }
                case 53:
                    int value2 = ints[0];
                    if (value2 == 1 && !MazdAllMaintenanceWarnAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.od.mazdall.MazdAllMaintenanceWarnAct");
                        break;
                    }
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
