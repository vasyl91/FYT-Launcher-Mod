package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_Baogu_Renault extends CallbackCanbusBase {
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D71_D0_B0 = 103;
    public static final int U_CARINFO_D71_D0_B1 = 102;
    public static final int U_CARINFO_D71_D0_B2 = 101;
    public static final int U_CARINFO_D71_D0_B3 = 100;
    public static final int U_CARINFO_D71_D0_B54 = 99;
    public static final int U_CARINFO_D71_D10_B30 = 127;
    public static final int U_CARINFO_D71_D10_B65 = 126;
    public static final int U_CARINFO_D71_D10_B7 = 125;
    public static final int U_CARINFO_D71_D11_B4 = 131;
    public static final int U_CARINFO_D71_D11_B5 = 130;
    public static final int U_CARINFO_D71_D11_B6 = 129;
    public static final int U_CARINFO_D71_D11_B7 = 128;
    public static final int U_CARINFO_D71_D12_B0 = 132;
    public static final int U_CARINFO_D71_D1_B10 = 106;
    public static final int U_CARINFO_D71_D1_B2 = 105;
    public static final int U_CARINFO_D71_D1_B3 = 104;
    public static final int U_CARINFO_D71_D2_B10 = 113;
    public static final int U_CARINFO_D71_D2_B2 = 112;
    public static final int U_CARINFO_D71_D2_B3 = 111;
    public static final int U_CARINFO_D71_D2_B4 = 110;
    public static final int U_CARINFO_D71_D2_B5 = 109;
    public static final int U_CARINFO_D71_D2_B6 = 108;
    public static final int U_CARINFO_D71_D2_B7 = 107;
    public static final int U_CARINFO_D71_D3_B70 = 114;
    public static final int U_CARINFO_D71_D4_B70 = 115;
    public static final int U_CARINFO_D71_D5_B70 = 116;
    public static final int U_CARINFO_D71_D6_B70 = 117;
    public static final int U_CARINFO_D71_D7_B6 = 119;
    public static final int U_CARINFO_D71_D7_B7 = 118;
    public static final int U_CARINFO_D71_D8_B20 = 123;
    public static final int U_CARINFO_D71_D8_B5 = 122;
    public static final int U_CARINFO_D71_D8_B6 = 121;
    public static final int U_CARINFO_D71_D8_B7 = 120;
    public static final int U_CARINFO_D71_D9_B70 = 124;
    public static final int U_CARINFO_D81_AVG_FUEL = 133;
    public static final int U_CARINFO_D81_AVG_SPEED = 134;
    public static final int U_CARINFO_D81_DRIVED_MILE = 135;
    public static final int U_CARINFO_END = 136;
    public static final int U_CNT_MAX = 138;
    public static final int U_JUMP_SOS_PAGE = 137;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 138; i++) {
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

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 137) {
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
        if (updateCode >= 0) {
            switch (updateCode) {
                case 137:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 138) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
