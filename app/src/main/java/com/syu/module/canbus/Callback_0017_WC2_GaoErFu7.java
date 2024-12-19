package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
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
import com.syu.ui.air.Air_0017_WC2_Golf;
import com.syu.ui.air.Air_0017_WC2_KeDiYaKe;
import com.syu.ui.air.Air_0017_WC2_MQB_All;
import com.syu.ui.air.Air_0017_WC2_MaiTeng;
import com.syu.ui.air.Air_0017_WC2_TuAng_Wc;
import com.syu.ui.air.Air_0017_WC2_TuGuanL;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;
import com.syu.util.ToolkitMisc;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0017_WC2_GaoErFu7 extends CallbackCanbusBase {
    int carId;
    Runnable mDismissDasBoardView = new Runnable() { // from class: com.syu.module.canbus.Callback_0017_WC2_GaoErFu7.1
        @Override // java.lang.Runnable
        public void run() {
            if (Golf7DashBoardVW_DZSJ.mIsFront && Golf7DashBoardVW_DZSJ.mInstance != null) {
                Golf7DashBoardVW_DZSJ.mInstance.finish();
            }
        }
    };
    Runnable mDismissAirSeatBlowHot = new Runnable() { // from class: com.syu.module.canbus.Callback_0017_WC2_GaoErFu7.2
        @Override // java.lang.Runnable
        public void run() {
            if (AirControl_DZSJ_SeatHotBlow.mIsFront && AirControl_DZSJ_SeatHotBlow.mInstance != null) {
                AirControl_DZSJ_SeatHotBlow.mInstance.finish();
            }
        }
    };
    Runnable mDismissFunctionalDrivingInfo1 = new Runnable() { // from class: com.syu.module.canbus.Callback_0017_WC2_GaoErFu7.3
        @Override // java.lang.Runnable
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 470; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        this.carId = (DataCanbus.DATA[1000] >> 16) & 65535;
        DoorHelper.sUcDoorEngine = 109;
        DoorHelper.sUcDoorFl = 110;
        DoorHelper.sUcDoorFr = 111;
        DoorHelper.sUcDoorRl = 112;
        DoorHelper.sUcDoorRr = 113;
        DoorHelper.sUcDoorBack = 114;
        if (this.carId != 6 && this.carId != 7 && this.carId != 8) {
            DoorHelper.getInstance().buildUi();
        }
        for (int i2 = 109; i2 < 115; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(DoorHelper.getInstance(), 0);
        }
        if (this.carId == 0 || this.carId == 8) {
            AirHelper.getInstance().buildUi(new Air_0017_WC2_Golf(LauncherApplication.getInstance()));
            for (int i3 = 87; i3 < 108; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (this.carId == 3) {
            AirHelper.getInstance().buildUi(new Air_0017_WC2_TuGuanL(LauncherApplication.getInstance()));
            for (int i4 = 87; i4 < 108; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            DataCanbus.NOTIFY_EVENTS[190].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            return;
        }
        if (this.carId == 4) {
            AirHelper.getInstance().buildUi(new Air_0017_WC2_KeDiYaKe(LauncherApplication.getInstance()));
            for (int i5 = 87; i5 < 108; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            for (int i6 = 150; i6 <= 157; i6++) {
                DataCanbus.NOTIFY_EVENTS[i6].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            for (int i7 = 190; i7 <= 193; i7++) {
                DataCanbus.NOTIFY_EVENTS[i7].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (this.carId == 5) {
            AirHelper.getInstance().buildUi(new Air_0017_WC2_TuAng_Wc(LauncherApplication.getInstance()));
            for (int i8 = 87; i8 < 108; i8++) {
                DataCanbus.NOTIFY_EVENTS[i8].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            DataCanbus.NOTIFY_EVENTS[123].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[151].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[207].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[204].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[206].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[205].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            DataCanbus.NOTIFY_EVENTS[190].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            for (int i9 = 150; i9 <= 157; i9++) {
                DataCanbus.NOTIFY_EVENTS[i9].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (this.carId != 6 && this.carId != 7) {
            if (this.carId == 9) {
                AirHelper.getInstance().buildUi(new Air_0017_WC2_MQB_All(LauncherApplication.getInstance()));
                for (int i10 = 87; i10 < 108; i10++) {
                    DataCanbus.NOTIFY_EVENTS[i10].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                DataCanbus.NOTIFY_EVENTS[123].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[151].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[207].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[204].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[206].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[205].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[190].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[191].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[192].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[220].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[221].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[193].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[226].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                DataCanbus.NOTIFY_EVENTS[158].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                for (int i11 = 150; i11 <= 157; i11++) {
                    DataCanbus.NOTIFY_EVENTS[i11].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
                }
                return;
            }
            AirHelper.getInstance().buildUi(new Air_0017_WC2_MaiTeng(LauncherApplication.getInstance()));
            for (int i12 = 87; i12 < 108; i12++) {
                DataCanbus.NOTIFY_EVENTS[i12].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            for (int i13 = 150; i13 <= 157; i13++) {
                DataCanbus.NOTIFY_EVENTS[i13].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            DataCanbus.NOTIFY_EVENTS[155].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 109; i < 115; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 87; i2 < 108; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        if (this.carId == 1) {
            for (int i3 = 150; i3 <= 157; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
        } else if (this.carId == 3) {
            DataCanbus.NOTIFY_EVENTS[190].removeNotify(AirHelper.SHOW_AND_REFRESH);
        } else if (this.carId == 5) {
            DataCanbus.NOTIFY_EVENTS[123].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[151].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[207].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[152].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[204].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[206].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[205].removeNotify(AirHelper.SHOW_AND_REFRESH);
        } else if (this.carId == 9) {
            for (int i4 = 87; i4 < 108; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
            for (int i5 = 150; i5 <= 157; i5++) {
                DataCanbus.NOTIFY_EVENTS[i5].removeNotify(AirHelper.SHOW_AND_REFRESH);
            }
            DataCanbus.NOTIFY_EVENTS[123].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[151].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[207].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[204].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[206].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[205].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[190].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[191].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[192].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[220].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[221].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[193].removeNotify(AirHelper.SHOW_AND_REFRESH);
            DataCanbus.NOTIFY_EVENTS[226].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0) {
            switch (updateCode) {
                case 74:
                    warningVehicle(updateCode, ints);
                    break;
                case 75:
                    warningStartStop(updateCode, ints);
                    break;
                case 76:
                    convConsumer(updateCode, ints);
                    break;
                case 82:
                    if (strs != null && strs.length >= 1 && !ToolkitMisc.strEqual(ConstGolf.mCarId, strs[0])) {
                        ConstGolf.mCarId = strs[0];
                        DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                        break;
                    }
                case 92:
                case 93:
                case 191:
                case 192:
                    if (this.carId == 6 || this.carId == 7) {
                        showCotrolAirSeat(updateCode, ints);
                        break;
                    } else {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
                case 138:
                    convDrivingMode(updateCode, ints);
                    break;
                case 158:
                    showCotrolAir(updateCode, ints);
                    break;
                case 265:
                    break;
                default:
                    if (updateCode >= 0 && updateCode < 470) {
                        HandlerCanbus.update(updateCode, ints);
                        break;
                    }
            }
        }
    }

    private void showDashBoard(int updateCode, int[] ints) {
        if (updateCode == 265) {
            if ((DataCanbus.DATA[264] == 1 && (this.carId == 6 || this.carId == 7)) || this.carId == 8) {
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
        if (updateCode == 158) {
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
        if (updateCode == 138) {
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
