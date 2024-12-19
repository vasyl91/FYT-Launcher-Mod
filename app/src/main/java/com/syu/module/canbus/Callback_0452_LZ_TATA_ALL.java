package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_TATA_ALL;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_LZ_TATA_ALL extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY = 15;
    public static final int U_AIR_BLOW_FOOT = 16;
    public static final int U_AIR_BLOW_UP = 14;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_ECO = 20;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_SYNC = 11;
    public static final int U_AIR_TEMP_LEFT = 18;
    public static final int U_AIR_TEMP_RIGHT = 19;
    public static final int U_AIR_TEMP_UNIT = 21;
    public static final int U_AIR_WIND_LEVEL = 17;
    public static final int U_CARINF_BEGIN = 23;
    public static final int U_CARINF_D38_D0_B10 = 24;
    public static final int U_CARINF_D38_D0_B32 = 25;
    public static final int U_CARINF_D38_D0_B4 = 26;
    public static final int U_CARINF_D38_D1_B0 = 27;
    public static final int U_CARINF_D38_D1_B1 = 28;
    public static final int U_CARINF_D38_D1_B32 = 29;
    public static final int U_CARINF_D38_D1_B54 = 30;
    public static final int U_CARINF_D38_D1_B6 = 31;
    public static final int U_CARINF_D38_D1_B7 = 32;
    public static final int U_CARINF_D38_D2_B30 = 33;
    public static final int U_CARINF_D38_D2_B74 = 34;
    public static final int U_CARINF_D38_D3_B70 = 35;
    public static final int U_CNT_MAX = 36;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 36; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_TATA_ALL(LauncherApplication.getInstance()));
        for (int i3 = 6; i3 < 22; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 6; i < 22; i++) {
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
        if (updateCode >= 0 && updateCode < 36) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
