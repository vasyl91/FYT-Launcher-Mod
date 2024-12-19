package com.syu.module.canbus;

import android.os.RemoteException;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0365_AY1_JeepZYG;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0365_AY1_JeepZYG extends CallbackCanbusBase {
    public static final int U_AIR_AC = 43;
    public static final int U_AIR_AUTO = 39;
    public static final int U_AIR_BEGIN = 38;
    public static final int U_AIR_BLOW_BODY = 47;
    public static final int U_AIR_BLOW_BODYFOOT = 48;
    public static final int U_AIR_BLOW_FOOT = 49;
    public static final int U_AIR_BLOW_FOOTFRONT = 50;
    public static final int U_AIR_CYCLE = 41;
    public static final int U_AIR_Dim_Rear = 42;
    public static final int U_AIR_END = 56;
    public static final int U_AIR_FRONT_DEFROST = 51;
    public static final int U_AIR_GOFOG = 38;
    public static final int U_AIR_POWER = 46;
    public static final int U_AIR_REAR_DEFROST = 52;
    public static final int U_AIR_SEAT_HEAT_LEFT = 54;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 55;
    public static final int U_AIR_SYNC = 40;
    public static final int U_AIR_TEMP_LEFT = 44;
    public static final int U_AIR_TEMP_RIGHT = 45;
    public static final int U_AIR_WIND_LEVEL_LEFT = 53;
    public static final int U_AUTO_DIMMINGHIGHTBEAMS = 8;
    public static final int U_AUTO_LOCK = 11;
    public static final int U_AUTO_PARK_BRAKE = 6;
    public static final int U_BLINDWARN = 24;
    public static final int U_CARCDLOOP = 33;
    public static final int U_CARCDRANDOM = 32;
    public static final int U_CARCDSTATE = 31;
    public static final int U_CARCDTIME = 36;
    public static final int U_CARCDTIMEALL = 37;
    public static final int U_CARCDTRACK = 34;
    public static final int U_CARCDTRACKALL = 35;
    public static final int U_CNT_MAX = 62;
    public static final int U_COMFORTSYSTENS = 25;
    public static final int U_DAYTIME_RUNNING_LIGHTS = 9;
    public static final int U_DOOR_BACK = 61;
    public static final int U_DOOR_BEGIN = 56;
    public static final int U_DOOR_END = 62;
    public static final int U_DOOR_ENGINE = 56;
    public static final int U_DOOR_FL = 57;
    public static final int U_DOOR_FR = 58;
    public static final int U_DOOR_RL = 59;
    public static final int U_DOOR_RR = 60;
    public static final int U_FORWARDCOLLISIONWARN = 19;
    public static final int U_FORWARD_COLLISION_BRAKE = 1;
    public static final int U_FRONTPARKSENSEVOL = 22;
    public static final int U_GETOFF_AUTOLOCK = 12;
    public static final int U_HEADLIGHTS_OFF_DELAY = 15;
    public static final int U_HEADLIGHTS_ON_DELAY = 16;
    public static final int U_HILL_START_ASSIST = 5;
    public static final int U_KEYLESS_ENTRY = 13;
    public static final int U_LANESENSELEVEL = 21;
    public static final int U_LANESENSEWARN = 20;
    public static final int U_LOCK_LIGHTS = 10;
    public static final int U_PARKSENSE = 18;
    public static final int U_PARKSENSE_BRAKEASSIST = 0;
    public static final int U_PARKVIEW_FIXEDLINE = 3;
    public static final int U_PARKVIEW_MOVINGLINE = 2;
    public static final int U_POWER_OFF_DELAY = 17;
    public static final int U_POWER_TAILGATE_ALARM = 14;
    public static final int U_PRESSKEYUNLOCK = 26;
    public static final int U_RAIN_SENSE_WIPERS = 4;
    public static final int U_REARPARKSENSEVOL = 23;
    public static final int U_SETLANGUAGE = 29;
    public static final int U_SETTING_BEGIN = 0;
    public static final int U_SETUNIT = 30;
    public static final int U_SPEEDVOLUME = 28;
    public static final int U_START_HEADLIGHTS = 7;
    public static final int U_SURROUNDSOUND = 27;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 62; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 56;
        DoorHelper.sUcDoorFl = 57;
        DoorHelper.sUcDoorFr = 58;
        DoorHelper.sUcDoorRl = 59;
        DoorHelper.sUcDoorRr = 60;
        DoorHelper.sUcDoorBack = 61;
        AirHelper.getInstance().buildUi(new Air_0365_AY1_JeepZYG(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 56; i2 < 62; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 38; i3 < 56; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[42].removeNotify(AirHelper.SHOW_AND_REFRESH);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 56; i < 62; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 38; i2 < 56; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 62) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
