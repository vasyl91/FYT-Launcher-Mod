package com.lsec.core.ipc.module.main;

import android.os.RemoteException;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.UiNotifyEvent;
import com.lsec.core.util.data.FinalCanbus;
import com.lsec.core.util.data.FinalChip;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Canbus extends IModuleCallback.Stub implements IConnStateListener {
    public static String Album = null;
    public static String Artist = null;
    public static final int CHANNEL_CNT_MAX = 6;
    public static int[] CHANNEL_FREQ_PRESET = null;
    public static String CarCdText = null;
    public static String CarFrameNum = null;
    public static String CarRadioText = null;
    public static String CdTextInfo = null;
    public static int CdTextType = 0;
    public static String CdUsbList = null;
    public static int CdUsbListType = 0;
    public static final boolean DEBUG_AIR = true;
    public static final boolean DEBUG_DOOR = true;
    public static int[] MCU_CANBUS_SUPPORT = null;
    public static final int MINUTEOILEXPENDMAX = 15;
    public static String MenuList = null;
    public static int MenuListType = 0;
    public static String Songname = null;
    public static String Str1 = null;
    public static String Str2 = null;
    public static String Str3 = null;
    public static String Str4 = null;
    public static String Str5 = null;
    public static String Str6 = null;
    public static final int TRIPOILEXPENDMAX = 5;
    public static String TelTextInfo;
    public static int TelTextType;
    public static String Title;
    public static String WifiName;
    public static String WifiPsword;
    public static String anjixingNumber;
    public static String btNumber;
    public static String btPassWord;
    public static String canVersion;
    public static int canbusId;
    public static int carId;
    public static String cdId3Album;
    public static String cdId3Artist;
    public static String cdId3Track;
    public static int cdid3charset;
    public static int cdid3type;
    public static String current_playtime;
    public static boolean delay;
    public static int[] freq;
    public static int id3infoflag;
    public static int infoIndex;
    public static int infoType;
    public static boolean jump;
    public static int[] mBlower_Time;
    public static int mCanbusLast;
    public static String mCarId;
    public static String mId3DiscName;
    public static String mId3Name;
    public static int mId3Type;
    public static String mIdArtist3Name;
    public static int[][] mMinuteoilexpend;
    public static int[] mTRACK_INFO;
    public static int[] mTRACK_TIME_INFO;
    public static int[][] mTripoilexpend;
    public static String onStarPhoneNumber;
    public static String onStarTTS;
    public static int sCanbusId;
    public static int sMcuCanbusSupportCnt;
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static Canbus INSTANCE = new Canbus();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[FinalCanbus.U_CNT_MAX];

    static {
        DATA[1001] = 1;
        DATA[1002] = 1;
        mCanbusLast = 0;
        MCU_CANBUS_SUPPORT = new int[1000];
        canVersion = FinalChip.BSP_PLATFORM_Null;
        CarFrameNum = FinalChip.BSP_PLATFORM_Null;
        CarCdText = FinalChip.BSP_PLATFORM_Null;
        CarRadioText = FinalChip.BSP_PLATFORM_Null;
        mCarId = null;
        mBlower_Time = new int[5];
        mTRACK_TIME_INFO = new int[2];
        mTRACK_INFO = new int[2];
        CHANNEL_FREQ_PRESET = new int[7];
        mTripoilexpend = new int[5][];
        mMinuteoilexpend = new int[15][];
        freq = new int[10];
        jump = false;
        delay = false;
    }

    public static Canbus getInstance() {
        return INSTANCE;
    }

    private Canbus() {
    }

    public static void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && DATA[updateCode] != ints[0]) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void mcuCanbusSupportCnt(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && sMcuCanbusSupportCnt != ints[0]) {
            if (ints[0] == 0) {
                sMcuCanbusSupportCnt = 0;
            }
            while (sMcuCanbusSupportCnt < ints[0]) {
                MCU_CANBUS_SUPPORT[sMcuCanbusSupportCnt] = PROXY.getI(1000, sMcuCanbusSupportCnt, -1);
                sMcuCanbusSupportCnt++;
                if (sMcuCanbusSupportCnt >= 1000) {
                    break;
                }
            }
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    @Override // com.syu.ipc.IModuleCallback
    public void update(int updateCode, int[] ints, float[] flts, String[] strs) throws RemoteException {
        Main.postRunnable_Ui(false, new Runnable_Update(updateCode, ints, flts, strs));
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onConnected(IRemoteToolkit toolkit) {
        try {
            PROXY.setRemoteModule(toolkit.getRemoteModule(7));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Canbus callback = getInstance();
        if (mRegisterCallBack != null) {
            mRegisterCallBack.register(callback);
            return;
        }
        for (int i = 1000; i < 1200; i++) {
            PROXY.register(callback, i, 1);
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onDisconnected() {
        PROXY.setRemoteModule(null);
        DATA[1000] = 0;
        mcuCanbusSupportCnt(1010, new int[1], null, null);
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

        @Override // java.lang.Runnable
        public void run() {
            if (this.updateCode >= 0 && this.updateCode < 1200) {
                switch (this.updateCode) {
                    case 67:
                    case 1000:
                    case 1001:
                    case 1002:
                    case 1003:
                    case 1009:
                    case 1013:
                    case FinalCanbus.U_RIGHT_CAMERA_ON_OFF /* 1017 */:
                    case FinalCanbus.U_RIGHT_CAMERA_STATE /* 1020 */:
                    case FinalCanbus.U_CANBUS_SLAVECAR_TOUCH_CALI /* 1025 */:
                    case FinalCanbus.U_CANBUS_SLAVECAR_BACKLIGHT /* 1026 */:
                        Canbus.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 1005:
                        if (IpcUtil.strsOk(this.strs, 1)) {
                            Canbus.canVersion = this.strs[0];
                            Canbus.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        }
                        break;
                    case 1010:
                        Canbus.mcuCanbusSupportCnt(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    default:
                        if (IpcUtil.intsOk(this.ints, 1)) {
                            Canbus.DATA[this.updateCode] = this.ints[0];
                        }
                        Canbus.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                }
            }
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void setRegisterModuleCallBack(IRegisterModuleCallBack registerModuleCallBack) {
        mRegisterCallBack = registerModuleCallBack;
    }
}
