package org.openxmlformats.schemas.drawingml.x2006.main;

import org.apache.xmlbeans.StringEnumAbstractBase;

/* JADX INFO: loaded from: D:\APK\APKRepatcher_v1.1.2\Projects\190000000_com.syu.media.apk\dexFile\classes3.dex */
public final class STRectAlignment$Enum extends StringEnumAbstractBase {
    static final int INT_B = 8;
    static final int INT_BL = 7;
    static final int INT_BR = 9;
    static final int INT_CTR = 5;
    static final int INT_L = 4;
    static final int INT_R = 6;
    static final int INT_T = 2;
    static final int INT_TL = 1;
    static final int INT_TR = 3;
    private static final long serialVersionUID = 1;
    public static final StringEnumAbstractBase.Table table = new StringEnumAbstractBase.Table(new STRectAlignment$Enum[]{new STRectAlignment$Enum("tl", 1), new STRectAlignment$Enum("t", 2), new STRectAlignment$Enum("tr", 3), new STRectAlignment$Enum("l", 4), new STRectAlignment$Enum("ctr", 5), new STRectAlignment$Enum("r", 6), new STRectAlignment$Enum("bl", 7), new STRectAlignment$Enum("b", 8), new STRectAlignment$Enum("br", 9)});

    private STRectAlignment$Enum(String str, int i) {
        super(str, i);
    }

    public static STRectAlignment$Enum forInt(int i) {
        return (STRectAlignment$Enum) table.forInt(i);
    }

    public static STRectAlignment$Enum forString(String str) {
        return (STRectAlignment$Enum) table.forString(str);
    }

    private Object readResolve() {
        return forInt(intValue());
    }
}
