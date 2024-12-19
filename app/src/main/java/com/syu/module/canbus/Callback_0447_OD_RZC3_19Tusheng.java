package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0447_OD_RZC_19Tusheng;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0447_OD_RZC3_19Tusheng extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_AUTO_LEFT = 13;
    public static final int U_AIR_BLOW_BODY_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_UP_LEFT = 9;
    public static final int U_AIR_BLOW_WIN_LEFT = 14;
    public static final int U_AIR_CLEAR = 23;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_END = 16;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_POWER = 12;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_SHOW = 24;
    public static final int U_AIR_SYNC = 15;
    public static final int U_AIR_TEMP_LEFT = 6;
    public static final int U_AIR_TEMP_REAR = 78;
    public static final int U_AIR_TEMP_RIGHT = 11;
    public static final int U_AIR_WIND_LEVEL_LEFT = 10;
    public static final int U_AIR_WIND_LEVEL_REAR = 77;
    public static final int U_CARINFO_D52_D10_B70 = 97;
    public static final int U_CARINFO_D52_D11_B70 = 98;
    public static final int U_CARINFO_D52_D12_B70 = 99;
    public static final int U_CARINFO_D52_D13_B70 = 121;
    public static final int U_CARINFO_D52_D14_B70 = 122;
    public static final int U_CARINFO_D52_D20_B70 = 79;
    public static final int U_CARINFO_D52_D21_B70 = 80;
    public static final int U_CARINFO_D52_D22_B70 = 81;
    public static final int U_CARINFO_D52_D23_B70 = 82;
    public static final int U_CARINFO_D52_D30_B70 = 83;
    public static final int U_CARINFO_D52_D31_B70 = 84;
    public static final int U_CARINFO_D52_D32_B70 = 85;
    public static final int U_CARINFO_D52_D33_B70 = 86;
    public static final int U_CARINFO_D52_D34_B70 = 87;
    public static final int U_CARINFO_D52_D35_B70 = 88;
    public static final int U_CARINFO_D52_D36_B70 = 89;
    public static final int U_CARINFO_D52_D37_D1_D2 = 90;
    public static final int U_CARINFO_D52_D38_D1_D2 = 91;
    public static final int U_CARINFO_D52_D40_B70 = 92;
    public static final int U_CARINFO_D52_D50_B70 = 93;
    public static final int U_CARINFO_D52_D60_B70 = 94;
    public static final int U_CARINFO_D52_D61_B70 = 95;
    public static final int U_CARINFO_D52_D62_B70 = 96;
    public static final int U_CARINFO_D52_D70_B70 = 100;
    public static final int U_CARINFO_D52_D71_B70 = 101;
    public static final int U_CARINFO_D52_D72_B70 = 102;
    public static final int U_CARINFO_D52_D73_B70 = 103;
    public static final int U_CARINFO_D52_D7_B70 = 36;
    public static final int U_CARINFO_D52_D80_B70 = 104;
    public static final int U_CARINFO_D52_D81_B70 = 105;
    public static final int U_CARINFO_D52_D82_B70 = 106;
    public static final int U_CARINFO_D52_D83_B70 = 107;
    public static final int U_CARINFO_D52_D8_B70 = 37;
    public static final int U_CARINFO_D52_D90_B70 = 108;
    public static final int U_CARINFO_D52_D91_B70 = 109;
    public static final int U_CARINFO_D52_D92_B70 = 110;
    public static final int U_CARINFO_D52_D9_B70 = 38;
    public static final int U_CARINFO_D52_DA0_B70 = 111;
    public static final int U_CARINFO_D52_DA1_B70 = 112;
    public static final int U_CARINFO_D52_DA2_B70 = 113;
    public static final int U_CARINFO_D52_DA3_B70 = 114;
    public static final int U_CARINFO_D52_DA4_B70 = 115;
    public static final int U_CARINFO_D52_DA_B70 = 39;
    public static final int U_CARINFO_D52_DB_B70 = 40;
    public static final int U_CARINFO_D52_DC_B70 = 41;
    public static final int U_CARINFO_D52_DD_B70 = 42;
    public static final int U_CARINFO_D52_DE_B70 = 43;
    public static final int U_CARINFO_D52_DF_B70 = 44;
    public static final int U_CARINFO_D53_D0_B70 = 45;
    public static final int U_CARINFO_D53_D10_B10 = 60;
    public static final int U_CARINFO_D53_D10_B32 = 59;
    public static final int U_CARINFO_D53_D10_B4 = 58;
    public static final int U_CARINFO_D53_D10_B5 = 57;
    public static final int U_CARINFO_D53_D10_B6 = 56;
    public static final int U_CARINFO_D53_D10_B7 = 55;
    public static final int U_CARINFO_D53_D11_B70 = 61;
    public static final int U_CARINFO_D53_D1_B70 = 46;
    public static final int U_CARINFO_D53_D2_B70 = 47;
    public static final int U_CARINFO_D53_D3_B70 = 48;
    public static final int U_CARINFO_D53_D4_B70 = 49;
    public static final int U_CARINFO_D53_D5_B70 = 50;
    public static final int U_CARINFO_D53_D6_B70 = 51;
    public static final int U_CARINFO_D53_D7_B70 = 52;
    public static final int U_CARINFO_D53_D8_B70 = 53;
    public static final int U_CARINFO_D53_D9_B70 = 54;
    public static final int U_CARINFO_D54_D0_B70 = 62;
    public static final int U_CARINFO_D54_D10_D11 = 68;
    public static final int U_CARINFO_D54_D1_D2 = 63;
    public static final int U_CARINFO_D54_D3_D4 = 64;
    public static final int U_CARINFO_D54_D5_B70 = 65;
    public static final int U_CARINFO_D54_D6_B70 = 66;
    public static final int U_CARINFO_D54_D7_D8_D9 = 67;
    public static final int U_CARINFO_D55_D0_D1 = 69;
    public static final int U_CARINFO_D55_D11_B30 = 76;
    public static final int U_CARINFO_D55_D11_B74 = 75;
    public static final int U_CARINFO_D55_D2_D3 = 70;
    public static final int U_CARINFO_D55_D4_D5 = 71;
    public static final int U_CARINFO_D55_D6_B70 = 72;
    public static final int U_CARINFO_D55_D7_D8 = 73;
    public static final int U_CARINFO_D55_D9_D10 = 74;
    public static final int U_CARINFO_EQ_BAL = 120;
    public static final int U_CARINFO_EQ_BASS = 116;
    public static final int U_CARINFO_EQ_FAD = 119;
    public static final int U_CARINFO_EQ_MID = 117;
    public static final int U_CARINFO_EQ_TREB = 118;
    public static final int U_CARINFO_LAGUAGE = 123;
    public static final int U_CARSET_AUTO_TEMP_CTRL = 31;
    public static final int U_CARSET_BEGIN = 25;
    public static final int U_CARSET_BLIND_POINT = 30;
    public static final int U_CARSET_GUIJI = 26;
    public static final int U_CARSET_RADAR = 27;
    public static final int U_CARSET_SEAT_HOTBLOW = 35;
    public static final int U_CARSET_STEER_HOT = 34;
    public static final int U_CARSET_THIRD_SEAT_LEFT = 32;
    public static final int U_CARSET_THIRD_SEAT_RIGHT = 33;
    public static final int U_CARSET_VIEW_FRONT = 28;
    public static final int U_CARSET_VIEW_REAR = 29;
    public static final int U_CNT_MAX = 124;
    public static final int U_DOOR_BACK = 21;
    public static final int U_DOOR_BEGIN = 16;
    public static final int U_DOOR_END = 22;
    public static final int U_DOOR_ENGINE = 16;
    public static final int U_DOOR_FL = 17;
    public static final int U_DOOR_FR = 18;
    public static final int U_DOOR_RL = 19;
    public static final int U_DOOR_RR = 20;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 124; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 16;
        DoorHelper.sUcDoorFl = 17;
        DoorHelper.sUcDoorFr = 18;
        DoorHelper.sUcDoorRl = 19;
        DoorHelper.sUcDoorRr = 20;
        DoorHelper.sUcDoorBack = 21;
        AirHelper.getInstance().buildUi(new Air_0447_OD_RZC_19Tusheng(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i3 = 16; i3 < 22; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i4 = 0; i4 < 16; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[77].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[78].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 16; i < 22; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 16; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 124) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    if (strs != null && strs.length > 0) {
                        ConstRzcAddData.CarFrameNum = strs[0];
                    } else {
                        ConstRzcAddData.CarFrameNum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
