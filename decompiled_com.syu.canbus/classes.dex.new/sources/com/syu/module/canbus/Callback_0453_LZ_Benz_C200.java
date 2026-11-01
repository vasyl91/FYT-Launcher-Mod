package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0453_LZ_Benz_C200;
import com.syu.ui.air.Air_0455_LZ_Benz_C200_NTG50;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0453_LZ_Benz_C200 extends CallbackCanbusBase {
    public static final int U_CARINF_D37_D0_B70 = 117;
    public static final int U_CARINF_D38_D0_B20 = 106;
    public static final int U_CARINF_D38_D0_B53 = 105;
    public static final int U_CARINF_D38_D0_B6 = 104;
    public static final int U_CARINF_D38_D0_B7 = 103;
    public static final int U_CARINF_D38_D10_B70 = 116;
    public static final int U_CARINF_D38_D1_B70 = 107;
    public static final int U_CARINF_D38_D2_B70 = 108;
    public static final int U_CARINF_D38_D3_B70 = 109;
    public static final int U_CARINF_D38_D4_B70 = 110;
    public static final int U_CARINF_D38_D5_B70 = 111;
    public static final int U_CARINF_D38_D6_B70 = 112;
    public static final int U_CARINF_D38_D7_B70 = 113;
    public static final int U_CARINF_D38_D8_B70 = 114;
    public static final int U_CARINF_D38_D9_B70 = 115;
    public static final int U_CARSET_D39_D0_B0 = 125;
    public static final int U_CARSET_D39_D0_B1 = 124;
    public static final int U_CARSET_D39_D0_B2 = 123;
    public static final int U_CARSET_D39_D0_B3 = 122;
    public static final int U_CARSET_D39_D0_B4 = 121;
    public static final int U_CARSET_D39_D0_B5 = 120;
    public static final int U_CARSET_D39_D0_B6 = 119;
    public static final int U_CARSET_D39_D0_B7 = 118;
    public static final int U_CARSET_D39_D1_B10 = 129;
    public static final int U_CARSET_D39_D1_B32 = 128;
    public static final int U_CARSET_D39_D1_B64 = 127;
    public static final int U_CARSET_D39_D1_B7 = 126;
    public static final int U_CARSET_D39_D2_B42 = 131;
    public static final int U_CARSET_D39_D2_B75 = 130;
    public static final int U_CAR_BENZ_TYPE = 135;
    public static final int U_CAR_LIGHT_D99_D0_B7 = 98;
    public static final int U_CAR_LIGHT_D99_D1_B70 = 99;
    public static final int U_CAR_LIGHT_D99_D2_B70 = 100;
    public static final int U_CAR_LIGHT_D99_D3_B70 = 101;
    public static final int U_CAR_LIGHT_D99_D4_B70 = 102;
    public static final int U_CAR_LVDS_MODE = 134;
    public static final int U_CAR_SCREEN_H = 133;
    public static final int U_CAR_SCREEN_W = 132;
    public static final int U_CNT_MAX = 136;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 136; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        if (DataCanbus.DATA[1000] == 8192455) {
            AirHelper.getInstance().buildUi(new Air_0455_LZ_Benz_C200_NTG50(TheApp.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0453_LZ_Benz_C200(TheApp.getInstance()));
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 136) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
