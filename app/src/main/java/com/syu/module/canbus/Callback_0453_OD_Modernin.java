package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0453_OD_Modernin extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINF_D42_D0_B70 = 124;
    public static final int U_CARINF_D42_D12_D14 = 131;
    public static final int U_CARINF_D42_D15_D16 = 132;
    public static final int U_CARINF_D42_D17_D18 = 133;
    public static final int U_CARINF_D42_D1_D2 = 125;
    public static final int U_CARINF_D42_D3_B70 = 126;
    public static final int U_CARINF_D42_D4_B70 = 127;
    public static final int U_CARINF_D42_D5_D6 = 128;
    public static final int U_CARINF_D42_D7_D8 = 129;
    public static final int U_CARINF_D42_D9_D10 = 130;
    public static final int U_CARSET_D41_D0_B10 = 103;
    public static final int U_CARSET_D41_D0_B2 = 102;
    public static final int U_CARSET_D41_D0_B43 = 101;
    public static final int U_CARSET_D41_D0_B65 = 100;
    public static final int U_CARSET_D41_D0_B7 = 99;
    public static final int U_CARSET_D41_D1_B20 = 106;
    public static final int U_CARSET_D41_D1_B53 = 105;
    public static final int U_CARSET_D41_D1_B7 = 104;
    public static final int U_CARSET_D41_D2_B20 = 110;
    public static final int U_CARSET_D41_D2_B3 = 109;
    public static final int U_CARSET_D41_D2_B54 = 108;
    public static final int U_CARSET_D41_D2_B76 = 107;
    public static final int U_CARSET_D41_D3_B0 = 137;
    public static final int U_CARSET_D41_D3_B1 = 136;
    public static final int U_CARSET_D41_D3_B2 = 135;
    public static final int U_CARSET_D41_D3_B3 = 134;
    public static final int U_CARSET_D41_D3_B4 = 114;
    public static final int U_CARSET_D41_D3_B5 = 113;
    public static final int U_CARSET_D41_D3_B6 = 112;
    public static final int U_CARSET_D41_D3_B7 = 111;
    public static final int U_CARSET_D41_D4_B0 = 120;
    public static final int U_CARSET_D41_D4_B1 = 119;
    public static final int U_CARSET_D41_D4_B2 = 118;
    public static final int U_CARSET_D41_D4_B43 = 117;
    public static final int U_CARSET_D41_D4_B5 = 116;
    public static final int U_CARSET_D41_D4_B76 = 115;
    public static final int U_CARSET_D41_D5_B2 = 139;
    public static final int U_CARSET_D41_D5_B3 = 138;
    public static final int U_CARSET_D41_D5_B54 = 122;
    public static final int U_CARSET_D41_D5_B76 = 121;
    public static final int U_CARSET_D41_D6_B70 = 123;
    public static final int U_CARWARN_D40_D0_B70 = 152;
    public static final int U_CARWARN_D40_D1_B70 = 153;
    public static final int U_CARWARN_D40_D2_B70 = 154;
    public static final int U_CARWARN_D40_D3_B70 = 155;
    public static final int U_CARWARN_D40_D4_B70 = 156;
    public static final int U_CARWARN_D40_D5_B70 = 157;
    public static final int U_CARWARN_D40_D6_B70 = 158;
    public static final int U_CNT_MAX = 159;
    public static final int U_TIRE_FL_WARN = 148;
    public static final int U_TIRE_FR_WARN = 149;
    public static final int U_TIRE_PRESSURE_FL = 140;
    public static final int U_TIRE_PRESSURE_FR = 141;
    public static final int U_TIRE_PRESSURE_RL = 142;
    public static final int U_TIRE_PRESSURE_RR = 143;
    public static final int U_TIRE_RL_WARN = 151;
    public static final int U_TIRE_RR_WARN = 150;
    public static final int U_TIRE_TEMP_FL = 144;
    public static final int U_TIRE_TEMP_FR = 145;
    public static final int U_TIRE_TEMP_RL = 146;
    public static final int U_TIRE_TEMP_RR = 147;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 159; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 159) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
