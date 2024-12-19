package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_LZ_Volvo;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_LZ_Volvo extends CallbackCanbusBase {
    public static final int U_AIR_CTRL_MODE = 142;
    public static final int U_AIR_CTRL_TEMP_LEFT_ADD = 143;
    public static final int U_AIR_CTRL_TEMP_LEFT_SUB = 144;
    public static final int U_AIR_CTRL_TEMP_RIGHT_ADD = 145;
    public static final int U_AIR_CTRL_TEMP_RIGHT_SUB = 146;
    public static final int U_CARINFO_D38_D0_B70 = 86;
    public static final int U_CARINFO_D38_D10_B70 = 96;
    public static final int U_CARINFO_D38_D11_B70 = 97;
    public static final int U_CARINFO_D38_D12_B70 = 98;
    public static final int U_CARINFO_D38_D13_B70 = 99;
    public static final int U_CARINFO_D38_D14_B70 = 100;
    public static final int U_CARINFO_D38_D15_B70 = 101;
    public static final int U_CARINFO_D38_D16_B70 = 102;
    public static final int U_CARINFO_D38_D17_B70 = 103;
    public static final int U_CARINFO_D38_D18_B70 = 104;
    public static final int U_CARINFO_D38_D19_B70 = 105;
    public static final int U_CARINFO_D38_D1_B70 = 87;
    public static final int U_CARINFO_D38_D20_B70 = 106;
    public static final int U_CARINFO_D38_D21_B0 = 112;
    public static final int U_CARINFO_D38_D21_B21 = 111;
    public static final int U_CARINFO_D38_D21_B3 = 110;
    public static final int U_CARINFO_D38_D21_B4 = 109;
    public static final int U_CARINFO_D38_D21_B5 = 108;
    public static final int U_CARINFO_D38_D21_B76 = 107;
    public static final int U_CARINFO_D38_D22_B0 = 119;
    public static final int U_CARINFO_D38_D22_B1 = 118;
    public static final int U_CARINFO_D38_D22_B2 = 117;
    public static final int U_CARINFO_D38_D22_B3 = 116;
    public static final int U_CARINFO_D38_D22_B4 = 115;
    public static final int U_CARINFO_D38_D22_B65 = 114;
    public static final int U_CARINFO_D38_D22_B7 = 113;
    public static final int U_CARINFO_D38_D23_B1 = 125;
    public static final int U_CARINFO_D38_D23_B2 = 124;
    public static final int U_CARINFO_D38_D23_B3 = 123;
    public static final int U_CARINFO_D38_D23_B4 = 122;
    public static final int U_CARINFO_D38_D23_B5 = 121;
    public static final int U_CARINFO_D38_D23_B76 = 120;
    public static final int U_CARINFO_D38_D24_B0 = 136;
    public static final int U_CARINFO_D38_D24_B1 = 135;
    public static final int U_CARINFO_D38_D24_B2 = 134;
    public static final int U_CARINFO_D38_D24_B3 = 133;
    public static final int U_CARINFO_D38_D24_B4 = 132;
    public static final int U_CARINFO_D38_D24_B5 = 131;
    public static final int U_CARINFO_D38_D24_B6 = 130;
    public static final int U_CARINFO_D38_D24_B7 = 129;
    public static final int U_CARINFO_D38_D25_B7 = 137;
    public static final int U_CARINFO_D38_D2_B70 = 88;
    public static final int U_CARINFO_D38_D3_B70 = 89;
    public static final int U_CARINFO_D38_D4_B70 = 90;
    public static final int U_CARINFO_D38_D5_B70 = 91;
    public static final int U_CARINFO_D38_D6_B70 = 92;
    public static final int U_CARINFO_D38_D7_B70 = 93;
    public static final int U_CARINFO_D38_D8_B70 = 94;
    public static final int U_CARINFO_D38_D9_B70 = 95;
    public static final int U_CARINFO_D39_D0_B70 = 139;
    public static final int U_CARINFO_D39_D1_B70 = 140;
    public static final int U_CARINFO_D39_D2_B70 = 141;
    public static final int U_CARINFO_D7D_D1_B30 = 126;
    public static final int U_CARINFO_D7E_D3_D4_D5 = 127;
    public static final int U_CARINFO_D7E_D8_D9 = 128;
    public static final int U_CNT_MAX = 147;
    public static final int U_STEER_CONTROLER_TYPE = 138;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 147; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_LZ_Volvo(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[29].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[30].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[29].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[30].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 147) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
