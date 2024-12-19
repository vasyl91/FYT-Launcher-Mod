package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xbs.yage8.XBS08YageCar6Cd;
import com.syu.carinfo.xbs.yage8.XBS08YageCarRadioAct;
import com.syu.carinfo.xbs.yage8.XBS08YageCarUSBAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_XBS_Yage8;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_XBS_08Yage extends CallbackCanbusBase {
    public static String Album = null;
    public static String Artist = null;
    public static String MenuList1 = null;
    public static String MenuList2 = null;
    public static String MenuList3 = null;
    public static String Title = null;
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 3;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 5;
    public static final int U_AIR_BLOW_FOOT_LEFT = 6;
    public static final int U_AIR_BLOW_UP_LEFT = 4;
    public static final int U_AIR_END = 10;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_TEMP_LEFT = 8;
    public static final int U_AIR_TEMP_RIGHT = 9;
    public static final int U_AIR_WIND_LEVEL = 7;
    public static final int U_CARCD_ALBUM = 24;
    public static final int U_CARCD_ARTIST = 25;
    public static final int U_CARCD_ASL = 48;
    public static final int U_CARCD_BAL = 47;
    public static final int U_CARCD_BASS = 49;
    public static final int U_CARCD_DISC1 = 26;
    public static final int U_CARCD_DISC2 = 27;
    public static final int U_CARCD_DISC3 = 28;
    public static final int U_CARCD_DISC4 = 29;
    public static final int U_CARCD_DISC5 = 30;
    public static final int U_CARCD_DISC6 = 31;
    public static final int U_CARCD_MID = 51;
    public static final int U_CARCD_NUM = 33;
    public static final int U_CARCD_REPEAT = 22;
    public static final int U_CARCD_STATE = 32;
    public static final int U_CARCD_TITLE = 23;
    public static final int U_CARCD_TRE = 50;
    public static final int U_CARCD_VOL = 52;
    public static final int U_CARCD_WORKSTATE = 34;
    public static final int U_CAREQ_D10_D0_B40 = 54;
    public static final int U_CAREQ_D10_D0_B75 = 53;
    public static final int U_CAREQ_FAD = 46;
    public static final int U_CARINF_D0E_D0_B70 = 60;
    public static final int U_CARINF_D0E_D10_D11_D12 = 67;
    public static final int U_CARINF_D0E_D1_D2 = 61;
    public static final int U_CARINF_D0E_D3_D4 = 62;
    public static final int U_CARINF_D0E_D5_B70 = 63;
    public static final int U_CARINF_D0E_D6_B70 = 64;
    public static final int U_CARINF_D0E_D7_B70 = 65;
    public static final int U_CARINF_D0E_D8_D9 = 66;
    public static final int U_CARMENU_LIST1 = 55;
    public static final int U_CARMENU_LIST2 = 56;
    public static final int U_CARMENU_LIST3 = 57;
    public static final int U_CARMENU_SHOW = 59;
    public static final int U_CARMENU_TYPE = 58;
    public static final int U_CARRADIO_BAND = 35;
    public static final int U_CARRADIO_CHNEL = 36;
    public static final int U_CARRADIO_FRQ = 39;
    public static final int U_CARRADIO_FRQ1 = 40;
    public static final int U_CARRADIO_FRQ2 = 41;
    public static final int U_CARRADIO_FRQ3 = 42;
    public static final int U_CARRADIO_FRQ4 = 43;
    public static final int U_CARRADIO_FRQ5 = 44;
    public static final int U_CARRADIO_FRQ6 = 45;
    public static final int U_CARRADIO_SCAN = 37;
    public static final int U_CARRADIO_ST = 38;
    public static final int U_CARUSB_PLAYTIME_MIN = 19;
    public static final int U_CARUSB_PLAYTIME_SEC = 20;
    public static final int U_CARUSB_STATE = 18;
    public static final int U_CARUSB_TRACK = 21;
    public static final int U_CNT_MAX = 68;
    public static final int U_DOOR_BACK = 16;
    public static final int U_DOOR_BEGIN = 11;
    public static final int U_DOOR_END = 17;
    public static final int U_DOOR_ENGINE = 11;
    public static final int U_DOOR_FL = 12;
    public static final int U_DOOR_FR = 13;
    public static final int U_DOOR_RL = 14;
    public static final int U_DOOR_RR = 15;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 68; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 11;
        DoorHelper.sUcDoorFl = 12;
        DoorHelper.sUcDoorFr = 13;
        DoorHelper.sUcDoorRl = 14;
        DoorHelper.sUcDoorRr = 15;
        DoorHelper.sUcDoorBack = 16;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 11; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_XBS_Yage8(LauncherApplication.getInstance()));
        for (int i3 = 0; i3 < 10; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 10; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 11; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 18) {
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 68) {
            switch (updateCode) {
                case 18:
                    ShowCarState(updateCode, ints);
                    break;
                case 23:
                    if (strs != null && strs.length > 0) {
                        Title = strs[0];
                    } else {
                        Title = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 24:
                    if (strs != null && strs.length > 0) {
                        Album = strs[0];
                    } else {
                        Album = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 25:
                    if (strs != null && strs.length > 0) {
                        Artist = strs[0];
                    } else {
                        Artist = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 55:
                    if (strs != null && strs.length > 0) {
                        MenuList1 = strs[0];
                    } else {
                        MenuList1 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 56:
                    if (strs != null && strs.length > 0) {
                        MenuList2 = strs[0];
                    } else {
                        MenuList2 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 57:
                    if (strs != null && strs.length > 0) {
                        MenuList3 = strs[0];
                    } else {
                        MenuList3 = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 68) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
