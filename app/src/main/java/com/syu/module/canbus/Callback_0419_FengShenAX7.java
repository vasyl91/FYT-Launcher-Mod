package com.syu.module.canbus;

import android.os.RemoteException;
import android.util.Log;
import com.syu.canbus.FuncMain;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.wc.jingyix5.JYCarMaintaneceOptions;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0419_BenTengX80;
import com.syu.ui.air.Air_0419_WC2_AX7;
import com.syu.ui.air.Air_0419_WC2_ChangAnYX;
import com.syu.ui.air.Air_0419_WC2_ChangAnYX_M;
import com.syu.ui.air.Air_0419_WC2_FuMeiLai2017;
import com.syu.ui.air.Air_0419_WC2_HuanSu;
import com.syu.ui.air.Air_0419_WC2_Jili_YuanJing;
import com.syu.ui.air.Air_0419_WC2_JingyiX5;
import com.syu.ui.air.Air_0419_WC2_OuShang_X70A;
import com.syu.ui.air.Air_0419_WC2_ZhongHua_H3;
import com.syu.ui.door.DoorHelper;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0419_FengShenAX7 extends CallbackCanbusBase {
    public static final int C_CMD_LOCK_SET = 3;
    public static final int C_CMD_SET_AIR = 0;
    public static final int C_CMD_SET_CAR = 1;
    public static final int C_CMD_SET_DASHBOARD = 2;
    public static final int U_AIR_AC = 12;
    public static final int U_AIR_ACMAX = 25;
    public static final int U_AIR_AIR = 26;
    public static final int U_AIR_AUTO = 22;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_AUTO_LEFT = 27;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_MODE_LEFT = 19;
    public static final int U_AIR_BLOW_WIN_LEFT = 18;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_DUAL = 23;
    public static final int U_AIR_END = 30;
    public static final int U_AIR_FRONT_DEFROST = 14;
    public static final int U_AIR_POWER = 11;
    public static final int U_AIR_REAR_DEFROST = 15;
    public static final int U_AIR_SEAT_HEAT_LEFT = 28;
    public static final int U_AIR_SEAT_HEAT_RIGHT = 29;
    public static final int U_AIR_TEMP_LEFT = 21;
    public static final int U_AIR_TEMP_RIGHT = 24;
    public static final int U_AIR_WIND_LEVEL_LEFT = 20;
    public static final int U_CARINFO_ADD_OIL = 56;
    public static final int U_CARINFO_AUTO_AC = 64;
    public static final int U_CARINFO_AUTO_LOCK = 93;
    public static final int U_CARINFO_AUTO_LOCK_WHEN_15KM_PRE_HOUR = 71;
    public static final int U_CARINFO_AUTO_RELOCK = 95;
    public static final int U_CARINFO_AUTO_UNLOCK = 94;
    public static final int U_CARINFO_AUTO_WIND = 63;
    public static final int U_CARINFO_AWAY_HOME_DELAY_LIGHT = 68;
    public static final int U_CARINFO_BACK_HOME_DELAY_LIGHT = 69;
    public static final int U_CARINFO_BEAM_FLASH_WHEN_ANTI_THEFT_RELEASED = 77;
    public static final int U_CARINFO_BEGIN = 50;
    public static final int U_CARINFO_CAR_CARE = 57;
    public static final int U_CARINFO_CLOSE_LIGHT = 55;
    public static final int U_CARINFO_CLOSE_POWER = 51;
    public static final int U_CARINFO_DOOR_UNLOCK = 96;
    public static final int U_CARINFO_DRIVER_SEAT_AUTO_RECOERS = 74;
    public static final int U_CARINFO_END = 85;
    public static final int U_CARINFO_ENGINER_TEMP_HIGHTER = 54;
    public static final int U_CARINFO_EXCEEDED_VEHICLE_SPEED = 58;
    public static final int U_CARINFO_FOLD_REARVIEW_WHEN_LOCKED = 70;
    public static final int U_CARINFO_FUEL_LOW = 52;
    public static final int U_CARINFO_HIGHTEMP_INTER_CYCLE = 62;
    public static final int U_CARINFO_JY_66D0B0 = 88;
    public static final int U_CARINFO_JY_66D0B1 = 87;
    public static final int U_CARINFO_JY_67D0B0 = 90;
    public static final int U_CARINFO_JY_67D0B1 = 89;
    public static final int U_CARINFO_JY_E = 92;
    public static final int U_CARINFO_JY_S = 86;
    public static final int U_CARINFO_JY_TOTAL_MILES = 91;
    public static final int U_CARINFO_KEY_NOT_PULLED = 50;
    public static final int U_CARINFO_LOCK_DOUBLE_LIGHT = 97;
    public static final int U_CARINFO_MAGNETIC_RELAY_STATE = 73;
    public static final int U_CARINFO_MAINTION_CAR = 59;
    public static final int U_CARINFO_OPEN_BSD_WARN = 81;
    public static final int U_CARINFO_OPEN_LDW_WARN = 80;
    public static final int U_CARINFO_OUT_REARVIEW_AUTO_LIGHT = 67;
    public static final int U_CARINFO_PARK_INTER_CYCLE = 65;
    public static final int U_CARINFO_PHONEING_DOWN_WIND = 61;
    public static final int U_CARINFO_REAR_VIEW_AUTO_FOLD = 99;
    public static final int U_CARINFO_RELEASE_HANDBACK = 53;
    public static final int U_CARINFO_REMOTE_CONTROL_WINDOW_DOWN = 78;
    public static final int U_CARINFO_REMOTE_CONTROL_WINDOW_UP = 79;
    public static final int U_CARINFO_REMOTE_OPEN_AIR = 60;
    public static final int U_CARINFO_SECONDARY_UNLOCK = 72;
    public static final int U_CARINFO_SPEED_SPEED_REMINDER = 83;
    public static final int U_CARINFO_STOP_WIPER_WHEN_OPEN_DOOR = 76;
    public static final int U_CARINFO_TPMS_UNIT = 84;
    public static final int U_CARINFO_TURN_AURO_FRONT_FOG_LIGHT = 75;
    public static final int U_CARINFO_UNLOCK_DOUBLE_LIGHT = 98;
    public static final int U_CARINFO_UPLIGHT_AUTO_DELAY = 66;
    public static final int U_CARINFO_WINTER_SPEED_LIMIT_REMINDER = 82;
    public static final int U_CNT_MAX = 100;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    boolean bMaintanceWarning = true;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 100; i++) {
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
        if (carId == 0 || carId == 1) {
            AirHelper.getInstance().buildUi(new Air_0419_WC2_AX7(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 30; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (carId == 2 || carId == 3) {
            AirHelper.getInstance().buildUi(new Air_0419_BenTengX80(LauncherApplication.getInstance()));
            for (int i4 = 10; i4 < 30; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (carId == 4 || carId == 5 || carId == 18 || carId == 19) {
            AirHelper.getInstance().buildUi(new Air_0419_WC2_HuanSu(LauncherApplication.getInstance()));
            for (int i5 = 10; i5 < 30; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (carId == 7) {
            AirHelper.getInstance().buildUi(new Air_0419_WC2_FuMeiLai2017(LauncherApplication.getInstance()));
            for (int i6 = 10; i6 < 30; i6++) {
                DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (carId == 8 || carId == 16 || carId == 17 || carId == 20) {
            AirHelper.getInstance().buildUi(new Air_0419_WC2_JingyiX5(LauncherApplication.getInstance()));
            for (int i7 = 10; i7 < 30; i7++) {
                DataCanbus.NOTIFY_EVENTS[i7].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (carId == 9) {
            AirHelper.getInstance().buildUi(new Air_0419_WC2_ChangAnYX(LauncherApplication.getInstance()));
            for (int i8 = 10; i8 < 30; i8++) {
                DataCanbus.NOTIFY_EVENTS[i8].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (carId == 10) {
            AirHelper.getInstance().buildUi(new Air_0419_WC2_ChangAnYX_M(LauncherApplication.getInstance()));
            for (int i9 = 10; i9 < 30; i9++) {
                DataCanbus.NOTIFY_EVENTS[i9].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (carId == 12) {
            AirHelper.getInstance().buildUi(new Air_0419_WC2_Jili_YuanJing(LauncherApplication.getInstance()));
            for (int i10 = 10; i10 < 30; i10++) {
                DataCanbus.NOTIFY_EVENTS[i10].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (carId == 13) {
            AirHelper.getInstance().buildUi(new Air_0419_WC2_ZhongHua_H3(LauncherApplication.getInstance()));
            for (int i11 = 10; i11 < 30; i11++) {
                DataCanbus.NOTIFY_EVENTS[i11].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (carId == 15) {
            AirHelper.getInstance().buildUi(new Air_0419_WC2_OuShang_X70A(LauncherApplication.getInstance()));
            for (int i12 = 10; i12 < 30; i12++) {
                DataCanbus.NOTIFY_EVENTS[i12].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 30; i2++) {
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
            if (this.bMaintanceWarning && setMiles < DataCanbus.DATA[91]) {
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
            if (this.bMaintanceWarning && setMiles2 < DataCanbus.DATA[91]) {
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
            if (this.bMaintanceWarning && setMiles3 < DataCanbus.DATA[91]) {
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

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 100) {
            HandlerCanbus.update(updateCode, ints);
            Log.d("s6", "updateCode:" + updateCode + ", value:" + DataCanbus.DATA[updateCode]);
        }
    }
}
