package com.fasterxml.aalto.util;

import com.syu.media.ListCondition01;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class XmlCharTypes {
    public static final int CT_AMP = 10;
    public static final int CT_ATTR_QUOTE = 14;
    public static final int CT_DTD_GT = 10;
    public static final int CT_DTD_LT = 9;
    public static final int CT_DTD_PERCENT = 12;
    public static final int CT_DTD_QUOTE = 8;
    public static final int CT_DTD_RBRACKET = 11;
    public static final int CT_GT = 17;
    public static final int CT_HYPHEN = 13;
    public static final int CT_INVALID = 1;
    public static final int CT_LBRACKET = 16;
    public static final int CT_LT = 9;
    public static final int CT_MULTIBYTE_2 = 5;
    public static final int CT_MULTIBYTE_3 = 6;
    public static final int CT_MULTIBYTE_4 = 7;
    public static final int CT_MULTIBYTE_N = 4;
    public static final int CT_NAME_ANY = 3;
    public static final int CT_NAME_COLON = 1;
    public static final int CT_NAME_NONE = 0;
    public static final int CT_NAME_NONFIRST = 2;
    public static final int CT_OK = 0;
    public static final int CT_QMARK = 12;
    public static final int CT_RBRACKET = 11;
    public static final int CT_WS_CR = 2;
    public static final int CT_WS_LF = 3;
    public static final int CT_WS_TAB = 8;
    public static final int[] PUBID_CHARS = new int[256];
    public static final int PUBID_INVALID = 0;
    public static final int PUBID_OK = 1;
    public final int[] ATTR_CHARS;
    public final int[] DTD_CHARS;
    public final int[] NAME_CHARS;
    public final int[] OTHER_CHARS;
    public final int[] TEXT_CHARS;

    static {
        for (int i = 0; i <= 25; i++) {
            int[] iArr = PUBID_CHARS;
            iArr[i + 65] = 1;
            iArr[i + 97] = 1;
        }
        for (int i2 = 48; i2 <= 57; i2++) {
            PUBID_CHARS[i2] = 1;
        }
        int[] iArr2 = PUBID_CHARS;
        iArr2[10] = 1;
        iArr2[13] = 1;
        iArr2[32] = 1;
        iArr2[45] = 1;
        iArr2[39] = 1;
        iArr2[40] = 1;
        iArr2[41] = 1;
        iArr2[43] = 1;
        iArr2[44] = 1;
        iArr2[46] = 1;
        iArr2[47] = 1;
        iArr2[58] = 1;
        iArr2[61] = 1;
        iArr2[63] = 1;
        iArr2[59] = 1;
        iArr2[33] = 1;
        iArr2[42] = 1;
        iArr2[35] = 1;
        iArr2[64] = 1;
        iArr2[36] = 1;
        iArr2[95] = 1;
        iArr2[37] = 1;
    }

    public XmlCharTypes() {
        this(256);
    }

    public XmlCharTypes(int i) {
        this.TEXT_CHARS = new int[i];
        this.ATTR_CHARS = new int[i];
        this.NAME_CHARS = new int[i];
        this.DTD_CHARS = new int[i];
        this.OTHER_CHARS = new int[i];
    }

    public static void fillInLatin1Chars(int[] iArr, int[] iArr2, int[] iArr3, int[] iArr4, int[] iArr5) {
        fillIn8BitTextRange(iArr);
        fillIn8BitAttrRange(iArr2);
        fillIn8BitNameRange(iArr3);
        for (int i = ListCondition01.USB; i <= 255; i++) {
            if (i != 215 && i != 247) {
                iArr3[i] = 3;
            }
        }
        iArr3[183] = 2;
        fillIn8BitDtdRange(iArr4);
        fillIn8BitTextRange(iArr5);
        iArr5[38] = 0;
        iArr5[60] = 0;
        iArr5[93] = 11;
        iArr5[63] = 12;
        iArr5[45] = 13;
    }

    private static void fillInCommonTextRange(int[] iArr) {
        for (int i = 0; i < 32; i++) {
            iArr[i] = 1;
        }
        iArr[13] = 2;
        iArr[10] = 3;
        iArr[9] = 0;
    }

    public static void fillIn8BitNameRange(int[] iArr) {
        for (int i = 97; i <= 122; i++) {
            iArr[i] = 3;
        }
        for (int i2 = 65; i2 <= 90; i2++) {
            iArr[i2] = 3;
        }
        iArr[95] = 3;
        iArr[58] = 1;
        iArr[45] = 2;
        iArr[46] = 2;
        for (int i3 = 48; i3 <= 57; i3++) {
            iArr[i3] = 2;
        }
    }

    protected static void fillIn8BitTextRange(int[] iArr) {
        fillInCommonTextRange(iArr);
        iArr[60] = 9;
        iArr[38] = 10;
        iArr[93] = 11;
    }

    protected static void fillIn8BitAttrRange(int[] iArr) {
        fillInCommonTextRange(iArr);
        iArr[9] = 8;
        iArr[60] = 9;
        iArr[38] = 10;
        iArr[39] = 14;
        iArr[34] = 14;
    }

    protected static void fillIn8BitDtdRange(int[] iArr) {
        fillInCommonTextRange(iArr);
        iArr[39] = 8;
        iArr[34] = 8;
        iArr[60] = 9;
        iArr[62] = 10;
        iArr[93] = 11;
        iArr[37] = 12;
    }
}
