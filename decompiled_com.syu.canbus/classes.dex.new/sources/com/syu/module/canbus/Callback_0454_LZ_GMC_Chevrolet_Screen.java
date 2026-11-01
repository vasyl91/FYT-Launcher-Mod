package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0454_LZ_GMC_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0454_LZ_GMC_Chevrolet_Screen extends CallbackCanbusBase {
    public static final int U_CARINF_D35_D10_B70 = 106;
    public static final int U_CARINF_D35_D11_B6 = 108;
    public static final int U_CARINF_D35_D11_B7 = 107;
    public static final int U_CARINF_D35_D2_D3 = 104;
    public static final int U_CARINF_D35_D7_D9 = 105;
    public static final int U_CARSET_SCREE_TYPE = 109;
    public static final int U_CAR_AIR_TYPE = 111;
    public static final int U_CAR_ANDROID_UI_VOL = 99;
    public static final int U_CAR_AUDI_TYPE = 110;
    public static final int U_CAR_LVDS_MODE = 101;
    public static final int U_CAR_SCREEN_H = 103;
    public static final int U_CAR_SCREEN_W = 102;
    public static final int U_CAR_UI_VOL = 98;
    public static final int U_CAR_VOICE_ANDROID = 100;
    public static final int U_CNT_MAX = 112;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 112; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0454_LZ_GMC_All(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        switch (DataCanbus.DATA[1000]) {
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_Screen /* 9437639 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_Screen /* 9503175 */:
            case FinalCanbus.CAR_455_LZ_YL_GMC_Sierra_19_RScreen /* 9568711 */:
            case FinalCanbus.CAR_455_LZ_YL_Chevrolet_Silverado_19_RScreen /* 9634247 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_4Screen /* 15729095 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_4Screen /* 15794631 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Hand_8Screen /* 15860167 */:
            case FinalCanbus.CAR_455_LZ_YL_Silverado_14_Auto_8Screen /* 15925703 */:
                DataCanbus.NOTIFY_EVENTS[27].removeNotify(AirHelper.SHOW_AND_REFRESH);
                DataCanbus.NOTIFY_EVENTS[28].removeNotify(AirHelper.SHOW_AND_REFRESH);
                DataCanbus.NOTIFY_EVENTS[21].removeNotify(AirHelper.SHOW_AND_REFRESH);
                break;
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 112) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
