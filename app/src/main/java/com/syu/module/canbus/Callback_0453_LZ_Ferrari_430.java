package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_LZ_Ferrani_430;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0453_LZ_Ferrari_430 extends CallbackCanbusBase {
    public static final int U_AIR_AUTO = 17;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_AUTO_LEFT = 14;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_BLOW_WIN_LEFT = 11;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_END = 18;
    public static final int U_AIR_FRONT_DEFROST = 10;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_WIND_LEVEL_LEFT = 15;
    public static final int U_CNT_MAX = 19;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 19; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0453_LZ_Ferrani_430(LauncherApplication.getInstance()));
        for (int i2 = 7; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 18; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 19) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
