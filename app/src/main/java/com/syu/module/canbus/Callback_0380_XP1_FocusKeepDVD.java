package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.focus.FocusSyncBtActi;
import com.syu.carinfo.xp.ylford.YLFordCarCD;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0380_XP1_FocusKeepDVD extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_AUTO_REQUEST = 110;
    public static final int U_BT_STATE = 103;
    public static final int U_CARCDINFO_STR = 118;
    public static final int U_CARCDMODE = 113;
    public static final int U_CARCDPLAYMODE = 115;
    public static final int U_CARCDPLAYTIME = 117;
    public static final int U_CARINFO_BEGIN = 98;
    public static final int U_CARINFO_END = 112;
    public static final int U_CARSET_BRIGHTNESS = 124;
    public static final int U_CARSET_INFORMATION = 122;
    public static final int U_CARSET_INTERIORLIGHTING = 128;
    public static final int U_CARSET_RAINSENSOR = 130;
    public static final int U_CARSET_TOWSYSTEM = 121;
    public static final int U_CARSET_TURNLIGHT = 127;
    public static final int U_CARSET_TYREMONITOR = 129;
    public static final int U_CARSET_UNIT = 125;
    public static final int U_CARSET_VOICEMODE = 126;
    public static final int U_CARSET_WARNING = 123;
    public static final int U_CAR_TRACK_INFO = 116;
    public static final int U_CAR_WARN = 111;
    public static final int U_CNT_MAX = 131;
    public static final int U_CUR_WORK_MODE = 107;
    public static final int U_DISPLAY_MODE = 102;
    public static final int U_JUMPCD = 120;
    public static final int U_JUMPSYNC = 119;
    public static final int U_LINE_GROUP = 100;
    public static final int U_LIST_INFO = 105;
    public static final int U_MODE_STATE = 108;
    public static final int U_PARM_WARM = 104;
    public static final int U_PHONE_STATE = 109;
    public static final int U_PHONE_TIME = 106;
    public static final int U_PLAY_TIME = 101;
    public static final int U_SCREEN_ICON = 99;
    public static final int U_SCREEN_ID = 98;
    public static String current_playtime;
    public static int infoIndex;
    public static int infoType;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 131; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.sUcDoorEngine = 0;
        //AirHelper.getInstance().buildUi(new Air_0380_XP1_Focus2012(LauncherApplication.getInstance()));
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
        if (updateCode == 99 || updateCode == 100 || updateCode == 105 || updateCode == 111 || updateCode == 110) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 118) {
            if (ints != null && ints.length >= 2) {
                infoType = ints[0];
                infoIndex = ints[1];
            }
            if (strs != null && strs.length > 0) {
                Songname = strs[0];
            } else {
                Songname = "";
            }
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
            return;
        }
        if (updateCode == 120) {
            if (!YLFordCarCD.mIsFront) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ylford.YLFordCarCD");
            }
        } else if (updateCode == 119) {
            if (!FocusSyncBtActi.isFront) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.focus.FocusSyncBtActi");
            }
        } else if (updateCode >= 0 && updateCode < 131) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
