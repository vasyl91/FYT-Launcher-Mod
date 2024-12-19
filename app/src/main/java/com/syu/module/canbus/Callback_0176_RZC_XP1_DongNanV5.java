package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0176_RZC_DongNanV5;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0176_RZC_XP1_DongNanV5 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 13;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_WIND_LEFT = 17;
    public static final int U_AIR_CYCLE = 11;
    public static final int U_AIR_END = 20;
    public static final int U_AIR_MAX = 18;
    public static final int U_AIR_REAR_DEFROST = 12;
    public static final int U_AIR_TEMP_LEFT = 14;
    public static final int U_AIR_WIND_LEVEL_LEFT = 19;
    public static final int U_CNT_MAX = 20;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 20; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0176_RZC_DongNanV5(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 20; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 20; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 20) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
