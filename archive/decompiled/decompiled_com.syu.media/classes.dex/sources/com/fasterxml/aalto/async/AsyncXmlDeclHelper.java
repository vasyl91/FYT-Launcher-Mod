package com.fasterxml.aalto.async;

import com.fasterxml.aalto.in.PName;
import com.fasterxml.aalto.in.PName1;
import com.fasterxml.aalto.in.PName2;
import com.fasterxml.aalto.in.PName3;
import com.fasterxml.aalto.util.XmlConsts;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes.dex */
public class AsyncXmlDeclHelper {
    private static final PName2 NAME_ENCODING;
    private static final PName3 NAME_STANDALONE;
    private static final PName2 NAME_VERSION;
    private static final PName1 NAME_XML;
    private static final int QUAD_ENCODING1;
    private static final int QUAD_ENCODING2;
    private static final int QUAD_STANDALONE1;
    private static final int QUAD_STANDALONE2;
    private static final int QUAD_STANDALONE3;
    private static final int QUAD_VERSION1;
    private static final int QUAD_VERSION2;
    private static final int QUAD_XML;

    static {
        int i = asciiQuads("xml")[0];
        QUAD_XML = i;
        int[] iArrAsciiQuads = asciiQuads(XmlConsts.XML_DECL_KW_VERSION);
        int i2 = iArrAsciiQuads[0];
        QUAD_VERSION1 = i2;
        int i3 = iArrAsciiQuads[1];
        QUAD_VERSION2 = i3;
        int[] iArrAsciiQuads2 = asciiQuads(XmlConsts.XML_DECL_KW_STANDALONE);
        int i4 = iArrAsciiQuads2[0];
        QUAD_STANDALONE1 = i4;
        int i5 = iArrAsciiQuads2[1];
        QUAD_STANDALONE2 = i5;
        int i6 = iArrAsciiQuads2[2];
        QUAD_STANDALONE3 = i6;
        int[] iArrAsciiQuads3 = asciiQuads(XmlConsts.XML_DECL_KW_ENCODING);
        int i7 = iArrAsciiQuads3[0];
        QUAD_ENCODING1 = i7;
        int i8 = iArrAsciiQuads3[1];
        QUAD_ENCODING2 = i8;
        NAME_XML = new PName1("xml", null, "xml", 0, i);
        NAME_VERSION = new PName2(XmlConsts.XML_DECL_KW_VERSION, null, XmlConsts.XML_DECL_KW_VERSION, 0, i2, i3);
        NAME_STANDALONE = new PName3(XmlConsts.XML_DECL_KW_STANDALONE, null, XmlConsts.XML_DECL_KW_STANDALONE, 0, i4, i5, i6);
        NAME_ENCODING = new PName2(XmlConsts.XML_DECL_KW_ENCODING, null, XmlConsts.XML_DECL_KW_ENCODING, 0, i7, i8);
    }

    public static PName find(int i) {
        if (i == QUAD_XML) {
            return NAME_XML;
        }
        return null;
    }

    public static PName find(int i, int i2) {
        if (i == QUAD_VERSION1) {
            if (i2 == QUAD_VERSION2) {
                return NAME_VERSION;
            }
            return null;
        }
        if (i == QUAD_ENCODING1 && i2 == QUAD_ENCODING2) {
            return NAME_ENCODING;
        }
        return null;
    }

    public static PName find(int i, int i2, int i3) {
        if (i == QUAD_STANDALONE1 && i2 == QUAD_STANDALONE2 && i3 == QUAD_STANDALONE3) {
            return NAME_STANDALONE;
        }
        return null;
    }

    static int[] asciiQuads(String str) {
        int length = str.length();
        int[] iArr = new int[(length + 3) / 4];
        int i = 0;
        while (i < length) {
            int iCharAt = str.charAt(i);
            int i2 = i + 1;
            if (i2 < length) {
                iCharAt = (iCharAt << 8) | str.charAt(i2);
                i2++;
                if (i2 < length) {
                    iCharAt = (iCharAt << 8) | str.charAt(i2);
                    i2++;
                    if (i2 < length) {
                        iCharAt = (iCharAt << 8) | str.charAt(i2);
                    }
                }
            }
            iArr[i2 / 4] = iCharAt;
            i = i2 + 1;
        }
        return iArr;
    }
}
