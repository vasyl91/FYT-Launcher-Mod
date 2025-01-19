package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0051_RZC_DaZhong extends CallbackCanbusBase {
    public static final int U_AIR_TEMP_OUT = 139;
    public static final int U_BATTERY_VOLTAGE = 105;
    public static final int U_CARINF_D41_D04_D1_D2 = 146;
    public static final int U_CARINF_D41_D04_D3_D4 = 147;
    public static final int U_CARINF_D41_D04_D5_D6 = 148;
    public static final int U_CARINF_D41_D04_D7_D8 = 149;
    public static final int U_CARINF_D41_D04_D9_D10 = 150;
    public static final int U_CARINF_D41_D11_D1_B20 = 117;
    public static final int U_CARINF_D41_D11_D1_B3 = 116;
    public static final int U_CARINF_D41_D11_D1_B4 = 115;
    public static final int U_CARINF_D41_D11_D1_B5 = 114;
    public static final int U_CARINF_D41_D11_D1_B76 = 113;
    public static final int U_CARINF_D41_D11_D2_B5 = 142;
    public static final int U_CARINF_D41_D11_D2_B6 = 141;
    public static final int U_CARINF_D41_D11_D2_B7 = 140;
    public static final int U_CARINF_D41_D12_D1_B7 = 143;
    public static final int U_CARINF_D41_D12_D1_D2 = 144;
    public static final int U_CARINF_D41_D13_D1_D2 = 145;
    public static final int U_CARSET_BACKCAR_TYPE = 119;
    public static final int U_CARSET_D25_D0_B32 = 121;
    public static final int U_CARSET_D27_D0_B70 = 122;
    public static final int U_CARSET_D27_D1_B70 = 123;
    public static final int U_CARSET_D27_D2_B70 = 124;
    public static final int U_CARSET_D27_D3_B70 = 125;
    public static final int U_CARSET_D27_D4_B70 = 126;
    public static final int U_CARSET_D27_D5_B70 = 127;
    public static final int U_CARSET_D27_D6_B70 = 128;
    public static final int U_CARSET_D27_D7_B70 = 129;
    public static final int U_CARSET_D41_D40_D1_B30 = 130;
    public static final int U_CARSET_D41_D40_D1_B74 = 131;
    public static final int U_CARSET_D41_D40_D2_B30 = 132;
    public static final int U_CARSET_D41_D40_D2_B74 = 133;
    public static final int U_CARSET_D41_D40_D3_B30 = 134;
    public static final int U_CARSET_D41_D80_D1_B70 = 135;
    public static final int U_CARSET_D41_D80_D2_B70 = 136;
    public static final int U_CARSET_D41_D80_D3_B70 = 137;
    public static final int U_CARSET_D41_D80_D4_B70 = 138;
    public static final int U_CARSET_D41_D80_D5_B70 = 151;
    public static final int U_CARSET_D41_D80_D6_B70 = 152;
    public static final int U_CARSET_D41_DA8_D1_B10 = 156;
    public static final int U_CARSET_D41_DA8_D1_B32 = 155;
    public static final int U_CARSET_D41_DA8_D1_B4 = 154;
    public static final int U_CARSET_D41_DA8_D1_B5 = 153;
    public static final int U_CARSET_RADAR_VOL = 118;
    public static final int U_CARSET_SCREEN_TYPE = 120;
    public static final int U_CLEAN_FLUIT_WARN = 102;
    public static final int U_CNT_MAX = 157;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_SPEED = 109;
    public static final int U_DRIVE_MILE = 106;
    public static final int U_ENGINE_SPEED = 110;
    public static final int U_HANDLE_BRAKE_WARN = 103;
    public static final int U_LIFE_BELT_WARN = 101;
    public static final int U_LOW_BATTERY_WARN = 100;
    public static final int U_LOW_OIL_WARN = 99;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 112;
    public static final int U_OUT_TEMP = 111;
    public static final int U_PARK = 107;
    public static final int U_RADAR_MUTE = 108;
    public static final int U_RESIDUAL_OIL = 104;

    @Override
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        if (DataCanbus.DATA[1000] == 2949171 || DataCanbus.DATA[1000] == 4587571 || DataCanbus.DATA[1000] == 4849715 || DataCanbus.DATA[1000] == 4980787 || DataCanbus.DATA[1000] == 5046323 || DataCanbus.DATA[1000] == 4915251) {
            //AirHelper.getInstance().buildUi(new Air_0051_RZC_Audi_Q5(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0051_RZC_PQ_DaZhong(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 157) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
