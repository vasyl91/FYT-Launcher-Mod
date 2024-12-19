package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_Luz_Nissac_GTR extends CallbackCanbusBase {
    public static final int U_AIR_AC = 9;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 7;
    public static final int U_AIR_BLOW_BODY = 14;
    public static final int U_AIR_BLOW_FOOT = 15;
    public static final int U_AIR_BLOW_MODE = 16;
    public static final int U_AIR_BLOW_UP = 13;
    public static final int U_AIR_CYCLE = 10;
    public static final int U_AIR_DUAL = 12;
    public static final int U_AIR_END = 23;
    public static final int U_AIR_FRONT_DEFROST = 19;
    public static final int U_AIR_POWER = 8;
    public static final int U_AIR_REAR_DEFROST = 20;
    public static final int U_AIR_TEMP_LEFT = 17;
    public static final int U_AIR_TEMP_RIGHT = 18;
    public static final int U_AIR_TEMP_UNIT = 21;
    public static final int U_AIR_WIND_LEVEL = 22;
    public static final int U_CARINFO_BEGIN = 24;
    public static final int U_CARINFO_D34_DATA0 = 25;
    public static final int U_CARINFO_D34_DATA1 = 26;
    public static final int U_CARINFO_D34_DATA10 = 33;
    public static final int U_CARINFO_D34_DATA2 = 27;
    public static final int U_CARINFO_D34_DATA3 = 28;
    public static final int U_CARINFO_D34_DATA45 = 29;
    public static final int U_CARINFO_D34_DATA6 = 30;
    public static final int U_CARINFO_D34_DATA78 = 31;
    public static final int U_CARINFO_D34_DATA9 = 32;
    public static final int U_CARINFO_D35_DATA0 = 34;
    public static final int U_CARINFO_D35_DATA1 = 35;
    public static final int U_CARINFO_D35_DATA10 = 40;
    public static final int U_CARINFO_D35_DATA23 = 36;
    public static final int U_CARINFO_D35_DATA45 = 37;
    public static final int U_CARINFO_D35_DATA6 = 38;
    public static final int U_CARINFO_D35_DATA789 = 39;
    public static final int U_CARINFO_D36_TIRE_FL = 42;
    public static final int U_CARINFO_D36_TIRE_FR = 41;
    public static final int U_CARINFO_D36_TIRE_RL = 44;
    public static final int U_CARINFO_D36_TIRE_RR = 43;
    public static final int U_CARINFO_D36_TIRE_STATE_FL = 46;
    public static final int U_CARINFO_D36_TIRE_STATE_FR = 45;
    public static final int U_CARINFO_D36_TIRE_STATE_RL = 48;
    public static final int U_CARINFO_D36_TIRE_STATE_RR = 47;
    public static final int U_CARINFO_END = 49;
    public static final int U_CARSET_BEGIN = 50;
    public static final int U_CARSET_D38_DATA0 = 51;
    public static final int U_CARSET_D38_DATA1 = 52;
    public static final int U_CARSET_D38_DATA10 = 61;
    public static final int U_CARSET_D38_DATA11_B6 = 63;
    public static final int U_CARSET_D38_DATA11_B7 = 62;
    public static final int U_CARSET_D38_DATA2 = 53;
    public static final int U_CARSET_D38_DATA3 = 54;
    public static final int U_CARSET_D38_DATA4 = 55;
    public static final int U_CARSET_D38_DATA5 = 56;
    public static final int U_CARSET_D38_DATA6 = 57;
    public static final int U_CARSET_D38_DATA7 = 58;
    public static final int U_CARSET_D38_DATA8 = 59;
    public static final int U_CARSET_D38_DATA9 = 60;
    public static final int U_CARSET_END = 64;
    public static final int U_CNT_MAX = 65;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 65; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 65) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
