package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0423_CYT_F3;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0423_CYT_ShuPing_QiYaK3 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 17;
    public static final int U_AIR_AC_MAX = 31;
    public static final int U_AIR_AUTO = 33;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY = 25;
    public static final int U_AIR_BLOW_FOOT = 27;
    public static final int U_AIR_BLOW_UP = 24;
    public static final int U_AIR_CYCLE = 21;
    public static final int U_AIR_DATA0 = 10;
    public static final int U_AIR_DATA1 = 11;
    public static final int U_AIR_DATA2 = 12;
    public static final int U_AIR_DATA3 = 13;
    public static final int U_AIR_DATA4 = 14;
    public static final int U_AIR_DATA5 = 15;
    public static final int U_AIR_DUAL = 22;
    public static final int U_AIR_END = 35;
    public static final int U_AIR_FRONT_DEFROG = 32;
    public static final int U_AIR_POWER = 16;
    public static final int U_AIR_REAR_DEFROG = 23;
    public static final int U_AIR_TEMP_LEFT = 29;
    public static final int U_AIR_TEMP_RIGHT = 30;
    public static final int U_AIR_WIND_LEVEL = 28;
    public static final int U_AIR_WIND_MODE = 34;
    public static final int U_CNT_MAX = 36;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 36; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        if (DataCanbus.sCanbusId == 131495) {
            AirHelper.getInstance().buildUi(new Air_0423_CYT_F3(LauncherApplication.getInstance()));
            for (int i2 = 16; i2 < 35; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 35; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 36) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
