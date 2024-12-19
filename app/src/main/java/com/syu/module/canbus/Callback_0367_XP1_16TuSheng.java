package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0367_XP_16TuSheng;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0367_XP1_16TuSheng extends CallbackCanbusBase {
    public static final int U_AIR_AC_MAX = 1;
    public static final int U_AIR_AUTO = 3;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY = 7;
    public static final int U_AIR_BLOW_FOOT = 8;
    public static final int U_AIR_BLOW_UP = 6;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 4;
    public static final int U_AIR_END = 12;
    public static final int U_AIR_FRONT_DEFROST = 5;
    public static final int U_AIR_POWER = 0;
    public static final int U_AIR_TEMP_LEFT = 10;
    public static final int U_AIR_TEMP_RIGHT = 11;
    public static final int U_AIR_WIND_LEVEL = 9;
    public static final int U_CNT_MAX = 12;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 12; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0367_XP_16TuSheng(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 12; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 12; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 12) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
