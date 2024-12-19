package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_CYT_Hyundai_VERACRUZ extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 14;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY = 11;
    public static final int U_AIR_BLOW_FOOT = 12;
    public static final int U_AIR_BLOW_MODE = 13;
    public static final int U_AIR_BLOW_UP = 10;
    public static final int U_AIR_CYCLE = 19;
    public static final int U_AIR_DUAL = 16;
    public static final int U_AIR_END = 21;
    public static final int U_AIR_FRONT_DEFROST = 17;
    public static final int U_AIR_REAR = 20;
    public static final int U_AIR_REAR_DEFROST = 18;
    public static final int U_AIR_TEMP_LEFT = 7;
    public static final int U_AIR_TEMP_RIGHT = 8;
    public static final int U_AIR_WIND_LEVEL = 9;
    public static final int U_CNT_MAX = 21;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 21; i++) {
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
        if (updateCode >= 0 && updateCode < 21) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
