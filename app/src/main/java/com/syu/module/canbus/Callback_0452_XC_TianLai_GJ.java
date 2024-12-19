package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xc.gongjue.XCTianLaiGjCdAct;
import com.syu.ipc.IModuleCallback;
import com.syu.module.IUiNotify;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_XC_TianLai_GJ;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_XC_TianLai_GJ extends CallbackCanbusBase {
    public static final int C_AIRSET_CONTROL = 1;
    public static final int C_CARSET_CONTROL = 0;
    public static final int C_CD_CONTROL = 2;
    public static final int U_AIR_AC = 4;
    public static final int U_AIR_AUTO = 2;
    public static final int U_AIR_BEGIN = 1;
    public static final int U_AIR_CYCLE = 5;
    public static final int U_AIR_DUAL = 16;
    public static final int U_AIR_END = 17;
    public static final int U_AIR_FRONT_DEFROST = 7;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR_DEFROST = 6;
    public static final int U_AIR_SEAT_BLOW_LEFT = 10;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 11;
    public static final int U_AIR_SEAT_HEAT_LEFT = 8;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 9;
    public static final int U_AIR_SYNC = 3;
    public static final int U_AIR_TEMP_LEFT = 14;
    public static final int U_AIR_TEMP_RIGHT = 15;
    public static final int U_AIR_WIND_LEVEL = 13;
    public static final int U_AIR_WIND_MODE = 12;
    public static final int U_CAREQ_BAL = 38;
    public static final int U_CAREQ_BASS = 40;
    public static final int U_CAREQ_FAD = 39;
    public static final int U_CAREQ_MID = 41;
    public static final int U_CAREQ_TREB = 42;
    public static final int U_CAREQ_VOL = 37;
    public static final int U_CAR_BEGIN = 25;
    public static final int U_CAR_CD_BEGIN = 31;
    public static final int U_CAR_CD_END = 36;
    public static final int U_CAR_CD_PLAYSTATE = 32;
    public static final int U_CAR_CD_STATE = 31;
    public static final int U_CAR_CD_TIME_M = 34;
    public static final int U_CAR_CD_TIME_S = 35;
    public static final int U_CAR_CD_TRACK = 33;
    public static final int U_CAR_END = 30;
    public static final int U_CAR_HEADLIGHTS_OFF_DELAY = 29;
    public static final int U_CAR_HEADLIGHTS_SENSITIVITY = 26;
    public static final int U_CAR_INTELLIGENT_KEY_LOCK = 28;
    public static final int U_CAR_INTERIOR_Ill = 25;
    public static final int U_CAR_SPEED_SENS_WIPER_INTER = 27;
    public static final int U_CNT_MAX = 43;
    public static final int U_DOOR_BACK = 23;
    public static final int U_DOOR_BEGIN = 18;
    public static final int U_DOOR_END = 24;
    public static final int U_DOOR_ENGINE = 18;
    public static final int U_DOOR_FL = 19;
    public static final int U_DOOR_FR = 20;
    public static final int U_DOOR_RL = 21;
    public static final int U_DOOR_RR = 22;
    private IUiNotify mNotifyCanbus = new IUiNotify() { // from class: com.syu.module.canbus.Callback_0452_XC_TianLai_GJ.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 31:
                    Callback_0452_XC_TianLai_GJ.this.isCdVisible(val);
                    break;
            }
        }
    };

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 43; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 18;
        DoorHelper.sUcDoorFl = 19;
        DoorHelper.sUcDoorFr = 20;
        DoorHelper.sUcDoorRl = 21;
        DoorHelper.sUcDoorRr = 22;
        DoorHelper.sUcDoorBack = 23;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 18; i2 < 24; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0452_XC_TianLai_GJ(LauncherApplication.getInstance()));
        for (int i3 = 1; i3 < 17; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[31].addNotify(this.mNotifyCanbus, 1);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 18; i < 24; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 1; i2 < 17; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DataCanbus.NOTIFY_EVENTS[31].removeNotify(this.mNotifyCanbus);
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 43) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void isCdVisible(int val) {
        if (!XCTianLaiGjCdAct.mIsFront && val == 1) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xc.gongjue.XCTianLaiGjCdAct");
        } else if (XCTianLaiGjCdAct.mIsFront && val == 0) {
            XCTianLaiGjCdAct.mInstance.finish();
        }
    }
}
