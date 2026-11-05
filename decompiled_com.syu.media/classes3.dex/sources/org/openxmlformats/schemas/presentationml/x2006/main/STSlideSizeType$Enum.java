package org.openxmlformats.schemas.presentationml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STSlideSizeType$Enum extends StringEnumAbstractBase {
    static final int INT_A_3 = 9;
    static final int INT_A_4 = 3;
    static final int INT_BANNER = 6;
    static final int INT_B_4_ISO = 10;
    static final int INT_B_4_JIS = 12;
    static final int INT_B_5_ISO = 11;
    static final int INT_B_5_JIS = 13;
    static final int INT_CUSTOM = 7;
    static final int INT_HAGAKI_CARD = 14;
    static final int INT_LEDGER = 8;
    static final int INT_LETTER = 2;
    static final int INT_OVERHEAD = 5;
    static final int INT_SCREEN_16_X_10 = 16;
    static final int INT_SCREEN_16_X_9 = 15;
    static final int INT_SCREEN_4_X_3 = 1;
    static final int INT_X_35_MM = 4;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STSlideSizeType$Enum[]{new STSlideSizeType$Enum("screen4x3", 1), new STSlideSizeType$Enum("letter", 2), new STSlideSizeType$Enum("A4", 3), new STSlideSizeType$Enum("35mm", 4), new STSlideSizeType$Enum("overhead", 5), new STSlideSizeType$Enum("banner", 6), new STSlideSizeType$Enum("custom", 7), new STSlideSizeType$Enum("ledger", 8), new STSlideSizeType$Enum("A3", 9), new STSlideSizeType$Enum("B4ISO", 10), new STSlideSizeType$Enum("B5ISO", 11), new STSlideSizeType$Enum("B4JIS", 12), new STSlideSizeType$Enum("B5JIS", 13), new STSlideSizeType$Enum("hagakiCard", 14), new STSlideSizeType$Enum("screen16x9", 15), new STSlideSizeType$Enum("screen16x10", 16)});

    private STSlideSizeType$Enum(String str, int i) {
        super(str, i);
    }

    public static STSlideSizeType$Enum forInt(int i) {
        return (STSlideSizeType$Enum) table.forInt(i);
    }

    public static STSlideSizeType$Enum forString(String str) {
        return (STSlideSizeType$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
