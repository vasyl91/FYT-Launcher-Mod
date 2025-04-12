package com.syu.module.canbus;

import android.content.Intent;
import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.R;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerRemove;
import com.syu.util.WarnDialgAct;

public class Callback_0439_XBS_Byd_Song extends CallbackCanbusBase {
    public static final int U_AIR_PM25_CAR_IN = 105;
    public static final int U_AIR_PM25_CAR_OUT = 106;
    public static final int U_AIR_PM25_LEVEL_IN = 107;
    public static final int U_AIR_PM25_LEVEL_OUT = 108;
    public static final int U_AIR_PM25_STATUS = 109;
    public static final int U_AIR_WARN_SOUND = 98;
    public static final int U_CARINFO_AIRAUTO_WINLEV = 123;
    public static final int U_CARINFO_AIR_AUTOMODE = 122;
    public static final int U_CARINFO_BEGIN = 114;
    public static final int U_CARINFO_BT_BLOW = 120;
    public static final int U_CARINFO_CHARGING_LOCK = 117;
    public static final int U_CARINFO_DATA0 = 118;
    public static final int U_CARINFO_END = 124;
    public static final int U_CARINFO_ENERGY_FEEDBACK = 116;
    public static final int U_CARINFO_SOC_PORT = 119;
    public static final int U_CARINFO_STEERING_ASSIT = 115;
    public static final int U_CARINFO_STOP_CYCLEIN = 121;
    public static final int U_CNT_MAX = 133;
    public static final int U_PM25_DETECT_INNER = 110;
    public static final int U_PM25_DETECT_OUTER = 111;
    public static final int U_PM25_WARN = 112;
    public static final int U_SET_FULL_CAMERA_SWITCH = 104;
    public static final int U_SET_LONGPRESS_CLOSE_LIFTTING_WINDOW = 101;
    public static final int U_SET_LONGPRESS_OPEN_LIFTTING_WINDOW = 102;
    public static final int U_SET_REMOTE_DOWN_WINDOW = 100;
    public static final int U_SET_REMOTE_LIFT_WINDOW = 99;
    public static final int U_SET_RIGHT_CAMERA_SWITCH = 103;
    public static final int U_SET_WINDOW_VALUE = 113;
    public static final int U_TIRE_ALARM_FL = 129;
    public static final int U_TIRE_ALARM_FR = 130;
    public static final int U_TIRE_ALARM_RL = 131;
    public static final int U_TIRE_ALARM_RR = 132;
    public static final int U_TIRE_PRESSURE_FL = 125;
    public static final int U_TIRE_PRESSURE_FR = 126;
    public static final int U_TIRE_PRESSURE_RL = 127;
    public static final int U_TIRE_PRESSURE_RR = 128;
    boolean isShow = false;
    private final Runnable showDlgWarn = new Runnable() { 
        @Override
        public void run() {
            Callback_0439_XBS_Byd_Song.this.isShow = true;
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
        for (int i = 0; i < 133; i++) {
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
        if (updateCode >= 0 && updateCode < 133) {
            HandlerCanbus.update(updateCode, ints);
        }
        if (updateCode == 112 && DataCanbus.DATA[updateCode] == 1) {
            if (this.isShow) {
                this.isShow = false;
                HandlerRemove.getInstance().removeCallbacks(this.showDlgWarn);
            }
            HandlerRemove.getInstance().postDelayed(this.showDlgWarn, 3L);
        }
    }
}
