package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Oubao_Andela;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_LZ_Oubao_Andela extends CallbackCanbusBase {
    public static String D07Title = null;
    public static String D0BTitle = null;
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 11;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_END = 18;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_TEMP_UNIT = 17;
    public static final int U_AIR_WIND_LEVEL_LEFT = 14;
    public static final int U_CARINFO_D01_D0_B3 = 21;
    public static final int U_CARINFO_D01_D0_B64 = 20;
    public static final int U_CARINFO_D01_D0_B7 = 19;
    public static final int U_CARINFO_D07_ALL_STR = 22;
    public static final int U_CARINFO_D0B_ALL_STR = 24;
    public static final int U_CARINFO_D0B_D0_B30 = 23;
    public static final int U_CARINFO_D12_D0_D1 = 25;
    public static final int U_CARINFO_D12_D2_D3 = 26;
    public static final int U_CARINFO_D12_D4_B70 = 27;
    public static final int U_CARINFO_D12_D5_B70 = 28;
    public static final int U_CARINFO_D12_D6_B70 = 29;
    public static final int U_CARINFO_D12_D7_B70 = 30;
    public static final int U_CARINFO_D13_D0_D1_D2_D3 = 31;
    public static final int U_CARINFO_D13_D4_B70 = 32;
    public static final int U_CARINFO_D13_D5_D6_D7_D8 = 33;
    public static final int U_CARINFO_D13_D9_D10 = 34;
    public static final int U_CARINFO_D14_D0_D1_D2_D3 = 35;
    public static final int U_CARINFO_D14_D4_B70 = 36;
    public static final int U_CARINFO_D14_D5_D6_D7_D8 = 37;
    public static final int U_CARINFO_D14_D9_D10 = 38;
    public static final int U_CNT_MAX = 39;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 39; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Oubao_Andela(LauncherApplication.getInstance()));
        for (int i2 = 7; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 7; i < 18; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 39) {
            switch (updateCode) {
                case 22:
                    if (strs != null && strs.length > 0) {
                        D07Title = strs[0];
                    } else {
                        D07Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 23:
                default:
                    if (updateCode >= 0 && updateCode < 39) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                case 24:
                    if (strs != null && strs.length > 0) {
                        D0BTitle = strs[0];
                    } else {
                        D0BTitle = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
