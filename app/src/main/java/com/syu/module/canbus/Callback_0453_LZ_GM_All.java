package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_GM_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AC_AUTO = 25;
    public static final int U_AIR_AQS = 22;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_AUTO_LEFT = 18;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_DUAL = 12;
    public static final int U_AIR_ECO = 23;
    public static final int U_AIR_END = 29;
    public static final int U_AIR_MAX_FRONT = 13;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_SEAT_HEAT_LEFT = 27;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 28;
    public static final int U_AIR_SHOW = 7;
    public static final int U_AIR_TEMP_LEFT = 20;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_TEMP_UNIT = 26;
    public static final int U_AIR_WIND_LEVEL_AUTO = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 19;
    public static final int U_CARSET_D35_D10_B70 = 55;
    public static final int U_CARSET_D35_D11_B6 = 57;
    public static final int U_CARSET_D35_D11_B7 = 56;
    public static final int U_CARSET_D35_D2_D3 = 53;
    public static final int U_CARSET_D35_D7_D8_D9 = 54;
    public static final int U_CARSET_D36_D0_D1 = 58;
    public static final int U_CARSET_D36_D2_B70 = 59;
    public static final int U_CARSET_D36_D3_B70 = 60;
    public static final int U_CARSET_D36_D4_B70 = 61;
    public static final int U_CARSET_D38_D0_B0 = 30;
    public static final int U_CARSET_D38_D0_B1 = 31;
    public static final int U_CARSET_D38_D0_B32 = 32;
    public static final int U_CARSET_D38_D0_B54 = 33;
    public static final int U_CARSET_D38_D0_B76 = 34;
    public static final int U_CARSET_D38_D1_B10 = 35;
    public static final int U_CARSET_D38_D1_B3 = 36;
    public static final int U_CARSET_D38_D2_B0 = 37;
    public static final int U_CARSET_D38_D2_B21 = 38;
    public static final int U_CARSET_D38_D2_B3 = 39;
    public static final int U_CARSET_D38_D2_B4 = 40;
    public static final int U_CARSET_D38_D2_B65 = 41;
    public static final int U_CARSET_D38_D2_B7 = 42;
    public static final int U_CARSET_D38_D3_B0 = 43;
    public static final int U_CARSET_D38_D3_B1 = 44;
    public static final int U_CARSET_D38_D3_B2 = 45;
    public static final int U_CARSET_D38_D3_B3 = 46;
    public static final int U_CARSET_D38_D3_B4 = 47;
    public static final int U_CARSET_D38_D3_B65 = 48;
    public static final int U_CARSET_D38_D3_B7 = 49;
    public static final int U_CARSET_D38_D4_B70 = 50;
    public static final int U_CARSET_D38_D5_B70 = 51;
    public static final int U_CARSET_D39_D0_B70 = 52;
    public static final int U_CNT_MAX = 62;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 62; i++) {
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
        if (updateCode >= 0 && updateCode < 62) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
