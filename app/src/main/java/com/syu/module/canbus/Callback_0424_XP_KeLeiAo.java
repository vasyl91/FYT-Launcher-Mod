package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0424_XP_Renault_Dacia;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0424_XP_KeLeiAo extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 86;
    public static final int U_CARINFO_CAR_LANG = 93;
    public static final int U_CARINFO_CAR_PARK = 94;
    public static final int U_CARINFO_END = 95;
    public static final int U_CARINFO_MILE_UNIT = 87;
    public static final int U_CARINFO_OIL_AVG = 89;
    public static final int U_CARINFO_OIL_UNIT = 88;
    public static final int U_CARINFO_SPEED_AVG = 92;
    public static final int U_CARINFO_TOTAL_MILE = 90;
    public static final int U_CARINFO_TOTAL_OIL = 91;
    public static final int U_CARSET_D17_D1_B70 = 143;
    public static final int U_CARSET_D17_D2_B70 = 144;
    public static final int U_CARSET_D17_D3_B70 = 145;
    public static final int U_CARSET_D17_D4_B70 = 146;
    public static final int U_CARSET_D17_D5_B70 = 147;
    public static final int U_CARSET_D17_D7_B54 = 149;
    public static final int U_CARSET_D17_D7_B7 = 148;
    public static final int U_CARSET_D40_D0_B70 = 97;
    public static final int U_CARSET_D40_D1_B0 = 123;
    public static final int U_CARSET_D40_D1_B1 = 103;
    public static final int U_CARSET_D40_D1_B2 = 102;
    public static final int U_CARSET_D40_D1_B3 = 101;
    public static final int U_CARSET_D40_D1_B4 = 100;
    public static final int U_CARSET_D40_D1_B5 = 99;
    public static final int U_CARSET_D40_D1_B76 = 98;
    public static final int U_CARSET_D40_D2_B0 = 109;
    public static final int U_CARSET_D40_D2_B1 = 108;
    public static final int U_CARSET_D40_D2_B2 = 107;
    public static final int U_CARSET_D40_D2_B3 = 106;
    public static final int U_CARSET_D40_D2_B54 = 105;
    public static final int U_CARSET_D40_D2_B76 = 104;
    public static final int U_CARSET_D40_D3_B0 = 114;
    public static final int U_CARSET_D40_D3_B1 = 113;
    public static final int U_CARSET_D40_D3_B2 = 112;
    public static final int U_CARSET_D40_D3_B3 = 126;
    public static final int U_CARSET_D40_D3_B4 = 125;
    public static final int U_CARSET_D40_D3_B5 = 124;
    public static final int U_CARSET_D40_D3_B6 = 111;
    public static final int U_CARSET_D40_D3_B7 = 110;
    public static final int U_CARSET_D40_D4_B0 = 129;
    public static final int U_CARSET_D40_D4_B1 = 128;
    public static final int U_CARSET_D40_D4_B32 = 127;
    public static final int U_CARSET_D40_D4_B4 = 118;
    public static final int U_CARSET_D40_D4_B5 = 117;
    public static final int U_CARSET_D40_D4_B6 = 116;
    public static final int U_CARSET_D40_D4_B7 = 115;
    public static final int U_CARSET_D40_D5_B0 = 122;
    public static final int U_CARSET_D40_D5_B21 = 131;
    public static final int U_CARSET_D40_D5_B4 = 130;
    public static final int U_CARSET_D40_D5_B5 = 121;
    public static final int U_CARSET_D40_D5_B6 = 120;
    public static final int U_CARSET_D40_D5_B7 = 119;
    public static final int U_CARSET_D60_D0_B70 = 132;
    public static final int U_CARSET_D60_D1_B10 = 136;
    public static final int U_CARSET_D60_D1_B32 = 135;
    public static final int U_CARSET_D60_D1_B54 = 134;
    public static final int U_CARSET_D60_D1_B76 = 133;
    public static final int U_CARSET_D60_D2_B1 = 140;
    public static final int U_CARSET_D60_D2_B2 = 139;
    public static final int U_CARSET_D60_D2_B3 = 138;
    public static final int U_CARSET_D60_D2_B74 = 137;
    public static final int U_CARSET_D60_D3_B70 = 141;
    public static final int U_CARSET_D60_D4_B76 = 142;
    public static final int U_CNT_MAX = 150;
    public static final int U_JUMP_SOS_PAGE = 96;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 150; i++) {
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
        if (DataCanbus.DATA[1000] != 917928 && DataCanbus.DATA[1000] != 983464) {
            AirHelper.getInstance().buildUi(new Air_0424_XP_Renault_Dacia(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 85; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
            }
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

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 96) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 96:
                showSosPage(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 150) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
