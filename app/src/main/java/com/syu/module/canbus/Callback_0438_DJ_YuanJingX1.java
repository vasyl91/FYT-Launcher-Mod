package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AIR_0438_DJ_YuanJingX1;
import com.syu.ui.air.AirHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0438_DJ_YuanJingX1 extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int U_AIR_AC = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 6;
    public static final int U_AIR_BLOW_FOOT_LEFT = 7;
    public static final int U_AIR_BLOW_MODE_LEFT = 10;
    public static final int U_AIR_BLOW_UP_LEFT = 8;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_END = 11;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 3;
    public static final int U_AIR_TEMP_LEFT = 9;
    public static final int U_AIR_WIND_LEVEL_LEFT = 5;
    public static final int U_CNT_MAX = 11;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 11; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new AIR_0438_DJ_YuanJingX1(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 11; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 11; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 11) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
