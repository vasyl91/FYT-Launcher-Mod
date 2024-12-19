package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0327_HC_TianLai;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0327_HC_OLD_TianLai extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 18;
    public static final int U_AIR_BLOW_FOOT_LEFT = 19;
    public static final int U_AIR_BLOW_MODE = 25;
    public static final int U_AIR_BLOW_UP_LEFT = 20;
    public static final int U_AIR_BLOW_WIN_LEFT = 24;
    public static final int U_AIR_CYCLE_INTER = 12;
    public static final int U_AIR_CYCLE_OUTER = 23;
    public static final int U_AIR_DUAL = 22;
    public static final int U_AIR_END = 26;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_TEMP_RIGHT = 17;
    public static final int U_AIR_WIND_LEVEL_LEFT = 21;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_OIL = 9;
    public static final int U_CARSET_BEGIN = 59;
    public static final int U_CARSET_DX30_D0_B02 = 62;
    public static final int U_CARSET_DX30_D0_B04 = 61;
    public static final int U_CARSET_DX30_D0_B65 = 60;
    public static final int U_CARSET_DX30_D1_B30 = 64;
    public static final int U_CARSET_DX30_D1_B76 = 63;
    public static final int U_CARSET_DX30_D2_B01 = 70;
    public static final int U_CARSET_DX30_D2_B05 = 67;
    public static final int U_CARSET_DX30_D2_B06 = 66;
    public static final int U_CARSET_DX30_D2_B07 = 65;
    public static final int U_CARSET_DX30_D2_B21 = 69;
    public static final int U_CARSET_DX30_D2_B43 = 68;
    public static final int U_CD_BEGIN = 50;
    public static final int U_CD_CURRENT_DISC_TRACK = 53;
    public static final int U_CD_CURRENT_TIME = 54;
    public static final int U_CD_DISC_ID = 52;
    public static final int U_CD_DISC_RANDOM_STATE = 57;
    public static final int U_CD_DISC_REPEATE_STATE = 56;
    public static final int U_CD_DISC_STATE = 51;
    public static final int U_CD_DISC_WORK_STATE = 55;
    public static final int U_CD_END = 58;
    public static final int U_CNT_MAX = 71;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 71; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0327_HC_TianLai(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 26; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 26; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 71) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
