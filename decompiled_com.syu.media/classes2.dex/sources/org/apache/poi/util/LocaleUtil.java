package org.apache.poi.util;

import java.nio.charset.Charset;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import module.canbus.FinalCanbus;
import org.apache.poi.hpsf.Variant;
import org.apache.poi.hssf.record.UnknownRecord;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public final class LocaleUtil {
    public static final TimeZone TIMEZONE_UTC = TimeZone.getTimeZone("UTC");
    public static final Charset CHARSET_1252 = Charset.forName("CP1252");
    private static final ThreadLocal<TimeZone> userTimeZone = new ThreadLocal<>();
    private static final ThreadLocal<Locale> userLocale = new ThreadLocal<>();

    public static String getLocaleFromLCID(int i) {
        int i2 = i & Variant.VT_ILLEGAL;
        if (i2 == 1) {
            return "ar";
        }
        if (i2 == 2) {
            return "bg";
        }
        if (i2 == 3) {
            return "ca";
        }
        if (i2 == 4) {
            return "zh-Hans";
        }
        if (i2 == 5) {
            return "cs";
        }
        if (i2 == 6) {
            return "da";
        }
        if (i2 == 7) {
            return "de";
        }
        if (i2 == 2051) {
            return "ca-ES-valencia";
        }
        if (i2 == 2052) {
            return "zh-CN";
        }
        if (i2 == 2057) {
            return "en-GB";
        }
        if (i2 == 2058) {
            return "es-MX";
        }
        if (i2 == 2064) {
            return "it-CH";
        }
        if (i2 == 2065) {
            return "ja-Ploc-JP";
        }
        switch (i2) {
            case 7:
                return "de";
            case 8:
                return "el";
            case 9:
                return "en";
            case 10:
                return "es";
            case 11:
                return "fi";
            case 12:
                return "fr";
            case 13:
                return "he";
            case 14:
                return "hu";
            case 15:
                return "is";
            case 16:
                return "it";
            case 17:
                return "ja";
            case 18:
                return "ko";
            case 19:
                return "nl";
            case 20:
                return "no";
            case 21:
                return "pl";
            case 22:
                return "pt";
            case 23:
                return "rm";
            case 24:
                return "ro";
            case 25:
                return "ru";
            case 26:
                return "bs, hr, or sr";
            case 27:
                return "sk";
            case 28:
                return "sq";
            case 29:
                return "sv";
            case 30:
                return "th";
            case 31:
                return "tr";
            case 32:
                return "ur";
            case 33:
                return "id";
            case 34:
                return "uk";
            case 35:
                return "be";
            case 36:
                return "sl";
            case 37:
                return "et";
            case 38:
                return "lv";
            case 39:
                return "lt";
            case 40:
                return "tg";
            case 41:
                return "fa";
            case 42:
                return "vi";
            case 43:
                return "hy";
            case 44:
                return "az";
            case 45:
                return "eu";
            case 46:
                return "dsb or hsb";
            case 47:
                return "mk";
            case 48:
                return "st";
            case 49:
                return "ts";
            case 50:
                return "tn";
            case 51:
                return "ve";
            case 52:
                return "xh";
            case 53:
                return "zu";
            case 54:
                return "af";
            case 55:
                return "ka";
            case 56:
                return "fo";
            case 57:
                return "hi";
            case 58:
                return "mt";
            case 59:
                return "se";
            case 60:
                return "ga";
            case 61:
                return "yi";
            case 62:
                return "ms";
            case 63:
                return "kk";
            case 64:
                return "ky";
            case 65:
                return "sw";
            case 66:
                return "tk";
            case 67:
                return "uz";
            case 68:
                return "tt";
            case 69:
                return "bn";
            case 70:
                return "pa";
            case 71:
                return "gu";
            case 72:
                return "or";
            case 73:
                return "ta";
            case 74:
                return "te";
            case 75:
                return "kn";
            case 76:
                return "ml";
            case 77:
                return "as";
            case 78:
                return "mr";
            case 79:
                return "sa";
            case 80:
                return "mn";
            case 81:
                return "bo";
            case 82:
                return "cy";
            case 83:
                return "km";
            case 84:
                return "lo";
            case 85:
                return "my";
            case 86:
                return "gl";
            case 87:
                return "kok";
            case 88:
                return "mni";
            case 89:
                return "sd";
            case 90:
                return "syr";
            case 91:
                return "si";
            case 92:
                return "chr";
            case 93:
                return "iu";
            case 94:
                return "am";
            case 95:
                return "tzm";
            case 96:
                return "ks";
            case 97:
                return "ne";
            case 98:
                return "fy";
            case 99:
                return "ps";
            case 100:
                return "fil";
            case 101:
                return "dv";
            case 102:
                return "bin";
            case 103:
                return "ff";
            case 104:
                return "ha";
            case 105:
                return "ibb";
            case 106:
                return "yo";
            case 107:
                return "quz";
            case 108:
                return "nso";
            case 109:
                return "ba";
            case 110:
                return "lb";
            case 111:
                return "kl";
            case 112:
                return "ig";
            case 113:
                return "kr";
            case 114:
                return "om";
            case 115:
                return "ti";
            case 116:
                return "gn";
            case 117:
                return "haw";
            case 118:
                return "la";
            case 119:
                return "so";
            case 120:
                return "ii";
            case 121:
                return "pap";
            case 122:
                return "arn";
            case 124:
                return "moh";
            case 126:
                return "br";
            case 140:
                return "prs";
            case 1148:
                return "moh-CA";
            case 1150:
                return "br-FR";
            case 1281:
                return "qps-ploc";
            case 1534:
                return "qps-ploca";
            case 2049:
                return "ar-IQ";
            case 2055:
                return "de-CH";
            case 2060:
                return "fr-BE";
            case 2067:
                return "nl-BE";
            case 2068:
                return "nn-NO";
            case 2070:
                return "pt-PT";
            case 2072:
                return "ro-MO";
            case 2073:
                return "ru-MO";
            case 2074:
                return "sr-Latn-CS";
            case 2077:
                return "sv-FI";
            case 2080:
                return "ur-IN";
            case 2092:
                return "az-Cyrl-AZ";
            case 2094:
                return "dsb-DE";
            case 2098:
                return "tn-BW";
            case 2107:
                return "se-SE";
            case 2108:
                return "ga-IE";
            case 2110:
                return "ms-BN";
            case 2115:
                return "uz-Cyrl-UZ";
            case 2117:
                return "bn-BD";
            case 2118:
                return "pa-Arab-PK";
            case 2121:
                return "ta-LK";
            case 2128:
                return "mn-Mong-CN";
            case 2129:
                return "bo-BT";
            case 2137:
                return "sd-Arab-PK";
            case 2141:
                return "iu-Latn-CA";
            case 2143:
                return "tzm-Latn-DZ";
            case 2144:
                return "ks-Deva";
            case 2145:
                return "ne-IN";
            case UnknownRecord.SHEETPROTECTION_0867 /* 2151 */:
                return "ff-Latn-SN";
            case 2155:
                return "quz-EC";
            case 2163:
                return "ti-ER";
            case 2559:
                return "qps-plocm";
            case 3073:
                return "ar-EG";
            case 3076:
                return "zh-HK";
            case 3079:
                return "de-AT";
            case 3081:
                return "en-AU";
            case 3082:
                return "es-ES";
            case 3084:
                return "fr-CA";
            case 3098:
                return "sr-Cyrl-CS";
            case 3131:
                return "se-FI";
            case 3167:
                return "tmz-MA";
            case 3179:
                return "quz-PE";
            case 4097:
                return "ar-LY";
            case 4100:
                return "zh-SG";
            case 4103:
                return "de-LU";
            case 4105:
                return "en-CA";
            case 4106:
                return "es-GT";
            case 4108:
                return "fr-CH";
            case 4122:
                return "hr-BA";
            case 4155:
                return "smj-NO";
            case 5121:
                return "ar-DZ";
            case 5124:
                return "zh-MO";
            case 5127:
                return "de-LI";
            case 5129:
                return "en-NZ";
            case 5130:
                return "es-CR";
            case 5132:
                return "fr-LU";
            case 5146:
                return "bs-Latn-BA";
            case 5179:
                return "smj-SE";
            case 6145:
                return "ar-MA";
            case 6153:
                return "en-IE";
            case 6154:
                return "es-PA";
            case 6156:
                return "fr-MC";
            case 6170:
                return "sr-Latn-BA";
            case 6203:
                return "sma-NO";
            case 7169:
                return "ar-TN";
            case 7177:
                return "en-ZA";
            case 7178:
                return "es-DO";
            case 7194:
                return "sr-Cyrl-BA";
            case 7227:
                return "sma-SE";
            case 8193:
                return "ar-OM";
            case 8201:
                return "en-JM";
            case 8202:
                return "es-VE";
            case 8204:
                return "fr-RE";
            case 8218:
                return "bs-Cyrl-BA";
            case 8251:
                return "sms-FI";
            case 9217:
                return "ar-YE";
            case 9225:
                return "en-029";
            case 9226:
                return "es-CO";
            case 9228:
                return "fr-CG";
            case 9242:
                return "sr-Latn-RS";
            case 9275:
                return "smn-FI";
            case 10241:
                return "ar-SY";
            case 10249:
                return "en-BZ";
            case 10250:
                return "es-PE";
            case 10252:
                return "fr-SN";
            case 10266:
                return "sr-Cyrl-RS";
            case 11265:
                return "ar-JO";
            case 11273:
                return "en-TT";
            case 11274:
                return "es-AR";
            case 11276:
                return "fr-CM";
            case 11290:
                return "sr-Latn-ME";
            case 12289:
                return "ar-LB";
            case 12297:
                return "en-ZW";
            case 12298:
                return "es-EC";
            case 12300:
                return "fr-CI";
            case 12314:
                return "sr-Cyrl-ME";
            case 13313:
                return "ar-KW";
            case 13321:
                return "en-PH";
            case 13322:
                return "es-CL";
            case 13324:
                return "fr-ML";
            case 14337:
                return "ar-AE";
            case 14345:
                return "en-ID";
            case 14346:
                return "es-UY";
            case 14348:
                return "fr-MA";
            case 15361:
                return "ar-BH";
            case 15369:
                return "en-HK";
            case 15370:
                return "es-PY";
            case 15372:
                return "fr-HT";
            case 16385:
                return "ar-QA";
            case 16393:
                return "en-IN";
            case 16394:
                return "es-BO";
            case 17409:
                return "ar-Ploc-SA";
            case 17417:
                return "en-MY";
            case 17418:
                return "es-SV";
            case 18433:
                return "ar-145";
            case 18441:
                return "en-SG";
            case 18442:
                return "es-HN";
            case 19465:
                return "en-AE";
            case 19466:
                return "es-NI";
            case 20489:
                return "en-BH";
            case 20490:
                return "es-PR";
            case 21513:
                return "en-EG";
            case 21514:
                return "es-US";
            case 22537:
                return "en-JO";
            case 23561:
                return "en-KW";
            case 24585:
                return "en-TR";
            case 25609:
                return "en-YE";
            case 25626:
                return "bs-Cyrl";
            case 26650:
                return "bs-Latn";
            case 27674:
                return "sr-Cyrl";
            case 28698:
                return "sr-Latn";
            case 28731:
                return "smn";
            case 29740:
                return "az-Cyrl";
            case 29755:
                return "sms";
            case 30724:
                return "zh";
            case 30740:
                return "nn";
            case 30746:
                return "bs";
            case 30764:
                return "az-Latn";
            case 30779:
                return "sma";
            case 30787:
                return "uz-Cyrl";
            case 30800:
                return "mn-Cyrl";
            case 30813:
                return "iu-Cans";
            case 31748:
                return "zh-Hant";
            case 31764:
                return "nb";
            case 31770:
                return "sr";
            case 31784:
                return "tg-Cyrl";
            case 31790:
                return "dsb";
            case 31803:
                return "smj";
            case 31811:
                return "uz-Latn";
            case 31814:
                return "pa-Arab";
            case 31824:
                return "mn-Mong";
            case 31833:
                return "sd-Arab";
            case 31836:
                return "chr-Cher";
            case 31837:
                return "iu-Latn";
            case 31839:
                return "tzm-Latn";
            case 31847:
                return "ff-Latn";
            case 31848:
                return "ha-Latn";
            case 31890:
                return "ku-Arab";
            default:
                switch (i2) {
                    case 128:
                        return "ug";
                    case 129:
                        return "mi";
                    case 130:
                        return "oc";
                    case 131:
                        return "co";
                    case 132:
                        return "gsw";
                    case 133:
                        return "sah";
                    case 134:
                        return "qut";
                    case 135:
                        return "rw";
                    case 136:
                        return "wo";
                    default:
                        switch (i2) {
                            case 145:
                                return "gd";
                            case 146:
                                return "ku";
                            case 147:
                                return "quc";
                            default:
                                switch (i2) {
                                    case FinalCanbus.U_CANBUS_SLAVECAR_TOUCH_CALI /* 1025 */:
                                        return "ar-SA";
                                    case FinalCanbus.U_CANBUS_SLAVECAR_BACKLIGHT /* 1026 */:
                                        return "bg-BG";
                                    case FinalCanbus.U_CANBUS_PM25_CAR_IN /* 1027 */:
                                        return "ca-ES";
                                    case FinalCanbus.U_CANBUS_PM25_CAR_OUT /* 1028 */:
                                        return "zh-TW";
                                    case 1029:
                                        return "cs-CZ";
                                    case 1030:
                                        return "da-DK";
                                    case 1031:
                                        return "de-DE";
                                    case 1032:
                                        return "el-GR";
                                    case 1033:
                                        return "en-US";
                                    case 1034:
                                        return "es-ES_tradnl";
                                    case 1035:
                                        return "fi-FI";
                                    case 1036:
                                        return "fr-FR";
                                    case 1037:
                                        return "he-IL";
                                    case 1038:
                                        return "hu-HU";
                                    case 1039:
                                        return "is-IS";
                                    case FinalCanbus.U_REAR_MOVE_TYPE /* 1040 */:
                                        return "it-IT";
                                    case FinalCanbus.U_NEW_AIREIXT_SP /* 1041 */:
                                        return "ja-JP";
                                    case FinalCanbus.U_CANBUS_BENZ_BUTTON /* 1042 */:
                                        return "ko-KR";
                                    case FinalCanbus.U_CANBUS_CAR_DOOR /* 1043 */:
                                        return "nl-NL";
                                    case FinalCanbus.U_CANBUS_CAR_AIR /* 1044 */:
                                        return "nb-NO";
                                    case FinalCanbus.U_BT_RECORD_5LIST /* 1045 */:
                                        return "pl-PL";
                                    case FinalCanbus.U_EXIST_SIDERADAR /* 1046 */:
                                        return "pt-BR";
                                    case FinalCanbus.U_JAHUAR_LZ_RADAR /* 1047 */:
                                        return "rm-CH";
                                    case FinalCanbus.U_TCROSS_ZH_BUTTON /* 1048 */:
                                        return "ro-RO";
                                    case FinalCanbus.U_6606_CARINF /* 1049 */:
                                        return "ru-RU";
                                    case 1050:
                                        return "hr-HR";
                                    case 1051:
                                        return "sk-SK";
                                    case 1052:
                                        return "sq-AL";
                                    case 1053:
                                        return "sv-SE";
                                    case 1054:
                                        return "th-TH";
                                    case 1055:
                                        return "tr-TR";
                                    case 1056:
                                        return "ur-PK";
                                    case 1057:
                                        return "id-ID";
                                    case 1058:
                                        return "uk-UA";
                                    case 1059:
                                        return "be-BY";
                                    case 1060:
                                        return "sl-SI";
                                    case 1061:
                                        return "et-EE";
                                    case 1062:
                                        return "lv-LV";
                                    case 1063:
                                        return "lt-LT";
                                    case 1064:
                                        return "tg-Cyrl-TJ";
                                    case 1065:
                                        return "fa-IR";
                                    case 1066:
                                        return "vi-VN";
                                    case 1067:
                                        return "hy-AM";
                                    case 1068:
                                        return "az-Latn-AZ";
                                    case 1069:
                                        return "eu-ES";
                                    case 1070:
                                        return "hsb-DE";
                                    case 1071:
                                        return "mk-MK";
                                    case 1072:
                                        return "st-ZA";
                                    case 1073:
                                        return "ts-ZA";
                                    case 1074:
                                        return "tn-ZA";
                                    case 1075:
                                        return "ve-ZA";
                                    case 1076:
                                        return "xh-ZA";
                                    case 1077:
                                        return "zu-ZA";
                                    case 1078:
                                        return "af-ZA";
                                    case 1079:
                                        return "ka-GE";
                                    case 1080:
                                        return "fo-FO";
                                    case 1081:
                                        return "hi-IN";
                                    case 1082:
                                        return "mt-MT";
                                    case 1083:
                                        return "se-NO";
                                    default:
                                        switch (i2) {
                                            case 1085:
                                                return "yi-Hebr";
                                            case 1086:
                                                return "ms-MY";
                                            case 1087:
                                                return "kk-KZ";
                                            case 1088:
                                                return "ky-KG";
                                            case 1089:
                                                return "sw-KE";
                                            case 1090:
                                                return "tk-TM";
                                            case 1091:
                                                return "uz-Latn-UZ";
                                            case 1092:
                                                return "tt-RU";
                                            case 1093:
                                                return "bn-IN";
                                            case 1094:
                                                return "pa-IN";
                                            case 1095:
                                                return "gu-IN";
                                            case 1096:
                                                return "or-IN";
                                            case 1097:
                                                return "ta-IN";
                                            case 1098:
                                                return "te-IN";
                                            case 1099:
                                                return "kn-IN";
                                            case 1100:
                                                return "ml-IN";
                                            case 1101:
                                                return "as-IN";
                                            case 1102:
                                                return "mr-IN";
                                            case 1103:
                                                return "sa-IN";
                                            case 1104:
                                                return "mn-MN";
                                            case 1105:
                                                return "bo-CN";
                                            case 1106:
                                                return "cy-GB";
                                            case 1107:
                                                return "km-KH";
                                            case 1108:
                                                return "lo-LA";
                                            case 1109:
                                                return "my-MM";
                                            case 1110:
                                                return "gl-ES";
                                            case 1111:
                                                return "kok-IN";
                                            case 1112:
                                                return "mni-IN";
                                            case 1113:
                                                return "sd-Deva-IN";
                                            case 1114:
                                                return "syr-SY";
                                            case 1115:
                                                return "si-LK";
                                            case 1116:
                                                return "chr-Cher-US";
                                            case 1117:
                                                return "iu-Cans-CA";
                                            case 1118:
                                                return "am-ET";
                                            case 1119:
                                                return "tzm-Arab-MA";
                                            case 1120:
                                                return "ks-Arab";
                                            case 1121:
                                                return "ne-NP";
                                            case 1122:
                                                return "fy-NL";
                                            case 1123:
                                                return "ps-AF";
                                            case 1124:
                                                return "fil-PH";
                                            case 1125:
                                                return "dv-MV";
                                            case 1126:
                                                return "bin-NG";
                                            case 1127:
                                                return "fuv-NG";
                                            case 1128:
                                                return "ha-Latn-NG";
                                            case 1129:
                                                return "ibb-NG";
                                            case 1130:
                                                return "yo-NG";
                                            case 1131:
                                                return "quz-BO";
                                            case 1132:
                                                return "nso-ZA";
                                            case 1133:
                                                return "ba-RU";
                                            case 1134:
                                                return "lb-LU";
                                            case 1135:
                                                return "kl-GL";
                                            case 1136:
                                                return "ig-NG";
                                            case 1137:
                                                return "kr-NG";
                                            case 1138:
                                                return "om-Ethi-ET";
                                            case 1139:
                                                return "ti-ET";
                                            case 1140:
                                                return "gn-PY";
                                            case 1141:
                                                return "haw-US";
                                            case 1142:
                                                return "la-Latn";
                                            case 1143:
                                                return "so-SO";
                                            case 1144:
                                                return "ii-CN";
                                            case 1145:
                                                return "pap-x029";
                                            case 1146:
                                                return "arn-CL";
                                            default:
                                                switch (i2) {
                                                    case 1152:
                                                        return "ug-CN";
                                                    case 1153:
                                                        return "mi-NZ";
                                                    case 1154:
                                                        return "oc-FR";
                                                    case 1155:
                                                        return "co-FR";
                                                    case 1156:
                                                        return "gsw-FR";
                                                    case 1157:
                                                        return "sah-RU";
                                                    case 1158:
                                                        return "qut-GT";
                                                    case 1159:
                                                        return "rw-RW";
                                                    case 1160:
                                                        return "wo-SN";
                                                    default:
                                                        switch (i2) {
                                                            case 1164:
                                                                return "prs-AF";
                                                            case 1165:
                                                                return "plt-MG";
                                                            case 1166:
                                                                return "zh-yue-HK";
                                                            case 1167:
                                                                return "tdd-Tale-CN";
                                                            case 1168:
                                                                return "khb-Talu-CN";
                                                            case 1169:
                                                                return "gd-GB";
                                                            case 1170:
                                                                return "ku-Arab-IQ";
                                                            case 1171:
                                                                return "quc-CO";
                                                            default:
                                                                return "invalid";
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    private LocaleUtil() {
    }

    public static void setUserTimeZone(TimeZone timeZone) {
        userTimeZone.set(timeZone);
    }

    public static TimeZone getUserTimeZone() {
        TimeZone timeZone = userTimeZone.get();
        return timeZone != null ? timeZone : TimeZone.getDefault();
    }

    public static void resetUserTimeZone() {
        userTimeZone.remove();
    }

    public static void setUserLocale(Locale locale) {
        userLocale.set(locale);
    }

    public static Locale getUserLocale() {
        Locale locale = userLocale.get();
        return locale != null ? locale : Locale.getDefault();
    }

    public static void resetUserLocale() {
        userLocale.remove();
    }

    public static Calendar getLocaleCalendar() {
        return getLocaleCalendar(getUserTimeZone());
    }

    public static Calendar getLocaleCalendar(int i, int i2, int i3) {
        return getLocaleCalendar(i, i2, i3, 0, 0, 0);
    }

    public static Calendar getLocaleCalendar(int i, int i2, int i3, int i4, int i5, int i6) {
        Calendar localeCalendar = getLocaleCalendar();
        localeCalendar.set(i, i2, i3, i4, i5, i6);
        localeCalendar.clear(14);
        return localeCalendar;
    }

    public static Calendar getLocaleCalendar(TimeZone timeZone) {
        return Calendar.getInstance(timeZone, getUserLocale());
    }
}
