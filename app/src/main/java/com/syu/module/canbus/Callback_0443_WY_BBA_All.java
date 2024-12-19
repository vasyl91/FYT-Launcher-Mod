package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WY_BBA_All extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 9;
    public static final int U_AIR_END = 32;
    public static final int U_CARINF_D12_D5_B70 = 33;
    public static final int U_CARINF_D12_D6_B54 = 35;
    public static final int U_CARINF_D12_D6_B76 = 34;
    public static final int U_CARINF_D47_D0_B70 = 36;
    public static final int U_CARSET_BACKCAR_TYPE = 37;
    public static final int U_CARSET_CARUI_ONOFF = 39;
    public static final int U_CARSET_SPLIT_ONOFF = 38;
    public static final int U_CNT_MAX = 40;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 40; i++) {
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
        if (updateCode >= 0 && updateCode < 40) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
