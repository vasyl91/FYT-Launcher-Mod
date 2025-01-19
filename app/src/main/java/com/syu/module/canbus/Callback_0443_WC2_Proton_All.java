package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0443_WC2_Proton_All;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Proton_All extends CallbackCanbusBase {
    public static final int U_CARINF_D32_D6_B70 = 98;
    public static final int U_CARINF_D32_D7_B70 = 99;
    public static final int U_CARINF_D32_D8_D9 = 120;
    public static final int U_CARINF_D61_D0_B32 = 101;
    public static final int U_CARINF_D61_D0_B54 = 118;
    public static final int U_CARINF_D61_D0_B6 = 121;
    public static final int U_CARINF_D61_D0_B7 = 100;
    public static final int U_CARINF_D61_D1_B0 = 109;
    public static final int U_CARINF_D61_D1_B1 = 108;
    public static final int U_CARINF_D61_D1_B2 = 107;
    public static final int U_CARINF_D61_D1_B3 = 106;
    public static final int U_CARINF_D61_D1_B4 = 105;
    public static final int U_CARINF_D61_D1_B5 = 104;
    public static final int U_CARINF_D61_D1_B6 = 103;
    public static final int U_CARINF_D61_D1_B7 = 102;
    public static final int U_CARINF_D61_D2_B0 = 115;
    public static final int U_CARINF_D61_D2_B1 = 114;
    public static final int U_CARINF_D61_D2_B32 = 113;
    public static final int U_CARINF_D61_D2_B4 = 112;
    public static final int U_CARINF_D61_D2_B5 = 111;
    public static final int U_CARINF_D61_D2_B6 = 110;
    public static final int U_CARINF_D61_D2_B7 = 119;
    public static final int U_CARINF_D61_D3_B10 = 127;
    public static final int U_CARINF_D61_D3_B2 = 126;
    public static final int U_CARINF_D61_D3_B3 = 125;
    public static final int U_CARINF_D61_D3_B4 = 124;
    public static final int U_CARINF_D61_D3_B5 = 123;
    public static final int U_CARINF_D61_D3_B6 = 117;
    public static final int U_CARINF_D61_D3_B7 = 116;
    public static final int U_CARINF_D61_D4_B0 = 131;
    public static final int U_CARINF_D61_D4_B1 = 130;
    public static final int U_CARINF_D61_D4_B2 = 129;
    public static final int U_CARINF_D61_D4_B43 = 128;
    public static final int U_CARINF_D61_D4_B75 = 122;
    public static final int U_CARINF_D61_D5_B30 = 139;
    public static final int U_CARINF_D61_D5_B4 = 140;
    public static final int U_CARINF_D61_D5_B5 = 134;
    public static final int U_CARINF_D61_D5_B6 = 133;
    public static final int U_CARINF_D61_D5_B7 = 132;
    public static final int U_CARINF_D61_D6_B20 = 155;
    public static final int U_CARINF_D61_D6_B43 = 138;
    public static final int U_CARINF_D61_D6_B5 = 137;
    public static final int U_CARINF_D61_D6_B6 = 136;
    public static final int U_CARINF_D61_D6_B7 = 135;
    public static final int U_CARINF_D61_D7_B0 = 154;
    public static final int U_CARINF_D61_D7_B1 = 153;
    public static final int U_CARINF_D61_D7_B2 = 152;
    public static final int U_CARINF_D61_D7_B3 = 151;
    public static final int U_CARINF_D61_D7_B4 = 144;
    public static final int U_CARINF_D61_D7_B5 = 143;
    public static final int U_CARINF_D61_D7_B6 = 142;
    public static final int U_CARINF_D61_D7_B7 = 141;
    public static final int U_CARINF_D62_D0_B5 = 147;
    public static final int U_CARINF_D62_D0_B6 = 146;
    public static final int U_CARINF_D62_D0_B7 = 145;
    public static final int U_CARINF_D62_D1_B43 = 150;
    public static final int U_CARINF_D62_D1_B65 = 149;
    public static final int U_CARINF_D62_D1_B7 = 148;
    public static final int U_CNT_MAX = 156;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 156; i++) {
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
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (DataCanbus.DATA[1000] == 16581051 || DataCanbus.DATA[1000] == 16646587) {
            //AirHelper.getInstance().buildUi(new Air_0443_WC2_Proton_X90(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0443_WC2_Proton_All(LauncherApplication.getInstance()));
        }
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(AirHelper.SHOW_AND_REFRESH);
    }

    @Override
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 156) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
