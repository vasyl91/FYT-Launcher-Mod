package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0443_WC2_18FENGGUANG_S560;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_Jili_GC7 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 4;
    public static final int U_AIR_AUTO = 3;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 9;
    public static final int U_AIR_BLOW_FOOT_LEFT = 10;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_END = 12;
    public static final int U_AIR_FRONT_DEFROST = 6;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 5;
    public static final int U_AIR_TEMP_LEFT = 7;
    public static final int U_AIR_WIND_LEVEL = 11;
    public static final int U_CNT_MAX = 12;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 12; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0443_WC2_18FENGGUANG_S560(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 12; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
