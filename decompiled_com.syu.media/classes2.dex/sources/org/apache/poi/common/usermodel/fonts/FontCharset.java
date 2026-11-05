package org.apache.poi.common.usermodel.fonts;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import module.canbus.FinalCanbus;
import org.apache.poi.util.POILogFactory;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes2.dex */
public enum FontCharset {
    ANSI(0, "Cp1252"),
    DEFAULT(1, "Cp1252"),
    SYMBOL(2, ""),
    MAC(77, "MacRoman"),
    SHIFTJIS(128, "Shift_JIS"),
    HANGUL(129, "cp949"),
    JOHAB(130, "x-Johab"),
    GB2312(134, "GB2312"),
    CHINESEBIG5(136, "Big5"),
    GREEK(161, "Cp1253"),
    TURKISH(162, "Cp1254"),
    VIETNAMESE(163, "Cp1258"),
    HEBREW(177, "Cp1255"),
    ARABIC(178, "Cp1256"),
    BALTIC(186, "Cp1257"),
    RUSSIAN(FinalCanbus.CAR_MSN_RZC_PSA301, "Cp1251"),
    THAI_(FinalCanbus.CAR_WC2_EU_Focus, "x-windows-874"),
    EASTEUROPE(FinalCanbus.CAR_RZC4_C5, "Cp1250"),
    OEM(255, "Cp1252");

    private static FontCharset[] _table = new FontCharset[256];
    private Charset charset;
    private int nativeId;

    static {
        for (FontCharset fontCharset : values()) {
            _table[fontCharset.getNativeId()] = fontCharset;
        }
    }

    FontCharset(int i, String str) {
        this.nativeId = i;
        if (str.length() > 0) {
            try {
                this.charset = Charset.forName(str);
                return;
            } catch (UnsupportedCharsetException unused) {
                POILogFactory.getLogger((Class<?>) FontCharset.class).log(5, "Unsupported charset: " + str);
            }
        }
        this.charset = null;
    }

    public Charset getCharset() {
        return this.charset;
    }

    public int getNativeId() {
        return this.nativeId;
    }

    public static FontCharset valueOf(int i) {
        if (i >= 0) {
            FontCharset[] fontCharsetArr = _table;
            if (i < fontCharsetArr.length) {
                return fontCharsetArr[i];
            }
        }
        return null;
    }
}
