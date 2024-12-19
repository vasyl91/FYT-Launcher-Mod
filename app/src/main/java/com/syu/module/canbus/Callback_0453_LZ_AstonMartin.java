package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_AstonMartin extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_AUTO_BLOW = 20;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_AUTO_LEFT = 21;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_END = 23;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_TEMP_LEFT = 18;
    public static final int U_AIR_TEMP_RIGHT = 19;
    public static final int U_AIR_TEMP_UNIT = 22;
    public static final int U_AIR_WIND_LEVEL_LEFT = 17;
    public static final int U_CARINF_D36_VINID = 36;
    public static final int U_CARINF_D38_D0_B0 = 31;
    public static final int U_CARINF_D38_D0_B1 = 30;
    public static final int U_CARINF_D38_D0_B2 = 29;
    public static final int U_CARINF_D38_D0_B3 = 28;
    public static final int U_CARINF_D38_D0_B4 = 27;
    public static final int U_CARINF_D38_D0_B5 = 26;
    public static final int U_CARINF_D38_D0_B6 = 25;
    public static final int U_CARINF_D38_D0_B7 = 24;
    public static final int U_CARINF_D38_D1_B43 = 34;
    public static final int U_CARINF_D38_D1_B65 = 33;
    public static final int U_CARINF_D38_D1_B7 = 32;
    public static final int U_CARINF_D39_D7_D8_D9 = 35;
    public static final int U_CNT_MAX = 37;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static String VinId = "";

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 37; i++) {
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
        if (updateCode == 36) {
            if (strs != null && strs.length > 0) {
                VinId = strs[0];
            } else {
                VinId = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode >= 0 && updateCode < 37) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
