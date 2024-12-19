package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0324_BNR_TianLai;
import com.syu.ui.air.Air_0327_HC_TianLai;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0324_BNR_XP1_NISSAN_LouLan extends CallbackCanbusBase {
    public static final int C_AIRSET = 2;
    public static final int C_CARSET = 1;
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_AC_MAX = 27;
    public static final int U_AIR_AUTO = 22;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_MODE_LEFT = 19;
    public static final int U_AIR_BLOW_WIN_LEFT = 18;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_DUAL = 23;
    public static final int U_AIR_END = 29;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_MAX = 25;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 15;
    public static final int U_AIR_SHOW = 26;
    public static final int U_AIR_TEMP_LEFT = 21;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_TEMP_UNIT = 28;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int U_CNT_MAX = 39;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_SETTING_93D0 = 30;
    public static final int U_SETTING_93D1 = 31;
    public static final int U_SETTING_93D2 = 32;
    public static final int U_SETTING_93D3 = 33;
    public static final int U_SETTING_93D4 = 34;
    public static final int U_SETTING_93D5 = 35;
    public static final int U_SETTING_93D6 = 36;
    public static final int U_SETTING_93D7 = 37;
    public static final int U_SETTING_93D8 = 38;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 39; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 721220 || DataCanbus.DATA[1000] == 786756 || DataCanbus.DATA[1000] == 852292 || DataCanbus.DATA[1000] == 983364 || DataCanbus.DATA[1000] == 1048900 || DataCanbus.DATA[1000] == 917828) {
            AirHelper.getInstance().buildUi(new Air_0324_BNR_TianLai(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0327_HC_TianLai(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 29; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 29; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 39) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
