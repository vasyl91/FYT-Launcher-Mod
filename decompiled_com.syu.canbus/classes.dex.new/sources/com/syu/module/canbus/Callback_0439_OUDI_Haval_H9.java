package com.syu.module.canbus;

import android.os.RemoteException;
import android.os.SystemProperties;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.carinfo.air.Air_Activity_RZC_Prado;
import com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl;
import com.syu.carinfo.rzc.havalh6.Rzc_Oudi_0439_AirFrontCtrl_HP;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0439_OUDI_Haval_H9;
import com.syu.ui.air.Air_0439_RZC_Haval_H6_Top;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0439_OUDI_Haval_H9 extends CallbackCanbusBase {
    public static final int U_CARCD_PLAYSTATE = 137;
    public static final int U_CARCD_PLAYTIME_M = 138;
    public static final int U_CARCD_PLAYTIME_S = 139;
    public static final int U_CARCD_PLAYTRACK = 134;
    public static final int U_CARCD_RANDOM = 136;
    public static final int U_CARCD_RPT = 135;
    public static final int U_CARCD_STATE = 133;
    public static final int U_CAREQ_BAL = 146;
    public static final int U_CAREQ_BASS = 145;
    public static final int U_CAREQ_CARVOL = 142;
    public static final int U_CAREQ_FAD = 147;
    public static final int U_CAREQ_MID = 144;
    public static final int U_CAREQ_SPEEDVOL = 148;
    public static final int U_CAREQ_SURROUND = 149;
    public static final int U_CAREQ_TERB = 143;
    public static final int U_CARINFO2_ALTITUDE = 126;
    public static final int U_CARINFO2_BEGIN = 117;
    public static final int U_CARINFO2_CONDENSATE_TEMP = 118;
    public static final int U_CARINFO2_END = 127;
    public static final int U_CARINFO2_FRONTWHEEL = 123;
    public static final int U_CARINFO2_INCLINATION = 124;
    public static final int U_CARINFO2_PRESSURE = 121;
    public static final int U_CARINFO2_SLOPE = 122;
    public static final int U_CARINFO2_STEER = 140;
    public static final int U_CARINFO2_TRAILER = 125;
    public static final int U_CARINFO2_TRAOIL_TEMP = 119;
    public static final int U_CARINFO2_VOLTAGE = 120;
    public static final int U_CARINFO_ALLTERRAIN = 113;
    public static final int U_CARINFO_ALS = 131;
    public static final int U_CARINFO_ANTITHEFT_SET = 109;
    public static final int U_CARINFO_AUTOBRAKE = 130;
    public static final int U_CARINFO_BEGIN = 100;
    public static final int U_CARINFO_CARTOP_MODE = 112;
    public static final int U_CARINFO_CETA_SET = 111;
    public static final int U_CARINFO_COLLISIONWARN = 129;
    public static final int U_CARINFO_D31_D03_B2 = 152;
    public static final int U_CARINFO_D31_D03_B4 = 181;
    public static final int U_CARINFO_D31_D03_B74 = 153;
    public static final int U_CARINFO_D31_D04_B0 = 159;
    public static final int U_CARINFO_D31_D04_B1 = 158;
    public static final int U_CARINFO_D31_D04_B2 = 157;
    public static final int U_CARINFO_D31_D04_B3 = 165;
    public static final int U_CARINFO_D31_D04_B54 = 156;
    public static final int U_CARINFO_D31_D04_B6 = 155;
    public static final int U_CARINFO_D31_D04_B7 = 154;
    public static final int U_CARINFO_D31_D05_B20 = 164;
    public static final int U_CARINFO_D31_D05_B4 = 163;
    public static final int U_CARINFO_D31_D05_B5 = 162;
    public static final int U_CARINFO_D31_D05_B6 = 161;
    public static final int U_CARINFO_D31_D05_B7 = 160;
    public static final int U_CARINFO_D31_D06_B40 = 169;
    public static final int U_CARINFO_D31_D06_B5 = 168;
    public static final int U_CARINFO_D31_D06_B6 = 167;
    public static final int U_CARINFO_D31_D06_B7 = 166;
    public static final int U_CARINFO_D31_D07_B10 = 175;
    public static final int U_CARINFO_D31_D07_B32 = 174;
    public static final int U_CARINFO_D31_D07_B4 = 173;
    public static final int U_CARINFO_D31_D07_B5 = 172;
    public static final int U_CARINFO_D31_D07_B6 = 171;
    public static final int U_CARINFO_D31_D07_B7 = 170;
    public static final int U_CARINFO_D31_D08_B10 = 179;
    public static final int U_CARINFO_D31_D08_B32 = 178;
    public static final int U_CARINFO_D31_D08_B6 = 177;
    public static final int U_CARINFO_D31_D08_B7 = 176;
    public static final int U_CARINFO_D31_D09_B30 = 180;
    public static final int U_CARINFO_DOMEDELAY = 101;
    public static final int U_CARINFO_DOORLOCK_SET = 110;
    public static final int U_CARINFO_END = 116;
    public static final int U_CARINFO_FATIGUE_DRIVING = 132;
    public static final int U_CARINFO_FOLLOWHOME = 102;
    public static final int U_CARINFO_FRONTLIGHT_MODE = 106;
    public static final int U_CARINFO_INTELLIGENT_START_STOP = 151;
    public static final int U_CARINFO_JUMPAIR = 141;
    public static final int U_CARINFO_LANGUAGE_SET = 150;
    public static final int U_CARINFO_PARK_SET = 108;
    public static final int U_CARINFO_POWERSAVE = 103;
    public static final int U_CARINFO_RAINFALLSENSOR = 104;
    public static final int U_CARINFO_REARVIEW_AUTO = 105;
    public static final int U_CARINFO_SEAT_MEMORY = 107;
    public static final int U_CNT_MAX = 182;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 99;
    public static final int U_JUMP_CARINFO = 128;
    public static final int U_SCREEN_BRIGHT_ADJUST = 114;
    public static final int U_TURN_RIGHT_ENTER_CAMERA = 115;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 182; i++) {
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
            AirHelper.getInstance().buildUi(new Air_0439_RZC_Haval_H6_Top(TheApp.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        AirHelper.getInstance().buildUi(new Air_0439_OUDI_Haval_H9(TheApp.getInstance()));
        for (int i4 = 10; i4 < 97; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
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

    private void convAirCtrl(int updateCode, int[] ints) {
        if (updateCode == 128) {
            int value = ints[0];
            if (TheApp.getConfiguration() == 1) {
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
        if (updateCode == 141) {
            int value = ints[0];
            if (TheApp.getConfiguration() == 1) {
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
            if (value == 1 && !Air_Activity_All_NewAdd_HP.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
            } else if (Air_Activity_All_NewAdd_HP.mIsFront && Air_Activity_All_NewAdd_HP.mInstance != null) {
                Air_Activity_All_NewAdd_HP.mInstance.finish();
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 182) {
            switch (updateCode) {
                case 128:
                    convAirCtrl(updateCode, ints);
                    break;
                case 141:
                    convH6AirCtrl(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
