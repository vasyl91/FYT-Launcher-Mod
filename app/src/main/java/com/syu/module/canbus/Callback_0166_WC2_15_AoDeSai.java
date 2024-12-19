package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0166_WC2_15_AoDeSai extends CallbackCanbusBase {
    public static final int U_AIR_AC = 30;
    public static final int U_AIR_AUTO = 26;
    public static final int U_AIR_BEGIN = 25;
    public static final int U_AIR_BLOW_BODY_LEFT = 32;
    public static final int U_AIR_BLOW_FOOT_LEFT = 33;
    public static final int U_AIR_BLOW_UP_LEFT = 34;
    public static final int U_AIR_CYCLE = 27;
    public static final int U_AIR_DUAL = 36;
    public static final int U_AIR_END = 40;
    public static final int U_AIR_FRONT_DEFROST = 28;
    public static final int U_AIR_POWER = 38;
    public static final int U_AIR_REAR_DEFROST = 29;
    public static final int U_AIR_SYNC = 39;
    public static final int U_AIR_TEMP_LEFT = 31;
    public static final int U_AIR_TEMP_RIGHT = 37;
    public static final int U_AIR_WIND_LEVEL_LEFT = 35;
    public static final int U_CARSHOW_DATA1 = 47;
    public static final int U_CARSHOW_DATA10 = 56;
    public static final int U_CARSHOW_DATA11 = 57;
    public static final int U_CARSHOW_DATA12 = 58;
    public static final int U_CARSHOW_DATA13 = 59;
    public static final int U_CARSHOW_DATA14 = 60;
    public static final int U_CARSHOW_DATA15 = 61;
    public static final int U_CARSHOW_DATA16 = 62;
    public static final int U_CARSHOW_DATA17 = 63;
    public static final int U_CARSHOW_DATA17_2 = 76;
    public static final int U_CARSHOW_DATA18 = 64;
    public static final int U_CARSHOW_DATA19 = 65;
    public static final int U_CARSHOW_DATA2 = 48;
    public static final int U_CARSHOW_DATA20 = 66;
    public static final int U_CARSHOW_DATA21 = 67;
    public static final int U_CARSHOW_DATA22 = 68;
    public static final int U_CARSHOW_DATA23 = 69;
    public static final int U_CARSHOW_DATA24 = 70;
    public static final int U_CARSHOW_DATA25 = 71;
    public static final int U_CARSHOW_DATA26 = 72;
    public static final int U_CARSHOW_DATA27 = 73;
    public static final int U_CARSHOW_DATA28 = 74;
    public static final int U_CARSHOW_DATA29 = 75;
    public static final int U_CARSHOW_DATA3 = 49;
    public static final int U_CARSHOW_DATA4 = 50;
    public static final int U_CARSHOW_DATA5 = 51;
    public static final int U_CARSHOW_DATA6 = 52;
    public static final int U_CARSHOW_DATA7 = 53;
    public static final int U_CARSHOW_DATA8 = 54;
    public static final int U_CARSHOW_DATA9 = 55;
    public static final int U_CNT_MAX = 77;
    public static final int U_DOOR_BACK = 45;
    public static final int U_DOOR_BEGIN = 40;
    public static final int U_DOOR_END = 46;
    public static final int U_DOOR_ENGINE = 40;
    public static final int U_DOOR_FL = 41;
    public static final int U_DOOR_FR = 42;
    public static final int U_DOOR_RL = 43;
    public static final int U_DOOR_RR = 44;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 77; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 40;
        DoorHelper.sUcDoorFl = 41;
        DoorHelper.sUcDoorFr = 42;
        DoorHelper.sUcDoorRl = 43;
        DoorHelper.sUcDoorRr = 44;
        DoorHelper.sUcDoorBack = 45;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 40; i2 < 46; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 40; i < 46; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    private void updateWarningNum(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 4) {
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 77) {
            switch (updateCode) {
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                    updateWarningNum(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
