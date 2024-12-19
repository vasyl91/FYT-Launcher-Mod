package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0443_WC2_Suzuki_All extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 86;
    public static final int U_CARINF_D13_D0_D1 = 87;
    public static final int U_CARINF_D13_D11_D12_D13 = 92;
    public static final int U_CARINF_D13_D2_D3 = 88;
    public static final int U_CARINF_D13_D4_D5 = 89;
    public static final int U_CARINF_D13_D6_D7 = 90;
    public static final int U_CARINF_D13_D8_D9_D10 = 91;
    public static final int U_CARINF_D16_D0_D1 = 93;
    public static final int U_CARINF_D16_D10_D11 = 98;
    public static final int U_CARINF_D16_D12_D13 = 99;
    public static final int U_CARINF_D16_D14_D15 = 100;
    public static final int U_CARINF_D16_D16_D17 = 101;
    public static final int U_CARINF_D16_D18_D19 = 102;
    public static final int U_CARINF_D16_D2_D3 = 94;
    public static final int U_CARINF_D16_D4_D5 = 95;
    public static final int U_CARINF_D16_D6_D7 = 96;
    public static final int U_CARINF_D16_D8_D9 = 97;
    public static final int U_CARINF_D17_D0_D1 = 103;
    public static final int U_CARINF_D17_D10_D11 = 108;
    public static final int U_CARINF_D17_D12_D13 = 109;
    public static final int U_CARINF_D17_D14_D15 = 110;
    public static final int U_CARINF_D17_D16_D17 = 111;
    public static final int U_CARINF_D17_D18_D19 = 112;
    public static final int U_CARINF_D17_D2_D3 = 104;
    public static final int U_CARINF_D17_D4_D5 = 105;
    public static final int U_CARINF_D17_D6_D7 = 106;
    public static final int U_CARINF_D17_D8_D9 = 107;
    public static final int U_CARINF_D3F_D11_B70 = 120;
    public static final int U_CARINF_D3F_D6_B30 = 114;
    public static final int U_CARINF_D3F_D6_B74 = 113;
    public static final int U_CARINF_D3F_D7_B30 = 116;
    public static final int U_CARINF_D3F_D7_B74 = 115;
    public static final int U_CARINF_D3F_D8_B30 = 118;
    public static final int U_CARINF_D3F_D8_B74 = 117;
    public static final int U_CARINF_D3F_D9_B4 = 119;
    public static final int U_CARINF_D48_D2_D3 = 121;
    public static final int U_CARINF_D48_D4_D5 = 122;
    public static final int U_CARINF_D48_D6_D7 = 123;
    public static final int U_CARINF_D48_D8_D9 = 124;
    public static final int U_CARSET_D61_D0_B10 = 125;
    public static final int U_CARSET_D61_D0_B2 = 126;
    public static final int U_CARSET_D61_D1_B0 = 127;
    public static final int U_CARSET_D61_D1_B1 = 128;
    public static final int U_CARSET_D61_D2_B20 = 129;
    public static final int U_CARSET_D61_D3_B0 = 130;
    public static final int U_CARSET_D61_D3_B1 = 131;
    public static final int U_CARSET_D61_D3_B2 = 132;
    public static final int U_CARSET_D61_D3_B3 = 133;
    public static final int U_CARSET_D61_D3_B4 = 134;
    public static final int U_CARSET_D61_D3_B5 = 135;
    public static final int U_CARSET_D61_D3_B6 = 136;
    public static final int U_CARSET_D61_D3_B7 = 137;
    public static final int U_CARSET_D61_D4_B0 = 138;
    public static final int U_CARSET_D61_D5_B1 = 139;
    public static final int U_CARSET_D61_D5_B2 = 140;
    public static final int U_CARSET_D61_D5_B3 = 141;
    public static final int U_CARSET_D61_D5_B4 = 142;
    public static final int U_CARSET_D61_D5_B5 = 143;
    public static final int U_CARSET_D61_D5_B6 = 144;
    public static final int U_CARSET_D61_D5_B7 = 145;
    public static final int U_CARSET_D61_D6_B1 = 146;
    public static final int U_CARSET_D61_D6_B2 = 147;
    public static final int U_CARSET_D61_D6_B3 = 148;
    public static final int U_CARSET_D61_D6_B4 = 149;
    public static final int U_CARSET_D61_D6_B5 = 150;
    public static final int U_CARSET_D61_D6_B6 = 151;
    public static final int U_CNT_MAX = 152;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 152; i++) {
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 152) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
