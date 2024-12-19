package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0004_FYT1_DongNanV5;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0004_FYT1_DongNanV5 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 3;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_FOOT = 7;
    public static final int U_AIR_BLOW_UP = 6;
    public static final int U_AIR_BLOW_WIN = 5;
    public static final int U_AIR_CYCLE = 1;
    public static final int U_AIR_END = 9;
    public static final int U_AIR_MAX = 0;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_TEMPERATURE = 8;
    public static final int U_AIR_WIND_LEVEL = 2;
    public static final int U_CNT_MAX = 10;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 10; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0004_FYT1_DongNanV5(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 9; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 9; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 10) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
