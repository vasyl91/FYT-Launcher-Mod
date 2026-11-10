package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0455_LZ_Honda_Screen;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Callback_0456_Sanwu_Toyota_Huangguan extends CallbackCanbusBase {
    public static final int U_CARSET_D68_D0_B0 = 107;
    public static final int U_CARSET_D68_D0_B1 = 108;
    public static final int U_CARSET_D68_D0_B2 = 109;
    public static final int U_CARSET_D68_D0_B3 = 110;
    public static final int U_CARSET_D68_D0_B4 = 111;
    public static final int U_CARSET_D68_D0_B5 = 112;
    public static final int U_CNT_MAX = 113;
    public static final int U_EXIST_TPMS = 98;
    public static final int U_PRESSURE_BACKUP = 106;
    public static final int U_PRESSURE_FL = 102;
    public static final int U_PRESSURE_FR = 103;
    public static final int U_PRESSURE_RL = 104;
    public static final int U_PRESSURE_RR = 105;
    public static final int U_SHOW_TIRE_BACKUP = 100;
    public static final int U_TIRE_SHOW_STATE = 101;
    public static final int U_TPMS_STATE = 99;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 113; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 <= 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0455_LZ_Honda_Screen(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 113) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
