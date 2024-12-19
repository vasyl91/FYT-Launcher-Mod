package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_DJ_08Prado_H extends CallbackCanbusBase {
    public static final int CMD_AIR_CTRL = 0;
    public static final int CMD_JUMP_EQ = 2;
    public static final int CMD_SET_CTRL = 1;
    public static final int CMD_SET_CTRL2 = 3;
    public static final int CMD_SET_CTRL3 = 4;
    public static final int CMD_SET_CTRL4 = 5;
    public static final int U_AIR_AC = 2;
    public static final int U_AIR_AUTO = 4;
    public static final int U_AIR_BEGIN = 0;
    public static final int U_AIR_BLOW_BODY_LEFT = 12;
    public static final int U_AIR_BLOW_FOOT_LEFT = 13;
    public static final int U_AIR_BLOW_MODE = 18;
    public static final int U_AIR_BLOW_UP_LEFT = 11;
    public static final int U_AIR_CYCLE = 3;
    public static final int U_AIR_DUAL = 5;
    public static final int U_AIR_END = 19;
    public static final int U_AIR_FRONT_DEFROST = 8;
    public static final int U_AIR_FRONT_MAX = 6;
    public static final int U_AIR_POWER = 1;
    public static final int U_AIR_REAR = 7;
    public static final int U_AIR_REAR_CTRL = 10;
    public static final int U_AIR_REAR_DEFROST = 9;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 16;
    public static final int U_AIR_TYPE = 17;
    public static final int U_AIR_WIND_LEVEL = 14;
    public static final int U_CAR_CD1_STATE = 39;
    public static final int U_CAR_CD2_STATE = 40;
    public static final int U_CAR_CD3_STATE = 41;
    public static final int U_CAR_CD4_STATE = 42;
    public static final int U_CAR_CD5_STATE = 43;
    public static final int U_CAR_CD6_STATE = 44;
    public static final int U_CAR_CD_ASL = 38;
    public static final int U_CAR_CD_DISC_RANDOM = 35;
    public static final int U_CAR_CD_DISC_REPEAT = 34;
    public static final int U_CAR_CD_MIN = 36;
    public static final int U_CAR_CD_NUM = 29;
    public static final int U_CAR_CD_RANDOM = 33;
    public static final int U_CAR_CD_REPEAT = 32;
    public static final int U_CAR_CD_SCAN = 45;
    public static final int U_CAR_CD_SEC = 37;
    public static final int U_CAR_CD_TOTALTRACK = 31;
    public static final int U_CAR_CD_TRACK = 30;
    public static final int U_CAR_RADIO_BAND = 20;
    public static final int U_CAR_RADIO_FREQ = 21;
    public static final int U_CAR_RADIO_FREQ1 = 22;
    public static final int U_CAR_RADIO_FREQ2 = 23;
    public static final int U_CAR_RADIO_FREQ3 = 24;
    public static final int U_CAR_RADIO_FREQ4 = 25;
    public static final int U_CAR_RADIO_FREQ5 = 26;
    public static final int U_CAR_RADIO_FREQ6 = 27;
    public static final int U_CAR_RADIO_STATE = 28;
    public static final int U_CAR_SET_INFO1 = 47;
    public static final int U_CAR_SET_INFO2 = 48;
    public static final int U_CAR_VOL = 46;
    public static final int U_CNT_MAX = 49;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 49; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 49) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
