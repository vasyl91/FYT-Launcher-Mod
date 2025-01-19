package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.wccamry.ConstWcToyota;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0418_XBS_XP1_AnKeSela_Cx4_Atenza extends CallbackCanbusBase {
    public static final int C_CARCD_SET = 0;
    public static final int C_CARSETTING = 1;
    public static String Songname = null;
    public static final int U_CARINFO_BEGIN = 7;
    public static final int U_CARINFO_CD_PLAYFOLDER = 11;
    public static final int U_CARINFO_CD_PLAYSTATE = 10;
    public static final int U_CARINFO_CD_PLAYTIME = 14;
    public static final int U_CARINFO_CD_PLAYTRACK = 12;
    public static final int U_CARINFO_CD_STATE = 7;
    public static final int U_CARINFO_CD_STR = 15;
    public static final int U_CARINFO_CD_TOTALTIME = 13;
    public static final int U_CARINFO_CD_TOTALTRACK = 8;
    public static final int U_CARINFO_CD_WORKSTATE = 9;
    public static final int U_CNT_MAX = 47;
    public static final int U_CUR_OIL_EXPEND = 42;
    public static final int U_CUR_TRIP_OIL_EXPEND = 43;
    public static final int U_IELOOP_OIL_EXPEND = 44;
    public static final int U_LAST_N_MINUTE_OIL_EXPEND = 40;
    public static final int U_SETTING_09D00 = 19;
    public static final int U_SETTING_09D02 = 18;
    public static final int U_SETTING_09D04 = 17;
    public static final int U_SETTING_09D07 = 16;
    public static final int U_SETTING_09D10 = 25;
    public static final int U_SETTING_09D12 = 24;
    public static final int U_SETTING_09D14 = 23;
    public static final int U_SETTING_09D15 = 22;
    public static final int U_SETTING_09D16 = 21;
    public static final int U_SETTING_09D17 = 20;
    public static final int U_SETTING_09D20 = 32;
    public static final int U_SETTING_09D22 = 31;
    public static final int U_SETTING_09D23 = 30;
    public static final int U_SETTING_09D24 = 29;
    public static final int U_SETTING_09D25 = 28;
    public static final int U_SETTING_09D26 = 27;
    public static final int U_SETTING_09D27 = 26;
    public static final int U_SETTING_09D30 = 35;
    public static final int U_SETTING_09D33 = 34;
    public static final int U_SETTING_09D36 = 33;
    public static final int U_SETTING_09D40 = 36;
    public static final int U_SETTING_09D50 = 37;
    public static final int U_SETTING_09D60 = 38;
    public static final int U_SETTING_09D77 = 45;
    public static final int U_TRIP_OIL_EXPEND = 41;
    public static int infoIndex;
    public static int infoType;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 47; i++) {
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 47) {
            switch (updateCode) {
                case 15:
                    infoType = ints[0];
                    if (strs != null && strs.length > 0) {
                        Songname = strs[0];
                    } else {
                        Songname = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 40:
                    lastMinoldexpend(updateCode, ints);
                    break;
                case 41:
                    tripOilexpend(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 47) {
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
