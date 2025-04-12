package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0439_XP_SUBURU extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 115;
    public static final int U_CAREQ_BASS = 116;
    public static final int U_CAREQ_FAD = 114;
    public static final int U_CAREQ_MID = 117;
    public static final int U_CAREQ_SYS = 112;
    public static final int U_CAREQ_TREB = 118;
    public static final int U_CAREQ_VOL = 113;
    public static final int U_CARINFO_AUTO_LOCK = 108;
    public static final int U_CARINFO_AUTO_UNLOCK = 109;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_CAR_STEER_BUTTON = 110;
    public static final int U_CARINFO_DEFOGGER = 104;
    public static final int U_CARINFO_END = 111;
    public static final int U_CARINFO_HAZARD_WARN = 106;
    public static final int U_CARINFO_INTERIOR_LIGHT = 103;
    public static final int U_CARINFO_LEFT_BLIND = 100;
    public static final int U_CARINFO_ONE_TOUCH = 105;
    public static final int U_CARINFO_PARK_SYS = 101;
    public static final int U_CARINFO_RAB_SYS = 102;
    public static final int U_CARINFO_RELOCK = 107;
    public static final int U_CARINFO_RIGHT_BLIND = 99;
    public static final int U_CNT_MAX = 120;
    public static final int U_JUMP_SOS_PAGE = 119;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 120; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0439_XP_SUBURU(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 119:
                showSosPage(updateCode, ints);
                break;
            default:
                if (updateCode >= 0 && updateCode < 120) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 119) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }
}
