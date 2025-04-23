package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.module.main.DataMain;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;
import com.syu.ui.parking.ParkingHelper;
import com.syu.ui.parking.Parking_RZC_QiJun;

public class Callback_0080_RZC_XP1_QiJun extends CallbackCanbusBase {
    public static final int U_CARINF_D21_D6_B30 = 129;
    public static final int U_CARINF_D21_D6_B54 = 128;
    public static final int U_CARINF_D21_D6_B76 = 127;
    public static final int U_CARINF_D21_D7_B30 = 132;
    public static final int U_CARINF_D21_D7_B54 = 131;
    public static final int U_CARINF_D21_D7_B76 = 130;
    public static final int U_CARINF_D27_D0_B0 = 147;
    public static final int U_CARINF_D27_D0_B1 = 146;
    public static final int U_CARINF_D27_D1_D2_D3 = 148;
    public static final int U_CARINF_D27_D4_D5 = 149;
    public static final int U_CARINF_D38_D4_B70 = 123;
    public static final int U_CARINF_D38_D5_B70 = 124;
    public static final int U_CARINF_D38_D6_B70 = 125;
    public static final int U_CARINF_D38_D7_B70 = 126;
    public static final int U_CARINF_D40_D0_B4 = 135;
    public static final int U_CARINF_D40_D0_B5 = 134;
    public static final int U_CARINF_D40_D0_B7 = 133;
    public static final int U_CARINF_D40_D1_B60 = 137;
    public static final int U_CARINF_D40_D1_B7 = 136;
    public static final int U_CARINF_D40_D2_B60 = 139;
    public static final int U_CARINF_D40_D2_B7 = 138;
    public static final int U_CARINF_D40_D3_B60 = 141;
    public static final int U_CARINF_D40_D3_B7 = 140;
    public static final int U_CARINF_D40_D4_B4 = 145;
    public static final int U_CARINF_D40_D4_B5 = 144;
    public static final int U_CARINF_D40_D4_B6 = 143;
    public static final int U_CARINF_D40_D4_B7 = 142;
    public static final int U_CARINF_D41_D0_B5 = 116;
    public static final int U_CARINF_D41_D0_B6 = 115;
    public static final int U_CARINF_D41_D0_B7 = 114;
    public static final int U_CARINF_D41_D12_D13 = 122;
    public static final int U_CARINF_D41_D1_D2 = 117;
    public static final int U_CARINF_D41_D3_D4 = 118;
    public static final int U_CARINF_D41_D5_D6 = 119;
    public static final int U_CARINF_D41_D7_D8 = 120;
    public static final int U_CARINF_D41_D9_D11 = 121;
    public static final int U_CARSET_D60_D30_B70 = 150;
    public static final int U_CNT_MAX = 151;
    public static final int U_JUMP_SOS_PAGE = 112;
    public static final int U_PARK_BTN = 100;
    public static final int U_PARK_CAMERA = 101;
    public static final int U_PARK_PAGE = 99;
    public static final int U_PARK_TXTMSG = 98;
    public static final int U_SETTING_93D0 = 113;
    public static final int U_SETTING_93D1 = 108;
    public static final int U_SETTING_93D2 = 109;
    public static final int U_SETTING_93D3 = 110;
    public static final int U_SETTING_93D4 = 111;
    public static final int U_SETTING_93D5 = 103;
    public static final int U_SETTING_93D6 = 104;
    public static final int U_SETTING_93D7 = 105;
    public static final int U_SETTING_93D8 = 106;
    public static final int U_SETTING_BEGIN = 102;
    public static final int U_SETTING_LANGUAGE = 107;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 151; i++) {
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
        if (1572944 == DataCanbus.DATA[1000]) {
            //AirHelper.getInstance().buildUi(new Air_0080_OD_Nissan_Teana(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0080_RZC_TianLai(LauncherApplication.getInstance()));
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (458832 == DataCanbus.DATA[1000]) {
            ParkingHelper.getInstance().buildUi(new Parking_RZC_QiJun(LauncherApplication.getInstance()));
            DataMain.NOTIFY_EVENTS[12].addNotify(ParkingHelper.getInstance(), 0);
            for (int i4 = 98; i4 <= 101; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(ParkingHelper.getInstance(), 0);
            }
        }
    }

    @Override
    public void out() {
        if (458832 == DataCanbus.DATA[1000]) {
            for (int i = 98; i <= 101; i++) {
                DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
            }
            DataMain.NOTIFY_EVENTS[12].removeNotify(ParkingHelper.getInstance());
            ParkingHelper.getInstance().destroyUi();
        }
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 112) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 151) {
            switch (updateCode) {
                case 112:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 151) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
