package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_DJ_Dodge_JCUV;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0452_DJ_Dodge_JCUV extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 113;
    public static final int U_CAREQ_BASS = 115;
    public static final int U_CAREQ_FAD = 114;
    public static final int U_CAREQ_MID = 116;
    public static final int U_CAREQ_SPEED_VOL = 118;
    public static final int U_CAREQ_TREB = 117;
    public static final int U_CAREQ_VOL = 111;
    public static final int U_CAREQ_VOL_PERCENTATE = 112;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D36_D0_B0 = 103;
    public static final int U_CARINFO_D36_D0_B1 = 102;
    public static final int U_CARINFO_D36_D0_B32 = 101;
    public static final int U_CARINFO_D36_D0_B54 = 100;
    public static final int U_CARINFO_D36_D0_B76 = 99;
    public static final int U_CARINFO_D36_D1_B0 = 121;
    public static final int U_CARINFO_D36_D1_B21 = 109;
    public static final int U_CARINFO_D36_D1_B3 = 108;
    public static final int U_CARINFO_D36_D1_B4 = 107;
    public static final int U_CARINFO_D36_D1_B5 = 106;
    public static final int U_CARINFO_D36_D1_B6 = 105;
    public static final int U_CARINFO_D36_D1_B7 = 104;
    public static final int U_CARINFO_D36_D3_B0 = 128;
    public static final int U_CARINFO_D36_D3_B2 = 127;
    public static final int U_CARINFO_D36_D3_B3 = 126;
    public static final int U_CARINFO_D36_D3_B4 = 125;
    public static final int U_CARINFO_D36_D3_B5 = 124;
    public static final int U_CARINFO_D36_D3_B6 = 123;
    public static final int U_CARINFO_D36_D3_B7 = 122;
    public static final int U_CARINFO_D37_D0_B70 = 129;
    public static final int U_CARINFO_D37_D1_B70 = 130;
    public static final int U_CARINFO_D37_D2_B70 = 131;
    public static final int U_CARINFO_D37_D3_B70 = 132;
    public static final int U_CARINFO_D37_D4_B70 = 133;
    public static final int U_CARINFO_D37_D5_B70 = 134;
    public static final int U_CARINFO_D37_D6_B70 = 135;
    public static final int U_CARINFO_D37_D7_B70 = 136;
    public static final int U_CARINFO_D37_D8_B70 = 137;
    public static final int U_CARINFO_D37_D9_B70 = 138;
    public static final int U_CARINFO_D37_DA_B70 = 139;
    public static final int U_CARINFO_LANGUAGE = 120;
    public static final int U_CARINFO_UNIT = 119;
    public static final int U_CARSET_END = 110;
    public static final int U_CNT_MAX = 129;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 129; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_DJ_Dodge_JCUV(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 129) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
