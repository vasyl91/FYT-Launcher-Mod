package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi;
import com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedSetActi;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;
import com.syu.util.ToolkitMisc;

public class Callback_0281_XP_PSA_ALL extends CallbackCanbusBase {
    public static final int U_174008_PANNEL_LEFT = 171;
    public static final int U_174008_PANNEL_RIGHT = 172;
    public static final int U_CARCD_PLAYTIME_M = 196;
    public static final int U_CARCD_PLAYTIME_S = 197;
    public static final int U_CARCD_TRACK = 194;
    public static final int U_CARCD_TRACK_TOTAL = 195;
    public static final int U_CAREQ_AMPON = 214;
    public static final int U_CAREQ_AUTO_VOL = 213;
    public static final int U_CAREQ_BAL = 209;
    public static final int U_CAREQ_BASS = 207;
    public static final int U_CAREQ_FAD = 210;
    public static final int U_CAREQ_LOUND = 212;
    public static final int U_CAREQ_TREB = 208;
    public static final int U_CAREQ_TYPE = 211;
    public static final int U_CARINF_D38_D4_B30 = 215;
    public static final int U_CARRADIO_BAND = 189;
    public static final int U_CARRADIO_D4_B0 = 193;
    public static final int U_CARRADIO_D4_B1 = 192;
    public static final int U_CARRADIO_D4_B2 = 191;
    public static final int U_CARRADIO_FRQ = 190;
    public static final int U_CARRADIO_TXT = 206;
    public static final int U_CARSET_BLACKLIGHT = 173;
    public static final int U_CARSET_CARDOOR_LOCK_STATE = 174;
    public static final int U_CARSET_CENTER_LOCK = 175;
    public static final int U_CARSET_DRIVER_ASSIST = 166;
    public static final int U_CARSET_OIL_UNIT = 179;
    public static final int U_CARSET_ONLY_UNLOOK_BACKDOOR = 168;
    public static final int U_CARSET_PILAO_DETECT = 169;
    public static final int U_CARSET_PULL_CONTROL_SYS = 170;
    public static final int U_CARSET_THEME_COLOR = 176;
    public static final int U_CARSET_TURNLIGHT_BYDRIVER = 167;
    public static final int U_CAR_D28_D0_B70 = 216;
    public static final int U_CAR_D28_D1_B70 = 217;
    public static final int U_CAR_DISCBOX_NUM = 198;
    public static final int U_CAR_DISCBOX_PLAYTIME_M = 201;
    public static final int U_CAR_DISCBOX_PLAYTIME_S = 202;
    public static final int U_CAR_DISCBOX_RANDOM = 205;
    public static final int U_CAR_DISCBOX_REPEAT = 203;
    public static final int U_CAR_DISCBOX_SCAN = 204;
    public static final int U_CAR_DISCBOX_TRACK = 199;
    public static final int U_CAR_DISCBOX_TRACK_TOTAL = 200;
    public static final int U_CAR_SOURCE_ID = 188;
    public static final int U_CNT_MAX = 218;
    public static final int U_ECOMIC_MODE = 178;
    public static final int U_LOCK_UNLOCK_LAMP_FLASH = 177;
    public static final int U_MEM_SPEED1 = 183;
    public static final int U_MEM_SPEED2 = 184;
    public static final int U_MEM_SPEED3 = 185;
    public static final int U_MEM_SPEED4 = 186;
    public static final int U_MEM_SPEED5 = 187;
    public static final int U_MEM_SPEED_ONOFF = 180;
    public static final int U_MEM_SPEED_SELECT = 181;
    public static final int U_MEM_SPEED_SHOW = 182;
    public static String RadioText = "";
    public static int mSum = -1;
    public static int mCurrPage = -1;
    public static String mCarId = null;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 218; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        //AirHelper.getInstance().buildUi(new Air_0118_XP1_BiaoZhi2008(LauncherApplication.getInstance()));
        DoorHelper.getInstance().buildUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
    }

    @Override
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

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 218) {
            if (updateCode == 165) {
                if (strs != null && strs.length >= 1 && !ToolkitMisc.strEqual(mCarId, strs[0])) {
                    mCarId = strs[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    return;
                }
                return;
            }
            if (updateCode == 154) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[154];
                if (value == 1 && !BZ408OilMileIndexActi.mIsFront) {
                    //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.BZ408OilMileIndexActi");
                    return;
                }
                return;
            }
            if (updateCode == 182) {
                if (ints != null) {
                    if (ints[0] == 1 && !PsaC4L_MemSpeedSetActi.mIsFront) {
                        //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.biaozhi408.PsaC4L_MemSpeedSetActi");
                        return;
                    } else {
                        if (ints[0] == 0 && PsaC4L_MemSpeedSetActi.mIsFront && PsaC4L_MemSpeedSetActi.mInstance != null) {
                            PsaC4L_MemSpeedSetActi.mInstance.finish();
                            return;
                        }
                        return;
                    }
                }
                return;
            }
            if (updateCode == 206) {
                if (strs != null && strs.length > 0) {
                    RadioText = strs[0];
                } else {
                    RadioText = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
                return;
            }
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
