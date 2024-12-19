package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.luz.binli.BinliCarSet;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_LZ_Binli;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_LUZ_Binli extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AQS = 28;
    public static final int U_AIR_AUTO_LEFT = 11;
    public static final int U_AIR_AUTO_RIGHT = 12;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 17;
    public static final int U_AIR_BLOW_BODY_RIGHT = 24;
    public static final int U_AIR_BLOW_FOOT_LEFT = 18;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 25;
    public static final int U_AIR_BLOW_MODE_LEFT = 19;
    public static final int U_AIR_BLOW_MODE_RIGHT = 26;
    public static final int U_AIR_BLOW_UP_LEFT = 16;
    public static final int U_AIR_BLOW_UP_RIGHT = 23;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_DUAL = 13;
    public static final int U_AIR_END = 31;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_CTRL = 27;
    public static final int U_AIR_REAR_DEFROST = 15;
    public static final int U_AIR_REST = 29;
    public static final int U_AIR_TEMP_LEFT = 21;
    public static final int U_AIR_TEMP_RIGHT = 22;
    public static final int U_AIR_TEMP_UNIT = 30;
    public static final int U_AIR_WIND_LEVEL = 20;
    public static final int U_CARINFO_INTERIOR_ALARM = 84;
    public static final int U_CARINFO_LIGHT_DELAY = 83;
    public static final int U_CARINFO_MOVE_ALARM = 85;
    public static final int U_CARSET_BEGIN = 32;
    public static final int U_CARSET_CAR_LEV = 49;
    public static final int U_CARSET_CUR_SPEED = 51;
    public static final int U_CARSET_DRIVENABLE_MILE = 52;
    public static final int U_CARSET_END = 68;
    public static final int U_CARSET_ENGINE_SPEED = 53;
    public static final int U_CARSET_HANG_LEV = 48;
    public static final int U_CARSET_HANG_ON = 47;
    public static final int U_CARSET_LIGHT_STATE = 50;
    public static final int U_CARSET_MILE_UNIT = 57;
    public static final int U_CARSET_PARK_MODE = 34;
    public static final int U_CARSET_RADAR_BEEP = 33;
    public static final int U_CARSET_TEMP_UNIT = 56;
    public static final int U_CARSET_TIRE_CALI = 45;
    public static final int U_CARSET_TIRE_ERROR = 46;
    public static final int U_CARSET_TIRE_FL = 40;
    public static final int U_CARSET_TIRE_FR = 41;
    public static final int U_CARSET_TIRE_MONITOR_TYPE = 44;
    public static final int U_CARSET_TIRE_ONOFF = 39;
    public static final int U_CARSET_TIRE_RL = 42;
    public static final int U_CARSET_TIRE_RR = 43;
    public static final int U_CARSET_TIRE_SPEED = 37;
    public static final int U_CARSET_TIRE_TYPE = 38;
    public static final int U_CARSET_TIRE_UNIT = 36;
    public static final int U_CARSET_TOTAL_MILE = 54;
    public static final int U_CARSET_TRIPA_AVG_SPEED = 60;
    public static final int U_CARSET_TRIPA_MILE = 58;
    public static final int U_CARSET_TRIPA_OIL = 59;
    public static final int U_CARSET_TRIPA_UNIT = 61;
    public static final int U_CARSET_TRIPB_AVG_OIL = 64;
    public static final int U_CARSET_TRIPB_AVG_SPEED = 65;
    public static final int U_CARSET_TRIPB_MILE = 62;
    public static final int U_CARSET_TRIPB_OIL = 63;
    public static final int U_CARSET_TRIPB_TIME = 67;
    public static final int U_CARSET_TRIPB_UNIT = 66;
    public static final int U_CARSET_VOLTAGE = 55;
    public static final int U_CARSET_WIPER_STATE = 35;
    public static final int U_CAR_CD1_STATE = 69;
    public static final int U_CAR_CD2_STATE = 70;
    public static final int U_CAR_CD3_STATE = 71;
    public static final int U_CAR_CD4_STATE = 72;
    public static final int U_CAR_CD5_STATE = 73;
    public static final int U_CAR_CD6_STATE = 74;
    public static final int U_CAR_CD_MIN = 81;
    public static final int U_CAR_CD_NUM = 79;
    public static final int U_CAR_CD_PLAYSTATE = 75;
    public static final int U_CAR_CD_PREVIEW = 78;
    public static final int U_CAR_CD_RANDOM = 77;
    public static final int U_CAR_CD_REPEAT = 76;
    public static final int U_CAR_CD_SEC = 82;
    public static final int U_CAR_CD_TRACK = 80;
    public static final int U_CNT_MAX = 86;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 86; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_LZ_Binli(LauncherApplication.getInstance()));
        for (int i3 = 7; i3 < 31; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 31; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    private void ShowCarState(int updateCode, int[] ints) {
        if (updateCode == 47) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            switch (value) {
                case 0:
                    if (BinliCarSet.mIsFront && BinliCarSet.mInstance != null) {
                        BinliCarSet.mInstance.finish();
                        break;
                    }
                case 1:
                    if (!BinliCarSet.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.luz.binli.BinliCarSet");
                        break;
                    }
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 86) {
            switch (updateCode) {
                case 47:
                    ShowCarState(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 86) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }
}
