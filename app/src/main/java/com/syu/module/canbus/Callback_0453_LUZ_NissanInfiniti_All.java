package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_LUZ_NissanInfiniti_All extends CallbackCanbusBase {
    public static final int U_CARINF_D33_D0_B70 = 102;
    public static final int U_CARINF_D33_D1_B70 = 103;
    public static final int U_CARINF_D33_D2_B70 = 104;
    public static final int U_CARINF_D35_D2_D3 = 105;
    public static final int U_CARINF_D36_D0_B70 = 106;
    public static final int U_CARINF_D36_D1_B70 = 107;
    public static final int U_CARINF_D36_D2_B70 = 108;
    public static final int U_CARINF_D36_D3_B70 = 109;
    public static final int U_CARINF_D37_D0_D1 = 98;
    public static final int U_CARINF_D37_D2_D3 = 99;
    public static final int U_CARINF_D37_D4_D6 = 100;
    public static final int U_CARINF_D37_D7_D8 = 101;
    public static final int U_CARSET_AIRTYPE = 127;
    public static final int U_CARSET_D38_D11_B1 = 120;
    public static final int U_CARSET_D38_D11_B2 = 119;
    public static final int U_CARSET_D38_D11_B3 = 118;
    public static final int U_CARSET_D38_D11_B4 = 117;
    public static final int U_CARSET_D38_D11_B5 = 116;
    public static final int U_CARSET_D38_D11_B6 = 115;
    public static final int U_CARSET_D38_D11_B7 = 114;
    public static final int U_CARSET_D38_D12_B10 = 123;
    public static final int U_CARSET_D38_D12_B32 = 122;
    public static final int U_CARSET_D38_D12_B76 = 121;
    public static final int U_CARSET_D38_D2_B70 = 110;
    public static final int U_CARSET_D38_D6_B70 = 111;
    public static final int U_CARSET_D38_D7_B70 = 112;
    public static final int U_CARSET_D38_D8_B70 = 113;
    public static final int U_CARSET_D3A_D0_B30 = 124;
    public static final int U_CARSET_D3A_D0_B7 = 125;
    public static final int U_CARSET_D3A_D1_B70 = 126;
    public static final int U_CNT_MAX = 128;

    @Override
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
        //AirHelper.getInstance().buildUi(new Air_0453_LZ_Nissan_Infeiniti(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 128) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
