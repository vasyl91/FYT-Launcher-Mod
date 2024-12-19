package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.daojun.lexus.djLexusCd;
import com.syu.carinfo.daojun.lexus.djLexusRadio;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_DJ_LEXUS_ES;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_DJ_LEXUS_ES extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int CMD_JUMP_EQ = 2;
    public static final int CMD_SET_CTRL = 1;
    public static final int CMD_SET_CTRL2 = 3;
    public static final int CMD_SET_CTRL3 = 4;
    public static final int CMD_SET_CTRL4 = 5;
    public static final int CMD_SET_JUMPCARUI = 6;
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_UP_LEFT = 11;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_END = 18;
    public static final int U_AIR_FRONT_DEFROST = 8;
    public static final int U_AIR_FRONT_MAX = 6;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR = 7;
    public static final int U_AIR_REAR_CTRL = 10;
    public static final int U_AIR_REAR_DEFROST = 9;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_TYPE = 17;
    public static final int U_AIR_WIND_LEVEL = 14;
    public static final int U_CAR_CD1_STATE = 54;
    public static final int U_CAR_CD2_STATE = 55;
    public static final int U_CAR_CD3_STATE = 56;
    public static final int U_CAR_CD4_STATE = 57;
    public static final int U_CAR_CD5_STATE = 58;
    public static final int U_CAR_CD6_STATE = 59;
    public static final int U_CAR_CD_ASL = 37;
    public static final int U_CAR_CD_BAN = 42;
    public static final int U_CAR_CD_BASS = 38;
    public static final int U_CAR_CD_DISC_RANDOM = 34;
    public static final int U_CAR_CD_DISC_REPEAT = 33;
    public static final int U_CAR_CD_FAD = 41;
    public static final int U_CAR_CD_MID = 39;
    public static final int U_CAR_CD_MIN = 35;
    public static final int U_CAR_CD_NUM = 28;
    public static final int U_CAR_CD_RANDOM = 32;
    public static final int U_CAR_CD_REPEAT = 31;
    public static final int U_CAR_CD_SCAN = 44;
    public static final int U_CAR_CD_SEC = 36;
    public static final int U_CAR_CD_TOTALTRACK = 30;
    public static final int U_CAR_CD_TRACK = 29;
    public static final int U_CAR_CD_TREB = 40;
    public static final int U_CAR_CD_VOL = 43;
    public static final int U_CAR_JUMP_CD = 45;
    public static final int U_CAR_JUMP_RADIO = 46;
    public static final int U_CAR_RADIO_BAND = 19;
    public static final int U_CAR_RADIO_FREQ = 20;
    public static final int U_CAR_RADIO_FREQ1 = 21;
    public static final int U_CAR_RADIO_FREQ2 = 22;
    public static final int U_CAR_RADIO_FREQ3 = 23;
    public static final int U_CAR_RADIO_FREQ4 = 24;
    public static final int U_CAR_RADIO_FREQ5 = 25;
    public static final int U_CAR_RADIO_FREQ6 = 26;
    public static final int U_CAR_RADIO_STATE = 27;
    public static final int U_CNT_MAX = 60;
    public static final int U_DOOR_BACK = 52;
    public static final int U_DOOR_BEGIN = 47;
    public static final int U_DOOR_END = 53;
    public static final int U_DOOR_ENGINE = 47;
    public static final int U_DOOR_FL = 48;
    public static final int U_DOOR_FR = 49;
    public static final int U_DOOR_RL = 50;
    public static final int U_DOOR_RR = 51;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 60; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 47;
        DoorHelper.sUcDoorFl = 48;
        DoorHelper.sUcDoorFr = 49;
        DoorHelper.sUcDoorRl = 50;
        DoorHelper.sUcDoorRr = 51;
        DoorHelper.sUcDoorBack = 52;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 47; i2 < 53; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_DJ_LEXUS_ES(LauncherApplication.getInstance()));
        for (int i3 = 0; i3 < 18; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 47; i < 53; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 18; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 60) {
            int value = ints[0];
            switch (updateCode) {
                case 45:
                    if (value == 1 && !djLexusCd.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.lexus.djLexusCd");
                        break;
                    }
                case 46:
                    if (value == 1 && !djLexusRadio.isFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.daojun.lexus.djLexusRadio");
                        break;
                    }
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
