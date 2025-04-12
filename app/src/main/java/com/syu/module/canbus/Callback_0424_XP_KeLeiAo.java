package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0424_XP_KeLeiAo extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_CAR_LANG = 105;
    public static final int U_CARINFO_CAR_PARK = 106;
    public static final int U_CARINFO_END = 107;
    public static final int U_CARINFO_MILE_UNIT = 99;
    public static final int U_CARINFO_OIL_AVG = 101;
    public static final int U_CARINFO_OIL_UNIT = 100;
    public static final int U_CARINFO_SPEED_AVG = 104;
    public static final int U_CARINFO_TOTAL_MILE = 102;
    public static final int U_CARINFO_TOTAL_OIL = 103;
    public static final int U_CARSET_D17_D1_B70 = 155;
    public static final int U_CARSET_D17_D2_B70 = 156;
    public static final int U_CARSET_D17_D3_B70 = 157;
    public static final int U_CARSET_D17_D4_B70 = 158;
    public static final int U_CARSET_D17_D5_B70 = 159;
    public static final int U_CARSET_D17_D7_B54 = 161;
    public static final int U_CARSET_D17_D7_B7 = 160;
    public static final int U_CARSET_D40_D0_B70 = 109;
    public static final int U_CARSET_D40_D1_B0 = 135;
    public static final int U_CARSET_D40_D1_B1 = 115;
    public static final int U_CARSET_D40_D1_B2 = 114;
    public static final int U_CARSET_D40_D1_B3 = 113;
    public static final int U_CARSET_D40_D1_B4 = 112;
    public static final int U_CARSET_D40_D1_B5 = 111;
    public static final int U_CARSET_D40_D1_B76 = 110;
    public static final int U_CARSET_D40_D2_B0 = 121;
    public static final int U_CARSET_D40_D2_B1 = 120;
    public static final int U_CARSET_D40_D2_B2 = 119;
    public static final int U_CARSET_D40_D2_B3 = 118;
    public static final int U_CARSET_D40_D2_B54 = 117;
    public static final int U_CARSET_D40_D2_B76 = 116;
    public static final int U_CARSET_D40_D3_B0 = 126;
    public static final int U_CARSET_D40_D3_B1 = 125;
    public static final int U_CARSET_D40_D3_B2 = 124;
    public static final int U_CARSET_D40_D3_B3 = 138;
    public static final int U_CARSET_D40_D3_B4 = 137;
    public static final int U_CARSET_D40_D3_B5 = 136;
    public static final int U_CARSET_D40_D3_B6 = 123;
    public static final int U_CARSET_D40_D3_B7 = 122;
    public static final int U_CARSET_D40_D4_B0 = 141;
    public static final int U_CARSET_D40_D4_B1 = 140;
    public static final int U_CARSET_D40_D4_B32 = 139;
    public static final int U_CARSET_D40_D4_B4 = 130;
    public static final int U_CARSET_D40_D4_B5 = 129;
    public static final int U_CARSET_D40_D4_B6 = 128;
    public static final int U_CARSET_D40_D4_B7 = 127;
    public static final int U_CARSET_D40_D5_B0 = 134;
    public static final int U_CARSET_D40_D5_B21 = 143;
    public static final int U_CARSET_D40_D5_B4 = 142;
    public static final int U_CARSET_D40_D5_B5 = 133;
    public static final int U_CARSET_D40_D5_B6 = 132;
    public static final int U_CARSET_D40_D5_B7 = 131;
    public static final int U_CARSET_D60_D0_B70 = 144;
    public static final int U_CARSET_D60_D1_B10 = 148;
    public static final int U_CARSET_D60_D1_B32 = 147;
    public static final int U_CARSET_D60_D1_B54 = 146;
    public static final int U_CARSET_D60_D1_B76 = 145;
    public static final int U_CARSET_D60_D2_B1 = 152;
    public static final int U_CARSET_D60_D2_B2 = 151;
    public static final int U_CARSET_D60_D2_B3 = 150;
    public static final int U_CARSET_D60_D2_B74 = 149;
    public static final int U_CARSET_D60_D3_B70 = 153;
    public static final int U_CARSET_D60_D4_B76 = 154;
    public static final int U_CARSET_D61_D0_B30 = 163;
    public static final int U_CARSET_D61_D0_B74 = 162;
    public static final int U_CARSET_D61_D1_B70 = 164;
    public static final int U_CARSET_D61_D2_B7 = 165;
    public static final int U_CNT_MAX = 166;
    public static final int U_JUMP_SOS_PAGE = 108;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 166; i++) {
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
            //AirHelper.getInstance().buildUi(new Air_0424_XP_Renault_Dacia(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
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

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 108) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 108:
                showSosPage(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 166) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
