package com.syu.module.canbus;

import android.content.Intent;
import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.carinfo.byd.hcy.ActivityAirCrtrlBydSirui;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerRemove;
import com.syu.util.WarnDialgAct;

public class Callback_0439_OD_AIying_Byd_Sirui extends CallbackCanbusBase {
    public static final int U_AIR_PM25_CAR_IN = 101;
    public static final int U_AIR_PM25_CAR_OUT = 102;
    public static final int U_AIR_PM25_LEVEL_IN = 103;
    public static final int U_AIR_PM25_LEVEL_OUT = 104;
    public static final int U_AIR_PM25_STATUS = 105;
    public static final int U_AIR_TEMP_CAR_IN = 99;
    public static final int U_AIR_TEMP_CAR_OUT = 100;
    public static final int U_AIR_WARN_SOUND = 106;
    public static final int U_CARINFO_AIRSHOW = 146;
    public static final int U_CARINFO_AIR_AUTOAC = 132;
    public static final int U_CARINFO_AUTO_CYCLE_TUNNEL = 135;
    public static final int U_CARINFO_AUTO_MODE_WIND_LEVEL = 134;
    public static final int U_CARINFO_BEGIN = 117;
    public static final int U_CARINFO_BLUE_WIN_DOWN = 128;
    public static final int U_CARINFO_CHARGING_LOCK = 120;
    public static final int U_CARINFO_DATA0 = 121;
    public static final int U_CARINFO_DOORS_AUTO_LOCK = 130;
    public static final int U_CARINFO_ENERGY_FEEDBACK = 119;
    public static final int U_CARINFO_LIGHT_HOME_DELAY = 123;
    public static final int U_CARINFO_MAINTENANCE_DAYS = 136;
    public static final int U_CARINFO_MAINTENANCE_MILEAGE = 137;
    public static final int U_CARINFO_METER_BRIGHT = 141;
    public static final int U_CARINFO_METER_LANGUAGE = 142;
    public static final int U_CARINFO_METER_THEME = 140;
    public static final int U_CARINFO_NIGHT_MODE = 131;
    public static final int U_CARINFO_PARK_AUTO_CYCLE = 133;
    public static final int U_CARINFO_REARVIEW_AUTO_AFTER_BACK = 126;
    public static final int U_CARINFO_REAR_CTRL = 127;
    public static final int U_CARINFO_REMOTE_DOWN_WINDOW = 125;
    public static final int U_CARINFO_REMOTE_LIFT_WINDOW = 124;
    public static final int U_CARINFO_SOC_PORT = 122;
    public static final int U_CARINFO_SPEED_WARN = 138;
    public static final int U_CARINFO_SPEED_WARN_WINTER = 139;
    public static final int U_CARINFO_STEERING_ASSIT = 118;
    public static final int U_CARINFO_UNIT_FUEL = 145;
    public static final int U_CARINFO_UNIT_PRESSURE = 144;
    public static final int U_CARINFO_UNIT_TEMP = 143;
    public static final int U_CARINFO_UNLOCK_SET = 129;
    public static final int U_CNT_MAX = 147;
    public static final int U_JUMP_CAR_AIR_INFO = 98;
    public static final int U_PM25_DETECT_INNER = 113;
    public static final int U_PM25_DETECT_OUTER = 114;
    public static final int U_PM25_WARN = 115;
    public static final int U_SET_FULL_CAMERA_SWITCH = 112;
    public static final int U_SET_LONGPRESS_CLOSE_LIFTTING_WINDOW = 109;
    public static final int U_SET_LONGPRESS_OPEN_LIFTTING_WINDOW = 110;
    public static final int U_SET_REMOTE_DOWN_WINDOW = 108;
    public static final int U_SET_REMOTE_LIFT_WINDOW = 107;
    public static final int U_SET_RIGHT_CAMERA_SWITCH = 111;
    public static final int U_SET_WINDOW_VALUE = 116;
    boolean isShow = false;
    private final Runnable showDlgWarn = new Runnable() { 
        @Override
        public void run() {
            Callback_0439_OD_AIying_Byd_Sirui.this.isShow = true;
            Intent ii = new Intent();
            ii.putExtra(WarnDialgAct.INFO, LauncherApplication.getInstance().getString(R.string.str_178_byd_12));
            ii.putExtra(WarnDialgAct.TITLE, LauncherApplication.getInstance().getString(R.string.str_178_byd_11));
            ii.setClass(LauncherApplication.getInstance(), WarnDialgAct.class);
            ii.setFlags(268435456);
            LauncherApplication.getInstance().startActivity(ii);
        }
    };

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 147; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0178_FYTA_BYDF3_SuRui_TopHp(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 147) {
            HandlerCanbus.update(updateCode, ints);
            if (updateCode == 115) {
                if (DataCanbus.DATA[updateCode] == 1) {
                    if (this.isShow) {
                        this.isShow = false;
                        HandlerRemove.getInstance().removeCallbacks(this.showDlgWarn);
                    }
                    HandlerRemove.getInstance().postDelayed(this.showDlgWarn, 3L);
                    return;
                }
                return;
            }
            if (updateCode == 146) {
                if (!ActivityAirCrtrlBydSirui.mIsFront) {
                    //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.byd.hcy.ActivityAirCrtrlBydSirui");
                } else if (ActivityAirCrtrlBydSirui.mIsFront && ActivityAirCrtrlBydSirui.mInstance != null) {
                    ActivityAirCrtrlBydSirui.mInstance.finish();
                }
            }
        }
    }
}
