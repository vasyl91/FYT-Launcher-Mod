package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0307_XBS_XP1_15ZhongHuaV3 extends CallbackCanbusBase {
    public static final int C_CMD_CARINFO = 0;
    public static final int U_CARINFO_AUTO_DOOR_LOCK = 100;
    public static final int U_CARINFO_AUTO_DOOR_RELOCK = 101;
    public static final int U_CARINFO_AUTO_DOOR_UNLOCK = 99;
    public static final int U_CARINFO_BACKCAR_MUTE_INHIBITION = 107;
    public static final int U_CARINFO_BACK_CAMERA = 106;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_D4_D03_B54 = 110;
    public static final int U_CARINFO_D4_D03_B6 = 109;
    public static final int U_CARINFO_D4_D03_B7 = 108;
    public static final int U_CARINFO_D4_D04_B32 = 115;
    public static final int U_CARINFO_D4_D04_B64 = 114;
    public static final int U_CARINFO_D4_D04_B7 = 111;
    public static final int U_CARINFO_D4_D05_B70 = 112;
    public static final int U_CARINFO_D4_D06_B70 = 113;
    public static final int U_CARINFO_LOCK_FLASH = 103;
    public static final int U_CARINFO_ONE_DOOR_UNLOCK = 102;
    public static final int U_CARINFO_REAR_MIRROR_AUTO_FOLD = 105;
    public static final int U_CARINFO_UNLOCK_FLASH = 104;
    public static final int U_CNT_MAX = 116;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0307_XBS_15ZhongHuaV3(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
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
        if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
