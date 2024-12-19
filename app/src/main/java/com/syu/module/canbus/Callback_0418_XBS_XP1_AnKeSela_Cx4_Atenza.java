package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0418_XBS_XP1_AnKeSela_Cx4_Atenza extends CallbackCanbusBase {
    public static final int C_CARCD_SET = 0;
    public static final int C_CARSETTING = 1;
    public static String Songname = null;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_CD_PLAYFOLDER = 54;
    public static final int U_CARINFO_CD_PLAYSTATE = 53;
    public static final int U_CARINFO_CD_PLAYTIME = 57;
    public static final int U_CARINFO_CD_PLAYTRACK = 55;
    public static final int U_CARINFO_CD_STATE = 50;
    public static final int U_CARINFO_CD_STR = 58;
    public static final int U_CARINFO_CD_TOTALTIME = 56;
    public static final int U_CARINFO_CD_TOTALTRACK = 51;
    public static final int U_CARINFO_CD_WORKSTATE = 52;
    public static final int U_CNT_MAX = 90;
    public static final int U_CUR_OIL_EXPEND = 85;
    public static final int U_CUR_TRIP_OIL_EXPEND = 86;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_IELOOP_OIL_EXPEND = 87;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 83;
    public static final int U_SETTING_09D00 = 62;
    public static final int U_SETTING_09D02 = 61;
    public static final int U_SETTING_09D04 = 60;
    public static final int U_SETTING_09D07 = 59;
    public static final int U_SETTING_09D10 = 68;
    public static final int U_SETTING_09D12 = 67;
    public static final int U_SETTING_09D14 = 66;
    public static final int U_SETTING_09D15 = 65;
    public static final int U_SETTING_09D16 = 64;
    public static final int U_SETTING_09D17 = 63;
    public static final int U_SETTING_09D20 = 75;
    public static final int U_SETTING_09D22 = 74;
    public static final int U_SETTING_09D23 = 73;
    public static final int U_SETTING_09D24 = 72;
    public static final int U_SETTING_09D25 = 71;
    public static final int U_SETTING_09D26 = 70;
    public static final int U_SETTING_09D27 = 69;
    public static final int U_SETTING_09D30 = 78;
    public static final int U_SETTING_09D33 = 77;
    public static final int U_SETTING_09D36 = 76;
    public static final int U_SETTING_09D40 = 79;
    public static final int U_SETTING_09D50 = 80;
    public static final int U_SETTING_09D60 = 81;
    public static final int U_SETTING_09D77 = 88;
    public static final int U_TRIP_OIL_EXPEND = 84;
    public static int infoIndex;
    public static int infoType;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 90; i++) {
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 90) {
            switch (updateCode) {
                case 58:
                    infoType = ints[0];
                    if (strs != null && strs.length > 0) {
                        Songname = strs[0];
                    } else {
                        Songname = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 83:
                    lastMinoldexpend(updateCode, ints);
                    break;
                case 84:
                    tripOilexpend(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 90) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void tripOilexpend(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 5) {
            ConstWcToyota.mTripoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void lastMinoldexpend(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 30) {
            ConstWcToyota.mMinuteoilexpend[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
