package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.air.Air_Activity_All_NewAdd_HP;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti;
import com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDrivingInfo1Acti;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitMisc;

public class Callback_0040_XP1_GaoErFu7 extends CallbackCanbusBase {
    public static final int U_ACTIVATEMATICLLY = 204;
    public static final int U_AIR_AUTOCYCLE_SET = 200;
    public static final int U_AIR_CLEAR_STATE = 235;
    public static final int U_BACK_BRIGHT = 201;
    public static final int U_BACK_CONTRAST = 202;
    public static final int U_BACK_SATURATION = 203;
    public static final int U_CAR_KEY_ACTIVATED = 205;
    public static final int U_CNT_MAX = 236;
    public static final int U_CUR_SPEED = 184;
    public static final int U_DOOR_MIND_PAIR = 198;
    public static final int U_DOOR_SENSE_LAN = 199;
    public static final int U_DRIVERLANEASSIST_JH = 206;
    public static final int U_ENGINE_SPEED = 185;
    public static final int U_JUMP_CARINFO = 191;
    public static final int U_LIGHT_ALL = 197;
    public static final int U_LIGHT_ASSIST = 195;
    public static final int U_LIGHT_BEND = 196;
    public static final int U_LIGHT_COLOR = 192;
    public static final int U_LIGHT_FAN = 193;
    public static final int U_LIGHT_RIGHT = 194;
    public static final int U_SETTING_86D13 = 190;
    public static final int U_SETTING_86D14 = 189;
    public static final int U_SETTING_86D15 = 188;
    public static final int U_SETTING_86D16 = 187;
    public static final int U_SETTING_86D17 = 186;
    public static final int U_SETTING_D40_D30_D1_B2 = 230;
    public static final int U_SETTING_D40_D30_D1_B3 = 234;
    public static final int U_SETTING_D40_D30_D1_B74 = 233;
    public static final int U_SETTING_D40_D51_D4_B75 = 231;
    public static final int U_SETTING_D40_D70_D2_B2 = 232;
    public static final int U_SETTING_D41_D20_D3_B70 = 225;
    public static final int U_SETTING_D41_D70_D3_B0 = 224;
    public static final int U_SETTING_D41_DA1_D1_B30 = 217;
    public static final int U_SETTING_D41_DA1_D1_B74 = 216;
    public static final int U_SETTING_D41_DA1_D2_B30 = 219;
    public static final int U_SETTING_D41_DA1_D2_B74 = 218;
    public static final int U_SETTING_D41_DA1_D3_B30 = 223;
    public static final int U_SETTING_D41_DA1_D3_B5 = 222;
    public static final int U_SETTING_D41_DA1_D3_B6 = 221;
    public static final int U_SETTING_D41_DA1_D3_B7 = 220;
    public static final int U_SETTING_D41_DC0_D1_B0 = 229;
    public static final int U_SETTING_D41_DC0_D1_B1 = 228;
    public static final int U_SETTING_D41_DC0_D1_B2 = 227;
    public static final int U_SETTING_D41_DC0_D1_B43 = 226;
    public static final int U_TIRE_ALARM = 207;
    public static final int U_TIRE_ALARM_FL = 208;
    public static final int U_TIRE_ALARM_FR = 209;
    public static final int U_TIRE_ALARM_RL = 210;
    public static final int U_TIRE_ALARM_RR = 211;
    public static final int U_TIRE_PRESSURE_FL = 212;
    public static final int U_TIRE_PRESSURE_FR = 213;
    public static final int U_TIRE_PRESSURE_RL = 214;
    public static final int U_TIRE_PRESSURE_RR = 215;
    Runnable mDismissFunctionalDrivingInfo1 = new Runnable() { 
        @Override
        public void run() {
            if (Golf7FunctionalDrivingInfo1Acti.mIsFront && Golf7FunctionalDrivingInfo1Acti.mInstance != null) {
                Golf7FunctionalDrivingInfo1Acti.mInstance.finish();
            }
        }
    };

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 236; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0040_XP_MQB_ALL(LauncherApplication.getInstance()));
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
        if (updateCode >= 0) {
            switch (updateCode) {
                case 80:
                    if (updateCode >= 0 && updateCode < 236) {
                        HandlerCanbus.update(updateCode, ints);
                    }
                    int value = DataCanbus.DATA[80];
                    if (value == 1 && !Air_Activity_All_NewAdd_HP.mIsFront) {
                        AirHelper.disableAirWindowLocal(true);
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.air.Air_Activity_All_NewAdd_HP");
                        break;
                    } else if (value == 0 && Air_Activity_All_NewAdd_HP.mIsFront && Air_Activity_All_NewAdd_HP.mInstance != null) {
                        Air_Activity_All_NewAdd_HP.mInstance.finish();
                        break;
                    }
                case 171:
                    warningVehicle(updateCode, ints);
                    break;
                case 172:
                    warningStartStop(updateCode, ints);
                    break;
                case 173:
                    convConsumer(updateCode, ints);
                    break;
                case 179:
                    if (strs != null && strs.length >= 1 && !ToolkitMisc.strEqual(ConstGolf.mCarId, strs[0])) {
                        ConstGolf.mCarId = strs[0];
                        DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                        break;
                    }
                case 191:
                    convDrivingMode(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 236) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void convDrivingMode(int updateCode, int[] ints) {
        if (updateCode == 191) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !Golf7_XP_FunctionalDrivingInfo1Acti.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7_xp.Golf7_XP_FunctionalDrivingInfo1Acti");
            }
            HandlerUI.getInstance().removeCallbacks(this.mDismissFunctionalDrivingInfo1);
            HandlerUI.getInstance().postDelayed(this.mDismissFunctionalDrivingInfo1, 100000L);
        }
    }

    private void convConsumer(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            ConstGolf.mConvConsumer[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void warningVehicle(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 16) {
            ConstGolf.mVehicleWarning[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }

    private void warningStartStop(int updateCode, int[] ints) {
        if (ints != null && ints.length >= 2 && ints[0] >= 0 && ints[0] < 7) {
            ConstGolf.mSartStop[ints[0]] = ints;
            DataCanbus.NOTIFY_EVENTS[updateCode].onNotify(ints, null, null);
        }
    }
}
