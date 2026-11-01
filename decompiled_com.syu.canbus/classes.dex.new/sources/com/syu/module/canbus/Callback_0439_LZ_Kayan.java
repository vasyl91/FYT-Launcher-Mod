package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.TheApp;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_LZ_Kayan;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0439_LZ_Kayan extends CallbackCanbusBase {
    public static final int U_AIR_SEAT_AUTO_LEFT = 100;
    public static final int U_AIR_SEAT_AUTO_RIGHT = 101;
    public static final int U_AIR_SEAT_COLD_AUTO_LEFT = 98;
    public static final int U_AIR_SEAT_COLD_AUTO_RIGHT = 99;
    public static final int U_AIR_SEAT_COLD_LEFT_BOTTOM = 107;
    public static final int U_AIR_SEAT_COLD_LEFT_WAIST = 106;
    public static final int U_AIR_SEAT_COLD_RIGHT_BOTTOM = 109;
    public static final int U_AIR_SEAT_COLD_RIGHT_WAIST = 108;
    public static final int U_AIR_SEAT_HOT_LEFT_BOTTOM = 103;
    public static final int U_AIR_SEAT_HOT_LEFT_WAIST = 102;
    public static final int U_AIR_SEAT_HOT_RIGHT_BOTTOM = 105;
    public static final int U_AIR_SEAT_HOT_RIGHT_WAIST = 104;
    public static final int U_CARAUX_CTRL_TYPE = 130;
    public static final int U_CARINF_D1F_D0_B30 = 131;
    public static final int U_CARINF_D1F_D0_B6 = 132;
    public static final int U_CARINF_D1F_D0_B7 = 133;
    public static final int U_CARINF_D1F_D1_B0 = 134;
    public static final int U_CARINF_D1F_D1_B1 = 135;
    public static final int U_CARINF_D1F_D1_B2 = 136;
    public static final int U_CARINF_D1F_D1_B3 = 137;
    public static final int U_CARINF_D1F_D1_B4 = 138;
    public static final int U_CARINF_D1F_D1_B5 = 139;
    public static final int U_CARINF_D1F_D2_B70 = 140;
    public static final int U_CARINF_D1F_D3_D4 = 141;
    public static final int U_CARINF_D34_T0_D1_D3 = 152;
    public static final int U_CARINF_D34_T0_D4_D6 = 153;
    public static final int U_CARINF_D34_T0_D7_D8 = 154;
    public static final int U_CARINF_D34_T0_D9_D10 = 155;
    public static final int U_CARINF_D34_T1_D1_D3 = 156;
    public static final int U_CARINF_D34_T1_D4_D6 = 157;
    public static final int U_CARINF_D34_T1_D7_D8 = 158;
    public static final int U_CARINF_D34_T1_D9_D10 = 159;
    public static final int U_CARINF_D35_D2_D3 = 150;
    public static final int U_CARINF_D36_D0_B70 = 142;
    public static final int U_CARINF_D36_D1_B70 = 143;
    public static final int U_CARINF_D36_D2_B70 = 144;
    public static final int U_CARINF_D36_D3_B70 = 145;
    public static final int U_CARINF_D36_D4_B70 = 146;
    public static final int U_CARINF_D36_D5_B70 = 147;
    public static final int U_CARINF_D36_D6_B70 = 148;
    public static final int U_CARINF_D36_D7_B70 = 149;
    public static final int U_CAR_AUDI_TYPE = 128;
    public static final int U_CAR_LVDS_MODE = 129;
    public static final int U_CAR_SET_AIR_AUTOCIRC = 123;
    public static final int U_CAR_SET_AIR_PANEL = 122;
    public static final int U_CAR_SET_AIR_STYLE = 124;
    public static final int U_CAR_SET_BEGIN = 112;
    public static final int U_CAR_SET_COMFORT_ENTRY = 121;
    public static final int U_CAR_SET_DAYTIME_LIGHT = 115;
    public static final int U_CAR_SET_DOOR_LOCK = 120;
    public static final int U_CAR_SET_DOOR_UNLOCK = 119;
    public static final int U_CAR_SET_END = 126;
    public static final int U_CAR_SET_EXTERIORLIGHT_OFFTIME = 125;
    public static final int U_CAR_SET_INTERLIGHT = 114;
    public static final int U_CAR_SET_INTERLIGHT_OFFTIME = 113;
    public static final int U_CAR_SET_REAR_WIPER = 117;
    public static final int U_CAR_SET_REVERSING_OPTIONS = 118;
    public static final int U_CAR_SET_WIPER_SENSOR = 116;
    public static final int U_CAR_STEER_TYPE = 127;
    public static final int U_CNT_MAX = 160;
    public static final int U_ENGINE_SPEED = 110;
    public static final int U_TOTAL_MILEAGE = 111;
    public static int modevalue = -1;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 160; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0439_LZ_Kayan(TheApp.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 160) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
