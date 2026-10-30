package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0339_RZC4_PSA_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0217_RZC4_PSA13_408 extends CallbackCanbusBase {
    public static final int U_AVERAGE_OIL_COST = 99;
    public static final int U_AVERAGE_OIL_COST_2 = 105;
    public static final int U_AVERAGE_SPEED = 100;
    public static final int U_AVERAGE_SPEED_2 = 107;
    public static final int U_CARINFO_CUR_PAGE = 109;
    public static final int U_CAR_BEGIN = 98;
    public static final int U_CAR_END = 110;
    public static final int U_CNT_MAX = 111;
    public static final int U_CUR_OIL_EXPEND = 101;
    public static final int U_DRIVING_MILEAGE = 102;
    public static final int U_JUMP_CARINFO = 108;
    public static final int U_OPTIMAL_OIL_EXPEND = 103;
    public static final int U_TOTAL_MILES = 104;
    public static final int U_TOTAL_MILES_2 = 106;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 111; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
        AirHelper.getInstance().buildUi(new Air_0339_RZC4_PSA_All(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
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
        if (updateCode >= 0 && updateCode < 111) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
