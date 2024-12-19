package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_HC_Oubao_CD extends CallbackCanbusBase {
    public static final int CMD_CARCD_CTRL = 0;
    public static final int U_CARINFO_BEGIN = 0;
    public static final int U_CARINFO_END = 4;
    public static final int U_CAR_AVG_FUEL = 61;
    public static final int U_CAR_AVG_FUEL2 = 65;
    public static final int U_CAR_AVG_SPEED = 59;
    public static final int U_CAR_AVG_SPEED2 = 63;
    public static final int U_CAR_BEGIN = 52;
    public static final int U_CAR_CUR_FUEL = 54;
    public static final int U_CAR_MILE_DRIVEED = 58;
    public static final int U_CAR_MILE_DRIVEED2 = 62;
    public static final int U_CAR_MILE_DRIVE_ENABLE = 53;
    public static final int U_CAR_TIRE_FL = 55;
    public static final int U_CAR_TIRE_FR = 55;
    public static final int U_CAR_TIRE_RL = 56;
    public static final int U_CAR_TIRE_RR = 57;
    public static final int U_CAR_TOTAL_FUEL = 60;
    public static final int U_CAR_TOTAL_FUEL2 = 64;
    public static final int U_CD_BEGIN = 23;
    public static final int U_CD_CUR_TRACK = 24;
    public static final int U_CD_END = 29;
    public static final int U_CD_PLAY_TIME_M = 25;
    public static final int U_CD_PLAY_TIME_S = 26;
    public static final int U_CD_REPEAT_STATE = 27;
    public static final int U_CD_WORK_STATE = 28;
    public static final int U_CNT_MAX = 66;
    public static final int U_LIST_BEGIN = 37;
    public static final int U_LIST_END = 51;
    public static final int U_LIST_NUM1 = 45;
    public static final int U_LIST_NUM2 = 46;
    public static final int U_LIST_NUM3 = 47;
    public static final int U_LIST_NUM4 = 48;
    public static final int U_LIST_NUM5 = 49;
    public static final int U_LIST_NUM6 = 50;
    public static final int U_LIST_NUM_SELECT = 38;
    public static final int U_LIST_TYPE1 = 39;
    public static final int U_LIST_TYPE2 = 40;
    public static final int U_LIST_TYPE3 = 41;
    public static final int U_LIST_TYPE4 = 42;
    public static final int U_LIST_TYPE5 = 43;
    public static final int U_LIST_TYPE6 = 44;
    public static final int U_RADIO_AS_ONOFF = 17;
    public static final int U_RADIO_BAND = 6;
    public static final int U_RADIO_BEGIN = 5;
    public static final int U_RADIO_END = 22;
    public static final int U_RADIO_FREQ = 7;
    public static final int U_RADIO_FREQ1 = 8;
    public static final int U_RADIO_FREQ2 = 9;
    public static final int U_RADIO_FREQ3 = 10;
    public static final int U_RADIO_FREQ4 = 11;
    public static final int U_RADIO_FREQ5 = 12;
    public static final int U_RADIO_FREQ6 = 13;
    public static final int U_RADIO_FREQ7 = 14;
    public static final int U_RADIO_FREQ8 = 15;
    public static final int U_RADIO_FREQ9 = 16;
    public static final int U_RADIO_LOC_ONOFF = 18;
    public static final int U_RADIO_MAN_ONOFF = 20;
    public static final int U_RADIO_MEMORY_ONOFF = 21;
    public static final int U_RADIO_SEEK_ONOFF = 19;
    public static final int U_USB_BEGIN = 30;
    public static final int U_USB_CUR_TRACK = 31;
    public static final int U_USB_END = 36;
    public static final int U_USB_PLAY_TIME_M = 32;
    public static final int U_USB_PLAY_TIME_S = 33;
    public static final int U_USB_REPEAT_STATE = 34;
    public static final int U_USB_WORK_STATE = 35;
    public static final int U_WORK_STATE_CD = 2;
    public static final int U_WORK_STATE_LIST = 1;
    public static final int U_WORK_STATE_MODE = 3;
    public static final int U_WORK_STATE_POWER = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 66; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 66) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
