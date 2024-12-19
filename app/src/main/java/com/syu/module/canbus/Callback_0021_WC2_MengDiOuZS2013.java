package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.mengdiou.MDOAirControlActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0021_WC1_Ecosport2018;
import com.syu.ui.air.Air_0021_WC1_MengDiOu2013;
import com.syu.ui.air.Air_0021_WC1_MengDiOu2013H;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0021_WC2_MengDiOuZS2013 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_AUTO_LEVEL = 32;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_LEFT = 37;
    public static final int U_AIR_BLOW_RIGHT = 36;
    public static final int U_AIR_BLOW_UP_LEFT = 9;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_DUAL = 12;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_HEAT_LEFT = 27;
    public static final int U_AIR_HEAT_RIGHT = 26;
    public static final int U_AIR_MAX = 10;
    public static final int U_AIR_POWER = 14;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_SHOW = 15;
    public static final int U_AIR_STEER_HOT = 35;
    public static final int U_AIR_TEMP_LEFT = 6;
    public static final int U_AIR_TEMP_RIGHT = 13;
    public static final int U_AIR_WIND_LEVEL_LEFT = 11;
    public static final int U_CARINFO_LANGUAGE = 31;
    public static final int U_CARINFO_UNIT_DISTANCE = 29;
    public static final int U_CARINFO_UNIT_TEMP = 30;
    public static final int U_CARSET_D34_D2_D3 = 38;
    public static final int U_CARSET_D34_D4_D5_D6 = 39;
    public static final int U_CARSET_D48_D2_D3 = 40;
    public static final int U_CARSET_D48_D4_D5 = 41;
    public static final int U_CARSET_D48_D6_D7 = 42;
    public static final int U_CARSET_D48_D8_D9 = 43;
    public static final int U_CARSET_D61_D2_B70 = 44;
    public static final int U_CNT_MAX = 45;
    public static final int U_CURSPEED_ENABLE = 34;
    public static final int U_CUR_SPEED = 24;
    public static final int U_DOOR_BACK = 22;
    public static final int U_DOOR_BEGIN = 18;
    public static final int U_DOOR_END = 23;
    public static final int U_DOOR_ENGINE = 17;
    public static final int U_DOOR_FL = 18;
    public static final int U_DOOR_FR = 19;
    public static final int U_DOOR_RL = 20;
    public static final int U_DOOR_RR = 21;
    public static final int U_ENGINE_ENABLE = 33;
    public static final int U_ENGINE_SPEED = 25;
    public static final int U_FRONT_WIND_MODE = 16;
    public static final int U_SHOW_AIR_KEY = 28;
    int carId;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        this.carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 45; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 17;
        DoorHelper.sUcDoorFl = 18;
        DoorHelper.sUcDoorFr = 19;
        DoorHelper.sUcDoorRl = 20;
        DoorHelper.sUcDoorRr = 21;
        DoorHelper.sUcDoorBack = 22;
        if (this.carId == 5) {
            AirHelper.getInstance().buildUi(new Air_0021_WC1_MengDiOu2013H(LauncherApplication.getInstance()));
        } else if (this.carId == 6) {
            AirHelper.getInstance().buildUi(new Air_0021_WC1_Ecosport2018(LauncherApplication.getInstance()));
        } else {
            AirHelper.getInstance().buildUi(new Air_0021_WC1_MengDiOu2013(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 17; i2 < 23; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 0; i3 < 17; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (this.carId == 5 || this.carId == 6) {
            DataCanbus.NOTIFY_EVENTS[26].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[27].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[32].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 18; i < 23; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 0; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 28:
                HandlerCanbus.update(updateCode, ints);
                int i = DataCanbus.DATA[28];
                if (ints[0] == 1 && !MDOAirControlActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.mengdiou.MDOAirControlActi");
                    break;
                } else if (ints[0] == 1 && MDOAirControlActi.mIsFront && MDOAirControlActi.mInstance != null) {
                    MDOAirControlActi.mInstance.finish();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 45) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
