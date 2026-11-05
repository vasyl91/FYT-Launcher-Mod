package com.fasterxml.aalto.out;

import base.event.AutoKeyEvent;
import com.fasterxml.aalto.util.XmlCharTypes;
import com.fasterxml.aalto.util.XmlChars;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class OutputCharTypes extends XmlCharTypes {
    public static final int CT_OUTPUT_MUST_QUOTE = 4;
    public static final int CT_OUTPUT_NAME_ANY_MB2 = 6;
    public static final int CT_OUTPUT_NAME_NONFIRST_MB2 = 5;
    public static final int CT_OUTPUT_NAME_UNENCODABLE = 4;
    static final int MAIN_TABLE_SIZE = 2048;
    private static XmlCharTypes sAsciiCharTypes;
    private static XmlCharTypes sLatin1CharTypes;
    private static final XmlCharTypes sUtf8CharTypes;

    static {
        XmlCharTypes xmlCharTypes = new XmlCharTypes(2048);
        sUtf8CharTypes = xmlCharTypes;
        fillInLatin1Chars(xmlCharTypes.TEXT_CHARS, xmlCharTypes.ATTR_CHARS, xmlCharTypes.NAME_CHARS, xmlCharTypes.DTD_CHARS, xmlCharTypes.OTHER_CHARS);
        modifyForUtf8(xmlCharTypes.TEXT_CHARS);
        modifyForUtf8(xmlCharTypes.ATTR_CHARS);
        modifyForUtf8(xmlCharTypes.DTD_CHARS);
        modifyForUtf8(xmlCharTypes.OTHER_CHARS);
        modifyUtf8Names(xmlCharTypes.NAME_CHARS);
        modifyForAttrWrite(xmlCharTypes.ATTR_CHARS);
    }

    public static final XmlCharTypes getUtf8CharTypes() {
        return sUtf8CharTypes;
    }

    public static final XmlCharTypes getLatin1CharTypes() {
        if (sLatin1CharTypes == null) {
            XmlCharTypes xmlCharTypes = new XmlCharTypes(2048);
            sLatin1CharTypes = xmlCharTypes;
            fillInLatin1Chars(xmlCharTypes.TEXT_CHARS, sLatin1CharTypes.ATTR_CHARS, sLatin1CharTypes.NAME_CHARS, sLatin1CharTypes.DTD_CHARS, sLatin1CharTypes.OTHER_CHARS);
            modifyForLatin1(sLatin1CharTypes.TEXT_CHARS);
            modifyForLatin1(sLatin1CharTypes.ATTR_CHARS);
            modifyForLatin1(sLatin1CharTypes.DTD_CHARS);
            modifyForLatin1(sLatin1CharTypes.OTHER_CHARS);
            modifyForAttrWrite(sLatin1CharTypes.ATTR_CHARS);
        }
        return sLatin1CharTypes;
    }

    public static final XmlCharTypes getAsciiCharTypes() {
        if (sAsciiCharTypes == null) {
            XmlCharTypes xmlCharTypes = new XmlCharTypes(2048);
            sAsciiCharTypes = xmlCharTypes;
            fillInLatin1Chars(xmlCharTypes.TEXT_CHARS, sAsciiCharTypes.ATTR_CHARS, sAsciiCharTypes.NAME_CHARS, sAsciiCharTypes.DTD_CHARS, sAsciiCharTypes.OTHER_CHARS);
            modifyForAscii(sAsciiCharTypes.TEXT_CHARS);
            modifyForAscii(sAsciiCharTypes.ATTR_CHARS);
            modifyForAscii(sAsciiCharTypes.DTD_CHARS);
            modifyForAscii(sAsciiCharTypes.OTHER_CHARS);
            modifyAsciiNames(sAsciiCharTypes.NAME_CHARS);
            modifyForAttrWrite(sAsciiCharTypes.ATTR_CHARS);
        }
        return sAsciiCharTypes;
    }

    private static void modifyForLatin1(int[] iArr) {
        for (int i = AutoKeyEvent.KEYCODE_MEDIA_PAUSE; i <= 159; i++) {
            iArr[i] = 4;
        }
        requireQuotingAfter(iArr, 255);
    }

    private static void modifyLatin1Names(int[] iArr) {
        int length = iArr.length;
        for (int i = 256; i < length; i++) {
            int i2 = iArr[i];
            if (i2 == 2 || i2 == 3) {
                iArr[i] = 4;
            }
        }
    }

    private static void modifyForUtf8(int[] iArr) {
        int length = iArr.length;
        for (int i = 128; i < length; i++) {
            if (iArr[i] == 0) {
                iArr[i] = 5;
            }
        }
    }

    private static void modifyUtf8Names(int[] iArr) {
        int length = iArr.length;
        for (int i = 128; i < length; i++) {
            if (XmlChars.is10NameStartChar(i)) {
                iArr[i] = 6;
            } else if (XmlChars.is10NameChar(i)) {
                iArr[i] = 5;
            } else {
                iArr[i] = 0;
            }
        }
    }

    private static void modifyForAscii(int[] iArr) {
        requireQuotingAfter(iArr, AutoKeyEvent.KEYCODE_MEDIA_PAUSE);
    }

    private static void modifyAsciiNames(int[] iArr) {
        modifyLatin1Names(iArr);
        int length = iArr.length;
        for (int i = 128; i < length; i++) {
            int i2 = iArr[i];
            if (i2 == 2 || i2 == 3) {
                iArr[i] = 4;
            }
        }
    }

    private static void modifyForAttrWrite(int[] iArr) {
        iArr[9] = 4;
    }

    private static void requireQuotingAfter(int[] iArr, int i) {
        int length = iArr.length;
        for (int i2 = i + 1; i2 < length; i2++) {
            if (iArr[i2] == 0) {
                iArr[i2] = 4;
            }
        }
    }
}
