package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC1_Mzd37;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_MAZD_ALL extends CallbackCanbusBase {
    public static final int U_AIR_AC = 4;
    public static final int U_AIR_AUTO = 3;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 13;
    public static final int U_AIR_BLOW_BODY_RIGHT = 17;
    public static final int U_AIR_BLOW_FOOT_LEFT = 14;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 18;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_BLOW_UP_RIGHT = 16;
    public static final int U_AIR_CYCLE = 5;
    public static final int U_AIR_CYCLE_AUTO = 6;
    public static final int U_AIR_DUAL = 7;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_FRONT_DEFROST = 8;
    public static final int U_AIR_POWER = 2;
    public static final int U_AIR_REAR_DEFROST = 9;
    public static final int U_AIR_SEAT_HEAT_LEFT = 10;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 11;
    public static final int U_AIR_SHOW = 1;
    public static final int U_AIR_TEMP_LEFT = 20;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_WIND_LEVEL_LEFT = 15;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 19;
    public static final int U_CARCD_BEGIN = 30;
    public static final int U_CARCD_END = 38;
    public static final int U_CARCD_FOLD_INFO = 35;
    public static final int U_CARCD_ID3_INFO = 37;
    public static final int U_CARCD_PLAY_PROGRESS = 36;
    public static final int U_CARCD_PLAY_STATE = 31;
    public static final int U_CARCD_RDM_STATE = 33;
    public static final int U_CARCD_RPT_STATE = 32;
    public static final int U_CARCD_TRACK_INFO = 34;
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
    public static final int U_CNT_MAX = 110;
    public static final int U_DOOR_BACK = 28;
    public static final int U_DOOR_BEGIN = 23;
    public static final int U_DOOR_END = 29;
    public static final int U_DOOR_ENGINE = 23;
    public static final int U_DOOR_FL = 24;
    public static final int U_DOOR_FR = 25;
    public static final int U_DOOR_RL = 26;
    public static final int U_DOOR_RR = 27;
    public static final int U_SET_D78_D10_B10 = 64;
    public static final int U_SET_D78_D10_B2 = 63;
    public static final int U_SET_D78_D10_B3 = 62;
    public static final int U_SET_D78_D10_B4 = 61;
    public static final int U_SET_D78_D10_B5 = 60;
    public static final int U_SET_D78_D10_B6 = 59;
    public static final int U_SET_D78_D10_B7 = 58;
    public static final int U_SET_D78_D11_B0 = 69;
    public static final int U_SET_D78_D11_B21 = 68;
    public static final int U_SET_D78_D11_B3 = 67;
    public static final int U_SET_D78_D11_B4 = 66;
    public static final int U_SET_D78_D11_B75 = 65;
    public static final int U_SET_D78_D12_B0 = 74;
    public static final int U_SET_D78_D12_B21 = 73;
    public static final int U_SET_D78_D12_B43 = 72;
    public static final int U_SET_D78_D12_B65 = 71;
    public static final int U_SET_D78_D12_B7 = 70;
    public static final int U_SET_D78_D13_B10 = 79;
    public static final int U_SET_D78_D13_B2 = 78;
    public static final int U_SET_D78_D13_B3 = 77;
    public static final int U_SET_D78_D13_B54 = 76;
    public static final int U_SET_D78_D13_B76 = 75;
    public static final int U_SET_D78_D14_B10 = 86;
    public static final int U_SET_D78_D14_B2 = 85;
    public static final int U_SET_D78_D14_B3 = 84;
    public static final int U_SET_D78_D14_B4 = 83;
    public static final int U_SET_D78_D14_B5 = 82;
    public static final int U_SET_D78_D14_B6 = 81;
    public static final int U_SET_D78_D14_B7 = 80;
    public static final int U_SET_D78_D15_B10 = 91;
    public static final int U_SET_D78_D15_B2 = 90;
    public static final int U_SET_D78_D15_B43 = 89;
    public static final int U_SET_D78_D15_B5 = 88;
    public static final int U_SET_D78_D15_B76 = 87;
    public static final int U_SET_D78_D16_B43 = 93;
    public static final int U_SET_D78_D16_B75 = 92;
    public static final int U_SET_D78_D7_B10 = 42;
    public static final int U_SET_D78_D7_B2 = 41;
    public static final int U_SET_D78_D7_B43 = 40;
    public static final int U_SET_D78_D7_B75 = 39;
    public static final int U_SET_D78_D8_B10 = 48;
    public static final int U_SET_D78_D8_B2 = 47;
    public static final int U_SET_D78_D8_B3 = 46;
    public static final int U_SET_D78_D8_B4 = 45;
    public static final int U_SET_D78_D8_B5 = 44;
    public static final int U_SET_D78_D8_B76 = 43;
    public static final int U_SET_D78_D9_B0 = 57;
    public static final int U_SET_D78_D9_B1 = 51;
    public static final int U_SET_D78_D9_B42 = 50;
    public static final int U_SET_D78_D9_B75 = 49;
    public static final int U_SET_D79_D0_B1 = 54;
    public static final int U_SET_D79_D0_B62 = 53;
    public static final int U_SET_D79_D0_B7 = 52;
    public static final int U_SET_D79_D1_B30 = 56;
    public static final int U_SET_D79_D1_B74 = 55;
    public static String mId3Name;
    public static int mId3Type;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 110; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        if (DataCanbus.DATA[1000] == 786875) {
            DoorHelper.sUcDoorEngine = 23;
            DoorHelper.sUcDoorFl = 24;
            DoorHelper.sUcDoorFr = 25;
            DoorHelper.sUcDoorRl = 26;
            DoorHelper.sUcDoorRr = 27;
            DoorHelper.sUcDoorBack = 28;
            DoorHelper.getInstance().buildUi();
            for (int i2 = 23; i2 < 29; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
            }
        }
        if (DataCanbus.DATA[1000] == 393659 || DataCanbus.DATA[1000] == 459195 || DataCanbus.DATA[1000] == 524731 || DataCanbus.DATA[1000] == 852411 || DataCanbus.DATA[1000] == 590267 || DataCanbus.DATA[1000] == 1049019) {
            AirHelper.getInstance().buildUi(new Air_0443_WC1_Mzd37(LauncherApplication.getInstance()));
            for (int i3 = 0; i3 < 22; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        if (DataCanbus.DATA[1000] == 786875) {
            for (int i = 23; i < 29; i++) {
                DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
            }
            DoorHelper.getInstance().destroyUi();
        }
        if (DataCanbus.DATA[1000] == 393659 || DataCanbus.DATA[1000] == 459195 || DataCanbus.DATA[1000] == 524731 || DataCanbus.DATA[1000] == 852411 || DataCanbus.DATA[1000] == 590267 || DataCanbus.DATA[1000] == 1049019) {
            for (int i2 = 0; i2 < 22; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
            AirHelper.getInstance().destroyUi();
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 110) {
            if (updateCode == 37) {
                if (ints != null && ints.length >= 1) {
                    mId3Type = ints[0];
                    if (strs != null && strs.length > 0) {
                        mId3Name = strs[0];
                    } else {
                        mId3Name = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
