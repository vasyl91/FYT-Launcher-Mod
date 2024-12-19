package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_XC_Xiandai_Suolantuo;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_XC_Xiandai_Suolantuo extends CallbackCanbusBase {
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 10;
    public static final int U_AIR_BLOW_FOOT_LEFT = 11;
    public static final int U_AIR_BLOW_UP_LEFT = 9;
    public static final int U_AIR_CYCLE = 5;
    public static final int U_AIR_DUAL = 7;
    public static final int U_AIR_END = 14;
    public static final int U_AIR_FRONT_DEFROST = 6;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_SHOW = 3;
    public static final int U_AIR_TEMP_LEFT = 12;
    public static final int U_AIR_TEMP_RIGHT = 13;
    public static final int U_AIR_WIND_LEVEL = 8;
    public static final int U_CAREQ_BAL = 16;
    public static final int U_CAREQ_BASS = 18;
    public static final int U_CAREQ_FAD = 17;
    public static final int U_CAREQ_MID = 19;
    public static final int U_CAREQ_TREB = 20;
    public static final int U_CAREQ_VOL = 15;
    public static final int U_CNT_MAX = 21;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 21; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0439_XC_Xiandai_Suolantuo(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 14; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 14; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 21) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
