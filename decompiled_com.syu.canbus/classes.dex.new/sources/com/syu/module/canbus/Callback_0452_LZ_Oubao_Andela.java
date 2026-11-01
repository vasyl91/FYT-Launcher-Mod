package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Oubao_Andela;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0452_LZ_Oubao_Andela extends CallbackCanbusBase {
    public static String D07Title = null;
    public static String D0BTitle = null;
    public static String D0CAirStr1 = null;
    public static String D0CAirStr2 = null;
    public static String D0CAirStr3 = null;
    public static String D0CAirStr4 = null;
    public static String D0CAirStr5 = null;
    public static String D0CAirStr6 = null;
    public static final int U_CARINFO_D01_D0_B3 = 100;
    public static final int U_CARINFO_D01_D0_B64 = 99;
    public static final int U_CARINFO_D01_D0_B7 = 98;
    public static final int U_CARINFO_D07_ALL_STR = 101;
    public static final int U_CARINFO_D0B_ALL_STR = 103;
    public static final int U_CARINFO_D0B_D0_B30 = 102;
    public static final int U_CARINFO_D0C_BUTTON = 127;
    public static final int U_CARINFO_D0C_D0_B54 = 120;
    public static final int U_CARINFO_D0C_D0_B6 = 119;
    public static final int U_CARINFO_D0C_D0_B7 = 118;
    public static final int U_CARINFO_D0C_STR1 = 121;
    public static final int U_CARINFO_D0C_STR2 = 122;
    public static final int U_CARINFO_D0C_STR3 = 123;
    public static final int U_CARINFO_D0C_STR4 = 124;
    public static final int U_CARINFO_D0C_STR5 = 125;
    public static final int U_CARINFO_D0C_STR6 = 126;
    public static final int U_CARINFO_D12_D0_D1 = 104;
    public static final int U_CARINFO_D12_D2_D3 = 105;
    public static final int U_CARINFO_D12_D4_B70 = 106;
    public static final int U_CARINFO_D12_D5_B70 = 107;
    public static final int U_CARINFO_D12_D6_B70 = 108;
    public static final int U_CARINFO_D12_D7_B70 = 109;
    public static final int U_CARINFO_D13_D0_D1_D2_D3 = 110;
    public static final int U_CARINFO_D13_D4_B70 = 111;
    public static final int U_CARINFO_D13_D5_D6_D7_D8 = 112;
    public static final int U_CARINFO_D13_D9_D10 = 113;
    public static final int U_CARINFO_D14_D0_D1_D2_D3 = 114;
    public static final int U_CARINFO_D14_D4_B70 = 115;
    public static final int U_CARINFO_D14_D5_D6_D7_D8 = 116;
    public static final int U_CARINFO_D14_D9_D10 = 117;
    public static final int U_CNT_MAX = 128;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 128; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Oubao_Andela(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 128) {
            switch (updateCode) {
                case 101:
                    if (strs != null && strs.length > 0) {
                        D07Title = strs[0];
                    } else {
                        D07Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 103:
                    if (strs != null && strs.length > 0) {
                        D0BTitle = strs[0];
                    } else {
                        D0BTitle = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 121:
                    if (strs != null && strs.length > 0) {
                        D0CAirStr1 = strs[0];
                    } else {
                        D0CAirStr1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 122:
                    if (strs != null && strs.length > 0) {
                        D0CAirStr2 = strs[0];
                    } else {
                        D0CAirStr2 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 123:
                    if (strs != null && strs.length > 0) {
                        D0CAirStr3 = strs[0];
                    } else {
                        D0CAirStr3 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 124:
                    if (strs != null && strs.length > 0) {
                        D0CAirStr4 = strs[0];
                    } else {
                        D0CAirStr4 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 125:
                    if (strs != null && strs.length > 0) {
                        D0CAirStr5 = strs[0];
                    } else {
                        D0CAirStr5 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                case 126:
                    if (strs != null && strs.length > 0) {
                        D0CAirStr6 = strs[0];
                    } else {
                        D0CAirStr6 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    HandlerCanbus.update(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 128) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }
}
