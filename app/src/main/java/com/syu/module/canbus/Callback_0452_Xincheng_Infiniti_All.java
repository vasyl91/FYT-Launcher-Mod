package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.xincheng.infiniti.Xincheng_Nissan_Tule_AirControlActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_Xincheng_Infiniti_All extends CallbackCanbusBase {
    public static final int U_CAREQ_BAL = 145;
    public static final int U_CAREQ_BASS = 143;
    public static final int U_CAREQ_BEGIN = 141;
    public static final int U_CAREQ_BOSE = 148;
    public static final int U_CAREQ_DRIVER = 150;
    public static final int U_CAREQ_FAD = 146;
    public static final int U_CAREQ_SPEED_VOL = 147;
    public static final int U_CAREQ_SURROUND = 149;
    public static final int U_CAREQ_TREBL = 144;
    public static final int U_CAREQ_VOL = 142;
    public static final int U_CARINFO_BEGIN = 104;
    public static final int U_CARINFO_D71_D1D0 = 105;
    public static final int U_CARINFO_D71_D3D2 = 106;
    public static final int U_CARINFO_D71_D6D5D4 = 107;
    public static final int U_CARINFO_D72_D1D0 = 108;
    public static final int U_CARINFO_D72_D2 = 109;
    public static final int U_CARSET_D74_D0_B0 = 115;
    public static final int U_CARSET_D74_D0_B1 = 114;
    public static final int U_CARSET_D74_D0_B2 = 113;
    public static final int U_CARSET_D74_D0_B3 = 112;
    public static final int U_CARSET_D74_D0_B4 = 111;
    public static final int U_CARSET_D74_D0_B5 = 110;
    public static final int U_CARSET_D74_D0_B6 = 152;
    public static final int U_CARSET_D74_D1_B02 = 116;
    public static final int U_CARSET_D74_D1_B35 = 117;
    public static final int U_CARSET_D74_D1_B67 = 118;
    public static final int U_CARSET_D74_D2_B01 = 119;
    public static final int U_CARSET_D74_D2_B23 = 120;
    public static final int U_CARSET_D74_D2_B45 = 121;
    public static final int U_CARSET_D74_D2_B6 = 122;
    public static final int U_CARSET_D74_D3_B02 = 123;
    public static final int U_CARSET_D74_D3_B3 = 153;
    public static final int U_CARSET_D74_D3_B4 = 154;
    public static final int U_CARSET_D74_D3_B75 = 155;
    public static final int U_CARSET_D74_D4_B1 = 160;
    public static final int U_CARSET_D74_D4_B2 = 159;
    public static final int U_CARSET_D74_D4_B3 = 158;
    public static final int U_CARSET_D74_D4_B4 = 157;
    public static final int U_CARSET_D74_D4_B75 = 156;
    public static final int U_CARSET_D75_D0_B0 = 129;
    public static final int U_CARSET_D75_D0_B1 = 128;
    public static final int U_CARSET_D75_D0_B2 = 127;
    public static final int U_CARSET_D75_D0_B3 = 126;
    public static final int U_CARSET_D75_D0_B4 = 125;
    public static final int U_CARSET_D75_D0_B65 = 124;
    public static final int U_CARSET_D75_D1_B07 = 130;
    public static final int U_CARSET_D75_D2_B07 = 131;
    public static final int U_CARSET_D75_D3_B07 = 132;
    public static final int U_CARSET_D75_D4_B0 = 139;
    public static final int U_CARSET_D75_D4_B1 = 138;
    public static final int U_CARSET_D75_D4_B2 = 137;
    public static final int U_CARSET_D75_D4_B3 = 136;
    public static final int U_CARSET_D75_D4_B4 = 135;
    public static final int U_CARSET_D75_D4_B5 = 134;
    public static final int U_CARSET_D75_D4_B6 = 133;
    public static final int U_CARSET_D75_D5_B07 = 140;
    public static final int U_CARSET_D7A_D0_B20 = 168;
    public static final int U_CARSET_D7A_D0_B4 = 167;
    public static final int U_CARSET_D7A_D0_B75 = 166;
    public static final int U_CARSET_D7A_D1_B0 = 172;
    public static final int U_CARSET_D7A_D1_B1 = 171;
    public static final int U_CARSET_D7A_D1_B42 = 170;
    public static final int U_CARSET_D7A_D1_B75 = 169;
    public static final int U_CARSET_END = 141;
    public static final int U_CAR_BELT_STATE = 164;
    public static final int U_CAR_CUR_SPEED = 161;
    public static final int U_CAR_EN_SPEED = 162;
    public static final int U_CAR_HANDBRAKE_STATE = 163;
    public static final int U_CAR_JUMP_AIR = 165;
    public static final int U_CAR_TIRE_BEGIN = 97;
    public static final int U_CAR_TIRE_END = 104;
    public static final int U_CAR_TIRE_SYS_VALUE = 103;
    public static final int U_CAR_TIRE_VALUE_FL = 98;
    public static final int U_CAR_TIRE_VALUE_FR = 99;
    public static final int U_CAR_TIRE_VALUE_RL = 100;
    public static final int U_CAR_TIRE_VALUE_RR = 101;
    public static final int U_CAR_TIRE_WARN_VALUE = 102;
    public static final int U_CNT_MAX = 173;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 151;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 173; i++) {
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
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        if (2032068 == DataCanbus.DATA[1000]) {
            //AirHelper.getInstance().buildUi(new Air_0452_Xincheng_Infeinidi_Q70(LauncherApplication.getInstance()));
        } else {
            //AirHelper.getInstance().buildUi(new Air_0452_Xincheng_Nissan_Tule(LauncherApplication.getInstance()));
        }
    }

    @Override
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 173) {
            if (updateCode == 165) {
                if (5046724 == DataCanbus.DATA[1000] || 5112260 == DataCanbus.DATA[1000]) {
                    int value = ints[0];
                    if (value == 1) {
                        if (!Xincheng_Nissan_Tule_AirControlActi.mIsFront) {
                            //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xincheng.infiniti.Xincheng_Nissan_Tule_AirControlActi");
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
