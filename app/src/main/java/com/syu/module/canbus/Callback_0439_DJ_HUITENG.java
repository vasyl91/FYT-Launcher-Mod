package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.huiteng.HuitengCarSet;
import com.syu.carinfo.huiteng.Huiteng_AirRearCtrl;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_LZ_Huiteng;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_DJ_HUITENG extends CallbackCanbusBase {
    public static final int U_AIR_AC = 4;
    public static final int U_AIR_AC_MAX = 20;
    public static final int U_AIR_AQS = 17;
    public static final int U_AIR_AUTO_LEFT = 6;
    public static final int U_AIR_AUTO_RIGHT = 7;
    public static final int U_AIR_AUTO_TEMP = 55;
    public static final int U_AIR_AUTO_WIND = 56;
    public static final int U_AIR_BEGIN = 2;
    public static final int U_AIR_BLOW_BODY = 12;
    public static final int U_AIR_BLOW_BODY_RIGHT = 24;
    public static final int U_AIR_BLOW_FOOT = 13;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 25;
    public static final int U_AIR_BLOW_UP = 11;
    public static final int U_AIR_BLOW_UP_RIGHT = 23;
    public static final int U_AIR_CYCLE = 5;
    public static final int U_AIR_CYCLE_AUTO = 26;
    public static final int U_AIR_DUAL = 8;
    public static final int U_AIR_END = 28;
    public static final int U_AIR_LEFT_SEAT_HOT = 18;
    public static final int U_AIR_MAX = 22;
    public static final int U_AIR_MAX_FRONT = 9;
    public static final int U_AIR_POWER = 3;
    public static final int U_AIR_REAR = 10;
    public static final int U_AIR_REAR_LOCK = 19;
    public static final int U_AIR_REST = 27;
    public static final int U_AIR_RIGHT_SEAT_HOT = 21;
    public static final int U_AIR_SET_STATE = 57;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_WIND_LEVEL = 14;
    public static final int U_CAR_JUMPINFO1 = 65;
    public static final int U_CAR_LEVEL = 63;
    public static final int U_CAR_SOFT_LEFT = 64;
    public static final int U_CAR_VOL = 66;
    public static final int U_CD_MIN = 62;
    public static final int U_CD_NUM = 59;
    public static final int U_CD_SEC = 61;
    public static final int U_CD_TRACK = 60;
    public static final int U_CELL_VOL = 50;
    public static final int U_CELL_VOL_WARN_FLAG = 53;
    public static final int U_CNT_MAX = 67;
    public static final int U_CUR_SPEED = 48;
    public static final int U_DOOR_BACK = 46;
    public static final int U_DOOR_BEGIN = 41;
    public static final int U_DOOR_END = 47;
    public static final int U_DOOR_ENGINE = 41;
    public static final int U_DOOR_FL = 42;
    public static final int U_DOOR_FR = 43;
    public static final int U_DOOR_RL = 44;
    public static final int U_DOOR_RR = 45;
    public static final int U_ENGINE_SPEED = 49;
    public static final int U_JUMP_CARINFO = 58;
    public static final int U_RADARMUTE = 1;
    public static final int U_REAR_AIR_BEGIN = 29;
    public static final int U_REAR_AIR_END = 40;
    public static final int U_REAR_AUTO_LEFT = 30;
    public static final int U_REAR_AUTO_RIGHT = 29;
    public static final int U_REAR_BLOW_BODY_LEFT = 35;
    public static final int U_REAR_BLOW_BODY_RIGHT = 32;
    public static final int U_REAR_BLOW_FOOT_LEFT = 36;
    public static final int U_REAR_BLOW_FOOT_RIGHT = 33;
    public static final int U_REAR_BLOW_UP_LEFT = 34;
    public static final int U_REAR_BLOW_UP_RIGHT = 31;
    public static final int U_REAR_POWER = 37;
    public static final int U_REAR_TEMP_LEFT = 38;
    public static final int U_REAR_TEMP_RIGHT = 39;
    public static final int U_RES_MIL = 51;
    public static final int U_RES_OIL = 52;
    public static final int U_RES_OIL_WARN_FLAG = 54;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 67; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 41;
        DoorHelper.sUcDoorFl = 42;
        DoorHelper.sUcDoorFr = 43;
        DoorHelper.sUcDoorRl = 44;
        DoorHelper.sUcDoorRr = 45;
        DoorHelper.sUcDoorBack = 46;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 41; i2 < 47; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        AirHelper.getInstance().buildUi(new Air_0439_LZ_Huiteng(LauncherApplication.getInstance()));
        for (int i3 = 2; i3 < 28; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 41; i < 47; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 2; i2 < 28; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 67) {
            switch (updateCode) {
                case 58:
                    if (ints[0] == 1 && !Huiteng_AirRearCtrl.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.huiteng.Huiteng_AirRearCtrl");
                        break;
                    }
                case 65:
                    if (ints[0] == 1 && !HuitengCarSet.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.huiteng.HuitengCarSet");
                        break;
                    }
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
