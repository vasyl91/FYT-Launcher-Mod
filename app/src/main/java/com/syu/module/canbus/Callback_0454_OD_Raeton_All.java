package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0454_OD_Raeton_All extends CallbackCanbusBase {
    public static final int U_CARINFO_D3A_D1_D2 = 98;
    public static final int U_CARINFO_D3A_D3_B6 = 100;
    public static final int U_CARINFO_D3A_D3_B7 = 99;
    public static final int U_CARINF_UBACK_STATE = 134;
    public static final int U_CARSET_D32_D0_B70 = 131;
    public static final int U_CARSET_D66_D0_B4 = 104;
    public static final int U_CARSET_D66_D0_B5 = 103;
    public static final int U_CARSET_D66_D0_B6 = 102;
    public static final int U_CARSET_D66_D0_B7 = 101;
    public static final int U_CARSET_D66_D1_B1 = 108;
    public static final int U_CARSET_D66_D1_B2 = 107;
    public static final int U_CARSET_D66_D1_B43 = 106;
    public static final int U_CARSET_D66_D1_B75 = 105;
    public static final int U_CARSET_D66_D2_B6 = 109;
    public static final int U_CARSET_D66_D3_B3 = 113;
    public static final int U_CARSET_D66_D3_B4 = 112;
    public static final int U_CARSET_D66_D3_B65 = 111;
    public static final int U_CARSET_D66_D3_B7 = 110;
    public static final int U_CARSET_D66_D4_B30 = 117;
    public static final int U_CARSET_D66_D4_B54 = 116;
    public static final int U_CARSET_D66_D4_B6 = 115;
    public static final int U_CARSET_D66_D4_B7 = 114;
    public static final int U_CARSET_D66_D5_B30 = 120;
    public static final int U_CARSET_D66_D5_B6 = 119;
    public static final int U_CARSET_D66_D5_B7 = 118;
    public static final int U_CARSET_D66_D6_B40 = 124;
    public static final int U_CARSET_D66_D6_B5 = 123;
    public static final int U_CARSET_D66_D6_B6 = 122;
    public static final int U_CARSET_D66_D6_B7 = 121;
    public static final int U_CARSET_D66_D7_B0 = 130;
    public static final int U_CARSET_D66_D7_B1 = 129;
    public static final int U_CARSET_D66_D7_B2 = 128;
    public static final int U_CARSET_D66_D7_B3 = 127;
    public static final int U_CARSET_D66_D7_B54 = 126;
    public static final int U_CARSET_D66_D7_B76 = 125;
    public static final int U_CARSET_D85_D0_B70 = 132;
    public static final int U_CARSET_D85_D1_B7 = 133;
    public static final int U_CNT_MAX = 135;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 135; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0454_OD_Raeton_All(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 135) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
