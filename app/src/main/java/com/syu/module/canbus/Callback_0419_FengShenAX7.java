package com.syu.module.canbus;

import android.os.RemoteException;

import com.android.launcher66.LauncherApplication;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.syu.carinfo.wc.jingyix5.JYCarMaintaneceOptions;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Callback_0419_FengShenAX7 extends CallbackCanbusBase {
    public static final int C_CMD_LOCK_SET = 3;
    public static final int C_CMD_SET_AIR = 0;
    public static final int C_CMD_SET_CAR = 1;
    public static final int C_CMD_SET_DASHBOARD = 2;
    public static final int U_CARINFO_ADD_OIL = 105;
    public static final int U_CARINFO_AUTO_AC = 113;
    public static final int U_CARINFO_AUTO_LOCK = 142;
    public static final int U_CARINFO_AUTO_LOCK_WHEN_15KM_PRE_HOUR = 120;
    public static final int U_CARINFO_AUTO_RELOCK = 144;
    public static final int U_CARINFO_AUTO_UNLOCK = 143;
    public static final int U_CARINFO_AUTO_WIND = 112;
    public static final int U_CARINFO_AWAY_HOME_DELAY_LIGHT = 117;
    public static final int U_CARINFO_BACK_HOME_DELAY_LIGHT = 118;
    public static final int U_CARINFO_BEAM_FLASH_WHEN_ANTI_THEFT_RELEASED = 126;
    public static final int U_CARINFO_BEGIN = 99;
    public static final int U_CARINFO_CAR_CARE = 106;
    public static final int U_CARINFO_CLOSE_LIGHT = 104;
    public static final int U_CARINFO_CLOSE_POWER = 100;
    public static final int U_CARINFO_DOOR_UNLOCK = 145;
    public static final int U_CARINFO_DRIVER_SEAT_AUTO_RECOERS = 123;
    public static final int U_CARINFO_END = 134;
    public static final int U_CARINFO_ENGINER_TEMP_HIGHTER = 103;
    public static final int U_CARINFO_EXCEEDED_VEHICLE_SPEED = 107;
    public static final int U_CARINFO_FOLD_REARVIEW_WHEN_LOCKED = 119;
    public static final int U_CARINFO_FUEL_LOW = 101;
    public static final int U_CARINFO_HIGHTEMP_INTER_CYCLE = 111;
    public static final int U_CARINFO_JY_66D0B0 = 137;
    public static final int U_CARINFO_JY_66D0B1 = 136;
    public static final int U_CARINFO_JY_67D0B0 = 139;
    public static final int U_CARINFO_JY_67D0B1 = 138;
    public static final int U_CARINFO_JY_E = 141;
    public static final int U_CARINFO_JY_S = 135;
    public static final int U_CARINFO_JY_TOTAL_MILES = 140;
    public static final int U_CARINFO_KEY_NOT_PULLED = 99;
    public static final int U_CARINFO_LOCK_DOUBLE_LIGHT = 146;
    public static final int U_CARINFO_MAGNETIC_RELAY_STATE = 122;
    public static final int U_CARINFO_MAINTION_CAR = 108;
    public static final int U_CARINFO_OPEN_BSD_WARN = 130;
    public static final int U_CARINFO_OPEN_LDW_WARN = 129;
    public static final int U_CARINFO_OUT_REARVIEW_AUTO_LIGHT = 116;
    public static final int U_CARINFO_PARK_INTER_CYCLE = 114;
    public static final int U_CARINFO_PHONEING_DOWN_WIND = 110;
    public static final int U_CARINFO_REAR_VIEW_AUTO_FOLD = 148;
    public static final int U_CARINFO_RELEASE_HANDBACK = 102;
    public static final int U_CARINFO_REMOTE_CONTROL_WINDOW_DOWN = 127;
    public static final int U_CARINFO_REMOTE_CONTROL_WINDOW_UP = 128;
    public static final int U_CARINFO_REMOTE_OPEN_AIR = 109;
    public static final int U_CARINFO_SECONDARY_UNLOCK = 121;
    public static final int U_CARINFO_SPEED_SPEED_REMINDER = 132;
    public static final int U_CARINFO_STOP_WIPER_WHEN_OPEN_DOOR = 125;
    public static final int U_CARINFO_TPMS_UNIT = 133;
    public static final int U_CARINFO_TURN_AURO_FRONT_FOG_LIGHT = 124;
    public static final int U_CARINFO_UNLOCK_DOUBLE_LIGHT = 147;
    public static final int U_CARINFO_UPLIGHT_AUTO_DELAY = 115;
    public static final int U_CARINFO_WINTER_SPEED_LIMIT_REMINDER = 131;
    private static final int U_CARMERA_STATE = 149;
    private static final int U_CAR_BACKCAR = 150;
    public static final int U_CNT_MAX = 151;
    public static final int U_CUR_SPEED = 98;
    public static final int U_ENGINE_SPEED = 98;
    boolean bMaintanceWarning = true;

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 151; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        int carId = (DataCanbus.DATA[1000] >> 16) & 65535;
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
        if (carId == 0 || carId == 1) {
            //AirHelper.getInstance().buildUi(new Air_0419_WC2_AX7(LauncherApplication.getInstance()));
            return;
        }
        if (carId == 2 || carId == 3) {
            //AirHelper.getInstance().buildUi(new Air_0419_BenTengX80(LauncherApplication.getInstance()));
            return;
        }
        if (carId == 4 || carId == 5 || carId == 18 || carId == 19) {
            //AirHelper.getInstance().buildUi(new Air_0419_WC2_HuanSu(LauncherApplication.getInstance()));
            return;
        }
        if (carId == 7) {
            //AirHelper.getInstance().buildUi(new Air_0419_WC2_FuMeiLai2017(LauncherApplication.getInstance()));
            return;
        }
        if (carId == 8 || carId == 16 || carId == 17 || carId == 20) {
            //AirHelper.getInstance().buildUi(new Air_0419_WC2_JingyiX5(LauncherApplication.getInstance()));
            return;
        }
        if (carId == 9) {
            //AirHelper.getInstance().buildUi(new Air_0419_WC2_ChangAnYX(LauncherApplication.getInstance()));
            return;
        }
        if (carId == 10) {
            //AirHelper.getInstance().buildUi(new Air_0419_WC2_ChangAnYX_M(LauncherApplication.getInstance()));
            return;
        }
        if (carId == 12) {
            //AirHelper.getInstance().buildUi(new Air_0419_WC2_Jili_YuanJing(LauncherApplication.getInstance()));
        } else if (carId == 13) {
            //AirHelper.getInstance().buildUi(new Air_0419_WC2_ZhongHua_H3(LauncherApplication.getInstance()));
        } else if (carId == 15) {
            //AirHelper.getInstance().buildUi(new Air_0419_WC2_OuShang_X70A(LauncherApplication.getInstance()));
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

    private void checkMaintanceOfCar() {
        Calendar calendar = Calendar.getInstance(Locale.CHINA);
        String tag = JYCarMaintaneceOptions.SPreUtils.get(LauncherApplication.getInstance(), "Maintenance_checked", "0");
        boolean onReminder = Integer.valueOf(tag).intValue() != 0;
        if (onReminder) {
            String tag2 = JYCarMaintaneceOptions.SPreUtils.get(LauncherApplication.getInstance(), "Maintenance_miles", "0");
            int setMiles = Integer.valueOf(tag2).intValue();
            if (this.bMaintanceWarning && setMiles < DataCanbus.DATA[140]) {
                FuncMain.tips(LauncherApplication.getInstance().getString(R.string.str_wc_jy_str14));
                this.bMaintanceWarning = false;
            }
        }
        String tag3 = JYCarMaintaneceOptions.SPreUtils.get(LauncherApplication.getInstance(), "tire_checked", "0");
        boolean onReminder2 = Integer.valueOf(tag3).intValue() != 0;
        Calendar.getInstance();
        if (onReminder2) {
            String tag4 = JYCarMaintaneceOptions.SPreUtils.get(LauncherApplication.getInstance(), "tire_miles", "0");
            int setMiles2 = Integer.valueOf(tag4).intValue();
            if (this.bMaintanceWarning && setMiles2 < DataCanbus.DATA[140]) {
                FuncMain.tips(LauncherApplication.getInstance().getString(R.string.str_wc_jy_str15));
                this.bMaintanceWarning = false;
            }
            String tag5 = JYCarMaintaneceOptions.SPreUtils.get(LauncherApplication.getInstance(), "tire_date", "0");
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Date date = null;
            try {
                date = format.parse(tag5);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            if (date != null) {
                calendar.clear();
                calendar.setTime(date);
            }
            if (this.bMaintanceWarning && calendar.getTimeInMillis() > System.currentTimeMillis()) {
                FuncMain.tips(LauncherApplication.getInstance().getString(R.string.str_wc_jy_str16));
                this.bMaintanceWarning = false;
            }
        }
        String tag6 = JYCarMaintaneceOptions.SPreUtils.get(LauncherApplication.getInstance(), "oil_checked", "0");
        boolean onReminder3 = Integer.valueOf(tag6).intValue() != 0;
        if (onReminder3) {
            String tag7 = JYCarMaintaneceOptions.SPreUtils.get(LauncherApplication.getInstance(), "oil_miles", "0");
            int setMiles3 = Integer.valueOf(tag7).intValue();
            if (this.bMaintanceWarning && setMiles3 < DataCanbus.DATA[140]) {
                FuncMain.tips(LauncherApplication.getInstance().getString(R.string.str_wc_jy_str17));
                this.bMaintanceWarning = false;
            }
            String tag8 = JYCarMaintaneceOptions.SPreUtils.get(LauncherApplication.getInstance(), "oil_date", "0");
            DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd");
            Date date2 = null;
            try {
                date2 = format2.parse(tag8);
            } catch (ParseException e2) {
                e2.printStackTrace();
            }
            if (date2 != null) {
                calendar.clear();
                calendar.setTime(date2);
            }
            if (this.bMaintanceWarning && calendar.getTimeInMillis() > System.currentTimeMillis()) {
                FuncMain.tips(LauncherApplication.getInstance().getString(R.string.str_wc_jy_str18));
                this.bMaintanceWarning = false;
            }
        }
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 151) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
