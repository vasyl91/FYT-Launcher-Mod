package org.apache.poi.util;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Set;
import org.apache.commons.codec.CharEncoding;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public class CodePageUtil {
    public static final int CP_037 = 37;
    public static final int CP_EUC_JP = 51932;
    public static final int CP_EUC_KR = 51949;
    public static final int CP_GB18030 = 54936;
    public static final int CP_GB2312 = 52936;
    public static final int CP_GBK = 936;
    public static final int CP_ISO_2022_JP1 = 50220;
    public static final int CP_ISO_2022_JP2 = 50221;
    public static final int CP_ISO_2022_JP3 = 50222;
    public static final int CP_ISO_2022_KR = 50225;
    public static final int CP_ISO_8859_1 = 28591;
    public static final int CP_ISO_8859_2 = 28592;
    public static final int CP_ISO_8859_3 = 28593;
    public static final int CP_ISO_8859_4 = 28594;
    public static final int CP_ISO_8859_5 = 28595;
    public static final int CP_ISO_8859_6 = 28596;
    public static final int CP_ISO_8859_7 = 28597;
    public static final int CP_ISO_8859_8 = 28598;
    public static final int CP_ISO_8859_9 = 28599;
    public static final int CP_JOHAB = 1361;
    public static final int CP_KOI8_R = 20866;
    public static final int CP_MAC_ARABIC = 10004;
    public static final int CP_MAC_CENTRAL_EUROPE = 10029;
    public static final int CP_MAC_CHINESE_SIMPLE = 10008;
    public static final int CP_MAC_CHINESE_TRADITIONAL = 10002;
    public static final int CP_MAC_CROATIAN = 10082;
    public static final int CP_MAC_CYRILLIC = 10007;
    public static final int CP_MAC_GREEK = 10006;
    public static final int CP_MAC_HEBREW = 10005;
    public static final int CP_MAC_ICELAND = 10079;
    public static final int CP_MAC_JAPAN = 10001;
    public static final int CP_MAC_KOREAN = 10003;
    public static final int CP_MAC_ROMAN = 10000;
    public static final int CP_MAC_ROMANIA = 10010;
    public static final int CP_MAC_ROMAN_BIFF23 = 32768;
    public static final int CP_MAC_THAI = 10021;
    public static final int CP_MAC_TURKISH = 10081;
    public static final int CP_MAC_UKRAINE = 10017;
    public static final int CP_MS949 = 949;
    public static final int CP_SJIS = 932;
    public static final int CP_UNICODE = 1200;
    public static final int CP_US_ACSII = 20127;
    public static final int CP_US_ASCII2 = 65000;
    public static final int CP_UTF16 = 1200;
    public static final int CP_UTF16_BE = 1201;
    public static final int CP_UTF8 = 65001;
    public static final int CP_WINDOWS_1250 = 1250;
    public static final int CP_WINDOWS_1251 = 1251;
    public static final int CP_WINDOWS_1252 = 1252;
    public static final int CP_WINDOWS_1252_BIFF23 = 32769;
    public static final int CP_WINDOWS_1253 = 1253;
    public static final int CP_WINDOWS_1254 = 1254;
    public static final int CP_WINDOWS_1255 = 1255;
    public static final int CP_WINDOWS_1256 = 1256;
    public static final int CP_WINDOWS_1257 = 1257;
    public static final int CP_WINDOWS_1258 = 1258;
    public static final Set<Charset> DOUBLE_BYTE_CHARSETS = Collections.singleton(StringUtil.BIG5);

    public static byte[] getBytesInCodePage(String str, int i) throws UnsupportedEncodingException {
        return str.getBytes(codepageToEncoding(i));
    }

    public static String getStringFromCodePage(byte[] bArr, int i) throws UnsupportedEncodingException {
        return getStringFromCodePage(bArr, 0, bArr.length, i);
    }

    public static String getStringFromCodePage(byte[] bArr, int i, int i2, int i3) throws UnsupportedEncodingException {
        return new String(bArr, i, i2, codepageToEncoding(i3));
    }

    public static String codepageToEncoding(int i) throws UnsupportedEncodingException {
        return codepageToEncoding(i, false);
    }

    public static String codepageToEncoding(int i, boolean z) throws UnsupportedEncodingException {
        if (i <= 0) {
            throw new UnsupportedEncodingException("Codepage number may not be " + i);
        }
        if (i == 1200) {
            return CharEncoding.UTF_16LE;
        }
        if (i == 1201) {
            return CharEncoding.UTF_16BE;
        }
        if (i == 10081) {
            return "MacTurkish";
        }
        if (i == 10082) {
            return "MacCroatian";
        }
        switch (i) {
            case 37:
                return "cp037";
            case CP_SJIS /* 932 */:
                return "SJIS";
            case CP_GBK /* 936 */:
                return "GBK";
            case CP_MS949 /* 949 */:
                return "ms949";
            case CP_JOHAB /* 1361 */:
                return "johab";
            case CP_MAC_ROMANIA /* 10010 */:
                return "MacRomania";
            case CP_MAC_UKRAINE /* 10017 */:
                return "MacUkraine";
            case CP_MAC_THAI /* 10021 */:
                return "MacThai";
            case CP_MAC_CENTRAL_EUROPE /* 10029 */:
                return "MacCentralEurope";
            case CP_MAC_ICELAND /* 10079 */:
                return "MacIceland";
            case CP_US_ACSII /* 20127 */:
                return CharEncoding.US_ASCII;
            case CP_KOI8_R /* 20866 */:
                return "KOI8-R";
            case CP_ISO_2022_KR /* 50225 */:
                return "ISO-2022-KR";
            case CP_EUC_JP /* 51932 */:
                return "EUC-JP";
            case CP_EUC_KR /* 51949 */:
                return "EUC-KR";
            case CP_GB2312 /* 52936 */:
                return "GB2312";
            case CP_GB18030 /* 54936 */:
                return "GB18030";
            default:
                switch (i) {
                    case CP_WINDOWS_1250 /* 1250 */:
                        return z ? "Cp1250" : "windows-1250";
                    case CP_WINDOWS_1251 /* 1251 */:
                        return z ? "Cp1251" : "windows-1251";
                    case 1252:
                        break;
                    case CP_WINDOWS_1253 /* 1253 */:
                        return z ? "Cp1253" : "windows-1253";
                    case CP_WINDOWS_1254 /* 1254 */:
                        return z ? "Cp1254" : "windows-1254";
                    case CP_WINDOWS_1255 /* 1255 */:
                        return z ? "Cp1255" : "windows-1255";
                    case CP_WINDOWS_1256 /* 1256 */:
                        return z ? "Cp1255" : "windows-1256";
                    case CP_WINDOWS_1257 /* 1257 */:
                        return z ? "Cp1257" : "windows-1257";
                    case CP_WINDOWS_1258 /* 1258 */:
                        return z ? "Cp1258" : "windows-1258";
                    default:
                        switch (i) {
                            case 10000:
                                return "MacRoman";
                            case CP_MAC_JAPAN /* 10001 */:
                                return "SJIS";
                            case CP_MAC_CHINESE_TRADITIONAL /* 10002 */:
                                return "Big5";
                            case CP_MAC_KOREAN /* 10003 */:
                                return "EUC-KR";
                            case CP_MAC_ARABIC /* 10004 */:
                                return "MacArabic";
                            case CP_MAC_HEBREW /* 10005 */:
                                return "MacHebrew";
                            case CP_MAC_GREEK /* 10006 */:
                                return "MacGreek";
                            case CP_MAC_CYRILLIC /* 10007 */:
                                return "MacCyrillic";
                            case CP_MAC_CHINESE_SIMPLE /* 10008 */:
                                return "EUC_CN";
                            default:
                                switch (i) {
                                    case CP_ISO_8859_1 /* 28591 */:
                                        return z ? "ISO8859_1" : CharEncoding.ISO_8859_1;
                                    case CP_ISO_8859_2 /* 28592 */:
                                        return z ? "ISO8859_2" : "ISO-8859-2";
                                    case CP_ISO_8859_3 /* 28593 */:
                                        return z ? "ISO8859_3" : "ISO-8859-3";
                                    case CP_ISO_8859_4 /* 28594 */:
                                        return z ? "ISO8859_4" : "ISO-8859-4";
                                    case CP_ISO_8859_5 /* 28595 */:
                                        return z ? "ISO8859_5" : "ISO-8859-5";
                                    case CP_ISO_8859_6 /* 28596 */:
                                        return z ? "ISO8859_6" : "ISO-8859-6";
                                    case CP_ISO_8859_7 /* 28597 */:
                                        return z ? "ISO8859_7" : "ISO-8859-7";
                                    case CP_ISO_8859_8 /* 28598 */:
                                        return z ? "ISO8859_8" : "ISO-8859-8";
                                    case CP_ISO_8859_9 /* 28599 */:
                                        return z ? "ISO8859_9" : "ISO-8859-9";
                                    default:
                                        switch (i) {
                                            case 32768:
                                                return "MacRoman";
                                            case CP_WINDOWS_1252_BIFF23 /* 32769 */:
                                                break;
                                            default:
                                                switch (i) {
                                                    case CP_ISO_2022_JP1 /* 50220 */:
                                                    case CP_ISO_2022_JP2 /* 50221 */:
                                                    case CP_ISO_2022_JP3 /* 50222 */:
                                                        return "ISO-2022-JP";
                                                    default:
                                                        switch (i) {
                                                            case CP_US_ASCII2 /* 65000 */:
                                                                return CharEncoding.US_ASCII;
                                                            case CP_UTF8 /* 65001 */:
                                                                return "UTF-8";
                                                            default:
                                                                return "cp" + i;
                                                        }
                                                }
                                        }
                                        break;
                                }
                                break;
                        }
                        break;
                }
                return z ? "Cp1252" : "windows-1252";
        }
    }

    public static String cp950ToString(byte[] bArr, int i, int i2) {
        StringBuilder sb = new StringBuilder();
        LittleEndianCP950Reader littleEndianCP950Reader = new LittleEndianCP950Reader(bArr, i, i2);
        for (int i3 = littleEndianCP950Reader.read(); i3 != -1; i3 = littleEndianCP950Reader.read()) {
            sb.append((char) i3);
        }
        littleEndianCP950Reader.close();
        return sb.toString();
    }
}
