package com.lsec.core.ipc.module.main;

import android.os.RemoteException;
import android.os.SystemProperties;
import android.text.TextUtils;
import com.lsec.core.ipc.Conn;
import com.lsec.core.ipc.Conn_Base;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.UiNotifyEvent;
import com.lsec.core.util.UiNotifyEventString;
import com.lsec.core.util.data.FinalChip;
import com.lsec.core.util.share.ShareHandler;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;
import java.util.ArrayList;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Main extends IModuleCallback.Stub implements IConnStateListener {
    public static final int BACK_CAMERA_NOT_FOUND = 4;
    public static final int BACK_CVBS = 1;
    public static final int BACK_END = 3;
    public static final int BACK_NULL = 0;
    public static final int BACK_USB = 2;
    public static int[] DATA_RADAR = null;
    public static final int PlatForm_3188 = 2;
    public static final int PlatForm_6025 = 6;
    public static final int PlatForm_786 = 4;
    public static final int PlatForm_8700 = 3;
    public static final int PlatForm_9853 = 8;
    public static final int PlatForm_Monitor = 1;
    public static final int PlatForm_PX5 = 7;
    public static final int PlatForm_Sophia = 5;
    private static final int RADAR_CNT = 16;
    public static final int RADAR_MAX_NORMAL = 20;
    private static Runnable_REQEUST REQEUST_APP_ID;
    public static String factorySn;
    public static int mVideoChannelCurrent;
    public static int[] mcuError;
    public static boolean mcuMatchError;
    public static String naviPackageName;
    public static int sAppIdRequest;
    public static ArrayList<String> sArrayDebugBackCar;
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    public static boolean bConnected = false;
    private static Main INSTANCE = new Main();
    public static boolean bIsHiworldObdEnable = SystemProperties.getBoolean("sys.fyt.hiworld_obd_enable", false);
    public static int mConf_PlatForm = 2;
    public static final UiNotifyEventString VER_MCU = new UiNotifyEventString();
    public static final UiNotifyEventString VER_DVD = new UiNotifyEventString();
    public static final UiNotifyEventString VER_BT = new UiNotifyEventString();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[256];

    static {
        DATA[1] = 1;
        DATA_RADAR = new int[16];
        for (int i = 0; i < 16; i++) {
            DATA_RADAR[i] = 10;
        }
        naviPackageName = FinalChip.BSP_PLATFORM_Null;
        factorySn = FinalChip.BSP_PLATFORM_Null;
        mcuMatchError = false;
        REQEUST_APP_ID = null;
    }

    public static Main getInstance() {
        return INSTANCE;
    }

    private Main() {
    }

    public static void initPlatForm(String str) {
        if ("Monitor".equals(str)) {
            mConf_PlatForm = 1;
            return;
        }
        if ("3188".equals(str)) {
            mConf_PlatForm = 2;
            return;
        }
        if ("8700".equals(str)) {
            mConf_PlatForm = 3;
            return;
        }
        if ("786".equals(str)) {
            mConf_PlatForm = 4;
            return;
        }
        if ("Sophia".equals(str)) {
            mConf_PlatForm = 5;
            return;
        }
        if (FinalChip.BSP_PLATFORM_6025.equals(str)) {
            mConf_PlatForm = 6;
        } else if ("PX5".equals(str)) {
            mConf_PlatForm = 7;
        } else if ("9853".equals(str)) {
            mConf_PlatForm = 8;
        }
    }

    public static void resetRadar() {
        updateRadar(14, new int[]{20}, null, null);
        updateRadar(15, new int[]{20}, null, null);
        updateRadar(16, new int[]{20}, null, null);
        updateRadar(17, new int[]{20}, null, null);
        updateRadar(18, new int[]{20}, null, null);
        updateRadar(19, new int[]{20}, null, null);
        updateRadar(20, new int[]{20}, null, null);
        updateRadar(21, new int[]{20}, null, null);
        updateRadar(97, new int[]{20}, null, null);
        updateRadar(96, new int[]{20}, null, null);
        updateRadar(95, new int[]{20}, null, null);
        updateRadar(94, new int[]{20}, null, null);
        updateRadar(93, new int[]{20}, null, null);
        updateRadar(92, new int[]{20}, null, null);
        updateRadar(91, new int[]{20}, null, null);
        updateRadar(90, new int[]{20}, null, null);
    }

    public static void updateRadar(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1)) {
            DATA[updateCode] = ints[0];
            if (updateCode < 90) {
                if (DATA_RADAR[updateCode - 14] != ints[0]) {
                    DATA_RADAR[updateCode - 14] = ints[0];
                    mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                    return;
                }
                return;
            }
            if (updateCode <= 93) {
                if (DATA_RADAR[(updateCode + 12) - 90] != ints[0]) {
                    DATA_RADAR[(updateCode + 12) - 90] = ints[0];
                    mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                    return;
                }
                return;
            }
            if (updateCode <= 97 && DATA_RADAR[(updateCode + 4) - 90] != ints[0]) {
                DATA_RADAR[(updateCode + 4) - 90] = ints[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void updateSteerAngle(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && DATA[updateCode] != ints[0]) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void updateNaviName(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            naviPackageName = strs[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void updateMcuSerial(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            factorySn = strs[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1)) {
            switch (updateCode) {
                case 89:
                    if (IpcUtil.intsOk(ints, 2)) {
                        int val = ints[0] > 0 ? ints[1] : 2;
                        if (DATA[updateCode] != val) {
                            DATA[updateCode] = val;
                            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                        }
                    }
                    break;
                default:
                    if (DATA[updateCode] != ints[0]) {
                        DATA[updateCode] = ints[0];
                        mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                    }
                    break;
            }
        }
    }

    public static void updateDirect(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1)) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void requestAppId(int value) {
        sAppIdRequest = value;
        PROXY.cmd(0, value);
    }

    public static void requestAppIdByOnTop(int value) {
        if (Conn.mInterfaceApp == null || Conn.mInterfaceApp.isAppTop()) {
            requestAppId(value);
            if (REQEUST_APP_ID != null) {
                REQEUST_APP_ID.stop();
                REQEUST_APP_ID = null;
            }
            REQEUST_APP_ID = new Runnable_REQEUST();
            Conn_Base.handler.postDelayed(REQEUST_APP_ID, 300L);
        }
    }

    public static class Runnable_REQEUST implements Runnable {
        public boolean bRunning = true;

        public void stop() {
            this.bRunning = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            if ((Conn.mInterfaceApp == null || Conn.mInterfaceApp.isAppTop()) && Main.PROXY.getI(0, -100) != Main.sAppIdRequest) {
                Main.requestAppId(Main.sAppIdRequest);
                if (this.bRunning) {
                    Conn_Base.handler.postDelayed(this, 1000L);
                }
            }
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            VER_MCU.register(toolkit, 0, 34, 1);
            VER_DVD.register(toolkit, 3, 30, 1);
            VER_BT.register(toolkit, 2, 17, 1);
            PROXY.setRemoteModule(toolkit.getRemoteModule(0));
            IModuleCallback callback = getInstance();
            if (mRegisterCallBack != null) {
                mRegisterCallBack.register(callback);
            } else {
                for (int i = 0; i < 256; i++) {
                    PROXY.register(callback, i, 1);
                }
            }
            bConnected = true;
            if (Conn.mInterfaceApp != null) {
                Conn.mInterfaceApp.onConnected_Main();
                if (Conn.mInterfaceApp.isAppTop()) {
                    Conn.mInterfaceApp.requestAppIdRight();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onDisconnected() {
        PROXY.setRemoteModule(null);
    }

    public static boolean isAccOn() {
        return DATA[50] != 0;
    }

    public static int getBackCameraType() {
        String type = SystemProperties.get("ro.fyt.usbenable");
        return type.equals("1") ? 2 : 1;
    }

    public static int getBackCameraId(int idPlatForm) {
        return ShareHandler.is2009(idPlatForm) ? 1 : 0;
    }

    public static void postRunnable_Ui(boolean bRemoveOther, Runnable runnable, long delayMillis) {
        if (runnable != null) {
            if (bRemoveOther) {
                removeRunnable_Ui(runnable);
            }
            if (delayMillis == 0) {
                UiNotifyEvent.HANDLER_UI.post(runnable);
            } else {
                UiNotifyEvent.HANDLER_UI.postDelayed(runnable, delayMillis);
            }
        }
    }

    public static void postRunnable_Ui(boolean bRemoveOther, Runnable runnable) {
        if (runnable != null) {
            if (bRemoveOther) {
                removeRunnable_Ui(runnable);
            }
            UiNotifyEvent.HANDLER_UI.post(runnable);
        }
    }

    public static void removeRunnable_Ui(Runnable runnable) {
        if (runnable != null) {
            UiNotifyEvent.HANDLER_UI.removeCallbacks(runnable);
        }
    }

    private class Runnable_Update implements Runnable {
        public float[] flts;
        public int[] ints;
        public String[] strs;
        public int updateCode;

        public Runnable_Update(int updateCode, int[] ints, float[] flts, String[] strs) {
            this.updateCode = updateCode;
            this.ints = ints;
            this.flts = flts;
            this.strs = strs;
        }

        /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
        @Override // java.lang.Runnable
        public void run() {
            if (this.updateCode >= 0 && this.updateCode < 256) {
                switch (this.updateCode) {
                    case 68:
                        if (IpcUtil.intsOk(this.ints, 3)) {
                            int iLen = this.ints.length;
                            boolean bIsFixCamera = false;
                            for (int i = 2; i < iLen; i++) {
                                if (Conn.mInterfaceApp != null && Conn.mInterfaceApp.isFixVideoId(this.ints[i])) {
                                    bIsFixCamera = true;
                                    if (!bIsFixCamera) {
                                        return;
                                    }
                                }
                            }
                            if (!bIsFixCamera) {
                                return;
                            }
                        }
                        break;
                    case 69:
                    case 70:
                        if (IpcUtil.intsOk(this.ints, 2) && Conn.mInterfaceApp != null && !Conn.mInterfaceApp.isFixVideoId(this.ints[1])) {
                            return;
                        }
                        break;
                }
                switch (this.updateCode) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 12:
                    case 13:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 30:
                    case 36:
                    case 38:
                    case 50:
                    case 65:
                    case 81:
                    case 83:
                    case 88:
                    case 89:
                    case 99:
                    case 100:
                    case 134:
                    case 137:
                    case 139:
                        Main.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 14:
                    case 15:
                    case 16:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 90:
                    case 91:
                    case 92:
                    case 93:
                    case 94:
                    case 95:
                    case 96:
                    case 97:
                        if (IpcUtil.intsOk(this.ints, 1) && !Main.bIsHiworldObdEnable) {
                            Main.updateRadar(this.updateCode, this.ints, this.flts, this.strs);
                            break;
                        }
                        break;
                    case 28:
                        Main.updateNaviName(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 35:
                        Main.updateMcuSerial(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 41:
                        if (!Main.bIsHiworldObdEnable) {
                            Main.updateSteerAngle(this.updateCode, this.ints, this.flts, this.strs);
                        }
                        break;
                    case 45:
                        if (IpcUtil.intsOk(this.ints, 1)) {
                            switch (this.ints[0]) {
                                case 4:
                                    if (IpcUtil.strsOk(this.strs, 1) && !TextUtils.isEmpty(this.strs[0])) {
                                        if (Main.sArrayDebugBackCar == null) {
                                            Main.sArrayDebugBackCar = new ArrayList<>();
                                        }
                                        Main.sArrayDebugBackCar.add(this.strs[0]);
                                        Main.updateDirect(this.updateCode, this.ints, this.flts, this.strs);
                                        break;
                                    }
                                    break;
                                case 5:
                                    Main.updateDirect(this.updateCode, this.ints, this.flts, this.strs);
                                    break;
                                default:
                                    Main.updateDirect(this.updateCode, this.ints, this.flts, this.strs);
                                    break;
                            }
                        }
                        break;
                    case 46:
                        Main.mcuError = this.ints;
                        Main.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 68:
                        if (IpcUtil.intsOk(this.ints, 2)) {
                            switch (this.ints[1]) {
                                case 0:
                                    Main.mVideoChannelCurrent = -1;
                                    break;
                                case 1:
                                    Main.mVideoChannelCurrent = this.ints[0];
                                    break;
                            }
                            Main.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        }
                        break;
                    default:
                        if (IpcUtil.intsOk(this.ints, 1)) {
                            Main.DATA[this.updateCode] = this.ints[0];
                        }
                        Main.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                }
            }
        }
    }

    public static boolean hasCamera() {
        switch (mConf_PlatForm) {
            case 5:
            case 6:
            case 7:
            case 8:
                return true;
            default:
                return false;
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void setRegisterModuleCallBack(IRegisterModuleCallBack registerModuleCallBack) {
        mRegisterCallBack = registerModuleCallBack;
    }
}
