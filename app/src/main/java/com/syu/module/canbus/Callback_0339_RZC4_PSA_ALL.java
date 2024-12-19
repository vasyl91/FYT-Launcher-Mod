package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.psa_all.PSAOilMileIndexActi;
import com.syu.carinfo.rzc.addcan.ConstRzcAddData;
import com.syu.carinfo.rzc.biaozhi408.Const_RZC4_PSA_ALL_DATA;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0339_RZC4_PSA14_4008;
import com.syu.ui.air.Air_0339_RZC4_PSA_All;
import com.syu.ui.door.DoorHelper;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0339_RZC4_PSA_ALL extends CallbackCanbusBase {
    public static int mSum = -1;
    public static int mCurrPage = -1;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 226; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        for (int i2 = ConstRzcAddData.U_CAR_ADD_START; i2 < 560; i2++) {
            DataCanbus.PROXY.register(callback, i2, 1);
        }
        DoorHelper.sUcDoorEngine = 0;
        DoorHelper.sUcDoorFl = 1;
        DoorHelper.sUcDoorFr = 2;
        DoorHelper.sUcDoorRl = 3;
        DoorHelper.sUcDoorRr = 4;
        DoorHelper.sUcDoorBack = 5;
        if (DataCanbus.DATA[1000] == 65875) {
            AirHelper.getInstance().buildUi(new Air_0339_RZC4_PSA14_4008(LauncherApplication.getInstance()));
            DataCanbus.NOTIFY_EVENTS[54].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        } else {
            AirHelper.getInstance().buildUi(new Air_0339_RZC4_PSA_All(LauncherApplication.getInstance()));
        }
        DoorHelper.getInstance().buildUi();
        for (int i3 = 0; i3 < 6; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(DoorHelper.getInstance(), 0);
        }
        for (int i4 = 10; i4 < 85; i4++) {
            DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        }
        DataCanbus.NOTIFY_EVENTS[54].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[51].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[23].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[24].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[22].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
        DataCanbus.NOTIFY_EVENTS[50].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        for (int i2 = 10; i2 < 85; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[54].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[51].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[23].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[24].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[22].removeNotify(AirHelper.SHOW_AND_REFRESH);
        DataCanbus.NOTIFY_EVENTS[50].removeNotify(AirHelper.SHOW_AND_REFRESH);
        AirHelper.getInstance().destroyUi();
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 226) {
            if (updateCode == 104) {
                HandlerCanbus.update(updateCode, ints);
                int value = DataCanbus.DATA[104];
                if (value == 1 && !PSAOilMileIndexActi.mIsFront) {
                    JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.rzc.biaozhi408.RZC_BZ408OilMileIndexActi");
                } else if (value == 0 && PSAOilMileIndexActi.mIsFront && PSAOilMileIndexActi.mInstance != null) {
                    PSAOilMileIndexActi.mInstance.finish();
                }
            } else if (updateCode == 214) {
                if (strs != null && strs.length > 0) {
                    Const_RZC4_PSA_ALL_DATA.RadioText = strs[0];
                } else {
                    Const_RZC4_PSA_ALL_DATA.RadioText = "";
                }
                DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                HandlerCanbus.update(updateCode, ints);
            } else {
                HandlerCanbus.update(updateCode, ints);
            }
        }
        if (updateCode >= 500 && updateCode < 560) {
            switch (updateCode) {
                case ConstRzcAddData.U_CAR_FRAME_NUM /* 501 */:
                    if (strs != null && strs.length > 0) {
                        ConstRzcAddData.CarFrameNum = strs[0];
                    } else {
                        ConstRzcAddData.CarFrameNum = "";
                    }
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                default:
                    HandlerCanbus.update(updateCode, ints);
                    break;
            }
        }
    }
}
