package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_OD_Weima_EX5 extends CallbackCanbusBase {
    public static final int U_AIR_AUTO = 9;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 14;
    public static final int U_AIR_BLOW_FOOT_LEFT = 15;
    public static final int U_AIR_BLOW_UP_LEFT = 13;
    public static final int U_AIR_CYCLE = 8;
    public static final int U_AIR_END = 20;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_PTC = 19;
    public static final int U_AIR_REAR_DEFROST = 11;
    public static final int U_AIR_SYNC = 10;
    public static final int U_AIR_TEMP_LEFT = 17;
    public static final int U_AIR_TEMP_RIGHT = 18;
    public static final int U_AIR_WIND_LEVEL_LEFT = 16;
    public static final int U_CARSET_D41_D0_B10 = 38;
    public static final int U_CARSET_D41_D0_B4 = 37;
    public static final int U_CARSET_D41_D0_B5 = 36;
    public static final int U_CARSET_D41_D0_B6 = 35;
    public static final int U_CARSET_D41_D0_B7 = 34;
    public static final int U_CARSET_D41_D1_B70 = 39;
    public static final int U_CARSET_D41_D2_B70 = 40;
    public static final int U_CARSET_D41_D3_B0 = 48;
    public static final int U_CARSET_D41_D3_B1 = 47;
    public static final int U_CARSET_D41_D3_B2 = 46;
    public static final int U_CARSET_D41_D3_B3 = 45;
    public static final int U_CARSET_D41_D3_B4 = 44;
    public static final int U_CARSET_D41_D3_B5 = 43;
    public static final int U_CARSET_D41_D3_B6 = 42;
    public static final int U_CARSET_D41_D3_B7 = 41;
    public static final int U_CNT_MAX = 49;
    public static final int U_TIRE_BEGIN = 20;
    public static final int U_TIRE_END = 33;
    public static final int U_TIRE_FL_WARN = 29;
    public static final int U_TIRE_FR_WARN = 30;
    public static final int U_TIRE_PRESSURE_FL = 21;
    public static final int U_TIRE_PRESSURE_FR = 22;
    public static final int U_TIRE_PRESSURE_RL = 23;
    public static final int U_TIRE_PRESSURE_RR = 24;
    public static final int U_TIRE_RL_WARN = 32;
    public static final int U_TIRE_RR_WARN = 31;
    public static final int U_TIRE_TEMP_FL = 25;
    public static final int U_TIRE_TEMP_FR = 26;
    public static final int U_TIRE_TEMP_RL = 27;
    public static final int U_TIRE_TEMP_RR = 28;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 49; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
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
        if (updateCode >= 0 && updateCode < 49) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
