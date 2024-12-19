package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_kyc_toyota_all;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_KYC_Toyota_All extends CallbackCanbusBase {
    public static final int U_CARCD_CURTIME_HOUR = 154;
    public static final int U_CARCD_CURTIME_MIN = 153;
    public static final int U_CARCD_CURTIME_SEC = 152;
    public static final int U_CARCD_CURTRACK = 148;
    public static final int U_CARCD_DISC1 = 119;
    public static final int U_CARCD_DISC2 = 120;
    public static final int U_CARCD_DISC3 = 121;
    public static final int U_CARCD_DISC4 = 122;
    public static final int U_CARCD_DISC5 = 123;
    public static final int U_CARCD_DISC6 = 124;
    public static final int U_CARCD_NUM = 126;
    public static final int U_CARCD_RANDOM = 146;
    public static final int U_CARCD_REPEAT = 145;
    public static final int U_CARCD_SCAN = 155;
    public static final int U_CARCD_STATE = 125;
    public static final int U_CARCD_TOTALTIME_HOUR = 151;
    public static final int U_CARCD_TOTALTIME_MIN = 150;
    public static final int U_CARCD_TOTALTIME_SEC = 149;
    public static final int U_CARCD_TOTALTRACK = 147;
    public static final int U_CARCD_WORKSTATE = 127;
    public static final int U_CARRADIO_BAND = 128;
    public static final int U_CARRADIO_CHNEL = 129;
    public static final int U_CARRADIO_FRQ = 132;
    public static final int U_CARRADIO_FRQ1 = 133;
    public static final int U_CARRADIO_FRQ10 = 142;
    public static final int U_CARRADIO_FRQ11 = 143;
    public static final int U_CARRADIO_FRQ12 = 144;
    public static final int U_CARRADIO_FRQ2 = 134;
    public static final int U_CARRADIO_FRQ3 = 135;
    public static final int U_CARRADIO_FRQ4 = 136;
    public static final int U_CARRADIO_FRQ5 = 137;
    public static final int U_CARRADIO_FRQ6 = 138;
    public static final int U_CARRADIO_FRQ7 = 139;
    public static final int U_CARRADIO_FRQ8 = 140;
    public static final int U_CARRADIO_FRQ9 = 141;
    public static final int U_CARRADIO_SCAN = 130;
    public static final int U_CARRADIO_ST = 131;
    public static final int U_CARSET_D26_D0_B10 = 89;
    public static final int U_CARSET_D26_D0_B32 = 88;
    public static final int U_CARSET_D26_D0_B64 = 87;
    public static final int U_CARSET_D26_D0_B7 = 86;
    public static final int U_CARSET_D26_D1_B20 = 94;
    public static final int U_CARSET_D26_D1_B4 = 93;
    public static final int U_CARSET_D26_D1_B5 = 92;
    public static final int U_CARSET_D26_D1_B6 = 91;
    public static final int U_CARSET_D26_D1_B7 = 90;
    public static final int U_CARSET_D26_D2_B20 = 100;
    public static final int U_CARSET_D26_D2_B3 = 99;
    public static final int U_CARSET_D26_D2_B4 = 98;
    public static final int U_CARSET_D26_D2_B5 = 97;
    public static final int U_CARSET_D26_D2_B6 = 96;
    public static final int U_CARSET_D26_D2_B7 = 95;
    public static final int U_CARSET_D26_D3_B10 = 103;
    public static final int U_CARSET_D26_D3_B6 = 102;
    public static final int U_CARSET_D26_D3_B7 = 101;
    public static final int U_CARSET_D26_D5_B30 = 105;
    public static final int U_CARSET_D26_D5_B54 = 104;
    public static final int U_CARSET_D26_D6_B75 = 106;
    public static final int U_CARSET_D31_D0_B30 = 108;
    public static final int U_CARSET_D31_D0_B74 = 107;
    public static final int U_CARSET_D31_D1_B30 = 110;
    public static final int U_CARSET_D31_D1_B74 = 109;
    public static final int U_CARSET_D31_D2_B30 = 112;
    public static final int U_CARSET_D31_D2_B74 = 111;
    public static final int U_CARSET_D31_D3_B70 = 113;
    public static final int U_CARSET_D31_D4_B0 = 114;
    public static final int U_CARSET_D31_D4_B32 = 156;
    public static final int U_CARSET_D32_D0_B0 = 116;
    public static final int U_CARSET_D34_D0_D1_D2 = 115;
    public static final int U_CNT_MAX = 157;
    public static final int U_REAR_SCREEN_POWER = 117;
    public static final int U_REAR_SYS_LOCK = 118;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 157; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_kyc_toyota_all(LauncherApplication.getInstance()));
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
