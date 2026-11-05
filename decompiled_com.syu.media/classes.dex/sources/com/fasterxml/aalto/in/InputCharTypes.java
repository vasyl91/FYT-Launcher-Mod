package com.fasterxml.aalto.in;

import bsp.FinalBsp;
import com.fasterxml.aalto.util.XmlCharTypes;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public final class InputCharTypes extends XmlCharTypes {
    public static final int CT_INPUT_NAME_MB_2 = 5;
    public static final int CT_INPUT_NAME_MB_3 = 6;
    public static final int CT_INPUT_NAME_MB_4 = 7;
    public static final int CT_INPUT_NAME_MB_N = 4;
    private static XmlCharTypes sAsciiCharTypes;
    private static XmlCharTypes sLatin1CharTypes;
    private static final XmlCharTypes sUtf8CharTypes;

    static {
        XmlCharTypes xmlCharTypes = new XmlCharTypes();
        sUtf8CharTypes = xmlCharTypes;
        fillInUtf8Chars(xmlCharTypes.TEXT_CHARS, xmlCharTypes.ATTR_CHARS, xmlCharTypes.NAME_CHARS, xmlCharTypes.DTD_CHARS, xmlCharTypes.OTHER_CHARS);
    }

    public static final XmlCharTypes getUtf8CharTypes() {
        return sUtf8CharTypes;
    }

    public static final synchronized XmlCharTypes getAsciiCharTypes() {
        if (sAsciiCharTypes == null) {
            XmlCharTypes xmlCharTypes = new XmlCharTypes();
            sAsciiCharTypes = xmlCharTypes;
            fillInLatin1Chars(xmlCharTypes.TEXT_CHARS, sAsciiCharTypes.ATTR_CHARS, sAsciiCharTypes.NAME_CHARS, sAsciiCharTypes.DTD_CHARS, sAsciiCharTypes.OTHER_CHARS);
            fillInIllegalAsciiRange(sAsciiCharTypes.TEXT_CHARS);
            fillInIllegalAsciiRange(sAsciiCharTypes.ATTR_CHARS);
            fillInIllegalAsciiRange(sAsciiCharTypes.NAME_CHARS);
            fillInIllegalAsciiRange(sAsciiCharTypes.DTD_CHARS);
            fillInIllegalAsciiRange(sAsciiCharTypes.OTHER_CHARS);
        }
        return sAsciiCharTypes;
    }

    public static final synchronized XmlCharTypes getLatin1CharTypes() {
        if (sLatin1CharTypes == null) {
            XmlCharTypes xmlCharTypes = new XmlCharTypes();
            sLatin1CharTypes = xmlCharTypes;
            fillInLatin1Chars(xmlCharTypes.TEXT_CHARS, sLatin1CharTypes.ATTR_CHARS, sLatin1CharTypes.NAME_CHARS, sLatin1CharTypes.DTD_CHARS, sLatin1CharTypes.OTHER_CHARS);
        }
        return sLatin1CharTypes;
    }

    public static void fillInUtf8Chars(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        fillIn8BitTextRange(iArr);
        fillInMultiByteTextRange(iArr);
        fillIn8BitAttrRange(iArr2);
        fillInMultiByteTextRange(iArr2);
        fillIn8BitNameRange(iArr3);
        fillInMultiByteNameRange(iArr3);
        fillIn8BitDtdRange(iArr4);
        fillInMultiByteTextRange(iArr4);
        iArr5[93] = 11;
        iArr5[62] = 17;
        fillIn8BitTextRange(iArr5);
        fillInMultiByteTextRange(iArr5);
        iArr5[38] = 0;
        iArr5[60] = 0;
        iArr5[93] = 11;
        iArr5[63] = 12;
        iArr5[45] = 13;
    }

    private static void fillInMultiByteTextRange(int[] iArr) {
        int i;
        for (int i2 = 128; i2 < 256; i2++) {
            if ((i2 & FinalBsp.KEY_CODE_NEXT) == 192) {
                i = 5;
            } else if ((i2 & FinalBsp.KEY_CODE_TONE_MINUS) == 224) {
                i = 6;
            } else {
                i = (i2 & FinalBsp.KEY_AIR_CYCLE) == 240 ? 7 : 1;
            }
            iArr[i2] = i;
        }
    }

    private static void fillInMultiByteNameRange(int[] iArr) {
        int i;
        for (int i2 = 128; i2 < 256; i2++) {
            if ((i2 & FinalBsp.KEY_CODE_NEXT) == 192) {
                i = 5;
            } else if ((i2 & FinalBsp.KEY_CODE_TONE_MINUS) == 224) {
                i = 6;
            } else {
                i = (i2 & FinalBsp.KEY_AIR_CYCLE) == 240 ? 7 : 1;
            }
            iArr[i2] = i;
        }
    }

    protected static void fillInIllegalAsciiRange(int[] iArr) {
        for (int i = 128; i <= 255; i++) {
            iArr[i] = 1;
        }
    }
}
