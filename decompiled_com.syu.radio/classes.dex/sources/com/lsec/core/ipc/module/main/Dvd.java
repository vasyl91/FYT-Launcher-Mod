package com.lsec.core.ipc.module.main;

import android.os.RemoteException;
import com.lsec.core.ipc.IConnStateListener;
import com.lsec.core.ipc.IRegisterModuleCallBack;
import com.lsec.core.ipc.ModuleProxy;
import com.lsec.core.util.InterfaceDvdConn;
import com.lsec.core.util.IpcUtil;
import com.lsec.core.util.TimeLock;
import com.lsec.core.util.UiNotifyEvent;
import com.lsec.core.util.data.FinalChip;
import com.syu.ipc.IModuleCallback;
import com.syu.ipc.IRemoteToolkit;
import java.util.Locale;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\com.syu.radio_1.0.apk\dexFile\classes.dex */
public class Dvd extends IModuleCallback.Stub implements IConnStateListener {
    public static final int Backward_1 = 2;
    public static final int Backward_2 = 4;
    public static final int Backward_3 = 8;
    public static final int Backward_4 = 16;
    public static final int Backward_5 = 32;
    public static final int CHANNEL_AUTOL = 7;
    public static final int CHANNEL_AUTOR = 8;
    public static final int CHANNEL_MONOL = 5;
    public static final int CHANNEL_MONOR = 6;
    public static final int CHANNEL_NULL = 0;
    public static final int CHANNEL_STEREO = 4;
    public static final int Forward_1 = 2;
    public static final int Forward_2 = 4;
    public static final int Forward_3 = 8;
    public static final int Forward_4 = 16;
    public static final int Forward_5 = 32;
    public static final int IDS_1 = 268;
    public static final int IDS_16_9 = 12;
    public static final int IDS_1_KID_SAFE = 40;
    public static final int IDS_2_G = 41;
    public static final int IDS_3D = 50;
    public static final int IDS_3_PG = 42;
    public static final int IDS_4_3_PAN_SCAN = 10;
    public static final int IDS_4_PG13 = 43;
    public static final int IDS_5_PG_R = 44;
    public static final int IDS_6_R = 45;
    public static final int IDS_7_NC_17 = 46;
    public static final int IDS_8_ADULT = 47;
    public static final int IDS_ACTION = 57;
    public static final int IDS_ADJUST = 16;
    public static final int IDS_AF = 266;
    public static final int IDS_AFMT_NOSUPPORT = 165;
    public static final int IDS_ALL = 109;
    public static final int IDS_ANGLE = 129;
    public static final int IDS_ARABIC = 204;
    public static final int IDS_ARENA = 53;
    public static final int IDS_AS = 256;
    public static final int IDS_ASPECT_RATIO = 9;
    public static final int IDS_AUDIO = 48;
    public static final int IDS_AUDIO_1 = 307;
    public static final int IDS_AUDIO_2 = 308;
    public static final int IDS_AUDIO_3 = 309;
    public static final int IDS_AUDIO_IN = 306;
    public static final int IDS_AUDIO_LANGUAGE = 28;
    public static final int IDS_AUDIO_OUT = 60;
    public static final int IDS_AUTO = 8;
    public static final int IDS_AUTO_ANSWER = 242;
    public static final int IDS_AUTO_CONNECT = 241;
    public static final int IDS_AUTO_L = 83;
    public static final int IDS_AUTO_R = 84;
    public static final int IDS_AUTO_SEEK = 263;
    public static final int IDS_AUXIN = 96;
    public static final int IDS_AV1 = 311;
    public static final int IDS_AV2 = 312;
    public static final int IDS_AV3 = 313;
    public static final int IDS_BACK = 131;
    public static final int IDS_BACKWARD = 142;
    public static final int IDS_BALITIC = 350;
    public static final int IDS_BASS_MODE_1 = 221;
    public static final int IDS_BASS_MODE_2 = 222;
    public static final int IDS_BLUETOOTH = 101;
    public static final int IDS_BRAZIL = 213;
    public static final int IDS_BRIGHTNESS = 17;
    public static final int IDS_BT_HFP_NOT_CONNECT = 337;
    public static final int IDS_BT_MUSIC = 100;
    public static final int IDS_BT_NOT_CONNECT = 336;
    public static final int IDS_BT_NOT_FIND_PBAP_PROFILE = 338;
    public static final int IDS_BT_PHONE = 99;
    public static final int IDS_BULGARIAN = 208;
    public static final int IDS_CAMERA = 94;
    public static final int IDS_CANCEL = 87;
    public static final int IDS_CARD = 91;
    public static final int IDS_CHANGE = 38;
    public static final int IDS_CHANGE_PASSWORD = 114;
    public static final int IDS_CHAPTER = 128;
    public static final int IDS_CHAPTER_TIME = 159;
    public static final int IDS_CHINESE = 3;
    public static final int IDS_CHURCH = 54;
    public static final int IDS_CLASSIC = 315;
    public static final int IDS_CLOSE = 137;
    public static final int IDS_CONCERT = 59;
    public static final int IDS_CONFIRM = 117;
    public static final int IDS_CONTRAST = 18;
    public static final int IDS_CROATIAN = 209;
    public static final int IDS_CSPK = 217;
    public static final int IDS_CZECH = 187;
    public static final int IDS_DANISH = 193;
    public static final int IDS_DEFAULT = 85;
    public static final int IDS_DELETE = 334;
    public static final int IDS_DEVICE_ERR = 274;
    public static final int IDS_DEVICE_LIST = 251;
    public static final int IDS_DIGITAL = 72;
    public static final int IDS_DIGITAL_AUDIO = 106;
    public static final int IDS_DIGITAL_OUTPUT = 107;
    public static final int IDS_DIMMER = 24;
    public static final int IDS_DIMMER_LEVEL = 25;
    public static final int IDS_DISC = 27;
    public static final int IDS_DISC_ERROR = 171;
    public static final int IDS_DISC_MENU = 111;
    public static final int IDS_DISC_NOSUPPORT = 172;
    public static final int IDS_DISC_TIME = 157;
    public static final int IDS_DIVX = 229;
    public static final int IDS_DIVX_1 = 278;
    public static final int IDS_DIVX_10 = 287;
    public static final int IDS_DIVX_11 = 288;
    public static final int IDS_DIVX_12 = 289;
    public static final int IDS_DIVX_13 = 290;
    public static final int IDS_DIVX_14 = 291;
    public static final int IDS_DIVX_15 = 292;
    public static final int IDS_DIVX_16 = 293;
    public static final int IDS_DIVX_17 = 294;
    public static final int IDS_DIVX_18 = 295;
    public static final int IDS_DIVX_19 = 296;
    public static final int IDS_DIVX_2 = 279;
    public static final int IDS_DIVX_20 = 297;
    public static final int IDS_DIVX_21 = 298;
    public static final int IDS_DIVX_22 = 299;
    public static final int IDS_DIVX_23 = 300;
    public static final int IDS_DIVX_24 = 301;
    public static final int IDS_DIVX_25 = 302;
    public static final int IDS_DIVX_26 = 303;
    public static final int IDS_DIVX_27 = 304;
    public static final int IDS_DIVX_28 = 305;
    public static final int IDS_DIVX_3 = 280;
    public static final int IDS_DIVX_4 = 281;
    public static final int IDS_DIVX_5 = 282;
    public static final int IDS_DIVX_6 = 283;
    public static final int IDS_DIVX_7 = 284;
    public static final int IDS_DIVX_8 = 285;
    public static final int IDS_DIVX_9 = 286;
    public static final int IDS_DIVX_SUBTITLE = 112;
    public static final int IDS_DIVX_VOD = 230;
    public static final int IDS_DONTPOWEROFF = 328;
    public static final int IDS_DOWNMIX = 65;
    public static final int IDS_DOWNMIX_STEREO = 67;
    public static final int IDS_DRAMA = 58;
    public static final int IDS_DTV = 333;
    public static final int IDS_DUAL_MONO = 77;
    public static final int IDS_DUAL_MONO_STEREO = 78;
    public static final int IDS_DUTCH = 191;
    public static final int IDS_DVBT = 95;
    public static final int IDS_DYNAMIC_COMPRESS = 73;
    public static final int IDS_ENGLISH = 2;
    public static final int IDS_ENTERKEYNUM = 331;
    public static final int IDS_EQ = 314;
    public static final int IDS_ERROR_PARENT = 170;
    public static final int IDS_ESTONIAN = 210;
    public static final int IDS_EXTEND_MODE = 276;
    public static final int IDS_FILE = 345;
    public static final int IDS_FILE_NAME = 161;
    public static final int IDS_FINNISH = 195;
    public static final int IDS_FMAM = 92;
    public static final int IDS_FOLDER = 125;
    public static final int IDS_FORWARD = 141;
    public static final int IDS_FRENCH = 30;
    public static final int IDS_FREQ = 228;
    public static final int IDS_FREQ_192 = 227;
    public static final int IDS_FREQ_48 = 225;
    public static final int IDS_FREQ_96 = 226;
    public static final int IDS_FSPK = 216;
    public static final int IDS_GERMAN = 34;
    public static final int IDS_GOTO = 272;
    public static final int IDS_GPS = 97;
    public static final int IDS_GREEK = 196;
    public static final int IDS_HALL = 52;
    public static final int IDS_HEBREW = 206;
    public static final int IDS_HEBREWNEW = 205;
    public static final int IDS_HINDI = 190;
    public static final int IDS_HUE = 19;
    public static final int IDS_HUNGARIAN = 188;
    public static final int IDS_ICELANDIC = 189;
    public static final int IDS_INDONESIAN = 202;
    public static final int IDS_INDONESIANNEW = 203;
    public static final int IDS_INITIALIZE = 154;
    public static final int IDS_INPUT_PINCODE = 259;
    public static final int IDS_INTRO = 270;
    public static final int IDS_INVALID = 143;
    public static final int IDS_IPOD = 93;
    public static final int IDS_IPODE_MODE = 275;
    public static final int IDS_ITALIAN = 200;
    public static final int IDS_JAPAN = 29;
    public static final int IDS_JAZZ = 317;
    public static final int IDS_KOREAN = 198;
    public static final int IDS_LATIN = 33;
    public static final int IDS_LATVIAN = 212;
    public static final int IDS_LETTER_BOX = 11;
    public static final int IDS_LINE_OUT = 75;
    public static final int IDS_LITHUANIAN = 211;
    public static final int IDS_LIVE = 322;
    public static final int IDS_LIVING_ROOM = 51;
    public static final int IDS_LOADING = 135;
    public static final int IDS_LOCAL = 255;
    public static final int IDS_LPCM_OUTPUT = 108;
    public static final int IDS_LT_RT = 66;
    public static final int IDS_MANUAL_SEEK = 264;
    public static final int IDS_MELAYU = 215;
    public static final int IDS_MENU = 126;
    public static final int IDS_MENU_LANGUAGE = 36;
    public static final int IDS_MICONOFF = 220;
    public static final int IDS_MONO_L = 79;
    public static final int IDS_MONO_LEFT = 147;
    public static final int IDS_MONO_MIX = 81;
    public static final int IDS_MONO_R = 80;
    public static final int IDS_MONO_RIGHT = 148;
    public static final int IDS_MOVIE_MODE = 55;
    public static final int IDS_MUSIC = 103;
    public static final int IDS_MUTE = 179;
    public static final int IDS_NEW_PASSWORD = 116;
    public static final int IDS_NEW_VERSION = 325;
    public static final int IDS_NEXT = 144;
    public static final int IDS_NO = 89;
    public static final int IDS_NOAUDIO = 163;
    public static final int IDS_NOCONNECTED = 253;
    public static final int IDS_NODISC = 134;
    public static final int IDS_NORWEGIAN = 197;
    public static final int IDS_NOSIGNAL = 258;
    public static final int IDS_NOSUPPORT_FILE = 173;
    public static final int IDS_NOVIEO = 164;
    public static final int IDS_NO_SUB = 176;
    public static final int IDS_NTSC = 5;
    public static final int IDS_OFF = 15;
    public static final int IDS_OK = 86;
    public static final int IDS_OLD_PASSWORD = 115;
    public static final int IDS_OLD_VERSION = 324;
    public static final int IDS_ON = 14;
    public static final int IDS_ON_PHONE = 260;
    public static final int IDS_OPEN = 136;
    public static final int IDS_OP_MODE = 74;
    public static final int IDS_OSD_LANGUAGE = 1;
    public static final int IDS_OTHER = 178;
    public static final int IDS_PAL = 6;
    public static final int IDS_PAL60 = 7;
    public static final int IDS_PANEL = 23;
    public static final int IDS_PANEL_ADJUST = 26;
    public static final int IDS_PASSIVE = 320;
    public static final int IDS_PASSWORD = 37;
    public static final int IDS_PAUSE = 140;
    public static final int IDS_PBC = 346;
    public static final int IDS_PBC_OFF = 151;
    public static final int IDS_PBC_OFF_ONLY = 152;
    public static final int IDS_PBC_ON = 149;
    public static final int IDS_PBC_ON_ONLY = 150;
    public static final int IDS_PCM_ONLY = 110;
    public static final int IDS_PHONE = 250;
    public static final int IDS_PHONENUMBERS = 252;
    public static final int IDS_PHOTO = 104;
    public static final int IDS_PIC_ANTICLOCKWIZE = 183;
    public static final int IDS_PIC_CLOCKWIZE = 182;
    public static final int IDS_PIC_LEFTRIGHT = 181;
    public static final int IDS_PIC_UPDOWN = 180;
    public static final int IDS_PIN_CODE = 249;
    public static final int IDS_PLAY = 138;
    public static final int IDS_PLAYING = 139;
    public static final int IDS_PLAY_EFFECT = 339;
    public static final int IDS_PL_MOVIE = 223;
    public static final int IDS_PL_MUSIC = 224;
    public static final int IDS_POLISH = 186;
    public static final int IDS_POP = 318;
    public static final int IDS_PORTUGUESE = 32;
    public static final int IDS_PREV = 145;
    public static final int IDS_PRE_STOP = 162;
    public static final int IDS_PROGRESSIVE = 13;
    public static final int IDS_PROLOGIC = 219;
    public static final int IDS_RADIO = 254;
    public static final int IDS_RANDOM = 271;
    public static final int IDS_RATING = 39;
    public static final int IDS_RDS = 265;
    public static final int IDS_RECORD = 335;
    public static final int IDS_REPAB_INVALID = 123;
    public static final int IDS_REPEAT = 118;
    public static final int IDS_REPEAT_A = 121;
    public static final int IDS_REPEAT_AB = 122;
    public static final int IDS_REP_CANCEL = 119;
    public static final int IDS_RESUME = 156;
    public static final int IDS_RETURN = 130;
    public static final int IDS_RETURN_MENU = 348;
    public static final int IDS_RETURN_TITLE = 347;
    public static final int IDS_RF_REMOD = 76;
    public static final int IDS_RING_CAR_TONE = 245;
    public static final int IDS_RING_PHONE = 246;
    public static final int IDS_RING_SILENT = 247;
    public static final int IDS_RING_TONE = 244;
    public static final int IDS_RING_VOLUME = 248;
    public static final int IDS_ROCK = 316;
    public static final int IDS_ROMANIAN = 207;
    public static final int IDS_ROOT_MENU = 153;
    public static final int IDS_RPAB_CANCEL = 120;
    public static final int IDS_RUSSIAN = 201;
    public static final int IDS_SATURATION = 20;
    public static final int IDS_SCI_FI = 56;
    public static final int IDS_SEEK_MODE = 262;
    public static final int IDS_SELECTCPRMKEYNUM = 330;
    public static final int IDS_SETUP = 102;
    public static final int IDS_SHARPNESS = 21;
    public static final int IDS_SHUFFLE = 269;
    public static final int IDS_SIMPLEREMOTE = 277;
    public static final int IDS_SLOVENIAN = 214;
    public static final int IDS_SMS_NOTIFY = 243;
    public static final int IDS_SOUND = 319;
    public static final int IDS_SOUND_MODE = 49;
    public static final int IDS_SPANISH = 31;
    public static final int IDS_SPDIF_OFF = 61;
    public static final int IDS_SPDIF_PCM = 63;
    public static final int IDS_SPDIF_RAW = 62;
    public static final int IDS_SPEAKER = 64;
    public static final int IDS_SSPK = 218;
    public static final int IDS_STANDARD = 113;
    public static final int IDS_STARTUPGRADE = 327;
    public static final int IDS_STEREO = 82;
    public static final int IDS_SUBTITLE_LANGUAGE = 35;
    public static final int IDS_SUBWOOFER = 69;
    public static final int IDS_SUBWOOFER_OFF = 71;
    public static final int IDS_SUBWOOFER_ON = 70;
    public static final int IDS_SUB_OFF = 174;
    public static final int IDS_SUB_ON = 175;
    public static final int IDS_SUB_UNSUPPORT = 177;
    public static final int IDS_SUPERMENU = 273;
    public static final int IDS_SWEDISH = 194;
    public static final int IDS_SYSTEM = 0;
    public static final int IDS_TA = 267;
    public static final int IDS_TCHINESE = 349;
    public static final int IDS_THAI = 199;
    public static final int IDS_TIME = 344;
    public static final int IDS_TITLE = 127;
    public static final int IDS_TITLE_TIME = 158;
    public static final int IDS_TOTAL = 146;
    public static final int IDS_TOTALCPRMKEYNUM = 329;
    public static final int IDS_TOUCH_SET_FAIL = 133;
    public static final int IDS_TOUCH_SET_OK = 132;
    public static final int IDS_TRACK = 124;
    public static final int IDS_TRACK_TIME = 160;
    public static final int IDS_TURKISH = 192;
    public static final int IDS_TV_SYSTEM = 4;
    public static final int IDS_UNSUPPORTED = 155;
    public static final int IDS_UPGRADE = 323;
    public static final int IDS_USB = 90;
    public static final int IDS_VCOMVAL = 22;
    public static final int IDS_VFMT_NOSUPPORT = 166;
    public static final int IDS_VFRMRATE_NOSUPPORT = 167;
    public static final int IDS_VIDEO = 105;
    public static final int IDS_VIDEO_IN = 310;
    public static final int IDS_VIETNAM = 351;
    public static final int IDS_VMCD = 98;
    public static final int IDS_VMCD_BACK = 236;
    public static final int IDS_VMCD_DELETE = 234;
    public static final int IDS_VMCD_DELETE_DIALOG = 231;
    public static final int IDS_VMCD_ENCOCE = 233;
    public static final int IDS_VMCD_HOME = 235;
    public static final int IDS_VMCD_REP_1 = 238;
    public static final int IDS_VMCD_REP_ALL = 239;
    public static final int IDS_VMCD_REP_OFF = 237;
    public static final int IDS_VMCD_STOP = 240;
    public static final int IDS_VMCD_STOP_DIALOG = 232;
    public static final int IDS_VRES_NOSUPPORT = 168;
    public static final int IDS_VS = 257;
    public static final int IDS_VSURROUND = 68;
    public static final int IDS_WAIT4SERVICEINFO = 261;
    public static final int IDS_WANTTOUPGRADE = 326;
    public static final int IDS_WIDE = 321;
    public static final int IDS_WIPE_BOTTOM = 341;
    public static final int IDS_WIPE_LEFT = 342;
    public static final int IDS_WIPE_RIGHT = 343;
    public static final int IDS_WIPE_TOP = 340;
    public static final int IDS_WRITTINGFLASH = 332;
    public static final int IDS_WRONG_REGION = 169;
    public static final int IDS_YES = 88;
    public static final int IDS_ZOOM = 184;
    public static final int IDS_ZOOMOFF = 185;
    public static final int INTRO_OFF = 0;
    public static final int INTRO_ON = 1;
    public static TimeLock LOCK_PLAY_TIME = null;
    public static final int RANDOM_OFF = 0;
    public static final int RANDOM_ON = 1;
    public static final int REPEAT_ALLDISC = 20;
    public static final int REPEAT_DIRECTORY = 2;
    public static final int REPEAT_DISC = 3;
    public static final int REPEAT_DVDDISC = 4;
    public static final int REPEAT_IDLE = 0;
    public static final int REPEAT_IDLE2 = 16;
    public static final int REPEAT_NULL = 18;
    public static final int REPEAT_ONE = 17;
    public static final int REPEAT_TITLE = 19;
    public static final int REPEAT_TRACK = 1;
    public static final int VOCAL_CANCEL = 1;
    public static final int VOCAL_CANCEL_AUTO = 2;
    public static final int VOCAL_MIX_MONO = 3;
    public static final int Zoom_1 = 2;
    public static final int Zoom_2 = 3;
    public static final int Zoom_3 = 4;
    public static final int Zoom_4 = 5;
    public static final int Zoom_5 = 6;
    public static final int Zoom_6 = 7;
    public static final int Zoom_7 = 8;
    public static final int Zoom_Null = 255;
    public static boolean isLoadError;
    public static boolean isShowOsdInfo;
    public static InterfaceDvdConn mInterfaceDvdConn;
    public static int mOsdInfo;
    public static int mOsdShowTime;
    public static int mOsdSubTitleType;
    public static int mOsdType;
    public static String mStrOsdInfo;
    public static int sAudioFileCnt;
    public static int sAudioFolderCnt;
    public static int sDvdModule;
    public static boolean sEnterListManual;
    public static String sId3Album;
    public static String sId3Artist;
    public static String sId3Title;
    public static boolean sLockPlayTime;
    public static int sPhotoFileCnt;
    public static int sPhotoFolderCnt;
    public static String sTrackTitle;
    public static int sVideoFileCnt;
    public static int sVideoFolderCnt;
    public static IRegisterModuleCallBack mRegisterCallBack = null;
    private static Dvd INSTANCE = new Dvd();
    public static UiNotifyEvent mUiNotifyEvent = new UiNotifyEvent();
    public static ModuleProxy PROXY = new ModuleProxy();
    public static int[] DATA = new int[50];

