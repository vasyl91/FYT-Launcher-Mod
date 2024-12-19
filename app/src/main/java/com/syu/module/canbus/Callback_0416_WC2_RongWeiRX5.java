package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0416_WC_RongWei_Rx5;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0416_WC2_RongWeiRX5 extends CallbackCanbusBase {
    public static final int U_CARINFO_BATTERY_VOLTAGE = 86;
    public static final int U_CARINFO_BEGIN = 86;
    public static final int U_CARINFO_D14_D1_D50 = 156;
    public static final int U_CARINFO_D15_D1_D50 = 157;
    public static final int U_CARINFO_D34_D10_D11 = 152;
    public static final int U_CARINFO_D34_D12_D13 = 153;
    public static final int U_CARINFO_D34_D15_D16 = 154;
    public static final int U_CARINFO_D34_D20_D21 = 155;
    public static final int U_CARINFO_D34_D4_D5_D6 = 150;
    public static final int U_CARINFO_D34_D7_D8 = 151;
    public static final int U_CARINFO_D35_D2_B10 = 88;
    public static final int U_CARINFO_D35_D2_B76 = 87;
    public static final int U_CARINFO_D35_D3_B1 = 89;
    public static final int U_CARINFO_D35_D4_B3 = 90;
    public static final int U_CARINFO_D3F_D1_D2 = 158;
    public static final int U_CARINFO_D3F_D3_B70 = 159;
    public static final int U_CARINFO_D3F_D6_D7 = 160;
    public static final int U_CARINFO_D3F_D8_D9 = 161;
    public static final int U_CARINFO_D66_D0_B0 = 97;
    public static final int U_CARINFO_D66_D0_B1 = 96;
    public static final int U_CARINFO_D66_D0_B2 = 95;
    public static final int U_CARINFO_D66_D0_B3 = 94;
    public static final int U_CARINFO_D66_D0_B4 = 93;
    public static final int U_CARINFO_D66_D0_B5 = 92;
    public static final int U_CARINFO_D66_D0_B7 = 91;
    public static final int U_CARINFO_D66_D10_B0 = 145;
    public static final int U_CARINFO_D66_D10_B1 = 144;
    public static final int U_CARINFO_D66_D10_B2 = 143;
    public static final int U_CARINFO_D66_D10_B3 = 142;
    public static final int U_CARINFO_D66_D10_B4 = 141;
    public static final int U_CARINFO_D66_D10_B5 = 140;
    public static final int U_CARINFO_D66_D10_B6 = 139;
    public static final int U_CARINFO_D66_D10_B7 = 138;
    public static final int U_CARINFO_D66_D11_B70 = 146;
    public static final int U_CARINFO_D66_D12_B70 = 147;
    public static final int U_CARINFO_D66_D13_B70 = 148;
    public static final int U_CARINFO_D66_D14_B70 = 149;
    public static final int U_CARINFO_D66_D2_B1 = 104;
    public static final int U_CARINFO_D66_D2_B2 = 103;
    public static final int U_CARINFO_D66_D2_B3 = 102;
    public static final int U_CARINFO_D66_D2_B4 = 101;
    public static final int U_CARINFO_D66_D2_B5 = 100;
    public static final int U_CARINFO_D66_D2_B6 = 99;
    public static final int U_CARINFO_D66_D2_B7 = 98;
    public static final int U_CARINFO_D66_D3_B10 = 108;
    public static final int U_CARINFO_D66_D3_B32 = 107;
    public static final int U_CARINFO_D66_D3_B4 = 106;
    public static final int U_CARINFO_D66_D3_B5 = 105;
    public static final int U_CARINFO_D66_D4_B0 = 116;
    public static final int U_CARINFO_D66_D4_B1 = 115;
    public static final int U_CARINFO_D66_D4_B2 = 114;
    public static final int U_CARINFO_D66_D4_B3 = 113;
    public static final int U_CARINFO_D66_D4_B4 = 112;
    public static final int U_CARINFO_D66_D4_B5 = 111;
    public static final int U_CARINFO_D66_D4_B6 = 110;
    public static final int U_CARINFO_D66_D4_B7 = 109;
    public static final int U_CARINFO_D66_D5_B30 = 118;
    public static final int U_CARINFO_D66_D5_B74 = 117;
    public static final int U_CARINFO_D66_D6_B10 = 122;
    public static final int U_CARINFO_D66_D6_B32 = 121;
    public static final int U_CARINFO_D66_D6_B4 = 120;
    public static final int U_CARINFO_D66_D6_B5 = 119;
    public static final int U_CARINFO_D66_D7_B10 = 126;
    public static final int U_CARINFO_D66_D7_B32 = 125;
    public static final int U_CARINFO_D66_D7_B54 = 124;
    public static final int U_CARINFO_D66_D7_B76 = 123;
    public static final int U_CARINFO_D66_D8_B10 = 132;
    public static final int U_CARINFO_D66_D8_B2 = 131;
    public static final int U_CARINFO_D66_D8_B3 = 130;
    public static final int U_CARINFO_D66_D8_B54 = 129;
    public static final int U_CARINFO_D66_D8_B6 = 128;
    public static final int U_CARINFO_D66_D8_B7 = 127;
    public static final int U_CARINFO_D66_D9_B10 = 137;
    public static final int U_CARINFO_D66_D9_B32 = 136;
    public static final int U_CARINFO_D66_D9_B54 = 135;
    public static final int U_CARINFO_D66_D9_B6 = 134;
    public static final int U_CARINFO_D66_D9_B7 = 133;
    public static final int[] U_CARINFO_ENERGEY_LIST = new int[50];
    public static final int[] U_CARINFO_OIL_LIST = new int[50];
    public static final int U_CNT_MAX = 162;

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 157) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_ENERGEY_LIST[ints[0]] = ints[1];
        } else if (updateCode == 156) {
            HandlerCanbus.update(updateCode, ints);
            U_CARINFO_OIL_LIST[ints[0]] = ints[1];
        } else if (updateCode >= 0 && updateCode < 162) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 162; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0416_WC_RongWei_Rx5(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }
}
