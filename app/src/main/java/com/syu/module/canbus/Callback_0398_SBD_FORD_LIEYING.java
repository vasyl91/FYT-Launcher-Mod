package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.android.launcher66.LauncherApplication;
import com.syu.carinfo.sbd.fordlieying.AirSBDFordLieYing;
import com.syu.carinfo.sbd.fordlieying.InfoSBDFordLieYing;
import com.syu.ipc.IModuleCallback;
import com.syu.module.IUiNotify;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0398_SBD_FORD_LIEYING;
import com.syu.util.HandlerUI;
import com.syu.util.ObjApp;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0398_SBD_FORD_LIEYING extends CallbackCanbusBase {
    public static final int AIR_CONTROL_CMD = 1;
    public static final int CAR_COMM_CONTROL = 2;
    public static final int SYS_START_VER = 0;
    public static final int U_AIR_AC = 22;
    public static final int U_AIR_AC_MAX = 27;
    public static final int U_AIR_AUTO_MAX = 23;
    public static final int U_AIR_AUTO_MIN = 24;
    public static final int U_AIR_BEGIN = 21;
    public static final int U_AIR_BLOW_AUTO_LEFT = 30;
    public static final int U_AIR_BLOW_BODY_LEFT = 33;
    public static final int U_AIR_BLOW_FOOT_LEFT = 32;
    public static final int U_AIR_BLOW_WIN_LEFT = 31;
    public static final int U_AIR_CYCLE = 25;
    public static final int U_AIR_DUAL = 28;
    public static final int U_AIR_END = 38;
    public static final int U_AIR_FRONT_DEFROST = 29;
    public static final int U_AIR_POWER = 21;
    public static final int U_AIR_REAR_DEFROST = 26;
    public static final int U_AIR_REAR_LOCK = 37;
    public static final int U_AIR_TEMP_LEFT = 35;
    public static final int U_AIR_TEMP_RIGHT = 36;
    public static final int U_AIR_WIND_LEVEL_LEFT = 34;
    public static final int U_CAR_JUMP_INFO = 39;
    public static final int U_CAR_TABLE_INT_1 = 3;
    public static final int U_CAR_TABLE_INT_2 = 4;
    public static final int U_CAR_TABLE_INT_3 = 5;
    public static final int U_CAR_TABLE_INT_INTER1_1 = 12;
    public static final int U_CAR_TABLE_INT_INTER1_2 = 13;
    public static final int U_CAR_TABLE_INT_INTER1_3 = 14;
    public static final int U_CAR_TABLE_INT_INTER2_1 = 15;
    public static final int U_CAR_TABLE_INT_INTER2_2 = 16;
    public static final int U_CAR_TABLE_INT_INTER2_3 = 17;
    public static final int U_CAR_TABLE_INT_INTER3_1 = 18;
    public static final int U_CAR_TABLE_INT_INTER3_2 = 19;
    public static final int U_CAR_TABLE_INT_INTER3_3 = 20;
    public static final int U_CAR_TABLE_INT_MAX_1 = 6;
    public static final int U_CAR_TABLE_INT_MAX_2 = 7;
    public static final int U_CAR_TABLE_INT_MAX_3 = 8;
    public static final int U_CAR_TABLE_INT_MIN_1 = 9;
    public static final int U_CAR_TABLE_INT_MIN_2 = 10;
    public static final int U_CAR_TABLE_INT_MIN_3 = 11;
    public static final int U_CAR_TABLE_STR_1 = 0;
    public static final int U_CAR_TABLE_STR_2 = 1;
    public static final int U_CAR_TABLE_STR_3 = 2;
    public static final int U_CNT_MAX = 40;
    public final IUiNotify SHOW_AIR_LIEYING = new IUiNotify() { // from class: com.syu.module.canbus.Callback_0398_SBD_FORD_LIEYING.1
        @Override // com.syu.module.IUiNotify
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        }
    };
    Runnable mDismissFunctionalDrivingInfo1 = new Runnable() { // from class: com.syu.module.canbus.Callback_0398_SBD_FORD_LIEYING.2
        @Override // java.lang.Runnable
        public void run() {
            if (AirSBDFordLieYing.mIsFront && AirSBDFordLieYing.mInstance != null) {
                AirSBDFordLieYing.mInstance.finish();
                Callback_0398_SBD_FORD_LIEYING.jump = false;
            }
            ObjApp.getMsgView().msg2("jump2 " + Callback_0398_SBD_FORD_LIEYING.jump);
        }
    };
    public static boolean jump = false;
    public static boolean delay = false;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 40; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        AirHelper.getInstance().buildUi(new Air_0398_SBD_FORD_LIEYING(LauncherApplication.getInstance()));
        for (int i2 = 21; i2 < 38; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(this.SHOW_AIR_LIEYING);
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
        for (int i = 21; i < 38; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.SHOW_AIR_LIEYING);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode <= 2) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
        }
        if (39 == updateCode) {
            convDrivingMode(updateCode, ints);
        } else if (updateCode >= 0 && updateCode < 40) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    private void convDrivingMode(int updateCode, int[] ints) {
        if (updateCode == 39) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !AirSBDFordLieYing.mIsFront && !InfoSBDFordLieYing.mIsFront && !delay) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.sbd.fordlieying.AirSBDFordLieYing");
                jump = true;
            }
            ObjApp.getMsgView().msg2("jump1 " + jump);
            if (jump) {
                HandlerUI.getInstance().removeCallbacks(this.mDismissFunctionalDrivingInfo1);
                HandlerUI.getInstance().postDelayed(this.mDismissFunctionalDrivingInfo1, 3000L);
            }
        }
    }
}
