package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Audi_A6;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_LZ_Audi_Q5_All extends CallbackCanbusBase {
    public static String CarVinID = "";
    public static final int U_AIR_AC = 18;
    public static final int U_AIR_ACMAX = 20;
    public static final int U_AIR_AUTO = 17;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_BODY_RIGHT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 16;
    public static final int U_AIR_BLOW_UP_LEFT = 11;
    public static final int U_AIR_BLOW_UP_RIGHT = 14;
    public static final int U_AIR_CYCLE = 23;
    public static final int U_AIR_END = 25;
    public static final int U_AIR_MAX_FRONT = 21;
    public static final int U_AIR_REAR_CTRL = 24;
    public static final int U_AIR_REAR_DEFROST = 22;
    public static final int U_AIR_SEAT_COLD_LEFT = 83;
    public static final int U_AIR_SEAT_COLD_RIGHT = 84;
    public static final int U_AIR_SEAT_HOT_LEFT = 81;
    public static final int U_AIR_SEAT_HOT_RIGHT = 82;
    public static final int U_AIR_SYNC = 19;
    public static final int U_AIR_TEMP_LEFT = 8;
    public static final int U_AIR_TEMP_RIGHT = 9;
    public static final int U_AIR_WIND_LEVEL = 10;
    public static final int U_CARINFO_D0E_D0_D1 = 55;
    public static final int U_CARINFO_D0E_D2_D3 = 56;
    public static final int U_CARINFO_D0E_D4_D5 = 57;
    public static final int U_CARINFO_D0E_D6_D7 = 58;
    public static final int U_CARINFO_D7D_D1_B70 = 26;
    public static final int U_CARINFO_D7E_D10_B70 = 60;
    public static final int U_CARINFO_D7E_D3_D4_D5 = 27;
    public static final int U_CARINFO_D7E_D8_D9 = 28;
    public static final int U_CARINFO_STR_VIN_ID = 59;
    public static final int U_CARSET_D0D_D0_B0 = 34;
    public static final int U_CARSET_D0D_D0_B1 = 33;
    public static final int U_CARSET_D0D_D0_B2 = 32;
    public static final int U_CARSET_D0D_D0_B3 = 31;
    public static final int U_CARSET_D0D_D0_B64 = 30;
    public static final int U_CARSET_D0D_D0_B7 = 29;
    public static final int U_CARSET_D0D_D10_B75 = 80;
    public static final int U_CARSET_D0D_D1_B0 = 42;
    public static final int U_CARSET_D0D_D1_B1 = 41;
    public static final int U_CARSET_D0D_D1_B2 = 40;
    public static final int U_CARSET_D0D_D1_B3 = 39;
    public static final int U_CARSET_D0D_D1_B4 = 38;
    public static final int U_CARSET_D0D_D1_B5 = 37;
    public static final int U_CARSET_D0D_D1_B6 = 36;
    public static final int U_CARSET_D0D_D1_B7 = 35;
    public static final int U_CARSET_D0D_D2_B70 = 43;
    public static final int U_CARSET_D0D_D3_B30 = 45;
    public static final int U_CARSET_D0D_D3_B74 = 44;
    public static final int U_CARSET_D0D_D4_B30 = 47;
    public static final int U_CARSET_D0D_D4_B74 = 46;
    public static final int U_CARSET_D0D_D5_B10 = 53;
    public static final int U_CARSET_D0D_D5_B32 = 52;
    public static final int U_CARSET_D0D_D5_B4 = 51;
    public static final int U_CARSET_D0D_D5_B5 = 50;
    public static final int U_CARSET_D0D_D5_B6 = 49;
    public static final int U_CARSET_D0D_D5_B7 = 48;
    public static final int U_CARSET_D0D_D6_B70 = 54;
    public static final int U_CARSET_D0D_D7_B0 = 67;
    public static final int U_CARSET_D0D_D7_B1 = 66;
    public static final int U_CARSET_D0D_D7_B2 = 65;
    public static final int U_CARSET_D0D_D7_B3 = 64;
    public static final int U_CARSET_D0D_D7_B4 = 63;
    public static final int U_CARSET_D0D_D7_B5 = 62;
    public static final int U_CARSET_D0D_D7_B76 = 61;
    public static final int U_CARSET_D0D_D8_B40 = 71;
    public static final int U_CARSET_D0D_D8_B5 = 70;
    public static final int U_CARSET_D0D_D8_B6 = 69;
    public static final int U_CARSET_D0D_D8_B7 = 68;
    public static final int U_CARSET_D0D_D9_B0 = 79;
    public static final int U_CARSET_D0D_D9_B1 = 78;
    public static final int U_CARSET_D0D_D9_B2 = 77;
    public static final int U_CARSET_D0D_D9_B3 = 76;
    public static final int U_CARSET_D0D_D9_B4 = 75;
    public static final int U_CARSET_D0D_D9_B5 = 74;
    public static final int U_CARSET_D0D_D9_B6 = 73;
    public static final int U_CARSET_D0D_D9_B7 = 72;
    public static final int U_CNT_MAX = 85;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 85; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Audi_A6(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 25; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 25; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 85) {
            switch (updateCode) {
                case 59:
                    if (strs != null && strs.length > 0) {
                        CarVinID = strs[0];
                    } else {
                        CarVinID = "";
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
