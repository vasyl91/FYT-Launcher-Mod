package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

public class Callback_0170_XP1_AnKeSela extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_CARCDENDI = 104;
    public static final int U_CARCDSTATE = 98;
    public static final int U_CAR_PLAY_PROGRESS = 100;
    public static final int U_CAR_PLAY_STATE = 101;
    public static final int U_CAR_TRACK_INFO = 102;
    public static final int U_CNT_MAX = 104;
    public static final int U_DISPLAY_ENABLE_0 = 103;
    public static final int U_SYNC_LINE_GROUP_STR = 99;
    public static int infoType;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 104; i++) {
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
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 104) {
            if (updateCode == 99) {
                if (ints != null && ints.length >= 1) {
                    infoType = ints[0];
                    if (strs != null && strs.length > 0) {
                        Songname = strs[0];
                    } else {
                        Songname = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    return;
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
