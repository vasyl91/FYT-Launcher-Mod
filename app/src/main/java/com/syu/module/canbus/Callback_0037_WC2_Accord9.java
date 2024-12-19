package com.syu.module.canbus;

import android.os.RemoteException;
import com.syu.canbus.JumpPage;
import com.syu.carinfo.accord9.wc.Accord9HBackCamera;
import com.syu.ipc.IModuleCallback;

/* loaded from: D:\APK\APKRepatcher\Projects\com.syu.canbus_1.0.apk\dexFile\classes.dex */
public class Callback_0037_WC2_Accord9 extends CallbackCanbusBase {
    public static final int BAND_AM_INDEX_BEGIN = 0;
    public static final int BAND_AM_INDEX_END = 65536;
    public static final int BAND_FM_INDEX_BEGIN = 65536;
    public static final int BAND_FM_INDEX_END = 131072;
    public static final int CHANNEL_AM_CNT_MAX = 6;
    public static final int CHANNEL_AM_INDEX_BEGIN = 0;
    public static final int CHANNEL_AM_INDEX_END = 65536;
    public static final int CHANNEL_FM_CNT_MAX = 12;
    public static final int CHANNEL_FM_INDEX_BEGIN = 65536;
    public static final int CHANNEL_FM_INDEX_END = 131072;
    public static final int U_CAR_CAMERA_MODE = 4;
    public static final int U_CAR_RIGHTCAMERA_STATE = 2;
    public static final int U_CAR_SCREEN_BRIGHTNESS_MODE = 1;
    public static final int U_CAR_SCREEN_COLOR = 3;
    public static final int U_CNT_MAX = 5;
    public static final int U_CURRENT_SPEED = 0;
    public static final int U_RADIO_AM_LIST_FREQ = 105;
    public static final int U_RADIO_AM_LIST_INFO = 106;
    public static final int U_RADIO_BAND = 100;
    public static final int U_RADIO_BEGIN = 100;
    public static final int U_RADIO_CHANNEL = 108;
    public static final int U_RADIO_CHANNEL_AMFREQ_PRESET = 101;
    public static final int U_RADIO_CHANNEL_AM_CNT = 110;
    public static final int U_RADIO_CHANNEL_FMFREQ_PRESET = 102;
    public static final int U_RADIO_CHANNEL_FM_CNT = 111;
    public static final int U_RADIO_FM_LIST_FREQ = 103;
    public static final int U_RADIO_FM_LIST_INFO = 104;
    public static final int U_RADIO_FREQ = 107;
    public static final int U_RADIO_LIGHT_ID = 112;
    public static final int U_RADIO_SEARCH_STATE = 109;
    public final int[] CHANNEL_FREQ_AM_PRESET = new int[6];
    public final int[] CHANNEL_FREQ_FM_PRESET = new int[12];
    public final int[] CHANNEL_FREQ_LIST_AM = new int[6];
    public final int[] CHANNEL_FREQ_LIST_FM = new int[12];
    public final int[] CHANNEL_AM_LIST_INFO = new int[6];
    public final int[] CHANNEL_FM_LIST_INFO = new int[12];

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void in() {
        IModuleCallback callback = ModuleCallbackCanbusProxy.getInstance();
        for (int i = 0; i < 5; i++) {
            DataCanbus.PROXY.register(callback, i, 1);
        }
        DataCanbus.PROXY.register(callback, FinalCanbus.U_ORI_CARBACK, 1);
    }

    @Override // com.syu.module.canbus.CallbackCanbusBase
    public void out() {
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        if (updateCode == 1021) {
            int value = ints[0];
            if (value == 1 && !Accord9HBackCamera.isFront) {
                JumpPage.startActivity("com.syu.canbus", "com.syu.carinfo.accord9.wc.Accord9HBackCamera");
                return;
            } else {
                if (value == 0 && Accord9HBackCamera.isFront && Accord9HBackCamera.mInstance != null) {
                    Accord9HBackCamera.mInstance.finish();
                    return;
                }
                return;
            }
        }
        if (updateCode >= 0 && updateCode < 5) {
            HandlerCanbus.update(updateCode, ints);
        }
    }
}
