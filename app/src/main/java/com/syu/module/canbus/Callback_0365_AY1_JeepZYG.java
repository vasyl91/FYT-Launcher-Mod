package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0365_AY1_JeepZYG extends CallbackCanbusBase {
    public static final int U_AUTO_DIMMINGHIGHTBEAMS = 105;
    public static final int U_AUTO_LOCK = 108;
    public static final int U_AUTO_PARK_BRAKE = 103;
    public static final int U_BLINDWARN = 121;
    public static final int U_CARCDLOOP = 130;
    public static final int U_CARCDRANDOM = 129;
    public static final int U_CARCDSTATE = 128;
    public static final int U_CARCDTIME = 133;
    public static final int U_CARCDTIMEALL = 134;
    public static final int U_CARCDTRACK = 131;
    public static final int U_CARCDTRACKALL = 132;
    public static final int U_CNT_MAX = 135;
    public static final int U_COMFORTSYSTENS = 122;
    public static final int U_DAYTIME_RUNNING_LIGHTS = 106;
    public static final int U_FORWARDCOLLISIONWARN = 116;
    public static final int U_FORWARD_COLLISION_BRAKE = 98;
    public static final int U_FRONTPARKSENSEVOL = 119;
    public static final int U_GETOFF_AUTOLOCK = 109;
    public static final int U_HEADLIGHTS_OFF_DELAY = 112;
    public static final int U_HEADLIGHTS_ON_DELAY = 113;
    public static final int U_HILL_START_ASSIST = 102;
    public static final int U_KEYLESS_ENTRY = 110;
    public static final int U_LANESENSELEVEL = 118;
    public static final int U_LANESENSEWARN = 117;
    public static final int U_LOCK_LIGHTS = 107;
    public static final int U_PARKSENSE = 115;
    public static final int U_PARKSENSE_BRAKEASSIST = 97;
    public static final int U_PARKVIEW_FIXEDLINE = 100;
    public static final int U_PARKVIEW_MOVINGLINE = 99;
    public static final int U_POWER_OFF_DELAY = 114;
    public static final int U_POWER_TAILGATE_ALARM = 111;
    public static final int U_PRESSKEYUNLOCK = 123;
    public static final int U_RAIN_SENSE_WIPERS = 101;
    public static final int U_REARPARKSENSEVOL = 120;
    public static final int U_SETLANGUAGE = 126;
    public static final int U_SETTING_BEGIN = 97;
    public static final int U_SETUNIT = 127;
    public static final int U_SPEEDVOLUME = 125;
    public static final int U_START_HEADLIGHTS = 104;
    public static final int U_SURROUNDSOUND = 124;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 135; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0365_AY1_JeepZYG(LauncherApplication.getInstance()));
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
        if (updateCode >= 0 && updateCode < 135) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
