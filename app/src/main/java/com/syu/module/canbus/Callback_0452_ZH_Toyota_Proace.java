package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_ZH_Toyota_Proace extends CallbackCanbusBase {
    public static final int U_CARSET_BEIGIN = 0;
    public static final int U_CARSET_D38_D1_B1 = 3;
    public static final int U_CARSET_D38_D1_B2 = 2;
    public static final int U_CARSET_D38_D1_B7 = 1;
    public static final int U_CARSET_D38_D3_B54 = 5;
    public static final int U_CARSET_D38_D3_B76 = 4;
    public static final int U_CARSET_D38_D4_B30 = 8;
    public static final int U_CARSET_D38_D5_B3 = 7;
    public static final int U_CARSET_D38_D5_B76 = 6;
    public static final int U_CARSET_D38_D6_B2 = 56;
    public static final int U_CARSET_D38_D6_B3 = 55;
    public static final int U_CARSET_D38_D6_B4 = 54;
    public static final int U_CARSET_D38_D6_B65 = 53;
    public static final int U_CARSET_D38_D6_B7 = 52;
    public static final int U_CARSET_METER_TYPE = 9;
    public static final int U_CAR_WARN_D4A_DATA0 = 31;
    public static final int U_CAR_WARN_D4A_DATA1 = 32;
    public static final int U_CAR_WARN_D4A_DATA10 = 41;
    public static final int U_CAR_WARN_D4A_DATA11 = 42;
    public static final int U_CAR_WARN_D4A_DATA12 = 43;
    public static final int U_CAR_WARN_D4A_DATA13 = 44;
    public static final int U_CAR_WARN_D4A_DATA14 = 45;
    public static final int U_CAR_WARN_D4A_DATA15 = 46;
    public static final int U_CAR_WARN_D4A_DATA16 = 47;
    public static final int U_CAR_WARN_D4A_DATA17 = 48;
    public static final int U_CAR_WARN_D4A_DATA18 = 49;
    public static final int U_CAR_WARN_D4A_DATA19 = 50;
    public static final int U_CAR_WARN_D4A_DATA2 = 33;
    public static final int U_CAR_WARN_D4A_DATA20 = 51;
    public static final int U_CAR_WARN_D4A_DATA3 = 34;
    public static final int U_CAR_WARN_D4A_DATA4 = 35;
    public static final int U_CAR_WARN_D4A_DATA5 = 36;
    public static final int U_CAR_WARN_D4A_DATA6 = 37;
    public static final int U_CAR_WARN_D4A_DATA7 = 38;
    public static final int U_CAR_WARN_D4A_DATA8 = 39;
    public static final int U_CAR_WARN_D4A_DATA9 = 40;
    public static final int U_CAR_WARN_DATA0 = 10;
    public static final int U_CAR_WARN_DATA1 = 11;
    public static final int U_CAR_WARN_DATA10 = 20;
    public static final int U_CAR_WARN_DATA11 = 21;
    public static final int U_CAR_WARN_DATA12 = 22;
    public static final int U_CAR_WARN_DATA13 = 23;
    public static final int U_CAR_WARN_DATA14 = 24;
    public static final int U_CAR_WARN_DATA15 = 25;
    public static final int U_CAR_WARN_DATA16 = 26;
    public static final int U_CAR_WARN_DATA17 = 27;
    public static final int U_CAR_WARN_DATA18 = 28;
    public static final int U_CAR_WARN_DATA19 = 29;
    public static final int U_CAR_WARN_DATA2 = 12;
    public static final int U_CAR_WARN_DATA20 = 30;
    public static final int U_CAR_WARN_DATA3 = 13;
    public static final int U_CAR_WARN_DATA4 = 14;
    public static final int U_CAR_WARN_DATA5 = 15;
    public static final int U_CAR_WARN_DATA6 = 16;
    public static final int U_CAR_WARN_DATA7 = 17;
    public static final int U_CAR_WARN_DATA8 = 18;
    public static final int U_CAR_WARN_DATA9 = 19;
    public static final int U_CNT_MAX = 57;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 57; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 57) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
