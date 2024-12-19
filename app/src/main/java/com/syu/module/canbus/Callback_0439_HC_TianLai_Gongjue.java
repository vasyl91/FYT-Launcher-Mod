package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.hc.tianlai.ActivityToread_AirRearCtrl;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_HC_Nissan_Guishi;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_HC_TianLai_Gongjue extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int CMD_CAREQ_CTRL = 3;
    public static final int CMD_CARSET2_CTRL = 4;
    public static final int CMD_CARSET_CTRL = 1;
    public static final int C_CMD_AIR_REAR = 6;
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AUTO = 10;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_MODE = 18;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_CYCLE = 14;
    public static final int U_AIR_DUAL = 11;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_FRONT_DEFROST = 12;
    public static final int U_AIR_REAR_DEFROST = 13;
    public static final int U_AIR_TEMP_LEFT = 20;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_WIND_LEVEL_LEFT = 19;
    public static final int U_CAREQ_BAL = 34;
    public static final int U_CAREQ_BASS = 32;
    public static final int U_CAREQ_BEGIN = 30;
    public static final int U_CAREQ_BOSE_CENTERPOINT = 37;
    public static final int U_CAREQ_END = 39;
    public static final int U_CAREQ_FAD = 35;
    public static final int U_CAREQ_SPEED_VOL = 38;
    public static final int U_CAREQ_SURROUND_VOL = 36;
    public static final int U_CAREQ_TRE = 33;
    public static final int U_CAREQ_VOL = 31;
    public static final int U_CARINFO_DRIVE_ENABLE = 48;
    public static final int U_CARSET_BEGIN = 40;
    public static final int U_CARSET_END = 47;
    public static final int U_CARSET_HEADLIGHTS_DELAYTIME = 45;
    public static final int U_CARSET_HEADLIGHTS_SENSITIVITY = 42;
    public static final int U_CARSET_INTELLIGENT_KEY = 44;
    public static final int U_CARSET_INTERIOR_ILLUMINATION = 41;
    public static final int U_CARSET_SPEED_SENSING_WIPER = 43;
    public static final int U_CARSET_UNLOCK_SELECTE = 46;
    public static final int U_CD_BEGIN = 23;
    public static final int U_CD_END = 29;
    public static final int U_CD_PLAYSTATE = 25;
    public static final int U_CD_START = 24;
    public static final int U_CD_TIME_M = 27;
    public static final int U_CD_TIME_S = 28;
    public static final int U_CD_TRACK = 26;
    public static final int U_CNT_MAX = 59;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_REAR_AIR_AUTO = 57;
    public static final int U_REAR_AIR_BEGIN = 49;
    public static final int U_REAR_AIR_BLOW_BODY = 54;
    public static final int U_REAR_AIR_BLOW_FOOT = 55;
    public static final int U_REAR_AIR_END = 58;
    public static final int U_REAR_AIR_MODE = 53;
    public static final int U_REAR_AIR_POWER = 50;
    public static final int U_REAR_AIR_SHOW = 51;
    public static final int U_REAR_AIR_TEMP = 56;
    public static final int U_REAR_AIR_WIN_LEVEL = 52;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 59; i++) {
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
        if (DataCanbus.DATA[1000] == 7799223 || DataCanbus.DATA[1000] == 65988 || DataCanbus.DATA[1000] == 1442245) {
            AirHelper.getInstance().buildUi(new Air_0439_HC_Nissan_Guishi(LauncherApplication.getInstance()));
            for (int i3 = 7; i3 < 22; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 7; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 59) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    private void showCotrolAir(int updateCode, int[] ints) {
        HandlerCanbus.update(updateCode, ints);
        int value = ints[0];
        if (value == 1 && !ActivityToread_AirRearCtrl.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.hc.tianlai.ActivityToread_AirRearCtrl");
        } else if (ActivityToread_AirRearCtrl.mIsFront && ActivityToread_AirRearCtrl.mInstance != null) {
            ActivityToread_AirRearCtrl.mInstance.finish();
        }
    }
}
