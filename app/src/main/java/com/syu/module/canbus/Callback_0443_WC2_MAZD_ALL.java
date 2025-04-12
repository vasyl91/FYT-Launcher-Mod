package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0443_WC2_MAZD_ALL extends CallbackCanbusBase {
    public static final int U_CARCD_BEGIN = 98;
    public static final int U_CARCD_END = 106;
    public static final int U_CARCD_FOLD_INFO = 103;
    public static final int U_CARCD_ID3_INFO = 105;
    public static final int U_CARCD_PLAY_PROGRESS = 104;
    public static final int U_CARCD_PLAY_STATE = 99;
    public static final int U_CARCD_RDM_STATE = 101;
    public static final int U_CARCD_RPT_STATE = 100;
    public static final int U_CARCD_TRACK_INFO = 102;
    public static final int U_CARINF_D32_D6_D7_D8 = 162;
    public static final int U_CARINF_DAY_CUR = 175;
    public static final int U_CARINF_DAY_SET = 164;
    public static final int U_CARINF_DISTANCE_CUR = 174;
    public static final int U_CARINF_DISTANCE_CUR_OIL = 177;
    public static final int U_CARINF_DISTANCE_CUR_TIRE = 176;
    public static final int U_CARINF_DISTANCE_SET = 163;
    public static final int U_CARINF_DISTANCE_SET_OIL = 166;
    public static final int U_CARINF_DISTANCE_SET_TIRE = 165;
    public static final int U_CARINF_OIL_DIS_WARN = 173;
    public static final int U_CARINF_RESERVATION_DAY_WARN = 171;
    public static final int U_CARINF_RESERVATION_DIS_WARN = 170;
    public static final int U_CARINF_RESERVATION_OIL_ON = 169;
    public static final int U_CARINF_RESERVATION_ON = 167;
    public static final int U_CARINF_RESERVATION_TIRE_ON = 168;
    public static final int U_CARINF_TIRE_DIS_WARN = 172;
    public static final int U_CNT_MAX = 178;
    public static final int U_SET_D78_D10_B10 = 132;
    public static final int U_SET_D78_D10_B2 = 131;
    public static final int U_SET_D78_D10_B3 = 130;
    public static final int U_SET_D78_D10_B4 = 129;
    public static final int U_SET_D78_D10_B5 = 128;
    public static final int U_SET_D78_D10_B6 = 127;
    public static final int U_SET_D78_D10_B7 = 126;
    public static final int U_SET_D78_D11_B0 = 137;
    public static final int U_SET_D78_D11_B21 = 136;
    public static final int U_SET_D78_D11_B3 = 135;
    public static final int U_SET_D78_D11_B4 = 134;
    public static final int U_SET_D78_D11_B75 = 133;
    public static final int U_SET_D78_D12_B0 = 142;
    public static final int U_SET_D78_D12_B21 = 141;
    public static final int U_SET_D78_D12_B43 = 140;
    public static final int U_SET_D78_D12_B65 = 139;
    public static final int U_SET_D78_D12_B7 = 138;
    public static final int U_SET_D78_D13_B10 = 147;
    public static final int U_SET_D78_D13_B2 = 146;
    public static final int U_SET_D78_D13_B3 = 145;
    public static final int U_SET_D78_D13_B54 = 144;
    public static final int U_SET_D78_D13_B76 = 143;
    public static final int U_SET_D78_D14_B10 = 154;
    public static final int U_SET_D78_D14_B2 = 153;
    public static final int U_SET_D78_D14_B3 = 152;
    public static final int U_SET_D78_D14_B4 = 151;
    public static final int U_SET_D78_D14_B5 = 150;
    public static final int U_SET_D78_D14_B6 = 149;
    public static final int U_SET_D78_D14_B7 = 148;
    public static final int U_SET_D78_D15_B10 = 159;
    public static final int U_SET_D78_D15_B2 = 158;
    public static final int U_SET_D78_D15_B43 = 157;
    public static final int U_SET_D78_D15_B5 = 156;
    public static final int U_SET_D78_D15_B76 = 155;
    public static final int U_SET_D78_D16_B43 = 161;
    public static final int U_SET_D78_D16_B75 = 160;
    public static final int U_SET_D78_D7_B10 = 110;
    public static final int U_SET_D78_D7_B2 = 109;
    public static final int U_SET_D78_D7_B43 = 108;
    public static final int U_SET_D78_D7_B75 = 107;
    public static final int U_SET_D78_D8_B10 = 116;
    public static final int U_SET_D78_D8_B2 = 115;
    public static final int U_SET_D78_D8_B3 = 114;
    public static final int U_SET_D78_D8_B4 = 113;
    public static final int U_SET_D78_D8_B5 = 112;
    public static final int U_SET_D78_D8_B76 = 111;
    public static final int U_SET_D78_D9_B0 = 125;
    public static final int U_SET_D78_D9_B1 = 119;
    public static final int U_SET_D78_D9_B42 = 118;
    public static final int U_SET_D78_D9_B75 = 117;
    public static final int U_SET_D79_D0_B1 = 122;
    public static final int U_SET_D79_D0_B62 = 121;
    public static final int U_SET_D79_D0_B7 = 120;
    public static final int U_SET_D79_D1_B30 = 124;
    public static final int U_SET_D79_D1_B74 = 123;
    public static String mId3Name;
    public static int mId3Type;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 178; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0443_WC1_Mzd37(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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
        if (updateCode >= 0 && updateCode < 178) {
            if (updateCode == 105) {
                if (ints != null && ints.length >= 1) {
                    mId3Type = ints[0];
                    if (strs != null && strs.length > 0) {
                        mId3Name = strs[0];
                    } else {
                        mId3Name = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
