package com.syu.module.canbus;

import android.os.RemoteException;
import android.os.SystemProperties;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.dasauto.AirControlPQDZSJ;
import com.syu.carinfo.dasauto.VwDashBoard_DZSJ;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0001_WC1_DaZhong;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0001_WC1_DaZhong extends CallbackCanbusBase {
    public static final int U_AIR_AC = 27;
    public static final int U_AIR_AC_MAX = 28;
    public static final int U_AIR_AUTO = 22;
    public static final int U_AIR_AUTO2 = 41;
    public static final int U_AIR_BEGIN = 21;
    public static final int U_AIR_BLOW_BODY_LEFT = 34;
    public static final int U_AIR_BLOW_BODY_RIGHT = 38;
    public static final int U_AIR_BLOW_FOOT_LEFT = 35;
    public static final int U_AIR_BLOW_FOOT_RIGHT = 39;
    public static final int U_AIR_BLOW_UP_LEFT = 33;
    public static final int U_AIR_BLOW_UP_RIGHT = 37;
    public static final int U_AIR_CYCLE = 23;
    public static final int U_AIR_DUAL = 21;
    public static final int U_AIR_END = 42;
    public static final int U_AIR_FRONT_DEFROST = 25;
    public static final int U_AIR_POWER = 53;
    public static final int U_AIR_REAR_DEFROST = 26;
    public static final int U_AIR_REAR_LOCK = 52;
    public static final int U_AIR_SEAT_HEAT_LEFT = 29;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 30;
    public static final int U_AIR_SHOW = 24;
    public static final int U_AIR_TEMP_LEFT = 31;
    public static final int U_AIR_TEMP_RIGHT = 32;
    public static final int U_AIR_WIND_LEVEL_LEFT = 36;
    public static final int U_AIR_WIND_LEVEL_RIGHT = 40;
    public static final int U_BATTERY_VOLTAGE = 6;
    public static final int U_BRAKE_LIGHTS = 16;
    public static final int U_CLEAN_FLUIT_WARN = 4;
    public static final int U_CNT_MAX = 54;
    public static final int U_CUR_OIL_EXPEND = 0;
    public static final int U_CUR_SPEED = 11;
    public static final int U_DASHBOARD_SHOW = 49;
    public static final int U_DOOR_BACK = 47;
    public static final int U_DOOR_BEGIN = 42;
    public static final int U_DOOR_END = 48;
    public static final int U_DOOR_ENGINE = 42;
    public static final int U_DOOR_FL = 43;
    public static final int U_DOOR_FR = 44;
    public static final int U_DOOR_RL = 45;
    public static final int U_DOOR_RR = 46;
    public static final int U_DRIVE_MILE = 7;
    public static final int U_ENGINE_SPEED = 15;
    public static final int U_HANDBRAK_STATE = 51;
    public static final int U_LIFE_BELT_WARN = 3;
    public static final int U_LIGHT_STATE = 50;
    public static final int U_LOW_BATTERY_WARN = 2;
    public static final int U_LOW_OIL_WARN = 1;
    public static final int U_MACHINE_OIL_WARN = 13;
    public static final int U_OUT_TEMP = 20;
    public static final int U_PARK_CARPORT = 9;
    public static final int U_PARK_ROAD = 8;
    public static final int U_PRECISION_SPEED = 14;
    public static final int U_RADAR_MUTE = 10;
    public static final int U_RESIDUAL_OIL = 5;
    public static final int U_REVEIVER_LIGHTS = 17;
    public static final int U_TURN_LIGHT_LIGHTS = 19;
    public static final int U_TURN_RIGHT_LIGHTS = 18;
    public static final int U_WATER_TEMP = 12;
    public static boolean jump = false;
    int carId;
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
        for (int i = 0; i < 54; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        this.carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        if (this.carId != 2 && this.carId != 3) {
            DoorHelper.sUcDoorEngine = 42;
            DoorHelper.sUcDoorFl = 43;
            DoorHelper.sUcDoorFr = 44;
            DoorHelper.sUcDoorRl = 45;
            DoorHelper.sUcDoorRr = 46;
            DoorHelper.sUcDoorBack = 47;
        }
        int ID = SystemProperties.getInt("ro.build.fytmanufacturer", -1);
        if (ID != 15) {
            AirHelper.getInstance().buildUi(new Air_0001_WC1_DaZhong(LauncherApplication.getInstance()));
        }
        if (this.carId != 2 && this.carId != 3) {
            DoorHelper.getInstance().buildUi();
            for (int i2 = 42; i2 < 48; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
            }
        }
        if (this.carId != 2 && ID != 15) {
            for (int i3 = 21; i3 < 42; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        if (this.carId != 2 && this.carId != 3) {
            for (int i = 42; i < 48; i++) {
                DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
            }
        }
        if (this.carId != 2) {
            for (int i2 = 21; i2 < 42; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
        }
        AirHelper.getInstance().destroyUi();
        if (this.carId != 2 && this.carId != 3) {
            DoorHelper.getInstance().destroyUi();
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 24:
                    if (this.carId == 2) {
                        showCotrolAir(updateCode, ints);
                        break;
                    }
                case 49:
                    break;
                default:
                    if (this.carId == 2) {
                        if (updateCode >= 21 && updateCode < 42) {
                            showCotrolAir(updateCode, ints);
                            break;
                        } else if (updateCode >= 0 && updateCode < 54) {
                            HandlerCanbus.update(updateCode, ints);
                            break;
                        }
                    } else if (updateCode >= 0 && updateCode < 54) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
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
        if (updateCode == 49) {
            if (this.carId == 2 || this.carId == 3) {
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
