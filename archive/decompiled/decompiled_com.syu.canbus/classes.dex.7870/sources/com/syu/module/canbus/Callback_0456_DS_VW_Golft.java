package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.canbus7870.apk\dexFile\classes.dex */
public class Callback_0456_DS_VW_Golft extends CallbackCanbusBase {
    public static final int U_CARINF_AUX1_ONOFF = 40;
    public static final int U_CARINF_AUX2_ONOFF = 41;
    public static final int U_CARINF_AUX3_ONOFF = 42;
    public static final int U_CARINF_AUX4_ONOFF = 43;
    public static final int U_CARINF_D32_D0_D1 = 1;
    public static final int U_CARINF_D32_D6_D7 = 2;
    public static final int U_CARINF_D33_D0_D1 = 3;
    public static final int U_CARINF_D33_D2_D3 = 4;
    public static final int U_CARINF_D33_D4_D5 = 5;
    public static final int U_CARINF_D33_D6_D7 = 6;
    public static final int U_CARINF_D34_D0_D1 = 7;
    public static final int U_CARINF_D34_D2_D3 = 8;
    public static final int U_CARINF_D34_D4_D5 = 9;
    public static final int U_CARINF_D34_D6_D7 = 10;
    public static final int U_CARINF_D35_D0_D1 = 11;
    public static final int U_CARINF_D35_D2_D3 = 12;
    public static final int U_CARINF_D35_D4_D5 = 13;
    public static final int U_CARINF_D35_D6_D7 = 14;
    public static final int U_CARINF_D37_T01_D1_B10 = 15;
    public static final int U_CARINF_D37_T02_D1_D4 = 16;
    public static final int U_CARINF_D37_T02_D5_D8 = 17;
    public static final int U_CARINF_D38_D0_B30 = 18;
    public static final int U_CARINF_D38_D1_B70 = 19;
    public static final int U_CARINF_D38_D2_B30 = 20;
    public static final int U_CARINF_D39_D0_B70 = 21;
    public static final int U_CARINF_D39_D1_B70 = 22;
    public static final int U_CARINF_D39_D2_B70 = 23;
    public static final int U_CARINF_D39_D3_B70 = 24;
    public static final int U_CARINF_D39_D4_B70 = 25;
    public static final int U_CARINF_D39_D5_B70 = 26;
    public static final int U_CARINF_D3A_D0_B70 = 27;
    public static final int U_CARINF_D3A_T1_D2_B70 = 28;
    public static final int U_CARINF_D3A_T1_D3_B70 = 29;
    public static final int U_CARINF_D3A_T2_D2_B70 = 30;
    public static final int U_CARINF_D3A_T2_D3_B70 = 31;
    public static final int U_CARINF_D3A_T3_D2_B70 = 32;
    public static final int U_CARINF_D3A_T3_D3_B70 = 33;
    public static final int U_CARINF_D3A_T4_D2_B70 = 34;
    public static final int U_CARINF_D3A_T4_D3_B70 = 35;
    public static final int U_CARINF_D3A_T5_D2_B70 = 36;
    public static final int U_CARINF_D3A_T5_D3_B70 = 37;
    public static final int U_CARINF_D3A_T6_D2_B70 = 38;
    public static final int U_CARINF_D3A_T6_D3_B70 = 39;
    public static final int U_CARINF_OUTPUT1_SEL = 46;
    public static final int U_CARINF_OUTPUT2_SEL = 47;
    public static final int U_CARINF_OUTPUT3_SEL = 48;
    public static final int U_CARINF_OUTPUT4_SEL = 49;
    public static final int U_CARINF_OUTPUT5_SEL = 50;
    public static final int U_CARINF_OUTPUT6_SEL = 51;
    public static final int U_CARINF_RGB_COLOR_TYPE = 44;
    public static final int U_CARINF_RGB_FLOW = 45;
    public static final int U_CNT_MAX = 52;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 52; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 <= 5; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 52) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
