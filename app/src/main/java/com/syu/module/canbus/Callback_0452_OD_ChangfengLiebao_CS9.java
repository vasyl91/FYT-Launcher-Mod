package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OD_ChangfeiLiebao_CS9;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_OD_ChangfengLiebao_CS9 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AQS = 20;
    public static final int U_AIR_AUTO = 8;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY = 15;
    public static final int U_AIR_BLOW_FOOT = 16;
    public static final int U_AIR_BLOW_MODE = 17;
    public static final int U_AIR_BLOW_UP = 14;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_HEAT = 21;
    public static final int U_AIR_REAR_DEFROST = 11;
    public static final int U_AIR_TEMP_LEFT = 18;
    public static final int U_AIR_TEMP_RIGHT = 19;
    public static final int U_AIR_WIND_LEVEL = 13;
    public static final int U_CARINF_D42_D0_B70 = 23;
    public static final int U_CARINF_D42_D10_D11 = 30;
    public static final int U_CARINF_D42_D12_D13 = 31;
    public static final int U_CARINF_D42_D14_B70 = 32;
    public static final int U_CARINF_D42_D15_B70 = 33;
    public static final int U_CARINF_D42_D16_B70 = 34;
    public static final int U_CARINF_D42_D1_B70 = 24;
    public static final int U_CARINF_D42_D2_D3 = 25;
    public static final int U_CARINF_D42_D4_D5 = 26;
    public static final int U_CARINF_D42_D6_D7 = 27;
    public static final int U_CARINF_D42_D8_B70 = 28;
    public static final int U_CARINF_D42_D9_B70 = 29;
    public static final int U_CNT_MAX = 35;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 35; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 7; i3 < 22; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0452_OD_ChangfeiLiebao_CS9(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 35) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
