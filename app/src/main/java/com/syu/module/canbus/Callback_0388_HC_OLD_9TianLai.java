package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.sbd.x80.TianLai09Act;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0388_HC_XP1_9TianLai;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0388_HC_OLD_9TianLai extends CallbackCanbusBase {
    public static final int U_AIR_AC = 15;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY_LEFT = 18;
    public static final int U_AIR_BLOW_FOOT_LEFT = 19;
    public static final int U_AIR_BLOW_MODE_LEFT = 23;
    public static final int U_AIR_BLOW_UP_LEFT = 20;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 22;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_TEMP_RIGHT = 17;
    public static final int U_AIR_WIND_LEVEL_LEFT = 21;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CAR_VOL = 67;
    public static final int U_CD_BEGIN = 56;
    public static final int U_CD_CURRENT_DISC_TRACK = 59;
    public static final int U_CD_CURRENT_TIME = 60;
    public static final int U_CD_DISC_STATE = 58;
    public static final int U_CD_DISC_WORK_STATE = 61;
    public static final int U_CD_END = 63;
    public static final int U_CD_STATE = 57;
    public static final int U_CD_TEXT = 62;
    public static final int U_CNT_MAX = 69;
    public static final int U_CUR_SPEED = 7;
    public static final int U_DOOR_BACK = 5;
    public static final int U_DOOR_BEGIN = 0;
    public static final int U_DOOR_END = 6;
    public static final int U_DOOR_ENGINE = 0;
    public static final int U_DOOR_FL = 1;
    public static final int U_DOOR_FR = 2;
    public static final int U_DOOR_RL = 3;
    public static final int U_DOOR_RR = 4;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_MEDIA_BEGIN = 64;
    public static final int U_MEDIA_END = 66;
    public static final int U_MEDIA_STATE = 65;
    public static final int U_RADIO_BAND = 52;
    public static final int U_RADIO_CHANNEL_FREQ = 53;
    public static final int U_RADIO_END = 55;
    public static final int U_RADIO_STATE = 51;
    public static final int U_RADIO_TEXT = 54;
    public static final int U_SOURCE_STATE = 68;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 69; i++) {
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
        for (int i3 = 10; i3 < 24; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        AirHelper.getInstance().buildUi(new Air_0388_HC_XP1_9TianLai(LauncherApplication.getInstance()));
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 24; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 53 || updateCode == 54 || updateCode == 62) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 68) {
            if ((ints[0] == 2 || ints[0] == 1) && !TianLai09Act.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.sbd.x80.TianLai09Act");
            }
            HandlerCanbus.update(updateCode, ints);
            return;
        }
        if (updateCode >= 0 && updateCode < 69) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
