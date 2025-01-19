package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.golf7.AirControlMQB_RZC_Front;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti;
import com.syu.carinfo.xp.xiandai.XiandaiSosPage;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
//import com.syu.ui.air.Air_0040_XP_MaiTeng17;
//import com.syu.ui.air.Air_0160_RZC_20TuGuanL;
//import com.syu.ui.air.Air_0160_RZC_DaZhong;
//import com.syu.ui.air.Air_0160_RZC_DaZhong_All;
//import com.syu.ui.air.Air_0160_RZC_TuGuanL;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitMisc;

public class Callback_0160_RZC_XP1_DaZhong_GaoErFu7 extends CallbackCanbusBase {
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
        for (int i = 0; i < 461; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 196768) {
            //AirHelper.getInstance().buildUi(new Air_0040_XP_MaiTeng17(LauncherApplication.getInstance()));
            for (int i2 = 10; i2 < 97; i2++) {
                DataCanbus.NOTIFY_EVENTS[i2].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else if (DataCanbus.DATA[1000] == 262304) {
            //AirHelper.getInstance().buildUi(new Air_0160_RZC_TuGuanL(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else if (DataCanbus.DATA[1000] == 721056 || DataCanbus.DATA[1000] == 1376416) {
            //AirHelper.getInstance().buildUi(new Air_0160_RZC_20TuGuanL(LauncherApplication.getInstance()));
            for (int i4 = 10; i4 < 97; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            DataCanbus.NOTIFY_EVENTS[358].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[359].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        } else if (DataCanbus.DATA[1000] == 458912 || DataCanbus.DATA[1000] == 524448) {
            //AirHelper.getInstance().buildUi(new Air_0160_RZC_DaZhong(LauncherApplication.getInstance()));
            for (int i5 = 10; i5 < 97; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        } else {
            //AirHelper.getInstance().buildUi(new Air_0160_RZC_DaZhong_All(LauncherApplication.getInstance()));
            for (int i6 = 10; i6 < 97; i6++) {
                DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            DataCanbus.NOTIFY_EVENTS[358].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DoorHelper.getInstance().buildUi();
        for (int i7 = 0; i7 < 6; i7++) {
            DataCanbus.NOTIFY_EVENTS[i7].addNotify(DoorHelper.getInstance(), 0);
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
        DataCanbus.NOTIFY_EVENTS[358].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 80:
                    HandlerCanbus.update(updateCode, ints);
                    int value = DataCanbus.DATA[80];
                    if (value == 1 && !AirControlMQB_RZC_Front.mIsFront) {
                        JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.AirControl_TuGuanL_RZC");
                        break;
                    } else if (value == 0 && AirControlMQB_RZC_Front.mIsFront && AirControlMQB_RZC_Front.mInstance != null) {
                        AirControlMQB_RZC_Front.mInstance.finish();
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
                case 460:
                    showSosPage(updateCode, ints);
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 461) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void showSosPage(int updateCode, int[] ints) {
        if (updateCode == 460) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0 && !XiandaiSosPage.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xp.xiandai.XiandaiSosPage");
            } else if (value == 0 && XiandaiSosPage.mIsFront && XiandaiSosPage.mInstance != null) {
                XiandaiSosPage.mInstance.finish();
            }
        }
    }

    private void convDrivingMode(int updateCode, int[] ints) {
        if (updateCode == 201) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value != 0) {
                if (!Golf7FunctionalDrivingInfo1Acti.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti");
                }
                HandlerUI.getInstance().removeCallbacks(this.mDismissFunctionalDrivingInfo1);
                HandlerUI.getInstance().postDelayed(this.mDismissFunctionalDrivingInfo1, 10000L);
            }
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
