package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0452_RZC_Beiqi_Bj90;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_RZC_BenzAll extends CallbackCanbusBase {
    public static final int U_CARASSIST_BEGIN = 98;
    public static final int U_CARASSIST_STATUS = 99;
    public static final int U_CARINF_D1_D1_B70 = 101;
    public static final int U_CARINF_D2_D1_B70 = 102;
    public static final int U_CARINF_D2_D2_B70 = 103;
    public static final int U_CARINF_D2_D3_B70 = 104;
    public static final int U_CARINF_D3_D1_B70 = 105;
    public static final int U_CARINF_D3_D2_B70 = 106;
    public static final int U_CARINF_D41_D02_D3_D5 = 136;
    public static final int U_CARINF_D41_D80_B70 = 107;
    public static final int U_CARSET_D2_D4_B70 = 115;
    public static final int U_CARSET_D2_D5_B70 = 116;
    public static final int U_CARSET_D41_D03_D1_D2 = 110;
    public static final int U_CARSET_D41_D03_D3_D4 = 111;
    public static final int U_CARSET_D41_D03_D5_D6 = 112;
    public static final int U_CARSET_D41_D03_D7_D8 = 113;
    public static final int U_CARSET_D41_D03_D9_D10 = 114;
    public static final int U_CARSET_D41_D80_D3_B70 = 108;
    public static final int U_CARSET_D41_D80_D4_B70 = 109;
    public static final int U_CARSET_D41_D80_D5_B70 = 138;
    public static final int U_CARSET_D41_D80_D6_B70 = 139;
    public static final int U_CARSET_D41_D85_D1_B70 = 137;
    public static final int U_CARSET_D41_DA8_D1_B0 = 144;
    public static final int U_CARSET_D41_DA8_D1_B1 = 143;
    public static final int U_CARSET_D41_DA8_D1_B2 = 142;
    public static final int U_CARSET_D41_DA8_D1_B3 = 141;
    public static final int U_CARSET_D41_DA8_D1_B4 = 140;
    public static final int U_CARSET_D41_DA8_D2_B70 = 145;
    public static final int U_CARSET_D41_DA8_D3_B70 = 146;
    public static final int U_CARSET_D4_D1_B70 = 117;
    public static final int U_CARSET_D4_D2_B70 = 118;
    public static final int U_CARSET_D4_D3_B70 = 119;
    public static final int U_CARSET_D4_D4_B70 = 120;
    public static final int U_CARSET_D4_D5_B70 = 121;
    public static final int U_CARSET_D5_D1_B70 = 122;
    public static final int U_CARSET_D5_D2_B70 = 123;
    public static final int U_CARSET_D5_D3_B70 = 124;
    public static final int U_CARSET_D6_D1_B70 = 125;
    public static final int U_CARSET_D6_D2_B70 = 126;
    public static final int U_CARSET_D7_D1_B70 = 127;
    public static final int U_CARSET_D8_D1_B70 = 128;
    public static final int U_CARSET_D9_D1_B70 = 129;
    public static final int U_CARSET_D9_D2_B70 = 130;
    public static final int U_CARSET_D9_D3_B70 = 131;
    public static final int U_CARSET_DA_D1_B70 = 132;
    public static final int U_CARSET_DA_D2_B70 = 133;
    public static final int U_CARSET_DA_D3_B70 = 134;
    public static final int U_CARSET_DA_D4_B70 = 135;
    public static final int U_CNT_MAX = 147;
    public static final int U_RADARBEEP_STATUS = 100;

    @Override
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
        if (DataCanbus.DATA[1000] == 7274948) {
            //AirHelper.getInstance().buildUi(new Air_0452_RZC_Beiqi_Bj90(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0439_RZC_Benz_S350(LauncherApplication.getInstance()));
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
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
        if (updateCode >= 0 && updateCode < 147) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
