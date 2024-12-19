package com.syu.module.canbus;

import android.content.Intent;
import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.R;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.byd.hcy.ActivityAirCrtrlBydSirui;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0178_FYTA_BYDF3_SuRui_TopHp;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerRemove;
import com.syu.util.WarnDialgAct;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0439_HuaChengYu_Byd_S7 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 11;
    public static final int U_AIR_ACMAX = 72;
    public static final int U_AIR_AUTO = 12;
    public static final int U_AIR_BATTERY = 16;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_AUTO_LEFT = 19;
    public static final int U_AIR_BLOW_BODY_LEFT = 22;
    public static final int U_AIR_BLOW_FOOT_LEFT = 21;
    public static final int U_AIR_BLOW_WIN_LEFT = 20;
    public static final int U_AIR_CYCLE = 13;
    public static final int U_AIR_DUAL = 15;
    public static final int U_AIR_END = 32;
    public static final int U_AIR_FRONT_DEFROST = 17;
    public static final int U_AIR_PM25_CAR_IN = 28;
    public static final int U_AIR_PM25_CAR_OUT = 29;
    public static final int U_AIR_PM25_LEVEL_IN = 30;
    public static final int U_AIR_PM25_LEVEL_OUT = 31;
    public static final int U_AIR_PM25_STATUS = 48;
    public static final int U_AIR_POWER = 10;
    public static final int U_AIR_REAR_AUTO = 46;
    public static final int U_AIR_REAR_CONTROL = 40;
    public static final int U_AIR_REAR_DEFROST = 14;
    public static final int U_AIR_REAR_EXIST = 41;
    public static final int U_AIR_REAR_MODE_BODY = 44;
    public static final int U_AIR_REAR_MODE_FOOT = 45;
    public static final int U_AIR_REAR_POWER = 43;
    public static final int U_AIR_REAR_TEMP_LEFT = 42;
    public static final int U_AIR_REAR_WIND_LEVEL = 47;
    public static final int U_AIR_TEMP_CAR_IN = 26;
    public static final int U_AIR_TEMP_CAR_OUT = 27;
    public static final int U_AIR_TEMP_LEFT = 24;
    public static final int U_AIR_TEMP_RIGHT = 25;
    public static final int U_AIR_TEMP_UNIT = 23;
    public static final int U_AIR_WARN_SOUND = 33;
    public static final int U_AIR_WIND_LEVEL_LEFT = 18;
    public static final int U_CARINFO_BEGIN = 53;
    public static final int U_CARINFO_CHARGING_LOCK = 56;
    public static final int U_CARINFO_DATA0 = 57;
    public static final int U_CARINFO_ENERGY_FEEDBACK = 55;
    public static final int U_CARINFO_SOC_PORT = 58;
    public static final int U_CARINFO_STEERING_ASSIT = 54;
    public static final int U_CARSET_AIR_MODE_AUTO = 64;
    public static final int U_CARSET_AUDIO_MODE = 69;
    public static final int U_CARSET_AUTO_LOCK = 62;
    public static final int U_CARSET_AUTO_WIN_LEV = 67;
    public static final int U_CARSET_AWAYHOME_LIGHT_DELAY = 61;
    public static final int U_CARSET_BACKHOME_LIGHT_DELAY = 60;
    public static final int U_CARSET_BEGIN = 59;
    public static final int U_CARSET_D27_D0_B70 = 84;
    public static final int U_CARSET_D27_D10_B70 = 102;
    public static final int U_CARSET_D27_D11_B70 = 103;
    public static final int U_CARSET_D27_D12_B43 = 106;
    public static final int U_CARSET_D27_D12_B65 = 105;
    public static final int U_CARSET_D27_D12_B7 = 104;
    public static final int U_CARSET_D27_D1_B6 = 86;
    public static final int U_CARSET_D27_D1_B7 = 85;
    public static final int U_CARSET_D27_D2_B2 = 92;
    public static final int U_CARSET_D27_D2_B3 = 91;
    public static final int U_CARSET_D27_D2_B4 = 90;
    public static final int U_CARSET_D27_D2_B5 = 89;
    public static final int U_CARSET_D27_D2_B6 = 88;
    public static final int U_CARSET_D27_D2_B7 = 87;
    public static final int U_CARSET_D27_D3_B2 = 96;
    public static final int U_CARSET_D27_D3_B43 = 95;
    public static final int U_CARSET_D27_D3_B5 = 94;
    public static final int U_CARSET_D27_D3_B76 = 93;
    public static final int U_CARSET_D27_D4_B70 = 97;
    public static final int U_CARSET_D27_D5_D6 = 98;
    public static final int U_CARSET_D27_D7_B70 = 99;
    public static final int U_CARSET_D27_D8_B70 = 100;
    public static final int U_CARSET_D27_D9_B70 = 101;
    public static final int U_CARSET_D29_D2_B0 = 78;
    public static final int U_CARSET_D29_D2_B1 = 77;
    public static final int U_CARSET_D29_D2_B2 = 76;
    public static final int U_CARSET_D29_D2_B3 = 75;
    public static final int U_CARSET_D29_D2_B4 = 74;
    public static final int U_CARSET_D29_D2_B75 = 73;
    public static final int U_CARSET_D29_D3_B20 = 79;
    public static final int U_CARSET_D29_D3_B3 = 108;
    public static final int U_CARSET_D29_D3_B4 = 107;
    public static final int U_CARSET_D2B_D0_B10 = 82;
    public static final int U_CARSET_D2B_D0_B2 = 81;
    public static final int U_CARSET_D2B_D0_B3 = 80;
    public static final int U_CARSET_D2B_D1_B70 = 83;
    public static final int U_CARSET_END = 70;
    public static final int U_CARSET_PARK_AUTO_CYCLE = 65;
    public static final int U_CARSET_REAR_VIEW_AUTO = 66;
    public static final int U_CARSET_TUNNEL_AUTO_CYCLE = 68;
    public static final int U_CARSET_UNLOCK_SYS = 63;
    public static final int U_CNT_MAX = 109;
    public static final int U_CUR_SPEED = 7;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_JUMP_CAR_AIR_INFO = 71;
    public static final int U_PM25_DETECT_INNER = 49;
    public static final int U_PM25_DETECT_OUTER = 50;
    public static final int U_PM25_WARN = 51;
    public static final int U_SET_FULL_CAMERA_SWITCH = 39;
    public static final int U_SET_LONGPRESS_CLOSE_LIFTTING_WINDOW = 36;
    public static final int U_SET_LONGPRESS_OPEN_LIFTTING_WINDOW = 37;
    public static final int U_SET_REMOTE_DOWN_WINDOW = 35;
    public static final int U_SET_REMOTE_LIFT_WINDOW = 34;
    public static final int U_SET_RIGHT_CAMERA_SWITCH = 38;
    public static final int U_SET_WINDOW_VALUE = 52;
    boolean isShow = false;
    private Runnable showDlgWarn = new Runnable() { // from class: com.syu.module.canbus.Callback_0439_HuaChengYu_Byd_S7.1
        @Override // java.lang.Runnable
        public void run() {
            Callback_0439_HuaChengYu_Byd_S7.this.isShow = true;
            Intent ii = new Intent();
            ii.putExtra(WarnDialgAct.INFO, LauncherApplication.getInstance().getString(R.string.str_178_byd_12));
            ii.putExtra(WarnDialgAct.TITLE, LauncherApplication.getInstance().getString(R.string.str_178_byd_11));
            ii.setClass(LauncherApplication.getInstance(), WarnDialgAct.class);
            ii.setFlags(268435456);
            LauncherApplication.getInstance().startActivity(ii);
        }
    };

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 109; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0178_FYTA_BYDF3_SuRui_TopHp(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 11; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        for (int i3 = 12; i3 < 28; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        for (int i4 = 0; i4 < 6; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(DoorHelper.getInstance(), 0);
        }
        DoorHelper.getInstance().buildUi();
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 10; i < 32; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 109) {
            HandlerCanbus.update(updateCode, ints);
            if (updateCode == 51) {
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
            if (updateCode == 71) {
                showCotrolAir(updateCode, ints);
            }
        }
    }

    private void showCotrolAir(int updateCode, int[] ints) {
        if (updateCode == 71) {
            int value = ints[0];
            if (value == 1 && !ActivityAirCrtrlBydSirui.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.byd.hcy.ActivityAirCrtrlBydSirui");
            } else if (ActivityAirCrtrlBydSirui.mIsFront && ActivityAirCrtrlBydSirui.mInstance != null) {
                ActivityAirCrtrlBydSirui.mInstance.finish();
            }
        }
    }
}
