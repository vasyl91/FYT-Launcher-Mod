package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xbs.yage8.XBS08YageCar6Cd;
import com.syu.carinfo.xbs.yage8.XBS08YageCarRadioAct;
import com.syu.carinfo.xbs.yage8.XBS08YageCarUSBAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0439_XBS_Yage8;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_XBS_08Yage extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String MenuList1 = null;
    public static String MenuList2 = null;
    public static String MenuList3 = null;
    public static String Title = null;
    public static final int U_CARCD_ALBUM = 104;
    public static final int U_CARCD_ARTIST = 105;
    public static final int U_CARCD_ASL = 128;
    public static final int U_CARCD_BAL = 127;
    public static final int U_CARCD_BASS = 129;
    public static final int U_CARCD_DISC1 = 106;
    public static final int U_CARCD_DISC2 = 107;
    public static final int U_CARCD_DISC3 = 108;
    public static final int U_CARCD_DISC4 = 109;
    public static final int U_CARCD_DISC5 = 110;
    public static final int U_CARCD_DISC6 = 111;
    public static final int U_CARCD_MID = 131;
    public static final int U_CARCD_NUM = 113;
    public static final int U_CARCD_REPEAT = 102;
    public static final int U_CARCD_STATE = 112;
    public static final int U_CARCD_TITLE = 103;
    public static final int U_CARCD_TRE = 130;
    public static final int U_CARCD_VOL = 132;
    public static final int U_CARCD_WORKSTATE = 114;
    public static final int U_CAREQ_D10_D0_B40 = 134;
    public static final int U_CAREQ_D10_D0_B75 = 133;
    public static final int U_CAREQ_FAD = 126;
    public static final int U_CARINF_D0E_D0_B70 = 140;
    public static final int U_CARINF_D0E_D10_D11_D12 = 147;
    public static final int U_CARINF_D0E_D1_D2 = 141;
    public static final int U_CARINF_D0E_D3_D4 = 142;
    public static final int U_CARINF_D0E_D5_B70 = 143;
    public static final int U_CARINF_D0E_D6_B70 = 144;
    public static final int U_CARINF_D0E_D7_B70 = 145;
    public static final int U_CARINF_D0E_D8_D9 = 146;
    public static final int U_CARMENU_LIST1 = 135;
    public static final int U_CARMENU_LIST2 = 136;
    public static final int U_CARMENU_LIST3 = 137;
    public static final int U_CARMENU_SHOW = 139;
    public static final int U_CARMENU_TYPE = 138;
    public static final int U_CARRADIO_BAND = 115;
    public static final int U_CARRADIO_CHNEL = 116;
    public static final int U_CARRADIO_FRQ = 119;
    public static final int U_CARRADIO_FRQ1 = 120;
    public static final int U_CARRADIO_FRQ2 = 121;
    public static final int U_CARRADIO_FRQ3 = 122;
    public static final int U_CARRADIO_FRQ4 = 123;
    public static final int U_CARRADIO_FRQ5 = 124;
    public static final int U_CARRADIO_FRQ6 = 125;
    public static final int U_CARRADIO_SCAN = 117;
    public static final int U_CARRADIO_ST = 118;
    public static final int U_CARUSB_PLAYTIME_MIN = 99;
    public static final int U_CARUSB_PLAYTIME_SEC = 100;
    public static final int U_CARUSB_STATE = 98;
    public static final int U_CARUSB_TRACK = 101;
    public static final int U_CNT_MAX = 148;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 148; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        //AirHelper.getInstance().buildUi(new Air_0439_XBS_Yage8(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 98) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            switch (value) {
                case 1:
                    if (!XBS08YageCarRadioAct.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xbs.yage8.XBS08YageCarRadioAct");
                        break;
                    }
                case 2:
                    if (!XBS08YageCar6Cd.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xbs.yage8.XBS08YageCar6Cd");
                        break;
                    }
                case 4:
                    if (!XBS08YageCarUSBAct.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xbs.yage8.XBS08YageCarUSBAct");
                        break;
                    }
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 148) {
            switch (updateCode) {
                case 98:
                    ShowCarState(updateCode, ints);
                    break;
                case 103:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 104:
                    if (strs != null && strs.length > 0) {
                        Album = strs[0];
                    } else {
                        Album = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 105:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 135:
                    if (strs != null && strs.length > 0) {
                        MenuList1 = strs[0];
                    } else {
                        MenuList1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 136:
                    if (strs != null && strs.length > 0) {
                        MenuList2 = strs[0];
                    } else {
                        MenuList2 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 137:
                    if (strs != null && strs.length > 0) {
                        MenuList3 = strs[0];
                    } else {
                        MenuList3 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 148) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
