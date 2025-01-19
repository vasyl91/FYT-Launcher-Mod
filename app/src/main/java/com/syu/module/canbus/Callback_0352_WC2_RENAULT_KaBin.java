package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0352_WC2_RENAULT_KaBin;
import com.syu.ui.door.DoorHelper;

public class Callback_0352_WC2_RENAULT_KaBin extends CallbackCanbusBase {
    public static final int U_CARINFO_AVG_OIL = 101;
    public static final int U_CARINFO_AVG_SPEED = 102;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_DRIVE_TIME_H = 105;
    public static final int U_CARINFO_DRIVE_TIME_M = 104;
    public static final int U_CARINFO_FRONT_REAR = 100;
    public static final int U_CARINFO_LEFT_RIGHT = 99;
    public static final int U_CARINFO_NOOIL_MIle = 107;
    public static final int U_CARINFO_TOTAL_MILE = 103;
    public static final int U_CARINFO_TOTAL_OIL = 106;
    public static final int U_CARINF_D48_D2_D3 = 185;
    public static final int U_CARINF_D48_D4_D5 = 186;
    public static final int U_CARINF_D48_D6_D7 = 187;
    public static final int U_CARINF_D48_D8_D9 = 188;
    public static final int U_CARSET_BEGIN = 108;
    public static final int U_CARSET_D23_D0_B70 = 192;
    public static final int U_CARSET_D61_D00_B40 = 110;
    public static final int U_CARSET_D61_D00_B75 = 109;
    public static final int U_CARSET_D61_D01_B04 = 114;
    public static final int U_CARSET_D61_D01_B05 = 113;
    public static final int U_CARSET_D61_D01_B06 = 112;
    public static final int U_CARSET_D61_D01_B07 = 111;
    public static final int U_CARSET_D61_D01_B20 = 166;
    public static final int U_CARSET_D61_D02_B20 = 117;
    public static final int U_CARSET_D61_D02_B43 = 116;
    public static final int U_CARSET_D61_D02_B75 = 115;
    public static final int U_CARSET_D61_D03_B10 = 167;
    public static final int U_CARSET_D61_D03_B42 = 119;
    public static final int U_CARSET_D61_D03_B75 = 118;
    public static final int U_CARSET_D61_D04_B20 = 122;
    public static final int U_CARSET_D61_D04_B53 = 121;
    public static final int U_CARSET_D61_D04_B76 = 120;
    public static final int U_CARSET_D61_D05_B07 = 123;
    public static final int U_CARSET_D61_D06_B00 = 130;
    public static final int U_CARSET_D61_D06_B01 = 129;
    public static final int U_CARSET_D61_D06_B04 = 127;
    public static final int U_CARSET_D61_D06_B05 = 126;
    public static final int U_CARSET_D61_D06_B06 = 125;
    public static final int U_CARSET_D61_D06_B07 = 124;
    public static final int U_CARSET_D61_D06_B32 = 128;
    public static final int U_CARSET_D61_D07_B07 = 131;
    public static final int U_CARSET_D61_D07_B40 = 132;
    public static final int U_CARSET_D61_D08_B07 = 133;
    public static final int U_CARSET_D61_D08_B40 = 135;
    public static final int U_CARSET_D61_D08_B65 = 134;
    public static final int U_CARSET_D61_D09_B00 = 141;
    public static final int U_CARSET_D61_D09_B01 = 140;
    public static final int U_CARSET_D61_D09_B06 = 137;
    public static final int U_CARSET_D61_D09_B07 = 136;
    public static final int U_CARSET_D61_D09_B32 = 139;
    public static final int U_CARSET_D61_D09_B54 = 138;
    public static final int U_CARSET_D61_D0A_B00 = 148;
    public static final int U_CARSET_D61_D0A_B01 = 147;
    public static final int U_CARSET_D61_D0A_B02 = 146;
    public static final int U_CARSET_D61_D0A_B03 = 145;
    public static final int U_CARSET_D61_D0A_B04 = 144;
    public static final int U_CARSET_D61_D0A_B05 = 143;
    public static final int U_CARSET_D61_D0A_B76 = 142;
    public static final int U_CARSET_D61_D0B_B04 = 152;
    public static final int U_CARSET_D61_D0B_B05 = 151;
    public static final int U_CARSET_D61_D0B_B06 = 150;
    public static final int U_CARSET_D61_D0B_B07 = 149;
    public static final int U_CARSET_D61_D0B_B10 = 191;
    public static final int U_CARSET_D61_D0B_B2 = 190;
    public static final int U_CARSET_D61_D0B_B3 = 189;
    public static final int U_CARSET_D62_D00_B00 = 160;
    public static final int U_CARSET_D62_D00_B01 = 159;
    public static final int U_CARSET_D62_D00_B02 = 158;
    public static final int U_CARSET_D62_D00_B03 = 157;
    public static final int U_CARSET_D62_D00_B04 = 156;
    public static final int U_CARSET_D62_D00_B05 = 155;
    public static final int U_CARSET_D62_D00_B06 = 154;
    public static final int U_CARSET_D62_D00_B07 = 153;
    public static final int U_CARSET_D62_D01_B70 = 161;
    public static final int U_CARSET_D62_D02_B70 = 162;
    public static final int U_CARSET_D62_D03_B70 = 163;
    public static final int U_CARSET_D62_D04_B07 = 164;
    public static final int U_CARSET_D62_D04_B64 = 165;
    public static final int U_CARSET_D62_D05_B40 = 170;
    public static final int U_CARSET_D62_D05_B6 = 169;
    public static final int U_CARSET_D62_D05_B7 = 168;
    public static final int U_CARSET_D62_D06_B40 = 171;
    public static final int U_CARSET_D62_D07_B70 = 172;
    public static final int U_CARSET_D62_D08_B20 = 176;
    public static final int U_CARSET_D62_D08_B43 = 175;
    public static final int U_CARSET_D62_D08_B5 = 174;
    public static final int U_CARSET_D62_D08_B76 = 173;
    public static final int U_CARSET_D62_D09_B10 = 183;
    public static final int U_CARSET_D62_D09_B2 = 182;
    public static final int U_CARSET_D62_D09_B3 = 181;
    public static final int U_CARSET_D62_D09_B4 = 180;
    public static final int U_CARSET_D62_D09_B5 = 179;
    public static final int U_CARSET_D62_D09_B6 = 178;
    public static final int U_CARSET_D62_D09_B7 = 177;
    public static final int U_CARSET_D62_D10_B76 = 184;
    public static final int U_CNT_MAX = 193;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 193; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0352_WC2_RENAULT_KaBin(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 193) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
