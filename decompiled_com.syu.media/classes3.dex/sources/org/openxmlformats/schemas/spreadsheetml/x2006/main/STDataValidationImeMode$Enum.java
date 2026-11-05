package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STDataValidationImeMode$Enum extends StringEnumAbstractBase {
    static final int INT_DISABLED = 4;
    static final int INT_FULL_ALPHA = 8;
    static final int INT_FULL_HANGUL = 10;
    static final int INT_FULL_KATAKANA = 6;
    static final int INT_HALF_ALPHA = 9;
    static final int INT_HALF_HANGUL = 11;
    static final int INT_HALF_KATAKANA = 7;
    static final int INT_HIRAGANA = 5;
    static final int INT_NO_CONTROL = 1;
    static final int INT_OFF = 2;
    static final int INT_ON = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STDataValidationImeMode$Enum[]{new STDataValidationImeMode$Enum("noControl", 1), new STDataValidationImeMode$Enum("off", 2), new STDataValidationImeMode$Enum("on", 3), new STDataValidationImeMode$Enum("disabled", 4), new STDataValidationImeMode$Enum("hiragana", 5), new STDataValidationImeMode$Enum("fullKatakana", 6), new STDataValidationImeMode$Enum("halfKatakana", 7), new STDataValidationImeMode$Enum("fullAlpha", 8), new STDataValidationImeMode$Enum("halfAlpha", 9), new STDataValidationImeMode$Enum("fullHangul", 10), new STDataValidationImeMode$Enum("halfHangul", 11)});

    private STDataValidationImeMode$Enum(String str, int i) {
        super(str, i);
    }

    public static STDataValidationImeMode$Enum forInt(int i) {
        return (STDataValidationImeMode$Enum) table.forInt(i);
    }

    public static STDataValidationImeMode$Enum forString(String str) {
        return (STDataValidationImeMode$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
