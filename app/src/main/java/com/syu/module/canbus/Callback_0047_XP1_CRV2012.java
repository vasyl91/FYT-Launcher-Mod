package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.crv.XpCrvActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0047_XP1_CRV2012 extends CallbackCanbusBase {
    public static final int U_AIR_TEMP_OUT = 30;
    public static final int U_BATTERY_VOLTAGE = 23;
    public static final int U_CLEAN_FLUIT_WARN = 20;
    public static final int U_CNT_MAX = 32;
    public static final int U_COMPASS_ANGLE = 9;
    public static final int U_COMPASS_AREA = 8;
    public static final int U_COMPASS_CALIBRATION = 7;
    public static final int U_CUR_OIL_EXPEND = 31;
    public static final int U_CUR_SPEED = 27;
    public static final int U_DOOR_BACK = 15;
    public static final int U_DOOR_BEGIN = 10;
    public static final int U_DOOR_END = 16;
    public static final int U_DOOR_ENGINE = 10;
    public static final int U_DOOR_FL = 11;
    public static final int U_DOOR_FR = 12;
    public static final int U_DOOR_RL = 13;
    public static final int U_DOOR_RR = 14;
    public static final int U_DRIVE_MILE = 24;
    public static final int U_ENGINE_SPEED = 28;
    public static final int U_HANDLE_BRAKE_WARN = 21;
    public static final int U_LIFE_BELT_WARN = 19;
    public static final int U_LOW_BATTERY_WARN = 18;
    public static final int U_LOW_OIL_WARN = 17;
    public static final int U_MISC_END = 32;
    public static final int U_OUT_TEMP = 29;
    public static final int U_PARK = 25;
    public static final int U_PLAYER_FOLDER = 5;
    public static final int U_PLAYER_PROGRESS = 6;
    public static final int U_PLAYER_TIME = 2;
    public static final int U_PLAYER_TOTAL_TRACK = 4;
    public static final int U_PLAYER_TRACK = 3;
    public static final int U_RADAR_MUTE = 26;
    public static final int U_RESIDUAL_OIL = 22;
    public static final int U_USB_STATES = 0;
    public static final int U_USB_TYPE = 1;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 32; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 10;
        DoorHelper.sUcDoorFl = 11;
        DoorHelper.sUcDoorFr = 12;
        DoorHelper.sUcDoorRl = 13;
        DoorHelper.sUcDoorRr = 14;
        DoorHelper.sUcDoorBack = 15;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 10; i2 < 16; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 16; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 32) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode == 0) {
            int value = DataCanbus.DATA[0];
            if (value == 3 && !XpCrvActi.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.crv.XpCrvActi");
            } else if (value == 2 && XpCrvActi.mIsFront && XpCrvActi.mInstance != null) {
                XpCrvActi.mInstance.finish();
            }
        }
    }
}
