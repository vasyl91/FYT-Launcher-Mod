package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.focus.FocusSyncBtActi;
import com.syu.carinfo.xp.ylford.YLFordCarCD;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0380_XP1_Focus2012;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0380_XP1_FocusKeepDVD extends CallbackCanbusBase {
    public static String Songname = null;
    public static final int U_AIR_AC = 32;
    public static final int U_AIR_AC_MAX = 43;
    public static final int U_AIR_AUTO = 35;
    public static final int U_AIR_BEGIN = 30;
    public static final int U_AIR_BLOW_BODY = 37;
    public static final int U_AIR_BLOW_FOOT = 38;
    public static final int U_AIR_BLOW_UP = 36;
    public static final int U_AIR_CYCLE = 34;
    public static final int U_AIR_DUAL = 42;
    public static final int U_AIR_END = 45;
    public static final int U_AIR_FRONT = 33;
    public static final int U_AIR_POWER = 31;
    public static final int U_AIR_SHOW = 30;
    public static final int U_AIR_TEMP_LEFT = 40;
    public static final int U_AIR_TEMP_RIGHT = 41;
    public static final int U_AIR_TEMP_UNIT = 44;
    public static final int U_AIR_WIND_LEVEL = 39;
    public static final int U_CARCDINFO_STR = 20;
    public static final int U_CARCDMODE = 15;
    public static final int U_CARCDPLAYMODE = 17;
    public static final int U_CARCDPLAYTIME = 19;
    public static final int U_CARSET_BRIGHTNESS = 26;
    public static final int U_CARSET_INFORMATION = 24;
    public static final int U_CARSET_TOWSYSTEM = 23;
    public static final int U_CARSET_TURNLIGHT = 29;
    public static final int U_CARSET_UNIT = 27;
    public static final int U_CARSET_VOICEMODE = 28;
    public static final int U_CARSET_WARNING = 25;
    public static final int U_CAR_TRACK_INFO = 18;
    public static final int U_CNT_MAX = 51;
    public static final int U_DOOR_BACK = 49;
    public static final int U_DOOR_BEGIN = 45;
    public static final int U_DOOR_END = 51;
    public static final int U_DOOR_ENGINE = 50;
    public static final int U_DOOR_FL = 45;
    public static final int U_DOOR_FR = 46;
    public static final int U_DOOR_RL = 47;
    public static final int U_DOOR_RR = 48;
    public static final int U_JUMPCD = 22;
    public static final int U_JUMPSYNC = 21;
    public static String current_playtime;
    public static int infoIndex;
    public static int infoType;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 51; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorFl = 45;
        DoorHelper.sUcDoorFr = 46;
        DoorHelper.sUcDoorRl = 47;
        DoorHelper.sUcDoorRr = 48;
        DoorHelper.sUcDoorBack = 49;
        DoorHelper.sUcDoorEngine = 50;
        AirHelper.getInstance().buildUi(new Air_0380_XP1_Focus2012(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 45; i2 < 51; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 30; i3 < 45; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 45; i < 51; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 30; i2 < 45; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 1 || updateCode == 2 || updateCode == 7 || updateCode == 13 || updateCode == 12) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
            return;
        }
        if (updateCode == 20) {
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
        if (updateCode == 22) {
            if (!YLFordCarCD.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.ylford.YLFordCarCD");
            }
        } else if (updateCode == 21) {
            if (!FocusSyncBtActi.isFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.focus.FocusSyncBtActi");
            }
        } else if (updateCode >= 0 && updateCode < 51) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
