package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0443_WC2_Xiandai_all;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_Xiandai_All extends CallbackCanbusBase {
    public static final int U_CAREQ_DA6_D0_B70 = 106;
    public static final int U_CAREQ_DA6_D1_B70 = 107;
    public static final int U_CAREQ_DA6_D2_B70 = 108;
    public static final int U_CAREQ_DA6_D3_B70 = 109;
    public static final int U_CAREQ_DA6_D4_B70 = 110;
    public static final int U_CAREQ_DA6_D5_B70 = 111;
    public static final int U_CAREQ_DA6_D6_B70 = 112;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_FRONT_VIEW_INIT = 101;
    public static final int U_CARINFO_RADAR_DISPLAY = 100;
    public static final int U_CARINFO_REAR_VIEW_INIT = 102;
    public static final int U_CARINFO_TRACK_DISPLAY = 99;
    public static final int U_CARINF_D16_D0_D1 = 132;
    public static final int U_CARINF_D16_D10_D11 = 137;
    public static final int U_CARINF_D16_D12_D13 = 138;
    public static final int U_CARINF_D16_D14_D15 = 139;
    public static final int U_CARINF_D16_D16_D17 = 140;
    public static final int U_CARINF_D16_D18_D19 = 141;
    public static final int U_CARINF_D16_D20_D21 = 153;
    public static final int U_CARINF_D16_D22_D23 = 154;
    public static final int U_CARINF_D16_D24_D25 = 155;
    public static final int U_CARINF_D16_D26_D27 = 156;
    public static final int U_CARINF_D16_D28_D29 = 157;
    public static final int U_CARINF_D16_D2_D3 = 133;
    public static final int U_CARINF_D16_D30_D31 = 158;
    public static final int U_CARINF_D16_D32_D33 = 159;
    public static final int U_CARINF_D16_D34_D35 = 160;
    public static final int U_CARINF_D16_D36_D37 = 161;
    public static final int U_CARINF_D16_D38_D39 = 162;
    public static final int U_CARINF_D16_D4_D5 = 134;
    public static final int U_CARINF_D16_D6_D7 = 135;
    public static final int U_CARINF_D16_D8_D9 = 136;
    public static final int U_CARINF_D16_UNIT = 142;
    public static final int U_CARINF_D17_D0_D1 = 143;
    public static final int U_CARINF_D17_D10_D11 = 148;
    public static final int U_CARINF_D17_D12_D13 = 149;
    public static final int U_CARINF_D17_D14_D15 = 150;
    public static final int U_CARINF_D17_D16_D17 = 151;
    public static final int U_CARINF_D17_D18_D19 = 152;
    public static final int U_CARINF_D17_D20_D21 = 163;
    public static final int U_CARINF_D17_D22_D23 = 164;
    public static final int U_CARINF_D17_D24_D25 = 165;
    public static final int U_CARINF_D17_D26_D27 = 166;
    public static final int U_CARINF_D17_D28_D29 = 167;
    public static final int U_CARINF_D17_D2_D3 = 144;
    public static final int U_CARINF_D17_D30_D31 = 168;
    public static final int U_CARINF_D17_D32_D33 = 169;
    public static final int U_CARINF_D17_D34_D35 = 170;
    public static final int U_CARINF_D17_D36_D37 = 171;
    public static final int U_CARINF_D17_D38_D39 = 172;
    public static final int U_CARINF_D17_D4_D5 = 145;
    public static final int U_CARINF_D17_D6_D7 = 146;
    public static final int U_CARINF_D17_D8_D9 = 147;
    public static final int U_CARINF_D3F_D0_D1 = 123;
    public static final int U_CARINF_D3F_D2_D3 = 124;
    public static final int U_CARINF_D3F_D4_B70 = 125;
    public static final int U_CARINF_D3F_D5_B70 = 126;
    public static final int U_CARINF_D3F_D6_B10 = 130;
    public static final int U_CARINF_D3F_D6_B32 = 129;
    public static final int U_CARINF_D3F_D6_B54 = 128;
    public static final int U_CARINF_D3F_D6_B76 = 127;
    public static final int U_CARINF_D3F_D7_B30 = 131;
    public static final int U_CARSEAT_BACK_STATE = 104;
    public static final int U_CARSEAT_SHOW_ENABLE = 105;
    public static final int U_CARSEAT_STATE = 103;
    public static final int U_CARSET_D12_D3_B70 = 122;
    public static final int U_CARSET_D61_D0_B5 = 121;
    public static final int U_CARSET_D61_D0_B6 = 120;
    public static final int U_CARSET_D61_D0_B7 = 113;
    public static final int U_CARSET_D61_D1_B4 = 117;
    public static final int U_CARSET_D61_D1_B5 = 116;
    public static final int U_CARSET_D61_D1_B6 = 115;
    public static final int U_CARSET_D61_D1_B7 = 114;
    public static final int U_CARSET_D61_D2_B74 = 118;
    public static final int U_CARSET_D61_D3_B70 = 119;
    public static final int U_CNT_MAX = 173;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 173; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0443_WC2_Xiandai_all(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
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
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 173) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
