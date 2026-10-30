package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0454_LZ_Bentley_MS;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0453_LUZ_Bentley_MS extends CallbackCanbusBase {
    public static final int U_CARINF_D35_D1_B70 = 98;
    public static final int U_CARINF_D35_D2_D3 = 99;
    public static final int U_CARINF_D35_D7_D8_D9_D10 = 100;
    public static final int U_CAR_AUDI_TYPE = 101;
    public static final int U_CNT_MAX = 102;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 102; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0454_LZ_Bentley_MS(TheApp.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 102) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
