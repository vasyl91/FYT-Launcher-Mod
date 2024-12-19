package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar;
import com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct;
import com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct;
import com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0450_cm_bmw_all;
import com.syu.ui.air.Air_0450_zhtd_lexus_all;
import com.syu.ui.benzair.Air_Benz;
import com.syu.ui.benzair.Air_BenzHelper;
import com.syu.ui.benzair.Air_Benz_S;
import com.syu.ui.benzair.Air_Volvo;
import com.syu.ui.benzair.SHow_Benz;
import com.syu.ui.benzair.Show_BenzHelper;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0450_ZHTD_BWM_CarUi extends CallbackCanbusBase {
    public static final int U_AIR_AC = 37;
    public static final int U_AIR_AUTO = 36;
    public static final int U_AIR_BEGIN = 22;
    public static final int U_AIR_BLOW_AUTO_LEFT = 28;
    public static final int U_AIR_BLOW_AUTO_RIGHT = 32;
    public static final int U_AIR_BLOW_BODY_LEFT = 26;
    public static final int U_AIR_BLOW_BODY_RIGHT = 30;
    public static final int U_AIR_BLOW_FOOT_LEFT = 27;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 31;
    public static final int U_AIR_BLOW_MODE_LEFT = 41;
    public static final int U_AIR_BLOW_MODE_RIGHT = 42;
    public static final int U_AIR_BLOW_UP_LEFT = 25;
    public static final int U_AIR_BLOW_UP_RIGHT = 29;
    public static final int U_AIR_CYCLE = 35;
    public static final int U_AIR_END = 43;
    public static final int U_AIR_FRONT_DEFROST = 38;
    public static final int U_AIR_REAR_DEFROST = 39;
    public static final int U_AIR_REFRESH = 40;
    public static final int U_AIR_SEAT_BLOW_LEFT = 69;
    public static final int U_AIR_SEAT_BLOW_RIGHT = 70;
    public static final int U_AIR_SEAT_HEAT_LEFT = 67;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 68;
    public static final int U_AIR_TEMP_LEFT = 23;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 33;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 34;
    public static final int U_CAROIL_ALARM_FLAG = 98;
    public static final int U_CAR_AUDIO_STATE = 19;
    public static final int U_CAR_AUX_TYPE = 55;
    public static final int U_CAR_BACKCAR_MUTE = 64;
    public static final int U_CAR_BACKCAR_TYPE = 50;
    public static final int U_CAR_BACK_JUMP = 56;
    public static final int U_CAR_BELT_ALARM_FLAG = 99;
    public static final int U_CAR_BELT_STATE = 11;
    public static final int U_CAR_BZ_AUX_ACTIVATION = 57;
    public static final int U_CAR_CUR_SPEED = 14;
    public static final int U_CAR_EN_SPEED = 16;
    public static final int U_CAR_FOOTBRAKE_STATE = 12;
    public static final int U_CAR_GEAR = 62;
    public static final int U_CAR_GUIJI_ONOFF = 51;
    public static final int U_CAR_HANDBRAKE_STATE = 13;
    public static final int U_CAR_JUMP_PAGE = 63;
    public static final int U_CAR_LEFT_RIGHT_AUTO_360 = 53;
    public static final int U_CAR_LIGHT_FAR = 8;
    public static final int U_CAR_LIGHT_LEFT = 9;
    public static final int U_CAR_LIGHT_NEAR = 7;
    public static final int U_CAR_LIGHT_RIGHT = 10;
    public static final int U_CAR_MANUAL_ONOFF = 60;
    public static final int U_CAR_MEDIA_LOCATION = 58;
    public static final int U_CAR_MIRROR_ONOFF = 52;
    public static final int U_CAR_NAVI = 59;
    public static final int U_CAR_OIL_REMAINED = 15;
    public static final int U_CAR_OUTSIDE_TEMP = 54;
    public static final int U_CAR_SCREEN_TYPE = 21;
    public static final int U_CAR_SHOW_AUX_WAIT = 61;
    public static final int U_CAR_TOTAL_MILE = 17;
    public static final int U_CAR_UI_STATE = 18;
    public static final int U_CAR_VOICE_STATE = 20;
    public static final int U_CAR_VOL_BASS = 44;
    public static final int U_CAR_VOL_BT = 49;
    public static final int U_CAR_VOL_MIDDLE = 45;
    public static final int U_CAR_VOL_NAVI = 48;
    public static final int U_CAR_VOL_SYS = 47;
    public static final int U_CAR_VOL_TREB = 46;
    public static final int U_CNT_MAX = 100;
    public static final int U_PANNEL_BUTTON_TYPE = 66;
    public static final int U_STEER_BUTTON_TYPE = 65;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 100; i++) {
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
        if (DataCanbus.DATA[1000] == 65986 || DataCanbus.DATA[1000] == 655810) {
            Air_BenzHelper.getInstance().buildUi(new Air_Benz(LauncherApplication.getInstance()));
            for (int i3 = 22; i3 < 43; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
            }
            Show_BenzHelper.getInstance().buildUi(new SHow_Benz(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[61].addNotify(Show_BenzHelper.SHOW_AND_REFRESH_BENZ, 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 524738) {
            Air_BenzHelper.getInstance().buildUi(new Air_Volvo(LauncherApplication.getInstance()));
            for (int i4 = 22; i4 < 43; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
            }
            DataCanbus.NOTIFY_EVENTS[67].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[68].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
            Show_BenzHelper.getInstance().buildUi(new SHow_Benz(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[61].addNotify(Show_BenzHelper.SHOW_AND_REFRESH_BENZ, 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 197058) {
            Air_BenzHelper.getInstance().buildUi(new Air_Benz_S(LauncherApplication.getInstance()));
            for (int i5 = 22; i5 < 43; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
            }
            Show_BenzHelper.getInstance().buildUi(new SHow_Benz(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[61].addNotify(Show_BenzHelper.SHOW_AND_REFRESH_BENZ, 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274) {
            AirHelper.getInstance().buildUi(new Air_0450_zhtd_lexus_all(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[37].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[35].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[36].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[25].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[26].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[27].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[33].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[23].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[24].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 393666) {
            AirHelper.getInstance().buildUi(new Air_0450_cm_bmw_all(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[37].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[35].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[33].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[23].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[24].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 22; i2 < 43; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(Air_BenzHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[67].removeNotify(Air_BenzHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[68].removeNotify(Air_BenzHelper.SHOW_AND_REFRESH);
        Air_BenzHelper.getInstance().destroyUi();
    }

    private void showDashBoard(int updateCode, int[] ints) {
        int value = ints[0];
        if (value == 1 && !KswAudiQ5Backcar.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar");
        } else if (KswAudiQ5Backcar.mInstance != null) {
            KswAudiQ5Backcar.mInstance.finish();
        }
    }

    private void showCarComputer(int updateCode, int[] ints) {
        int value = ints[0];
        switch (DataCanbus.DATA[1000]) {
            case 450:
            case FinalCanbus.CAR_450_ZHTD_Lexus /* 262594 */:
            case FinalCanbus.CAR_450_ZHTD_LandRover /* 328130 */:
            case FinalCanbus.CAR_450_CM_ZHTD_BMWM /* 393666 */:
            case FinalCanbus.CAR_450_ZHTD_Lexus_L /* 590274 */:
            case FinalCanbus.CAR_450_ZHTD_Porsche /* 655810 */:
                if (value == 1 && !ZhtdBmwNewCarinfoAct.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct");
                    break;
                }
            case FinalCanbus.CAR_450_ZHTD_Benz /* 65986 */:
            case FinalCanbus.CAR_450_ZHTD_Benz_S /* 197058 */:
            case FinalCanbus.CAR_450_ZHTD_Volvo /* 524738 */:
                if (value == 1 && !ZhtdBenzNewCarinfoAct.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct");
                    break;
                }
            case FinalCanbus.CAR_450_ZHTD_Audi /* 131522 */:
                if (value == 1 && !ZhtdAudiNewCarinfoAct.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct");
                    break;
                }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 100) {
            switch (updateCode) {
                case 56:
                    showDashBoard(updateCode, ints);
                    break;
                case 63:
                    showCarComputer(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