    static {
        DATA[20] = 1;
        isShowOsdInfo = true;
        LOCK_PLAY_TIME = new TimeLock();
        isLoadError = false;
        mInterfaceDvdConn = null;
    }

    public static Dvd getInstance() {
        return INSTANCE;
    }

    private Dvd() {
    }

    public static String updateOsdInfos(int[] intData) {
        if (mInterfaceDvdConn == null) {
            return FinalChip.BSP_PLATFORM_Null;
        }
        String str = mInterfaceDvdConn.updateOsdInfo_Dvd(intData);
        return str;
    }

    public static String updateAngle(int subtitleType, int osdInfo) {
        String str = String.format(Locale.US, "Angle:%d/%d", Integer.valueOf(subtitleType), Integer.valueOf(osdInfo));
        return str;
    }

    public static boolean isModule8288() {
        return Main.mConf_PlatForm != 8 && sDvdModule == 1;
    }

    public static boolean isPlaying() {
        return DATA[31] == 1;
    }

    public static boolean hasDEVICE() {
        return PROXY.getI(6, 0) != 0;
    }

    public static boolean hasDVD() {
        return PROXY.getI(8, 0) != 0;
    }

    public static boolean hasSD() {
        return PROXY.getI(9, 0) != 0;
    }

    public static boolean hasUSB() {
        return PROXY.getI(10, 0) != 0;
    }

