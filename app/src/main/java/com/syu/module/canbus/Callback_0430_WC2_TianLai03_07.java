package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wc.tianlai.ActivityWCTianLaiCarCD;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0430_wc2_TianLai03;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0430_WC2_TianLai03_07 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_AUTO = 22;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_MODE_LEFT = 19;
    public static final int U_AIR_BLOW_WIN_LEFT = 18;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_DUAL = 23;
    public static final int U_AIR_END = 25;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 15;
    public static final int U_AIR_TEMP_LEFT = 21;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int U_CARINFO_JY_TOTAL_MILES = 61;
    public static final int U_CDC_BEGIN = 50;
    public static final int U_CDC_END = 60;
    public static final int U_CD_CURRENT_DISC_TRACK = 53;
    public static final int U_CD_CURRENT_TIME = 54;
    public static final int U_CD_DISC_STATE = 51;
    public static final int U_CD_DISC_TYPE = 52;
    public static final int U_CD_DISC_WORK_STATE = 55;
    public static final int U_CD_SHOW = 57;
    public static final int U_CD_STATE = 56;
    public static final int U_CNT_MAX = 62;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 62; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0430_wc2_TianLai03(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 25; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 62) {
            HandlerCanbus.update(updateCode, ints);
            if (updateCode == 57) {
                if (!ActivityWCTianLaiCarCD.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.wc.tianlai.ActivityWCTianLaiCarCD");
                } else if (ActivityWCTianLaiCarCD.mIsFront && ActivityWCTianLaiCarCD.mInstance != null) {
                    ActivityWCTianLaiCarCD.mInstance.finish();
                }
            }
        }
    }
}
