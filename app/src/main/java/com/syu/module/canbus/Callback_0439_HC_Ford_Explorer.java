package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_HC_Ford_Explorer;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_HC_Ford_Explorer extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_ACMAX = 16;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_AUTO_WIN = 18;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_AUTO_LEFT = 23;
    public static final int U_AIR_BLOW_BODY_LEFT = 21;
    public static final int U_AIR_BLOW_BODY_REAR = 34;
    public static final int U_AIR_BLOW_FOOT_LEFT = 22;
    public static final int U_AIR_BLOW_FOOT_REAR = 35;
    public static final int U_AIR_BLOW_UP_LEFT = 20;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 10;
    public static final int U_AIR_END = 37;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_FRONT_MAX = 15;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_REAR_LOCK = 32;
    public static final int U_AIR_REAR_POWER = 31;
    public static final int U_AIR_REAR_WIND_LEVEL = 33;
    public static final int U_AIR_SEAT_BLOW_LEFT = 29;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 30;
    public static final int U_AIR_SEAT_HOT_LEFT = 27;
    public static final int U_AIR_SEAT_HOT_RIGHT = 28;
    public static final int U_AIR_STEER_HOT = 17;
    public static final int U_AIR_TEMP_LEFT = 24;
    public static final int U_AIR_TEMP_REAR = 36;
    public static final int U_AIR_TEMP_RIGHT = 25;
    public static final int U_AIR_TEMP_UNIT = 26;
    public static final int U_AIR_WIND_LEVEL = 19;
    public static final int U_CARSET_BEGIN = 38;
    public static final int U_CARSET_D40_D0_B54 = 72;
    public static final int U_CARSET_D40_D0_B76 = 71;
    public static final int U_CARSET_D40_D1_B70 = 73;
    public static final int U_CARSET_D40_D2_B70 = 74;
    public static final int U_CARSET_D40_D3_B70 = 75;
    public static final int U_CARSET_D40_D4_B70 = 76;
    public static final int U_CARSET_D40_D5_B70 = 77;
    public static final int U_CARSET_D40_D6_B70 = 78;
    public static final int U_CARSET_D40_D7_B10 = 82;
    public static final int U_CARSET_D40_D7_B32 = 81;
    public static final int U_CARSET_D40_D7_B76 = 80;
    public static final int U_CARSET_D40_D8_B10 = 85;
    public static final int U_CARSET_D40_D8_B32 = 84;
    public static final int U_CARSET_D40_D8_B76 = 83;
    public static final int U_CARSET_D40_D9_B20 = 86;
    public static final int U_CARSET_END = 43;
    public static final int U_CARSET_LANGUAGE = 41;
    public static final int U_CARSET_LIGHT_COLOR = 42;
    public static final int U_CARSET_MILE_UNIT = 40;
    public static final int U_CARSET_TEMP_UNIT = 39;
    public static final int U_CAR_CD_PLAYTIME = 57;
    public static final int U_CAR_CD_RANDOM = 56;
    public static final int U_CAR_CD_REPEAT = 55;
    public static final int U_CAR_CD_TOTALTIME = 58;
    public static final int U_CAR_CD_TOTALTRACK = 60;
    public static final int U_CAR_CD_TRACK = 59;
    public static final int U_CAR_CD_WORKE_STATE = 54;
    public static final int U_CAR_EQ_BAL = 64;
    public static final int U_CAR_EQ_BASS = 66;
    public static final int U_CAR_EQ_FAD = 65;
    public static final int U_CAR_EQ_MID = 67;
    public static final int U_CAR_EQ_SPEED = 70;
    public static final int U_CAR_EQ_ST = 69;
    public static final int U_CAR_EQ_TREB = 68;
    public static final int U_CAR_EQ_VOL = 63;
    public static final int U_CAR_JUMP_CD = 61;
    public static final int U_CAR_JUMP_RADIO = 62;
    public static final int U_CAR_RADIO_BAND = 45;
    public static final int U_CAR_RADIO_CHANNEL = 47;
    public static final int U_CAR_RADIO_FREQ = 46;
    public static final int U_CAR_RADIO_FREQ1 = 48;
    public static final int U_CAR_RADIO_FREQ2 = 49;
    public static final int U_CAR_RADIO_FREQ3 = 50;
    public static final int U_CAR_RADIO_FREQ4 = 51;
    public static final int U_CAR_RADIO_FREQ5 = 52;
    public static final int U_CAR_RADIO_FREQ6 = 53;
    public static final int U_CAR_RADIO_SACN = 44;
    public static final int U_CNT_MAX = 87;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 87; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_HC_Ford_Explorer(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 37; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 7; i2 < 37; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 87) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
