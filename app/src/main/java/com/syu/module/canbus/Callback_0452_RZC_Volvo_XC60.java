package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_RZC_Volvo_XC60;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_RZC_Volvo_XC60 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 1;
    public static final int U_AIR_AUTO = 3;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 8;
    public static final int U_AIR_BLOW_FOOT_LEFT = 9;
    public static final int U_AIR_BLOW_UP_LEFT = 7;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 4;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 5;
    public static final int U_AIR_POWER = 0;
    public static final int U_AIR_REAR_DEFROST = 6;
    public static final int U_AIR_SEAT_HOT_LEFT = 13;
    public static final int U_AIR_SEAT_HOT_RIGHT = 14;
    public static final int U_AIR_TEMP_LEFT = 11;
    public static final int U_AIR_TEMP_RIGHT = 12;
    public static final int U_AIR_WIND_LEVEL_LEFT = 10;
    public static final int U_CNT_MAX = 15;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 15; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = ConstRzcAddData.U_DOOR_ENGINE_ADD;
        DoorHelper.sUcDoorFl = ConstRzcAddData.U_DOOR_FL_ADD;
        DoorHelper.sUcDoorFr = ConstRzcAddData.U_DOOR_FR_ADD;
        DoorHelper.sUcDoorRl = ConstRzcAddData.U_DOOR_RL_ADD;
        DoorHelper.sUcDoorRr = ConstRzcAddData.U_DOOR_RR_ADD;
        DoorHelper.sUcDoorBack = ConstRzcAddData.U_DOOR_BACK_ADD;
        DoorHelper.getInstance().buildUi();
        for (int i3 = ConstRzcAddData.U_DOOR_ENGINE_ADD; i3 <= 558; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0452_RZC_Volvo_XC60(LauncherApplication.getInstance()));
        for (int i4 = 0; i4 < 15; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 15; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = ConstRzcAddData.U_DOOR_ENGINE_ADD; i2 <= 558; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 15) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode >= 500 && updateCode < 560) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
