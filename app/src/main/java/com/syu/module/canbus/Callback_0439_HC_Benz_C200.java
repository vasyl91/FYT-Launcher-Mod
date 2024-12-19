package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_HC_Benz_C200;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_HC_Benz_C200 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 10;
    public static final int U_AIR_AUTO = 12;
    public static final int U_AIR_BEGIN = 9;
    public static final int U_AIR_BLOW_AUTO_LEFT = 19;
    public static final int U_AIR_BLOW_BODY_LEFT = 22;
    public static final int U_AIR_BLOW_FOOT_LEFT = 21;
    public static final int U_AIR_BLOW_WIN_LEFT = 20;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_DUAL = 11;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_DEFROST = 15;
    public static final int U_AIR_FRONT_MAX = 16;
    public static final int U_AIR_POWER = 9;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_TEMP_LEFT = 24;
    public static final int U_AIR_TEMP_RIGHT = 25;
    public static final int U_AIR_TEMP_UNIT = 23;
    public static final int U_AIR_WIND_AUTO_LEFT = 17;
    public static final int U_AIR_WIND_LEVEL_LEFT = 18;
    public static final int U_CNT_MAX = 27;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 27; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_HC_Benz_C200(LauncherApplication.getInstance()));
        for (int i3 = 9; i3 < 26; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 9; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 27) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
