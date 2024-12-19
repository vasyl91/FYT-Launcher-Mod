package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0151_DAOJUN_XP1_BYDG6;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0151_DAOJUN_XP1_BYDG6 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 24;
    public static final int U_AIR_AUTO = 20;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BEGIN2 = 19;
    public static final int U_AIR_BIG_LIGHT = 32;
    public static final int U_AIR_BLOW_BODY_LEFT = 26;
    public static final int U_AIR_BLOW_FOOT_LEFT = 27;
    public static final int U_AIR_BLOW_UP_LEFT = 28;
    public static final int U_AIR_CYCLE = 21;
    public static final int U_AIR_DATA1 = 10;
    public static final int U_AIR_DATA2 = 11;
    public static final int U_AIR_DATA3 = 12;
    public static final int U_AIR_DATA4 = 13;
    public static final int U_AIR_DATA5 = 14;
    public static final int U_AIR_DATA6 = 15;
    public static final int U_AIR_DATA7 = 16;
    public static final int U_AIR_DUAL = 30;
    public static final int U_AIR_END = 33;
    public static final int U_AIR_FRONT_DEFROST = 22;
    public static final int U_AIR_REAR_DEFROST = 23;
    public static final int U_AIR_TEMP_LEFT = 25;
    public static final int U_AIR_TEMP_RIGHT = 31;
    public static final int U_AIR_WIND_LEVEL_LEFT = 29;
    public static final int U_AMP_SWITCH = 18;
    public static final int U_CNT_MAX = 34;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_RADAR_SWITCH = 17;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 34; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0151_DAOJUN_XP1_BYDG6(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 33; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 33; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 34) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
