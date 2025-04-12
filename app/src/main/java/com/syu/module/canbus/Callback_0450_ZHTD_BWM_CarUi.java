package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar;
import com.syu.carinfo.zhtd.bmw.ZhtdAudiNewCarinfoAct;
import com.syu.carinfo.zhtd.bmw.ZhtdBenzNewCarinfoAct;
import com.syu.carinfo.zhtd.bmw.ZhtdBmwNewCarinfoAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.benzair.Air_Benz;
import com.syu.ui.benzair.Air_BenzHelper;
import com.syu.ui.benzair.Air_Benz_S;
import com.syu.ui.benzair.Air_Volvo;
import com.syu.ui.benzair.SHow_Benz;
import com.syu.ui.benzair.Show_BenzHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0450_ZHTD_BWM_CarUi extends CallbackCanbusBase {
    public static final int U_CAROIL_ALARM_FLAG = 163;
    public static final int U_CAR_AUDIO_STATE = 110;
    public static final int U_CAR_AUX_TYPE = 124;
    public static final int U_CAR_BACKCAR_MUTE = 133;
    public static final int U_CAR_BACKCAR_TYPE = 119;
    public static final int U_CAR_BACK_JUMP = 125;
    public static final int U_CAR_BELT_ALARM_FLAG = 164;
    public static final int U_CAR_BELT_STATE = 102;
    public static final int U_CAR_BT_TIME_M = 159;
    public static final int U_CAR_BT_TIME_S = 160;
    public static final int U_CAR_BZ_AUX_ACTIVATION = 126;
    public static final int U_CAR_CDC_DISC1 = 146;
    public static final int U_CAR_CDC_DISC2 = 147;
    public static final int U_CAR_CDC_DISC3 = 148;
    public static final int U_CAR_CDC_DISC4 = 149;
    public static final int U_CAR_CDC_DISC5 = 150;
    public static final int U_CAR_CDC_DISC6 = 151;
    public static final int U_CAR_CDC_NUM = 152;
    public static final int U_CAR_CDC_RANDOM = 145;
    public static final int U_CAR_CDC_REP = 144;
    public static final int U_CAR_CDC_TIME_M = 141;
    public static final int U_CAR_CDC_TIME_S = 142;
    public static final int U_CAR_CDC_TRACK = 143;
    public static final int U_CAR_CUR_SPEED = 105;
    public static final int U_CAR_EN_SPEED = 107;
    public static final int U_CAR_FOOTBRAKE_STATE = 103;
    public static final int U_CAR_GEAR = 131;
    public static final int U_CAR_GUIJI_ONOFF = 120;
    public static final int U_CAR_HANDBRAKE_STATE = 104;
    public static final int U_CAR_JUMP_PAGE = 132;
    public static final int U_CAR_LEFT_RIGHT_AUTO_360 = 122;
    public static final int U_CAR_LIGHT_FAR = 99;
    public static final int U_CAR_LIGHT_LEFT = 100;
    public static final int U_CAR_LIGHT_NEAR = 98;
    public static final int U_CAR_LIGHT_RIGHT = 101;
    public static final int U_CAR_MANUAL_ONOFF = 129;
    public static final int U_CAR_MEDIA_LOCATION = 127;
    public static final int U_CAR_MENU_SHOW = 161;
    public static final int U_CAR_MENU_STR = 162;
    public static final int U_CAR_MIRROR_ONOFF = 121;
    public static final int U_CAR_NAVI = 128;
    public static final int U_CAR_OIL_REMAINED = 106;
    public static final int U_CAR_OUTSIDE_TEMP = 123;
    public static final int U_CAR_RADIO_CHL = 139;
    public static final int U_CAR_RADIO_FRQ = 138;
    public static final int U_CAR_RADIO_ST = 140;
    public static final int U_CAR_SCREEN_TYPE = 112;
    public static final int U_CAR_SHOW_AUX_WAIT = 130;
    public static final int U_CAR_STATE = 136;
    public static final int U_CAR_TOTAL_MILE = 108;
    public static final int U_CAR_UI_STATE = 109;
    public static final int U_CAR_USB_NUM = 158;
    public static final int U_CAR_USB_RANDOM = 157;
    public static final int U_CAR_USB_REP = 156;
    public static final int U_CAR_USB_TIME_M = 153;
    public static final int U_CAR_USB_TIME_S = 154;
    public static final int U_CAR_USB_TRACK = 155;
    public static final int U_CAR_VOICE_STATE = 111;
    public static final int U_CAR_VOL = 137;
    public static final int U_CAR_VOL_BASS = 113;
    public static final int U_CAR_VOL_BT = 118;
    public static final int U_CAR_VOL_MIDDLE = 114;
    public static final int U_CAR_VOL_NAVI = 117;
    public static final int U_CAR_VOL_SYS = 116;
    public static final int U_CAR_VOL_TREB = 115;
    public static final int U_CNT_MAX = 165;
    public static final int U_PANNEL_BUTTON_TYPE = 135;
    public static final int U_STEER_BUTTON_TYPE = 134;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 165; i++) {
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
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
            }
            Show_BenzHelper.getInstance().buildUi(new SHow_Benz(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[130].addNotify(Show_BenzHelper.SHOW_AND_REFRESH_BENZ, 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 524738) {
            Air_BenzHelper.getInstance().buildUi(new Air_Volvo(LauncherApplication.getInstance()));
            for (int i4 = 10; i4 < 97; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
            }
            Show_BenzHelper.getInstance().buildUi(new SHow_Benz(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[130].addNotify(Show_BenzHelper.SHOW_AND_REFRESH_BENZ, 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 197058) {
            Air_BenzHelper.getInstance().buildUi(new Air_Benz_S(LauncherApplication.getInstance()));
            for (int i5 = 10; i5 < 97; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(Air_BenzHelper.SHOW_AND_REFRESH, 0);
            }
            Show_BenzHelper.getInstance().buildUi(new SHow_Benz(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[130].addNotify(Show_BenzHelper.SHOW_AND_REFRESH_BENZ, 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 262594 || DataCanbus.DATA[1000] == 590274) {
            //AirHelper.getInstance().buildUi(new Air_0450_zhtd_lexus_all(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[11].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[12].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[13].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[18].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[19].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[20].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[21].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[27].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[28].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            return;
        }
        if (DataCanbus.DATA[1000] == 393666) {
            //AirHelper.getInstance().buildUi(new Air_0450_cm_bmw_all(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[11].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[12].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[21].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[27].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[28].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(Air_BenzHelper.SHOW_AND_REFRESH);
        }
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 165) {
            switch (updateCode) {
                case 125:
                    showDashBoard(updateCode, ints);
                    break;
                case 132:
                    showCarComputer(updateCode, ints);
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
