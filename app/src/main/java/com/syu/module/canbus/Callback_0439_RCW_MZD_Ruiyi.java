package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_RCW_MZD_Ruiyi;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_RCW_MZD_Ruiyi extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 10;
    public static final int U_AIR_BLOW_FOOT_LEFT = 11;
    public static final int U_AIR_BLOW_UP_LEFT = 9;
    public static final int U_AIR_CYCLE = 8;
    public static final int U_AIR_DUAL = 7;
    public static final int U_AIR_ECO = 3;
    public static final int U_AIR_END = 15;
    public static final int U_AIR_FRONT_DEFROST = 5;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 6;
    public static final int U_AIR_TEMP_LEFT = 13;
    public static final int U_AIR_TEMP_RIGHT = 14;
    public static final int U_AIR_WIND_LEVEL_LEFT = 12;
    public static final int U_CNT_MAX = 16;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 16; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0439_RCW_MZD_Ruiyi(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 15; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 15; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 16) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}