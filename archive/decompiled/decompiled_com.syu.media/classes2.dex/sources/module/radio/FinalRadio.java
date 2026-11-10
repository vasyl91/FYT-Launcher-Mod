package module.radio;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class FinalRadio {
    public static final int AREA_CHINA = 2;
    public static final int AREA_EUROPE = 2;
    public static final int AREA_JAPAN = 4;
    public static final int AREA_LATIN = 1;
    public static final int AREA_OIRT = 3;
    public static final int AREA_USA = 0;
    public static final int BAND_AM_INDEX_BEGIN = 0;
    public static final int BAND_AM_INDEX_END = 65536;
    public static final int BAND_FM_INDEX_BEGIN = 65536;
    public static final int BAND_FM_INDEX_END = 131072;
    public static final int BAND_SWITCH_ALL = -1;
    public static final int BAND_SWITCH_AM = -2;
    public static final int BAND_SWITCH_FM = -3;
    public static final int BAND_SWITCH_FM_AND_AM = -4;
    public static final int CHANNEL_AM_INDEX_BEGIN = 0;
    public static final int CHANNEL_AM_INDEX_END = 65536;
    public static final int CHANNEL_FM_INDEX_BEGIN = 65536;
    public static final int CHANNEL_FM_INDEX_END = 131072;
    public static final int C_AIR_LINE = 24;
    public static final int C_AM1 = 30;
    public static final int C_AM2 = 31;
    public static final int C_AREA = 12;
    public static final int C_AUTO_SENSITY = 15;
    public static final int C_BAND = 11;
    public static final int C_FM1 = 27;
    public static final int C_FM2 = 28;
    public static final int C_FM3 = 29;
    public static final int C_FREQ = 13;
    public static final int C_FREQ_DOWN = 4;
    public static final int C_FREQ_UP = 3;
    public static final int C_LOC = 18;
    public static final int C_NEXT_CHANNEL = 0;
    public static final int C_POWER = 25;
    public static final int C_PREV_CHANNEL = 1;
    public static final int C_RADIO_INFO = 26;
    public static final int C_RADIO_RDA_TXT = 27;
    public static final int C_RDS_AF_ENABLE = 20;
    public static final int C_RDS_ENABLE = 16;
    public static final int C_RDS_PTY_ENABLE = 21;
    public static final int C_RDS_TA_ENABLE = 19;
    public static final int C_SAVE = 10;
    public static final int C_SAVE_CHANNEL = 8;
    public static final int C_SCAN = 9;
    public static final int C_SEARCH = 22;
    public static final int C_SEEK_DOWN = 6;
    public static final int C_SEEK_UP = 5;
    public static final int C_SELECT_CHANNEL = 7;
    public static final int C_SENSITY = 14;
    public static final int C_SORT_TYPE = 23;
    public static final int C_STERO = 17;
    public static final int FREQ_BY_RATIO = 2;
    public static final int FREQ_BY_STEP = 0;
    public static final int FREQ_DIRECT = 1;
    public static final int FREQ_DIRECT_NEW = 3;
    public static final int G_AREA = 2;
    public static final int G_BAND = 0;
    public static final int G_CHANNEL = 3;
    public static final int G_CHANNEL_FREQ = 4;
    public static final int G_FREQ = 1;
    public static final int G_PTY_ID = 5;
    public static final int MODULE_RADIO_ARM = 4;
    public static final int MODULE_RADIO_BY_MCU = 1;
    public static final int MODULE_RADIO_DAB = 2;
    public static final int MODULE_RADIO_INNER = 3;
    public static final int MODULE_RADIO_NULL = 0;
    public static final int SEARCH_STATE_AUTO = 1;
    public static final int SEARCH_STATE_BACK = 3;
    public static final int SEARCH_STATE_FORE = 2;
    public static final int SEARCH_STATE_NONE = 0;
    public static final String SERVICE_MS_ACTION = "com.syu.ms.radio";
    public static final int SORT_TYPE_BY_FREQ_LH = 1;
    public static final int SORT_TYPE_BY_SIGNAL_HL = 0;
    public static final int U_AIR_LINE = 25;
    public static final int U_AREA = 2;
    public static final int U_AUTO_SENSITY = 19;
    public static final int U_BAND = 0;
    public static final int U_CHANNEL = 3;
    public static final int U_CHANNEL_FREQ = 4;
    public static final int U_CNT_MAX = 100;
    public static final int U_EXTRA_FREQ_INFO = 16;
    public static final int U_FREQ = 1;
    public static final int U_INNER_CMD = 28;
    public static final int U_LOC = 23;
    public static final int U_POWER = 27;
    public static final int U_PS_TEXT = 26;
    public static final int U_PTY_ID = 5;
    public static final int U_RDS_AF_ENABLE = 6;
    public static final int U_RDS_CHANNEL_TEXT = 14;
    public static final int U_RDS_ENABLE = 15;
    public static final int U_RDS_PI_SEEK = 10;
    public static final int U_RDS_PTY_SEEK = 12;
    public static final int U_RDS_TA = 7;
    public static final int U_RDS_TA_ENABLE = 9;
    public static final int U_RDS_TA_SEEK = 11;
    public static final int U_RDS_TEXT = 13;
    public static final int U_RDS_TP = 8;
    public static final int U_SCAN = 20;
    public static final int U_SEARCH_STATE = 22;
    public static final int U_SENSITY_AM = 17;
    public static final int U_SENSITY_FM = 18;
    public static final int U_SORT_TYPE = 24;
    public static final int U_STEREO = 21;
    public static final int U_SUPPROT_AM = 29;

    public final class Options {
        public static final int BASE = 32;
        public static final int RADIO_MUTE = 32;
        public static final int RADIO_TO_OTHER = 33;
        public static final int RESET = 34;

        public Options(FinalRadio finalRadio) {
        }
    }

    public enum RadioStore {
        AREA;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static RadioStore[] valuesCustom() {
            RadioStore[] radioStoreArr = new RadioStore[1];
            System.arraycopy(values(), 0, radioStoreArr, 0, 1);
            return radioStoreArr;
        }
    }
}
