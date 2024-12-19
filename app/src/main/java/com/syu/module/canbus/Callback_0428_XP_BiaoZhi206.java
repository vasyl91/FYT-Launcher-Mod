package com.syu.module.canbus;

import android.os.RemoteException;
import android.text.TextUtils;
import com.android.launcher66.LauncherApplication;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.door.DoorHelper;
import com.syu.util.HandlerUI;
import com.syu.util.ToastInfo;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0428_XP_BiaoZhi206 extends CallbackCanbusBase {
    public static final int U_AIR_AC = 14;
    public static final int U_AIR_AUTO = 11;
    public static final int U_AIR_BEGIN = 10;
    public static final int U_AIR_BLOW_AUTO_LEFT = 23;
    public static final int U_AIR_BLOW_BODY_LEFT = 16;
    public static final int U_AIR_BLOW_FOOT_LEFT = 17;
    public static final int U_AIR_BLOW_UP_LEFT = 18;
    public static final int U_AIR_CYCLE = 12;
    public static final int U_AIR_DUAL = 20;
    public static final int U_AIR_END = 24;
    public static final int U_AIR_FRONT_DEFROST = 13;
    public static final int U_AIR_POWER = 22;
    public static final int U_AIR_TEMP_LEFT = 15;
    public static final int U_AIR_TEMP_RIGHT = 21;
    public static final int U_AIR_WIND_LEVEL_LEFT = 19;
    public static final int U_AVERAGE_OIL_EXPEND = 30;
    public static final int U_AVERAGE_SPEED = 25;
    public static final int U_CARINFO = 31;
    public static final int U_CNT_MAX = 32;
    public static final int U_CUR_OIL_EXPEND = 29;
    public static final int U_CUR_SPEED = 7;
    public static final int U_DRIVING_MILEAGE = 27;
    public static final int U_ENGINE_SPEED = 8;
    public static final int U_TRIP_MILES = 28;
    private String str = "";
    private Runnable mRunn = new Runnable() { // from class: com.syu.module.canbus.Callback_0428_XP_BiaoZhi206.1
        @Override // java.lang.Runnable
        public void run() {
            if (!TextUtils.isEmpty(Callback_0428_XP_BiaoZhi206.this.str)) {
                ToastInfo.showToast(LauncherApplication.getInstance().getApplicationContext(), Callback_0428_XP_BiaoZhi206.this.str);
            }
        }
    };

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 32; i++) {
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

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 32) {
            HandlerCanbus.update(updateCode, ints);
            if (updateCode == 31) {
                if (DataCanbus.DATA[updateCode] == 1) {
                    DoorHelper.getInstance().showAndRefresh();
                } else {
                    showTips(DataCanbus.DATA[updateCode]);
                }
            }
        }
    }
}
