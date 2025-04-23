package com.syu.module.canbus;

import android.os.RemoteException;

import com.syu.carinfo.xc.gongjue.XCTianLaiGjCdAct;
import com.syu.ipc.IModuleCallback;
import com.syu.module.IUiNotify;
import com.syu.ui.air.AirHelper;
import com.syu.ui.door.DoorHelper;

public class Callback_0452_XC_TianLai_GJ extends CallbackCanbusBase {
    public static final int C_AIRSET_CONTROL = 1;
    public static final int C_CARSET_CONTROL = 0;
    public static final int C_CD_CONTROL = 2;
    public static final int U_CAREQ_BAL = 111;
    public static final int U_CAREQ_BASS = 113;
    public static final int U_CAREQ_FAD = 112;
    public static final int U_CAREQ_MID = 114;
    public static final int U_CAREQ_TREB = 115;
    public static final int U_CAREQ_VOL = 110;
    public static final int U_CAR_BEGIN = 98;
    public static final int U_CAR_CD_BEGIN = 104;
    public static final int U_CAR_CD_END = 109;
    public static final int U_CAR_CD_PLAYSTATE = 105;
    public static final int U_CAR_CD_STATE = 104;
    public static final int U_CAR_CD_TIME_M = 107;
    public static final int U_CAR_CD_TIME_S = 108;
    public static final int U_CAR_CD_TRACK = 106;
    public static final int U_CAR_END = 103;
    public static final int U_CAR_HEADLIGHTS_OFF_DELAY = 102;
    public static final int U_CAR_HEADLIGHTS_SENSITIVITY = 99;
    public static final int U_CAR_INTELLIGENT_KEY_LOCK = 101;
    public static final int U_CAR_INTERIOR_Ill = 98;
    public static final int U_CAR_SPEED_SENS_WIPER_INTER = 100;
    public static final int U_CNT_MAX = 116;
    private final IUiNotify mNotifyCanbus = new IUiNotify() { 
        @Override
        public void onNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
            int val = DataCanbus.DATA[updateCode];
            switch (updateCode) {
                case 104:
                    Callback_0452_XC_TianLai_GJ.this.isCdVisible(val);
                    break;
            }
        }
    };

    @Override
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 116; i++) {
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
        //AirHelper.getInstance().buildUi(new Air_0452_XC_TianLai_GJ(LauncherApplication.getInstance()));
        for (int i3 = 10; i3 < 97; i3++) {
            DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH);
        }
        DataCanbus.NOTIFY_EVENTS[104].addNotify(this.mNotifyCanbus, 1);
    }

    @Override
    public void out() {
        for (int i = 0; i < 6; i++) {
            DataCanbus.NOTIFY_EVENTS[i].removeNotify(DoorHelper.getInstance());
        }
        DoorHelper.getInstance().destroyUi();
        for (int i2 = 10; i2 < 97; i2++) {
            DataCanbus.NOTIFY_EVENTS[i2].removeNotify(AirHelper.SHOW_AND_REFRESH);
        }
        AirHelper.getInstance().destroyUi();
        DataCanbus.NOTIFY_EVENTS[104].removeNotify(this.mNotifyCanbus);
    }

    @Override
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 116) {
            HandlerCanbus.update(updateCode, ints);
        }
    }

    
    public void isCdVisible(int val) {
        if (!XCTianLaiGjCdAct.mIsFront && val == 1) {
            //JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.xc.gongjue.XCTianLaiGjCdAct");
        } else if (XCTianLaiGjCdAct.mIsFront && val == 0) {
            XCTianLaiGjCdAct.mInstance.finish();
        }
    }
}
