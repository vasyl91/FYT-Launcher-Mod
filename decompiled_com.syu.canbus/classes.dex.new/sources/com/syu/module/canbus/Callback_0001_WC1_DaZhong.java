package com.syu.module.canbus;

import android.os.RemoteException;
import android.os.SystemProperties;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.dasauto.AirControlPQDZSJ;
import com.syu.carinfo.dasauto.VwDashBoard_DZSJ;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0001_WC1_DaZhong;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0001_WC1_DaZhong extends CallbackCanbusBase {
    public static final int U_BATTERY_VOLTAGE = 104;
    public static final int U_BRAKE_LIGHTS = 114;
    public static final int U_CLEAN_FLUIT_WARN = 102;
    public static final int U_CNT_MAX = 126;
    public static final int U_CUR_OIL_EXPEND = 98;
    public static final int U_CUR_SPEED = 109;
    public static final int U_DASHBOARD_SHOW = 120;
    public static final int U_DRIVE_MILE = 105;
    public static final int U_ENGINE_SPEED = 113;
    public static final int U_HANDBRAK_STATE = 122;
    public static final int U_LIFE_BELT_WARN = 101;
    public static final int U_LIGHT_B_VALUE = 125;
    public static final int U_LIGHT_G_VALUE = 124;
    public static final int U_LIGHT_R_VALUE = 123;
    public static final int U_LIGHT_STATE = 121;
    public static final int U_LOW_BATTERY_WARN = 100;
    public static final int U_LOW_OIL_WARN = 99;
    public static final int U_MACHINE_OIL_WARN = 111;
    public static final int U_MISC_BEGIN = 98;
    public static final int U_MISC_END = 119;
    public static final int U_OUT_TEMP = 118;
    public static final int U_PARK_CARPORT = 107;
    public static final int U_PARK_ROAD = 106;
    public static final int U_PRECISION_SPEED = 112;
    public static final int U_RADAR_MUTE = 108;
    public static final int U_RESIDUAL_OIL = 103;
    public static final int U_REVEIVER_LIGHTS = 115;
    public static final int U_TURN_LIGHT_LIGHTS = 117;
    public static final int U_TURN_RIGHT_LIGHTS = 116;
    public static final int U_WATER_TEMP = 110;
    public static boolean jump = false;
    Runnable mDismissAirView = new Runnable() { // from class: com.syu.module.canbus.Callback_0001_WC1_DaZhong.1
        @Override // java.lang.Runnable
        public void run() {
            if (AirControlPQDZSJ.mIsFront && AirControlPQDZSJ.mInstance != null) {
                AirControlPQDZSJ.mInstance.finish();
                Callback_0001_WC1_DaZhong.jump = false;
            }
        }
    };
    Runnable mDismissDasBoardView = new Runnable() { // from class: com.syu.module.canbus.Callback_0001_WC1_DaZhong.2
        @Override // java.lang.Runnable
        public void run() {
            if (VwDashBoard_DZSJ.mIsFront && VwDashBoard_DZSJ.mInstance != null) {
                VwDashBoard_DZSJ.mInstance.finish();
            }
        }
    };

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 126; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        if (DataCanbus.DATA[1000] != 131073 && DataCanbus.DATA[1000] != 196609) {
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
        }
        int ID = SystemProperties.getInt("ro.build.fytmanufacturer", -1);
        if (ID != 15) {
            AirHelper.getInstance().buildUi(new Air_0001_WC1_DaZhong(TheApp.getInstance()));
        }
        if (DataCanbus.DATA[1000] != 131073 && ID != 15) {
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
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
        if (updateCode >= 0) {
            switch (updateCode) {
                case 120:
                    break;
                default:
                    if (DataCanbus.DATA[1000] == 131073) {
                        if (updateCode >= 10 && updateCode < 97) {
                            showCotrolAir(updateCode, ints);
                            break;
                        } else if (updateCode >= 0 && updateCode < 126) {
                            HandlerCanbus.update(updateCode, ints);
                            break;
                        }
                    } else if (updateCode >= 0 && updateCode < 126) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                    break;
            }
        }
    }

    private void showCotrolAir(int updateCode, int[] ints) {
        if (AirHelper.sAirWindowEnable == 1) {
            HandlerCanbus.update(updateCode, ints);
            if (!AirControlPQDZSJ.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dasauto.AirControlPQDZSJ");
                jump = true;
            }
            if (jump) {
                HandlerUI.getInstance().removeCallbacks(this.mDismissAirView);
                HandlerUI.getInstance().postDelayed(this.mDismissAirView, 5000L);
            }
        }
    }

    private void showDashBoard(int updateCode, int[] ints) {
        if (updateCode == 120) {
            if (DataCanbus.DATA[1000] == 131073 || DataCanbus.DATA[1000] == 196609) {
                HandlerCanbus.update(updateCode, ints);
                int value = ints[0];
                if (value == 1 && !VwDashBoard_DZSJ.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.dasauto.VwDashBoard_DZSJ");
                    HandlerUI.getInstance().removeCallbacks(this.mDismissDasBoardView);
                } else if (VwDashBoard_DZSJ.mIsFront && value == 0) {
                    HandlerUI.getInstance().removeCallbacks(this.mDismissDasBoardView);
                    HandlerUI.getInstance().postDelayed(this.mDismissDasBoardView, 3000L);
                }
            }
        }
    }
}
