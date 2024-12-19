package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0219_DJ_ChangAnYueXiangV7;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0219_DJ_ChangAnYueXiangV7 extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 2;
    public static final int U_AIR_BLOW_FOOT_LEFT = 3;
    public static final int U_AIR_BLOW_UP_LEFT = 4;
    public static final int U_AIR_END = 7;
    public static final int U_AIR_FRONT_DEFROST = 1;
    public static final int U_AIR_POWER = 6;
    public static final int U_AIR_WIND_LEVEL_LEFT = 5;
    public static final int U_CNT_MAX = 7;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 7; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0219_DJ_ChangAnYueXiangV7(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 7; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 7; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 7) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
