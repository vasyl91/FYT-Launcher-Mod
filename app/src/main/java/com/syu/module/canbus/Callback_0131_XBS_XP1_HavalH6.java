package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0131_XBS_XP1_HavalH6 extends CallbackCanbusBase {
    public static final int U_AIR_BELT = 104;
    public static final int U_AIR_SRS_WARN = 105;
    public static final int U_AUTO_AC_ENABLED = 100;
    public static final int U_CNT_MAX = 107;
    public static final int U_CUR_SPEED = 101;
    public static final int U_ENGINE_SPEED = 102;
    public static final int U_FEEDBACK_LAMP_ENABLED = 99;
    public static final int U_INFO_END = 103;
    public static final int U_SYSTEM_KEY_WITH_EKEY_ENABLED = 98;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 106;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 107; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        int carid = (DataCanbus.DATA[1000] >> 16) & 65535;
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (carid == 4) {
            //AirHelper.getInstance().buildUi(new Air_0131_XBS_HavaH2(LauncherApplication.getInstance()));
        } else if (carid == 5) {
            //AirHelper.getInstance().buildUi(new Air_0132_XBS_Hava17H2(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0131_FYT_XBS_HavaH6(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
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
        if (updateCode >= 0 && updateCode < 107) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
