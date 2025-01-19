package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0371_BG_XP1_ZiYouGuang;
import com.syu.ui.door.DoorHelper;
import com.syu.util.Print;

public class Callback_0371_BG_XP1_ZiYouGuang extends CallbackCanbusBase {
    public static final int C_AIR_CONTROL_CMD = 0;
    public static final int C_CAR_INFO_CD_CMD = 4;
    public static final int C_CAR_INFO_DAQIE_CMD = 1;
    public static final int C_CAR_INFO_ZIYOUGUANG_CMD = 2;
    public static final int C_CAR_INFO_ZIYOUGUANG_H_CMD = 3;
    public static final int C_CYT_AIR_CMD = 5;
    public static String Songname = null;
    public static final int U_AUTO_LOCK = 102;
    public static final int U_AUTO_PARK_BRAKE = 99;
    public static final int U_BLINDWARRING = 124;
    public static final int U_BRAKE_MODE = 116;
    public static final int U_CARCDSTATE = 128;
    public static final int U_CARSET_07D00 = 139;
    public static final int U_CARSET_07D01 = 138;
    public static final int U_CARSET_07D02 = 137;
    public static final int U_CARSET_07D04 = 136;
    public static final int U_CARSET_07D06 = 135;
    public static final int U_CARSET_07D16 = 141;
    public static final int U_CARSET_07D17 = 140;
    public static final int U_CARSET_07D21 = 146;
    public static final int U_CARSET_07D22 = 145;
    public static final int U_CARSET_07D23 = 144;
    public static final int U_CARSET_07D24 = 143;
    public static final int U_CARSET_07D26 = 142;
    public static final int U_CARSET_07D30 = 153;
    public static final int U_CARSET_07D31 = 152;
    public static final int U_CARSET_07D32 = 150;
    public static final int U_CARSET_07D33 = 151;
    public static final int U_CARSET_07D34 = 149;
    public static final int U_CARSET_07D36 = 148;
    public static final int U_CARSET_07D37 = 147;
    public static final int U_CARSET_07D45 = 155;
    public static final int U_CARSET_07D47 = 154;
    public static final int U_CARSET_07D53 = 160;
    public static final int U_CARSET_07D54 = 159;
    public static final int U_CARSET_07D55 = 158;
    public static final int U_CARSET_07D56 = 157;
    public static final int U_CARSET_07D57 = 156;
    public static final int U_CARSET_07D65 = 163;
    public static final int U_CARSET_07D66 = 162;
    public static final int U_CARSET_07D67 = 161;
    public static final int U_CARSET_COMPASS = 164;
    public static final int U_CAR_PLAY_PROGRESS = 130;
    public static final int U_CAR_PLAY_STATE = 131;
    public static final int U_CAR_STRS_STATE_ONE = 134;
    public static final int U_CAR_TRACK_INFO = 132;
    public static final int U_CNT_MAX = 165;
    public static final int U_COMFORTSYSTENS = 111;
    public static final int U_COMPASSOFFSET = 113;
    public static final int U_DAYTIME_RUNNING_LIGHTS = 100;
    public static final int U_DISPLAY_ENABLE_0 = 133;
    public static final int U_DORRWARRING = 127;
    public static final int U_FORMATSET = 114;
    public static final int U_FORWARDCOLLISIONWARN = 121;
    public static final int U_FORWARD_COLLISION = 117;
    public static final int U_FRONTPARKSENSEVOL = 109;
    public static final int U_GETOFF_AUTOLOCK = 103;
    public static final int U_HEADLIGHTS_OFF_DELAY = 105;
    public static final int U_HEADLIGHTS_ON_DELAY = 106;
    public static final int U_HILL_START_ASSIST = 98;
    public static final int U_KEYLESS_ENTRY = 104;
    public static final int U_LANEWAR = 122;
    public static final int U_LANGUAGESET = 115;
    public static final int U_LOCK_LIGHTS = 101;
    public static final int U_PARKSENSE = 108;
    public static final int U_PARKSENSE_BRAKEASSIST = 97;
    public static final int U_POWER_OFF_DELAY = 107;
    public static final int U_PRESSKEYUNLOCK = 112;
    public static final int U_RAINAUTOLIGHT = 125;
    public static final int U_REARPARKSENSEVOL = 110;
    public static final int U_SETTING_BEGIN = 97;
    public static final int U_SYNC_LINE_GROUP_STR = 129;
    public static final int U_VIDEO_MOVE = 118;
    public static final int U_VIDEO_STATIC = 119;
    public static final int U_VIEW_AUTOLIGHT = 126;
    public static final int U_VIEW_LANEDEV = 123;
    public static final int U_VIEW_RAINAUTO = 120;
    public static String current_playtime;
    public static int infoIndex;
    public static int infoType;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 165; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0371_BG_XP1_ZiYouGuang(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        switch (updateCode) {
            case 129:
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
                break;
            case 134:
                Print.log("LG", "371 updateCode=" + updateCode + " ints[0]=" + strs[0]);
                if (strs != null && strs.length > 0) {
                    current_playtime = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                }
            default:
                if (updateCode >= 0 && updateCode < 165) {
                    HandlerCanbus.update(updateCode, ints);
                    break;
                }
        }
    }
}
