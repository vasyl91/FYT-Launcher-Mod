package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0317_WC2_ATS extends CallbackCanbusBase {
    public static final int U_AIR_AC = 5;
    public static final int U_AIR_AMB = 20;
    public static final int U_AIR_AQS = 21;
    public static final int U_AIR_AUTO = 1;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_AUTO_LEFT = 15;
    public static final int U_AIR_BLOW_BODY_LEFT = 7;
    public static final int U_AIR_BLOW_FOOT_LEFT = 8;
    public static final int U_AIR_BLOW_UP_LEFT = 9;
    public static final int U_AIR_CYCLE = 2;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_FRONT_DEFROST = 3;
    public static final int U_AIR_FRONT_WIND_MODE = 19;
    public static final int U_AIR_POWER = 14;
    public static final int U_AIR_REAR_DEFROST = 4;
    public static final int U_AIR_SEAT_BLOW_LEFT = 18;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 17;
    public static final int U_AIR_SEAT_HEAT_BLOW_LEFT = 46;
    public static final int U_AIR_SEAT_HEAT_BLOW_RIGHT = 45;
    public static final int U_AIR_SEAT_HEAT_LEFT = 11;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 12;
    public static final int U_AIR_SYNC = 16;
    public static final int U_AIR_TEMP_LEFT = 6;
    public static final int U_AIR_TEMP_RIGHT = 13;
    public static final int U_AIR_WIND_LEVEL_LEFT = 10;
    public static final int U_CNT_MAX = 47;
    public static final int U_CUR_SPEED = 39;
    public static final int U_DOOR_BACK = 37;
    public static final int U_DOOR_BEGIN = 32;
    public static final int U_DOOR_END = 38;
    public static final int U_DOOR_ENGINE = 32;
    public static final int U_DOOR_FL = 33;
    public static final int U_DOOR_FR = 34;
    public static final int U_DOOR_RL = 35;
    public static final int U_DOOR_RR = 36;
    public static final int U_ENGINE_SPEED = 40;
    public final int C_BTN_CMD = 65536;
    public final int C_TOUCH_CMD = 65537;
    public final int C_AIR_CMD = FinalCanbus.CAR_XP1_DaZhong_H;
    public final int TOUCH_STATE_NULL = -1;
    public final int TOUCH_STATE_UP = 0;
    public final int TOUCH_STATE_DOWN = 1;
    public final int KEY_POWER = 1;
    public final int KEY_PREV = 2;
    public final int KEY_NEXT = 3;
    public final int KEY_TONE = 5;
    public final int KEY_BACK = 6;
    public final int KEY_NUM1 = 10;
    public final int KEY_NUM2 = 11;
    public final int KEY_NUM3 = 12;
    public final int KEY_NUM4 = 13;
    public final int KEY_NUM5 = 14;
    public final int KEY_LEFT = 25;
    public final int KEY_RIGHT = 26;
    public final int KEY_MEDIA = 36;
    public final int KEY_HOME = 43;
    public final int KEY_MENU = 47;
    public final int KEY_RADIO = 50;
    public final int CMD_AIR_POEWR = 1;
    public final int CMD_AIR_AC = 2;
    public final int CMD_AIR_AUTO = 4;
    public final int CMD_AIR_REARDEFROST = 6;
    public final int CMD_AIR_CYCLE = 7;
    public final int CMD_AIR_BLOWUP = 8;
    public final int CMD_AIR_BODY = 9;
    public final int CMD_AIR_FOOT = 10;
    public final int CMD_AIR_WHEEL = 11;
    public final int CMD_AIR_TEMP_LEFT = 12;
    public final int CMD_AIR_TEMP_RIGHT = 13;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 47; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 32;
        DoorHelper.sUcDoorFl = 33;
        DoorHelper.sUcDoorFr = 34;
        DoorHelper.sUcDoorRl = 35;
        DoorHelper.sUcDoorRr = 36;
        DoorHelper.sUcDoorBack = 37;
        DoorHelper.getInstance().buildUi();
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 32; i < 38; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 47) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
