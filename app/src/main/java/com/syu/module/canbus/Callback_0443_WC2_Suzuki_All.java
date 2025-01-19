package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Suzuki_All extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 98;
    public static final int U_CARINF_D13_D0_D1 = 99;
    public static final int U_CARINF_D13_D11_D12_D13 = 104;
    public static final int U_CARINF_D13_D2_D3 = 100;
    public static final int U_CARINF_D13_D4_D5 = 101;
    public static final int U_CARINF_D13_D6_D7 = 102;
    public static final int U_CARINF_D13_D8_D9_D10 = 103;
    public static final int U_CARINF_D16_D0_D1 = 105;
    public static final int U_CARINF_D16_D10_D11 = 110;
    public static final int U_CARINF_D16_D12_D13 = 111;
    public static final int U_CARINF_D16_D14_D15 = 112;
    public static final int U_CARINF_D16_D16_D17 = 113;
    public static final int U_CARINF_D16_D18_D19 = 114;
    public static final int U_CARINF_D16_D2_D3 = 106;
    public static final int U_CARINF_D16_D4_D5 = 107;
    public static final int U_CARINF_D16_D6_D7 = 108;
    public static final int U_CARINF_D16_D8_D9 = 109;
    public static final int U_CARINF_D17_D0_D1 = 115;
    public static final int U_CARINF_D17_D10_D11 = 120;
    public static final int U_CARINF_D17_D12_D13 = 121;
    public static final int U_CARINF_D17_D14_D15 = 122;
    public static final int U_CARINF_D17_D16_D17 = 123;
    public static final int U_CARINF_D17_D18_D19 = 124;
    public static final int U_CARINF_D17_D2_D3 = 116;
    public static final int U_CARINF_D17_D4_D5 = 117;
    public static final int U_CARINF_D17_D6_D7 = 118;
    public static final int U_CARINF_D17_D8_D9 = 119;
    public static final int U_CARINF_D3F_D11_B70 = 132;
    public static final int U_CARINF_D3F_D6_B30 = 126;
    public static final int U_CARINF_D3F_D6_B74 = 125;
    public static final int U_CARINF_D3F_D7_B30 = 128;
    public static final int U_CARINF_D3F_D7_B74 = 127;
    public static final int U_CARINF_D3F_D8_B30 = 130;
    public static final int U_CARINF_D3F_D8_B74 = 129;
    public static final int U_CARINF_D3F_D9_B4 = 131;
    public static final int U_CARINF_D48_D2_D3 = 133;
    public static final int U_CARINF_D48_D4_D5 = 134;
    public static final int U_CARINF_D48_D6_D7 = 135;
    public static final int U_CARINF_D48_D8_D9 = 136;
    public static final int U_CARSET_D61_D0_B10 = 137;
    public static final int U_CARSET_D61_D0_B2 = 138;
    public static final int U_CARSET_D61_D1_B0 = 139;
    public static final int U_CARSET_D61_D1_B1 = 140;
    public static final int U_CARSET_D61_D2_B20 = 141;
    public static final int U_CARSET_D61_D3_B0 = 142;
    public static final int U_CARSET_D61_D3_B1 = 143;
    public static final int U_CARSET_D61_D3_B2 = 144;
    public static final int U_CARSET_D61_D3_B3 = 145;
    public static final int U_CARSET_D61_D3_B4 = 146;
    public static final int U_CARSET_D61_D3_B5 = 147;
    public static final int U_CARSET_D61_D3_B6 = 148;
    public static final int U_CARSET_D61_D3_B7 = 149;
    public static final int U_CARSET_D61_D4_B0 = 150;
    public static final int U_CARSET_D61_D5_B1 = 151;
    public static final int U_CARSET_D61_D5_B2 = 152;
    public static final int U_CARSET_D61_D5_B3 = 153;
    public static final int U_CARSET_D61_D5_B4 = 154;
    public static final int U_CARSET_D61_D5_B5 = 155;
    public static final int U_CARSET_D61_D5_B6 = 156;
    public static final int U_CARSET_D61_D5_B7 = 157;
    public static final int U_CARSET_D61_D6_B1 = 158;
    public static final int U_CARSET_D61_D6_B2 = 159;
    public static final int U_CARSET_D61_D6_B3 = 160;
    public static final int U_CARSET_D61_D6_B4 = 161;
    public static final int U_CARSET_D61_D6_B5 = 162;
    public static final int U_CARSET_D61_D6_B6 = 163;
    public static final int U_CNT_MAX = 164;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 164; i++) {
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
        if (updateCode >= 0 && updateCode < 164) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
