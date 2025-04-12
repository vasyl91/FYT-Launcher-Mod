package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_KYC_Toyota_All extends CallbackCanbusBase {
    public static final int U_CARCD_CURTIME_HOUR = 166;
    public static final int U_CARCD_CURTIME_MIN = 165;
    public static final int U_CARCD_CURTIME_SEC = 164;
    public static final int U_CARCD_CURTRACK = 160;
    public static final int U_CARCD_DISC1 = 131;
    public static final int U_CARCD_DISC2 = 132;
    public static final int U_CARCD_DISC3 = 133;
    public static final int U_CARCD_DISC4 = 134;
    public static final int U_CARCD_DISC5 = 135;
    public static final int U_CARCD_DISC6 = 136;
    public static final int U_CARCD_NUM = 138;
    public static final int U_CARCD_RANDOM = 158;
    public static final int U_CARCD_REPEAT = 157;
    public static final int U_CARCD_SCAN = 167;
    public static final int U_CARCD_STATE = 137;
    public static final int U_CARCD_TOTALTIME_HOUR = 163;
    public static final int U_CARCD_TOTALTIME_MIN = 162;
    public static final int U_CARCD_TOTALTIME_SEC = 161;
    public static final int U_CARCD_TOTALTRACK = 159;
    public static final int U_CARCD_WORKSTATE = 139;
    public static final int U_CARINF_D6E_D0_D1 = 172;
    public static final int U_CARINF_D6E_D2_D3 = 173;
    public static final int U_CARINF_D6E_D4_D5 = 174;
    public static final int U_CARINF_D6E_D6_D7 = 175;
    public static final int U_CARINF_D6E_D8_D9 = 176;
    public static final int U_CARRADIO_BAND = 140;
    public static final int U_CARRADIO_CHNEL = 141;
    public static final int U_CARRADIO_FRQ = 144;
    public static final int U_CARRADIO_FRQ1 = 145;
    public static final int U_CARRADIO_FRQ10 = 154;
    public static final int U_CARRADIO_FRQ11 = 155;
    public static final int U_CARRADIO_FRQ12 = 156;
    public static final int U_CARRADIO_FRQ2 = 146;
    public static final int U_CARRADIO_FRQ3 = 147;
    public static final int U_CARRADIO_FRQ4 = 148;
    public static final int U_CARRADIO_FRQ5 = 149;
    public static final int U_CARRADIO_FRQ6 = 150;
    public static final int U_CARRADIO_FRQ7 = 151;
    public static final int U_CARRADIO_FRQ8 = 152;
    public static final int U_CARRADIO_FRQ9 = 153;
    public static final int U_CARRADIO_SCAN = 142;
    public static final int U_CARRADIO_ST = 143;
    public static final int U_CARSET_D26_D0_B10 = 101;
    public static final int U_CARSET_D26_D0_B32 = 100;
    public static final int U_CARSET_D26_D0_B64 = 99;
    public static final int U_CARSET_D26_D0_B7 = 98;
    public static final int U_CARSET_D26_D1_B20 = 106;
    public static final int U_CARSET_D26_D1_B4 = 105;
    public static final int U_CARSET_D26_D1_B5 = 104;
    public static final int U_CARSET_D26_D1_B6 = 103;
    public static final int U_CARSET_D26_D1_B7 = 102;
    public static final int U_CARSET_D26_D2_B20 = 112;
    public static final int U_CARSET_D26_D2_B3 = 111;
    public static final int U_CARSET_D26_D2_B4 = 110;
    public static final int U_CARSET_D26_D2_B5 = 109;
    public static final int U_CARSET_D26_D2_B6 = 108;
    public static final int U_CARSET_D26_D2_B7 = 107;
    public static final int U_CARSET_D26_D3_B10 = 115;
    public static final int U_CARSET_D26_D3_B6 = 114;
    public static final int U_CARSET_D26_D3_B7 = 113;
    public static final int U_CARSET_D26_D5_B30 = 117;
    public static final int U_CARSET_D26_D5_B54 = 116;
    public static final int U_CARSET_D26_D6_B43 = 177;
    public static final int U_CARSET_D26_D6_B75 = 118;
    public static final int U_CARSET_D26_D7_B2 = 181;
    public static final int U_CARSET_D26_D7_B3 = 180;
    public static final int U_CARSET_D26_D7_B4 = 179;
    public static final int U_CARSET_D26_D7_B75 = 178;
    public static final int U_CARSET_D31_D0_B30 = 120;
    public static final int U_CARSET_D31_D0_B74 = 119;
    public static final int U_CARSET_D31_D1_B30 = 122;
    public static final int U_CARSET_D31_D1_B74 = 121;
    public static final int U_CARSET_D31_D2_B30 = 124;
    public static final int U_CARSET_D31_D2_B74 = 123;
    public static final int U_CARSET_D31_D3_B70 = 125;
    public static final int U_CARSET_D31_D4_B0 = 126;
    public static final int U_CARSET_D31_D4_B32 = 168;
    public static final int U_CARSET_D32_D0_B0 = 128;
    public static final int U_CARSET_D32_D0_B6 = 170;
    public static final int U_CARSET_D32_D0_B7 = 169;
    public static final int U_CARSET_D34_D0_D1_D2 = 127;
    public static final int U_CNT_MAX = 182;
    public static final int U_REAR_SCREEN_POWER = 129;
    public static final int U_REAR_SYS_LOCK = 130;
    public static final int U_SHOW_AIRMODE = 171;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 182; i++) {
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
        if (DataCanbus.DATA[1000] != 590279 && DataCanbus.DATA[1000] != 655815) {
            //AirHelper.getInstance().buildUi(new Air_0439_kyc_toyota_all(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
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
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
