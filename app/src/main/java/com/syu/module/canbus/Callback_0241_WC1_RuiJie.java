package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0241_WC1_RuiJie;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0241_WC1_RuiJie extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BIG_LIGHT = 20;
    public static final int U_AIR_BLOW_BODY_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_UP_LEFT = 9;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 17;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_FRONT_WIND_MODE = 22;
    public static final int U_AIR_MAX = 10;
    public static final int U_AIR_POWER = 19;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_REAR_TEMP_LEFT = 24;
    public static final int U_AIR_REAR_TEMP_RIGHT = 25;
    public static final int U_AIR_REAR_WIND_MODE = 23;
    public static final int U_AIR_SEAT_BLOW_HEAT_LEFT = 15;
    public static final int U_AIR_SEAT_BLOW_HEAT_RIGHT = 16;
    public static final int U_AIR_SEAT_HEAT_LEFT = 13;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 14;
    public static final int U_AIR_TEMP_LEFT = 6;
    public static final int U_AIR_TEMP_RIGHT = 18;
    public static final int U_AIR_TEMP_UNIT = 21;
    public static final int U_AIR_WIND_LEVEL_LEFT = 11;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 12;
    public static final int U_CNT_MAX = 26;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 26; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0241_WC1_RuiJie(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 26; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 26) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
