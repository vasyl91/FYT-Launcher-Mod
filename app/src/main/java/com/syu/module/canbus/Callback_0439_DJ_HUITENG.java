package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.huiteng.HuitengCarSet;
import com.syu.carinfo.huiteng.Huiteng_AirRearCtrl;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_DJ_HUITENG extends CallbackCanbusBase {
    public static final int U_AIR_AUTO_TEMP = 105;
    public static final int U_AIR_AUTO_WIND = 106;
    public static final int U_AIR_SET_STATE = 107;
    public static final int U_CAR_JUMPINFO1 = 115;
    public static final int U_CAR_LEVEL = 113;
    public static final int U_CAR_SOFT_LEFT = 114;
    public static final int U_CAR_VOL = 116;
    public static final int U_CD_MIN = 112;
    public static final int U_CD_NUM = 109;
    public static final int U_CD_SEC = 111;
    public static final int U_CD_TRACK = 110;
    public static final int U_CELL_VOL = 100;
    public static final int U_CELL_VOL_WARN_FLAG = 103;
    public static final int U_CNT_MAX = 117;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_JUMP_CARINFO = 108;
    public static final int U_RADARMUTE = 117;
    public static final int U_RES_MIL = 101;
    public static final int U_RES_OIL = 102;
    public static final int U_RES_OIL_WARN_FLAG = 104;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 117; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_LZ_Huiteng(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 117) {
            switch (updateCode) {
                case 108:
                    if (ints[0] == 1 && !Huiteng_AirRearCtrl.mIsFront) {
                        //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.huiteng.Huiteng_AirRearCtrl");
                        break;
                    }
                case 115:
                    if (ints[0] == 1 && !HuitengCarSet.mIsFront) {
                        //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.huiteng.HuitengCarSet");
                        break;
                    }
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
