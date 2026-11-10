package org.openxmlformats.schemas.spreadsheetml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STPhoneticType$Enum extends StringEnumAbstractBase {
    static final int INT_FULLWIDTH_KATAKANA = 2;
    static final int INT_HALFWIDTH_KATAKANA = 1;
    static final int INT_HIRAGANA = 3;
    static final int INT_NO_CONVERSION = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STPhoneticType$Enum[]{new STPhoneticType$Enum("halfwidthKatakana", 1), new STPhoneticType$Enum("fullwidthKatakana", 2), new STPhoneticType$Enum("Hiragana", 3), new STPhoneticType$Enum("noConversion", 4)});

    private STPhoneticType$Enum(String str, int i) {
        super(str, i);
    }

    public static STPhoneticType$Enum forInt(int i) {
        return (STPhoneticType$Enum) table.forInt(i);
    }

    public static STPhoneticType$Enum forString(String str) {
        return (STPhoneticType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
