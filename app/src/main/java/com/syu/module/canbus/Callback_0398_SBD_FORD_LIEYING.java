package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.sbd.fordlieying.AirSBDFordLieYing;
import com.syu.carinfo.sbd.fordlieying.InfoSBDFordLieYing;
import com.syu.ipc.IModuleCallback;
import com.syu.module.IUiNotify;
import com.syu.ui.air.AirHelper;
import com.syu.util.HandlerUI;
import com.syu.util.ObjApp;

public class Callback_0398_SBD_FORD_LIEYING extends CallbackCanbusBase {
    public static final int AIR_CONTROL_CMD = 1;
    public static final int CAR_COMM_CONTROL = 2;
    public static final int SYS_START_VER = 0;
    public static final int U_CAR_JUMP_INFO = 119;
    public static final int U_CAR_TABLE_INT_1 = 101;
    public static final int U_CAR_TABLE_INT_2 = 102;
    public static final int U_CAR_TABLE_INT_3 = 103;
    public static final int U_CAR_TABLE_INT_INTER1_1 = 110;
    public static final int U_CAR_TABLE_INT_INTER1_2 = 111;
    public static final int U_CAR_TABLE_INT_INTER1_3 = 112;
    public static final int U_CAR_TABLE_INT_INTER2_1 = 113;
    public static final int U_CAR_TABLE_INT_INTER2_2 = 114;
    public static final int U_CAR_TABLE_INT_INTER2_3 = 115;
    public static final int U_CAR_TABLE_INT_INTER3_1 = 116;
    public static final int U_CAR_TABLE_INT_INTER3_2 = 117;
    public static final int U_CAR_TABLE_INT_INTER3_3 = 118;
    public static final int U_CAR_TABLE_INT_MAX_1 = 104;
    public static final int U_CAR_TABLE_INT_MAX_2 = 105;
    public static final int U_CAR_TABLE_INT_MAX_3 = 106;
    public static final int U_CAR_TABLE_INT_MIN_1 = 107;
    public static final int U_CAR_TABLE_INT_MIN_2 = 108;
    public static final int U_CAR_TABLE_INT_MIN_3 = 109;
    public static final int U_CAR_TABLE_STR_1 = 98;
    public static final int U_CAR_TABLE_STR_2 = 99;
    public static final int U_CAR_TABLE_STR_3 = 100;
    public static final int U_CNT_MAX = 120;
    public final IUiNotify SHOW_AIR_LIEYING = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        }
    };
    Runnable mDismissFunctionalDrivingInfo1 = new Runnable() { 
        @Override
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

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 120; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        //AirHelper.getInstance().buildUi(new Air_0398_SBD_FORD_LIEYING(LauncherApplication.getInstance()));
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].addNotify(this.SHOW_AIR_LIEYING);
        }
    }

    @Override
    public void out() {
        for (int i = 10; i < 97; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(this.SHOW_AIR_LIEYING);
        }
        AirHelper.getInstance().destroyUi();
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 98 && updateCode <= 100) {
            HandlerCanbus.update(updateCode, ints, flts, strs);
        }
        if (119 == updateCode) {
            convDrivingMode(updateCode, ints);
        } else if (updateCode >= 0 && updateCode < 120) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    private void convDrivingMode(int updateCode, int[] ints) {
        if (updateCode == 119) {
            HandlerCanbus.update(updateCode, ints);
            int value = ints[0];
            if (value == 1 && !AirSBDFordLieYing.mIsFront && !InfoSBDFordLieYing.mIsFront && !delay) {
                //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.sbd.fordlieying.AirSBDFordLieYing");
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
