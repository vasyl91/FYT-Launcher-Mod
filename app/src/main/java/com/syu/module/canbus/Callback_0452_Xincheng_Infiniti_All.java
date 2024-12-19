package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.xincheng.infiniti.Xincheng_Nissan_Tule_AirControlActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0452_Xincheng_Infeinidi_Q70;
import com.syu.ui.air.Air_0452_Xincheng_Nissan_Tule;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0452_Xincheng_Infiniti_All extends CallbackCanbusBase {
    public static final int U_AIR_AC = 8;
    public static final int U_AIR_ACMAX = 21;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_AUTO_REAR = 25;
    public static final int U_AIR_BEGIN = 6;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_BODY_REAR = 26;
    public static final int U_AIR_BLOW_BODY_RIGHT = 113;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_FOOT_REAR = 27;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 114;
    public static final int U_AIR_BLOW_TOP = 110;
    public static final int U_AIR_BLOW_UP_LEFT = 15;
    public static final int U_AIR_BLOW_UP_RIGHT = 112;
    public static final int U_AIR_CYCLE = 9;
    public static final int U_AIR_CYCLE_AUTO = 14;
    public static final int U_AIR_DUAL = 12;
    public static final int U_AIR_END = 30;
    public static final int U_AIR_FOREST = 111;
    public static final int U_AIR_FRONT_HOT = 22;
    public static final int U_AIR_MAX_FRONT = 13;
    public static final int U_AIR_POWER = 7;
    public static final int U_AIR_POWER_REAR = 24;
    public static final int U_AIR_RAER = 10;
    public static final int U_AIR_SEAT_BLOW_LEFT = 87;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 88;
    public static final int U_AIR_SEAT_HOT_LEFT = 85;
    public static final int U_AIR_SEAT_HOT_RIGHT = 86;
    public static final int U_AIR_TEMP_LEFT = 19;
    public static final int U_AIR_TEMP_REAR = 29;
    public static final int U_AIR_TEMP_RIGHT = 20;
    public static final int U_AIR_TEMP_UNIT = 23;
    public static final int U_AIR_WIND_LEVEL_LEFT = 18;
    public static final int U_AIR_WIND_LEVEL_REAR = 28;
    public static final int U_CAREQ_BAL = 78;
    public static final int U_CAREQ_BASS = 76;
    public static final int U_CAREQ_BEGIN = 74;
    public static final int U_CAREQ_BOSE = 81;
    public static final int U_CAREQ_DRIVER = 83;
    public static final int U_CAREQ_FAD = 79;
    public static final int U_CAREQ_SPEED_VOL = 80;
    public static final int U_CAREQ_SURROUND = 82;
    public static final int U_CAREQ_TREBL = 77;
    public static final int U_CAREQ_VOL = 75;
    public static final int U_CARINFO_BEGIN = 37;
    public static final int U_CARINFO_D71_D1D0 = 38;
    public static final int U_CARINFO_D71_D3D2 = 39;
    public static final int U_CARINFO_D71_D6D5D4 = 40;
    public static final int U_CARINFO_D72_D1D0 = 41;
    public static final int U_CARINFO_D72_D2 = 42;
    public static final int U_CARSET_D74_D0_B0 = 48;
    public static final int U_CARSET_D74_D0_B1 = 47;
    public static final int U_CARSET_D74_D0_B2 = 46;
    public static final int U_CARSET_D74_D0_B3 = 45;
    public static final int U_CARSET_D74_D0_B4 = 44;
    public static final int U_CARSET_D74_D0_B5 = 43;
    public static final int U_CARSET_D74_D0_B6 = 89;
    public static final int U_CARSET_D74_D1_B02 = 49;
    public static final int U_CARSET_D74_D1_B35 = 50;
    public static final int U_CARSET_D74_D1_B67 = 51;
    public static final int U_CARSET_D74_D2_B01 = 52;
    public static final int U_CARSET_D74_D2_B23 = 53;
    public static final int U_CARSET_D74_D2_B45 = 54;
    public static final int U_CARSET_D74_D2_B6 = 55;
    public static final int U_CARSET_D74_D3_B02 = 56;
    public static final int U_CARSET_D74_D3_B3 = 90;
    public static final int U_CARSET_D74_D3_B4 = 91;
    public static final int U_CARSET_D74_D3_B75 = 92;
    public static final int U_CARSET_D74_D4_B1 = 97;
    public static final int U_CARSET_D74_D4_B2 = 96;
    public static final int U_CARSET_D74_D4_B3 = 95;
    public static final int U_CARSET_D74_D4_B4 = 94;
    public static final int U_CARSET_D74_D4_B75 = 93;
    public static final int U_CARSET_D75_D0_B0 = 62;
    public static final int U_CARSET_D75_D0_B1 = 61;
    public static final int U_CARSET_D75_D0_B2 = 60;
    public static final int U_CARSET_D75_D0_B3 = 59;
    public static final int U_CARSET_D75_D0_B4 = 58;
    public static final int U_CARSET_D75_D0_B65 = 57;
    public static final int U_CARSET_D75_D1_B07 = 63;
    public static final int U_CARSET_D75_D2_B07 = 64;
    public static final int U_CARSET_D75_D3_B07 = 65;
    public static final int U_CARSET_D75_D4_B0 = 72;
    public static final int U_CARSET_D75_D4_B1 = 71;
    public static final int U_CARSET_D75_D4_B2 = 70;
    public static final int U_CARSET_D75_D4_B3 = 69;
    public static final int U_CARSET_D75_D4_B4 = 68;
    public static final int U_CARSET_D75_D4_B5 = 67;
    public static final int U_CARSET_D75_D4_B6 = 66;
    public static final int U_CARSET_D75_D5_B07 = 73;
    public static final int U_CARSET_D7A_D0_B20 = 105;
    public static final int U_CARSET_D7A_D0_B4 = 104;
    public static final int U_CARSET_D7A_D0_B75 = 103;
    public static final int U_CARSET_D7A_D1_B0 = 109;
    public static final int U_CARSET_D7A_D1_B1 = 108;
    public static final int U_CARSET_D7A_D1_B42 = 107;
    public static final int U_CARSET_D7A_D1_B75 = 106;
    public static final int U_CARSET_END = 74;
    public static final int U_CAR_BELT_STATE = 101;
    public static final int U_CAR_CUR_SPEED = 98;
    public static final int U_CAR_EN_SPEED = 99;
    public static final int U_CAR_HANDBRAKE_STATE = 100;
    public static final int U_CAR_JUMP_AIR = 102;
    public static final int U_CAR_TIRE_BEGIN = 30;
    public static final int U_CAR_TIRE_END = 37;
    public static final int U_CAR_TIRE_SYS_VALUE = 36;
    public static final int U_CAR_TIRE_VALUE_FL = 31;
    public static final int U_CAR_TIRE_VALUE_FR = 32;
    public static final int U_CAR_TIRE_VALUE_RL = 33;
    public static final int U_CAR_TIRE_VALUE_RR = 34;
    public static final int U_CAR_TIRE_WARN_VALUE = 35;
    public static final int U_CNT_MAX = 115;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 84;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 115; i++) {
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
        if (2032068 == DataCanbus.DATA[1000]) {
            AirHelper.getInstance().buildUi(new Air_0452_Xincheng_Infeinidi_Q70(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[110].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[111].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[112].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[113].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[114].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            for (int i3 = 6; i3 < 30; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        AirHelper.getInstance().buildUi(new Air_0452_Xincheng_Nissan_Tule(LauncherApplication.getInstance()));
        for (int i4 = 6; i4 < 30; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 6; i2 < 30; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 115) {
            if (updateCode == 102) {
                if (5046724 == DataCanbus.DATA[1000] || 5112260 == DataCanbus.DATA[1000]) {
                    int value = ints[0];
                    if (value == 1) {
                        if (!Xincheng_Nissan_Tule_AirControlActi.mIsFront) {
                            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xincheng.infiniti.Xincheng_Nissan_Tule_AirControlActi");
                            return;
                        }
                        return;
                    } else {
                        if (value == 0 && Xincheng_Nissan_Tule_AirControlActi.mIsFront && Xincheng_Nissan_Tule_AirControlActi.mInstance != null) {
                            Xincheng_Nissan_Tule_AirControlActi.mInstance.finish();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
