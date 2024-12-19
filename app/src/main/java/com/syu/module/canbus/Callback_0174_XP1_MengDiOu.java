package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0174_XP_MengDiOu;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0174_XP1_MengDiOu extends CallbackCanbusBase {
    public static final int U_AIR_AC = 17;
    public static final int U_AIR_AUTO = 24;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_FOOT_LEFT = 15;
    public static final int U_AIR_BLOW_UP_LEFT = 14;
    public static final int U_AIR_BLOW_WIN_LEFT = 13;
    public static final int U_AIR_CYCLE = 18;
    public static final int U_AIR_END = 32;
    public static final int U_AIR_MAXFRONT_DEFROST = 19;
    public static final int U_AIR_POWER = 30;
    public static final int U_AIR_REAR_DEFROST = 20;
    public static final int U_AIR_SHOW = 31;
    public static final int U_AIR_SYNC = 25;
    public static final int U_AIR_TEMP_LEFT = 11;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_WIND = 12;
    public static final int U_CNT_MAX = 33;
    public static final int U_CUR_SPEED = 7;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_ENGINE_SPEED = 8;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 33; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = 10; i2 < 32; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0174_XP_MengDiOu(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 32; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 33) {
            if (updateCode == 31) {
                if (ints[0] == 0) {
                    AirHelper.getInstance().hideWindow();
                    return;
                } else {
                    AirHelper.getInstance().showAndRefresh();
                    return;
                }
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
