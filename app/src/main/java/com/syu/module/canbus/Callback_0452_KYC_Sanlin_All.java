package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_KYC_Sanlin_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 16;
    public static final int U_AIR_AUTO = 15;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 11;
    public static final int U_AIR_CYCLE = 18;
    public static final int U_AIR_END = 20;
    public static final int U_AIR_MAX_FRONT = 20;
    public static final int U_AIR_REAR_CTRL = 14;
    public static final int U_AIR_REAR_DEFROST = 19;
    public static final int U_AIR_SYNC = 17;
    public static final int U_AIR_TEMP_LEFT = 8;
    public static final int U_AIR_TEMP_RIGHT = 9;
    public static final int U_AIR_WIND_LEVEL_LEFT = 10;
    public static final int U_CARINF_D40_D3_B70 = 36;
    public static final int U_CARINF_D41_D0_B70 = 37;
    public static final int U_CARINF_D41_D10_B70 = 47;
    public static final int U_CARINF_D41_D11_B70 = 48;
    public static final int U_CARINF_D41_D12_B70 = 49;
    public static final int U_CARINF_D41_D13_B70 = 50;
    public static final int U_CARINF_D41_D1_B70 = 38;
    public static final int U_CARINF_D41_D2_B70 = 39;
    public static final int U_CARINF_D41_D3_B70 = 40;
    public static final int U_CARINF_D41_D4_B70 = 41;
    public static final int U_CARINF_D41_D5_B70 = 42;
    public static final int U_CARINF_D41_D6_B70 = 43;
    public static final int U_CARINF_D41_D7_B70 = 44;
    public static final int U_CARINF_D41_D8_B70 = 45;
    public static final int U_CARINF_D41_D9_B70 = 46;
    public static final int U_CARSET_LEFT_OR_RIGHT = 51;
    public static final int U_CNT_MAX = 52;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_PRESSURE_BACK = 25;
    public static final int U_PRESSURE_FL = 21;
    public static final int U_PRESSURE_FR = 22;
    public static final int U_PRESSURE_RL = 23;
    public static final int U_PRESSURE_RR = 24;
    public static final int U_TEMP_BACK = 30;
    public static final int U_TEMP_FL = 26;
    public static final int U_TEMP_FR = 27;
    public static final int U_TEMP_RL = 28;
    public static final int U_TEMP_RR = 29;
    public static final int U_WARNING_BACK = 35;
    public static final int U_WARNING_FL = 31;
    public static final int U_WARNING_FR = 32;
    public static final int U_WARNING_RL = 33;
    public static final int U_WARNING_RR = 34;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 52; i++) {
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
        if (updateCode >= 0 && updateCode < 52) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
