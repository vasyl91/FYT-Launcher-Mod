package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_RZC_Mclaren_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_COOL = 23;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_HEAT = 22;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_SEAT_HOT_LEFT = 20;
    public static final int U_AIR_SEAT_HOT_RIGHT = 21;
    public static final int U_AIR_SYNC = 11;
    public static final int U_AIR_TEMP_LEFT = 18;
    public static final int U_AIR_TEMP_RIGHT = 19;
    public static final int U_AIR_WIND_LEVEL = 17;
    public static final int U_CAREQ_D62_D00_B70 = 54;
    public static final int U_CAREQ_D62_D01_B70 = 55;
    public static final int U_CAREQ_D62_D02_B70 = 56;
    public static final int U_CAREQ_D62_D03_B70 = 57;
    public static final int U_CAREQ_D62_D04_B70 = 58;
    public static final int U_CAREQ_D62_D05_B30 = 60;
    public static final int U_CAREQ_D62_D05_B74 = 59;
    public static final int U_CAREQ_D62_D06_B70 = 61;
    public static final int U_CARINFO_BEGIN = 25;
    public static final int U_CARINFO_D40_D0A_B70 = 34;
    public static final int U_CARINFO_D40_D0B_B70 = 35;
    public static final int U_CARINFO_D40_D0C_B70 = 36;
    public static final int U_CARINFO_D40_D0E_B70 = 37;
    public static final int U_CARINFO_D40_D0F_B70 = 38;
    public static final int U_CARINFO_D40_D10_B70 = 39;
    public static final int U_CARINFO_D40_D1_B70 = 26;
    public static final int U_CARINFO_D40_D20_B70 = 40;
    public static final int U_CARINFO_D40_D21_B70 = 41;
    public static final int U_CARINFO_D40_D22_B70 = 42;
    public static final int U_CARINFO_D40_D23_B70 = 43;
    public static final int U_CARINFO_D40_D24_B70 = 44;
    public static final int U_CARINFO_D40_D25_B70 = 45;
    public static final int U_CARINFO_D40_D26_B70 = 46;
    public static final int U_CARINFO_D40_D26_D2_B30 = 63;
    public static final int U_CARINFO_D40_D26_D2_B74 = 62;
    public static final int U_CARINFO_D40_D27_B70 = 47;
    public static final int U_CARINFO_D40_D28_B70 = 48;
    public static final int U_CARINFO_D40_D2_B70 = 27;
    public static final int U_CARINFO_D40_D30_B70 = 49;
    public static final int U_CARINFO_D40_D31_B70 = 50;
    public static final int U_CARINFO_D40_D32_B70 = 51;
    public static final int U_CARINFO_D40_D33_B70 = 52;
    public static final int U_CARINFO_D40_D34_B70 = 53;
    public static final int U_CARINFO_D40_D3_B70 = 28;
    public static final int U_CARINFO_D40_D4_B70 = 29;
    public static final int U_CARINFO_D40_D6_B70 = 30;
    public static final int U_CARINFO_D40_D7_B70 = 31;
    public static final int U_CARINFO_D40_D8_B70 = 32;
    public static final int U_CARINFO_D40_D9_B70 = 33;
    public static final int U_CNT_MAX = 64;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 64; i++) {
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
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
