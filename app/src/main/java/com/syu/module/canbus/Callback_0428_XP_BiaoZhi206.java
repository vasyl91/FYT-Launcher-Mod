package com.syu.module.canbus;

import android.os.RemoteException;
import android.text.TextUtils;

import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;
import com.syu.util.ToastInfo;

public class Callback_0428_XP_BiaoZhi206 extends CallbackCanbusBase {
    public static final int U_AVERAGE_OIL_EXPEND = 103;
    public static final int U_AVERAGE_SPEED = 98;
    public static final int U_CARINFO = 104;
    public static final int U_CNT_MAX = 105;
    public static final int U_CUR_OIL_EXPEND = 102;
    public static final int U_DRIVING_MILEAGE = 100;
    public static final int U_TRIP_MILES = 101;
    private String str = "";
    private final Runnable mRunn = new Runnable() { 
        @Override
        public void run() {
            if (!TextUtils.isEmpty(Callback_0428_XP_BiaoZhi206.this.str)) {
                ToastInfo.showToast(LauncherApplication.getInstance().getApplicationContext(), Callback_0428_XP_BiaoZhi206.this.str);
            }
        }
    };

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 105; i++) {
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
    }

    public void showTips(int data) {
        this.str = "";
        switch (data) {
            case 40:
                this.str = "HANDBRAKE ON";
                break;
            case 41:
                this.str = "SEAT BELT REMINDER";
                break;
            case 53:
                this.str = "PUT AUTO.TRANSMISS.LEVER IN POSTION P";
                break;
            case 65:
                this.str = "ASP/ESR DISABLE";
                break;
            case 67:
                this.str = "DEADLOCKING ACTIVE";
                break;
            case 68:
                this.str = "AUTOMATICALLY LIGHTING ACTIVE";
                break;
            case 69:
                this.str = "AUTOMATICALLY WIPPING ACTIVE";
                break;
            case 75:
                this.str = "LPG DEFAULT";
                break;
            case 78:
                this.str = "FLH DIPPED HEADLIGHT BULB BLOWN";
                break;
        }
        HandlerUI.getInstance().post(this.mRunn);
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 105) {
            HandlerCanbus.update(updateCode, ints);
            if (updateCode == 104) {
                if (DataCanbus.DATA[updateCode] == 1) {
                    DoorHelper.getInstance().showAndRefresh();
                } else {
                    showTips(DataCanbus.DATA[updateCode]);
                }
            }
        }
    }
}
