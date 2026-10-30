package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.canbus.TheApp;
import com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar;
import com.syu.carinfo.ksw.audiq5.LZBmwCarinfoAct;
import com.syu.ipc.IModuleCallback;
import com.syu.ui.air.AirHelper;
import com.syu.ui.air.Air_0448_LZ_BMW;
import com.syu.ui.air.Air_0448_ZX_Ford_All;
import com.syu.ui.door.DoorHelper;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.canbus.apk\dexFile\classes.dex */
public class Callback_0448_LZ_BWM_CarUi extends CallbackCanbusBase {
    public static String CarBTInfo = null;
    public static final int U_CARBT_STATE = 135;
    public static final int U_CARBT_STRINFO = 136;
    public static final int U_CARSET_DA1_T27_D1_B70 = 140;
    public static final int U_CARSET_DA1_T28_D1_B70 = 141;
    public static final int U_CARSET_DA1_T29_D1_B70 = 142;
    public static final int U_CARSET_DA1_T2A_D1_B70 = 143;
    public static final int U_CAR_AUX_AUTO_HAND = 125;
    public static final int U_CAR_AUX_KEYNUM = 123;
    public static final int U_CAR_AUX_POSITION = 124;
    public static final int U_CAR_BACKCAR_DELAY = 128;
    public static final int U_CAR_BACKCAR_TYPE = 127;
    public static final int U_CAR_BACK_JUMP = 104;
    public static final int U_CAR_BELT = 116;
    public static final int U_CAR_CAM_STATE = 98;
    public static final int U_CAR_CARUI_STATE = 122;
    public static final int U_CAR_CAR_BT_TYPE = 126;
    public static final int U_CAR_CUR_SPEED = 106;
    public static final int U_CAR_D13_D7_B70 = 130;
    public static final int U_CAR_D13_D8_B70 = 131;
    public static final int U_CAR_DISTANCE_UNIT = 110;
    public static final int U_CAR_DRIVED_ENABLE = 105;
    public static final int U_CAR_EN_SPEED = 107;
    public static final int U_CAR_EVO_STATE = 121;
    public static final int U_CAR_GUIJI_STATE = 102;
    public static final int U_CAR_HANDBRAKE_STATE = 103;
    public static final int U_CAR_IDRIVE_STATE = 119;
    public static final int U_CAR_JUMPCARINFO = 129;
    public static final int U_CAR_LANG_STATE = 118;
    public static final int U_CAR_LVDS_MODE = 132;
    public static final int U_CAR_MIRROR_STATE = 99;
    public static final int U_CAR_OIL_REMAINED = 108;
    public static final int U_CAR_OUTSIDE_TEMP = 117;
    public static final int U_CAR_RADAR_STATE = 101;
    public static final int U_CAR_SCREEN_STATE = 120;
    public static final int U_CAR_SET_TYPE = 133;
    public static final int U_CAR_TEMP_UNIT = 109;
    public static final int U_CAR_TIRE_PRESSURE_FL = 112;
    public static final int U_CAR_TIRE_PRESSURE_FR = 113;
    public static final int U_CAR_TIRE_PRESSURE_RL = 114;
    public static final int U_CAR_TIRE_PRESSURE_RR = 115;
    public static final int U_CAR_TOTAL_MILE = 111;
    public static final int U_CAR_UI_STATE = 100;
    public static final int U_CAR_VOL_ANDROID_CTR = 138;
    public static final int U_CAR_VOL_SHOW = 139;
    public static final int U_CNT_MAX = 144;
    public static final int U_SHOW_AIRMODE = 134;
    public static int modevalue = -1;
    public static int CarUiState = 0;

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 144; i++) {
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
        if (DataCanbus.DATA[1000] == 65984 || DataCanbus.DATA[1000] == 262592 || DataCanbus.DATA[1000] == 197056 || DataCanbus.DATA[1000] == 131520 || DataCanbus.DATA[1000] == 590272 || DataCanbus.DATA[1000] == 328128 || DataCanbus.DATA[1000] == 393664 || DataCanbus.DATA[1000] == 721344 || DataCanbus.DATA[1000] == 459200 || DataCanbus.DATA[1000] == 524736 || DataCanbus.DATA[1000] == 1049024 || DataCanbus.DATA[1000] == 655808 || DataCanbus.DATA[1000] == 2228672 || DataCanbus.DATA[1000] == 786880 || DataCanbus.DATA[1000] == 1638848 || DataCanbus.DATA[1000] == 1507776) {
            AirHelper.getInstance().buildUi(new Air_0448_LZ_BMW(TheApp.getInstance()));
            for (int i3 = 10; i3 < 97; i3++) {
                DataCanbus.NOTIFY_EVENTS[i3].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
            return;
        }
        if (DataCanbus.DATA[1000] == 2163136) {
            AirHelper.getInstance().buildUi(new Air_0448_ZX_Ford_All(TheApp.getInstance()));
            for (int i4 = 10; i4 < 97; i4++) {
                DataCanbus.NOTIFY_EVENTS[i4].addNotify(AirHelper.SHOW_AND_REFRESH, 0);
            }
        }
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
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

    private void showDashBoard(int updateCode, int[] ints) {
        int value = ints[0];
        if (value == 1 && !KswAudiQ5Backcar.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ksw.audiq5.KswAudiQ5Backcar");
        } else if (KswAudiQ5Backcar.mIsFront && value == 0 && KswAudiQ5Backcar.mIsFront && KswAudiQ5Backcar.mInstance != null) {
            KswAudiQ5Backcar.mInstance.finish();
        }
    }

    private void showDashBoardYage10(int updateCode, int[] ints) {
        int value = ints[0];
        if (value == 1 && !LZBmwCarinfoAct.mIsFront) {
            JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.ksw.audiq5.LZBmwCarinfoAct");
        } else if (LZBmwCarinfoAct.mIsFront && value == 0 && LZBmwCarinfoAct.mIsFront && LZBmwCarinfoAct.mInstance != null) {
            LZBmwCarinfoAct.mInstance.finish();
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode >= 0 && updateCode < 144) {
            switch (updateCode) {
                case 104:
                    showDashBoard(updateCode, ints);
                    break;
                case 129:
                    showDashBoardYage10(updateCode, ints);
                    break;
                case 134:
                    CarUiState = ints[0];
                    DataCanbus.NOTIFY_EVENTS[updateCode].onNotify();
                    break;
                case 136:
                    if (strs != null && strs.length > 0) {
                        CarBTInfo = strs[0];
                    } else {
                        CarBTInfo = "";
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
