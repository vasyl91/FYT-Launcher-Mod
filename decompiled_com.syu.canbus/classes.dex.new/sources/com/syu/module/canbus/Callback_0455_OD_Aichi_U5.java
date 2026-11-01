package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0455_OD_Aichi_U5;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0455_OD_Aichi_U5 extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D50_D0_B0 = 105;
    public static final int U_CARINFO_D50_D0_B1 = 104;
    public static final int U_CARINFO_D50_D0_B2 = 103;
    public static final int U_CARINFO_D50_D0_B3 = 102;
    public static final int U_CARINFO_D50_D0_B4 = 101;
    public static final int U_CARINFO_D50_D0_B65 = 100;
    public static final int U_CARINFO_D50_D0_B7 = 99;
    public static final int U_CARINFO_D50_D10_B6 = 134;
    public static final int U_CARINFO_D50_D10_B7 = 133;
    public static final int U_CARINFO_D50_D11_B5 = 137;
    public static final int U_CARINFO_D50_D11_B6 = 136;
    public static final int U_CARINFO_D50_D11_B7 = 135;
    public static final int U_CARINFO_D50_D1_B70 = 106;
    public static final int U_CARINFO_D50_D2_B0 = 110;
    public static final int U_CARINFO_D50_D2_B1 = 109;
    public static final int U_CARINFO_D50_D2_B2 = 108;
    public static final int U_CARINFO_D50_D2_B3 = 107;
    public static final int U_CARINFO_D50_D3_B20 = 113;
    public static final int U_CARINFO_D50_D3_B53 = 112;
    public static final int U_CARINFO_D50_D3_B76 = 111;
    public static final int U_CARINFO_D50_D4_B4 = 115;
    public static final int U_CARINFO_D50_D4_B75 = 114;
    public static final int U_CARINFO_D50_D5_B0 = 120;
    public static final int U_CARINFO_D50_D5_B1 = 119;
    public static final int U_CARINFO_D50_D5_B32 = 118;
    public static final int U_CARINFO_D50_D5_B54 = 117;
    public static final int U_CARINFO_D50_D5_B76 = 116;
    public static final int U_CARINFO_D50_D6_B7 = 121;
    public static final int U_CARINFO_D50_D7_B4 = 124;
    public static final int U_CARINFO_D50_D7_B5 = 123;
    public static final int U_CARINFO_D50_D7_B76 = 122;
    public static final int U_CARINFO_D50_D8_B0 = 130;
    public static final int U_CARINFO_D50_D8_B1 = 129;
    public static final int U_CARINFO_D50_D8_B2 = 128;
    public static final int U_CARINFO_D50_D8_B43 = 127;
    public static final int U_CARINFO_D50_D8_B5 = 126;
    public static final int U_CARINFO_D50_D8_B76 = 125;
    public static final int U_CARINFO_D50_D9_B5 = 132;
    public static final int U_CARINFO_D50_D9_B76 = 131;
    public static final int U_CARINF_UBACK_STATE = 138;
    public static final int U_CNT_MAX = 139;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 139; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0455_OD_Aichi_U5(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 139) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
