package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0420_WC2_10_crown;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0420_WC2_ToYoTa_10_Crown extends CallbackCanbusBase {
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_AQS = 30;
    public static final int U_AIR_AUTO = 22;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_BODY_RIGHT = 34;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 35;
    public static final int U_AIR_BLOW_MODE_LEFT = 19;
    public static final int U_AIR_BLOW_WIN_LEFT = 18;
    public static final int U_AIR_BLOW_WIN_RIGHT = 36;
    public static final int U_AIR_CLEAN = 27;
    public static final int U_AIR_CLEAN_FLOWER = 29;
    public static final int U_AIR_CLEAN_ICE = 28;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_DUAL = 23;
    public static final int U_AIR_END = 37;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 15;
    public static final int U_AIR_SHOW = 25;
    public static final int U_AIR_SWING = 26;
    public static final int U_AIR_TEMP_LEFT = 21;
    public static final int U_AIR_TEMP_REAR_LEFT = 31;
    public static final int U_AIR_TEMP_REAR_RIGHT = 32;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int U_AIR_WIND_LEVEL_REAR = 33;
    public static final int U_CAREQ_D87_D0_B70 = 77;
    public static final int U_CAREQ_D87_D1_B70 = 78;
    public static final int U_CAREQ_D87_D2_B70 = 79;
    public static final int U_CAREQ_D87_D3_B70 = 80;
    public static final int U_CAREQ_D87_D4_B70 = 81;
    public static final int U_CAREQ_D87_D5_B70 = 82;
    public static final int U_CARINF_D13_D0_D1 = 83;
    public static final int U_CARINF_D13_D10_B70 = 88;
    public static final int U_CARINF_D13_D11_B70 = 89;
    public static final int U_CARINF_D13_D14_D15 = 90;
    public static final int U_CARINF_D13_D2_D3 = 84;
    public static final int U_CARINF_D13_D4_D5 = 85;
    public static final int U_CARINF_D13_D6_D7 = 86;
    public static final int U_CARINF_D13_D8_D9 = 87;
    public static final int U_CDC_BEGIN = 66;
    public static final int U_CDC_END = 76;
    public static final int U_CD_CURRENT_DISC_TRACK = 69;
    public static final int U_CD_CURRENT_TIME = 70;
    public static final int U_CD_DISC_STATE = 67;
    public static final int U_CD_DISC_TYPE = 68;
    public static final int U_CD_DISC_WORK_STATE = 71;
    public static final int U_CD_STATE = 72;
    public static final int U_CNT_MAX = 91;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_RADIO_AM_ST_STATE = 54;
    public static final int U_RADIO_BAND = 51;
    public static final int U_RADIO_BEGIN = 50;
    public static final int U_RADIO_CURRENT_FREQ = 52;
    public static final int U_RADIO_END = 65;
    public static final int U_RADIO_PRE_BAND = 56;
    public static final int U_RADIO_PRE_CHANNEL_FREQ = 57;
    public static final int U_RADIO_PRE_SAVE_CHANNEL = 53;
    public static final int U_RADIO_TUNER_STATE = 55;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 91; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0420_WC2_10_crown(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 37; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 37; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 91) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
