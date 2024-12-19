package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0226_FYTA_ChangAnYueXiangV7;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0226_FYTA_ChangAnYueXiangV7 extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_FOOT_LEFT = 2;
    public static final int U_AIR_BLOW_UP_LEFT = 3;
    public static final int U_AIR_END = 5;
    public static final int U_AIR_FRONT_DEFROST = 1;
    public static final int U_AIR_WIND_LEVEL_LEFT = 4;
    public static final int U_CNT_MAX = 5;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 5; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0226_FYTA_ChangAnYueXiangV7(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 5; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 5) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
