package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_XC_GM_Rongwei_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_XC_GM_Rongwei_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 35;
    public static final int U_AIR_AUTO = 37;
    public static final int U_AIR_AUTO_BLOW = 42;
    public static final int U_AIR_AUTO_REAR = 53;
    public static final int U_AIR_BEGIN = 33;
    public static final int U_AIR_BLOW_AUTO_LEFT = 44;
    public static final int U_AIR_BLOW_BODY_LEFT = 46;
    public static final int U_AIR_BLOW_BODY_REAR = 55;
    public static final int U_AIR_BLOW_FOOT_LEFT = 47;
    public static final int U_AIR_BLOW_FOOT_REAR = 56;
    public static final int U_AIR_BLOW_UP_LEFT = 45;
    public static final int U_AIR_BLOW_UP_REAR = 54;
    public static final int U_AIR_CYCLE = 38;
    public static final int U_AIR_ECO = 36;
    public static final int U_AIR_END = 59;
    public static final int U_AIR_FRONT_DEFROST = 41;
    public static final int U_AIR_POWER = 34;
    public static final int U_AIR_POWER_REAR = 52;
    public static final int U_AIR_REAR_DEFROST = 39;
    public static final int U_AIR_SEAT_HOT_LEFT = 50;
    public static final int U_AIR_SEAT_HOT_RIGHT = 51;
    public static final int U_AIR_TEMP_LEFT = 48;
    public static final int U_AIR_TEMP_REAR = 57;
    public static final int U_AIR_TEMP_RIGHT = 49;
    public static final int U_AIR_WIND_LEVEL_LEFT = 43;
    public static final int U_AIR_WIN_LEV_REAR = 58;
    public static final int U_AIR_ZONE = 40;
    public static final int U_ANJIXING_PHONE_STATE = 31;
    public static final int U_ANJIXING_STATE = 32;
    public static final int U_CARINFO_D05_D0_B10 = 10;
    public static final int U_CARINFO_D05_D0_B32 = 9;
    public static final int U_CARINFO_D05_D0_B54 = 8;
    public static final int U_CARINFO_D05_D0_B76 = 7;
    public static final int U_CARINFO_D05_D1_B0 = 82;
    public static final int U_CARINFO_D05_D1_B1 = 81;
    public static final int U_CARINFO_D05_D1_B32 = 80;
    public static final int U_CARINFO_D06_D0_B0 = 16;
    public static final int U_CARINFO_D06_D0_B21 = 15;
    public static final int U_CARINFO_D06_D0_B3 = 14;
    public static final int U_CARINFO_D06_D0_B4 = 13;
    public static final int U_CARINFO_D06_D0_B65 = 12;
    public static final int U_CARINFO_D06_D0_B7 = 11;
    public static final int U_CARINFO_D06_D1_B0 = 23;
    public static final int U_CARINFO_D06_D1_B1 = 22;
    public static final int U_CARINFO_D06_D1_B2 = 21;
    public static final int U_CARINFO_D06_D1_B3 = 20;
    public static final int U_CARINFO_D06_D1_B4 = 19;
    public static final int U_CARINFO_D06_D1_B65 = 18;
    public static final int U_CARINFO_D06_D1_B7 = 17;
    public static final int U_CARINFO_D06_D2_B2 = 29;
    public static final int U_CARINFO_D06_D2_B3 = 28;
    public static final int U_CARINFO_D06_D2_B4 = 27;
    public static final int U_CARINFO_D06_D2_B5 = 26;
    public static final int U_CARINFO_D06_D2_B6 = 25;
    public static final int U_CARINFO_D06_D2_B7 = 24;
    public static final int U_CARINFO_D16_D0_B10 = 62;
    public static final int U_CARINFO_D16_D0_B32 = 61;
    public static final int U_CARINFO_D16_D0_B76 = 60;
    public static final int U_CARINFO_D17_D0_B0 = 70;
    public static final int U_CARINFO_D17_D0_B1 = 69;
    public static final int U_CARINFO_D17_D0_B2 = 68;
    public static final int U_CARINFO_D17_D0_B3 = 67;
    public static final int U_CARINFO_D17_D0_B4 = 66;
    public static final int U_CARINFO_D17_D0_B5 = 65;
    public static final int U_CARINFO_D17_D0_B6 = 64;
    public static final int U_CARINFO_D17_D0_B7 = 63;
    public static final int U_CARINFO_D18_D0_D1 = 71;
    public static final int U_CARINFO_D18_D10_D11 = 77;
    public static final int U_CARINFO_D18_D12_D13 = 78;
    public static final int U_CARINFO_D18_D2_B70 = 72;
    public static final int U_CARINFO_D18_D3_D4 = 73;
    public static final int U_CARINFO_D18_D5_D6 = 74;
    public static final int U_CARINFO_D18_D7_B70 = 75;
    public static final int U_CARINFO_D18_D8_D9 = 76;
    public static final int U_CARINFO_D19_D0_B70 = 79;
    public static final int U_CARINFO_RADAR_ONOFF = 30;
    public static final int U_CNT_MAX = 83;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static String anjixingNumber;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 83; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_XC_GM_Rongwei_All(LauncherApplication.getInstance()));
        for (int i3 = 33; i3 < 59; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 33; i2 < 59; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 31:
                if (strs != null && strs.length > 0) {
                    anjixingNumber = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 83) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
