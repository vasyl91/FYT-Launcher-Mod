package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_PA_Ford_F150 extends CallbackCanbusBase {
    public static String Str_Line1 = null;
    public static String Str_Line2 = null;
    public static String Str_Line3 = null;
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 13;
    public static final int U_AIR_BLOW_FOOT_LEFT = 14;
    public static final int U_AIR_BLOW_SEAT_LEFT = 24;
    public static final int U_AIR_BLOW_SEAT_RIGHT = 25;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 27;
    public static final int U_AIR_FRONT_DEFROST = 18;
    public static final int U_AIR_HOT_STEER = 26;
    public static final int U_AIR_MAXAC = 20;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 19;
    public static final int U_AIR_SEAT_HEAT_LEFT = 22;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 23;
    public static final int U_AIR_SYNC = 11;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_TEMP_RIGHT = 17;
    public static final int U_AIR_TEMP_UNIT = 21;
    public static final int U_AIR_WIND_LEVEL_LEFT = 15;
    public static final int U_CARSET_ALTITUDE = 56;
    public static final int U_CARSET_ANGLE = 59;
    public static final int U_CARSET_CALIBRATE = 45;
    public static final int U_CARSET_D17_D0_B0 = 46;
    public static final int U_CARSET_D17_D1_B70 = 47;
    public static final int U_CARSET_D17_D2_B70 = 48;
    public static final int U_CARSET_D17_D3_B70 = 49;
    public static final int U_CARSET_D17_D4_B70 = 50;
    public static final int U_CARSET_D17_D5_B70 = 51;
    public static final int U_CARSET_D17_D6_B70 = 52;
    public static final int U_CARSET_D17_D7_B70 = 53;
    public static final int U_CARSET_D17_D8_B30 = 55;
    public static final int U_CARSET_D17_D8_B6 = 54;
    public static final int U_CARSET_D18_D0_B70 = 61;
    public static final int U_CARSET_D19_D0_B70 = 62;
    public static final int U_CARSET_D1A_D0_D15 = 63;
    public static final int U_CARSET_D1B_D0_B2 = 69;
    public static final int U_CARSET_D1B_D0_B3 = 68;
    public static final int U_CARSET_D1B_D0_B4 = 67;
    public static final int U_CARSET_D1B_D0_B5 = 66;
    public static final int U_CARSET_D1B_D0_B6 = 65;
    public static final int U_CARSET_D1B_D0_B7 = 64;
    public static final int U_CARSET_D1B_D1_B2 = 75;
    public static final int U_CARSET_D1B_D1_B3 = 74;
    public static final int U_CARSET_D1B_D1_B4 = 73;
    public static final int U_CARSET_D1B_D1_B5 = 72;
    public static final int U_CARSET_D1B_D1_B6 = 71;
    public static final int U_CARSET_D1B_D1_B7 = 70;
    public static final int U_CARSET_D1C_D0_D23 = 76;
    public static final int U_CARSET_D1D_D0_D23 = 77;
    public static final int U_CARSET_D1E_D0_B70 = 78;
    public static final int U_CARSET_D40_D00_D1_B70 = 43;
    public static final int U_CARSET_D40_D01_D1_B70 = 44;
    public static final int U_CARSET_D4D_D0_D1 = 41;
    public static final int U_CARSET_D4D_D2_D3 = 42;
    public static final int U_CARSET_D5D_D0_B0 = 40;
    public static final int U_CARSET_D5D_D0_B1 = 60;
    public static final int U_CARSET_D5F_D0_B0 = 35;
    public static final int U_CARSET_D5F_D0_B1 = 34;
    public static final int U_CARSET_D5F_D0_B2 = 33;
    public static final int U_CARSET_D5F_D0_B3 = 32;
    public static final int U_CARSET_D5F_D0_B4 = 31;
    public static final int U_CARSET_D5F_D0_B5 = 30;
    public static final int U_CARSET_D5F_D0_B6 = 29;
    public static final int U_CARSET_D5F_D0_B7 = 28;
    public static final int U_CARSET_D5F_D1_B70 = 36;
    public static final int U_CARSET_D5F_D2_B70 = 37;
    public static final int U_CARSET_D5F_D3_B70 = 38;
    public static final int U_CARSET_D5F_D4_B70 = 39;
    public static final int U_CARSET_LATITUDE = 58;
    public static final int U_CARSET_LONGITUDE = 57;
    public static final int U_CNT_MAX = 79;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 79; i++) {
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
        switch (updateCode) {
            case 63:
                if (strs != null && strs.length > 0) {
                    Str_Line1 = strs[0];
                } else {
                    Str_Line1 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            case 76:
                if (strs != null && strs.length > 0) {
                    Str_Line2 = strs[0];
                } else {
                    Str_Line2 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            case 77:
                if (strs != null && strs.length > 0) {
                    Str_Line3 = strs[0];
                } else {
                    Str_Line3 = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 79) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
