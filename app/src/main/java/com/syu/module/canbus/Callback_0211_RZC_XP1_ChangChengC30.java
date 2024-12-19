package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0211_OuDi_ChangChengH3;
import com.syu.ui.air.Air_0211_RZC_ChangChengC30;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0211_RZC_XP1_ChangChengC30 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 3;
    public static final int U_AIR_AUTO = 8;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 5;
    public static final int U_AIR_CYCLE = 1;
    public static final int U_AIR_END = 11;
    public static final int U_AIR_FRONT_DEFROST = 9;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_REAR_DEFROST = 2;
    public static final int U_AIR_TEMP_LEFT = 4;
    public static final int U_AIR_TEMP_RIGHT = 10;
    public static final int U_AIR_WIND_LEVEL_LEFT = 6;
    public static final int U_CNT_MAX = 11;
    private int mcarId;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        this.mcarId = (DataCanbus.DATA[1000] >> 16) & 65535;
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 11; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        if (this.mcarId == 0) {
            AirHelper.getInstance().buildUi(new Air_0211_RZC_ChangChengC30(LauncherApplication.getInstance()));
        } else if (this.mcarId == 1) {
            AirHelper.getInstance().buildUi(new Air_0211_OuDi_ChangChengH3(LauncherApplication.getInstance()));
        }
        for (int i2 = 0; i2 < 11; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
