package module.bt;

import java.util.HashMap;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FinalBt {
    public static final int A2DP_STATE_CONNECTED = 2;
    public static final int A2DP_STATE_CONNECTING = 1;
    public static final int A2DP_STATE_DISCONNECTED = 0;
    public static final int A2DP_STATE_DISCONNECTING = 3;
    public static final int BROADCAST_CMD_NULL = 0;
    public static final int BROADCAST_CMD_PAGE_BTAV = 4;
    public static final int BROADCAST_CMD_PAGE_BTAV_FORCE = 5;
    public static final int BROADCAST_CMD_PAGE_DIAL_BY_KEY = 2;
    public static final int BROADCAST_CMD_PAGE_DIAL_BY_WORK = 3;
    public static final int BROADCAST_CMD_SHOW_PIP = 1;
    public static final String BROADCAST_MS_ACTION = "com.syu.ms.bt";
    public static final int BTAV_PLAY_STATE_PAUSE = 0;
    public static final int BTAV_PLAY_STATE_PLAY = 1;
    public static final String BUNDLE_KEY_CMD = "cmd";
    public static final int C_AUTOPICK = 28;
    public static final int C_BTAV_LINK_CUT = 31;
    public static final int C_BTAV_NEXT = 1;
    public static final int C_BTAV_PAUSE = 3;
    public static final int C_BTAV_PLAY = 27;
    public static final int C_BTAV_PLAYPAUSE = 2;
    public static final int C_BTAV_PREV = 0;
    public static final int C_BTAV_STOP = 4;
    public static final int C_BTRING_PERCENT = 30;
    public static final int C_BT_CURTALK_HANG = 34;
    public static final int C_BT_DEL_RECORD_ALL = 41;
    public static final int C_BT_DEL_RECORD_ONE = 40;
    public static final int C_BT_DEVICE_UPDATE_FILE = 38;
    public static final int C_BT_DIAL_RECORD = 35;
    public static final int C_BT_HANG_RECORD = 37;
    public static final int C_BT_HOLD = 32;
    public static final int C_BT_HOLD_HANG = 33;
    public static final int C_BT_POWER_ON = 29;
    public static final int C_BT_RING_RECORD = 36;
    public static final int C_CLEAR = 15;
    public static final int C_CONNECT_DEVICE = 24;
    public static final int C_CONNECT_OBD = 25;
    public static final int C_CONSOLIDATED_CALLS = 39;
    public static final int C_DIAL = 7;
    public static final int C_DISCOVER = 20;
    public static final int C_DOWNLOAD_BOOK = 26;
    public static final int C_HANG = 10;
    public static final int C_HANG_CLEAR_NUM = 16;
    public static final int C_HFP = 14;
    public static final int C_KEY = 6;
    public static final int C_LINK_CUT = 13;
    public static final int C_LOCAL_NAME = 19;
    public static final int C_MIC_LEVEL = 23;
    public static final int C_MIC_VOL = 22;
    public static final int C_NUMBER = 12;
    public static final int C_PICKUP = 9;
    public static final int C_PIN_CODE = 18;
    public static final int C_QUERY_PAIR = 5;
    public static final int C_REDIAL = 8;
    public static final int C_REJECT_RING = 11;
    public static final int C_RESET = 17;
    public static final int C_TEST = 21;
    public static final int KEY_DIAL = 0;
    public static final int KEY_HANG = 1;
    public static final int KEY_N0 = 2;
    public static final int KEY_N1 = 3;
    public static final int KEY_N2 = 4;
    public static final int KEY_N3 = 5;
    public static final int KEY_N4 = 6;
    public static final int KEY_N5 = 7;
    public static final int KEY_N6 = 8;
    public static final int KEY_N7 = 9;
    public static final int KEY_N8 = 10;
    public static final int KEY_N9 = 11;
    public static final int KEY_NJ = 14;
    public static final int KEY_NP = 12;
    public static final int KEY_NX = 13;
    public static final int MODULE_BT8700 = 2;
    public static final int MODULE_BT_SG9832 = 4;
    public static final int MODULE_BT_SOFIA = 3;
    public static final int MODULE_IVT = 5;
    public static final int MODULE_NULL = 0;
    public static final int MODULE_RDA = 1;
    public static final int PAGE_BOOK = 2;
    public static final int PAGE_DIAL = 1;
    public static final int PAGE_HISTORY = 4;
    public static final int PAGE_MUSIC = 5;
    public static final int PAGE_NULL = 0;
    public static final int PAGE_PAIR = 6;
    public static final int PAGE_SET = 3;
    public static final int PBAP_STATE_CONNECTED = 1;
    public static final int PBAP_STATE_DISCONNECTED = 0;
    public static final int PBAP_STATE_LOAD = 2;
    public static final int PHONE_STATE_CONNECTED = 2;
    public static final int PHONE_STATE_CONSOLIDATED = 7;
    public static final int PHONE_STATE_DIAL = 3;
    public static final int PHONE_STATE_DISCONNECTED = 0;
    public static final int PHONE_STATE_LINK = 1;
    public static final int PHONE_STATE_PAIR = 6;
    public static final int PHONE_STATE_RING = 4;
    public static final int PHONE_STATE_TALK = 5;
    public static final int RECORD_STATE_CONNECTED = 3;
    public static final int RECORD_STATE_LOAD = 4;
    public static final String SERVICE_MS_ACTION = "com.syu.ms.bt";
    public static final int U_A2DP_SINK_STATE = 34;
    public static final int U_AUTOPICK = 20;
    public static final int U_AUTOPICK_REMAIN = 21;
    public static final int U_AVRCP14_SUPPORT = 30;
    public static final int U_BOOK = 22;
    public static final int U_BTAV_GENRE = 27;
    public static final int U_BTAV_ID3_ALBUM = 26;
    public static final int U_BTAV_ID3_ARTIST = 1;
    public static final int U_BTAV_ID3_TITLE = 0;
    public static final int U_BTAV_PLAY_STATE = 13;
    public static final int U_BTAV_PLAY_TIME = 28;
    public static final int U_BTAV_PLAY_TRACK = 3;
    public static final int U_BTAV_TOTAL_TIME = 2;
    public static final int U_BTAV_TOTAL_TRACK = 4;
    public static final int U_BTRING_PERCENT = 33;
    public static final int U_BT_POWER_ON = 31;
    public static final int U_BT_VER = 17;
    public static final int U_CNT_MAX = 256;
    public static final int U_HANG_CLEAR_NUM = 10;
    public static final int U_HFP = 18;
    public static final int U_LOCAL_MAC_ADDR = 14;
    public static final int U_LOCAL_NAME = 15;
    public static final int U_MIC_LEVEL = 32;
    public static final int U_PAIR_LIST = 5;
    public static final int U_PAIR_RESULT = 25;
    public static final int U_PBAP_STATE = 29;
    public static final int U_PHONE_MAC_ADDR = 6;
    public static final int U_PHONE_NAME = 7;
    public static final int U_PHONE_NUMBER = 8;
    public static final int U_PHONE_STATE = 9;
    public static final int U_PHONE_TYPE = 23;
    public static final int U_PIN_CODE = 16;
    public static final int U_RECORD = 35;
    public static final int U_RESET = 19;
    public static final int U_RING_TIME = 11;
    public static final int U_SEARCH_LIST = 24;
    public static final int U_TALK_TIME = 12;
    public static final int U_UPDATE_PROGRESS = 36;

    public static class BluetoothConfig {
        public static final int ANDROID_COMMON = 0;
        public static final int CHENGQ_COMMON = 1;
        public static final int CHENGQ_PRO = 7;
        public static final int IVT = 2;
        public static final int WENQIANG_COMMON = 5;
        public static final int WENQIANG_LITE = 3;
        public static final int WENQIANG_PRO = 4;
        public static final int WENQIANG_PRO_LIT = 6;
        public static HashMap<String, BluetoothConfig> configs;

        static {
            HashMap<String, BluetoothConfig> map = new HashMap<>();
            configs = map;
            map.put("0", new BluetoothConfig(true, false, "0", ""));
        }

        public BluetoothConfig(boolean z, boolean z2, String str, String str2) {
        }
    }

    public static class Coding {
        public static final int AAC = 3;
        public static final int APTX = 5;
        public static final int APTXHD = 7;
        public static final int APTX_LL = 8;
        public static final int APTX_SPRINT = 6;
        public static final int FASTSTREAM = 4;
        public static final int INVALID = 0;
        public static final int MP3 = 2;
        public static final int SBC = 1;
    }

    public static class Mute {
        public static final int COMMON = 2;
        public static final int EXTERNAL_BLUETOOTH = 1;
        public static final int EXTERNAL_MIC = 4;
    }

    public final class Option {
        public static final int BLE_STEER_DEV_STATE = 58;
        public static final int BLUETOPTH_CODING = 47;
        public static final int BTAV_ABLUME_IMG = 51;
        public static final int CALLING_PIP_ENABLE = 55;
        public static final int C_BT_NUMBER_NAME = 53;
        public static final int C_BT_RECORD_5LIST = 52;
        public static final int MUTE_MIC = 42;
        public static final int ODB_DEV_CONNECTSTATE = 48;
        public static final int PHONE_BATTERY = 44;
        public static final int PHONE_MESSAGE = 50;
        public static final int PHONE_MESSAGE_HANDLE = 49;
        public static final int PHONE_OPERATOR = 46;
        public static final int PHONE_SIGNAL = 45;
        public static final int PHONE_VOICE = 43;
        public static final int STOP_DOWNLOAD_BOOK = 56;
        public static final int TERMINAL_CMD = 57;

        public Option(FinalBt finalBt) {
        }
    }
}
