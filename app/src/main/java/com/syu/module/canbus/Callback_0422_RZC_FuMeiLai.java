package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0422_RZC_FuMeiLai;
import com.syu.ui.air.Air_0422_RZC_HaiMaS5YOUNG;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0422_RZC_FuMeiLai extends CallbackCanbusBase {
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_AUTO = 22;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 18;
    public static final int U_AIR_BLOW_FOOT_LEFT = 19;
    public static final int U_AIR_BLOW_MODE = 20;
    public static final int U_AIR_BLOW_UP_LEFT = 17;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 15;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_TEMP_LEFT = 21;
    public static final int U_AIR_TEMP_LEFT_2 = 23;
    public static final int U_AIR_WIND_LEFT = 16;
    public static final int U_CARSET_BEGIN = 25;
    public static final int U_CARSET_D40_D2_B70 = 29;
    public static final int U_CARSET_LIGHT_HOME = 26;
    public static final int U_CARSET_LIGHT_HOME_TIME = 27;
    public static final int U_CARSET_ROAD_AWAY = 28;
    public static final int U_CNT_MAX = 30;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 30; i++) {
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
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        if (carId == 2 || carId == 4 || carId == 5) {
            AirHelper.getInstance().buildUi(new Air_0422_RZC_HaiMaS5YOUNG(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0422_RZC_FuMeiLai(LauncherApplication.getInstance()));
        }
        for (int i3 = 10; i3 < 24; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 30) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
