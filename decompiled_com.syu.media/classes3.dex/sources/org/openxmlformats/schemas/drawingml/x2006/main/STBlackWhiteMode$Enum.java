package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STBlackWhiteMode$Enum extends StringEnumAbstractBase {
    static final int INT_AUTO = 2;
    static final int INT_BLACK = 9;
    static final int INT_BLACK_GRAY = 7;
    static final int INT_BLACK_WHITE = 8;
    static final int INT_CLR = 1;
    static final int INT_GRAY = 3;
    static final int INT_GRAY_WHITE = 6;
    static final int INT_HIDDEN = 11;
    static final int INT_INV_GRAY = 5;
    static final int INT_LT_GRAY = 4;
    static final int INT_WHITE = 10;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STBlackWhiteMode$Enum[]{new STBlackWhiteMode$Enum("clr", 1), new STBlackWhiteMode$Enum("auto", 2), new STBlackWhiteMode$Enum("gray", 3), new STBlackWhiteMode$Enum("ltGray", 4), new STBlackWhiteMode$Enum("invGray", 5), new STBlackWhiteMode$Enum("grayWhite", 6), new STBlackWhiteMode$Enum("blackGray", 7), new STBlackWhiteMode$Enum("blackWhite", 8), new STBlackWhiteMode$Enum("black", 9), new STBlackWhiteMode$Enum("white", 10), new STBlackWhiteMode$Enum("hidden", 11)});

    private STBlackWhiteMode$Enum(String str, int i) {
        super(str, i);
    }

    public static STBlackWhiteMode$Enum forInt(int i) {
        return (STBlackWhiteMode$Enum) table.forInt(i);
    }

    public static STBlackWhiteMode$Enum forString(String str) {
        return (STBlackWhiteMode$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
