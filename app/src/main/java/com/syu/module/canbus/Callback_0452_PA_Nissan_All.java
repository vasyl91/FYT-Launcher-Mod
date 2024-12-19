package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_PA_Nissan_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_UP_LEFT = 7;
    public static final int U_AIR_CYCLE = 11;
    public static final int U_AIR_DUAL = 18;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 16;
    public static final int U_AIR_MAXAC = 15;
    public static final int U_AIR_POWER = 13;
    public static final int U_AIR_REAR_DEFROST = 17;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_TEMP_UNIT = 51;
    public static final int U_AIR_WIND_LEVEL_LEFT = 14;
    public static final int U_CARSET_ALTITUDE = 68;
    public static final int U_CARSET_ANGLE = 71;
    public static final int U_CARSET_CALIBRATE = 74;
    public static final int U_CARSET_D4D_D0_D1 = 72;
    public static final int U_CARSET_D4D_D2_D3 = 73;
    public static final int U_CARSET_D5D_D0_B0 = 34;
    public static final int U_CARSET_D5D_D0_B1 = 65;
    public static final int U_CARSET_D5E_D0_B1 = 50;
    public static final int U_CARSET_D5E_D0_B2 = 49;
    public static final int U_CARSET_D5E_D0_B3 = 48;
    public static final int U_CARSET_D5E_D0_B4 = 47;
    public static final int U_CARSET_D5E_D0_B5 = 46;
    public static final int U_CARSET_D5E_D0_B6 = 45;
    public static final int U_CARSET_D5E_D0_B7 = 44;
    public static final int U_CARSET_D5F_D0_B0 = 29;
    public static final int U_CARSET_D5F_D0_B1 = 28;
    public static final int U_CARSET_D5F_D0_B2 = 27;
    public static final int U_CARSET_D5F_D0_B3 = 26;
    public static final int U_CARSET_D5F_D0_B4 = 25;
    public static final int U_CARSET_D5F_D0_B5 = 24;
    public static final int U_CARSET_D5F_D0_B6 = 23;
    public static final int U_CARSET_D5F_D0_B7 = 22;
    public static final int U_CARSET_D5F_D1_B70 = 30;
    public static final int U_CARSET_D5F_D2_B70 = 31;
    public static final int U_CARSET_D5F_D3_B70 = 32;
    public static final int U_CARSET_D5F_D4_B70 = 33;
    public static final int U_CARSET_D93_D0_B70 = 35;
    public static final int U_CARSET_D93_D1_B70 = 36;
    public static final int U_CARSET_D93_D2_B70 = 37;
    public static final int U_CARSET_D93_D3_B70 = 38;
    public static final int U_CARSET_D93_D4_B70 = 39;
    public static final int U_CARSET_D93_D5_B70 = 40;
    public static final int U_CARSET_D93_D6_B70 = 41;
    public static final int U_CARSET_D93_D7_B70 = 42;
    public static final int U_CARSET_D93_D8_B70 = 43;
    public static final int U_CARSET_D95_D0_B5 = 54;
    public static final int U_CARSET_D95_D0_B6 = 53;
    public static final int U_CARSET_D95_D0_B7 = 52;
    public static final int U_CARSET_D95_D1_B30 = 58;
    public static final int U_CARSET_D95_D1_B4 = 57;
    public static final int U_CARSET_D95_D1_B65 = 56;
    public static final int U_CARSET_D95_D1_B7 = 55;
    public static final int U_CARSET_D95_D2_B0 = 75;
    public static final int U_CARSET_D95_D2_B1 = 67;
    public static final int U_CARSET_D95_D2_B2 = 66;
    public static final int U_CARSET_D95_D2_B3 = 62;
    public static final int U_CARSET_D95_D2_B4 = 61;
    public static final int U_CARSET_D95_D2_B6 = 60;
    public static final int U_CARSET_D95_D2_B7 = 59;
    public static final int U_CARSET_D95_D3_B30 = 64;
    public static final int U_CARSET_D95_D3_B74 = 63;
    public static final int U_CARSET_LATITUDE = 70;
    public static final int U_CARSET_LONGITUDE = 69;
    public static final int U_CNT_MAX = 76;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 76; i++) {
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
        if (updateCode >= 0 && updateCode < 76) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
