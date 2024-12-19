package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0376_SBD_RuiFengS5;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0376_SBD_WC1_ForeginVersionRuiFengS5 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_AUTO = 17;
    public static final int U_AIR_BLOW_BODY_LEFT = 15;
    public static final int U_AIR_BLOW_FOOT_LEFT = 16;
    public static final int U_AIR_BLOW_MODE = 18;
    public static final int U_AIR_BLOW_WIN_LEFT = 14;
    public static final int U_AIR_END = 19;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_WIND_LEFT = 13;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_END = 67;
    public static final int U_CNT_MAX = 68;
    public static final int U_PRESSURE_FL = 55;
    public static final int U_PRESSURE_FR = 56;
    public static final int U_PRESSURE_RL = 57;
    public static final int U_PRESSURE_RR = 58;
    public static final int U_TEMP_FL = 51;
    public static final int U_TEMP_FR = 52;
    public static final int U_TEMP_RL = 53;
    public static final int U_TEMP_RR = 54;
    public static final int U_TEMP_WARN_FLW = 60;
    public static final int U_TEMP_WARN_FL_H = 59;
    public static final int U_TEMP_WARN_FRW = 62;
    public static final int U_TEMP_WARN_FR_H = 61;
    public static final int U_TEMP_WARN_RLW = 64;
    public static final int U_TEMP_WARN_RL_H = 63;
    public static final int U_TEMP_WARN_RRW = 66;
    public static final int U_TEMP_WARN_RR_H = 65;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 68; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0376_SBD_RuiFengS5(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 19; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 19; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 68) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