    public boolean isMediaTypeAudio() {
        return DATA[18] == 1;
    }

    public boolean isMediaTypePhoto() {
        return DATA[18] == 2;
    }

    public boolean isMediaTypeVideo() {
        return DATA[18] == 3;
    }

    public static void updateNotify(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1)) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void deviceOnDvd(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && DATA[updateCode] != ints[0]) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void UpdateRandom(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && DATA[updateCode] != ints[0]) {
            DATA[updateCode] = ints[0];
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void trackTitle(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                if (sTrackTitle != null) {
                    sTrackTitle = strs[0];
                    mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                    return;
                }
                return;
            }
            if (!strs[0].equals(sTrackTitle)) {
                sTrackTitle = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void id3Title(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                if (sId3Title != null) {
                    sId3Title = strs[0];
                    mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                    return;
                }
                return;
            }
            if (!strs[0].equals(sId3Title)) {
                sId3Title = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void id3Artist(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                if (sId3Artist != null) {
                    sId3Artist = strs[0];
                    mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                    return;
                }
                return;
            }
            if (!strs[0].equals(sId3Artist)) {
                sId3Artist = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void id3Album(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.strsOk(strs, 1)) {
            if (strs[0] == null) {
                if (sId3Album != null) {
                    sId3Album = strs[0];
                    mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
                    return;
                }
                return;
            }
            if (!strs[0].equals(sId3Album)) {
                sId3Album = strs[0];
                mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
            }
        }
    }

    public static void OsdInfo(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 4)) {
            mStrOsdInfo = updateOsdInfos(ints);
            mUiNotifyEvent.updateNotify(updateCode, ints, flts, strs);
        }
    }

    public static void touchState(int updateCode, int[] ints, float[] flts, String[] strs) {
        if (IpcUtil.intsOk(ints, 1) && DATA[updateCode] != ints[0]) {
            DATA[updateCode] = ints[0];
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
            PROXY.setRemoteModule(toolkit.getRemoteModule(3));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Dvd callback = getInstance();
        if (mRegisterCallBack != null) {
            mRegisterCallBack.register(callback);
            return;
        }
        for (int i = 0; i < 50; i++) {
            PROXY.register(callback, i, 1);
        }
    }

    @Override // com.lsec.core.ipc.IConnStateListener
    public void onDisconnected() {
        PROXY.setRemoteModule(null);
        sEnterListManual = false;
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
            if (this.updateCode >= 0 && this.updateCode < 50) {
                switch (this.updateCode) {
                    case 0:
                        Dvd.id3Title(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 1:
                        Dvd.id3Artist(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 2:
                        Dvd.id3Album(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                    case 15:
                    case 17:
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 26:
                    case 27:
                    case 28:
                    case 31:
                    case 32:
                    case 36:
                    case 38:
                        Dvd.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 9:
                    case 10:
                    case 11:
                    case 25:
                    case 30:
                    case 37:
                    default:
                        if (IpcUtil.intsOk(this.ints, 1)) {
                            Dvd.DATA[this.updateCode] = this.ints[0];
                        }
                        Dvd.mUiNotifyEvent.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 12:
                        if (!Dvd.sLockPlayTime && Dvd.LOCK_PLAY_TIME.unlock(1000)) {
                            Dvd.updateNotify(this.updateCode, this.ints, this.flts, this.strs);
                            break;
                        }
                        break;
                    case 16:
                        Dvd.trackTitle(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 24:
                        if (IpcUtil.intsOk(this.ints, 1)) {
                            Dvd.sDvdModule = this.ints[0];
                            if (this.ints[0] == 1) {
                                Dvd.isShowOsdInfo = true;
                            } else {
                                Dvd.isShowOsdInfo = false;
                            }
                        }
                        break;
                    case 29:
                        Dvd.deviceOnDvd(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 33:
                        Dvd.OsdInfo(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 34:
                        Dvd.UpdateRandom(this.updateCode, this.ints, this.flts, this.strs);
                        break;
                    case 35:
                        Dvd.touchState(this.updateCode, this.ints, this.flts, this.strs);
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
