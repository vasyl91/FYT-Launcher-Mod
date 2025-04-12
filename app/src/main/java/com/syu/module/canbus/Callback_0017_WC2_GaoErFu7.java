package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.canbus.JumpPage;
import com.syu.carinfo.golf7.AirControlMQB_WC_Front;
import com.syu.carinfo.golf7.AirControlMaiTengDZSJ;
import com.syu.carinfo.golf7.AirControl_DZSJ_ClearAir;
import com.syu.carinfo.golf7.AirControl_DZSJ_SeatHotBlow;
import com.syu.carinfo.golf7.ConstGolf;
import com.syu.carinfo.golf7.Golf7DashBoardVW_DZSJ;
import com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti;
import com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitMisc;

public class Callback_0017_WC2_GaoErFu7 extends CallbackCanbusBase {
    int carId = 0;
    Runnable mDismissDasBoardView = new Runnable() { 
        @Override
        public void run() {
            if (Golf7DashBoardVW_DZSJ.mIsFront && Golf7DashBoardVW_DZSJ.mInstance != null) {
                Golf7DashBoardVW_DZSJ.mInstance.finish();
            }
        }
    };
    Runnable mDismissAirSeatBlowHot = new Runnable() { 
        @Override
        public void run() {
            if (AirControl_DZSJ_SeatHotBlow.mIsFront && AirControl_DZSJ_SeatHotBlow.mInstance != null) {
                AirControl_DZSJ_SeatHotBlow.mInstance.finish();
            }
        }
    };
    Runnable mDismissFunctionalDrivingInfo1 = new Runnable() { 
        @Override
        public void run() {
            if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                if (Golf7FunctionalEscSystemActiVW_DZSJ.mIsFront && Golf7FunctionalEscSystemActiVW_DZSJ.mInstance != null) {
                    Golf7FunctionalEscSystemActiVW_DZSJ.mInstance.finish();
                    return;
                }
                return;
            }
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
        this.carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (this.carId != 6 && this.carId != 7 && this.carId != 8) {
            DoorHelper.getInstance().buildUi();
        }
        for (int i2 = 0; i2 < 6; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        if (this.carId == 0 || this.carId == 8) {
            //AirHelper.getInstance().buildUi(new Air_0017_WC2_Golf(LauncherApplication.getInstance()));
            for (int i3 = 10; i3 <= 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (this.carId == 3) {
            //AirHelper.getInstance().buildUi(new Air_0017_WC2_TuGuanL(LauncherApplication.getInstance()));
            for (int i4 = 10; i4 <= 97; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (this.carId == 4) {
            //AirHelper.getInstance().buildUi(new Air_0017_WC2_KeDiYaKe(LauncherApplication.getInstance()));
            for (int i5 = 10; i5 <= 97; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (this.carId == 5) {
            //AirHelper.getInstance().buildUi(new Air_0017_WC2_TuAng_Wc(LauncherApplication.getInstance()));
            for (int i6 = 10; i6 <= 97; i6++) {
                DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (this.carId != 6 && this.carId != 7) {
            if (this.carId == 9) {
                //AirHelper.getInstance().buildUi(new Air_0017_WC2_MQB_All(LauncherApplication.getInstance()));
                for (int i7 = 10; i7 <= 97; i7++) {
                    DataCanbus.NOTIFY_EVENTS[i7].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                return;
            }
            //AirHelper.getInstance().buildUi(new Air_0017_WC2_MaiTeng(LauncherApplication.getInstance()));
            for (int i8 = 10; i8 <= 97; i8++) {
                DataCanbus.NOTIFY_EVENTS[i8].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
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
                case 29:
                case 30:
                case 31:
                case 32:
                    if (this.carId == 6 || this.carId == 7) {
                        showCotrolAirSeat(updateCode, ints);
                        break;
                    } else {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                case 80:
                    showCotrolAir(updateCode, ints);
                    break;
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
                case 201:
                    convDrivingMode(updateCode, ints);
                    break;
                case 294:
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 461) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void showDashBoard(int updateCode, int[] ints) {
        if (updateCode == 294) {
            if ((DataCanbus.DATA[293] == 1 && (this.carId == 6 || this.carId == 7)) || this.carId == 8) {
                HandlerCanbus.update(updateCode, ints);
                int value = ints[0];
                if (value == 1 && !Golf7DashBoardVW_DZSJ.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.Golf7DashBoardVW_DZSJ");
                    HandlerUI.getInstance().removeCallbacks(this.mDismissDasBoardView);
                } else if (Golf7DashBoardVW_DZSJ.mIsFront && value == 0) {
                    HandlerUI.getInstance().removeCallbacks(this.mDismissDasBoardView);
                    HandlerUI.getInstance().postDelayed(this.mDismissDasBoardView, 3000L);
                }
            }
        }
    }

    private void showCotrolAir(int updateCode, int[] ints) {
        if (updateCode == 80) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (this.carId == 1) {
                if (value == 1 && !AirControlMQB_WC_Front.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.AirControlMaiTeng");
                    return;
                } else {
                    if (AirControlMQB_WC_Front.mIsFront && AirControlMQB_WC_Front.mInstance != null) {
                        AirControlMQB_WC_Front.mInstance.finish();
                        return;
                    }
                    return;
                }
            }
            if (this.carId == 6 || this.carId == 7) {
                if (value == 1 && !AirControlMaiTengDZSJ.mIsFront && !AirControl_DZSJ_ClearAir.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.AirControlMaiTengDZSJ");
                } else if (AirControlMaiTengDZSJ.mIsFront && AirControlMaiTengDZSJ.mInstance != null) {
                    AirControlMaiTengDZSJ.mInstance.finish();
                }
            }
        }
    }

    private void showCotrolAirSeat(int updateCode, int[] ints) {
        HandlerCanbus.update(updateCode, ints);
        int i = ints[0];
        if (this.carId == 6 || this.carId == 7) {
            if (!AirControl_DZSJ_SeatHotBlow.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.AirControl_DZSJ_SeatHotBlow");
            }
            HandlerUI.getInstance().removeCallbacks(this.mDismissAirSeatBlowHot);
            HandlerUI.getInstance().postDelayed(this.mDismissAirSeatBlowHot, 5000L);
        }
    }

    private void convDrivingMode(int updateCode, int[] ints) {
        if (updateCode == 201) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (DataCanbus.DATA[1000] == 393233 || DataCanbus.DATA[1000] == 458769) {
                if (value == 1 && !Golf7FunctionalEscSystemActiVW_DZSJ.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.Golf7FunctionalEscSystemActiVW_DZSJ");
                }
            } else if (value == 1 && !Golf7FunctionalDrivingInfo1Acti.mIsFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.golf7.Golf7FunctionalDrivingInfo1Acti");
            } else {
                boolean z = Golf7FunctionalDrivingInfo1Acti.mIsFront;
            }
            HandlerUI.getInstance().removeCallbacks(this.mDismissFunctionalDrivingInfo1);
            HandlerUI.getInstance().postDelayed(this.mDismissFunctionalDrivingInfo1, 6000L);
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
