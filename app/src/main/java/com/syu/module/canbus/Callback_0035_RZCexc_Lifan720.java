package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0035_RZCexe_LiFan720;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0035_RZCexc_Lifan720 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 7;
    public static final int U_AIR_AQS = 12;
    public static final int U_AIR_BEGIN = 2;
    public static final int U_AIR_BLOW_AUTO_LEFT = 4;
    public static final int U_AIR_BLOW_BODY_LEFT = 14;
    public static final int U_AIR_BLOW_FOOT_LEFT = 15;
    public static final int U_AIR_BLOW_UP_LEFT = 13;
    public static final int U_AIR_BLOW_WIN_LEFT = 5;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_END = 18;
    public static final int U_AIR_POWER = 9;
    public static final int U_AIR_REAR_DEFROST = 11;
    public static final int U_AIR_SEAT_HEAT_LEFT = 16;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 17;
    public static final int U_AIR_TEMP_LEFT = 10;
    public static final int U_AIR_TEMP_RIGHT = 6;
    public static final int U_AIR_WIND_LEVEL = 8;
    public static final int U_CNT_MAX = 18;
    public static final int U_SET_RADAR_ON_OFF = 1;
    public static final int U_SET_WARN_VOL = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 18; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0035_RZCexe_LiFan720(LauncherApplication.getInstance()));
        for (int i2 = 2; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 2; i < 18; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 18) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
