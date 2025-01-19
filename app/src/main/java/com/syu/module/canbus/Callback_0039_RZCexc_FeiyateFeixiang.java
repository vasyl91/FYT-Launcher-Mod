package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0039_RZCexe_FeiYaTeFeiXiang;
import com.syu.ui.door.DoorHelper;

public class Callback_0039_RZCexc_FeiyateFeixiang extends CallbackCanbusBase {
    public static final int U_CARINF_BEGIN = 115;
    public static final int U_CARINF_CUR_FUEL = 117;
    public static final int U_CARINF_RANGE = 116;
    public static final int U_CARINF_TRIPA_AVG_FUEL = 118;
    public static final int U_CARINF_TRIPA_AVG_SPEED = 119;
    public static final int U_CARINF_TRIPA_DISTANCE = 120;
    public static final int U_CARINF_TRIPA_TIME = 121;
    public static final int U_CARINF_TRIPB_AVG_FUEL = 122;
    public static final int U_CARINF_TRIPB_AVG_SPEED = 123;
    public static final int U_CARINF_TRIPB_DISTANCE = 124;
    public static final int U_CARINF_TRIPB_TIME = 125;
    public static final int U_CARSET_ADD_LIGHTS_D14 = 126;
    public static final int U_CARSET_ADD_PARK_D32 = 127;
    public static final int U_CARSET_ADD_PARK_D33 = 128;
    public static final int U_CARSET_ADD_PARK_D34 = 129;
    public static final int U_CARSET_ADD_PARK_D35 = 130;
    public static final int U_CARSET_ADD_PARK_D36 = 131;
    public static final int U_CARSET_AUTO_CLOSE = 108;
    public static final int U_CARSET_BEEP_VOL = 112;
    public static final int U_CARSET_BEGIN = 98;
    public static final int U_CARSET_CAR_TYPE = 113;
    public static final int U_CARSET_D40_D15_B70 = 132;
    public static final int U_CARSET_D40_D21_B70 = 133;
    public static final int U_CARSET_D40_D22_B70 = 136;
    public static final int U_CARSET_D40_D23_B70 = 137;
    public static final int U_CARSET_D40_D37_B70 = 134;
    public static final int U_CARSET_D40_D38_B70 = 135;
    public static final int U_CARSET_D40_D39_B70 = 138;
    public static final int U_CARSET_D40_D3A_B70 = 139;
    public static final int U_CARSET_D40_D3B_B70 = 140;
    public static final int U_CARSET_END = 114;
    public static final int U_CARSET_LANGUAGE = 99;
    public static final int U_CARSET_LIGHTS_CORNERING = 105;
    public static final int U_CARSET_LIGHTS_COURTESY = 106;
    public static final int U_CARSET_LIGHTS_DAYTIME = 104;
    public static final int U_CARSET_LIGHTS_FLASH = 107;
    public static final int U_CARSET_PARKSENSE = 109;
    public static final int U_CARSET_REAR_PARKENSE_VOL = 110;
    public static final int U_CARSET_TRIPB_SHOW = 111;
    public static final int U_CARSET_UNIT_DISTANCE = 101;
    public static final int U_CARSET_UNIT_FUEL = 100;
    public static final int U_CARSET_UNIT_METRIC = 103;
    public static final int U_CARSET_UNIT_TEMP = 102;
    public static final int U_CNT_MAX = 141;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 141; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        //AirHelper.getInstance().buildUi(new Air_0039_RZCexe_FeiYaTeFeiXiang(LauncherApplication.getInstance()));
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 141) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
