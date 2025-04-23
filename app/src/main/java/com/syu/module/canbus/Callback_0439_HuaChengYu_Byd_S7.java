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

public class Callback_0439_HuaChengYu_Byd_S7 extends CallbackCanbusBase {
    public static final int U_AIR_PM25_CAR_IN = 101;
    public static final int U_AIR_PM25_CAR_OUT = 102;
    public static final int U_AIR_PM25_LEVEL_IN = 103;
    public static final int U_AIR_PM25_LEVEL_OUT = 104;
    public static final int U_AIR_PM25_STATUS = 105;
    public static final int U_AIR_TEMP_CAR_IN = 99;
    public static final int U_AIR_TEMP_CAR_OUT = 100;
    public static final int U_AIR_WARN_SOUND = 106;
    public static final int U_CARINFO_BEGIN = 117;
    public static final int U_CARINFO_CHARGING_LOCK = 120;
    public static final int U_CARINFO_DATA0 = 121;
    public static final int U_CARINFO_ENERGY_FEEDBACK = 119;
    public static final int U_CARINFO_SOC_PORT = 122;
    public static final int U_CARINFO_STEERING_ASSIT = 118;
    public static final int U_CARSET_AIR_MODE_AUTO = 128;
    public static final int U_CARSET_AUDIO_MODE = 133;
    public static final int U_CARSET_AUTO_LOCK = 126;
    public static final int U_CARSET_AUTO_WIN_LEV = 131;
    public static final int U_CARSET_AWAYHOME_LIGHT_DELAY = 125;
    public static final int U_CARSET_BACKHOME_LIGHT_DELAY = 124;
    public static final int U_CARSET_BEGIN = 123;
    public static final int U_CARSET_D27_D0_B70 = 146;
    public static final int U_CARSET_D27_D10_B70 = 164;
    public static final int U_CARSET_D27_D10_B70_OLD = 169;
    public static final int U_CARSET_D27_D11_B70 = 165;
    public static final int U_CARSET_D27_D11_B70_OLD = 170;
    public static final int U_CARSET_D27_D12_B43 = 168;
    public static final int U_CARSET_D27_D12_B65 = 167;
    public static final int U_CARSET_D27_D12_B7 = 166;
    public static final int U_CARSET_D27_D12_B70_OLD = 171;
    public static final int U_CARSET_D27_D13_B70_OLD = 172;
    public static final int U_CARSET_D27_D14_B70_OLD = 173;
    public static final int U_CARSET_D27_D15_B70_OLD = 174;
    public static final int U_CARSET_D27_D1_B6 = 148;
    public static final int U_CARSET_D27_D1_B7 = 147;
    public static final int U_CARSET_D27_D2_B2 = 154;
    public static final int U_CARSET_D27_D2_B3 = 153;
    public static final int U_CARSET_D27_D2_B4 = 152;
    public static final int U_CARSET_D27_D2_B5 = 151;
    public static final int U_CARSET_D27_D2_B6 = 150;
    public static final int U_CARSET_D27_D2_B7 = 149;
    public static final int U_CARSET_D27_D3_B2 = 158;
    public static final int U_CARSET_D27_D3_B43 = 157;
    public static final int U_CARSET_D27_D3_B5 = 156;
    public static final int U_CARSET_D27_D3_B76 = 155;
    public static final int U_CARSET_D27_D4_B70 = 159;
    public static final int U_CARSET_D27_D5_D6 = 160;
    public static final int U_CARSET_D27_D7_B70 = 161;
    public static final int U_CARSET_D27_D8_B70 = 162;
    public static final int U_CARSET_D27_D9_B70 = 163;
    public static final int U_CARSET_D29_D2_B0 = 140;
    public static final int U_CARSET_D29_D2_B1 = 139;
    public static final int U_CARSET_D29_D2_B2 = 138;
    public static final int U_CARSET_D29_D2_B3 = 137;
    public static final int U_CARSET_D29_D2_B4 = 136;
    public static final int U_CARSET_D29_D2_B75 = 135;
    public static final int U_CARSET_D29_D3_B20 = 141;
    public static final int U_CARSET_D29_D3_B3 = 170;
    public static final int U_CARSET_D29_D3_B4 = 169;
    public static final int U_CARSET_D2B_D0_B10 = 144;
    public static final int U_CARSET_D2B_D0_B2 = 143;
    public static final int U_CARSET_D2B_D0_B3 = 142;
    public static final int U_CARSET_D2B_D1_B70 = 145;
    public static final int U_CARSET_END = 134;
    public static final int U_CARSET_PARK_AUTO_CYCLE = 129;
    public static final int U_CARSET_REAR_VIEW_AUTO = 130;
    public static final int U_CARSET_TUNNEL_AUTO_CYCLE = 132;
    public static final int U_CARSET_UNLOCK_SYS = 127;
    public static final int U_CARSHOW_PM25_UI = 175;
    public static final int U_CNT_MAX = 176;
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
            Callback_0439_HuaChengYu_Byd_S7.this.isShow = true;
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
        for (int i = 0; i < 176; i++) {
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
        if (updateCode >= 0 && updateCode < 176) {
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
            if (updateCode == 98) {
                showCotrolAir(updateCode, ints);
            }
        }
    }

    private void showCotrolAir(int updateCode, int[] ints) {
        if (updateCode == 98) {
            int value = ints[0];
            if (value == 1 && !ActivityAirCrtrlBydSirui.mIsFront) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.byd.hcy.ActivityAirCrtrlBydSirui");
            } else if (ActivityAirCrtrlBydSirui.mIsFront && ActivityAirCrtrlBydSirui.mInstance != null) {
                ActivityAirCrtrlBydSirui.mInstance.finish();
            }
        }
    }
}
