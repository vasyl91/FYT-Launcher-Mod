package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0352_WC2_RENAULT_KaBin;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0352_WC2_RENAULT_KaBin extends CallbackCanbusBase {
    public static final int U_CARINFO_AVG_OIL = 89;
    public static final int U_CARINFO_AVG_SPEED = 90;
    public static final int U_CARINFO_BEGIN = 86;
    public static final int U_CARINFO_DRIVE_TIME_H = 93;
    public static final int U_CARINFO_DRIVE_TIME_M = 92;
    public static final int U_CARINFO_FRONT_REAR = 88;
    public static final int U_CARINFO_LEFT_RIGHT = 87;
    public static final int U_CARINFO_NOOIL_MIle = 95;
    public static final int U_CARINFO_TOTAL_MILE = 91;
    public static final int U_CARINFO_TOTAL_OIL = 94;
    public static final int U_CARINF_D48_D2_D3 = 173;
    public static final int U_CARINF_D48_D4_D5 = 174;
    public static final int U_CARINF_D48_D6_D7 = 175;
    public static final int U_CARINF_D48_D8_D9 = 176;
    public static final int U_CARSET_BEGIN = 96;
    public static final int U_CARSET_D23_D0_B70 = 180;
    public static final int U_CARSET_D61_D00_B40 = 98;
    public static final int U_CARSET_D61_D00_B75 = 97;
    public static final int U_CARSET_D61_D01_B04 = 102;
    public static final int U_CARSET_D61_D01_B05 = 101;
    public static final int U_CARSET_D61_D01_B06 = 100;
    public static final int U_CARSET_D61_D01_B07 = 99;
    public static final int U_CARSET_D61_D01_B20 = 154;
    public static final int U_CARSET_D61_D02_B20 = 105;
    public static final int U_CARSET_D61_D02_B43 = 104;
    public static final int U_CARSET_D61_D02_B75 = 103;
    public static final int U_CARSET_D61_D03_B10 = 155;
    public static final int U_CARSET_D61_D03_B42 = 107;
    public static final int U_CARSET_D61_D03_B75 = 106;
    public static final int U_CARSET_D61_D04_B20 = 110;
    public static final int U_CARSET_D61_D04_B53 = 109;
    public static final int U_CARSET_D61_D04_B76 = 108;
    public static final int U_CARSET_D61_D05_B07 = 111;
    public static final int U_CARSET_D61_D06_B00 = 118;
    public static final int U_CARSET_D61_D06_B01 = 117;
    public static final int U_CARSET_D61_D06_B04 = 115;
    public static final int U_CARSET_D61_D06_B05 = 114;
    public static final int U_CARSET_D61_D06_B06 = 113;
    public static final int U_CARSET_D61_D06_B07 = 112;
    public static final int U_CARSET_D61_D06_B32 = 116;
    public static final int U_CARSET_D61_D07_B07 = 119;
    public static final int U_CARSET_D61_D07_B40 = 120;
    public static final int U_CARSET_D61_D08_B07 = 121;
    public static final int U_CARSET_D61_D08_B40 = 123;
    public static final int U_CARSET_D61_D08_B65 = 122;
    public static final int U_CARSET_D61_D09_B00 = 129;
    public static final int U_CARSET_D61_D09_B01 = 128;
    public static final int U_CARSET_D61_D09_B06 = 125;
    public static final int U_CARSET_D61_D09_B07 = 124;
    public static final int U_CARSET_D61_D09_B32 = 127;
    public static final int U_CARSET_D61_D09_B54 = 126;
    public static final int U_CARSET_D61_D0A_B00 = 136;
    public static final int U_CARSET_D61_D0A_B01 = 135;
    public static final int U_CARSET_D61_D0A_B02 = 134;
    public static final int U_CARSET_D61_D0A_B03 = 133;
    public static final int U_CARSET_D61_D0A_B04 = 132;
    public static final int U_CARSET_D61_D0A_B05 = 131;
    public static final int U_CARSET_D61_D0A_B76 = 130;
    public static final int U_CARSET_D61_D0B_B04 = 140;
    public static final int U_CARSET_D61_D0B_B05 = 139;
    public static final int U_CARSET_D61_D0B_B06 = 138;
    public static final int U_CARSET_D61_D0B_B07 = 137;
    public static final int U_CARSET_D61_D0B_B10 = 179;
    public static final int U_CARSET_D61_D0B_B2 = 178;
    public static final int U_CARSET_D61_D0B_B3 = 177;
    public static final int U_CARSET_D62_D00_B00 = 148;
    public static final int U_CARSET_D62_D00_B01 = 147;
    public static final int U_CARSET_D62_D00_B02 = 146;
    public static final int U_CARSET_D62_D00_B03 = 145;
    public static final int U_CARSET_D62_D00_B04 = 144;
    public static final int U_CARSET_D62_D00_B05 = 143;
    public static final int U_CARSET_D62_D00_B06 = 142;
    public static final int U_CARSET_D62_D00_B07 = 141;
    public static final int U_CARSET_D62_D01_B70 = 149;
    public static final int U_CARSET_D62_D02_B70 = 150;
    public static final int U_CARSET_D62_D03_B70 = 151;
    public static final int U_CARSET_D62_D04_B07 = 152;
    public static final int U_CARSET_D62_D04_B64 = 153;
    public static final int U_CARSET_D62_D05_B40 = 158;
    public static final int U_CARSET_D62_D05_B6 = 157;
    public static final int U_CARSET_D62_D05_B7 = 156;
    public static final int U_CARSET_D62_D06_B40 = 159;
    public static final int U_CARSET_D62_D07_B70 = 160;
    public static final int U_CARSET_D62_D08_B20 = 164;
    public static final int U_CARSET_D62_D08_B43 = 163;
    public static final int U_CARSET_D62_D08_B5 = 162;
    public static final int U_CARSET_D62_D08_B76 = 161;
    public static final int U_CARSET_D62_D09_B10 = 171;
    public static final int U_CARSET_D62_D09_B2 = 170;
    public static final int U_CARSET_D62_D09_B3 = 169;
    public static final int U_CARSET_D62_D09_B4 = 168;
    public static final int U_CARSET_D62_D09_B5 = 167;
    public static final int U_CARSET_D62_D09_B6 = 166;
    public static final int U_CARSET_D62_D09_B7 = 165;
    public static final int U_CARSET_D62_D10_B76 = 172;
    public static final int U_CNT_MAX = 181;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 181; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        AirHelper.getInstance().buildUi(new Air_0352_WC2_RENAULT_KaBin(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 85; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[52].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[52].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 181) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
