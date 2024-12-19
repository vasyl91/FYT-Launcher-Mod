package com.syu.module.canbus;

import android.os.RemoteException;
import android.os.SystemProperties;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.air.Air_Activity_RZC_Prado;
import com.syu.carinfo.rzc.havalh6.Rzc_H6_0439_AirFrontCtrl_HP;
import com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl;
import com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl_HP;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OUDI_Haval_H9;
import com.syu.ui.air.Air_0439_RZC_Haval_H6_Top;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_OUDI_Haval_H9 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 11;
    public static final int U_AIR_AQS = 86;
    public static final int U_AIR_AUTO = 14;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_BODY = 19;
    public static final int U_AIR_BLOW_FOOT = 20;
    public static final int U_AIR_BLOW_UP = 18;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 15;
    public static final int U_AIR_END = 32;
    public static final int U_AIR_FRONT_DEFROST = 16;
    public static final int U_AIR_HEATHOT_LEFT = 30;
    public static final int U_AIR_HEATHOT_RIGHT = 31;
    public static final int U_AIR_LUMBARSEAT_LEFT = 66;
    public static final int U_AIR_LUMBARSEAT_RIGHT = 67;
    public static final int U_AIR_MASSAGESEAT_LEFT = 64;
    public static final int U_AIR_MASSAGESEAT_RIGHT = 65;
    public static final int U_AIR_POWER = 10;
    public static final int U_AIR_REAR_AUTO = 25;
    public static final int U_AIR_REAR_BODY = 26;
    public static final int U_AIR_REAR_DEFROST = 17;
    public static final int U_AIR_REAR_FOOT = 27;
    public static final int U_AIR_REAR_HOTSEAT = 68;
    public static final int U_AIR_REAR_POWER = 24;
    public static final int U_AIR_REAR_TEMP = 29;
    public static final int U_AIR_REAR_WIND_LEVEL = 28;
    public static final int U_AIR_TEMP_LEFT = 22;
    public static final int U_AIR_TEMP_RIGHT = 23;
    public static final int U_AIR_WIND_LEVEL = 21;
    public static final int U_AIR_WINSEAT_LEFT = 62;
    public static final int U_AIR_WINSEAT_RIGHT = 63;
    public static final int U_AIR_ZONE = 13;
    public static final int U_CARCD_PLAYSTATE = 77;
    public static final int U_CARCD_PLAYTIME_M = 78;
    public static final int U_CARCD_PLAYTIME_S = 79;
    public static final int U_CARCD_PLAYTRACK = 74;
    public static final int U_CARCD_RANDOM = 76;
    public static final int U_CARCD_RPT = 75;
    public static final int U_CARCD_STATE = 73;
    public static final int U_CAREQ_BAL = 91;
    public static final int U_CAREQ_BASS = 90;
    public static final int U_CAREQ_CARVOL = 87;
    public static final int U_CAREQ_FAD = 92;
    public static final int U_CAREQ_MID = 89;
    public static final int U_CAREQ_SPEEDVOL = 93;
    public static final int U_CAREQ_SURROUND = 94;
    public static final int U_CAREQ_TERB = 88;
    public static final int U_CARINFO2_ALTITUDE = 59;
    public static final int U_CARINFO2_BEGIN = 50;
    public static final int U_CARINFO2_CONDENSATE_TEMP = 51;
    public static final int U_CARINFO2_END = 60;
    public static final int U_CARINFO2_FRONTWHEEL = 56;
    public static final int U_CARINFO2_INCLINATION = 57;
    public static final int U_CARINFO2_PRESSURE = 54;
    public static final int U_CARINFO2_SLOPE = 55;
    public static final int U_CARINFO2_STEER = 80;
    public static final int U_CARINFO2_TRAILER = 58;
    public static final int U_CARINFO2_TRAOIL_TEMP = 52;
    public static final int U_CARINFO2_VOLTAGE = 53;
    public static final int U_CARINFO_ALLTERRAIN = 46;
    public static final int U_CARINFO_ALS = 71;
    public static final int U_CARINFO_ANTITHEFT_SET = 42;
    public static final int U_CARINFO_AUTOBRAKE = 70;
    public static final int U_CARINFO_BEGIN = 33;
    public static final int U_CARINFO_CARTOP_MODE = 45;
    public static final int U_CARINFO_CETA_SET = 44;
    public static final int U_CARINFO_COLLISIONWARN = 69;
    public static final int U_CARINFO_D31_D03_B02 = 84;
    public static final int U_CARINFO_D31_D03_B74 = 85;
    public static final int U_CARINFO_D31_D04_B0 = 100;
    public static final int U_CARINFO_D31_D04_B1 = 99;
    public static final int U_CARINFO_D31_D04_B2 = 98;
    public static final int U_CARINFO_D31_D04_B54 = 97;
    public static final int U_CARINFO_D31_D04_B6 = 96;
    public static final int U_CARINFO_D31_D04_B7 = 95;
    public static final int U_CARINFO_D31_D05_B20 = 105;
    public static final int U_CARINFO_D31_D05_B4 = 104;
    public static final int U_CARINFO_D31_D05_B5 = 103;
    public static final int U_CARINFO_D31_D05_B6 = 102;
    public static final int U_CARINFO_D31_D05_B7 = 101;
    public static final int U_CARINFO_DOMEDELAY = 34;
    public static final int U_CARINFO_DOORLOCK_SET = 43;
    public static final int U_CARINFO_END = 49;
    public static final int U_CARINFO_FATIGUE_DRIVING = 72;
    public static final int U_CARINFO_FOLLOWHOME = 35;
    public static final int U_CARINFO_FRONTLIGHT_MODE = 39;
    public static final int U_CARINFO_INTELLIGENT_START_STOP = 83;
    public static final int U_CARINFO_JUMPAIR = 81;
    public static final int U_CARINFO_LANGUAGE_SET = 82;
    public static final int U_CARINFO_PARK_SET = 41;
    public static final int U_CARINFO_POWERSAVE = 36;
    public static final int U_CARINFO_RAINFALLSENSOR = 37;
    public static final int U_CARINFO_REARVIEW_AUTO = 38;
    public static final int U_CARINFO_SEAT_MEMORY = 40;
    public static final int U_CNT_MAX = 106;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_JUMP_CARINFO = 61;
    public static final int U_SCREEN_BRIGHT_ADJUST = 47;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 48;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 106; i++) {
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
        if (DataCanbus.DATA[1000] == 7078327 || DataCanbus.DATA[1000] == 7143863) {
            AirHelper.getInstance().buildUi(new Air_0439_RZC_Haval_H6_Top(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 32; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            DataCanbus.NOTIFY_EVENTS[62].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[63].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            return;
        }
        AirHelper.getInstance().buildUi(new Air_0439_OUDI_Haval_H9(LauncherApplication.getInstance()));
        for (int i4 = 10; i4 < 32; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 32; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    private void convAirCtrl(int updateCode, int[] ints) {
        if (updateCode == 61) {
            int value = ints[0];
            if (LauncherApplication.getConfiguration() == 1) {
                int CustomerId = SystemProperties.getInt("ro.build.fytmanufacturer", 0);
                if (CustomerId == 95) {
                    if (value == 1 && !Air_Activity_RZC_Prado.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_RZC_Prado");
                        return;
                    } else {
                        if (Air_Activity_RZC_Prado.mIsFront && Air_Activity_RZC_Prado.mInstance != null) {
                            Air_Activity_RZC_Prado.mInstance.finish();
                            return;
                        }
                        return;
                    }
                }
                if (value == 1 && !Rzc_Oudi_0439_AirFrontCtrl.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl");
                    return;
                } else {
                    if (Rzc_Oudi_0439_AirFrontCtrl.mIsFront && Rzc_Oudi_0439_AirFrontCtrl.mInstance != null) {
                        Rzc_Oudi_0439_AirFrontCtrl.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (value == 1 && !Rzc_Oudi_0439_AirFrontCtrl_HP.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl_HP");
            } else if (Rzc_Oudi_0439_AirFrontCtrl_HP.mIsFront && Rzc_Oudi_0439_AirFrontCtrl_HP.mInstance != null) {
                Rzc_Oudi_0439_AirFrontCtrl_HP.mInstance.finish();
            }
        }
    }

    private void convH6AirCtrl(int updateCode, int[] ints) {
        if (updateCode == 81) {
            int value = ints[0];
            if (LauncherApplication.getConfiguration() == 1) {
                int CustomerId = SystemProperties.getInt("ro.build.fytmanufacturer", 0);
                if (CustomerId == 95) {
                    if (value == 1 && !Air_Activity_RZC_Prado.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_RZC_Prado");
                        return;
                    } else {
                        if (Air_Activity_RZC_Prado.mIsFront && Air_Activity_RZC_Prado.mInstance != null) {
                            Air_Activity_RZC_Prado.mInstance.finish();
                            return;
                        }
                        return;
                    }
                }
                if (value == 1 && !Rzc_Oudi_0439_AirFrontCtrl.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl");
                    return;
                } else {
                    if (Rzc_Oudi_0439_AirFrontCtrl.mIsFront && Rzc_Oudi_0439_AirFrontCtrl.mInstance != null) {
                        Rzc_Oudi_0439_AirFrontCtrl.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (value == 1 && !Rzc_H6_0439_AirFrontCtrl_HP.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.havalh6.Rzc_H6_0439_AirFrontCtrl_HP");
            } else if (Rzc_H6_0439_AirFrontCtrl_HP.mIsFront && Rzc_H6_0439_AirFrontCtrl_HP.mInstance != null) {
                Rzc_H6_0439_AirFrontCtrl_HP.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 106) {
            switch (updateCode) {
                case 61:
                    convAirCtrl(updateCode, ints);
                    break;
                case 81:
                    convH6AirCtrl(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
