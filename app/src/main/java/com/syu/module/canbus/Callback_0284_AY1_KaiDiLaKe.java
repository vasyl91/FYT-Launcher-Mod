package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0284_AY1_KaiDiLaKe extends CallbackCanbusBase {
    public static final int U_AIR_BEGIN = 40;
    public static final int U_AIR_END = 51;
    public static final int U_AVERAGE_SPEED = 1;
    public static final int U_CNT_MAX = 58;
    public static final int U_CURRENT_SPEED = 0;
    public static final int U_CUR_OIL_EXPEND = 2;
    public static final int U_DOOR_BACK = 57;
    public static final int U_DOOR_BEGIN = 52;
    public static final int U_DOOR_END = 58;
    public static final int U_DOOR_ENGINE = 52;
    public static final int U_DOOR_FL = 53;
    public static final int U_DOOR_FR = 54;
    public static final int U_DOOR_RL = 55;
    public static final int U_DOOR_RR = 56;
    public static final int U_DRIVING_MILEAGE = 3;
    public static final int U_OPTIMAL_OIL_EXPEND = 4;
    private static int mLevel = 130;
    public final int C_BTN_CMD = 65536;
    public final int C_MCU_UPDATE = 65539;
    public final int C_CD_TOUCH = 65540;
    public final int TOUCH_STATE_DOWN = 1;
    public final int TOUCH_STATE_UP = 2;
    public final int TOUCH_STATE_MOVE = 3;
    public final int KEY_NULL = 0;
    public final int KEY_FAV = 1;
    public final int KEY_HOME = 2;
    public final int KEY_PREV = 3;
    public final int KEY_NEXT = 4;
    public final int KEY_MENU = 5;
    public final int KEY_RADIO = 6;
    public final int KEY_MEDIA = 7;
    public final int KEY_PHONE = 8;
    public final int KEY_BACK = 9;
    public final int KEY_VOL_UP = 10;
    public final int KEY_VOL_DN = 11;
    public final int KEY_TUNE_UP = 12;
    public final int KEY_TUNE_DN = 13;
    public final int KEY_POWER_MUTE = 16;
    public final int KEY_FAV_1 = 17;
    public final int KEY_FAV_2 = 18;
    public final int KEY_FAV_3 = 19;
    public final int KEY_FAV_4 = 20;
    public final int KEY_FAV_5 = 21;
    public final int ACON_FAN_DEC = 129;
    public final int ACON_FAN_INC = 131;
    public final int ACON_ACON_PWR = 130;
    public final int ACON_WD_DEC = 133;
    public final int ACON_WD_INC = 141;
    public final int ACON_AUTO = 134;
    public final int ACON_LTEMP_DEC = 135;
    public final int ACON_LTEMP_INC = 144;
    public final int ACON_RTEMP_DEC = 143;
    public final int ACON_RTEMP_INC = 132;
    public final int ACON_NULL = 136;
    public final int ACON_AC = 137;
    public final int ACON_CYCLE = 138;
    public final int ACON_REAR = 139;
    public final int ACON_FRONT = 140;
    public final int ACON_SYNC = 142;
    public final int ACON_LSEAT = 145;
    public final int ACON_RSEAT = 146;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 58; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 58) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
