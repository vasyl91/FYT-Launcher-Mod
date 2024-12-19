package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.rzc.ruifengs3.JhRuiFengS7TireAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_OUDI_Jianghuai_Ruifeng_all;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_Oudi_Jianghuai_Ruifeng extends CallbackCanbusBase {
    public static final int U_AIR_AC = 7;
    public static final int U_AIR_AUTO = 9;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 13;
    public static final int U_AIR_BLOW_FOOT_LEFT = 14;
    public static final int U_AIR_BLOW_UP_LEFT = 12;
    public static final int U_AIR_CYCLE = 8;
    public static final int U_AIR_DUAL = 10;
    public static final int U_AIR_END = 22;
    public static final int U_AIR_HEAT = 51;
    public static final int U_AIR_REAR_DEFROST = 11;
    public static final int U_AIR_SEAT_BLOW_LEFT = 20;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 21;
    public static final int U_AIR_SEAT_HOT_LEFT = 18;
    public static final int U_AIR_SEAT_HOT_RIGHT = 19;
    public static final int U_AIR_TEMP_LEFT = 16;
    public static final int U_AIR_TEMP_RIGHT = 17;
    public static final int U_AIR_WIND_LEVEL_LEFT = 15;
    public static final int U_CAR_AUTOLOCK = 38;
    public static final int U_CAR_D40_D010_B70 = 45;
    public static final int U_CAR_D40_D011_B70 = 46;
    public static final int U_CAR_D40_D012_B70 = 47;
    public static final int U_CAR_D40_D013_B70 = 48;
    public static final int U_CAR_D40_D014_B70 = 49;
    public static final int U_CAR_D40_D015_B70 = 50;
    public static final int U_CAR_D40_D016_B3 = 56;
    public static final int U_CAR_D40_D016_B4 = 55;
    public static final int U_CAR_D40_D016_B5 = 54;
    public static final int U_CAR_D40_D016_B6 = 53;
    public static final int U_CAR_D40_D016_B7 = 52;
    public static final int U_CAR_D40_D017_B70 = 57;
    public static final int U_CAR_D40_D06_B70 = 41;
    public static final int U_CAR_D40_D07_B70 = 42;
    public static final int U_CAR_D40_D08_B70 = 43;
    public static final int U_CAR_D40_D09_B70 = 44;
    public static final int U_CAR_D42_D0_B70 = 58;
    public static final int U_CAR_D42_D10_B70 = 67;
    public static final int U_CAR_D42_D11_B70 = 68;
    public static final int U_CAR_D42_D12_D13 = 69;
    public static final int U_CAR_D42_D14_B4 = 73;
    public static final int U_CAR_D42_D14_B5 = 72;
    public static final int U_CAR_D42_D14_B6 = 71;
    public static final int U_CAR_D42_D14_B7 = 70;
    public static final int U_CAR_D42_D1_D2 = 59;
    public static final int U_CAR_D42_D3_B70 = 60;
    public static final int U_CAR_D42_D4_B70 = 61;
    public static final int U_CAR_D42_D5_B70 = 62;
    public static final int U_CAR_D42_D6_B70 = 63;
    public static final int U_CAR_D42_D7_B70 = 64;
    public static final int U_CAR_D42_D8_B70 = 65;
    public static final int U_CAR_D42_D9_B70 = 66;
    public static final int U_CAR_INTERLIGHT = 37;
    public static final int U_CAR_LOCALIGHT = 40;
    public static final int U_CAR_OUTLIGHT = 36;
    public static final int U_CAR_PROMPTLL = 39;
    public static final int U_CAR_TISHIVOL = 35;
    public static final int U_CNT_MAX = 74;
    public static final int U_PRESSURE_FL = 23;
    public static final int U_PRESSURE_FR = 24;
    public static final int U_PRESSURE_RL = 25;
    public static final int U_PRESSURE_RR = 26;
    public static final int U_TEMP_FL = 27;
    public static final int U_TEMP_FR = 28;
    public static final int U_TEMP_RL = 29;
    public static final int U_TEMP_RR = 30;
    public static final int U_WARNING_FL = 31;
    public static final int U_WARNING_FR = 32;
    public static final int U_WARNING_RL = 33;
    public static final int U_WARNING_RR = 34;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 74; i++) {
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
        AirHelper.getInstance().buildUi(new Air_0452_OUDI_Jianghuai_Ruifeng_all(LauncherApplication.getInstance()));
        for (int i3 = 6; i3 < 22; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 6; i2 < 22; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 74) {
            HandlerCanbus.update(updateCode, ints);
            if ((updateCode == 34 || updateCode == 33 || updateCode == 32 || updateCode == 31) && !JhRuiFengS7TireAct.bNotShowingWarning) {
                if ((DataCanbus.DATA[34] != 0 || DataCanbus.DATA[33] != 0 || DataCanbus.DATA[32] != 0 || DataCanbus.DATA[31] != 0) && !JhRuiFengS7TireAct.bFront) {
                    try {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.ruifengs3.JhRuiFengS7TireAct");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
