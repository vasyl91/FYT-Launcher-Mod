package org.apache.poi.ss.usermodel;

import module.canbus.FinalCanbus;
import org.apache.poi.util.Removal;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
@Removal(version = "4.0")
@Deprecated
public enum FontCharset {
    ANSI(0),
    DEFAULT(1),
    SYMBOL(2),
    MAC(77),
    SHIFTJIS(128),
    HANGEUL(129),
    JOHAB(130),
    GB2312(134),
    CHINESEBIG5(136),
    GREEK(161),
    TURKISH(162),
    VIETNAMESE(163),
    HEBREW(177),
    ARABIC(178),
    BALTIC(186),
    RUSSIAN(FinalCanbus.CAR_MSN_RZC_PSA301),
    THAI(FinalCanbus.CAR_WC2_EU_Focus),
    EASTEUROPE(FinalCanbus.CAR_RZC4_C5),
    OEM(255);

    private static FontCharset[] _table = new FontCharset[256];
    private int charset;

    static {
        for (FontCharset fontCharset : values()) {
            _table[fontCharset.getValue()] = fontCharset;
        }
    }

    FontCharset(int i) {
        this.charset = i;
    }

    public int getValue() {
        return this.charset;
    }

    public static FontCharset valueOf(int i) {
        FontCharset[] fontCharsetArr = _table;
        if (i >= fontCharsetArr.length) {
            return null;
        }
        return fontCharsetArr[i];
    }
}
